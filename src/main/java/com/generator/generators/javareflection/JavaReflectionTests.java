package com.generator.generators.javareflection;

import com.generator.editors.BaseDomainVisitor;
import com.generator.editors.NeoModel;
import com.generator.editors.canvas.neo.NeoEditor;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;
import org.neo4j.graphdb.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

import static com.generator.editors.BaseDomainVisitor.*;

/**
 * Created 20.05.17.
 */
public class JavaReflectionTests {

   public enum Entities implements Label {
      CLASS, PACKAGE, METHOD, // compile entities
      INSTANCE                // runtime entities
   }

   public enum Relations implements RelationshipType {
      PARENT, PACKAGE, CONSTRUCTOR, PARAMETER, METHOD,   // compile relations
      INSTANCE_TYPE, INSTANCE_INITALIZE                  // runtime relations
   }

   public enum Properties {
      name, modifiers, type
   }

   @Test
   public void tmp() {

      Class myObjectClass = String.class;

      final Package aPackage = myObjectClass.getPackage();
      final String[] split = aPackage.getName().split("[.]");
      for (int i = 0; i < split.length; i++) {
         String s = split[i];
         System.out.println("\t" + s);

         // find packages, and use node if exists

      }
   }

   @Test
   public void testReflection() {

      final NeoModel neoModel = NeoEditor.newEmbeddedDatabase("/home/goe/projects/nextgen/src/main/java/com/generator/generators/javareflection/db");

      final Class reflectedClass = String.class;

      neoModel.doInTransaction(new NeoModel.Committer() {
         @Override
         public void doAction(Transaction tx) throws Throwable {

            // todo: make utility functions (static, to query modifiers from node)
            final Node classNode = getClassNode(reflectedClass, neoModel);
            classNode.setProperty(Properties.modifiers.name(), reflectedClass.getModifiers());

            // superclass todo: recursive
            final Class superclass = reflectedClass.getSuperclass();

            // interfaces todo: recursive
            final Class[] interfaces = reflectedClass.getInterfaces();

            // constructors
            final Constructor[] constructors = reflectedClass.getConstructors();
            final Map<String, Constructor> newConstructors = new HashMap<>();
            for (Constructor constructor : constructors)
               newConstructors.put(constructor.toString(), constructor);
            for (Constructor constructor : constructors) {
               if (!Modifier.isPublic(constructor.getModifiers())) continue;

               // try to match parameters
               final Set<Node> parameterNodes = getParameters(constructor.getParameterTypes(), neoModel);
               for (Relationship relationship : outgoing(classNode, Relations.CONSTRUCTOR)) {
                  final Node classConstructor = other(classNode, relationship);

                  // count up equal parameters, if match, constructor already exists:
                  final AtomicInteger parameterCount = new AtomicInteger(0);
                  for (Relationship parameterRelation : outgoing(classConstructor, Relations.PARAMETER))
                     if (parameterNodes.contains(other(classConstructor, parameterRelation)))
                        parameterCount.incrementAndGet();

                  // matching parameters. this means classConstructor exist
                  if (parameterCount.get() == parameterNodes.size())
                     newConstructors.remove(constructor.toString());
               }
            }

            for (Constructor newConstructor : newConstructors.values()) {
               // new class-constructor:
               final Node newConstructorNode = neoModel.newNode(Entities.METHOD, Properties.name.name(), reflectedClass.getSimpleName());
               classNode.createRelationshipTo(newConstructorNode, Relations.CONSTRUCTOR);
               for (Node parameterNode : getParameters(newConstructor.getParameterTypes(), neoModel))
                  newConstructorNode.createRelationshipTo(parameterNode, Relations.PARAMETER);
            }

            // method
            final Method[] methods = reflectedClass.getMethods();
            final Set<Method> newMethods = new LinkedHashSet<>();
            for (Method method : methods) newMethods.add(method);
            for (int i = 0; i < methods.length; i++) {
               final Method method = methods[i];
               if (!Modifier.isPublic(method.getModifiers())) continue;

               // try to match parameters
               final Set<Node> parameterNodes = getParameters(method.getParameterTypes(), neoModel);
               for (Relationship relationship : outgoing(classNode, Relations.METHOD)) {
                  final Node classMethod = other(classNode, relationship);

                  // count up equal parameters, if match, constructor already exists:
                  final AtomicInteger parameterCount = new AtomicInteger(0);
                  for (Relationship parameterRelation : outgoing(classMethod, Relations.PARAMETER))
                     if (parameterNodes.contains(other(classMethod, parameterRelation)))
                        parameterCount.incrementAndGet();

                  // check returntype
                  final Node returnType = getClassNode(method.getReturnType(), neoModel);


                  // matching parameters. this means classMethod exist
                  if (parameterCount.get() == parameterNodes.size())
                     newMethods.remove(method);
               }
            }

            for (Method newMethod : newMethods) {
               // new method:
               final Node newMethodNode = neoModel.newNode(Entities.METHOD, Properties.name.name(), newMethod.getName());
               classNode.createRelationshipTo(newMethodNode, Relations.METHOD);
               for (Node parameterNode : getParameters(newMethod.getParameterTypes(), neoModel))
                  newMethodNode.createRelationshipTo(parameterNode, Relations.PARAMETER);


            }

            // fields
            final Field[] fields = reflectedClass.getFields();

            final Annotation[] annotations = reflectedClass.getAnnotations();


         }

         @Override
         public void exception(Throwable throwable) {

         }
      });


      neoModel.doInTransaction(new NeoModel.Committer() {
         @Override
         public void doAction(Transaction tx) throws Throwable {

            neoModel.findNodes(Entities.PACKAGE).forEachRemaining(new Consumer<Node>() {
               @Override
               public void accept(Node node) {
                  System.out.println();
                  System.out.println(getString(node, Properties.name.name()));

                  incoming(node, Relations.PARENT).forEach(new Consumer<Relationship>() {
                     @Override
                     public void accept(Relationship relationship) {
                        System.out.println("." + getOtherProperty(node, relationship, Properties.name.name()));
                     }
                  });

                  incoming(node, Relations.PACKAGE).forEach(relationship -> {
                     final Node classNode = other(node, relationship);
                     System.out.println("\t" + getString(classNode, Properties.name.name()));

                     outgoing(classNode, Relations.CONSTRUCTOR).forEach(constructorRelation -> {
                        final Node constructorNode = other(classNode, constructorRelation);
                        System.out.print("\t\t" + getString(constructorNode, Properties.name.name()) + "(");
                        outgoing(constructorNode, Relations.PARAMETER).forEach(new Consumer<Relationship>() {
                           @Override
                           public void accept(Relationship constructorRelation) {
                              final Node parameterNode = other(constructorNode, constructorRelation);
                              System.out.print(" " + getString(parameterNode, Properties.name.name()));
                           }
                        });
                        System.out.println(")");
                     });
                     outgoing(classNode, Relations.METHOD).forEach(methodRelation -> {
                        final Node methodNode = other(classNode, methodRelation);
                        System.out.print("\t\t" + getString(methodNode, Properties.name.name()) + "(");
                        outgoing(methodNode, Relations.PARAMETER).forEach(new Consumer<Relationship>() {
                           @Override
                           public void accept(Relationship methodRelation) {
                              final Node parameterNode = other(methodNode, methodRelation);
                              System.out.print(" " + getString(parameterNode, Properties.name.name()));
                           }
                        });
                        System.out.println(" )");
                     });


                  });
               }
            });

            // test instantiation
            final ResourceIterator<Node> classNodes = neoModel.findNodes(Entities.CLASS, Properties.name.name(), "String");
            while (classNodes.hasNext()) {
               final Node classNode = classNodes.next();
               System.out.println(getString(classNode, Properties.name.name()));
               // todo: use templates, to create code that can be compiled and ran:

               final Node instanceNode = neoModel.newNode(Entities.INSTANCE, Properties.name.name(), "myString");
               instanceNode.createRelationshipTo(classNode, Relations.INSTANCE_TYPE);

               // test: take first constructor (byte[], String)
               final Node classConstructor = other(classNode, outgoing(classNode, Relations.CONSTRUCTOR).iterator().next());
               // relate to which constructor (but needs parameters)
               instanceNode.createRelationshipTo(classConstructor, Relations.INSTANCE_INITALIZE);

               final Node byteParamNode = neoModel.newNode(Entities.INSTANCE, Properties.name.name());


               new ReflectionVisitor() {
                  @Override
                  <T> T visitInstance(Node node) {
                     final Node typeNode = other(node, singleOutgoing(node, Relations.INSTANCE_TYPE));
                     final StringBuilder out = new StringBuilder(getString(typeNode, Properties.name.name()) +" " + getString(node, Properties.name.name()) + " = new " + getString(typeNode, Properties.name.name()));
                     System.out.println(out.toString());

                     return super.visitInstance(node);
                  }
               }.visit(instanceNode);

               // new instance
               outgoing(classNode, Relations.CONSTRUCTOR).forEach(new Consumer<Relationship>() {
                  @Override
                  public void accept(Relationship relationship) {
                     final Node constructorNode = other(classNode, relationship);
                     final StringBuilder out = new StringBuilder("new " + getString(classNode, Properties.name.name()));
                     out.append("(");
                     final AtomicBoolean first = new AtomicBoolean(true);
                     outgoing(constructorNode, Relations.PARAMETER).forEach(new Consumer<Relationship>() {
                        @Override
                        public void accept(Relationship relationship) {
                           final Node parameterNode = other(constructorNode, relationship);
                           if (!first.get()) out.append(", ");
                           out.append(getString(parameterNode, Properties.name.name()));
                           first.set(false);
                        }
                     });
                     out.append(")");

                     System.out.println(out.toString());
                  }
               });


               // set method

               // get method

            }
         }

         @Override
         public void exception(Throwable throwable) {

         }
      });
   }

