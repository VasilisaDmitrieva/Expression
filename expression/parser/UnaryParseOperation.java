package expression.parser;

import expression.Argument;
import expression.exceptions.CheckedNegate;
import expression.exceptions.ParseException;

import java.util.List;

public abstract class UnaryParseOperation extends ParseOperation {
    protected List<String> signs;
    public UnaryParseOperation(List<String> signs) {
        this.signs = signs;
    }
    @Override
    public Argument step() throws ParseException {
        Argument res = null;
        String operator = parser.getCurToken();
        if (isSign(operator)) {
            parser.nextToken();
            if (parser.overflow) {
                res = newOverflowArgument(operator, step());
            } else {
                res = newArgument(operator, step());
            }
        } else  {
            return next.step();
        }
        return res;
    }

    private boolean isSign(String str) {
        for (String ch : signs) {
            if (str.equals(ch)) {
                return true;
            }
        }
        return false;
    }

    abstract protected Argument newArgument(String str, Argument left);
    abstract protected Argument newOverflowArgument(String str, Argument left);

    @Override
    public void setParser(ExpressionParser parser) {
        this.parser = parser;
        parser.operations.addAll(signs);
    }
}
