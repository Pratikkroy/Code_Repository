package graph;

public class SSSPInDAG {

	public int parent[];
	public int distance[];
	
	public void shortestPath(Graph graph,int source)
	{
		SingleSourceShortestPath util=new SingleSourceShortestPath();
		
		util.initialiseSingleSource(graph, source);
		
		TopologicalSort tsort=new TopologicalSort();
		
		LinkedList list=tsort.topologicalsort(graph);
		
		LinkedList.Node ptr=list.head;
		LinkedList.Node itr;
		
		while(ptr!=null)
		{
			itr=graph.adjList[ptr.index].head;
			
			while(itr!=null)
			{
				util.relax(ptr.index, itr.index, itr.weight);
				itr=itr.next;
			}
			ptr=ptr.next;
		}
		
		this.parent=util.parent;
		this.distance=util.distance;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
