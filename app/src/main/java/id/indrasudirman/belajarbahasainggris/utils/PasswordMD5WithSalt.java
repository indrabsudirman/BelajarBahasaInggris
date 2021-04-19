package id.indrasudirman.belajarbahasainggris.utils;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.logging.Logger;

import id.indrasudirman.belajarbahasainggris.AccountActivity;

public class PasswordMD5WithSalt {

    private static final String TAG = PasswordMD5WithSalt.class.getSimpleName();

    public static String digest (char [] in, byte [] salt) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");

        ArrayList<Byte> list = new ArrayList<>();
        for (int i = 0; i < in.length; i++) {
            byte b = (byte) in[i];
            list.add(b);
        }
        byte [] inputInByte = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            inputInByte[i] = list.get(i);
        }
        messageDigest.update(salt);
        messageDigest.update(inputInByte);

        byte byteData[] = messageDigest.digest();

        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < byteData.length; i++) {
            String hex = Integer.toHexString(0xff & byteData[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static byte [] getSalt() throws NoSuchAlgorithmException {
        //Always use a Secure Random generator
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        //Create array for salt
        byte [] salt = new byte[16];
        //Get a random salt
        secureRandom.nextBytes(salt);
        //Return salt
        return salt;
    }

    protected final static char [] hexArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static String byteArrayToHexString (byte [] bytes) {
        char [] hexChars = new char[bytes.length * 2];
        int v;

        for (int i = 0; i < bytes.length; i++) {
            v = bytes[i] & 0xff;
            hexChars [i * 2] = hexArray [v >>> 4];
            hexChars [i * 2 + 1] = hexArray [v & 0x0f];
        }
        return new String(hexChars);
    }

    public static byte [] hexStringToByteArray (String string) {
        if (string != null) {
            int len = string.length();
            byte [] data = new byte[len / 2];

            for (int i = 0; i < len; i += 2) {
                data [i/2] = (byte) ((Character.digit(string.charAt(i), 16) << 4) + Character.digit(string.charAt(i + 1), 16));
            }
            return data;

        } else {
            return null;
        }
    }

    public String passKey (String key) {
        String digest = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte [] hash = messageDigest.digest(key.getBytes("UTF-8"));

            //converting byte array to Hexadecimal String
            StringBuilder stringBuilder = new StringBuilder(2 * hash.length);
            for (byte b : hash) {
                stringBuilder.append(String.format("%02x", b&0xff));
            }
            digest = stringBuilder.toString();
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, "UnsupportedEncodingException");
        } catch (NoSuchAlgorithmException e) {
            Log.e(TAG, "NoSuchAlgorithmException");
        }
        return digest;
    }

}
