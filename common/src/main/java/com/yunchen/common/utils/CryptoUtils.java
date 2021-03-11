package com.yunchen.common.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class CryptoUtils {
    private static final int ivLength = 16;

    public static byte[] aes256Encrypt(byte[] data, String key) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CFB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, getAES256Key(key));

            byte[] iv = cipher.getParameters().getParameterSpec(IvParameterSpec.class).getIV();
            byte[] ciphers = cipher.doFinal(data);
            byte[] result = new byte[ciphers.length + ivLength];

            System.arraycopy(ciphers, 0, result, 0, ciphers.length);
            System.arraycopy(iv, 0, result, ciphers.length, ivLength);

            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] aes256Decrypt(byte[] data, String key) {
        if (data.length <= ivLength) {
            throw new RuntimeException("invalid encrypted data");
        }

        try {
            int encLength = data.length - ivLength;
            byte[] iv = new byte[ivLength];
            byte[] encrypt = new byte[encLength];

            System.arraycopy(data, 0, encrypt, 0, encLength);
            System.arraycopy(data, encLength, iv, 0, ivLength);

            Cipher cipher = Cipher.getInstance("AES/CFB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, getAES256Key(key), new IvParameterSpec(iv));

            return cipher.doFinal(encrypt);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Key getAES256Key(String keySeed) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return getSecretKey(keySeed, "AES", 256);
    }

    private static Key getSecretKey(String seed, String alg, int keyLength) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        PBEKeySpec spec = new PBEKeySpec(seed.toCharArray(), seed.getBytes(), 8, keyLength);

        return new SecretKeySpec(factory.generateSecret(spec).getEncoded(), alg);
    }
}
