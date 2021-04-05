package expression.parser;

import expression.Argument;
import expression.exceptions.ParseException;

import java.util.ArrayList;
import java.util.List;

public class Pipeline {
    private final ArrayList<PriorityStep> prioritet;

    public Pipeline(ExpressionParser parser, List<PriorityStep> prioritet) {
        this.prioritet = new ArrayList<>();
        this.prioritet.addAll(prioritet);
        for (int i = 0; i < prioritet.size() - 1; i++) {
            PriorityStep op = prioritet.get(i);
            op.setNext(prioritet.get(i + 1));
            op.setParser(parser);
        }
        PriorityStep op = prioritet.get(prioritet.size() - 1);
        op.setNext(prioritet.get(0));
        op.setParser(parser);
    }

    public Argument parse() throws ParseException {
        return prioritet.get(0).step();
    }
}
