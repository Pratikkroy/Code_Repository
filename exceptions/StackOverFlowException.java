package exceptions;

public class StackOverFlowException extends Exception {

    public StackOverFlowException() {
        this("StackOverFlowException");
    }

    public StackOverFlowException(String s) {
        super(s);
    }
  
}