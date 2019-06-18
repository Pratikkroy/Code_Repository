package string;

public class NaiveSearch {

	public static boolean search(String text,String pattern)
	{
		if(text.length()<pattern.length())
			return false;
		
		if((text.length()==0 && pattern.length()==0) || pattern.length()==0)
			return true;
		
		for(int i=0;i<text.length();i++)
		{
			for(int j=0;j<pattern.length();j++)
			{
				if(text.charAt(i+j)!=pattern.charAt(j))
					break;
			}
			
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String text="absefabdbcaecklmnabcmnvgb";
		String pattern="abc";
		
		System.out.println(search(text,pattern));
	}

}
