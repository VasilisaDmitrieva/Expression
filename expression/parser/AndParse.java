package expression.parser;

import expression.*;

import java.util.List;

public class AndParse extends BinaryParseOperation {
    public AndParse() {
        super(List.of("&"));
    }

    @Override
    protected Argument newOverflowArgument(String str, Argument left, Argument right) {
        return newArgument(str, left, right);
    }

    @Override
    protected Argument newArgument(String str, Argument left, Argument right) {
        return new And(left, right);
    }
}
