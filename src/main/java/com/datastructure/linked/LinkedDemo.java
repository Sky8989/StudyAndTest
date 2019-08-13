package com.datastructure.linked;

import java.util.List;

public class LinkedDemo {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        //当前节点
        ListNode cur = result;
        //用来进位
        int curNum = 0;
        while(true){
            if(l1 == null || l2 == null){
                break;
            }
            int num1 = l1.val;
            int num2 = l2.val;

            int  sum = curNum + (num1 + num2);
            System.out.println("1 sum = " + sum);

            curNum = sum / 10; //判断求和 是否大于10
            System.out.println("1 curNum = " + curNum);
            sum = sum % 10;
            System.out.println("2 sum = " + sum);

            cur.next = new ListNode(sum);
            cur = cur.next;

            if (l1 != null)
            l1 = l1.next;

            if (l2 != null)
            l2 = l2.next;

        }
        //进位
        if(curNum == 1){
            System.out.println("---");
            cur.next = new ListNode(curNum);
        }

        return result.next;
    }

    public static void main(String[] args) {

        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);

        ListNode node1 = new ListNode(0);
        node1 = listNode2;
        node1.next = new ListNode(4);
        node1.next.next = listNode3;

        node1.list();
        System.out.println("-----------");


        ListNode node2 = new ListNode(0);
        node2 = listNode5;
        node2.next = listNode6;
     //   node2.next.next = listNode4;
        node2.next.next = new ListNode(9);

        node2.list();


        ListNode resultNode = addTwoNumbers(node1,node2);
        System.out.println("计算后的结果 ");
        resultNode.list();

    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

      public void list(){
          ListNode temp = this;
          while (true){
              if(temp == null){
                  break;
              }
              System.out.println(temp);
              temp = temp.next;
          }
      }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("ListNode{");
            sb.append("val=").append(val);
            sb.append('}');
            return sb.toString();
        }
    }


}
