package expression.exceptions;

import expression.parser.*;

import java.util.List;

public class ExpressionParser extends expression.parser.ExpressionParser {
    public ExpressionParser() {
        super.pipeline = new Pipeline(this,
                List.of(new SubAdd(), new DivMul(), new UnaryOp(),
                        new Factor()));
        overflow = false;
    }
}
