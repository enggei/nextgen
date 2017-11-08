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
import com.generator.generators.stringtemplate.StringTemplatePlugin;
import com.generator.neo.NeoModel;
import com.generator.util.CompilerUtil;
import com.generator.util.NeoUtil;
import com.generator.util.Reflect;
import com.generator.util.SwingUtil;
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
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import static com.generator.util.NeoUtil.*;

/**
 * Created 12.09.17.
 */
public class JavaPlugin extends JavaDomainDomainPlugin {

   public static void cleanupPreviousSessions(NeoModel graph) {
      instanceMap.clear();
   }

   private static final JavaGroup javaGroup = new JavaGroup();

   private static final Map<String, Object> instanceMap = new LinkedHashMap<>();

   public JavaPlugin(App app) {
      super(app);
   }

   @Override
   protected void addActionsTo(JMenu menu) {


      menu.add(new App.TransactionAction("Import jar-file", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

//            final File jarFile = SwingUtil.showOpenFile(app, System.getProperty("user.home"));
            final File jarFile = SwingUtil.showOpenFile(app, "/home/goe/projects/nextgen/lib/");
            if(jarFile==null || !jarFile.exists() || !jarFile.getName().toLowerCase().endsWith(".jar")) return;

            final JarFile jar = new JarFile(jarFile);
            final Enumeration<JarEntry> entries = jar.entries();
            while (entries.hasMoreElements()) {
               final JarEntry entry = entries.nextElement();
               final String name = entry.getName();
               final int extIndex = name.lastIndexOf(".class");
               if (extIndex > 0) {
                  final String name2 = name.substring(0, extIndex).replace("/", ".");
                  System.out.println(name + " -> " + name2);
               }
            }
         }
      });

      menu.add(new App.TransactionAction("New test - instance", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            // todo this should come from traversers of the graph
            final String name = "Hello";
            final String packageName = "com.test";

            final JavaGroup.PojoST pojoST = new JavaGroup().newPojo().
                  setPackage(packageName).
                  setName(name).
                  addPropertiesValue(null, "Integer", "id").
                  addPropertiesValue(null, "String", "name").
                  addLexicalValue("id").
                  addLexicalValue("name");

            // compile source and create instance :
            final Object instance = new CompilerUtil().newInstance(packageName + "." + name, pojoST, new DiagnosticCollector<>());

            // create Object-node for this instance, and use uuid for key in instance-map
            final Node node = getGraph().newNode(Entities.Object, AppMotif.Properties.name.name(), name);
            instanceMap.put(getString(node, TAG_UUID), instance);
            fireNodesLoaded(node);
         }
      });

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
   protected void handleObject(JPopupMenu pop, NeoNode objectNode, Set<NeoNode> selectedNodes) {
      // todo: nodeInstances will be null if restarting - needs to be cleaned-up
      final Object instance = instanceMap.get(getString(objectNode.getNode(), TAG_UUID));
      if (instance == null) return;

      new BaseClassVisitor() {
         @Override
         public void onClass(Package classPackage, String className, Class superClass) {
            System.out.println(className);
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
                           System.out.println("\t" + parameter.getType().getName());
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
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {

      super.handleNodeRightClick(pop, neoNode, selectedNodes);

      // get incoming INSTANCE, and if of STTemplate, allow to create instance of, similar to renderer
      DomainPlugin.incomingINSTANCE(neoNode.getNode(), (instanceRelation, instanceNode) -> {
         if (StringTemplatePlugin.isSTTemplate(instanceNode)) {

            pop.add(new App.TransactionAction("TEST - new instance of " + getNameProperty(neoNode.getNode()), app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  // todo this should come from traversers of the graph
                  final String name = getNameProperty(neoNode.getNode());
                  final String packageName = DomainMotif.getEntityProperty(neoNode.getNode(), "packageName", "");

                  final String content = StringTemplatePlugin.renderStatement(neoNode.getNode(), instanceNode);

                  // compile source and create instance :
                  final DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
                  final Object instance = new CompilerUtil().newInstance(packageName + "." + name, content, diagnostics);
                  if (instance == null) {
                     CompilerUtil.printDiagnostics(diagnostics);
                     return;
                  }

                  // create Object-node for this instance, and use uuid for key in instance-map
                  final Node node = newObject(name);
                  instanceMap.put(getString(node, TAG_UUID), instance);
                  relate(neoNode.getNode(), node, Relations.OBJECT);

                  // todo add delete-listener, so instanceMap does not fill up

                  fireNodesLoaded(node);
               }
            });
         }
      });
   }

   @Override
   protected JComponent newClassEditor(NeoNode neoNode) {
      return new ClassPanel(neoNode);
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
               final Reflect result = Reflect.on(instance).call(method.getName());
               text.append("\n\n\t").append(method.getName()).append(" = ").append(result.isNull() ? "null" : result.get().toString());
            }

            private void renderField(String name, Class<?> returnType) {
               text.append("\n\t").append(returnType.getName()).append(" ").append(name);
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

         add(new JScrollPane(txtEditor), BorderLayout.CENTER);
      }
   }

   public static String toSource(Node classNode) {

      final Node packageNode = other(classNode, singleIncoming(classNode, Relations.CLASS));

      final JavaGroup.ClassST classST = javaGroup.newClass().
            setPackage(getNameProperty(packageNode)).
            setName(getNameProperty(classNode));

      outgoingFIELD(classNode, (fieldRelation, fieldNode) -> {

         final Node typeNode = singleOutgoingTYPE(fieldNode);
         final Node instantiationNode = singleOutgoingINSTANTIATION(fieldNode);

         classST.addFieldsValue(getNameProperty(instantiationNode), getNameProperty(fieldNode), getNameProperty(typeNode), DomainMotif.getEntityProperty(fieldNode, Properties.scope.name()));
      });

      outgoingMETHOD(classNode, (methodRelation, methodNode) -> {

         if (isMethod(methodNode)) {

            final JavaGroup.methodST methodST = javaGroup.newmethod().
                  setName(getNameProperty(methodNode)).
                  setScope(DomainMotif.getEntityProperty(methodNode, Properties.scope.name()));

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

      return classST.toString();
   }

   @Override
   public String toString() {
      return super.toString();
   }

   private static void createStatementBlock(Node statementNode, JavaGroup.methodST methodST) {
      if (statementNode == null) return;
      methodST.addStatementsValue(getNameProperty(statementNode));
      createStatementBlock(singleOutgoingNEXT(statementNode), methodST);
   }
}