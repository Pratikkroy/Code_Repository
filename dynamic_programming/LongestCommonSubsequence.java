package dynamic_programming;

public class LongestCommonSubsequence {

	public int dp[][];
	
	public int lcs_it(String s1,int n1,String s2,int n2)
	{
		dp=new int[n1+1][n2+1];
		
		for(int i=0;i<=n1;i++)
			dp[i][0]=0;
		
		for(int i=0;i<=n2;i++)
			dp[0][i]=0;
		
		for(int i=1;i<=n1;i++)
		{
			for(int j=1;j<=n2;j++)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
					dp[i][j]=dp[i-1][j-1]+1;
				else
					dp[i][j]=max(dp[i][j-1],dp[i-1][j]);
			}
		}
		
		return dp[n1][n2];
	}
	
	public int lcs_rec(String s1,int l1,String s2,int l2)
	{
		if(l1==s1.length() || l2==s2.length())
			return 0;
		
		if(dp[l1+1][l2+1]!=0)
			return dp[l1+1][l2+1];
		
		if(s1.charAt(l1)==s2.charAt(l2))
			return dp[l1+1][l2+1]=1+lcs_rec(s1,l1+1,s2,l2+1);
		
		return dp[l1+1][l2+1]=max(lcs_rec(s1,l1+1,s2,l2),lcs_rec(s1,l1,s2,l2+1));
	}
	
	public void printLCS()
	{
		
	}
	public int max(int a,int b)
	{
		return a>b?a:b;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1="AGGTAB";
		String s2="GXTXAYB";
		
		LongestCommonSubsequence lcs=new LongestCommonSubsequence();
		
		lcs.dp=new int[s1.length()+1][s2.length()+1];
		System.out.println(lcs.lcs_rec(s1, 0, s2, 0));
		
		System.out.println(lcs.lcs_it(s1, s1.length(), s2, s2.length()));
	}

}
