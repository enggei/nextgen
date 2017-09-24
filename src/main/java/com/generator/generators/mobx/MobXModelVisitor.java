package com.generator.generators.mobx;

import com.generator.app.App;
import com.generator.app.AppMotif;
import com.generator.generators.domain.DomainVisitor;
import com.generator.generators.project.ProjectPlugin;
import com.generator.util.NeoUtil;
import org.neo4j.graphdb.Node;

import java.util.Stack;

/**
 * Created 20.09.17.
 */
public class MobXModelVisitor extends DomainVisitor {

   private final MobXGroup mobXGroup = new MobXGroup();
   private final Stack<MobXGroup.ModelST> modelStack = new Stack<>();

   public MobXModelVisitor(Node visitorNode, App app) {
      super(true, visitorNode, app);
   }

   @Override
   public void visitEntity(Node node) {

      if(!modelStack.isEmpty()) return;
      System.out.println("MobX Entity " + NeoUtil.getNameAndLabelsFrom(node));

      final MobXGroup.ModelST modelST = mobXGroup.newModel().
            setName(NeoUtil.get(node, AppMotif.Properties.name.name()));
      modelStack.push(modelST);
      super.visitEntity(node);

      NeoUtil.outgoing(visitorNode, ProjectPlugin.Relations.RENDERER).forEach(relationship -> ProjectPlugin.renderToFile(relationship, null, modelST.toString(), NeoUtil.other(visitorNode, relationship), app));
      System.out.println(modelST);
   }

   @Override
   public void visitProperty(Node node) {
      System.out.println("MobX Property " + NeoUtil.getNameAndLabelsFrom(node));
      super.visitProperty(node);

      modelStack.peek().addObservablesValue(null, NeoUtil.get(node, AppMotif.Properties.name.name()));
   }
}