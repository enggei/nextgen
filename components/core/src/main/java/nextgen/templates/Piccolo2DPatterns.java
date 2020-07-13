package nextgen.templates;

import nextgen.templates.java.Expression;
import nextgen.templates.java.MethodCallExpression;
import nextgen.templates.piccolo2d.*;

import static nextgen.templates.JavaPatterns.*;

public class Piccolo2DPatterns extends Piccolo2DST {

    public static PNodeImpl newPNodeImpl(PCanvas canvas, PNode node) {
        return newPNodeImpl()
                .setNodeName(node.getName())
                .setCanvasName(canvas.getName());
    }

    public static NodeAction newNodeAction(PNode node, String name, String title) {
        return newNodeAction()
                .setCanvasName(node.getCanvasName())
                .setNodeType(node.getName())
                .setName(name)
                .setTitle(title);
    }

    public static NodeAction newNodeAction(PNodeImpl node, String name, String title) {
        return newNodeAction()
                .setCanvasName(node.getCanvasName())
                .setNodeType(node.getName())
                .setName(name)
                .setTitle(title);
    }

    public static RelationAction newRelationAction(PRelation relation, String name, String title) {
        return newRelationAction()
                .setCanvasName(relation.getCanvasName())
                .setRelationType(relation.getName())
                .setName(name)
                .setTitle(title);
    }

    public static RelationAction newRelationAction(PRelationImpl relation, String name, String title) {
        return newRelationAction()
                .setCanvasName(relation.getCanvasName())
                .setRelationType(relation.getName())
                .setName(name)
                .setTitle(title);
    }

    public static void addDefaultActionsToCanvas(PCanvas canvas) {

        final CanvasAction selectAllNodesAction = newCanvasAction(canvas, "SelectAllNodes", "Select all nodes")
                .addStatements(newInvokeLater().addArguments(newLambdaExpression().setBody(newExpressionStmt().setExpression(expression("canvas.getAllNodes().forEach(" + canvas.getNodeName() + "::select)")))));

        final CanvasAction unselectAllNodesAction = newCanvasAction(canvas, "UnselectAllNodes", "Unselect all nodes")
                .addStatements(newInvokeLater().addArguments(newLambdaExpression().setBody(newExpressionStmt().setExpression(expression("canvas.getSelectedNodes().forEach(" + canvas.getNodeName() + "::unselect)")))));

        final CanvasAction closeSelectedNodesAction = newCanvasAction(canvas, "CloseSelectedNodes", "Close selected nodes")
                .addStatements(newInvokeLater().addArguments(newLambdaExpression().setBody(newExpressionStmt().setExpression(expression("canvas.getSelectedNodes().forEach(" + canvas.getNodeName() + "::close)")))));

        final CanvasAction retainSelectedNodesAction = newCanvasAction(canvas, "RetainSelectedNodes", "Retain selected nodes")
                .addStatements(newInvokeLater().addArguments(newLambdaExpression().setBody(newExpressionStmt().setExpression(expression("canvas.getUnselectedNodes().forEach(STNode::close)")))));

        final LayoutVerticallyAction layoutVerticallyAction = newLayoutVerticallyAction()
                .setName("LayoutVerticallyAction")
                .setCanvasName(canvas.getName())
                .setNodeType(canvas.getNodeName());

        final CanvasAction popupAction = newCanvasAction(canvas, "PopupAction", "Popup")
                .addStatements(newExpressionStmt().setExpression(newInvokeLater()
                        .addArguments(newLambdaExpression()
                                .setBody(newBlockStmt()
                                        .addStatements("final javax.swing.JPopupMenu pop = new javax.swing.JPopupMenu();")
                                        .addStatements("canvas.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.WAIT_CURSOR));")
                                        .addStatements("canvas.onCanvasRightClick(pop, event);")
                                        .addStatements("canvas.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.DEFAULT_CURSOR));")
                                        .addStatements("pop.show(canvas, (int) event.getCanvasPosition().getX(), (int) event.getCanvasPosition().getY());")))));


        registerRightClickAction(canvas, selectAllNodesAction, selectAllNodesAction.getName());
        registerRightClickAction(canvas, unselectAllNodesAction, unselectAllNodesAction.getName());
        registerRightClickAction(canvas, closeSelectedNodesAction, closeSelectedNodesAction.getName());
        registerRightClickAction(canvas, retainSelectedNodesAction, retainSelectedNodesAction.getName());
        registerRightClickAction(canvas, layoutVerticallyAction, layoutVerticallyAction.getName());
        canvas.addActions(popupAction);

        canvas.addOnKeyPressed("1", layoutVerticallyAction.getName());
        canvas.addOnKeyPressed("A", selectAllNodesAction.getName());
        canvas.addOnKeyPressed("C", closeSelectedNodesAction.getName());
        canvas.addOnKeyPressed("F", popupAction.getName());
        canvas.addOnKeyPressed("R", retainSelectedNodesAction.getName());
    }

