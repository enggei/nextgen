package nextgen.swing.forms;

import nextgen.swing.ComponentFactory;

import static nextgen.swing.ComponentFactory.newJLabel;
import static nextgen.templates.jgoodies.JavaJGoodiesST.*;

public class FormEditor {

   public static void main(String[] args) {
      com.formdev.flatlaf.FlatDarculaLaf.install();

      final java.awt.Font font = new java.awt.Font("InputMono", java.awt.Font.PLAIN, 24);
      javax.swing.UIManager.put("TextField.font", font);
      javax.swing.UIManager.put("TextArea.font", font);

      nextgen.utils.SwingUtil.showPanel(new FormEditor().newFormBuilderPanel());
   }

   private javax.swing.JComponent newFormBuilderPanel() {
      return new nextgen.swing.forms.FormEditor.FormBuilderPanel();
   }

   static class FormBuilderPanel extends javax.swing.JPanel {

      FormModel model = new nextgen.swing.forms.FormModel();

      javax.swing.JButton btnGenerate = ComponentFactory.newJButton("Generate");
      javax.swing.JButton btnReset = ComponentFactory.newJButton("Reset");
      javax.swing.JButton btnAddColumn = ComponentFactory.newJButton("Add Column");
      javax.swing.JButton btnDelColumn = ComponentFactory.newJButton("Del Column");
      javax.swing.JButton btnAddRow = ComponentFactory.newJButton("Add Row");
      javax.swing.JButton btnDelRow = ComponentFactory.newJButton("Del Row");
      javax.swing.JButton btnMakePanel = ComponentFactory.newJButton("Make Panel");

      SelectButton colCount = new nextgen.swing.forms.FormEditor.FormBuilderPanel.SelectButton(model.counts());
      SelectButton rowCount = new nextgen.swing.forms.FormEditor.FormBuilderPanel.SelectButton(model.counts());
      SelectButton columnAlignments = new nextgen.swing.forms.FormEditor.FormBuilderPanel.SelectButton(model.cAlignments()).action(button -> generateForm());
      SelectButton rowAlignments = new nextgen.swing.forms.FormEditor.FormBuilderPanel.SelectButton(model.rAlignments()).action(button -> generateForm());
      SelectButton columnSizes = new nextgen.swing.forms.FormEditor.FormBuilderPanel.SelectButton(model.sizes()).action(button -> generateForm());
      SelectButton rowSizes = new nextgen.swing.forms.FormEditor.FormBuilderPanel.SelectButton(model.sizes()).action(button -> generateForm());
      SelectButton columnGrowths = new nextgen.swing.forms.FormEditor.FormBuilderPanel.SelectButton(model.growths()).action(button -> generateForm());
      SelectButton rowGrowths = new nextgen.swing.forms.FormEditor.FormBuilderPanel.SelectButton(model.growths()).action(button -> generateForm());
      SelectButton cellHAlignment = new nextgen.swing.forms.FormEditor.FormBuilderPanel.SelectButton(model.hAlignments()).action(button -> generateForm());
      SelectButton cellVAlignment = new nextgen.swing.forms.FormEditor.FormBuilderPanel.SelectButton(model.vAlignments()).action(button -> generateForm());

      SelectButton prefPanelWidth = new nextgen.swing.forms.FormEditor.FormBuilderPanel.SelectButton(model.panelWidths()).action(button -> renderModel());
      SelectButton prefPanelHeight = new nextgen.swing.forms.FormEditor.FormBuilderPanel.SelectButton(model.panelHeights()).action(button -> renderModel());
      SelectButton extending = new nextgen.swing.forms.FormEditor.FormBuilderPanel.SelectButton(model.extending()).action(button -> renderModel());
      SelectButton darkula = new nextgen.swing.forms.FormEditor.FormBuilderPanel.SelectButton(model.laf()).action(button -> renderModel());
      javax.swing.JTextField formName = ComponentFactory.newJTextField("TestPanel", 15);
      javax.swing.JTextField formPackage = ComponentFactory.newJTextField("nextgen.swing.forms", 15);

      javax.swing.JTabbedPane tabbedPane = ComponentFactory.newJTabbedPane();
      javax.swing.JPanel formPanel = new com.jgoodies.forms.debug.FormDebugPanel();

