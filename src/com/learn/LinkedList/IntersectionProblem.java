package com.learn.LinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionProblem {
	
	public static Node findIntersection(Node node1, Node node2) {
		int length1=0, length2=0;
		
		Node temp1 = node1;
		Node temp2 = node2;
		
		while(temp1 != null) {
			length1++;
			temp1 = temp1.next;
		}
		while(temp2 != null) {
			length2++;
			temp2 = temp2.next;
		}
		int diff = Math.abs(length1 - length2);
		if(length1 > length2) {
			temp1 = node1;
			temp2 = node2;
		} 
		else {
			temp1 = node2;
			temp2 = node1;
		}
		int i= 0;
		while(i<diff) {
			temp1 = temp1.next;
			i++;
		}
		while(!(temp1 == temp2)) {
			if(temp1 == null || temp2 == null)
				return null;
			
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		return temp1;
	}
	public static Node findIntersectionAltApproach(Node node1, Node node2) {
		
		Node temp1 = node1;
		Node temp2 = node2;
		Set<Node> nodes = new HashSet<Node>();
		Node cNode = null;
		while(temp1!=null&&temp2!=null) {
			if(nodes.contains(temp1)) {
				cNode = temp1;
				break;
			}
			if(nodes.contains(temp2)) {
				cNode = temp2;
				break;
			}
			nodes.add(temp1);
			temp1= temp1.next;
			
			nodes.add(temp2);
			temp2 = temp2.next;
			
		}
		
		if(cNode==null) {
			Node temp = null;
			if(temp1==null) {
				temp = temp2;
			}
			else {
			    temp = temp1;	
			}
				while(temp!=null) {
					if(nodes.contains(temp)) {
						cNode = temp;
						break;
					}
					temp = temp.next;
				}
			}
			
		
		
		return cNode;
	}
	public static class Node {
		Node next;
		int key;
		public Node(int key) {
			this.key = key;
		}
	}
	
	public static void main(String args[]) {
		/*
		 * Node head1 = new Node(1); head1.next = new Node(2); Node temp = head1.next;
		 * temp.next = new Node(3); temp = temp.next; Node head2 = new Node(5);
		 * head2.next = temp; temp.next = new Node(4);
		 * 
		 * System.out.print(findIntersectionAltApproach(head1,head2).key);
		 */
		
		String str1 = "12345";
		String str2 = "12345678";
		List<String> strs = new ArrayList<String>();
		//strs.add(getStringForSort(str1));
		//strs.add(getStringForSort(str2));
		strs.add(str1);
		strs.add(str2);
		Collections.sort(strs);
		System.out.print(strs.toString());

	}

	public static String getStringForSort(String str) {
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			if(ch>='0'&&ch<='9')
			sb1.append(ch);
			else
				sb2.append(ch);
		}
		return sb1.append(sb2).toString();
	}
}
