package expression;

public class Divide extends AbstractOperation {
    public Divide(Argument a, Argument b) {
        super(a, b, '/');
    }

    @Override
    public int calc(int a, int b) {
        return a / b;
    }
}
