package com.generator.generators.javapoet;

import com.generator.app.App;
import com.generator.app.DomainMotif;
import com.generator.app.NodeRenderPanel;
import com.generator.app.nodes.NeoNode;
import com.generator.generators.domain.DomainPlugin;
import com.generator.generators.project.ProjectPlugin;
import com.generator.util.GeneratedFile;
import com.generator.neo.NeoModel;
import com.generator.util.NeoUtil;
import com.generator.util.SwingUtil;
import com.squareup.javapoet.*;
import org.jetbrains.annotations.NotNull;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;
import spoon.Launcher;
import spoon.reflect.CtModel;

import javax.lang.model.element.Modifier;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static com.generator.util.NeoUtil.other;

/**
 * Created 06.12.17.
 */
public class JavaPoetPlugin extends JavaPoetDomainPlugin {

   public JavaPoetPlugin(App app) {
      super(app);

      // add default-types if not exists:
      final Map<String, Node> existingTypes = new LinkedHashMap<>();
      DomainPlugin.outgoingINSTANCE(getEntityNode(Entities.TypeName), (relationship, typeNode) -> existingTypes.put(getNameProperty(typeNode, ""), typeNode));
      for (TypeName typeName : defaultTypes()) {
         final Node typeNode = existingTypes.get(typeName.toString());
         if (typeNode == null)
            newTypeName(typeName.toString(), null, false);
         else {
            final Object packageNameProperty = getPackageNameProperty(typeNode);
            final Boolean builtInTypeProperty = getBuiltInType(getNameProperty(typeNode)) != null;
            final Boolean isArrayProperty = getIsArrayProperty(typeNode, false);
            if (packageNameProperty != null || !builtInTypeProperty || isArrayProperty)
               newTypeName(typeName.toString(), null, isArrayProperty);
         }
      }
   }

   @Override
   protected void addActionsTo(JMenu menu) {

      addShowMenu(menu, Entities.JavaFile);
      addShowMenu(menu, Entities.TypeName);
      addShowMenu(menu, Entities.TypeSpec);

      menu.add(new App.TransactionAction("Add Library from sources", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final File sourceDir = SwingUtil.showOpenDir(app, System.getProperty("user.home"));
            if (sourceDir == null || !sourceDir.exists()) return;

            final Launcher launcher = new Launcher();
            launcher.addInputResource(sourceDir.getAbsolutePath());
            launcher.getEnvironment().setAutoImports(true); // optional
            launcher.getEnvironment().setNoClasspath(true); // optional
            launcher.buildModel();
            Long start = app.logWindow.logWithTimestamp("Creating model");
            final CtModel model = launcher.getModel();
            app.logWindow.log("Creating model", start);
            final Node newlibrary = newlibrary();

            start = app.logWindow.logWithTimestamp("creating types");
            model.getAllTypes().forEach(ctType -> relateTYPE(newlibrary, newTypeName(ctType.getSimpleName(), ctType.getPackage().getQualifiedName(), false)));
            app.logWindow.log("creating types ", start);

            fireNodesLoaded(newlibrary);
         }
      });

