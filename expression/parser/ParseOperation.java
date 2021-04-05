package expression.parser;

public abstract class ParseOperation implements PriorityStep {
    protected ParseOperation next;
    protected ExpressionParser parser;

    @Override
    public void setParser(ExpressionParser parser) {
        this.parser = parser;
    }

    @Override
    public void setNext(PriorityStep next) {
        this.next = (ParseOperation) next;
    }
}
