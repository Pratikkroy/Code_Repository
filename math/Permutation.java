package math;

public class Permutation {

	public void permutate(int arr[],int s, int e)
	{
		if(s==e)
		{
			for(int i=0;i<arr.length;i++)
				System.out.print(arr[i]+" ");
			
			System.out.println();
		}
		for(int i=s;i<=e;i++)
		{
			swap(arr,s,i);
			permutate(arr,s+1,e);
			swap(arr,s,i);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]= {1,2,3,4};
		
		new Permutation().permutate(arr,0,arr.length-1);

	}

	public void swap(int arr[],int x,int y)
	{
		int temp=arr[x];
		arr[x]=arr[y];
		arr[y]=temp;
	}
}
