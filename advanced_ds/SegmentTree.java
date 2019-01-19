package advanced_ds;



public class SegmentTree {

	public int st[];
	public int lazy[];
	public int size;
	int MAX_SIZE;
	
	public void buildTree(int arr[],int size)
	{
		int x=(int)Math.ceil(Math.log(size+1)/Math.log(2));
		
		MAX_SIZE=(int)Math.pow(2,x+1)-1;
		
		st=new int[MAX_SIZE];
		this.size=size;
		
		buildTreeUtil(arr,0,size,0);
		
		lazy=new int[MAX_SIZE];
		for(int i=0;i<MAX_SIZE;i++)
			lazy[i]=0;
	}
	
	private void buildTreeUtil(int arr[],int s,int e,int root)
	{
		if(s==e)
			st[root]=arr[s];
		else
		{
			int mid=(s+e)/2;
			
			buildTreeUtil(arr,s,mid,2*root+1);
			buildTreeUtil(arr,mid+1,e,2*root+2);
			
			st[root]=st[2*root+1]+st[2*root+2];
		}
	}
	
	public int sum(int qs,int qe)
	{
		if(qs<0 || qe>size || qe<qs)
			return -1;
		
		return sumUtil(qs,qe,0,size,0);
	}
	
	private int sumUtil(int qs,int qe,int s,int e,int root)
	{
		if(lazy[root]!=0)
		{
			st[root]+=(e-s+1)*lazy[root];
			
			if(s!=e)
			{
				lazy[2*root+1]+=lazy[root];
				lazy[2*root+2]+=lazy[root];
			}
			
			lazy[root]=0;
		}
		
		if(s>=qs && e<=qe)
			return st[root];
		
		if(e<qs || s>qe || s>e)
			return 0;
		
		int mid=(s+e)/2;
		
		return sumUtil(qs, qe, s, mid, 2*root+1)+sumUtil(qs,qe,mid+1,e,2*root+2);
		
	}
	
	public void update(int index,int diff)
	{
		if(index<0 || index>size)
			return;
		
		updateUtil(0,size,0,index,diff);
	}
	
	private void updateUtil(int s,int e,int root,int index,int diff)
	{
		if(lazy[root]!=0)
		{
			st[root]+=(e-s+1)*lazy[root];
			
			if(s!=e)
			{
				lazy[2*root+1]+=lazy[root];
				lazy[2*root+2]+=lazy[root];
			}
			
			lazy[root]=0;
		}
		
		if(index<s || index>e || s>e)
			return;
		
		if(s==e)
		{
			if(s==index)
				st[root]=st[root]+diff;
			
			return;
		}
			
		int mid=(s+e)/2;
		
		if(index<=mid)
			updateUtil(0,mid,2*root+1, index, diff);
		else
			updateUtil(mid+1, e, 2*root+2, index, diff);
		
		st[root]=st[2*root+1]+st[2*root+2];
		
	}
	
	public void updateRange(int qs,int qe,int diff)
	{
		if(qs<0 || qe>size || qe>qs)
			return;
		
		updateRangeUtil(0, size, 0, qs, qe, diff);
	}
	
	private void updateRangeUtil(int s,int e,int root,int qs,int qe,int diff)
	{
		if(lazy[root]!=0)
		{
			st[root]+=(e-s+1)*lazy[root];
			
			if(s!=e)
			{
				lazy[2*root+1]+=lazy[root];
				lazy[2*root+2]+=lazy[root];
			}
			
			lazy[root]=0;
		}
		
		if(s>qe || e<qs || s>e)
			return;
		
		if(s>=qs && e<=qe)
		{
			st[root]+=(e-s+1)*diff;
			
			if(s!=e)
			{
				lazy[2*root+1]+=diff;
				lazy[2*root+2]+=diff;
			}
			return;
		}
		
		int mid=(s+e)/2;
		updateRangeUtil(s, mid, 2*root+1, qs, qe, diff);
		updateRangeUtil(mid+1, e, 2*root+2, qs, qe, diff);
		
		st[root]=st[2*root+1]+st[2*root+2];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[]= {1,3,5,7,9,11};
		int n=arr.length;
		
		SegmentTree tree=new SegmentTree();
		
		tree.buildTree(arr, n-1);
		
		//for(int i=0;i<tree.st.length;i++)
			//System.out.println(tree.st[i]+" ");
		
		System.out.println(tree.sum(1,4));
		tree.update(1, 4);
		System.out.println(tree.sum(1,4));
	}

}
