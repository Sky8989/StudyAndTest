package com.datastructure.linked;

import java.util.Stack;

/**
 * 百度面试题  逆序打印链表
 */
public class BaiDuDemo {

    public static void main(String[] args) {
        SimpleLinkedDemo.SimpleLinked simpleLinked = new SimpleLinkedDemo.SimpleLinked(0,"");
        Node n1 = new Node(1,"aaa");
        Node n2 = new Node(2,"bbb");
        Node n3 = new Node(3,"ccc");
        Node n4 = new Node(4,"ddd");

        simpleLinked.add(n2);
        simpleLinked.add(n3);
        simpleLinked.add(n1);
        simpleLinked.add(n4);

        System.out.println("正常打印");

        simpleLinked.list();


        System.out.println("逆序打印");

        reversePrint(simpleLinked.head);

    }


    public static void reversePrint(Node head){
        if(head == null){
            System.out.println("链表为空");
        }

        Node cur = head.next;
        Node next = null;
        Stack<Node> stack = new Stack<>();

        while(true){
            if(cur  == null){
                break;
            }
            next = cur.next; //赋值给下一个节点
            cur.next = null; //取出第一个并将 下一个节点指向null
            stack.add(cur); //加入栈中
            cur = next;  //将一个节点 赋值给当前节点
        }

        //遍历
        int len = stack.size();
        for(int i = 0; i < len; i++){
            System.out.println(stack.pop());
        }

    }
}
