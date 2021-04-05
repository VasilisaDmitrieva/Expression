package expression.exceptions;

import expression.Argument;
import expression.Multiply;

public class CheckedMultiply extends Multiply {
    public CheckedMultiply(Argument left, Argument right) {
        super(left, right);
    }

    private void checkMul(int a, int b) {
        if (a > b) {
            throw new OverflowException("Multiply");
        }
    }

    @Override
    public int calc(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        if (a > 0 && b > 0) {
            checkMul(a, Integer.MAX_VALUE / b);
        } else if (a > 0 && b < 0) {
            checkMul(Integer.MIN_VALUE / a, b);
        } else if (a < 0 && b > 0) {
            checkMul(Integer.MIN_VALUE / b, a);
        } else {
            checkMul(Integer.MAX_VALUE / b, a);
        }
        return a * b;
    }
}
