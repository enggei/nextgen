package com.generator.generators.vertx;

import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.NeoPNode;
import org.neo4j.graphdb.Node;
import org.piccolo2d.event.PInputEvent;

import javax.swing.*;

/**
 * Created 28.05.17.
 */
public class VertxDomainImpl extends VertxDomain {

   @Override
   public void addToDomainMenu(PInputEvent event, NeoEditor editor, JMenu domainMenu) {
      domainMenu.add(editor.newAddNodeAction(Entities.RouterVerticle, Properties.name.name(), event));
   }

   @Override
   protected NeoPNode newRouterVerticlePNode(Node node, NeoEditor editor) {
      return new RouterVerticlePNode(node, editor) {
         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {
            super.showNodeActions(pop, event);
         }

         @Override
         public void showTargetActions(JPopupMenu pop, PInputEvent event) {
            super.showTargetActions(pop, event);
         }
      };
   }
}