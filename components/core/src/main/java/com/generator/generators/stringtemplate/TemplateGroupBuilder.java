package com.generator.generators.stringtemplate;

import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created 19.05.18.
 */
public class TemplateGroupBuilder {

   public enum Formatter {
      capitalize, toUpper, lowFirst, toLower, humpToCap, camelHump
   }

   public enum AttributeOperator {
      first, rest, last, length, strip
   }

   public static String asString(String value) {
      return "\"" + value + "\"";
   }

   public static String escape(String text) {
      return text.
            replaceAll("\\\\", "\\\\\\\\").
            replaceAll("\"", "\\\\\"");
   }

   private static final Set<String> reservedWords = new LinkedHashSet<>(Arrays.asList("default", "first", "group", "if", "implements", "interface", "last", "length", "optional", "rest", "strip", "super", "trunc", "else", "endif", "elseif"));

   private final String name;
   private final String delimiter;
   private final Set<TemplateStatement> statements = new LinkedHashSet<>();
   private final Set<TemplateMap> maps = new LinkedHashSet<>();

   public TemplateGroupBuilder(String name, String delimiter) {
      this.name = name;
      this.delimiter = delimiter;
   }

   public TemplateGroupBuilder addStatement(TemplateStatement statement) {
      this.statements.add(statement);
      return this;
   }

   public TemplateGroupBuilder addMap(TemplateMap map) {
      this.maps.add(map);
      return this;
   }

   public String delimiter() {
      return delimiter;
   }

   public String toSTG() {
      final StringBuilder out = new StringBuilder("delimiters \"" + delimiter + "\", \"" + delimiter + "\"");

      for (TemplateStatement statement : statements)
         out.append(statement.toSTG(delimiter));

      for (TemplateMap map : maps)
         out.append(map.toSTG());

      // add eom and gt for Stringtemplate-bugfix:
      out.append("\n\neom() ::= <<}>>\n");
      out.append("\ngt() ::= \">\"\n");

      return out.toString();
   }

   public STGroup asSTGroup() {
      final STGroupString stGroup = new STGroupString(toSTG());
      stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      return stGroup;
   }

   public TemplateGroupBuilder saveToFile(File directory) throws IOException {
      final File stgFile = new File(directory, name + ".stg");
      if (!stgFile.createNewFile()) throw new IOException("Could not create file '" + stgFile.getAbsolutePath() + "'");

      final BufferedWriter writer = new BufferedWriter(new FileWriter(stgFile));
      writer.write(toSTG());
      writer.close();

      return this;
   }

   public static final class TemplateStatement {

      private String name;
      private final List<TemplateSection> sections = new LinkedList<>();

      public TemplateStatement(String name) {
         this.name = tryToSetName(name);
      }

      public TemplateStatement addSection(TemplateSection section) {
         this.sections.add(section);
         return this;
      }

      public String toSTG(String delimiter) {

         final StringBuilder content = new StringBuilder();
         final Set<String> parameters = new LinkedHashSet<>();
         for (TemplateSection section : sections) {
            content.append(section.toSTG(delimiter));
            parameters.addAll(section.getParameters());
         }

         final StringBuilder out = new StringBuilder("\n\n" + name);
         out.append("(");
         boolean first = true;
         for (String parameter : parameters) {
            if (!first) out.append(",");
            out.append(parameter);
            first = false;
         }
         out.append(") ::= <<");
         final String s = content.toString().trim();
         out.append(s.endsWith(">") ? (s.trim() + " ") : s.trim());
         out.append(">>");

         return out.toString();
      }

      // convenience methods
      public TemplateStatement addSpace() {
         return addSection(new SpaceSection());
      }

      public TemplateStatement addNewLine() {
         return addSection(new NewLineSection());
      }

      public TemplateStatement addSection(String content) {
         return addSection(new StringSection(content));
      }
   }

   public static final class TemplateMap {

      private String name;
      private String defaultValue;
      private final Map<String, String> mappings = new LinkedHashMap<>();

      public TemplateMap(String name) {
         this.name = tryToSetName(name);
      }

      public TemplateMap(String name, String defaultValue) {
         this.name = tryToSetName(name);
         this.defaultValue = defaultValue;
      }

      public TemplateMap addMapping(String key, String value) {
         this.mappings.put(key, value);
         return this;
      }

