package com.generator.generators.javaparser;

import com.generator.editors.NeoModel;
import com.generator.util.FileUtil;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.graphdb.factory.GraphDatabaseSettings;

import java.io.File;
import java.util.*;

import static com.generator.editors.BaseDomainVisitor.*;
import static org.neo4j.graphdb.RelationshipType.withName;

/**
 * Created 10.01.17.
 */
public class JavaParserDomain {

    public static final class DomainBuilder {

        private final NeoModel graph;
        private final Node domainNode;
        private final Map<String, DomainLabel> labels = new TreeMap<>();
        private final Map<String, DomainRelation> relations = new TreeMap<>();
        private final RelationshipType domainLabels = withName("domain_LABELS");
        private final RelationshipType domainRelations = withName("domain_RELATIONS");

        DomainBuilder(NeoModel graph, String domainName) {
            this.graph = graph;
            this.domainNode = getOrCreate(graph, "DOMAIN", "name", domainName);
            this.domainNode.getRelationships(Direction.OUTGOING, domainLabels).forEach(relationship -> {
                final DomainLabel lblNode = new DomainLabel(other(domainNode, relationship));
                labels.put(lblNode.name(), lblNode);
            });
            this.domainNode.getRelationships(Direction.OUTGOING, domainRelations).forEach(relationship -> {
                final DomainRelation domainRelation = new DomainRelation(other(domainNode, relationship));
                relations.put(domainRelation.name(), domainRelation);
            });
        }

        public DomainBuilder addLabel(String name) {
            if (labels.containsKey(name)) return this;
            final Node labelNode = getOrCreate(graph, "Label", "name", name);
            domainNode.createRelationshipTo(labelNode, domainLabels);
            labels.put(name, new DomainLabel(labelNode));
            return this;
        }

        DomainLabel getLabel(String name) {
            return this.labels.get(name);
        }

        DomainBuilder addRelation(String name, String src, String dst) {

            if (relations.containsKey(name)) {
                relations.get(name).
                        addSrc(getLabel(src)).
                        addDst(getLabel(dst));
                return this;
            }

            final Node relationNode = getOrCreate(graph, "Relation", "name", name);
            domainNode.createRelationshipTo(relationNode, domainRelations);
            relations.put(name, new DomainRelation(relationNode).
                    addSrc(getLabel(src)).
                    addDst(getLabel(dst)));

            return this;
        }

        DomainRelation getRelation(String name) {
            return this.relations.get(name);
        }

        private Node getOrCreate(NeoModel graph, String label, String key, String value) {
            final Set<Node> set = graph.getAll(label, key, value);
            System.out.println("set: " + set.size());
            if (set.isEmpty()) return graph.newNode(label, key, value);
            else if (set.size() == 1) return set.iterator().next();
            else throw new IllegalStateException("more than 1 node with " + label + " " + key + "=" + value);
        }

        private final class DomainLabel implements Comparable<DomainLabel> {

            private final Node node;
            private final String name;

            DomainLabel(Node node) {
                this.node = node;
                this.name = get(node, "name");
            }

            public String name() {
                return name;
            }

            public Node newNode() {
                return graph.newNode(name);
            }

            public Node newNode(String... kv) {
                return graph.newNode(name, kv);
            }

            Node getOrCreate(String key, String value) {
                final Set<Node> set = graph.getAll(name, key, value);
                System.out.println("found " + set.size() + " " + name + " (" + key + "=" + value + ")");
                if (set.isEmpty()) return graph.newNode(name, key, value);
                else if (set.size() == 1) return set.iterator().next();
                else throw new IllegalStateException("more than 1 node with " + name + " " + key + "=" + value);
            }

            public ResourceIterator<Node> all() {
                return graph.findNodes(() -> name);
            }

            @Override
            public int compareTo(DomainLabel o) {
                return this.name.compareToIgnoreCase(o.name);
            }
        }

        private final class DomainRelation {

