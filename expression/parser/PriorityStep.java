package expression.parser;

import expression.Argument;
import expression.exceptions.ParseException;

public interface PriorityStep {
    Argument step() throws ParseException;
    void setNext(PriorityStep next);
    void setParser(ExpressionParser parser);
}
