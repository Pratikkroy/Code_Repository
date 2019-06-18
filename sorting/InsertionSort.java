package sorting;

public class InsertionSort {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		int arr[]= {5,9,2,7,1,8,3,7};
		int n=arr.length;
		
		System.out.print("Array Before Sorting :: ");
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
		
		System.out.println();
		
		int j=0;
		int key=0;
		for(int i=1;i<=n-1;i++)
		{
			key=arr[i];
			j=i-1;
			while(j>=0 && arr[j]>key)
			{
				arr[j+1]=arr[j];
				j--;
			}
			
			arr[j+1]=key;
		}
		
		
		System.out.print("Array After Sorting :: ");
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
	}

}
