package math;

public class ExtendedEuclid {

	static int d, x, y;
	static int temp;
	
	static void extendedEuclid(int a, int b) {
	    if(b == 0) {
	        d = a;
	        x = 1;
	        y = 0;
	    }
	    else {
	        extendedEuclid(b, a%b);
	        temp = x;
	        x = y;
	        y = temp - (a/b)*y;
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a=10,b=16;
		
		extendedEuclid(a, b);
		System.out.println(" GCD of ( "+a+","+b+" ) --> "+d);
		System.out.println(" x = "+x+","+" y = "+y);
	}

}
