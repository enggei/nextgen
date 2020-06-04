package test;

import nextgen.st.STApp;
import nextgen.st.STGenerator;
import nextgen.st.domain.STGDirectory;
import nextgen.st.domain.STGroupModel;
import org.junit.Test;

import java.util.Optional;

public class STGeneratorTests {

    @Test
    public void test() {

        final String root = "components/core/src/test/java";
        final String packageDeclaration = "tmp.st";

        final STGDirectory stgDirectory = STApp.load("/home/goe/projects/nextgen/components/core/src/main/resources/templates");

        final Optional<STGroupModel> templateGroup = stgDirectory.getGroups()
                .filter(stGroupModel1 -> stGroupModel1.getName().equals("StringTemplate"))
                .findFirst();

        templateGroup.ifPresent(stGroupModel -> {
            final STGenerator stGenerator = new STGenerator(STGenerator.toSTGroup(stGroupModel));

            stgDirectory.getGroups()
                    .filter(stGroupModel1 -> stGroupModel1.getName().equals("Test"))
                    .forEach(stGroupModel1 -> {
                        stGenerator.generateSTGroup(stGroupModel1, packageDeclaration, root);

                    });

        });
    }
}
