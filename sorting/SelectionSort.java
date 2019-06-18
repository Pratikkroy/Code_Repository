package sorting;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[]= {5,9,2,7,1,8,3,7};
		int n=arr.length;
		
		System.out.print("Array Before Sorting :: ");
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
		
		System.out.println();
		
		int minIndex=0;
		for(int i=0;i<=n-2;i++)
		{
			minIndex=i;
			for(int j=i+1;j<=n-1;j++)
			{
				if(arr[j]<arr[minIndex])
					minIndex=j;
			}
			swap(arr,i,minIndex);
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
