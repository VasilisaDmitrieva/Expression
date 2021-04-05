package expression.parser;
import expression.Argument;
import expression.exceptions.ParseException;

import java.util.List;

public abstract class BinaryParseOperation extends ParseOperation {
    protected List<String> signs;

    public BinaryParseOperation(List<String> signs) {
        this.signs = signs;
    }

    @Override
    public Argument step() throws ParseException {
        Argument first = next.step();

        while (parser.correctToken()) {
            String operator = parser.getCurToken();
            if (isSign(operator)) {
                parser.nextToken();
            } else {
                break;
            }

            Argument second = next.step();
            if (parser.overflow) {
                first = newOverflowArgument(operator, first, second);
            } else {
                first = newArgument(operator, first, second);
            }
        }
        return first;
    }

    abstract protected Argument newOverflowArgument(String str, Argument left, Argument right);

    private boolean isSign(String str) {
        for (String ch : signs) {
            if (str.equals(ch)) {
                return true;
            }
        }
        return false;
    }
    abstract protected Argument newArgument(String str, Argument left, Argument right);

    @Override
    public void setParser(ExpressionParser parser) {
        this.parser = parser;
        parser.operations.addAll(signs);
    }
}
