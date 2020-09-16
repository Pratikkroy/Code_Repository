package exceptions;

public class QueueOverFlowException extends Exception {

    public QueueOverFlowException() {
        this("QueueOverFlowException");
    }

    public QueueOverFlowException(String s) {
        super(s);
    }
  
}