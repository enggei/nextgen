package com.nextgen.core.template.st;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.Tree;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STErrorListener;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;
import org.stringtemplate.v4.misc.STCompiletimeMessage;
import org.stringtemplate.v4.misc.STMessage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * User: goe
 * Date: 05.09.13
 */
public class TemplateParser {

    public static TemplateStatement parse(String delimiters, String name, String content, STErrorListener errorListener) throws IOException {
        return parseToFile(delimiters, name, content, errorListener).getTemplateStatement(name);
    }

    public static TemplateStatement parse(String delimiters, String name, String content, final StringBuilder errors) throws IOException {
        return parseToFile(delimiters, name, content, new STErrorListener() {
            @Override
            public void compileTimeError(STMessage stMessage) {
                if (stMessage instanceof STCompiletimeMessage) {
                    final Token token = ((STCompiletimeMessage) stMessage).token;
                    errors.append("\nat ").append(token.getLine()).append(" position ").append(token.getCharPositionInLine());
                }
            }

            @Override
            public void runTimeError(STMessage stMessage) {

            }

            @Override
            public void IOError(STMessage stMessage) {

            }

            @Override
            public void internalError(STMessage stMessage) {

            }
        }).getTemplateStatement(name);
    }

    private static TemplateFile parseToFile(String delimiters, String name, String content, STErrorListener errorListener) throws IOException {
        final File tempFile = File.createTempFile("name", ".stg");
        final BufferedWriter out = new BufferedWriter(new FileWriter(tempFile));
        out.write("delimiters \"" + delimiters + "\", \"" + delimiters + "\"\n\n" + name + "() ::= <<" + content + " >>");
        out.close();
        return parse(tempFile, errorListener);
    }

    public static TemplateFile parse(File file, StringBuilder errors) {
        return parse(file,new STErrorListener() {
            @Override
            public void compileTimeError(STMessage stMessage) {
                if (stMessage instanceof STCompiletimeMessage) {
                    final Token token = ((STCompiletimeMessage) stMessage).token;
                    errors.append("\nat ").append(token.getLine()).append(" position ").append(token.getCharPositionInLine()).append(token.getText());
                }
            }

            @Override
            public void runTimeError(STMessage stMessage) {

            }

            @Override
            public void IOError(STMessage stMessage) {

            }

            @Override
            public void internalError(STMessage stMessage) {

            }
        });
    }

    public static TemplateFile parse(File file, STErrorListener errorListener) {
        if (file.length() == 0) return null;

        final STGroupFile group = new STGroupFile(file.getAbsolutePath());
        group.setListener(errorListener);

        // let Stringtemplate verify the content, by iterating through the templates and try to render
        // nb: delimitersChars is a lazy trigger for parsing delimiters-chars from file (important that a 'group.getInstanceOf' is called before this, otherwise the delimiterChars are set to default '<' '>'
        final List<String> templateNames = new ArrayList<>(group.getTemplateNames());
        for (String templateName : templateNames)
            group.getInstanceOf(templateName).render();

        final Map<String, TemplateFile> imports = new LinkedHashMap<>();
        for (STGroup stGroup : group.getImportedGroups())
            imports.put(stGroup.getName(), parse(new File(file.getParent(), stGroup.getName() + (stGroup.getName().toLowerCase().endsWith(".stg") ? "" : ".stg")), errorListener));

        Collections.sort(templateNames);

        final Map<String, TemplateTreeParser.ParameterBuilder> builderMap = new LinkedHashMap<>();
        for (String templateName : templateNames) {
            final ST st = group.getInstanceOf(templateName);
            if (st.isAnonSubtemplate()) continue;
            final TemplateTreeParser.ParameterBuilder parameterBuilder = new TemplateTreeParser.ParameterBuilder(st.getName().substring(1), st.impl.template);
            parse(st.impl.ast, parameterBuilder);
            builderMap.put(parameterBuilder.getName(), parameterBuilder);

        }

        final Map<String, TemplateStatement> statements = new LinkedHashMap<>();
        for (String builder : builderMap.keySet()) {
            final TemplateTreeParser.ParameterBuilder parameterBuilder = builderMap.get(builder);
            statements.put(parameterBuilder.getName(), parameterBuilder.processMethodCalls(builderMap, imports).toStatement());
        }

        return new TemplateFile(statements, group.delimiterStartChar);
    }

    private static void parse(Tree ast, TemplateTreeParser.ParameterBuilder parameterBuilder) {

        if (ast == null) return;

        final int type = ast.getType();

        switch (type) {
            case 4:
                new TemplateTreeParser(ast, parameterBuilder);
                break;
            case 41:
                new TemplateTreeParser(ast, parameterBuilder);
                break;
            default:
                for (int i = 0; i < ast.getChildCount(); i++)
                    parse(ast.getChild(i), parameterBuilder);
                break;
        }
    }
}