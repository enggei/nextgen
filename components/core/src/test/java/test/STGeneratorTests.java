package test;

import io.vertx.core.json.JsonObject;
import nextgen.st.STApp;
import nextgen.st.STGenerator;
import nextgen.st.STParser;
import nextgen.st.domain.STGDirectory;
import nextgen.st.domain.STGroupModel;
import org.junit.Test;
import org.stringtemplate.v4.STGroupFile;

import java.io.File;

public class STGeneratorTests {

    @Test
    public void test() {

        final String root = "/home/goe/projects/nextgen/components/core/src/test/java";
        final String packageDeclaration = "tmp.st";

        final STGDirectory stgDirectory = STApp.load("/home/goe/projects/nextgen/components/core/src/main/resources/templates");

        final STGenerator stGenerator = new STGenerator(new STGroupModel(new JsonObject(STParser.read(new File("/home/goe/projects/nextgen/components/core/src/main/java/nextgen/st/StringTemplate.json")))));

        stgDirectory.getGroups()
                .filter(stGroupModel1 -> stGroupModel1.getName().equals("Test"))
                .forEach(stGroupModel1 -> {
                    stGenerator.generateSTGroup(stGroupModel1, packageDeclaration, root);
                });
    }
}
