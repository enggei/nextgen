package nextgen.utils;

import com.jgoodies.forms.builder.FormBuilder;
import com.jgoodies.forms.debug.FormDebugPanel;
import com.jgoodies.forms.layout.CellConstraints;
import nextgen.st.domain.STTemplate;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.*;
import java.io.File;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.*;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static javax.swing.JOptionPane.*;

public class SwingUtil {
   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(SwingUtil.class);

   public static Font getDefaultFont() {
      return new Font("Hack", Font.PLAIN, 20);
   }

   public static JTextField newTextField() {
      return new JTextField();
   }

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

   public static void toClipboard(String content) {
      StringSelection stringSelection = new StringSelection(content);
      Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
      clipboard.setContents(stringSelection, (clipboard1, contents) -> {
         // don't care ?
      });
   }

   public static void showPanel(final JComponent component) {
      SwingUtil.setLookAndFeel_Nimbus();

      final JFrame frame = new JFrame();
      frame.getContentPane().add(component, BorderLayout.CENTER);
      frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      show(frame);
   }

   public static File showOpenDir(Component parent, String dir) {
      final JFileChooser fc = dir == null || (!new File(dir).isDirectory()) ? new JFileChooser() : new JFileChooser(dir);
      fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
      final int result = fc.showOpenDialog(parent);
      return JFileChooser.APPROVE_OPTION == result ? fc.getSelectedFile() : null;
   }

