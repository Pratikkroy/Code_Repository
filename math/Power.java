package math;

public class Power {

	// exp>=0
	public int power_rec(long base,int exp,int MOD)
    {
    	if(exp==0)
    		return 1;
    	
    	if(exp%2==0)
    		return power_rec(base*base,exp/2,MOD)%MOD;
    	
    	return ((int)base*power_rec(base*base,exp/2,MOD))%MOD;
    		
    }
	
	public int power_it(long base, int exp, int MOD)
	{		
		long result=1;
		
		while(exp>0)
		{
			if(exp%2==1)
				result=(result*base)%MOD;
			
			base=(base*base)%MOD;
			exp=exp/2;
		}
		
		return (int)result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(new Power().power_it(2,10, 1000000007));
	}

}
