package com.generator.util;

import javax.swing.*;
import javax.swing.text.DefaultHighlighter;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created 30.07.17.
 */
public final class TextProcessingPanel extends JPanel {

   private final JTextArea txtInput = newTextArea();
   private final String lineSeparator = System.getProperty("line.separator");

   private JTextArea newTextArea() {
      final JTextArea txtEditor = new JTextArea(30, 30);
      txtEditor.setFont(new Font("Hack", Font.PLAIN, 12));
      txtEditor.setTabSize(3);
      return txtEditor;
   }

   private final Stack<String> inputStack = new Stack<>();
   private final JTextField txtPattern = new JTextField("");
   private final JTextField txtInsert = new JTextField("");
   private final JTextArea txtOutput = newTextArea();

   private final JRadioButton radReplace = new JRadioButton("replace", true);
   private final JRadioButton radInsertAfter = new JRadioButton("insert after");
   private final JRadioButton radInsertLineAfter = new JRadioButton("insert line after");
   private final JRadioButton radInsertBefore = new JRadioButton("insert before");
   private final JRadioButton radInsertLineBefore = new JRadioButton("insert line before");
   private final JRadioButton radRemove = new JRadioButton("remove");
   private final JRadioButton radRemoveLine = new JRadioButton("remove line");
   private final JRadioButton radRemoveLineBefore = new JRadioButton("remove line before");
   private final JRadioButton radRemoveLineAfter = new JRadioButton("remove line after");
   private final JCheckBox chkTrimEmptyLines = new JCheckBox("Compress lines", true);
   private final JRadioButton radExtract = new JRadioButton("keep only matches");
   private final JButton btnSetAsInput = new JButton(" <- ");

