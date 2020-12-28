package nextgen.swing.forms.builder;

import com.jgoodies.forms.layout.*;
import nextgen.swing.*;
import nextgen.templates.jgoodies.ColumnSpec;
import nextgen.templates.jgoodies.RowSpec;
import nextgen.templates.jgoodies.*;

import javax.swing.*;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static nextgen.swing.ComponentFactory.*;
import static nextgen.templates.jgoodies.JavaJGoodiesST.*;

public class FormEditor extends JPanel {

   private final JPanel formPanel = ComponentFactory.decorate(newJPanel());
   private final JScrollPane formScrollPane = newJScrollPane(formPanel);

   private final SelectButton colCount;
   private final SelectButton rowCount;
   private final SelectButton columnAlignments;
   private final SelectButton rowAlignments;
   private final SelectButton columnSizes;
   private final SelectButton rowSizes;
   private final SelectButton columnGrowths;
   private final SelectButton rowGrowths;
   private final SelectButton cellHAlignment;
   private final SelectButton cellVAlignment;
   private final SelectButton extending;
   private final JTextField formName;
   private final JTextField formPackage;

   private final Stack<FormModel> models = new Stack<>();

   private Consumer<FormEditor> makePanelAction;

   public FormEditor(String name, String packageName, String model) {
      this(parse(name, packageName, model));
   }

   public FormEditor(FormModel model) {
      super(new java.awt.BorderLayout(10, 10));

      models.push(model);
      models.push(new FormModel(models.peek()));

      ComponentFactory.decorate(this);
      setPreferredSize(new java.awt.Dimension(2500, 1200));

      colCount = new SelectButton(model.counts(), Integer.toString(model.columns().size()));
      rowCount = new SelectButton(model.counts(), Integer.toString(model.rows().size()));
      columnAlignments = new SelectButton(model.cAlignments());
      rowAlignments = new SelectButton(model.rAlignments());
      columnSizes = new SelectButton(model.sizes());
      rowSizes = new SelectButton(model.sizes());
      columnGrowths = new SelectButton(model.growths());
      rowGrowths = new SelectButton(model.growths());
      cellHAlignment = new SelectButton(model.hAlignments());
      cellVAlignment = new SelectButton(model.vAlignments());

      final JPanel west = ComponentFactory.newBorderPanel();
      final JPanel westNorth = ComponentFactory.newJPanel(new java.awt.GridLayout(14, 2));
      final JButton btnGenerate = ComponentFactory.newJButton("Generate");
      final JButton btnAddColumn = ComponentFactory.newJButton("Add Column");
      final JButton btnDelColumn = ComponentFactory.newJButton("Del Column");
      final JButton btnAddRow = ComponentFactory.newJButton("Add Row");
      final JButton btnDelRow = ComponentFactory.newJButton("Del Row");
      final JButton btnUndo = ComponentFactory.newJButton("Undo");

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
      westNorth.add(btnUndo);
      west.add(westNorth, java.awt.BorderLayout.NORTH);

      extending = new SelectButton(model.extending());
      formName = ComponentFactory.newJTextField(model.name(), 15);
      formPackage = ComponentFactory.newJTextField(model.packageName(), 15);
      final JButton btnMakePanel = ComponentFactory.newJButton("Save");

      final JPanel westCenter = ComponentFactory.newJPanel(new java.awt.GridLayout(4, 2));
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

      final JTabbedPane tabbedPane = ComponentFactory.newJTabbedPane();
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

      btnUndo.addActionListener(actionEvent -> undo());
      btnAddColumn.addActionListener(actionEvent -> addColumn());
      btnAddRow.addActionListener(actionEvent -> addRow());
      btnDelColumn.addActionListener(actionEvent -> delColumn());
      btnDelRow.addActionListener(actionEvent -> delRow());
      btnMakePanel.addActionListener(actionEvent -> makePanel());

      extending.action(button -> renderModel());

      renderModel();
   }

