package nextgen.st;

import nextgen.st.domain.STGroupModel;
import nextgen.st.domain.STTemplate;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class STGenerator {

    public static boolean debug = true;

    public static final String DELIMITER = "~";

    private final STGroup generator;

    public STGenerator(STGroupModel generator) {
        this(toSTGroup(generator));
    }

    public STGenerator(STGroup generator) {
        this.generator = generator;
    }

    public void generateSTGroup(STGroupModel stGroupModel, String packageName, String rootPath) {

        final File root = new File(rootPath);
        final String packageDeclaration = packageName + "." + stGroupModel.getName().toLowerCase();

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
        stGroupModel.getTemplates()
                .sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))
                .forEach(stTemplate -> generateSTEntity(stTemplate, root, packageDeclaration, stDomain, stDomainTests, stgString));

        stDomain.add("stgString", stgString);

        writeToFile(toStg(stGroupModel), packageDeclaration, stGroupModel.getName(), "stg", root);
        writeToFile(stDomain.render(), packageDeclaration, domainClassName, "java", root);
        writeToFile(stDomainTests.render(), packageDeclaration, testsClassName, "java", root);
    }

    public void generateSTEntity(STTemplate stTemplate, File root, String packageDeclaration, ST stDomain, ST stDomainTests, ST stgString) {

        if (stTemplate.getText().trim().length() == 0) {
            stTemplate.getChildren().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(childTemplate -> generateSTEntity(childTemplate, root, packageDeclaration, stDomain, stDomainTests, stgString));
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

        stTemplate.getChildren().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(childTemplate -> generateSTEntity(childTemplate, root, packageDeclaration, stDomain, stDomainTests, stgString));

        final ST stClass = generateSTClass(className, stTemplate, packageDeclaration);
        writeToFile(stClass.render(), packageDeclaration, className, "java", root);
    }

    public ST generateSTClass(String className, STTemplate stTemplate, String packageDeclaration) {

        final ST stEntity = generator.getInstanceOf("STEntity");
        stEntity.add("packageName", packageDeclaration);
        stEntity.add("name", className);
        stEntity.add("template", stTemplate.getName());

        String content = escape(stTemplate.getText()).replaceAll("\n", "\\\\n\" + \n\t\t\t\"");
        content = content.replaceAll(">>", ">~gt()~");
        content = content.endsWith(">") ? (content.trim() + " ") : content.trim();

        final ST template = generator.getInstanceOf("Template")
                .add("name", stTemplate.getName())
                .add("content", content);

        stTemplate.getParameters().forEach(stParameter -> {

            template.add("params", stParameter.getName());

            switch (stParameter.getType()) {
                case SINGLE:

                    stEntity.addAggr("singleFields.{name,type}", stParameter.getName(), stParameter.getArgumentType("Object"));
                    final ST singleAccessors = generator.getInstanceOf("entitySingleAccessors");
                    singleAccessors.add("entity", className);
                    singleAccessors.add("name", stParameter.getName());
                    singleAccessors.add("type", stParameter.getArgumentType("Object"));
                    stEntity.add("singleAccessors", singleAccessors);
                    break;

                case LIST:

                    stEntity.addAggr("listFields.{name,type}", stParameter.getName(), stParameter.getArgumentType("Object"));
                    final ST listAccessors = generator.getInstanceOf("entityListAccessors");
                    listAccessors.add("entity", className);
                    listAccessors.add("name", stParameter.getName());
                    listAccessors.add("type", stParameter.getArgumentType("Object"));
                    stEntity.add("listAccessors", listAccessors);
                    break;

                case KVLIST:

                    final ST aggrSpec = new ST("~name~.{~keys:{it|~it~};separator=\",\"~}", '~', '~')
                            .add("name", stParameter.getName());
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

        stEntity.add("stString", template);

        return stEntity;
    }

    public static STGroup toSTGroup(STGroupModel model) {
        final STGroupString stGroupString = new STGroupString(model.getName(), toStg(model), model.getDelimiter().charAt(0), model.getDelimiter().charAt(0));
        stGroupString.registerRenderer(Object.class, new DefaultAttributeRenderer());
        return stGroupString;
    }

    public static String toStg(STGroupModel model) {
        final STGroup templateGroup = newTemplateGroup();

        final ST stGroupTemplate = templateGroup.getInstanceOf("STGroupTemplate");
        stGroupTemplate.add("delimiter", model.getDelimiter());

        model.getTemplates()
                .filter(stTemplate -> !(stTemplate.getName().equals("eom") || stTemplate.getName().equals("gt")))
                .sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))
                .forEach(stModel -> addSTTemplate(templateGroup, stGroupTemplate, stModel));

        return stGroupTemplate.render();
    }

    private static void addSTTemplate(STGroup templateGroup, ST stGroupTemplate, STTemplate stModel) {

        final ST stTemplate = templateGroup.getInstanceOf("STTemplate");
        stTemplate.add("name", stModel.getName());
        stTemplate.add("content", stModel.getText());
        stModel.getParameters().forEach(stParameter -> stTemplate.add("params", stParameter.getName()));

        stGroupTemplate.add("templates", stTemplate);

        stModel.getChildren().forEach(childTemplate -> addSTTemplate(templateGroup, stGroupTemplate, childTemplate));
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

    public static void writeToFile(Object content, String packageDeclaration, String name, String filetype, File root) {
        final File directory = new File(root, packageToPath(packageDeclaration));
        final File file = new File(directory, name + "." + filetype);
        write(file, content);
    }

    public static String packageToPath(String packageName) {
        return packageName.replaceAll("[.]", "/");
    }

    public static File tryToCreateFileIfNotExists(File f) {
        if (!f.exists()) {
            tryToCreateDirIfNotExists(f.getParentFile());
            try {
                if (!f.createNewFile()) throw new RuntimeException("Could not create file " + f.getName());
            } catch (IOException e) {
                throw new RuntimeException("Could not create file " + f.getName());
            }
        }
        return f;
    }

    public static File tryToCreateDirIfNotExists(File f) {

        if (f == null) throw new RuntimeException("File cannot be null");

        if (!f.exists()) {
            if (f.getParentFile() != null && !f.getParentFile().exists() && !f.getParentFile().mkdirs())
                throw new RuntimeException("Could not create parent dirs for " + f.getAbsolutePath());
            if (!f.mkdir()) throw new RuntimeException("Could not create directory " + f.getName());
        }
        return f;
    }

    public static void write(File file, Object content) {

        try {
            tryToCreateFileIfNotExists(file);
            if (debug) System.out.println("writing file " + file.getAbsolutePath());

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

    private static String escape(String text) {
        return text.replaceAll("\\\\", "\\\\\\\\").replaceAll("\"", "\\\\\"");
    }

}