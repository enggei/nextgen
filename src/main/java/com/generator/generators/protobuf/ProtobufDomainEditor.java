package com.generator.generators.protobuf;


import com.generator.editors.domain.MetaDomain;
import com.generator.editors.domain.MetaNode;
import com.generator.editors.domain.NeoModel;
import com.generator.editors.domain.MetaRelation;
import com.generator.editors.graph.GraphRelation;
import com.generator.editors.graph.d2.GraphEditor2D;
import com.generator.editors.graph.d2.GraphNode2D;
import com.generator.editors.graph.d2.ShortestPathGraphRelation;
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
public class ProtobufDomainEditor extends GraphEditor2D<ProtobufDomain.ENTITIES, ProtobufDomain.RELATIONS, GraphNode2D<ProtobufDomain.ENTITIES>> {

    public ProtobufDomainEditor(MetaDomain<ProtobufDomain.ENTITIES, ProtobufDomain.RELATIONS> domain) {
        super(domain);
    }

    @Override
    protected GraphRelation<GraphNode2D<ProtobufDomain.ENTITIES>, GraphNode2D<ProtobufDomain.ENTITIES>, ProtobufDomain.ENTITIES> newGraphRelation(MetaRelation<ProtobufDomain.ENTITIES, ProtobufDomain.RELATIONS> metaRelation, Relationship relationship, GraphNode2D<ProtobufDomain.ENTITIES> source, GraphNode2D<ProtobufDomain.ENTITIES> target) {

        if (metaRelation == null) return null;

        switch (ProtobufDomain.RELATIONS.valueOf(metaRelation.getName().name())) {
            case FIELDRULE:
                return newFIELDRULERelation(relationship, source, target);
            case FIELDTYPE:
                return newFIELDTYPERelation(relationship, source, target);
            case IMPORT:
                return newIMPORTRelation(relationship, source, target);
            case FIELD:
                return newFIELDRelation(relationship, source, target);
            case OPTIONS:
                return newOPTIONSRelation(relationship, source, target);
            case MESSAGE:
                return newMESSAGERelation(relationship, source, target);
            case ENUMVALUE:
                return newENUMVALUERelation(relationship, source, target);
            case PACKAGE:
                return newPACKAGERelation(relationship, source, target);

            default:
                return null;
        }
    }

    @Override
    protected GraphNode2D<ProtobufDomain.ENTITIES> newGraphNodeFor(MetaNode<ProtobufDomain.ENTITIES> metaNode, Node node) {

        if (metaNode == null) return null;

        final int x = Math.max(0, random.nextInt(getWidth() - 60) + 30);
        final int y = Math.max(0, random.nextInt(getHeight() - 60) + 30);

        switch (metaNode.getLabel()) {
            case File:
                return newFileGraphNode(metaNode, node, x, y);
            case Package:
                return newPackageGraphNode(metaNode, node, x, y);
            case Option:
                return newOptionGraphNode(metaNode, node, x, y);
            case Import:
                return newImportGraphNode(metaNode, node, x, y);
            case Message:
                return newMessageGraphNode(metaNode, node, x, y);
            case Extend:
                return newExtendGraphNode(metaNode, node, x, y);
            case Extensions:
                return newExtensionsGraphNode(metaNode, node, x, y);
            case Enum:
                return newEnumGraphNode(metaNode, node, x, y);
            case EnumValue:
                return newEnumValueGraphNode(metaNode, node, x, y);
            case FieldType:
                return newFieldTypeGraphNode(metaNode, node, x, y);
            case FieldRule:
                return newFieldRuleGraphNode(metaNode, node, x, y);
            case Property:
                return newPropertyGraphNode(metaNode, node, x, y);

            default:
                return null;
        }
    }