   public FormModel model() {
      return models.peek();
   }

   public java.util.stream.Stream<FormModel.Cell> getComponentCells() {
      return models.peek().cells().stream()
            .filter(cell -> !cell.component().equals(models.peek().components()[0]));  // [0] = "NONE"
   }

   public String debug() {
      return debug(models.peek());
   }

   public RowSpecs getRowSpecs() {
      final RowSpecs rowSpecs = newRowSpecs();
      models.peek().rows().forEach(row -> rowSpecs.addRowSpec(asRowSpec(row)));
      return rowSpecs;
   }

   public ColumnSpecs getColumnSpecs() {
      final ColumnSpecs columnSpecs = newColumnSpecs();
      models.peek().columns().forEach(column -> columnSpecs.addColumnSpec(asColumnSpec(column)));
      return columnSpecs;
   }

   public FormEditor onMakePanel(Consumer<FormEditor> makePanelAction) {
      this.makePanelAction = makePanelAction;
      return this;
   }

   public String getCellName(FormModel.Cell cell) {
      return models.peek().componentPrefixes()[indexOf(models.peek().components(), cell.component())] + (cell.name() == null ? (cell.component() + "_" + cell.x() + "" + cell.y()) : cell.name());
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


   private void undo() {
      if (models.size() > 1) models.pop();
      renderModel();
   }

   private void makePanel() {

      if (makePanelAction != null) {
         makePanelAction.accept(this);
         return;
      }

      final ColumnSpecs columnSpecs = getColumnSpecs();
      final RowSpecs rowSpecs = getRowSpecs();

      final String packageName = formPackage.getText().trim();
      final String name = formName.getText().trim();

      final FormPanel formPanel = newFormPanel()
            .setPackage(packageName)
            .setModel(debug())
            .setName(name)
            .setColSpec(columnSpecs)
            .setRowSpec(rowSpecs)
            .setExtending("javax.swing.JPanel")
            .setColumns(models.peek().columns().size())
            .setRows(models.peek().rows().size());
      getComponentCells().forEach(cell -> addComponent(formPanel, cell));

      nextgen.st.STGenerator.writeJavaFile(formPanel, packageName, name, "./src/main/java");
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
            final JScrollPane jScrollPane = newJScrollPane();
            jScrollPane.setPreferredSize(new Dimension(800, 600));
            jScrollPane.setBackground(Color.RED);
            return jScrollPane;
      }

      return null;
   }

   private String debug(FormModel model) {
      final StringBuilder out = new StringBuilder();
      model.columns().forEach(column -> out
            .append("col ").append(column.x())
            .append(" ").append(column.y())
            .append(" ").append(column.columnAlignment().name())
            .append(" ").append(column.size())
            .append(" ").append(column.grow())
            .append("\n"));
      model.rows().forEach(row -> out
            .append("row ").append(row.x())
            .append(" ").append(row.y())
            .append(" ").append(row.rowAlignment().name())
            .append(" ").append(row.size())
            .append(" ").append(row.grow())
            .append("\n"));
      model.cells().forEach(cell -> out
            .append("cell ").append(cell.x())
            .append(" ").append(cell.y())
            .append(" ").append(cell.height())
            .append(" ").append(cell.width())
            .append(" ").append(cell.hAlign().name())
            .append(" ").append(cell.vAlign().name())
            .append(" ").append(cell.component())
            .append(" ").append(cell.name())
            .append("\n"));
      System.out.println(out.toString().trim());
      return out.toString().trim();
   }

   private void addComponent(FormPanel formPanel, FormModel.Cell cell) {
      formPanel.addComponents(getCellY(cell), getCellName(cell), getCellType(cell), null, getCellX(cell), cell.hAlign().name(), cell.height(), cell.vAlign().name(), cell.width());
   }

