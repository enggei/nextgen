package nextgen.projects;

import nextgen.templates.Piccolo2DPatterns;
import nextgen.templates.domain.Entity;
import nextgen.templates.java.*;
import nextgen.templates.piccolo2d.*;
import nextgen.templates.text.Line;
import org.junit.Test;

import java.util.Arrays;

import static nextgen.projects.BaseSTProject.JavaPatterns.*;
import static nextgen.st.STGenerator.writeJavaFile;
import static nextgen.templates.DomainPatterns.newEnum;
import static nextgen.templates.DomainPatterns.*;
import static nextgen.templates.Piccolo2DPatterns.*;
import static nextgen.templates.TextPatterns.*;

public class STProject extends BaseSTProject {

    @Test
    public void generateCanvasPackage() {

        final PCanvas canvas = newPCanvas()
                .setName(STCanvas.name())
                .setPackageName(stCanvasPackage.getName())
                .setNodeName(STNode.name())
                .setRelationName(STRelation.name())
                .addFields(STRenderer.asClassOrInterfaceType(), STRenderer.variableName())
                .addFields(STModelDB.asClassOrInterfaceType(), STModelDB.variableName())
                .addConstructorStatements(newExpressionStmt(SwingUtilities.staticMethodCall("invokeLater", newLambdaExpression("new LoadLastLayoutAction(this, null).actionPerformed(null)"))))
                .addMethods(newNodeSupplierMethod(STModel.asParameter(),
                        newReturnStatement(newLambdaExpression(STModelNode.asObjectCreationExpression("this", STModelDB.methodCall("findSTTemplateByUuid", STModel.methodCall("getStTemplate")), STModel.variableName(), STRenderer.variableName())))))
                .addMethods(newNodeSupplierMethod(STValue.asParameter(),
                        newReturnStatement(newLambdaExpression(STValueNode.asObjectCreationExpression("this", STValue.variableName(), STRenderer.variableName())))))
                .addMethods(newNodeSupplierMethod(newParameter(STParameter.asClassOrInterfaceType(), STParameter.variableName()),
                        newReturnStatement(newLambdaExpression(STKVNode.asObjectCreationExpression("this", STParameter.variableName(), STArgument.variableName(), STRenderer.variableName()))))
                        .addParameters(STArgument.asParameter()))
                .addMethods(newNodeSupplierMethod(STFile.asParameter(),
                        newReturnStatement(newLambdaExpression(STFileNode.asObjectCreationExpression("this", STFile.variableName(), STModel.variableName(), STRenderer.variableName()))))
                        .addParameters(STModel.asParameter()))
                .addMethods(newPublicFinalMethodDeclaration(RSyntaxTextArea.asClassOrInterfaceType(), "newTextArea", newBlockStmt()
                        .addStatements(RSyntaxTextArea.asFinalVariableDeclaration(RSyntaxTextArea.asObjectCreationExpression(10, 80)))
                        .addStatements(newExpressionStmt(RSyntaxTextArea.methodCall("setTabSize", 3)))
                        .addStatements(newExpressionStmt(RSyntaxTextArea.methodCall("addKeyListener", KeyAdapter.asObjectCreationExpression()
                                .addAnonymousClassBodies(newOverriddenMethodDeclaration("keyPressed", newBlockStmt()
                                        .addStatements("if (keyEvent.getModifiers() == " + KeyEvent.asFieldAccessExpression("CTRL_MASK") + " && keyEvent.getKeyCode() == " + KeyEvent.asFieldAccessExpression("VK_F") + ") {\n" +
                                                "\t" + newMethodCallExpression("format", RSyntaxTextArea.variableName()) + ";\n" +
                                                "\t}"))
                                        .addModifiers(Modifiers.PUBLIC).addParameters(KeyEvent.asParameter()))
                                .addAnonymousClassBodies("private void format(JTextArea txtEditor) {\n" +
                                        "                final int caretPosition = txtEditor.getCaretPosition();\n" +
                                        "                final StringBuilder spaces = new StringBuilder();\n" +
                                        "                for (int i = 0; i < txtEditor.getTabSize(); i++) spaces.append(\" \");\n" +
                                        "\n" +
                                        "                String[] split = txtEditor.getText().split(\"\\n\");\n" +
                                        "                final StringBuilder formatted = new StringBuilder();\n" +
                                        "                for (String s : split) formatted.append(s.replace(spaces, \"\\t\")).append(\"\\n\");\n" +
                                        "                split = formatted.toString().split(\"\\n\");\n" +
                                        "                System.out.println(formatted.toString());\n" +
                                        "\n" +
                                        "                final StringBuilder formatted2 = new StringBuilder();\n" +
                                        "                for (String s : split) {\n" +
                                        "                    if (s.trim().length() == 0) {\n" +
                                        "                        formatted2.append(\"\\n\");\n" +
                                        "                        continue;\n" +
                                        "                    }\n" +
                                        "\n" +
                                        "                    final char[] c = s.toCharArray();\n" +
                                        "                    for (int i = 0; i < c.length; i++) {\n" +
                                        "                        if (c[i] == '\\t') {\n" +
                                        "                            formatted2.append(c[i]);\n" +
                                        "                            continue;\n" +
                                        "                        }\n" +
                                        "                        if (c[i] == ' ') continue;\n" +
                                        "                        formatted2.append(s.substring(i));\n" +
                                        "                        break;\n" +
                                        "                    }\n" +
                                        "\n" +
                                        "                    formatted2.append(\"\\n\");\n" +
                                        "                }\n" +
                                        "                System.out.println(formatted2.toString());\n" +
                                        "\n" +
                                        "                txtEditor.setText(formatted2.toString().trim());\n" +
                                        "                txtEditor.setCaretPosition(Math.min(formatted2.toString().trim().length(), caretPosition));\n" +
                                        "            }"))))
                        .addStatements(newReturnStatement(newExpression(RSyntaxTextArea.variableName())))))
                .addMethods(newPublicFinalMethodDeclaration(JTextField.asClassOrInterfaceType(), "newTextField", newBlockStmt(
                        "return newTextField(\"\", columns);"))
                        .addParameters(intType.asParameter().setName("columns")))
                .addMethods(newPublicFinalMethodDeclaration(JTextField.asClassOrInterfaceType(), "newTextField", newBlockStmt(
                        "javax.swing.JTextField textField = new javax.swing.JTextField(content, columns);",
                        "textField.addMouseListener(new java.awt.event.MouseAdapter() {\n" +
                                "\t@Override\n" +
                                "\tpublic void mouseClicked(java.awt.event.MouseEvent e) {\n" +
                                "\t\tif (javax.swing.SwingUtilities.isRightMouseButton(e))\n" +
                                "\t\t\tjavax.swing.SwingUtilities.invokeLater(() -> {\n" +
                                "\t\t\t\tfinal javax.swing.JPopupMenu pop = new javax.swing.JPopupMenu();\n" +
                                "\t\t\t\tpop.add(new AbstractAction(\"Set from clipboard\") {\n" +
                                "\t\t\t\t\t@Override\n" +
                                "\t\t\t\t\tpublic void actionPerformed(ActionEvent e) {\n" +
                                "\t\t\t\t\t\ttextField.setText(com.generator.util.SwingUtil.fromClipboard());\n" +
                                "\t\t\t\t\t}\n" +
                                "\t\t\t\t});\n" +
                                "\t\t\t\tpop.show(textField, e.getX(), e.getY());\n" +
                                "\t\t\t});\n" +
                                "\t}\n" +
                                "});",
                        "textField.addFocusListener(new java.awt.event.FocusAdapter() {\n" +
                                "\t@Override\n" +
                                "\tpublic void focusGained(java.awt.event.FocusEvent evt) {\n" +
                                "\t\tjavax.swing.SwingUtilities.invokeLater(() -> ((javax.swing.JTextField) evt.getSource()).selectAll());\n" +
                                "\t}\n" +
                                "\n" +
                                "\t@Override\n" +
                                "\tpublic void focusLost(java.awt.event.FocusEvent evt) {\n" +
                                "\t\tjavax.swing.SwingUtilities.invokeLater(() -> {\n" +
                                "\t\t\t((javax.swing.JTextField) evt.getSource()).setSelectionStart(0);\n" +
                                "\t\t\t((javax.swing.JTextField) evt.getSource()).setSelectionEnd(0);\n" +
                                "\t\t});\n" +
                                "\t}\n" +
                                "});",
                        "return textField;"))
                        .addParameters(String.asParameter().setName("content"))
                        .addParameters(intType.asParameter().setName("columns")))
                .addCanvasActionmethods(newProtectedMethodDeclaration("doLaterInTransaction", newBlockStmt()
                        .addStatements(invokeLater(newMethodCallExpression(newFieldAccessExpression(STCanvas.variableName(), "modelDb"), "doInTransaction", "consumer", newLambdaExpression().addParameters("throwable").setBody(SwingUtil.staticMethodCall("showException", "canvas", "throwable"))))))
                        .addParameters(Consumer.asParameter(NeoTransaction.asClassOrInterfaceType())));

        final PNode node = newPNode()
                .setName(STNode.name())
                .setCanvasName(canvas.getName())
                .setPackageName(stCanvasPackage.getName())
                .addMethods(newNodeMethod()
                        .setIsStatic(true)
                        .setName("cut")
                        .addParams("text", "String")
                        .setType("String")
                        .setReturnStatement("text.substring(0, Math.min(text.length(), 20));"))
                .addMethods(newProtectedMethodDeclaration("doLaterInTransaction", newBlockStmt()
                        .addStatements("javax.swing.SwingUtilities.invokeLater(() -> canvas.modelDb.doInTransaction(consumer, throwable -> com.generator.util.SwingUtil.showException(canvas, throwable)));"))
                        .addParameters(Consumer.asParameter(NeoTransaction).setName("consumer")))
                .addNodeActionmethods(newProtectedMethodDeclaration("doLaterInTransaction", newBlockStmt()
                        .addStatements("node.doLaterInTransaction(consumer);"))
                        .addParameters(Consumer.asParameter(NeoTransaction).setName("consumer")));

        final PRelation relation = newPRelation()
                .setName(STRelation.name())
                .setNodeName(node.getName())
                .setCanvasName(canvas.getName())
                .setPackageName(stCanvasPackage.getName())
                .addMethods(newProtectedMethodDeclaration("doLaterInTransaction", newBlockStmt()
                        .addStatements("javax.swing.SwingUtilities.invokeLater(() -> canvas.modelDb.doInTransaction(consumer, throwable -> com.generator.util.SwingUtil.showException(canvas, throwable)));"))
                        .addParameters(newParameter()
                                .setType("java.util.function.Consumer<org.neo4j.graphdb.Transaction>")
                                .setName("consumer")))
                .addRelationActionmethods(newProtectedMethodDeclaration("doLaterInTransaction", newBlockStmt()
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
                .addFields(STArgument.asClassOrInterfaceType(), STArgument.variableName())
                .addFields(STParameter.asClassOrInterfaceType(), STParameter.variableName())
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
                        .addStatements(invokeLaterInTransaction("src.stModel.removeArguments(relation.stArgument);", "canvas.removeRelation(relation.getUuid());")));

        final PRelationImpl stKVArgumentRelation = newPRelationImpl()
                .setCanvasName(canvas.getName())
                .setRelationName(STRelation.name())
                .setPackageName(stCanvasPackage.getName())
                .setSrcNode(STKVNode.name())
                .setDstNode(STNode.name())
                .setName(STKVArgumentRelation.name())
                .setUuidExpression("UUID.fromString(stArgumentKV.getUuid())")
                .addFields(STArgument.asClassOrInterfaceType(), STArgument.variableName())
                .addFields(STParameterKey.asClassOrInterfaceType(), STParameterKey.variableName())
                .addFields(STArgumentKV.asClassOrInterfaceType(), STArgumentKV.variableName())
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
                                "relation.stArgument.removeKeyValues(relation.stArgumentKV);")));

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
                                "canvas.modelDb.remove(src.stValue);")));

        final PNodeImpl stFileNode = newPNodeImpl(canvas, node)
                .setName(STFileNode.name())
                .setPackageName(stCanvasPackage.getName())
                .setNodeName(STNode.name())
                .addFields(STFile.asClassOrInterfaceType(), STFile.variableName())
                .addFields(STModel.asClassOrInterfaceType(), STModel.variableName())
                .addFields(STRenderer.asClassOrInterfaceType(), STRenderer.variableName())
                .setInitText(newMethodCallExpression(STGenerator.staticMethodCall("asFile", STFile.variableName()), "getAbsolutePath"))
                .setUuid(UUID.staticMethodCall("fromString", STFile.methodCall("getUuid")))
                .addOnLeftClick(invokeLaterInTransaction(
                        "if (stRenderer == null || stModel == null || stFile.getPath() == null) return;",
                        newExpressionStmt(STGenerator.staticMethodCall("writeToFile", STRenderer.methodCall("render", STModel.variableName()), STFile.methodCall("getPackageName"), STFile.methodCall("getName"), STFile.methodCall("getType"), File.asObjectCreationExpression(STFile.methodCall("getPath"))))))
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
                        "node.setText(" + newMethodCallExpression(STGenerator.staticMethodCall("asFile", newFieldAccessExpression("node", "stFile")), "getAbsolutePath") + ");"
                )));

        final PRelationImpl stSinkRelation = newPRelationImpl()
                .setCanvasName(canvas.getName())
                .setRelationName(STRelation.name())
                .setPackageName(stCanvasPackage.getName())
                .setSrcNode(STModelNode.name())
                .setDstNode(STFileNode.name())
                .setName(STSinkRelation.name())
                .setNameExpression("\"SINK\"")
                .setUuidExpression("dst.getUuid()")
                .addOnRightClick(false, "Delete")
                .addOnKeyPressed("D", "Delete");

        stSinkRelation.addActions(newRelationAction(stSinkRelation, "Delete", "Delete")
                .addStatements("if (!com.generator.util.SwingUtil.showConfirmDialog(canvas, \"Delete ?\")) return;")
                .addStatements("final STModelNode src = (STModelNode) relation.getSrc();")
                .addStatements("final STFileNode dst = (STFileNode) relation.getDst();")
                .addStatements(invokeLaterInTransaction(
                        "src.stModel.removeFiles(dst.stFile);",
                        "canvas.removeRelation(relation.getUuid());")));

        final Statement fieldMapDeclaration = newLinkedHashMap("fieldMap", String.asClassOrInterfaceType(), JTextField.asClassOrInterfaceType());
        final FieldAccessExpression nodeStFileAccess = newFieldAccessExpression("node", "stFile");

        final NodeAction editFileSinkAction = newNodeAction(stFileNode, "EditFileSink", "Edit")
                .addStatements(doInTransaction(
                        fieldMapDeclaration,
                        newExpressionStmt(newMethodCallExpression(newExpression("fieldMap"), "put", asString("name"), STCanvas.methodCall("newTextField", newMethodCallExpression(nodeStFileAccess, "getName"), "15"))),
                        newExpressionStmt(newMethodCallExpression(newExpression("fieldMap"), "put", asString("type"), STCanvas.methodCall("newTextField", newMethodCallExpression(nodeStFileAccess, "getType"), "15"))),
                        newExpressionStmt(newMethodCallExpression(newExpression("fieldMap"), "put", asString("path"), STCanvas.methodCall("newTextField", newMethodCallExpression(nodeStFileAccess, "getPath"), "15"))),
                        newExpressionStmt(newMethodCallExpression(newExpression("fieldMap"), "put", asString("package"), STCanvas.methodCall("newTextField", newMethodCallExpression(nodeStFileAccess, "getPackageName"), "15"))),
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
                .addFields(STValue.asClassOrInterfaceType(), STValue.variableName())
                .addFields(STRenderer.asClassOrInterfaceType(), STRenderer.variableName())
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
                .addFields(STParameter.asClassOrInterfaceType(), STParameter.variableName())
                .addFields(STArgument.asClassOrInterfaceType(), STArgument.variableName())
                .addFields(STRenderer.asClassOrInterfaceType(), STRenderer.variableName())
                .setInitText("stParameter.getName()")
                .addMethods(newProtectedMethodDeclaration("removeArgument", newBlockStmt()
                        .addStatements(newLine("stArgument.getKeyValues().filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.uuid())).findAny().ifPresent(stArgumentKV -> {", "});")
                                .addChildren("canvas.removeRelation(UUID.fromString(stArgumentKV.getUuid()));")
                                .addChildren("stArgument.removeKeyValues(stArgumentKV);")))
                        .addParameters(newParameter(STParameterKey.asClassOrInterfaceType(), STParameterKey.variableName())))
                .addNewNodeAddedStatements(newLine("stParameter.getKeys().forEach(stParameterKey -> stArgument.getKeyValues().filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.uuid())).forEach(stArgumentKV -> {", "}));")
                        .addChildren("final nextgen.st.model.STValue value = stArgumentKV.getValue();")
                        .addChildren(newSwitchStmt("value.getType()")
                                .addEntries(newSwitchEntryStmt().addLabels("STMODEL").addStatements(newBlock(
                                        "final nextgen.st.model.STModel stModel = value.getStModel();",
                                        "if (node.getUuid().equals(UUID.fromString(stModel.getUuid()))) canvas.addRelation(new STKVArgumentRelation(canvas, STKVNode.this, node, stArgument, stParameterKey, stArgumentKV));", "break;"
                                )))
                                .addEntries(newSwitchEntryStmt().addLabels("PRIMITIVE").addStatements(newBlock(
                                        "if (node.getUuid().equals(UUID.fromString(value.getUuid()))) canvas.addRelation(new STKVArgumentRelation(canvas, STKVNode.this, node, stArgument, stParameterKey, stArgumentKV));", "break;"
                                )))
                                .addEntries(newSwitchEntryStmt().addLabels("ENUM").addStatements(newBlock(
                                        "if (node.getUuid().equals(UUID.fromString(value.getUuid()))) canvas.addRelation(new STKVArgumentRelation(canvas, STKVNode.this, node, stArgument, stParameterKey, stArgumentKV));", "break;"
                                )))))
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
                .addFields(STParameter.asClassOrInterfaceType(), STParameter.variableName())
                .addFields(STParameterKey.asClassOrInterfaceType(), STParameterKey.variableName())
                .addFields(STArgument.asClassOrInterfaceType(), STArgument.variableName())
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
                .addFields(STParameter.asClassOrInterfaceType(), STParameter.variableName())
                .addFields(STParameterKey.asClassOrInterfaceType(), STParameterKey.variableName())
                .addFields(STArgument.asClassOrInterfaceType(), STArgument.variableName())
                .addFields(STValueNode.name(), STValueNode.variableName())
                .setTitleExpression(true)
                .addStatements(invokeLaterInTransaction(
                        "node.removeArgument(stParameterKey);",
                        "final nextgen.st.model.STArgumentKV stArgumentKV = canvas.modelDb.newSTArgumentKV(stParameterKey, stValueNode.stValue);",
                        "node.stArgument.addKeyValues(stArgumentKV);",
                        "canvas.addRelation(new STKVArgumentRelation(canvas, node, stValueNode, stArgument, stParameterKey, stArgumentKV));"
                )));

        stKVNode.addActions(newNodeAction(stKVNode, "SetSTModelArgumentAction", "Set")
                .addFields(STParameter.asClassOrInterfaceType(), STParameter.variableName())
                .addFields(STParameterKey.asClassOrInterfaceType(), STParameterKey.variableName())
                .addFields(STArgument.asClassOrInterfaceType(), STArgument.variableName())
                .addFields(STModelNode.name(), STModelNode.variableName())
                .setTitleExpression(true)
                .addStatements(invokeLaterInTransaction(
                        "node.removeArgument(stParameterKey);",
                        STValue.asFinalVariableDeclaration("canvas.modelDb.newSTValue(stModelNode.stModel)"),
                        STArgumentKV.asFinalVariableDeclaration("canvas.modelDb.newSTArgumentKV(stParameterKey, stValue);"),
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
                .addFields(STArgument.asClassOrInterfaceType(), STArgument.variableName())
                .addFields(STParameterKey.asClassOrInterfaceType(), STParameterKey.variableName())
                .addFields(STArgumentKV.asClassOrInterfaceType(), STArgumentKV.variableName())
                .addStatements(invokeLaterInTransaction(
                        STValue.asFinalVariableDeclaration(STArgumentKV.methodCall("getValue")),
                        newSwitchStmt("stValue.getType()")
                                .addEntries(newSwitchEntryStmt().addLabels("STMODEL").addStatements(newBlock(
                                        "canvas.addNode(stValue.getStModel().getUuid(), canvas.newSTNode(stValue.getStModel()));",
                                        "canvas.addRelation(new STKVArgumentRelation(canvas, node, canvas.getNode(UUID.fromString(stValue.getStModel().getUuid())), node.stArgument, stParameterKey, stArgumentKV));", "break;")))
                                .addEntries(newSwitchEntryStmt().addLabels("PRIMITIVE").addStatements(newBlock(
                                        "canvas.addNode(stValue.getUuid(), canvas.newSTNode(stValue));",
                                        "canvas.addRelation(new STKVArgumentRelation(canvas, node, canvas.getNode(UUID.fromString(stValue.getUuid())), node.stArgument, stParameterKey, stArgumentKV));", "break;")))
                                .addEntries(newSwitchEntryStmt().addLabels("ENUM").addStatements(newBlock(
                                        "canvas.addNode(stValue.getUuid(), canvas.newSTNode(stValue));",
                                        "canvas.addRelation(new STKVArgumentRelation(canvas, node, canvas.getNode(UUID.fromString(stValue.getUuid())), node.stArgument, stParameterKey, stArgumentKV));", "break;"))),
                        "new LayoutTreeAction(node, canvas, event).actionPerformed(null);"));
        stKVNode.addActions(openKVArgument);

        final NodeAction removeKVArgument = newNodeAction(stKVNode, "RemoveArgument", "Remove")
                .setTitleExpression(true)
                .addFields(STArgument.asClassOrInterfaceType(), STArgument.variableName())
                .addFields(STParameterKey.asClassOrInterfaceType(), STParameterKey.variableName())
                .addFields(STArgumentKV.asClassOrInterfaceType(), STArgumentKV.variableName())
                .addStatements(invokeLaterInTransaction(
                        newExpressionStmt(STCanvas.methodCall("removeRelation", UUID.staticMethodCall("fromString", STArgumentKV.methodCall("getUuid")))),
                        newExpressionStmt(STArgument.methodCall("removeKeyValues", STArgumentKV.variableName()))));
        stKVNode.addActions(removeKVArgument);

        final NodeAction editSTValue = newNodeAction(stValueNode, "EditSTValue", "Edit")
                .addStatements(RSyntaxTextArea.asFinalVariableDeclaration(STCanvas.methodCall("newTextArea")))
                .addStatements(doInTransaction(
                        "rSyntaxTextArea.setText(node.stValue.getValue());"
                ))
                .addStatements("final JPanel inputPanel = new JPanel(new BorderLayout());")
                .addStatements("inputPanel.add(rSyntaxTextArea, BorderLayout.CENTER);")
                .addStatements("inputPanel.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));")
                .addStatements(newBlock()
                        .addLines(newLine("com.generator.util.SwingUtil.showDialog(inputPanel, canvas, \"Edit\", new com.generator.util.SwingUtil.ConfirmAction() {", "});")
                                .addChildren("@Override")
                                .addChildren(newLine("public void verifyAndCommit() throws Exception {", "}")
                                        .addChildren("final String s = rSyntaxTextArea.getText().trim();")
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

        final MethodDeclaration forEachArgument = newProtectedMethodDeclaration("forEachArgument", newBlockStmt()
                .addStatements(newLine("stTemplate.getParameters()" +
                        ".forEach(stParameter -> stModel.getArguments()" +
                        ".filter(stArgument -> stArgument.getStParameter().equals(stParameter.uuid()))" +
                        ".forEach(stArgument -> consumer.accept(stArgument, stParameter)));")))
                .addParameters(BiConsumer.asParameter(STArgument.asClassOrInterfaceType(), STParameter.asClassOrInterfaceType()));

        final MethodDeclaration refersTo = newProtectedMethodDeclaration("refersTo", newBlockStmt()
                .addStatements(newBlock(
                        "if (stArgument == null || stParameter == null || node == null) return false;",
                        newSwitchStmt("stParameter.getType()")
                                .addEntries(newSwitchEntryStmt("SINGLE", newBlockStmt(
                                        "final nextgen.st.model.STValue value = stArgument.getValue();",
                                        "if (value != null) return UUID.fromString(value.getUuid()).equals(node.getUuid()) || (value.getType().equals(nextgen.st.model.STValueType.STMODEL) && value.getStModel() != null && UUID.fromString(value.getStModel().getUuid()).equals(node.getUuid()));", "break;")))
                                .addEntries(newSwitchEntryStmt("LIST", newBlockStmt(
                                        "final nextgen.st.model.STValue value = stArgument.getValue();",
                                        "if (value != null) return UUID.fromString(value.getUuid()).equals(node.getUuid()) || (value.getType().equals(nextgen.st.model.STValueType.STMODEL) && value.getStModel() != null && UUID.fromString(value.getStModel().getUuid()).equals(node.getUuid()));", "break;")))
                                .addEntries(newSwitchEntryStmt("KVLIST", newBlockStmt(
                                        "if (UUID.fromString(stArgument.getUuid()).equals(node.getUuid())) return true;", "break;"))))
                        .addLines("return false;")))
                .addParameters(newParameter(STArgument.asClassOrInterfaceType(), STArgument.variableName()))
                .addParameters(newParameter(STParameter.asClassOrInterfaceType(), STParameter.variableName()))
                .addParameters(newParameter(STNode.asClassOrInterfaceType(), "node"))
                .setType("boolean");

        final PNodeImpl stModelNode = newPNodeImpl(canvas, node)
                .setPackageName(stCanvasPackage.getName())
                .setName(STModelNode.name())
                .addFields(STTemplate.asClassOrInterfaceType(), STTemplate.variableName())
                .addFields(STModel.asClassOrInterfaceType(), STModel.variableName())
                .addFields(STRenderer.asClassOrInterfaceType(), STRenderer.variableName())
                .setInitText(STTemplate.methodCall("getName") + " + " + asString(" : \\n") + " + " + STRenderer.methodCall("render", STModel.variableName()))
                .setUuid(UUID.staticMethodCall("fromString", STModel.methodCall("getUuid")))
                .addMethods(forEachArgument)
                .addMethods(refersTo)
                .addMethods(newProtectedMethodDeclaration("removeArgument", newBlockStmt()
                        .addStatements(newLine("stModel.getArguments().filter(existing -> existing.getStParameter().equals(stParameter.uuid())).findAny().ifPresent(existing -> {", "});")
                                .addChildren("canvas.removeRelation(UUID.fromString(existing.getUuid()));")
                                .addChildren("stModel.removeArguments(existing);")))
                        .addParameters(newParameter(STParameter.asClassOrInterfaceType(), STParameter.variableName())))
                .addAddedToCanvasStatements("canvas.getAllNodes().forEach(this::newNodeAdded);")
                .addNewNodeAddedStatements(newLine("forEachArgument((stArgument, stParameter) -> {", "});")
                        .addChildren("if (refersTo(stArgument, stParameter, node)) canvas.addRelation(new STArgumentRelation(canvas, STModelNode.this, node, stArgument, stParameter));"))
                .addOnLeftClick(doInTransactionSilent("setText(stRenderer.render(stModel));"))
                .addRightClickStatements(getSelectedSTValueNodes("stValueNodes"))
                .addRightClickStatements(getSelectedSTModelNodes("stModelNodes"))
                .addRightClickStatements(doInTransactionSilent()
                        .addChildren(newLine("stTemplate.getParameters().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stParameter -> {", "});")
                                .addChildren("final JMenu stParameterMenu = new JMenu(stParameter.getName());")
                                .addChildren(newSwitchStmt("stParameter.getType()")
                                        .addEntries(newSwitchEntryStmt("SINGLE", newBlockStmt()
                                                .addStatements(newLine("stValueNodes.forEach(stNode -> {", "});")
                                                        .addChildren(newLine("stParameterMenu.add(new SetSTValueArgumentAction(\"Set \" + stParameter.getName() + \" = \" + cut(stNode.getText()), STModelNode.this, canvas, event, stParameter, stNode));")))
                                                .addStatements(newLine("stModelNodes.forEach(stNode -> {", "});")
                                                        .addChildren(newLine("stParameterMenu.add(new SetSTModelArgumentAction(\"Set \" + stParameter.getName() + \" = \" + cut(stNode.getText()), STModelNode.this, canvas, event, stParameter, stNode));")))
                                                .addStatements(newLine("stParameterMenu.add(new SetInputValueArgumentAction(\"Set \" + stParameter.getName(), STModelNode.this, canvas, event, stParameter));"))
                                                .addStatements(newLine("stParameterMenu.add(new SetClipboardValueArgumentAction(\"Set \" + stParameter.getName() + \" from clipboard\", STModelNode.this, canvas, event, stParameter));", "break;"))))
                                        .addEntries(newSwitchEntryStmt("LIST", newBlockStmt()
                                                .addStatements(newLine("stValueNodes.forEach(stNode -> {", "});")
                                                        .addChildren(newLine("stParameterMenu.add(new AddSTValueArgumentAction(\"Add \" + stParameter.getName() + \" = \" + cut(stNode.getText()), STModelNode.this, canvas, event, stParameter, stNode));")))
                                                .addStatements(newLine("stModelNodes.forEach(stNode -> {", "});")
                                                        .addChildren(newLine("stParameterMenu.add(new AddSTModelArgumentAction(\"Add \" + stParameter.getName() + \" = \" + cut(stNode.getText()), STModelNode.this, canvas, event, stParameter, stNode));")))
                                                .addStatements(newLine("stParameterMenu.add(new AddInputValueArgumentAction(\"Add \" + stParameter.getName(), STModelNode.this, canvas, event, stParameter));"))
                                                .addStatements(newLine("stParameterMenu.add(new AddClipboardValueArgumentAction(\"Add from clipboard \" + stParameter.getName(), STModelNode.this, canvas, event, stParameter));", "break;"))))
                                        .addEntries(newSwitchEntryStmt("KVLIST", newBlockStmt("stParameterMenu.add(new AddKVInputValueArgumentAction(\"Add \" + stParameter.getName(), STModelNode.this, canvas, event, stParameter));", "break;"))))
                                .addChildren(newLine("stModel.getArguments().filter(existing -> existing.getValue() != null).filter(stArgument -> stArgument.getStParameter().equals(stParameter.uuid())).forEach(stArgument -> {", "});")
                                        .addChildren("stParameterMenu.add(new OpenArgument(\"Open \" + (stParameter.getType().equals(nextgen.st.domain.STParameterType.KVLIST) ? stParameter.getName() : cut(canvas.stRenderer.render(stArgument.getValue()))), STModelNode.this, canvas, event, stParameter, stArgument));")
                                        .addChildren("stParameterMenu.add(new RemoveArgument(\"Remove \" + (stParameter.getType().equals(nextgen.st.domain.STParameterType.KVLIST) ? stParameter.getName() : cut(canvas.stRenderer.render(stArgument.getValue()))), STModelNode.this, canvas, event, stParameter, stArgument));"))
                                .addChildren("if (stParameterMenu.getMenuComponentCount() != 0) pop.add(stParameterMenu);"))
                        .addChildren("if (pop.getComponents().length != 0) pop.addSeparator();"));

        stModelNode.addActions(newNodeAction(stModelNode, "SetInputValueArgumentAction", "Set")
                .addFields(STParameter.asClassOrInterfaceType(), STParameter.variableName())
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
                .addFields(STParameter.asClassOrInterfaceType(), STParameter.variableName())
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
                .addFields(STParameter.asClassOrInterfaceType(), STParameter.variableName())
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
                .addFields(STParameter.asClassOrInterfaceType(), STParameter.variableName())
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
                .addFields(STParameter.asClassOrInterfaceType(), STParameter.variableName())
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
                .addFields(STParameter.asClassOrInterfaceType(), STParameter.variableName())
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
                .addFields(STParameter.asClassOrInterfaceType(), STParameter.variableName())
                .addFields(STValueNode.name(), STValueNode.variableName())
                .setTitleExpression(true)
                .addStatements(invokeLaterInTransaction(
                        "final nextgen.st.model.STArgument stArgument = canvas.modelDb.newSTArgument(stParameter, stValueNode.stValue);",
                        "node.stModel.addArguments(stArgument);",
                        "canvas.addRelation(new STArgumentRelation(canvas, node, stValueNode, stArgument, stParameter));",
                        "node.setText(node.stRenderer.render(node.stModel));"
                )));

        stModelNode.addActions(newNodeAction(stModelNode, "AddSTModelArgumentAction", "Add")
                .addFields(STParameter.asClassOrInterfaceType(), STParameter.variableName())
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
                .addFields(STParameter.asClassOrInterfaceType(), STParameter.variableName())
                .setTitleExpression(true)
                .addStatements("final Map<nextgen.st.domain.STParameterKey, JTextField> fieldMap = new LinkedHashMap<>();")
                .addStatements(invokeLaterInTransaction(newBlock()
                        .addLines(newLine("stParameter.getKeys().forEach(stParameterKey -> ", "fieldMap.put(stParameterKey, canvas.newTextField(15))", ");"))
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
                .addFields(STParameter.asClassOrInterfaceType(), STParameter.variableName())
                .addFields(STArgument.asClassOrInterfaceType(), STArgument.variableName())
                .setTitleExpression(true)
                .addStatements(invokeLaterInTransaction(

                        newLine("if (stParameter.getType().equals(nextgen.st.domain.STParameterType.KVLIST)) {", "}")
                                .addChildren("final STNode dstNode = canvas.addNode(stArgument.getUuid(), canvas.newSTNode(stParameter, stArgument));")
                                .addChildren("canvas.addRelation(new STArgumentRelation(canvas, node, dstNode, stArgument, stParameter));")
                                .setEnd(newLine("} else {", "}")
                                        .addChildren("final nextgen.st.model.STValue stValue = stArgument.getValue();")
                                        .addChildren(newSwitchStmt("stValue.getType()")
                                                .addEntries(newSwitchEntryStmt("STMODEL", newBlockStmt(
                                                        "final STNode dstNode = canvas.addNode(stValue.getStModel().getUuid(), canvas.newSTNode(stValue.getStModel()));",
                                                        "canvas.addRelation(new STArgumentRelation(canvas, node, dstNode, stArgument, stParameter));", "break;"
                                                )))
                                                .addEntries(newSwitchEntryStmt("PRIMITIVE", newBlockStmt(
                                                        "final STNode dstNode = canvas.addNode(stValue.getUuid(), canvas.newSTNode(stValue));",
                                                        "canvas.addRelation(new STArgumentRelation(canvas, node, dstNode, stArgument, stParameter));", "break;"
                                                )))
                                                .addEntries(newSwitchEntryStmt("ENUM", newBlockStmt(
                                                        "final STNode dstNode = canvas.addNode(stValue.getUuid(), canvas.newSTNode(stValue));",
                                                        "canvas.addRelation(new STArgumentRelation(canvas, node, dstNode, stArgument, stParameter));", "break;"
                                                ))))),
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
                .addFields(STParameter.asClassOrInterfaceType(), STParameter.variableName())
                .addFields(STArgument.asClassOrInterfaceType(), STArgument.variableName())
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
                        fieldMapDeclaration,
                        newExpressionStmt(newMethodCallExpression(newExpression("fieldMap"), "put", asString("name"), STCanvas.methodCall("newTextField", STCanvas.methodCall("modelDb.getSTModelName", "node.stModel", asString("")), "15"))),
                        newExpressionStmt(newMethodCallExpression(newExpression("fieldMap"), "put", asString("type"), STCanvas.methodCall("newTextField", "15"))),
                        newExpressionStmt(newMethodCallExpression(newExpression("fieldMap"), "put", asString("path"), STCanvas.methodCall("newTextField", "15"))),
                        newExpressionStmt(newMethodCallExpression(newExpression("fieldMap"), "put", asString("package"), STCanvas.methodCall("newTextField", STCanvas.methodCall("modelDb.getSTModelPackage", "node.stModel", asString("")), "15"))),
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
                                .addChildren("canvas.addRelation(new STSinkRelation(canvas, node, dstNode));")
                                .addChildren("new LayoutTreeAction(node, canvas, event).actionPerformed(null);")));
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

        final CanvasAction saveLastLayoutAction = newCanvasAction(canvas, "SaveLastLayoutAction", "Save last layout")
                .addStatements(invokeLaterInTransaction(
                        "final nextgen.st.canvas.layout.LayoutNeoFactory layoutNeoFactory = new nextgen.st.canvas.layout.LayoutNeoFactory(canvas.modelDb.getDatabaseService());\n" +
                                "final nextgen.st.canvas.layout.Layout last = layoutNeoFactory.findOrCreateLayoutByName(\"last\");\n" +
                                "\n" +
                                "last.getNodes().forEach(layoutNode -> {\n" +
                                "\tlayoutNode.getNode().getRelationships().forEach(org.neo4j.graphdb.Relationship::delete);\n" +
                                "\tlayoutNode.getNode().delete();\n" +
                                "});\n" +
                                "\n" +
                                "canvas.getAllNodes().forEach(stNode -> {\n" +
                                "\tfinal nextgen.st.canvas.layout.LayoutNode layoutNode = layoutNeoFactory.newLayoutNode();\n" +
                                "\tlayoutNode.setX(stNode.getOffset().getX());\n" +
                                "\tlayoutNode.setY(stNode.getOffset().getY());\n" +
                                "\n" +
                                "\tif (stNode instanceof STModelNode) {\n" +
                                "\t\tfinal org.neo4j.graphdb.Node node = ((STModelNode) stNode).stModel.getNode();\n" +
                                "\t\tlayoutNode.getNode().createRelationshipTo(node, org.neo4j.graphdb.RelationshipType.withName(\"ref\"));\n" +
                                "\t} else if (stNode instanceof STValueNode) {\n" +
                                "\t\tfinal org.neo4j.graphdb.Node node = ((STValueNode) stNode).stValue.getNode();\n" +
                                "\t\tlayoutNode.getNode().createRelationshipTo(node, org.neo4j.graphdb.RelationshipType.withName(\"ref\"));\n" +
                                "\t}\n" +
                                "\n" +
                                "\tlast.addNodes(layoutNode);\n" +
                                "});"

                ));
        registerRightClickAction(canvas, saveLastLayoutAction, saveLastLayoutAction.getName());

        final CanvasAction loadLastLayoutAction = newCanvasAction(canvas, "LoadLastLayoutAction", "Load last layout")
                .addStatements(invokeLaterInTransaction(
                        "final nextgen.st.canvas.layout.LayoutNeoFactory layoutNeoFactory = new nextgen.st.canvas.layout.LayoutNeoFactory(canvas.modelDb.getDatabaseService());\n" +
                                "final nextgen.st.canvas.layout.Layout last = layoutNeoFactory.findLayoutByName(\"last\");\n" +
                                "if (last == null) return;\n" +
                                "\n" +
                                "last.getNodes().forEach(layoutNode -> {\n" +
                                "\tfinal org.neo4j.graphdb.Node node = layoutNode.getNode();\n" +
                                "\tnode.getRelationships(org.neo4j.graphdb.Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName(\"ref\")).forEach(relationship -> {\n" +
                                "\t\tfinal org.neo4j.graphdb.Node stNode = relationship.getOtherNode(node);\n" +
                                "\t\tif (stNode.hasLabel(org.neo4j.graphdb.Label.label(\"STModel\"))) {\n" +
                                "\t\t\tfinal nextgen.st.model.STModel stModel = canvas.modelDb.newSTModel(stNode);\n" +
                                "\t\t\tcanvas.addNode(stModel.getUuid(), canvas.newSTNode(stModel));\n" +
                                "\t\t\tcanvas.getNode(stModel.getUuid()).setOffset(layoutNode.getX(), layoutNode.getY());\n" +
                                "\t\t} else if (stNode.hasLabel(org.neo4j.graphdb.Label.label(\"STValue\"))) {\n" +
                                "\t\t\tfinal nextgen.st.model.STValue stModel = canvas.modelDb.newSTValue(stNode);\n" +
                                "\t\t\tcanvas.addNode(stModel.getUuid(), canvas.newSTNode(stModel));\n" +
                                "\t\t\tcanvas.getNode(stModel.getUuid()).setOffset(layoutNode.getX(), layoutNode.getY());\n" +
                                "\t\t}\n" +
                                "\t});\n" +
                                "});"

                ));
        registerRightClickAction(canvas, loadLastLayoutAction, loadLastLayoutAction.getName());

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
                .setBlockStmt(newBlockStmt().setStatements(statements));
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

        final Entity layoutDomain = newEntity("Layout")
                .addRelations(newStringField("uuid"))
                .addRelations(newStringField("name"))
                .addRelations(newOneToMany("nodes", newEntity("LayoutNode")
                        .addRelations(newStringField("uuid"))
                        .addRelations(newDoubleField("x"))
                        .addRelations(newDoubleField("y"))));

        writeNeo(mainJava, layout.getName(), newDomain("Layout")
                .addEntities(layoutDomain));


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