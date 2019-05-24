package graph;

public class BellmanFord {

	public int parent[];
	public int distance[];
	
	public boolean shortestPath(Graph graph,int source)
	{
		SingleSourceShortestPath util=new SingleSourceShortestPath();
		
		util.initialiseSingleSource(graph, source);
		
		LinkedList.Node ptr;
		
		for(int j=1;j<=graph.numberOfVertices-1;j++)
		{
			for(int i=0;i<graph.numberOfVertices;i++)
			{
				ptr=graph.adjList[i].head;
				
				while(ptr!=null)
				{
					util.relax(i,ptr.index,ptr.weight);
					ptr=ptr.next;
				}
			}
		}
		
		this.parent=util.parent;
		this.distance=util.distance;
		
		for(int i=0;i<graph.numberOfVertices;i++)
		{
			ptr=graph.adjList[i].head;
			
			while(ptr!=null)
			{
				if(distance[ptr.index]>distance[i]+ptr.weight)
					return false;
				ptr=ptr.next;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph graph=new Graph(5);
		
		graph.addEdge(0, 1, 6);
		graph.addEdge(0, 2, 7);
		graph.addEdge(1, 3, 5);
		graph.addEdge(1, 2, 8);
		graph.addEdge(1, 4, -4);
		
		graph.addEdge(2, 3, -3);
		graph.addEdge(2, 4, 9);
		graph.addEdge(3, 1, -2);
		graph.addEdge(4, 0, 2);
		graph.addEdge(4, 3, 7);
		
		graph.printGraph();
		
		BellmanFord bmf=new BellmanFord();
		bmf.shortestPath(graph, 0);
		
		//SingleSourceShortestPath.printArray(bmf.parent);
		//SingleSourceShortestPath.printArray(bmf.distance);
	}

}
