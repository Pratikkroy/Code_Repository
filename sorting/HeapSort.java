package sorting;

public class HeapSort {

	
	public void heapsort(int arr[],int n)
	{
		// build max heap
		for(int index=(n-1)/2;index>=0;index--)
			maxHeapify(arr,n,index);
		
		// heap sort
		for(int index=n;index>0;index--)
		{
			swap(arr,index,0);
			
			maxHeapify(arr,index-1, 0);
		}
	}
	
	private void maxHeapify(int arr[],int size,int root)
	{
		int max=root;
		int lChild=2*root+1;
		int rChild=2*root+2;
		
		if(lChild<=size && arr[max]<arr[lChild])
			max=lChild;
		
		if(rChild<=size && arr[max]<arr[rChild])
			max=rChild;
		
		if(max!=root)
		{
			swap(arr,max,root);
			
			maxHeapify(arr,size,max);
		}
	}
	
	private void swap(int arr[],int x,int y)
	{
		if(arr[x]!=arr[y])
		{
			arr[x]=arr[x]^arr[y];
			arr[y]=arr[x]^arr[y];
			arr[x]=arr[x]^arr[y];
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]= {5,9,2,7,1,8,3,7};
		int n=arr.length;
		
		System.out.print("Array Before Sorting :: ");
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
		
		System.out.println();
		
		new HeapSort().heapsort(arr,n-1);
		
		System.out.print("Array After Sorting :: ");
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
	}

}
