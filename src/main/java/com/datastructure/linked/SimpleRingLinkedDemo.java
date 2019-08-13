package com.datastructure.linked;

public class SimpleRingLinkedDemo {

    public static void main(String[] args) {
        SimpleRingLinked simpleRingLinked = new SimpleRingLinked(0,3);
        Node node1= new Node(1,"sky");
        Node node2= new Node(2,"skt");
        Node node3= new Node(3,"sum");
        Node node4= new Node(4,"ddd");

        simpleRingLinked.add(node1);
        simpleRingLinked.add(node2);
        simpleRingLinked.add(node3);
        simpleRingLinked.add(node4);
        simpleRingLinked.list();
    }


    /**
     *   环形单链表
     */
    static class SimpleRingLinked{
        int no;
        /**
         * 长度
         */
        int length;

        Node head = new Node(0,"");


        SimpleRingLinked(int no, int length){
            this.no = no;
            this.length = length;
        }
        /**
         * 添加节点
         */
        public void add(Node newNode){
            Node temp = head;
            if (length < 0) {
                System.out.println("长度越界");
                return;
            }
            while (temp.next != null && temp.next != head){
                temp = temp.next;
            }
            //最后位置 添加数据
            temp.next = newNode;
            newNode.next = head;

        }

        public void list(){
            Node temp = head;
            while (temp.next != head){

                temp = temp.next;
                System.out.println(temp);
            }
        }

        public boolean isEmpty(){
            Node temp = head;
            /**
             * 判空 闭环
             */
            if(temp.next != head){
                return false;
            }else{
                return true;
            }
        }
    }



}
