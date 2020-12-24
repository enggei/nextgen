package nextgen.templates.jgoodies;

public class JavaJGoodiesPatterns extends JavaJGoodiesST {

   public static nextgen.templates.jgoodies.ColumnSpec newColumnSpec(nextgen.templates.jgoodies.columnAlignment fill, String size, String grow) {
      final nextgen.templates.jgoodies.ColumnSpec columnSpec = newColumnSpec();
      columnSpec.setColumnAlignment(fill);
      columnSpec.setSize(size == null ? newConstantSize(defaultSize()) : newConstantSize(size));
      columnSpec.setResizeBehavior(grow == null ? null : newResizeBehavior().setGROW(grow));
      return columnSpec;
   }

   public static nextgen.templates.jgoodies.ColumnSpec newColumnSpec(Object fill, Object size, Object grow) {
      final nextgen.templates.jgoodies.ColumnSpec columnSpec = newColumnSpec();
      columnSpec.setColumnAlignment(fill == null ? null : columnAlignment.valueOf(fill.toString()));
      columnSpec.setSize(size == null ? newConstantSize(defaultSize()) : newConstantSize(size.toString().trim()));
      columnSpec.setResizeBehavior(grow == null ? null : newResizeBehavior().setGROW(grow));
      return columnSpec;
   }

   public static nextgen.templates.jgoodies.RowSpec newRowSpec(nextgen.templates.jgoodies.rowAlignment fill, String size, String grow) {
      final nextgen.templates.jgoodies.RowSpec rowSpec = newRowSpec();
      rowSpec.setRowAlignment(fill);
      rowSpec.setSize(size == null ? newConstantSize(defaultSize()) : newConstantSize(size));
      rowSpec.setResizeBehavior(grow == null ? null : newResizeBehavior().setGROW(grow));
      return rowSpec;
   }

   public static nextgen.templates.jgoodies.RowSpec newRowSpec(Object fill, Object size, Object grow) {
      final nextgen.templates.jgoodies.RowSpec rowSpec = newRowSpec();
      rowSpec.setRowAlignment(fill == null ? null : rowAlignment.valueOf(fill.toString()));
      rowSpec.setSize(size == null ? newConstantSize(defaultSize()) : newConstantSize(size.toString().trim()));
      rowSpec.setResizeBehavior(grow == null ? null : newResizeBehavior().setGROW(grow));
      return rowSpec;
   }

   private static nextgen.templates.jgoodies.Size newConstantSize(String size) {
      return newConstantSize().setValue(size);
   }

   private static String defaultSize() {
      return "15px";
   }
}