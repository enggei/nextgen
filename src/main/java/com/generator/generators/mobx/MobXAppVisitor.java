package com.generator.generators.mobx;

import com.generator.app.App;
import com.generator.app.AppMotif;
import com.generator.generators.domain.DomainVisitor;
import com.generator.generators.project.ProjectPlugin;
import com.generator.util.NeoUtil;
import com.generator.util.StringUtil;
import org.neo4j.graphdb.Node;

import java.util.Stack;

/**
 * Created 22.09.17.
 */
public class MobXAppVisitor extends DomainVisitor<MobXGroup.MobXContainerST> {

   private final MobXGroup mobXGroup = new MobXGroup();
   private final Stack<MobXGroup.MobXContainerST> modelStack = new Stack<>();
   private String storeName;

   public MobXAppVisitor(Node visitorNode, App app) {
      super(true, visitorNode, app);
   }

   @Override
   public MobXGroup.MobXContainerST getResult() {
      return modelStack.peek();
   }

   @Override
   public void visitEntity(Node node) {

      if (!modelStack.isEmpty()) return;

      final MobXGroup.MobXContainerST modelST = mobXGroup.newMobXContainer().
            setName(NeoUtil.get(node, AppMotif.Properties.name.name()));

      modelST.addComponentsValue("material-ui/TextField", "TextField");
      modelST.addComponentsValue("material-ui/FlatButton", "FlatButton");
      modelST.addComponentsValue("material-ui/Card", "{Card, CardActions, CardHeader, CardMedia, CardTitle, CardText}");

      storeName = NeoUtil.get(node, AppMotif.Properties.name.name()) + "Store";
      modelST.setStore(storeName);

      modelST.addConstructorStatementsValue("this.props.ConfigStore.loadConfig();");
      modelST.addConstructorStatementsValue("this.handleSubmit = this.handleSubmit.bind(this);");

      modelST.addMethodDeclarationsValue("handleSubmit(event) {\n" +
            "    event.preventDefault();\n" +
            "    this.props." + storeName + ".saveConfig();\n" +
            "  }");


      modelST.setElement("<div>\n" +
            "        <Card expanded=\"true\">\n" +
            "            <CardHeader title=\"Scan settings\" subtitle=\"Settings for subnet-scan\" actAsExpander={false} showExpandableButton={false}/>\n" +
            "            <CardText>\n" +
            "              <form onSubmit={this.handleSubmit}>\n" +
            "                  <label> End port: <TextField value={this.props.ConfigStore.config.endPort} id=\"endPort\" onChange={this.handleEndPort} /> </label>\n" +
            "                  <br/>\n" +
            "                  <label> CidrIps: <TextField value={this.props.ConfigStore.config.cidrIps} id=\"cidrIps\" onChange={this.handleCidrIps}/> </label>\n" +
            "                  <br/>\n" +
            "                  <label> StartPort: <TextField value={this.props.ConfigStore.config.startPort} id=\"startPort\" onChange={this.handleStartPort}/> </label>\n" +
            "                  <br/>\n" +
            "                  <label> IpTimeout: <TextField value={this.props.ConfigStore.config.ipTimeout} id=\"ipTimeout\" onChange={this.handleIpTimeout}/> </label>\n" +
            "                  <br/>\n" +
            "                  <label> Threads: <TextField value={this.props.ConfigStore.config.nThreads} id=\"nThreads\" onChange={this.handleThreads}/> </label>\n" +
            "                  <br/>\n" +
            "                  <label> PortTimeout: <TextField value={this.props.ConfigStore.config.portTimeout} id=\"portTimeout\" onChange={this.handlePortTimeout}/> </label>\n" +
            "                  <br/>\n" +
            "                  <label> ScanTimeout: <TextField value={this.props.ConfigStore.config.scanTimeout} id=\"scanTimeout\" onChange={this.handleScanTimeout}/> </label>\n" +
            "                  <br/>\n" +
            "                  <label> Mask: <TextField value={this.props.ConfigStore.config.mask} id=\"mask\" onChange={this.handleMask}/> </label>\n" +
            "                  <br/>\n" +
            "\n" +
            "              </form>\n" +
            "            </CardText>\n" +
            "            <CardActions>\n" +
            "              <FlatButton label=\"Save\" type=\"submit\" value=\"Submit\" backgroundColor=\"#000000\" labelStyle={{color: '#ffffff'}}/>\n" +
            "            </CardActions>\n" +
            "          </Card>\n" +
            "        </div>");


      modelStack.push(modelST);
      super.visitEntity(node);

      NeoUtil.outgoing(visitorNode, ProjectPlugin.Relations.RENDERER).forEach(relationship -> ProjectPlugin.renderToFile(relationship, null, modelST.toString(), NeoUtil.other(visitorNode, relationship), app));
   }

   @Override
   public void visitProperty(Node node) {
      super.visitProperty(node);

      final String propertyName = NeoUtil.get(node, AppMotif.Properties.name.name());

      modelStack.peek().addConstructorStatementsValue("this.handle" + StringUtil.capitalize(propertyName) + " = this.handle" + StringUtil.capitalize(propertyName) + ".bind(this);");
      modelStack.peek().addMethodDeclarationsValue("handle" + StringUtil.capitalize(propertyName) + "(event) { this.props." + storeName + ".config." + propertyName + " = event.target.value; }");
   }
}