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

      addCodeTemplate(true, "sout", "System.out.println(", ");");
      addCodeTemplate(true, "serr", "System.err.println(", ");");

      addCodeTemplate(true, "linfo", "log.info(", ");");
      addCodeTemplate(true, "lwarn", "log.warn(", ");");
      addCodeTemplate(true, "ldebug", "log.debug(", ");");

      addCodeTemplate(true, "lambda", "() -> ", ")");
      addCodeTemplate(true,  "lambdaMethod", "() -> {\n", "\n})");
      addCodeTemplate(true,  "lambdaOne", "a -> {\n", "\n})");
      addCodeTemplate(true,  "lambdaTwo", "(a, b) -> {\n", "\n})");

   }
}