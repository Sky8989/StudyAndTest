package com.test;

import java.util.HashMap;
import java.util.Map;

public class HashMapTestAdd {
    public static void main(String[] args) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("aaa",new String("bbb"));
        map.put("aaa1",new String("a1"));
        map.put("aaa1",new String("b1"));
    }
}
