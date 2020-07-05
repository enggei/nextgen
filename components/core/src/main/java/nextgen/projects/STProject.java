package nextgen.projects;

import nextgen.st.STGenerator;
import nextgen.templates.JavaPatterns;
import nextgen.templates.Piccolo2DPatterns;
import nextgen.templates.domain.Entity;
import nextgen.templates.java.PackageDeclaration;
import nextgen.templates.piccolo2d.*;
import nextgen.templates.text.Line;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;

import static nextgen.templates.DomainPatterns.newEnum;
import static nextgen.templates.DomainPatterns.*;
import static nextgen.templates.JavaPatterns.*;
import static nextgen.templates.Piccolo2DPatterns.*;
import static nextgen.templates.TextPatterns.*;

public class STProject {

    private final File root = new File("/home/goe/projects/nextgen/components/core");
    private final File javaMainSrc = new File(root, "src/main/java");
    private final File javaTestSrc = new File(root, "src/test/java");

    private final PackageDeclaration stPackage = newPackageDeclaration("nextgen.st");
    private final PackageDeclaration stDomainPackage = newPackageDeclaration(stPackage, "domain");
    private final PackageDeclaration stModelPackage = newPackageDeclaration(stPackage, "model");
    private final PackageDeclaration stModelNeoPackage = newPackageDeclaration(stModelPackage, "neo");
    private final PackageDeclaration stCanvasPackage = newPackageDeclaration(stPackage, "canvas");

