package com.yunchen.common.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.zip.CRC32;

public class HashUtils {
    public final static String MD5 = "MD5";
    public final static String SHA1 = "SHA1";
    private final static Integer BUFFER_LENGTH = 8192;
    private final static char[] hexChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String md5(byte[] input) {
        return bytes2hex(digest(MD5, input));
    }

    public static String md5(InputStream is) {
        return bytes2hex(digest(MD5, is));
    }

    public static String md5(String s) {
        return md5(s.getBytes(StandardCharsets.UTF_8));
    }

    public static String sha1(byte[] input) {
        return bytes2hex(digest(SHA1, input));
    }

    public static String sha1(InputStream is) {
        return bytes2hex(digest(SHA1, is));
    }

    public static String sha1(String s) {
        return sha1(s.getBytes(StandardCharsets.UTF_8));
    }

    public static String crc32(byte[] input) {
        return bytes2hex(crc32(input, 0, input.length));
    }

    public static byte[] crc32(byte[] input, int off, int len) {
        CRC32 crc32 = new CRC32();
        crc32.update(input, off, len);

        ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES);
        buffer.putInt((int) crc32.getValue());

        return buffer.array();
    }

    public static String crc32(String s) {
        return crc32(s.getBytes(StandardCharsets.UTF_8));
    }

    public static String checksum(File file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            return checksum(fis);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String checksum(InputStream is) {
        int length;
        int blockSize = 1024;
        byte[] buffer = new byte[blockSize];

        try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
            MessageDigest md = MessageDigest.getInstance(SHA1);

            while ((length = is.read(buffer, 0, blockSize)) != -1) {
                os.write(digest(MD5, buffer, 0, length));
                os.write(crc32(buffer, 0, length));

                md.update(os.toByteArray());
                os.reset();
            }

            return bytes2hex(md.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] digest(String algorithm, byte[] input) {
        return digest(algorithm, input, 0, input.length);
    }

    public static byte[] digest(String algorithm, byte[] input, int offset, int len) {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(input, offset, len);

            return md.digest();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] digest(String algorithm, InputStream is) {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            int length;
            byte[] buffer = new byte[BUFFER_LENGTH];

            while ((length = is.read(buffer, 0, BUFFER_LENGTH)) != -1) {
                md.update(buffer, 0, length);
            }

            return md.digest();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected static String bytes2hex(byte[] bytes) {
        int i = 0;
        char[] ret = new char[bytes.length << 1];

        for (byte b : bytes) {
            ret[i++] = hexChar[b >>> 4 & 0xF];
            ret[i++] = hexChar[b & 0xF];
        }

        return new String(ret);
    }
}
