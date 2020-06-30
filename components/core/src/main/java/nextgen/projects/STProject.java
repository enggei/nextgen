package nextgen.projects;

import nextgen.st.STGenerator;
import nextgen.templates.DomainPatterns;
import nextgen.templates.JavaPatterns;
import nextgen.templates.Piccolo2DPatterns;
import nextgen.templates.TextPatterns;
import nextgen.templates.domain.Entity;
import nextgen.templates.java.PackageDeclaration;
import nextgen.templates.piccolo2d.*;
import org.junit.Test;

import java.io.File;

import static nextgen.templates.DomainPatterns.*;
import static nextgen.templates.Piccolo2DPatterns.*;
import static nextgen.templates.TextPatterns.newLine;
import static nextgen.templates.text.TextST.newBlock;

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

        final PNodeImpl stValueNode = newPNodeImpl(canvas, node)
                .setName("STValueNode")
                .setPackageName(stCanvasPackage.getName())
                .setNodeName("STNode")
                .addFields("nextgen.st.model.STValue", "stValue");

        final PNodeImpl stModelNode = newPNodeImpl(canvas, node)
                .setPackageName(stCanvasPackage.getName())
                .setName("STModelNode")
                .addFields("nextgen.st.domain.STGroupModel", "stGroupModel")
                .addFields("nextgen.st.domain.STTemplate", "stTemplate")
                .addFields("nextgen.st.model.STModel", "stModel")
                .addFields("nextgen.st.STRenderer", "stRenderer")
                .addRightClickStatements(TextPatterns.newLine(
                        "final java.util.List<STValueNode> stValueNodes = canvas.getSelectedNodes()",
                        ".filter(stNode -> stNode instanceof STValueNode)",
                        ".filter(stNode -> !stNode.getUuid().equals(getUuid()))",
                        ".map(stNode -> (STValueNode) stNode)",
                        ".collect(Collectors.toList());"))
                .addRightClickStatements(TextPatterns.newLine(
                        "final java.util.List<STModelNode> stModelNodes = canvas.getSelectedNodes()",
                        ".filter(stNode -> stNode instanceof STModelNode)",
                        ".filter(stNode -> !stNode.getUuid().equals(getUuid()))",
                        ".map(stNode -> (STModelNode) stNode)",
                        ".collect(Collectors.toList());"))
                .addRightClickStatements(newLine("stTemplate.getParameters().forEach(stParameter -> {", "});")
                        .addChildren("final JMenu stParameterMenu = new JMenu(stParameter.getName());")
                        .addChildren(JavaPatterns.newSwitch().setSelector("stParameter.getType()")
                                .addCases("SINGLE", newBlock()
                                        .addLines(newLine("stParameterMenu.add(", Piccolo2DPatterns.newAnonymousPNodeAction("STModelNode")
                                                        .setHeader("\"Set \" + stParameter.getName()")
                                                        .addStatements("final String s = SwingUtil.showInputDialog(stParameter.getName(), canvas);")
                                                        .addStatements("if (s == null || s.trim().length() == 0) return;")
                                                        .addStatements("STModeller.setArgument(stParameter, stModel, new STValue().setType(STValueType.PRIMITIVE).setValue(s.trim()));")
                                                        .addStatements("setText(stRenderer.render(stModel));")
                                                , ");"))
                                        .addLines(newLine("stValueNodes.forEach(stNode -> {", "});")
                                                .addChildren("final int end = Math.min(stNode.getText().length(), 50);")
                                                .addChildren(newLine("stParameterMenu.add(", newAnonymousPNodeAction("STModelNode")
                                                                .setHeader("\"Set \" + stParameter.getName() + \" = \" + stNode.getText().substring(0, end)")
                                                                .addStatements("STModeller.setArgument(stParameter, stModel, stNode.stValue);")
                                                                .addStatements("setText(stRenderer.render(stModel));")
                                                        , ");")))
                                        .addLines(newLine("stModelNodes.forEach(stNode -> {", "});")
                                                .addChildren("final int end = Math.min(stNode.getText().length(), 50);")
                                                .addChildren(newLine("stParameterMenu.add(", newAnonymousPNodeAction("STModelNode")
                                                                .setHeader("\"Set \" + stParameter.getName() + \" = \" + stNode.getText().substring(0, end)")
                                                                .addStatements("STModeller.setArgument(stParameter, stModel, new STValue().setType(STValueType.STMODEL).setValue(stNode.getUuid().toString()));")
                                                                .addStatements("setText(stRenderer.render(stModel));")
                                                        , ");"))))
                                .addCases("LIST", newBlock()
                                        .addLines(newLine("stParameterMenu.add(", newAnonymousPNodeAction("STModelNode")
                                                        .setHeader("\"Add \" + stParameter.getName()")
                                                        .addStatements("final String s = SwingUtil.showInputDialog(stParameter.getName(), canvas);")
                                                        .addStatements("if (s == null || s.trim().length() == 0) return;")
                                                        .addStatements("STModeller.addArgument(stParameter, stModel, new STValue().setType(STValueType.PRIMITIVE).setValue(s.trim()));")
                                                        .addStatements("setText(stRenderer.render(stModel));")
                                                , ");"))
                                        .addLines(newLine("stValueNodes.forEach(stNode -> {", "});")
                                                .addChildren("final int end = Math.min(stNode.getText().length(), 50);")
                                                .addChildren(newLine("stParameterMenu.add(", newAnonymousPNodeAction("STModelNode")
                                                                .setHeader("\"Add \" + stParameter.getName() + \" = \" + stNode.getText().substring(0, end)")
                                                                .addStatements("STModeller.addArgument(stParameter, stModel, stNode.stValue);")
                                                                .addStatements("setText(stRenderer.render(stModel));")
                                                        , ");")))
                                        .addLines(newLine("stModelNodes.forEach(stNode -> {", "});")
                                                .addChildren("final int end = Math.min(stNode.getText().length(), 50);")
                                                .addChildren(newLine("stParameterMenu.add(", newAnonymousPNodeAction("STModelNode")
                                                                .setHeader("\"Add \" + stParameter.getName() + \" = \" + stNode.getText().substring(0, end)")
                                                                .addStatements("STModeller.addArgument(stParameter, stModel, new STValue().setType(STValueType.STMODEL).setValue(stNode.getUuid().toString()));")
                                                                .addStatements("setText(stRenderer.render(stModel));")
                                                        , ");")))
                                )
                                .addCases("KVLIST", newBlock()
                                        .addLines(newLine("stParameterMenu.add(", newAnonymousPNodeAction("STModelNode")
                                                .setHeader("\"Add \" + stParameter.getName()")
                                                .addStatements(newBlock()
                                                        .addLines("final Map<STParameterKey, JTextField> fieldMap = new LinkedHashMap<>();")
                                                        .addLines(newLine("stParameter.getKeys().forEach(stParameterKey -> {", "});")
                                                                .addChildren("fieldMap.put(stParameterKey, new JTextField(15));")))
                                                .addStatements(newBlock()
                                                        .addLines("final JPanel inputPanel = new JPanel(new GridLayout(fieldMap.size(), 2));")
                                                        .addLines("inputPanel.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));")
                                                        .addLines(newLine("for (Map.Entry<STParameterKey, JTextField> fieldEntry : fieldMap.entrySet()) {", "}")
                                                                .addChildren("inputPanel.add(new JLabel(fieldEntry.getKey().getName()));")
                                                                .addChildren("inputPanel.add(fieldEntry.getValue());")))
                                                .addStatements(newBlock()
                                                        .addLines(newLine("SwingUtil.showDialog(inputPanel, canvas, stParameter.getName(), new SwingUtil.ConfirmAction() {", "});")
                                                                .addChildren("@Override")
                                                                .addChildren(newLine("public void verifyAndCommit() throws Exception {", "}")
                                                                        .addChildren("final Collection<STArgumentKV> kvs = new ArrayList<>();")
                                                                        .addChildren(newLine("for (Map.Entry<STParameterKey, JTextField> fieldEntry : fieldMap.entrySet()) {", "}")
                                                                                .addChildren("kvs.add(new STArgumentKV().setKey(fieldEntry.getKey()).setValue(new STValue().setType(STValueType.PRIMITIVE).setValue(fieldEntry.getValue().getText().trim())));"))
                                                                        .addChildren("STModeller.addArgument(stParameter, stModel, kvs);")
                                                                        .addChildren("setText(stRenderer.render(stModel));")))), ");"))
                                ))
                        .addChildren("pop.add(stParameterMenu);"))
                .addRightClickStatements("final JMenu remove = new JMenu(\"Remove\");")
                .addRightClickStatements(newLine("stModel.getArguments().forEach(stArgument -> {", "});")
                        .addChildren("final String s = stRenderer.render(stArgument).toString();")
                        .addChildren("final int end = Math.min(s.length(), 50);")
                        .addChildren(newLine("remove.add(new STNode.NodeAction<STModelNode>(\"Remove \" + s.substring(0, end), this, canvas, event) {", "});")
                                .addChildren("@Override")
                                .addChildren(newLine("void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {", "}")
                                        .addChildren("STModeller.removeArgument(stArgument, stModel);")
                                        .addChildren("setText(stRenderer.render(stModel));"))))
                .addRightClickStatements("if (remove.getMenuComponentCount() != 0) pop.add(remove);");

        final CanvasAction newSTNodeAction = newCanvasAction(canvas, "NewSTValueNode", "New Value")
                .addStatements("final String s = com.generator.util.SwingUtil.showInputDialog(\"Value\", canvas);\n" +
                        "if (s == null || s.trim().length() == 0) return;")
                .addStatements(newLine("SwingUtilities.invokeLater(() -> {", "});")
                        .addChildren("final nextgen.st.model.STValue stValue = new nextgen.st.model.STValue().setType(nextgen.st.model.STValueType.PRIMITIVE).setValue(s);")
                        .addChildren("canvas.addNode(new " + stValueNode.getName() + "(canvas, s, stValue.getUuid(), stValue));"));
        registerRightClickAction(canvas, newSTNodeAction, newSTNodeAction.getName());

        final NodeAction editSTValue = newNodeAction(stValueNode, "EditSTValue", "Edit")
                .addStatements("final String s = com.generator.util.SwingUtil.showInputDialog(\"Value\", canvas, node.stValue.getValue().toString());\n" +
                        "if (s == null || s.trim().length() == 0) return;")
                .addStatements("node.stValue.setValue(s);");
        registerRightClickAction(stValueNode, editSTValue, editSTValue.getName());

        Piccolo2DPatterns.addDefaultActionsToCanvas(canvas);
        Piccolo2DPatterns.addDefaultActionsToNode(node);

        STGenerator.writeJavaFile(canvas, stCanvasPackage, canvas.getName(), javaMainSrc);
        STGenerator.writeJavaFile(node, stCanvasPackage, node.getName(), javaMainSrc);
        STGenerator.writeJavaFile(relation, stCanvasPackage, relation.getName(), javaMainSrc);

        STGenerator.writeJavaFile(stModelNode, stCanvasPackage, stModelNode.getName(), javaMainSrc);
        STGenerator.writeJavaFile(stValueNode, stCanvasPackage, stValueNode.getName(), javaMainSrc);
    }

    @Test
    public void generateModellingDomain() {

        final Entity stValue = newEntity("STValue")
                .addRelations(newEnumField("type", "STValueType", "STMODEL,PRIMITIVE"))
                .addRelations(newExternalRef("value", Object.class));

        writePojo(javaMainSrc, stModelPackage.getName(), newDomain("STModel")
                .addEntities(newEntity("STModule")
                        .addRelations(newStringField("name"))
                        .addRelations(newOneToManyString("stGroups"))
                        .addRelations(newOneToMany("models", newEntity("STModel")
                                .addRelations(newExternalRef("stTemplate", DomainPatterns.newType(stDomainPackage, "STTemplate")))
                                .addRelations(newOneToMany("arguments", newEntity("STArgument")
                                        .addRelations(newExternalRef("stParameter", DomainPatterns.newType(stDomainPackage, "STParameter")))
                                        .addRelations(newOneToOne("value", stValue))
                                        .addRelations(newOneToMany("keyValues", newEntity("STArgumentKV")
                                                .addRelations(newExternalRef("stParameterKey", DomainPatterns.newType(stDomainPackage, "STParameterKey")))
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