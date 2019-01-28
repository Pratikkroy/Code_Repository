package basic_ds;

public class Tree {

	public class Node
	{
		public int data;
		public Node left,right;
		
		private Node(int value)
		{
			data=value;
			left=right=null;
		}
	}
	
	private Node root;
	
	public Tree()
	{
		root=null;
	}
	
	public void addRoot(int data)
	{
		root=new Node(data);
	}
	
	public void addNode(int p,int data,String s)
    {
        Node parent=find(p);

        if(parent!=null)
        {
            Node node=new Node(data);
            if(s.equals("L"))
            	parent.left=node;
            else
            	parent.right=node;

            //System.out.print(data+" added ");
        }
    }
	
	public Node find(int data)
	{
		return findUtil(root,data);
	}
	
	private Node findUtil(Node root,int data)
	{
		// search the tree in preorder fashion.
		
		if(root==null)
			return null;
		
		if(root.data==data)
			return root;
		
		// search left
		Node node=findUtil(root.left, data);
		
		// search right
		if(node==null)
			node=findUtil(root.right, data);
		
		return node;
			
	}
	
	public boolean isPresentNode(int data)
	{
		if(find(data)==null)
			return false;
		else
			return true;
	}
	
	// height of node is the length of path (number of edges) from root to path.
	// height of a tree is the maximum height of the nodes in a tree.
	public int findHeightOfNode(Node node)
	{
		//return findHeightUtil(root);
		return findLevel(node)-1;
	}
	
	public int findHeightOfTree()
	{
		return findHeightUtil(root);
	}
	
	private int findHeightUtil(Node root)
	{
		if(root==null)
			return -1;
		
		int leftHeight=findHeightUtil(root.left);
		int rightHeight=findHeightUtil(root.right);
		
		return leftHeight>rightHeight?leftHeight+1:rightHeight+1;
	}
	
	
	//level of root is 1
	public int findLevel(Node node)
	{
		return findLevelUtil(root, node, 1);
	}
	
	private int findLevelUtil(Node root,Node node,int level)
	{
		if(root==null)
			return 0;
		
		if(root==node)
			return level;
		
		int left=findLevelUtil(root.left, node, level+1);
		
		if(left!=0)
			return left;
		
		return findLevelUtil(root.right, node, level+1);
			
	}
	
	public void inorder()
	{
		inorder(root);
	}
	
	private void inorder(Node root)
	{
		if(root==null)
			return;

	    inorder(root.left);
	    System.out.print(root.data+" ");
	    inorder(root.right);
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Tree tree=new Tree();
		tree.addRoot(1);
		tree.addNode(1, 2, "L");
		tree.addNode(1, 3, "R");
		tree.addNode(3, 4, "L");
		tree.addNode(3, 5, "R");
		tree.addNode(5, 6, "L");
		
		//tree.inorder();
		
		System.out.println(tree.findHeightOfTree());
		System.out.println(tree.findLevel(tree.find(6)));
	}

}
