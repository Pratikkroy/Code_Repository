package basic_ds;

public class BST {

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
	
	BST()
	{
		root=null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
