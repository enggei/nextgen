package com.generator.generators.stringtemplate.parser;

import com.generator.generators.stringtemplate.domain.TemplateFile;
import com.generator.generators.stringtemplate.domain.TemplateImport;
import com.generator.generators.stringtemplate.domain.TemplateStatement;
import com.generator.util.FileUtil;
import org.antlr.runtime.tree.Tree;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STErrorListener;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * User: goe
 * Date: 05.09.13
 */
public class TemplateFileParser {

   public static TemplateStatement parse(String delimiters, String name, String content, STErrorListener errorListener) throws IOException {
      return parseToFile(delimiters, name, content, errorListener).getTemplateStatement(name);
   }

   private static TemplateFile parseToFile(String delimiters, String name, String content, STErrorListener errorListener) throws IOException {
      final File tempFile = File.createTempFile("name", ".stg");
      FileUtil.write("delimiters \"" + delimiters + "\", \"" + delimiters + "\"\n\n" + name + "() ::= <<" + content + " >>", tempFile);
      return parse(tempFile, errorListener);
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
      final Map<String, TemplateImport> importNames = new LinkedHashMap<>();
      for (STGroup stGroup : group.getImportedGroups()) {
         imports.put(stGroup.getName(), parse(new File(file.getParent(), stGroup.getName() + (stGroup.getName().toLowerCase().endsWith(".stg") ? "" : ".stg")), errorListener));
         importNames.put(stGroup.getName(), new TemplateImport(stGroup.getName()));
      }

      Collections.sort(templateNames);

      final Map<String, Expression.ParameterBuilder> builderMap = new LinkedHashMap<>();
      for (String templateName : templateNames) {
         final ST st = group.getInstanceOf(templateName);
         if (st.isAnonSubtemplate()) continue;
         final Expression.ParameterBuilder parameterBuilder = new Expression.ParameterBuilder(st.getName().substring(1), group.delimiterStartChar, st.impl.template);
         parse(st.impl.ast, parameterBuilder);
         builderMap.put(parameterBuilder.getName(), parameterBuilder);

      }

      final Map<String, TemplateStatement> statements = new LinkedHashMap<>();
      for (String builder : builderMap.keySet()) {
         final Expression.ParameterBuilder parameterBuilder = builderMap.get(builder);
         statements.put(parameterBuilder.getName(), parameterBuilder.processMethodCalls(builderMap, imports).toStatement());
      }

      return new TemplateFile(file, importNames, statements);
   }

   private static void parse(Tree ast, Expression.ParameterBuilder parameterBuilder) {

      if (ast == null) return;

      final int type = ast.getType();

      switch (type) {
         case 4:
            new Expression(ast, parameterBuilder);
            break;
         case 41:
            new Expression(ast, parameterBuilder);
            break;
         default:
            for (int i = 0; i < ast.getChildCount(); i++)
               parse(ast.getChild(i), parameterBuilder);
            break;
      }
   }
}