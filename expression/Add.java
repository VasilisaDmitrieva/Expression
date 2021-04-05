package expression;

public class  Add extends AbstractOperation {
    public Add(Argument a, Argument b) {
        super(a, b, '+');
    }

    @Override
    public int calc(int a, int b) {
        return a + b;
    }
}
