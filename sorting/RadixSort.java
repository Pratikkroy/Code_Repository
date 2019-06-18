package sorting;

public class RadixSort {

	public void radixsort(int arr[],int n)
	{		
		//finding max
		int max=arr[0];
		for(int i=1;i<=n;i++)
		{
			if(arr[i]>max)
				max=arr[i];
		}
		
		for(int exp=1;max/exp>0;exp=exp*10)
		{
			countsort(arr, n, exp);
		}
			
	}
	
	public void countsort(int arr[],int n,int exp)
	{
		int count[]=new int[10];
		
		for(int i=0;i<=n;i++)
		{
			count[(arr[i]/exp)%10]++;
		}
		
		for(int i=1;i<=9;i++)
		{
			count[i]=count[i]+count[i-1];
		}
		
		for(int i=0;i<=9;i++)
		{
			count[i]--;
		}
		
		int result[]=new int[n+1];
		for(int i=n;i>=0;i--)
		{
			result[count[(arr[i]/exp)%10]]=arr[i];
			
			count[(arr[i]/exp)%10]--;
		}
		
		for(int i=0;i<=n;i++)
			arr[i]=result[i];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[]= {5,9,2,7,1,8,3,7};
		int n=arr.length;
		
		System.out.print("Array Before Sorting :: ");
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
		
		System.out.println();
		
		new RadixSort().radixsort(arr,n-1);
		
		System.out.print("Array After Sorting :: ");
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
	}

}