    @Override
    public final void rightClickSelect(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<ProtobufDomain.ENTITIES> targetNode) {
        super.rightClickSelect(mouseEvent, popupMenu, targetNode);

        final MetaNode<ProtobufDomain.ENTITIES> metaNode = targetNode.getMetaNode();
        if (metaNode == null) return;   // targetNode not recognized by ProtobufDomain

        switch (metaNode.getLabel()) {
            case File:
                rightClickFile(mouseEvent, popupMenu, targetNode);
                break;
            case Package:
                rightClickPackage(mouseEvent, popupMenu, targetNode);
                break;
            case Option:
                rightClickOption(mouseEvent, popupMenu, targetNode);
                break;
            case Import:
                rightClickImport(mouseEvent, popupMenu, targetNode);
                break;
            case Message:
                rightClickMessage(mouseEvent, popupMenu, targetNode);
                break;
            case Extend:
                rightClickExtend(mouseEvent, popupMenu, targetNode);
                break;
            case Extensions:
                rightClickExtensions(mouseEvent, popupMenu, targetNode);
                break;
            case Enum:
                rightClickEnum(mouseEvent, popupMenu, targetNode);
                break;
            case EnumValue:
                rightClickEnumValue(mouseEvent, popupMenu, targetNode);
                break;
            case FieldType:
                rightClickFieldType(mouseEvent, popupMenu, targetNode);
                break;
            case FieldRule:
                rightClickFieldRule(mouseEvent, popupMenu, targetNode);
                break;
            case Property:
                rightClickProperty(mouseEvent, popupMenu, targetNode);
                break;
        }
    }

    protected void rightClickFile(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<ProtobufDomain.ENTITIES> targetNode) {
    }

    protected void rightClickPackage(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<ProtobufDomain.ENTITIES> targetNode) {
    }

    protected void rightClickOption(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<ProtobufDomain.ENTITIES> targetNode) {
    }

    protected void rightClickImport(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<ProtobufDomain.ENTITIES> targetNode) {
    }

    protected void rightClickMessage(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<ProtobufDomain.ENTITIES> targetNode) {
    }

    protected void rightClickExtend(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<ProtobufDomain.ENTITIES> targetNode) {
    }

    protected void rightClickExtensions(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<ProtobufDomain.ENTITIES> targetNode) {
    }

    protected void rightClickEnum(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<ProtobufDomain.ENTITIES> targetNode) {
    }

    protected void rightClickEnumValue(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<ProtobufDomain.ENTITIES> targetNode) {
    }

    protected void rightClickFieldType(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<ProtobufDomain.ENTITIES> targetNode) {
    }

    protected void rightClickFieldRule(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<ProtobufDomain.ENTITIES> targetNode) {
    }

    protected void rightClickProperty(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D<ProtobufDomain.ENTITIES> targetNode) {
    }


    protected GraphRelation<GraphNode2D<ProtobufDomain.ENTITIES>, GraphNode2D<ProtobufDomain.ENTITIES>, ProtobufDomain.ENTITIES> newFIELDRULERelation(Relationship relationship, GraphNode2D<ProtobufDomain.ENTITIES> source, GraphNode2D<ProtobufDomain.ENTITIES> target) {
        return new ShortestPathGraphRelation(relationship, source, target);
    }

    protected GraphRelation<GraphNode2D<ProtobufDomain.ENTITIES>, GraphNode2D<ProtobufDomain.ENTITIES>, ProtobufDomain.ENTITIES> newFIELDTYPERelation(Relationship relationship, GraphNode2D<ProtobufDomain.ENTITIES> source, GraphNode2D<ProtobufDomain.ENTITIES> target) {
        return new ShortestPathGraphRelation(relationship, source, target);
    }

    protected GraphRelation<GraphNode2D<ProtobufDomain.ENTITIES>, GraphNode2D<ProtobufDomain.ENTITIES>, ProtobufDomain.ENTITIES> newIMPORTRelation(Relationship relationship, GraphNode2D<ProtobufDomain.ENTITIES> source, GraphNode2D<ProtobufDomain.ENTITIES> target) {
        return new ShortestPathGraphRelation(relationship, source, target);
    }

    protected GraphRelation<GraphNode2D<ProtobufDomain.ENTITIES>, GraphNode2D<ProtobufDomain.ENTITIES>, ProtobufDomain.ENTITIES> newFIELDRelation(Relationship relationship, GraphNode2D<ProtobufDomain.ENTITIES> source, GraphNode2D<ProtobufDomain.ENTITIES> target) {
        return new ShortestPathGraphRelation(relationship, source, target);
    }

