package com.generator.generators.java;

import com.generator.app.App;
import com.generator.app.AppEvents;
import com.generator.app.AppMotif;
import com.generator.app.DomainMotif;
import com.generator.app.nodes.NeoNode;
import com.generator.generators.domain.DomainPlugin;
import com.generator.generators.java.parser.JavaLexer;
import com.generator.generators.java.parser.JavaParser;
import com.generator.generators.java.parser.JavaParserNeoVisitor;
import com.generator.generators.project.ProjectPlugin;
import com.generator.util.GeneratedFile;
import com.generator.generators.stringtemplate.StringTemplatePlugin;
import com.generator.neo.NeoModel;
import com.generator.util.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaFileObject;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static com.generator.app.DomainMotif.findOrCreateInstanceNode;
import static com.generator.app.DomainMotif.getName;
import static com.generator.util.NeoUtil.*;

/**
 * Created 12.09.17.
 */
public class JavaPlugin extends JavaDomainDomainPlugin {

   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(JavaPlugin.class);

   public static void cleanupPreviousSessions(NeoModel graph) {
      instanceMap.clear();
   }

   private static final JavaGroup javaGroup = new JavaGroup();
   private static final Map<String, Object> instanceMap = new LinkedHashMap<>();

   public enum SCOPE {
      PUBLIC, PACKAGE, PROTECTED, PRIVATE
   }

   public JavaPlugin(App app) {
      super(app);
   }

   @Override
   protected void addActionsTo(JMenu menu) {

      addShowMenu(menu, Entities._package);
      addShowMenu(menu, Entities.Class);

      menu.add(new App.TransactionAction("New Package", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String name = SwingUtil.showInputDialog("Name", app);
            if (name == null || name.length() == 0) return;

            fireNodesLoaded(new_package(name));
         }
      });

      menu.add(new App.TransactionAction("New Class", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String name = SwingUtil.showInputDialog("Name", app);
            if (name == null || name.length() == 0) return;

            fireNodesLoaded(newClass(name, null, null, null));
         }
      });


      // todo: work in progress
