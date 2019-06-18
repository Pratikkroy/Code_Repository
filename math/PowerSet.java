package math;

public class PowerSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]= {1,2,3};
		
		int n=arr.length;
		long k=(long)Math.pow(2, n);
		int i,j;
		
		for(i=0; i<k;i++)
		{
			System.out.print("{ ");
			for(j=0;j<n;j++)
			{
				if((1<<j & i)>0)
					System.out.print(arr[j]+" ");
			}
			System.out.println("}");
		}

	}

}
