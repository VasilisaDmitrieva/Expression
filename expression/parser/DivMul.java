package expression.parser;

import expression.*;
import expression.exceptions.*;

import java.util.List;

final public class DivMul extends BinaryParseOperation {
    public DivMul() {
        super(List.of("*", "/"));
    }

    @Override
    protected Argument newOverflowArgument(String str, Argument left, Argument right) {
        if (str.equals("*")) {
            return new Multiply(left, right);
        }
        return new Divide(left, right);
    }

    @Override
    protected Argument newArgument(String str, Argument left, Argument right) {
        if (str.equals("*")) {
            return new CheckedMultiply(left, right);
        }
        return new CheckedDivide(left, right);
    }
}
