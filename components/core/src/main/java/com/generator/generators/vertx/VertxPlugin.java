package com.generator.generators.vertx;

import com.generator.app.App;
import com.generator.app.nodes.NeoNode;
import com.generator.generators.maven.MavenPlugin;
import com.generator.generators.project.ProjectPlugin;
import com.generator.util.FileUtil;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.*;

/**
 * Created 05.12.17.
 */
public class VertxPlugin extends VertxDomainPlugin {

   private final Map<String, TcpBridgeServerSession> sessionMap = new LinkedHashMap<>();

   public VertxPlugin(App app) {
      super(app);
   }

   @Override
   protected void addActionsTo(JMenu menu) {

      addShowMenu(menu, Entities.Application);

      menu.add(new App.TransactionAction("New Application", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String projectName = SwingUtil.showInputDialog("Name", app);
            if (projectName.length() == 0) return;

            final File dir = SwingUtil.showOpenDir(app, System.getProperty("user.home"));
            if (dir == null || !dir.exists()) return;

            final File tmpDir = new File(dir, projectName);
            if (tmpDir.exists()) {
               SwingUtil.showMessage("Project directory " + tmpDir.getAbsolutePath() + " already exists", app);
               return;
            }

            final File projectDir = FileUtil.tryToCreateDirIfNotExists(tmpDir);
            if (!projectDir.exists()) {
               SwingUtil.showMessage("Could not create " + projectDir.getAbsolutePath(), app);
               return;
            }

            final Node applicationNode = newApplication(projectName);
            final Node directoryNode = ProjectPlugin.newDirectory(getGraph(), projectName, projectDir.getAbsolutePath());
            ProjectPlugin.relateRENDERER(directoryNode, applicationNode);

            final Node pomNode = MavenPlugin.newPOM(getGraph());
            MavenPlugin.relatePROPERTIES(pomNode, MavenPlugin.newproperty(getGraph(), "project.build.sourceEncoding", "UTF-8"));
            MavenPlugin.relatePROPERTIES(pomNode, MavenPlugin.newproperty(getGraph(), "project.reporting.outputEncoding", "UTF-8"));
            MavenPlugin.relatePROPERTIES(pomNode, MavenPlugin.newproperty(getGraph(), "maven.compiler.source", "1.8"));
            MavenPlugin.relatePROPERTIES(pomNode, MavenPlugin.newproperty(getGraph(), "maven.compiler.target", "1.8"));
            MavenPlugin.relatePROPERTIES(pomNode, MavenPlugin.newproperty(getGraph(), "vertx.version", "3.3.0"));

            MavenPlugin.relateDEPENDENCIES(pomNode, MavenPlugin.newDependency(getGraph(), "io.vertx", "vertx-core", "${vertx.version}", null, null, null));
            MavenPlugin.relateDEPENDENCIES(pomNode, MavenPlugin.newDependency(getGraph(), "io.vertx", "vertx-web", "${vertx.version}", null, null, null));
            MavenPlugin.relateDEPENDENCIES(pomNode, MavenPlugin.newDependency(getGraph(), "io.dropwizard.metrics", "metrics-core", "3.1.2", null, null, null));
            MavenPlugin.relateDEPENDENCIES(pomNode, MavenPlugin.newDependency(getGraph(), "io.vertx", "vertx-dropwizard-metrics", "${vertx.version}", null, null, null));

            MavenPlugin.relateDEPENDENCIES(pomNode, MavenPlugin.newDependency(getGraph(), "org.pac4j", "vertx-pac4j", "2.0.1", null, null, null));
            MavenPlugin.relateDEPENDENCIES(pomNode, MavenPlugin.newDependency(getGraph(), "io.vertx", "vertx-auth-oauth2", "3.3.0", null, null, null));
            MavenPlugin.relateDEPENDENCIES(pomNode, MavenPlugin.newDependency(getGraph(), "log4j", "log4j", "1.2.17", null, null, null));
            MavenPlugin.relateDEPENDENCIES(pomNode, MavenPlugin.newDependency(getGraph(), "org.neo4j", "neo4j", "3.1.0-M03", null, null, null));
            MavenPlugin.relateDEPENDENCIES(pomNode, MavenPlugin.newDependency(getGraph(), "org.neo4j", "neo4j-cypher", "3.1.0-M03", null, null, null));

            final Node ramlDependency = MavenPlugin.newDependency(getGraph(), "guru.nidi.raml", "raml-tester", "0.8.4", null, "test", null);
            MavenPlugin.relateEXCLUSIONS(ramlDependency, MavenPlugin.newExclusion(getGraph(), "com.fasterxml.jackson.core", "jackson-core"));
            MavenPlugin.relateEXCLUSIONS(ramlDependency, MavenPlugin.newExclusion(getGraph(), "com.fasterxml.jackson.core", "jackson-databind"));
            MavenPlugin.relateDEPENDENCIES(pomNode, ramlDependency);

            MavenPlugin.relateDEPENDENCIES(pomNode, MavenPlugin.newDependency(getGraph(), "io.vertx", "vertx-unit", "3.0.0", null, "test", null));
            MavenPlugin.relateDEPENDENCIES(pomNode, MavenPlugin.newDependency(getGraph(), "junit", "junit", "4.12", null, "test", null));
            MavenPlugin.relateDEPENDENCIES(pomNode, MavenPlugin.newDependency(getGraph(), "com.jayway.restassured", "rest-assured", "2.4.0", null, "test", null));
            MavenPlugin.relateDEPENDENCIES(pomNode, MavenPlugin.newDependency(getGraph(), "org.assertj", "assertj-core", "2.0.0", null, "test", null));
            MavenPlugin.relateDEPENDENCIES(pomNode, MavenPlugin.newDependency(getGraph(), "org.jboss.resteasy", "resteasy-client", "3.0.6.Final", null, "test", null));
            MavenPlugin.relateDEPENDENCIES(pomNode, MavenPlugin.newDependency(getGraph(), "com.github.dpaukov", "combinatoricslib3", "3.0.0", null, "test", null));

            ProjectPlugin.relateRENDERER(directoryNode, pomNode);

            final Node baseBuildNode = MavenPlugin.newBaseBuild(getGraph());
            MavenPlugin.relateBASEBUILD(pomNode, baseBuildNode);

            final Node testResource = MavenPlugin.newTestResource(getGraph());
            MavenPlugin.relateKEYVALUE(testResource, MavenPlugin.newKeyValue(getGraph(), "directory", "src/test/resources"));
            MavenPlugin.relateKEYVALUE(testResource, MavenPlugin.newKeyValue(getGraph(), "filtering", "true"));
            MavenPlugin.relateTEST_RESOURCE(baseBuildNode, testResource);

            FileUtil.write(MavenPlugin.renderPOM(pomNode), new File(projectDir, "pom.xml"));

            final Set<Node> nodes = new LinkedHashSet<>();
            nodes.add(applicationNode);
            nodes.add(directoryNode);
            nodes.add(pomNode);

            fireNodesLoaded(nodes);
         }
      });
   }

   @Override
   protected void handleTcpBridgeServer(JPopupMenu pop, NeoNode tcpBridgeServerNode, Set<NeoNode> selectedNodes) {

      pop.add(new App.TransactionAction("Connect", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String sessionID = UUID.randomUUID().toString();
            final Node sessionNode = newTcpBridgeHost(sessionID);
            relateSESSION(tcpBridgeServerNode.getNode(), sessionNode);
            sessionMap.put(sessionID, new TcpBridgeServerSession(sessionNode));
            fireNodesLoaded(sessionNode);
         }
      });

   }

   @Override
   protected void handleTcpBridgeHost(JPopupMenu pop, NeoNode tcpBridgeHostNode, Set<NeoNode> selectedNodes) {

      final TcpBridgeServerSession tcpBridgeServerSession = sessionMap.get(getUuidProperty(tcpBridgeHostNode.getNode(), ""));
      if(tcpBridgeServerSession==null) return;
   }

   private final class TcpBridgeServerSession {

      private final String host;
      private final Integer port;

      TcpBridgeServerSession(Node sessionNode) {

         host = getHostProperty(singleIncomingSESSION(sessionNode));
         port = Integer.valueOf(getPortProperty(singleIncomingSESSION(sessionNode)));

      }
   }
}