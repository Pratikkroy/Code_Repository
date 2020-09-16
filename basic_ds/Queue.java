package basic_ds;

import exceptions.QueueOverFlowException;
import exceptions.QueueUnderFlowException;

public class Queue {

	public int MAX_SIZE;
	private int front,rear;
	private int queue[];
	
	public Queue(int size)
	{
		MAX_SIZE=size;
		queue=new int[MAX_SIZE];
		
		front=rear=-1;
	}
	
	public boolean enqueue(int value) throws QueueOverFlowException
	{
		if(front==-1) // empty queue
		{
			front=rear=0;
			
			queue[rear]=value;
			return true;
		}
		
		if(rear>=front)   // when rear==front ---> one element
		{
			if(rear-front+1==MAX_SIZE) //queue overflow
				throw new QueueOverFlowException();	
		}
		else if(front>rear)
		{
			if(front-rear==1)   // queue overflow
			throw new QueueOverFlowException();	
		}
		
		rear=(rear+1)%MAX_SIZE;
		
		queue[rear]=value;
		return true;
	}

	public int deque() throws QueueUnderFlowException
	{
		if(front==-1) //empty queue
			throw new QueueUnderFlowException();
		
		int result=queue[front];
		
		front=(front+1)%MAX_SIZE;
		
		if(front==(rear+1)%MAX_SIZE)
			front=rear=-1;
		
		return result;
	}
	
	public boolean isEmpty()
	{
		return front==-1;
	}
	
	public boolean isFull()
	{
		return size()==MAX_SIZE;
	}
	
	public int getFrontElement() throws QueueUnderFlowException
	{
		if(front==-1)
			throw new QueueUnderFlowException();
		
		return queue[front];
	}
	
	public int getLastElement() throws QueueUnderFlowException
	{
		if(front==-1)
			throw new QueueUnderFlowException();
		
		return queue[rear];
	}
	
	public int size()
	{
		if(front==-1)
			return 0;
		
		if(rear>=front)
			return rear-front+1;
		
		return rear+1+MAX_SIZE-front;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue q=new Queue(5);
		
		try {
			q.enqueue(1);
			q.enqueue(2);
			q.enqueue(3);
			q.enqueue(4);
			
			q.enqueue(5);
			q.enqueue(6);
			q.enqueue(7);
		} catch (Exception ex) {
			System.out.println("Exception occured:: "+ex.getMessage());
			ex.printStackTrace();
		}
		
		
		System.out.println(q.isFull());
		
		while(!q.isEmpty())
		{
			try {
				System.out.println("Front --> "+q.deque()+" "+q.isFull());
			} catch (Exception ex) {
				System.out.println("Exception occured:: "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		
		try {
			System.out.println("Front --> "+q.getFrontElement());
			System.out.println("Rear --> "+q.getLastElement());
			System.out.println("size --> "+q.size());
		} catch (Exception ex) {
			System.out.println("Exception occured:: "+ex.getMessage());
			ex.printStackTrace();
		}
		
	}

}
