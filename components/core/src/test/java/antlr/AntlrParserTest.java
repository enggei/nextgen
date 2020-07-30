package antlr;

import nextgen.st.importers.AntlrGrammarsImporter;
import org.antlr.parser.st4.STGLexer;
import org.antlr.parser.st4.STGParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;

public class AntlrParserTest {

    public static void main(String[] args) throws IOException {

        final Set<File> grammarFiles = new TreeSet<>((o1, o2) -> o1.getAbsolutePath().compareToIgnoreCase(o2.getAbsolutePath()));
        AntlrGrammarsImporter.findFiles(new File("components/core/src/test/java/grammars/stringtemplate"), grammarFiles);

        final File files[] = grammarFiles.toArray(new File[grammarFiles.size()]);
        final File stgFile = new File("/home/goe/projects/nextgen/components/core/src/main/java/nextgen/templates/test/Test.stg");

        STGLexer stgLexer = new STGLexer(CharStreams.fromFileName(stgFile.getAbsolutePath(), StandardCharsets.UTF_8));
        CommonTokenStream tokens = new CommonTokenStream(stgLexer);
//        tokens.fill();
//
//        for (Token tok : tokens.getTokens()) {
//            if (tok instanceof CommonToken) {
//                System.out.println(((CommonToken) tok).toString(stgLexer));
//            } else {
//                System.out.println(tok.toString());
//            }
//        }

        STGParser parser = new STGParser(tokens);
        parser.addErrorListener(new DiagnosticErrorListener());
        parser.setTrace(true);
        ParseTree tree = parser.group();

    }
}