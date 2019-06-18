package sorting;

public class MergeSort {

	private void merge(int arr[],int l,int mid,int r)
	{
		int result[]=new int[r-l+1];
		
		int i=l;
		int j=mid+1;
		int x=0;
		
		while(i<=mid && j<=r )
		{
			if(arr[i]<arr[j])
			{
				result[x]=arr[i];
				i++;
			}
			else
			{
				result[x]=arr[j];
				j++;
			}
			
			x++;
		}
		
		while(i<=mid)
		{
			result[x]=arr[i];
			i++;
			x++;
		}
		
		while(j<=r)
		{
			result[x]=arr[j];
			j++;
			x++;
		}
		
		for(i=l;i<=r;i++)
			arr[i]=result[i-l];
	}
	public void mergesort(int arr[],int l,int r)
	{
		if(l<r)
		{
			int mid=(l+r)/2;
			
			mergesort(arr,l,mid);
			mergesort(arr,mid+1,r);
			merge(arr,l,mid,r);
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
		
		new MergeSort().mergesort(arr, 0, n-1);
		
		System.out.print("Array After Sorting :: ");
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
	}

}