    private static Expression expression(String s) {
        return newNameExpression().setValue(s);
    }

    public static CanvasAction newCanvasAction(PCanvas canvas, String name, String title) {
        return newCanvasAction()
                .setCanvasName(canvas.getName())
                .setName(name)
                .setTitle(title);
    }

    public static void addDefaultActionsToNode(PNode node) {

        final LayoutTreeAction layoutTreeAction = newLayoutTreeAction()
                .setName("LayoutTreeAction")
                .setCanvasName(node.getCanvasName())
                .setNodeType(node.getName());

        final NodeAction closeNodeAction = newNodeAction(node, "CloseNode", "Close")
                .addStatements(newExpressionStmt().setExpression(newInvokeLater()
                        .addArguments("node::close")));

        final NodeAction popupAction = newNodeAction(node, "PopupAction", "Popup")
                .addStatements(newExpressionStmt().setExpression(newInvokeLater()
                        .addArguments(newLambdaExpression()
                                .setBody(newBlockStmt()
                                        .addStatements("final javax.swing.JPopupMenu pop = new javax.swing.JPopupMenu();")
                                        .addStatements("canvas.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.WAIT_CURSOR));")
                                        .addStatements("node.onNodeRightClick(event, pop);")
                                        .addStatements("canvas.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.DEFAULT_CURSOR));")
                                        .addStatements("pop.show(canvas, (int) event.getCanvasPosition().getX(), (int) event.getCanvasPosition().getY());")))));

        final NodeAction retainNodeAction = newNodeAction(node, "RetainNode", "Retain")
                .addStatements(newExpressionStmt().setExpression(newInvokeLater()
                        .addArguments(newLambdaExpression()
                                .setBody(newBlockStmt()
                                        .addStatements("canvas.getAllNodes().filter(canvasNode -> !canvasNode.getUuid().equals(node.getUuid())).forEach(" + node.getName() + "::close);")
                                        .addStatements("canvas.getAllRelations().forEach(relation -> canvas.removeRelation(relation.getUuid()));")))));

        final NodeAction debugAction = newNodeAction(node, "DebugAction", "Debug")
                .addStatements(newExpressionStmt().setExpression(newInvokeLater()
                        .addArguments(newLambdaExpression()
                                .setBody(newBlockStmt()
                                        .addStatements("final PBounds fullBounds = node.getFullBoundsReference();")
                                        .addStatements("System.out.println(fullBounds.getX() + \",\" + fullBounds.getY() + \", [\" + fullBounds.getWidth() + \",\" + fullBounds.getHeight() + \"]\");")))));

        registerRightClickAction(node, layoutTreeAction, layoutTreeAction.getName());
        registerRightClickAction(node, retainNodeAction, retainNodeAction.getName());
        registerRightClickAction(node, closeNodeAction, closeNodeAction.getName());
        node.addActions(popupAction);
        node.addActions(debugAction);

        node.addOnKeyPressed("1", layoutTreeAction.getName());
        node.addOnKeyPressed("C", closeNodeAction.getName());
        node.addOnKeyPressed("R", retainNodeAction.getName());
        node.addOnKeyPressed("F", popupAction.getName());
        node.addOnKeyPressed("B", debugAction.getName());
    }

    public static MethodCallExpression newInvokeLater() {
        return newMethodCallExpression()
                .setScope("javax.swing.SwingUtilities")
                .setName("invokeLater");
    }

    public static void registerRightClickAction(PCanvas canvas, Object action, Object name) {
        canvas.addActions(action);
        canvas.addOnRightClick(name);
    }

    public static void registerRightClickAction(PNodeImpl node, Object action, Object name) {
        node.addActions(action);
        node.addOnRightClick(name, false);
    }

    public static void registerRightClickAction(PNode node, Object action, Object name) {
        node.addActions(action);
        node.addOnRightClick(name, false);
    }
}