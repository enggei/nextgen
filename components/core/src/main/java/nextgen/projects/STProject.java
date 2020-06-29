package nextgen.projects;

import nextgen.st.STGenerator;
import nextgen.templates.JavaPatterns;
import nextgen.templates.Piccolo2DPatterns;
import nextgen.templates.domain.Entity;
import nextgen.templates.java.PackageDeclaration;
import nextgen.templates.piccolo2d.*;
import org.junit.Test;

import java.io.File;

import static nextgen.templates.DomainPatterns.*;
import static nextgen.templates.Piccolo2DPatterns.*;

public class STProject {

    private final File root = new File("/home/goe/projects/nextgen/components/core");
    private final File javaMainSrc = new File(root, "src/main/java");
    private final File javaTestSrc = new File(root, "src/test/java");

    private final PackageDeclaration stPackage = JavaPatterns.newPackageDeclaration("nextgen.st");
    private final PackageDeclaration stDomainPackage = JavaPatterns.newPackageDeclaration(stPackage, "domain");
    private final PackageDeclaration stModelPackage = JavaPatterns.newPackageDeclaration(stPackage, "model");
    private final PackageDeclaration stCanvasPackage = JavaPatterns.newPackageDeclaration(stPackage, "canvas");

    @Test
    public void generateCanvasPackage() {

        final String canvasName = "STCanvas";
        final String nodeName = "STNode";
        final String relationName = "STRelation";

        final PCanvas canvas = newPCanvas()
                .setName(canvasName)
                .setPackageName(stCanvasPackage.getName())
                .setNodeName(nodeName)
                .setRelationName(relationName);

        final PNode node = newPNode()
                .setName(nodeName)
                .setCanvasName(canvas.getName())
                .setPackageName(stCanvasPackage.getName());

        final PRelation relation = newPRelation()
                .setName(relationName)
                .setNodeName(node.getName())
                .setCanvasName(canvas.getName())
                .setPackageName(stCanvasPackage.getName());

        final CanvasAction newSTNodeAction = newCanvasAction(canvas, "NewNode", "New Node")
                .addStatements("SwingUtilities.invokeLater(() -> canvas.addNode(new " + node.getName() + "(canvas, \"HelloWorld\")));");

        registerRightClickAction(canvas, newSTNodeAction, newSTNodeAction.getName());

        Piccolo2DPatterns.addDefaultActionsToCanvas(canvas);
        Piccolo2DPatterns.addDefaultActionsToNode(node);

        STGenerator.writeJavaFile(canvas, stCanvasPackage, canvas.getName(), javaMainSrc);
        STGenerator.writeJavaFile(node, stCanvasPackage, node.getName(), javaMainSrc);
        STGenerator.writeJavaFile(relation, stCanvasPackage, relation.getName(), javaMainSrc);
    }

    @Test
    public void generateModellingDomain() {

        final Entity stValue = newEntity("STValue")
                .addRelations(newEnumField("type", "STValueType", "STMODEL,PRIMITIVE"))
                .addRelations(newStringField("value"));

        writeJsonWrapper(javaTestSrc, stModelPackage.getName(), newDomain("STModel")
                .addEntities(newEntity("STModule")
                        .addRelations(newStringField("name"))
                        .addRelations(newOneToManyString("stGroups"))
                        .addRelations(newOneToMany("models", newEntity("STModel")
                                .addRelations(newStringField("stTemplate"))
                                .addRelations(newOneToMany("arguments", newEntity("STArgument")
                                        .addRelations(newStringField("stParameter"))
                                        .addRelations(newOneToOne("value", stValue))
                                        .addRelations(newOneToMany("keyValues", newEntity("STArgumentKV")
                                                .addRelations(newStringField("key"))
                                                .addRelations(newOneToOne("value", stValue))))))))
                        .addRelations(newOneToMany("values", stValue))
                )
        );
    }

    @Test
    public void generateDomain() {

        final Entity stGroupModel = newEntity("STGroupModel")
                .addRelations(newStringField("name", true))
                .addRelations(newStringField("delimiter"))
                .addRelations(newStringField("icon"))
                .addRelations(newOneToMany("templates", newEntity("STTemplate")
                        .addRelations(newStringField("name", true))
                        .addRelations(newStringField("text"))
                        .addRelations(newOneToManyString("implements"))
                        .addRelations(newOneToMany("parameters", newEntity("STParameter")
                                .addRelations(newStringField("name", true))
                                .addRelations(newEnumField("type", newEnum("STParameterType", "SINGLE,LIST,KVLIST")))
                                .addRelations(newOneToMany("keys", newEntity("STParameterKey")
                                        .addRelations(newStringField("name"))
                                        .addRelations(newStringField("argumentType"))))
                                .addRelations(newStringField("argumentType"))))
                        .addRelations(newOneToManySelf("children"))))
                .addRelations(newOneToMany("interfaces", newEntity("STInterface")
                        .addRelations(newStringField("name"))))
                .addRelations(newOneToMany("enums", newEntity("STEnum")
                        .addRelations(newStringField("name", true))
                        .addRelations(newOneToMany("values", newEntity("STEnumValue")
                                .addRelations(newStringField("name", true))
                                .addRelations(newStringField("lexical"))))));

        writeJsonWrapper(javaMainSrc, stDomainPackage.getName(), newDomain("ST")
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
                                .addRelations(newStringField("message"))
                                .addRelations(newIntegerField("line"))
                                .addRelations(newIntegerField("charPosition"))))));
    }
}