    protected GraphRelation<GraphNode2D<ProtobufDomain.ENTITIES>, GraphNode2D<ProtobufDomain.ENTITIES>, ProtobufDomain.ENTITIES> newOPTIONSRelation(Relationship relationship, GraphNode2D<ProtobufDomain.ENTITIES> source, GraphNode2D<ProtobufDomain.ENTITIES> target) {
        return new ShortestPathGraphRelation(relationship, source, target);
    }

    protected GraphRelation<GraphNode2D<ProtobufDomain.ENTITIES>, GraphNode2D<ProtobufDomain.ENTITIES>, ProtobufDomain.ENTITIES> newMESSAGERelation(Relationship relationship, GraphNode2D<ProtobufDomain.ENTITIES> source, GraphNode2D<ProtobufDomain.ENTITIES> target) {
        return new ShortestPathGraphRelation(relationship, source, target);
    }

    protected GraphRelation<GraphNode2D<ProtobufDomain.ENTITIES>, GraphNode2D<ProtobufDomain.ENTITIES>, ProtobufDomain.ENTITIES> newENUMVALUERelation(Relationship relationship, GraphNode2D<ProtobufDomain.ENTITIES> source, GraphNode2D<ProtobufDomain.ENTITIES> target) {
        return new ShortestPathGraphRelation(relationship, source, target);
    }

    protected GraphRelation<GraphNode2D<ProtobufDomain.ENTITIES>, GraphNode2D<ProtobufDomain.ENTITIES>, ProtobufDomain.ENTITIES> newPACKAGERelation(Relationship relationship, GraphNode2D<ProtobufDomain.ENTITIES> source, GraphNode2D<ProtobufDomain.ENTITIES> target) {
        return new ShortestPathGraphRelation(relationship, source, target);
    }

    protected GraphNode2D<ProtobufDomain.ENTITIES> newFileGraphNode(MetaNode<ProtobufDomain.ENTITIES> metaNode, Node node, int x, int y) {
        return new GraphNode2D<>(node, metaNode, x, y, 25, 20, Color.decode("#a50026"), Color.decode("#f5f5f5"), Color.decode("#000000"), Color.decode("#fee8c8"), NeoModel.getNameOrLabelFrom(node), false);
    }

    protected GraphNode2D<ProtobufDomain.ENTITIES> newPackageGraphNode(MetaNode<ProtobufDomain.ENTITIES> metaNode, Node node, int x, int y) {
        return new GraphNode2D<>(node, metaNode, x, y, 22, 20, Color.decode("#d73027"), Color.decode("#f5f5f5"), Color.decode("#b30000"), Color.decode("#fee8c8"), NeoModel.getNameOrLabelFrom(node), false);
    }

    protected GraphNode2D<ProtobufDomain.ENTITIES> newOptionGraphNode(MetaNode<ProtobufDomain.ENTITIES> metaNode, Node node, int x, int y) {
        return new GraphNode2D<>(node, metaNode, x, y, 22, 20, Color.decode("#f46d43"), Color.decode("#f5f5f5"), Color.decode("#b30000"), Color.decode("#fee8c8"), NeoModel.getNameOrLabelFrom(node), false);
    }

    protected GraphNode2D<ProtobufDomain.ENTITIES> newImportGraphNode(MetaNode<ProtobufDomain.ENTITIES> metaNode, Node node, int x, int y) {
        return new GraphNode2D<>(node, metaNode, x, y, 22, 20, Color.decode("#a50026"), Color.decode("#f5f5f5"), Color.decode("#b30000"), Color.decode("#fee8c8"), NeoModel.getNameOrLabelFrom(node), false);
    }

    protected GraphNode2D<ProtobufDomain.ENTITIES> newMessageGraphNode(MetaNode<ProtobufDomain.ENTITIES> metaNode, Node node, int x, int y) {
        return new GraphNode2D<>(node, metaNode, x, y, 22, 20, Color.decode("#4575b4"), Color.decode("#f5f5f5"), Color.decode("#b30000"), Color.decode("#fee8c8"), NeoModel.getNameOrLabelFrom(node), false);
    }

