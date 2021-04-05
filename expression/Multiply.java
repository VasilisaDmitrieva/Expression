package expression;

public class Multiply extends AbstractOperation {
    public Multiply(Argument a, Argument b) {
        super(a, b, '*');
    }

    @Override
    public int calc(int a, int b) {
        return a * b;
    }
}