      public String toSTG() {
         final StringBuilder out = new StringBuilder("\n\n" + name).append(" ::= [").append("\n");

         boolean first = true;
         for (Map.Entry<String, String> entry : mappings.entrySet()) {
            if (!first) out.append(",\n");
            out.append("\t").append("\"").append(entry.getKey()).append("\"").append(":").append("\"").append(entry.getValue()).append("\"");
            first = false;
         }

         if (defaultValue != null) {
            if (!first) out.append(",\n");
            out.append("\t").append("default").append(":").append(defaultValue);
         }

         out.append("\n").append("]");
         return out.toString();
      }
   }


   public interface TemplateSection {

      String toSTG(String delimiter);

      Set<String> getParameters();
   }

   public static final class StringSection implements TemplateSection {

      private final String content;

      public StringSection(String content) {
         this.content = content;
      }

      @Override
      public String toSTG(String delimiter) {
         return content;
      }

      @Override
      public Set<String> getParameters() {
         return Collections.emptySet();
      }
   }

   public static final class SingleValueSection implements TemplateSection {

      private final String name;

      public SingleValueSection(String name) {
         this.name = tryToSetName(name);
      }

      @Override
      public String toSTG(String delimiter) {
         return delimiter + name + delimiter;
      }

      @Override
      public Set<String> getParameters() {
         return Collections.singleton(name);
      }
   }

   public static final class ListSection implements TemplateSection {

      private final String name;
      private final String separator;
      private final String it = "it";
      private final List<TemplateSection> content = new ArrayList<>();

      private AttributeOperator operator = null;

      public ListSection(String name) {
         this.name = tryToSetName(name);
         this.separator = null;
      }

      public ListSection(String name, AttributeOperator operator) {
         this.name = tryToSetName(name);
         this.separator = null;
         this.operator = operator;
      }

      public ListSection(String name, String separator) {
         this.name = tryToSetName(name);
         this.separator = separator;
      }

      public ListSection(String name, String separator, AttributeOperator operator) {
         this.name = tryToSetName(name);
         this.separator = separator;
         this.operator = operator;
      }

      public ListSection(String name, String separator, AttributeOperator operator, List<TemplateSection> content) {
         this.name = tryToSetName(name);
         this.separator = separator;
         this.operator = operator;
         this.content.addAll(content);
      }

      public ListSection addContent(TemplateSection section) {
         this.content.add(section);
         return this;
      }

      // convenience method for string-content
      public ListSection addContent(String section) {
         this.content.add(new StringSection(section));
         return this;
      }

      public ListSection addIteratorReference() {
         this.content.add(new IteratorSection(it));
         return this;
      }

      public ListSection addIteratorReference(Formatter format) {
         this.content.add(new IteratorSection(it, format));
         return this;
      }

      public ListSection addZeroBasedIterationNumber() {
         this.content.add(new IterationNumberSection(true));
         return this;
      }

      public ListSection addOneBasedIterationNumber() {
         this.content.add(new IterationNumberSection(false));
         return this;
      }

      @Override
      public String toSTG(String delimiter) {

         final StringBuilder out = new StringBuilder(delimiter + (operator == null ? name : (operator + "(" + name + ")")) + ":{" + it + "|");

         for (TemplateSection section : content)
            out.append(section.toSTG(delimiter));
         out.append("}");

         if (separator != null)
            out.append(";separator=\"").append(separator).append("\"");
         out.append(delimiter);

         return out.toString();
      }

      @Override
      public Set<String> getParameters() {
         final Set<String> parameters = new LinkedHashSet<>();

         if (name != null && name.length() > 0)
            parameters.add(name);

         for (TemplateSection section : content)
            parameters.addAll(section.getParameters());

         return parameters;
      }

      private final class IteratorSection implements TemplateSection {

         private final String name;
         private final Formatter formatter;

         public IteratorSection(String name) {
            this.name = tryToSetName(name);
            this.formatter = null;
         }

         public IteratorSection(String name, Formatter formatter) {
            this.name = tryToSetName(name);
            this.formatter = formatter;
         }

         @Override
         public String toSTG(String delimiter) {
            final StringBuilder out = new StringBuilder(delimiter + name);

            if (formatter != null)
               out.append(";format=\"").append(formatter).append("\"");

            out.append(delimiter);

            return out.toString();
         }

         @Override
         public Set<String> getParameters() {
            return Collections.emptySet();
         }
      }

      private class IterationNumberSection implements TemplateSection {

