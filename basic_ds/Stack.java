package basic_ds;

import exceptions.StackOverFlowException;
import exceptions.StackUnderFlowException;

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
	
	public boolean push(int value) throws StackOverFlowException
	{
		if(top>MAX_SIZE-2)
			throw new StackOverFlowException();
		
		top++;
		stack[top]=value;
		
		return true;
	}
	
	public int pop() throws StackUnderFlowException
	{
		if(top==-1)
			throw new StackUnderFlowException();
		
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

		Stack stack=new Stack(2);
		
		try {
			stack.push(10);
			stack.push(20);
			stack.push(30);
			stack.push(40);
			stack.push(50);
		} catch(Exception ex) {
			System.out.println("Exception occured:: "+ex.getMessage());
			ex.printStackTrace();
		}
		
		System.out.println(stack.isFull());
		
		while(!stack.isEmpty())
		{
			try {
				System.out.println(stack.pop()+" "+stack.isFull());	
			} catch(Exception ex) {
				System.out.println("Exception occured:: "+ex.getMessage());
				ex.printStackTrace();
			}
		}

		try {
			System.out.println(stack.pop()+" "+stack.isFull());	
		} catch(Exception ex) {
			System.out.println("Exception occured:: "+ex.getMessage());
			ex.printStackTrace();
		}
	}

}
