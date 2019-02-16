package math;

public class Combination {

	long dp[][];
	
	public long combination_rec(int n,int r)
	{
		// C(n,r)+C(n,r-1)=C(n+1,r)
		if(r<0 || r>n)
			return -1;
		
		dp=new long[n+1][r+1];
		
		return combination_rec_Util(n, r);	
	}
	
	private long combination_rec_Util(int n,int r)
	{
		if(r==0)
			return dp[n][r]=1;
		
		if(r==1)
			return dp[n][r]=n;
		
		if(n==r)
			return dp[n][r]=1;
		
		if(dp[n][r]==0)
			dp[n][r]=combination_rec_Util(n-1, r)+combination_rec_Util(n-1, r-1);
		
		return dp[n][r];
	}
	
	public long combination_it(int n,int r)
	{
		if(r<0 || r>n)
			return -1;
		
		r=r>n/2?n-r:r;
		long result=1;
		
		for(int i=1;i<=r;i++)
		{
			result=(result*(n+1-i))/i;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Combination c=new Combination();
		
		System.out.println(c.combination_it(10, 2));
	}

}
