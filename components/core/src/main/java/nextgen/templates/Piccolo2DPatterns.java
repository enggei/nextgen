package nextgen.templates;

import nextgen.templates.piccolo2d.*;

import static nextgen.templates.JavaPatterns.invokeLater;
import static nextgen.templates.JavaPatterns.newInvokeLater;

public class Piccolo2DPatterns extends Piccolo2DST {

    public static PNodeImpl newPNodeImpl(PCanvas canvas, PNode node) {
        return newPNodeImpl()
                .setNodeName(node.getName())
                .setCanvasName(canvas.getName());
    }

    public static void addDefaultActionsToCanvas(PCanvas canvas) {

        final CanvasAction selectAllNodesAction = newCanvasAction(canvas, "SelectAllNodes", "Select all nodes")
                .addStatements(invokeLater("canvas.getAllNodes().forEach(" + canvas.getNodeName() + "::select)"));

        final CanvasAction unselectAllNodesAction = newCanvasAction(canvas, "UnselectAllNodes", "Unselect all nodes")
                .addStatements(invokeLater("canvas.getSelectedNodes().forEach(" + canvas.getNodeName() + "::unselect)"));

        final CanvasAction closeSelectedNodesAction = newCanvasAction(canvas, "CloseSelectedNodes", "Close selected nodes")
                .addStatements(invokeLater("canvas.getSelectedNodes().forEach(" + canvas.getNodeName() + "::close)"));

        final LayoutVerticallyAction layoutVerticallyAction = newLayoutVerticallyAction()
                .setName("LayoutVerticallyAction")
                .setCanvasName(canvas.getName())
                .setNodeType(canvas.getNodeName());

        final CanvasAction popupAction = newCanvasAction(canvas, "PopupAction", "Popup")
                .addStatements(newInvokeLater()
                        .addStatements("final JPopupMenu pop = new JPopupMenu();")
                        .addStatements("canvas.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));")
                        .addStatements("canvas.onCanvasRightClick(pop, event);")
                        .addStatements("canvas.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));")
                        .addStatements("pop.show(canvas, (int) event.getCanvasPosition().getX(), (int) event.getCanvasPosition().getY());"));


        registerRightClickAction(canvas, selectAllNodesAction, selectAllNodesAction.getName());
        registerRightClickAction(canvas, unselectAllNodesAction, unselectAllNodesAction.getName());
        registerRightClickAction(canvas, closeSelectedNodesAction, closeSelectedNodesAction.getName());
        registerRightClickAction(canvas, layoutVerticallyAction, layoutVerticallyAction.getName());
        canvas.addActions(popupAction);;

        canvas.addOnKeyPressed("1", layoutVerticallyAction.getName());
        canvas.addOnKeyPressed("A", selectAllNodesAction.getName());
        canvas.addOnKeyPressed("C", closeSelectedNodesAction.getName());
        canvas.addOnKeyPressed("F", popupAction.getName());
    }

    public static void registerRightClickAction(PCanvas canvas, Object action, Object name) {
        canvas.addActions(action);
        canvas.addOnRightClick(name);
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
                .addStatements(newInvokeLater().setMethodReference("node::close"));

        final NodeAction popupAction = newNodeAction(node, "PopupAction", "Popup")
                .addStatements(newInvokeLater()
                        .addStatements("final JPopupMenu pop = new JPopupMenu();")
                        .addStatements("canvas.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));")
                        .addStatements("node.onNodeRightClick(event, pop);")
                        .addStatements("canvas.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));")
                        .addStatements("pop.show(canvas, (int) event.getCanvasPosition().getX(), (int) event.getCanvasPosition().getY());"));

        final NodeAction retainNodeAction = newNodeAction(node, "RetainNode", "Retain")
                .addStatements(newInvokeLater(
                        "canvas.getAllNodes().filter(canvasNode -> !canvasNode.getUuid().equals(node.getUuid())).forEach(" + node.getName() + "::close);",
                        "canvas.getAllRelations().forEach(relation -> canvas.removeRelation(relation.getUuid()));"));

        registerRightClickAction(node, layoutTreeAction, layoutTreeAction.getName());
        registerRightClickAction(node, retainNodeAction, retainNodeAction.getName());
        registerRightClickAction(node, closeNodeAction, closeNodeAction.getName());
        registerRightClickAction(node, popupAction, popupAction.getName());

        node.addOnKeyPressed("1", layoutTreeAction.getName());
        node.addOnKeyPressed("C", closeNodeAction.getName());
        node.addOnKeyPressed("R", retainNodeAction.getName());
        node.addOnKeyPressed("F", popupAction.getName());
    }

    public static void registerRightClickAction(PNodeImpl node, Object action, Object name) {
        node.addActions(action);
        node.addOnRightClick(name,false);
    }

    public static void registerRightClickAction(PNode node, Object action, Object name) {
        node.addActions(action);
        node.addOnRightClick(name, false);
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

    public static AnonymousPNodeAction newAnonymousPNodeAction(String nodeType) {
        return newAnonymousPNodeAction().setNodeType(nodeType);
    }
}