      menu.add(new App.TransactionAction("Add JavaFile", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String packageName = SwingUtil.showInputDialog("Package", app);
            if (packageName == null || packageName.length() == 0) return;

            fireNodesLoaded(newJavaFile(packageName));
         }
      });

      menu.add(new App.TransactionAction("Add Class", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String className = SwingUtil.showInputDialog("Name", app);
            if (className == null || className.length() == 0) return;

            fireNodesLoaded(newTypeSpec(className));
         }
      });

      menu.add(new App.TransactionAction("Add Type", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final JTextField txtClassName = new JTextField();
            final JCheckBox chkIsArray = new JCheckBox();

            final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("75dlu, 4dlu, 75dlu:grow, 4dlu, 75dlu:grow", "pref, 4dlu, pref, 4dlu, ");
            int row = 1;
            editor.addLabel("ClassName", 1, row);
            editor.add(txtClassName, 3, row);

            SwingUtil.showDialog(editor, app, "New Type", new SwingUtil.ConfirmAction() {
               @Override
               public void verifyAndCommit() throws Exception {
                  getGraph().doInTransaction(new NeoModel.Committer() {
                     @Override
                     public void doAction(Transaction tx) throws Throwable {

                        final String className = txtClassName.getText().trim();
                        if (className.length() == 0) return;

                        final String packageName = className.substring(0, className.lastIndexOf("."));
                        final String simpleName = className.substring(className.lastIndexOf(".") + 1);

                        final Set<Node> foundNode = new LinkedHashSet<>();
                        getGraph().findNodes(Entities.TypeName).forEachRemaining(typeNode -> {
                           if (getNameProperty(typeNode).equals(simpleName) && getPackageNameProperty(typeNode).equals(packageName) && getIsArrayProperty(typeNode, false).equals(chkIsArray.isSelected()))
                              foundNode.add(typeNode);
                        });

                        if (foundNode.isEmpty())
                           fireNodesLoaded(newTypeName(simpleName, packageName, chkIsArray.isSelected()));
                        else
                           fireNodesLoaded(foundNode);
                     }

                     @Override
                     public void exception(Throwable throwable) {
                        SwingUtil.showException(app, throwable);
                     }
                  });
               }
            });

         }
      });
   }

   @Override
   protected void handleJavaFile(JPopupMenu pop, NeoNode javaFileNode, Set<NeoNode> selectedNodes) {

      ProjectPlugin.incomingRENDERER(javaFileNode.getNode(), (rendererRelationship, directory) -> {

         final Node typeSpecNode = singleOutgoingTYPESPEC(javaFileNode.getNode());
         if (typeSpecNode == null) return;

         final JavaFile source = asJavaFile(javaFileNode.getNode());
         if (source == null) return;

         pop.add(new App.TransactionAction("Write to " + ProjectPlugin.getPathProperty(directory), app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final Object packageNameProperty = ProjectPlugin.getPackageNameProperty(rendererRelationship, "");
               final Object className = getNameProperty(typeSpecNode, "");

               GeneratedFile.newJavaFile(ProjectPlugin.getFile(directory).getPath(), packageNameProperty.toString(), className.toString()).write(source.toString());
            }
         });
      });
   }

   @Override
   protected void handleMethod(JPopupMenu pop, NeoNode methodNode, Set<NeoNode> selectedNodes) {

      pop.add(new App.TransactionAction("Set Modifiers", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final Map<Modifier, Relationship> existingModifiers = new LinkedHashMap<>();
            outgoingMODIFIERS(methodNode.getNode(), (relationship, modifierNode) -> existingModifiers.put(Modifier.valueOf(getTypeProperty(modifierNode)), relationship));

            final Modifier[] modifiers = Modifier.values();
            final Map<Modifier, JCheckBox> chkModifiers = new LinkedHashMap<>();

            final StringBuilder rows = new StringBuilder();
            for (int i = 0; i < modifiers.length; i++) {
               chkModifiers.put(modifiers[i], new JCheckBox("", existingModifiers.containsKey(modifiers[i])));
               if (i > 0) rows.append(", ");
               rows.append("pref, 4dlu");
            }

            final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("75dlu,4dlu,75dlu:grow", rows.toString());
            int row = 1;
            for (Modifier modifier : modifiers) {
               editor.addLabel(modifier.name(), 1, row);
               editor.add(chkModifiers.get(modifier), 3, row);
               row += 2;
            }

            final String methodName = getNameProperty(methodNode.getNode(), "[method]");

            SwingUtil.showDialog(editor, app, methodName, new SwingUtil.ConfirmAction() {
               @Override
               public void verifyAndCommit() throws Exception {

                  if (chkModifiers.get(Modifier.ABSTRACT).isSelected() && chkModifiers.get(Modifier.FINAL).isSelected())
                     throw new IllegalStateException(methodName + " cannot both be abstract and final");

                  getGraph().doInTransaction(new NeoModel.Committer() {
                     @Override
                     public void doAction(Transaction tx) throws Throwable {

                        for (Modifier modifier : modifiers) {
                           final JCheckBox checkBox = chkModifiers.get(modifier);
                           final Relationship existing = existingModifiers.get(modifier);

                           if (checkBox.isSelected()) {
                              if (existing == null) relateMODIFIERS(methodNode.getNode(), newModifier(modifier.name()));
                           } else {
                              if (existing != null) {
                                 final Node existingModifier = other(methodNode.getNode(), existing);
                                 existing.delete();
                                 DomainMotif.tryToDeleteNode(existingModifier, false);
                              }
                           }
                        }
                     }

                     @Override
                     public void exception(Throwable throwable) {
                        SwingUtil.showException(app, throwable);
                     }
                  });
               }
            });
         }
      });

      pop.add(new App.TransactionAction("Add Parameter", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String parameterName = SwingUtil.showInputDialog("Name", app);
            if (parameterName == null || parameterName.length() == 0) return;

            final Node newParameter = newParameter(parameterName);
            relatePARAMETER(methodNode.getNode(), newParameter);
            fireNodesLoaded(newParameter);
         }
      });

      for (NeoNode selectedNode : selectedNodes) {
         if (isTypeName(selectedNode.getNode())) {
            pop.add(new App.TransactionAction("Add " + getNameProperty(selectedNode.getNode()) + " as parameter", app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  final String parameterName = SwingUtil.showInputDialog("Name", app);
                  if (parameterName == null || parameterName.length() == 0) return;

                  final Node newParameter = newParameter(parameterName);
                  relatePARAMETER(methodNode.getNode(), newParameter);
                  relateTYPE(newParameter, selectedNode.getNode());
                  fireNodesLoaded(newParameter);
               }
            });
         }
      }
   }

   @Override
   protected void handleStatement(JPopupMenu pop, NeoNode statementNode, Set<NeoNode> selectedNodes) {

      for (NeoNode selectedNode : selectedNodes) {
         if (isTypeName(selectedNode.getNode())) {
            pop.add(new App.TransactionAction("Add " + getNameProperty(selectedNode.getNode()) + " as parameter", app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  final Node statementParameter = newStatementParameter();
                  relateSTATEMENT_PARAMETER_TYPE(statementParameter, selectedNode.getNode());

                  relateSTATEMENT_PARAMETER(statementNode.getNode(), statementParameter);
                  fireNodesLoaded(statementParameter);
               }
            });
         }
      }
   }

   @Override
   protected void handleStatementParameter(JPopupMenu pop, NeoNode statementParameterNode, Set<NeoNode> selectedNodes) {

   }

   @Override
   protected void handleParameter(JPopupMenu pop, NeoNode parameterNode, Set<NeoNode> selectedNodes) {

      final JMenu mnuTypes = new JMenu("Set type..");

      for (NeoNode selectedNode : selectedNodes) {

         // todo check for classType too, and connect as type-node

         if (isTypeName(selectedNode.getNode())) {
            pop.add(new App.TransactionAction(getNameProperty(selectedNode.getNode()), app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  final Node typeNode = singleOutgoingTYPE(parameterNode.getNode());
                  if (getNameProperty(selectedNode.getNode()).toString().equals(getNameProperty(typeNode, ""))) return;

                  final Relationship existingType = NeoUtil.singleOutgoing(parameterNode.getNode(), Relations.TYPE);
                  if (existingType != null) existingType.delete();

                  relateTYPE(parameterNode.getNode(), selectedNode.getNode());
               }
            });
         }
      }

      pop.add(mnuTypes);
   }

   @NotNull
   private static Set<TypeName> defaultTypes() {
      final Set<TypeName> typeNames = new LinkedHashSet<>();
      typeNames.add(TypeName.BOOLEAN);
      typeNames.add(TypeName.BYTE);
      typeNames.add(TypeName.CHAR);
      typeNames.add(TypeName.DOUBLE);
      typeNames.add(TypeName.FLOAT);
      typeNames.add(TypeName.INT);
      typeNames.add(TypeName.LONG);
      typeNames.add(TypeName.SHORT);
      typeNames.add(TypeName.VOID);
      return typeNames;
   }

   @Override
   protected JComponent newJavaFileEditor(NeoNode javaFileNode) {
      return new NodeRenderPanel(javaFileNode) {
         @Override
         protected String render(Node node) {
            final JavaFile javaFile = asJavaFile(node);
            return javaFile == null ? "" : javaFile.toString();
         }
      };
   }

   @Override
   protected JComponent newTypeSpecEditor(NeoNode typeSpecNode) {
      return new NodeRenderPanel(typeSpecNode) {
         @Override
         protected String render(Node node) {
            final TypeSpec typeSpec = asTypeSpec(node);
            return typeSpec == null ? "" : typeSpec.toString();
         }
      };
   }

   @Override
   protected JComponent newMethodEditor(NeoNode methodNode) {
      return new NodeRenderPanel(methodNode) {
         @Override
         protected String render(Node node) {
            return asMethod(node).toString();
         }
      };
   }

   @Override
   protected JComponent newFieldEditor(NeoNode fieldNode) {
      return new NodeRenderPanel(fieldNode) {
         @Override
         protected String render(Node node) {
            final FieldSpec fieldSpec = asField(node);
            return fieldSpec == null ? "" : fieldSpec.toString();
         }
      };
   }

   @Override
   protected JComponent newParameterEditor(NeoNode parameterNode) {
      return new NodeRenderPanel(parameterNode) {
         @Override
         protected String render(Node node) {
            final ParameterSpec parameter = asParameter(node);
            return parameter == null ? "" : parameter.toString();
         }
      };
   }

   @Override
   protected JComponent newStatementEditor(NeoNode statementNode) {
      return new NodeRenderPanel(statementNode) {
         @Override
         protected String render(Node node) {
            final CodeBlock.Builder builder = CodeBlock.builder();
            renderBlock(builder, node, new AtomicInteger(0));
            return builder.build().toString();
         }
      };
   }

   @Override
   protected JComponent newTypeNameEditor(NeoNode typeNameNode) {
      return new NodeRenderPanel(typeNameNode) {
         @Override
         protected String render(Node node) {

            final String nameProperty = getNameProperty(node);
            final String packageProperty = getPackageNameProperty(node);
            final Boolean isArrayProperty = getIsArrayProperty(node, false);
            final Boolean isBuiltInTypeProperty = getBuiltInType(nameProperty) != null;

            if (isBuiltInTypeProperty) return nameProperty;
            return (packageProperty + "." + nameProperty) + (isArrayProperty ? "[]" : "");
         }
      };
   }

   private static JavaFile asJavaFile(Node node) {

      final TypeSpec typeSpec = asTypeSpec(singleOutgoingTYPESPEC(node));
      if (typeSpec == null) return null;

      return JavaFile.builder(getPackageNameProperty(node), typeSpec).build();
   }

   private static TypeSpec asTypeSpec(Node typeSpecNode) {

      final String nameProperty = getNameProperty(typeSpecNode);
      if (nameProperty == null) return null;

      final TypeSpec.Builder classBuilder = TypeSpec.classBuilder(nameProperty);

      outgoingMODIFIERS(typeSpecNode, (relationship, modifierNode) -> {
         final Modifier modifier = asModifier(modifierNode);
         if (modifier != null)
            classBuilder.addModifiers(modifier);
      });

      outgoingFIELDS(typeSpecNode, (relationship, fieldNode) -> {
         final FieldSpec fieldSpec = asField(fieldNode);
         if (fieldSpec != null) classBuilder.addField(fieldSpec);
      });

      outgoingMETHODS(typeSpecNode, (relationship, methodNode) -> {
         classBuilder.addMethod(asMethod(methodNode));
      });

      return classBuilder.build();
   }

   private static FieldSpec asField(Node fieldNode) {

      final TypeName fieldType = asType(singleOutgoingTYPE(fieldNode));
      if (fieldType == null) return null;

      final String name = getNameProperty(fieldNode);
      if (name == null || name.length() == 0) return null;

      final FieldSpec.Builder builder = FieldSpec.builder(fieldType, name);

      outgoingMODIFIERS(fieldNode, (relationship, modifierNode) -> builder.addModifiers(asModifier(modifierNode)));

      final Node statementNode = singleOutgoingINITIALIZER(fieldNode);
      if (statementNode != null) {
         final List<Object> args = new ArrayList<Object>();
         outgoingSTATEMENT_PARAMETER(statementNode, (relationship, statementParameterNode) -> {

            final Node parameterTypeNode = singleOutgoingSTATEMENT_PARAMETER_TYPE(statementParameterNode);
            if (parameterTypeNode != null) {
               args.add(asType(parameterTypeNode));

            } else {
               final String typeProperty = getTypeProperty(statementParameterNode, "");

               switch (typeProperty) {
                  case "":
                     break;
                  case "STRING":
                     args.add(getNameProperty(statementParameterNode));
                     break;
                  case "LITERAL":
                     args.add(statementParameterNode);
                     break;
               }
            }
         });

         final String code = getStatementProperty(statementNode);
         builder.initializer(code, args);
      }


      return builder.build();
   }

   private static MethodSpec asMethod(Node methodNode) {

      final MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder(getNameProperty(methodNode, ""));

      final TypeName returnType = asType(singleOutgoingRETURNS(methodNode));
      if (returnType != null)
         methodBuilder.returns(returnType);

      outgoingMODIFIERS(methodNode, (relationship, modifierNode) -> methodBuilder.addModifiers(asModifier(modifierNode)));

      outgoingPARAMETER(methodNode, (relationship, parameterNode) -> {
         final ParameterSpec parameterSpec = asParameter(parameterNode);
         if (parameterSpec == null) return;
         methodBuilder.addParameter(parameterSpec);
      });

      addMethodStatements(methodBuilder, singleOutgoingSTATEMENTS(methodNode));

      return methodBuilder.build();
   }

   private static void renderBlock(CodeBlock.Builder codeBlock, Node statementNode) {
      renderBlock(codeBlock, statementNode, new AtomicInteger(0));
   }

   private static void renderBlock(CodeBlock.Builder codeBlock, Node statementNode, AtomicInteger indent) {

      if (statementNode == null) return;

      final List<Object> args = new ArrayList<Object>();
      outgoingSTATEMENT_PARAMETER(statementNode, (relationship, statementParameterNode) -> {

         final Node parameterTypeNode = singleOutgoingSTATEMENT_PARAMETER_TYPE(statementParameterNode);
         if (parameterTypeNode != null) {
            args.add(asType(parameterTypeNode));

         } else {
            final String typeProperty = getTypeProperty(statementParameterNode, "");

            switch (typeProperty) {
               case "":
                  break;
               case "STRING":
                  args.add(getNameProperty(statementParameterNode));
                  break;
               case "LITERAL":
                  args.add(statementParameterNode);
                  break;
            }
         }
      });


      final String code = getStatementProperty(statementNode);

      try {
         if (getIsControlFlowStartProperty(statementNode, false)) {
            codeBlock.beginControlFlow(code, args.toArray(new Object[args.size()]));
            indent.incrementAndGet();

         } else if (getIsControlFlowEndProperty(statementNode, false)) {
            if (indent.get() > 0) {
               if (code == null)
                  codeBlock.endControlFlow();
               else
                  codeBlock.endControlFlow(code, args.toArray(new Object[args.size()]));
               indent.decrementAndGet();
            }

         } else {
            if (code != null)
               codeBlock.addStatement(code, args.toArray(new Object[args.size()]));
         }
      } catch (IllegalArgumentException e) {
         log.warn("missing parameters for statement: " + e.getMessage());
      }

      renderBlock(codeBlock, singleOutgoingNEXT(statementNode), indent);
   }

   private static void addMethodStatements(MethodSpec.Builder methodBuilder, Node statementNode) {

      if (statementNode == null) return;

      final CodeBlock.Builder codeBlock = CodeBlock.builder();
      renderBlock(codeBlock, statementNode, new AtomicInteger(0));
      methodBuilder.addCode(codeBlock.build());
   }

   private static ParameterSpec asParameter(Node parameterNode) {

      final TypeName type = asType(singleOutgoingTYPE(parameterNode));
      final String name = getNameProperty(parameterNode);
      if (type == null || name == null) return null;

      final ParameterSpec.Builder builder = ParameterSpec.builder(type, name);
      outgoingMODIFIERS(parameterNode, (relationship, modifierNode) -> builder.addModifiers(asModifier(modifierNode)));

      return builder.build();
   }

   private static TypeName asType(Node typeNameNode) {
      if (typeNameNode == null) return null;

      TypeName returnType;
      if (getBuiltInType(getNameProperty(typeNameNode)) != null) {
         returnType = getBuiltInType(getNameProperty(typeNameNode));

      } else {

         // Parameterized type (List<>, Map<>, Set<>, ...)
         final Set<TypeName> typeNames = new LinkedHashSet<>();
         outgoingTYPEARGUMENTS(typeNameNode, (relationship, typeArgumentNode) -> typeNames.add(asType(typeArgumentNode)));
         if (!typeNames.isEmpty()) {
            returnType = ParameterizedTypeName.get(ClassName.get(getPackageNameProperty(typeNameNode), getNameProperty(typeNameNode)), typeNames.toArray(new TypeName[typeNames.size()]));
         } else {

            // Wildcard type (subType = extends, super = super)
            final Node subTypeNode = singleOutgoingSUBTYPE(typeNameNode);
            if (subTypeNode != null)
               returnType = WildcardTypeName.subtypeOf(asType(subTypeNode));
            else {
               final Node superTypeNode = singleOutgoingSUPERTYPE(typeNameNode);
               if (superTypeNode != null)
                  returnType = WildcardTypeName.supertypeOf(asType(superTypeNode));
               else  // default type
                  returnType = ClassName.get(getPackageNameProperty(typeNameNode, ""), getNameProperty(typeNameNode));
            }
         }
      }

      return getIsArrayProperty(typeNameNode, false) ? ArrayTypeName.of(returnType) : returnType;
   }

   private static TypeName getBuiltInType(String type) {
      if (type == null) return null;

      switch (type) {
         case "boolean":
            return TypeName.BOOLEAN;
         case "byte":
            return TypeName.BYTE;
         case "char":
            return TypeName.CHAR;
         case "double":
            return TypeName.DOUBLE;
         case "float":
            return TypeName.FLOAT;
         case "int":
            return TypeName.INT;
         case "long":
            return TypeName.LONG;
         case "object":
            return TypeName.OBJECT;
         case "short":
            return TypeName.SHORT;
         case "void":
            return TypeName.VOID;
      }

      return null;
   }

   private static Modifier asModifier(Node modifierNode) {
      return Modifier.valueOf(getTypeProperty(modifierNode));
   }

   public static void showAddJavaFileRenderer(NeoNode directoryNode, NeoNode javaFileNode, JPopupMenu pop, App app) {

      final Node typeSpecNode = singleOutgoingTYPESPEC(javaFileNode.getNode());
      if (typeSpecNode == null) return;

      pop.add(new App.TransactionAction("Add Java Renderer for " + getNameProperty(typeSpecNode), app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String className = getNameProperty(typeSpecNode);

            final Relationship rendererRelationship = ProjectPlugin.relateRENDERER(directoryNode.getNode(), javaFileNode.getNode());
            ProjectPlugin.setFileTypeProperty(app.model.graph(), rendererRelationship, ProjectPlugin.Filetype.java.name());
            ProjectPlugin.setPackageNameProperty(app.model.graph(), rendererRelationship, getPackageNameProperty(javaFileNode.getNode()));
            ProjectPlugin.setClassNameProperty(app.model.graph(), rendererRelationship, className);
         }
      });
   }
}