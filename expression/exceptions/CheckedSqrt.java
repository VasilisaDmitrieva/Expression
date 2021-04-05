package expression.exceptions;

import expression.AbstractUnaryOperation;
import expression.Argument;

public class CheckedSqrt extends AbstractUnaryOperation {
    public CheckedSqrt(Argument a) {
        super(a, "sqrt");
    }

    @Override
    public int calc(int a) {
        if (a < 0) {
            throw new EvaluateException("negative sqrt");
        }
        if (a == 0) {
            return 0;
        }
        int i = 1;
        int r = 0;
        while ((r = i * i) <= a && r > 0) {
            i++;
        }
        return i - 1;
    }
}