//      menu.add(new App.TransactionAction("Import jar-file", app) {
//         @Override
//         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
//
////            final File jarFile = SwingUtil.showOpenFile(app, System.getProperty("user.home"));
//            final File jarFile = SwingUtil.showOpenFile(app, "/home/goe/projects/nextgen/lib/");
//            if(jarFile==null || !jarFile.exists() || !jarFile.getName().toLowerCase().endsWith(".jar")) return;
//
//            final JarFile jar = new JarFile(jarFile);
//            final Enumeration<JarEntry> entries = jar.entries();
//            while (entries.hasMoreElements()) {
//               final JarEntry entry = entries.nextElement();
//               final String name = entry.getName();
//               final int extIndex = name.lastIndexOf(".class");
//               if (extIndex > 0) {
//                  final String name2 = name.substring(0, extIndex).replace("/", ".");
//                  log.info(name + " -> " + name2);
//               }
//            }
//         }
//      });


      menu.add(new App.TransactionAction("Parse Java-file", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final File grammarFile = SwingUtil.showOpenFile(app, System.getProperty("user.home"));
            if (grammarFile == null || !grammarFile.getName().toLowerCase().endsWith(".java")) return;

            final JavaParser parser = new JavaParser(new CommonTokenStream(new JavaLexer(CharStreams.fromFileName(grammarFile.getAbsolutePath()))));
            final JavaParserNeoVisitor visitor = new JavaParserNeoVisitor(getGraph());
            visitor.visit(parser.compilationUnit());
            if (visitor.getRoot() != null) fireNodesLoaded(visitor.getRoot());
         }
      });
   }


   @Override
   protected void handle_package(JPopupMenu pop, NeoNode _packageNode, Set<NeoNode> selectedNodes) {

      for (NeoNode selectedNode : selectedNodes) {
         if (isClass(selectedNode.getNode())) {
            pop.add(new App.TransactionAction("Set package for " + getNameAndLabelsFrom(selectedNode.getNode()), app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  relate_PACKAGE(_packageNode.getNode(), selectedNode.getNode());
               }
            });
         }
      }
   }

   @Override
   protected void handleConstructor(JPopupMenu pop, NeoNode constructorNode, Set<NeoNode> selectedNodes) {

      final SCOPE scope = SCOPE.valueOf(getScopeProperty(constructorNode.getNode(), SCOPE.PACKAGE.name()));
      if (SCOPE.PUBLIC.equals(scope)) {

         final Node classNode = singleIncomingCONSTRUCTOR(constructorNode.getNode());

         final Map<String, Node> nodeParameters = new LinkedHashMap<>();
         outgoingPARAMETER(constructorNode.getNode(), (relationship, parameterNode) -> nodeParameters.put(getName(singleOutgoingTYPE(parameterNode)), parameterNode));

         pop.add(new App.TransactionAction("New instance", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final String packageName = getNameProperty(singleIncomingCLASS(classNode));
               final String name = getNameProperty(classNode);
               final String source = toSource(classNode);

               // compile source and create instance :
               final DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
               final Class<?> classInstance = new CompilerUtil().compile(packageName + "." + name, source, diagnostics);
               if (classInstance == null) {
                  SwingUtil.showDialog(new CompilerUtil.DiagnosticPanel(diagnostics, source), app, "Compilation errors");
                  return;
               }

               new BaseClassVisitor() {
                  @Override
                  public void onPublicConstructor(Constructor<?> constructor) {

                     // collect all parameters and nodes with same type, to allow user to select which parameter
                     final Map<Parameter, Set<Node>> parameterSetMap = new LinkedHashMap<>();

                     final Object parameters = new Object[constructor.getParameters().length];
                     final AtomicInteger parameterMatch = new AtomicInteger(0);
                     for (Parameter parameter : constructor.getParameters()) {
                        if (nodeParameters.containsKey(parameter.getType().getSimpleName())) {

                           parameterSetMap.put(parameter, new LinkedHashSet<>());

                           // same parameter-type, try to find parameter amongst selected nodes:
                           for (NeoNode selectedNode : selectedNodes) {
                              if (isParameter(selectedNode.getNode())) {
                                 final Node parameterTypeNode = singleOutgoingTYPE(selectedNode.getNode());
                                 if (parameter.getType().getCanonicalName().equals(getNameProperty(parameterTypeNode)))
                                    parameterSetMap.get(parameter).add(selectedNode.getNode());
                              }
                           }

                           parameterMatch.incrementAndGet();
                        }
                     }

                     for (Map.Entry<Parameter, Set<Node>> entry : parameterSetMap.entrySet()) {
                        log.info(entry.getKey().getName() + "(" + entry.getKey().getType().getCanonicalName());
                        for (Node node : entry.getValue()) {
                           log.info("\t" + getNameProperty(node));
                        }
                     }


                     if (parameterMatch.get() == constructor.getParameters().length) {
                        try {
                           final Object instance = constructor.newInstance(parameters);
                           // create Object-node for this instance, and use uuid for key in instance-map
                           final Node node = getGraph().newNode(Entities.Object, AppMotif.Properties.name.name(), name);
                           instanceMap.put(getString(node, TAG_UUID), instance);
                           fireNodesLoaded(node);
                        } catch (Throwable t) {
                           SwingUtil.showException(app, t);
                        }
                     }
                  }
               }.visit(classInstance);
            }
         });
      }
   }

   @Override
   protected void handleClass(JPopupMenu pop, NeoNode classNode, Set<NeoNode> selectedNodes) {

      ProjectPlugin.outgoingRENDERER(classNode.getNode(), (rendererRelationship, directory) -> pop.add(new App.TransactionAction("Write to " + ProjectPlugin.getPathProperty(directory), app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            GeneratedFile.newJavaFile(ProjectPlugin.getFile(directory).getPath(), getNameProperty(singleIncomingCLASS(classNode.getNode())), getName(classNode.getNode())).write(toSource(classNode.getNode()));
         }
      }));

      final Set<Node> fieldNodes = new LinkedHashSet<>();
      outgoingFIELD(classNode.getNode(), (relationship, fieldNode) -> {
         final String fieldName = getName(fieldNode);
         final Node typeNode = singleOutgoingTYPE(fieldNode);
         if (fieldName == null || typeNode == null) return;
         fieldNodes.add(fieldNode);
      });

      pop.add(new App.TransactionAction("Compile", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String packageName = getNameProperty(singleIncomingCLASS(classNode.getNode()));
            final String name = getNameProperty(classNode.getNode());
            final String source = toSource(classNode.getNode());

            final DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
            final Class<?> classInstance = new CompilerUtil().compile(packageName + "." + name, source, diagnostics);
            if (classInstance == null) {
               SwingUtil.showDialog(new CompilerUtil.DiagnosticPanel(diagnostics, source), app, "Compilation errors");
               return;
            }

            SwingUtil.showMessage("Compiled OK", app);
         }
      });


      outgoingCONSTRUCTOR(classNode.getNode(), new RelationConsumer() {
         @Override
         public void accept(Relationship relationship, Node constructorNode) {

            final SCOPE scope = SCOPE.valueOf(getScopeProperty(constructorNode, SCOPE.PACKAGE.name()));

            switch (scope) {

               case PUBLIC:
                  break;

               case PACKAGE:
                  break;

               case PROTECTED:
                  break;

               case PRIVATE:
                  break;
            }
         }
      });


      pop.add(new App.TransactionAction("Edit", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String[] scopes = new String[]{"package", "protected", "private", "public"};
            final String currentScope = getScopeProperty(classNode.getNode(), "package");
            final JComboBox<String> cboScopes = new JComboBox<>(scopes);
            cboScopes.setSelectedItem(currentScope);

            final JCheckBox chkAbstract = new JCheckBox("Abstract", getIsAbstractProperty(classNode.getNode(), false));
            final JCheckBox chkFinal = new JCheckBox("Final", getIsFinalProperty(classNode.getNode(), false));

            final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("75dlu,4dlu,75dlu:grow", "pref, 4dlu, pref, 4dlu, pref");
            editor.addLabel("Scope", 1, 1);
            editor.add(cboScopes, 3, 1);
            editor.addLabel("Abstract", 1, 3);
            editor.add(chkAbstract, 3, 3);
            editor.addLabel("Final", 1, 5);
            editor.add(chkFinal, 3, 5);

            final String className = getNameProperty(classNode.getNode());

            SwingUtil.showDialog(editor, app, className, new SwingUtil.ConfirmAction() {
               @Override
               public void verifyAndCommit() throws Exception {

                  if (chkAbstract.isSelected() && chkFinal.isSelected())
                     throw new IllegalStateException(className + " cannot both be abstract and final");

                  getGraph().doInTransaction(new NeoModel.Committer() {
                     @Override
                     public void doAction(Transaction tx) throws Throwable {
                        setIsAbstractProperty(classNode.getNode(), chkAbstract.isSelected());
                        setIsFinalProperty(classNode.getNode(), chkFinal.isSelected());
                        setScopeProperty(classNode.getNode(), "package".equals(cboScopes.getSelectedItem()) ? "" : cboScopes.getSelectedItem());
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

      pop.add(new App.TransactionAction("Add Field", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final JTextField txtName = new JTextField();
            final JTextField txtType = new JTextField();

            final String[] scopes = new String[]{"package", "protected", "private", "public"};
            final String currentScope = getScopeProperty(classNode.getNode(), "package");
            final JComboBox<String> cboScopes = new JComboBox<>(scopes);
            cboScopes.setSelectedItem(currentScope);

            final JCheckBox chkFinal = new JCheckBox("", false);
            final JCheckBox chkSetter = new JCheckBox("", false);
            final JCheckBox chkIsEqha = new JCheckBox("", false);
            final JCheckBox chkToString = new JCheckBox("", false);
            final JCheckBox chkGetter = new JCheckBox("", false);
            final JCheckBox chkIsArray = new JCheckBox("", false);

            final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("75dlu,4dlu,75dlu:grow", "pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref");
            int row = 1;
            editor.addLabel("Name", 1, row);
            editor.add(txtName, 3, row);
            row += 2;
            editor.addLabel("Type", 1, row);
            editor.add(txtType, 3, row);
            row += 2;
            editor.addLabel("Scope", 1, row);
            editor.add(cboScopes, 3, row);
            row += 2;
            editor.addLabel("Final", 1, row);
            editor.add(chkFinal, 3, row);
            row += 2;
            editor.addLabel("Equals/Hash", 1, row);
            editor.add(chkIsEqha, 3, row);
            row += 2;
            editor.addLabel("toString", 1, row);
            editor.add(chkToString, 3, row);
            row += 2;
            editor.addLabel("getter", 1, row);
            editor.add(chkGetter, 3, row);
            row += 2;
            editor.addLabel("setter", 1, row);
            editor.add(chkSetter, 3, row);
            row += 2;
            editor.addLabel("isArray", 1, row);
            editor.add(chkIsArray, 3, row);

            SwingUtil.showDialog(editor, app, "New field", new SwingUtil.ConfirmAction() {
               @Override
               public void verifyAndCommit() throws Exception {
                  getGraph().doInTransaction(new NeoModel.Committer() {
                     @Override
                     public void doAction(Transaction tx) throws Throwable {
                        final Node newField = newField(cboScopes.getSelectedItem().equals("package") ? null : cboScopes.getSelectedItem(), txtName.getText().trim(), chkSetter.isSelected(), chkFinal.isSelected(), chkIsEqha.isSelected(), chkToString.isSelected(), chkGetter.isSelected(), chkIsArray.isSelected());
                        relateTYPE(newField, findOrCreateInstanceNode(getGraph(), txtType.getText().trim(), getEntityNode(Entities.Class)));
                        relateFIELD(classNode.getNode(), newField);
                        fireNodeChanged(newField);
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

      pop.add(new App.TransactionAction("Set Accessors", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final Map<String, Node> available = new LinkedHashMap<>();
            for (Node fieldNode : fieldNodes)
               available.put(getNameProperty(fieldNode), fieldNode);

            // first = setter, second = getter
            final Map<String, Tuple<JCheckBox, JCheckBox>> fields = new TreeMap<>();
            final StringBuilder rows = new StringBuilder();
            boolean first = true;
            for (Map.Entry<String, Node> propertyEntry : available.entrySet()) {
               if (!first) rows.append(",4dlu,");
               rows.append("pref, 4dlu, pref");
               fields.put(propertyEntry.getKey(), new Tuple<>(new JCheckBox("Setter"), new JCheckBox("Getter")));
               fields.get(propertyEntry.getKey()).getFirst().setSelected(getHasSetterProperty(propertyEntry.getValue(), false));
               fields.get(propertyEntry.getKey()).getSecond().setSelected(getHasGetterProperty(propertyEntry.getValue(), false));
               first = false;
            }

            final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("75dlu:grow,4dlu,75dlu:grow,4dlu,75dlu:grow", rows.toString().trim());
            int row = 1;
            for (Map.Entry<String, Tuple<JCheckBox, JCheckBox>> fieldEntry : fields.entrySet()) {
               editor.addLabel(fieldEntry.getKey(), 1, row);
               editor.add(fieldEntry.getValue().getFirst(), 3, row);
               editor.add(fieldEntry.getValue().getSecond(), 5, row);
               row += 2;
            }
            editor.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

            SwingUtil.showDialog(editor, app, "Fields", new SwingUtil.ConfirmAction() {
               @Override
               public void verifyAndCommit() throws Exception {
                  getGraph().doInTransaction(new NeoModel.Committer() {
                     @Override
                     public void doAction(Transaction tx) throws Throwable {
                        for (Map.Entry<String, Tuple<JCheckBox, JCheckBox>> fieldEntry : fields.entrySet()) {
                           setHasSetterProperty(available.get(fieldEntry.getKey()), fieldEntry.getValue().getFirst().isSelected());
                           setHasGetterProperty(available.get(fieldEntry.getKey()), fieldEntry.getValue().getSecond().isSelected());
                        }
                     }

                     @Override
                     public void exception(Throwable throwable) {
                        SwingUtil.showExceptionNoStack(app, throwable);
                     }
                  });
               }
            });
         }
      });

      pop.add(new App.TransactionAction("Set equal / hash", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final Map<String, Node> available = new LinkedHashMap<>();
            for (Node fieldNode : fieldNodes)
               available.put(getNameProperty(fieldNode), fieldNode);

            final Map<String, JCheckBox> fields = new TreeMap<>();
            final StringBuilder rows = new StringBuilder();
            boolean first = true;
            for (Map.Entry<String, Node> propertyEntry : available.entrySet()) {
               if (!first) rows.append(",4dlu,");
               rows.append("pref");
               fields.put(propertyEntry.getKey(), new JCheckBox());
               fields.get(propertyEntry.getKey()).setSelected(getIsEqhaProperty(propertyEntry.getValue(), false));
               first = false;
            }

            final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("75dlu:grow,4dlu,75dlu:grow", rows.toString().trim());
            int row = 1;
            for (Map.Entry<String, JCheckBox> fieldEntry : fields.entrySet()) {
               editor.addLabel(fieldEntry.getKey(), 1, row);
               editor.add(fieldEntry.getValue(), 3, row);
               row += 2;
            }
            editor.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

            SwingUtil.showDialog(editor, app, "Fields", new SwingUtil.ConfirmAction() {
               @Override
               public void verifyAndCommit() throws Exception {
                  getGraph().doInTransaction(new NeoModel.Committer() {
                     @Override
                     public void doAction(Transaction tx) throws Throwable {
                        for (Map.Entry<String, JCheckBox> fieldEntry : fields.entrySet())
                           setIsEqhaProperty(available.get(fieldEntry.getKey()), fieldEntry.getValue().isSelected());
                     }

                     @Override
                     public void exception(Throwable throwable) {
                        SwingUtil.showExceptionNoStack(app, throwable);
                     }
                  });
               }
            });
         }
      });

      pop.add(new App.TransactionAction("Set toString", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final Map<String, Node> available = new LinkedHashMap<>();
            for (Node fieldNode : fieldNodes)
               available.put(getNameProperty(fieldNode), fieldNode);

            final Map<String, JCheckBox> fields = new TreeMap<>();
            final StringBuilder rows = new StringBuilder();
            boolean first = true;
            for (Map.Entry<String, Node> propertyEntry : available.entrySet()) {
               if (!first) rows.append(",4dlu,");
               rows.append("pref");
               fields.put(propertyEntry.getKey(), new JCheckBox());
               fields.get(propertyEntry.getKey()).setSelected(getIsToStringProperty(propertyEntry.getValue(), false));
               first = false;
            }

            final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("75dlu:grow,4dlu,75dlu:grow", rows.toString().trim());
            int row = 1;
            for (Map.Entry<String, JCheckBox> fieldEntry : fields.entrySet()) {
               editor.addLabel(fieldEntry.getKey(), 1, row);
               editor.add(fieldEntry.getValue(), 3, row);
               row += 2;
            }
            editor.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

            SwingUtil.showDialog(editor, app, "Fields", new SwingUtil.ConfirmAction() {
               @Override
               public void verifyAndCommit() throws Exception {
                  getGraph().doInTransaction(new NeoModel.Committer() {
                     @Override
                     public void doAction(Transaction tx) throws Throwable {
                        for (Map.Entry<String, JCheckBox> fieldEntry : fields.entrySet())
                           setIsToStringProperty(available.get(fieldEntry.getKey()), fieldEntry.getValue().isSelected());
                     }

                     @Override
                     public void exception(Throwable throwable) {
                        SwingUtil.showExceptionNoStack(app, throwable);
                     }
                  });
               }
            });
         }
      });
   }

   @Override
   protected void handleField(JPopupMenu pop, NeoNode fieldNode, Set<NeoNode> selectedNodes) {

      pop.add(new App.TransactionAction("Set type", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String typeName = SwingUtil.showInputDialog("Type", app);
            if (typeName == null || typeName.length() == 0) return;

            final Node instanceNode = DomainMotif.findOrCreateInstanceNode(getGraph(), typeName, getEntityNode(Entities.Class));
            relateTYPE(fieldNode.getNode(), instanceNode);
            fireNodesLoaded(instanceNode);
         }
      });
   }

   @Override
   protected void handleObject(JPopupMenu pop, NeoNode objectNode, Set<NeoNode> selectedNodes) {
      // todo: nodeInstances will be null if restarting - needs to be cleaned-up
      final Object instance = instanceMap.get(getString(objectNode.getNode(), TAG_UUID));
      if (instance == null) return;

      new BaseClassVisitor() {
         @Override
         public void onClass(Package classPackage, String className, Class superClass) {
            log.info(className);
         }

         @Override
         public void onPublicMethod(Method method) {

            final Class<?> returnType = method.getReturnType();

            if ("void".equals(returnType.getName())) {
               pop.add(new App.TransactionAction("Call " + method.getName(), app) {
                  @Override
                  protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                     final Parameter[] parameters = method.getParameters();
                     final Object[] args = new Object[parameters.length];

                     for (int i = 0; i < parameters.length; i++) {
                        Parameter parameter = parameters[i];

                        // todo: generify this to support any arbitrary parameter, and remove if-else
                        if ("java.lang.String".equals(parameter.getType().getName())) {

                           final String value = SwingUtil.showInputDialog(parameter.getName(), app);
                           if (value == null) return;

                           final Reflect param = Reflect.on(parameter.getType());
                           args[i] = param.create(value).get();

                        } else if ("java.lang.Integer".equals(parameter.getType().getName())) {

                           final String value = SwingUtil.showInputDialog(parameter.getName(), app);
                           if (value == null) return;

                           final Reflect param = Reflect.on(parameter.getType());
                           args[i] = param.create(Integer.parseInt(value.trim())).get();

                        } else {
                           log.info("\t" + parameter.getType().getName());
                           args[i] = parameter.getType().newInstance();
                        }

                     }

                     Reflect.on(instance).call(method.getName(), args);
                     fireNodeChanged(objectNode.getNode());
                  }
               });
            }
         }
      }.visit(instance.getClass());
   }

   @Override
   protected JComponent newClassEditor(NeoNode neoNode) {
      return new ClassPanel(neoNode);
   }

   @Override
   protected JComponent newConstructorEditor(NeoNode constructorNode) {
      return new ConstructorPanel(constructorNode.getNode());
   }

   @Override
   protected JComponent newObjectEditor(NeoNode neoNode) {
      return new ObjectPanel(neoNode);
   }


   private final class ObjectPanel extends JPanel {

      ObjectPanel(NeoNode objectNode) {
         super(new BorderLayout());

         final JTextArea txtEditor = SwingUtil.newTextArea();
         txtEditor.setEditable(false);
         txtEditor.setText(renderObject(objectNode.getNode()));
         txtEditor.setCaretPosition(0);

         addNodeChangedListener(objectNode, new AppEvents.TransactionalPropertyChangeListener<Object, Object>(getClass(), JavaPlugin.ObjectPanel.this, app) {
            @Override
            protected void propertyChange(Object oldValue, Object newValue) {
               txtEditor.setText(renderObject(objectNode.getNode()));
               txtEditor.setCaretPosition(0);
            }
         });

         add(new JScrollPane(txtEditor), BorderLayout.CENTER);
      }

      private String renderObject(Node node) {

         final Object instance = instanceMap.get(NeoUtil.getString(node, TAG_UUID));
         if (instance == null) return "No instance for " + NeoUtil.getString(node, TAG_UUID);

         final StringBuilder text = new StringBuilder();

         new BaseClassVisitor() {

            @Override
            public void onClass(Package classPackage, String className, Class superClass) {
               text.append(className).append(superClass != null ? " extends " + superClass.getName() : "");
            }

            @Override
            public void onPublicField(String name, Class<?> returnType) {
               renderField(name, returnType);
            }

            @Override
            public void onPackageField(String name, Class<?> returnType) {
               renderField(name, returnType);
            }

            @Override
            public void onPrivateField(String name, Class<?> returnType) {
               renderField(name, returnType);
            }

            @Override
            public void onProtectedField(String name, Class<?> returnType) {
               renderField(name, returnType);
            }

            @Override
            public void onPublicMethod(Method method) {
               final Class<?> returnType = method.getReturnType();
               if ("void".equals(returnType.getName())) return;

               if (method.getParameters().length > 0) return;

               final Reflect result = Reflect.on(instance).call(method.getName());
               text.append("\n\n\t").append(method.getName()).append(" = ").append(result.isNull() ? "null" : result.get().toString());
            }

            private void renderField(String name, Class<?> returnType) {
               text.append("\n\t");

               String returnTypeName = returnType.getName();
               if (returnTypeName.startsWith("[L")) {
                  returnTypeName = returnTypeName.substring(2, returnTypeName.length() - 1) + "[]";
               }

               text.append(returnTypeName).append(" ").append(name);
               final Reflect field = Reflect.on(instance).field(name);
               text.append(field.isNull() ? " null" : " = " + field.get() + "");
            }
         }.visit(instance.getClass());

         return text.toString();
      }
   }

   private class ClassPanel extends JPanel {
      ClassPanel(NeoNode neoNode) {
         super(new BorderLayout());

         final JTextArea txtEditor = new JTextArea();
         txtEditor.setFont(com.generator.app.AppMotif.getDefaultFont());
         txtEditor.setTabSize(3);
         txtEditor.setEditable(false);
         txtEditor.setText(toSource(neoNode.getNode()));
         txtEditor.setCaretPosition(0);

         add(new JScrollPane(txtEditor), BorderLayout.CENTER);
      }
   }

   private class ConstructorPanel extends JPanel {
      ConstructorPanel(Node constructorNode) {
         super(new BorderLayout());

         final JTextArea txtEditor = new JTextArea();
         txtEditor.setFont(com.generator.app.AppMotif.getDefaultFont());
         txtEditor.setTabSize(3);
         txtEditor.setEditable(false);
         txtEditor.setText(format(constructorNode));
         txtEditor.setCaretPosition(0);

         add(new JScrollPane(txtEditor), BorderLayout.CENTER);
      }

      private String format(Node constructorNode) {
         final StringBuilder out = new StringBuilder();

         out.append("scope : ").append(getScopeProperty(constructorNode, ""));

         outgoingPARAMETER(constructorNode, (relationship, other) -> out.append("\n\t").append(getNameProperty(other, "")).append(" (").append(getNameProperty(singleOutgoingTYPE(other), "?")).append(")"));
         return out.toString();
      }
   }

   public static String toSource(Node classNode) {

      final Node packageNode = other(classNode, singleIncoming(classNode, Relations.CLASS));

      final JavaGroup.ClassST classST = javaGroup.newClass().
            setPackage(getNameProperty(packageNode)).
            setName(getNameProperty(classNode)).
            setScope(getScopeProperty(classNode)).
            setIsAbstract(getIsAbstractProperty(classNode)).
            setIsFinal(getIsFinalProperty(classNode));

      final JavaGroup.eqhaST eqhaST = javaGroup.neweqha().
            setName(getNameProperty(classNode));

      final JavaGroup.toStringST toStringST = javaGroup.newtoString();

      outgoingCONSTRUCTOR(classNode, (constructorRelation, constructorNode) -> {

         final JavaGroup.constructorST constructorST = javaGroup.newconstructor().
               setName(getNameProperty(classNode)).
               setScope(getScopeProperty(constructorNode, ""));

         outgoingPARAMETER(constructorNode, (parameterRelation, fieldNode) -> constructorST.addFieldsValue(getNameProperty(singleOutgoingTYPE(fieldNode)), getNameProperty(fieldNode)));

         classST.addMethodsValue(constructorST);
      });

      outgoingSET(classNode, (listRelation, setNode) -> {

         final String fieldName = getNameProperty(setNode);

         final JavaGroup.setMethodsST setMethodsST = javaGroup.newsetMethods().
               setElementName(getElementNameProperty(setNode)).
               setElementType(getElementTypeProperty(setNode)).
               setName(fieldName);

         classST.addFieldsValue("new " + getImplementationProperty(setNode) + "<>()", fieldName, "java.util.Set<" + getElementTypeProperty(setNode) + ">", "private", true, false);
         classST.addMethodsValue(setMethodsST);
      });

      outgoingMAP(classNode, (listRelation, mapNode) -> {

         final String fieldName = getNameProperty(mapNode);

         final JavaGroup.mapMethodsST mapMethodST = javaGroup.newmapMethods().
               setKeyType(getKeyTypeProperty(mapNode)).
               setValueType(getValueTypeProperty(mapNode)).
               setName(fieldName);

         classST.addFieldsValue("new " + getImplementationProperty(mapNode) + "<>()", fieldName, "java.util.Map<" + getKeyTypeProperty(mapNode) + "," + getValueTypeProperty(mapNode) + ">", "private", true, false);
         classST.addMethodsValue(mapMethodST);
      });

      outgoingLIST(classNode, (listRelation, listNode) -> {

         final String fieldName = getNameProperty(listNode);

         final JavaGroup.listMethodsST listMethodsST = javaGroup.newlistMethods().
               setElementName(getElementNameProperty(listNode)).
               setElementType(getElementTypeProperty(listNode)).
               setName(fieldName);

         classST.addFieldsValue("new " + getImplementationProperty(listNode) + "<>()", fieldName, "java.util.List<" + getElementTypeProperty(listNode) + ">", "private", true, false);
         classST.addMethodsValue(listMethodsST);
      });

      outgoingFIELD(classNode, (fieldRelation, fieldNode) -> {

         final Node typeNode = singleOutgoingTYPE(fieldNode);
         final Node instantiationNode = singleOutgoingINSTANTIATION(fieldNode);

         final String fieldName = getNameProperty(fieldNode);
         final String typeName = getNameProperty(typeNode);

         final Boolean isArray = getIsArrayProperty(fieldNode, false);
         final Boolean isFinal = getIsFinalProperty(fieldNode, false);

         classST.addFieldsValue(getNameProperty(instantiationNode), fieldName, typeName, DomainMotif.getEntityProperty(fieldNode, Properties.scope.name()), isFinal, isArray);

         if (getIsEqhaProperty(fieldNode, false)) eqhaST.addEqhaValue(fieldName);
         if (getIsToStringProperty(fieldNode, false)) toStringST.addValuesValue(fieldName);

         if (isArray) {
            classST.addMethodsValue(javaGroup.newarrayMethods().setName(fieldName).setType(typeName));

         } else {

            if (getHasGetterProperty(fieldNode, false))
               classST.addMethodsValue(javaGroup.newget().setName(fieldName).setType(typeName));

            if (!isFinal && getHasSetterProperty(fieldNode, false))
               classST.addMethodsValue(javaGroup.newset().setName(fieldName).setType(typeName));
         }
      });

      outgoingMETHOD(classNode, (methodRelation, methodNode) -> {

         if (isMethod(methodNode)) {

            final JavaGroup.methodST methodST = javaGroup.newmethod().
                  setName(getNameProperty(methodNode)).
                  setScope(DomainMotif.getEntityProperty(methodNode, Properties.scope.name()));

            final Node returnValueNode = singleOutgoingRETURNVALUE(methodNode);
            methodST.setReturnValue(returnValueNode == null ? null : getNameProperty(returnValueNode));

            outgoingPARAMETER(methodNode, (parameterRelation, parameterNode) -> {
               final Node typeNode = singleOutgoingTYPE(parameterNode);
               methodST.addParametersValue(getNameProperty(parameterNode), getNameProperty(typeNode));
            });

            createStatementBlock(singleOutgoingBLOCK(methodNode), methodST);

            classST.addMethodsValue(methodST);

         } else {
            final Node templateNode = other(methodNode, singleIncoming(methodNode, DomainPlugin.Relations.INSTANCE));
            if (templateNode != null)
               classST.addMethodsValue(StringTemplatePlugin.renderStatement(methodNode, templateNode));
         }
      });

      // add equals/has and toString, if applied
      if (!eqhaST.getEqhaValues().isEmpty()) classST.addMethodsValue(eqhaST);
      if (!toStringST.getValuesValues().isEmpty()) classST.addMethodsValue(toStringST);

      return classST.toString();
   }

   @Override
   public String toString() {
      return super.toString();
   }

   private static void createStatementBlock(Node statementNode, JavaGroup.methodST methodST) {
      if (statementNode == null) return;
      methodST.addStatementsValue(getCodeProperty(statementNode));
      createStatementBlock(singleOutgoingNEXT(statementNode), methodST);
   }
}