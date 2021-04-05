package expression;

public class Subtract extends AbstractOperation {
    public Subtract(Argument a, Argument b) {
        super(a, b, '-');
    }

    @Override
    public int calc(int a, int b) {
        return a - b;
    }
}

