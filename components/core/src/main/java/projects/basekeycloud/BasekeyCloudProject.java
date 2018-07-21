package projects.basekeycloud;

import com.generator.generators.java.JavaGroup;
import com.generator.util.GeneratedFile;
import org.junit.Test;

import java.io.IOException;

public class BasekeyCloudProject extends BasekeyCloud {

    private final String domainPackage = "com.ud.basekey.cloud.domain";

    @Test
    public void generateProbeMaintenance() throws IOException {

        final String classname = "Probe";

        final JavaGroup.PojoST probeST = javaGroup.newPojo().
                setPackage(domainPackage).
                setScope("public").
                setName(classname).
                setExtends("BaseEntity").
                addImportsValue("com.ud.core.domain.BaseEntity");

        probeST.addPropertiesValue(null, "String", "uuid", null, null, null, null);
        probeST.addPropertiesValue(null, "String", "name", null, null, null, null);
        probeST.addPropertiesValue(null, "Boolean", "deleted", null, null, null, null);


        GeneratedFile.newJavaFile(dir("main.src"), domainPackage, classname).write(probeST);
    }
}