         private final boolean zeroBased;

         public IterationNumberSection(boolean zeroBased) {
            this.zeroBased = zeroBased;
         }

         @Override
         public String toSTG(String delimiter) {
            return delimiter + "i" + (zeroBased ? "0" : "") + delimiter;
         }

         @Override
         public Set<String> getParameters() {
            return Collections.emptySet();
         }
      }
   }

   public static final class KeyValueListSection implements TemplateSection {

      private final String name;
      private final String separator;
      private final String it = "it";
      private final List<TemplateSection> content = new ArrayList<>();

      public KeyValueListSection(String name) {
         this.name = tryToSetName(name);
         this.separator = null;
      }

      public KeyValueListSection(String name, String separator) {
         this.name = tryToSetName(name);
         this.separator = separator;
      }

      public KeyValueListSection addContent(TemplateSection section) {
         this.content.add(section);
         return this;
      }

      public KeyValueListSection addIteratorReference(String name) {
         this.content.add(new KeyValueListSection.IteratorSection(it, name));
         return this;
      }

      public KeyValueListSection addIteratorReference(String name, Formatter format) {
         this.content.add(new KeyValueListSection.IteratorSection(it, name, format));
         return this;
      }

      @Override
      public String toSTG(String delimiter) {
         final StringBuilder out = new StringBuilder(delimiter + name + ":{" + it + "|");

         // to fix bug in StringTemplateParser, check if content contains '}' and replace with eom()
         for (TemplateSection section : content)
            out.append(section.toSTG(delimiter));
         out.append("}");

         if (separator != null)
            out.append(";separator=\"").append(separator).append("\"");
         out.append(delimiter);

         return out.toString();
      }

      @Override
      public Set<String> getParameters() {
         final Set<String> parameters = new LinkedHashSet<>();

         if (name != null && name.length() > 0)
            parameters.add(name);

         for (TemplateSection section : content)
            parameters.addAll(section.getParameters());

         return parameters;
      }

      private final class IteratorSection implements TemplateSection {

         private final String name;
         private final String key;
         private final Formatter formatter;

         public IteratorSection(String name, String key) {
            this.name = tryToSetName(name);
            this.key = key;
            this.formatter = null;
         }

         public IteratorSection(String name, String key, Formatter formatter) {
            this.name = tryToSetName(name);
            this.key = key;
            this.formatter = formatter;
         }

         @Override
         public String toSTG(String delimiter) {
            final StringBuilder out = new StringBuilder(delimiter + name + "." + key);

            if (formatter != null)
               out.append(";format=\"").append(formatter).append("\"");

            out.append(delimiter);

            return out.toString();
         }

         @Override
         public Set<String> getParameters() {
            return Collections.emptySet();
         }
      }
   }

   public static final class IfSection implements TemplateSection {

      private final String condition;
      private final List<TemplateSection> content = new ArrayList<>();
      private boolean isElseIf;

      public IfSection(String condition) {
         this.condition = condition;
         this.isElseIf = false;
      }

      public IfSection(String condition, boolean isElseIf) {
         this.condition = condition;
         this.isElseIf = isElseIf;
      }

      public IfSection addContent(TemplateSection section) {
         this.content.add(section);
         return this;
      }

      public IfSection addElse() {
         this.content.add(new ElseSection());
         return this;
      }

      public IfSection addElseIf(IfSection section) {
         section.isElseIf = true;
         this.content.add(section);
         return this;
      }

      @Override
      public String toSTG(String delimiter) {
         final StringBuilder out = new StringBuilder(delimiter + (isElseIf ? "else" : "") + "if(" + condition + ")" + delimiter);

         for (TemplateSection templateSection : content)
            out.append(templateSection.toSTG(delimiter));

         if (!isElseIf)
            out.append(delimiter).append("endif").append(delimiter);

         return out.toString();
      }

      @Override
      public Set<String> getParameters() {
         final Set<String> parameters = new LinkedHashSet<>();
         for (TemplateSection section : content)
            parameters.addAll(section.getParameters());
         return parameters;
      }

      private final class ElseSection implements TemplateSection {
         @Override
         public String toSTG(String delimiter) {
            return delimiter + "else" + delimiter;
         }

         @Override
         public Set<String> getParameters() {
            return Collections.emptySet();
         }
      }
   }

   public static class LengthSection implements TemplateSection {

      private final String name;

