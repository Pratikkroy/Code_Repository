package dynamic_programming;

public class NumberOfIncreasingSubsequeneceOfLengthK {

	int dp[][];
	
	public int numberOfSubsequences(int arr[],int n,int k)
	{
		int sum=0;
		
		dp=new int[k+1][n+1];
		
		for(int i=1;i<=n;i++)
			dp[1][i]=1;
		
		for(int l=2;l<=k;l++)
		{
			for(int i=l;i<=n;i++)
			{
				for(int j=l-1;j<i;j++)
				{
					if(arr[i-1]>arr[j-1])
						dp[l][i]+=dp[l-1][k];
				}
			}
		}
		
		for(int i=n;i>=k;i--)
			sum+=dp[k][i];
		
		return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[]= {2,6,4,5,7};
		int n=arr.length;
		int k=3;
		
		NumberOfIncreasingSubsequeneceOfLengthK is=new NumberOfIncreasingSubsequeneceOfLengthK();
		
		System.out.println(is.numberOfSubsequences(arr, n, k));
	}

}
