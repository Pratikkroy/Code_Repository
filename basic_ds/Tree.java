package basic_ds;

public class Tree {

	class Node
	{
		int data;
		Node left,right;
		
		Node(int value)
		{
			data=value;
			left=right=null;
		}
	}
	
	private Node root;
	
	Tree()
	{
		root=null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