      public LengthSection(String name) {
         this.name = name;
      }

      @Override
      public String toSTG(String delimiter) {
         return delimiter + AttributeOperator.length + "(" + name + ")" + delimiter;
      }

      @Override
      public Set<String> getParameters() {
         return Collections.emptySet();
      }
   }

   public static class NewLineSection implements TemplateSection {

      private final Integer lines;

      public NewLineSection() {
         this.lines = 1;
      }

      public NewLineSection(Integer lines) {
         this.lines = lines;
      }

      @Override
      public String toSTG(String delimiter) {
         final StringBuilder out = new StringBuilder();
         for (int i = 0; i < lines; i++)
            out.append("\n");
         return out.toString();
      }

      @Override
      public Set<String> getParameters() {
         return Collections.emptySet();
      }
   }

   public static class SpaceSection implements TemplateSection {

      private final Integer space;

      public SpaceSection() {
         this.space = 1;
      }

      public SpaceSection(Integer space) {
         this.space = space;
      }

      @Override
      public String toSTG(String delimiter) {
         final StringBuilder out = new StringBuilder();
         for (int i = 0; i < space; i++)
            out.append(" ");
         return out.toString();
      }

      @Override
      public Set<String> getParameters() {
         return Collections.emptySet();
      }
   }

   public static class CommentSection implements TemplateSection {

      private final String comment;

      public CommentSection(String comment) {
         this.comment = comment;
      }

      @Override
      public String toSTG(String delimiter) {
         return delimiter + "! " + comment + " !" + delimiter;
      }

      @Override
      public Set<String> getParameters() {
         return Collections.emptySet();
      }
   }

   public static final class EscapeSection implements TemplateSection {

      private final List<String> content;

      public EscapeSection(String... content) {
         this.content = new ArrayList<>(Arrays.asList(content));
      }

      @Override
      public String toSTG(String delimiter) {
         final StringBuilder out = new StringBuilder();
         for (String s : content)
            out.append(delimiter).append("\\").append(s).append(delimiter);
         return out.toString();
      }

      @Override
      public Set<String> getParameters() {
         return Collections.emptySet();
      }
   }

   public static final TemplateSection escapeDelimiter() {
      return new TemplateSection() {
         @Override
         public String toSTG(String delimiter) {
            return "\\" + delimiter;
         }

         @Override
         public Set<String> getParameters() {
            return Collections.emptySet();
         }
      };
   }

   public static final TemplateSection unicode(String... unicodes) {
      return new TemplateSection() {
         @Override
         public String toSTG(String delimiter) {
            final StringBuilder out = new StringBuilder();
            for (String s : unicodes)
               out.append(delimiter).append("\\u").append(s).append(delimiter);
            return out.toString();
         }

         @Override
         public Set<String> getParameters() {
            return Collections.emptySet();
         }
      };
   }

   public static class MethodReferenceSection implements TemplateSection {

      private final String directory;
      private final String methodName;
      private final Map<String, String> parameterMappings = new LinkedHashMap<>();

      public MethodReferenceSection(String methodName) {
         this.directory = "";
         this.methodName = methodName;
      }

      public MethodReferenceSection(String directory, String methodName) {
         this.directory = directory;
         this.methodName = methodName;
      }

      public MethodReferenceSection addParameter(String referenceParameter, String value) {
         this.parameterMappings.put(referenceParameter, value);
         return this;
      }

      @Override
      public String toSTG(String delimiter) {
         final StringBuilder out = new StringBuilder(delimiter + ((directory == null || directory.length() == 0) ? "" : (directory + "/")) + methodName);
         out.append("(");

         boolean first = true;
         for (Map.Entry<String, String> entry : parameterMappings.entrySet()) {
            if (!first) out.append(",");
            out.append(entry.getKey()).append("=").append(entry.getValue());
            first = false;
         }
         out.append(")").append(delimiter);

         return out.toString();
      }

      @Override
      public Set<String> getParameters() {
         return Collections.emptySet();
      }
   }

   public static class MapReferenceSection implements TemplateSection {

      private final String directory;
      private final String mapName;
      private final String mappingValue;

      public MapReferenceSection(String mapName, String mappingValue) {
         this.directory = null;
         this.mapName = mapName;
         this.mappingValue = mappingValue;
      }

      public MapReferenceSection(String directory, String mapName, String mappingValue) {
         this.directory = directory;
         this.mapName = mapName;
         this.mappingValue = mappingValue;
      }

