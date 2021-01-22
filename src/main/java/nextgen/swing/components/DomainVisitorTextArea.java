package nextgen.swing.components;

public class DomainVisitorTextArea extends JavaTextArea {

   public DomainVisitorTextArea(String text) {
      super(text);

      setClearWhitespaceLinesEnabled(true);
   }

   @Override
   protected void assignActions() {
      super.assignActions();

      addCodeTemplate(true,   "entityName", "name(entity)", "");
      addCodeTemplate(true,   "relationName", "name(relation)", "");
      addCodeTemplate(true,   "srcName", "name(src)", "");
      addCodeTemplate(true,   "dstName", "name(dst)", "");

      addCodeTemplate(true,   "getString", "getString(\"", "\")");
      addCodeTemplate(true,   "getSet", "getSet(\"", "\")");
      addCodeTemplate(true,   "get", "get(\"", "\")");

      addCodeTemplate(true,   "app", "append(", ")");

      addCodeTemplate(true,   "set", "set(\"", "\", )");

      addCodeTemplate(true,   "new", "newBuilder(\"", "\", \"\")");
      addCodeTemplate(true,   "newe", "newBuilder(entity, \"", "\", \"\")");

      addCodeTemplate(true,   "enums", "enums(entity)", "");
      addCodeTemplate(true,   "enumsArray", "enumsArray(entity)", "");

      addCodeTemplate(true,   "write", "write(\"", "\")");
      addCodeTemplate(true,   "writeEntities", "writeEntities(\"", "\")");

   }
}