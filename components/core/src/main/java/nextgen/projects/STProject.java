package nextgen.projects;

import nextgen.st.STGenerator;
import nextgen.templates.JavaPatterns;
import nextgen.templates.Piccolo2DPatterns;
import nextgen.templates.domain.Domain;
import nextgen.templates.domain.Entity;
import nextgen.templates.java.PackageDeclaration;
import nextgen.templates.piccolo2d.*;
import org.junit.Test;

import java.io.File;

import static nextgen.templates.DomainPatterns.*;
import static nextgen.templates.Piccolo2DPatterns.*;
import static nextgen.templates.TextPatterns.*;
import static nextgen.templates.JavaPatterns.*;

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
                .addFields("nextgen.st.model.neo.STModelDB", "modelDb");

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
                .addMethods(newNodeMethod()
                        .setName("setSTModel")
                        .addParams("stModel", "nextgen.st.model.STModel")
                        .addStatements(newLine("if (this.stModel != null)", "")
                                .addChildren("this.stModel.removePropertyChangeListener(this);"))
                        .addStatements("this.stModel = stModel;")
                        .addStatements("this.stModel.addPropertyChangeListener(this);")
                        .addStatements("this.stModel.setFile(stFile);")
                        .addStatements("setText(nextgen.st.STGenerator.asFile(stFile).getAbsolutePath());")
                )
                .addOnLeftClick("if (stRenderer == null || stModel == null) return;")
                .addOnLeftClick("nextgen.st.STGenerator.writeToFile(stRenderer.render(stModel), stFile.getPackageName(), stFile.getName(), stFile.getType(), new java.io.File(stFile.getPath()));")
                .addRightClickStatements(newLineIndent(
                        "final java.util.List<STModelNode> stModelNodes = canvas.getSelectedNodes()",
                        "\t",
                        ".filter(stNode -> stNode instanceof STModelNode)",
                        ".filter(stNode -> !stNode.getUuid().equals(getUuid()))",
                        ".map(stNode -> (STModelNode) stNode)",
                        ".collect(Collectors.toList());"))
                .addRightClickStatements(newBlock(
                        "final JMenu sourceMenu = new JMenu(\"STModels\");",
                        newLine("stModelNodes.forEach(stNode -> {", "});")
                                .addChildren("final int end = Math.min(stNode.getText().length(), 50);")
                                .addChildren(newLine("sourceMenu.add(", newAnonymousPNodeAction("STFileNode")
                                                .setHeader("\"Set source to \" + stNode.getText().substring(0, end)")
                                                .addStatements("node.setSTModel(stNode.stModel);")
                                        , ");")),
                        "pop.add(sourceMenu);"))
                .addConstructorStatements(newLine("if (this.stModel != null)")
                        .addChildren("this.stModel.addPropertyChangeListener(this);"))
                .addOnPropertyChange(newBlock(
                        "final Object source = evt.getSource();",
                        "System.out.println(\"Event :\" + source.getClass().getCanonicalName());",
                        newLine("if (source instanceof nextgen.st.model.STModel) {", "}")
                                .addChildren("final nextgen.st.model.STModel stModel = (nextgen.st.model.STModel) source;")
                                .addChildren("this.stFile.setName(nextgen.st.STModelPatterns.getSTModelValue(stModel, \"name\", this.stFile.getName()));")
                                .addChildren("this.stFile.setPackageName(nextgen.st.STModelPatterns.getSTModelPackage(stModel, this.stFile.getPackageName()));")));

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
                                        .addChildren(newInvokeLater(
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
                .addFields("nextgen.st.STRenderer", "stRenderer");

        final NodeAction stValueToClipboard = newNodeAction(stValueNode, "ToClipboard", "To Clipboard")
                .addStatements("com.generator.util.SwingUtil.toClipboard(node.stRenderer.render(node.stValue));");
        registerRightClickAction(stValueNode, stValueToClipboard, stValueToClipboard.getName());


        final PNodeImpl stModelNode = newPNodeImpl(canvas, node)
                .setPackageName(stCanvasPackage.getName())
                .setName("STModelNode")
                .addFields("nextgen.st.domain.STTemplate", "stTemplate")
                .addFields("nextgen.st.model.STModel", "stModel")
                .addFields("nextgen.st.STRenderer", "stRenderer")
                .addConstructorStatements(newLine("if (this.stModel != null)")
                        .addChildren("this.stModel.addPropertyChangeListener(this);"))
                .addOnPropertyChange("setText(stRenderer.render(stModel));")
                .addOnLeftClick("setText(stRenderer.render(stModel));")
                .addRightClickStatements(newLine(
                        "final java.util.List<STValueNode> stValueNodes = canvas.getSelectedNodes()",
                        ".filter(stNode -> stNode instanceof STValueNode)",
                        ".filter(stNode -> !stNode.getUuid().equals(getUuid()))",
                        ".map(stNode -> (STValueNode) stNode)",
                        ".collect(Collectors.toList());"))
                .addRightClickStatements(newLine(
                        "final java.util.List<STModelNode> stModelNodes = canvas.getSelectedNodes()",
                        ".filter(stNode -> stNode instanceof STModelNode)",
                        ".filter(stNode -> !stNode.getUuid().equals(getUuid()))",
                        ".map(stNode -> (STModelNode) stNode)",
                        ".collect(Collectors.toList());"))
                .addRightClickStatements(newLine("stTemplate.getParameters().forEach(stParameter -> {", "});")
                        .addChildren("final JMenu stParameterMenu = new JMenu(stParameter.getName());")
                        .addChildren(newSwitch().setSelector("stParameter.getType()")
                                .addCases("SINGLE", newBlock()
                                        .addLines(newLine("stParameterMenu.add(", Piccolo2DPatterns.newAnonymousPNodeAction("STModelNode")
                                                        .setHeader("\"Set \" + stParameter.getName()")
                                                        .addStatements("final String s = SwingUtil.showInputDialog(stParameter.getName(), canvas);")
                                                        .addStatements("if (s == null || s.trim().length() == 0) return;")
                                                        .addStatements("final nextgen.st.model.STValue stValue = newSTValue(s.trim());")
                                                        .addStatements("setArgument(stTemplate, stModel, newSTArgument(stParameter, stValue));")
                                                        .addStatements("setText(stRenderer.render(stModel));")
                                                , ");"))
                                        .addLines(newLine("stValueNodes.forEach(stNode -> {", "});")
                                                .addChildren("final int end = Math.min(stNode.getText().length(), 50);")
                                                .addChildren(newLine("stParameterMenu.add(", newAnonymousPNodeAction("STModelNode")
                                                                .setHeader("\"Set \" + stParameter.getName() + \" = \" + stNode.getText().substring(0, end)")
                                                                .addStatements("setArgument(stTemplate, stModel, newSTArgument(stParameter, stNode.stValue));")
                                                                .addStatements("setText(stRenderer.render(stModel));")
                                                        , ");")))
                                        .addLines(newLine("stModelNodes.forEach(stNode -> {", "});")
                                                .addChildren("final int end = Math.min(stNode.getText().length(), 50);")
                                                .addChildren(newLine("stParameterMenu.add(", newAnonymousPNodeAction("STModelNode")
                                                                .setHeader("\"Set \" + stParameter.getName() + \" = \" + stNode.getText().substring(0, end)")
                                                                .addStatements("setArgument(stTemplate, stModel, newSTArgument(stParameter, newSTValue(stNode.stModel)));")
                                                                .addStatements("setText(stRenderer.render(stModel));")
                                                        , ");"))))
                                .addCases("LIST", newBlock()
                                        .addLines(newLine("stParameterMenu.add(", newAnonymousPNodeAction("STModelNode")
                                                        .setHeader("\"Add \" + stParameter.getName()")
                                                        .addStatements("final String s = SwingUtil.showInputDialog(stParameter.getName(), canvas);")
                                                        .addStatements("if (s == null || s.trim().length() == 0) return;")
                                                        .addStatements("final nextgen.st.model.STValue stValue = newSTValue(s.trim());")
                                                        .addStatements("canvas.addNode(new STValueNode(canvas, s, stValue.getUuid(), stValue, node.stRenderer));")
                                                        .addStatements("addArgument(stTemplate, stModel, newSTArgument(stParameter, stValue));")
                                                        .addStatements("setText(stRenderer.render(stModel));")
                                                , ");"))
                                        .addLines(newLine("stValueNodes.forEach(stNode -> {", "});")
                                                .addChildren("final int end = Math.min(stNode.getText().length(), 50);")
                                                .addChildren(newLine("stParameterMenu.add(", newAnonymousPNodeAction("STModelNode")
                                                                .setHeader("\"Add \" + stParameter.getName() + \" = \" + stNode.getText().substring(0, end)")
                                                                .addStatements("addArgument(stTemplate, stModel, newSTArgument(stParameter, stNode.stValue));")
                                                                .addStatements("setText(stRenderer.render(stModel));")
                                                        , ");")))
                                        .addLines(newLine("stModelNodes.forEach(stNode -> {", "});")
                                                .addChildren("final int end = Math.min(stNode.getText().length(), 50);")
                                                .addChildren(newLine("stParameterMenu.add(", newAnonymousPNodeAction("STModelNode")
                                                                .setHeader("\"Add \" + stParameter.getName() + \" = \" + stNode.getText().substring(0, end)")
                                                                .addStatements("addArgument(stTemplate, stModel, newSTArgument(stParameter, newSTValue(stNode.stModel)));")
                                                                .addStatements("setText(stRenderer.render(stModel));")
                                                        , ");")))
                                )
                                .addCases("KVLIST", newBlock()
                                        .addLines(newLine("stParameterMenu.add(", newAnonymousPNodeAction("STModelNode")
                                                .setHeader("\"Add \" + stParameter.getName()")
                                                .addStatements(newBlock()
                                                        .addLines("final Map<STParameterKey, JTextField> fieldMap = new LinkedHashMap<>();")
                                                        .addLines(newLine("stParameter.getKeys().forEach(stParameterKey -> ", "fieldMap.put(stParameterKey, new JTextField(15))", ");")))
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
                                                                                .addChildren("final String value = fieldEntry.getValue().getText().trim();")
                                                                                .addChildren("if (value.length() == 0) continue;")
                                                                                .addChildren("kvs.add(new STArgumentKV().setStParameterKey(fieldEntry.getKey()).setValue(newSTValue(value)));"))
                                                                        .addChildren("addArgument(stTemplate, stModel,  newSTArgument(stParameter, kvs));")
                                                                        .addChildren("setText(stRenderer.render(stModel));")))), ");"))
                                ))
                        .addChildren("pop.add(stParameterMenu);"))
                .addRightClickStatements("final JMenu open = new JMenu(\"Open\");")
                .addRightClickStatements(newLine("stModel.getArguments().forEach(stArgument -> {", "});")
                        .addChildren("final String s = stRenderer.render(stArgument).toString();")
                        .addChildren("final int end = Math.min(s.length(), 50);")
                        .addChildren(newLine("open.add(new STNode.NodeAction<STModelNode>(\"Open \" + s.substring(0, end), this, canvas, event) {", "});")
                                .addChildren("@Override")
                                .addChildren(newLine("void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {", "}")
                                        .addChildren(newInvokeLater(
                                                "final STValue stValue = stArgument.getValue();",
                                                JavaPatterns.newSwitch()
                                                        .setSelector("stValue.getType()")
                                                        .addCases("STMODEL", newBlock(
                                                                "final nextgen.st.model.STModel stModel = stValue.getStModel();",
                                                                "canvas.addNode(new STModelNode(canvas, stRenderer.render(stModel), stModel.getUuid(), stModel.getStTemplate(), stModel, node.stRenderer));"
                                                        ))
                                                        .addCases("PRIMITIVE", "canvas.addNode(new STValueNode(canvas, stRenderer.render(stValue), stValue.getUuid(), stValue, node.stRenderer));")
                                                        .addCases("ENUM", "canvas.addNode(new STValueNode(canvas, stRenderer.render(stValue), stValue.getUuid(), stValue, node.stRenderer));")

                                        )))))
                .addRightClickStatements("if (open.getMenuComponentCount() != 0) pop.add(open);")

                .addRightClickStatements("final JMenu remove = new JMenu(\"Remove\");")
                .addRightClickStatements(newLine("stModel.getArguments().forEach(stArgument -> {", "});")
                        .addChildren("final String s = stRenderer.render(stArgument).toString();")
                        .addChildren("final int end = Math.min(s.length(), 50);")
                        .addChildren(newLine("remove.add(new STNode.NodeAction<STModelNode>(\"Remove \" + s.substring(0, end), this, canvas, event) {", "});")
                                .addChildren("@Override")
                                .addChildren(newLine("void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {", "}")
                                        .addChildren("stModel.removeArguments(stArgument);")
                                        .addChildren("setText(stRenderer.render(stModel));"))))
                .addRightClickStatements("if (remove.getMenuComponentCount() != 0) pop.add(remove);");

        final NodeAction stModelToClipboard = newNodeAction(stModelNode, "ToClipboard", "To Clipboard")
                .addStatements("com.generator.util.SwingUtil.toClipboard(node.stRenderer.render(node.stModel));");
        registerRightClickAction(stModelNode, stModelToClipboard, stModelToClipboard.getName());

        final NodeAction deleteSTModel = newNodeAction(stModelNode, "Delete", "Delete")
                .addStatements(newInvokeLater(
                        newLine("canvas.modelDb.doInTransaction(tx -> {", "})")
                                .addChildren("canvas.modelDb.remove(node.stModel);")
                                .addChildren("canvas.removeNode(node.getUuid());")));
        registerRightClickAction(stModelNode, deleteSTModel, deleteSTModel.getName());

        final NodeAction addFileSink = newNodeAction(stModelNode, "AddFileSink", "Add File Sink")
                .addStatements("final Map<String, JTextField> fieldMap = new java.util.LinkedHashMap<>();")
                .addStatements("fieldMap.put(\"name\", new JTextField(getSTModelValue(node.stModel, \"name\", \"\"), 15));")
                .addStatements("fieldMap.put(\"type\", new JTextField(15));")
                .addStatements("fieldMap.put(\"path\", new JTextField(15));")
                .addStatements("fieldMap.put(\"package\", new JTextField(getSTModelPackage(node.stModel, \"\"), 15));")
                .addStatements("final JPanel inputPanel = new JPanel(new GridLayout(fieldMap.size(), 2));")
                .addStatements("inputPanel.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));")
                .addStatements(newForEachStmt()
                        .setVariable("Map.Entry<String, JTextField> fieldEntry")
                        .setIterable("fieldMap.entrySet()")
                        .setBody(newBlockStmt()
                                .addStatements("inputPanel.add(new JLabel(fieldEntry.getKey()));")
                                .addStatements("inputPanel.add(fieldEntry.getValue());")))
                .addStatements(newBlock()
                        .addLines(newLine("com.generator.util.SwingUtil.showDialog(inputPanel, canvas, \"New File sink\", new com.generator.util.SwingUtil.ConfirmAction() {", "});")
                                .addChildren("@Override")
                                .addChildren(newLine("public void verifyAndCommit() throws Exception {", "}")
                                        .addChildren("final String name = fieldMap.get(\"name\").getText().trim();")
                                        .addChildren("final String type = fieldMap.get(\"type\").getText().trim();")
                                        .addChildren("final String path = fieldMap.get(\"path\").getText().trim();")
                                        .addChildren("final String packageName = fieldMap.get(\"package\").getText().trim();")
                                        .addChildren(newInvokeLater(
                                                "final nextgen.st.model.STFile stFile = newSTFile(name, type, path, packageName);",
                                                "node.stModel.setFile(stFile);",
                                                "canvas.addNode(new STFileNode(canvas, nextgen.st.STGenerator.asFile(stFile).getAbsolutePath(), stFile.getUuid(), stFile, node.stModel, node.stRenderer));"
                                        )))));
        registerRightClickAction(stModelNode, addFileSink, addFileSink.getName());

        final NodeAction openFileSInk = newNodeAction(stModelNode, "OpenFileSink", "Open File Sink")
                .addStatements(newInvokeLater(
                        "final nextgen.st.model.STFile stFile = node.stModel.getFile();",
                        "if (stFile == null) return;",
                        "canvas.addNode(new STFileNode(canvas, nextgen.st.STGenerator.asFile(stFile).getAbsolutePath(), stFile.getUuid(), stFile, node.stModel, node.stRenderer));"
                ));

        registerRightClickAction(stModelNode, openFileSInk, openFileSInk.getName());

        final NodeAction openFile = newNodeAction(stFileNode, "OpenFile", "Open")
                .addStatements(newLine("try {", "} catch (Exception ex) { com.generator.util.SwingUtil.showException(canvas, ex); }")
                        .addChildren("java.awt.Desktop.getDesktop().open(nextgen.st.STGenerator.asFile(node.stFile));"));
        registerRightClickAction(stFileNode, openFile, openFile.getName());

        final CanvasAction newSTNodeAction = newCanvasAction(canvas, "NewSTValueNode", "New Value")
                .addStatements("final String s = com.generator.util.SwingUtil.showInputDialog(\"Value\", canvas);\n" +
                        "if (s == null || s.trim().length() == 0) return;")
                .addStatements(newInvokeLater(
                        "final nextgen.st.model.STValue stValue = nextgen.st.STModelPatterns.newSTValue(s);",
                        "canvas.addNode(new " + stValueNode.getName() + "(canvas, s, stValue.getUuid(), stValue, canvas.stRenderer));"
                ));
        registerRightClickAction(canvas, newSTNodeAction, newSTNodeAction.getName());

        final CanvasAction saveAction = newCanvasAction(canvas, "SaveCanvas", "Save")
                .addStatements(newInvokeLater(
                        newLine(
                                "final java.util.List<STModelNode> stModelNodes = canvas.getAllNodes()",
                                ".filter(stNode -> stNode instanceof STModelNode)",
                                ".map(stNode -> (STModelNode) stNode)",
                                ".collect(java.util.stream.Collectors.toList());"),
                        newLine("canvas.modelDb.doInTransaction(tx -> {", "});")
                                .addChildren(newLine("for (STModelNode stModelNode : stModelNodes)")
                                        .addChildren("canvas.modelDb.save(stModelNode.stModel);"))
                ));
        registerRightClickAction(canvas, saveAction, saveAction.getName());

        final CanvasAction loadAllAction = newCanvasAction(canvas, "LoadAllModels", "Load All Models")
                .addStatements(invokeLater(newLine("canvas.modelDb.doInTransaction(tx -> {", "})")
                        .addChildren(newLine("canvas.modelDb.getAllSTModels().forEach(stModel -> ", ");")
                                .addChildren("canvas.addNode(new STModelNode(canvas, canvas.stRenderer.render(stModel), stModel.getUuid(), stModel.getStTemplate(), stModel, canvas.stRenderer))"))));
        registerRightClickAction(canvas, loadAllAction, loadAllAction.getName());

        final CanvasAction newSTValueFromClipboard = newCanvasAction(canvas, "NewSTValueFromClipboard", "New Value from Clipboard")
                .addStatements("final String s = com.generator.util.SwingUtil.fromClipboard();")
                .addStatements("if (s == null || s.trim().length() == 0) return;")
                .addStatements(newInvokeLater(
                        "final nextgen.st.model.STValue stValue = nextgen.st.STModelPatterns.newSTValue(s);",
                        "canvas.addNode(new " + stValueNode.getName() + "(canvas, s, stValue.getUuid(), stValue, canvas.stRenderer));"));
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
                                        .addChildren(newInvokeLater(
                                                "final nextgen.st.model.STFile stFile = nextgen.st.STModelPatterns.newSTFile(name, type, path, packageName);",
                                                "canvas.addNode(new STFileNode(canvas, nextgen.st.STGenerator.asFile(stFile).getAbsolutePath(), stFile.getUuid(), stFile, null, null));"
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
                                        .addChildren(newInvokeLater(
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

    @Test
    public void generateModellingDomain() {

        final Entity stValue = newEntity("STValue")
                .addRelations(newEnumField("type", "STValueType", "STMODEL,PRIMITIVE,ENUM"))
                .addRelations(newExternalRef("value", Object.class));

        final Entity stModel = newEntity("STModel")
                .addRelations(newOneToOne("file", newEntity("STFile")
                        .addRelations(newStringField("name"))
                        .addRelations(newStringField("type"))
                        .addRelations(newStringField("packageName"))
                        .addRelations(newStringField("path"))))
                .addRelations(newExternalRef("stTemplate", newType(stDomainPackage, "STTemplate")))
                .addRelations(newOneToMany("arguments", newEntity("STArgument")
                        .addRelations(newExternalRef("stParameter", newType(stDomainPackage, "STParameter")))
                        .addRelations(newOneToOne("value", stValue))
                        .addRelations(newOneToMany("keyValues", newEntity("STArgumentKV")
                                .addRelations(newExternalRef("stParameterKey", newType(stDomainPackage, "STParameterKey")))
                                .addRelations(newOneToOne("value", stValue))))));

        stValue.addRelations(newOneToOne("stModel", stModel));

        writeBean(javaMainSrc, stModelPackage.getName(), newDomain("STModel")
                .addEntities(stModel));

        // neo-persistence domain:

        final Entity stValueNeo = newEntity("STValueNeo")
                .addRelations(newStringField("uuid"))
                .addRelations(newStringField("value"))
                .addRelations(newStringField("type"));

        final Entity stModelNeo = newEntity("STModelNeo")
                .addRelations(newStringField("uuid"))
                .addRelations(newStringField("stTemplate"))
                .addRelations(newOneToOne("file", newEntity("STFileNeo")
                        .addRelations(newStringField("uuid"))
                        .addRelations(newStringField("name"))
                        .addRelations(newStringField("type"))
                        .addRelations(newStringField("packageName"))
                        .addRelations(newStringField("path"))))
                .addRelations(newOneToMany("arguments", newEntity("STArgumentNeo")
                        .addRelations(newStringField("uuid"))
                        .addRelations(newStringField("stParameter"))
                        .addRelations(newOneToOne("value", stValueNeo))
                        .addRelations(newOneToMany("keyValues", newEntity("STArgumentKVNeo")
                                .addRelations(newStringField("uuid"))
                                .addRelations(newStringField("stParameterKey"))
                                .addRelations(newOneToOne("value", stValueNeo))))));

        stValueNeo.addRelations(newOneToOne("stModel", stModelNeo));

        writeNeo(javaMainSrc, stModelNeoPackage.getName(), newDomain("STModelNeo")
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