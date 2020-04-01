package com.generator.generators.css;

import com.generator.ProjectConstants;
import com.generator.generators.css.parser.css3BaseListener;
import com.generator.generators.css.parser.css3Lexer;
import com.generator.generators.css.parser.css3NodeListener;
import com.generator.generators.css.parser.css3Parser;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;
import java.util.Stack;

/**
 * Created 14.09.17.
 */
public class Tests {

    @Test
    public void testCss() throws IOException {
        final css3NodeListener listener = new css3NodeListener(true);
        new ParseTreeWalker().walk(listener, new css3Parser(new CommonTokenStream(new css3Lexer(CharStreams.fromFileName("/home/goe/projects/nextgen/components/core/tmpSrc/main/js/css/app.css")))).stylesheet());
//      new ParseTreeWalker().walk(listener, new css3Parser(new CommonTokenStream(new css3Lexer(CharStreams.fromFileName(ProjectConstants.MAIN_ROOT + "/com/generator/generators/css/test.css")))).stylesheet());
    }

    @Test
    public void convertToJson() throws IOException {

        final Stack<JsonObject> selectors = new Stack<>();

        ParseTreeListener listener = new css3BaseListener() {

            @Override
            public void enterSelectorGroup(css3Parser.SelectorGroupContext ctx) {
                selectors.push(new JsonObject().
                        put("name", ctx.getText()).
                        put("attributes", new JsonArray()));
                super.enterSelectorGroup(ctx);
            }

            @Override
            public void enterKnownDeclaration(css3Parser.KnownDeclarationContext ctx) {
                final String[] kv = ctx.getText().split(":");
                selectors.peek().getJsonArray("attributes").
                        add(new JsonObject().
                                put("name", kv[0].trim()).
                                put("value", kv[1].trim()));
                super.enterKnownDeclaration(ctx);
            }
        };
        new ParseTreeWalker().walk(listener, new css3Parser(new CommonTokenStream(new css3Lexer(CharStreams.fromFileName("/home/goe/projects/nextgen/components/core/src/main/js/index.css")))).stylesheet());

        for (JsonObject selector : selectors) {
            final StringBuilder out = new StringBuilder("\n.add(new JsonObject().\n" +
                    "\tput(\"name\", \"" + selector.getString("name") + "\").\n" +
                    "\tput(\"attributes\", new JsonArray()");
            for (Object attributesObject : selector.getJsonArray("attributes", new JsonArray())) {
                final JsonObject attributes = (JsonObject) attributesObject;
                out.append("\n\t\t.add(new JsonObject().put(\"name\", \"").append(attributes.getString("name")).append("\").put(\"value\", \"").append(attributes.getString("value")).append("\"))");
            }
            out.append("))");
            System.out.println(out.toString());
        }
    }
}