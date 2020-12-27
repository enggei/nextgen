package nextgen.swing.forms.builder;

import com.jgoodies.forms.layout.*;
import nextgen.swing.ComponentFactory;
import nextgen.templates.jgoodies.ColumnSpec;
import nextgen.templates.jgoodies.RowSpec;
import nextgen.templates.jgoodies.*;

import javax.swing.*;

import java.util.function.Consumer;

import static nextgen.swing.ComponentFactory.*;
import static nextgen.templates.jgoodies.JavaJGoodiesST.*;

public class FormEditor extends JPanel {

   private Consumer<FormEditor> makePanelAction;

   public static void main(String[] args) {
      ComponentFactory.applyLaf();
      nextgen.utils.SwingUtil.showPanel(new FormEditor());
   }


   FormModel model = newFormModel("mod SearchForm nextgen.swing.forms\n" +
         "col 2 1 LEFT PREF none\n" +
         "col 3 1 LEFT PREF grow\n" +
         "col 4 1 LEFT PREF none\n" +
         "row 1 2 FILL PREF none\n" +
         "row 1 3 FILL PREF none\n" +
         "row 1 4 FILL PREF none\n" +
         "cell 2 2 1 1 FILL FILL Label search\n" +
         "cell 2 3 1 1 FILL FILL Label replace\n" +
         "cell 2 4 1 3 FILL FILL ScrollPane result\n" +
         "cell 3 2 1 1 FILL FILL TextField search\n" +
         "cell 3 3 1 1 FILL FILL TextField replace\n" +
         "cell 3 4 1 1 FILL FILL NONE null\n" +
         "cell 4 2 1 1 FILL FILL Button search\n" +
         "cell 4 3 1 1 FILL FILL Button replace\n" +
         "cell 4 4 1 1 FILL FILL NONE null");

   private FormModel newFormModel(String s) {
      final FormModel model = new FormModel();

      for (String l : s.split("\n")) {
         final String[] c = l.trim().split("[ ]");
         int i = 1;
         switch (c[0]) {
            case "mod":
               model.setName(c[i++]);
               model.setPackageName(c[i++]);
               break;
            case "col":
               model.columns().add(new FormModel.Column()
                     .setX(Integer.parseInt(c[i++]))
                     .setY(Integer.parseInt(c[i++]))
                     .setColumnAlignment(columnAlignment.valueOf(c[i++]))
                     .setSize(c[i++])
                     .setGrow(c[i++])
               );

               break;
            case "row":
               model.rows().add(new FormModel.Row()
                     .setX(Integer.parseInt(c[i++]))
                     .setY(Integer.parseInt(c[i++]))
                     .setRowAlignment(rowAlignment.valueOf(c[i++]))
                     .setSize(c[i++])
                     .setGrow(c[i++])
               );

               break;

            case "cell":
               model.cells().add(new FormModel.Cell()
                     .setX(Integer.parseInt(c[i++]))
                     .setY(Integer.parseInt(c[i++]))
                     .setHeight(Integer.parseInt(c[i++]))
                     .setWidth(Integer.parseInt(c[i++]))
                     .setHAlign(hAlignment.valueOf(c[i++]))
                     .setVAlign(vAlignment.valueOf(c[i++]))
                     .setComponent(c[i++])
                     .setName(c[i++])
               );
               break;
         }
      }
      return model;
   }

   SelectButton colCount = new SelectButton(model.counts(), Integer.toString(model.columns().size()));
   SelectButton rowCount = new SelectButton(model.counts(), Integer.toString(model.rows().size()));
   SelectButton columnAlignments = new SelectButton(model.cAlignments());
   SelectButton rowAlignments = new SelectButton(model.rAlignments());
   SelectButton columnSizes = new SelectButton(model.sizes());
   SelectButton rowSizes = new SelectButton(model.sizes());
   SelectButton columnGrowths = new SelectButton(model.growths());
   SelectButton rowGrowths = new SelectButton(model.growths());
   SelectButton cellHAlignment = new SelectButton(model.hAlignments());
   SelectButton cellVAlignment = new SelectButton(model.vAlignments());

   JButton btnReset = ComponentFactory.newJButton("Reset");
   JButton btnGenerate = ComponentFactory.newJButton("Generate");
   JButton btnAddColumn = ComponentFactory.newJButton("Add Column");
   JButton btnDelColumn = ComponentFactory.newJButton("Del Column");
   JButton btnAddRow = ComponentFactory.newJButton("Add Row");
   JButton btnDelRow = ComponentFactory.newJButton("Del Row");
   JButton btnMakePanel = ComponentFactory.newJButton("Make Panel");

