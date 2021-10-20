package com.Driver.pak;

class Node
{
int data;
Node left,right;
Node(int item)
{
data = item;
left = right = null;
}
}
public class Driver1 {
	static void findSkew(Node root)
	{
		if(root != null)
		{
			findSkew(root.left);
			System.out.println(root.data);
			findSkew(root.right);
		}
	}
	
	
	public static void main(String args[])
	{
		Node node  = new Node(50);
		Node node1 = new Node(60);
		Node node2 = new Node(30);
		Node node3 = new Node(10);
		Node node4 = new Node(55);
		node.left = node2;
		node.right = node1;
		node2.left = node3;
		node1.left = node4;
		findSkew(node);
		
		
		
		}
}

