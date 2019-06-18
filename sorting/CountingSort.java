package sorting;

public class CountingSort {
	
	public int[] countsort(int input[],int n)
	{
		int i=0;
		
		// finding max and min
		int max=input[0],min=input[0];
		for(i=1;i<=n;i++)
		{
			if(input[i]>max)
				max=input[i];
			
			if(input[i]<min)
				min=input[i];
		}
		
		int count[]=new int[max-min+1];
		
		for(i=0;i<=n;i++)
			count[input[i]-min]++;
		
		for(i=1;i<=max-min;i++)
			count[i]=count[i]+count[i-1];
		
		for(i=0;i<=max-min;i++)
			count[i]--;
		
		int output[]=new int[n+1];
		
		for(i=n;i>=0;i--)
		{
			output[count[input[i]-min]]=input[i];
			
			count[input[i]-min]--;
		}
		
		return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		int arr[]= {5,9,2,7,1,8,3,7};
		int n=arr.length;
		
		System.out.print("Array Before Sorting :: ");
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
		
		System.out.println();
		
		arr=new CountingSort().countsort(arr,n-1);
		
		System.out.print("Array After Sorting :: ");
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
	}

}
