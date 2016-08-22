package com.generator.generators.vertxWeb;


import com.generator.editors.domain.MetaDomain;
import com.generator.editors.domain.MetaNode;
import com.generator.editors.domain.NeoModel;
import com.generator.editors.domain.MetaRelation;
import com.generator.editors.domain.editors.NodeEditor;
import com.generator.editors.graph.GraphRelation;
import com.generator.editors.graph.GraphEditor;
import com.generator.editors.graph.d2.GraphEditor2D;
import com.generator.editors.graph.d2.GraphNode2D;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * 
 */
public class vertxWebEditor extends GraphEditor2D<vertxWeb.ENTITIES, vertxWeb.RELATIONS, GraphNode2D<vertxWeb.ENTITIES>> {

    public vertxWebEditor(MetaDomain<vertxWeb.ENTITIES, vertxWeb.RELATIONS> domain) {
        super(domain);
    }

    @Override
    protected GraphRelation<GraphNode2D<vertxWeb.ENTITIES>, GraphNode2D<vertxWeb.ENTITIES>, vertxWeb.ENTITIES> newGraphRelation(MetaRelation<vertxWeb.ENTITIES, vertxWeb.RELATIONS> metaRelation, Relationship relationship, GraphNode2D<vertxWeb.ENTITIES> source, GraphNode2D<vertxWeb.ENTITIES> target) {

        if (metaRelation == null) return null;

        switch (vertxWeb.RELATIONS.valueOf(metaRelation.getName().name())) {
            case ROUTES:
                return newROUTESRelation(relationship, source, target);
            case EXCEPTIONHANDLER:
                return newEXCEPTIONHANDLERRelation(relationship, source, target);
            case ROUTE:
                return newROUTERelation(relationship, source, target);
            case HANDLER:
                return newHANDLERRelation(relationship, source, target);

            default:
                return null;
        }
    }

    @Override
    public NodeEditor getNodeEditor(MetaNode<vertxWeb.ENTITIES> metaNode, GraphNode2D<vertxWeb.ENTITIES> node, GraphEditor editor) {

        if (metaNode == null) return null;

        switch (metaNode.getLabel()) {
            case HTTPServer:
                return newHTTPServerGraphEditor(metaNode, node, editor);
            case Router:
                return newRouterGraphEditor(metaNode, node, editor);
            case HandlerThrowable:
                return newHandlerThrowableGraphEditor(metaNode, node, editor);
            case Route:
                return newrouteGraphEditor(metaNode, node, editor);
            case RequestHandler:
                return newrequestHandlerGraphEditor(metaNode, node, editor);
            case StaticHandler:
                return newStaticHandlerGraphEditor(metaNode, node, editor);

            default:
                return null;
        }
    }

    @Override
    protected GraphNode2D<vertxWeb.ENTITIES> newGraphNodeFor(MetaNode<vertxWeb.ENTITIES> metaNode, Node node) {

        if (metaNode == null) return null;

        final int x = Math.max(0, random.nextInt(getWidth() - 60) + 30);
        final int y = Math.max(0, random.nextInt(getHeight() - 60) + 30);

        switch (metaNode.getLabel()) {
            case HTTPServer:
                return newHTTPServerGraphNode(metaNode, node, x, y);
            case Router:
                return newRouterGraphNode(metaNode, node, x, y);
            case HandlerThrowable:
                return newHandlerThrowableGraphNode(metaNode, node, x, y);
            case Route:
                return newrouteGraphNode(metaNode, node, x, y);
            case RequestHandler:
                return newrequestHandlerGraphNode(metaNode, node, x, y);
            case StaticHandler:
                return newStaticHandlerGraphNode(metaNode, node, x, y);

            default:
                return null;
        }
    }

