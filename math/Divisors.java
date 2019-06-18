package math;

import java.util.*;


public class Divisors {

	public static Set<Long> divisors(long n)
	{
		Set<Long> divisors=new TreeSet<Long>();
		
		for(long i=1;i*i<=n;i++)
		{
			if(n%i==0)
			{
				divisors.add(i);
				divisors.add(n/i);
			}
		}
			
		return divisors;
		
	}
	
	public static long[] divisors2(long n)
	{
		long temp[]=new long[2*(int)Math.sqrt(n)];
		
		int x=0;
		for(long i=1;i*i<=n;i++)
		{
			if(n%i==0)
			{
				temp[x++]=i;
				
				if(i!=n/i)
					temp[x++]=n/i;
			}
		}
		
		long divisors[]=new long[x];
		for(int i=0,j=x-1;i<x;)
		{
			divisors[i/2]=temp[i];
			
			if(i+1<x)
				divisors[x-1-i/2]=temp[i+1];
			
			i+=2;
			
		}
		
		
		return divisors;
	}
	
	 public static void main(String args[]){
		// TODO Auto-generated method stub

		int n=103;
		
		Set<Long> arr;
		Iterator<Long> iterator;
		
		/*for(int i=1;i<=n;i++)
		{
			arr=factors(i);
			iterator=arr.iterator();
			
			System.out.print(i+" --> ");
			while(iterator.hasNext())
				System.out.print(iterator.next()+" ");
			
			System.out.println();
		}*/
		
		long arr2[];
		for(int i=1;i<=n;i++)
		{
			arr2=divisors2(i);
			
			for(int j=0;j<arr2.length;j++)
				System.out.print(arr2[j]+" ");
			
			System.out.println();
		}
		
		arr2=divisors2(545544644);
		
		for(int i=0;i<arr2.length;i++)
			System.out.print(arr2[i]+" ");
	}

}
