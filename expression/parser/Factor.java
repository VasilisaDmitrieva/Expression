package expression.parser;

import expression.*;
import expression.exceptions.ParseException;

final public class Factor extends ParseOperation {
    @Override
    public Argument step() throws ParseException {
        Argument result;

        if (parser.testToken("(")) {
            parser.nextToken();
            result = next.step();
            if (!parser.testToken(")")) {
                throw parser.error("Expected ')'");
            } else {
                parser.nextToken();
            }
        } else {
            if (parser.tokenNum()) {
                result = new Const(Integer.parseInt(parser.getCurToken()));
            } else if (parser.isVariable()){
                result = new Variable(parser.getCurToken());
            } else {
                String token = parser.getCurToken();
                if (parser.isOp()) {
                    throw parser.error("no argument in " + token + " operation");
                }
                if (token.equals(")") || token.length() == 0) {
                    throw parser.error("no argument");
                }
                for (int i = 0; i < token.length(); i++) {
                    if (!Character.isDigit(token.charAt(i)) &&
                            !(token.charAt(i) == '-')) {
                        throw parser.error("wrong format: " + token);
                    }
                }
                throw parser.error("constant overflow: " + parser.getCurToken());
            }
            parser.nextToken();
        }

        return result;
    }
}
