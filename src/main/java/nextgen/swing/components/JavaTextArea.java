package nextgen.swing.components;

public class JavaTextArea extends BaseTextArea {

   public JavaTextArea() {
      setSyntaxEditingStyle("text/java");
   }

   public JavaTextArea(String text) {
      super(text);
      setSyntaxEditingStyle("text/java");
   }

   @Override
   protected void assignActions() {
      super.assignActions();

      addCodeTemplate(true, provider, "sout", "System.out.println(", ");");
      addCodeTemplate(true, provider, "lambda", "() -> ", ")");
      addCodeTemplate(true, provider,  "lambdaMethod", "() -> {\n", "\n})");
      addCodeTemplate(true, provider,  "lambdaOne", "a -> {\n", "\n})");
      addCodeTemplate(true, provider,  "lambdaTwo", "(a, b) -> {\n", "\n})");
   }
}