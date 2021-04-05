package expression.parser;

import expression.exceptions.ParseException;

public class BaseParser {
    public static final char END = '\0';
    private CharSource source;
    protected char ch = 0xffff;

    protected BaseParser(CharSource source) {
        setSource(source);
    }

    protected BaseParser() {
        this(new StringSource(""));
    }

    protected void setSource(CharSource source) {
        this.source = source;
        nextChar();
    }

    protected void nextChar() {
        ch = source.hasNext() ? source.next() : END;
    }

    protected ParseException error(final String message) {
        return source.error(message);
    }
}