package com.example.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.StringJoiner;

@SpringBootApplication
public class SpringBoot01Application {

	public static void main(String[] args) {
		//SpringApplication.run(SpringBoot01Application.class, args);
		ListNode l1	= new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
//
//		ListNode l2	= new ListNode(5);
//		l1.next = new ListNode(6);
//		l1.next.next = new ListNode(4);

		System.out.println(l1);
		System.out.println(getVal(l1));

	//	ListNode l3 = addTwoNumbers(l1,l2);

	}

	 static class ListNode {
      int val;
      ListNode next;

		@Override
		public String toString() {
			return new StringJoiner(", ", ListNode.class.getSimpleName() + "[", "]")
					.add("val=" + val)
					.add("next=" + next)
					.toString();
		}

		ListNode(int x) { val = x;

     }
  }


	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {


		return new ListNode(1);


	}

	public  static int getVal(ListNode l1){
		if(l1.next != null){
			return getVal(l1.next);
		}else {
			return l1.val;
		}
	}


}
