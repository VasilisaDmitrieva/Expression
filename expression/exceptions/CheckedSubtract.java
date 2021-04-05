package expression.exceptions;

import expression.Argument;
import expression.Subtract;

public class CheckedSubtract extends Subtract {
    public CheckedSubtract(Argument left, Argument right) {
        super(left, right);
    }

    @Override
    public int calc(int a, int b) {
        if ((a >= 0 && b <= 0 && a > Integer.MAX_VALUE + b) ||
                (a <= 0 && b >= 0 && a < Integer.MIN_VALUE + b)) {
            throw new OverflowException("Subtract");
        }
        return a - b;
    }
}
