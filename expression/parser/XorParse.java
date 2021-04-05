package expression.parser;

import expression.*;

import java.util.List;

public class XorParse extends BinaryParseOperation {
    public XorParse() {
        super(List.of("^"));
    }

    @Override
    protected Argument newOverflowArgument(String str, Argument left, Argument right) {
        return newArgument(str, left, right);
    }

    @Override
    protected Argument newArgument(String str, Argument left, Argument right) {
        return new Xor(left, right);
    }
}
