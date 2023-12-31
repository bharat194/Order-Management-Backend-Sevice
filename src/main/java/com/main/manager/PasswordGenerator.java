package com.main.manager;

import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Service;

@Service
public class PasswordGenerator {
	
	private static final String ALGO = "AES";
	private static final byte[] keyValue = new byte[] {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P',};
	
	public String encrypt(String pwd) {
	    String encodedPwd = "";
	    try {
	        Key key = generateKey();
	        Cipher c = Cipher.getInstance(ALGO);
	        c.init(Cipher.ENCRYPT_MODE, key);
	        byte[] encVal = c.doFinal(pwd.getBytes());
	        encodedPwd = Base64.getEncoder().encodeToString(encVal);

	    } catch (Exception e) {

	        e.printStackTrace();
	    }
	    return encodedPwd;

	}
	public  String decrypt(String encryptedData) {
	    String decodedPWD = "";
	    try {
	        Key key = generateKey();
	        Cipher c = Cipher.getInstance(ALGO);
	        c.init(Cipher.DECRYPT_MODE, key);
	        byte[] decordedValue = Base64.getDecoder().decode(encryptedData);
	        byte[] decValue = c.doFinal(decordedValue);
	        decodedPWD = new String(decValue);

	    } catch (Exception e) {

	    }
	    return decodedPWD;
	}
	
	private Key generateKey() {
	    SecretKeySpec key = new SecretKeySpec(keyValue, ALGO);
	    return key;
	}

}
