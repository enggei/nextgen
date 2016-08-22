package com.generator.generators.easyFlow;


import com.generator.editors.domain.MetaDomain;
import com.generator.editors.domain.MetaNode;
import com.generator.editors.domain.NeoModel;
import com.generator.editors.graph.d2.GraphEditor2D;
import com.generator.editors.graph.d2.GraphNode2D;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 *
 */
public class EasyFlowDomainEditor extends GraphEditor2D<EasyFlowDomain.ENTITIES, EasyFlowDomain.RELATIONS, GraphNode2D<EasyFlowDomain.ENTITIES>> {

    public EasyFlowDomainEditor(MetaDomain<EasyFlowDomain.ENTITIES, EasyFlowDomain.RELATIONS> domain) {
        super(domain);
    }

    @Override
    protected GraphNode2D<EasyFlowDomain.ENTITIES> newGraphNodeFor(MetaNode<EasyFlowDomain.ENTITIES> metaNode, Node node) {

        if (metaNode == null) return null;

        final int x = Math.max(0, random.nextInt(getWidth() - 60) + 30);
        final int y = Math.max(0, random.nextInt(getHeight() - 60) + 30);

        switch (metaNode.getLabel()) {
            case Flow:
                return new GraphNode2D<>(node, metaNode, x, y, 35, 33, Color.decode("#d8daeb"), Color.decode("#fee0b6"), Color.decode("#b30000"), Color.decode("#fee8c8"), NeoModel.getNameOrLabelFrom(node), false);
            case ContextProperty:
                return new GraphNode2D<>(node, metaNode, x, y, 12, 10, Color.decode("#998ec3"), Color.decode("#f7f7f7"), Color.decode("#b30000"), Color.decode("#fee8c8"), NeoModel.getNameOrLabelFrom(node), false);
            case State:
                return new GraphNode2D<>(node, metaNode, x, y, 35, 33, Color.decode("#f7f7f7"), Color.decode("#d8b365"), Color.decode("#b30000"), Color.decode("#fee8c8"), NeoModel.getNameOrLabelFrom(node), false);
            case Event:
                return new GraphNode2D<>(node, metaNode, x, y, 20, 17, Color.decode("#f7f7f7"), Color.decode("#e9a3c9"), Color.decode("#b30000"), Color.decode("#fee8c8"), NeoModel.getNameOrLabelFrom(node), false);
            case SuperParameter:
                return new GraphNode2D<>(node, metaNode, x, y, 22, 20, Color.decode("#fee8c8"), Color.decode("#b30000"), Color.decode("#b30000"), Color.decode("#fee8c8"), NeoModel.getNameOrLabelFrom(node), false);

            default:
                return null;
        }
    }

    @Override
    public final void rightClickSelect(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<EasyFlowDomain.ENTITIES> targetNode) {
        super.rightClickSelect(mouseEvent, popupMenu, targetNode);

        final MetaNode<EasyFlowDomain.ENTITIES> metaNode = targetNode.getMetaNode();
        if (metaNode == null) return;   // targetNode not recognized by EasyFlowDomain

        switch (metaNode.getLabel()) {
            case Flow:
                rightClickFlow(mouseEvent, popupMenu, targetNode);
                break;
            case ContextProperty:
                rightClickContextProperty(mouseEvent, popupMenu, targetNode);
                break;
            case State:
                rightClickState(mouseEvent, popupMenu, targetNode);
                break;
            case Event:
                rightClickEvent(mouseEvent, popupMenu, targetNode);
                break;
            case SuperParameter:
                rightClickSuperParameter(mouseEvent, popupMenu, targetNode);
                break;
        }
    }

    protected void rightClickFlow(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<EasyFlowDomain.ENTITIES> targetNode) {
    }

    protected void rightClickContextProperty(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<EasyFlowDomain.ENTITIES> targetNode) {
    }

    protected void rightClickState(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<EasyFlowDomain.ENTITIES> targetNode) {
    }

    protected void rightClickEvent(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<EasyFlowDomain.ENTITIES> targetNode) {
    }

    protected void rightClickSuperParameter(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<EasyFlowDomain.ENTITIES> targetNode) {
    }


    public static void main(String[] args) {

        final GraphDatabaseService db = new GraphDatabaseFactory().newEmbeddedDatabase(new java.io.File(args[0]));
        final EasyFlowDomain domain = new EasyFlowDomain(new NeoModel(db));
        SwingUtil.setLookAndFeel_Nimbus();
        final JFrame frame = new JFrame("EasyFlowDomain");
        frame.getContentPane().add(new EasyFlowDomainEditor(domain), BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SwingUtil.show(frame);
    }
}