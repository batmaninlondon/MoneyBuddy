/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.Utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.regex.Pattern;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;

//import java.util.Base64; 

public class DesEncrypter  {

	Logger logger = LogManager.getLogger(DesEncrypter.class);
	
	Cipher ecipher;
    Cipher dcipher;

    byte[] salt =  {
            (byte)0xA9, (byte)0x9B, (byte)0xC8, (byte)0x32,
            (byte)0x56, (byte)0x35, (byte)0xE3, (byte)0x03
        };

    int iterationCount = 19;
    
    public static final DesEncrypter MONEYBUDDY = new DesEncrypter();

    public DesEncrypter() {

    	logger.debug("DesEncrypter class - DesEncrypter method - start");
    	
        try{

        	String passPhrase = "MoneyBuddy";
            KeySpec keySpec = new PBEKeySpec(passPhrase.toCharArray(), salt, iterationCount);
            SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);

            ecipher = Cipher.getInstance(key.getAlgorithm());
            dcipher = Cipher.getInstance(key.getAlgorithm());

            AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);

            ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
            dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);

            logger.debug("DesEncrypter class - DesEncrypter method - end ");
            
        } 
        catch (InvalidAlgorithmParameterException|InvalidKeySpecException|NoSuchPaddingException|NoSuchAlgorithmException|InvalidKeyException e)
        {
        	logger.error("DesEncrypter class - DesEncrypter method - caught some Exception");
        	e.printStackTrace();
			try {
				throw new MoneyBuddyException(e.getMessage(),e);
			} catch (MoneyBuddyException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        } 
        catch (Exception e ) {
        	logger.error("DesEncrypter class - DesEncrypter method - caught Exception");
			e.printStackTrace();
			try {
				throw new MoneyBuddyException(e.getMessage(),e);
			} catch (MoneyBuddyException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
        
    }

    public String encrypt(String str) throws MoneyBuddyException {

    	logger.debug("DesEncrypter class - encrypt method - start");
    	
        try{

            byte[] utf8 = str.getBytes("UTF8");
            byte[] enc  = ecipher.doFinal(utf8);

            logger.debug("DesEncrypter class - encrypt method - end"); 
            
            String encryptStr = new sun.misc.BASE64Encoder().encode(enc);
            /*Base64.Encoder encoder = Base64.getEncoder();  
            String encryptStr =  encoder.encode(enc).toString();  */
            
            System.out.println("str before replacement in encrypt : "+encryptStr);
            String newStr = encryptStr.replaceAll(Pattern.quote("+"), "123456789");
            System.out.println("str before replacement in encrypt : "+newStr);
            		
            return newStr;

        } 
        catch (BadPaddingException|IllegalBlockSizeException|UnsupportedEncodingException e)
        {
        	logger.error("DesEncrypter class - encrypt method - Caught some Exception");
        	e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
        } 
        catch (Exception e ) {
        	logger.error("DesEncrypter class - encrypt method - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}

    }

    public String decrypt(String str) throws MoneyBuddyException {

    	logger.debug("DesEncrypter class - decrypt method - start");
    	
        try{
        	System.out.println("str before replacement in decrypt : "+str);
        	str = str.replaceAll("123456789", "+");	
        	System.out.println("str after replacement in decrypt : "+str);
            byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);
        	/*Base64.Decoder decoder = Base64.getDecoder();
        	byte[] dec  =  decoder.decode(str) ;*/
        	
            System.out.println("dec : "+dec.toString());
            byte[] utf8 = dcipher.doFinal(dec);
            System.out.println("utf8 : "+utf8.toString());

            logger.debug("DesEncrypter class - decrypt method - end");
            
            return new String(utf8,"UTF8");

        } 
        catch (BadPaddingException|IllegalBlockSizeException|UnsupportedEncodingException e)
        {
        	logger.error("DesEncrypter class - decrypt method - Caught some Exception");
        	e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
        } 

        catch (IOException e)
        {
        	logger.error("DesEncrypter class - decrypt method - Caught IOException");
        	e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
        }
        catch (Exception e ) {
        	logger.error("DesEncrypter class - decrypt method - Caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
    }

    public static void main(String args[]){
        try {
        	String encrypted = DesEncrypter.MONEYBUDDY.encrypt("293abcd@1234");
	        System.out.println("encrypted :"+encrypted);
	        
	        String decrypted = DesEncrypter.MONEYBUDDY.decrypt("7wcfs2QrUF406fePJcwWEQ==");
	        System.out.println("decrypted :"+decrypted+":");
	       // int len = "233".length();
	        
	       // String password = decrypted.substring(len);
	        
	       // System.out.println("password : "+password);
        
        }
        catch (Exception e ) {
        	
			e.printStackTrace();
		}
      }
    
}
