package nextgen.templates;

import nextgen.templates.text.Line;
import nextgen.templates.text.TextST;

public class TextPatterns extends TextST {

    public static Line newLine(String header, Object... children) {
        final Line line = newLine(header);
        for (Object o : children)
            line.addChildren(o);
        return line;
    }

    public static Line newLine(String line) {
        return newLine().setLine(line);
    }

    public static Line newLine(String line, String end) {
        return newLine().setLine(line).setEnd(end);
    }

    public static Line newLine(String line, Object between, String end) {
        return newLine().setLine(line + between + end);
    }
}