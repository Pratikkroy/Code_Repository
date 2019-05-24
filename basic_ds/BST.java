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
			Node succ=findInorderSuccessor(node.data);
			
			int data=succ.data;
			delete(succ);
			
			if(parent.left==node)
				parent.left.data=data;
			else
				parent.right.data=data;
		}
	}
	
	public Node findInorderSuccessor(int data)
	{
		
		Node ptr=root;
		Node succ=null;
		
		while(ptr!=null)
		{
			if(data>ptr.data)
				ptr=ptr.right;
			else if(data<ptr.data)
			{
				succ=ptr;
				ptr=ptr.left;
			}
			else if(data==ptr.data)
			{
				if(ptr.right!=null)
				{
					succ=ptr.right;
					ptr=ptr.right;
					
					while(ptr!=null)
					{
						succ=ptr;
						ptr=ptr.left;
					}
				}
				
				return succ;
			}
		}
		
		return null;
		
		
	}
	
	public Node findInorderPredeccessor(int data)
	{
		Node ptr=root;
		Node pred=null;
		
		while(ptr!=null)
		{
			if(data>ptr.data)
			{
				pred=ptr;
				ptr=ptr.right;
			}
			else if(data<ptr.data)
				ptr=ptr.left;
			else if(data==ptr.data)
			{
				if(ptr.left!=null)
				{
					pred=ptr.left;
					ptr=ptr.left;
					
					while(ptr!=null)
					{
						pred=ptr;
						ptr=ptr.right;
					}
				}
				
				return pred;
			}
		}
		
		return null;
		
	}
	
	public Node findCeil(int data)
	{
		Node ptr=root;
		Node ceil=null;
		
		while(ptr!=null)
		{
			if(data>ptr.data)
				ptr=ptr.right;
			else if(data<ptr.data)
			{
				ceil=ptr;
				ptr=ptr.left;
			}
			else if(data==ptr.data)
				return ptr;
		}
		
		
		return ceil;
		
		
	}
	
	public Node findFloor(int data)
	{
		
		Node ptr=root;
		Node floor=null;
		
		while(ptr!=null)
		{
			if(data>ptr.data)
			{
				floor=ptr;
				ptr=ptr.right;
			}
			else if(data<ptr.data)
				ptr=ptr.left;
			else if(data==ptr.data)
				return ptr;
		}
		
		
		return floor;
		
	}
	
	public Node findLCA(Node node1, Node node2)
	{
		if(node1==null || node2==null)
			return null;
		
		if(node1==node2)
			return node1;
		
		Node max=node1.data>node2.data?node1:node2;
		Node min=node1.data<node2.data?node1:node2;
		
		Node node=root;
		
		while(node!=null)
		{
			if(max.data==node.data || min.data==node.data)
				return node;
				
			if(node.data>min.data && node.data<max.data)
				return node;
			else if(node.data>min.data && node.data>max.data)
				node=node.left;
			else if(node.data<min.data && node.data<max.data)
				node=node.right;
			
		}
		
		return node;
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
		b.insert(10);
		b.insert(9);
		
		
		b.inorder(b.root);
		System.out.println();
		
		System.out.println(b.findLCA(b.search(99), b.search(6)).data);
		
		b.inorder(b.root);
		System.out.println();
		
		
		
	}

}
