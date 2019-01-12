package data_structures;

class Node
{
	int data;
	Node parent;
	Node next;
	int length; 
	
	Node(int value)
	{
		data=value;
		next=null;
		length=1;
		parent=this;
	}
}

public class DisjointSet {

	public Node sets[];
	
	public DisjointSet(int n)
	{
		sets=new Node[n];
	}
	
	public Node makeSet(int data)
	{
		Node node=new Node(data);
		
		return node;
	}
	
	public void union(Node n1,Node n2)
	{
		Node head1=n1.parent;
		Node head2=n2.parent;
		
		int totalLength=head1.length+head2.length;
		
		if(head1==head2)
			return;
		
		if(head1.length>=head2.length)
		{
			Node ptr=head1;
			
			while(ptr.next!=null)
			{	
				ptr.length=totalLength;
				ptr=ptr.next;
			}
			
			ptr.next=head2;
			ptr.length=totalLength;
			ptr=ptr.next;
			
			while(ptr!=null)
			{	
				ptr.parent=head1;
				ptr.length=totalLength;
				ptr=ptr.next;
			}
			
			
			head2=null;
		}
		else
		{
			Node ptr=head2;
			
			while(ptr.next!=null)
			{	
				ptr.length=totalLength;
				ptr=ptr.next;
			}
			
			ptr.next=head1;
			ptr.length=totalLength;
			ptr=ptr.next;
			
			while(ptr!=null)
			{	
				ptr.parent=head2;
				ptr.length=totalLength;
				ptr=ptr.next;
			}
			
			head1=null;
		}
	}
	
	public Node findSet(Node element)
	{
		return element.parent;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[]= {1,2,3,4,5,6,7,8,9};
		int n=arr.length;
		
		
		DisjointSet ds=new DisjointSet(n);
		
		for(int i=0;i<n;i++)
			ds.sets[i]=ds.makeSet(arr[i]);
		
		ds.union(ds.sets[0],ds.sets[1]);
		ds.union(ds.sets[0],ds.sets[2]);
		ds.union(ds.sets[0],ds.sets[3]);
		ds.union(ds.sets[4],ds.sets[5]);
		ds.union(ds.sets[6],ds.sets[7]);
		ds.union(ds.sets[8],ds.sets[7]);
		
		Node node=ds.sets[0];
		
		Node head=node.parent;
		
		while(head!=null)
		{
			System.out.print(head.data+" "+head.length+"L ");
			head=head.next;
		}
		System.out.println();
		node=ds.sets[4];
		head=node.parent;
		
		while(head!=null)
		{
			System.out.print(head.data+" "+head.length+"L ");
			head=head.next;
		}
		System.out.println();
		node=ds.sets[6];
		head=node.parent;
		
		while(head!=null)
		{
			System.out.print(head.data+" "+head.length+"L ");
			head=head.next;
		}
		System.out.println();
		
	}

}
