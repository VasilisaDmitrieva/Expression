package expression.exceptions;

public class OverflowException extends EvaluateException {
    public OverflowException(String str) {
        super("overflow in " + str);
    }
}
