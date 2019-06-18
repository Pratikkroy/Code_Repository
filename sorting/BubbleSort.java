package sorting;

public class BubbleSort {
	
	public static void main(String args[])
	{
		int arr[]= {5,9,2,7,1,8,3,7};
		int n=arr.length;
		
		System.out.print("Array Before Sorting :: ");
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
		
		System.out.println();
		
		for(int i=n-2;i>=0;i--)
		{
			for(int j=0;j<=i;j++)
			{
				if(arr[j]>arr[j+1])
					swap(arr,j,j+1);
			}
		}
		
		
		System.out.print("Array After Sorting :: ");
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
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

}
