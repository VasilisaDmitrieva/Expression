package expression;

public class UnaryMinus extends AbstractUnaryOperation {
    public UnaryMinus(Argument a) {
        super(a, "-");
    }

    @Override
    public int calc(int a) {
        return -a;
    }
}
