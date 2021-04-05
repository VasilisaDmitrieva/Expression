package expression.exceptions;

import expression.AbstractUnaryOperation;
import expression.Argument;

public class CheckedAbs extends AbstractUnaryOperation {
    public CheckedAbs(Argument a) {
        super(a, "abs");
    }

    @Override
    public int calc(int a) {
        if (a == Integer.MIN_VALUE) {
            throw new OverflowException("Abs");
        }
        if (a < 0) {
            return -a;
        }
        return a;
    }
}
