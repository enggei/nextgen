package com.generator.generators.mysql;

import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.NeoPNode;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created 24.03.17.
 */
public class MysqlDomainImpl extends MysqlDomain {

   @Override
   public void addToDomainMenu(PInputEvent event, NeoEditor editor, JMenu domainMenu) {

      domainMenu.add(editor.newAddNodeAction(Entities.database, "name", event));
   }

   @Override
   protected NeoPNode newDatabasePNode(Node node, NeoEditor editor) {
      return new DatabasePNode(node, editor) {
         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {

            pop.add(editor.newAddNodeAction(Entities.table, "name", Relations.TABLE, this, event));

            super.showNodeActions(pop, event);
         }
      };
   }
}