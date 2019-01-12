package basic_ds;

class MaxHeap
{
	private int arr[];
	private int size;
	private int MAX_SIZE;
	
	public MaxHeap(int maxSize)
	{
		MAX_SIZE=maxSize;
		arr=new int[MAX_SIZE];
		
		size=-1;
	}
	
	public void buildMaxHeap(int arr[],int n)
	{
		size=n;
		for(int i=0;i<=size;i++)
			this.arr[i]=arr[i];
		
		for(int index=(size-1)/2;index>=0;index--)
			maxHeapify(size,index);
	}
	
	public void heapSort()
	{
		for(int index=size;index>0;index--)
		{
			swap(arr,index,0);
			
			maxHeapify(index-1, 0);
		}
	}
	
	public int extractMax()
	{
		int max=arr[0];
		
		delete(0);
		
		return max;
	}
	
	public int getMax()
	{
		return arr[0];
	}
	
	public void insert(int value)
	{
		size=size+1;
		arr[size]=value;
		
		
		int child=size;
		int parent=(child-1)/2;
		
		while(parent>=0 && arr[parent]<arr[child])
		{
			swap(arr,parent,child);
			
			child=parent;
			parent=(child-1)/2;
		}
	}
	
	public int delete(int index)
	{
		if(index<0 || index>size)
			return -1;
		
		int currentValue=arr[index];
		int newValue=arr[size];
		
		arr[size]=0;
		size=size-1;
		
		if(newValue>currentValue)
			increaseKey(index, newValue);
		else if(newValue<currentValue)
			decreaseKey(index, newValue);
		
		return currentValue;
	}
	
	public void increaseKey(int index,int value)
	{
		if(index<0 || index>size)
			return;
		
		arr[index]=value;
		
		int child=index;
		int parent=(child-1)/2;
		
		while(parent>=0 && arr[parent]<arr[child])
		{
			swap(arr,parent,child);
			
			child=parent;
			parent=(child-1)/2;
		}
	}
	
	public void decreaseKey(int index,int value)
	{
		if(index<0 || index>size)
			return;
		
		arr[index]=value;
		
		maxHeapify(size, index);
	}
	
	public int find(int value)
	{
		return findUtil(0,value);
	}
	
	private int findUtil(int root,int value)
	{
		if(root>size || arr[root]<value)
			return -1;
		
		if(arr[root]==value)
			return root;
		
		int index=-1;
		int lChild=2*root+1;
		if(lChild<=size)
			index=findUtil(lChild,value);
		
		int rChild=2*root+2;
		if(index==-1 && rChild<=size)
			index=findUtil(rChild,value);
		
		return index;
	}
	
	// here size is used as a parameter only because of the call in heapSort method.
	public void maxHeapify(int size,int root)
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
			
			maxHeapify(size,max);
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
}

public class Heap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[]= {6,3,3,9,4,2,10,8,4};
		int n=arr.length;    // heap size
		
		MinHeap heap=new MinHeap(100);
		
		heap.buildMinHeap(arr,n-1);
		//heap.heapSort();
		//heap.delete(1);
		heap.insert(1);
		heap.insert(11);
		heap.delete(heap.find(2));
		//heap.decreaseKey(1, 1);
		
		for(int i=0;i<=heap.size;i++)
			System.out.print(heap.arr[i]+" ");
		
		System.out.println();
		for(int i=0;i<=heap.size;i++)
			System.out.println(heap.arr[i]+" --> "+heap.find(heap.arr[i]));
	}

}

class MinHeap
{
	public int arr[];
	public int size;
	private int MAX_SIZE;
	
	public MinHeap(int maxSize) 
	{
		MAX_SIZE=maxSize;
		arr=new int[MAX_SIZE];
		
		size=-1;
	}
	
	public void buildMinHeap(int arr[],int n)
	{
		size=n;
		for(int i=0;i<=size;i++)
			this.arr[i]=arr[i];
		
		for(int index=(size-1)/2;index>=0;index--)
			minHeapify(size,index);
	}
	
	public void heapSort()
	{
		for(int index=size;index>0;index--)
		{
			swap(arr,index,0);
			
			minHeapify(index-1, 0);
		}
	}
	
	public int extractMin()
	{
		int min=arr[0];
		
		delete(0);
		
		return min;
	}
	
	public int getMin()
	{
		return arr[0];
	}
	
	public void insert(int value)
	{
		size=size+1;
		arr[size]=value;
		
		int child=size;
		int parent=(child-1)/2;
		
		while(parent>=0 && arr[parent]>arr[child])
		{
			swap(arr,parent,child);
			
			child=parent;
			parent=(child-1)/2;
		}
	}
	
	public int delete(int index)
	{
		if(index<0 || index>size)
			return -1;
		
		int currentValue=arr[index];
		int newValue=arr[size];
		
		arr[size]=0;
		
		size=size-1;
		
		if(newValue>currentValue)
			increaseKey(index, newValue);
		else if(newValue<currentValue)
			decreaseKey(index, newValue);
		
		return currentValue;
	}
	
	public void increaseKey(int index,int value)
	{
		if(index<0 || index>size)
			return;
		
		arr[index]=value;
		
		minHeapify(size, index);
	}
	
	public void decreaseKey(int index,int value)
	{
		if(index<0 || index>size)
			return;
		
		arr[index]=value;
		
		int child=index;
		int parent=(child-1)/2;
		
		while(parent>=0 && arr[parent]>arr[child])
		{
			swap(arr,parent,child);
			
			child=parent;
			parent=(child-1)/2;
		}
	}
	
	public int find(int value)
	{
		return findUtil(0,value);
	}
	
	private int findUtil(int root,int value)
	{
		if(root>size || arr[root]>value)
			return -1;
		
		if(arr[root]==value)
			return root;
		
		int index=-1;
		int lChild=2*root+1;
		if(lChild<=size)
			index=findUtil(lChild,value);
		
		int rChild=2*root+2;
		if(index==-1 && rChild<=size)
			index=findUtil(rChild,value);
		
		return index;
	}
	
	
	public void minHeapify(int size,int root)
	{
		int min=root;
		int lChild=2*root+1;
		int rChild=2*root+2;
		
		if(lChild<=size && arr[min]>arr[lChild])
			min=lChild;
		
		if(rChild<=size && arr[min]>arr[rChild])
			min=rChild;
		
		if(min!=root)
		{
			swap(arr,min,root);
			
			minHeapify(size,min);
		}
	}
	
	public boolean isHeap(int arr[],  int n)
	{
	    // Start from root and go till the last internal
	    // node
	    for (int i=0; i<=(n-1)/2; i++)
	    {
	        // If left child is greater, return false
	        if (2*i+1<=n && arr[2*i +1] < arr[i])
	        {       
	        	return false;
	        }
	 
	        // If right child is greater, return false
	        if (2*i+2<=n && arr[2*i+2] < arr[i])
	        {
	        	return false;
	        }
	    }
	    return true;
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
}