            private final Node node;
            private final String name;
            private final Set<DomainLabel> sources = new TreeSet<>();
            private final Set<DomainLabel> destinations = new TreeSet<>();
            private final RelationshipType source = withName("_source");
            private final RelationshipType destination = withName("_destination");

            DomainRelation(Node node) {
                this.node = node;
                this.name = get(node, "name");
            }

            String name() {
                return name;
            }

            RelationshipType type() {
                return withName(name);
            }

            DomainRelation addSrc(DomainLabel domainLabel) {
                if (sources.contains(domainLabel)) return this;
                node.createRelationshipTo(domainLabel.node, source);
                sources.add(domainLabel);
                return this;
            }

            DomainRelation addDst(DomainLabel domainLabel) {
                if (destinations.contains(domainLabel)) return this;
                node.createRelationshipTo(domainLabel.node, destination);
                destinations.add(domainLabel);
                return this;
            }
        }
    }

    public static void main(String[] args) {

        final NeoModel graph = new NeoModel(new GraphDatabaseFactory()
                .newEmbeddedDatabaseBuilder(new java.io.File("/home/goe/dbtest"))
                .setConfig(GraphDatabaseSettings.allow_store_upgrade, "true")
                .newGraphDatabase());

        File[] list = FileUtil.list("/home/goe/udc/trailer-report/src/main/java/com/ud/tr/domain", ".java");

        graph.doInTransaction(new NeoModel.Committer() {
            @Override
            public void doAction(Transaction tx) throws Throwable {

                // define domain :
                final DomainBuilder domainBuilder = new DomainBuilder(graph, "Java").
                        addLabel("Package").
                        addLabel("TypeDeclaration").
                        addRelation("packageMember", "Package", "TypeDeclaration");

                for (int i = 0; i < list.length; i++) {
                    File file = list[i];
                    System.out.println(file);

                    CompilationUnit cu = JavaParser.parse(file);

                    new VoidVisitorAdapter<String>() {

                        final Stack<Node> currentPackage = new Stack<Node>();
                        final Stack<Node> currentClass = new Stack<Node>();

                        @Override
                        public void visit(PackageDeclaration n, String arg) {

                            System.out.println("PackageDeclaration " + n.getPackageName());

                            final Node packageNode = domainBuilder.
                                    getLabel("Package").
                                    getOrCreate("name", n.getPackageName());

                            currentPackage.push(packageNode);
                            super.visit(n, arg);
                        }

                        @Override
                        public void visit(ClassOrInterfaceDeclaration n, String arg) {

                            System.out.println("ClassOrInterfaceDeclaration " + n.getName());

                            final Node packageNode = currentPackage.peek();

                            Node typeDeclarationNode = null;
                            for (Relationship packageMember : outgoing(packageNode, withName("packageMember"))) {
                                final String typeDeclarationName = getOtherProperty(packageNode, packageMember, "name");
                                if (n.getName().equals(typeDeclarationName)) {
                                    typeDeclarationNode = other(packageNode, packageMember);
                                    break;
                                }
                            }

                            if (typeDeclarationNode == null) {
                                typeDeclarationNode = domainBuilder.getLabel("TypeDeclaration").getOrCreate("name", n.getName());
                                packageNode.createRelationshipTo(typeDeclarationNode, domainBuilder.getRelation("packageMember").type());
                            }

                            currentClass.push(typeDeclarationNode);
                            super.visit(n, arg);
                            currentClass.pop();
                        }

                        @Override
                        public void visit(FieldDeclaration n, String arg) {

                            for (VariableDeclarator variableDeclarator : n.getVariables()) {
                                System.out.println(variableDeclarator.getId() + (variableDeclarator.getInit() == null ? "" : variableDeclarator.getInit() + ""));
                            }

                            super.visit(n, arg);
                        }
                    }.visit(cu, null);
                }
            }

            @Override
            public void exception(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }
}