    @Test
    public void generateCanvasPackage() {

        final String canvasName = "STCanvas";
        final String nodeName = "STNode";
        final String relationName = "STRelation";

        final PCanvas canvas = newPCanvas()
                .setName(canvasName)
                .setPackageName(stCanvasPackage.getName())
                .setNodeName(nodeName)
                .setRelationName(relationName)
                .addFields("nextgen.st.STRenderer", "stRenderer")
                .addFields("nextgen.st.model.STModelDB", "modelDb");

        final PNode node = newPNode()
                .setName(nodeName)
                .setCanvasName(canvas.getName())
                .setPackageName(stCanvasPackage.getName());

        final PRelation relation = newPRelation()
                .setName(relationName)
                .setNodeName(node.getName())
                .setCanvasName(canvas.getName())
                .setPackageName(stCanvasPackage.getName());

        final PNodeImpl stFileNode = newPNodeImpl(canvas, node)
                .setName("STFileNode")
                .setPackageName(stCanvasPackage.getName())
                .setNodeName("STNode")
                .addFields("nextgen.st.model.STFile", "stFile")
                .addFields("nextgen.st.model.STModel", "stModel")
                .addFields("nextgen.st.STRenderer", "stRenderer")
                .setInitText("nextgen.st.STGenerator.asFile(stFile).getAbsolutePath()")
                .setUuid("java.util.UUID.fromString(stFile.getUuid())")
                .addMethods(newNodeMethod()
                        .setName("setSTModel")
                        .addParams("stModel", "nextgen.st.model.STModel")
                        .addStatements(newInvokeLaterInTransaction(newBlock(
                                "this.stModel = stModel;",
                                "this.stModel.setFile(stFile);",
                                "setText(nextgen.st.STGenerator.asFile(stFile).getAbsolutePath());"
                        ))))
                .addOnLeftClick(newInvokeLaterInTransaction(
                        "if (stRenderer == null || stModel == null) return;",
                        "nextgen.st.STGenerator.writeToFile(stRenderer.render(stModel), stFile.getPackageName(), stFile.getName(), stFile.getType(), new java.io.File(stFile.getPath()));"))
                .addRightClickStatements(getSelectedSTModelNodes("stModelNodes"))
                .addRightClickStatements(newInvokeLaterInTransaction(
                        "final JMenu sourceMenu = new JMenu(\"STModels\");",
                        newLine("stModelNodes.forEach(stNode -> {", "});")
                                .addChildren("final int end = Math.min(stNode.getText().length(), 50);")
                                .addChildren(newLine("sourceMenu.add(", newAnonymousPNodeAction("STFileNode")
                                                .setHeader("\"Set source to \" + stNode.getText().substring(0, end)")
                                                .addStatements("node.setSTModel(stNode.stModel);")
                                        , ");")),
                        "pop.add(sourceMenu);"));

        final NodeAction editFileSinkAction = newNodeAction(stFileNode, "EditFileSink", "Edit")
                .addStatements("final Map<String, JTextField> fieldMap = new java.util.LinkedHashMap<>();")
                .addStatements("fieldMap.put(\"name\", new JTextField(node.stFile.getName(), 15));")
                .addStatements("fieldMap.put(\"type\", new JTextField(node.stFile.getType(), 15));")
                .addStatements("fieldMap.put(\"path\", new JTextField(node.stFile.getPath(), 15));")
                .addStatements("fieldMap.put(\"package\", new JTextField(node.stFile.getPackageName(), 15));")
                .addStatements("final JPanel inputPanel = new JPanel(new GridLayout(fieldMap.size(), 2));")
                .addStatements("inputPanel.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));")
                .addStatements(newLine("for (Map.Entry<String, JTextField> fieldEntry : fieldMap.entrySet()) {", "}")
                        .addChildren("inputPanel.add(new JLabel(fieldEntry.getKey()));")
                        .addChildren("inputPanel.add(fieldEntry.getValue());"))
                .addStatements(newBlock()
                        .addLines(newLine("com.generator.util.SwingUtil.showDialog(inputPanel, canvas, \"Edit\", new com.generator.util.SwingUtil.ConfirmAction() {", "});")
                                .addChildren("@Override")
                                .addChildren(newLine("public void verifyAndCommit() throws Exception {", "}")
                                        .addChildren("final String name = fieldMap.get(\"name\").getText().trim();")
                                        .addChildren("final String type = fieldMap.get(\"type\").getText().trim();")
                                        .addChildren("final String path = fieldMap.get(\"path\").getText().trim();")
                                        .addChildren("final String packageName = fieldMap.get(\"package\").getText().trim();")
                                        .addChildren(newInvokeLaterInTransaction(
                                                "node.stFile.setName(name);",
                                                "node.stFile.setType(type);",
                                                "node.stFile.setPath(path);",
                                                "node.stFile.setPackageName(packageName);",
                                                "node.setText(nextgen.st.STGenerator.asFile(node.stFile).getAbsolutePath());")))));
        registerRightClickAction(stFileNode, editFileSinkAction, editFileSinkAction.getName());

        final PNodeImpl stValueNode = newPNodeImpl(canvas, node)
                .setName("STValueNode")
                .setPackageName(stCanvasPackage.getName())
                .setNodeName("STNode")
                .addFields("nextgen.st.model.STValue", "stValue")
                .addFields("nextgen.st.STRenderer", "stRenderer")
                .setInitText("stRenderer.render(stValue)")
                .setUuid("java.util.UUID.fromString(stValue.getUuid())");

        final NodeAction stValueToClipboard = newNodeAction(stValueNode, "ToClipboard", "To Clipboard")
                .addStatements("com.generator.util.SwingUtil.toClipboard(node.stRenderer.render(node.stValue));");
        registerRightClickAction(stValueNode, stValueToClipboard, stValueToClipboard.getName());

        final PNodeImpl stModelNode = newPNodeImpl(canvas, node)
                .setPackageName(stCanvasPackage.getName())
                .setName("STModelNode")
                .addFields("nextgen.st.domain.STTemplate", "stTemplate")
                .addFields("nextgen.st.model.STModel", "stModel")
                .addFields("nextgen.st.STRenderer", "stRenderer")
                .setInitText("stRenderer.render(stModel)")
                .setUuid("java.util.UUID.fromString(stModel.getUuid())")
                .addMethods(newNodeMethod()
                        .setName("cut")
                        .addParams("text", "String")
                        .setType("String")
                        .setReturnStatement("text.substring(0, Math.min(text.length(), 20));"))
                .addOnLeftClick(doInTransactionSilent("setText(stRenderer.render(stModel));"))
                .addRightClickStatements(getSelectedSTValueNodes("stValueNodes"))
                .addRightClickStatements(getSelectedSTModelNodes("stModelNodes"))
                .addRightClickStatements(doInTransactionSilent()
                        .addChildren(newLine("stTemplate.getParameters().forEach(stParameter -> {", "});")
                                .addChildren("final JMenu stParameterMenu = new JMenu(stParameter.getName());")
                                .addChildren(newSwitch().setSelector("stParameter.getType()")
                                        .addCases("SINGLE", newBlock()
                                                .addLines(newLine("stParameterMenu.add(new SetInputValueArgumentAction(\"Set \" + stParameter.getName(), STModelNode.this, canvas, event, stParameter));"))
                                                .addLines(newLine("stValueNodes.forEach(stNode -> {", "});")
                                                        .addChildren(newLine("stParameterMenu.add(new SetSTValueArgumentAction(\"Set \" + stParameter.getName() + \" = \" + cut(stNode.getText()), STModelNode.this, canvas, event, stParameter, stNode.stValue));")))
                                                .addLines(newLine("stModelNodes.forEach(stNode -> {", "});")
                                                        .addChildren(newLine("stParameterMenu.add(new SetSTModelArgumentAction(\"Set \" + stParameter.getName() + \" = \" + cut(stNode.getText()), STModelNode.this, canvas, event, stParameter, stNode.stModel));"))))
                                        .addCases("LIST", newBlock()
                                                .addLines(newLine("stParameterMenu.add(new AddInputValueArgumentAction(\"Add \" + stParameter.getName(), STModelNode.this, canvas, event, stParameter));"))
                                                .addLines(newLine("stValueNodes.forEach(stNode -> {", "});")
                                                        .addChildren(newLine("stParameterMenu.add(new AddSTValueArgumentAction(\"Add \" + stParameter.getName() + \" = \" + cut(stNode.getText()), STModelNode.this, canvas, event, stParameter, stNode.stValue));")))
                                                .addLines(newLine("stModelNodes.forEach(stNode -> {", "});")
                                                        .addChildren(newLine("stParameterMenu.add(new AddSTModelArgumentAction(\"Add \" + stParameter.getName() + \" = \" + cut(stNode.getText()), STModelNode.this, canvas, event, stParameter, stNode.stModel));"))))
                                        .addCases("KVLIST", newBlock()
                                                .addLines(newLine("stParameterMenu.add(new AddKVInputValueArgumentAction(\"Add \" + stParameter.getName(), STModelNode.this, canvas, event, stParameter));"))))
                                .addChildren("if (stParameterMenu.getMenuComponentCount() != 0) pop.add(stParameterMenu);"))
                        .addChildren("final JMenu open = new JMenu(\"Open\");")
                        .addChildren("final JMenu remove = new JMenu(\"Remove\");")
                        .addChildren(newLine("stModel.getArguments().forEach(stArgument -> {", "});")
                                .addChildren("open.add(new OpenArgument(STModelNode.this, canvas, event, stArgument));")
                                .addChildren("remove.add(new RemoveArgument(STModelNode.this, canvas, event, stArgument));"))
                        .addChildren("if (open.getMenuComponentCount() != 0) pop.add(open);")
                        .addChildren("if (remove.getMenuComponentCount() != 0) pop.add(remove);"));

        stModelNode.addActions(newNodeAction(stModelNode, "SetInputValueArgumentAction", "Set")
                .addFields("nextgen.st.domain.STParameter", "stParameter")
                .setTitleExpression(true)
                .addStatements("final String s = SwingUtil.showInputDialog(stParameter.getName(), canvas);")
                .addStatements("if (s == null || s.trim().length() == 0) return;")
                .addStatements(newInvokeLaterInTransaction(
                        "final nextgen.st.model.STValue stValue = canvas.modelDb.newSTValue(s.trim());",
                        "canvas.modelDb.setArgument(node.stModel, stParameter, stValue);",
                        "node.setText(node.stRenderer.render(node.stModel));"
                )));

        stModelNode.addActions(newNodeAction(stModelNode, "SetSTValueArgumentAction", "Set")
                .addFields("nextgen.st.domain.STParameter", "stParameter")
                .addFields("nextgen.st.model.STValue", "stValue")
                .setTitleExpression(true)
                .addStatements(newInvokeLaterInTransaction(
                        "canvas.modelDb.setArgument(node.stModel, stParameter, stValue);",
                        "node.setText(node.stRenderer.render(node.stModel));"
                )));

        stModelNode.addActions(newNodeAction(stModelNode, "SetSTModelArgumentAction", "Set")
                .addFields("nextgen.st.domain.STParameter", "stParameter")
                .addFields("nextgen.st.model.STModel", "stModel")
                .setTitleExpression(true)
                .addStatements(newInvokeLaterInTransaction(
                        "canvas.modelDb.setArgument(node.stModel, stParameter, stModel);",
                        "node.setText(node.stRenderer.render(node.stModel));"
                )));

        stModelNode.addActions(newNodeAction(stModelNode, "AddInputValueArgumentAction", "Add")
                .addFields("nextgen.st.domain.STParameter", "stParameter")
                .setTitleExpression(true)
                .addStatements("final String s = SwingUtil.showInputDialog(stParameter.getName(), canvas);")
                .addStatements("if (s == null || s.trim().length() == 0) return;")
                .addStatements(newInvokeLaterInTransaction(
                        "final nextgen.st.model.STValue stValue = canvas.modelDb.newSTValue(s.trim());",
                        "canvas.modelDb.addArgument(node.stModel, stParameter, stValue);",
                        "node.setText(node.stRenderer.render(node.stModel));"
                )));

        stModelNode.addActions(newNodeAction(stModelNode, "AddSTValueArgumentAction", "Add")
                .addFields("nextgen.st.domain.STParameter", "stParameter")
                .addFields("nextgen.st.model.STValue", "stValue")
                .setTitleExpression(true)
                .addStatements(newInvokeLaterInTransaction(
                        "canvas.modelDb.addArgument(node.stModel, stParameter, stValue);",
                        "node.setText(node.stRenderer.render(node.stModel));"
                )));

        stModelNode.addActions(newNodeAction(stModelNode, "AddSTModelArgumentAction", "Add")
                .addFields("nextgen.st.domain.STParameter", "stParameter")
                .addFields("nextgen.st.model.STModel", "stModel")
                .setTitleExpression(true)
                .addStatements(newInvokeLaterInTransaction(
                        "canvas.modelDb.addArgument(node.stModel, stParameter, stModel);",
                        "node.setText(node.stRenderer.render(node.stModel));"
                )));

        stModelNode.addActions(newNodeAction(stModelNode, "AddKVInputValueArgumentAction", "Add")
                .addFields("nextgen.st.domain.STParameter", "stParameter")
                .setTitleExpression(true)
                .addStatements("final Map<STParameterKey, JTextField> fieldMap = new LinkedHashMap<>();")
                .addStatements(newInvokeLaterInTransaction(newBlock()
                        .addLines(newLine("stParameter.getKeys().forEach(stParameterKey -> ", "fieldMap.put(stParameterKey, new JTextField(15))", ");"))
                        .addLines("final JPanel inputPanel = new JPanel(new GridLayout(fieldMap.size(), 2));")
                        .addLines("inputPanel.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));")
                        .addLines(newLine("for (Map.Entry<STParameterKey, JTextField> fieldEntry : fieldMap.entrySet()) {", "}")
                                .addChildren("inputPanel.add(new JLabel(fieldEntry.getKey().getName()));")
                                .addChildren("inputPanel.add(fieldEntry.getValue());"))
                        .addLines(newBlock()
                                .addLines(newLine("SwingUtil.showDialog(inputPanel, canvas, stParameter.getName(), new SwingUtil.ConfirmAction() {", "});")
                                        .addChildren("@Override")
                                        .addChildren(newLine("public void verifyAndCommit() throws Exception {", "}")
                                                .addChildren("final Collection<STArgumentKV> kvs = new ArrayList<>();")
                                                .addChildren(newLine("for (Map.Entry<STParameterKey, JTextField> fieldEntry : fieldMap.entrySet()) {", "}")
                                                        .addChildren("final String value = fieldEntry.getValue().getText().trim();")
                                                        .addChildren("if (value.length() == 0) continue;")
                                                        .addChildren("kvs.add(canvas.modelDb.newSTArgumentKV(fieldEntry.getKey(),canvas.modelDb.newSTValue(value)));"))
                                                .addChildren("canvas.modelDb.addArgument(node.stModel, stParameter, kvs);")
                                                .addChildren("node.setText(node.stRenderer.render(node.stModel));"))))
                )));

        final NodeAction openSTArgument = newNodeAction(stModelNode, "OpenArgument", "Open")
                .addFields("nextgen.st.model.STArgument", "stArgument")
                .addConstructorStatements("final String s = node.stRenderer.render(stArgument).toString();")
                .addConstructorStatements("final int end = Math.min(s.length(), 50);")
                .addConstructorStatements("setName(\"Open \" + s.substring(0, end));")
                .addStatements(newInvokeLaterInTransaction(
                        "final STValue stValue = stArgument.getValue();",
                        JavaPatterns.newSwitch()
                                .setSelector("stValue.getType()")
                                .addCases("STMODEL", newBlock(
                                        "final nextgen.st.model.STModel stModel = stValue.getStModel();",
                                        "canvas.addNode(new STModelNode(canvas, canvas.modelDb.findSTTemplateByUuid(stModel.getStTemplate()), stModel, node.stRenderer));"
                                ))
                                .addCases("PRIMITIVE", "canvas.addNode(new STValueNode(canvas, stValue, node.stRenderer));")
                                .addCases("ENUM", "canvas.addNode(new STValueNode(canvas, stValue, node.stRenderer));")));
        stModelNode.addActions(openSTArgument);

        final NodeAction removeSTArgument = newNodeAction(stModelNode, "RemoveArgument", "Remove")
                .addFields("nextgen.st.model.STArgument", "stArgument")
                .addConstructorStatements("final String s = node.stRenderer.render(stArgument).toString();")
                .addConstructorStatements("final int end = Math.min(s.length(), 50);")
                .addConstructorStatements("setName(\"Remove \" + s.substring(0, end));")
                .addStatements(newInvokeLaterInTransaction(
                        "node.stModel.removeArguments(stArgument);",
                        "node.setText(node.stRenderer.render(node.stModel));"));
        stModelNode.addActions(removeSTArgument);

        final NodeAction stModelToClipboard = newNodeAction(stModelNode, "ToClipboard", "To Clipboard")
                .addStatements(newInvokeLaterInTransaction("com.generator.util.SwingUtil.toClipboard(node.stRenderer.render(node.stModel));"));
        registerRightClickAction(stModelNode, stModelToClipboard, stModelToClipboard.getName());

        final NodeAction deleteSTModel = newNodeAction(stModelNode, "Delete", "Delete")
                .addStatements(newInvokeLaterInTransaction(
                        "canvas.modelDb.remove(node.stModel);",
                        "canvas.removeNode(node.getUuid());"));
        registerRightClickAction(stModelNode, deleteSTModel, deleteSTModel.getName());

        final NodeAction addFileSink = newNodeAction(stModelNode, "AddFileSink", "Add File Sink")
                .addStatements(doInTransaction(newBlock(
                        "final Map<String, JTextField> fieldMap = new java.util.LinkedHashMap<>();",
                        "fieldMap.put(\"name\", new JTextField(canvas.modelDb.getSTModelName(node.stModel, \"\"), 15));",
                        "fieldMap.put(\"type\", new JTextField(15));",
                        "fieldMap.put(\"path\", new JTextField(15));",
                        "fieldMap.put(\"package\", new JTextField(canvas.modelDb.getSTModelPackage(node.stModel, \"\"), 15));",
                        "final JPanel inputPanel = new JPanel(new GridLayout(fieldMap.size(), 2));",
                        "inputPanel.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));",
                        newForEachStmt()
                                .setVariable("Map.Entry<String, JTextField> fieldEntry")
                                .setIterable("fieldMap.entrySet()")
                                .setBody(newBlockStmt()
                                        .addStatements("inputPanel.add(new JLabel(fieldEntry.getKey()));")
                                        .addStatements("inputPanel.add(fieldEntry.getValue());")),
                        newBlock()
                                .addLines(newLine("com.generator.util.SwingUtil.showDialog(inputPanel, canvas, \"New File sink\", new com.generator.util.SwingUtil.ConfirmAction() {", "});")
                                        .addChildren("@Override")
                                        .addChildren(newLine("public void verifyAndCommit() throws Exception {", "}")
                                                .addChildren("final String name = fieldMap.get(\"name\").getText().trim();")
                                                .addChildren("final String type = fieldMap.get(\"type\").getText().trim();")
                                                .addChildren("final String path = fieldMap.get(\"path\").getText().trim();")
                                                .addChildren("final String packageName = fieldMap.get(\"package\").getText().trim();")
                                                .addChildren(newInvokeLaterInTransaction(
                                                        "final nextgen.st.model.STFile stFile = canvas.modelDb.newSTFile(name, type, path, packageName);",
                                                        "node.stModel.setFile(stFile);",
                                                        "canvas.addNode(new STFileNode(canvas, stFile, node.stModel, node.stRenderer));"
                                                ))))
                )));
        registerRightClickAction(stModelNode, addFileSink, addFileSink.getName());

        final NodeAction openFileSInk = newNodeAction(stModelNode, "OpenFileSink", "Open File Sink")
                .addStatements(newInvokeLaterInTransaction(
                        "final nextgen.st.model.STFile stFile = node.stModel.getFile();",
                        "if (stFile == null) return;",
                        "canvas.addNode(new STFileNode(canvas, stFile, node.stModel, node.stRenderer));"
                ));

        registerRightClickAction(stModelNode, openFileSInk, openFileSInk.getName());

        final NodeAction openFile = newNodeAction(stFileNode, "OpenFile", "Open")
                .addStatements(newInvokeLaterInTransaction(newLine("try {", "} catch (Exception ex) { com.generator.util.SwingUtil.showException(canvas, ex); }")
                        .addChildren("java.awt.Desktop.getDesktop().open(nextgen.st.STGenerator.asFile(node.stFile));")));
        registerRightClickAction(stFileNode, openFile, openFile.getName());

        final CanvasAction newSTNodeAction = newCanvasAction(canvas, "NewSTValueNode", "New Value")
                .addStatements("final String s = com.generator.util.SwingUtil.showInputDialog(\"Value\", canvas);\n" +
                        "if (s == null || s.trim().length() == 0) return;")
                .addStatements(newInvokeLaterInTransaction(
                        "canvas.addNode(new STValueNode(canvas, canvas.modelDb.newSTValue(s), canvas.stRenderer));"
                ));
        registerRightClickAction(canvas, newSTNodeAction, newSTNodeAction.getName());


        final CanvasAction loadAllAction = newCanvasAction(canvas, "LoadAllModels", "Load All Models")
                .addStatements(newInvokeLaterInTransaction(newLine("canvas.modelDb.findAllSTModel().forEach(stModel -> ", ");")
                        .addChildren("canvas.addNode(new STModelNode(canvas, canvas.modelDb.findSTTemplateByUuid(stModel.getStTemplate()), stModel, canvas.stRenderer))")));
        registerRightClickAction(canvas, loadAllAction, loadAllAction.getName());

        final CanvasAction newSTValueFromClipboard = newCanvasAction(canvas, "NewSTValueFromClipboard", "New Value from Clipboard")
                .addStatements("final String s = com.generator.util.SwingUtil.fromClipboard();")
                .addStatements("if (s == null || s.trim().length() == 0) return;")
                .addStatements(newInvokeLaterInTransaction(
                        "final nextgen.st.model.STValue stValue = canvas.modelDb.newSTValue(s);",
                        "canvas.addNode(new STValueNode(canvas, stValue, canvas.stRenderer));"));
        registerRightClickAction(canvas, newSTValueFromClipboard, newSTValueFromClipboard.getName());

        final CanvasAction newSTFileNode = newCanvasAction(canvas, "NewSTFileNode", "New Sink")
                .addStatements("final Map<String, JTextField> fieldMap = new java.util.LinkedHashMap<>();")
                .addStatements("fieldMap.put(\"name\", new JTextField(15));")
                .addStatements("fieldMap.put(\"type\", new JTextField(15));")
                .addStatements("fieldMap.put(\"path\", new JTextField(15));")
                .addStatements("fieldMap.put(\"package\", new JTextField(15));")
                .addStatements("final JPanel inputPanel = new JPanel(new GridLayout(fieldMap.size(), 2));")
                .addStatements("inputPanel.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));")
                .addStatements(newLine("for (Map.Entry<String, JTextField> fieldEntry : fieldMap.entrySet()) {", "}")
                        .addChildren("inputPanel.add(new JLabel(fieldEntry.getKey()));")
                        .addChildren("inputPanel.add(fieldEntry.getValue());"))
                .addStatements(newBlock()
                        .addLines(newLine("com.generator.util.SwingUtil.showDialog(inputPanel, canvas, \"New sink\", new com.generator.util.SwingUtil.ConfirmAction() {", "});")
                                .addChildren("@Override")
                                .addChildren(newLine("public void verifyAndCommit() throws Exception {", "}")
                                        .addChildren("final String name = fieldMap.get(\"name\").getText().trim();")
                                        .addChildren("final String type = fieldMap.get(\"type\").getText().trim();")
                                        .addChildren("final String path = fieldMap.get(\"path\").getText().trim();")
                                        .addChildren("final String packageName = fieldMap.get(\"package\").getText().trim();")
                                        .addChildren(newInvokeLaterInTransaction(
                                                "final nextgen.st.model.STFile stFile = canvas.modelDb.newSTFile(name, type, path, packageName);",
                                                "canvas.addNode(new STFileNode(canvas, stFile, null, null));"
                                        )))));
        registerRightClickAction(canvas, newSTFileNode, newSTFileNode.getName());

        final NodeAction editSTValue = newNodeAction(stValueNode, "EditSTValue", "Edit")
                .addStatements("final JTextArea textArea = new JTextArea(15,40);")
                .addStatements("textArea.setText(node.stValue.getValue().toString());")
                .addStatements("final JPanel inputPanel = new JPanel(new BorderLayout());")
                .addStatements("inputPanel.add(textArea, BorderLayout.CENTER);")
                .addStatements("inputPanel.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));")
                .addStatements(newBlock()
                        .addLines(newLine("com.generator.util.SwingUtil.showDialog(inputPanel, canvas, \"Edit\", new com.generator.util.SwingUtil.ConfirmAction() {", "});")
                                .addChildren("@Override")
                                .addChildren(newLine("public void verifyAndCommit() throws Exception {", "}")
                                        .addChildren("final String s = textArea.getText().trim();")
                                        .addChildren(newInvokeLaterInTransaction(
                                                "node.stValue.setValue(s);",
                                                "node.setText(node.stValue.getValue().toString());"
                                        )))));
        registerRightClickAction(stValueNode, editSTValue, editSTValue.getName());


        Piccolo2DPatterns.addDefaultActionsToCanvas(canvas);
        Piccolo2DPatterns.addDefaultActionsToNode(node);

        STGenerator.writeJavaFile(canvas, stCanvasPackage, canvas.getName(), javaMainSrc);
        STGenerator.writeJavaFile(node, stCanvasPackage, node.getName(), javaMainSrc);
        STGenerator.writeJavaFile(relation, stCanvasPackage, relation.getName(), javaMainSrc);

        STGenerator.writeJavaFile(stFileNode, stCanvasPackage, stFileNode.getName(), javaMainSrc);
        STGenerator.writeJavaFile(stValueNode, stCanvasPackage, stValueNode.getName(), javaMainSrc);
        STGenerator.writeJavaFile(stModelNode, stCanvasPackage, stModelNode.getName(), javaMainSrc);
    }