    @Override
    public final void rightClickSelect(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<vertxWeb.ENTITIES> targetNode) {
        super.rightClickSelect(mouseEvent, popupMenu, targetNode);

        final MetaNode<vertxWeb.ENTITIES> metaNode = targetNode.getMetaNode();
        if (metaNode == null) return;   // targetNode not recognized by vertxWeb

        switch (metaNode.getLabel()) {
            case HTTPServer:
                rightClickHTTPServer(mouseEvent, popupMenu, targetNode);
                break;
            case Router:
                rightClickRouter(mouseEvent, popupMenu, targetNode);
                break;
            case HandlerThrowable:
                rightClickHandlerThrowable(mouseEvent, popupMenu, targetNode);
                break;
            case Route:
                rightClickRoute(mouseEvent, popupMenu, targetNode);
                break;
            case RequestHandler:
                rightClickRequestHandler(mouseEvent, popupMenu, targetNode);
                break;
            case StaticHandler:
                rightClickStaticHandler(mouseEvent, popupMenu, targetNode);
                break;
        }
    }

    protected void rightClickHTTPServer(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<vertxWeb.ENTITIES> targetNode) {
    }

    protected void rightClickRouter(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<vertxWeb.ENTITIES> targetNode) {
    }

    protected void rightClickHandlerThrowable(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<vertxWeb.ENTITIES> targetNode) {
    }

    protected void rightClickRoute(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<vertxWeb.ENTITIES> targetNode) {
    }

    protected void rightClickRequestHandler(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<vertxWeb.ENTITIES> targetNode) {
    }

    protected void rightClickStaticHandler(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<vertxWeb.ENTITIES> targetNode) {
    }

