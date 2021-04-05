package expression;

public class Or extends AbstractOperation {
    public Or(Argument a, Argument b) {
        super(a, b, '|');
    }

    @Override
    public int calc(int a, int b) {
        return a | b;
    }
}
