package com.generator.generators.java;

import com.generator.editors.domain.BaseDomainVisitor;
import com.generator.editors.graph.d2.GraphEditor2D;
import com.generator.editors.graph.GraphEditorAction;
import com.generator.editors.graph.d2.GraphNode2D;
import com.generator.generators.java.parser.JavaParser;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

import java.io.File;
import java.io.FileReader;
import java.util.Stack;
import java.util.UUID;

import static com.generator.generators.java.JavaDomain.ENTITIES;
import static com.generator.generators.java.JavaDomain.RELATIONS;

/**
 * goe on 4/6/15.
 * todo: continue, so all JDK sources can be parsed and put in NeoGraph (with annotations etc)
 */
public class ParseJavaFileAction extends GraphEditorAction<ENTITIES, RELATIONS, GraphNode2D<ENTITIES>, GraphEditor2D<ENTITIES, RELATIONS, GraphNode2D<ENTITIES>>> {

    public ParseJavaFileAction(String name, GraphEditor2D<ENTITIES, RELATIONS, GraphNode2D<ENTITIES>> editor) {
        super(name, editor);
    }

    public ParseJavaFileAction(GraphEditor2D<ENTITIES, RELATIONS, GraphNode2D<ENTITIES>> editor) {
        super("Parse .java file", editor);
    }

    @Override
    public void doAction(Transaction tx) throws Throwable {

        final File file = SwingUtil.showOpenFile(editor);
        if (file != null && file.exists()) {
            final Node parseNode = parseJavaFile(file);
            // show and select node
            editor.getOrAdd(parseNode);
        }
    }

    protected Node parseJavaFile(final File file) throws java.io.IOException {
        final Node parseNode = editor.getDomain().newNode(ENTITIES.FILE, UUID.randomUUID(), "name", file.getAbsolutePath());

        final JavaParser javaParser = new JavaParser(JavaParser.createLexer(new FileReader(file.getAbsolutePath()))) {

            private final Stack<Node> currentNode = new Stack<>();

            @Override
            public void packageName(String name) {
                currentNode.push(editor.getDomain().newNode(ENTITIES.PACKAGE, UUID.randomUUID(), "name", name));
            }

            @Override
            public void className(String modifier, String name) {
                final Node parent = currentNode.peek();

                currentNode.push(editor.getDomain().newNode(ENTITIES.CLASS, UUID.randomUUID(), "name", name));

                if (BaseDomainVisitor.isType(parent, ENTITIES.CLASS))
                    editor.getDomain().relate(RELATIONS.MEMBER, parent, currentNode.peek());
                editor.getDomain().relate(RELATIONS.CONTAINS, parseNode, currentNode.peek());
            }

            @Override
            public void interfaceName(String name) {
                final Node parent = currentNode.peek();
                currentNode.push(editor.getDomain().newNode(ENTITIES.INTERFACE, UUID.randomUUID(), "name", name));
                editor.getDomain().relate(RELATIONS.MEMBER, parent, currentNode.peek());
            }

            @Override
            public void annotationName(String name) {
                System.out.println("@ -> " + name);
            }

            @Override
            public void newBlock() {
                System.out.println("\t\tBLOCK START");
            }

            @Override
            public void endBlock() {
                System.out.println("\t\tBLOCK END");
            }

            @Override
            public void newLocalVariableStatement(String statement) {
                System.out.println("\t\t\t" + statement);
            }

            @Override
            public void newStatement(String statement) {
                System.out.println("\t\t\t" + statement);
            }

            @Override
            public void newTypeDeclaration(String declaration) {
                System.out.println("\t\t\t" + declaration);
            }

            @Override
            public void interfaceExtends(String name) {

                final String[] s = name.split(",");
                for (String ss : s) {
                    System.out.println("extends: '" + ss + "'");
                }
            }

            @Override
            public void enumName(String name) {
                System.out.println("\t" + name);
            }

            @Override
            public void newMethod(String returnType, String name) {
                final Node parent = currentNode.peek();
                currentNode.push(editor.getDomain().newNode(ENTITIES.METHOD, UUID.randomUUID(), "name", name));
                // todo find returnType-node
                //editor.getDomain().relate(RELATIONS.DECLARES, parent, currentNode.peek());
            }

            @Override
            public void newParameter(String modifier, String type, String name) {
                System.out.println("\t\t\tparameter: " + modifier + " " + type + " " + name);
            }

            @Override
            public void newField(String modifier, String type, String name, String initalizer) {
                System.out.println("\t\tfield: " + (modifier == null ? "" : modifier) + type + " : " + name + " : " + initalizer);
            }

            @Override
            public void endMethod(String methodBody) {
                System.out.println("\t\t" + methodBody + "\n");
            }
        };

        javaParser.compilationUnit();

        return parseNode;
    }
}