    protected GraphRelation<GraphNode2D<vertxWeb.ENTITIES>, GraphNode2D<vertxWeb.ENTITIES>, vertxWeb.ENTITIES> newROUTESRelation(Relationship relationship, GraphNode2D<vertxWeb.ENTITIES> source, GraphNode2D<vertxWeb.ENTITIES> target) {
        return new com.generator.editors.graph.d2.ShortestPathGraphRelation(relationship, source, target);
    }
    protected GraphRelation<GraphNode2D<vertxWeb.ENTITIES>, GraphNode2D<vertxWeb.ENTITIES>, vertxWeb.ENTITIES> newEXCEPTIONHANDLERRelation(Relationship relationship, GraphNode2D<vertxWeb.ENTITIES> source, GraphNode2D<vertxWeb.ENTITIES> target) {
        return new com.generator.editors.graph.d2.ShortestPathGraphRelation(relationship, source, target);
    }
    protected GraphRelation<GraphNode2D<vertxWeb.ENTITIES>, GraphNode2D<vertxWeb.ENTITIES>, vertxWeb.ENTITIES> newROUTERelation(Relationship relationship, GraphNode2D<vertxWeb.ENTITIES> source, GraphNode2D<vertxWeb.ENTITIES> target) {
        return new com.generator.editors.graph.d2.ShortestPathGraphRelation(relationship, source, target);
    }
    protected GraphRelation<GraphNode2D<vertxWeb.ENTITIES>, GraphNode2D<vertxWeb.ENTITIES>, vertxWeb.ENTITIES> newHANDLERRelation(Relationship relationship, GraphNode2D<vertxWeb.ENTITIES> source, GraphNode2D<vertxWeb.ENTITIES> target) {
        return new com.generator.editors.graph.d2.ShortestPathGraphRelation(relationship, source, target);
    }
    protected GraphNode2D<vertxWeb.ENTITIES> newHTTPServerGraphNode(MetaNode<vertxWeb.ENTITIES> metaNode, Node node, int x, int y) {
        return new GraphNode2D<>(node, metaNode, x, y, 22, 20, Color.decode("#8dd3c7"), Color.decode("#8dd3c7"), Color.decode("#b30000"), Color.decode("#fee8c8"), NeoModel.getNameOrLabelFrom(node), false);
    }
    protected GraphNode2D<vertxWeb.ENTITIES> newRouterGraphNode(MetaNode<vertxWeb.ENTITIES> metaNode, Node node, int x, int y) {
        return new GraphNode2D<>(node, metaNode, x, y, 22, 20, Color.decode("#8dd3c7"), Color.decode("#8dd3c7"), Color.decode("#b30000"), Color.decode("#fee8c8"), NeoModel.getNameOrLabelFrom(node), false);
    }
    protected GraphNode2D<vertxWeb.ENTITIES> newHandlerThrowableGraphNode(MetaNode<vertxWeb.ENTITIES> metaNode, Node node, int x, int y) {
        return new GraphNode2D<>(node, metaNode, x, y, 22, 20, Color.decode("#8dd3c7"), Color.decode("#8dd3c7"), Color.decode("#b30000"), Color.decode("#fee8c8"), NeoModel.getNameOrLabelFrom(node), false);
    }
    protected GraphNode2D<vertxWeb.ENTITIES> newrouteGraphNode(MetaNode<vertxWeb.ENTITIES> metaNode, Node node, int x, int y) {
        return new GraphNode2D<>(node, metaNode, x, y, 22, 20, Color.decode("#8dd3c7"), Color.decode("#8dd3c7"), Color.decode("#b30000"), Color.decode("#fee8c8"), NeoModel.getNameOrLabelFrom(node), false);
    }
    protected GraphNode2D<vertxWeb.ENTITIES> newrequestHandlerGraphNode(MetaNode<vertxWeb.ENTITIES> metaNode, Node node, int x, int y) {
        return new GraphNode2D<>(node, metaNode, x, y, 22, 20, Color.decode("#8dd3c7"), Color.decode("#8dd3c7"), Color.decode("#b30000"), Color.decode("#fee8c8"), NeoModel.getNameOrLabelFrom(node), false);
    }
    protected GraphNode2D<vertxWeb.ENTITIES> newStaticHandlerGraphNode(MetaNode<vertxWeb.ENTITIES> metaNode, Node node, int x, int y) {
        return new GraphNode2D<>(node, metaNode, x, y, 22, 20, Color.decode("#8dd3c7"), Color.decode("#8dd3c7"), Color.decode("#b30000"), Color.decode("#fee8c8"), NeoModel.getNameOrLabelFrom(node), false);
    }
    public NodeEditor newHTTPServerGraphEditor(MetaNode<vertxWeb.ENTITIES> metaNode, GraphNode2D<vertxWeb.ENTITIES> node, GraphEditor editor) {
        return super.getNodeEditor(metaNode, node, editor);
    }
    public NodeEditor newRouterGraphEditor(MetaNode<vertxWeb.ENTITIES> metaNode, GraphNode2D<vertxWeb.ENTITIES> node, GraphEditor editor) {
        return super.getNodeEditor(metaNode, node, editor);
    }
    public NodeEditor newHandlerThrowableGraphEditor(MetaNode<vertxWeb.ENTITIES> metaNode, GraphNode2D<vertxWeb.ENTITIES> node, GraphEditor editor) {
        return super.getNodeEditor(metaNode, node, editor);
    }
    public NodeEditor newrouteGraphEditor(MetaNode<vertxWeb.ENTITIES> metaNode, GraphNode2D<vertxWeb.ENTITIES> node, GraphEditor editor) {
        return super.getNodeEditor(metaNode, node, editor);
    }
    public NodeEditor newrequestHandlerGraphEditor(MetaNode<vertxWeb.ENTITIES> metaNode, GraphNode2D<vertxWeb.ENTITIES> node, GraphEditor editor) {
        return super.getNodeEditor(metaNode, node, editor);
    }
    public NodeEditor newStaticHandlerGraphEditor(MetaNode<vertxWeb.ENTITIES> metaNode, GraphNode2D<vertxWeb.ENTITIES> node, GraphEditor editor) {
        return super.getNodeEditor(metaNode, node, editor);
    }

    public static void main(String[] args) {

        final GraphDatabaseService db = new GraphDatabaseFactory().newEmbeddedDatabase(new java.io.File(args[0]));
        final vertxWeb domain = new vertxWeb(new NeoModel(db));
        final vertxWebEditor editor = new vertxWebEditor(domain);

        SwingUtil.setLookAndFeel_Nimbus();
        final JFrame frame = new JFrame("vertxWeb");
        frame.addKeyListener(editor);
        frame.getContentPane().add(editor, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SwingUtil.show(frame);
    }
} 