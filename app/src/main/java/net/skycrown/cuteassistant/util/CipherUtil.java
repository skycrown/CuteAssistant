package net.skycrown.cuteassistant.util;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * Created by skycrown on 2018/6/16.
 */

public class CipherUtil {

    public static String MD5(String source) {
        byte[] hash = null;
        try {
            hash = MessageDigest.getInstance("MD5").digest(source.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return byteArrayToHexString(hash);
    }

    public static Key getDESKey(byte[] key) throws Exception {
        DESKeySpec desSpec = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        return keyFactory.generateSecret(desSpec);
    }

    public static String decrypt(String data, Key key, String algorithm) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, key);
        String result = new String(cipher.doFinal(hexStringToByteArray(data)), "utf8");
        return result;
    }

    public static String encrypt(String data, Key key, String algorithm) throws Exception{
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return byteArrayToHexString(cipher.doFinal(data.getBytes("utf8")));
    }

    public static String byteArrayToHexString(byte[] data){
        StringBuilder sb = new StringBuilder(data.length * 2);
        for (byte b : data) {
            if ((b & 0xff) < 0x10) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(b & 0xff));
        }
        return sb.toString().toUpperCase(Locale.getDefault());
    }

    public static byte[] hexStringToByteArray(String str) {
        int len = str.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return data;
    }
}
