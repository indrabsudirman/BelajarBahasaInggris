package id.indrasudirman.belajarbahasainggris.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import id.indrasudirman.belajarbahasainggris.model.User;

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String TAG = SQLiteHelper.class.getSimpleName();

    //Database Version
    private static final int DATABASE_VERSION = 1;

    //Database Name
    private static final String DATABASE_NAME = "BelajarBahasaInggris.db";

    //User Table Name
    private static final String TABLE_USER = "Users";

    //User Table Columns Name
    private static final String COLUMN_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_MAIL = "user_email";
    private static final String COLUMN_PASSWORD_SALT = "salt";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_PHOTO_PATH = "photo_path";
    private static final String COLUMN_SCORE = "score";


    //Create Table SQL Query
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "(" + COLUMN_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME
            + " TEXT," + COLUMN_USER_MAIL + " TEXT," + COLUMN_PASSWORD_SALT
            + " TEXT," + COLUMN_PASSWORD + " TEXT, " + COLUMN_PHOTO_PATH +" TEXT, "+ COLUMN_SCORE + " TEXT" + ")" ;

    //Drop Table SQL Query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    public SQLiteHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        //Drop User Table if exist
        sqLiteDatabase.execSQL(DROP_USER_TABLE);
        //Create New Table
        onCreate(sqLiteDatabase);

    }

    /**
     * This method is to create user record
     */
    public void addUser(User users) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_USER_NAME, users.getName());
        contentValues.put(COLUMN_USER_MAIL, users.getEmail());
        contentValues.put(COLUMN_PASSWORD_SALT, users.getSalt());
        contentValues.put(COLUMN_PASSWORD, users.getPassword());
        contentValues.put(COLUMN_SCORE, "0");

        //Inserting row
        sqLiteDatabase.insert(TABLE_USER, null, contentValues);
        sqLiteDatabase.close();
    }

    /**
     * This method is to fetch all user and return the list of user records
     * @return list
     */
    public List<User> getAllUser() {
        //array of columns to fetch
        String [] columns = {
                COLUMN_ID,
                COLUMN_USER_NAME,
                COLUMN_USER_MAIL,
                COLUMN_PASSWORD_SALT,
                COLUMN_PASSWORD,
        };
        //Sorting orders
        String sortOrder = COLUMN_USER_NAME + " ASC";
        List<User> usersList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        //Query the user table
        /**
         * Here query function is used to fetch records from user this function works like we use sql query
         * SQL query equivalent to this query function is
         * SELECT user_id, user_name, user_email, salt, password FROM user ORDER BY user_name;
         */
        Cursor cursor = sqLiteDatabase.query(TABLE_USER, //Table to query
                columns, //columns to return
                null, //columns for the WHERE clause
                null, //The values for the WHERE clause
                null, //group the row
                null, //filter by row groups
                sortOrder); //The sort order

        //Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User users = new User();
                users.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_ID))));
                users.setName(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)));
                users.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_USER_MAIL)));
                users.setSalt(cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD_SALT)));
                users.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD)));
                //Adding user record to list
                usersList.add(users);
            } while (cursor.moveToNext());
        }
        cursor.close();
        sqLiteDatabase.close();
        //return user list
        return usersList;
    }

    /**
     * This method to update user record
     *
     * @ param user
     */
    public void updateUser (String userEmailOld, String userName, String userEmailNew, String salt, String password) {
        int count = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, userName);
        values.put(COLUMN_USER_MAIL, userEmailNew);
        values.put(COLUMN_PASSWORD_SALT, salt);
        values.put(COLUMN_PASSWORD, password);
        // update Row
        count = db.update(TABLE_USER,values,COLUMN_USER_MAIL + "= '" + userEmailOld + "'",null);
        if (count > 0) {
            Log.d(TAG, "Image database updated");
            Log.d(TAG, "Count is " + count);
        }

        db.close(); // Closing database connection
    }

    /**
     * This method to update user photo record
     *
     * @ param userEmail, photoPath
     */
    public void updateUserImage(String email, String photoPath) {

        int count = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_PHOTO_PATH, photoPath);
        // update Row
        count = db.update(TABLE_USER,values,COLUMN_USER_MAIL + "= '" + email + "'",null);
        if (count > 0) {
            Log.d(TAG, "Image database updated");
            Log.d(TAG, "Count is " + count);
        }

        db.close(); // Closing database connection

    }

    /**
     * This method to update user score record
     *
     * @ param userEmail, userScore
     */

    public void updateUserScore (String email, String userScore) {

        int count = 0;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SCORE, userScore);
        //update row
        count = sqLiteDatabase.update(TABLE_USER, values, COLUMN_USER_MAIL + "= '" + email + "'", null);
        if (count > 0) {
            Log.d(TAG, "Score database updated");
            Log.d(TAG, "Count is " + count);
        }
    }

    public String getUserName (String email) {
        String userName = null;

        String [] column = {COLUMN_USER_NAME};
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        //Selection criteria
        String selection = COLUMN_USER_MAIL + " = ?";

        //Selection argument
        String [] selectionArgs = {email};

        /**
         * Query users table with condition
         * This query function is used to fetch records from user table this function work like we use sql query
         * SQL Query equivalent to this query function is
         * SELECT user_name FROM Users WHERE user_email = 'indrabsudirman@gmail.com'
         */

        Cursor cursor = sqLiteDatabase.query(TABLE_USER, //Table User
                column, //Column to return
                selection, //Select base on
                selectionArgs, //Select argument
                null, // The value for the WHERE clause
                null, //group the row
                null //filter by row groups
                );
        if (cursor.moveToFirst()) {
            userName = cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME));
        }

        return userName;
    }

    public String getUserScore (String email) {
        String userScore = null;

        String [] column = {COLUMN_SCORE};
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        //Selection criteria
        String selection = COLUMN_USER_MAIL + " = ?";

        //Selection argument
        String [] selectionArgs = {email};

        /**
         * Query users table with condition
         * This query function is used to fetch records from user table this function work like we use sql query
         * SQL Query equivalent to this query function is
         * SELECT user_score FROM Users WHERE user_email = 'indrabsudirman@gmail.com'
         */

        Cursor cursor = sqLiteDatabase.query(TABLE_USER, //Table User
                column, //Column to return
                selection, //Select base on
                selectionArgs, //Select argument
                null, // The value for the WHERE clause
                null, //group the row
                null //filter by row groups
        );
        if (cursor.moveToFirst()) {
            userScore = cursor.getString(cursor.getColumnIndex(COLUMN_SCORE));
        }

        return userScore;
    }

    public String imagePathAlready (String email) {
        String imagePath = null;

        String [] column = {COLUMN_PHOTO_PATH};
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        //Selection criteria
        String selection = COLUMN_USER_MAIL + " = ?";

        //Selection argument
        String [] selectionArgs = {email};

        /**
         * Query users table with condition
         * This query function is used to fetch records from user table this function work like we use sql query
         * SQL query equivalent to this query function is
         * SELECT photo_path FROM Users WHERE user_email = 'indrabsudirman@gmail.com';
         */

        Cursor cursor = sqLiteDatabase.query(TABLE_USER, //Table name
                column, //Column to return
                selection, //Select base on
                selectionArgs, //Select argument
                null, //The value for the WHERE clause
                null, //group the row
                null //filter by row groups
                );
        if (cursor.moveToFirst()) {
            User user = new User();
            imagePath = cursor.getString(cursor.getColumnIndex(COLUMN_PHOTO_PATH));
            user.setImageName(imagePath);
            Log.d(TAG, "ImagePath ada di database, user.getImageName() adalah : " + user.getImageName());


        }
        return imagePath;

    }

    /**
     * This method is to delete user record
     * @ param user
     */
    public void deleteUser (User users) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        //Delete user record by id
        sqLiteDatabase.delete(TABLE_USER, COLUMN_ID + " = ?",
                new String[] {String.valueOf(users.getId())});
        sqLiteDatabase.close();
    }

    /**
     * This method to check user exist or not
     * @param email
     * @return true/false
     */
    public boolean checkUser (String email) {
        //array of columns to fetch
        String[] columns = {COLUMN_ID};
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        //Selection criteria
        String selection = COLUMN_USER_MAIL + " = ?";

        //Selection argument
        String [] selectionArgs = {email};

        //Query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'indrabsudirman@gmail.com';
         */
        Cursor cursor = sqLiteDatabase.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        sqLiteDatabase.close();

        return cursorCount > 0;
    }

    /**
     * This method to check user exist or not
     *
     * @ param email
     * @ param password
     * @ param true/false
     */

    public boolean checkUser (String email, String password) {
        //Array of columns to fetch
        String [] columns = {COLUMN_ID};

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        //Selection criteria
        String selection = COLUMN_USER_MAIL + " = ?" + " AND " + COLUMN_PASSWORD_SALT + " = ?";
        //Selection arguments
        String [] selectionArgs = {email, password};

        //Query user table with conditions
        /**
         * here query function is used to fetch records from user table this function works like we use sql query
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'indrabsudirman@gmail.com' AND user_password = 'query';
         */
        Cursor cursor = sqLiteDatabase.query(TABLE_USER, //Table to query
                columns, //columns to return
                selection, //columns for return
                selectionArgs, //column for the WHERE clause
                null, //The values for the WHERE clause
                null, //group the rows
                null); //filter by row groups
        int cursorCount = cursor.getCount(); //The sort order

        cursor.close();
        sqLiteDatabase.close();
        if (cursorCount > 0) {
            return true;
        }
        return false;

    }

    public String getSalt(String email) {
        String salt = null;

        String[] columns = {COLUMN_PASSWORD_SALT};
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        //Selection criteria
        String selection = COLUMN_USER_MAIL + " = ?";

        //Selection argument
        String[] selectionArgs = {email};

        //Query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'indrabsudirman@gmail.com';
         */
        Cursor cursor = sqLiteDatabase.query(TABLE_USER, //Table to query
                columns, // column to return
                selection, //Select base on
                selectionArgs, //select argument
                null, //The values for the WHERE clause
                null, //group the rows
                null); //filter by row groups

            if (cursor.moveToFirst()) {
                    salt = cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD_SALT));
                    System.out.println("Salt in cursor is in getSalt " + salt);

            }
            return salt;

    }

    public String getPwdSalt(String email) {
        String salt1 = null;

        String[] columns = {COLUMN_PASSWORD};
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        //Selection criteria
        String selection = COLUMN_USER_MAIL + " = ?";

        //Selection argument
        String[] selectionArgs = {email};

        //Query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'indrabsudirman@gmail.com';
         */
        Cursor cursor = sqLiteDatabase.query(TABLE_USER, //Table to query
                columns, // column to return
                selection, //Select base on
                selectionArgs, //select argument
                null, //The values for the WHERE clause
                null, //group the rows
                null); //filter by row groups

        if (cursor.moveToFirst()) {
            salt1 = cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD));
            System.out.println("Pwd Salt in cursor is in getPwdSalt " + salt1);

        }
        return salt1;

    }


}
