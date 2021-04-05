package expression.parser;

import expression.*;
import expression.exceptions.ParseException;

import java.util.ArrayList;
import java.util.List;

public class ExpressionParser extends BaseParser implements expression.exceptions.Parser {
    private String curToken;
    private String nextToken;
    private boolean lastOp;
    protected Pipeline pipeline;
    protected boolean overflow;
    protected ArrayList<String> operations = new ArrayList<>();

    public ExpressionParser() {
        pipeline = new Pipeline(this,
                    List.of(new OrParse(), new XorParse(), new AndParse(),
                            new SubAdd(), new DivMul(), new UnaryMin(),
                            new Factor()));
        overflow = true;
    }

    @Override
    public TripleExpression parse(String expression) throws ParseException {
        setSource(new StringSource(expression));
        curToken = nextToken = null;
        lastOp = true;
        nextToken();

        TripleExpression res = pipeline.parse();

        if (correctToken(curToken)) {
            throw error("wrong format: " + curToken);
        }
        return res;
    }

    public String getCurToken() {
        return curToken;
    }

    protected boolean testToken(String str) {
        if (correctToken()) {
            return str.equals(curToken);
        }
        return false;
    }

    private boolean correctToken(String str) {
        return str != null && str.length() != 0;
    }

    protected boolean correctToken() {
        return correctToken(curToken);
    }

    private boolean tokenNum(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    protected boolean isVariable() {
        return testToken("x") ||
                testToken("y") ||
                testToken("z");
    }

    private String isOp(Character ch) {
        for (String op : operations) {
            if (op.charAt(0) == ch) {
                return op;
            }
        }
        return null;
    }

    private boolean isOp(String str) {
        if (correctToken(str)) {
            for (String op : operations) {
                if (op.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isOp() {
        return isOp(curToken);
    }

    protected boolean tokenNum() {
        return tokenNum(curToken);
    }

    private String readToken() {
        if (correctToken(nextToken)) {
            String str = nextToken;
            nextToken = null;

            return str;
        }

        StringBuilder sb = new StringBuilder();
        while (ch != END) {
            if (!Character.isWhitespace(ch)) {
                String str;
                if (((str = isOp(ch)) != null && str.length() == 1)
                        || ch == '(' || ch == ')') {
                    if (sb.length() == 0) {
                        if (str != null && str.length() != 0) {
                            sb.append(str);
                        } else {
                            sb.append(ch);
                        }
                        nextChar();
                    }
                    return sb.toString();
                }
                sb.append(ch);
            } else {
                if (sb.length() != 0) {
                    return sb.toString();
                }
            }
            nextChar();
        }

        return sb.toString();
    }

    protected void nextToken() {
        curToken = readToken();
        nextToken = readToken();

        if (testToken("-")) {
            if (correctToken(nextToken)) {
                String str = '-' + nextToken;
                if (lastOp && tokenNum(str)) {
                    curToken = str;
                    nextToken = null;
                }
            }
        }
        lastOp = isOp(curToken);
    }
}
