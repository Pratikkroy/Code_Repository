package exceptions;

public class QueueUnderFlowException extends Exception {

    public QueueUnderFlowException() {
        this("QueueUnderFlowException");
    }

    public QueueUnderFlowException(String s) {
        super(s);
    }
  
}