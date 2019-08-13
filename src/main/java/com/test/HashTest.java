package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class HashTest {

    public static void main(String[] args) {
        // 8 4 2 1
        int len = 7;
        int z = 15;

        int res = z % len;
        int res1 = z & (len-1);   // 0111 & 1111  = 0111


        System.out.println(res);
        System.out.println(res1);

        List<Integer> list = new ArrayList();


        StringBuilder sb = new StringBuilder();
        sb.reverse();
    }
}
