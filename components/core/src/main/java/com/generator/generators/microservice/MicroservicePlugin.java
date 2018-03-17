package com.generator.generators.microservice;

import com.generator.app.App;
import com.generator.app.nodes.NeoNode;
import com.generator.generators.java.JavaGroup;
import com.generator.generators.mobx.MobXGroup;
import com.generator.generators.stringtemplate.GeneratedFile;
import com.generator.generators.vertx.VertxGroup;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.Set;

/**
 * Created 31.01.18.
 */
public class MicroservicePlugin extends MicroserviceDomainPlugin {

   private final JavaGroup javaGroup = new JavaGroup();
   private final MobXGroup mobXGroup = new MobXGroup();
   private final VertxGroup vertxGroup = new VertxGroup();

   public MicroservicePlugin(App app) {
      super(app);
   }

   @Override
   protected void addActionsTo(JMenu menu) {

      addShowMenu(menu, Entities.Service);

      menu.add(new App.TransactionAction("New Service", app) {
         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String name = SwingUtil.showInputDialog("Name", app);
            if (name == null || name.length() == 0) return;

            fireNodesLoaded(newService("1", name, null, null));
         }
      });
   }

   @Override
   protected void handleService(JPopupMenu pop, NeoNode serviceNode, Set<NeoNode> selectedNodes) {

      if (hasRootProperty(serviceNode.getNode())) {
         pop.add(new App.TransactionAction("Generate", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final String serviceName = getNameProperty(serviceNode.getNode());
               final String packageName = getPackageNameProperty(serviceNode.getNode());
               final String javaSrc = new File(getRootProperty(serviceNode.getNode()).toString(), "src/main/java").getAbsolutePath();
               final String webSrc = new File(getRootProperty(serviceNode.getNode()).toString(), "src/main/web").getAbsolutePath();

               // generate pojos:
               outgoingDOMAINENTITY(serviceNode.getNode(), (relationship, entityNode) -> {

                  final String nameProperty = getNameProperty(entityNode);

                  JavaGroup.PojoST currentPojo = javaGroup.newPojo().
                        setPackage(packageName).
                        setName(nameProperty);

                  currentPojo.setJson("true");
                  currentPojo.setNeoNode("true");

                  outgoingPROPERTY(entityNode, (relationship1, propertyNode) -> {

                     currentPojo.addPropertiesValue(getDefaultValueProperty(propertyNode), getTypeProperty(propertyNode), getNameProperty(propertyNode), null,null,null, false);

                     if ("true".equals(getIsEqhaProperty(propertyNode)))
                        currentPojo.addEqhaValue(getNameProperty(propertyNode));
                     if ("true".equals(getIsLexicalProperty(propertyNode)))
                        currentPojo.addLexicalValue(getNameProperty(propertyNode));
                  });

                  try {
                     GeneratedFile.newJavaFile(javaSrc, packageName, nameProperty).write(currentPojo);
                  } catch (IOException e1) {
                     SwingUtil.showException(app, e1);
                  }
               });

               // generate verticle-endpoint:
               final VertxGroup.RESTVerticleST restVerticleST = vertxGroup.newRESTVerticle().
                     setPackageName(packageName).
                     setName(serviceName);

               outgoingENDPOINT(serviceNode.getNode(), (relationship, endpointNode) -> {

                  final String endpointName = getNameProperty(endpointNode);
                  final String uri = getUriProperty(endpointNode);
                  final String action = getActionProperty(endpointNode);

                  final String versionedURI = "/" + getVersionProperty(serviceNode.getNode(), "1") + (uri.startsWith("/") ? uri : ("/" + uri));

//                  restVerticleST.addEndpointsValue(endpointName, versionedURI, action);
               });

               outgoingMESSAGE(serviceNode.getNode(), (relationship, messageNode) -> {

                  final String address = getAddressProperty(messageNode);
                  final String name = getNameProperty(messageNode);

                  restVerticleST.addEventsValue(null,address, name);
               });

               try {
                  GeneratedFile.newJavaFile(javaSrc, packageName, serviceName).write(restVerticleST);
               } catch (IOException e1) {
                  SwingUtil.showException(app, e1);
               }

               // generate MobX-models
               outgoingDOMAINENTITY(serviceNode.getNode(), (relationship, entityNode) -> {

                  final String nameProperty = getNameProperty(entityNode);

                  final MobXGroup.ModelST modelST = mobXGroup.newModel().
                        setName(nameProperty);

                  outgoingPROPERTY(entityNode, (relationship1, propertyNode) -> modelST.addObservablesValue(getDefaultValueProperty(propertyNode), getNameProperty(propertyNode)));

                  try {
                     GeneratedFile.newPlainFile(webSrc, packageName, nameProperty + ".js").write(modelST);
                  } catch (IOException e1) {
                     SwingUtil.showException(app, e1);
                  }
               });

               // generate Database
               outgoingPERSISTENCE(serviceNode.getNode(), (databaseRelation, databaseNode) -> {

                  final String dbName = getNameProperty(databaseNode);
                  final VertxGroup.NeoVerticleST neoVerticleST = vertxGroup.newNeoVerticle().
                        setName(dbName).
                        setPackageName(packageName);

                  outgoingACTION(databaseNode, (actionRelation, actionNode) -> neoVerticleST.addActionsValue(getAddressProperty(actionNode), getNameProperty(actionNode)));

                  // linking domain-entities to persist in the database
                  incomingPERSISTENCE(databaseNode, (persistenceRelation, entityNode) -> {
                     System.out.println("Entity " + getNameProperty(entityNode) + ":");
                     outgoingPROPERTY(entityNode, (propertyRelation, propertyNode) -> System.out.println("\t" + getNameProperty(propertyNode)));
                  });

                  try {
                     GeneratedFile.newJavaFile(javaSrc, packageName, dbName).write(neoVerticleST);
                  } catch (IOException e1) {
                     SwingUtil.showException(app, e1);
                  }
               });
            }
         });
      }
   }
}