package nextgen.swing;

import com.github.difflib.DiffUtils;
import com.github.difflib.algorithm.DiffException;
import com.github.difflib.patch.*;
import nextgen.swing.forms.RegexpForm;
import nextgen.utils.*;
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

/**
 * Created 30.07.17.
 */
public final class TextProcessingPanel extends BaseEditor<String> {

   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TextProcessingPanel.class);

   private final String lineSeparator = System.getProperty("line.separator");
   private final Stack<String> inputStack = new Stack<>();
   private final AtomicBoolean synchScrollPanes = new AtomicBoolean(true);

   private final JTextArea txtInput = newRSyntaxTextArea();
   private final RTextScrollPane scrollInput = new RTextScrollPane(txtInput);
   private final JTextArea txtOutput = newRSyntaxTextArea();
   private final RTextScrollPane scrollOutput = new RTextScrollPane(txtOutput);
   private final JTextField txtPattern = newJTextField("");
   private final JTextField txtInsert = newJTextField("");
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

   private final Color decode = Color.LIGHT_GRAY;
   private final Color matchColor = Color.LIGHT_GRAY;
   private final Color outputHightlightColor = Color.BLUE;
   private final Color decode3 = Color.LIGHT_GRAY;

   public TextProcessingPanel() {
      this(SwingUtil.fromClipboard());
   }

   public TextProcessingPanel(String inputText) {
      super(inputText);
      setLayout(new BorderLayout());

      final JButton btnSetAsInput = newJButton(setOutputAsInputAction(), "Set output-text to inputText");

      final ButtonGroup group = new ButtonGroup();
      group.add(radReplace);
      group.add(radInsertAfter);
      group.add(radInsertLineAfter);
      group.add(radInsertBefore);
      group.add(radInsertLineBefore);
      group.add(radRemove);
      group.add(radRemoveLine);
      group.add(radRemoveLineBefore);
      group.add(radRemoveLineAfter);

      txtInput.setText(inputText);
      txtInput.setCaretPosition(0);
      txtInput.addFocusListener(newTxtInputFocusListener());
      final JPopupMenu txtInputPop = newJPopupMenu();
      txtInputPop.add(newUndoAction());
      txtInputPop.add(setTxtInputFromClipboardAction());
      txtInput.setComponentPopupMenu(txtInputPop);

      final JPopupMenu txtOutputPop = newJPopupMenu();
      txtOutputPop.add(setOutputAsInputAction());
      txtOutputPop.add(txtOutputToClipboardAction());
      txtOutputPop.setComponentPopupMenu(txtInputPop);
      txtOutputPop.setToolTipText("Left-click to add content to clipboard.\nRight-click for options.");

      txtPattern.addActionListener(e12 -> filter());
      txtPattern.addKeyListener(txtPatternAddKeyListener());
      txtPattern.addMouseListener(txtPatternAddMouseListener());

      txtInsert.setToolTipText("Use $1,$2 ... to reference group-value");
      txtInsert.addKeyListener(newTxtInsertKeyListener());

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


      new TextAreaScrollSynchListener(scrollInput, scrollOutput);

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
      add(regexpForm, BorderLayout.CENTER);

      filter();

      txtPattern.requestFocusInWindow();
   }

   private AbstractAction txtOutputToClipboardAction() {
      return new AbstractAction("Add to clipboard") {
         @Override
         public void actionPerformed(ActionEvent e) {
            SwingUtil.toClipboard(txtOutput.getText().trim());
         }
      };
   }

   private void filter() {

      SwingUtilities.invokeLater(() -> {

         txtInput.getHighlighter().removeAllHighlights();
         txtInsert.setEnabled(radReplace.isSelected() || radInsertAfter.isSelected() || radInsertLineAfter.isSelected() || radInsertBefore.isSelected() || radInsertLineBefore.isSelected());

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

               txtInput.getHighlighter().addHighlight(start, end, new DefaultHighlighter.DefaultHighlightPainter(matchColor) {
                  @Override
                  public void paint(Graphics g, int offs0, int offs1, Shape bounds, JTextComponent c) {
                     super.paint(g, offs0, offs1, bounds, c);
                  }
               });

               if (firstMatch.get()) {
                  synchScrollPanes.set(false);
                  Rectangle2D view = txtInput.modelToView2D(start);
                  txtInput.scrollRectToVisible(view.getBounds());
                  txtInput.setCaretPosition(start);
                  txtOutput.setCaretPosition(start);
                  scrollOutput.getVerticalScrollBar().setValue(scrollInput.getVerticalScrollBar().getValue());
                  firstMatch.set(false);
                  System.out.println("setValue");

                  synchScrollPanes.set(true);
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

            for (Map.Entry<Integer, Integer> entry : outputHighlights.entrySet()) {
               txtOutput.getHighlighter().addHighlight(entry.getKey(), entry.getValue(), new DefaultHighlighter.DefaultHighlightPainter(outputHightlightColor));
            }

         } catch (Throwable e) {
            txtPattern.setToolTipText(e.getMessage());
            txtPattern.setBackground(decode3);
            txtOutput.setText(e.getMessage());
            txtOutput.setCaretPosition(0);
         }
      });
   }

   private MouseAdapter txtPatternAddMouseListener() {
      return new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {

            if (SwingUtilities.isRightMouseButton(e)) {
               final JPopupMenu pop = newJPopupMenu();
               pop.add(new AbstractAction("Help") {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                     showHelp();
                  }
               });

               SwingUtilities.invokeLater(() -> pop.show(txtPattern, e.getX(), e.getY()));
            }
         }
      };
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

   private KeyAdapter txtPatternAddKeyListener() {
      return new KeyAdapter() {

         @Override
         public void keyPressed(KeyEvent event) {
            if (event.getKeyCode() == KeyEvent.VK_SPACE) {
               if (!event.isControlDown()) return;
               SwingUtilities.invokeLater(() -> showHelp());
            }
         }

         @Override
         public void keyReleased(KeyEvent e) {
            filter();
         }
      };
   }


   private KeyAdapter newTxtInsertKeyListener() {
      return new KeyAdapter() {
         @Override
         public void keyReleased(KeyEvent e) {
            filter();
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

   public Action setTxtInputFromClipboardAction() {
      return new AbstractAction("Set from clipboard") {
         @Override
         public void actionPerformed(ActionEvent e) {
            txtInput.setText(SwingUtil.fromClipboard());
            txtInput.setCaretPosition(0);
            filter();
         }
      };
   }

   public Action newUndoAction() {
      return new AbstractAction("Undo") {
         @Override
         public void actionPerformed(ActionEvent e) {
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

   public String getOutputText() {
      return txtOutput.getText();
   }

   private void showHelp() {
      String out = "" + "[abc] a, b, or c (simple class)\n" +
            "[^abc] Any character except a, b, or c (negation)\n" +
            "[a-zA-Z] a through z, or A through Z, inclusive (range)\n" +
            "[a-d[m-p]] a through d, or m through p: [a-dm-p] (union)\n" +
            "[a-z&&[def]] d, e, or f (intersection)\n" +
            "[a-z&&[^bc]] a through z, except for b and c: [ad-z] (subtraction)\n" +
            "[a-z&&[^m-p]] a through z, and not m through p: [a-lq-z] (subtraction)" +
            "\n\nAny character\n" +
            "\\d A digit: [0-9]\n" +
            "\\D A non-digit: [\\^0-9]\n" +
            "\\s A whitespace character: [ \\t\\n\\x0B\\f\\r]\n" +
            "\\S A non-whitespace character: [\\^\\s]\n" +
            "\\w A word character: [a-zA-Z_0-9]\n" +
            "\\W A non-word character: [\\^\\w]" +
            "\n\n^ The beginning of a line.\n" +
            "$ The end of a line.\n" +
            "\\b A word boundary.\n" +
            "\\B A non-word boundary.\n" +
            "\\A The beginning of the input.\n" +
            "\\G The end of the previous match.\n" +
            "\\Z The end of the input but for the final terminator, if any.\n" +
            "\\z The end of the input." +
            "\n\n" +
            "X? X?? X?+ X, once or not at all\n" +
            "X* X*? X*+ X, zero or more times\n" +
            "X+ X+? X++ X, one or more times\n" +
            "X{n} X{n}? X{n}+ X, exactly n times\n" +
            "X{n,} X{n,}? X{n,}+ X, at least n times\n" +
            "X{n,m} X{n,m}? X{n,m}+ X, at least n but not more than\n" +
            "m times";
      SwingUtil.showTextResult("Regexp", out, txtPattern);
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
         if (evt.getValueIsAdjusting() || !synchScrollPanes.get()) return;
         int value = evt.getValue();
         System.out.println("setValue changed");
//         if (evt.getSource().equals(input))
//            output.setValue(value);
//         else
//            input.setValue(value);
      }
   }

   public String getPattern() {
      return txtPattern.getText().trim();
   }

   public static void main(String[] args) {
      ComponentFactory.applyLaf();
      SwingUtil.showPanel(new TextProcessingPanel(args.length == 0 ? FileUtil.readIntact(new File("/home/goe/projects/munster/src/main/js/styles.css")) : args[0]));
   }
}