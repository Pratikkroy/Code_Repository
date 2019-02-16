package math;

public class HCF {

	public long hcf(long a, long b)
	{
		if(b==0)
			return a;
		
		return (hcf(b,a%b));
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(new HCF().hcf(5,10));

	}

}
