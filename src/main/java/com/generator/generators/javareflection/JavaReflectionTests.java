package com.generator.generators.javareflection;

import com.generator.editors.BaseDomainVisitor;
import com.generator.editors.NeoModel;
import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.util.ClasspathUtil;
import com.generator.util.FileUtil;
import org.junit.Test;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.Transaction;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

import static com.generator.editors.BaseDomainVisitor.*;
import static com.generator.generators.javareflection.JavaBuilderDomain.Entities;
import static com.generator.generators.javareflection.JavaBuilderDomain.Relations.PARENT;

/**
 * Created 20.05.17.
 */
public class JavaReflectionTests {

   @Test
   public void testReflection() throws IOException {

      final Set<String> classes = new LinkedHashSet<>();
      ClasspathUtil.findClasses(s -> {
         classes.add(s);
         return true;
      });


      final String dir = "/home/goe/projects/nextgen/src/main/java/com/generator/generators/javareflection/db";
      FileUtil.removeFilesUnder(dir);

      final NeoModel neoModel = NeoEditor.newEmbeddedDatabase(dir);

      final AtomicInteger current = new AtomicInteger(0);
      final AtomicInteger max = new AtomicInteger(5);

      neoModel.doInTransaction(new NeoModel.Committer() {
         @Override
         public void doAction(Transaction tx) throws Throwable {

            int count = 0;
            int ignored = 0;
            for (String aClass : classes) {
               if(count<current.get()) {
                  count++;
                  continue;
               }
               try {
                  System.out.println(aClass + " (" + (++count) + "/" + (classes.size() - ignored) + ")");
                  findClassNode(Class.forName(aClass), neoModel);
               } catch (UnsatisfiedLinkError e) {
                  System.out.println("ignoring " + aClass);
                  ignored++;
               }

               if(count>=max.get()) {
                  return;
               }
            }

            neoModel.findNodes(Entities.PACKAGE).forEachRemaining(new Consumer<Node>() {
               @Override
               public void accept(Node packageNode) {
                  System.out.println("package " + getString(packageNode, JavaBuilderDomain.Properties.name.name()));

                  for (Relationship classPackageRelation : incoming(packageNode, JavaBuilderDomain.Relations.PACKAGE)) {
                     printClass(other(packageNode, classPackageRelation));
                  }
               }
            });
         }

         private void printClass(Node classNode) {
            System.out.print("\t" + (hasLabel(classNode, Entities.INTERFACE) ? " i " : " c ") + getString(classNode, JavaBuilderDomain.Properties.name.name()));
            final Relationship superclassRelation = singleOutgoing(classNode, JavaBuilderDomain.Relations.PARENT);
            if (superclassRelation != null) {
               System.out.println(" extends " + getString(other(classNode, superclassRelation), JavaBuilderDomain.Properties.name.name()));
            } else {
               System.out.println();
            }

            for (Relationship interfaceRelation : outgoing(classNode, JavaBuilderDomain.Relations.INTERFACE)) {
               final Node interfaceNode = other(classNode, interfaceRelation);
               System.out.println("\t\timplements " + getString(interfaceNode, JavaBuilderDomain.Properties.name.name()));
            }

            for (Relationship constructorRelation : outgoing(classNode, JavaBuilderDomain.Relations.CONSTRUCTOR)) {
               final Node constructorNode = other(classNode, constructorRelation);
               System.out.print("\t\tc ");
               final StringBuilder params = new StringBuilder("(");
               boolean first = true;
               for (Relationship parameterRelation : outgoing(constructorNode, JavaBuilderDomain.Relations.PARAMETER)) {
                  final Node parameterNode = other(constructorNode, parameterRelation);
                  if (!first) params.append(",");
                  first = false;
                  final Relationship parameterTypeRelation = singleOutgoing(parameterNode, JavaBuilderDomain.Relations.TYPE);
                  params.append((String) getOtherProperty(parameterNode, parameterTypeRelation, JavaBuilderDomain.Properties.name.name()));
               }
               System.out.println(params.append(")"));
            }

            for (Relationship methodRelation : outgoing(classNode, JavaBuilderDomain.Relations.METHOD)) {
               final Node methodNode = other(classNode, methodRelation);
               System.out.print("\t\tm " + getString(methodNode, JavaBuilderDomain.Properties.name.name()));
               final StringBuilder params = new StringBuilder("(");
               boolean first = true;
               for (Relationship parameterRelation : outgoing(methodNode, JavaBuilderDomain.Relations.PARAMETER)) {
                  final Node parameterNode = other(methodNode, parameterRelation);
                  if (!first) params.append(",");
                  first = false;
                  final Relationship parameterTypeRelation = singleOutgoing(parameterNode, JavaBuilderDomain.Relations.TYPE);
                  params.append((String) getOtherProperty(parameterNode, parameterTypeRelation, JavaBuilderDomain.Properties.name.name()));
               }
               System.out.println(params.append(")"));
            }

            for (Relationship fieldRelation : outgoing(classNode, JavaBuilderDomain.Relations.FIELD)) {
               final Node fieldNode = other(classNode, fieldRelation);
               System.out.print("\t\tf " + getString(fieldNode, JavaBuilderDomain.Properties.name.name()) + " (");
               final Relationship fieldTypeRelation = singleOutgoing(fieldNode, JavaBuilderDomain.Relations.TYPE);
               System.out.println((String) getOtherProperty(fieldNode, fieldTypeRelation, JavaBuilderDomain.Properties.name.name()) + ")");
            }
         }

         private Node findClassNode(Class reflectedClass, NeoModel neoModel) {
            final Node packageNode = findPackageNode(reflectedClass.getPackage(), neoModel);

            final String simpleName = "".equals(reflectedClass.getSimpleName()) ? reflectedClass.getName() : reflectedClass.getSimpleName();

            for (Relationship packageRelation : incoming(packageNode, JavaBuilderDomain.Relations.PACKAGE)) {
               final Node candidateClassNode = other(packageNode, packageRelation);
               if (simpleName.equals(getString(candidateClassNode, JavaBuilderDomain.Properties.name.name())))
                  return candidateClassNode;
            }
            printPackage(packageNode);
            System.out.println(simpleName);
            final Node classNode = neoModel.newNode(Entities.CLASS, JavaBuilderDomain.Properties.name.name(), simpleName);
            classNode.createRelationshipTo(packageNode, JavaBuilderDomain.Relations.PACKAGE);

            // superclass
            if (reflectedClass.getSuperclass() != null)
               classNode.createRelationshipTo(findClassNode(reflectedClass.getSuperclass(), neoModel), JavaBuilderDomain.Relations.PARENT);

            // constructors
            for (Constructor constructor : reflectedClass.getConstructors()) {
               final Node constructorNode = neoModel.newNode(Entities.CONSTRUCTOR);
               classNode.createRelationshipTo(constructorNode, JavaBuilderDomain.Relations.CONSTRUCTOR);
               for (Parameter parameter : constructor.getParameters()) {
                  final Node parameterNode = neoModel.newNode(Entities.PARAMETER);
                  constructorNode.createRelationshipTo(parameterNode, JavaBuilderDomain.Relations.PARAMETER);

                  final Node parameterTypeNode = findClassNode(parameter.getType(), neoModel);
                  parameterNode.createRelationshipTo(parameterTypeNode, JavaBuilderDomain.Relations.TYPE);
               }
            }

            // methods
            for (Method method : reflectedClass.getMethods()) {
               final Node methodNode = neoModel.newNode(Entities.METHOD, JavaBuilderDomain.Properties.name.name(), method.getName());
               methodNode.setProperty(JavaBuilderDomain.Properties.modifiers.name(), method.getModifiers());
               classNode.createRelationshipTo(methodNode, JavaBuilderDomain.Relations.METHOD);
               for (Parameter parameter : method.getParameters()) {
                  final Node parameterNode = neoModel.newNode(Entities.PARAMETER);
                  methodNode.createRelationshipTo(parameterNode, JavaBuilderDomain.Relations.PARAMETER);

                  final Node parameterTypeNode = findClassNode(parameter.getType(), neoModel);
                  parameterNode.createRelationshipTo(parameterTypeNode, JavaBuilderDomain.Relations.TYPE);
               }
            }

            // fields
            for (Field field : reflectedClass.getFields()) {
               final Node fieldNode = neoModel.newNode(Entities.FIELD, JavaBuilderDomain.Properties.name.name(), field.getName());
               fieldNode.setProperty(JavaBuilderDomain.Properties.modifiers.name(), field.getModifiers());
               classNode.createRelationshipTo(fieldNode, JavaBuilderDomain.Relations.FIELD);

               final Node fieldTypeNode = findClassNode(field.getType(), neoModel);
               fieldNode.createRelationshipTo(fieldTypeNode, JavaBuilderDomain.Relations.TYPE);
            }

            // implements
            for (Class anInterface : reflectedClass.getInterfaces()) {
               final Node interfaceNode = findInterfaceNode(anInterface, neoModel);
               classNode.createRelationshipTo(interfaceNode, JavaBuilderDomain.Relations.INTERFACE);
            }

            return classNode;
         }

         private void printPackage(Node packageNode) {
            System.out.print(getString(packageNode, JavaBuilderDomain.Properties.name.name())+".");
            final Relationship relationship = singleOutgoing(packageNode, JavaBuilderDomain.Relations.PARENT);
            if (relationship != null) printPackage(other(packageNode, relationship));
         }

         private Node findInterfaceNode(Class anInterface, NeoModel neoModel) {
            final Node packageNode = findPackageNode(anInterface.getPackage(), neoModel);

            for (Relationship packageRelation : incoming(packageNode, JavaBuilderDomain.Relations.PACKAGE)) {
               final Node candidateClassNode = other(packageNode, packageRelation);
               if (anInterface.getSimpleName().equals(getString(candidateClassNode, JavaBuilderDomain.Properties.name.name())))
                  return candidateClassNode;
            }

            final Node interfaceNode = neoModel.newNode(Entities.INTERFACE, JavaBuilderDomain.Properties.name.name(), anInterface.getSimpleName());
            interfaceNode.createRelationshipTo(packageNode, JavaBuilderDomain.Relations.PACKAGE);

            // superclass
            if (anInterface.getSuperclass() != null)
               interfaceNode.createRelationshipTo(findClassNode(anInterface.getSuperclass(), neoModel), JavaBuilderDomain.Relations.PARENT);

            // methods
            for (Method method : anInterface.getMethods()) {
               final Node methodNode = neoModel.newNode(Entities.METHOD, JavaBuilderDomain.Properties.name.name(), method.getName());
               methodNode.setProperty(JavaBuilderDomain.Properties.modifiers.name(), method.getModifiers());
               interfaceNode.createRelationshipTo(methodNode, JavaBuilderDomain.Relations.METHOD);
               for (Parameter parameter : method.getParameters()) {
                  final Node parameterNode = neoModel.newNode(Entities.PARAMETER);
                  methodNode.createRelationshipTo(parameterNode, JavaBuilderDomain.Relations.PARAMETER);

                  final Node parameterTypeNode = findClassNode(parameter.getType(), neoModel);
                  parameterNode.createRelationshipTo(parameterTypeNode, JavaBuilderDomain.Relations.TYPE);
               }
            }

            return interfaceNode;
         }

         private Node findPackageNode(Package reflectedClassPackage, NeoModel graph) {
            return findPackageNode(reflectedClassPackage == null ? null : reflectedClassPackage.getName().split("[.]"), 0, graph, null);
         }

         private Node findPackageNode(String[] packagePath, int index, NeoModel graph, Node currentPackageNode) {

            if (packagePath == null) {
               final ResourceIterator<Node> nullPackageIterator = graph.findNodes(JavaBuilderDomain.Entities.PACKAGE, JavaBuilderDomain.Properties.name.name(), "null");
               if (nullPackageIterator.hasNext()) return nullPackageIterator.next();
               return graph.newNode(JavaBuilderDomain.Entities.PACKAGE, JavaBuilderDomain.Properties.name.name(), "null");
            }

            if (index == packagePath.length) return currentPackageNode;

            final String packageName = packagePath[index];
            if (index == 0) {
               final ResourceIterator<Node> packageNodes = graph.findNodes(JavaBuilderDomain.Entities.PACKAGE, JavaBuilderDomain.Properties.name.name(), packageName);
               if (packageNodes.hasNext()) {
                  return findPackageNode(packagePath, index + 1, graph, packageNodes.next());
               } else {
                  return findPackageNode(packagePath, index + 1, graph, graph.newNode(JavaBuilderDomain.Entities.PACKAGE, JavaBuilderDomain.Properties.name.name(), packageName));
               }
            }

            for (Relationship relationship : incoming(currentPackageNode, PARENT)) {
               final String subPackageName = getOtherProperty(currentPackageNode, relationship, JavaBuilderDomain.Properties.name.name());
               if (packageName.equals(subPackageName))
                  return findPackageNode(packagePath, index + 1, graph, other(currentPackageNode, relationship));
            }

            final Node newPackageNode = graph.newNode(JavaBuilderDomain.Entities.PACKAGE, JavaBuilderDomain.Properties.name.name(), packageName);
            newPackageNode.createRelationshipTo(currentPackageNode, PARENT);
            return findPackageNode(packagePath, index + 1, graph, newPackageNode);
         }

         @Override
         public void exception(Throwable throwable) {
            throwable.printStackTrace();
         }
      });
//
//      neoModel.doInTransaction(new NeoModel.Committer() {
//         @Override
//         public void doAction(Transaction tx) throws Throwable {
//
//            neoModel.findNodes(Entities.PACKAGE).forEachRemaining(node -> {
//
//               incoming(node, Relations.PARENT).forEach(relationship -> System.out.println("." + getOtherProperty(node, relationship, Properties.name.name())));
//
//               incoming(node, Relations.PACKAGE).forEach(relationship -> {
//                  final Node classNode = other(node, relationship);
//                  System.out.println("\t" + getString(classNode, Properties.name.name()));
//
//                  outgoing(classNode, Relations.CONSTRUCTOR).forEach(constructorRelation -> {
//                     final Node constructorNode = other(classNode, constructorRelation);
//                     System.out.print("\t\t" + getString(constructorNode, Properties.name.name()) + "(");
//                     outgoing(constructorNode, Relations.PARAMETER).forEach(constructorRelation1 -> {
//                        final Node parameterNode = other(constructorNode, constructorRelation1);
//                        System.out.print(" " + getString(parameterNode, Properties.name.name()));
//                     });
//                     System.out.println(")");
//                  });
//                  outgoing(classNode, Relations.METHOD).forEach(methodRelation -> {
//                     final Node methodNode = other(classNode, methodRelation);
//                     System.out.print("\t\t" + getString(methodNode, Properties.name.name()) + "(");
//                     outgoing(methodNode, Relations.PARAMETER).forEach(methodRelation1 -> {
//                        final Node parameterNode = other(methodNode, methodRelation1);
//                        System.out.print(" " + getString(parameterNode, Properties.name.name()));
//                     });
//                     System.out.println(" )");
//                  });
//
//                  outgoing(classNode, Relations.FIELD).forEach(fieldRelation -> {
//                     final Node fieldTypeNode = other(classNode, fieldRelation);
//                     System.out.print("\t\t\t" + getString(fieldTypeNode, Properties.name.name()) + "(");
//                     System.out.print(" " + getString(fieldRelation, Properties.name.name()));
//                     System.out.println(" )");
//                  });
//
//               });
//            });
//
//            // test instantiation
//            final ResourceIterator<Node> classNodes = neoModel.findNodes(Entities.CLASS, Properties.name.name(), "String");
//            while (classNodes.hasNext()) {
//               final Node classNode = classNodes.next();
//               System.out.println(getString(classNode, Properties.name.name()));
//               // todo: use templates, to create code that can be compiled and ran:
//
//               final Node instanceNode = neoModel.newNode(Entities.INSTANCE, Properties.name.name(), "myString");
//               instanceNode.createRelationshipTo(classNode, Relations.INSTANCE_TYPE);
//
//               // test: take first constructor (byte[], String)
//               final Node classConstructor = other(classNode, outgoing(classNode, Relations.CONSTRUCTOR).iterator().next());
//               // relate to which constructor (but needs parameters)
//               instanceNode.createRelationshipTo(classConstructor, Relations.INSTANCE_INITIALIZE);
//
//               final Node byteParamNode = neoModel.newNode(Entities.INSTANCE, Properties.name.name());
//
//
//               new ReflectionVisitor() {
//                  @Override
//                  <T> T visitInstance(Node node) {
//                     final Node typeNode = other(node, singleOutgoing(node, Relations.INSTANCE_TYPE));
//                     final StringBuilder out = new StringBuilder(getString(typeNode, Properties.name.name()) + " " + getString(node, Properties.name.name()) + " = new " + getString(typeNode, Properties.name.name()));
//                     System.out.println(out.toString());
//
//                     return super.visitInstance(node);
//                  }
//               }.visit(instanceNode);
//
//               // new instance
//               outgoing(classNode, Relations.CONSTRUCTOR).forEach(new Consumer<Relationship>() {
//                  @Override
//                  public void accept(Relationship relationship) {
//                     final Node constructorNode = other(classNode, relationship);
//                     final StringBuilder out = new StringBuilder("new " + getString(classNode, Properties.name.name()));
//                     out.append("(");
//                     final AtomicBoolean first = new AtomicBoolean(true);
//                     outgoing(constructorNode, Relations.PARAMETER).forEach(new Consumer<Relationship>() {
//                        @Override
//                        public void accept(Relationship relationship) {
//                           final Node parameterNode = other(constructorNode, relationship);
//                           if (!first.get()) out.append(", ");
//                           out.append(getString(parameterNode, Properties.name.name()));
//                           first.set(false);
//                        }
//                     });
//                     out.append(")");
//
//                     System.out.println(out.toString());
//                  }
//               });
//
//
//               // set method
//
//               // get method
//
//            }
//         }
//
//         @Override
//         public void exception(Throwable throwable) {
//
//         }
//      });
   }

   private void listFiles(File root) {
      for (File file : root.listFiles()) {
         if (file.isDirectory()) {
            listFiles(file);
         } else {
            String name = file.getName();

            if (name.toLowerCase().endsWith(".class")) {
               System.out.println(name);
            } else if (name.toLowerCase().endsWith(".jar")) {
               System.out.println("\t\t" + name);
            }

            // Check if it's a .class file or a .jar file and handle accordingly.
         }
      }
   }

   public static abstract class ReflectionVisitor implements com.generator.domain.IDomainVisitor {

      @Override
      public <T> T visit(Node n) {
         if (n == null) return null;
         if (BaseDomainVisitor.hasLabel(n, Entities.INSTANCE.name())) return visitInstance(n);
         return null;
      }

      <T> T visitInstance(Node node) {
         return null;
      }
   }
}