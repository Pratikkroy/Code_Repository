package graph;

class LinkedList
{
	class Node
	{
		int index;
		int weight;
		Node next;
		
		Node(int d,int w)
		{
			index=d;
			weight=w;
			next=null;
		}
	}
	
	Node head;
	
	LinkedList()
	{
		head=null;
	}
	
	public void add(int value,int weight)
	{
		Node node=new Node(value,weight);
		
		if(head==null)
		{	
			head=node;
			return;
		}
		
		Node ptr=head;
		
		while(ptr.next!=null)
		{	
			// to avoid duplicate edges
			if(ptr.index==value)
				return;
			
			ptr=ptr.next;
		}
		
		ptr.next=node;	
	}

	public void addFirst(int value,int weight)
	{
		Node node=new Node(value,weight);
		
		node.next=head;
		head=node;
	}

}

public class Graph 
{
	int numberOfVertices;
	
	LinkedList adjList[];
	
	Graph(int v)
	{
		numberOfVertices=v;
		
		adjList=new LinkedList[numberOfVertices];
		
		for(int i=0;i<numberOfVertices;i++)
			adjList[i]=new LinkedList();
	}
	
	public void addEdge(int u,int v,int weight)
	{
		if(u<0 || u>=numberOfVertices || v<0 || v>=numberOfVertices)
			return;
				
		adjList[u].add(v,weight);
		
		//if it is a undirected graph then
		adjList[v].add(u,weight);
		
	}
	
	public void printGraph()
	{
		
		LinkedList.Node ptr;
		
		for(int i=0;i<numberOfVertices;i++)
		{
			ptr=adjList[i].head;
			System.out.print(i);
			
			while(ptr!=null)
			{	
				System.out.print(" --> "+ptr.index);
				ptr=ptr.next;
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph graph=new Graph(5);
		
		graph.addEdge(0, 1, 0);
		graph.addEdge(0, 2, 0);
		graph.addEdge(0, 3, 0);
		graph.addEdge(1, 4, 0);
		graph.addEdge(1, 3, 0);
		graph.addEdge(2, 3, 0);
		graph.addEdge(3, 4, 0);
		
		graph.printGraph();
	}

}
