package com.yunchen.common.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.ConcurrentHashMap;

public class GenericUtils {
    private static final ConcurrentHashMap<String, Class<?>> mapCaches = new ConcurrentHashMap<>();

    public static <T> Class<T> getEntityClass(Class<?> klass, Class<?> targetParent) {
        String key = klass.getName() + ":" + targetParent.getName();
        if (mapCaches.containsKey(key)) {
            @SuppressWarnings("unchecked")
            Class<T> result = (Class<T>) mapCaches.get(key);
            return result;
        }

        Class<T> result = findEntityClass(klass, targetParent);
        if (null != result) {
            mapCaches.put(key, result);
        }

        return result;
    }

    private static <T> Class<T> findEntityClass(Class<?> klass, Class<?> targetParent) {
        Type[] types = klass.getGenericInterfaces();
        for (Type type : types) {
            if (type instanceof ParameterizedType) {
                ParameterizedType t = (ParameterizedType) type;
                if (t.getRawType() == targetParent || targetParent.isAssignableFrom((Class<?>) t.getRawType())) {
                    @SuppressWarnings("unchecked")
                    Class<T> result = (Class<T>) t.getActualTypeArguments()[0];
                    return result;
                }
            } else if (type instanceof Class) {
                return findEntityClass((Class<?>) type, targetParent);
            }
        }

        return null;
    }
}
