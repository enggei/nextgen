package nextgen.swing.components;

public class STTemplateTextArea extends JavaTextArea {

   private final String delimiter = nextgen.st.STGenerator.DELIMITER;

   public STTemplateTextArea(String text) {
      super(text);
      setSyntaxEditingStyle("text/plain");
      setClearWhitespaceLinesEnabled(true);
   }

   @Override
   protected void assignActions() {
      super.assignActions();

      getPopupMenu().add(newAction("Insert Single", actionEvent -> insertSingle()));
      getPopupMenu().add(newAction("Insert Single Capitalized", actionEvent -> insertCapitalized()));
      getPopupMenu().add(newAction("Insert List", actionEvent -> insertList()));
      getPopupMenu().add(newAction("Insert If", actionEvent -> insertIf()));
      getPopupMenu().add(newAction("Insert If-else", actionEvent -> insertIfElse()));
      getPopupMenu().add(newAction("Replace text and insert Single", actionEvent -> replaceAndInsertSingle()));
      getPopupMenu().add(newAction("Replace text", actionEvent -> replace()));
      getPopupMenu().add(newAction("Debug Template", actionEvent -> debug()));
   }

   private void insertSingle() {
      javax.swing.SwingUtilities.invokeLater(() -> {
         removeSelectedTextIfAny();
         final int caretPosition = getCaretPosition();
         insert(delim(""), caretPosition);
         setCaretPosition(caretPosition + 1);
      });
   }

   private void insertCapitalized() {
      javax.swing.SwingUtilities.invokeLater(() -> {
         removeSelectedTextIfAny();
         final int caretPosition = getCaretPosition();
         insert(delim(";format=\"capitalize\""), caretPosition);
         setCaretPosition(caretPosition + 1);
      });
   }

   private void insertList() {
      final String input = nextgen.utils.SwingUtil.showInputDialog("name", this);
      if (input == null) return;
      final String name = input.contains(" ") ? input.split(" ")[0] : input;
      final String separator = input.contains(" ") ? input.split(" ")[1] : null;
      javax.swing.SwingUtilities.invokeLater(() -> {
         removeSelectedTextIfAny();
         final int caretPosition = getCaretPosition();
         final String pre = name + ":{it|";
         final String sep = separator == null ? "" : ";separator=\"" + separator + "\"";
         final String list = pre + "}" + sep;
         insert(delim(list), caretPosition);
         setCaretPosition(caretPosition + pre.length() + 1);
      });
   }

   private void insertIf() {
      final String input = nextgen.utils.SwingUtil.showInputDialog("condition", this);
      if (input == null) return;
      final String name = input.trim();
      javax.swing.SwingUtilities.invokeLater(() -> {
         removeSelectedTextIfAny();
         final int caretPosition = getCaretPosition();
         final String pre = delim("if(" + name + ")");
         final String list = pre + delim("endif");
         insert(list, caretPosition);
         setCaretPosition(caretPosition + pre.length());
      });
   }

   private void insertIfElse() {
      final String input = nextgen.utils.SwingUtil.showInputDialog("condition", this);
      if (input == null) return;
      final String name = input.trim();
      javax.swing.SwingUtilities.invokeLater(() -> {
         removeSelectedTextIfAny();
         final int caretPosition = getCaretPosition();
         final String pre = delim("if(" + name + ")");
         final String list = pre + delim("else") + delim("endif");
         insert(list, caretPosition);
         setCaretPosition(caretPosition + pre.length());
      });
   }

   private void replaceAndInsertSingle() {
      final String selected = getSelectedText();
      if (selected == null || selected.length() < 1) return;
      final String propertyName = nextgen.utils.SwingUtil.showInputDialog("name", this);
      if (propertyName == null || propertyName.trim().length() == 0) return;

      javax.swing.SwingUtilities.invokeLater(() -> {
         final String replacement = delim(propertyName);
         final org.fife.ui.rtextarea.SearchContext context = new org.fife.ui.rtextarea.SearchContext();
         context.setSearchFor(selected);
         context.setReplaceWith(replacement);
         context.setMatchCase(true);
         context.setSearchForward(true);
         context.setWholeWord(false);
         org.fife.ui.rtextarea.SearchEngine.replaceAll(this, context);
      });
   }

   private void replace() {
      final String selected = getSelectedText();
      if (selected == null || selected.length() < 1) return;
      final String replaceWith = nextgen.utils.SwingUtil.showInputDialog("value", this);
      if (replaceWith == null || replaceWith.trim().length() == 0) return;

      javax.swing.SwingUtilities.invokeLater(() -> {
         final org.fife.ui.rtextarea.SearchContext context = new org.fife.ui.rtextarea.SearchContext();
         context.setSearchFor(selected);
         context.setReplaceWith(replaceWith);
         context.setMatchCase(true);
         context.setSearchForward(true);
         context.setWholeWord(true);
         org.fife.ui.rtextarea.SearchEngine.replaceAll(this, context);
      });
   }

   private void debug() {
      javax.swing.SwingUtilities.invokeLater(() -> nextgen.st.STParser.asST(getText().trim()).inspect());
   }

   private String delim(String expression) {
      return getDelimiter() + expression + getDelimiter();
   }

   private String getDelimiter() {
      return delimiter;
   }
}