   SelectButton prefPanelWidth = new SelectButton(model.panelWidths());
   SelectButton prefPanelHeight = new SelectButton(model.panelHeights());
   SelectButton extending = new SelectButton(model.extending());

   JTextField formName = ComponentFactory.newJTextField(model.name(), 15);
   JTextField formPackage = ComponentFactory.newJTextField(model.packageName(), 15);

   JTabbedPane tabbedPane = ComponentFactory.newJTabbedPane();
   JPanel formPanel = ComponentFactory.decorate(new com.jgoodies.forms.debug.FormDebugPanel());
   JScrollPane formScrollPane = newJScrollPane(formPanel);

   public FormEditor() {
      super(new java.awt.BorderLayout(10, 10));
      ComponentFactory.decorate(this);

      setPreferredSize(new java.awt.Dimension(2500, 1200));

      final JPanel west = ComponentFactory.newJPanel(new java.awt.BorderLayout());
      final JPanel westNorth = ComponentFactory.newJPanel(new java.awt.GridLayout(14, 2));
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
      westNorth.add(newJLabel(""));
      westNorth.add(btnGenerate);
      westNorth.add(btnAddColumn);
      westNorth.add(btnDelColumn);
      westNorth.add(btnAddRow);
      westNorth.add(btnDelRow);
      westNorth.add(newJLabel(""));
      westNorth.add(btnReset);
      west.add(westNorth, java.awt.BorderLayout.NORTH);

      final JPanel westCenter = ComponentFactory.newJPanel(new java.awt.GridLayout(6, 2));
      westCenter.add(newJLabel("Form.width"));
      westCenter.add(prefPanelWidth);
      westCenter.add(newJLabel("Form.height"));
      westCenter.add(prefPanelHeight);
      westCenter.add(newJLabel("Form.extends"));
      westCenter.add(extending);
      westCenter.add(newJLabel("Form.package"));
      westCenter.add(formPackage);
      westCenter.add(newJLabel("Form.name"));
      westCenter.add(formName);
      westCenter.add(newJLabel("Form"));
      westCenter.add(btnMakePanel);
      west.add(westCenter, java.awt.BorderLayout.SOUTH);

      add(west, java.awt.BorderLayout.WEST);

      tabbedPane.add("FormPanel", formScrollPane);
      add(tabbedPane, java.awt.BorderLayout.CENTER);

      new ButtonTabComponent(tabbedPane, "Preview");

      colCount.action(button -> generateForm());
      rowCount.action(button -> generateForm());

      columnAlignments.action(button -> generateForm());
      rowAlignments.action(button -> generateForm());
      columnSizes.action(button -> generateForm());
      rowSizes.action(button -> generateForm());
      columnGrowths.action(button -> generateForm());
      rowGrowths.action(button -> generateForm());
      cellHAlignment.action(button -> generateForm());
      cellVAlignment.action(button -> generateForm());
      btnGenerate.addActionListener(actionEvent -> generateForm());

      btnReset.addActionListener(actionEvent -> reset());
      btnAddColumn.addActionListener(actionEvent -> addColumn());
      btnAddRow.addActionListener(actionEvent -> addRow());
      btnDelColumn.addActionListener(actionEvent -> delColumn());
      btnDelRow.addActionListener(actionEvent -> delRow());
      btnMakePanel.addActionListener(actionEvent -> makePanel());

      prefPanelWidth.action(button -> renderModel());
      prefPanelHeight.action(button -> renderModel());
      extending.action(button -> renderModel());

      renderModel();
   }

   public FormModel model() {
      return model;
   }

   private void reset() {
      model.columns().clear();
      model.rows().clear();
      model.cells().clear();
      generateForm();
   }

   private void makePanel() {

      System.out.println(debug(model));

      if (makePanelAction != null) makePanelAction.accept(this);

      final ColumnSpecs columnSpecs = getColumnSpecs();
      final RowSpecs rowSpecs = getRowSpecs();

      final String packageName = formPackage.getText().trim();
      final String name = formName.getText().trim();

      final FormPanel formPanel = newFormPanel()
            .setPackage(packageName)
            .setName(name)
            .setColSpec(columnSpecs)
            .setRowSpec(rowSpecs)
            .setExtending("javax.swing.JPanel")
            .setColumns(model.columns().size())
            .setRows(model.rows().size());
      getCellComponents().forEach(cell -> addComponent(formPanel, cell));

      nextgen.st.STGenerator.writeJavaFile(formPanel, packageName, name, "./src/main/java");
   }

