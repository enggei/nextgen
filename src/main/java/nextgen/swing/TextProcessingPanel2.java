package nextgen.swing;

import com.github.difflib.DiffUtils;
import com.github.difflib.algorithm.DiffException;
import com.github.difflib.patch.*;
import nextgen.swing.forms.RegexpForm;
import nextgen.utils.*;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.*;

import static nextgen.swing.ComponentFactory.*;

public final class TextProcessingPanel2 extends BaseEditor<String> {

   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TextProcessingPanel2.class);

   private final String lineSeparator = System.getProperty("line.separator");
   private final RSyntaxTextArea txtInput = newRSyntaxTextArea();
   private final RTextScrollPane scrollInput = newRTextScrollPane(txtInput);
   private final JPopupMenu txtInputPop = newJPopupMenu();

   private final RSyntaxTextArea txtOutput = newRSyntaxTextArea();
   private final RTextScrollPane scrollOutput = newRTextScrollPane(txtOutput);
   private final JPopupMenu txtOutputPop = newJPopupMenu();
   private final TextAreaScrollSynchListener scrollSynchListener = new TextAreaScrollSynchListener(scrollInput, scrollOutput);

   private final JTextField txtPattern = newJTextField();
   private final JTextField txtInsert = newJTextField("", "Use $1,$2 ... to reference group-value");

   private final ButtonGroup group = new ButtonGroup();
   private final JRadioButton radReplace = newJRadioButton("replace", true);
   private final JRadioButton radInsertAfter = newJRadioButton("insert after");
   private final JRadioButton radInsertLineAfter = newJRadioButton("insert line after");
   private final JRadioButton radInsertBefore = newJRadioButton("insert before");
   private final JRadioButton radInsertLineBefore = newJRadioButton("insert line before");
   private final JRadioButton radRemove = newJRadioButton("remove");
   private final JRadioButton radRemoveLine = newJRadioButton("remove line");
   private final JRadioButton radRemoveLineBefore = newJRadioButton("remove line before");
   private final JRadioButton radRemoveLineAfter = newJRadioButton("remove line after");

   private final JCheckBox chkTrimEmptyLines = new JCheckBox("Compress lines", true);
   private final JCheckBox chkShowDifference = new JCheckBox("Show Difference", false);
   private final JCheckBox chkKeepMatches = new JCheckBox("keep only matches", false);
   private final JCheckBox chkShowDistinct = new JCheckBox("show distinct", false);

   private final JButton btnSetAsInput = newJButton(setOutputAsInputAction(), "Set output-text to inputText");

   private final JList<String> lstValues = new JList<>();
   private final JScrollPane scrollValues = new JScrollPane(lstValues);

   private final Stack<String> inputStack = new Stack<>();
   private final Color decode = Color.decode("#33a02c");
   private final Color txtInputMatchColor = Color.decode("#33a02c");
   private final Color txtOutputMatchColor = Color.decode("#1a9641");

   public TextProcessingPanel2() {
      this(SwingUtil.fromClipboard());
   }

   public TextProcessingPanel2(String inputText) {
      super(inputText);
      setLayout(new BorderLayout());

      txtInput.setText(inputText);
      txtInput.setCaretPosition(0);
      txtInput.addFocusListener(newTxtInputFocusListener());

      txtInputPop.add(txtInputFromClipboardAction());
      txtInputPop.add(newUndoAction());
      txtInput.setComponentPopupMenu(txtInputPop);

      txtOutputPop.add(setOutputAsInputAction());
      txtOutputPop.add(txtOutputToClipboardAction());
      txtOutputPop.setComponentPopupMenu(txtOutputPop);

      txtPattern.addActionListener(actionEvent -> filter());
      txtPattern.addKeyListener(newPatternKeyListener());

      txtInsert.addKeyListener(newTxtInsertKeyListener());

      group.add(radReplace);
      group.add(radInsertAfter);
      group.add(radInsertLineAfter);
      group.add(radInsertBefore);
      group.add(radInsertLineBefore);
      group.add(radRemove);
      group.add(radRemoveLine);
      group.add(radRemoveLineBefore);
      group.add(radRemoveLineAfter);

      radReplace.addActionListener(e -> filter());
      radInsertAfter.addActionListener(e -> filter());
      radInsertLineAfter.addActionListener(e -> filter());
      radInsertBefore.addActionListener(e -> filter());
      radInsertLineBefore.addActionListener(e -> filter());
      radRemove.addActionListener(e -> filter());
      radRemoveLine.addActionListener(e -> filter());
      radRemoveLineBefore.addActionListener(e -> filter());
      radRemoveLineAfter.addActionListener(e -> filter());

      chkKeepMatches.addActionListener(e -> filter());
      chkTrimEmptyLines.setToolTipText("Check to compress 2 or more empty lines into 1");
      chkTrimEmptyLines.addActionListener(e -> filter());
      chkShowDifference.addActionListener(e -> filter());

      final RegexpForm regexpForm = new RegexpForm();
      regexpForm.setSource(scrollInput);
      regexpForm.setPattern(newJLabel("Pattern"));
      regexpForm.setPattern(txtPattern);
      regexpForm.setInsert(newJLabel("Insert"));
      regexpForm.setInsert(txtInsert);
      regexpForm.setReplace(radReplace);
      regexpForm.setInsertAfter(radInsertAfter);
      regexpForm.setInsertLineAfter(radInsertLineAfter);
      regexpForm.setInsertBefore(radInsertBefore);
      regexpForm.setInsertLineBefore(radInsertLineBefore);
      regexpForm.setRemove(radRemove);
      regexpForm.setRemoveLine(radRemoveLine);
      regexpForm.setRemoveLineBefore(radRemoveLineBefore);
      regexpForm.setRemoveLineAfter(radRemoveLineAfter);
      regexpForm.setCompressLines(chkTrimEmptyLines);
      regexpForm.setShowDifference(chkShowDifference);
      regexpForm.setKeepOnlyMatches(chkKeepMatches);
      regexpForm.setSetSource(btnSetAsInput);
      regexpForm.setTarget(scrollOutput);
      regexpForm.setTarget(scrollOutput);
      regexpForm.setShowDistinct(chkShowDistinct);
      add(regexpForm, BorderLayout.CENTER);

      txtPattern.requestFocusInWindow();
   }

   @Override
   public void setModel(String model) {
      super.setModel(model);
      SwingUtilities.invokeLater(() -> txtInput.setText(model));
   }

   @Override
   public String getModel() {
      return txtOutput.getText().trim();
   }

   private void filter() {

      SwingUtilities.invokeLater(() -> {

         txtInput.getHighlighter().removeAllHighlights();
         txtInsert.setEnabled(radReplace.isSelected() || radInsertAfter.isSelected() || radInsertLineAfter.isSelected() || radInsertBefore.isSelected() || radInsertLineBefore.isSelected());

         final Set<String> set = new TreeSet<>();

         try {

            txtOutput.setText("");
            if (txtPattern.getText().trim().length() == 0) return;

            final String inputText = txtInput.getText();
            final Pattern pattern = Pattern.compile(txtPattern.getText());
            final Matcher matcher = pattern.matcher(inputText);
            final String replacement = txtInsert.getText();

            final StringBuilder filteredText = new StringBuilder();
            final char[] input = inputText.toCharArray();
            int currentIndex = 0;
            final Map<Integer, Integer> outputHighlights = new LinkedHashMap<>();
            final AtomicBoolean firstMatch = new AtomicBoolean(true);

            while (matcher.find()) {

               final int start = matcher.start();
               final int end = matcher.end();
               set.add(inputText.substring(start, end));

               txtInput.getHighlighter().addHighlight(start, end, new DefaultHighlighter.DefaultHighlightPainter(txtInputMatchColor));

               if (firstMatch.get()) {
                  scrollSynchListener.scrollTo(start);
                  firstMatch.set(false);
               }

               if (replacement.length() > 0) {

                  String newLine = replacement;
                  for (int i = 0; i < matcher.groupCount(); i++)
                     newLine = newLine.replace("$" + (i + 1), matcher.group(i + 1));

                  if (chkKeepMatches.isSelected()) {
                     filteredText.append(newLine).append(lineSeparator);
                     currentIndex = inputText.length();
                  } else {
                     if (radReplace.isSelected()) {
                        filteredText.append(inputText, currentIndex, start);
                        int newStart = filteredText.length();
                        filteredText.append(newLine);
                        outputHighlights.put(newStart, filteredText.length());
                        currentIndex = end;
                     } else if (radInsertAfter.isSelected()) {
                        filteredText.append(inputText, currentIndex, end);
                        int newStart = filteredText.length();
                        filteredText.append(newLine);
                        outputHighlights.put(newStart, filteredText.length());
                        currentIndex = end;
                     } else if (radInsertBefore.isSelected()) {
                        filteredText.append(inputText, currentIndex, start);
                        int newStart = filteredText.length();
                        filteredText.append(newLine);
                        outputHighlights.put(newStart, filteredText.length());
                        filteredText.append(inputText, start, end);
                        currentIndex = end;
                     } else if (radInsertLineBefore.isSelected()) {
                        filteredText.append(inputText, currentIndex, start);
                        int newStart = filteredText.length();
                        filteredText.append(newLine);
                        outputHighlights.put(newStart, filteredText.length());
                        filteredText.append(lineSeparator);
                        filteredText.append(inputText, start, end);
                        currentIndex = end;
                     }
                  }
               }

               if (radRemove.isSelected()) {
                  filteredText.append(inputText, currentIndex, start);
                  currentIndex = end;

               } else if (radRemoveLine.isSelected()) {

                  // if there are multiple matches on a line, the first match removes the entire line.
                  // Therefore, just ignore the rest of the matches on this (removed) line.
                  if (start >= currentIndex) {
                     int startOfLine = start;
                     while (startOfLine > 0) {
                        if (lineSeparator.equals(("" + input[startOfLine])))
                           break;
                        startOfLine--;
                     }

                     int endOfLine = end;
                     while (endOfLine < input.length) {
                        if (lineSeparator.equals(("" + input[endOfLine])))
                           break;
                        endOfLine++;
                     }

                     filteredText.append(inputText, currentIndex, startOfLine);
                     currentIndex = endOfLine;
                  }

               } else if (radRemoveLineBefore.isSelected()) {

                  int startOfLine = start;
                  int endOfLine = 0;
                  while (startOfLine > 0) {
                     if (lineSeparator.equals(("" + input[startOfLine]))) {
                        if (endOfLine == 0) {
                           endOfLine = startOfLine;
                        } else
                           break;
                     }
                     startOfLine--;
                  }

                  if (startOfLine >= currentIndex) {
                     filteredText.append(inputText, currentIndex, startOfLine);
                     currentIndex = endOfLine;
                  }

               } else if (radRemoveLineAfter.isSelected()) {

                  if (start >= currentIndex) {
                     int endOfLine = end;
                     int startOfLine = -1;
                     while (endOfLine < input.length - 1) {
                        if (lineSeparator.equals(("" + input[endOfLine]))) {
                           if (startOfLine == -1) {
                              startOfLine = endOfLine;
                           } else
                              break;
                        }
                        endOfLine++;
                     }
                     filteredText.append(inputText, currentIndex, startOfLine == -1 ? end : startOfLine);
                     currentIndex = endOfLine;
                  }

               } else if (radInsertLineAfter.isSelected()) {

                  String newLine = "";
                  if (replacement.length() > 0) {
                     newLine = replacement;
                     for (int i = 0; i < matcher.groupCount(); i++)
                        newLine = newLine.replace("$" + (i + 1), matcher.group(i + 1));
                  }

                  filteredText.append(inputText, currentIndex, end);
                  filteredText.append(lineSeparator);
                  int newStart = filteredText.length();
                  filteredText.append(newLine);
                  outputHighlights.put(newStart, filteredText.length());
                  currentIndex = end;

               } else if (chkKeepMatches.isSelected()) {
                  filteredText.append(inputText, start, end).append(lineSeparator);
                  currentIndex = inputText.length();
               }
            }

            if (currentIndex < inputText.length())
               filteredText.append(inputText.substring(currentIndex));

            final StringBuilder outputText = new StringBuilder();
            if (chkTrimEmptyLines.isSelected()) {
               final String[] lines = filteredText.toString().split(lineSeparator);
               String previous = null;
               for (String line : lines) {
                  if (line.trim().length() == 0 && previous != null && previous.trim().length() == 0)
                     continue;
                  outputText.append(line).append(lineSeparator);
                  previous = line;
               }

            } else {
               outputText.append(filteredText.toString());
            }

            txtOutput.setText(outputText.toString().trim());
            //txtOutput.setCaretPosition(0);

            if (chkShowDifference.isSelected()) showDifference();

            for (Map.Entry<Integer, Integer> entry : outputHighlights.entrySet())
               txtOutput.getHighlighter().addHighlight(entry.getKey(), entry.getValue(), new DefaultHighlighter.DefaultHighlightPainter(txtOutputMatchColor));

            if (chkShowDistinct.isSelected()) {
               txtOutput.getHighlighter().removeAllHighlights();
               final StringBuilder distinct = new StringBuilder();
               for (String s : set) distinct.append(s).append("\n");
               txtOutput.setText(distinct.toString());
            }

         } catch (Throwable e) {
            txtPattern.setToolTipText(e.getMessage());
            txtOutput.setText(e.getMessage());
            txtOutput.setCaretPosition(0);
         }
      });
   }

   private Action setOutputAsInputAction() {
      return new AbstractAction("Set this text as input") {
         @Override
         public void actionPerformed(ActionEvent e) {
            inputStack.push(txtInput.getText());
            txtInput.setText(txtOutput.getText());
            txtInput.setCaretPosition(0);
            filter();
         }
      };
   }

   private KeyListener newTxtInsertKeyListener() {
      return new KeyAdapter() {
         @Override
         public void keyReleased(KeyEvent e) {
            filter();
         }
      };
   }

   private KeyListener newPatternKeyListener() {
      return new KeyAdapter() {
         @Override
         public void keyPressed(KeyEvent keyEvent) {
            if (keyEvent.getModifiers() == KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == KeyEvent.VK_SPACE) {
               SwingUtilities.invokeLater(() -> {
                  JPopupMenu pop = new JPopupMenu("Patterns");

                  pop.add(newAction("[abc]", actionEvent -> {
                     txtPattern.setText("[]");
                     filter();
                  }));
                  pop.add(newAction("[^abc]", actionEvent -> {
                     txtPattern.setText("[^]");
                     filter();
                  }));
                  pop.add(newAction("[a-zA-Z]", actionEvent -> {
                     txtPattern.setText("[a-zA-Z]");
                     filter();
                  }));
                  pop.add(newAction("[a-d[m-p]]", actionEvent -> {
                     txtPattern.setText("[a-d[m-p]]");
                     filter();
                  }));
                  pop.add(newAction("[a-z&&[def]]", actionEvent -> {
                     txtPattern.setText("[a-z&&[def]]");
                     filter();
                  }));
                  pop.add(newAction("[a-z&&[^bc]]", actionEvent -> {
                     txtPattern.setText("[a-z&&[^bc]]");
                     filter();
                  }));
                  pop.add(newAction("[a-z&&[^m-p]]", actionEvent -> {
                     txtPattern.setText("[a-z&&[^m-p]]");
                     filter();
                  }));

                  pop.add(newAction("digits", actionEvent -> {
                     txtPattern.setText("\\d");
                     filter();
                  }));
                  pop.add(newAction("non-digits", actionEvent -> {
                     txtPattern.setText("\\D");
                     filter();
                  }));

                  final Point location = SwingUtilities.getLocalBounds(txtPattern).getLocation();
                  pop.show(txtPattern, location.x, location.y);
               });
            }
         }
      };
   }

   private FocusListener newTxtInputFocusListener() {
      return new FocusListener() {
         @Override
         public void focusGained(FocusEvent e) {
         }

         @Override
         public void focusLost(FocusEvent e) {
            SwingUtilities.invokeLater(() -> txtInput.setCaretPosition(0));
         }
      };
   }

   private Action txtOutputToClipboardAction() {
      return new AbstractAction("Add to clipboard") {
         @Override
         public void actionPerformed(ActionEvent e) {
            SwingUtil.toClipboard(txtOutput.getText().trim());
         }
      };
   }

   private Action txtInputFromClipboardAction() {
      return new AbstractAction("Set from clipboard") {
         @Override
         public void actionPerformed(ActionEvent e) {
            txtInput.setText(SwingUtil.fromClipboard());
            txtInput.setCaretPosition(0);
            filter();
         }
      };
   }

   private Action newUndoAction() {
      return new AbstractAction("Undo") {
         @Override
         public void actionPerformed(ActionEvent e) {
            if (inputStack.pop().isEmpty()) return;
            txtInput.setText(inputStack.pop());
            txtInput.setCaretPosition(0);
            filter();
         }
      };
   }

   private void showDifference() throws DiffException {
      final String src = txtInput.getText().trim();
      final String dst = txtOutput.getText().trim();

      final String[] srcLines = src.split("\n");
      final String[] dstLines = dst.split("\n");

      final Patch<String> patch = DiffUtils.diff(Arrays.asList(srcLines), Arrays.asList(dstLines));

      txtInput.getHighlighter().removeAllHighlights();
      txtOutput.getHighlighter().removeAllHighlights();

      for (Delta<String> delta : patch.getDeltas()) {
         highlightChunk(src, delta.getOriginal(), txtInput, decode);
         highlightChunk(dst, delta.getRevised(), txtOutput, decode);
      }
   }

   private void highlightChunk(String src, Chunk<String> original, JTextArea txtInput, Color highlightColor) {
      for (String line : original.getLines()) {
         final int startIndex = src.indexOf(line);
         final int endIndex = startIndex + line.length();
         try {
            txtInput.getHighlighter().addHighlight(startIndex, endIndex, new DefaultHighlighter.DefaultHighlightPainter(highlightColor));
         } catch (BadLocationException e1) {
            log.info(SwingUtil.printStackTrace(e1));
         }
      }
   }

   private final class TextAreaScrollSynchListener implements AdjustmentListener {

      private final JScrollBar input;
      private final JScrollBar output;

      public TextAreaScrollSynchListener(RTextScrollPane scrollInput, RTextScrollPane scrollOutput) {
         this.input = scrollInput.getVerticalScrollBar();
         this.output = scrollOutput.getVerticalScrollBar();
         scrollInput.getVerticalScrollBar().addAdjustmentListener(this);
         scrollOutput.getVerticalScrollBar().addAdjustmentListener(this);
      }

      @Override
      public void adjustmentValueChanged(AdjustmentEvent evt) {
         if (evt.getValueIsAdjusting()) return;
         if (evt.getSource().equals(input)) output.setValue(evt.getValue());
      }

      public void scrollTo(int start) {
         try {
            final Rectangle2D view = txtInput.modelToView2D(start);
            txtInput.scrollRectToVisible(view.getBounds());
            txtInput.setCaretPosition(start);
            scrollOutput.getVerticalScrollBar().setValue(scrollInput.getVerticalScrollBar().getValue());
         } catch (BadLocationException ignored) {

         }
      }
   }

   public static void main(String[] args) {
      SwingUtil.showPanel(new TextProcessingPanel2(args.length == 0 ? FileUtil.readIntact(new File("/home/goe/projects/munster/src/main/js/styles.css")) : args[0]));
   }
}