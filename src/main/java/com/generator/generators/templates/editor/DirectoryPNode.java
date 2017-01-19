package com.generator.generators.templates.editor;

import com.generator.editors.NeoModel;
import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;
import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.*;

import static com.generator.editors.BaseDomainVisitor.*;
import static com.generator.editors.NeoModel.uuidOf;
import static com.generator.generators.templates.editor.TemplateDomain.TemplateLabels.Directory;
import static com.generator.generators.templates.editor.TemplateDomain.TemplateLabels.Statement;
import static com.generator.generators.templates.editor.TemplateDomain.TemplateRelations.DIRECTORY_MEMBER;
import static com.generator.generators.templates.editor.TemplateDomain.TemplateRelations.TEMPLATE_STATEMENT;
import static org.neo4j.graphdb.Direction.INCOMING;

/**
 * Created 10.01.17.
 */
class DirectoryPNode extends TemplateDomainPNode {

   DirectoryPNode(Node node, NeoEditor editor) {
      super(node, Directory, TemplateDomain.TemplateProperties.name.name(), "153, 52, 4".split(", "), editor);
      pNode.setFont(new Font("Hack", Font.BOLD, 12));
   }

   @Override
   public void expand() {

      final Map<UUID, org.neo4j.graphdb.Label> pNodes = new LinkedHashMap<>();

      outgoing(node, DIRECTORY_MEMBER).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), TemplateDomain.TemplateLabels.Statement));

      editor.showAndLayout(pNodes, pNode);
   }

   @Override
   public void showDependents() {
      final Map<UUID, org.neo4j.graphdb.Label> pNodes = new LinkedHashMap<>();

      for (Relationship relationship : node.getRelationships(INCOMING)) {
         if (NeoEditor.isAppRelated(relationship)) continue;
         final Node other = other(node, relationship);
         if (hasLabel(other, TemplateDomain.TemplateLabels.Project.name()))
            pNodes.put(uuidOf(other(node, relationship)), TemplateDomain.TemplateLabels.Project);
         else
            System.out.println(other.getLabels().iterator().next());
      }

      editor.showAndLayout(pNodes, pNode);
   }

   @Override
   public void showNodeActions(JPopupMenu pop, PInputEvent event) {
      pop.add(new Render());
      pop.add(new CopyPath());
      pop.add(new SetPath());

      outgoing(node, DIRECTORY_MEMBER).forEach(relationship -> {
         final Node statementNode = other(node, relationship);
         pop.add(new NeoEditor.TransactionAction("Detach " + NeoModel.getNameOrLabelFrom(statementNode), editor.getGraph(), editor.canvas) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               relationship.delete();
            }
         });

      });

      super.showNodeActions(pop, event);
   }

   @Override
   public void showTargetActions(JPopupMenu pop, PInputEvent event) {

      editor.getSelectedNodes().
            stream().
            filter(selectedPNode -> selectedPNode.node.hasLabel(Statement)).
            forEach(selectedPNode -> setFileTypes(selectedPNode.node));

      SwingUtilities.invokeLater(editor.canvas::repaint);
   }

   private void setFileTypes(Node statementNode) {

      final String outputFormat = SwingUtil.showSelectDialog(editor.canvas, "Output format", "File outputFormat", Arrays.asList("java", "other"));
      if (outputFormat == null) return;

      switch (outputFormat) {

         case "java": {

            final Set<String> paramsName = new TreeSet<>();
            new TemplateGroupVisitor() {
               @Override
               protected void onSingleTemplateParameter(String name, Node parameterNode) {
                  paramsName.add(name);
               }
            }.visitTemplateStatement(other(statementNode, singleOutgoing(statementNode, TEMPLATE_STATEMENT)));

            final String packageParam = SwingUtil.showSelectDialog(editor.canvas, "Package", "Select parameter value", paramsName);
            if (packageParam == null) return;

            final String classnameParam = SwingUtil.showSelectDialog(editor.canvas, "Classname", "Select parameter value", paramsName);
            if (classnameParam == null) return;

            if (isRelated(node, statementNode, DIRECTORY_MEMBER))
               setRenderJavaFile(packageParam, classnameParam, getRelationship(node, statementNode, DIRECTORY_MEMBER));
            else
               editor.addRelation(setRenderJavaFile(packageParam, classnameParam, node.createRelationshipTo(statementNode, DIRECTORY_MEMBER)));
            break;
         }

         case "other": {

            final String filename = SwingUtil.showInputDialog("Filename, with extension", editor.canvas);
            if (filename == null) return;

            if (isRelated(node, statementNode, DIRECTORY_MEMBER))
               setRenderOtherFile(filename, getRelationship(node, statementNode, DIRECTORY_MEMBER));
            else
               editor.addRelation(setRenderOtherFile(filename, node.createRelationshipTo(statementNode, DIRECTORY_MEMBER)));
            break;
         }
      }
   }

   private static Relationship setRenderOtherFile(String filename, Relationship newRelation) {
      newRelation.setProperty(TemplateDomain.TemplateProperties.outputFormat.name(), "other");
      newRelation.setProperty(TemplateDomain.TemplateProperties.name.name(), filename);
      return newRelation;
   }

   private static Relationship setRenderJavaFile(String packageParam, String classnameParam, Relationship newRelation) {
      newRelation.setProperty(TemplateDomain.TemplateProperties.outputFormat.name(), "java");
      newRelation.setProperty(TemplateDomain.TemplateProperties.packageName.name(), packageParam);
      newRelation.setProperty(TemplateDomain.TemplateProperties.name.name(), classnameParam);
      return newRelation;
   }

   private class SetPath extends NeoEditor.TransactionAction {

      SetPath() {
         super("Set path ", editor.getGraph(), editor.canvas);
      }

      @Override
      public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

         final File dir = SwingUtil.showOpenDir(editor.canvas, getString(node, TemplateDomain.TemplateProperties.name.name()));
         if (dir == null) return;

         node.setProperty(TemplateDomain.TemplateProperties.name.name(), dir.getAbsolutePath());

         updateView();
      }
   }

   private class CopyPath extends NeoEditor.TransactionAction {

      CopyPath() {
         super("Copy path ", editor.getGraph(), editor.canvas);
      }

      @Override
      public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
         SwingUtil.toClipboard(getString(node, TemplateDomain.TemplateProperties.name.name()));
      }
   }

   private class Render extends NeoEditor.TransactionAction {

      public Render() {
         super("Render", editor.getGraph(), editor.canvas);
      }

      @Override
      public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
         TemplateDomain.renderProjectMember(node, editor.canvas);
      }
   }
}
