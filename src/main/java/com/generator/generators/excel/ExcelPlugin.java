package com.generator.generators.excel;

import com.generator.app.App;
import com.generator.app.nodes.NeoNode;
import com.generator.generators.project.ProjectPlugin;
import com.generator.util.SwingUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
                  outgoingCELL(rowNode, (cellRelation, cellNode) -> {
                     if ("".equals(ExcelPlugin.getValue(cellNode))) return;
                     final XSSFCell cell = row.createCell(Integer.valueOf(getNameProperty(singleIncomingCOL(cellNode))));
                     cell.setCellValue((String) ExcelPlugin.getValue(cellNode));
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
                  incomingCOL(cellNode.getNode(), (relationship, other) -> relationship.delete());
                  relateCOL(columnNode.getNode(), cellNode.getNode());
               }
            }));

      selectedNodes.stream().
            filter(selectedNode -> isRow(selectedNode.getNode())).
            forEach(rowNode -> pop.add(new App.TransactionAction("Set row to " + getNameProperty(rowNode.getNode()), app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  incomingROW(cellNode.getNode(), (relationship, other) -> relationship.delete());
                  relateROW(rowNode.getNode(), cellNode.getNode());
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
}