   private void addComponent(JPanel formPanel, FormModel.Cell cell) {
      int width = cell.width();
      int height = cell.height();
      final String hAlign = cell.hAlign().toString();
      final String vAlign = cell.vAlign().toString();
      final java.awt.Component comp = newComponent(cell);
      if (comp != null) formPanel.add(comp, new CellConstraints().xywh(cell.x() - 1, cell.y() - 1, width, height, hAlign + "," + vAlign));
   }

   private void generateForm() {
      SwingUtilities.invokeLater(() -> {

         int cols = Integer.parseInt(colCount.getValue());
         int rows = Integer.parseInt(rowCount.getValue());

         copyFormModel();

         models.peek().columns().clear();
         for (int i = 0; i < cols; i++)
            models.peek().columns().add(newColumn()
                  .setColumnAlignment(columnAlignments.getValue())
                  .setSize(columnSizes.getValue())
                  .setGrow(columnGrowths.getValue())
                  .setX(i + 2)
                  .setY(1));

         models.peek().rows().clear();
         for (int i = 0; i < rows; i++)
            models.peek().rows().add(newRow()
                  .setRowAlignment(rowAlignments.getValue())
                  .setSize(rowSizes.getValue())
                  .setGrow(rowGrowths.getValue())
                  .setX(1)
                  .setY(i + 2));

         final java.util.Map<String, FormModel.Cell> existing = new java.util.LinkedHashMap<>();
         models.peek().cells().forEach(cell -> existing.put(cell.x() + "_" + cell.y(), cell));
         models.peek().cells().clear();
         for (int i = 0; i < cols; i++)
            for (int j = 0; j < rows; j++) {
               final int iOffset = i + 2;
               final int jOffset = j + 2;
               models.peek().cells().add(newCell(iOffset, jOffset, existing.get(iOffset + "_" + jOffset)));
            }

         renderModel();
      });
   }

   private FormModel.Cell newCell(int x, int y, FormModel.Cell cache) {
      if (cache == null) return newCell(x, y);
      return cache.setHAlign(cellHAlignment.getValue()).setVAlign(cellVAlignment.getValue());
   }

   private void renderModel() {
      SwingUtilities.invokeLater(() -> {

         final ColumnSpecs columnSpecs = getEditorColumnSpecs();
         final RowSpecs rowSpecs = getEditorRowSpecs();
         final FormLayout formLayout = new FormLayout(columnSpecs.toString(), rowSpecs.toString());
         final CellConstraints constraints = new CellConstraints();

         formPanel.removeAll();
         formPanel.setLayout(formLayout);

         formPanel.add(ComponentFactory.newBorderPanel(), constraints.xy(1, 1));
         models.peek().columns().forEach(column -> formPanel.add(new ColumnCell(column), constraints.xy(column.x(), column.y())));
         models.peek().rows().forEach(row -> formPanel.add(new RowCell(row), constraints.xy(row.x(), row.y())));
         getEditorCells().forEach(cell -> formPanel.add(new Cell(cell), constraints.xywh(cell.x(), cell.y(), getW(cell), getH(cell), cell.hAlign() + ", " + cell.vAlign())));

         formPanel.revalidate();
         formPanel.repaint();

         formScrollPane.getVerticalScrollBar().setUnitIncrement(100);
         formScrollPane.getHorizontalScrollBar().setUnitIncrement(100);
      });
   }

   private int getW(FormModel.Cell cell) {
      return Math.min(cell.width(), (models.peek().columns().size() - cell.x() + 2));
   }

   private int getH(FormModel.Cell cell) {
      return Math.min(cell.height(), (models.peek().rows().size() - cell.y() + 2));
   }

