package nextgen.swing;


import javax.swing.*;

public class AbstractEditor extends javax.swing.JPanel {

   protected final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AbstractEditor.class);

   public AbstractEditor() {
      super(new java.awt.BorderLayout());
      ComponentFactory.decorate(this);
      setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
   }

   public String title() {
      return "Editor";
   }

   protected nextgen.swing.STAppPresentationModel appModel() {
      return nextgen.swing.AppModel.getInstance().getSTAppPresentationModel();
   }


   protected javax.swing.JTextField newTextField() {
      return newTextField("", 30);
   }

   protected javax.swing.JTextField newTextField(int columns) {
      return newTextField("", columns);
   }

   protected javax.swing.JTextField newTextField(String text) {
      return newTextField(text, 30);
   }

   protected javax.swing.JTextField newTextField(String text, int columns) {
      return newTextField(text, columns, new String[0], -1);
   }

   protected javax.swing.JTextField newTextField(int columns, String[] options) {
      return newTextField("", columns, options, 0);
   }

   protected javax.swing.JTextField newTextField(String text, int columns, java.util.List<String> options, int startIndex) {
      return newTextField(text, columns, options.toArray(new String[options.size()]), startIndex);
   }

   protected javax.swing.JTextField newTextField(String text, int columns, String[] options, int startIndex) {
      return nextgen.utils.SwingUtil.newTextField(text, columns, options, startIndex);
   }

   protected javax.swing.JLabel newLabel(String name) {
      return nextgen.swing.ComponentFactory.newJLabel(name);
   }

   protected void input(javax.swing.JComponent owner, String message, java.util.function.Consumer<String> consumer) {
      nextgen.utils.SwingUtil.showInputDialog(message, owner, inputValue -> appModel().doLaterInTransaction(transaction1 -> consumer.accept(inputValue)));
   }


   protected <T> void selectAndRender(javax.swing.JComponent owner, java.util.Collection<T> values, java.util.function.Function<T, String> renderer, T defaultValue, java.util.function.Consumer<T> consumer) {
      nextgen.utils.SwingUtil.showSelectDialog("Select", owner, values, renderer, defaultValue, selected -> appModel().doLaterInTransaction(transaction1 -> consumer.accept(selected)));
   }

   protected javax.swing.JButton newButton(String name, java.util.function.Consumer<org.neo4j.graphdb.Transaction> onClick) {
      return nextgen.swing.ComponentFactory.newJButton(appModel().newTransactionAction(name, onClick));
   }

   protected javax.swing.JButton newButton(Action action) {
      return nextgen.swing.ComponentFactory.newJButton(action);
   }

   protected javax.swing.JButton newButton(String name, int hAlign, java.util.function.Consumer<org.neo4j.graphdb.Transaction> onClick) {
      final JButton component = ComponentFactory.newJButton(appModel().newTransactionAction(name, onClick));
      component.setHorizontalTextPosition(hAlign);
      return component;
   }

   protected javax.swing.JButton newRightAlignedButton(Action action) {
      final JButton jButton = newButton(action);
      jButton.setHorizontalAlignment(SwingConstants.RIGHT);
      return jButton;
   }

   protected javax.swing.JButton newRightAlignedButton(String name, java.util.function.Consumer<org.neo4j.graphdb.Transaction> onClick) {
      final JButton jButton = newButton(name, SwingConstants.RIGHT, onClick);
      jButton.setHorizontalAlignment(SwingConstants.RIGHT);
      return jButton;
   }

   protected java.awt.event.KeyListener getEditorKeyListener() {
      return new java.awt.event.KeyAdapter() {
         @Override
         public void keyPressed(java.awt.event.KeyEvent keyEvent) {
            if (keyEvent.getModifiers() == java.awt.event.KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == java.awt.event.KeyEvent.VK_S) {
               appModel().doLaterInTransaction(transaction -> {
                  tryToSave();
               });
            }
         }
      };
   }

   protected void tryToSave() {
   }

   protected javax.swing.JPopupMenu addPopupActions(org.fife.ui.rsyntaxtextarea.RSyntaxTextArea textArea) {
      final javax.swing.JPopupMenu pop = textArea.getPopupMenu();
      pop.addSeparator();
      pop.add(newAction("Replace with Clipboard", actionEvent -> replaceWithClipboard(textArea)));
      pop.add(newAction("Append from Clipboard", actionEvent -> appendFromClipboard(textArea)));
      pop.add(newAction("Prepend from Clipboard", actionEvent -> prependFromClipboard(textArea)));
      pop.add(newAction("Select from Clipboard", actionEvent -> selectFromClipboard(textArea)));
      pop.addSeparator();
      pop.add(newAction("Select Line", actionEvent -> selectLine(textArea)));
      pop.add(newAction("To Clipboard", actionEvent -> toClipboard(textArea)));
      return pop;
   }

   protected void replaceWithClipboard(org.fife.ui.rsyntaxtextarea.RSyntaxTextArea textArea) {
      if (!textArea.isEditable()) return;
      textArea.setText(nextgen.utils.SwingUtil.fromClipboard().trim());
      textArea.setCaretPosition(0);
      tryToSave();
   }

   protected void selectFromClipboard(org.fife.ui.rsyntaxtextarea.RSyntaxTextArea textArea) {
      if (!textArea.isEditable()) return;

      appModel().doLaterInTransaction(transaction -> {
         nextgen.utils.SwingUtil.selectFromClipboard(textArea, o -> {
            textArea.setText(o.toString().trim());
            textArea.setCaretPosition(0);
            tryToSave();
         });
      });
   }

   protected void prependFromClipboard(org.fife.ui.rsyntaxtextarea.RSyntaxTextArea textArea) {
      if (!textArea.isEditable()) return;
      textArea.setText(nextgen.utils.SwingUtil.fromClipboard().trim() + textArea.getText());
      textArea.setCaretPosition(0);
      tryToSave();
   }

   protected void appendFromClipboard(org.fife.ui.rsyntaxtextarea.RSyntaxTextArea textArea) {
      if (!textArea.isEditable()) return;
      textArea.append(nextgen.utils.SwingUtil.fromClipboard().trim());
      textArea.setCaretPosition(0);
      tryToSave();
   }

   protected void selectLine(org.fife.ui.rsyntaxtextarea.RSyntaxTextArea textArea) {
      final int startOffsetOfCurrentLine = textArea.getLineStartOffsetOfCurrentLine();
      final int endOffsetOfCurrentLine = textArea.getLineEndOffsetOfCurrentLine();
      try {
         final String line = textArea.getText(startOffsetOfCurrentLine, endOffsetOfCurrentLine - startOffsetOfCurrentLine).trim();
         log.info(line);
         nextgen.utils.SwingUtil.toClipboard(line);
      } catch (javax.swing.text.BadLocationException ignored) {

      }
   }

   protected void toClipboard(org.fife.ui.rsyntaxtextarea.RSyntaxTextArea textArea) {
      nextgen.utils.SwingUtil.toClipboard(textArea.getText().trim());
   }

   protected FlowPanel newFlowPanel() {
      return new nextgen.swing.AbstractEditor.FlowPanel();
   }

   protected ColumnPanel newColumnPanel() {
      return new AbstractEditor.ColumnPanel();
   }

   protected GridPanel newGridPanel(int rows, int cols) {
      return new AbstractEditor.GridPanel(rows, cols);
   }

   protected static class FlowPanel extends BasePanel {
      FlowPanel() {
         super();
         setLayout(nextgen.swing.ComponentFactory.newBoxLineLayout(this));
      }
   }

   protected static class ColumnPanel extends BasePanel {
      ColumnPanel() {
         super();
         setLayout(nextgen.swing.ComponentFactory.newBoxPageLayout(this));
      }
   }

   protected static class GridPanel extends BasePanel {
      GridPanel(int rows, int cols) {
         super();
         setLayout(new java.awt.GridLayout(rows, cols, 4, 4));
      }
   }

   protected javax.swing.Action newAction(String name, java.util.function.Consumer<java.awt.event.ActionEvent> consumer) {
      return new javax.swing.AbstractAction(name) {
         @Override
         public void actionPerformed(java.awt.event.ActionEvent e) {
            consumer.accept(e);
         }
      };
   }

   protected void clearEditor() {
      removeAll();
      editorUpdated();
   }

   protected void editorUpdated() {
      revalidate();
      repaint();
   }

   public static class BasePanel extends javax.swing.JPanel {

      public BasePanel() {
         ComponentFactory.decorate(this);
         setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
      }

      public AbstractEditor.BasePanel append(javax.swing.JComponent jComponent) {
         add(jComponent);
         return this;
      }

      public AbstractEditor.BasePanel appendLabel(String label) {
         add(nextgen.swing.ComponentFactory.newJLabel(label));
         return this;
      }
   }
}