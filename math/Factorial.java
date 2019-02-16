package math;

public class Factorial {

	long dp[];
	
	public int factorial_it(int n,int MOD)
	{
		long result=1;
		
		while(n>1)
		{
			result=(result*n)%MOD;
			n--;
		}
		
		return (int)result;
	}
	
	public int factorial_rec(long n,int MOD)
	{
		if(n==0)
			return 1;
		
		return (int)((n*factorial_rec(n-1, MOD))%MOD);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Factorial f=new Factorial();
		
		for(int i=0;i<=10;i++)
			System.out.println(f.factorial_rec(i,1000000007));
	}

}
