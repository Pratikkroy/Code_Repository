package exceptions;

public class StackUnderFlowException extends Exception {

    public StackUnderFlowException() {
        this("StackUnderFlowException");
    }

    public StackUnderFlowException(String s) {
        super(s);
    }
}