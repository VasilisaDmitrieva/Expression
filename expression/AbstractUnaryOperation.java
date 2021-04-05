package expression;

import java.util.Objects;

public abstract class AbstractUnaryOperation implements Argument {
    private Argument left;
    private String sign;

    public AbstractUnaryOperation(Argument a, String sign) {
        this.left = a;
        this.sign = sign;
    }

    @Override
    public int evaluate(int x) {
        return calc(left.evaluate(x));
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return calc(left.evaluate(x, y, z));
    }

    public abstract int calc(int a);

    @Override
    public String toString() {
        return sign + "(" + left.toString() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass())  {
            return false;
        }
        AbstractUnaryOperation that = (AbstractUnaryOperation) o;
        return sign == that.sign &&
                left.equals(that.left);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, sign);
    }
}
