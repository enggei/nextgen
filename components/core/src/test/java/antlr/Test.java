package antlr;

import org.antlr.parser.antlr4.*;
import org.antlr.parser.st4.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Test {

    // https://jakubdziworski.github.io/java/2016/04/01/antlr_visitor_vs_listener.html

    public static void main(String[] args) {
        testStringtemplateParser();
//        testAntlrParser();
    }

    public static void testStringtemplateParser() {
        try {
            final File file = new File("/home/goe/projects/nextgen/components/core/src/test/java/antlr/Test.stg");

//            final STGroup stGroup = new STGroupFile(file.getAbsolutePath());
//            final ST clone = stGroup.getInstanceOf("clone");
//            System.out.println(clone.render());

            InputStream inputStream = new FileInputStream(file);
            Lexer lexer = new STLexer(CharStreams.fromStream(inputStream));
//            Lexer lexer = new STGLexer(CharStreams.fromStream(inputStream));
            TokenStream tokenStream = new CommonTokenStream(lexer);
            STParser parser = new STParser(tokenStream);
//            STGParser parser = new STGParser(tokenStream);

            final DebugSTGVisitor debugVisitor = new DebugSTGVisitor();
            debugVisitor.visit(parser.template());
//            debugVisitor.visit(parser.group());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static final class DebugSTGVisitor extends STGParserBaseVisitor<Object> {

        @Override
        public Object visitErrorNode(ErrorNode node) {
            return super.visitErrorNode(node);
        }

        @Override
        public Object visitGroup(STGParser.GroupContext ctx) {
            return super.visitGroup(ctx);
        }

        @Override
        public Object visitDelimiters(STGParser.DelimitersContext ctx) {
            return super.visitDelimiters(ctx);
        }
    }

    public static void testAntlrParser() {
        try {
            InputStream inputStream = new FileInputStream(new File("/home/goe/projects/nextgen/components/core/src/main/java/com/generator/generators/protobuf/parser/Protobuf.g4"));
            Lexer lexer = new ANTLRv4Lexer(CharStreams.fromStream(inputStream));
            TokenStream tokenStream = new CommonTokenStream(lexer);
            ANTLRv4Parser parser = new ANTLRv4Parser(tokenStream);

            final DebugANTLRv4Visitor debugVisitor = new DebugANTLRv4Visitor();
            debugVisitor.visit(parser.grammarSpec());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static final class DebugANTLRv4Visitor extends ANTLRv4ParserBaseVisitor<Object> {

        @Override
        public Object visitGrammarSpec(ANTLRv4Parser.GrammarSpecContext ctx) {

            final String grammarName = new GrammarNameVisitor().visitGrammarDecl(ctx.grammarDecl());
            System.out.println("grammar " + grammarName);

            final RuleContext ruleContext = ctx.getRuleContext();


            return super.visitGrammarSpec(ctx);
        }

        private static final class GrammarNameVisitor extends ANTLRv4ParserBaseVisitor<String> {
            @Override
            public String visitGrammarDecl(ANTLRv4Parser.GrammarDeclContext ctx) {
                return ctx.identifier().getText();
            }
        }
    }

}