    protected GraphNode2D<ProtobufDomain.ENTITIES> newExtendGraphNode(MetaNode<ProtobufDomain.ENTITIES> metaNode, Node node, int x, int y) {
        return new GraphNode2D<>(node, metaNode, x, y, 22, 20, Color.decode("#ffffbf"), Color.decode("#f5f5f5"), Color.decode("#b30000"), Color.decode("#fee8c8"), NeoModel.getNameOrLabelFrom(node), false);
    }

    protected GraphNode2D<ProtobufDomain.ENTITIES> newExtensionsGraphNode(MetaNode<ProtobufDomain.ENTITIES> metaNode, Node node, int x, int y) {
        return new GraphNode2D<>(node, metaNode, x, y, 22, 20, Color.decode("#d8b365"), Color.decode("#f5f5f5"), Color.decode("#b30000"), Color.decode("#fee8c8"), NeoModel.getNameOrLabelFrom(node), false);
    }

    protected GraphNode2D<ProtobufDomain.ENTITIES> newEnumGraphNode(MetaNode<ProtobufDomain.ENTITIES> metaNode, Node node, int x, int y) {
        return new GraphNode2D<>(node, metaNode, x, y, 22, 20, Color.decode("#74add1"), Color.decode("#f5f5f5"), Color.decode("#b30000"), Color.decode("#fee8c8"), NeoModel.getNameOrLabelFrom(node), false);
    }

    protected GraphNode2D<ProtobufDomain.ENTITIES> newEnumValueGraphNode(MetaNode<ProtobufDomain.ENTITIES> metaNode, Node node, int x, int y) {
        return new GraphNode2D<>(node, metaNode, x, y, 22, 20, Color.decode("#abd9e9"), Color.decode("#f5f5f5"), Color.decode("#b30000"), Color.decode("#fee8c8"), NeoModel.getNameOrLabelFrom(node), false);
    }

    protected GraphNode2D<ProtobufDomain.ENTITIES> newFieldTypeGraphNode(MetaNode<ProtobufDomain.ENTITIES> metaNode, Node node, int x, int y) {
        return new GraphNode2D<>(node, metaNode, x, y, 22, 20, Color.decode("#313695"), Color.decode("#f5f5f5"), Color.decode("#b30000"), Color.decode("#fee8c8"), NeoModel.getNameOrLabelFrom(node), false);
    }

    protected GraphNode2D<ProtobufDomain.ENTITIES> newFieldRuleGraphNode(MetaNode<ProtobufDomain.ENTITIES> metaNode, Node node, int x, int y) {
        return new GraphNode2D<>(node, metaNode, x, y, 22, 20, Color.decode("#fee090"), Color.decode("#f5f5f5"), Color.decode("#b30000"), Color.decode("#fee8c8"), NeoModel.getNameOrLabelFrom(node), false);
    }

    protected GraphNode2D<ProtobufDomain.ENTITIES> newPropertyGraphNode(MetaNode<ProtobufDomain.ENTITIES> metaNode, Node node, int x, int y) {
        return new GraphNode2D<>(node, metaNode, x, y, 22, 20, Color.decode("#ffffbf"), Color.decode("#f5f5f5"), Color.decode("#b30000"), Color.decode("#fee8c8"), NeoModel.getNameOrLabelFrom(node), false);
    }

    public static void main(String[] args) {

        final GraphDatabaseService db = new GraphDatabaseFactory().newEmbeddedDatabase(args[0]);
        final ProtobufDomain domain = new ProtobufDomain(new NeoModel(db));
        final ProtobufDomainEditor editor = new ProtobufDomainEditor(domain);

        SwingUtil.setLookAndFeel_Nimbus();
        final JFrame frame = new JFrame("ProtobufDomain");
        frame.addKeyListener(editor);
        frame.getContentPane().add(editor, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SwingUtil.show(frame);
    }
}