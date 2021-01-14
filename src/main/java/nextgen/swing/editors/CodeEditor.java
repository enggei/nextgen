package nextgen.swing.editors;

public class CodeEditor extends StringEditor {

   @Override
   protected void init() {
      super.init();
      textArea.setSyntaxEditingStyle("text/java");

      addCodeTemplate(true, provider, textArea, "sout", "System.out.println(", ");");
      addCodeTemplate(true, provider, textArea, "lambda", "() -> ", ")");
      addCodeTemplate(true, provider, textArea, "lambdaMethod", "() -> {\n", "\n})");
      addCodeTemplate(true, provider, textArea, "lambdaOne", "a -> {\n", "\n})");
      addCodeTemplate(true, provider, textArea, "lambdaTwo", "(a, b) -> {\n", "\n})");
   }
}