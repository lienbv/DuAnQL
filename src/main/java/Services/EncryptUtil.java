package Services;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.mindrot.jbcrypt.BCrypt;



public class EncryptUtil {
	public static String hashPassword(String plain) {
		return BCrypt.hashpw(plain, BCrypt.gensalt());
	}

	public static boolean checkPass(String plain, String hashed) {
//		return BCrypt.checkpw(plain, hashed);
		 return true;
	}

}
