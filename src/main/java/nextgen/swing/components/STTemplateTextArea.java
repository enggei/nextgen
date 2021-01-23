package nextgen.swing.components;

public class STTemplateTextArea extends JavaTextArea {

   private final String delimiter = nextgen.st.STGenerator.DELIMITER;

   private final javax.swing.border.Border defaultBorder = getBorder();
   private final java.awt.Color uneditedColor = getBackground();
   private final java.awt.Color editedColor = getBackground().brighter();
   private final java.awt.Color errorColor = java.awt.Color.decode("#e66101");
   private String startText;

   public STTemplateTextArea(String text) {
      super(text);
      setSyntaxEditingStyle("text/plain");
      setClearWhitespaceLinesEnabled(true);
      startText = text;
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

      addKeyListener(new java.awt.event.KeyAdapter() {
         @Override
         public void keyPressed(java.awt.event.KeyEvent keyEvent) {
            if (keyEvent.getModifiers() == java.awt.event.KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == java.awt.event.KeyEvent.VK_L) {
               insertList();
            } else if (keyEvent.getModifiers() == java.awt.event.KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == java.awt.event.KeyEvent.VK_I) {
               insertIf();
            } else if (keyEvent.getModifiers() == java.awt.event.KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == java.awt.event.KeyEvent.VK_E) {
               insertIfElse();
            } else if (keyEvent.getModifiers() == java.awt.event.KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == java.awt.event.KeyEvent.VK_Q) {
               insertCapitalized();
            } else if (keyEvent.getModifiers() == java.awt.event.KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == java.awt.event.KeyEvent.VK_P) {
               insertSingle();
            } else if (keyEvent.getModifiers() == java.awt.event.KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == java.awt.event.KeyEvent.VK_R) {
               replaceAndInsertSingle();
            } else if (keyEvent.getModifiers() == java.awt.event.KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == java.awt.event.KeyEvent.VK_F) {
               format();
            }
         }
      });
   }

   private void format() {
      nextgen.utils.SwingUtil.format(this);
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

   public void modelToView(nextgen.model.STTemplate model) {
      final nextgen.model.STGroupModel stGroup = nextgen.swing.STAppPresentationModel.getSTGroup(model);
      setSyntaxEditingStyle(stGroup.getLanguage());
      setText(model.getText());

      setBorder(defaultBorder);
      removeAllLineHighlights();
      setToolTipText("");
   }

   public void viewToModel(nextgen.model.STTemplate model) {

      // bugfix: if there are '>>' in template, StringTemplate does not parse it, as '>>' is used as part of the template-definition:
      // gt() is a 'private/hidden' template which is used to solve this issue
      String text = getText().trim().replaceAll(">>", ">" + delimiter + "gt()" + delimiter);

      final nextgen.model.parser.ParseResult parseResult = nextgen.st.STParser.parseTemplate(text);
      if (parseResult.getErrors().isEmpty()) {

         setBorder(defaultBorder);
         removeAllLineHighlights();
         setToolTipText("");

         nextgen.st.STParser.mergeTemplate(parseResult.getParsed().getTemplates().stream().findFirst().get(), model);
         startText = text;
         setBackground(startText.trim().equals(getText().trim()) ? uneditedColor : editedColor);

         model.setText(text);

      } else {

         setBorder(javax.swing.BorderFactory.createLineBorder(errorColor));
         removeAllLineHighlights();
         setToolTipText(nextgen.st.STParser.toString(parseResult.getErrors()));

         parseResult.getErrors().forEach(parserError -> {
            try {
               addLineHighlight(parserError.getLine() - 1, java.awt.Color.decode("#b2182b"));
            } catch (javax.swing.text.BadLocationException ignored) {

            }
         });
      }
   }
}