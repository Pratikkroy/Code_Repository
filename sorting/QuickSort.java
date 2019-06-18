package sorting;

public class QuickSort {

	private int selectPivot(int arr[],int l,int r)
	{
		int pivot=l;
		
		for(int i=l;i<r;i++)
		{
			if(arr[i]<arr[r])
			{
				if(i!=pivot)
					swap(arr,pivot,i);
				pivot++;
			}
		}
		
		swap(arr,pivot,r);
		
		return pivot;
	}
	
	public void quicksort(int arr[],int l,int r)
	{
		if(l<r)
		{
			int pivot=selectPivot(arr, l, r);
			
			
			quicksort(arr,l,pivot-1);
			quicksort(arr,pivot+1,r);
		}
		
	}
	
	private static void swap(int arr[],int x,int y)
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
		
		int arr[]= {1,2,3,11,12};
		int n=arr.length;
		
		System.out.print("Array Before Sorting :: ");
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
		
		System.out.println();
		
		new QuickSort().quicksort(arr, 0, n-1);
		
		System.out.print("Array After Sorting :: ");
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
	}

}
