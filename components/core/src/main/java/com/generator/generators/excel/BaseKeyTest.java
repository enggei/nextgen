package com.generator.generators.excel;

import com.generator.generators.java.JavaGroup;
import com.generator.generators.mobx.MobXGroup;
import com.generator.util.GeneratedFile;
import com.generator.util.FileUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created 26.01.18.
 */
public class BaseKeyTest {

   private static final File file = new File("/home/goe/udc/basekey-probe/model.xlsx");
   private static final File javaSrc = new File("/home/goe/udc/basekey-probe/src/main/java");
   private static final File webSrc = new File("/home/goe/udc/basekey-probe/src/main/web");
   private final JavaGroup javaGroup = new JavaGroup();
   private final MobXGroup mobXGroup = new MobXGroup();

   private static final Integer packageColumn = 0;
   private static final Integer domainColumn = 1;
   private static final Integer entityColumn = 2;
   private static final Integer propertyColumn = 3;
   private static final Integer propertyTypeColumn = 4;
   private static final Integer defaultPropertyValueColumn = 5;
   private static final Integer propertyConstraintColumn = 6;
   private static final Integer eqhaColumn = 7;
   private static final Integer lexical = 8;
   private static final Integer apiName = 9;
   private static final Integer apiGET = 10;
   private static final Integer apiPOST = 11;

   private final Map<Integer, String> currentValues = new LinkedHashMap<>();

   @Test
   public void generateEntities() throws IOException {

      final FileInputStream excelFile = new FileInputStream(file);
      final Workbook workbook = new XSSFWorkbook(excelFile);

      final Sheet sheet = workbook.getSheetAt(0);

      final Set<RowHandler> rowHandlers = new LinkedHashSet<>();
      rowHandlers.add(new PojoBuilder());
      rowHandlers.add(new ApiBuilder());

      for (Row currentRow : sheet) {
         if (currentRow.getRowNum() == 0) continue;// ignore header

         // handle row
         updateCurrentValue(currentRow, packageColumn);
         updateCurrentValue(currentRow, domainColumn);
         updateCurrentValue(currentRow, entityColumn);

         updateCurrentValue(currentRow, propertyColumn);
         updateCurrentValue(currentRow, propertyTypeColumn);
         updateCurrentValue(currentRow, defaultPropertyValueColumn, true);
         updateCurrentValue(currentRow, propertyConstraintColumn);

         updateCurrentValue(currentRow, eqhaColumn);
         updateCurrentValue(currentRow, lexical);
         updateCurrentValue(currentRow, apiName);
         updateCurrentValue(currentRow, apiGET);
         updateCurrentValue(currentRow, apiPOST);

         for (RowHandler rowHandler : rowHandlers)
            rowHandler.handleRow(currentRow);
      }

      for (RowHandler rowHandler : rowHandlers)
         rowHandler.end();
   }

   private void updateCurrentValue(Row currentRow, int column) {
      updateCurrentValue(currentRow, column, false);
   }

   private void updateCurrentValue(Row currentRow, int column, boolean remove) {
      if (hasValue(currentRow, column)) {
         currentValues.put(column, getValue(currentRow, column));
      } else {
         if (remove) currentValues.remove(column);
      }
   }

   private String getCurrentValue(int column) {
      return currentValues.get(column);
   }

   interface RowHandler {

      void handleRow(Row row);

      void end();
   }

   private final class ApiBuilder implements RowHandler {

      private MobXGroup.DomainStoreST domainStoreST;

      @Override
      public void handleRow(Row row) {

         if (hasValue(row, apiName)) {

            if (domainStoreST != null) {
               writeMobXDomainStore(getCurrentValue(domainColumn), getCurrentValue(apiName) + "Store", domainStoreST);
            }

            domainStoreST = mobXGroup.newDomainStore().
                  setName(getValue(row, apiName, false));

            domainStoreST.addObservablesValue(getCurrentValue(entityColumn), "new " + getCurrentValue(entityColumn) + "()", "./" + getCurrentValue(entityColumn));

            if (hasValue(row, apiGET))
               domainStoreST.addActionsValue(mobXGroup.newaction().
                     setName("load" + getCurrentValue(entityColumn)).
                     addStatementsValue(mobXGroup.newgetRequest().
                           setUrl(getCurrentValue(apiGET)).
                           setEntity(getCurrentValue(entityColumn))));

            if (hasValue(row, apiPOST))
               domainStoreST.addActionsValue(mobXGroup.newaction().
                     setName("save" + getCurrentValue(entityColumn)).
                     addStatementsValue(mobXGroup.newpostRequest().
                           setUrl(getCurrentValue(apiPOST)).
                           setEntity(getCurrentValue(entityColumn))));
         }
      }

