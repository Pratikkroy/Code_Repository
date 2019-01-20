package basic_ds;

public class Tree {

	public class Node
	{
		public int data;
		public Node left,right;
		
		public Node(int value)
		{
			data=value;
			left=right=null;
		}
	}
	
	public Node root;
	
	public Tree()
	{
		root=null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
