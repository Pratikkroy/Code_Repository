package dynamic_programming;

public class LongestPalindromicSubsequence {

	public int dp[][];
	
	public int lps_it(String s,int n)
	{
		dp=new int[n+1][n+1];
		
		for(int i=1;i<=n;i++)
			dp[i][i]=1;
		
		int j=0;
		for(int l=2;l<=n;l++)
		{
			for(int i=1;i<=n-l+1;i++)
			{
				j=i+l-1;
				
				if(s.charAt(i-1)==s.charAt(j-1) && l==2)
					dp[i][j]=2;
				else if(s.charAt(i-1)==s.charAt(j-1))
					dp[i][j]=2+dp[i+1][j-1]; 
				else
					dp[i][j]=max(dp[i][j-1],dp[i+1][j]);
			}
		}
		return dp[1][n];
	}
	
	public int lps_rec(String s,int l,int r)
	{
		if(dp[l+1][r+1]!=0)
			return dp[l+1][r+1];
		
		if(l==r)
			return dp[l+1][r+1]=1;
		
		if(s.charAt(l)==s.charAt(r) && r==l+1)
			return dp[l+1][r+1]=2;
			
		if(s.charAt(l)==s.charAt(r))
			return dp[l+1][r+1]=2+lps_rec(s,l+1,r-1);
		
		return dp[l+1][r+1]=max(lps_rec(s,l+1,r),lps_rec(s,l,r-1));
	}
	
	public int max(int a,int b)
	{
		return a>b?a:b;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s="ABDBDABC";
		int n=s.length();
		
		LongestPalindromicSubsequence lps=new LongestPalindromicSubsequence();
		
		lps.dp=new int[n+1][n+1];
		
		//System.out.println(lps.lps_rec(s, 0, n-1));
		
		//print2D(lps.dp);
		
		System.out.println(lps.lps_it(s, n));
		print2D(lps.dp);
		
	}
	
	public static void print2D(int arr[][])
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

}