   public static Optional<File> showOpenFile(Component parent, String dir) {
      final JFileChooser fc = dir == null ? new JFileChooser() : new JFileChooser(new File(dir).isDirectory() ? new File(dir) : new File(dir)
            .getParentFile());
      final int result = fc.showOpenDialog(parent);
      return Optional.ofNullable(JFileChooser.APPROVE_OPTION == result ? fc.getSelectedFile() : null);
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
      txtEditor.setBackground(UIManager.getColor("Panel.background"));
      txtEditor.setTabSize(3);
      txtEditor.setCaretPosition(0);

      final JScrollPane content = new JScrollPane(txtEditor);
      content.setBackground(Color.getColor("Panel.background"));
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
         log.info(stacktrace);
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
      final Component component = content instanceof FormPanel ? ((FormPanel) content).build() : (content instanceof DebugFormPanel ? ((DebugFormPanel) content)
            .build() : content);
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
                  SwingUtil.showExceptionNoStack(content, e1);
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

   public static void showDialog(final JDialog dialog, final Component owner) {
      SwingUtilities.invokeLater(() -> {
         dialog.pack();
         dialog.setLocationRelativeTo(owner);
         dialog.setVisible(true);
      });
   }

   public static String showInputDialog(String message, Component owner) {
      final String s = JOptionPane.showInputDialog(owner, message);
      return s == null ? null : s.trim();
   }

   public static void showNameDialog(String message, Component owner, Consumer<String> onConfirm) {
      showInputDialog(message, owner, new Dimension(800, 600), onConfirm);
   }

   public static void showInputDialog(String message, Component owner, Consumer<String> onConfirm) {
      showInputDialog(message, owner, new Dimension(800, 600), onConfirm);
   }

   public static void showInputDialog(String message, Component owner, String startValue, Consumer<String> onConfirm) {
      showInputDialog(message, owner, new Dimension(800, 600), startValue, onConfirm);
   }

   public static void showInputDialog(String message, Component owner, Dimension dimension, Consumer<String> onConfirm) {
      showInputDialog(message, owner, dimension, null, onConfirm);
   }

   public static <T>void showSelectDialog(String message, Component owner, Set<T> set, Consumer<T> onConfirm) {
      final JComboBox<T> content = newComboBox(set, set.iterator().next());
      final JDialog dialog = new JDialog(SwingUtil.getFrame(owner), message, true);
      dialog.add(content, BorderLayout.CENTER);
      final JPanel commandPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

      final ConfirmAction onSave = new ConfirmAction() {
         @Override
         public void verifyAndCommit() throws Exception {
            onConfirm.accept((T) content.getSelectedItem());
         }
      };

      JButton btnSave;
      commandPanel.add(btnSave = new JButton(new AbstractAction(onSave.getConfirmTitle()) {
         @Override
         public void actionPerformed(ActionEvent e) {
            try {
               onSave.verifyAndCommit();
               dialog.dispose();
            } catch (Exception e1) {
               SwingUtil.showExceptionNoStack(content, e1);
            }
         }
      }));
      dialog.getRootPane().setDefaultButton(btnSave);

      commandPanel.add(new JButton(new AbstractAction(onSave.getCancelTitle()) {
         @Override
         public void actionPerformed(ActionEvent e) {
            SwingUtilities.invokeLater(dialog::dispose);
         }
      }));
      dialog.add(commandPanel, BorderLayout.SOUTH);

      showDialog(dialog, owner);
   }

   public static void showInputDialog(String message, Component owner, Dimension dimension, String startValue, Consumer<String> onConfirm) {

      final RSyntaxTextArea rSyntaxTextArea = newRSyntaxTextArea();
      rSyntaxTextArea.setText(startValue == null ? "" : startValue);

      final JPanel content = new JPanel(new BorderLayout());
      content.add(new org.fife.ui.rtextarea.RTextScrollPane(rSyntaxTextArea), BorderLayout.CENTER);
      content.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
      content.setPreferredSize(dimension);

      final JDialog dialog = new JDialog(SwingUtil.getFrame(owner), message, true);
      dialog.add(content, BorderLayout.CENTER);
      final JPanel commandPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

      final ConfirmAction onSave = new ConfirmAction() {
         @Override
         public void verifyAndCommit() throws Exception {
            final String s = rSyntaxTextArea.getText().trim();
            if (s.trim().length() == 0) {
               dialog.dispose();
               return;
            }
            onConfirm.accept(s.trim());
         }
      };

      rSyntaxTextArea.addKeyListener(new KeyAdapter() {
         @Override
         public void keyPressed(KeyEvent e) {
            if (e.isControlDown() && KeyEvent.VK_S == e.getKeyCode()) {
               try {
                  onSave.verifyAndCommit();
                  dialog.dispose();
               } catch (Exception ex) {
                  ex.printStackTrace();
               }
            }
         }
      });
      JButton btnSave;
      commandPanel.add(btnSave = new JButton(new AbstractAction(onSave.getConfirmTitle()) {
         @Override
         public void actionPerformed(ActionEvent e) {
            try {
               onSave.verifyAndCommit();
               dialog.dispose();
            } catch (Exception e1) {
               SwingUtil.showExceptionNoStack(content, e1);
            }
         }
      }));
      dialog.getRootPane().setDefaultButton(btnSave);

      commandPanel.add(new JButton(new AbstractAction(onSave.getCancelTitle()) {
         @Override
         public void actionPerformed(ActionEvent e) {
            SwingUtilities.invokeLater(dialog::dispose);
         }
      }));
      dialog.add(commandPanel, BorderLayout.SOUTH);

      showDialog(dialog, owner);


   }

   public static void showException(Component parent, Throwable t) {
      t.printStackTrace();
      final StringWriter stackTrace = new StringWriter();
      t.printStackTrace(new PrintWriter(stackTrace));
      JOptionPane.showMessageDialog(parent, t.getMessage() + "\n" + stackTrace, "Exception", JOptionPane.ERROR_MESSAGE);
   }

   public static void showExceptionNoStack(Component parent, Throwable t) {
      JOptionPane.showMessageDialog(parent, t.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
   }

   public static void setLookAndFeel_Nimbus() {
      setLookAndFeel();
   }

   private static void setLookAndFeel() {
      for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
         if ("Nimbus" .equals(laf.getName())) {
            try {
               UIManager.setLookAndFeel(laf.getClassName());
            } catch (Exception e) {
               System.err.println("Could not set look and feel '" + "Nimbus" + "': " + e.getMessage());
            }
         }
      }
   }

   public static void printSwingDefaults(PrintStream out) {

      final UIDefaults uid = UIManager.getDefaults();
      final Enumeration<Object> uidKeys = uid.keys();
      final String cr = System.getProperty("line.separator");
      final TreeMap<Object, Object> sortedMap = new TreeMap<>();

      Object uidKey;
      while (uidKeys.hasMoreElements()) {
         uidKey = uidKeys.nextElement();
         sortedMap.put(uidKey.toString(), uid.get(uidKey));
      }

      for (Object key : sortedMap.keySet()) out.print(key + "=" + sortedMap.get(key) + cr);

//      UIManager.put("OptionPane.cancelButtonText", "Cancel");
//      UIManager.put("OptionPane.noButtonText", "No");
//      UIManager.put("OptionPane.okButtonText", "Confirm");
//      UIManager.put("OptionPane.yesButtonText", "Yes");
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

   public static <T> JComboBox<T> newComboBox(T[] enumValues, T selected) {
      return newComboBox(new LinkedHashSet<>(Arrays.asList(enumValues)), selected);
   }

   @SuppressWarnings("unchecked")
   public static <T> JComboBox<T> newComboBox(Set<T> enumValues, T selected) {
      final T[] values = (T[]) new Object[enumValues.size()];
      int index = 0;
      for (T enumValue : enumValues)
         values[index++] = enumValue;
      final JComboBox<T> comboBox = new JComboBox<>(values);
      if (selected != null) comboBox.setSelectedItem(selected);
      return comboBox;
   }

   public static abstract class ConfirmAction {

      private final String confirmTitle;
      private final String cancelTitle;

      public ConfirmAction() {
         this("Save", "Cancel");
      }

      public ConfirmAction(String confirmTitle, String cancelTitle) {
         this.confirmTitle = confirmTitle;
         this.cancelTitle = cancelTitle;
      }

      public abstract void verifyAndCommit() throws Exception;

      String getConfirmTitle() {
         return confirmTitle;
      }

      String getCancelTitle() {
         return cancelTitle;
      }
   }

   public static class DebugFormPanel extends FormDebugPanel {

      private final FormBuilder builder;
      private final CellConstraints cc;
      private final CellConstraints.Alignment colAlign;
      private final CellConstraints.Alignment rowAlign;

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
      private final FormBuilder builder;
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

         setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
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

      } catch (BadLocationException ble) {
         ble.printStackTrace();
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

   public static org.fife.ui.rsyntaxtextarea.RSyntaxTextArea newRSyntaxTextArea() {
      return newRSyntaxTextArea(10, 80);
   }

   public static org.fife.ui.rsyntaxtextarea.RSyntaxTextArea newRSyntaxTextArea(int rows, int cols) {
      return decorate(new org.fife.ui.rsyntaxtextarea.RSyntaxTextArea(rows, cols));
   }

   public static org.fife.ui.rsyntaxtextarea.RSyntaxTextArea decorate(org.fife.ui.rsyntaxtextarea.RSyntaxTextArea rSyntaxTextArea) {

      rSyntaxTextArea.setTabSize(3);
      rSyntaxTextArea.setHighlightCurrentLine(false);
      rSyntaxTextArea.setSelectionColor(Color.decode("#2b8cbe"));
      rSyntaxTextArea.setBackground(UIManager.getColor("Panel.background"));
      rSyntaxTextArea.setForeground(UIManager.getColor("Tree.foreground"));
      rSyntaxTextArea.setFont(UIManager.getFont("TextField.font"));
      rSyntaxTextArea.addKeyListener(new java.awt.event.KeyAdapter() {

         @Override
         public void keyPressed(java.awt.event.KeyEvent keyEvent) {
            if (keyEvent.getModifiers() == java.awt.event.KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == java.awt.event.KeyEvent.VK_F) {
               format(rSyntaxTextArea);
            }
         }
      });

      return rSyntaxTextArea;
   }

   public static RTextScrollPane newRTextScrollPane(RSyntaxTextArea rSyntaxTextArea) {
      final RTextScrollPane scrollPane = new RTextScrollPane(rSyntaxTextArea);
      scrollPane.setBackground(UIManager.getColor("Panel.background"));
      scrollPane.getGutter().setBackground(scrollPane.getBackground());
      scrollPane.getGutter().setForeground(UIManager.getColor("TextField.foreground"));
      scrollPane.getGutter().setFont(UIManager.getFont("TextField.font").deriveFont(29f));
      return scrollPane;
   }

   public static void format(JTextArea txtEditor) {
      final int caretPosition = txtEditor.getCaretPosition();
      final StringBuilder spaces = new StringBuilder();
      for (int i = 0; i < txtEditor.getTabSize(); i++) spaces.append(" ");

      String[] split = txtEditor.getText().split("\n");
      final StringBuilder formatted = new StringBuilder();
      for (String s : split) formatted.append(s.replace(spaces, "\t")).append("\n");
      split = formatted.toString().split("\n");

      final StringBuilder formatted2 = new StringBuilder();
      for (String s : split) {
         if (s.trim().length() == 0) {
            formatted2.append("\n");
            continue;
         }

         final char[] c = s.toCharArray();
         for (int i = 0; i < c.length; i++) {
            if (c[i] == '\t') {
               formatted2.append(c[i]);
               continue;
            }
            if (c[i] == ' ') continue;
            formatted2.append(s.substring(i));
            break;
         }

         formatted2.append("\n");
      }
      txtEditor.setText(formatted2.toString().trim());
      txtEditor.setCaretPosition(Math.min(formatted2.toString().trim().length(), caretPosition));
   }

   public static javax.swing.JTextField newTextField(int columns) {
      return newTextField("", columns);
   }

   public static javax.swing.JTextField newTextField(String content, int columns) {
      javax.swing.JTextField textField = new javax.swing.JTextField(content, columns);
      textField.addMouseListener(new java.awt.event.MouseAdapter() {
         @Override
         public void mouseClicked(java.awt.event.MouseEvent e) {
            if (javax.swing.SwingUtilities.isRightMouseButton(e))
               javax.swing.SwingUtilities.invokeLater(() -> {
                  final javax.swing.JPopupMenu pop = new javax.swing.JPopupMenu();
                  pop.add(new AbstractAction("Set from clipboard") {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                        textField.setText(nextgen.utils.SwingUtil.fromClipboard());
                     }
                  });
                  pop.show(textField, e.getX(), e.getY());
               });
         }
      });
      textField.addFocusListener(new java.awt.event.FocusAdapter() {
         @Override
         public void focusGained(java.awt.event.FocusEvent evt) {
            javax.swing.SwingUtilities.invokeLater(() -> ((javax.swing.JTextField) evt.getSource()).selectAll());
         }

         @Override
         public void focusLost(java.awt.event.FocusEvent evt) {
            javax.swing.SwingUtilities.invokeLater(() -> {
               ((javax.swing.JTextField) evt.getSource()).setSelectionStart(0);
               ((javax.swing.JTextField) evt.getSource()).setSelectionEnd(0);
            });
         }
      });
      return textField;
   }

   public static void showDialog(JComponent parent, JDialog dialog, JButton btnSave) {

      dialog.getRootPane().setDefaultButton(btnSave);

      final JPanel commandPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
      commandPanel.add(btnSave);
      commandPanel.add(new JButton(new AbstractAction("Cancel") {
         @Override
         public void actionPerformed(ActionEvent e) {
            SwingUtilities.invokeLater(dialog::dispose);
         }
      }));
      dialog.add(commandPanel, BorderLayout.SOUTH);

      SwingUtilities.invokeLater(() -> {
         dialog.pack();
         dialog.setLocationRelativeTo(parent);
         dialog.setVisible(true);
      });
   }

   public static Optional<String> getInputFromUser(JComponent parent, String message) {
      final String s = SwingUtil.showInputDialog(message, parent);
      return Optional.ofNullable(s == null || s.trim().length() == 0 ? null : s);
   }

   public static Optional<Boolean> confirm(JComponent parent, String description) {
      final boolean b = SwingUtil.showConfirmDialog(parent, description);
      return Optional.ofNullable(b ? Boolean.TRUE : null);
   }

   private static class SelectFocusAdapter extends FocusAdapter {

      @Override
      public void focusGained(java.awt.event.FocusEvent evt) {
         SwingUtilities.invokeLater(() -> ((JTextField) evt.getSource()).selectAll());
      }

      @Override
      public void focusLost(FocusEvent evt) {
         SwingUtilities.invokeLater(() -> {
            ((JTextField) evt.getSource()).setSelectionStart(0);
            ((JTextField) evt.getSource()).setSelectionEnd(0);
         });
      }
   }
}