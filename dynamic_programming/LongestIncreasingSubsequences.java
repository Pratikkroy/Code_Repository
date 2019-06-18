package dynamic_programming;

public class LongestIncreasingSubsequences {

	public int lis(int arr[],int n)
	{
		int dp[]=new int[n+1];
		
		for(int i=0;i<=n;i++)
			dp[i]=1;
		
		for(int i=1;i<=n;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(arr[j]<arr[i] && dp[i]<dp[j]+1)
				{
					dp[i]=dp[j]+1;
				}
			}
		}
		
		int max=dp[0];
		for(int i=1;i<=n;i++)
		{
			if(dp[i]>max)
				max=dp[i];
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]= {10,22,9,33,21,50,41,60};
		int n=arr.length;
		
		System.out.println(new LongestIncreasingSubsequences().lis(arr, n-1));

	}

}
