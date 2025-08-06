package utils;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHash {

    public static String GetHash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean VerifyHash(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }
}
