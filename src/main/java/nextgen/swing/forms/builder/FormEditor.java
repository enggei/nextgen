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
import java.util.stream.*;

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

   private final JButton btnUndo = ComponentFactory.newJButton("Undo");

   private final Stack<FormModel> models = new Stack<>();

   private Consumer<FormEditor> makePanelAction;

   public FormEditor(String name, String packageName, String model) {
      this(parse(name, packageName, model));
   }

   public FormEditor(FormModel model) {
      super(new java.awt.BorderLayout(10, 10));

      models.push(model);

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

   private void copyFormModel() {
      System.out.println("pushing");
      models.push(new FormModel(model()));
      btnUndo.setEnabled(true);
   }

   public FormEditor onMakePanel(Consumer<FormEditor> makePanelAction) {
      this.makePanelAction = makePanelAction;
      return this;
   }

   public java.util.stream.Stream<FormModel.Cell> getComponentCells() {
      return model().cells().stream()
            .filter(cell -> !cell.component().equals(model().components()[0]));  // [0] = "NONE"
   }

   public RowSpecs getRowSpecs() {
      final RowSpecs rowSpecs = newRowSpecs();
      model().rows().forEach(row -> rowSpecs.addRowSpec(asRowSpec(row)));
      return rowSpecs;
   }

   public ColumnSpecs getColumnSpecs() {
      final ColumnSpecs columnSpecs = newColumnSpecs();
      model().columns().forEach(column -> columnSpecs.addColumnSpec(asColumnSpec(column)));
      return columnSpecs;
   }

   public String getCellName(FormModel.Cell cell) {
      return model().componentPrefixes()[indexOf(model().components(), cell.component())] + (cell.name() == null ? (cell.component() + "_" + cell.x() + "" + cell.y()) : cell.name());
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
      if (models.size() > 1) {
         models.pop();
         System.out.println("popping");
      } else {
         btnUndo.setEnabled(false);
      }
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
            .setColumns(model().columns().size())
            .setRows(model().rows().size());
      getComponentCells().forEach(cell -> formPanel.addComponents(cell.y() - 1, getCellName(cell), getCellType(cell), null, cell.x() - 1, cell.hAlign().name(), cell.height(), cell.vAlign().name(), cell.width()));

      //nextgen.st.STGenerator.writeJavaFile(formPanel, packageName, name, "./src/main/java");
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

         model().columns().clear();
         for (int i = 0; i < cols; i++)
            model().columns().add(newColumn()
                  .setColumnAlignment(columnAlignments.getValue())
                  .setSize(columnSizes.getValue())
                  .setGrow(columnGrowths.getValue())
                  .setX(i + 2)
                  .setY(1));

         model().rows().clear();
         for (int i = 0; i < rows; i++)
            model().rows().add(newRow()
                  .setRowAlignment(rowAlignments.getValue())
                  .setSize(rowSizes.getValue())
                  .setGrow(rowGrowths.getValue())
                  .setX(1)
                  .setY(i + 2));

         final java.util.Map<String, FormModel.Cell> existing = new java.util.LinkedHashMap<>();
         model().cells().forEach(cell -> existing.put(cell.x() + "_" + cell.y(), cell));
         model().cells().clear();
         for (int i = 0; i < cols; i++)
            for (int j = 0; j < rows; j++) {
               final int iOffset = i + 2;
               final int jOffset = j + 2;
               model().cells().add(newCell(iOffset, jOffset, existing.get(iOffset + "_" + jOffset)));
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
         model().columns().forEach(column -> formPanel.add(new ColumnCell(column), constraints.xy(column.x(), column.y())));
         model().rows().forEach(row -> formPanel.add(new RowCell(row), constraints.xy(row.x(), row.y())));
         getEditorCells().forEach(cell -> formPanel.add(new Cell(cell), constraints.xywh(cell.x(), cell.y(), cell.width(), cell.height(), cell.hAlign() + ", " + cell.vAlign())));

         formPanel.revalidate();
         formPanel.repaint();

         formScrollPane.getVerticalScrollBar().setUnitIncrement(100);
         formScrollPane.getHorizontalScrollBar().setUnitIncrement(100);
      });
   }

   private Stream<FormModel.Cell> getEditorCells() {
      final Map<String, FormModel.Cell> occupied = new LinkedHashMap<>();
      final List<FormModel.Cell> cells = model().cells();
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

//      return occupied.values().stream().filter(cell -> getX(cell) < model().columns().size() - 2).filter(cell -> getY(cell) < model().rows().size() - 2);
      return occupied.values().stream();
   }

   private ColumnSpecs getEditorColumnSpecs() {
      final ColumnSpecs columnSpecs = newColumnSpecs().addColumnSpec(nullColumnSpec());
      model().columns().forEach(column -> columnSpecs.addColumnSpec(asColumnSpec(column)));
      return columnSpecs;
   }

   private RowSpecs getEditorRowSpecs() {
      final RowSpecs rowSpecs = newRowSpecs().addRowSpec(nullRowSpec());
      model().rows().forEach(row -> rowSpecs.addRowSpec(asRowSpec(row)));
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
      copyFormModel();

      model().columns().add(newColumn()
            .setColumnAlignment(columnAlignments.getValue())
            .setSize(columnSizes.getValue())
            .setGrow(columnGrowths.getValue())
            .setX(model().columns().size() + 2)
            .setY(1));

      colCount.setValue(Integer.toString(model().columns().size()));

      for (int i = 0; i < model().rows().size(); i++)
         model().cells().add(newCell(model().columns().size() + 1, i + 2));

      renderModel();
   }

   private void addRow() {
      copyFormModel();

      model().rows().add(newRow()
            .setRowAlignment(rowAlignments.getValue())
            .setSize(rowSizes.getValue())
            .setGrow(rowGrowths.getValue())
            .setX(1)
            .setY(model().rows().size() + 2));

      rowCount.setValue(Integer.toString(model().rows().size()));

      for (int i = 0; i < model().columns().size(); i++)
         model().cells().add(newCell(i + 2, model().rows().size() + 1));

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
      if (model().columns().size() > 0) {
         System.out.println("delColumn");
         copyFormModel();
         final FormModel.Column column = model().columns().remove(model().columns().size() - 1);
         final List<FormModel.Cell> colCells = model().cells().stream().filter(cell -> cell.x() >= column.x()).collect(Collectors.toList());
         for (FormModel.Cell colCell : colCells) model().cells().remove(colCell);
         colCount.setValue(Integer.toString(model().columns().size()));
         renderModel();
      }
   }

   private void delRow() {
      if (model().rows().size() > 0) {
         System.out.println("delRow");
         copyFormModel();
         final FormModel.Row row = model().rows().remove(model().rows().size() - 1);
         final List<FormModel.Cell> rowCells = model().cells().stream().filter(cell -> cell.y() >= row.y()).collect(Collectors.toList());
         for (FormModel.Cell rowCell : rowCells) model().cells().remove(rowCell);
         rowCount.setValue(Integer.toString(model().rows().size()));
         renderModel();
      }
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
         components[0] = new SelectButton(model().cAlignments(), col.columnAlignment()).action(button -> {
            col.setColumnAlignment(button.getValue());
            renderModel();
         });
         components[1] = new SelectButton(model().sizes(), col.size()).action(button -> {
            col.setSize(button.getValue());
            renderModel();
         });
         components[2] = new SelectButton(model().growths(), col.grow()).action(button -> {
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
         components[0] = new SelectButton(model().rAlignments(), row.rowAlignment()).action(button -> {
            row.setRowAlignment(button.getValue());
            renderModel();
         });
         components[1] = new SelectButton(model().sizes(), row.size()).action(button -> {
            row.setSize(button.getValue());
            renderModel();
         });
         components[2] = new SelectButton(model().growths(), row.grow()).action(button -> {
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
         components[0] = new SelectButton(model().components(), cell.component()).action(button -> {
            cell.setComponent(button.getValue());
            renderModel();
         });
         components[1] = new FormEditor.InputField(cell).action(inputField -> {
            cell.setName(inputField.getText());
            renderModel();
         });
         components[2] = new SelectButton(getAvailableWidths(model(), cell), (Object) cell.width()).action(button -> {
            cell.setWidth(button.getValue());
            renderModel();
         });
         components[3] = new SelectButton(getAvailableHeights(model(), cell), (Object) cell.height()).action(button -> {
            cell.setHeight(button.getValue());
            renderModel();
         });
         components[4] = new SelectButton(model().vAlignments(), cell.vAlign())
               .formatter((o) -> "v " + o)
               .action(button -> {
                  cell.setVAlign(button.getValue());
                  renderModel();
               });
         components[5] = new SelectButton(model().hAlignments(), cell.hAlign())
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
                     .setName(c.length == 9 ? c[i] : null));
               break;
         }
      }
      return model;
   }

   public static void main(String[] args) {
      ComponentFactory.applyLaf();
      nextgen.utils.SwingUtil.showPanel(new FormEditor("SearchPanel", "tmp", debug(modelOne())));
   }

   private static String debug(String s) {
      System.out.println(s);
      return s;
   }

   private static String modelOne() {
      return "col 2 1 CENTER 75 none\n" +
            "col 3 1 CENTER 75 none\n" +
            "col 4 1 FILL pref grow\n" +
            "col 5 1 LEFT pref none\n" +
            "row 1 2 TOP pref none\n" +
            "cell 2 2 1 1 FILL TOP Label key\n" +
            "cell 3 2 1 1 FILL TOP Component value\n" +
            "cell 4 2 1 1 CENTER CENTER NONE null";
   }

   public String debug() {
      final StringBuilder out = new StringBuilder();
      model().columns().forEach(column -> out
            .append("col ").append(column.x())
            .append(" ").append(column.y())
            .append(" ").append(column.columnAlignment().name())
            .append(" ").append(column.size())
            .append(" ").append(column.grow())
            .append("\n"));
      model().rows().forEach(row -> out
            .append("row ").append(row.x())
            .append(" ").append(row.y())
            .append(" ").append(row.rowAlignment().name())
            .append(" ").append(row.size())
            .append(" ").append(row.grow())
            .append("\n"));
      model().cells().forEach(cell -> out
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
}