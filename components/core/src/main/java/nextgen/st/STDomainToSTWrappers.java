package nextgen.st;

import com.generator.util.StringUtil;
import nextgen.java.JavaPatterns;
import nextgen.java.st.PackageDeclaration;
import nextgen.st.domain.STGDirectory;
import nextgen.st.domain.STGroupModel;
import nextgen.st.domain.STTemplate;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import java.io.File;
import java.util.Optional;

import static nextgen.java.JavaPatterns.newPackageDeclaration;

public class STDomainToSTWrappers {

    private final STGroup templateGroup;

    public STDomainToSTWrappers(STGroupModel templateGroup) {
        this.templateGroup = STGenerator.toSTGroup(templateGroup);
    }

    public static void main(String[] args) {

        final String root = "components/core/src/test/java";
        final String packageDeclaration = "tmp.st";

        final STGDirectory stgDirectory = STApp.load("/home/goe/projects/nextgen/components/core/src/main/resources/templates");
        final Optional<STGroupModel> templateGroup = stgDirectory.getGroups()
                .filter(stGroupModel1 -> stGroupModel1.getName().equals("StringTemplate"))
                .findFirst();

        templateGroup.ifPresent(stGroupModel -> {
            final STDomainToSTWrappers stGenerator = new STDomainToSTWrappers(stGroupModel);

            stgDirectory.getGroups()
                    .filter(stGroupModel1 -> stGroupModel1.getName().equals("Test"))
                    .forEach(stGroupModel1 -> {
                        stGenerator.generateSTGroup(stGroupModel1, packageDeclaration, root);
                    });

        });
    }

    public void generateSTGroup(STGroupModel stGroupModel, String packageName, String root) {

        final PackageDeclaration packageDeclaration = newPackageDeclaration(packageName + "." + stGroupModel.getName().toLowerCase());

        final String domainClassName = StringUtil.capitalize(stGroupModel.getName() + "ST");
        final ST stDomain = templateGroup.getInstanceOf("STDomain");
        stDomain.add("packageName", packageDeclaration.getName());
        stDomain.add("name", domainClassName);

        final ST stDomainTests = templateGroup.getInstanceOf("STDomainTests");
        final String testsClassName = StringUtil.capitalize(stGroupModel.getName() + "STTests");
        stDomainTests.add("packageName", packageDeclaration.getName());
        stDomainTests.add("name", testsClassName);
        stDomainTests.add("domainName", domainClassName);
        stDomainTests.add("stgPath", "/home/goe/projects/nextgen/components/core/src/main/resources/templates/" + stGroupModel.getName() + ".stg");

        stGroupModel.getTemplates().forEach(stTemplate -> {
            final String className = StringUtil.capitalize(stTemplate.getName());
            JavaPatterns.writeToFile(generateSTClass(className, stTemplate, packageDeclaration), packageDeclaration, className, new File(root));

            final ST newEntity = templateGroup.getInstanceOf("newEntityInstance");
            newEntity.add("entityName", className);
            newEntity.add("template", stTemplate.getName());
            stDomain.add("entities", newEntity);

            final ST entityTestCase = templateGroup.getInstanceOf("templateTestMethod");
            entityTestCase.add("template", stTemplate.getName());

            stDomainTests.addAggr("testcases.{name,impl}", stTemplate.getName(), entityTestCase);
        });

        JavaPatterns.writeToFile(stDomain.render(), packageDeclaration, domainClassName, new File(root));
        JavaPatterns.writeToFile(stDomainTests.render(), packageDeclaration, testsClassName, new File(root));
    }

    public String generateSTClass(String className, STTemplate stTemplate, PackageDeclaration packageDeclaration) {

        final ST stEntity = templateGroup.getInstanceOf("STEntity");
        stEntity.add("packageName", packageDeclaration.getName());
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

                    final ST listAccessors = templateGroup.getInstanceOf("entityListAccessors");
                    listAccessors.add("entity", className);
                    listAccessors.add("name", stParameter.getName());
                    stEntity.add("listAccessors", listAccessors);

                    break;
                case KVLIST:
                    stEntity.add("kvListFields", stParameter.getName());

                    final ST kvListAccessors = templateGroup.getInstanceOf("entityKVListAccessors");
                    kvListAccessors.add("entity", className);
                    kvListAccessors.add("name", stParameter.getName());
                    stParameter.getKeys().forEach(stParameterKey -> kvListAccessors.add("keys", stParameterKey));
                    stEntity.add("kvListAccessors", kvListAccessors);
                    break;
            }
        });

        return stEntity.render();
    }
}