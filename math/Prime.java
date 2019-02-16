package math;

public class Prime {

	public boolean isPrime(int n)
	{
		if(n==0 || n==1)
			return false;
		
		if(n==2 || n==3)
			return true;
		
		if(n%2==0 || n%3==0)
			return false;
		
		int i=5;
		while(i*i<=n)
		{
			if(n%i==0 || n%(i+2)==0)
				return false;
			
			i=i+6;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Prime p=new Prime();
		for(int i=0;i<=100;i++)
		{
			System.out.println(i+" "+p.isPrime(i));
		}
	}

}