    private Object newInvokeLaterInTransaction(Object... statements) {
        return newInvokeLater(newLine("canvas.modelDb.doInTransaction(tx -> {", Arrays.asList(statements), "}, throwable -> com.generator.util.SwingUtil.showExceptionNoStack(canvas, throwable))"));
    }

    private Line doInTransaction(Object... statements) {
        return newLine("canvas.modelDb.doInTransaction(tx -> {", Arrays.asList(statements), "}, throwable -> com.generator.util.SwingUtil.showExceptionNoStack(canvas, throwable));");
    }

    private Line doInTransactionSilent(Object... statements) {
        return newLine("canvas.modelDb.doInTransaction(tx -> {", Arrays.asList(statements), "});");
    }

    public Line getSelectedSTValueNodes(String name) {
        return newLineIndent(
                "final java.util.List<STValueNode> " + name + " = canvas.getSelectedNodes()",
                "\t",
                ".filter(stNode -> stNode instanceof STValueNode)",
                ".filter(stNode -> !stNode.getUuid().equals(getUuid()))",
                ".map(stNode -> (STValueNode) stNode)",
                ".collect(Collectors.toList());");
    }

    public Line getSelectedSTModelNodes(String name) {
        return newLineIndent(
                "final java.util.List<STModelNode> " + name + " = canvas.getSelectedNodes()",
                "\t",
                ".filter(stNode -> stNode instanceof STModelNode)",
                ".filter(stNode -> !stNode.getUuid().equals(getUuid()))",
                ".map(stNode -> (STModelNode) stNode)",
                ".collect(Collectors.toList());");
    }

