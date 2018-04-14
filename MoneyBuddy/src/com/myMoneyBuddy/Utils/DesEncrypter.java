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
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.apache.log4j.Logger;
import com.myMoneyBuddy.ExceptionClasses.MoneyBuddyException;

public class DesEncrypter {

	Logger logger = Logger.getLogger(DesEncrypter.class);
	
	Cipher ecipher;
    Cipher dcipher;

    byte[] salt =  {
            (byte)0xA9, (byte)0x9B, (byte)0xC8, (byte)0x32,
            (byte)0x56, (byte)0x35, (byte)0xE3, (byte)0x03
        };

    int iterationCount = 3;

    public DesEncrypter() throws MoneyBuddyException {

    	logger.debug("DesEncrypter class - DesEncrypter method - start");
    	
        try{

        	String passPhrase = "123456";
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
			throw new MoneyBuddyException(e.getMessage(),e);
        } 
        catch (Exception e ) {
        	logger.error("DesEncrypter class - DesEncrypter method - caught Exception");
			e.printStackTrace();
			throw new MoneyBuddyException(e.getMessage(),e);
		}
        
    }

    public String encrypt(String str) throws MoneyBuddyException {

    	logger.debug("DesEncrypter class - encrypt method - start");
    	
        try{

            byte[] utf8 = str.getBytes("UTF8");
            byte[] enc  = ecipher.doFinal(utf8);

            logger.debug("DesEncrypter class - encrypt method - end"); 
            
            return new sun.misc.BASE64Encoder().encode(enc);

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

            byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);
            byte[] utf8 = dcipher.doFinal(dec);

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

    
}
