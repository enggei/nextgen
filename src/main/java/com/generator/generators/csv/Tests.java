package com.generator.generators.csv;

import com.generator.ProjectConstants;
import com.generator.generators.csv.parser.CSVLexer;
import com.generator.generators.csv.parser.CSVNodeListener;
import com.generator.generators.csv.parser.CSVParser;
import io.vertx.core.json.JsonObject;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created 10.09.17.
 */
public class Tests {

   @Test
   public void testParser() throws IOException {
      final CSVParser parser = new CSVParser(new CommonTokenStream(new CSVLexer(CharStreams.fromFileName(ProjectConstants.GENERATORS_ROOT+"csv/test.csv"))));
      final CSVNodeListener listener = new CSVNodeListener(true);
      new ParseTreeWalker().walk(listener, parser.csvFile());
   }

   @Test
   public void testCSVGroup() throws IOException {

      final CSVGroup csvGroup = new CSVGroup();
      final CSVGroup.CSVST csv = csvGroup.newCSV().
            addHeaderValue("Exhibitor").
            addHeaderValue("Site").
            addHeaderValue("Screen");

      addRow(csvGroup, csv, "FHP", "Filmhuset Facklan Kungsbacka", 5);
      addRow(csvGroup, csv, "Bergen Kino AS", "Bergen USF Cinemateket", 1);
      addRow(csvGroup, csv, "Killa", "Killa", 1);
      addRow(csvGroup, csv, "Kino-Hovi", "Kino-Hovi", 1);
      addRow(csvGroup, csv, "Savon Kinot", "Kuvalipas", 1);
      addRow(csvGroup, csv, "Savon Kinot", "Maxim Varkaus", 3);
      addRow(csvGroup, csv, "Savon Kinot", "Olavi", 1);
      addRow(csvGroup, csv, "Nordisk Film Biografer AS", "Århus Metropol", 5);
      addRow(csvGroup, csv, "Vig. Kulturhuset Vig Bio", "Vig. Kulturhuset Vig bio", 1);
      addRow(csvGroup, csv, "Vig. Kulturhuset Vig Bio", "Vig. Kulturhuset Vig bio", 1);
      addRow(csvGroup, csv, "Hvalsoe Bio", "Hvalsoe Bio", 1);
      addRow(csvGroup, csv, "Nibe Kino Nibe", "Hvalsoe Bio", 1);
      addRow(csvGroup, csv, "Tisvilde Bio", "Tisvilde Bio", 1);
      addRow(csvGroup, csv, "Slangerup Bio", "Slangerup bio", 1);

      System.out.println(csv.toString());
      System.out.println();
      final CSVParser parser = new CSVParser(new CommonTokenStream(new CSVLexer(CharStreams.fromString(csv.toString()))));
      final CSVNodeListener listener = new CSVNodeListener(true) {

         public JsonObject exhibitor;
         final AtomicInteger col = new AtomicInteger(0);
         final Map<String, JsonObject> exhibitors = new LinkedHashMap<>();

         @Override
         public void enterRow(CSVParser.RowContext arg) {
            super.enterRow(arg);

            col.set(0);
         }

         @Override
         public void enterField(CSVParser.FieldContext arg) {
            super.enterField(arg);

            switch (col.get()) {
               case 0: {
                  exhibitor = exhibitors.computeIfAbsent(arg.getText(), k -> new JsonObject());
                  exhibitor.put("name", arg.getText());
                  break;
               }
               case 1: {
//                    final Node filmhusetFacklanNode = model.findOrCreate(Entities.Site, Properties.name.name(), "Filmhuset Fackland, Kungsbacka");
               }
            }
         }

         @Override
         public void exitRow(CSVParser.RowContext arg) {
            super.exitRow(arg);
         }

      };
      new ParseTreeWalker().walk(listener, parser.csvFile());
   }

   private void addRow(CSVGroup csvGroup, CSVGroup.CSVST csv, String exhibitor, String site, Object screen) {
      csv.addRowValue(csvGroup.newrow().
            addColumnValue(csvGroup.newstringValue().setValue(exhibitor)).
            addColumnValue(csvGroup.newstringValue().setValue(site)).
            addColumnValue(screen));
   }
}
