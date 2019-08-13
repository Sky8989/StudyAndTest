package com.datastructure.linked;

public class DoubleLikedDemo {

    public static void main(String[] args) {
        DoubleLiked doubleLiked = new DoubleLiked();

        DoubleNode n1 = new DoubleNode(1,"aaa");
        DoubleNode n2 = new DoubleNode(2,"bbb");
        DoubleNode n3 = new DoubleNode(3,"ccc");
        DoubleNode n4 = new DoubleNode(4,"ddd");

        doubleLiked.add(n1);
        doubleLiked.add(n2);
        doubleLiked.add(n3);
        doubleLiked.add(n4);

        doubleLiked.list();


    }

    static class DoubleLiked{
        int no;

        /**
         * 前一个节点
         */
        DoubleNode pre;
        /**
         * 后一个节点
         */
        DoubleNode next = new DoubleNode(0,"");


        /**
         * 添加节点
         * @param newNode
         */
        public void add(DoubleNode newNode){
            DoubleNode temp = next;

            while (true){
                if(temp.next == null){
                    break;
                }

                temp = temp.next;
            }

            //添加
            temp.next = newNode;
            newNode.pre = temp;
        }

        public void list(){
            DoubleNode temp = next;
            while (true){
                if(temp.next == null){
                    break;
                }

                temp = temp.next;
                System.out.println(temp);

            }
        }
    }


}
