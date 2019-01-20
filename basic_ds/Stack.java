package basic_ds;

public class Stack {

	public int MAX_SIZE;
	private int top;
	private int stack[];
	
	
	public Stack(int max)
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
	
	public boolean isFull()
	{
		return (top+1)==MAX_SIZE;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack stack=new Stack(5);
		
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		
		System.out.println(stack.isFull());
		
		while(!stack.isEmpty())
		{
			System.out.println(stack.pop()+" "+stack.isFull());
		}
	}

}