   private Stream<FormModel.Cell> getEditorCells() {
      final Map<String, FormModel.Cell> occupied = new LinkedHashMap<>();
      final List<FormModel.Cell> cells = models.peek().cells();
      for (FormModel.Cell cell : cells) {
         String key = cell.x() + " " + cell.y();
         if (occupied.containsKey(key)) continue;

         for (int i = 0; i < cell.width(); i++) {
            int x = cell.x() + i;
            occupied.put(x + " " + cell.y(), cell);
         }

         for (int i = 0; i < cell.height(); i++) {
            int y = cell.y() + i;
            occupied.put(cell.x() + " " + y, cell);
         }
      }

      return occupied.values().stream();
   }

   private ColumnSpecs getEditorColumnSpecs() {
      final ColumnSpecs columnSpecs = newColumnSpecs().addColumnSpec(nullColumnSpec());
      models.peek().columns().forEach(column -> columnSpecs.addColumnSpec(asColumnSpec(column)));
      return columnSpecs;
   }

   private RowSpecs getEditorRowSpecs() {
      final RowSpecs rowSpecs = newRowSpecs().addRowSpec(nullRowSpec());
      models.peek().rows().forEach(row -> rowSpecs.addRowSpec(asRowSpec(row)));
      return rowSpecs;
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

   private RowSpec asRowSpec(FormModel.Row row) {
      return JavaJGoodiesPatterns.newRowSpec(row.rowAlignment(), row.size(), row.grow());
   }

   private ColumnSpec asColumnSpec(FormModel.Column column) {
      return JavaJGoodiesPatterns.newColumnSpec(column.columnAlignment(), column.size(), column.grow());
   }

   private void addColumn() {
      copyFormModel().columns().add(newColumn()
            .setColumnAlignment(columnAlignments.getValue())
            .setSize(columnSizes.getValue())
            .setGrow(columnGrowths.getValue())
            .setX(models.peek().columns().size() + 2)
            .setY(1));

      colCount.setValue(Integer.toString(models.peek().columns().size()));

      for (int i = 0; i < models.peek().rows().size(); i++)
         models.peek().cells().add(newCell(models.peek().columns().size() + 1, i + 2));

      renderModel();
   }

   private FormModel copyFormModel() {
      models.push(new FormModel(models.peek()));
      return models.peek();
   }

   private void addRow() {
      copyFormModel().rows().add(newRow()
            .setRowAlignment(rowAlignments.getValue())
            .setSize(rowSizes.getValue())
            .setGrow(rowGrowths.getValue())
            .setX(1)
            .setY(models.peek().rows().size() + 2));

      rowCount.setValue(Integer.toString(models.peek().rows().size()));

      for (int i = 0; i < models.peek().columns().size(); i++)
         models.peek().cells().add(newCell(i + 2, models.peek().rows().size() + 1));

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
      if (models.peek().columns().size() > 1) models.peek().columns().remove(models.peek().columns().size() - 1);
      colCount.setValue(Integer.toString(models.peek().columns().size()));
      renderModel();
   }

   private void delRow() {
      if (models.peek().rows().size() > 1) models.peek().rows().remove(models.peek().rows().size() - 1);
      rowCount.setValue(Integer.toString(models.peek().rows().size()));
      renderModel();
   }

   public String getModelName() {
      return formName.getText().trim();
   }

   public String getModelPackage() {
      return formPackage.getText().trim();
   }

   private class ColumnCell extends JPanel {
      JComponent[] components;

      public ColumnCell(FormModel.Column col) {
         super(new java.awt.GridLayout(3, 1));
         ComponentFactory.decorate(this);

         components = new JComponent[3];
         components[0] = new SelectButton(models.peek().cAlignments(), col.columnAlignment()).action(button -> {
            col.setColumnAlignment(button.getValue());
            renderModel();
         });
         components[1] = new SelectButton(models.peek().sizes(), col.size()).action(button -> {
            col.setSize(button.getValue());
            renderModel();
         });
         components[2] = new SelectButton(models.peek().growths(), col.grow()).action(button -> {
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
         components[0] = new SelectButton(models.peek().rAlignments(), row.rowAlignment()).action(button -> {
            row.setRowAlignment(button.getValue());
            renderModel();
         });
         components[1] = new SelectButton(models.peek().sizes(), row.size()).action(button -> {
            row.setSize(button.getValue());
            renderModel();
         });
         components[2] = new SelectButton(models.peek().growths(), row.grow()).action(button -> {
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
         setBorder(BorderFactory.createLineBorder(Color.BLACK));

         components = new JComponent[6];
         components[0] = new SelectButton(models.peek().components(), cell.component()).action(button -> {
            cell.setComponent(button.getValue());
            renderModel();
         });
         components[1] = new FormEditor.InputField(cell).action(inputField -> {
            cell.setName(inputField.getText());
            renderModel();
         });
         components[2] = new SelectButton(getAvailableWidths(models.peek(), cell), (Object) cell.width()).action(button -> {
            cell.setWidth(button.getValue());
            renderModel();
         });
         components[3] = new SelectButton(getAvailableHeights(models.peek(), cell), (Object) cell.height()).action(button -> {
            cell.setHeight(button.getValue());
            renderModel();
         });
         components[4] = new SelectButton(models.peek().vAlignments(), cell.vAlign())
               .formatter((o) -> "v " + o)
               .action(button -> {
                  cell.setVAlign(button.getValue());
                  renderModel();
               });
         components[5] = new SelectButton(models.peek().hAlignments(), cell.hAlign())
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
               getComponentCells().forEach(cell -> addComponent(innerPanel, cell));
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

   public static FormModel parse(String name, String packageName, String s) {

      final FormModel model = new FormModel();
      model.setName(name);
      model.setPackageName(packageName);

      for (String l : s.split("\n")) {
         final String[] c = l.trim().split("[ ]");
         int i = 1;
         switch (c[0]) {
            case "col":
               model.columns().add(new FormModel.Column()
                     .setX(Integer.parseInt(c[i++]))
                     .setY(Integer.parseInt(c[i++]))
                     .setColumnAlignment(columnAlignment.valueOf(c[i++]))
                     .setSize(c[i++])
                     .setGrow(c[i])
               );

               break;
            case "row":
               model.rows().add(new FormModel.Row()
                     .setX(Integer.parseInt(c[i++]))
                     .setY(Integer.parseInt(c[i++]))
                     .setRowAlignment(rowAlignment.valueOf(c[i++]))
                     .setSize(c[i++])
                     .setGrow(c[i])
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
                     .setName(c[i])
               );
               break;
         }
      }
      return model;
   }

   public static void main(String[] args) {
      ComponentFactory.applyLaf();
      nextgen.utils.SwingUtil.showPanel(new FormEditor("SearchPanel", "tmp", debug(modelTwo())));
   }

   private static String debug(String s) {
      System.out.println(s);
      return s;
   }

   private static String modelTwo() {
      return "col 2 1 CENTER pref none\n" +
            "col 3 1 LEFT pref none\n" +
            "col 4 1 LEFT pref none\n" +
            "row 1 2 TOP pref none\n" +
            "row 1 3 TOP pref none\n" +
            "row 1 4 TOP pref none\n" +
            "cell 2 2 1 1 CENTER CENTER Label search\n" +
            "cell 2 3 1 1 CENTER CENTER Label replace\n" +
            "cell 2 4 1 3 CENTER CENTER ScrollPane result\n" +
            "cell 3 2 1 1 CENTER CENTER TextField search\n" +
            "cell 3 3 1 1 CENTER CENTER TextField replace\n" +
            "cell 3 4 1 1 CENTER CENTER NONE null\n" +
            "cell 4 2 1 1 CENTER CENTER Button search\n" +
            "cell 4 3 1 1 CENTER CENTER Button replace\n" +
            "cell 4 4 1 1 CENTER CENTER NONE null";
   }

   private static String modelOne() {
      return "col 2 1 LEFT PREF none\n" +
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
            "cell 4 4 1 1 FILL FILL NONE null";
   }
}