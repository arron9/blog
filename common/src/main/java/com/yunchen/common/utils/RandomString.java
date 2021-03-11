package com.yunchen.common.utils;

import java.util.Random;

public class RandomString {
    private static final String CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String random(int length) {
        int i = 0;
        char[] buffer = new char[length];

        Random rnd = new Random();
        while (i < length) {
            buffer[i++] = CHARS.charAt(rnd.nextInt(62));
        }

        return new String(buffer);
    }

    public static byte[] randomBytes(int length) {
        int i = 0;
        byte[] buffer = new byte[length];

        Random rnd = new Random();
        while (i < length) {
            buffer[i++] = (byte) rnd.nextInt(256);
        }

        return buffer;
    }
}