      public FormBuilderPanel() {
         super(new java.awt.BorderLayout(10, 10));

         setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.DARK_GRAY), javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));
         setPreferredSize(new java.awt.Dimension(2500, 1200));

         final javax.swing.JPanel west = ComponentFactory.newJPanel(new java.awt.BorderLayout());
         final javax.swing.JPanel westNorth = ComponentFactory.newJPanel(new java.awt.GridLayout(14, 2));
         westNorth.add(newJLabel("Columns"));
         westNorth.add(colCount);
         westNorth.add(newJLabel("ColumnAlignment"));
         westNorth.add(columnAlignments);
         westNorth.add(newJLabel("ColumnSize"));
         westNorth.add(columnSizes);
         westNorth.add(newJLabel("ColumnGrow"));
         westNorth.add(columnGrowths);
         westNorth.add(newJLabel("Rows"));
         westNorth.add(rowCount);
         westNorth.add(newJLabel("RowAlignment"));
         westNorth.add(rowAlignments);
         westNorth.add(newJLabel("RowSize"));
         westNorth.add(rowSizes);
         westNorth.add(newJLabel("RowGrow"));
         westNorth.add(rowGrowths);
         westNorth.add(newJLabel("Cell V Alignment"));
         westNorth.add(cellVAlignment);
         westNorth.add(newJLabel("Cell H Alignment"));
         westNorth.add(cellHAlignment);

         westNorth.add(newJLabel("Generate"));
         westNorth.add(btnGenerate);
         westNorth.add(btnAddColumn);
         westNorth.add(btnDelColumn);
         westNorth.add(btnAddRow);
         westNorth.add(btnDelRow);
         westNorth.add(newJLabel(""));
         westNorth.add(btnReset);
         west.add(westNorth, java.awt.BorderLayout.NORTH);

         final javax.swing.JPanel westCenter = ComponentFactory.newJPanel(new java.awt.GridLayout(7, 2));
         westCenter.add(newJLabel("Form.width"));
         westCenter.add(prefPanelWidth);
         westCenter.add(newJLabel("Form.height"));
         westCenter.add(prefPanelHeight);
         westCenter.add(newJLabel("Form.extends"));
         westCenter.add(extending);
         westCenter.add(newJLabel("Form.laf"));
         westCenter.add(darkula);
         westCenter.add(newJLabel("Form.package"));
         westCenter.add(formPackage);
         westCenter.add(newJLabel("Form.name"));
         westCenter.add(formName);
         westCenter.add(newJLabel("Form"));
         westCenter.add(btnMakePanel);
         west.add(westCenter, java.awt.BorderLayout.SOUTH);

         add(west, java.awt.BorderLayout.WEST);


         javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(formPanel);
         scrollPane.getVerticalScrollBar().setBlockIncrement(50);
         tabbedPane.add("FormPanel", scrollPane);
         add(tabbedPane, java.awt.BorderLayout.CENTER);

         new ButtonTabComponent(tabbedPane, "Preview", new com.jgoodies.forms.debug.FormDebugPanel());

         colCount.action(button -> generateForm());
         rowCount.action(button -> generateForm());
         btnGenerate.addActionListener(actionEvent -> generateForm());
         btnReset.addActionListener(actionEvent -> reset());
         btnAddColumn.addActionListener(actionEvent -> addColumn());
         btnAddRow.addActionListener(actionEvent -> addRow());
         btnDelColumn.addActionListener(actionEvent -> delColumn());
         btnDelRow.addActionListener(actionEvent -> delRow());
         btnMakePanel.addActionListener(actionEvent -> makePanel());
      }

      private void reset() {
         model.columns().clear();
         model.rows().clear();
         model.cells().clear();
      }

      private void makePanel() {

         System.out.println(debug(model));

         final nextgen.templates.jgoodies.ColumnSpecs columnSpecs = getInnerColumnSpecs();
         final nextgen.templates.jgoodies.RowSpecs rowSpecs = getInnerRowSpecs();

         final String packageName = formPackage.getText().trim();
         final String name = formName.getText().trim();
         final String extendingName = extending.getValue().equals("JPanel") ? "javax.swing.JPanel" : "com.jgoodies.forms.debug.FormDebugPanel";

         final nextgen.templates.jgoodies.FormPanel formPanel = newFormPanel()
               .setPackage(packageName)
               .setName(name)
               .setColSpec(columnSpecs)
               .setRowSpec(rowSpecs)
               .setExtending(extendingName);
         getCellComponents().forEach(cell -> addComponent(formPanel, cell));

         nextgen.st.STGenerator.writeJavaFile(formPanel, packageName, name, "./src/main/java");
}

      private java.util.stream.Stream<nextgen.swing.forms.FormModel.Cell> getCellComponents() {
         return model.cells().stream().filter(cell -> !cell.component().equals(model.components()[0]));  // [0] = "NONE"
      }

      private java.awt.Component newComponent(nextgen.swing.forms.FormModel.Cell cell) {
         switch (cell.component()) {
            case "Label":
               return newJLabel(cell.name());
            case "TextField":
               return ComponentFactory.newJTextField(15);
            case "Button":
               return ComponentFactory.newJButton(cell.name());
            case "TextArea":
               return ComponentFactory.newJTextArea(15, 15);
            case "Table":
               return ComponentFactory.newJTable();
            case "List":
               return ComponentFactory.newJList();
            case "ToggleButton":
               return ComponentFactory.newJToggleButton(cell.name());
            case "TabbedPane":
               return ComponentFactory.newJTabbedPane();
            case "CheckBox":
               return ComponentFactory.newJCheckBox(cell.name());
            case "RadioButton":
               return ComponentFactory.newJRadioButton(cell.name());
            case "Panel":
               return ComponentFactory.newJPanel();
            case "ScrollPane":
               return ComponentFactory.newJScrollPane();
//            case "Component":
//               return null;
         }

         return null;
      }


      private String debug(nextgen.swing.forms.FormModel model) {
         final StringBuilder out = new StringBuilder("\nModel:");
         model.columns().forEach(column -> out
               .append("\ncol  ").append(column.x())
               .append(" ").append(column.y())
               .append(" ").append(column.columnAlignment())
               .append(" ").append(column.size())
               .append(" ").append(column.grow()));
         model.rows().forEach(row -> out
               .append("\nrow  ").append(row.x())
               .append(" ").append(row.y())
               .append(" ").append(row.rowAlignment())
               .append(" ").append(row.size())
               .append(" ").append(row.grow()));
         model.cells().forEach(cell -> out
               .append("\ncell ").append(cell.x())
               .append(" ").append(cell.y())
               .append(" ").append(cell.height())
               .append(" ").append(cell.width())
               .append(" ").append(cell.hAlign())
               .append(" ").append(cell.vAlign())
               .append(" ").append(cell.component())
               .append(" ").append(cell.name()));
         return out.toString();
      }

      private void addComponent(nextgen.templates.jgoodies.FormPanel formPanel, nextgen.swing.forms.FormModel.Cell cell) {
         addComponent(formPanel, cell, null);
      }

      private void addComponent(nextgen.templates.jgoodies.FormPanel formPanel, nextgen.swing.forms.FormModel.Cell cell, Object init) {
         int width = cell.width();
         int height = cell.height();
         final String hAlign = cell.hAlign().toString();
         final String vAlign = cell.vAlign().toString();
         Object type = "javax.swing.J" + cell.component();
         Object x = cell.x() - 1;
         Object y = cell.y() - 1;
         Object name = model.componentPrefixes()[indexOf(model.components(), cell.component())] + (cell.name() == null ? (cell.component() + "_" + cell.x() + "" + cell.y()) : cell.name());

         formPanel.addComponents(width, vAlign, height, hAlign, x, init, type, name, y);
      }

      private void addComponent(javax.swing.JPanel formPanel, nextgen.swing.forms.FormModel.Cell cell) {
         int width = cell.width();
         int height = cell.height();
         final String hAlign = cell.hAlign().toString();
         final String vAlign = cell.vAlign().toString();
         int x = cell.x() - 1;
         int y = cell.y() - 1;
         formPanel.add(newComponent(cell), new com.jgoodies.forms.layout.CellConstraints().xywh(x, y, width, height, hAlign + "," + vAlign));
      }

      private void generateForm() {
         javax.swing.SwingUtilities.invokeLater(() -> {

            int cols = Integer.parseInt(colCount.getValue());
            int rows = Integer.parseInt(rowCount.getValue());

            model.columns().clear();
            for (int i = 0; i < cols; i++)
               model.columns().add(newColumn()
                     .setColumnAlignment(columnAlignments.getValue())
                     .setSize(columnSizes.getValue())
                     .setGrow(columnGrowths.getValue())
                     .setX(i + 2)
                     .setY(1));

            model.rows().clear();
            for (int i = 0; i < rows; i++)
               model.rows().add(newRow()
                     .setRowAlignment(rowAlignments.getValue())
                     .setSize(rowSizes.getValue())
                     .setGrow(rowGrowths.getValue())
                     .setX(1)
                     .setY(i + 2));

            final java.util.Map<String, nextgen.swing.forms.FormModel.Cell> existing = new java.util.LinkedHashMap<>();
            model.cells().forEach(cell -> existing.put(cell.x() + "_" + cell.y(), cell));

            model.cells().clear();
            for (int i = 0; i < cols; i++)
               for (int j = 0; j < rows; j++) {
                  final int iOffset = i + 2;
                  final int jOffset = j + 2;
                  model.cells().add(newCell(iOffset, jOffset, existing.get(iOffset + "_" + jOffset)));
               }

            renderModel();
         });
      }

      private nextgen.swing.forms.FormModel.Cell newCell(int x, int y, nextgen.swing.forms.FormModel.Cell cache) {
         if (cache == null) return newCell().setX(x).setY(y);
         return cache;
      }

      private void renderModel() {
         javax.swing.SwingUtilities.invokeLater(() -> {
            final nextgen.templates.jgoodies.ColumnSpecs columnSpecs = getEditorColumnSpecs();
            final nextgen.templates.jgoodies.RowSpecs rowSpecs = getEditorRowSpecs();
            final com.jgoodies.forms.layout.FormLayout formLayout = new com.jgoodies.forms.layout.FormLayout(columnSpecs.toString(), rowSpecs.toString());
            final com.jgoodies.forms.layout.CellConstraints constraints = new com.jgoodies.forms.layout.CellConstraints();

            formPanel.removeAll();
            formPanel.setLayout(formLayout);

            formPanel.setPreferredSize(new java.awt.Dimension(Integer.parseInt(prefPanelWidth.getValue()), Integer.parseInt(prefPanelHeight.getValue())));

            formPanel.add(new NullCell(), constraints.xy(1, 1));
            model.columns().forEach(column -> formPanel.add(new ColumnCell(column), constraints.xy(column.x(), column.y())));
            model.rows().forEach(row -> formPanel.add(new RowCell(row), constraints.xy(row.x(), row.y())));
            model.cells().forEach(cell -> formPanel.add(new Cell(cell), constraints.xywh(cell.x(), cell.y(), cell.width(), cell.height(), cell.hAlign() + ", " + cell.vAlign())));

            formPanel.revalidate();
            formPanel.repaint();


         });
      }

      private nextgen.templates.jgoodies.ColumnSpec nullColumnSpec() {
         return nextgen.templates.jgoodies.JavaJGoodiesPatterns.newColumnSpec()
               .setSize(newConstantSize().setValue("200"))
               .setColumnAlignment(nextgen.templates.jgoodies.columnAlignment.FILL);
      }

      private nextgen.templates.jgoodies.RowSpec nullRowSpec() {
         return nextgen.templates.jgoodies.JavaJGoodiesPatterns.newRowSpec()
               .setSize(newConstantSize().setValue("200"))
               .setRowAlignment(nextgen.templates.jgoodies.rowAlignment.FILL);
      }

      private nextgen.templates.jgoodies.RowSpecs getEditorRowSpecs() {
         final nextgen.templates.jgoodies.RowSpecs rowSpecs = newRowSpecs().addRowSpec(nullRowSpec());
         model.rows().forEach(row -> rowSpecs.addRowSpec(asRowSpec(row)));
         return rowSpecs;
      }

      private nextgen.templates.jgoodies.ColumnSpecs getEditorColumnSpecs() {
         final nextgen.templates.jgoodies.ColumnSpecs columnSpecs = newColumnSpecs().addColumnSpec(nullColumnSpec());
         model.columns().forEach(column -> columnSpecs.addColumnSpec(asColumnSpec(column)));
         return columnSpecs;
      }

      private nextgen.templates.jgoodies.RowSpecs getInnerRowSpecs() {
         final nextgen.templates.jgoodies.RowSpecs rowSpecs = newRowSpecs();
         model.rows().forEach(row -> rowSpecs.addRowSpec(asRowSpec(row)));
         return rowSpecs;
      }

      private nextgen.templates.jgoodies.ColumnSpecs getInnerColumnSpecs() {
         final nextgen.templates.jgoodies.ColumnSpecs columnSpecs = newColumnSpecs();
         model.columns().forEach(column -> columnSpecs.addColumnSpec(asColumnSpec(column)));
         return columnSpecs;
      }

      private nextgen.templates.jgoodies.RowSpec asRowSpec(nextgen.swing.forms.FormModel.Row row) {
         return nextgen.templates.jgoodies.JavaJGoodiesPatterns.newRowSpec(row.rowAlignment(), row.size(), row.grow());
      }

      private nextgen.templates.jgoodies.ColumnSpec asColumnSpec(nextgen.swing.forms.FormModel.Column column) {
         return nextgen.templates.jgoodies.JavaJGoodiesPatterns.newColumnSpec(column.columnAlignment(), column.size(), column.grow());
      }

      private void addColumn() {
         model.columns().add(newColumn()
               .setColumnAlignment(columnAlignments.getValue())
               .setSize(columnSizes.getValue())
               .setGrow(columnGrowths.getValue())
               .setX(model.columns().size() + 2)
               .setY(1));

         colCount.setValue(Integer.toString(model.columns().size()));

         for (int i = 0; i < model.rows().size(); i++)
            model.cells().add(newCell()
                  .setX(model.columns().size() + 1)
                  .setY(i + 2));

         renderModel();
      }

      private void addRow() {
         model.rows().add(newRow()
               .setRowAlignment(rowAlignments.getValue())
               .setSize(rowSizes.getValue())
               .setGrow(rowGrowths.getValue())
               .setX(1)
               .setY(model.rows().size() + 2));

         rowCount.setValue(Integer.toString(model.rows().size()));

         for (int i = 0; i < model.columns().size(); i++)
            model.cells().add(newCell()
                  .setX(i + 2)
                  .setY(model.rows().size() + 1));

         renderModel();
      }

      private nextgen.swing.forms.FormModel.Column newColumn() {
         return new nextgen.swing.forms.FormModel.Column();
      }

      private nextgen.swing.forms.FormModel.Row newRow() {
         return new nextgen.swing.forms.FormModel.Row();
      }

      private nextgen.swing.forms.FormModel.Cell newCell() {
         return new nextgen.swing.forms.FormModel.Cell().setComponent("NONE").setWidth(1).setHeight(1).setHAlign(cellHAlignment.getValue()).setVAlign(cellVAlignment.getValue());
      }

      private void delColumn() {
         if (model.columns().size() > 1) model.columns().remove(model.columns().size() - 1);
         colCount.setValue(Integer.toString(model.columns().size()));
         final java.util.List<nextgen.swing.forms.FormModel.Cell> cells = model.cells().stream().filter(cell -> cell.x() == model.columns().size() + 2).collect(java.util.stream.Collectors.toList());
         for (nextgen.swing.forms.FormModel.Cell cell : cells) model.cells().remove(cell);
         renderModel();
      }

      private void delRow() {
         if (model.rows().size() > 1) model.rows().remove(model.rows().size() - 1);
         rowCount.setValue(Integer.toString(model.rows().size()));
         final java.util.List<nextgen.swing.forms.FormModel.Cell> cells = model.cells().stream().filter(cell -> cell.y() == model.rows().size() + 2).collect(java.util.stream.Collectors.toList());
         for (nextgen.swing.forms.FormModel.Cell cell : cells) model.cells().remove(cell);
         renderModel();
      }

      private final class SelectButton extends javax.swing.JToggleButton {

         private final java.util.concurrent.atomic.AtomicInteger index = new java.util.concurrent.atomic.AtomicInteger(0);
         private final java.util.List<Object> values = new java.util.ArrayList<>();
         private java.util.function.Consumer<SelectButton> action;

         public SelectButton(Object[] array) {
            this(array, indexOf(array, 0));
         }

         public SelectButton(Object[] array, Object initial) {
            this(array, indexOf(array, initial));
         }

         public SelectButton(Object[] array, int initial) {
            ComponentFactory.decorate(this);

            this.values.addAll(java.util.Arrays.asList(array));
            this.index.set(initial);

            setText(values.get(index.get()).toString());
            addActionListener(actionEvent -> javax.swing.SwingUtilities.invokeLater(() -> {
               if (index.incrementAndGet() >= values.size()) index.set(0);
               setText(values.get(index.get()).toString());
               if (action != null) action.accept(this);
            }));

            addMouseListener(new java.awt.event.MouseAdapter() {
               @Override
               public void mousePressed(java.awt.event.MouseEvent e) {
                  if (javax.swing.SwingUtilities.isRightMouseButton(e)) {
                     javax.swing.SwingUtilities.invokeLater(() -> {
                        javax.swing.JPopupMenu pop = new javax.swing.JPopupMenu();
                        for (int i = 0; i < values.size(); i++) {
                           Object value = values.get(i);
                           int finalI = i;
                           pop.add(newMenuItem(new javax.swing.AbstractAction(value.toString()) {
                              @Override
                              public void actionPerformed(java.awt.event.ActionEvent actionEvent) {
                                 javax.swing.SwingUtilities.invokeLater(() -> {
                                    index.set(finalI);
                                    setText(values.get(index.get()).toString());
                                    if (action != null) action.accept(SelectButton.this);
                                 });
                              }
                           }));
                        }

                        pop.show(SelectButton.this, e.getX(), e.getY());
                     });
                  }
               }
            });
         }

         public SelectButton action(java.util.function.Consumer<SelectButton> actionListenerConsumer) {
            this.action = actionListenerConsumer;
            return this;
         }

         @SuppressWarnings("unchecked")
         public <T> T getValue() {
            return (T) values.get(index.get());
         }

         public int getIndex() {
            return index.get();
         }

         public void setValue(Object value) {
            if (!values.contains(value)) values.add(value);
            index.set(values.indexOf(value));
            setText(values.get(index.get()).toString());
         }
      }

      private static javax.swing.JMenuItem newMenuItem(javax.swing.AbstractAction abstractAction) {
         final javax.swing.JMenuItem jMenuItem = new javax.swing.JMenuItem(abstractAction);
         jMenuItem.setBackground(java.awt.Color.DARK_GRAY);
         jMenuItem.setFont(javax.swing.UIManager.getFont("TextField.font"));
         return jMenuItem;
      }

      private static class NullCell extends javax.swing.JPanel {
         public NullCell() {
            super(new java.awt.BorderLayout());
            setBackground(java.awt.Color.DARK_GRAY);
         }
      }

      private class ColumnCell extends javax.swing.JPanel {
         javax.swing.JComponent[] components;

         public ColumnCell(FormModel.Column col) {
            super(new java.awt.GridLayout(3, 1));
            setBackground(java.awt.Color.DARK_GRAY);
            components = new javax.swing.JComponent[3];
            components[0] = new nextgen.swing.forms.FormEditor.FormBuilderPanel.SelectButton(model.cAlignments(), col.columnAlignment()).action(button -> {
               col.setColumnAlignment(button.getValue());
               renderModel();
            });
            components[1] = new nextgen.swing.forms.FormEditor.FormBuilderPanel.SelectButton(model.sizes(), col.size()).action(button -> {
               col.setSize(button.getValue());
               renderModel();
            });
            components[2] = new nextgen.swing.forms.FormEditor.FormBuilderPanel.SelectButton(model.growths(), col.grow()).action(button -> {
               col.setGrow(button.getValue());
               renderModel();
            });
            for (javax.swing.JComponent component : components) add(component);
         }
      }

      private class RowCell extends javax.swing.JPanel {
         javax.swing.JComponent[] components;

         public RowCell(FormModel.Row row) {
            super(new java.awt.GridLayout(3, 1));
            setBackground(java.awt.Color.DARK_GRAY);
            components = new javax.swing.JComponent[3];
            components[0] = new nextgen.swing.forms.FormEditor.FormBuilderPanel.SelectButton(model.rAlignments(), row.rowAlignment()).action(button -> {
               row.setRowAlignment(button.getValue());
               renderModel();
            });
            components[1] = new nextgen.swing.forms.FormEditor.FormBuilderPanel.SelectButton(model.sizes(), row.size()).action(button -> {
               row.setSize(button.getValue());
               renderModel();
            });
            components[2] = new nextgen.swing.forms.FormEditor.FormBuilderPanel.SelectButton(model.growths(), row.grow()).action(button -> {
               row.setGrow(button.getValue());
               renderModel();
            });
            for (javax.swing.JComponent component : components) add(component);
         }
      }

      private class Cell extends javax.swing.JPanel {
         javax.swing.JComponent[] components;

         public Cell(FormModel.Cell cell) {
            super(new java.awt.GridLayout(6, 1));
            setBackground(java.awt.Color.DARK_GRAY);
            components = new javax.swing.JComponent[6];
            components[0] = new nextgen.swing.forms.FormEditor.FormBuilderPanel.SelectButton(model.components(), cell.component()).action(button -> {
               cell.setComponent(button.getValue());
               renderModel();
            });
            components[1] = new nextgen.swing.forms.FormEditor.FormBuilderPanel.InputField(cell).action(inputField -> {
               cell.setName(inputField.getText());
               renderModel();
            });
            components[2] = new nextgen.swing.forms.FormEditor.FormBuilderPanel.SelectButton(getAvailableWidths(model, cell), (Object) cell.width()).action(button -> {
               cell.setWidth(button.getValue());
               renderModel();
            });
            components[3] = new nextgen.swing.forms.FormEditor.FormBuilderPanel.SelectButton(getAvailableHeights(model, cell), (Object) cell.height()).action(button -> {
               cell.setHeight(button.getValue());
               renderModel();
            });
            components[4] = new nextgen.swing.forms.FormEditor.FormBuilderPanel.SelectButton(model.hAlignments(), cell.hAlign()).action(button -> {
               cell.setHAlign(button.getValue());
               renderModel();
            });
            components[5] = new nextgen.swing.forms.FormEditor.FormBuilderPanel.SelectButton(model.vAlignments(), cell.vAlign()).action(button -> {
               cell.setVAlign(button.getValue());
               renderModel();
            });
            for (javax.swing.JComponent component : components) add(component);
         }

         private Object[] getAvailableWidths(FormModel model, nextgen.swing.forms.FormModel.Cell cell) {
            final int columns = model.columns().size();
            final int c = cell.x() - 1;
            int left = columns - c;
            return getAvailable(left);
         }

         private Object[] getAvailableHeights(FormModel model, nextgen.swing.forms.FormModel.Cell cell) {
            final int rows = model.rows().size();
            final int r = cell.y() - 1;
            int left = rows - r;
            return getAvailable(left);
         }

         private Object[] getAvailable(int left) {
            if (left <= 0) return new Object[]{1};
            final Object[] values = new Object[left + 1];
            for (int i = 0; i <= left; i++) values[i] = (i + 1);
            return values;
         }
      }

      private static int indexOf(Object[] values, Object initial) {
         for (int i = 0; i < values.length; i++)
            if (initial.equals(values[i])) return i;
         return 0;
      }

      private static class InputField extends javax.swing.JTextField {

         private java.util.function.Consumer<InputField> action;

         public InputField(nextgen.swing.forms.FormModel.Cell cell) {
            super(cell.name() == null ? "" : cell.name(), 30);
            setBackground(java.awt.Color.DARK_GRAY);
            setForeground(java.awt.Color.WHITE);
            setFont(javax.swing.UIManager.getFont("TextField.font"));

            addKeyListener(new java.awt.event.KeyAdapter() {
               @Override
               public void keyPressed(java.awt.event.KeyEvent e) {
                  javax.swing.SwingUtilities.invokeLater(() -> {
                     cell.setName(getText());
                  });
               }
            });

            addActionListener(actionEvent -> {
               cell.setName(getText());
               if (action != null) action.accept(this);
            });
         }

         public InputField action(java.util.function.Consumer<InputField> actionListenerConsumer) {
            this.action = actionListenerConsumer;
            return this;
         }
      }

      class ButtonTabComponent extends javax.swing.JPanel {

         ButtonTabComponent(final javax.swing.JTabbedPane pane, String title, com.jgoodies.forms.debug.FormDebugPanel component) {
            super(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));
            ComponentFactory.decorate(this);
            setOpaque(false);

            javax.swing.JLabel label = newJLabel(title);
            label.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 5));
            add(label);

            component.addComponentListener(new java.awt.event.ComponentAdapter() {
               @Override
               public void componentShown(java.awt.event.ComponentEvent e) {
                  component.removeAll();
                  component.setLayout(new com.jgoodies.forms.layout.FormLayout(getInnerColumnSpecs().toString(), getInnerRowSpecs().toString()));
                  getCellComponents().forEach(cell -> addComponent(component, cell));
                  component.revalidate();
                  component.repaint();
               }
            });
            pane.add(title, component);
         }
      }
   }
}