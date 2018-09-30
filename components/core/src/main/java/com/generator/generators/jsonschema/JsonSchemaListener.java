package com.generator.generators.jsonschema;

import com.generator.generators.json.parser.JSONBaseListener;
import com.generator.generators.json.parser.JSONLexer;
import com.generator.generators.json.parser.JSONParser;
import com.generator.util.StringUtil;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Stack;

public class JsonSchemaListener extends JSONBaseListener {

    private final JsonSchema jsonSchema = new JsonSchema();

    private final Stack<Node> nodes = new Stack<>();
    private boolean printExit = false;

    public JsonSchema parse(String schema) {
        final JSONParser parser = new JSONParser(new CommonTokenStream(new JSONLexer(CharStreams.fromString(schema))));
        new ParseTreeWalker().walk(this, parser.json());
        return jsonSchema;
    }

    @Override
    public void enterJson(JSONParser.JsonContext ctx) {
        nodes.push(new Node(nodes));
        System.out.println(print(nodes));
    }

    @Override
    public void exitJson(JSONParser.JsonContext ctx) {
        nodes.pop();
        if (printExit) System.out.println(print(nodes));
    }

    @Override
    public void enterObj(JSONParser.ObjContext ctx) {
        nodes.push(new Node(nodes));
        System.out.println(print(nodes));
    }

    @Override
    public void exitObj(JSONParser.ObjContext ctx) {
        nodes.pop();
        if (printExit) System.out.println(print(nodes));
    }

    @Override
    public void enterPair(JSONParser.PairContext ctx) {
        nodes.push(new Node(nodes).setName(StringUtil.trimEnds(1, ctx.getChild(0).getText())));
        System.out.println(print(nodes));
    }

    @Override
    public void exitPair(JSONParser.PairContext ctx) {
        nodes.pop();
        if (printExit) System.out.println(print(nodes));
    }

    @Override
    public void enterArray(JSONParser.ArrayContext ctx) {
        nodes.push(new Node(nodes));
        System.out.println(print(nodes));
    }

    @Override
    public void exitArray(JSONParser.ArrayContext ctx) {
        nodes.pop();
        if (printExit) System.out.println(print(nodes));
    }

    @Override
    public void enterValue(JSONParser.ValueContext ctx) {

        final TerminalNode string = ctx.STRING();
        final TerminalNode number = ctx.NUMBER();
        final JSONParser.ObjContext obj = ctx.obj();

        if (string != null) nodes.push(new Node(nodes).setValue(string));
        else if (number != null) nodes.push(new Node(nodes).setValue(number));
        else nodes.push(new Node(nodes));
        System.out.println(print(nodes));
    }

    @Override
    public void exitValue(JSONParser.ValueContext ctx) {
        nodes.pop();
        if (printExit) System.out.println(print(nodes));
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        //nodes.peek().setValue(node.getSymbol().getText());
    }

    private final class Node {

        private String name = "";
        private Node parent;
        private Object value;

        public Node(Stack<Node> nodes) {
            if (!nodes.isEmpty()) parent = nodes.peek();
        }

        public Node setName(String name) {
            this.name = name;
            return this;
        }

        @Override
        public String toString() {
            return "(" + name + (value == null ? "" : ("=" + value.toString())) + ")";
        }

        public Node setValue(Object value) {
            this.value = value;
            return this;
        }
    }

    private String print(Stack<Node> nodes) {
        final StringBuilder out = new StringBuilder();
        for (Node node : nodes)
            out.append(node).append(" ");
        return out.toString().trim();
    }
}