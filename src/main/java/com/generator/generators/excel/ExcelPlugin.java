package com.generator.generators.excel;

import com.generator.app.App;
import com.generator.app.nodes.NeoNode;
import com.generator.generators.project.ProjectPlugin;
import com.generator.neo.NeoModel;
import com.generator.util.SwingUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.util.*;
import java.util.List;

/**
 * Created 03.11.17.
 */
public class ExcelPlugin extends ExcelDomainPlugin {

   public ExcelPlugin(App app) {
      super(app);
   }

   @Override
   protected void addActionsTo(JMenu menu) {

      addShowMenu(menu, Entities.Workbook);

      menu.add(new App.TransactionAction("Add Workbook", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String name = SwingUtil.showInputDialog("Name", app);
            if (name == null || name.length() == 0) return;

            fireNodesLoaded(newWorkbook(name));
         }
      });
   }

   @Override
   protected void handleWorkbook(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {

      pop.add(new App.TransactionAction("Add Sheet", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String name = SwingUtil.showInputDialog("Name", app);
            if (name == null || name.length() == 0) return;

            final Node sheet = newSheet(name);
            relateSHEET(neoNode.getNode(), sheet);
            fireNodesLoaded(sheet);
         }
      });

      ProjectPlugin.outgoingRENDERER(neoNode.getNode(), (rendererRelationship, directory) -> pop.add(new App.TransactionAction("Write to " + ProjectPlugin.getPath(directory), app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final XSSFWorkbook workbook = new XSSFWorkbook();

            outgoingSHEET(neoNode.getNode(), (relationship, sheetNode) -> {
               final XSSFSheet sheet = workbook.createSheet(getNameProperty(sheetNode));
               outgoingROW(sheetNode, (rowRelation, rowNode) -> {
                  final XSSFRow row = sheet.createRow(Integer.valueOf(getNameProperty(rowNode)));
                  outgoingCELL(rowNode, (cellRowRelation, cellNode) -> {

                     if ("".equals(ExcelPlugin.getValue(cellNode))) return;

                     incomingCELL(cellNode, (cellColumnRelation, other) -> {
                        if (isColumn(other)) {
                           final XSSFCell cell = row.createCell(Integer.valueOf(getNameProperty(other)));
                           cell.setCellValue((String) ExcelPlugin.getValue(cellNode));
                        }
                     });
                  });
               });
            });

            try {
               final File file = new File(ProjectPlugin.getFile(directory), getNameProperty(neoNode.getNode()) + ".xlsx");
               FileOutputStream outputStream = new FileOutputStream(file);
               workbook.write(outputStream);
               workbook.close();
            } catch (Throwable t) {
               SwingUtil.showException(app, t);
            }
         }
      }));
   }

   @Override
   protected void handleSheet(JPopupMenu pop, NeoNode sheetNode, Set<NeoNode> selectedNodes) {
      pop.add(new App.TransactionAction("Add Row", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final Set<String> existingRows = new LinkedHashSet<>();
            outgoingROW(sheetNode.getNode(), (relationship, rowNode) -> existingRows.add(getNameProperty(rowNode)));

            final List<Integer> availableRows = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
               if (existingRows.contains(Integer.toString(i))) continue;
               availableRows.add(i);
            }

            final Integer newRow = SwingUtil.showSelectDialog(app, availableRows);
            if (newRow == null) return;

            final Node rowNode = newRow();
            setNameProperty(rowNode, newRow.toString());
            relateROW(sheetNode.getNode(), rowNode);
            fireNodesLoaded(rowNode);
         }
      });

      pop.add(new App.TransactionAction("Add Column", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final Set<String> existingColumns = new LinkedHashSet<>();
            outgoingCOL(sheetNode.getNode(), (relationship, colNode) -> existingColumns.add(getNameProperty(colNode)));

            final List<Integer> availableColumns = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
               if (existingColumns.contains(Integer.toString(i))) continue;
               availableColumns.add(i);
            }

            final Object newColumnName = SwingUtil.showSelectDialog(app, availableColumns);
            if (newColumnName == null) return;

            final Node colNode = newColumn(newColumnName.toString());
            relateCOL(sheetNode.getNode(), colNode);
            fireNodesLoaded(colNode);
         }
      });
   }

   @Override
   protected void handleRow(JPopupMenu pop, NeoNode rowNode, Set<NeoNode> selectedNodes) {
      pop.add(new App.TransactionAction("Add Cell", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            final Node cellNode = newCell();
            relateCELL(rowNode.getNode(), cellNode);
            fireNodesLoaded(cellNode);
         }
      });
   }

   @Override
   protected void handleColumn(JPopupMenu pop, NeoNode columnNode, Set<NeoNode> selectedNodes) {
      pop.add(new App.TransactionAction("Add Cell", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            final Node cellNode = newCell();
            relateCELL(columnNode.getNode(), cellNode);
            fireNodesLoaded(cellNode);
         }
      });
   }

   @Override
   protected void handleCell(JPopupMenu pop, NeoNode cellNode, Set<NeoNode> selectedNodes) {

      selectedNodes.stream().
            filter(selectedNode -> isColumn(selectedNode.getNode())).
            forEach(columnNode -> pop.add(new App.TransactionAction("Set column to " + getNameProperty(columnNode.getNode()), app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  incomingCELL(cellNode.getNode(), (relationship, other) -> {
                     if (isColumn(other)) relationship.delete();
                  });
                  relateCELL(columnNode.getNode(), cellNode.getNode());
               }
            }));

      selectedNodes.stream().
            filter(selectedNode -> isRow(selectedNode.getNode())).
            forEach(rowNode -> pop.add(new App.TransactionAction("Set row to " + getNameProperty(rowNode.getNode()), app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  incomingCELL(cellNode.getNode(), (relationship, other) -> {
                     if (isRow(other)) relationship.delete();
                  });
                  relateCELL(rowNode.getNode(), cellNode.getNode());
               }
            }));

      pop.add(new App.TransactionAction("Set value", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            final String value = SwingUtil.showInputDialog("Value", app, ExcelPlugin.getValue(cellNode.getNode()));
            if (value == null || value.equals(ExcelPlugin.getValue(cellNode.getNode()))) return;
            setValue(cellNode.getNode(), value);
         }
      });
   }

   @Override
   protected JComponent newSheetEditor(NeoNode sheetNode) {
      return new SheetEditor(sheetNode);
   }

   private class SheetEditor extends JPanel {

      SheetEditor(NeoNode sheetNode) {
         super(new BorderLayout());

         final JTable tblSheet = new JTable(new SheetTableModel(sheetNode.getNode()));
         final TableColumnModel columnModel = tblSheet.getColumnModel();
         for (int i = 0; i < columnModel.getColumnCount(); i++)
            columnModel.getColumn(i).setMinWidth(50);
         add(new JScrollPane(tblSheet), BorderLayout.CENTER);
      }

      private class SheetTableModel extends AbstractTableModel {

         private final List<Row> content = new ArrayList<>();
         private final Node sheetNode;

         SheetTableModel(Node sheetNode) {

            this.sheetNode = sheetNode;

            final Map<Integer, Node> existingRows = new TreeMap<>();
            final Map<Integer, Map<Integer, Node>> rowCells = new LinkedHashMap<>();
            outgoingROW(sheetNode, (relationship, other) -> {

               final Integer rowName = Integer.valueOf(getNameProperty(other));
               existingRows.put(rowName, other);
               rowCells.put(rowName, new LinkedHashMap<>());

               outgoingCELL(other, (relationship1, cellNode) -> incomingCELL(cellNode, (relationship11, other1) -> {
                  if (isColumn(other1)) {
                     final Integer colName = Integer.valueOf(getNameProperty(other1));
                     rowCells.get(rowName).put(colName, cellNode);
                  }
               }));
            });

            for (int i = 0; i < 50; i++) {
               if (existingRows.containsKey(i))
                  content.add(new Row(i, existingRows.get(i), rowCells.get(i)));
               else content.add(new Row(i));
            }
         }

         @Override
         public int getRowCount() {
            return content.size();
         }

         @Override
         public int getColumnCount() {
            return content.get(0).cells.size();
         }

         @Override
         public Object getValueAt(int rowIndex, int columnIndex) {
            return content.get(rowIndex).cells.get(columnIndex);
         }

         @Override
         public String getColumnName(int column) {
            return content.get(0).cells.get(column).name + "";
         }

         @Override
         public boolean isCellEditable(int rowIndex, int columnIndex) {
            return true;
         }

         @Override
         public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            final Row row = content.get(rowIndex);
            row.cells.get(columnIndex).setValue(aValue, row);
            fireTableCellUpdated(rowIndex, columnIndex);
         }

         private final class Row {

            private final int name;
            private final List<Cell> cells = new ArrayList<>();
            private Node node;

            private Row(int name) {
               this.name = name;
               for (int i = 0; i < 20; i++)
                  cells.add(new Cell(i, null));
            }

            public Row(int name, Node rowNode, Map<Integer, Node> cellNodes) {
               this.name = name;
               this.node = rowNode;

               for (int i = 0; i < 20; i++) {
                  if (cellNodes != null && cellNodes.containsKey(i)) {
                     cells.add(new Cell(i, cellNodes.get(i)));
                  } else {
                     cells.add(new Cell(i, null));
                  }
               }
            }

            public Node getNode() {
               if (node == null) {
                  node = newRow();
                  setNameProperty(node, Integer.toString(name));
                  relateROW(sheetNode, node);
               }
               return node;
            }
         }

         private final class Cell {

            private final int name;
            private String value;
            private Node cellNode;

            Cell(int name, Node cellNode) {
               this.name = name;
               this.cellNode = cellNode;
               this.value = cellNode == null ? null : getValue(cellNode);
            }

            @Override
            public String toString() {
               return value;
            }

            public void setValue(Object aValue, Row row) {
               getGraph().doInTransaction(new NeoModel.Committer() {
                  @Override
                  public void doAction(Transaction tx) throws Throwable {

                     if (cellNode != null) {
                        ExcelPlugin.setValue(cellNode, aValue);
                        value = aValue == null ? null : aValue.toString();
                        return;
                     }

                     final Node rowNode = row.getNode();
                     final Node colNode = getColumnNode();

                     final Node cellNode = newCell();
                     ExcelPlugin.setValue(cellNode, aValue);
                     value = aValue == null ? null : aValue.toString();
                     relateCELL(rowNode, cellNode);
                     relateCELL(colNode, cellNode);
                  }

                  @Override
                  public void exception(Throwable throwable) {
                     SwingUtil.showException(app, throwable);
                  }
               });
            }

            private Node getColumnNode() {

               final Set<Node> found = new LinkedHashSet<>();
               outgoingCOL(sheetNode, (relationship, other) -> {
                  if (isColumn(other) && name == Integer.valueOf(getNameProperty(other)))
                     found.add(other);
               });

               if (found.isEmpty()) {
                  final Node colNode = newColumn();
                  setNameProperty(colNode, Integer.toString(name));
                  relateCOL(sheetNode, colNode);
                  found.add(colNode);
               }

               return found.iterator().next();
            }
         }
      }
   }
}