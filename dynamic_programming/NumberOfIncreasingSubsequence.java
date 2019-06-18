package dynamic_programming;

public class NumberOfIncreasingSubsequence {

	public int dp[];
	public int numberofIncreasingSubsequences_it(int arr[],int n)
	{
		dp=new int[n+1];
		
		for(int i=0;i<=n;i++)
			dp[i]=1;
		
		for(int i=1;i<=n;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(arr[i]>arr[j])
					dp[i]+=dp[j];
			}
		}
		
		int sum=0;
		for(int i=0;i<=n;i++)
			sum+=dp[i];
		
		return sum;
	}
	
	public int numberofIncreasingSubsequences_it2(int arr[],int n)
	{
		int max=0;
		for(int i=0;i<n;i++)
		{
			if(arr[i]>max)
				max=arr[i];
		}
		
		int count[]=new int[max+1];
		int sum=0;
		for(int i=0;i<n;i++)
		{
			count[arr[i]]++;
			for(int j=arr[i]-1;j>=0;j--)
			{
				count[arr[i]]+=count[j];
				sum+=count[j];
			}	
			
			sum++;
		}
		
		/*for(int i=0;i<=max;i++)
		{
			sum+=count[i];
		}*/
		
		return sum;
	}
	
	public int numberofIncreasingSubsequences_rec(int arr[],int r)
	{
		if(r==0)
			return 1;
		
		int count=0;
		
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<=i;j++)
			{
				if(arr[i]>arr[j])
				{
					count+=1+numberofIncreasingSubsequences_rec(arr,r-1);
				}
				else
					count+=numberofIncreasingSubsequences_rec(arr,r-1);
			}		
			
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[]= {3, 2, 4, 5, 4};// {2,6,4,5,7};
		int n=arr.length;
		
		NumberOfIncreasingSubsequence is=new NumberOfIncreasingSubsequence();
		System.out.println(is.numberofIncreasingSubsequences_it(arr, n-1));
		
		is.dp=new int[n];
		
		//for(int i=0;i<n;i++)
			
		//recursion method is wrong
		System.out.println(is.numberofIncreasingSubsequences_rec(arr, n-1));
		
		System.out.println(is.numberofIncreasingSubsequences_it2(arr, n));
	}

}
