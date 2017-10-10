package com.generator.generators.java;

import com.generator.app.nodes.NeoNode;
import com.generator.generators.java.parser.JavaLexer;
import com.generator.generators.java.parser.JavaParser;
import com.generator.generators.java.parser.JavaParserNeoVisitor;
import com.generator.util.NeoUtil;
import com.generator.app.*;
import com.generator.generators.domain.DomainPlugin;
import com.generator.generators.stringtemplate.StringTemplatePlugin;
import com.generator.util.CompilerUtil;
import com.generator.util.Reflect;
import com.generator.util.SwingUtil;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaFileObject;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static com.generator.util.NeoUtil.*;
import static com.generator.util.NeoUtil.getNameAndLabelsFrom;
import static com.generator.util.NeoUtil.relate;

/**
 * Created 12.09.17.
 */
public class JavaPlugin extends Plugin {

   public enum Entities implements Label {
      Object
   }

   public enum Relations implements RelationshipType {
      OBJECT
   }

   public enum Properties {

   }

   private final Map<String, Object> instanceMap = new LinkedHashMap<>();

   public JavaPlugin(App app) {
      super(app, "Java");
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   protected void addActionsTo(JMenu menu) {
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
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {

      // get incoming INSTANCE, and if of STTemplate, allow to create instance of, similar to renderer

      incoming(neoNode.getNode(), DomainPlugin.Relations.INSTANCE).forEach(instanceRelation -> {

         final Node instanceNode = other(neoNode.getNode(), instanceRelation);

         if (hasLabel(instanceNode, StringTemplatePlugin.Entities.STTemplate)) {

            pop.add(new App.TransactionAction("TEST - new instance of " + DomainMotif.getPropertyValue(neoNode.getNode(), AppMotif.Properties.name.name()), app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  // todo this should come from traversers of the graph
                  final String name = DomainMotif.getPropertyValue(neoNode.getNode(), AppMotif.Properties.name.name());
                  final String packageName = DomainMotif.getPropertyValue(neoNode.getNode(), "package", "");

                  final String content = StringTemplatePlugin.renderStatement(neoNode.getNode(), instanceNode);

                  // compile source and create instance :
                  final DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
                  final Object instance = new CompilerUtil().newInstance(packageName + "." + name, content, diagnostics);
                  if (instance == null) {
                     CompilerUtil.printDiagnostics(diagnostics);
                     return;
                  }

                  // create Object-node for this instance, and use uuid for key in instance-map
                  final Node node = getGraph().newNode(Entities.Object, AppMotif.Properties.name.name(), name);
                  instanceMap.put(getString(node, TAG_UUID), instance);
                  relate(neoNode.getNode(), node, Relations.OBJECT);

                  // todo add delete-listener, so instanceMap does not fill up

                  fireNodesLoaded(node);
               }
            });

         }
      });

      if (hasLabel(neoNode.getNode(), Entities.Object)) {

         // todo: nodeInstances will be null if restarting - needs to be cleaned-up
         final Object instance = instanceMap.get(getString(neoNode.getNode(), TAG_UUID));
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
                        fireNodeChanged(neoNode.getNode());
                     }
                  });
               }
            }
         }.visit(instance.getClass());
      }
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
      if (neoNode.getNode().hasLabel(Entities.Object))
         return new ObjectPanel(neoNode);
      return null;
   }

   private final class ObjectPanel extends JPanel {

      ObjectPanel(NeoNode objectNode) {
         super(new BorderLayout());

         final JTextArea txtEditor = new JTextArea(25, 85);
         txtEditor.setFont(new Font("Hack", Font.PLAIN, 15));
         txtEditor.setTabSize(3);
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
}