package com.generator.generators.java;


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
 * Java domain
 */
public class JavaDomainEditor extends GraphEditor2D<JavaDomain.ENTITIES, JavaDomain.RELATIONS, GraphNode2D<JavaDomain.ENTITIES>> {

    public JavaDomainEditor(MetaDomain<JavaDomain.ENTITIES, JavaDomain.RELATIONS> domain) {
        super(domain);
    }

    @Override
    protected GraphNode2D<JavaDomain.ENTITIES> newGraphNodeFor(MetaNode<JavaDomain.ENTITIES> metaNode, Node node) {

        if (metaNode == null) return null;

        final int x = Math.max(0, random.nextInt(getWidth() - 60) + 30);
        final int y = Math.max(0, random.nextInt(getHeight() - 60) + 30);

        switch (metaNode.getLabel()) {
            case PACKAGE:
                return new GraphNode2D<>(node, metaNode, x, y, 22, 20, Color.decode("#fee8c8"), Color.decode("#b30000"), Color.decode("#b30000"), Color.decode("#fee8c8"), NeoModel.getNameOrLabelFrom(node), false); // todo this can perhaps be a 'GraphNode' which extends GraphNode2D 
            case CLASS:
                return new GraphNode2D<>(node, metaNode, x, y, 22, 20, Color.decode("#fee8c8"), Color.decode("#b30000"), Color.decode("#b30000"), Color.decode("#fee8c8"), NeoModel.getNameOrLabelFrom(node), false); // todo this can perhaps be a 'GraphNode' which extends GraphNode2D 
            case INTERFACE:
                return new GraphNode2D<>(node, metaNode, x, y, 22, 20, Color.decode("#fee8c8"), Color.decode("#b30000"), Color.decode("#b30000"), Color.decode("#fee8c8"), NeoModel.getNameOrLabelFrom(node), false); // todo this can perhaps be a 'GraphNode' which extends GraphNode2D 
            case METHOD:
                return new GraphNode2D<>(node, metaNode, x, y, 22, 20, Color.decode("#fee8c8"), Color.decode("#b30000"), Color.decode("#b30000"), Color.decode("#fee8c8"), NeoModel.getNameOrLabelFrom(node), false); // todo this can perhaps be a 'GraphNode' which extends GraphNode2D 
            case ENUM_VALUE:
                return new GraphNode2D<>(node, metaNode, x, y, 22, 20, Color.decode("#fee8c8"), Color.decode("#b30000"), Color.decode("#b30000"), Color.decode("#fee8c8"), NeoModel.getNameOrLabelFrom(node), false); // todo this can perhaps be a 'GraphNode' which extends GraphNode2D 
            case ENUM:
                return new GraphNode2D<>(node, metaNode, x, y, 22, 20, Color.decode("#fee8c8"), Color.decode("#b30000"), Color.decode("#b30000"), Color.decode("#fee8c8"), NeoModel.getNameOrLabelFrom(node), false); // todo this can perhaps be a 'GraphNode' which extends GraphNode2D 
            case FILE:
                return new GraphNode2D<>(node, metaNode, x, y, 22, 20, Color.decode("#fee8c8"), Color.decode("#b30000"), Color.decode("#b30000"), Color.decode("#fee8c8"), NeoModel.getNameOrLabelFrom(node), false); // todo this can perhaps be a 'GraphNode' which extends GraphNode2D 

            default:
                return null;
        }
    }

    @Override
    public final void rightClickSelect(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<JavaDomain.ENTITIES> targetNode) {
        super.rightClickSelect(mouseEvent, popupMenu, targetNode);

        final MetaNode<JavaDomain.ENTITIES> metaNode = targetNode.getMetaNode();
        if (metaNode == null) return;   // targetNode not recognized by JavaDomain

        switch (metaNode.getLabel()) {
            case PACKAGE:
                rightClickPACKAGE(mouseEvent, popupMenu, targetNode);
                break;
            case CLASS:
                rightClickCLASS(mouseEvent, popupMenu, targetNode);
                break;
            case INTERFACE:
                rightClickINTERFACE(mouseEvent, popupMenu, targetNode);
                break;
            case METHOD:
                rightClickMETHOD(mouseEvent, popupMenu, targetNode);
                break;
            case ENUM_VALUE:
                rightClickENUM_VALUE(mouseEvent, popupMenu, targetNode);
                break;
            case ENUM:
                rightClickENUM(mouseEvent, popupMenu, targetNode);
                break;
            case FILE:
                rightClickFILE(mouseEvent, popupMenu, targetNode);
                break;
        }
    }

    protected void rightClickPACKAGE(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<JavaDomain.ENTITIES> targetNode) {
    }

    protected void rightClickCLASS(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<JavaDomain.ENTITIES> targetNode) {
    }

    protected void rightClickINTERFACE(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<JavaDomain.ENTITIES> targetNode) {
    }

    protected void rightClickMETHOD(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<JavaDomain.ENTITIES> targetNode) {
    }

    protected void rightClickENUM_VALUE(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<JavaDomain.ENTITIES> targetNode) {
    }

    protected void rightClickENUM(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<JavaDomain.ENTITIES> targetNode) {
    }

    protected void rightClickFILE(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<JavaDomain.ENTITIES> targetNode) {
    }
}