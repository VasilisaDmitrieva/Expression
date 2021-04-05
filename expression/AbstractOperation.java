package expression;

import java.util.Objects;

public abstract class AbstractOperation implements Argument {
    private Argument left;
    private Argument right;
    private char sign;

    public AbstractOperation(Argument a, Argument b, char sign) {
        this.left = a;
        this.right = b;
        this.sign = sign;
    }

    @Override
    public int evaluate(int x) {
        return calc(left.evaluate(x), right.evaluate(x));
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return calc(left.evaluate(x, y, z), right.evaluate(x, y, z));
    }

    public abstract int calc(int a, int b);

    @Override
    public String toString() {
        return "(" + left.toString() + " " + sign + " " + right.toString() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass())  {
            return false;
        }
        AbstractOperation that = (AbstractOperation) o;
        return sign == that.sign &&
                left.equals(that.left) &&
                right.equals(that.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right, sign);
    }
}
