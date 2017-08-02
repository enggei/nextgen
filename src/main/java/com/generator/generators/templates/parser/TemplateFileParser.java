package com.generator.generators.templates.parser;

import com.generator.generators.templates.domain.TemplateFile;
import com.generator.generators.templates.domain.TemplateImport;
import com.generator.generators.templates.domain.TemplateStatement;
import com.generator.util.FileUtil;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.Tree;
import org.jetbrains.annotations.NotNull;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STErrorListener;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;
import org.stringtemplate.v4.misc.STCompiletimeMessage;
import org.stringtemplate.v4.misc.STMessage;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * User: goe
 * Date: 05.09.13
 */
public class TemplateFileParser {

   private final Debugger debugger = new Debugger();

   private boolean debug = false;

   // todo: refactor this with listeners, and give them specific information, so one can highlight in text-editor on line and character:
   final Set<STMessage> compileTimeErrors = new LinkedHashSet<>();
   //      final Set<STMessage> runtimeErrors = new LinkedHashSet<>();
   final Set<STMessage> ioErrors = new LinkedHashSet<>();
   final Set<STMessage> internalErrors = new LinkedHashSet<>();

   public Set<STMessage> getCompileTimeErrors() {
      return compileTimeErrors;
   }

   public Set<STMessage> getIoErrors() {
      return ioErrors;
   }

   public Set<STMessage> getInternalErrors() {
      return internalErrors;
   }

   public TemplateStatement parse(String delimiters, String name, String content) throws IOException {
      return parse(delimiters, name, content, false, defaultErrorListener());
   }

   @NotNull
   private STErrorListener defaultErrorListener() {
      return new STErrorListener() {
         @Override
         public void compileTimeError(STMessage msg) {
            compileTimeErrors.add(msg);
            if (msg instanceof STCompiletimeMessage) {
               final Token token = ((STCompiletimeMessage) msg).token;
            }
         }

         @Override
         public void runTimeError(STMessage msg) {
//            runtimeErrors.add(msg);
         }

         @Override
         public void IOError(STMessage msg) {
            ioErrors.add(msg);
         }

         @Override
         public void internalError(STMessage msg) {
            internalErrors.add(msg);
         }
      };
   }

   public TemplateStatement parse(String delimiters, String name, String content, STErrorListener errorListener) throws IOException {
      return parse(delimiters, name, content, false, errorListener);
   }

   public TemplateStatement parse(String delimiters, String name, String content, boolean debug, STErrorListener errorListener) throws IOException {
      this.debug = debug;
      final File tempFile = File.createTempFile("name", ".stg");
      FileUtil.write("delimiters \"" + delimiters + "\", \"" + delimiters + "\"\n\n" + name + "() ::= <<" + content + " >>", tempFile);
      return parse(tempFile, errorListener).getTemplateStatement(name);
   }

   public TemplateFile parse(File file) {
      return parse(file, false, defaultErrorListener());
   }

   public TemplateFile parse(File file, STErrorListener errorListener) {
      return parse(file, false, errorListener);
   }

   public TemplateFile parse(File file, boolean debug, STErrorListener errorListener) {
      this.debug = debug;
      System.out.println("parsing " + file.getAbsolutePath() + " debug: " + this.debug);
      if (file.length() == 0) return null;

      final STGroupFile group = new STGroupFile(file.getAbsolutePath());
      group.setListener(errorListener);

      // let Stringtemplate verify the content, by iterating through the templates and try to render
      // nb: delimitersChars is a lazy trigger for parsing delimiters-chars from file (important that a 'group.getInstanceOf' is called before this, otherwise the delimiterChars are set to default '<' '>'
      final List<String> templateNames = new ArrayList<>(group.getTemplateNames());
      for (String templateName : templateNames) {
         group.getInstanceOf(templateName).render();
      }

      printErrors(compileTimeErrors, "compile error: ");
//      printErrors(runtimeErrors, "runtime error: ");
      printErrors(ioErrors, "ioError error: ");
      printErrors(internalErrors, "internalError error: ");


      final Map<String, TemplateFile> imports = new LinkedHashMap<>();
      final Map<String, TemplateImport> importNames = new LinkedHashMap<>();
      for (STGroup stGroup : group.getImportedGroups()) {
         imports.put(stGroup.getName(), new TemplateFileParser().parse(new File(file.getParent(), stGroup.getName() + (stGroup.getName().toLowerCase().endsWith(".stg") ? "" : ".stg")), errorListener));
         importNames.put(stGroup.getName(), new TemplateImport(stGroup.getName()));
      }

      Collections.sort(templateNames);

      final Map<String, Expression.ParameterBuilder> builderMap = new LinkedHashMap<>();
      for (String templateName : templateNames) {
         final ST st = group.getInstanceOf(templateName);
         if (st.isAnonSubtemplate()) continue;
         final Expression.ParameterBuilder parameterBuilder = new Expression.ParameterBuilder(st.getName().substring(1), group.delimiterStartChar, st.impl.template);
         debugger.newStatement();
         parse(st.impl.ast, parameterBuilder);
         builderMap.put(parameterBuilder.getName(), parameterBuilder);

      }

      // write debug-file if debug=true
      if (debug) debugger.done(file);

      final Map<String, TemplateStatement> statements = new LinkedHashMap<>();
      for (String builder : builderMap.keySet()) {
         final Expression.ParameterBuilder parameterBuilder = builderMap.get(builder);
         statements.put(parameterBuilder.getName(), parameterBuilder.processMethodCalls(builderMap, imports).toStatement());
      }

      return new TemplateFile(UUID.randomUUID(), group.delimiterStartChar, file, importNames, statements);
   }

   private void parse(Tree ast, Expression.ParameterBuilder parameterBuilder) {

      if (ast == null) return;

      final int type = ast.getType();

      debugger.inc();
      debugger.onType(ast);

      switch (type) {
         case 4:
            new Expression(ast, parameterBuilder, debugger);
            break;
         case 41:
            new Expression(ast, parameterBuilder, debugger);
            break;
         default:
            for (int i = 0; i < ast.getChildCount(); i++)
               parse(ast.getChild(i), parameterBuilder);
            break;
      }
      debugger.dec();
   }

   private static void printErrors(Set<STMessage> set, String type) {
      for (STMessage stMessage : set) {
         System.err.println(type + stMessage);
      }
   }


}