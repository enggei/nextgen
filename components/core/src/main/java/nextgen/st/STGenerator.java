package nextgen.st;

import com.generator.util.StringUtil;
import nextgen.st.domain.STGroupModel;
import nextgen.st.domain.STTemplate;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class STGenerator {

    private final STGroup templateGroup;

    public STGenerator(STGroupModel templateGroup) {
        this.templateGroup = STGenerator.toSTGroup(templateGroup);
    }

    public void generateSTGroup(STGroupModel stGroupModel, String packageName, String rootPath) {

        final File root = new File(rootPath);

        final String packageDeclaration = packageName + "." + stGroupModel.getName().toLowerCase();

        final File stg = writeToFile(toStg(stGroupModel), packageDeclaration, stGroupModel.getName(), "stg", root);

        final String domainClassName = StringUtil.capitalize(stGroupModel.getName() + "ST");
        final ST stDomain = templateGroup.getInstanceOf("STDomain");
        stDomain.add("packageName", packageDeclaration);
        stDomain.add("name", domainClassName);
        stDomain.add("template", stGroupModel.getName());
        stDomain.add("templateDir", stg.getParentFile().getAbsolutePath());

        final ST stDomainTests = templateGroup.getInstanceOf("STDomainTests");
        final String testsClassName = StringUtil.capitalize(stGroupModel.getName() + "STTests");
        stDomainTests.add("packageName", packageDeclaration);
        stDomainTests.add("name", testsClassName);
        stDomainTests.add("domainName", domainClassName);

        stGroupModel.getTemplates()
                .sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))
                .forEach(stTemplate -> generateSTEntity(root, packageDeclaration, stDomain, stDomainTests, stTemplate));

        writeToFile(stDomain.render(), packageDeclaration, domainClassName, root);
        writeToFile(stDomainTests.render(), packageDeclaration, testsClassName, root);
    }

    public void generateSTEntity(File root, String packageDeclaration, ST stDomain, ST stDomainTests, STTemplate stTemplate) {

        final String className = StringUtil.capitalize(stTemplate.getName());
        writeToFile(generateSTClass(className, stTemplate, packageDeclaration), packageDeclaration, className, root);

        final ST newEntity = templateGroup.getInstanceOf("newEntityInstance");
        newEntity.add("entityName", className);
        newEntity.add("template", stTemplate.getName());
        stDomain.add("entities", newEntity);

        final ST entityTestCase = templateGroup.getInstanceOf("templateTestMethod");
        entityTestCase.add("template", stTemplate.getName());

        stDomainTests.addAggr("testcases.{name,impl}", stTemplate.getName(), entityTestCase);

        stTemplate.getChildren().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stTemplate1 -> generateSTEntity(root, packageDeclaration, stDomain, stDomainTests, stTemplate1));
    }

    public String generateSTClass(String className, STTemplate stTemplate, String packageDeclaration) {

        final ST stEntity = templateGroup.getInstanceOf("STEntity");
        stEntity.add("packageName", packageDeclaration);
        stEntity.add("name", className);

        stTemplate.getParameters().forEach(stParameter -> {

            switch (stParameter.getType()) {
                case SINGLE:

                    stEntity.add("singleFields", stParameter.getName());

                    final ST singleAccessors = templateGroup.getInstanceOf("entitySingleAccessors");
                    singleAccessors.add("entity", className);
                    singleAccessors.add("name", stParameter.getName());
                    stEntity.add("singleAccessors", singleAccessors);
                    break;
                case LIST:
                    stEntity.add("listFields", stParameter.getName());

                    ST listAccessors = templateGroup.getInstanceOf("entityListAccessors");
                    listAccessors.add("entity", className);
                    listAccessors.add("name", stParameter.getName());
                    stEntity.add("listAccessors", listAccessors);

                    break;
                case KVLIST:

                    final ST aggrSpec = new ST(".{~keys:{it|~it~};separator=\",\"~}", '~', '~');
                    final ST aggrValues = new ST("~values:{it|map.get(\"~it~\")};separator=\", \"~", '~', '~');

                    final ST kvListAccessors = templateGroup.getInstanceOf("entityKVListAccessors");
                    kvListAccessors.add("entity", className);
                    kvListAccessors.add("name", stParameter.getName());
                    stParameter.getKeys().forEach(stParameterKey -> {
                        kvListAccessors.add("keys", stParameterKey);

                        aggrSpec.add("keys", stParameterKey);
                        aggrValues.add("values", stParameterKey);
                    });

                    stEntity.addAggr("kvListFields.{name,aggrSpec,aggrValues}", stParameter.getName(), stParameter.getName() + aggrSpec.render(), aggrValues.render());
                    stEntity.add("kvListAccessors", kvListAccessors);
                    break;
            }
        });

        return stEntity.render();
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

    public static void addSTTemplate(STGroup templateGroup, ST stGroupTemplate, STTemplate stModel) {

        final ST stTemplate = templateGroup.getInstanceOf("STTemplate");
        stTemplate.add("name", stModel.getName());
        stTemplate.add("content", stModel.getText());
        stModel.getParameters().forEach(stParameter -> stTemplate.add("params", stParameter.getName()));

        stGroupTemplate.add("templates", stTemplate);

        stModel.getChildren().forEach(stTemplate1 -> addSTTemplate(templateGroup, stGroupTemplate, stTemplate1));
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

    public static void main(String[] args) {
        final ST aggrSpec = new ST("~keys:{it|~it~};separator=\",\"~", '~', '~');

        aggrSpec.add("keys", 1);
        aggrSpec.add("keys", 1);
        aggrSpec.add("keys", 1);

        System.out.println(aggrSpec.render());
    }

    public static File writeToFile(Object content, String packageDeclaration, String name, File root) {
        final File directory = new File(root, packageToPath(packageDeclaration));
        final File file = new File(directory, name + ".java");
        write(file, content);
        return file;
    }

    public static File writeToFile(Object content, String packageDeclaration, String name, String filetype, File root) {
        final File directory = new File(root, packageToPath(packageDeclaration));
        final File file = new File(directory, name + "." + filetype);
        write(file, content);
        return file;
    }

    public static String packageToPath(String packageName) {
        return packageName.replaceAll("[.]", "/");
    }

    public static File write(File file, Object content) {

        try {

            if (!file.exists()) {
                final File parent = file.getParentFile();
                if (!parent.exists()) {
                    if (parent.getParentFile() != null && !parent.getParentFile().exists() && !parent.getParentFile().mkdirs())
                        throw new RuntimeException("Could not create parent dirs for " + parent.getAbsolutePath());
                    if (!parent.mkdir()) throw new RuntimeException("Could not create directory " + parent.getName());
                }
                if (!file.createNewFile()) throw new RuntimeException("Could not create file " + file.getName());
            }
            System.out.println("writing file " + file.getAbsolutePath());

            final BufferedWriter out = new BufferedWriter(new FileWriter(file));
            out.write(content == null ? "" : content.toString());
            out.close();

            return file;

        } catch (Exception e) {
            throw new RuntimeException("Could not write to " + file.getAbsolutePath() + " : " + e.getMessage(), e);
        }
    }
}