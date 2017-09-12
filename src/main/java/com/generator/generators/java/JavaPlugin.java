package com.generator.generators.java;

import com.generator.BaseDomainVisitor;
import com.generator.NeoModel;
import com.generator.app.App;
import com.generator.app.AppEvents;
import com.generator.app.AppMotif;
import com.generator.app.Workspace;
import com.generator.generators.domain.DomainPlugin;
import com.generator.generators.javareflection.BaseClassVisitor;
import com.generator.util.Reflect;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import javax.tools.DiagnosticCollector;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static com.generator.BaseDomainVisitor.getString;
import static com.generator.BaseDomainVisitor.hasLabel;
import static com.generator.NeoModel.getNameAndLabelsFrom;

/**
 * Created 12.09.17.
 */
public class JavaPlugin extends DomainPlugin {

   public enum Entities implements Label {
      Object
   }

   public enum Relations implements RelationshipType {

   }

   public enum Properties {

   }

   private final Map<String, Object> instanceMap = new LinkedHashMap<>();

   public JavaPlugin(App app) {
      super(app, "Java");
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
            final Object instance = new SourceToInstanceGenerator().newInstance(packageName + "." + name, pojoST, new DiagnosticCollector<>());

            // create Object-node for this instance, and use uuid for key in instance-map
            final Node node = getGraph().newNode(Entities.Object, AppMotif.Properties.name.name(), name);
            instanceMap.put(getString(node, NeoModel.TAG_UUID), instance);
            fireNodesLoaded(node);
         }
      });
   }

   @Override
   protected void handleNodeRightClick(JPopupMenu pop, Workspace.NodeCanvas.NeoNode neoNode, Set<Workspace.NodeCanvas.NeoNode> selectedNodes) {

      if (hasLabel(neoNode.getNode(), Entities.Object)) {

         // todo: nodeInstances will be null if restarting - needs to be cleaned-up
         final Object instance = instanceMap.get(getString(neoNode.getNode(), NeoModel.TAG_UUID));
         if (instance == null) return;

         new BaseClassVisitor() {
            @Override
            public void onClass(Package classPackage, String className, Class superClass) {
               System.out.println(className);
            }

            @Override
            public void onPublicMethod(Method method) {

               pop.add(new App.TransactionAction("Call " + method.getName(), app) {
                  @Override
                  protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                     final Parameter[] parameters = method.getParameters();
                     final Object[] args = new Object[parameters.length];

                     for (int i = 0; i < parameters.length; i++) {
                        Parameter parameter = parameters[i];

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
         }.visit(instance.getClass());
      }
   }

   @Override
   public void showEditorFor(Workspace.NodeCanvas.NeoNode neoNode, JTabbedPane tabbedPane) {
      if (neoNode.getNode().hasLabel(Entities.Object))
         tabbedPane.add(getNameAndLabelsFrom(neoNode.getNode()), new ObjectPanel(neoNode));
   }

   private final class ObjectPanel extends JPanel {

      ObjectPanel(Workspace.NodeCanvas.NeoNode objectNode) {
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

         final Object instance = instanceMap.get(BaseDomainVisitor.getString(node, NeoModel.TAG_UUID));
         if (instance == null) return "No instance for " + BaseDomainVisitor.getString(node, NeoModel.TAG_UUID);

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