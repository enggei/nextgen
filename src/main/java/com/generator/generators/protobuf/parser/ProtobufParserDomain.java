package com.generator.generators.protobuf.parser;

import com.generator.editors.domain.MetaDomain;
import com.generator.editors.domain.MetaNode;
import com.generator.editors.domain.NeoModel;
import com.generator.editors.graph.d2.GraphEditor2D;
import com.generator.editors.graph.d2.GraphNode2D;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.UUID;

import static com.generator.editors.domain.MetaRelation.Cardinality.OneToMany;
import static com.generator.editors.domain.MetaRelation.Cardinality.OneToOne;
import static com.generator.editors.domain.MetaRelation.Direction.OneWay;
import static com.generator.generators.protobuf.parser.ProtobufParserDomain.ENTITIES.*;
import static com.generator.generators.protobuf.parser.ProtobufParserDomain.RELATIONS.*;

/**
 * 
 */
public class ProtobufParserDomain extends MetaDomain<ProtobufParserDomain.ENTITIES, ProtobufParserDomain.RELATIONS> {

    public enum ENTITIES {
        File, PackageDecl, PackageName, Option, Imports, Message, EnumName, MessageContent, Property, DefaultValue, Extensions, PropertyName, PropertyType, ExtensionMax
    }

    public enum RELATIONS implements RelationshipType {
        FILEPACKAGEDECL, FILEOPTION, FILEIMPORTS, FILEMESSAGE, PACKAGEDECLPACKAGENAME, OPTIONPROPERTYNAME, MESSAGEMESSAGECONTENT, MESSAGEENUMNAME, MESSAGECONTENTPROPERTY, MESSAGECONTENTEXTENSIONS, MESSAGECONTENTMESSAGE, PROPERTYPROPERTYTYPE, PROPERTYDEFAULTVALUE, EXTENSIONSEXTENSIONMAX
    }

    public ProtobufParserDomain(final NeoModel model) {
        super(model, "ProtobufParserDomain");

        try (Transaction tx = model.beginTx()) {

            addMetaNode(ENTITIES.File, UUID.randomUUID(), Color.decode("#d1e5f0"), Color.decode("#b2182b"), Color.decode("#000000"), Color.decode("#000000"), 22, 20);
            addMetaNode(ENTITIES.PackageDecl, UUID.randomUUID(), Color.decode("#d1e5f0"), Color.decode("#b2182b"), Color.decode("#000000"), Color.decode("#000000"), 22, 20);
            addMetaNode(ENTITIES.PackageName, UUID.randomUUID(), Color.decode("#d1e5f0"), Color.decode("#b2182b"), Color.decode("#000000"), Color.decode("#000000"), 22, 20);
            addMetaNode(ENTITIES.Option, UUID.randomUUID(), Color.decode("#d1e5f0"), Color.decode("#b2182b"), Color.decode("#000000"), Color.decode("#000000"), 22, 20);
            addMetaNode(ENTITIES.Imports, UUID.randomUUID(), Color.decode("#d1e5f0"), Color.decode("#b2182b"), Color.decode("#000000"), Color.decode("#000000"), 22, 20);
            addMetaNode(ENTITIES.Message, UUID.randomUUID(), Color.decode("#d1e5f0"), Color.decode("#b2182b"), Color.decode("#000000"), Color.decode("#000000"), 22, 20);
            addMetaNode(ENTITIES.EnumName, UUID.randomUUID(), Color.decode("#d1e5f0"), Color.decode("#b2182b"), Color.decode("#000000"), Color.decode("#000000"), 22, 20);
            addMetaNode(ENTITIES.MessageContent, UUID.randomUUID(), Color.decode("#d1e5f0"), Color.decode("#b2182b"), Color.decode("#000000"), Color.decode("#000000"), 22, 20);
            addMetaNode(ENTITIES.Property, UUID.randomUUID(), Color.decode("#d1e5f0"), Color.decode("#b2182b"), Color.decode("#000000"), Color.decode("#000000"), 22, 20);
            addMetaNode(ENTITIES.DefaultValue, UUID.randomUUID(), Color.decode("#d1e5f0"), Color.decode("#b2182b"), Color.decode("#000000"), Color.decode("#000000"), 22, 20);
            addMetaNode(ENTITIES.Extensions, UUID.randomUUID(), Color.decode("#d1e5f0"), Color.decode("#b2182b"), Color.decode("#000000"), Color.decode("#000000"), 22, 20);
            addMetaNode(ENTITIES.PropertyName, UUID.randomUUID(), Color.decode("#d1e5f0"), Color.decode("#b2182b"), Color.decode("#000000"), Color.decode("#000000"), 22, 20);
            addMetaNode(ENTITIES.PropertyType, UUID.randomUUID(), Color.decode("#d1e5f0"), Color.decode("#b2182b"), Color.decode("#000000"), Color.decode("#000000"), 22, 20);
            addMetaNode(ENTITIES.ExtensionMax, UUID.randomUUID(), Color.decode("#d1e5f0"), Color.decode("#b2182b"), Color.decode("#000000"), Color.decode("#000000"), 22, 20);

            addMetaRelation(FILEPACKAGEDECL, newNodeSet(File), newNodeSet(PackageDecl), OneToOne, OneWay);
            addMetaRelation(FILEOPTION, newNodeSet(File), newNodeSet(Option), OneToMany, OneWay);
            addMetaRelation(FILEIMPORTS, newNodeSet(File), newNodeSet(Imports), OneToMany, OneWay);
            addMetaRelation(FILEMESSAGE, newNodeSet(File), newNodeSet(Message), OneToMany, OneWay);
            addMetaRelation(PACKAGEDECLPACKAGENAME, newNodeSet(PackageDecl), newNodeSet(PackageName), OneToOne, OneWay);
            addMetaRelation(OPTIONPROPERTYNAME, newNodeSet(Option), newNodeSet(PropertyName), OneToOne, OneWay);
            addMetaRelation(MESSAGEMESSAGECONTENT, newNodeSet(Message), newNodeSet(MessageContent), OneToMany, OneWay);
            addMetaRelation(MESSAGEENUMNAME, newNodeSet(Message), newNodeSet(EnumName), OneToMany, OneWay);
            addMetaRelation(MESSAGECONTENTPROPERTY, newNodeSet(MessageContent), newNodeSet(Property), OneToOne, OneWay);
            addMetaRelation(MESSAGECONTENTEXTENSIONS, newNodeSet(MessageContent), newNodeSet(Extensions), OneToOne, OneWay);
            addMetaRelation(MESSAGECONTENTMESSAGE, newNodeSet(MessageContent), newNodeSet(Message), OneToOne, OneWay);
            addMetaRelation(PROPERTYPROPERTYTYPE, newNodeSet(Property), newNodeSet(PropertyType), OneToOne, OneWay);
            addMetaRelation(PROPERTYDEFAULTVALUE, newNodeSet(Property), newNodeSet(DefaultValue), OneToOne, OneWay);
            addMetaRelation(EXTENSIONSEXTENSIONMAX, newNodeSet(Extensions), newNodeSet(ExtensionMax), OneToOne, OneWay);

            validate();

            tx.success();
        }
    }

