package basic_ds;

import java.util.ArrayDeque;

public class JavaQueueUsingDeque<E> {

     /**
     * Since we only need to expose the below methods.
     * So using ArrayDeque as a composed object, not inherited.
     */

    ArrayDeque<E> arrayDeque;

    public JavaQueueUsingDeque() {
        arrayDeque = new ArrayDeque<>();
	}
    
    public boolean enqueue(E value) {
        arrayDeque.addLast(value);
        return true;
	}

	public E deque() {
		return arrayDeque.removeFirst();
	}
	
	public boolean isEmpty(){
		return arrayDeque.isEmpty();
	}
	
	public boolean isFull(){
		/**
         * Since we have not defined the MAX_SIZE, so this method should always return false;
         */

        return false;
	}
	
	public E getFrontElement(){
		return arrayDeque.getFirst();
	}
	
	public E getLastElement() {
		return arrayDeque.getLast();
	}
	
	public int size() {
		return arrayDeque.size();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JavaQueueUsingDeque<Integer> q=new JavaQueueUsingDeque<Integer>();
		
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