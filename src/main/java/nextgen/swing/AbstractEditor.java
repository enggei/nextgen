package nextgen.swing;

public class AbstractEditor extends javax.swing.JPanel {

   protected final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AbstractEditor.class);

   public AbstractEditor() {
      super(new java.awt.BorderLayout());
      setBackground(javax.swing.UIManager.getColor("Panel.background"));
//      setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getColor("Panel.background")));
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
      return new javax.swing.JLabel(name);
   }

   protected <T> void selectAndRender(javax.swing.JComponent owner, java.util.Collection<T> values, java.util.function.Function<T, String> renderer, T defaultValue, java.util.function.Consumer<T> consumer) {
      nextgen.utils.SwingUtil.showSelectDialog("Select", owner, values, renderer, defaultValue, selected -> appModel().doLaterInTransaction(transaction1 -> consumer.accept(selected)));
   }

   protected javax.swing.JButton newButton(String name, java.util.function.Consumer<org.neo4j.graphdb.Transaction> onClick) {
      return new javax.swing.JButton(appModel().newTransactionAction(name, onClick));
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

   protected BorderPanel newBorderPanel() {
      return new AbstractEditor.BorderPanel();
   }

   protected FormPanel newFormPanel(nextgen.swing.FormPanelParameters params) {
      return new AbstractEditor.FormPanel(params);
   }

   protected GridPanel newGridPanel(int rows, int cols) {
      return new AbstractEditor.GridPanel(rows, cols);
   }

   protected GridPanel newGrid1x1Panel() {
      return new AbstractEditor.GridPanel(1, 1);
   }

   protected GridPanel newGrid2x2Panel() {
      return new AbstractEditor.GridPanel(2, 2);
   }

   protected static class FlowPanel extends BasePanel {
      FlowPanel() {
         super();
         setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));
      }
   }

   protected static class BorderPanel extends BasePanel {
      BorderPanel() {
         super();
         setLayout(new java.awt.BorderLayout(4, 4));
      }

      public BorderPanel addNorth(javax.swing.JComponent component) {
         add(component, java.awt.BorderLayout.NORTH);
         return this;
      }

      public BorderPanel addSouth(javax.swing.JComponent component) {
         add(component, java.awt.BorderLayout.SOUTH);
         return this;
      }

      public BorderPanel addEast(javax.swing.JComponent component) {
         add(component, java.awt.BorderLayout.EAST);
         return this;
      }

      public BorderPanel addEast(javax.swing.Action action) {
         add(new javax.swing.JButton(action), java.awt.BorderLayout.EAST);
         return this;
      }

      public BorderPanel addEast(String label) {
         add(new javax.swing.JLabel(label), java.awt.BorderLayout.EAST);
         return this;
      }

      public BorderPanel addWest(javax.swing.JComponent component) {
         add(component, java.awt.BorderLayout.WEST);
         return this;
      }

      public BorderPanel addWest(String label) {
         add(new javax.swing.JLabel(label), java.awt.BorderLayout.WEST);
         return this;
      }

      public BorderPanel addCenter(javax.swing.JComponent component) {
         add(component, java.awt.BorderLayout.CENTER);
         return this;
      }
   }

   protected static class ColumnPanel extends BasePanel {
      ColumnPanel() {
         super();
         setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));
      }
   }

   protected static class GridPanel extends BasePanel {
      GridPanel(int rows, int cols) {
         super();
         setLayout(new java.awt.GridLayout(rows, cols, 4, 4));
      }
   }

   protected static class ConstantFormPanel extends FormPanel {

      ConstantFormPanel() {
         super(new nextgen.swing.FormPanelParameters() {
            @Override
            public String columnSpecs() {
               return "fill:50px:grow(.25), fill:50px:grow, fill:50px:grow(.25)";
            }

            @Override
            public String rowSpecs() {
               return "fill:50px";
            }

            @Override
            public java.util.stream.Stream<nextgen.swing.FormPanelParameters.FormComponent> components() {

               final java.util.concurrent.atomic.AtomicInteger count = new java.util.concurrent.atomic.AtomicInteger();

               return java.util.Arrays.stream(new nextgen.swing.FormPanelParameters.FormComponent[]{

                     new nextgen.swing.FormPanelParameters.FormComponent() {
                        @Override
                        public javax.swing.JComponent component() {
                           return new javax.swing.JLabel("Comp " + count.incrementAndGet());
                        }

                        @Override
                        public Object constraints() {
                           return new com.jgoodies.forms.layout.CellConstraints().xy(1, 1);
                        }
                     },

               new nextgen.swing.FormPanelParameters.FormComponent() {
                        @Override
                        public javax.swing.JComponent component() {
                           return new javax.swing.JLabel("Comp " + count.incrementAndGet());
                        }

                        @Override
                        public Object constraints() {
                           return new com.jgoodies.forms.layout.CellConstraints().xy(2, 1);
                        }
                     },

                     new nextgen.swing.FormPanelParameters.FormComponent() {
                        @Override
                        public javax.swing.JComponent component() {
                           return new javax.swing.JLabel("Comp " + count.incrementAndGet());
                        }

                        @Override
                        public Object constraints() {
                           return new com.jgoodies.forms.layout.CellConstraints().xy(3, 1);
                        }
                     },

               });
            }
         });
      }
   }

   protected static class FormPanel extends BasePanel {
      FormPanel(FormPanelParameters params) {
         super();
         final com.jgoodies.forms.layout.FormLayout layout = new com.jgoodies.forms.layout.FormLayout(params.columnSpecs(), params.rowSpecs());
         setLayout(layout);

         params.components().forEach(formComponent -> add(formComponent.component(), formComponent.constraints()));
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
         setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
      }

      public AbstractEditor.BasePanel append(javax.swing.JComponent jComponent) {
         add(jComponent);
         return this;
      }

      public AbstractEditor.BasePanel appendButton(javax.swing.Action action) {
         add(new javax.swing.JButton(action));
         return this;
      }

      public AbstractEditor.BasePanel appendLabel(String label) {
         add(new javax.swing.JLabel(label));
         return this;
      }
   }

   protected javax.swing.JScrollPane newScrollPane(javax.swing.JComponent component) {
      return newScrollPane(component, 5);
   }

   protected javax.swing.JScrollPane newScrollPane(javax.swing.JComponent component, int tick) {
      final javax.swing.JScrollPane jScrollPane = new javax.swing.JScrollPane(component);
      jScrollPane.setBackground(javax.swing.UIManager.getColor("Panel.background"));
      jScrollPane.getVerticalScrollBar().setUnitIncrement(tick);
      return jScrollPane;
   }
}