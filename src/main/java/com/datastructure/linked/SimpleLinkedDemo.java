package com.datastructure.linked;

import java.io.StringReader;

public class SimpleLinkedDemo {


    public static void main(String[] args) {
        SimpleLinked simpleLinked = new SimpleLinked(0,"头");
        Node node1= new Node(1,"sky");
        Node node2= new Node(2,"skt");
        Node node3= new Node(3,"sum");

        simpleLinked.add(node1);
        simpleLinked.add(node2);
        simpleLinked.add(node3);


        simpleLinked.list();

//        System.out.println("头节点添加 ==");
//        simpleLinked.addHead(node2);
//        simpleLinked.addHead(node1);
//        simpleLinked.addHead(node3);
//        simpleLinked.list();
        //翻转

       System.out.println("翻转 =");
       Node serverseNode = simpleLinked.serverse();
       simpleLinked.head.next = serverseNode;
       simpleLinked.list();

    }

    /**
     * 简单链表
     */
    static class SimpleLinked{
        int no;
        String name;
        Node head = new Node(0,"");

        public SimpleLinked(int no, String name) {
            this.no = no;
            this.name = name;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("SimpleLinked{");
            sb.append("no=").append(no);
            sb.append(", name='").append(name).append('\'');
            sb.append('}');
            return sb.toString();
        }

        public void del(int no){
            Node temp = head;
            while (true){

                if(temp.next == null){
                    break;
                }

                if(temp.next.no == no){
                    //删除
                    temp.next = temp.next.next;

                    break;
                }
                temp = temp.next;
            }


        }

        public void addHead(Node newNode){
            //newNode.next = null;
            Node temp = this.head;

            if(temp.next == null){
                temp.next = newNode;

            }else {

              temp.next.next = null;
              Node n1 =  temp.next; // 1,2,3
            //  n1.next = null;
              newNode.next = n1;
              temp.next = newNode;
            }



        }


        /**
         * 添加节点
         */
        public void add(Node newNode){
            Node temp = head;
            while(true){
                if(temp.next == null){
                    break;
                }

                //下移
                temp = temp.next;
            }
            //最后一个Node 添加
            temp.next = newNode;

        }

        public void list(){
            Node temp = head;
            while (true){
                if(temp.next == null){
                    break;
                }

                System.out.println(temp.next);

                temp = temp.next;
            }
        }

        public Node serverse(){

            //翻转节点
            Node serverseNode = new Node(0,"");
            //当前链表的第一个节点
            Node cur = this.head.next;
            /**
             * 第一个节点的下一个节点
             */
            Node next = null;

            while (true){
                if(cur == null){
                    break;
                }
                //给下一个节点赋值
                next = cur.next;
                cur.next = serverseNode.next;
                serverseNode.next = cur;
                cur = next; //往下移
            }

            //将翻转过来的节点 赋值给当前节点
            head.next = serverseNode.next;

          return head.next;


        }

        public Node getHead(){
            Node temp = head;
                if(temp.next == null){
                    System.out.println("链接为空");
                }
            temp = head.next;
            return temp;



        }
    }
}
