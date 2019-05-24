package advanced_ds;

public class BinaryIndexedTree {

	public int BIT[];
	public int size;
	
	public void buildTree(int arr[],int size)
	{
		this.size=size+1;
		
		BIT=new int[size+2];
		
		for(int i=0;i<=size;i++)
			update(i+1,arr[i]);
	}
	
	public void update(int index,int value)
	{
		while(index<=size)
		{
			BIT[index]=BIT[index]+value;
			
			index=index+(index&(-index));
		}
	}
	
	public int sum(int index)
	{
		int sum=0;
		
		index++;
		while(index>0)
		{
			sum=sum+BIT[index];
			
			index=index-(index&(-index));
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[]= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		int n=arr.length;
		
		BinaryIndexedTree tree=new BinaryIndexedTree();
		
		tree.buildTree(arr, n-1);
		
		//for(int i=0;i<tree.st.length;i++)
			//System.out.println(tree.st[i]+" ");
		
		System.out.println(tree.sum(4));
		tree.update(1, 4);
		System.out.println(tree.sum(4));
	}

}
