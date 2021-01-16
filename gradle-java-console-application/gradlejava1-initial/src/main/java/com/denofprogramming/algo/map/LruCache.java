package com.denofprogramming.algo.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache {

    /**
     * used LinkedHashMap to implement
     */
    Map<String, String> cache;

    public LruCache(int cap) {
        cache = new LinkedHashMap<String, String>(cap);
    }

    public void put(String k, String v) {
        cache.put(k, v);
    }

    public String get(String k) {
        String v = cache.get(k);
        if (v != null) {
            cache.remove(k);
            cache.put(k, v);
        }
        return v == null ? "" : v;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String k : cache.keySet()) {
            sb.append(cache.get(k) + " ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LruCache cache = new LruCache(10);
        cache.put("d", "d");
        cache.put("e", "e");
        cache.put("f", "f");
        cache.put("a", "a");
        cache.put("b", "b");
        cache.put("c", "c");
        cache.get("d");
        System.out.println(cache);
    }

}
