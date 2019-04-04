package basic_ds;

public class BST {

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
	
	public BST()
	{
		root=null;
	}
	
	public void insert(int data)
	{
		Node node = new Node(data);
		
		if(root==null)
		{
			root=node;
			return;
		}
		
		Node parent=root;
		Node ptr=root;
		
		while(ptr!=null)
		{
			parent=ptr;
			
			if(data>ptr.data)
				ptr=ptr.right;
			
			else if(data<ptr.data)
				ptr=ptr.left;
			
			// duplicate element
			else
				break;
			
		}
		
		if(data<parent.data)
			parent.left=node;
		else if (data>parent.data)
			parent.right=node;
		
	}
	
	public Node search(int data)
	{
		if(root==null)
			return null;
		
		Node node=root;
		
		while(node!=null)
		{
			if(data>node.data)
				node=node.right;
			else if(data<node.data)
				node=node.left;
			else if(data==node.data)
				return node;
		}
		
		return null;
	}
	
	public Node findParent(int data)
	{
		if(root==null || root.data==data)
			return null;
		
		Node parent=root;
		Node node=root;
		
		while(node!=null)
		{
			
			if(data>node.data)
			{	
				parent=node;
				node=node.right;
			}
			else if(data<node.data)
			{
				parent=node;
				node=node.left;
			}
			else if(data==node.data)
				return parent;
			
			
		}
		
		return null;
	}
	
	public void delete(Node node)
	{
		if(node==null)
			return;
		
		Node parent=findParent(node.data);
		
		if(node.left==null && node.right==null)
		{
			if(parent.left==node)
				parent.left=null;
			else
				parent.right=null;
				
		}
		else if(node.left==null)
		{
			if(parent.left==node)
				parent.left=node.right;
			else
				parent.right=node.right;
		}
		else if(node.right==null)
		{
			if(parent.left==node)
				parent.left=node.left;
			else
				parent.right=node.left;
		}
		else
		{
			//succ=findSuccessor(node);
		}
	}
	
	public Node findInorderSuccessor(Node node)
	{
		
		return null;
		
		
	}
	
	public Node findInorderPredeccessor(Node node)
	{
		
		return null;
		
	}
	
	public Node findCeil(Node node)
	{
		
		return null;
		
		
	}
	
	public Node findFloor(Node node)
	{
		
		return null;
		
		
	}
	
	public static void inorder(Node root)
	{
		if(root==null)
			return;
		
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BST b=new BST();
		b.insert(5);
		b.insert(3);
		b.insert(1);
		b.insert(4);
		b.insert(8);
		b.insert(6);
		b.insert(5);
		b.insert(10);
		b.insert(12);
		
		
		b.inorder(b.root);
		System.out.println();
		b.delete(b.search(10));
		
		b.inorder(b.root);
		System.out.println();
	}

}
