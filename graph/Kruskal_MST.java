package graph;

import advanced_ds.DisjointSet2;

public class Kruskal_MST {

	public Graph kruskal(Graph graph)
	{		
		Edge edges[]=findEdges(graph);
		
		quicksort(edges, 0,edges.length-1);
		
		/*for(int i=0;i<edges.length;i++)
		{
			System.out.println(edges[i].source+" --> "+edges[i].destination+" --> "+edges[i].weight);
		}*/
		
		return buildMST(graph,edges);
	}
	
	private Graph buildMST(Graph graph,Edge edges[])
	{
		Graph mst=new Graph(graph.numberOfVertices);
		
		DisjointSet2 ds=new DisjointSet2(graph.numberOfVertices);
		
		for(int i=0;i<graph.numberOfVertices;i++)
			ds.sets[i]=ds.makeSet(i);
		
		for(int i=0;i<edges.length;i++)
		{
			if(ds.findSet(ds.sets[edges[i].source])!=ds.findSet(ds.sets[edges[i].destination]))
			{
				mst.addEdge(edges[i].source, edges[i].destination, edges[i].weight);
				ds.union(ds.sets[edges[i].source], ds.sets[edges[i].destination]);
			}
		}
		
		return mst;
	}
	
	private Edge[] findEdges(Graph graph)
	{
		Edge edges[]=new Edge[100];
		int x=0;
		
		LinkedList.Node ptr;
		for(int i=0;i<graph.numberOfVertices;i++)
		{
			ptr=graph.adjList[i].head;
			
			while(ptr!=null)
			{
				edges[x]=new Edge(i,ptr.index,ptr.weight);
				x++;
				ptr=ptr.next;
			}
		}
		
		Edge edge[]=new Edge[x];
		for(int i=0;i<x;i++)
			edge[i]=edges[i];
		
		return edge;
	}
	
	private void quicksort(Edge edges[],int l,int r)
	{
		if(l<r)
		{
			int pivot=partition(edges,l,r);
			
			quicksort(edges, l, pivot-1);
			quicksort(edges, pivot+1,r);
		}
	}
	
	private int partition(Edge edges[],int l,int r)
	{	
		int pivot=l;
		
		for(int i=l;i<r;i++)
		{
			if(edges[i].weight<edges[r].weight)
			{
				if(i!=pivot)
					swap(edges,i,pivot);
				pivot++;
			}
		}
		
		swap(edges,r,pivot);
		
		return pivot;
	}
	
	private void swap(Edge edges[],int x,int y)
	{
		if(x!=y)
		{
			Edge temp=edges[x];
			edges[x]=edges[y];
			edges[y]=temp;
		}
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
		
		Kruskal_MST mst=new Kruskal_MST();
		
		Graph g=mst.kruskal(graph);
		
		g.printGraph();
	}

}
