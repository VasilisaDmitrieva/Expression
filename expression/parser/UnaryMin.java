package expression.parser;

import expression.Argument;
import expression.UnaryMinus;
import expression.exceptions.CheckedNegate;

import java.util.List;

final public class UnaryMin extends UnaryParseOperation {
    public UnaryMin() {
        super(List.of("-"));
    }

    @Override
    protected Argument newArgument(String str, Argument left) {
        return new CheckedNegate(left);
    }

    @Override
    protected Argument newOverflowArgument(String str, Argument left) {
        return new UnaryMinus(left);
    }
}