      @Override
      public String toSTG(String delimiter) {
         return delimiter + ((directory == null || directory.length() == 0) ? "" : (directory + "/")) + mapName + "." + "(" + mappingValue + ")" + delimiter;
      }

      @Override
      public Set<String> getParameters() {
         return Collections.emptySet();
      }
   }

   // composite sections

   public static final class FirstRestSection implements TemplateSection {

      private final String name;
      private ListSection first;
      private ListSection rest;

      public FirstRestSection(String name, ListSection first, ListSection rest) {
         this.name = name;
         this.first = first;
         this.rest = rest;
      }

      @Override
      public String toSTG(String delimiter) {
         final ListSection f = new ListSection(name, first.separator, AttributeOperator.first, first.content);
         final ListSection r = new ListSection(name, rest.separator, AttributeOperator.rest, rest.content);
         return f.toSTG(delimiter) + "" + r.toSTG(delimiter);
      }

      @Override
      public Set<String> getParameters() {
         final Set<String> parameters = new LinkedHashSet<>();
         parameters.add(name);
         parameters.addAll(first.getParameters());
         parameters.addAll(rest.getParameters());
         return parameters;
      }
   }

   private static final class DefaultAttributeRenderer implements org.stringtemplate.v4.AttributeRenderer {

      @Override
      public String toString(Object o, String formatString, java.util.Locale locale) {

         final String text = o.toString();

         if (formatString == null) return text;

         switch (Formatter.valueOf(formatString)) {
            case capitalize:
               return capitalize(text);
            case toUpper:
               return toUpper(text);
            case lowFirst:
               return lowFirst(text);
            case toLower:
               return text.toLowerCase();
            case humpToCap:
               return humpToCap(text);
            case camelHump:
               return camelHump(text);
            default:
               return o.toString();
         }
      }

      private String capitalize(String string) {
         if (string == null || string.length() == 0) return "";
         return Character.toUpperCase(string.charAt(0)) + (string.length() > 1 ? string.substring(1) : "");
      }

      private String lowFirst(String string) {
         if (string == null || string.length() == 0) return "";
         return Character.toLowerCase(string.charAt(0)) + (string.length() > 1 ? string.substring(1) : "");
      }

      private String toUpper(String text) {
         return text.toUpperCase();
      }

      private String humpToCap(String text) {
         final char[] chars = text.toCharArray();
         final StringBuilder out = new StringBuilder();
         boolean first = true;
         for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (!first && Character.isUpperCase(aChar) && (i < chars.length - 2 && Character.isLowerCase(chars[i + 1]))) {
               out.append("_");
            }
            first = false;
            out.append(Character.toUpperCase(aChar));
         }
         return out.toString();
      }

