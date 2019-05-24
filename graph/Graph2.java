package graph;


class Vertex
{
	public int data;
	public int index;
	
	public Vertex(int d,int i)
	{
		data=d;
		index=i;
	}
}

class Edge
{
	public int source;
	public int destination;
	public int weight;
	
	Edge(int s,int d,int w)
	{
		source=s;
		destination=d;
		weight=w;
	}
}

public class Graph2 {

	public int numberOfVerices;
	public int numberOfEdges;
	int k;
	
	public Vertex vertices[];
	public Edge edges[];
	
	public Graph2(int v,int e)
	{
		numberOfVerices=v;
		numberOfEdges=e;
		k=0;
		
		vertices=new Vertex[numberOfVerices];
		edges=new Edge[numberOfEdges];
	}
	
	public void addEdge(int u,int v,int weight)
	{
		edges[k]=new Edge(u,v,weight);
		k++;
	}
	
	public void addVertex(int data,int index)
	{
		vertices[index]=new Vertex(data,index);
	}
	
	public void printGraph()
	{
		for(int i=0;i<numberOfEdges;i++)
			System.out.println(edges[i].source+" "+edges[i].destination+" "+edges[i].weight);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// This class is made just to represent graph in another way.
		
		int v=5;
		int e=7;
		
		Graph2 graph=new Graph2(v,e);
		
		for(int i=0;i<5;i++)
			graph.addVertex(i, i);
		
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
