package nextgen.swing.components;

public class DomainVisitorTextArea extends JavaTextArea {

   public DomainVisitorTextArea(String text) {
      super(text);

      setClearWhitespaceLinesEnabled(true);
   }

   @Override
   protected void assignActions() {
      super.assignActions();

      addCodeTemplate(true, provider,  "entityName", "name(entity)", "");
      addCodeTemplate(true, provider,  "relationName", "name(relation)", "");
      addCodeTemplate(true, provider,  "srcName", "name(src)", "");
      addCodeTemplate(true, provider,  "dstName", "name(dst)", "");

      addCodeTemplate(true, provider,  "gstring", "getString(\"", "\")");
      addCodeTemplate(true, provider,  "gset", "getSet(\"", "\")");
      addCodeTemplate(true, provider,  "get", "get(\"", "\")");

      addCodeTemplate(true, provider,  "new", "newBuilder(\"", "\", \"\")");
      addCodeTemplate(true, provider,  "newe", "newBuilder(entity, \"", "\", \"\")");

      addCodeTemplate(true, provider,  "write", "write(\"", "\")");
      addCodeTemplate(true, provider,  "writeEntities", "writeEntities(\"", "\")");

   }
}