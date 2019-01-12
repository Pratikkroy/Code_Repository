package basic_ds;

public class Stack {

	private int top;
	private int stack[];
	private int MAX_SIZE;
	
	Stack(int max)
	{
		MAX_SIZE=max;
		stack=new int[MAX_SIZE];
		
		top=-1;
	}
	
	public boolean push(int value)
	{
		if(top>MAX_SIZE-2)
			return false;
		
		top++;
		stack[top]=value;
		
		return true;
	}
	
	public int pop()
	{
		if(top==-1)
			return -1;
		
		int result=stack[top];
		
		stack[top]=0;
		top--;
		
		return result;
	}
	
	public int getTopElement()
	{
		if(top==-1)
			return -1;
		
		return stack[0];
	}
	
	public int size()
	{
		return top+1;
	}
	
	public boolean isEmpty()
	{
		return top==-1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack stack=new Stack(0);
		
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		
		while(!stack.isEmpty())
		{
			System.out.println(stack.pop());
		}
	}

}
