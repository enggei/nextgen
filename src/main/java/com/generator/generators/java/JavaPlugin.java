package com.generator.generators.java;

import com.generator.BaseDomainVisitor;
import com.generator.NeoModel;
import com.generator.app.App;
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
import java.awt.event.ActionEvent;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

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
      menu.add(new App.TransactionAction("New instance", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            // todo this should come from traversers of the graph
            final JavaGroup.PojoST pojoST = new JavaGroup().newPojo().
                  setPackage("com.test").
                  setName("Hello").
                  addPropertiesValue(null, "String", "name").
                  addPropertiesValue(null, "String", "yolo").
                  addLexicalValue("name").
                  addLexicalValue("yolo");

            // compile source and create instance :
            final Object instance = new SourceToInstanceGenerator().newInstance("com.test.Hello", pojoST, new DiagnosticCollector<>());

            // create Object-node for this instance, and use uuid for key in instance-map
            final Node node = getGraph().newNode(Entities.Object);
            instanceMap.put(BaseDomainVisitor.getString(node, NeoModel.TAG_UUID), instance);
            fireNodesLoaded(node);
         }
      });
   }

   @Override
   protected void handleNodeRightClick(JPopupMenu pop, Workspace.NodeCanvas.NeoNode neoNode, Set<Workspace.NodeCanvas.NeoNode> selectedNodes) {

      if (BaseDomainVisitor.hasLabel(neoNode.getNode(), Entities.Object)) {

         // todo: nodeInstances will be null if restarting - needs to be cleaned-up
         final Object instance = instanceMap.get(BaseDomainVisitor.getString(neoNode.getNode(), NeoModel.TAG_UUID));
         if (instance == null) return;

         System.out.println(instance.toString());
         final Reflect pojoInstance = Reflect.on(instance);

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

                        } else {
                           System.out.println("\t" + parameter.getType().getName());
                           args[i] = parameter.getType().newInstance();
                        }

                     }

                     final Reflect result = pojoInstance.call(method.getName(), args);
                     System.out.println(result.isNull() ? "null" : result.toString());
                  }
               });
            }
         }.visit(instance.getClass());
      }
   }
}