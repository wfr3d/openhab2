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

    public static String decrypt(byte[] key, String cipherText)
            throws UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException,
            NoSuchAlgorithmException, NoSuchPaddingException {
        byte[] encrypted = Base64.getDecoder().decode(cipherText);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance(ENCRYPTION_TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        System.arraycopy(encrypted, 0, new byte[(encrypted.length + (8 - (encrypted.length % 8)))], 0,
                encrypted.length);
        return new String(cipher.doFinal(encrypted), "UTF-8").trim();

    }

    public static String decrypt(String id, String pwd, String cipherText) throws Exception {
        return decrypt(generateKey(pwd, pwd), cipherText);
    }

}
