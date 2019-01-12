package data_structures;

class TreeNode
{
	int data;
	int rank;
	int size;
	TreeNode parent;
	
	TreeNode(int value)
	{
		data=value;
		rank=0;
		size=1;
		parent=this;
	}	
}
public class DisjointSet2 {

	public TreeNode sets[];
	
	public DisjointSet2(int size)
	{
		sets=new TreeNode[size];
	}
	
	public TreeNode makeSet(int value)
	{
		TreeNode node=new TreeNode(value);
		
		return node;
	}
	
	public void union(TreeNode node1,TreeNode node2)
	{
		link(findSet(node1),findSet(node2));
	}
	
	private void link(TreeNode head1,TreeNode head2)
	{
		if(head1==head2)
			return;
			
		if(head1.rank>=head2.rank)
		{	
			head2.parent=head1;
			
			if(head1.rank==head2.rank)
				head1.rank=head1.rank+1;
			
			head1.size=head1.size+head2.size;
		}
		else
		{
			head1.parent=head2;
			
			head2.size=head2.size+head1.size;
		}
	}
	
	public TreeNode findSet(TreeNode node)
	{
		if(node.parent!=node)
			node.parent=findSet(node.parent);
		
		return node.parent;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[]= {1,2,3,4,5,6,7,8,9};
		int n=arr.length;
		
		
		DisjointSet2 ds=new DisjointSet2(n);
		
		for(int i=0;i<n;i++)
			ds.sets[i]=ds.makeSet(arr[i]);
		
		ds.union(ds.sets[0],ds.sets[1]);
		ds.union(ds.sets[0],ds.sets[2]);
		ds.union(ds.sets[0],ds.sets[3]);
		ds.union(ds.sets[4],ds.sets[5]);
		ds.union(ds.sets[6],ds.sets[7]);
		ds.union(ds.sets[8],ds.sets[7]);
		
		ds.union(ds.sets[0],ds.sets[6]);
		
		for(int i=0;i<n;i++)
			System.out.println(arr[i]+" -->"+ds.sets[i].parent.data);
	}

}
