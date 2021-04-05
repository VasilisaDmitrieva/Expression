package expression;

public class Xor extends AbstractOperation {
    public Xor(Argument a, Argument b) {
        super(a, b, '^');
    }

    @Override
    public int calc(int a, int b) {
        return a ^ b;
    }
}
