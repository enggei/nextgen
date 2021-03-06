package nextgen.st;

import nextgen.model.STEnum;
import nextgen.model.STGroupModel;
import nextgen.model.STTemplate;
import nextgen.templates.java.JavaPatterns;
import nextgen.templates.java.ClassOrInterfaceDeclaration;
import nextgen.templates.java.Modifiers;
import nextgen.utils.StringUtil;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class STGenerator {

   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STGenerator.class);

   public static final char DELIMITERCHAR = '~';
   public static final String DELIMITER = "" + DELIMITERCHAR;

   private final STGroup generator;

   public STGenerator(STGroupModel generator) {
      this(toSTGroup(generator));
   }

   public STGenerator(STGroup generator) {
      this.generator = generator;
   }

   public static ST asST(nextgen.model.parser.ParsedSTTemplate stTemplate) {
      return asST(newTemplateGroup(), stTemplate);
   }

   public void generateSTGroup(STGroupModel stGroupModel) {
      stGroupModel.getFiles().forEach(stFile -> {

         final String packageName = stFile.getPackageName().getValue();
         final String path = stFile.getPath().getValue();

         generateSTGroup(stGroupModel, packageName, path);
      });
   }

   public void generateSTGroup(STGroupModel stGroupModel, String packageDeclaration, String rootPath) {

      final File root = new File(rootPath);

      final String domainClassName = capitalize(stGroupModel.getName() + "ST");
      final ST stDomain = generator.getInstanceOf("STDomain");
      stDomain.add("packageName", packageDeclaration);
      stDomain.add("name", domainClassName);

      final String testsClassName = capitalize(stGroupModel.getName() + "STTests");
      final ST stDomainTests = generator.getInstanceOf("STDomainTests");
      stDomainTests.add("packageName", packageDeclaration);
      stDomainTests.add("name", testsClassName);
      stDomainTests.add("domainName", domainClassName);

      final ST stgString = generator.getInstanceOf("stgString");
      stGroupModel.getTemplatesSorted()
            .sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))
            .forEach(stTemplate -> generateSTEntity(stTemplate, root, packageDeclaration, stDomain, stDomainTests, stgString));

      stGroupModel.getEnumsSorted().forEach(stEnum -> {
         final ST stEnumDeclaration = generateSTEnum(packageDeclaration, stEnum);
         writeJavaFile(stEnumDeclaration.render(), packageDeclaration, stEnum.getName(), root);
      });

      stGroupModel.getInterfacesSorted().forEach(stInterface -> {
         final ST interfaceDeclaration = generator.getInstanceOf("STInterface");
         interfaceDeclaration.add("packageName", packageDeclaration);
         interfaceDeclaration.add("name", stInterface.getName());
         writeJavaFile(interfaceDeclaration.render(), packageDeclaration, stInterface.getName(), root);
      });
      stDomain.add("stgString", stgString);

      writeToFile(toStg(stGroupModel), packageDeclaration, stGroupModel.getName(), "stg", root);
      writeJavaFile(stDomain.render(), packageDeclaration, domainClassName, root);
      writeJavaFile(stDomainTests.render(), packageDeclaration, testsClassName, new File(root.getAbsolutePath().replaceAll("src/main", "src/test")));

      // create Patterns file if it does not exist:
      final String patternsClassName = capitalize(stGroupModel.getName() + "Patterns");
      final File patternsFile = new File(new File(root.getAbsolutePath(), packageToPath(packageDeclaration)), patternsClassName + ".java");
      if (!patternsFile.exists()) {

         final ClassOrInterfaceDeclaration patternsClass = JavaPatterns.newClassOrInterfaceDeclaration()
               .addModifiers(Modifiers.PUBLIC)
               .setName(patternsClassName)
               .addExtend(domainClassName);

         writeJavaFile(JavaPatterns.newCompilationUnit()
               .setPackageDeclaration(JavaPatterns.newPackageDeclaration(packageDeclaration))
               .addImportDeclaration(JavaPatterns.newImportDeclaration()
                     .setName(packageDeclaration)
                     .setIsAsterisk(true))
               .addTypes(patternsClass), packageDeclaration, patternsClassName, root);
      }
   }

   public ST generateSTEnum(String packageDeclaration, STEnum stEnum) {

      final ST stEnumDeclaration = generator.getInstanceOf("STEnum");
      stEnumDeclaration.add("packageName", packageDeclaration);
      stEnumDeclaration.add("name", stEnum.getName());

      stEnum.getValuesSorted().forEach(stEnumValue -> {

         final ST stEnumValue1 = generator.getInstanceOf("STEnumValue");
         stEnumValue1.add("name", stEnumValue.getName());
         stEnumValue1.add("lexical", stEnumValue.getLexical());

         stEnumDeclaration.add("enumValues", stEnumValue1.render().trim());
      });
      return stEnumDeclaration;
   }

   public void generateSTEntity(STTemplate stTemplate, File root, String packageDeclaration, ST stDomain, ST stDomainTests, ST stgString) {

      if (stTemplate.getText().trim().length() == 0) {
         stTemplate.getChildrenSorted()
               .sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))
               .forEach(childTemplate -> generateSTEntity(childTemplate, root, packageDeclaration, stDomain, stDomainTests, stgString));
         return;
      }

      final String className = capitalize(stTemplate.getName());

      stgString.add("templates", className);

      final ST newEntityInstance = generator.getInstanceOf("newEntityInstance");
      newEntityInstance.add("entityName", className);
      stDomain.add("entities", newEntityInstance);

      final ST templateTestMethod = generator.getInstanceOf("templateTestMethod");
      templateTestMethod.add("template", className);
      stDomainTests.addAggr("testcases.{name,impl}", className, templateTestMethod);

      stTemplate.getChildrenSorted()
            .sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))
            .forEach(childTemplate -> generateSTEntity(childTemplate, root, packageDeclaration, stDomain, stDomainTests, stgString));

      final ST stClass = generateSTClass(className, stTemplate, packageDeclaration);
      writeJavaFile(stClass.render(), packageDeclaration, className, root);
   }

   public ST generateSTClass(String className, STTemplate stTemplate, String packageDeclaration) {

      final ST stEntity = generator.getInstanceOf("STEntity");
      stEntity.add("packageName", packageDeclaration);
      stEntity.add("name", className);
      stEntity.add("template", stTemplate.getName());

      stTemplate.getImplements().forEach(s -> stEntity.add("interfaces", s));

      String content = StringUtil.escape(stTemplate.getText()).replaceAll("\n", "\\\\n\" + \n\t\t\t\"");
      content = content.replaceAll(">>", ">~gt()~");
      content = content.trim();

      final ST template = newTemplateGroup().getInstanceOf("STTemplate")
            .add("name", stTemplate.getName())
            .add("content", content);

      stTemplate.getParameters().forEach(stParameter -> {

         template.add("params", stParameter.getName());

         switch (stParameter.getType()) {
            case SINGLE:

               final String singleArgumentType = stParameter.getArgumentType("Object");
               stEntity.addAggr("singleFields.{name,type}", stParameter.getName(), singleArgumentType);
               final ST singleAccessors = generator.getInstanceOf("entitySingleAccessors");
               singleAccessors.add("entity", className);
               singleAccessors.add("name", stParameter.getName());
               singleAccessors.add("type", singleArgumentType);
               stEntity.add("singleAccessors", singleAccessors);
               break;

            case LIST:

               final String listArgumentType = stParameter.getArgumentType("Object");
               stEntity.addAggr("listFields.{name,type}", stParameter.getName(), listArgumentType);
               final ST listAccessors = generator.getInstanceOf("entityListAccessors");
               listAccessors.add("entity", className);
               listAccessors.add("name", stParameter.getName());
               listAccessors.add("type", listArgumentType);
               stEntity.add("listAccessors", listAccessors);
               break;

            case KVLIST:

               final ST aggrSpec = new ST("~name~.{~keys:{it|~it~};separator=\",\"~}", '~', '~').add("name", stParameter.getName());
               final ST aggrValues = new ST("~values:{it|map.get(\"~it~\")};separator=\", \"~", '~', '~');

               final ST kvListAccessors = generator.getInstanceOf("entityKVListAccessors");
               kvListAccessors.add("entity", className);
               kvListAccessors.add("name", stParameter.getName());
               stParameter.getKeys().forEach(stParameterKey -> {
                  kvListAccessors.addAggr("keys.{name,type}", stParameterKey.getName(), stParameterKey.getArgumentType("Object"));
                  aggrSpec.add("keys", stParameterKey.getName());
                  aggrValues.add("values", stParameterKey.getName());
               });

               stEntity.addAggr("kvListFields.{name, aggrSpec, aggrValues}", stParameter.getName(), aggrSpec.render(), aggrValues.render());
               stEntity.add("kvListAccessors", kvListAccessors);
               break;
         }
      });

      stEntity.add("stString", template.render().trim());

      return stEntity;
   }

   public static STGroup toSTGroup(STGroupModel model) {
      final STGroupString stGroupString = new STGroupString(model.getName(), toStg(model), DELIMITERCHAR, DELIMITERCHAR);
      stGroupString.registerRenderer(Object.class, new DefaultAttributeRenderer());
      return stGroupString;
   }

   public static String toStg(String templateText) {
      final STGroup templateGroup = newTemplateGroup();

      final ST stGroupTemplate = templateGroup.getInstanceOf("STGroupTemplate");
      stGroupTemplate.add("delimiter", DELIMITER);

      final ST stTemplate = templateGroup.getInstanceOf("STTemplate");
      stTemplate.add("name", "tmp");
      stTemplate.add("content", templateText);
      stGroupTemplate.add("templates", stTemplate);

      return stGroupTemplate.render();
   }

   public static String toStg(STGroupModel model) {
      final STGroup templateGroup = newTemplateGroup();

      final ST stGroupTemplate = templateGroup.getInstanceOf("STGroupTemplate");
      stGroupTemplate.add("delimiter", DELIMITER);

      nextgen.swing.STAppPresentationModel.aggregateTemplates(model)
            .filter(stTemplate -> !(stTemplate.getName().equals("eom") || stTemplate.getName().equals("gt")))
            .forEach(stTemplate -> stGroupTemplate.add("templates", asST(templateGroup, stTemplate)));

      return stGroupTemplate.render();
   }

   public static ST asST(STGroup templateGroup, STTemplate stModel) {
      final ST stTemplate = templateGroup.getInstanceOf("STTemplate");
      stTemplate.add("name", stModel.getName());
      stTemplate.add("content", stModel.getText());
      stModel.getParameters().forEach(stParameter -> stTemplate.add("params", stParameter.getName()));
      return stTemplate;
   }

   public static ST asST(STGroup templateGroup, nextgen.model.parser.ParsedSTTemplate stModel) {
      final ST stTemplate = templateGroup.getInstanceOf("STTemplate");
      stTemplate.add("name", stModel.getName());
      stTemplate.add("content", stModel.getText());
      stModel.getParameters().forEach(stParameter -> stTemplate.add("params", stParameter.getName()));
      return stTemplate;
   }

   private static STGroup newTemplateGroup() {

      final String stg = "delimiters \"~\", \"~\"" +
            "\n\ngt() ::= \">\"" +
            "\n\neot() ::= <<~gt()~~gt()~>>" +
            "\n\nSTGroupTemplate(delimiter,templates) ::= <<delimiters \"~delimiter~\",\"~delimiter~\"" +
            "\n\n~templates:{it|~it~};separator=\"\\n\\n\"~" +
            "\n\neom() ::= \"}\"" +
            "\n\ngt() ::= \">\"" +
            "\n\n>>" +
            "\n\nSTTemplate(content,name,params) ::= <<~name~(~params:{it|~it~};separator=\",\"~) ::= <<~content~ ~eot()~>>";

      return new NamedSTGroup("TemplateTemplate", stg, "~");
   }

   private static final class NamedSTGroup extends STGroupString {

      public NamedSTGroup(String sourceName, String text, String delimiter) {
         super(sourceName, text, delimiter.charAt(0), delimiter.charAt(0));
      }

      @Override
      public String getName() {
         return sourceName;
      }
   }

   private static final class DefaultAttributeRenderer implements org.stringtemplate.v4.AttributeRenderer {

      @Override
      public String toString(Object o, String formatString, java.util.Locale locale) {

         final String text = o.toString();
         if (formatString == null) return text;

         switch (formatString) {
            case "simpleName":
               final int lastIndex = text.lastIndexOf(".");
               if (lastIndex == -1) return text;
               return text.substring(lastIndex + 1);
            case "capitalize":
               return Character.toUpperCase(text.charAt(0)) + (text.length() > 1 ? text.substring(1) : "");
            case "toUpper":
               return text.toUpperCase();
            case "lowFirst":
               return Character.toLowerCase(text.charAt(0)) + (text.length() > 1 ? text.substring(1) : "");
            case "toLower":
               return text.toLowerCase();
            default:
               return o.toString();
         }
      }
   }

   public static void writeJavaFile(Object content, String packageDeclaration, String name, String root) {
      writeJavaFile(content, packageDeclaration, name, new java.io.File(root));
   }

   public static void writeJavaFile(Object content, String packageDeclaration, String name, File root) {
      if (name == null || name.length() == 0) throw new IllegalArgumentException("WriteJavaFile.name cannot be empty");
      writeToFile(content, packageDeclaration, name, "java", root);
   }

   public static void writeJavaFile(Object content, Object packageDeclaration, Object name, File root) {
      if (name == null || name.toString().length() == 0) throw new IllegalArgumentException("WriteJavaFile.name cannot be empty");
      writeToFile(content, packageDeclaration == null ? "" : packageDeclaration.toString(), name.toString(), "java", root);
   }

   @Deprecated
   public static void writeKotlinFile(Object content, String packageDeclaration, String name, File root) {
      if (name == null || name.length() == 0)
         throw new IllegalArgumentException("WriteKotlinFile.name cannot be empty");
      writeToFile(content, packageDeclaration, name, "kt", root);
   }

   public static void writeToFile(Object content, String packageDeclaration, String name, String filetype, File root) {
      final File directory = packageDeclaration == null ? root : new File(root, packageToPath(packageDeclaration));
      final File file = new File(directory, name + (filetype == null ? "" : ("." + filetype)));
      write(file, content);
   }

   public static String packageToPath(String packageName) {
      return packageName == null ? "" : (packageName.replaceAll("[.]", "/"));
   }

   public static File makeRelative(File file, File root) {
      return new File(file.getAbsolutePath().substring(root.getAbsolutePath().length() + 1));
   }

   public static void tryToCreateFileIfNotExists(java.io.File f) {
      if (!f.exists()) {
         tryToCreateDirIfNotExists(f.getParentFile());
         try {
            if (!f.createNewFile()) throw new RuntimeException("Could not create file " + f.getName());
         } catch (IOException e) {
            throw new RuntimeException("Could not create file " + f.getName());
         }
      }
   }

   public static void tryToCreateDirIfNotExists(java.io.File f) {

      if (f == null) throw new RuntimeException("File cannot be null");

      if (!f.exists()) {
         if (f.getParentFile() != null && !f.getParentFile().exists() && !f.getParentFile().mkdirs())
            throw new RuntimeException("Could not create parent dirs for " + f.getAbsolutePath());
         if (!f.mkdir()) throw new RuntimeException("Could not create directory " + f.getName());
      }
   }

   public static void write(File file, Object content) {

      try {
         tryToCreateFileIfNotExists(file);
         log.info("writing to " + file.getAbsolutePath());
         final BufferedWriter out = new BufferedWriter(new FileWriter(file));
         out.write(content == null ? "" : content.toString());
         out.close();

      } catch (Exception e) {
         throw new RuntimeException("Could not write to " + file.getAbsolutePath() + " : " + e.getMessage(), e);
      }
   }

   private static String capitalize(String str) {
      return Character.toUpperCase(str.charAt(0)) + (str.length() > 1 ? str.substring(1) : "");
   }
}