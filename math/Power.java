package math;

public class Power {

	public static long power(long x, long y)
	{
		if(y==0)
			return 1;
		if(y%2==0)
			return power(x*x,y/2);
		
		return x*power(x*x,y/2);
	}
	
	public static long power_rec(long x,long y, int mod)
	{
		if(y==0)
			return 1;
		if(y%2==0)
			return power_rec((x*x)%mod,y/2,mod)%mod;
		
		return (x*power_rec((x*x)%mod,y/2,mod))%mod;
	}
	
	public static long power_it(long x,long y, int mod)
	{
		long result=1;
		
		while(y>0)
		{
			if(y%2==1)
				result=(result*x)%mod;
			x=(x*x)%mod;
			y=y/2;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<=10;i++)
		{
			//System.out.println(i+" --> "+(isPrime(i)?"Prime":"Not Prime"));
			System.out.println(i+" --> "+power(i,1));
		}
	}

}
