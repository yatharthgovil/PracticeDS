package com.learn.LinkedList;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class ArbitraryProblemSolution {
	
	public static List<Node> constructList() {
		Node node = new Node(1,null,null);
		Node head = node;
		List<Node> nodes = new ArrayList<Node>();
		nodes.add(node);
		int i =1 ;
		while(i<6) {
			Node node1 = new Node(i+1,null,null);
			head.next = node1;
			head = node1;
			nodes.add(node1);
			i++;
		}
		Node temp1 = nodes.get(0);
		temp1.arbit = nodes.get(2);
		temp1 = nodes.get(1);
		temp1.arbit = nodes.get(4);
		temp1 = nodes.get(2);
		temp1.arbit = nodes.get(1);
		temp1 = nodes.get(3);
		temp1.arbit = nodes.get(5);
		temp1 = nodes.get(4);
		temp1.arbit = nodes.get(0);
		temp1 = nodes.get(5);
		temp1.arbit = nodes.get(3);
		

	return nodes;
	}
	public static class Node {
		int data;
		Node next;
		Node arbit;
		Node(int data, Node next, Node arbit) {
			this.data = data;
			this.next = next;
			this.arbit = arbit;
		}
	}
	
	public static void main(String[] args) {
		List<Node> nodes = constructList();
		
		List<Node> cloneList = cloneList(nodes.get(1).arbit);
		System.out.println(cloneList.size());
		
	}
	public static Node get(Set<Node> nodeSet) {
		Iterator<Node> nodeIterator = nodeSet.iterator();
		if(nodeIterator.hasNext())
			return nodeIterator.next();
		else 
			return null;
	}

	public static List<Node> cloneList(Node node) {
		Set<Node> certainSet = new HashSet<Node>();
		Set<Node> arbitSet = new HashSet<Node>();
		Map<Integer,Node> keysMap = new HashMap<Integer,Node>();
		List<Node> cloneList = new ArrayList<Node>();
		Node temp = node;
		Node node1 = null;
		while(!arbitSet.isEmpty()||temp!=null) {
			if(temp == null) {
				temp = get(arbitSet);
			}
			
			if(arbitSet.contains(temp)) {
				arbitSet.remove(temp);
			}
			if(!certainSet.contains(temp)) {
				
				if(!keysMap.containsKey(temp.data)) {
					node1 = new Node(temp.data,null,null);
					keysMap.put(temp.data, node1);
					cloneList.add(node1);
				}
				else {
				    node1 = keysMap.get(temp.data);
				}
				if(temp.next!=null) {
					if(!keysMap.containsKey(temp.next.data)) {
						node1.next = new Node(temp.next.data,null,null);
						keysMap.put(node1.next.data, node1.next);
						cloneList.add(node1.next);
					}
					else 
						node1.next = keysMap.get(temp.next.data);

				}
				if(temp.arbit !=null) {
					if(!keysMap.containsKey(temp.arbit.data)) {
						node1.arbit = new Node(temp.arbit.data,null,null);
						keysMap.put(node1.arbit.data, node1.arbit);
						cloneList.add(node1.arbit);

					}else 
						node1.arbit = keysMap.get(temp.arbit.data);
					}		
			}
			if(!certainSet.contains(temp.arbit)) {
				arbitSet.add(temp.arbit);
			}
			certainSet.add(temp);
			temp = temp.next;
					}
		return cloneList;

	}
}
