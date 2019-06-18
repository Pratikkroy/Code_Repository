package math;



public class SieveOfErantosthenes {
	
	public static int[] sieve(int n)
	{
		int arr[]=new int[n+1];
		
		arr[0]=1;
		arr[1]=1;
		for(int i=2;i*i<=n;i++)
		{
			if(arr[i]==0)
			{
				for(int j=i*i;j<=n;j=j+i)
				{
					if(arr[j]==0)
						arr[j]=1;
				}
			}
		}
		
		// if want only the prime numbers then
		/*	ArrayList<Integer> prime=new ArrayList<Integer>();
		 *  for(int i=2;i<=n;i++)
		 *  	if(arr[i]==0)
		 *  		prime.add(arr[i]);
		 */
		return arr;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n=12;
		
		int prime[]=sieve(n);
		
		for(int i=2;i<=n;i++)
		{
			if(prime[i]==0)
				System.out.println(i+" "+Prime.isPrime(i));
		}
	}

}
