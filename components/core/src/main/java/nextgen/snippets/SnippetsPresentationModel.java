package nextgen.snippets;

import jdk.jshell.*;
import nextgen.utils.JShellUtil;
import org.neo4j.graphdb.GraphDatabaseService;

import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

public class SnippetsPresentationModel extends JShellNeoFactory {

   public SnippetsPresentationModel(String dir) {
      super(dir);
   }

   public SnippetsPresentationModel(GraphDatabaseService db) {
      super(db);
   }

   public static void main(String[] args) {
      final String dir = "/home/goe/projects/nextgen/components/core/src/test/java/nextgen/snippets/testdb";
      final SnippetsPresentationModel db = new SnippetsPresentationModel(dir);

      final JShell shell = JShellUtil.newLocalShell();

      JShellBlackboard.db = db;
      System.out.println(JShellBlackboard.test);

      final String[] snippets = new String[]{
            "String method(int v) { return Integer.toString(v); }",
            "int x = 45;",
            "String x = \"NewX\";",
            "import nextgen.snippets.*;",
            "double volume(double radius) { return 4.0 / 3.0 * PI * cube(radius); }",
            "import nextgen.snippets.JShellBlackboard.test;",
            "nextgen.snippets.JShellBlackboard.test++;",
            "nextgen.snippets.JShellBlackboard.db.doInTransaction(tx -> System.out.println(\"in transaction\"));",
      };

//      db.doInTransaction(transaction -> {

      for (String input : snippets) {
         System.out.println("\"" + input + "\"");

         final List<SnippetEvent> events = shell.eval(input);
         System.out.println("\tevents " + events.size());
         for (int i = 0; i < events.size(); i++) {
            final SnippetEvent event = events.get(i);
            final Snippet snippet = event.snippet();
            System.out.println("\t\t" + i + " " + shell.status(snippet));

            switch (shell.status(snippet)) {
               case VALID:
                  System.out.println("\t\t\t" + snippet.kind());
                  switch (snippet.kind()) {
                     case IMPORT:
                        final ImportSnippet importSnippet = (ImportSnippet) snippet;
                        System.out.println("\t\t\t\t" + importSnippet.name() + " " + importSnippet.fullname());
                        break;
                     case TYPE_DECL:
                        break;
                     case METHOD:
                        final MethodSnippet methodSnippet = (MethodSnippet) snippet;
                        System.out.println("\t\t\t\t" + methodSnippet.signature() + " " + methodSnippet.parameterTypes());
                        break;
                     case VAR:
                        final VarSnippet varSnippet = (VarSnippet) snippet;
                        System.out.println("\t\t\t\t" + varSnippet.typeName());
                        break;
                     case EXPRESSION:
                        final ExpressionSnippet expressionSnippet = (ExpressionSnippet) snippet;
                        System.out.println("\t\t\t\t" + expressionSnippet.name() + " " + expressionSnippet.typeName());
                        break;
                     case STATEMENT:
                        final StatementSnippet statementSnippet = (StatementSnippet) snippet;
                        break;
                     case ERRONEOUS:
                        final ErroneousSnippet erroneousSnippet = (ErroneousSnippet) snippet;
                        System.out.println("\t\t\t\t" + erroneousSnippet.probableKind());
                        break;
                  }
                  break;

               case RECOVERABLE_NOT_DEFINED:
               case RECOVERABLE_DEFINED:
                  final DeclarationSnippet declarationSnippet = (DeclarationSnippet) snippet;

               case DROPPED:
                  break;
               case OVERWRITTEN:
                  break;
               case REJECTED:
                  final Stream<Diag> diagnostics = shell.diagnostics(snippet);
                  diagnostics.forEach(diag ->
                        System.out.println("\t\t\t"
                              + diag.getStartPosition() + " "
                              + diag.getEndPosition() + " "
                              + diag.getCode() + " "
                              + diag.getPosition() + " "
                              + diag.getMessage(Locale.getDefault())));

                  break;
               case NONEXISTENT:

                  break;
            }
         }
         System.out.println();
      }

      shell.methods().forEach(methodSnippet -> {
         System.out.println(methodSnippet.signature());
      });

      shell.imports().forEach(importSnippet -> {
         System.out.println(importSnippet.fullname());
      });

      shell.variables().forEach(varSnippet -> {
         System.out.println(varSnippet.typeName());
      });

      System.out.println(JShellBlackboard.test);
//      });
   }
}