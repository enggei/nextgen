package com.generator.generators.protobuf;

import com.generator.editors.graph.GraphEditorAction;
import com.generator.editors.graph.d2.GraphEditor2D;
import com.generator.editors.graph.d2.GraphNode2D;
import com.generator.generators.protobuf.parser.ProtobufParser;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;

import java.io.File;
import java.io.FileReader;
import java.util.*;

import static com.generator.generators.protobuf.ProtobufDomain.ENTITIES;
import static com.generator.generators.protobuf.ProtobufDomain.ENTITIES.Enum;
import static com.generator.generators.protobuf.ProtobufDomain.ENTITIES.*;
import static com.generator.generators.protobuf.ProtobufDomain.ENTITIES.Package;
import static com.generator.generators.protobuf.ProtobufDomain.RELATIONS;
import static com.generator.generators.protobuf.ProtobufDomain.RELATIONS.*;

/**
 * goe on 3/26/15.
 */
public class ParseProtoFileAction extends GraphEditorAction<ENTITIES, RELATIONS, GraphNode2D<ENTITIES>, GraphEditor2D<ENTITIES, RELATIONS, GraphNode2D<ENTITIES>>> {

    public ParseProtoFileAction(GraphEditor2D<ENTITIES, RELATIONS, GraphNode2D<ENTITIES>> editor) {
        super("Parse .proto file", editor);
    }

