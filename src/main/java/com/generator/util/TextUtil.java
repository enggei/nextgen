package com.generator.util;

import org.stringtemplate.v4.ST;

import java.util.Scanner;

import static com.generator.util.StringUtil.printRest;

/**
 * Created 24.07.17.
 */
public class TextUtil {
   private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(TextUtil.class);
   static final String text =
         "allRowsSelected\tbool\tfalse\tSet to true to indicate that all rows should be selected.\n" +
               "bodyStyle\tobject\t\tOverride the inline-styles of the body's table element.\n" +
               "children\tnode\t\tChildren passed to table.\n" +
               "className\tstring\t\tThe css class name of the root element.\n" +
               "fixedFooter\tbool\ttrue\tIf true, the footer will appear fixed below the table. The default value is true.\n" +
               "fixedHeader\tbool\ttrue\tIf true, the header will appear fixed above the table. The default value is true.\n" +
               "footerStyle\tobject\t\tOverride the inline-styles of the footer's table element.\n" +
               "headerStyle\tobject\t\tOverride the inline-styles of the header's table element.\n" +
               "height\tstring\t'inherit'\tThe height of the table.\n" +
               "multiSelectable\tbool\tfalse\tIf true, multiple table rows can be selected. CTRL/CMD+Click and SHIFT+Click are valid actions. The default value is false.\n" +
               "onCellClick\tfunction\t\tCalled when a row cell is clicked. rowNumber is the row number and columnId is the column number or the column key.\n" +
               "|onCellHover\tfunction\t\tCalled when a table cell is hovered. rowNumber is the row number of the hovered row and columnId is the column number or the column key of the cell.\n" +
               "|onCellHoverExit\tfunction\t\tCalled when a table cell is no longer hovered. rowNumber is the row number of the row and columnId is the column number or the column key of the cell.\n" +
               "|onRowHover\tfunction\t\tCalled when a table row is hovered. rowNumber is the row number of the hovered row.\n" +
               "|onRowHoverExit\tfunction\t\tCalled when a table row is no longer hovered. rowNumber is the row number of the row that is no longer hovered.\n" +
               "|onRowSelection\tfunction\t\tCalled when a row is selected. selectedRows is an array of all row selections. IF all rows have been selected, the string \"all\" will be returned instead to indicate that all rows have been selected.\n" +
               "selectable\tbool\ttrue\tIf true, table rows can be selected. If multiple row selection is desired, enable multiSelectable. The default value is true.\n" +
               "style\tobject\t\tOverride the inline-styles of the root element.\n" +
               "wrapperStyle\tobject\t\tOverride the inline-styles of the table's wrapper element.";


   public static void main(String[] args) {

      final StringBuilder template = new StringBuilder("<Table");

      final Scanner scanner = new Scanner(text);
      boolean inFunction = false;
      boolean functionAdded = false;
      while (scanner.hasNext()) {
         final String line = scanner.nextLine();
         final String clean = line.replaceAll("[\t]+", " ");
         if (clean.trim().length() == 0) continue;
         final String[] tokens = clean.split("[ ]");

         if (tokens[0].startsWith("|")) {
            inFunction = false;
            functionAdded = false;
            tokens[0] = tokens[0].substring(1);
         }

         if (inFunction || "function".equals(tokens[1])) {
            inFunction = true;
            log.info("in function " + tokens[0]);
            //log.info("\t\t" + printRest(0, tokens, " "));
            if (!functionAdded) {
               ST st = new ST("~if($function$)~\n\t $function$={~$function$~}~endif~", '$', '$');
               template.append(st.add("function", tokens[0]).render());
               functionAdded = true;
            }
         } else {
            log.info(String.format("%1$-" + 30 + "s", tokens[0]) + String.format("%1$-" + 30 + "s", tokens[1]) + "|" + printRest(2, tokens, " "));
            ST st = new ST("~if($attribute$)~\n\t $attribute$=\"~$attribute$~\"~endif~", '$', '$');
            template.append(st.add("attribute", tokens[0]).render());
         }
      }

      log.info(template.append("/>").toString());
   }
}