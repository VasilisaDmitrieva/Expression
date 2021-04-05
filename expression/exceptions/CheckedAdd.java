package expression.exceptions;

import expression.Add;
import expression.Argument;

public class CheckedAdd extends Add {
    public CheckedAdd(Argument left, Argument right) {
        super(left, right);
    }

    @Override
    public int calc(int a, int b) {
        if ((a > 0 && b > 0 && a > Integer.MAX_VALUE - b) ||
                (a < 0 && b < 0 && a < Integer.MIN_VALUE - b)) {
            throw new OverflowException("Add");
        }
        return a + b;
    }
}
