package org.openhab.binding.nefit.internal.transport;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class NefitCrypto {

    private final static String MAGIC = "58f18d70f667c9c79ef7de435bf0f9b1553bbb6e61816212ab80e5b0d351fbb1";
    private static final String ENCRYPTION_TRANSFORMATION = "AES/ECB/NoPadding";

    public static byte[] generateKey(String id, String pwd)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] md1 = md5(Utils.addAll(id.getBytes("UTF8"), Utils.hexStringToByteArray(MAGIC)));
        byte[] md2 = md5(Utils.addAll(Utils.hexStringToByteArray(MAGIC), pwd.getBytes("UTF8")));
        return Utils.addAll(md1, md2);
    }

    public static byte[] md5(byte[] source) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("MD5");
        return m.digest(source);
    }

    public static String encrypt(byte[] key, String chipherText)
            throws UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException,
            NoSuchAlgorithmException, NoSuchPaddingException {
        byte[] chipherTextPadded = new byte[chipherText.length() + (16 - chipherText.length() % 16)];
        System.arraycopy(chipherText.getBytes(), 0, chipherTextPadded, 0, chipherText.length());
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance(ENCRYPTION_TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        return Base64.getEncoder().encodeToString(cipher.doFinal(chipherTextPadded));
    }

    public static String decrypt(byte[] key, String cipher64)
            throws UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException,
            NoSuchAlgorithmException, NoSuchPaddingException {
        byte[] chipherText = Base64.getDecoder().decode(cipher64);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance(ENCRYPTION_TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        if (chipherText.length % 8 != 0) {
            byte[] chipherTextPadded = new byte[(chipherText.length + (8 - (chipherText.length % 8)))];
            System.arraycopy(chipherText, 0, chipherTextPadded, 0, chipherText.length);
            chipherText = chipherTextPadded;
        }
        return new String(cipher.doFinal(chipherText), "UTF-8").trim();
    }

    public static String decrypt(String id, String pwd, String cipherText) throws Exception {
        return decrypt(generateKey(pwd, pwd), cipherText);
    }

}
