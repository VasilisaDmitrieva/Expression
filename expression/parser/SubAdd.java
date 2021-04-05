package expression.parser;

import expression.*;
import expression.exceptions.*;

import java.util.List;

final public class SubAdd extends BinaryParseOperation {
    public SubAdd() {
        super(List.of("+", "-"));
    }

    @Override
    protected Argument newOverflowArgument(String str, Argument left, Argument right) {
        if (str.equals("+")) {
            return new Add(left, right);
        }
        return new Subtract(left, right);
    }

    @Override
    protected Argument newArgument(String str, Argument left, Argument right) {
        if (str.equals("+")) {
            return new CheckedAdd(left, right);
        }
        return new CheckedSubtract(left, right);
    }
}