   @NotNull
   private Set<Node> getParameters(Class[] parameterTypes, NeoModel neoModel) {
      final Set<Node> parameterNodes = new LinkedHashSet<>();
      for (Class parameterType : parameterTypes)
         parameterNodes.add(getClassNode(parameterType, neoModel));
      return parameterNodes;
   }

   @NotNull
   private static Node getClassNode(Class reflectedClass, NeoModel neoModel) {

      final Node packageNode = findPackageNode(getPackagePath(reflectedClass), 0, neoModel, null);

      Node classNode = null;
      for (Relationship packageMember : incoming(packageNode, Relations.PACKAGE))
         if (reflectedClass.getSimpleName().equals(getOtherProperty(packageNode, packageMember, Properties.name.name())))
            classNode = other(packageNode, packageMember);

      if (classNode == null) {
         classNode = neoModel.newNode(Entities.CLASS, Properties.name.name(), reflectedClass.getSimpleName());
         classNode.createRelationshipTo(packageNode, Relations.PACKAGE);
      }
      return classNode;
   }

   @NotNull
   private static String[] getPackagePath(Class reflectedClass) {

      if (reflectedClass.getPackage() == null)
         return "java.primitives".split("[.]");

      return reflectedClass.getPackage().getName().split("[.]");
   }

   private static Node findPackageNode(String[] packagePath, int index, NeoModel neoModel, Node currentPackageNode) {

      if (index == packagePath.length) return currentPackageNode;

      final String packageName = packagePath[index];
      if (index == 0) {
         final ResourceIterator<Node> packageNodes = neoModel.findNodes(Entities.PACKAGE, Properties.name.name(), packageName);
         if (packageNodes.hasNext()) {
            return findPackageNode(packagePath, index + 1, neoModel, packageNodes.next());
         } else {
            return findPackageNode(packagePath, index + 1, neoModel, neoModel.newNode(Entities.PACKAGE, Properties.name.name(), packageName));
         }
      }

      for (Relationship relationship : incoming(currentPackageNode, Relations.PARENT)) {
         final String subPackageName = getOtherProperty(currentPackageNode, relationship, Properties.name.name());
         if (packageName.equals(subPackageName))
            return findPackageNode(packagePath, index + 1, neoModel, other(currentPackageNode, relationship));
      }

      final Node newPackageNode = neoModel.newNode(Entities.PACKAGE, Properties.name.name(), packageName);
      newPackageNode.createRelationshipTo(currentPackageNode, Relations.PARENT);
      return findPackageNode(packagePath, index + 1, neoModel, newPackageNode);
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