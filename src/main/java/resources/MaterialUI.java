package resources;

import nextgen.utils.FileUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import java.io.*;
import java.nio.file.*;
import java.util.Arrays;

public class MaterialUI {

   private static final String separator = "'";

   public static void main(String[] args) throws IOException {

      final StringBuilder all = new StringBuilder();

      Files.list(Path.of("/home/goe/projects/nextgen/resources/material-ui"))
            .filter(path -> path.toFile().isFile())
            .sorted((p1, p2) -> p1.toFile().getName().compareToIgnoreCase(p2.toFile().getName()))
            .forEach(path -> {

               final String filename = path.toFile().getName();
               final String component = path.toFile().getName().substring(0, filename.length() - 5);

               final StringBuilder csv = new StringBuilder();

               final String html = FileUtil.read(path.toFile());
               final Document doc = Jsoup.parse(html);
               final Element table = doc.select("table").get(0);
               final Elements trs = table.select("tr");
               for (int i = 1; i < trs.size(); i++) {                // first row is the col names so skip it.
                  final Element tr = trs.get(i);
                  final Elements tds = tr.select("td");

                  final Element classElement = tds.get(0);
                  final Element descriptionElement = tds.get(1);
                  final Element requiredElement = tds.size() == 3 ? tds.get(2) : null;

                  final String classValue = classElement.childrenSize() == 1 ? getText(classElement.child(0)) : getText(classElement);
                  final String descriptionValue = getText(descriptionElement).replaceAll(",", " ").replaceAll(";", " - ");
                  final String requiredValue = requiredElement == null ? "" : getText(requiredElement);

                  append(csv, "\n", component);
                  append(csv, ",", classValue);
                  append(csv, ",", descriptionValue);
                  append(csv, ",", requiredValue);
               }
               addTemplates(component, csv);

               final String[] string = csv.toString().trim().split("\n");
               Arrays.sort(string);
               for (String s : string) all.append(s).append("\n");
            });


      FileUtil.writeFile(all.toString().trim(), new File("/home/goe/projects/nextgen/resources/material-ui/info/all.csv"));
   }

   private static void append(StringBuilder csv, String prefix, String component) {
      csv.append(prefix).append(separator).append(component).append(separator);
   }

   private static String getText(Element classElement) {
      return classElement.wholeText().trim();
   }

   private static void addTemplates(String component, StringBuilder csv) {

      if (component.equals("Checkbox")) {
         csv.append("\n")
               .append(separator).append(component).append(separator)
               .append(",").append(separator).append("<label for=\"~id~\" class=\"mdl-checkbox mdl-js-checkbox\">" +
               "<input type=\"checkbox\" id=\"~id~\" class=\"mdl-checkbox__input\">" +
               "<span class=\"mdl-checkbox__label\">~label~</span>" +
               "</label>").append(separator)
               .append(",").append(separator).append("New Checkbox").append(separator).append(",");
      }
   }
}