    @Override
    protected final ENTITIES entity(String s) {
        return ENTITIES.valueOf(s);
    }

    @Override
    protected final RELATIONS relation(String s) {
        return RELATIONS.valueOf(s);
    }

    @Override
    public final MetaNode<ENTITIES> getRootNode() {
        return getNode(File);
    }

    @Override
    public final boolean isConstrained(Node node) {
        return super.isConstrained(node);
    }



    public static class ProtobufParserDomainEditor extends JPanel {

        public ProtobufParserDomainEditor(JFrame frame, final ProtobufParserDomain domain) {
            super(new BorderLayout());
            setPreferredSize(new Dimension(800, 600));

            final GraphEditor2D activeEditor = new GraphEditor2D(domain) {
                @Override
                public final void rightClickSelect(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D targetNode) {
                    super.rightClickSelect(mouseEvent, popupMenu, targetNode);

                    final MetaNode<ENTITIES> metaNode = targetNode.getMetaNode();
                    if (metaNode == null) return;   // targetNode not recognized by ProtobufParserDomain

                    switch (metaNode.getLabel()) {
                        case File:
                            rightClickFile(mouseEvent, popupMenu, targetNode);
                            break;
                        case PackageDecl:
                            rightClickPackageDecl(mouseEvent, popupMenu, targetNode);
                            break;
                        case PackageName:
                            rightClickPackageName(mouseEvent, popupMenu, targetNode);
                            break;
                        case Option:
                            rightClickOption(mouseEvent, popupMenu, targetNode);
                            break;
                        case Imports:
                            rightClickImports(mouseEvent, popupMenu, targetNode);
                            break;
                        case Message:
                            rightClickMessage(mouseEvent, popupMenu, targetNode);
                            break;
                        case EnumName:
                            rightClickEnumName(mouseEvent, popupMenu, targetNode);
                            break;
                        case MessageContent:
                            rightClickMessageContent(mouseEvent, popupMenu, targetNode);
                            break;
                        case Property:
                            rightClickProperty(mouseEvent, popupMenu, targetNode);
                            break;
                        case DefaultValue:
                            rightClickDefaultValue(mouseEvent, popupMenu, targetNode);
                            break;
                        case Extensions:
                            rightClickExtensions(mouseEvent, popupMenu, targetNode);
                            break;
                        case PropertyName:
                            rightClickPropertyName(mouseEvent, popupMenu, targetNode);
                            break;
                        case PropertyType:
                            rightClickPropertyType(mouseEvent, popupMenu, targetNode);
                            break;
                        case ExtensionMax:
                            rightClickExtensionMax(mouseEvent, popupMenu, targetNode);
                            break;
                    }
                }

                protected void rightClickFile(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D targetNode) {
                }

                protected void rightClickPackageDecl(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D targetNode) {
                }

                protected void rightClickPackageName(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D targetNode) {
                }

                protected void rightClickOption(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D targetNode) {
                }

                protected void rightClickImports(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D targetNode) {
                }

                protected void rightClickMessage(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D targetNode) {
                }

                protected void rightClickEnumName(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D targetNode) {
                }

                protected void rightClickMessageContent(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D targetNode) {
                }

                protected void rightClickProperty(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D targetNode) {
                }

                protected void rightClickDefaultValue(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D targetNode) {
                }

                protected void rightClickExtensions(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D targetNode) {
                }

                protected void rightClickPropertyName(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D targetNode) {
                }

                protected void rightClickPropertyType(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D targetNode) {
                }

                protected void rightClickExtensionMax(MouseEvent mouseEvent, JPopupMenu popupMenu, GraphNode2D targetNode) {
                }
            };
            frame.addKeyListener(activeEditor);
            addKeyListener(activeEditor);

            add(activeEditor, BorderLayout.CENTER);
        }
    }
}