      @Override
      public void end() {
         if (domainStoreST != null) {
            writeMobXDomainStore(getCurrentValue(domainColumn), getCurrentValue(apiName) + "Store", domainStoreST);
         }
      }

      private void writeMobXDomainStore(String currentDomain, String currentEntity, MobXGroup.DomainStoreST template) {
         System.out.println(template);
         final File dir = new File(webSrc.getAbsolutePath(), currentDomain);
         FileUtil.write(template, new File(dir, currentEntity + ".js"));
      }
   }

   private final class PojoBuilder implements RowHandler {


      JavaGroup.PojoST currentPojo = null;
      MobXGroup.ModelST currentMobXModel = null;

      @Override
      public void handleRow(Row row) {

         if (hasValue(row, entityColumn)) {

            if (currentPojo != null) {
               writeMobXObservable(getCurrentValue(domainColumn), getCurrentValue(entityColumn), currentMobXModel);
               writePojo(getCurrentValue(packageColumn), getCurrentValue(domainColumn), getCurrentValue(entityColumn), currentPojo);
            }

            currentPojo = javaGroup.newPojo().
                  setPackage(getCurrentValue(packageColumn) + "." + getCurrentValue(domainColumn)).
                  setName(getCurrentValue(entityColumn));

            currentMobXModel = mobXGroup.newModel().
                  setName(getCurrentValue(entityColumn));
         }

         if (hasValue(row, eqhaColumn))
            currentPojo.addEqhaValue(getCurrentValue(propertyColumn));

         if (hasValue(row, lexical))
            currentPojo.addLexicalValue(getCurrentValue(propertyColumn));

         if (hasValue(row, propertyColumn) && hasValue(row, propertyTypeColumn)) {
            currentPojo.addPropertiesValue(getCurrentValue(defaultPropertyValueColumn), getCurrentValue(propertyTypeColumn), getCurrentValue(propertyColumn), null,null,null, false);
            currentMobXModel.addObservablesValue(getCurrentValue(defaultPropertyValueColumn), getCurrentValue(propertyColumn));
         }
      }

      @Override
      public void end() {
         if (currentPojo != null) {
            writeMobXObservable(getCurrentValue(domainColumn), getCurrentValue(entityColumn), currentMobXModel);
            writePojo(getCurrentValue(packageColumn), getCurrentValue(domainColumn), getCurrentValue(entityColumn), currentPojo);
         }
      }

      private void writeMobXObservable(String currentDomain, String currentEntity, MobXGroup.ModelST template) {
//         System.out.println(template);
         final File dir = new File(webSrc.getAbsolutePath(), currentDomain);
         FileUtil.write(template, new File(dir, currentEntity + ".js"));
      }

      private void writePojo(String currentPackage, String currentDomain, String currentEntity, JavaGroup.PojoST template) {
//         System.out.println(template);
         try {
            GeneratedFile.newJavaFile(javaSrc.getAbsolutePath(), currentPackage + "." + currentDomain, currentEntity).write(template);
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }

   private static boolean hasValue(Row row, int column) {
      return hasValue(row.getCell(column));
   }

   private static boolean hasValue(Cell cell) {

      if (cell == null) return false;

      switch (cell.getCellTypeEnum()) {
         case _NONE:
            break;
         case NUMERIC:
            return 0.0d != cell.getNumericCellValue();
         case STRING:
            return cell.getStringCellValue() != null && cell.getStringCellValue().length() > 0;
         case FORMULA:
            break;
         case BLANK:
            break;
         case BOOLEAN:
            break;
         case ERROR:
            break;
      }

      return false;
   }

   public static String getValue(Row row, int column, boolean asString) {
      return getValue(row.getCell(column), asString);
   }

   public static String getValue(Row row, int column) {
      return getValue(row.getCell(column), false);
   }

   public static String getValue(Cell cell, boolean asString) {
      switch (cell.getCellTypeEnum()) {
         case _NONE:
            return null;
         case NUMERIC:
            final String tmp = cell.getNumericCellValue() + "";
            return tmp.endsWith(".0") ? tmp.substring(0, tmp.length() - 2) : tmp;
         case STRING:
            return asString ? ("\"" + cell.getStringCellValue() + "\"") : cell.getStringCellValue();
         case FORMULA:
            return null;
         case BLANK:
            return null;
         case BOOLEAN:
            return null;
         case ERROR:
            return null;
      }
      return null;
   }
}