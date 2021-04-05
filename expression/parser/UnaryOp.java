package expression.parser;

import expression.*;
import expression.exceptions.*;

import java.util.List;

public class UnaryOp extends UnaryParseOperation {
    public UnaryOp() {
        super(List.of("-", "abs", "sqrt"));
    }

    @Override
    protected Argument newArgument(String str, Argument left) {
        if (str.equals(signs.get(0))) {
            return new CheckedNegate(left);
        }
        if (str.equals(signs.get(1))) {
            return new CheckedAbs(left);
        }
        return new CheckedSqrt(left);
    }

    @Override
    protected Argument newOverflowArgument(String str, Argument left) {
        return newArgument(str, left);
    }
}
