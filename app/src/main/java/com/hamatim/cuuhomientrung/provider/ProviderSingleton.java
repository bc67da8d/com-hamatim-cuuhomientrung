package com.hamatim.cuuhomientrung.provider;

import java.util.HashMap;

public class ProviderSingleton {

    private static HashMap<String, Object> cached;

    public static <T> T get(final Class<T> tClass) {
        if (null == getCache().get(tClass.getCanonicalName())) {
            getCache().put(tClass.getCanonicalName(), create(tClass));
        }
        return (T) getCache().get(tClass.getCanonicalName());
    }

    private static <T> T create(Class<T> tClass) {
        try {
            return tClass.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException("Cannot create an instance of " + tClass, e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Cannot create an instance of " + tClass, e);
        }
    }

    public static HashMap<String, Object> getCache() {
        if (cached == null){
            cached = new HashMap<>();
        }
        return cached;
    }

}
