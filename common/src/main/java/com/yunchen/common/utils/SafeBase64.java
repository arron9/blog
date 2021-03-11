package com.yunchen.common.utils;

import java.util.Base64;

public class SafeBase64 {
    public static String encode(byte[] data) {
        String origin = Base64.getEncoder().encodeToString(data);

        byte[] bytes = origin.getBytes();
        int end = bytes.length - 1;
        int i = end;
        boolean stop = false;

        while (i >= 0) {
            if ('=' == bytes[i] && !stop) {
                end--;
            } else {
                stop = true;

                if ('+' == bytes[i]) {
                    bytes[i] = '-';
                } else if ('/' == bytes[i]) {
                    bytes[i] = '_';
                }
            }

            i--;
        }

        return new String(bytes, 0, end + 1);
    }

    public static byte[] decode(String data) {
        int len = data.length();
        byte[] dest = new byte[len + 4];
        System.arraycopy(data.getBytes(), 0, dest, 0, len);

        for (int i = 0; i < len; i++) {
            if ('-' == dest[i]) {
                dest[i] = '+';
            } else if ('_' == dest[i]) {
                dest[i] = '/';
            }
        }

        System.arraycopy(new byte[]{'=', '=', '=', '='}, 0, dest, len, 4);

        return Base64.getDecoder().decode(new String(dest, 0, len + (4 - len & 3)));
    }
}