   public TextProcessingPanel(String inputText, Set<String> patterns) {
      super(new BorderLayout());

      btnSetAsInput.setToolTipText("Set output-text to inputText (for further processing)");

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
      group.add(radExtract);

      txtPattern.addKeyListener(new KeyAdapter() {

         @Override
         public void keyPressed(KeyEvent event) {
            switch (event.getKeyCode()) {
               case KeyEvent.VK_SPACE:
                  if (!event.isControlDown()) return;
                  SwingUtilities.invokeLater(() -> showHelp());
                  break;
            }
         }

         @Override
         public void keyReleased(KeyEvent e) {
            filter();
         }
      });

      if (patterns.size() == 1) txtPattern.setText(patterns.iterator().next());

      btnSetAsInput.addActionListener(e -> {
         inputStack.push(txtInput.getText());
         txtInput.setText(txtOutput.getText());
         txtInput.setCaretPosition(0);
         filter();
      });

      txtPattern.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {

            if (SwingUtilities.isRightMouseButton(e)) {
               final JPopupMenu pop = new JPopupMenu();

               for (String pattern : patterns) {
                  pop.add(new AbstractAction(pattern) {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                        txtPattern.setText(pattern);
                        filter();
                     }
                  });
               }

               pop.add(new AbstractAction("Help") {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                     showHelp();
                  }
               });

               SwingUtilities.invokeLater(() -> pop.show(txtPattern, e.getX(), e.getY()));
            }
         }
      });

      txtInput.setText(inputText);
      txtInput.setCaretPosition(0);
      txtInput.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isRightMouseButton(e)) {
               final JPopupMenu pop = new JPopupMenu();

               if (inputStack.size() > 0) {
                  pop.add(new AbstractAction("Undo") {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                        txtInput.setText(inputStack.pop());
                        txtInput.setCaretPosition(0);
                        filter();
                     }
                  });
               }

               pop.add(new AbstractAction("Set from clipboard") {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                     txtInput.setText(SwingUtil.fromClipboard());
                     txtInput.setCaretPosition(0);
                     filter();
                  }
               });

               SwingUtilities.invokeLater(() -> pop.show(txtInput, e.getX(), e.getY()));
            }
         }
      });

      txtInput.addFocusListener(new FocusListener() {
         @Override
         public void focusGained(FocusEvent e) {
         }

         @Override
         public void focusLost(FocusEvent e) {
            SwingUtilities.invokeLater(() -> txtInput.setCaretPosition(0));
         }
      });

      txtPattern.addActionListener(e12 -> filter());
      txtInsert.setToolTipText("Use $1,$2 ... to reference group-value");
      txtInsert.addKeyListener(new KeyAdapter() {
         @Override
         public void keyReleased(KeyEvent e) {
            filter();
         }
      });
      radReplace.addActionListener(e -> filter());
      radInsertAfter.addActionListener(e -> filter());
      radInsertLineAfter.addActionListener(e -> filter());
      radInsertBefore.addActionListener(e -> filter());
      radInsertLineBefore.addActionListener(e -> filter());
      radRemove.addActionListener(e -> filter());
      radRemoveLine.addActionListener(e -> filter());
      radRemoveLineBefore.addActionListener(e -> filter());
      radRemoveLineAfter.addActionListener(e -> filter());
      radExtract.addActionListener(e -> filter());



      chkTrimEmptyLines.setToolTipText("Check to compress 2 or more empty lines into 1");
      chkTrimEmptyLines.addActionListener(e -> filter());

      final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("350dlu:grow,4dlu,100dlu,4dlu,350dlu:grow", "pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,50dlu:grow");
      int row = 1;
      editor.add(new JScrollPane(txtInput), 1, row, 1, 35);
      editor.addLabel("Pattern", 3, row+=2);
      editor.add(txtPattern, 3, row+=2);
      editor.addLabel("Insert", 3, row+=2);
      editor.add(txtInsert, 3, row+=2);
      editor.add(radReplace, 3, row+=2);
      editor.add(radInsertAfter, 3, row+=2);
      editor.add(radInsertLineAfter, 3, row+=2);
      editor.add(radInsertBefore, 3, row+=2);
      editor.add(radInsertLineBefore, 3, row+=2);
      editor.add(radRemove, 3, row+=2);
      editor.add(radRemoveLine, 3, row+=2);
      editor.add(radRemoveLineBefore, 3, row+=2);
      editor.add(radRemoveLineAfter, 3, row+=2);
      editor.add(chkTrimEmptyLines, 3, row+=2);
      editor.add(radExtract, 3, row+=2);
      editor.add(btnSetAsInput, 3, row+=2);
      editor.add(new JScrollPane(txtOutput), 5, 1, 1, 35);

      txtOutput.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e))
               SwingUtil.toClipboard(txtOutput.getText().trim());
            else if (SwingUtilities.isRightMouseButton(e)) {
               final JPopupMenu pop = new JPopupMenu();

               pop.add(new AbstractAction("Set this text as input") {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                     inputStack.push(txtInput.getText());
                     txtInput.setText(txtOutput.getText());
                     txtInput.setCaretPosition(0);
                     filter();
                  }
               });

               pop.add(new AbstractAction("Add to clipboard") {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                     SwingUtil.toClipboard(txtOutput.getText().trim());
                  }
               });

               SwingUtilities.invokeLater(() -> pop.show(txtOutput, e.getX(), e.getY()));
            }
         }
      });
      txtOutput.setToolTipText("Left-click to add content to clipboard.\nRight-click for options.");

      filter();

      add(editor.build(), BorderLayout.CENTER);

      txtPattern.requestFocusInWindow();
   }

   public String getOutputText() {
      return txtOutput.getText();
   }

   private void showHelp() {
      final StringBuilder out = new StringBuilder("");

      out.append("[abc] a, b, or c (simple class)\n" +
            "[^abc] Any character except a, b, or c (negation)\n" +
            "[a-zA-Z] a through z, or A through Z, inclusive (range)\n" +
            "[a-d[m-p]] a through d, or m through p: [a-dm-p] (union)\n" +
            "[a-z&&[def]] d, e, or f (intersection)\n" +
            "[a-z&&[^bc]] a through z, except for b and c: [ad-z] (subtraction)\n" +
            "[a-z&&[^m-p]] a through z, and not m through p: [a-lq-z] (subtraction)");

      out.append("\n\nAny character\n" +
            "\\d A digit: [0-9]\n" +
            "\\D A non-digit: [\\^0-9]\n" +
            "\\s A whitespace character: [ \\t\\n\\x0B\\f\\r]\n" +
            "\\S A non-whitespace character: [\\^\\s]\n" +
            "\\w A word character: [a-zA-Z_0-9]\n" +
            "\\W A non-word character: [\\^\\w]");

      out.append("\n\n^ The beginning of a line.\n" +
            "$ The end of a line.\n" +
            "\\b A word boundary.\n" +
            "\\B A non-word boundary.\n" +
            "\\A The beginning of the input.\n" +
            "\\G The end of the previous match.\n" +
            "\\Z The end of the input but for the final terminator, if any.\n" +
            "\\z The end of the input.");

      out.append("\n\n" +
            "X? X?? X?+ X, once or not at all\n" +
            "X* X*? X*+ X, zero or more times\n" +
            "X+ X+? X++ X, one or more times\n" +
            "X{n} X{n}? X{n}+ X, exactly n times\n" +
            "X{n,} X{n,}? X{n,}+ X, at least n times\n" +
            "X{n,m} X{n,m}? X{n,m}+ X, at least n but not more than\n" +
            "m times");


      SwingUtil.showTextResult("Regexp", out.toString(), txtPattern);
   }

   private void filter() {

      txtInput.getHighlighter().removeAllHighlights();
      txtInsert.setEnabled(radReplace.isSelected() || radInsertAfter.isSelected() || radInsertLineAfter.isSelected() || radInsertBefore.isSelected() || radInsertLineBefore.isSelected());

      try {
         txtPattern.setBackground(UIManager.getColor("TextField.background"));
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
         while (matcher.find()) {
            final int start = matcher.start();
            final int end = matcher.end();

            txtInput.getHighlighter().addHighlight(start, end, new DefaultHighlighter.DefaultHighlightPainter(Color.decode("#91bfdb")));

            if (replacement.length() > 0) {

               String newLine = replacement;
               for (int i = 0; i < matcher.groupCount(); i++)
                  newLine = newLine.replace("$" + (i + 1), matcher.group(i + 1));

               if (radReplace.isSelected()) {
                  filteredText.append(inputText.substring(currentIndex, start));
                  int newStart = filteredText.length();
                  filteredText.append(newLine);
                  outputHighlights.put(newStart, filteredText.length());
                  currentIndex = end;
               } else if (radInsertAfter.isSelected()) {
                  filteredText.append(inputText.substring(currentIndex, end));
                  int newStart = filteredText.length();
                  filteredText.append(newLine);
                  outputHighlights.put(newStart, filteredText.length());
                  currentIndex = end;
               } else if (radInsertBefore.isSelected()) {
                  filteredText.append(inputText.substring(currentIndex, start));
                  int newStart = filteredText.length();
                  filteredText.append(newLine);
                  outputHighlights.put(newStart, filteredText.length());
                  filteredText.append(inputText.substring(start, end));
                  currentIndex = end;
               } else if (radInsertLineBefore.isSelected()) {
                  filteredText.append(inputText.substring(currentIndex, start));
                  int newStart = filteredText.length();
                  filteredText.append(newLine);
                  outputHighlights.put(newStart, filteredText.length());
                  filteredText.append(lineSeparator);
                  filteredText.append(inputText.substring(start, end));
                  currentIndex = end;
               }
            }

            if (radRemove.isSelected()) {
               filteredText.append(inputText.substring(currentIndex, start));
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

                  filteredText.append(inputText.substring(currentIndex, startOfLine));
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
                  filteredText.append(inputText.substring(currentIndex, startOfLine));
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
                  filteredText.append(inputText.substring(currentIndex, startOfLine == -1 ? end : startOfLine));
                  currentIndex = endOfLine;
               }

            } else if (radExtract.isSelected()) {
               filteredText.append(inputText.substring(start, end)).append(lineSeparator);
               currentIndex = inputText.length();

            } else if (radInsertLineAfter.isSelected()) {

               String newLine = "";
               if (replacement.length() > 0) {
                  newLine = replacement;
                  for (int i = 0; i < matcher.groupCount(); i++)
                     newLine = newLine.replace("$" + (i + 1), matcher.group(i + 1));
               }

               filteredText.append(inputText.substring(currentIndex, end));
               filteredText.append(lineSeparator);
               int newStart = filteredText.length();
               filteredText.append(newLine);
               outputHighlights.put(newStart, filteredText.length());
               currentIndex = end;
            }
         }

         if (currentIndex < inputText.length())
            filteredText.append(inputText.substring(currentIndex, inputText.length()));

         final StringBuilder outputText = new StringBuilder();
         if (chkTrimEmptyLines.isSelected()) {
            final String[] lines = filteredText.toString().split(lineSeparator);
            String previous = null;
            for (int i = 0; i < lines.length; i++) {
               String line = lines[i];
               if (line.trim().length() == 0 && previous != null && previous.trim().length() == 0)
                  continue;
               outputText.append(line).append(lineSeparator);
               previous = line;
            }

         } else {
            outputText.append(filteredText.toString());
         }

         txtOutput.setText(outputText.toString().trim());
         txtOutput.setCaretPosition(0);

         for (Map.Entry<Integer, Integer> entry : outputHighlights.entrySet())
            txtOutput.getHighlighter().addHighlight(entry.getKey(), entry.getValue(), new DefaultHighlighter.DefaultHighlightPainter(Color.decode("#99d594")));

      } catch (Throwable e) {
         txtPattern.setToolTipText(e.getMessage());
         txtPattern.setBackground(Color.decode("#fc8d59"));
         txtOutput.setText(e.getMessage());
         txtOutput.setCaretPosition(0);
      }
   }

   public String getPattern() {
      return txtPattern.getText().trim();
   }

   public static void main(String[] args) {
      final String inputText = "import React from 'react';\n" +
            "import RaisedButton from 'material-ui/RaisedButton';\n" +
            "import Popover from 'material-ui/Popover';\n" +
            "import Menu from 'material-ui/Menu';\n" +
            "import MenuItem from 'material-ui/MenuItem';\n" +
            "\n" +
            "export default class PopoverExampleSimple extends React.Component {\n" +
            "\n" +
            "  constructor(props) {\n" +
            "    super(props);\n" +
            "\n" +
            "    this.state = {\n" +
            "      open: false,\n" +
            "    };\n" +
            "  }\n" +
            "\n" +
            "  handleTouchTap = (event) => {\n" +
            "    // This prevents ghost click.\n" +
            "    event.preventDefault();\n" +
            "\n" +
            "    this.setState({\n" +
            "      open: true,\n" +
            "      anchorEl: event.currentTarget,\n" +
            "    });\n" +
            "  };\n" +
            "\n" +
            "  handleRequestClose = () => {\n" +
            "    this.setState({\n" +
            "      open: false,\n" +
            "    });\n" +
            "  };\n" +
            "\n" +
            "  render() {\n" +
            "    return (\n" +
            "      <div>\n" +
            "        <RaisedButton\n" +
            "          onTouchTap={this.handleTouchTap}\n" +
            "          label=\"Click me\"\n" +
            "        />\n" +
            "        <Popover\n" +
            "          open={this.state.open}\n" +
            "          anchorEl={this.state.anchorEl}\n" +
            "          anchorOrigin={{horizontal: 'left', vertical: 'bottom'}}\n" +
            "          targetOrigin={{horizontal: 'left', vertical: 'top'}}\n" +
            "          onRequestClose={this.handleRequestClose}\n" +
            "        >\n" +
            "          <Menu>\n" +
            "            <MenuItem primaryText=\"Refresh\" />\n" +
            "            <MenuItem primaryText=\"Help &amp; feedback\" />\n" +
            "            <MenuItem primaryText=\"Settings\" />\n" +
            "            <MenuItem primaryText=\"Sign out\" />\n" +
            "          </Menu>\n" +
            "        </Popover>\n" +
            "      </div>\n" +
            "    );\n" +
            "  }\n" +
            "}";

      SwingUtil.showPanel(new TextProcessingPanel(inputText, Collections.singleton("[i]")));
   }
}