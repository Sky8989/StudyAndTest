package com.test;

import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();

        stack.push("1");
        stack.push("b");
        stack.push("c");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
