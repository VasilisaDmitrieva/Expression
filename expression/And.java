package expression;

public class And extends AbstractOperation {
    public And(Argument a, Argument b) {
        super(a, b, '&');
    }

    @Override
    public int calc(int a, int b) {
        return a & b;
    }
}
