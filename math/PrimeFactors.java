package math;

import java.util.*;

public class PrimeFactors {

	public static Set<Long>  primeFactors(long n)
	{
		Set<Long> primeFactors =new TreeSet<Long>();
		long i=2;
		
		while(i*i<=n)
		{
			if(n%i==0)
			{
				primeFactors.add(i);
				
				while(n%i==0)
					n=n/i;
			}
			
			if(i==2)
				i=3;
			else
				i=i+2;
				
		}
		
		if(n>=2)
			primeFactors.add(n);
		
		return primeFactors;
	}
	
	public static Set<Integer>  primeFactors_Sieve(int n)
	{
		Set<Integer> primeFactors=new TreeSet<Integer>();
		
		while(n!=1)
		{
			primeFactors.add(minPrime[n]);
			n=n/minPrime[n];
		}
		
		return primeFactors;
	}
	
	static int minPrime[];
	public static void sieve(int n)
	{
		minPrime=new int[n+1];
		minPrime[0]=0;
		minPrime[1]=1;
		
		for(int i=2;i*i<=n;i++)
		{
			if(minPrime[i]==0)
			{				
				for(int j=i*i;j<=n;j=j+i)
				{
					if(minPrime[j]==0)
						minPrime[j]=i;
				}
			}
		}
		
		for(int i=2;i<=n;i++)
		{
			if(minPrime[i]==0)
				minPrime[i]=i;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n=103;
		
		sieve(n);
		/*for(int i=0;i<=n;i++)
			System.out.println(i+" --> "+minPrime[i]);
		*/
		
		Set<Integer> arr;
		Iterator<Integer> iterator;
		
		for(int i=1;i<=n;i++)
		{
			arr=primeFactors_Sieve(i);
			iterator=arr.iterator();
			
			System.out.print(i+" --> ");
			while(iterator.hasNext())
				System.out.print(iterator.next()+" ");
			
			System.out.println();
		}
		
		
		
		arr=primeFactors_Sieve(n);
		iterator=arr.iterator();
		
		System.out.print(n+" --> ");
		while(iterator.hasNext())
			System.out.print(iterator.next()+" ");
		
		
		
	}
	
}
