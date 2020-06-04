package nextgen.projects;

import nextgen.domain.DomainToJson;
import nextgen.java.st.PackageDeclaration;
import org.junit.Test;

import java.io.File;

import static nextgen.domain.DomainPatterns.*;
import static nextgen.java.JavaPatterns.newPackageDeclaration;

public class STProject {

    private final File root = new File("/home/goe/projects/nextgen/components/core");
    private final File javaMainSrc = new File(root, "src/main/java");

    private final PackageDeclaration stDomainPackage = newPackageDeclaration("nextgen.st.domain");

    @Test
    public void generateDomain() {

        final EntityBuilder stTemplate = newEntityBuilder("STTemplate")
                .addStringField("name", true)
                .addStringField("text")
                .addOneToManyRelation("parameters", newEntityBuilder("STParameter")
                        .addStringField("name", true)
                        .addEnumField("type", "STParameterType", "SINGLE,LIST,KVLIST")
                        .addOneToManyRelation("keys", newEntityBuilder("STParameterKey")
                                .addStringField("name")
                                .addOneToManyRelation("argumentTypes", newString()))
                        .addOneToManyRelation("argumentTypes", newString()))
                .addOneToManySelf("children");

        final EntityBuilder stGroupModel = newEntityBuilder("STGroupModel")
                .addStringField("name", true)
                .addStringField("delimiter")
                .addOneToManyRelation("templates", stTemplate);

        DomainToJson.generate(javaMainSrc, stDomainPackage, newDomainBuilder("ST")
                .add(newEntityBuilder("STGDirectory")
                        .addStringField("path")
                        .addStringField("outputPackage")
                        .addStringField("outputPath")
                        .addOneToManyRelation("groups", stGroupModel))
                .add(newEntityBuilder("STGParseResult")
                        .addOneToOneRelation("parsed", stGroupModel)
                        .addOneToManyRelation("errors", newEntityBuilder("STGError")
                                .addEnumField("type", "STGErrorType", "COMPILE,RUNTIME,IO,INTERNAL")
                                .addExternalField("message", org.stringtemplate.v4.misc.STMessage.class))));
    }
}
