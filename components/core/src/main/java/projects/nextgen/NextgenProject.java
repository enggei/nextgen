package projects.nextgen;

import com.generator.project.Project;
import org.junit.Test;

public class NextgenProject extends Project {

    @Test
    public void createMeta() {

        final String src = "/home/goe/projects/generator/src/main/java";
        final String packageName = "projects.nextgen.meta";

        generator("NextgenGenerator", packageName);

        entity("TemplateVerticle", packageName).
                addProperties(property("name", "String", true)).
                addProperties(property("packageName", "String", true)).
                addProperties(listProperty("properties", "DataProperty"));

    }
}