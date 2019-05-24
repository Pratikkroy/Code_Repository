package graph;

public class SingleSourceShortestPath {

	public int parent[];
	public int distance[];
	final int VERY_BIG_NUMBER=1000000000;
	
	public void initialiseSingleSource(Graph graph,int source)
	{
		if(source<0 || source>=graph.numberOfVertices )
			return;
		
		parent=new int[graph.numberOfVertices];
		distance=new int[graph.numberOfVertices];
		
		for(int i=0;i<graph.numberOfVertices;i++)
		{
			parent[i]=-1;
			distance[i]=VERY_BIG_NUMBER;
		}
		
		distance[source]=0;
	}
	
	public void relax(int u,int v,int w)
	{
		if(distance[v]>distance[u]+w)
		{	
			distance[v]=distance[u]+w;
			parent[v]=u;
		}
	}
	
	public static void printArray(int arr[])
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(i+" --> "+arr[i]);
		}
	}
}
