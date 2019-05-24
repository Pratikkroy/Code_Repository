package graph;

public class BreadthFirstSearch {

	int numberOfVertices;
	int distance[];
	int parent[];
	
	public BreadthFirstSearch(int n)
	{
		numberOfVertices=n;
		distance=new int[numberOfVertices];
		parent=new int[numberOfVertices];
		
		distance[0]=0;
		parent[0]=-1;
	}
	
	public void search(Graph graph,int source)
	{		
		int visited[]=new int[numberOfVertices];
		Queue q=new Queue(numberOfVertices);
		
		q.enqueue(source);
		visited[source]=1;     
		// 0 means not discovered. 
		// 1 means it is in the queue. 
		// 2 means it is explored and out of the queue.
		
		int pnode,nnode;
		LinkedList.Node ptr;
		
		while(!q.isEmpty())
		{
			pnode=q.deque();
			ptr=graph.adjList[pnode].head;
			
			while(ptr!=null)
			{
				nnode=ptr.index;
				
				if(visited[nnode]==0)
				{
					visited[nnode]=1;
					q.enqueue(nnode);
					
					distance[nnode]=distance[pnode]+1;
					parent[nnode]=pnode;
				}
				ptr=ptr.next;				
			}
			visited[pnode]=2;
			System.out.println(pnode+" --> "+distance[pnode]+" --> "+parent[pnode]);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph graph=new Graph(8);
		
		graph.addEdge(0, 1, 1);
		graph.addEdge(0, 2, 1);
		graph.addEdge(0, 6, 1);
		graph.addEdge(2, 3, 1);
		graph.addEdge(3, 4, 1);

		graph.addEdge(1, 5, 1);
		graph.addEdge(6, 5, 1);
		graph.addEdge(6, 4, 1);
		graph.addEdge(4, 7, 1);
		graph.addEdge(5, 7, 1);
		
		//graph.printGraph();
		System.out.println("pnode --> distance --> parent");
		
		BreadthFirstSearch bfs=new BreadthFirstSearch(graph.numberOfVertices);
		bfs.search(graph,0);
		
		
	}

}

class Queue {

	private int front,rear;
	private int queue[];
	private int MAX_SIZE;
	
	Queue(int size)
	{
		MAX_SIZE=size;
		queue=new int[MAX_SIZE];
		
		front=rear=-1;
	}
	
	public boolean enqueue(int value)
	{
		if(front==-1) // empty queue
		{
			front=rear=0;
			
			queue[rear]=value;
			return true;
		}
		
		if(rear>=front)   // when rear==front ---> one element
		{
			if(rear-front+1==MAX_SIZE) //queue overflow
				return false; 	
		}
		else if(front>rear)
		{
			if(front-rear==1)   // queue overflow
				return false;
		}
		
		rear=(rear+1)%MAX_SIZE;
		
		queue[rear]=value;
		return true;
	}

	public int deque()
	{
		if(front==-1) //empty queue
			return -1;
		
		int result=queue[front];
		
		front=(front+1)%MAX_SIZE;
		
		if(front==(rear+1)%MAX_SIZE)
			front=rear=-1;
		
		return result;
	}
	
	public boolean isEmpty()
	{
		return front==-1;
	}

}

