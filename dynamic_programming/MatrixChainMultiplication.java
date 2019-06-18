package dynamic_programming;

public class MatrixChainMultiplication {

	public int dp[][];
	private final int VERY_BIG_NUMBER=1000000000;
	
	public int mcm_rec(int p[],int i,int j)
	{
		if(i>=j)
			return dp[i][j]=0;
		
		if(dp[i][j]!=VERY_BIG_NUMBER)
			return dp[i][j];
		
		int cost=0;
		int min=VERY_BIG_NUMBER;
		
		for(int k=i;k<j;k++)
		{
			cost=mcm_rec(p,i,k)+mcm_rec(p,k+1,j)+p[i-1]*p[k]*p[j];
			
			if(cost<min)
				min=cost;
		}
		
		return dp[i][j]=min;
	}
	
	public int mcm_it(int p[],int n)
	{
		dp=new int[n+1][n+1];
		
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(i==j)
					dp[i][j]=0;
				else
					dp[i][j]=VERY_BIG_NUMBER;
			}
		}
		
		int cost=0;
		int j=0;
		for(int l=2;l<=n;l++)
		{
			for(int i=1;i<=n-l+1;i++)
			{
				j=i+l-1;
				
				for(int k=i;k<j;k++)
				{
					cost=dp[i][k]+dp[k+1][j]+p[i-1]*p[k]*p[j];
					
					if(cost<dp[i][j])
						dp[i][j]=cost;
				}
			}
		}
		
		return dp[1][n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[]= {10,5,20,30,10};
		int n=arr.length-1;
		
		MatrixChainMultiplication mcm=new MatrixChainMultiplication();
		
		mcm.dp=new int[n+1][n+1];
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(i==j)
					mcm.dp[i][j]=0;
				else
					mcm.dp[i][j]=1000000000;
			}
		}
		System.out.println(mcm.mcm_rec(arr, 1, n));
		
		System.out.println(mcm.mcm_it(arr, n));
	}

}
