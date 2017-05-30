package com.generator.generators.java;

import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.NeoPNode;
import com.generator.generators.templates.domain.GeneratedFile;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;
import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Stack;
import java.util.function.Consumer;

import static com.generator.editors.BaseDomainVisitor.*;

/**
 * Created 26.04.17.E
 */
public class JavaDomainImpl extends JavaDomain {

   @Override
   public void addToDomainMenu(PInputEvent event, NeoEditor editor, JMenu domainMenu) {
      domainMenu.add(editor.newAddNodeAction(Entities.Package, "name", event));
      domainMenu.add(editor.newAddNodeAction(Entities.Generator, "name", event));
      domainMenu.add(new NeoEditor.TransactionAction("Parse class", editor) {
         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
         }
      });
   }

   @Override
   protected NeoPNode newGeneratorPNode(Node node, NeoEditor editor) {
      return new GeneratorPNode(node, editor) {
         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {

            pop.add(new NeoEditor.TransactionAction("Generate", editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  final JavaDomainGroup javaGroup = new JavaDomainGroup();

                  new JavaDomainVisitor() {

                     private String root;
                     private final Stack<JavaDomainGroup.javaclassST> classSTStack = new Stack<>();

                     @Override
                     <T> T visitGenerator(Node node) {
                        root = getString(node, Properties.root.name());
                        if (root == null) throw new IllegalStateException("No root set. Set root first");

                        outgoing(node, Relations.GENERATE).forEach(relationship -> visit(other(node, relationship)));
                        return super.visitGenerator(node);
                     }

                     @Override
                     <T> T visitPackage(Node node) {

                        final String packageName = getString(node, Properties.name.name());

                        outgoing(node, Relations.MEMBER).forEach(relationship -> {
                           final String className = getOtherProperty(node, relationship, Properties.name.name());
                           final GeneratedFile javaFile = GeneratedFile.newJavaFile(root, packageName, className);
//                           try {
                           visit(other(node, relationship));
                           classSTStack.peek().setPackage(packageName);
                           System.out.println(classSTStack.peek());
//                              javaFile.write(classSTStack.pop());
//                           } catch (IOException e1) {
//                              throw new IllegalStateException("Could not write to file " + javaFile.getFile().getAbsolutePath());
//                           }
                        });

                        return super.visitPackage(node);
                     }

                     @Override
                     <T> T visitClass(Node node) {
                        classSTStack.push(javaGroup.newjavaclass());
                        classSTStack.peek().setName(getString(node, Properties.name.name()));
                        classSTStack.peek().setScope(getString(node, Properties.scope.name()));

                        //todo implements, extends

                        outgoing(node, Relations.FIELD).forEach(relationship -> visit(other(node, relationship)));
                        outgoing(node, Relations.CONSTRUCTOR).forEach(relationship -> visit(other(node, relationship)));
                        outgoing(node, Relations.METHOD).forEach(relationship -> visit(other(node, relationship)));
                        outgoing(node, Relations.INNERCLASS).forEach(relationship -> visit(other(node, relationship)));
                        return super.visitClass(node);
                     }

                     @Override
                     <T> T visitField(Node node) {
                        final Object type = hasOutgoing(node, Relations.TYPE) ? getOtherProperty(node, singleOutgoing(node, Relations.TYPE), Properties.name.name()) : "Object";
                        classSTStack.peek().addFieldsValue(getString(node, Properties.name.name()), getString(node, Properties.scope.name()), type);
                        return super.visitField(node);
                     }

                     @Override
                     <T> T visitMethod(Node node) {

                        final JavaDomainGroup.parametersST parameters = javaGroup.newparameters();
                        outgoing(node, Relations.PARAMETER).forEach(new Consumer<Relationship>() {
                           @Override
                           public void accept(Relationship relationship) {
                              parameters.addParametersValue(getString(relationship, Properties.name.name()), getOtherProperty(node, relationship, Properties.name.name()));
                           }
                        });

                        final Object returnValue = hasOutgoing(node, Relations.RETURNVALUE) ? getOtherProperty(node, singleOutgoing(node, Relations.RETURNVALUE), Properties.name.name()) : "void";
                        final String scope = getString(node, Properties.scope.name());
                        classSTStack.peek().addMethodsValue(getString(node, Properties.name.name()), returnValue, scope.equals("package") ? "" : scope, parameters);
                        return super.visitMethod(node);
                     }

                     @Override
                     <T> T visitInterface(Node node) {
                        return super.visitInterface(node);
                     }

                     @Override
                     <T> T visitConstructor(Node node) {

                        final JavaDomainGroup.parametersST parameters = javaGroup.newparameters();
                        outgoing(node, Relations.PARAMETER).forEach(new Consumer<Relationship>() {
                           @Override
                           public void accept(Relationship relationship) {
                              parameters.addParametersValue(getString(relationship, Properties.name.name()), getOtherProperty(node, relationship, Properties.name.name()));
                           }
                        });

                        classSTStack.peek().addConstructorsValue(parameters);
                        return super.visitConstructor(node);
                     }

                     @Override
                     <T> T visitJavaStatement(Node node) {
                        return super.visitJavaStatement(node);
                     }
                  }.visit(node);
               }
            });

            super.showNodeActions(pop, event);
         }
      };
   }

   @Override
   protected NeoPNode newPackagePNode(Node node, NeoEditor editor) {
      return new PackagePNode(node, editor) {
         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {
            super.showNodeActions(pop, event);
         }
      };
   }

   @Override
   protected NeoPNode newClassPNode(Node node, NeoEditor editor) {
      return new ClassPNode(node, editor) {
         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {
            super.showNodeActions(pop, event);
         }
      };
   }

   @Override
   protected NeoPNode newFieldPNode(Node node, NeoEditor editor) {
      return new FieldPNode(node, editor) {
         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {
            pop.add(editor.newSetNodePropertyAction(JavaDomain.Properties.name.name(), this));

            super.showNodeActions(pop, event);
         }
      };
   }

   @Override
   protected NeoPNode newMethodPNode(Node node, NeoEditor editor) {
      return new MethodPNode(node, editor) {
         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {
            super.showNodeActions(pop, event);
         }
      };
   }

   @Override
   protected NeoPNode newInterfacePNode(Node node, NeoEditor editor) {
      return new InterfacePNode(node, editor) {
         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {
            super.showNodeActions(pop, event);
         }
      };
   }

   @Override
   protected NeoPNode newConstructorPNode(Node node, NeoEditor editor) {
      return new ConstructorPNode(node, editor) {
         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {
            super.showNodeActions(pop, event);
         }
      };
   }

   @Override
   protected NeoPNode newJavaStatementPNode(Node node, NeoEditor editor) {
      return new JavaStatementPNode(node,editor) {
         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {
            super.showNodeActions(pop, event);
         }
      };
   }
}