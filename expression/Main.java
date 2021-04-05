package expression;

import expression.exceptions.CheckedDivide;
import expression.exceptions.ExpressionParser;
import expression.exceptions.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        /*Variable vx = new Variable("x");
        Variable vy = new Variable("y");
        ExpressionParser a = new ExpressionParser();
        TripleExpression exp = new Variable("z");

        exp = a.parse("abssqrt(x * y * z) ");
        System.out.println(exp.toString() + ' ' + exp.evaluate(0, 0, -1538579178));*/
        CheckedDivide w = new CheckedDivide(new Const(Integer.MIN_VALUE), new Const(-1));
        w.evaluate(0);
    }
}