    @Override
    public void doAction(Transaction tx) throws Throwable {

        final File file = SwingUtil.showOpenFile(editor);
        if (file != null && file.exists()) {

            final Node parseNode = editor.getDomain().newNode(ENTITIES.File, UUID.randomUUID(), "name", file.getAbsolutePath());

            // todo this is better than ParseEasyFlowFileAction:
            // #1 it enforces the domain- constraints
            // #2 it is compile-time enforced
            // todo: check if this is reversing parse-content:

            ProtobufParser parser = new ProtobufParser(ProtobufParser.createLexer(new FileReader(file.getAbsolutePath()))) {

                private final Stack<Node> messageStack = new Stack<>();
                private final Map<Node, String> unmappedTypes = new LinkedHashMap<>();

                @Override
                public void packageName(String name) {
                    this.messageStack.push(editor.getDomain().newNode(Package, UUID.randomUUID(), "name", name));
                    editor.getDomain().relate(PACKAGE, parseNode, this.messageStack.peek());
                }

                @Override
                public void option(String name, String value) {
                    editor.getDomain().relate(OPTIONS, this.messageStack.peek(), editor.getDomain().newNode(Option, UUID.randomUUID(), name, value));
                }

                @Override
                public void imports(String name) {
                    editor.getDomain().relate(IMPORT, this.messageStack.peek(), editor.getDomain().newNode(Import, UUID.randomUUID(), "package", name));
                }

                @Override
                public void newMessage(String name, String comment) {
                    final Node parent = messageStack.peek();
                    messageStack.push(editor.getDomain().newNode(Message, UUID.randomUUID(), "name", name, "comment", filterComments(comment)));
                    editor.getDomain().relate(MESSAGE, parent, messageStack.peek());
                }

                @Override
                public void endMessage() {
                    messageStack.pop();
                }

                @Override
                public void newProperty(FieldRules rule, String propertyType, String propertyName, Integer ordinal, String comment, String parent, String defaultValue) {
                    final Node node = editor.getDomain().newNode(Property, UUID.randomUUID(), "parent", (parent == null ? "" : parent), "name", propertyName, "ordinal", ordinal.toString(), "comment", filterComments(comment), "defaultValue", defaultValue);

                    editor.getDomain().relate(FIELD, messageStack.peek(), node);
                    editor.getDomain().relate(RELATIONS.FIELDRULE, node, ((ProtobufDomain)editor.getDomain()).defaultFieldRule().get(rule.name()));

                    if (((ProtobufDomain)editor.getDomain()).defaultFieldType().containsKey(propertyType)) {
                        editor.getDomain().relate(FIELDTYPE, node, ((ProtobufDomain)editor.getDomain()).defaultFieldType().get(propertyType));
                    } else {
                        unmappedTypes.put(node, propertyType);
                    }
                }

                @Override
                public void newExtensions(String min, String max) {
                    editor.getDomain().relate(FIELD, messageStack.peek(), editor.getDomain().newNode(Extensions, UUID.randomUUID(), "min", min, "max", max));
                }

                @Override
                public void endExtension() {
                    messageStack.pop();
                }

                @Override
                public void newEnum(String name, String comment) {
                    final Node parent = messageStack.peek();
                    final Node node = editor.getDomain().newNode(Enum, UUID.randomUUID(), "name", name, "comment", filterComments(comment));
                    messageStack.push(node);
                    editor.getDomain().relate(MESSAGE, parent, messageStack.peek());
                }

                @Override
                public void newEnumValue(String name, Integer ordinal, String comment) {
                    editor.getDomain().relate(ENUMVALUE, messageStack.peek(), editor.getDomain().newNode(EnumValue, UUID.randomUUID(), "name", name, "ordinal", ordinal.toString(), "comment", filterComments(comment)));
                }

                @Override
                public void endEnum() {
                    messageStack.pop();
                }

                @Override
                public void newExtension(String name) {
                    final Node parent = messageStack.peek();
                    messageStack.push(editor.getDomain().newNode(Extend, UUID.randomUUID(), "name", name));
                    editor.getDomain().relate(MESSAGE, parent, messageStack.peek());
                }

                @Override
                public void end() {

                    messageStack.pop();

                    final Set<Node> foundNodes = new LinkedHashSet<>();
                    try (Transaction tx = editor.getDomain().getModel().beginTx()) {

                        for (Map.Entry<Node, String> entry : unmappedTypes.entrySet()) {
                            final Node propertyNode = entry.getKey();
                            final Queue<String> propertyType = new ArrayDeque<>();
                            Collections.addAll(propertyType, entry.getValue().split("[.]"));
                            final Node messageNode = propertyNode.getSingleRelationship(FIELD, Direction.INCOMING).getOtherNode(propertyNode);

                            final Stack<Node> path = new Stack<>();
                            path.add(messageNode);
                            while (!path.peek().hasRelationship(Direction.OUTGOING, PACKAGE)) {
                                for (Relationship relationship : path.peek().getRelationships(Direction.OUTGOING, MESSAGE)) {
                                    Node candidateNode = relationship.getOtherNode(path.peek());
                                    if (!candidateNode.getProperty("name").equals(propertyType.peek())) continue;

                                    propertyType.poll();
                                    while (!propertyType.isEmpty()) {
                                        boolean found = false;
                                        for (Relationship nested : candidateNode.getRelationships(Direction.OUTGOING, MESSAGE)) {
                                            if (!nested.getOtherNode(candidateNode).getProperty("name").equals(propertyType.peek()))
                                                continue;
                                            propertyType.poll();
                                            found = true;
                                            candidateNode = nested.getOtherNode(candidateNode);
                                            break;
                                        }

                                        if (!found) {
                                            System.out.println("could not find " + propertyType);
                                            break;
                                        }
                                    }

                                    editor.getDomain().relate(FIELDTYPE, propertyNode, candidateNode);
                                    foundNodes.add(propertyNode);
                                    break;
                                }
                                if (propertyType.isEmpty()) break;
                                if (!path.peek().hasRelationship(Direction.INCOMING, MESSAGE))
                                    break;

                                path.add(path.peek().getSingleRelationship(MESSAGE, Direction.INCOMING).getOtherNode(path.peek()));
                            }
                        }
                        tx.success();
                    }

                    for (Node foundNode : foundNodes) unmappedTypes.remove(foundNode);
                    if (unmappedTypes.isEmpty()) return;

                    for (Map.Entry<Node, String> entry : unmappedTypes.entrySet())
                        System.err.println("STILL unmapped: " + entry.getKey().getProperty("name") + " " + entry.getValue());
                }

                protected String filterComments(String comment) {
                    return comment == null ? null : comment.replaceAll("//", "").trim();
                }
            };

            parser.file();

            // show and select node
            editor.getOrAdd(parseNode);
        }
    }
}