package graph;

public class Dijkstra {

	public int parent[];
	public int distance[];	
	
	public void dijkstra(Graph graph,int source)
	{
		SingleSourceShortestPath util=new SingleSourceShortestPath();
		
		util.initialiseSingleSource(graph, source);
		
		PriorityQueue queue=new PriorityQueue(100);
		
		for(int i=0;i<graph.numberOfVertices;i++)
		{
			queue.add(1, util.VERY_BIG_NUMBER);
		}
		
		queue.decreaseRank(source, 0);
		
		LinkedList.Node ptr;
		int min;
		
		while(queue.size>-1)
		{
			min=queue.extractMin();
			ptr=graph.adjList[min].head;
			
			while(ptr!=null)
			{
				util.relax(min, ptr.index, ptr.weight);
				ptr=ptr.next;
			}
		}
		
		this.parent=util.parent;
		this.distance=util.distance;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