    @Test
    public void generateModellingDomain() {

        final Entity stValueNeo = newEntity("STValue")
                .addRelations(newStringField("uuid"))
                .addRelations(newStringField("value"))
                .addRelations(newEnumField("type", newEnum("STValueType", "STMODEL,PRIMITIVE,ENUM")));

        final Entity stModelNeo = newEntity("STModel")
                .addRelations(newStringField("uuid"))
                .addRelations(newStringField("stTemplate"))
                .addRelations(newOneToOne("file", newEntity("STFile")
                        .addRelations(newStringField("uuid"))
                        .addRelations(newStringField("name"))
                        .addRelations(newStringField("type"))
                        .addRelations(newStringField("packageName"))
                        .addRelations(newStringField("path"))))
                .addRelations(newOneToMany("arguments", newEntity("STArgument")
                        .addRelations(newStringField("uuid"))
                        .addRelations(newStringField("stParameter"))
                        .addRelations(newOneToOne("value", stValueNeo))
                        .addRelations(newOneToMany("keyValues", newEntity("STArgumentKV")
                                .addRelations(newStringField("uuid"))
                                .addRelations(newStringField("stParameterKey"))
                                .addRelations(newOneToOne("value", stValueNeo))))));

        stValueNeo.addRelations(newOneToOne("stModel", stModelNeo));

        writeNeo(javaMainSrc, stModelPackage.getName(), newDomain("STModel")
                .addEntities(stModelNeo));
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
                        .addRelations(newStringField("modelDb"))
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