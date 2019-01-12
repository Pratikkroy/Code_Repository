package basic_ds;

public class Queue {

	private int front,rear;
	private int queue[];
	private int MAX_SIZE;
	
	Queue(int size)
	{
		MAX_SIZE=size;
		queue=new int[MAX_SIZE];
		
		front=rear=-1;
	}
	
	public boolean enqueue(int value)
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
				return false; 	
		}
		else if(front>rear)
		{
			if(front-rear==1)   // queue overflow
				return false;
		}
		
		rear=(rear+1)%MAX_SIZE;
		
		queue[rear]=value;
		return true;
	}

	public int deque()
	{
		if(front==-1) //empty queue
			return -1;
		
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
	
	public int getFrontElement()
	{
		if(front==-1)
			return -1;
		
		return queue[front];
	}
	
	public int getLastElement()
	{
		if(front==-1)
			return -1;
		
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
		
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		
		q.deque();
		q.deque();
		q.deque();
		q.enqueue(5);
		q.enqueue(6);
		q.enqueue(7);
		
		q.deque();
		q.deque();
		q.deque();
		q.deque();
		q.deque();
		
		System.out.println("Front --> "+q.getFrontElement());
		System.out.println("Rear --> "+q.getLastElement());
		System.out.println("size --> "+q.size());
	}

}
