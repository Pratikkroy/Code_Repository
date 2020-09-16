package basic_ds;

import java.util.ArrayDeque;

public class JavaStackUsingDeque<E>  {

    /**
     * Since we only need to expose the below methods.
     * So using ArrayDeque as a composed object, not inherited.
     */

    ArrayDeque<E> arrayDeque;

    public JavaStackUsingDeque(){
        arrayDeque = new ArrayDeque<>();
	}
	
	public boolean push(E value) {
		arrayDeque.addFirst(value);
		return true;
	}
	
	public E pop(){
		return arrayDeque.removeFirst();
	}
	
	public E getTopElement(){
		return arrayDeque.peekFirst();
	}
	
	public int size(){
		return arrayDeque.size();
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
    
    public static void main(String[] args) {
        JavaStackUsingDeque<Integer> stackUsingDeque = new JavaStackUsingDeque<>();

        stackUsingDeque.push(10);
        stackUsingDeque.push(20);
        stackUsingDeque.push(30);
        stackUsingDeque.push(40);

        while(!stackUsingDeque.isEmpty()) {
            System.out.println(stackUsingDeque.pop());
        }
        System.out.println(stackUsingDeque.pop());
    }
    
}