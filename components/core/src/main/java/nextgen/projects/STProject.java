package nextgen.projects;

import nextgen.templates.JavaPatterns;
import nextgen.templates.Piccolo2DPatterns;
import nextgen.templates.domain.Entity;
import nextgen.templates.java.*;
import nextgen.templates.piccolo2d.*;
import nextgen.templates.text.Line;
import org.junit.Test;

import java.util.Arrays;

import static nextgen.st.STGenerator.writeJavaFile;
import static nextgen.templates.DomainPatterns.newEnum;
import static nextgen.templates.DomainPatterns.*;
import static nextgen.templates.JavaPatterns.*;
import static nextgen.templates.Piccolo2DPatterns.*;
import static nextgen.templates.TextPatterns.*;
import static nextgen.templates.java.JavaST.newMethodDeclaration;
import static nextgen.templates.java.JavaST.newSwitch;

public class STProject extends BaseSTProject {

    @Test
    public void generateCanvasPackage() {

        final PCanvas canvas = newPCanvas()
                .setName(STCanvas.name())
                .setPackageName(stCanvasPackage.getName())
                .setNodeName(STNode.name())
                .setRelationName(STRelation.name())
                .addFields(STRenderer.type(), STRenderer.variableName())
                .addFields(STModelDB.type(), STModelDB.variableName())
                .addMethods(newNodeSupplierMethod(STModel.asParameter(),
                        "return () -> new STModelNode(this, modelDb.findSTTemplateByUuid(stModel.getStTemplate()), stModel, stRenderer);"))
                .addMethods(newNodeSupplierMethod(STValue.asParameter(),
                        "return () -> new STValueNode(this, stValue, stRenderer);"))
                .addMethods(newNodeSupplierMethod(newParameter(STParameter.type(), STParameter.variableName()),
                        "return () -> new STKVNode(this, stParameter, stArgument, stRenderer);")
                        .addParameters(STArgument.asParameter()))
                .addMethods(newNodeSupplierMethod(STFile.asParameter(),
                        "return () -> new STFileNode(this, stFile, stModel, stRenderer);")
                        .addParameters(STModel.asParameter()))
                .addCanvasActionmethods(newProtectedMethod("doLaterInTransaction", newBlockStmt()
                        .addStatements(invokeLater(STCanvas.methodCall("modelDb.doInTransaction", "consumer", "throwable -> com.generator.util.SwingUtil.showException(canvas, throwable)"))))
                        .addParameters(Consumer.asParameter(NeoTransaction.type())));

        final PNode node = newPNode()
                .setName(STNode.name())
                .setCanvasName(canvas.getName())
                .setPackageName(stCanvasPackage.getName())
                .addMethods(newNodeMethod()
                        .setName("cut")
                        .addParams("text", "String")
                        .setType("String")
                        .setReturnStatement("text.substring(0, Math.min(text.length(), 20));"))
                .addMethods(newProtectedMethod("doLaterInTransaction", newBlockStmt()
                        .addStatements("javax.swing.SwingUtilities.invokeLater(() -> canvas.modelDb.doInTransaction(consumer, throwable -> com.generator.util.SwingUtil.showException(canvas, throwable)));"))
                        .addParameters(newParameter()
                                .setType("java.util.function.Consumer<org.neo4j.graphdb.Transaction>")
                                .setName("consumer")))
                .addNodeActionmethods(newProtectedMethod("doLaterInTransaction", newBlockStmt()
                        .addStatements("node.doLaterInTransaction(consumer);"))
                        .addParameters(newParameter()
                                .setType("java.util.function.Consumer<org.neo4j.graphdb.Transaction>")
                                .setName("consumer")));

        final PRelation relation = newPRelation()
                .setName(STRelation.name())
                .setNodeName(node.getName())
                .setCanvasName(canvas.getName())
                .setPackageName(stCanvasPackage.getName())
                .addMethods(newProtectedMethod("doLaterInTransaction", newBlockStmt()
                        .addStatements("javax.swing.SwingUtilities.invokeLater(() -> canvas.modelDb.doInTransaction(consumer, throwable -> com.generator.util.SwingUtil.showException(canvas, throwable)));"))
                        .addParameters(newParameter()
                                .setType("java.util.function.Consumer<org.neo4j.graphdb.Transaction>")
                                .setName("consumer")))
                .addRelationActionmethods(newProtectedMethod("doLaterInTransaction", newBlockStmt()
                        .addStatements("relation.doLaterInTransaction(consumer);"))
                        .addParameters(newParameter()
                                .setType("java.util.function.Consumer<org.neo4j.graphdb.Transaction>")
                                .setName("consumer")));

        final PRelationImpl stArgumentRelation = newPRelationImpl()
                .setCanvasName(canvas.getName())
                .setRelationName(STRelation.name())
                .setPackageName(stCanvasPackage.getName())
                .setSrcNode(STModelNode.name())
                .setDstNode(STNode.name())
                .setName(STArgumentRelation.name())
                .setUuidExpression("UUID.fromString(stArgument.getUuid())")
                .addFields(STArgument.type(), STArgument.variableName())
                .addFields(STParameter.type(), STParameter.variableName())
                .setNameExpression("stParameter.getName()")
                .addOnRightClick(false, "Delete")
                .addOnKeyPressed("D", "Delete")
                .addActions(newRelationAction()
                        .setName("Delete")
                        .setRelationType(STArgumentRelation.name())
                        .setCanvasName(STCanvas.name())
                        .setTitle("Delete")
                        .addStatements("if (!com.generator.util.SwingUtil.showConfirmDialog(canvas, \"Delete ?\")) return;")
                        .addStatements("final STModelNode src = (STModelNode) relation.getSrc();")
                        .addStatements(invokeLaterInTransaction("src.stModel.removeArguments(relation.stArgument);", "canvas.removeRelation(relation.getUuid());"))
                );

        final PRelationImpl stKVArgumentRelation = newPRelationImpl()
                .setCanvasName(canvas.getName())
                .setRelationName(STRelation.name())
                .setPackageName(stCanvasPackage.getName())
                .setSrcNode(STKVNode.name())
                .setDstNode(STNode.name())
                .setName(STKVArgumentRelation.name())
                .setUuidExpression("UUID.fromString(stArgumentKV.getUuid())")
                .addFields(STArgument.type(), STArgument.variableName())
                .addFields(STParameterKey.type(), STParameterKey.variableName())
                .addFields(STArgumentKV.type(), STArgumentKV.variableName())
                .setNameExpression("stParameterKey.getName()")
                .addOnRightClick(false, "Delete")
                .addOnKeyPressed("D", "Delete")
                .addActions(newRelationAction()
                        .setName("Delete")
                        .setRelationType(STKVArgumentRelation.name())
                        .setCanvasName(STCanvas.name())
                        .setTitle("Delete")
                        .addStatements("if (!com.generator.util.SwingUtil.showConfirmDialog(canvas, \"Delete ?\")) return;")
                        .addStatements(invokeLaterInTransaction(
                                "canvas.removeRelation(relation.getUuid());",
                                "relation.stArgument.removeKeyValues(relation.stArgumentKV);"))
                );

        final PRelationImpl stValueModelRelation = newPRelationImpl()
                .setCanvasName(canvas.getName())
                .setRelationName(STRelation.name())
                .setPackageName(stCanvasPackage.getName())
                .setSrcNode(STValueNode.name())
                .setDstNode(STModelNode.name())
                .setName(STValueModelRelation.name())
                .setUuidExpression("UUID.fromString(src.stValue.getUuid())")
                .addOnRightClick(false, "Delete")
                .addOnKeyPressed("D", "Delete")
                .addActions(newRelationAction()
                        .setName("Delete")
                        .setRelationType(STValueModelRelation.name())
                        .setCanvasName(STCanvas.name())
                        .setTitle("Delete")
                        .addStatements("if (!com.generator.util.SwingUtil.showConfirmDialog(canvas, \"Delete ?\")) return;")
                        .addStatements(invokeLaterInTransaction(
                                "final STValueNode src = (STValueNode) relation.getSrc();",
                                "src.close();",
                                "canvas.modelDb.remove(src.stValue);"
                        )));

        final PNodeImpl stFileNode = newPNodeImpl(canvas, node)
                .setName(STFileNode.name())
                .setPackageName(stCanvasPackage.getName())
                .setNodeName(STNode.name())
                .addFields(STFile.type(), STFile.variableName())
                .addFields(STModel.type(), STModel.variableName())
                .addFields(STRenderer.type(), STRenderer.variableName())
                .setInitText("nextgen.st.STGenerator.asFile(stFile).getAbsolutePath()")
                .setUuid("java.util.UUID.fromString(stFile.getUuid())")
                .addOnLeftClick(invokeLaterInTransaction(
                        "if (stRenderer == null || stModel == null) return;",
                        "nextgen.st.STGenerator.writeToFile(stRenderer.render(stModel), stFile.getPackageName(), stFile.getName(), stFile.getType(), new java.io.File(stFile.getPath()));"))
                .addRightClickStatements(getSelectedSTModelNodes("stModelNodes"))
                .addRightClickStatements(invokeLaterInTransaction(
                        "final JMenu sourceMenu = new JMenu(\"STModels\");",
                        newLine("stModelNodes.forEach(stModelNode -> {", "});")
                                .addChildren("final int end = Math.min(stModelNode.getText().length(), 50);")
                                .addChildren(newLine("sourceMenu.add(new SetSource(\"Set source to \" + stModelNode.getText().substring(0, end), STFileNode.this, canvas, event, stModelNode));")),
                        "pop.add(sourceMenu);"));

        stFileNode.addActions(newNodeAction(stFileNode, "SetSource", "Set Source")
                .setTitleExpression(true)
                .addFields(STModelNode.name(), STModelNode.variableName())
                .addStatements(invokeLaterInTransaction(
                        "if (node.stModel != null) canvas.removeRelation(node.getUuid());",
                        "node.stModel = stModelNode.stModel;",
                        "node.stModel.addFiles(node.stFile);",
                        "canvas.addRelation(new STSinkRelation(canvas, stModelNode, node));",
                        "node.setText(nextgen.st.STGenerator.asFile(node.stFile).getAbsolutePath());"
                )));

        final PRelationImpl stSinkRelation = newPRelationImpl()
                .setCanvasName(canvas.getName())
                .setRelationName(STRelation.name())
                .setPackageName(stCanvasPackage.getName())
                .setSrcNode(STModelNode.name())
                .setDstNode(STFileNode.name())
                .setName("STSinkRelation")
                .setNameExpression("\"SINK\"")
                .setUuidExpression("dst.getUuid()")
                .addOnRightClick(false, "Delete")
                .addOnKeyPressed("D", "Delete")
                .addActions(newRelationAction()
                        .setName("Delete")
                        .setRelationType("STSinkRelation")
                        .setCanvasName(STCanvas.name())
                        .setTitle("Delete")
                        .addStatements("if (!com.generator.util.SwingUtil.showConfirmDialog(canvas, \"Delete ?\")) return;")
                        .addStatements("final STModelNode src = (STModelNode) relation.getSrc();")
                        .addStatements("final STFileNode dst = (STFileNode) relation.getDst();")
                        .addStatements(invokeLaterInTransaction(
                                "src.stModel.removeFiles(dst.stFile);",
                                "canvas.removeRelation(relation.getUuid());")));


        final NodeAction editFileSinkAction = newNodeAction(stFileNode, "EditFileSink", "Edit")
                .addStatements(doInTransaction(
                        "final Map<String, JTextField> fieldMap = new java.util.LinkedHashMap<>();",
                        "fieldMap.put(\"name\", new JTextField(node.stFile.getName(), 15));",
                        "fieldMap.put(\"type\", new JTextField(node.stFile.getType(), 15));",
                        "fieldMap.put(\"path\", new JTextField(node.stFile.getPath(), 15));",
                        "fieldMap.put(\"package\", new JTextField(node.stFile.getPackageName(), 15));",
                        "final JPanel inputPanel = new JPanel(new GridLayout(fieldMap.size(), 2));",
                        "inputPanel.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));",
                        newLine("for (Map.Entry<String, JTextField> fieldEntry : fieldMap.entrySet()) {", "}")
                                .addChildren("inputPanel.add(new JLabel(fieldEntry.getKey()));")
                                .addChildren("inputPanel.add(fieldEntry.getValue());"),
                        newBlock()
                                .addLines(newLine("com.generator.util.SwingUtil.showDialog(inputPanel, canvas, \"Edit\", new com.generator.util.SwingUtil.ConfirmAction() {", "});")
                                        .addChildren("@Override")
                                        .addChildren(newLine("public void verifyAndCommit() throws Exception {", "}")
                                                .addChildren("final String name = fieldMap.get(\"name\").getText().trim();")
                                                .addChildren("final String type = fieldMap.get(\"type\").getText().trim();")
                                                .addChildren("final String path = fieldMap.get(\"path\").getText().trim();")
                                                .addChildren("final String packageName = fieldMap.get(\"package\").getText().trim();")
                                                .addChildren(invokeLaterInTransaction(
                                                        "node.stFile.setName(name);",
                                                        "node.stFile.setType(type);",
                                                        "node.stFile.setPath(path);",
                                                        "node.stFile.setPackageName(packageName);",
                                                        "node.setText(nextgen.st.STGenerator.asFile(node.stFile).getAbsolutePath());"))))
                ));
        registerRightClickAction(stFileNode, editFileSinkAction, editFileSinkAction.getName());

        final PNodeImpl stValueNode = newPNodeImpl(canvas, node)
                .setName(STValueNode.name())
                .setPackageName(stCanvasPackage.getName())
                .setNodeName(STNode.name())
                .addFields(STValue.type(), STValue.variableName())
                .addFields(STRenderer.type(), STRenderer.variableName())
                .setInitText("stRenderer.render(stValue)")
                .setUuid(UUID.staticMethodCall("fromString", STValue.methodCall("getUuid")))
                .addOnKeyPressed("D", "Delete")
                .addAddedToCanvasStatements(newLine("if (stValue.getType().equals(nextgen.st.model.STValueType.STMODEL)) {", "}")
                        .addChildren("final nextgen.st.model.STModel stModel = stValue.getStModel();")
                        .addChildren("final STNode stModelNode = canvas.getNode(UUID.fromString(stModel.getUuid()));")
                        .addChildren(newLine("if (stModelNode instanceof STModelNode) {", "}")
                                .addChildren("canvas.addRelation(new STValueModelRelation(canvas, STValueNode.this, (STModelNode) stModelNode));")))
                .addNewNodeAddedStatements(newLine("if (stValue.getType().equals(nextgen.st.model.STValueType.STMODEL)) {", "}")
                        .addChildren("final UUID uuid = UUID.fromString(stValue.getStModel().getUuid());")
                        .addChildren(newLine("if (uuid.equals(node.getUuid())) {", "}")
                                .addChildren("canvas.addRelation(new STValueModelRelation(canvas, STValueNode.this, (STModelNode) node));")));

        final PNodeImpl stKVNode = newPNodeImpl(canvas, node)
                .setName(STKVNode.name())
                .setPackageName(stCanvasPackage.getName())
                .setNodeName(STNode.name())
                .addFields(STParameter.type(), STParameter.variableName())
                .addFields(STArgument.type(), STArgument.variableName())
                .addFields(STRenderer.type(), STRenderer.variableName())
                .setInitText("stParameter.getName()")
                .addMethods(newProtectedMethod("removeArgument", newBlockStmt()
                        .addStatements(newLine("stArgument.getKeyValues().filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.uuid())).findAny().ifPresent(stArgumentKV -> {", "});")
                                .addChildren("canvas.removeRelation(UUID.fromString(stArgumentKV.getUuid()));")
                                .addChildren("stArgument.removeKeyValues(stArgumentKV);")))
                        .addParameters(newParameter(STParameterKey.type(), STParameterKey.variableName())))
                .addNewNodeAddedStatements(newLine("stParameter.getKeys().forEach(stParameterKey -> stArgument.getKeyValues().filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.uuid())).forEach(stArgumentKV -> {", "}));")
                        .addChildren("final nextgen.st.model.STValue value = stArgumentKV.getValue();")
                        .addChildren(newSwitch()
                                .setSelector("value.getType()")
                                .addCases("STMODEL", newBlock(
                                        "final nextgen.st.model.STModel stModel = value.getStModel();",
                                        "if (node.getUuid().equals(UUID.fromString(stModel.getUuid()))) canvas.addRelation(new STKVArgumentRelation(canvas, STKVNode.this, node, stArgument, stParameterKey, stArgumentKV));"
                                ))
                                .addCases("PRIMITIVE", newBlock(
                                        "if (node.getUuid().equals(UUID.fromString(value.getUuid()))) canvas.addRelation(new STKVArgumentRelation(canvas, STKVNode.this, node, stArgument, stParameterKey, stArgumentKV));"
                                ))
                                .addCases("ENUM", newBlock(
                                        "if (node.getUuid().equals(UUID.fromString(value.getUuid()))) canvas.addRelation(new STKVArgumentRelation(canvas, STKVNode.this, node, stArgument, stParameterKey, stArgumentKV));"
                                ))))
                .setUuid("java.util.UUID.fromString(stArgument.getUuid())")
                .addRightClickStatements(getSelectedSTValueNodes("stValueNodes"))
                .addRightClickStatements(getSelectedSTModelNodes("stModelNodes"))
                .addRightClickStatements(doInTransactionSilent()
                        .addChildren(newLine("stParameter.getKeys().forEach(stParameterKey -> {", "});")
                                .addChildren("final JMenu stParameterMenu = new JMenu(stParameterKey.getName());")
                                .addChildren(newBlock()
                                        .addLines(newLine("stValueNodes.forEach(stNode -> {", "});")
                                                .addChildren(newLine("stParameterMenu.add(new SetSTValueArgumentAction(\"Set \" + stParameterKey.getName() + \" = \" + cut(stNode.getText()), STKVNode.this, canvas, event, stParameter, stParameterKey, stArgument, stNode));")))
                                        .addLines(newLine("stModelNodes.forEach(stNode -> {", "});")
                                                .addChildren(newLine("stParameterMenu.add(new SetSTModelArgumentAction(\"Set \" + stParameterKey.getName() + \" = \" + cut(stNode.getText()), STKVNode.this, canvas, event, stParameter, stParameterKey, stArgument, stNode));")))
                                        .addLines(newLine("stParameterMenu.add(new SetInputValueArgumentAction(\"Set \" + stParameterKey.getName(), STKVNode.this, canvas, event, stParameter, stParameterKey, stArgument));")))
                                .addChildren(newLine("stArgument.getKeyValues().filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.uuid())).forEach(stArgumentKV -> {", "});")
                                        .addChildren("stParameterMenu.add(new OpenArgument(\"Open \" + stParameterKey.getName(), STKVNode.this, canvas, event, stArgument, stParameterKey, stArgumentKV));")
                                        .addChildren("stParameterMenu.add(new RemoveArgument(\"Remove \" + stParameterKey.getName(), STKVNode.this, canvas, event, stArgument, stParameterKey, stArgumentKV));"))
                                .addChildren("if (stParameterMenu.getMenuComponentCount() != 0) pop.add(stParameterMenu);"))
                        .addChildren("if (pop.getComponents().length != 0) pop.addSeparator();"));

        stKVNode.addActions(newNodeAction(stKVNode, "SetInputValueArgumentAction", "Set")
                .addFields(STParameter.type(), STParameter.variableName())
                .addFields(STParameterKey.type(), STParameterKey.variableName())
                .addFields(STArgument.type(), STArgument.variableName())
                .setTitleExpression(true)
                .addStatements("final String s = com.generator.util.SwingUtil.showInputDialog(stParameter.getName(), canvas);")
                .addStatements("if (s == null || s.trim().length() == 0) return;")
                .addStatements(invokeLaterInTransaction(
                        "final nextgen.st.model.STValue stValue = canvas.modelDb.newSTValue(s.trim());",
                        "node.removeArgument(stParameterKey);",
                        "final nextgen.st.model.STArgumentKV stArgumentKV = canvas.modelDb.newSTArgumentKV(stParameterKey, stValue);",
                        "node.stArgument.addKeyValues(stArgumentKV);",
                        "final STNode stValueNode = canvas.addNode(canvas.newSTNode(stValue).get());",
                        "canvas.addRelation(new STKVArgumentRelation(canvas, node, stValueNode, stArgument, stParameterKey, stArgumentKV));"
                )));

        stKVNode.addActions(newNodeAction(stKVNode, "SetSTValueArgumentAction", "Set")
                .addFields(STParameter.type(), STParameter.variableName())
                .addFields(STParameterKey.type(), STParameterKey.variableName())
                .addFields(STArgument.type(), STArgument.variableName())
                .addFields(STValueNode.name(), STValueNode.variableName())
                .setTitleExpression(true)
                .addStatements(invokeLaterInTransaction(
                        "node.removeArgument(stParameterKey);",
                        "final nextgen.st.model.STArgumentKV stArgumentKV = canvas.modelDb.newSTArgumentKV(stParameterKey, stValueNode.stValue);",
                        "node.stArgument.addKeyValues(stArgumentKV);",
                        "canvas.addRelation(new STKVArgumentRelation(canvas, node, stValueNode, stArgument, stParameterKey, stArgumentKV));"
                )));

        stKVNode.addActions(newNodeAction(stKVNode, "SetSTModelArgumentAction", "Set")
                .addFields(STParameter.type(), STParameter.variableName())
                .addFields(STParameterKey.type(), STParameterKey.variableName())
                .addFields(STArgument.type(), STArgument.variableName())
                .addFields(STModelNode.name(), STModelNode.variableName())
                .setTitleExpression(true)
                .addStatements(invokeLaterInTransaction(
                        "node.removeArgument(stParameterKey);",
                        STValue.asVariable("canvas.modelDb.newSTValue(stModelNode.stModel)"),
                        STArgumentKV.asVariable("canvas.modelDb.newSTArgumentKV(stParameterKey, stValue);"),
                        "node.stArgument.addKeyValues(stArgumentKV);",
                        "canvas.addRelation(new STKVArgumentRelation(canvas, node, stModelNode, stArgument, stParameterKey, stArgumentKV));"
                )));

        final NodeAction openAllKVs = newNodeAction(stKVNode, "OpenAllArguments", "Open All")
                .addStatements(invokeLaterInTransaction(
                        newLine("node.stParameter.getKeys().forEach(stParameterKey -> {", "});")
                                .addChildren("node.stArgument.getKeyValues()" +
                                        ".filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.uuid()))" +
                                        ".findFirst()" +
                                        newLine(".ifPresent(stArgumentKV -> {", "});")
                                                .addChildren("new OpenArgument(\"\", node, canvas, event, node.stArgument, stParameterKey, stArgumentKV).actionPerformed(null);")),
                        "new LayoutTreeAction(node, canvas, event).actionPerformed(null);"));
        registerRightClickAction(stKVNode, openAllKVs, openAllKVs.getName());
        stKVNode.addOnKeyPressed("E", "OpenAllArguments");

        final NodeAction openKVArgument = newNodeAction(stKVNode, "OpenArgument", "Open")
                .setTitleExpression(true)
                .addFields(STArgument.type(), STArgument.variableName())
                .addFields(STParameterKey.type(), STParameterKey.variableName())
                .addFields(STArgumentKV.type(), STArgumentKV.variableName())
                .addStatements(invokeLaterInTransaction(
                        STValue.asVariable(STArgumentKV.methodCall("getValue")),
                        newSwitch()
                                .setSelector("stValue.getType()")
                                .addCases("STMODEL", newBlock(
                                        "canvas.addNode(stValue.getStModel().getUuid(), canvas.newSTNode(stValue.getStModel()));",
                                        "canvas.addRelation(new STKVArgumentRelation(canvas, node, canvas.getNode(UUID.fromString(stValue.getStModel().getUuid())), node.stArgument, stParameterKey, stArgumentKV));"))
                                .addCases("PRIMITIVE", newBlock(
                                        "canvas.addNode(stValue.getUuid(), canvas.newSTNode(stValue));",
                                        "canvas.addRelation(new STKVArgumentRelation(canvas, node, canvas.getNode(UUID.fromString(stValue.getUuid())), node.stArgument, stParameterKey, stArgumentKV));"))
                                .addCases("ENUM", newBlock(
                                        "canvas.addNode(stValue.getUuid(), canvas.newSTNode(stValue));",
                                        "canvas.addRelation(new STKVArgumentRelation(canvas, node, canvas.getNode(UUID.fromString(stValue.getUuid())), node.stArgument, stParameterKey, stArgumentKV));")),
                        "new LayoutTreeAction(node, canvas, event).actionPerformed(null);"));
        stKVNode.addActions(openKVArgument);

        final NodeAction removeKVArgument = newNodeAction(stKVNode, "RemoveArgument", "Remove")
                .setTitleExpression(true)
                .addFields(STArgument.type(), STArgument.variableName())
                .addFields(STParameterKey.type(), STParameterKey.variableName())
                .addFields(STArgumentKV.type(), STArgumentKV.variableName())
                .addStatements(invokeLaterInTransaction(
                        statement(STCanvas.methodCall("removeRelation", UUID.staticMethodCall("fromString", STArgumentKV.methodCall("getUuid")))),
                        statement(STArgument.methodCall("removeKeyValues", STArgumentKV.variableName()))));
        stKVNode.addActions(removeKVArgument);

        final NodeAction editSTValue = newNodeAction(stValueNode, "EditSTValue", "Edit")
                .addStatements("final JTextArea textArea = new JTextArea(15,40);")
                .addStatements(doInTransaction(
                        "textArea.setText(node.stValue.getValue());"
                ))
                .addStatements("final JPanel inputPanel = new JPanel(new BorderLayout());")
                .addStatements("inputPanel.add(textArea, BorderLayout.CENTER);")
                .addStatements("inputPanel.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));")
                .addStatements(newBlock()
                        .addLines(newLine("com.generator.util.SwingUtil.showDialog(inputPanel, canvas, \"Edit\", new com.generator.util.SwingUtil.ConfirmAction() {", "});")
                                .addChildren("@Override")
                                .addChildren(newLine("public void verifyAndCommit() throws Exception {", "}")
                                        .addChildren("final String s = textArea.getText().trim();")
                                        .addChildren(invokeLaterInTransaction(
                                                "node.stValue.setValue(s);",
                                                "node.setText(node.stValue.getValue());"
                                        )))));
        registerRightClickAction(stValueNode, editSTValue, editSTValue.getName());

        final NodeAction stValueToClipboard = newNodeAction(stValueNode, "ToClipboard", "To Clipboard")
                .addStatements(doInTransaction("com.generator.util.SwingUtil.toClipboard(node.stRenderer.render(node.stValue));"));
        registerRightClickAction(stValueNode, stValueToClipboard, stValueToClipboard.getName());

        final NodeAction deleteSTValue = newNodeAction(stValueNode, "Delete", "Delete")
                .addStatements("if (!com.generator.util.SwingUtil.showConfirmDialog(canvas, \"Delete value ?\")) return;")
                .addStatements(invokeLaterInTransaction(
                        "node.close();",
                        "canvas.modelDb.remove(node.stValue);"));
        registerRightClickAction(stValueNode, deleteSTValue, deleteSTValue.getName());

        final MethodDeclaration forEachArgument = newProtectedMethod("forEachArgument", newBlockStmt()
                .addStatements(newLine("stTemplate.getParameters()" +
                        ".forEach(stParameter -> stModel.getArguments()" +
                        ".filter(stArgument -> stArgument.getStParameter().equals(stParameter.uuid()))" +
                        ".forEach(stArgument -> consumer.accept(stArgument, stParameter)));")))
                .addParameters(BiConsumer.asParameter(STArgument.type(), STParameter.type()));

        final MethodDeclaration refersTo = newProtectedMethod("refersTo", newBlockStmt()
                .addStatements(newBlock(
                        "if (stArgument == null || stParameter == null || node == null) return false;",
                        newSwitch()
                                .setSelector("stParameter.getType()")
                                .addCases("SINGLE", newBlock(
                                        "final nextgen.st.model.STValue value = stArgument.getValue();",
                                        "if (value != null) return UUID.fromString(value.getUuid()).equals(node.getUuid()) || (value.getType().equals(nextgen.st.model.STValueType.STMODEL) && value.getStModel() != null && UUID.fromString(value.getStModel().getUuid()).equals(node.getUuid()));"))
                                .addCases("LIST", newBlock(
                                        "final nextgen.st.model.STValue value = stArgument.getValue();",
                                        "if (value != null) return UUID.fromString(value.getUuid()).equals(node.getUuid()) || (value.getType().equals(nextgen.st.model.STValueType.STMODEL) && value.getStModel() != null && UUID.fromString(value.getStModel().getUuid()).equals(node.getUuid()));"))
                                .addCases("KVLIST", newBlock(
                                        "if (UUID.fromString(stArgument.getUuid()).equals(node.getUuid())) return true;")))
                        .addLines("return false;")))
                .addParameters(newParameter(STArgument.type(), STArgument.variableName()))
                .addParameters(newParameter(STParameter.type(), STParameter.variableName()))
                .addParameters(newParameter(STNode.type(), "node"))
                .setType("boolean");

        final PNodeImpl stModelNode = newPNodeImpl(canvas, node)
                .setPackageName(stCanvasPackage.getName())
                .setName(STModelNode.name())
                .addFields(STTemplate.type(), STTemplate.variableName())
                .addFields(STModel.type(), STModel.variableName())
                .addFields(STRenderer.type(), STRenderer.variableName())
                .setInitText("stTemplate.getName() + \" : \\n\" + stRenderer.render(stModel)")
                .setUuid("java.util.UUID.fromString(stModel.getUuid())")
                .addMethods(forEachArgument)
                .addMethods(refersTo)
                .addMethods(newProtectedMethod("removeArgument", newBlockStmt()
                        .addStatements(newLine("stModel.getArguments().filter(existing -> existing.getStParameter().equals(stParameter.uuid())).findAny().ifPresent(existing -> {", "});")
                                .addChildren("canvas.removeRelation(UUID.fromString(existing.getUuid()));")
                                .addChildren("stModel.removeArguments(existing);")))
                        .addParameters(newParameter(STParameter.type(), STParameter.variableName())))
                .addAddedToCanvasStatements("canvas.getAllNodes().forEach(this::newNodeAdded);")
                .addNewNodeAddedStatements(newLine("forEachArgument((stArgument, stParameter) -> {", "});")
                        .addChildren("if (refersTo(stArgument, stParameter, node)) canvas.addRelation(new STArgumentRelation(canvas, STModelNode.this, node, stArgument, stParameter));"))
                .addOnLeftClick(doInTransactionSilent("setText(stRenderer.render(stModel));"))
                .addRightClickStatements(getSelectedSTValueNodes("stValueNodes"))
                .addRightClickStatements(getSelectedSTModelNodes("stModelNodes"))
                .addRightClickStatements(doInTransactionSilent()
                        .addChildren(newLine("stTemplate.getParameters().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stParameter -> {", "});")
                                .addChildren("final JMenu stParameterMenu = new JMenu(stParameter.getName());")
                                .addChildren(newSwitch().setSelector("stParameter.getType()")
                                        .addCases("SINGLE", newBlock()
                                                .addLines(newLine("stValueNodes.forEach(stNode -> {", "});")
                                                        .addChildren(newLine("stParameterMenu.add(new SetSTValueArgumentAction(\"Set \" + stParameter.getName() + \" = \" + cut(stNode.getText()), STModelNode.this, canvas, event, stParameter, stNode));")))
                                                .addLines(newLine("stModelNodes.forEach(stNode -> {", "});")
                                                        .addChildren(newLine("stParameterMenu.add(new SetSTModelArgumentAction(\"Set \" + stParameter.getName() + \" = \" + cut(stNode.getText()), STModelNode.this, canvas, event, stParameter, stNode));")))
                                                .addLines(newLine("stParameterMenu.add(new SetInputValueArgumentAction(\"Set \" + stParameter.getName(), STModelNode.this, canvas, event, stParameter));"))
                                                .addLines(newLine("stParameterMenu.add(new SetClipboardValueArgumentAction(\"Set from clipboard\" + stParameter.getName(), STModelNode.this, canvas, event, stParameter));")))
                                        .addCases("LIST", newBlock()
                                                .addLines(newLine("stValueNodes.forEach(stNode -> {", "});")
                                                        .addChildren(newLine("stParameterMenu.add(new AddSTValueArgumentAction(\"Add \" + stParameter.getName() + \" = \" + cut(stNode.getText()), STModelNode.this, canvas, event, stParameter, stNode));")))
                                                .addLines(newLine("stModelNodes.forEach(stNode -> {", "});")
                                                        .addChildren(newLine("stParameterMenu.add(new AddSTModelArgumentAction(\"Add \" + stParameter.getName() + \" = \" + cut(stNode.getText()), STModelNode.this, canvas, event, stParameter, stNode));")))
                                                .addLines(newLine("stParameterMenu.add(new AddInputValueArgumentAction(\"Add \" + stParameter.getName(), STModelNode.this, canvas, event, stParameter));"))
                                                .addLines(newLine("stParameterMenu.add(new AddClipboardValueArgumentAction(\"Add from clipboard \" + stParameter.getName(), STModelNode.this, canvas, event, stParameter));")))
                                        .addCases("KVLIST", newBlock()
                                                .addLines(newLine("stParameterMenu.add(new AddKVInputValueArgumentAction(\"Add \" + stParameter.getName(), STModelNode.this, canvas, event, stParameter));"))))
                                .addChildren(newLine("stModel.getArguments().filter(existing -> existing.getValue() != null).filter(stArgument -> stArgument.getStParameter().equals(stParameter.uuid())).forEach(stArgument -> {", "});")
                                        .addChildren("stParameterMenu.add(new OpenArgument(\"Open \" + (stParameter.getType().equals(nextgen.st.domain.STParameterType.KVLIST) ? stParameter.getName() : canvas.stRenderer.render(stArgument.getValue())), STModelNode.this, canvas, event, stParameter, stArgument));")
                                        .addChildren("stParameterMenu.add(new RemoveArgument(\"Remove \" + (stParameter.getType().equals(nextgen.st.domain.STParameterType.KVLIST) ? stParameter.getName() : canvas.stRenderer.render(stArgument.getValue())), STModelNode.this, canvas, event, stParameter, stArgument));"))
                                .addChildren("if (stParameterMenu.getMenuComponentCount() != 0) pop.add(stParameterMenu);"))
                        .addChildren("if (pop.getComponents().length != 0) pop.addSeparator();"));

        stModelNode.addActions(newNodeAction(stModelNode, "SetInputValueArgumentAction", "Set")
                .addFields(STParameter.type(), STParameter.variableName())
                .setTitleExpression(true)
                .addStatements("final String s = com.generator.util.SwingUtil.showInputDialog(stParameter.getName(), canvas);")
                .addStatements("if (s == null || s.trim().length() == 0) return;")
                .addStatements(invokeLaterInTransaction(
                        "node.removeArgument(stParameter);",
                        "final nextgen.st.model.STValue stValue = canvas.modelDb.newSTValue(s.trim());",
                        "final nextgen.st.model.STArgument stArgument = canvas.modelDb.newSTArgument(stParameter, stValue);",
                        "node.stModel.addArguments(stArgument);",
                        "canvas.addNode(stValue.getUuid(), canvas.newSTNode(stValue));",
                        "canvas.addRelation(new STArgumentRelation(canvas, node, canvas.getNode(stValue.getUuid()), stArgument, stParameter));",
                        "node.setText(node.stRenderer.render(node.stModel));"
                )));

        stModelNode.addActions(newNodeAction(stModelNode, "SetClipboardValueArgumentAction", "Set")
                .addFields(STParameter.type(), STParameter.variableName())
                .setTitleExpression(true)
                .addStatements("final String s = com.generator.util.SwingUtil.fromClipboard();")
                .addStatements("if (s == null || s.trim().length() == 0) return;")
                .addStatements(invokeLaterInTransaction(
                        "node.removeArgument(stParameter);",
                        "final nextgen.st.model.STValue stValue = canvas.modelDb.newSTValue(s.trim());",
                        "final nextgen.st.model.STArgument stArgument = canvas.modelDb.newSTArgument(stParameter, stValue);",
                        "node.stModel.addArguments(stArgument);",
                        "canvas.addNode(stValue.getUuid(), canvas.newSTNode(stValue));",
                        "canvas.addRelation(new STArgumentRelation(canvas, node, canvas.getNode(stValue.getUuid()), stArgument, stParameter));",
                        "node.setText(node.stRenderer.render(node.stModel));"
                )));

        stModelNode.addActions(newNodeAction(stModelNode, "SetSTValueArgumentAction", "Set")
                .addFields(STParameter.type(), STParameter.variableName())
                .addFields(STValueNode.name(), STValueNode.variableName())
                .setTitleExpression(true)
                .addStatements(invokeLaterInTransaction(
                        "node.removeArgument(stParameter);",
                        "final nextgen.st.model.STArgument stArgument = canvas.modelDb.newSTArgument(stParameter, stValueNode.stValue);",
                        "node.stModel.addArguments(stArgument);",
                        "canvas.addRelation(new STArgumentRelation(canvas, node, stValueNode, stArgument, stParameter));",
                        "node.setText(node.stRenderer.render(node.stModel));"
                )));

        stModelNode.addActions(newNodeAction(stModelNode, "SetSTModelArgumentAction", "Set")
                .addFields(STParameter.type(), STParameter.variableName())
                .addFields(STModelNode.name(), STModelNode.variableName())
                .setTitleExpression(true)
                .addStatements(invokeLaterInTransaction(
                        "node.removeArgument(stParameter);",
                        "final nextgen.st.model.STValue stValue = canvas.modelDb.newSTValue(stModelNode.stModel);",
                        "final nextgen.st.model.STArgument stArgument = canvas.modelDb.newSTArgument(stParameter, stValue);",
                        "node.stModel.addArguments(stArgument);",
                        "canvas.addRelation(new STArgumentRelation(canvas, node, stModelNode, stArgument, stParameter));",
                        "node.setText(node.stRenderer.render(node.stModel));"
                )));

        stModelNode.addActions(newNodeAction(stModelNode, "AddInputValueArgumentAction", "Add")
                .addFields(STParameter.type(), STParameter.variableName())
                .setTitleExpression(true)
                .addStatements("final String s = com.generator.util.SwingUtil.showInputDialog(stParameter.getName(), canvas);")
                .addStatements("if (s == null || s.trim().length() == 0) return;")
                .addStatements(invokeLaterInTransaction(
                        "final nextgen.st.model.STValue stValue = canvas.modelDb.newSTValue(s.trim());",
                        "final nextgen.st.model.STArgument stArgument = canvas.modelDb.newSTArgument(stParameter, stValue);",
                        "node.stModel.addArguments(stArgument);",
                        "final STNode stValueNode = canvas.addNode(canvas.newSTNode(stValue).get());",
                        "canvas.addRelation(new STArgumentRelation(canvas, node, stValueNode, stArgument, stParameter));",
                        "node.setText(node.stRenderer.render(node.stModel));"
                )));

        stModelNode.addActions(newNodeAction(stModelNode, "AddClipboardValueArgumentAction", "Add")
                .addFields(STParameter.type(), STParameter.variableName())
                .setTitleExpression(true)
                .addStatements("final String s = com.generator.util.SwingUtil.fromClipboard();")
                .addStatements("if (s == null || s.trim().length() == 0) return;")
                .addStatements(invokeLaterInTransaction(
                        "final nextgen.st.model.STValue stValue = canvas.modelDb.newSTValue(s.trim());",
                        "final nextgen.st.model.STArgument stArgument = canvas.modelDb.newSTArgument(stParameter, stValue);",
                        "node.stModel.addArguments(stArgument);",
                        "final STNode stValueNode = canvas.addNode(canvas.newSTNode(stValue).get());",
                        "canvas.addRelation(new STArgumentRelation(canvas, node, stValueNode, stArgument, stParameter));",
                        "node.setText(node.stRenderer.render(node.stModel));"
                )));

        stModelNode.addActions(newNodeAction(stModelNode, "AddSTValueArgumentAction", "Add")
                .addFields(STParameter.type(), STParameter.variableName())
                .addFields(STValueNode.name(), STValueNode.variableName())
                .setTitleExpression(true)
                .addStatements(invokeLaterInTransaction(
                        "final nextgen.st.model.STArgument stArgument = canvas.modelDb.newSTArgument(stParameter, stValueNode.stValue);",
                        "node.stModel.addArguments(stArgument);",
                        "canvas.addRelation(new STArgumentRelation(canvas, node, stValueNode, stArgument, stParameter));",
                        "node.setText(node.stRenderer.render(node.stModel));"
                )));

        stModelNode.addActions(newNodeAction(stModelNode, "AddSTModelArgumentAction", "Add")
                .addFields(STParameter.type(), STParameter.variableName())
                .addFields(STModelNode.name(), STModelNode.variableName())
                .setTitleExpression(true)
                .addStatements(invokeLaterInTransaction(
                        "final nextgen.st.model.STValue stValue = canvas.modelDb.newSTValue(stModelNode.stModel);",
                        "final nextgen.st.model.STArgument stArgument = canvas.modelDb.newSTArgument(stParameter, stValue);",
                        "node.stModel.addArguments(stArgument);",
                        "canvas.addRelation(new STArgumentRelation(canvas, node, stModelNode, stArgument, stParameter));",
                        "node.setText(node.stRenderer.render(node.stModel));"
                )));

        stModelNode.addActions(newNodeAction(stModelNode, "AddKVInputValueArgumentAction", "Add")
                .addFields(STParameter.type(), STParameter.variableName())
                .setTitleExpression(true)
                .addStatements("final Map<nextgen.st.domain.STParameterKey, JTextField> fieldMap = new LinkedHashMap<>();")
                .addStatements(invokeLaterInTransaction(newBlock()
                        .addLines(newLine("stParameter.getKeys().forEach(stParameterKey -> ", "fieldMap.put(stParameterKey, new JTextField(15))", ");"))
                        .addLines("final JPanel inputPanel = new JPanel(new GridLayout(fieldMap.size(), 2));")
                        .addLines("inputPanel.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));")
                        .addLines(newLine("for (Map.Entry<nextgen.st.domain.STParameterKey, JTextField> fieldEntry : fieldMap.entrySet()) {", "}")
                                .addChildren("inputPanel.add(new JLabel(fieldEntry.getKey().getName()));")
                                .addChildren("inputPanel.add(fieldEntry.getValue());"))
                        .addLines(newBlock()
                                .addLines(newLine("com.generator.util.SwingUtil.showDialog(inputPanel, canvas, stParameter.getName(), new com.generator.util.SwingUtil.ConfirmAction() {", "});")
                                        .addChildren("@Override")
                                        .addChildren(newLine("public void verifyAndCommit() throws Exception {", "}")
                                                .addChildren(invokeLaterInTransaction(
                                                        "final java.util.List<nextgen.st.model.STArgumentKV> kvs = new ArrayList<>();",
                                                        newLine("for (Map.Entry<nextgen.st.domain.STParameterKey, JTextField> fieldEntry : fieldMap.entrySet()) {", "}")
                                                                .addChildren("final String value = fieldEntry.getValue().getText().trim();")
                                                                .addChildren("if (value.length() == 0) continue;")
                                                                .addChildren("kvs.add(canvas.modelDb.newSTArgumentKV(fieldEntry.getKey(), canvas.modelDb.newSTValue(value)));"),
                                                        "final nextgen.st.model.STArgument stArgument = canvas.modelDb.newSTArgument(stParameter, kvs);",
                                                        "node.stModel.addArguments(stArgument);",
                                                        "final STNode stkvNode = canvas.addNode(canvas.newSTNode(stParameter, stArgument).get());",
                                                        "canvas.addRelation(new STArgumentRelation(canvas, node, stkvNode, stArgument, stParameter));",
                                                        "node.setText(node.stRenderer.render(node.stModel));"
                                                )))))
                )));

        stModelNode.addActions(newNodeAction(stModelNode, "OpenArgument", "Open")
                .addFields(STParameter.type(), STParameter.variableName())
                .addFields(STArgument.type(), STArgument.variableName())
                .setTitleExpression(true)
                .addStatements(invokeLaterInTransaction(

                        newLine("if (stParameter.getType().equals(nextgen.st.domain.STParameterType.KVLIST)) {", "}")
                                .addChildren("final STNode dstNode = canvas.addNode(stArgument.getUuid(), canvas.newSTNode(stParameter, stArgument));")
                                .addChildren("canvas.addRelation(new STArgumentRelation(canvas, node, dstNode, stArgument, stParameter));")
                                .setEnd(newLine("} else {", "}")
                                        .addChildren("final nextgen.st.model.STValue stValue = stArgument.getValue();")
                                        .addChildren(newSwitch()
                                                .setSelector("stValue.getType()")
                                                .addCases("STMODEL", newBlock(
                                                        "final STNode dstNode = canvas.addNode(stValue.getStModel().getUuid(), canvas.newSTNode(stValue.getStModel()));",
                                                        "canvas.addRelation(new STArgumentRelation(canvas, node, dstNode, stArgument, stParameter));"
                                                ))
                                                .addCases("PRIMITIVE", newBlock(
                                                        "final STNode dstNode = canvas.addNode(stValue.getUuid(), canvas.newSTNode(stValue));",
                                                        "canvas.addRelation(new STArgumentRelation(canvas, node, dstNode, stArgument, stParameter));"
                                                ))
                                                .addCases("ENUM", newBlock(
                                                        "final STNode dstNode = canvas.addNode(stValue.getUuid(), canvas.newSTNode(stValue));",
                                                        "canvas.addRelation(new STArgumentRelation(canvas, node, dstNode, stArgument, stParameter));"
                                                )))),
                        "new LayoutTreeAction(node, canvas, event).actionPerformed(null);")));

        final NodeAction openAllSTArgument = newNodeAction(stModelNode, "OpenAllArguments", "Open All")
                .addStatements(invokeLaterInTransaction(
                        newBlock()
                                .addLines(newLine("node.forEachArgument((stArgument, stParameter) -> {", "});")
                                        .addChildren("new OpenArgument(\"\", node, canvas, event, stParameter, stArgument).actionPerformed(null);"))
                                .addLines("new LayoutTreeAction(node, canvas, event).actionPerformed(null);")));
        stModelNode.addOnKeyPressed("E", "OpenAllArguments");
        stModelNode.addOnKeyPressed("D", "Delete");
        registerRightClickAction(stModelNode, openAllSTArgument, openAllSTArgument.getName());

        final NodeAction removeSTArgument = newNodeAction(stModelNode, "RemoveArgument", "Remove")
                .addFields(STParameter.type(), STParameter.variableName())
                .addFields(STArgument.type(), STArgument.variableName())
                .setTitleExpression(true)
                .addStatements(invokeLaterInTransaction(
                        "canvas.removeRelation(UUID.fromString(stArgument.getUuid()));",
                        "node.stModel.removeArguments(stArgument);",
                        "node.setText(node.stRenderer.render(node.stModel));"));
        stModelNode.addActions(removeSTArgument);

        final NodeAction stModelToClipboard = newNodeAction(stModelNode, "ToClipboard", "To Clipboard")
                .addStatements(invokeLaterInTransaction("com.generator.util.SwingUtil.toClipboard(node.stRenderer.render(node.stModel));"));
        registerRightClickAction(stModelNode, stModelToClipboard, stModelToClipboard.getName());

        final NodeAction deleteSTModel = newNodeAction(stModelNode, "Delete", "Delete")
                .addStatements("if (!com.generator.util.SwingUtil.showConfirmDialog(canvas, \"Delete model ?\")) return;")
                .addStatements(invokeLaterInTransaction(
                        "node.close();",
                        "canvas.modelDb.remove(node.stModel);"));
        registerRightClickAction(stModelNode, deleteSTModel, deleteSTModel.getName());
        stModelNode.addOnRightClick(null, true);

        final NodeAction cloneSTModel = newNodeAction(stModelNode, "Clone", "Clone")
                .addStatements(invokeLaterInTransaction(
                        "final nextgen.st.model.STModel clone = canvas.modelDb.clone(node.stModel);",
                        "final STModelNode stModelNode = (STModelNode) canvas.newSTNode(clone).get();",
                        "canvas.addNode(stModelNode);",
                        "stModelNode.setText(stModelNode.stRenderer.render(stModelNode.stModel));"
                ));
        registerRightClickAction(stModelNode, cloneSTModel, cloneSTModel.getName());


        stModelNode.addOnRightClick(null, true);

        final NodeAction addFileSink = newNodeAction(stModelNode, "AddFileSink", "Add File Sink")
                .addStatements(invokeLaterInTransaction(newBlock(
                        newLinkedHashMap("fieldMap", String.type(), JTextField.type()),
                        put("fieldMap", asString("name"), JTextField.newInstance(STCanvas.methodCall("modelDb.getSTModelName", "node.stModel", asString("")), "15")),
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
                                                .addChildren(invokeLaterInTransaction(
                                                        "final nextgen.st.model.STFile stFile = canvas.modelDb.newSTFile(name, type, path, packageName);",
                                                        "node.stModel.addFiles(stFile);",
                                                        "final STFileNode dstNode = canvas.addNode(new STFileNode(canvas, stFile, node.stModel, node.stRenderer));",
                                                        "canvas.addRelation(new STSinkRelation(canvas, node, dstNode));"
                                                ))))
                )));
        registerRightClickAction(stModelNode, addFileSink, addFileSink.getName());

        final NodeAction openFileSInk = newNodeAction(stModelNode, "OpenFileSink", "Open File Sink")
                .addStatements(invokeLaterInTransaction(
                        newLine("node.stModel.getFiles().forEach(stFile -> {", "});")
                                .addChildren("final STFileNode dstNode = (STFileNode) canvas.addNode(stFile.getUuid(), canvas.newSTNode(stFile, node.stModel));")
                                .addChildren("canvas.addRelation(new STSinkRelation(canvas, node, dstNode));")));
        stModelNode.addOnKeyPressed("S", "OpenFileSink");
        registerRightClickAction(stModelNode, openFileSInk, openFileSInk.getName());

        final NodeAction openFile = newNodeAction(stFileNode, "OpenFile", "Open")
                .addStatements(invokeLaterInTransaction(newLine("try {", "} catch (Exception ex) { com.generator.util.SwingUtil.showException(canvas, ex); }")
                        .addChildren("java.awt.Desktop.getDesktop().open(nextgen.st.STGenerator.asFile(node.stFile));")));
        registerRightClickAction(stFileNode, openFile, openFile.getName());

        final CanvasAction newSTNodeAction = newCanvasAction(canvas, "NewSTValueNode", "New Value")
                .addStatements("final String s = com.generator.util.SwingUtil.showInputDialog(\"Value\", canvas);\n" +
                        "if (s == null || s.trim().length() == 0) return;")
                .addStatements(invokeLaterInTransaction(
                        "canvas.addNode(new STValueNode(canvas, canvas.modelDb.newSTValue(s), canvas.stRenderer));"));
        registerRightClickAction(canvas, newSTNodeAction, newSTNodeAction.getName());

        final CanvasAction newSTValueFromClipboard = newCanvasAction(canvas, "NewSTValueFromClipboard", "New Value from Clipboard")
                .addStatements("final String s = com.generator.util.SwingUtil.fromClipboard();")
                .addStatements("if (s == null || s.trim().length() == 0) return;")
                .addStatements(invokeLaterInTransaction(
                        "canvas.addNode(canvas.newSTNode(canvas.modelDb.newSTValue(s)).get());"));
        registerRightClickAction(canvas, newSTValueFromClipboard, newSTValueFromClipboard.getName());

        final CanvasAction loadAllAction = newCanvasAction(canvas, "LoadAllModels", "Load All Models")
                .addStatements(invokeLaterInTransaction(newLine("canvas.modelDb.findAllSTModel().forEach(stModel -> ", ");")
                        .addChildren("canvas.addNode(stModel.getUuid(), canvas.newSTNode(stModel))")));
        registerRightClickAction(canvas, loadAllAction, loadAllAction.getName());
        canvas.addOnKeyPressed("M", "LoadAllModels");

        Piccolo2DPatterns.addDefaultActionsToCanvas(canvas);
        Piccolo2DPatterns.addDefaultActionsToNode(node);

        writeJavaFile(canvas, stCanvasPackage, canvas.getName(), mainJava);
        writeJavaFile(node, stCanvasPackage, node.getName(), mainJava);
        writeJavaFile(relation, stCanvasPackage, relation.getName(), mainJava);

        writeJavaFile(stFileNode, stCanvasPackage, stFileNode.getName(), mainJava);
        writeJavaFile(stValueNode, stCanvasPackage, stValueNode.getName(), mainJava);
        writeJavaFile(stModelNode, stCanvasPackage, stModelNode.getName(), mainJava);
        writeJavaFile(stKVNode, stCanvasPackage, stKVNode.getName(), mainJava);
        writeJavaFile(stArgumentRelation, stCanvasPackage, stArgumentRelation.getName(), mainJava);
        writeJavaFile(stKVArgumentRelation, stCanvasPackage, stKVArgumentRelation.getName(), mainJava);
        writeJavaFile(stValueModelRelation, stCanvasPackage, stValueModelRelation.getName(), mainJava);
        writeJavaFile(stSinkRelation, stCanvasPackage, stSinkRelation.getName(), mainJava);
    }


    public MethodDeclaration newNodeSupplierMethod(Parameter parameter, Object... statements) {
        return newMethodDeclaration()
                .setName("newSTNode")
                .setType("java.util.function.Supplier<STNode>")
                .addParameters(parameter)
                .setBlockStmt(JavaPatterns.newBlockStmt().setStatements(statements));
    }

    private Line invokeLaterInTransaction(Object... statements) {
        return newLine("doLaterInTransaction(tx -> {", Arrays.asList(statements), "});");
    }

    private Line doInTransaction(Object... statements) {
        return newLine("canvas.modelDb.doInTransaction(tx -> {", Arrays.asList(statements), "});");
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
                ".collect(java.util.stream.Collectors.toList());");
    }

    public Line getSelectedSTModelNodes(String name) {
        return newLineIndent(
                "final java.util.List<STModelNode> " + name + " = canvas.getSelectedNodes()",
                "\t",
                ".filter(stNode -> stNode instanceof STModelNode)",
                ".filter(stNode -> !stNode.getUuid().equals(getUuid()))",
                ".map(stNode -> (STModelNode) stNode)",
                ".collect(java.util.stream.Collectors.toList());");
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
                .addRelations(newOneToMany("files", newEntity("STFile")
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

        writeNeo(mainJava, stModelPackage.getName(), newDomain("STModel")
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

        writeJsonWrapper(mainJava, stDomainPackage.getName(), newDomain("ST")
                .addEntities(newEntity("STAppModel")
                        .addRelations(newStringField("modelDb"))
                        .addRelations(newIntegerField("editorFontSize"))
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