package com.learn.trees;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ClosestLeafNode {
	
	Node root = null;
	public static class Node {
		char data;
		Node left;
		Node right;
		Node(char k) {
			this.data = k;
		}
	}
	public static class Dist{
		int minDist;
	}
	
	public void findClosestDown(Node node,Dist dist,int lev) {
		
		if(node == null)
			return;
		if(node.left == null&&node.right == null) {
			if(dist.minDist>lev) {
				dist.minDist = lev;
				System.out.println("closest leaf node is----->"+node.data);
			}
		}
		findClosestDown(node.left,dist,lev+1);
		findClosestDown(node.right,dist,lev+1);
		
	}
	
	public int findAncesstors(Node node,Map<Node,Integer> ancesstors,char k) {
		
		if(node == null)
			return -1;
		if(node.data==k) {
			ancesstors.put(node,-1);
			return 1;
		}
		
		
		int l = findAncesstors(node.left,ancesstors,k);
		if(l==1) {
			ancesstors.put(node, 1);
			return 1;
		}
		if (l==-1) {
			int r = findAncesstors(node.right,ancesstors,k);
			if(r==1) {
				ancesstors.put(node, 0);
				return 1;
			}
		}
		return -1;
	}
	
	public void findMinLeaf(Node root, char k) {
		
		Map<Node,Integer> ancesstors = new LinkedHashMap<Node,Integer>();
		findAncesstors(root,ancesstors,k);
		Set<Node> ancNodes = ancesstors.keySet();
		int i =1;
		Dist dist = new Dist();
		dist.minDist = Integer.MAX_VALUE;
		for(Node node:ancNodes) {
			if(ancesstors.get(node)==1)
			findClosestDown(node.right,dist,i);
			else if(ancesstors.get(node)==0) {
				findClosestDown(node.left,dist,i);
			}
			else {
				findClosestDown(node.left,dist,i);
				findClosestDown(node.right,dist,i);
			}
			i++;
		}
        System.out.println(dist.minDist);

	}
	public static void main(String[] args) {
		ClosestLeafNode tree = new ClosestLeafNode();
		tree.root = new Node('A');
		tree.root.left = new Node('B'); 
        tree.root.right = new Node('C'); 
        tree.root.right.left = new Node('E'); 
        tree.root.right.right = new Node('F'); 
        tree.root.right.left.left = new Node('G'); 
        tree.root.right.left.left.left = new Node('I'); 
        tree.root.right.left.left.right = new Node('J'); 
        tree.root.right.right.right = new Node('H'); 
        tree.root.right.right.right.left = new Node('K');
        char k = 'F';
        tree.findMinLeaf(tree.root, k);
        
		
	}

}
