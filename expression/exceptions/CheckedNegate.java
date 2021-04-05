package expression.exceptions;

import expression.Argument;
import expression.UnaryMinus;

public class CheckedNegate extends UnaryMinus {
    public CheckedNegate(Argument left) {
        super(left);
    }

    @Override
    public int calc(int a) {
        if (a == Integer.MIN_VALUE) {
            throw new OverflowException("Negate");
        }
        return -a;
    }
}
