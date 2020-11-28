package nextgen.templates;

import nextgen.templates.text.Block;
import nextgen.templates.text.Line;
import nextgen.templates.text.TextST;

import java.util.Arrays;
import java.util.Collection;

public class TextPatterns extends TextST {

    public static Block newBlock(Collection<Object> children) {
        final Block block = newBlock();
        for (Object child : children) {
            block.addLines(child);
        }
        return block;
    }

    public static Block newBlock(Object... children) {
        return newBlock(Arrays.asList(children));
    }

    public static Line newLine(String header, Object... children) {
        final Line line = newLine(header);
        for (Object o : children)
            line.addChildren(o);
        return line;
    }

    public static Line newLineIndent(String header, String indent, Object... children) {
        final Line line = newLine(header);
        for (Object o : children)
            line.addChildren(indent + o);
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

    public static Line newLine(String start, Collection<Object> between, String end) {
        final Line line = newLine(start);
        for (Object o : between)
            line.addChildren(o);
        line.setEnd(end);
        return line;
    }
}