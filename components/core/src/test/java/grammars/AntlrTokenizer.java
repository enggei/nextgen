package grammars;

import nextgen.st.importers.AntlrGrammarsImporter;
import nextgen.utils.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class AntlrTokenizer {

    public static void main(String[] args) throws IOException {
        final AntlrTokenizer tokenizer = new AntlrTokenizer();

        final Set<File> grammarFiles = new TreeSet<>((o1, o2) -> o1.getAbsolutePath().compareToIgnoreCase(o2.getAbsolutePath()));
        AntlrGrammarsImporter.findFiles(new File("components/core/src/test/java/grammars"), grammarFiles);

        for (File grammarFile : grammarFiles) {

            final AtomicBoolean isLexer = new AtomicBoolean(grammarFile.getName().toLowerCase().contains("lexer"));
            FileUtil.readString(grammarFile, line -> {
                final String s = line.trim();
                if (s.length() == 0) return false;
                if (s.startsWith("//")) return false;
                if (s.startsWith("parser ")) {
                    isLexer.set(false);
                    return true;
                } else if (s.startsWith("lexer ")) {
                    isLexer.set(true);
                    return true;
                }
                return false;
            });

            if (isLexer.get()) {
                final AntlrLexerContext context = tokenizer.parseLexer(grammarFile.getAbsolutePath());
                System.out.println("lexer  " + grammarFile.getName());
            } else {
                final AntlrParserContext context = tokenizer.parseParser(grammarFile.getAbsolutePath());
                System.out.println("parser " + grammarFile.getName());
//                for (String option : context._options)
//                    System.out.println("\t" + option);
//                for (AntlrParserRule rule : context._rules) {
//                    System.out.println("\t" + rule._name);
//                    for (String alternative : rule._alternatives) {
//                        System.out.println("\t\t" + alternative);
//                    }
//                }
            }
        }
    }

    private AntlrParserContext parseParser(String file) throws IOException {

        final AntlrParserContext context = new AntlrParserContext();

        FileUtil.readString(file, line -> {

            final String s = line.trim();
            if (s.length() == 0) return false;
            if (s.startsWith("//")) return false;
            if (context._prelim && !s.startsWith("parser")) return false;

            if (s.startsWith("parser")) {
                context._prelim = false;
                context._parser = s;
            } else if (s.startsWith("options ")) {
                context._inOptions = true;
                context._options.add(s);
                if (s.endsWith("}")) context._inOptions = false;
            } else if (context._inOptions) {
                context._options.add(s);
                if (s.endsWith("}")) context._inOptions = false;
            } else if (s.endsWith(";")) {

                AntlrParserRule antlrParserRule = null;
                final Iterator<String> iterator = context._queue.iterator();
                while (iterator.hasNext()) {
                    if (antlrParserRule == null) {
                        antlrParserRule = new AntlrParserRule();
                        antlrParserRule._name = iterator.next();
                        context._rules.add(antlrParserRule);
                    } else {
                        antlrParserRule._alternatives.add(iterator.next());
                    }
                }
                context._queue.clear();
            } else {
                context._queue.add(s);
            }
            return false;
        });

        return context;
    }

    private AntlrLexerContext parseLexer(String file) throws IOException {

        final AntlrLexerContext context = new AntlrLexerContext();

        FileUtil.readString(file, line -> {

            final String s = line.trim();
            if (s.length() == 0) return false;
            if (s.startsWith("//")) return false;
            if (context._prelim && !s.startsWith("lexer")) return false;

            return false;
        });

        return context;
    }
}