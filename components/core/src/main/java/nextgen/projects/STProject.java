package nextgen.projects;

import nextgen.templates.domain.Entity;
import nextgen.templates.java.JavaST;
import nextgen.templates.java.PackageDeclaration;
import org.junit.Test;

import java.io.File;

import static nextgen.templates.DomainPatterns.*;

public class STProject {

    private final File root = new File("/home/goe/projects/nextgen/components/core");
    private final File javaMainSrc = new File(root, "src/main/java");
    private final File javaTestSrc = new File(root, "src/test/java");

    private final PackageDeclaration stDomainPackage = JavaST.newPackageDeclaration().setName("nextgen.st.domain");

    @Test
    public void generateDomain() {

        final Entity stGroupModel = newEntity("STGroupModel")
                .addRelations(newStringField("name", true))
                .addRelations(newStringField("delimiter"))
                .addRelations(newOneToMany("templates", newEntity("STTemplate")
                        .addRelations(newStringField("name", true))
                        .addRelations(newStringField("text"))
                        .addRelations(newOneToMany("parameters", newEntity("STParameter")
                                .addRelations(newStringField("name", true))
                                .addRelations(newEnumField("type", newEnum("STParameterType", "SINGLE,LIST,KVLIST")))
                                .addRelations(newOneToMany("keys", newEntity("STParameterKey")
                                        .addRelations(newStringField("name"))
                                        .addRelations(newStringField("argumentType"))))
                                .addRelations(newOneToManySelf("children"))
                                .addRelations(newOneToMany("enums", newEntity("STEnum")
                                        .addRelations(newStringField("name", true))
                                        .addRelations(newStringField("values"))))))));

        ProjectPatterns.writeJsonWrapper(javaTestSrc, newDomain("ST", stDomainPackage.getName())
                .addEntities(newEntity("STAppModel")
                        .addRelations(newStringField("generatorRoot"))
                        .addRelations(newStringField("generatorPackage"))
                        .addRelations(newStringField("generatorName"))
                        .addRelations(newOneToMany("directories", newEntity("STGDirectory")
                                .addRelations(newStringField("path"))
                                .addRelations(newStringField("outputPackage"))
                                .addRelations(newStringField("outputPath"))
                                .addRelations(newOneToMany("groups", stGroupModel)))))
                .addEntities(newEntity("STGParseResult")
                        .addRelations(newOneToOne("parsed", stGroupModel))
                        .addRelations(newOneToMany("errors", newEntity("STGError")
                                .addRelations(newEnumField("type", newEnum("STGErrorType", "COMPILE,RUNTIME,IO,INTERNAL")))
                                .addRelations(newOneToOneExternal("message", org.stringtemplate.v4.misc.STMessage.class))))));
    }

}
