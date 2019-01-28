package basic_ds;


public class LinkedList {
	
	public class Node
	{
		public int data;
		public Node next;
		
		private Node(int value)
		{
			data=value;
			next=null;
		}
	}
	
	private Node head;
	private Node tail;
	
	public LinkedList()
	{
		head=null;
		tail=null;
	}
	
	public void addFirst(int value)
	{
		Node node=new Node(value);
		
		node.next=head;
		head=node;
		
		if(tail==null)
			tail=node;
	}
	
	public void addLast(int value)
	{
		if(head==null)
		{	
			addFirst(value);
			return;
		}
		
		Node node=new Node(value);
		
		tail.next=node;
		tail=node;
	}
	
	public void addAtN(int n,int value)
	{
		int length=length();
		
		if(length==0 && n==1) // empty list
		{
			addFirst(value);
			return;
		}
		else if(n>=1 && n<=length+1)
		{
			if(n==1)
			{
				addFirst(value);
				return;
			}
			else if(n==length+1) // last node
			{
				addLast(value);
				return;
			}
			
			Node ptr=head;
			
			while(n-->2)
				ptr=ptr.next;
			
			Node node=new Node(value);
			
			node.next=ptr.next;
			ptr.next=node;
		}
		
	}
	
	public void removeFirst()
	{
		if(head==null)
			return;
		
		head=head.next;
		
		if(head==null) // one element
			tail=null;
	}
	
	public void removeLast()
	{
		if(head==null)
			return;
		if(head==tail)  // one element
			head=tail=null;
		
		Node node=head;
		
		while(node.next!=tail)
			node=node.next;
		
		tail=node;
		node.next=null;
	}
	
	public void removeAtN(int n)
	{
		int length=length();
		
		if(n>0 && n<=length)
		{
			if(n==1)
			{	
				removeFirst();
				return;
			}
			if(n==length)
			{
				removeLast();
				return;
			}
			
			Node node=head;
			
			while(n-->2)
				node=node.next;
			
			node.next=node.next.next;
		}
		
	}
	
	public int length()
	{
		Node node=head;
		int length=0;
		
		while(node!=null)
		{
			length++;
			node=node.next;
		}
		
		return length;
	}
	
	public void display()
	{
		Node node=head;
		
		while(node!=null)
		{	
			System.out.print(node.data+" ");
			node=node.next;
		}
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList list=new LinkedList();
		
		list.addLast(20);
		list.addFirst(60);
		list.addFirst(80);
		list.addFirst(90);
		list.addFirst(89);
		list.addAtN(2, 10);
		list.display();
		
		list.removeLast();
		list.removeFirst();
		list.display();
		
		list.removeAtN(5);
		list.display();
		
	}

}
