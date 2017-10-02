package com.generator.util;

import com.jgoodies.forms.builder.FormBuilder;
import com.jgoodies.forms.debug.FormDebugPanel;
import com.jgoodies.forms.layout.CellConstraints;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.io.File;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.OK_CANCEL_OPTION;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;

public class SwingUtil {

   public static String fromClipboard() {
      final Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
      final Transferable contents = clipboard.getContents(null);
      if ((contents != null) && contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
         try {
            return (String) contents.getTransferData(DataFlavor.stringFlavor);
         } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
         }
      }
      return "";
   }

   public static void showPanel(final JComponent component) {
      SwingUtil.setLookAndFeel_Nimbus();

      final JFrame frame = new JFrame();
      frame.getContentPane().add(component, BorderLayout.CENTER);
      frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      show(frame);
   }

   public static void toClipboard(String content) {
      StringSelection stringSelection = new StringSelection(content);
      Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
      clipboard.setContents(stringSelection, (clipboard1, contents) -> {
         // don't care ?
      });
   }

   public static File showOpenDir(Component parent, String dir) {
      final JFileChooser fc = dir == null || (!new File(dir).isDirectory()) ? new JFileChooser() : new JFileChooser(dir);
      fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
      final int result = fc.showOpenDialog(parent);
      return JFileChooser.APPROVE_OPTION == result ? fc.getSelectedFile() : null;
   }

   public static File showOpenFile(Component parent, String dir) {
      final JFileChooser fc = dir == null ? new JFileChooser() : new JFileChooser(new File(dir).isDirectory() ? new File(dir) : new File(dir).getParentFile());
      final int result = fc.showOpenDialog(parent);
      return JFileChooser.APPROVE_OPTION == result ? fc.getSelectedFile() : null;
   }

   public static void showTextResult(String title, String text, Component parentComponent) {
      showTextResult(title, text, parentComponent, true);
   }

   public static void showTextResult(String title, String text, Component parentComponent, boolean modal) {
      showTextResult(title, text, parentComponent, new Dimension(800, 600), modal);
   }

   public static void showTextResult(String title, String text, Component parentComponent, Dimension defaultSize, boolean modal) {
      final JPanel panel = new JPanel(new BorderLayout());
      panel.add(new JLabel(title + " : "), BorderLayout.NORTH);

      final JTextArea txtEditor = new JTextArea(text);
      txtEditor.setFont(new Font("Hack", Font.PLAIN, 10));
      txtEditor.setTabSize(3);
      txtEditor.setCaretPosition(0);
      txtEditor.setEditable(false);

      final JScrollPane content = new JScrollPane(txtEditor);
      if (defaultSize != null) {
         content.setMaximumSize(defaultSize);
         content.setPreferredSize(defaultSize);
         content.setMinimumSize(defaultSize);
         content.setSize(defaultSize);
      }
      panel.add(content, BorderLayout.CENTER);

      if (modal)
         showDialog(content, parentComponent, "Text", null, true);
      else
         JOptionPane.showMessageDialog(parentComponent, panel, "Text", INFORMATION_MESSAGE);
   }

   public static void showTextInput(String title, JTextArea textArea, Component component, ConfirmAction onSave) {
      final JPanel panel = new JPanel(new BorderLayout(5, 5));
      panel.add(new JLabel(title + " : "), BorderLayout.NORTH);
      final JScrollPane content = new JScrollPane(textArea);
      content.setMaximumSize(new Dimension(800, 600));
      content.setPreferredSize(new Dimension(800, 600));
      content.setMinimumSize(new Dimension(800, 600));
      content.setSize(new Dimension(800, 600));
      panel.add(content, BorderLayout.CENTER);

      showDialog(panel, component, title, onSave);
   }

   public static void showException(String message, Throwable throwable, Component component) {

      final String stacktrace = printStackTrace(throwable);

      if (component != null) {
         final JPanel panel = new JPanel(new BorderLayout());
         panel.add(new JLabel(message + " : "), BorderLayout.NORTH);
         final JScrollPane content = new JScrollPane(new JTextArea(stacktrace));
         content.setMaximumSize(new Dimension(800, 600));
         content.setPreferredSize(new Dimension(800, 600));
         content.setMinimumSize(new Dimension(800, 600));
         content.setSize(new Dimension(800, 600));
         panel.add(content, BorderLayout.CENTER);
         JOptionPane.showMessageDialog(component, panel, "Exception", JOptionPane.ERROR_MESSAGE);
      } else {
         System.out.println(stacktrace);
      }
   }

   @NotNull
   public static String printStackTrace(Throwable throwable) {
      final StringWriter stacktrace = new StringWriter();
      throwable.printStackTrace(new PrintWriter(stacktrace));
      return stacktrace.toString();
   }

   public static void showException(Throwable throwable, Component component) {
      showException("", throwable, component);
   }

   public static void showMessage(String message, Component component) {
      JOptionPane.showMessageDialog(component, message);
   }

   private static JFrame getFrame(Component child) {
      return (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, child);
   }

   public static void showDialog(final Component content, final Component owner, String title) {
      showDialog(content, owner, title, null);
   }

   // todo: combine showDialog and showDialogNoDefaultButton

   public static void showDialog(final Component content, final Component owner, String title, final ConfirmAction onSave) {
      showDialog(content, owner, title, onSave, true);
   }

   public static void showDialog(final Component content, final Component owner, String title, final ConfirmAction onSave, boolean modal) {
      final JDialog dialog = new JDialog(SwingUtil.getFrame(owner), title, modal);
      final Component component = content instanceof FormPanel ? ((FormPanel) content).build() : (content instanceof DebugFormPanel ? ((DebugFormPanel) content).build() : content);
      dialog.add(component, BorderLayout.CENTER);
      final JPanel commandPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

      if (onSave != null) {
         JButton btnSave;
         commandPanel.add(btnSave = new JButton(new AbstractAction(onSave.getConfirmTitle()) {
            @Override
            public void actionPerformed(ActionEvent e) {
               try {
                  onSave.verifyAndCommit();
                  dialog.dispose();
               } catch (Exception e1) {
                  SwingUtil.showException(e1, content);
               }
            }
         }));
         dialog.getRootPane().setDefaultButton(btnSave);
      }

      commandPanel.add(new JButton(new AbstractAction(onSave == null ? "Close" : onSave.getCancelTitle()) {
         @Override
         public void actionPerformed(ActionEvent e) {
            SwingUtilities.invokeLater(dialog::dispose);
         }
      }));
      dialog.add(commandPanel, BorderLayout.SOUTH);

      showDialog(dialog, owner);
   }

   public static void showCloseDialog(final Component content, final Component owner, String title, final OnClosed onClosed) {
      final JDialog dialog = new JDialog(SwingUtil.getFrame(owner), title, true);
      dialog.add(content, BorderLayout.CENTER);
      final JPanel commandPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

      commandPanel.add(new JButton(new AbstractAction("Close") {
         @Override
         public void actionPerformed(ActionEvent e) {
            SwingUtilities.invokeLater(dialog::dispose);
         }
      }));
      dialog.add(commandPanel, BorderLayout.SOUTH);

      dialog.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosed(WindowEvent e) {
            onClosed.onClosed();
         }
      });

      showDialog(dialog, owner);
   }

   public static void showDialog(final JDialog dialog, final Component owner) {
      SwingUtilities.invokeLater(() -> {
         dialog.pack();
         dialog.setLocationRelativeTo(owner);
         dialog.setVisible(true);
      });
   }

   public static String showInputDialog(String message, Component owner) {
      return JOptionPane.showInputDialog(owner, message);
   }

   public static String showInputDialog(String message, Component owner, String defaultValue) {
      final String newValue = JOptionPane.showInputDialog(owner, message, defaultValue);
      return newValue == null ? defaultValue : newValue;
   }

   public static void showException(Component parent, Throwable t) {
      t.printStackTrace();
      JOptionPane.showMessageDialog(parent, t.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
   }

   public static void showExceptionNoStack(Component parent, Throwable t) {
      JOptionPane.showMessageDialog(parent, t.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
   }

   public static void setLookAndFeel_Nimbus() {
      setLookAndFeel();
   }


   private static void setLookAndFeel() {
      for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
         if ("Nimbus".equals(laf.getName())) {
            try {
               UIManager.setLookAndFeel(laf.getClassName());
            } catch (Exception e) {
               System.err.println("Could not set look and feel '" + "Nimbus" + "': " + e.getMessage());
            }
         }
      }
   }

   private static void printSwingDefaults(PrintStream out) {

      final UIDefaults uid = UIManager.getDefaults();
      final Enumeration uidKeys = uid.keys();
      final String cr = System.getProperty("line.separator");
      final TreeMap<Object, Object> sortedMap = new TreeMap<>();

      Object uidKey;
      while (uidKeys.hasMoreElements()) {
         uidKey = uidKeys.nextElement();
         sortedMap.put(uidKey.toString(), uid.get(uidKey));
      }

      for (Object key : sortedMap.keySet()) out.print(key + "=" + sortedMap.get(key) + cr);


      UIManager.put("OptionPane.cancelButtonText", "Cancel");
      UIManager.put("OptionPane.noButtonText", "No");
      UIManager.put("OptionPane.okButtonText", "Confirm");
      UIManager.put("OptionPane.yesButtonText", "Yes");

      System.out.println(UIManager.getString("OptionPane.yesButtonTest"));
      JOptionPane.showConfirmDialog(new JFrame(), "Message", "Test", OK_CANCEL_OPTION);
   }

   public static void showDialog(final JDialog dialog, final Component relativeTo, final Component contentPane, final JButton confirmAction, final JButton cancelAction, final JButton defaultAction) {
      dialog.add(contentPane, BorderLayout.CENTER);
      final JPanel commandPane = new JPanel(new FlowLayout(FlowLayout.RIGHT));
      commandPane.add(confirmAction);
      commandPane.add(cancelAction);
      dialog.add(commandPane, BorderLayout.SOUTH);
      dialog.getRootPane().setDefaultButton(defaultAction);
      SwingUtilities.invokeLater(() -> {
         dialog.pack();
         if (relativeTo != null) dialog.setLocationRelativeTo(relativeTo);
         dialog.setVisible(true);
      });
   }

   public static void main(String[] args) {
      printSwingDefaults(System.out);
   }

   public static void show(final JFrame frame) {
      SwingUtilities.invokeLater(() -> {
         frame.pack();
         frame.setLocationByPlatform(true);
         frame.setVisible(true);
      });
   }

   public static void showPopup(final JPopupMenu pop, final Component invoker, final MouseEvent e) {
      SwingUtilities.invokeLater(() -> {
         pop.setInvoker(invoker);
         pop.show(invoker, e.getX(), e.getY());
      });
   }

   public static boolean showConfirmDialog(Component parent, String message) {
      return JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(parent, message);
   }

   @SuppressWarnings("unchecked")
   public static <T> T showInputDialog(Component parent, String message, String title, java.util.List<T> values) {
      return (T) JOptionPane.showInputDialog(parent, message, title, QUESTION_MESSAGE, null, values.toArray(), values.get(0));
   }

   public static void showDialog(final JDialog dialog, final Dimension size, final Component owner) {
      SwingUtilities.invokeLater(() -> {
         try {
            if (size == null) dialog.pack();
            else dialog.setSize(size);
            dialog.setLocationRelativeTo(owner);
            dialog.setVisible(true);
         } catch (Exception e) {
            e.printStackTrace();
         }
      });
   }

   @SuppressWarnings("unchecked")
   public static <T> T showSelectDialog(Component parent, T[] available) {
      return (T) JOptionPane.showInputDialog(parent, "Available ", "Select", JOptionPane.QUESTION_MESSAGE, null, available, available.length == 0 ? null : available[0]);
   }

   @SuppressWarnings("unchecked")
   public static <T> T showSelectDialog(Component parent, T[] available, T selected) {
      return (T) JOptionPane.showInputDialog(parent, "Available ", "Select", QUESTION_MESSAGE, null, available, selected);
   }

   @SuppressWarnings("unchecked")
   public static <T> T showSelectDialog(Component parent, Collection<T> list) {
      if (list == null || list.size() == 0) return null;

      final T[] available = (T[]) list.toArray();
      return (T) JOptionPane.showInputDialog(parent, "Available: ", "Select", QUESTION_MESSAGE, null, available, available.length == 0 ? null : available[0]);
   }

   @SuppressWarnings("unchecked")
   public static <T> T showSelectDialog(Component parent, Collection<T> list, T selected) {
      if (list == null || list.size() == 0) return null;

      final T[] available = (T[]) list.toArray();
      return (T) JOptionPane.showInputDialog(parent, "Available: ", "Select", QUESTION_MESSAGE, null, available, selected);
   }

   public static void selectByLevensthein(JComboBox<Object> comboBox, Object[] values, String value) {
      int min = Integer.MAX_VALUE;
      String defaultValue = null;
      for (Object property : values) {
         int dist = StringUtil.levensthein(property.toString(), value);
         if (dist < min) {
            min = dist;
            defaultValue = property.toString();
         }
      }
      if (defaultValue != null) comboBox.setSelectedItem(defaultValue);
   }

   public static abstract class ConfirmAction {

      private final String confirmTitle;
      private final String cancelTitle;

      public ConfirmAction() {
         this("Save", "Cancel");
      }

      public ConfirmAction(String confirmTitle) {
         this(confirmTitle, "Cancel");
      }

      public ConfirmAction(String confirmTitle, String cancelTitle) {
         this.confirmTitle = confirmTitle;
         this.cancelTitle = cancelTitle;
      }

      public abstract void verifyAndCommit() throws Exception;

      String getConfirmTitle() {
         return confirmTitle;
      }

      String getCancelTitle() { return cancelTitle; }
   }

   public interface OnClosed {
      void onClosed();
   }


   public static class DebugFormPanel extends FormDebugPanel {

      private FormBuilder builder;
      private final CellConstraints cc;
      private final CellConstraints.Alignment colAlign;
      private final CellConstraints.Alignment rowAlign;

      public DebugFormPanel(String columns, String rows) {
         this(columns, rows, CellConstraints.FILL, CellConstraints.FILL);
      }

      DebugFormPanel(String columns, String rows, CellConstraints.Alignment colAlign, CellConstraints.Alignment rowAlign) {
         this.cc = new CellConstraints();
         this.builder = FormBuilder.create().debug(true).columns(columns).rows(rows);
         this.colAlign = colAlign;
         this.rowAlign = rowAlign;
      }

      public void add(Component component, int column, int row) {
         this.add(component, column, row, 1, 1);
      }

      public void add(Component component, int column, int row, CellConstraints.Alignment colAlign, CellConstraints.Alignment rowAlign) {
         this.add(component, column, row, 1, 1, colAlign, rowAlign);
      }

      public void add(Component component, int column, int row, int colSpan, int rowSpan) {
         this.add(component, column, row, colSpan, rowSpan, this.colAlign, this.rowAlign);
      }

      public void addLabel(String text, int column, int row) {
         this.addLabel(text, column, row, this.colAlign, this.rowAlign);
      }

      public void addLabel(String text, int column, int row, CellConstraints.Alignment colAlign, CellConstraints.Alignment rowAlign) {
         this.addLabel(text, column, row, 1, 1, colAlign, rowAlign);
      }

      public void addLabel(String text, int column, int row, int colSpan, int rowSpan) {
         this.add(new JLabel(text), column, row, colSpan, rowSpan, this.colAlign, this.rowAlign);
      }

      public void addLabel(String text, int column, int row, int colSpan, int rowSpan, CellConstraints.Alignment colAlign, CellConstraints.Alignment rowAlign) {
         final JLabel label = new JLabel(text);
         label.setFont(label.getFont().deriveFont(Font.BOLD));
         this.add(label, column, row, colSpan, rowSpan, colAlign, rowAlign);
      }

      public void addScrollPane(Component component, int column, int row, int colSpan, int rowSpan) {
         this.add(new JScrollPane(component), column, row, colSpan, rowSpan, this.colAlign, this.rowAlign);
      }

      public void addSeparator(String text, int column, int row, int colSpan, int rowSpan) {
         this.builder.addSeparator(text, this.cc.xywh(column, row, colSpan, rowSpan));
      }

      public void add(Component component, int column, int row, int colSpan, int rowSpan, CellConstraints.Alignment colAlign, CellConstraints.Alignment rowAlign) {
         this.builder.add(component).at(this.cc.xywh(column, row, colSpan, rowSpan, colAlign, rowAlign));
      }

      protected void setTitledBorder(String title) {
         this.setBorder(BorderFactory.createTitledBorder(" " + title + " "));
      }

      public JPanel build() {
         return builder.build();
      }
   }

   public static class FormPanel extends JPanel {
      private FormBuilder builder;
      private final CellConstraints cc;
      private final CellConstraints.Alignment colAlign;
      private final CellConstraints.Alignment rowAlign;

      public FormPanel() {
         this("", "");
      }

      public FormPanel(String columns, String rows) {
         this(columns, rows, CellConstraints.FILL, CellConstraints.FILL);
      }

      public FormPanel(String columns, String rows, Component... components) {
         this(columns, rows, CellConstraints.FILL, CellConstraints.FILL);

         final int columnCount = rows.split(",").length;
         int column = 1;
         int row = 1;
         for (Component component : components) {
            add(component, column, row);
            column += 2;
            if (column > columnCount) {
               column = 1;
               row += 2;
            }
         }
      }

      public JPanel build() {
         return builder.getPanel();
      }

      public FormPanel(String columns, String rows, CellConstraints.Alignment colAlign, CellConstraints.Alignment rowAlign) {
         this.cc = new CellConstraints();
         this.builder = FormBuilder.create().columns(columns).rows(rows);
         this.colAlign = colAlign;
         this.rowAlign = rowAlign;
      }

      public void add(Component component, int column, int row) {
         this.add(component, column, row, 1, 1);
      }

      public void add(Component component, int column, int row, CellConstraints.Alignment colAlign, CellConstraints.Alignment rowAlign) {
         this.add(component, column, row, 1, 1, colAlign, rowAlign);
      }

      public void add(Component component, int column, int row, int colSpan, int rowSpan) {
         this.add(component, column, row, colSpan, rowSpan, this.colAlign, this.rowAlign);
      }

      public JLabel addLabel(String text, int column, int row) {
         return this.addLabel(text, column, row, this.colAlign, this.rowAlign);
      }

      public JLabel addLabel(String text, int column, int row, CellConstraints.Alignment colAlign, CellConstraints.Alignment rowAlign) {
         return this.addLabel(text, column, row, 1, 1, colAlign, rowAlign);
      }

      public JLabel addLabel(String text, int column, int row, int colSpan, int rowSpan, CellConstraints.Alignment colAlign, CellConstraints.Alignment rowAlign) {
         final JLabel label = new JLabel(text);
         this.add(label, column, row, colSpan, rowSpan, colAlign, rowAlign);
         return label;
      }

      public void addScrollPane(Component component, int column, int row, int colSpan, int rowSpan) {
         this.add(new JScrollPane(component), column, row, colSpan, rowSpan, this.colAlign, this.rowAlign);
      }

      public void addSeparator(String text, int column, int row, int colSpan, int rowSpan) {
         this.builder.addSeparator(text, this.cc.xywh(column, row, colSpan, rowSpan));
      }

      public void add(Component component, int column, int row, int colSpan, int rowSpan, CellConstraints.Alignment colAlign, CellConstraints.Alignment rowAlign) {
         this.builder.add(component).at(this.cc.xywh(column, row, colSpan, rowSpan, colAlign, rowAlign));
      }

      protected void setTitledBorder(String title) {
         this.setBorder(BorderFactory.createTitledBorder(" " + title + " "));
      }
   }

   public static void tryToHighlight(JTextComponent txtEditor, final List<String> selectedText, final Highlighter.HighlightPainter highlightPainter) {
      SwingUtilities.invokeLater(() -> highLight(txtEditor, selectedText, highlightPainter));
   }

   private static void highLight(JTextComponent textComp, Iterable<String> pattern, Highlighter.HighlightPainter highlightPainter) {

      removeHighlights(textComp);

      try {

         // escape '$' if its used in patterns:
         final StringBuilder out = new StringBuilder();
         boolean first = true;
         for (String item : pattern) {
            if (!first) out.append("|");
            first = false;
            out.append(item.replaceAll("\\$", "\\\\\\$").replaceAll("\\(", "\\\\\\(").replaceAll("\\)", "\\\\\\)"));
         }

         final Pattern r = Pattern.compile(out.toString());
         final Matcher matcher = r.matcher(textComp.getText());
         final Highlighter highlighter = textComp.getHighlighter();
         while (matcher.find()) {
            highlighter.addHighlight(matcher.start(), matcher.end(), highlightPainter);
         }

      } catch (BadLocationException ignored) {
         ignored.printStackTrace();
      }
   }

   private static void removeHighlights(JTextComponent textComp) {
      final Highlighter highlighter = textComp.getHighlighter();
      final Highlighter.Highlight[] highlights = highlighter.getHighlights();
      for (Highlighter.Highlight highlight : highlights) {
         if (highlight.getPainter() instanceof DefaultHighlighter.DefaultHighlightPainter) {
            highlighter.removeHighlight(highlight);
         }
      }
   }
}