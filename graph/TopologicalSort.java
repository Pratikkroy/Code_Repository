package graph;

public class TopologicalSort {

	int numberOfVertices;
	int discoveryTime[];
	int finishTime[];
	int visited[];
	int time;
	
	public LinkedList topologicalsort(Graph graph)
	{
		return dfSearch(graph,0);
	}
	
	private LinkedList dfSearch(Graph graph,int source)
	{
		numberOfVertices=graph.numberOfVertices;
		time=0;
		discoveryTime=new int[numberOfVertices];
		finishTime=new int [numberOfVertices];
		
		visited=new int[numberOfVertices];
		
		LinkedList list=new LinkedList();
		
		visit(graph,source,list);
		for(int i=0;i<numberOfVertices;i++)
		{
			if(visited[i]==0)
				visit(graph,i,list);
		}
		
		return list;
	}
	
	private void visit(Graph graph,int pnode,LinkedList list)
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
				visit(graph,nnode,list);
			}
			ptr=ptr.next;
		}
		
		visited[pnode]=2;
		time++;
		finishTime[pnode]=time;
		list.addFirst(pnode, 0);
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
		
		TopologicalSort sort=new TopologicalSort();
		
		LinkedList list=sort.topologicalsort(graph);
		LinkedList.Node ptr=list.head;
		
		while(ptr!=null)
		{
			System.out.print(ptr.index+" ");
			ptr=ptr.next;
		}
	}

}
