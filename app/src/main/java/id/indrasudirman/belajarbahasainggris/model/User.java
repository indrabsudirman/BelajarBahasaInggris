package id.indrasudirman.belajarbahasainggris.model;

public class User {

    private int id;
    private String name;
    private String email;
    private String salt;
    private String password;
    private String imageName;
    private int score;
    private String scoreDB;

    //Default constructor
    public User() {
    }

    public String getScoreDB() {
        return scoreDB;
    }

    public void setScoreDB(String scoreDB) {
        this.scoreDB = scoreDB;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
