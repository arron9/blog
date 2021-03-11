package com.yunchen.common.utils;

public class StringUtils {
    public static String repeat(String str, int count) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            sb.append(str);
        }

        return sb.toString();
    }

    public static String suffix(String str, int count) {
        return str.substring(str.length() - count);
    }

    public static String prefix(String str, int count) {
        return str.substring(0, count);
    }
}
