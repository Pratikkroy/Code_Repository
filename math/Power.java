package math;

public class Power {

	// exp>=0
	public int power(long base,int exp,int MOD)
    {
    	if(exp==0)
    		return 1;
    	
    	if(exp%2==0)
    		return power(base*base,exp/2,MOD)%MOD;
    	
    	return ((int)base*power(base*base,exp/2,MOD))%MOD;
    		
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(new Power().power(2,21, 1000000007));
	}

}
