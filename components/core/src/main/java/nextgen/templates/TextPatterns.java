package nextgen.templates;

import nextgen.templates.text.Line;
import nextgen.templates.text.TextST;

public class TextPatterns extends TextST {

    public static Line newLine(String line) {
        return newLine().setLine(line);
    }

    public static Line newLine(String line, String end) {
        return newLine().setLine(line).setEnd(end);
    }
}