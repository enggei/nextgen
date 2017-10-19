package com.generator.generators.mysql;

import com.generator.generators.java.JavaGroup;
import com.generator.generators.mysql.parser.MySqlParser;
import com.generator.generators.mysql.parser.MySqlParserNodeListener;
import com.generator.generators.stringtemplate.GeneratedFile;
import com.generator.util.StringUtil;

import java.io.IOException;
import java.util.Stack;

/**
 * Created 09.09.17.
 */
public class MySqlToPojoGenerator extends MySqlParserNodeListener {

   private final JavaGroup javaGroup = new JavaGroup();
   private final Stack<JavaGroup.PojoST> currentPojos = new Stack<>();

   private String propertyName;
   private String propertyType;

   public MySqlToPojoGenerator(boolean debug) {
      super(debug);
   }

   public void done(String root, String packageName) throws IOException {
      while (!currentPojos.isEmpty()) {
         final JavaGroup.PojoST pop = currentPojos.pop();
         pop.setPackage(packageName);
         if (debug)
            System.out.println(pop);
         else
            GeneratedFile.newJavaFile(root, packageName, pop.getName()).write(pop);
      }
   }

   @Override
   public void enterColCreateTable(MySqlParser.ColCreateTableContext arg) {
      super.enterColCreateTable(arg);
      currentPojos.push(javaGroup.newPojo());
   }

   @Override
   public void enterId_(MySqlParser.Id_Context arg) {
      super.enterId_(arg);

      if (inTable_name() && !inConstraintDefinition()) {
         currentPojos.peek().setName(StringUtil.capitalize(StringUtil.trimEnds(1, arg.getText())));
      } else if (inColumnDefinition()) {
         this.propertyName = StringUtil.trimEnds(1, arg.getText());
      }
   }

   @Override
   public void enterDimensionDatatype(MySqlParser.DimensionDatatypeContext arg) {
      super.enterDimensionDatatype(arg);

      final String type = arg.getText();
      if (type.toUpperCase().startsWith("BIGINT"))
         this.propertyType = "Long";
      else if (type.toUpperCase().startsWith("INT"))
         this.propertyType = "Integer";
      else if (type.toUpperCase().startsWith("TIMESTAMP"))
         this.propertyType = "Long";
      else if (type.toUpperCase().startsWith("DATETIME"))
         this.propertyType = "java.util.Date";
      else
         System.out.println("unsupported DimensionDatatype " + delim + "'" + arg.getText() + "'");
   }

   @Override
   public void enterCharDatatype(MySqlParser.CharDatatypeContext arg) {
      super.enterCharDatatype(arg);
      this.propertyType = "String";
   }

   @Override
   public void enterSimpleDatatype(MySqlParser.SimpleDatatypeContext arg) {
      super.enterSimpleDatatype(arg);

      final String type = arg.getText();
      if (type.toUpperCase().startsWith("DATE")) {
         this.propertyType = "java.util.Date";
      } else
         System.out.println("unsupported DimensionDatatype " + delim + "'" + arg.getText() + "'");
   }

   @Override
   public void exitColumnDefinition(MySqlParser.ColumnDefinitionContext arg) {
      super.exitColumnDefinition(arg);
      currentPojos.peek().addPropertiesValue(null, propertyType, propertyName);
      this.propertyType = null;
      this.propertyName = null;
   }
}