   private java.util.stream.Stream<FormModel.Cell> getCellComponents() {
      return model.cells().stream().filter(cell -> !cell.component().equals(model.components()[0]));  // [0] = "NONE"
   }

   private java.awt.Component newComponent(FormModel.Cell cell) {
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
      }

      return null;
   }

   private String debug(FormModel model) {
      final StringBuilder out = new StringBuilder("\nmod ").append(model.name())
            .append(" ").append(model.packageName());
      model.columns().forEach(column -> out
            .append("\ncol ").append(column.x())
            .append(" ").append(column.y())
            .append(" ").append(column.columnAlignment().name())
            .append(" ").append(column.size())
            .append(" ").append(column.grow()));
      model.rows().forEach(row -> out
            .append("\nrow ").append(row.x())
            .append(" ").append(row.y())
            .append(" ").append(row.rowAlignment().name())
            .append(" ").append(row.size())
            .append(" ").append(row.grow()));
      model.cells().forEach(cell -> out
            .append("\ncell ").append(cell.x())
            .append(" ").append(cell.y())
            .append(" ").append(cell.height())
            .append(" ").append(cell.width())
            .append(" ").append(cell.hAlign().name())
            .append(" ").append(cell.vAlign().name())
            .append(" ").append(cell.component())
            .append(" ").append(cell.name()));
      return out.toString();
   }

   private void addComponent(FormPanel formPanel, FormModel.Cell cell) {
      int width = cell.width();
      int height = cell.height();
      final String hAlign = cell.hAlign().toString();
      final String vAlign = cell.vAlign().toString();
      formPanel.addComponents(width, vAlign, height, hAlign, getCellX(cell), null, getCellType(cell), getCellName(cell), getCellY(cell));
   }

   private void addComponent(JPanel formPanel, FormModel.Cell cell) {
      int width = cell.width();
      int height = cell.height();
      final String hAlign = cell.hAlign().toString();
      final String vAlign = cell.vAlign().toString();
      final java.awt.Component comp = newComponent(cell);
      if (comp != null) formPanel.add(comp, new CellConstraints().xywh(getCellX(cell), getCellY(cell), width, height, hAlign + "," + vAlign));
   }

   private void generateForm() {
      SwingUtilities.invokeLater(() -> {

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

         final java.util.Map<String, FormModel.Cell> existing = new java.util.LinkedHashMap<>();
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

   private FormModel.Cell newCell(int x, int y, FormModel.Cell cache) {
      if (cache == null) return newCell(x, y);
      return cache;
   }

   private void renderModel() {
      SwingUtilities.invokeLater(() -> {
         System.out.println("renderModel");
         final long start = System.currentTimeMillis();

         final ColumnSpecs columnSpecs = getEditorColumnSpecs();
         final RowSpecs rowSpecs = getEditorRowSpecs();
         final FormLayout formLayout = new FormLayout(columnSpecs.toString(), rowSpecs.toString());
         final CellConstraints constraints = new CellConstraints();

         formPanel.removeAll();
         formPanel.setLayout(formLayout);

         formPanel.add(ComponentFactory.newBorderPanel(), constraints.xy(1, 1));
         model.columns().forEach(column -> formPanel.add(new ColumnCell(column), constraints.xy(column.x(), column.y())));
         model.rows().forEach(row -> formPanel.add(new RowCell(row), constraints.xy(row.x(), row.y())));
         model.cells().forEach(cell -> formPanel.add(new Cell(cell), constraints.xywh(cell.x(), cell.y(), cell.width(), cell.height(), cell.hAlign() + ", " + cell.vAlign())));

         formPanel.revalidate();
         formPanel.repaint();

         formScrollPane.getVerticalScrollBar().setUnitIncrement(100);
         formScrollPane.getHorizontalScrollBar().setUnitIncrement(100);

         System.out.println("took " + (System.currentTimeMillis() - start) + "ms");
      });
   }

   private RowSpecs getEditorRowSpecs() {
      final RowSpecs rowSpecs = newRowSpecs().addRowSpec(nullRowSpec());
      model.rows().forEach(row -> rowSpecs.addRowSpec(asRowSpec(row)));
      return rowSpecs;
   }

   private ColumnSpecs getEditorColumnSpecs() {
      final ColumnSpecs columnSpecs = newColumnSpecs().addColumnSpec(nullColumnSpec());
      model.columns().forEach(column -> columnSpecs.addColumnSpec(asColumnSpec(column)));
      return columnSpecs;
   }

   private nextgen.templates.jgoodies.ColumnSpec nullColumnSpec() {
      return JavaJGoodiesPatterns.newColumnSpec()
            .setSize(newConstantSize().setValue("200"))
            .setColumnAlignment(columnAlignment.FILL);
   }

   private nextgen.templates.jgoodies.RowSpec nullRowSpec() {
      return JavaJGoodiesPatterns.newRowSpec()
            .setSize(newConstantSize().setValue("200"))
            .setRowAlignment(rowAlignment.FILL);
   }

   public RowSpecs getRowSpecs() {
      final RowSpecs rowSpecs = newRowSpecs();
      model.rows().forEach(row -> rowSpecs.addRowSpec(asRowSpec(row)));
      return rowSpecs;
   }

   public ColumnSpecs getColumnSpecs() {
      final ColumnSpecs columnSpecs = newColumnSpecs();
      model.columns().forEach(column -> columnSpecs.addColumnSpec(asColumnSpec(column)));
      return columnSpecs;
   }

   private RowSpec asRowSpec(FormModel.Row row) {
      return JavaJGoodiesPatterns.newRowSpec(row.rowAlignment(), row.size(), row.grow());
   }

   private ColumnSpec asColumnSpec(FormModel.Column column) {
      return JavaJGoodiesPatterns.newColumnSpec(column.columnAlignment(), column.size(), column.grow());
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
         model.cells().add(newCell(model.columns().size() + 1, i + 2));

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
         model.cells().add(newCell(i + 2, model.rows().size() + 1));

      renderModel();
   }

   private FormModel.Column newColumn() {
      return new FormModel.Column();
   }

   private FormModel.Row newRow() {
      return new FormModel.Row();
   }

   private FormModel.Cell newCell(int x, int y) {
      return new FormModel.Cell().setX(x).setY(y).setComponent("NONE").setWidth(1).setHeight(1).setHAlign(cellHAlignment.getValue()).setVAlign(cellVAlignment.getValue());
   }

   private void delColumn() {
      if (model.columns().size() > 1) model.columns().remove(model.columns().size() - 1);
      colCount.setValue(Integer.toString(model.columns().size()));
      renderModel();
   }

   private void delRow() {
      if (model.rows().size() > 1) model.rows().remove(model.rows().size() - 1);
      rowCount.setValue(Integer.toString(model.rows().size()));
      renderModel();
   }

   public FormEditor onMakePanel(Consumer<FormEditor> makePanelAction) {
      this.makePanelAction = makePanelAction;
      return this;
   }

   public String getCellName(FormModel.Cell cell) {
      return model.componentPrefixes()[indexOf(model.components(), cell.component())] + (cell.name() == null ? (cell.component() + "_" + cell.x() + "" + cell.y()) : cell.name());
   }

   public String getCellType(FormModel.Cell cell) {
      return "J" + cell.component();
   }

   public int getCellX(FormModel.Cell cell) {
      return cell.x() - 1;
   }

   public int getCellY(FormModel.Cell cell) {
      return cell.y() - 1;
   }

   private static final class SelectButton extends JToggleButton {

      private final java.util.concurrent.atomic.AtomicInteger index = new java.util.concurrent.atomic.AtomicInteger(0);
      private final java.util.List<Object> values = new java.util.ArrayList<>();
      private java.util.function.Consumer<SelectButton> action;
      private java.util.function.Function<Object, String> formatter = Object::toString;

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
         addActionListener(actionEvent -> SwingUtilities.invokeLater(() -> {
            if (index.incrementAndGet() >= values.size()) index.set(0);
            setValue(values.get(index.get()));
            if (action != null) action.accept(this);
         }));

         addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
               if (SwingUtilities.isRightMouseButton(e)) {
                  SwingUtilities.invokeLater(() -> {
                     JPopupMenu pop = ComponentFactory.newJPopupMenu();
                     for (int i = 0; i < values.size(); i++) {
                        Object value = values.get(i);
                        int finalI = i;
                        pop.add(ComponentFactory.newJMenuItem(new AbstractAction(value.toString()) {
                           @Override
                           public void actionPerformed(java.awt.event.ActionEvent actionEvent) {
                              SwingUtilities.invokeLater(() -> {
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

      public SelectButton formatter(java.util.function.Function<Object, String> formatter) {
         this.formatter = formatter;
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
         setText(formatter.apply(values.get(index.get())));
      }
   }

   private class ColumnCell extends JPanel {
      JComponent[] components;

      public ColumnCell(FormModel.Column col) {
         super(new java.awt.GridLayout(3, 1));
         ComponentFactory.decorate(this);

         components = new JComponent[3];
         components[0] = new SelectButton(model.cAlignments(), col.columnAlignment()).action(button -> {
            col.setColumnAlignment(button.getValue());
            renderModel();
         });
         components[1] = new SelectButton(model.sizes(), col.size()).action(button -> {
            col.setSize(button.getValue());
            renderModel();
         });
         components[2] = new SelectButton(model.growths(), col.grow()).action(button -> {
            col.setGrow(button.getValue());
            renderModel();
         });
         for (JComponent component : components) add(component);
      }
   }

   private class RowCell extends JPanel {
      JComponent[] components;

      public RowCell(FormModel.Row row) {
         super(new java.awt.GridLayout(3, 1));
         ComponentFactory.decorate(this);
         components = new JComponent[3];
         components[0] = new SelectButton(model.rAlignments(), row.rowAlignment()).action(button -> {
            row.setRowAlignment(button.getValue());
            renderModel();
         });
         components[1] = new SelectButton(model.sizes(), row.size()).action(button -> {
            row.setSize(button.getValue());
            renderModel();
         });
         components[2] = new SelectButton(model.growths(), row.grow()).action(button -> {
            row.setGrow(button.getValue());
            renderModel();
         });
         for (JComponent component : components) add(component);
      }
   }

   private class Cell extends JPanel {
      JComponent[] components;

      public Cell(FormModel.Cell cell) {
         super(new java.awt.GridLayout(6, 1));
         ComponentFactory.decorate(this);

         components = new JComponent[6];
         components[0] = new SelectButton(model.components(), cell.component()).action(button -> {
            cell.setComponent(button.getValue());
            renderModel();
         });
         components[1] = new FormEditor.InputField(cell).action(inputField -> {
            cell.setName(inputField.getText());
            renderModel();
         });
         components[2] = new SelectButton(getAvailableWidths(model, cell), (Object) cell.width()).action(button -> {
            cell.setWidth(button.getValue());
            renderModel();
         });
         components[3] = new SelectButton(getAvailableHeights(model, cell), (Object) cell.height()).action(button -> {
            cell.setHeight(button.getValue());
            renderModel();
         });
         components[4] = new SelectButton(model.vAlignments(), cell.vAlign())
               .formatter((o) -> "v " + o)
               .action(button -> {
                  cell.setVAlign(button.getValue());
                  renderModel();
               });
         components[5] = new SelectButton(model.hAlignments(), cell.hAlign())
               .formatter((o) -> "h " + o)
               .action(button -> {
                  cell.setHAlign(button.getValue());
                  renderModel();
               });
         for (JComponent component : components) add(component);
      }

      private Object[] getAvailableWidths(FormModel model, FormModel.Cell cell) {
         final int columns = model.columns().size();
         final int c = cell.x() - 1;
         int left = columns - c;
         return getAvailable(left);
      }

      private Object[] getAvailableHeights(FormModel model, FormModel.Cell cell) {
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

   private static class InputField extends JTextField {

      private java.util.function.Consumer<InputField> action;

      public InputField(FormModel.Cell cell) {
         super(cell.name() == null ? "" : cell.name(), 30);
         ComponentFactory.decorate(this);

         addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
               SwingUtilities.invokeLater(() -> cell.setName(getText()));
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

   class ButtonTabComponent {

      ButtonTabComponent(final JTabbedPane pane, String title) {

         final JPanel container = ComponentFactory.newBorderPanel();
         container.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentShown(java.awt.event.ComponentEvent e) {

               container.removeAll();

               final FormLayout layout = new FormLayout(getColumnSpecs().toString(), getRowSpecs().toString());
               final JPanel innerPanel = getInnerPanel(layout, extending);
               getCellComponents().forEach(cell -> addComponent(innerPanel, cell));
               container.add(innerPanel, java.awt.BorderLayout.CENTER);

               container.revalidate();
               container.repaint();
            }

            private JPanel getInnerPanel(FormLayout layout, SelectButton extending) {
               if (extending.getValue().equals("JPanel"))
                  return ComponentFactory.newJPanel(layout);
               else
                  return new com.jgoodies.forms.debug.FormDebugPanel(layout);
            }
         });

         pane.add(title, container);
      }
   }
}