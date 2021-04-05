package expression.exceptions;

import expression.Argument;
import expression.Divide;

public class CheckedDivide extends Divide {
    public CheckedDivide(Argument left, Argument right) {
        super(left, right);
    }

    @Override
    public int calc(int a, int b) {
        if (b == 0) {
            throw new EvaluateException("Division by zero");
        }
        if (a == 0) {
            return 0;
        }

        if (a > 0 && b > 0) {
            checkDivide(a / Integer.MAX_VALUE, b);
        } else if (a < 0 && b > 0) {
            checkDivide(a / Integer.MIN_VALUE, b);
        } else if (a < 0 && b < 0){
            if (a % Integer.MAX_VALUE != 0) {
                checkDivide(b, a / Integer.MAX_VALUE - 1);
            } else {
                checkDivide(b, a / Integer.MAX_VALUE);
            }
        }
        return a / b;
    }

    private void checkDivide(int a, int b) {
        if (a > b) {
            throw new OverflowException("Divide");
        }
    }
}
