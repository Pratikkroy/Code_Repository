package graph;

public class DepthFirstSearch {

	int numberOfVertices;
	int parent[];
	int discoveryTime[];
	int finishTime[];
	int visited[];
	int time;
	
	public DepthFirstSearch(int n) 
	{
		numberOfVertices=n;	
	}
	
	public void search(Graph graph,int source)
	{
		time=0;
		parent=new int [numberOfVertices];
		discoveryTime=new int[numberOfVertices];
		finishTime=new int [numberOfVertices];
		
		visited=new int[numberOfVertices];
		
		parent[source]=-1;
		
		visit(graph, source);
		for(int i=0;i<numberOfVertices;i++)
		{
			if(visited[i]==0)
				visit(graph,i);
			
			System.out.println(i+" --> "+parent[i]+" --> "+discoveryTime[i]+" --> "+finishTime[i]);
		}
	}
	
	public void visit(Graph graph,int pnode)
	{
		visited[pnode]=1;
		time++;
		discoveryTime[pnode]=time;
		
		LinkedList.Node ptr=graph.adjList[pnode].head;
		int nnode;
		while(ptr!=null)
		{	
			nnode=ptr.index;
			if(visited[nnode]==0)
			{
				parent[nnode]=pnode;
				visit(graph,nnode);
			}
			ptr=ptr.next;
		}
		
		visited[pnode]=2;
		time++;
		finishTime[pnode]=time;
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
		System.out.println("pnode --> parent --> discoveryTime --> finishTime");
				
		DepthFirstSearch dfs=new DepthFirstSearch(graph.numberOfVertices);
		dfs.search(graph,0);
				
	}

}
