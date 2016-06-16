package com.generator.generators.html5.parser;

import org.antlr.v4.runtime.misc.NotNull;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * goe on 9/26/14.
 */
public class Tests {

    @Test
    public void testSimple() throws IOException {

        final String file = "/media/storage/projects/cep/resources/igapi/account/accounts.response.GET.html";
//        new HTMLParser(HTMLParser.createLexer(new FileReader(file))).htmlDocument();

        HTMLParser.visit(new FileReader(file), new HTMLParserBaseVisitor<Object>() {

            private final AtomicBoolean inDfn = new AtomicBoolean(false);

            @Override
            public Object visitHtmlTagName(@NotNull HTMLParser.HtmlTagNameContext ctx) {

                if (ctx.TAG_NAME().toString().equals("dfn")) {
                    inDfn.set(true);
                    System.out.println("dfn: " + ctx.TAG_NAME());
                }
                return super.visitHtmlTagName(ctx);
            }

            @Override
            public Object visitHtmlAttributeValue(@NotNull HTMLParser.HtmlAttributeValueContext ctx) {

                if (inDfn.get()) {
                    System.out.println(ctx.ATTVALUE_VALUE().toString().trim());
                }

                return super.visitHtmlAttributeValue(ctx);
            }

            @Override
            public Object visitHtmlContent(@NotNull HTMLParser.HtmlContentContext ctx) {

                if (inDfn.get()) {
                    System.out.println(ctx.getText().trim());
                    inDfn.set(false);
                }
                return super.visitHtmlContent(ctx);
            }
        });

    }
}
