package com.generator.generators.excel;

import com.generator.app.App;
import com.generator.app.AppMotif;
import com.generator.app.nodes.NeoNode;
import com.generator.generators.project.ProjectPlugin;
import com.generator.util.NeoUtil;
import com.generator.util.StringUtil;
import com.generator.util.SwingUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

import static com.generator.util.NeoUtil.has;

/**
 * Created 03.11.17.
 */
public class ExcelPlugin extends ExcelDomainPlugin {

   public enum CellType {
      String, Integer, Formula
   }

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

               final Map<Integer, Node> rowMap = new TreeMap<>();
               outgoingROW(sheetNode, (relationship1, rowNode) -> rowMap.put(getRow(rowNode), rowNode));

               for (Map.Entry<Integer, Node> rowEntry : rowMap.entrySet()) {
                  final XSSFRow row = sheet.createRow(rowEntry.getKey());

                  final Map<Integer,Node> colMap = new TreeMap<>();
                  outgoingCELL(rowEntry.getValue(), (relationship12, cellNode) -> colMap.put(getCol(cellNode), cellNode));

                  for (Map.Entry<Integer, Node> colEntry : colMap.entrySet()) {
                     final XSSFCell cell = row.createCell(colEntry.getKey());

                     switch (CellType.valueOf(getCellType(colEntry.getValue()))) {
                        case String:
                           cell.setCellValue(getNameProperty(colEntry.getValue()));
                           break;
                        case Integer:
                           if(has(colEntry.getValue(), AppMotif.Properties.name.name()))
                              cell.setCellValue(Integer.valueOf(getNameProperty(colEntry.getValue())));
                           break;
                        case Formula:
                           break;
                     }

                  }
               }
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

            final AtomicInteger rowCount = new AtomicInteger(0);
            outgoingROW(sheetNode.getNode(), (relationship, other) -> rowCount.incrementAndGet());

            final Node rowNode = newRow();
            setRow(rowNode, rowCount.get());
            relateROW(sheetNode.getNode(), rowNode);
            fireNodesLoaded(rowNode);
         }
      });
   }

   @Override
   protected void handleRow(JPopupMenu pop, NeoNode rowNode, Set<NeoNode> selectedNodes) {

      for (CellType cellType : CellType.values()) {
         pop.add(new App.TransactionAction("Add " + cellType.name() + " Cell", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final String value = SwingUtil.showInputDialog("Value", app);
               if (value == null || value.length()==0) return;

               final AtomicInteger rowCount = new AtomicInteger(0);
               outgoingCELL(rowNode.getNode(), (relationship, other) -> rowCount.incrementAndGet());

               final Node cellNode = newCell(value);
               setCol(cellNode, rowCount.get());
               setCellType(cellNode, cellType.name());
               relateCELL(rowNode.getNode(), cellNode);
               fireNodesLoaded(cellNode);
            }
         });
      }
   }

   @Override
   protected void handleCell(JPopupMenu pop, NeoNode cellNode, Set<NeoNode> selectedNodes) {
      pop.add(new App.TransactionAction("Set value", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String value = SwingUtil.showInputDialog("Value", app, getNameProperty(cellNode.getNode()));
            if (value == null || value.equals(getNameProperty(cellNode.getNode()))) return;

            if(StringUtil.isStringNumeric(value)) {
               setCellType(cellNode.getNode(), CellType.Integer.name());
            } else {
               setCellType(cellNode.getNode(), CellType.String.name());
            }

            setNameProperty(cellNode, value);
         }
      });
   }
}