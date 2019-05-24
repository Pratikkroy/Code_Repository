package graph;


public class Prim_MST {

	public int parent[];
	public int distance[];
	final int VERY_BIG_NUMBER=1000000000;
	
	public Graph prim(Graph graph,int source)
	{
		parent=new int[graph.numberOfVertices];
		distance=new int[graph.numberOfVertices];
		
		PriorityQueue queue=new PriorityQueue(10);
		
		for(int i=0;i<graph.numberOfVertices;i++)
		{
			parent[i]=-1;
			distance[i]=VERY_BIG_NUMBER;
			
			queue.add(i, VERY_BIG_NUMBER);
		}
		
		distance[source]=0;
		queue.decreaseRank(source, 0);
		
		LinkedList.Node ptr;
		int min;
		
		while(queue.size>-1)
		{
			min=queue.extractMin();
			ptr=graph.adjList[min].head;
			
			while(ptr!=null)
			{
				if(queue.contains(ptr.index) && distance[ptr.index]>ptr.weight)
				{
					parent[ptr.index]=min;
					distance[ptr.index]=ptr.weight;
					
					queue.decreaseRank(ptr.index,ptr.weight);
				}
				ptr=ptr.next;
			}
		}
		
		Graph mst=new Graph(graph.numberOfVertices);
		for(int i=0;i<graph.numberOfVertices;i++)
		{
			if(parent[i]!=-1)
				mst.addEdge(parent[i], i, distance[i]);
		}
		
		return mst;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph graph=new Graph(6);
		
		graph.addEdge(0, 1, 2);
		graph.addEdge(0, 2, 3);
		graph.addEdge(1, 2, 3);
		graph.addEdge(1, 3, 4);
		graph.addEdge(1, 4, 6);

		graph.addEdge(2, 3, 5);
		graph.addEdge(2, 4, 1);
		graph.addEdge(3, 4, 6);
		graph.addEdge(3, 5, 2);
		graph.addEdge(5, 4, 3);
		
		Prim_MST mst=new Prim_MST();
		
		Graph g=mst.prim(graph,0);
		
		g.printGraph();
	}

}

class PriorityQueue {

	class Node
	{
		int rank;
		int index;
		
		public Node(int i,int r)
		{
			index=i;
			rank=r;
		}
	}
	
	public Node arr[];
	public int size;
	private int MAX_SIZE;
	
	public PriorityQueue(int maxSize) 
	{
		MAX_SIZE=maxSize;
		arr=new Node[MAX_SIZE];
		
		size=-1;
	}
	
	public void add(int index,int rank)
	{
		Node node=new Node(index,rank);
		
		insert(node);
	}
	
	public boolean contains(int value)
	{
		return !(findByValue(value)==-1);
	}
	
	public void deleteValue(int value)
	{
		delete(findByValue(value));
	}
	
	public void increaseRank(int value,int rank) 
	{
		increaseKey(findByValue(value), rank);	
	}
	
	public void decreaseRank(int value,int rank) 
	{
		
		decreaseKey(findByValue(value), rank);
		
	}
	
	public int extractMin()
	{
		int min=arr[0].index;
		
		delete(0);
		
		return min;
	}
	
	public int getMin()
	{
		return arr[0].index;
	}
	
	private void insert(Node value)
	{
		size=size+1;
		arr[size]=value;
		
		int child=size;
		int parent=(child-1)/2;
		
		while(parent>=0 && arr[parent].rank>arr[child].rank)
		{
			swap(arr,parent,child);
			
			child=parent;
			parent=(child-1)/2;
		}
	}
	
	private int delete(int index)
	{
		if(index<0 || index>size)
			return -1;
		
		int currentIndex=arr[index].index;
		arr[index].index=arr[size].index;
		
		int currentValue=arr[index].rank;
		int newValue=arr[size].rank;
		
		arr[size]=null;
		size=size-1;
		
		if(newValue>currentValue)
			increaseKey(index, newValue);
		else if(newValue<currentValue)
			decreaseKey(index, newValue);
		
		return currentIndex;
	}
	
	private void increaseKey(int index,int rank)
	{
		if(index<0 || index>size)
			return;
		
		arr[index].rank=rank;
		
		minHeapify(size, index);
	}
	
	private void decreaseKey(int index,int rank)
	{
		if(index<0 || index>size)
			return;
		
		arr[index].rank=rank;
		
		int child=index;
		int parent=(child-1)/2;
		
		while(parent>=0 && arr[parent].rank>arr[child].rank)
		{
			swap(arr,parent,child);
			
			child=parent;
			parent=(child-1)/2;
		}
	}
	
	private int findByValue(int value)
	{
		for(int i=0;i<=size;i++)
		{
			if(arr[i].index==value)
				return i;
		}
		
		return -1;
	}
	
	
	
	private void minHeapify(int size,int root)
	{
		int min=root;
		int lChild=2*root+1;
		int rChild=2*root+2;
		
		if(lChild<=size && arr[min].rank>arr[lChild].rank)
			min=lChild;
		
		if(rChild<=size && arr[min].rank>arr[rChild].rank)
			min=rChild;
		
		if(min!=root)
		{
			swap(arr,min,root);
			
			minHeapify(size,min);
		}
	}
	
	private void swap(Node arr[],int x,int y)
	{
		if(arr[x]!=arr[y])
		{
			Node temp=arr[x];
			arr[x]=arr[y];
			arr[y]=temp;
		}
		
	}

	
}