      private String camelHump(String text) {
         final char[] chars = text.toCharArray();
         final StringBuilder out = new StringBuilder();
         boolean capitalize = true;
         for (char aChar : chars) {
            if (Character.isWhitespace(aChar)) {
               capitalize = true;
               continue;
            }
            out.append(capitalize ? Character.toUpperCase(aChar) : aChar);
            capitalize = false;
         }
         return out.toString();
      }
   }

   private static String tryToSetName(String name) {
      if (reservedWords.contains(name)) throw new IllegalArgumentException("name '" + name + "' is a reserved word");
      return name;
   }


   public static void main(String[] args) throws IOException {

      final TemplateGroupBuilder templateGroupBuilder = new TemplateGroupBuilder("HelloTest", "~");

      templateGroupBuilder.
            addStatement(new TemplateStatement("TestSingleValue").
                  addSection(new StringSection("TestSingleValue : ")).
                  addSection(new SingleValueSection("singleValue"))).
            addStatement(new TemplateStatement("TestStringContent").
                  addSection(new StringSection("TestStringContent"))).
            addStatement(new TemplateStatement("TestListContent").
                  addNewLine().
                  addSection(new ListSection("noSeparator").
                        addContent(new StringSection("#")).
                        addIteratorReference(Formatter.toUpper).
                        addContent(new StringSection(".")).
                        addContent(new NewLineSection())).
                  addNewLine().
                  addSection(new ListSection("withSeparator", "\\n").
                        addContent(new StringSection("#")).
                        addIteratorReference().
                        addContent(new StringSection(".")))).
            addStatement(new TemplateStatement("TestIfAndElse").
                  addSection(new IfSection("packageName").
                        addContent(new CommentSection("simple comment")).
                        addContent(new StringSection("package ")).
                        addContent(new SingleValueSection("packageName")).
                        addContent(new SpaceSection(5))).
                  addSection(new IfSection("packageName").
                        addContent(new StringSection("package ")).
                        addElse().
                        addContent(new StringSection("// no package"))).
                  addSection(new IfSection("one").
                        addContent(new StringSection("One: ")).
                        addContent(new SingleValueSection("one")).
                        addElseIf(new IfSection("two").
                              addContent(new StringSection("Two: ")).
                              addContent(new SingleValueSection("two"))).
                        addElseIf(new IfSection("three").
                              addContent(new StringSection("Three: ")).
                              addContent(new SingleValueSection("three"))))).
            addStatement(new TemplateStatement("TestKeyValueListContent").
                  addSection(new KeyValueListSection("users").
                        addContent(new StringSection("name: ")).
                        addIteratorReference("name", Formatter.toUpper).
                        addContent(new NewLineSection()).
                        addContent(new StringSection("address: ")).
                        addIteratorReference("address"))).
            addStatement(new TemplateStatement("TestMethodReference").
                  addSection(new StringSection("Test method reference: ")).
                  addSection(new MethodReferenceSection("TestStringContent"))).
            addStatement(new TemplateStatement("TestMethodReference2").
                  addSection(new StringSection("Test method reference with parameters: ")).
                  addSection(new MethodReferenceSection("TestSingleValue").
                        addParameter("singleValue", "\"XXX\"")).
                  addSection(new SingleValueSection("name")).
                  addSection(new MethodReferenceSection("TestSingleValue").
                        addParameter("singleValue", "name"))).
            addMap(new TemplateMap("mapname", asString("err")).
                  addMapping("name1", "val1").
                  addMapping("name2", "val2")).
            addStatement(new TemplateStatement("TestMapReference").
                  addSection("Mapping name2 ").
                  addSection(new SingleValueSection("name")).
                  addSpace().
                  addSection(new MapReferenceSection("mapname", "name"))).
            addStatement(new TemplateStatement("TestFirstRest").
                  addSection(new FirstRestSection("numbers",
                        new ListSection("").
                              addContent("int sum = ").addIteratorReference().
                              addContent("\nIterator ").addZeroBasedIterationNumber().
                              addContent(new NewLineSection()).addContent("Length: ").addContent(new LengthSection("numbers")).
                              addContent(new NewLineSection()),
                        new ListSection("", "\\n").
                              addContent(new NewLineSection()).
                              addContent(new StringSection("sum += ")).addIteratorReference().
                              addContent(new StringSection(" // i(")).addOneBasedIterationNumber().
                              addContent(new StringSection("), i0(")).addZeroBasedIterationNumber().addContent(new StringSection(")"))))).
            addStatement(new TemplateStatement("TestEscapes").addSection("Escaped characters:").
                  addSection(new EscapeSection("u00AE", "t", "n", " ")).
                  addSection(escapeDelimiter()).
                  addSection(unicode("0482", "0BF5")));

      System.out.println(templateGroupBuilder.toSTG());

      final STGroup stGroup = templateGroupBuilder.asSTGroup();

      System.out.println(stGroup.getInstanceOf("TestSingleValue").add("singleValue", "YAYAY").render());
      System.out.println(stGroup.getInstanceOf("TestStringContent").render());
      System.out.println(stGroup.getInstanceOf("TestKeyValueListContent").addAggr("users.{name,address}", "Mark", "22 Moore").render());
      System.out.println(stGroup.getInstanceOf("TestListContent").add("noSeparator", "Mark").add("noSeparator", "Darth").render());
      System.out.println(stGroup.getInstanceOf("TestIfAndElse").add("packageName", "PACKAGENAME").add("two", "TWO").render());
      System.out.println(stGroup.getInstanceOf("TestMethodReference").render());
      System.out.println(stGroup.getInstanceOf("TestMethodReference2").add("name", "YYY").render());
      System.out.println(stGroup.getInstanceOf("TestMapReference").add("name", "name2").render());
      System.out.println(stGroup.getInstanceOf("TestFirstRest").add("numbers", 0).add("numbers", 1).add("numbers", 2).render());
      System.out.println(stGroup.getInstanceOf("TestEscapes").render());
   }


}