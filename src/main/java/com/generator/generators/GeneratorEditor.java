package com.generator.generators;

import com.generator.editors.NeoModel;
import com.generator.editors.canvas.BaseNodeRenderPanel;
import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.NeoPNode;
import com.generator.editors.canvas.neo.NeoPTextNode;
import com.generator.generators.easyFlow.EasyFlowDomain;
import com.generator.generators.html5.Html5Domain;
import com.generator.generators.java.JavaDomain;
import com.generator.generators.meta.MetaDomain;
import com.generator.generators.project.ProjectDomain;
import com.generator.generators.templates.TemplateDomain;
import com.generator.generators.vertx.VertxDomain;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Node;
import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

import static com.generator.editors.NeoModel.uuidOf;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * Created 23.02.17.
 */
public class GeneratorEditor extends NeoEditor {

   GeneratorEditor() {
      super();
      canvas.setBackground(new Color(Integer.valueOf("247, 247, 247".split(", ")[0]), Integer.valueOf("247, 247, 247".split(", ")[1]), Integer.valueOf("247, 247, 247".split(", ")[2])));

      for (TemplateDomain.Entities label : TemplateDomain.Entities.values())
         nodesByLabel.put(label.name(), new LinkedHashSet<>());

      for (ProjectDomain.Entities label : ProjectDomain.Entities.values())
         nodesByLabel.put(label.name(), new LinkedHashSet<>());

      for (JavaDomain.Entities label : JavaDomain.Entities.values())
         nodesByLabel.put(label.name(), new LinkedHashSet<>());

      for (MetaDomain.Entities label : MetaDomain.Entities.values())
         nodesByLabel.put(label.name(), new LinkedHashSet<>());

      for (EasyFlowDomain.Entities label : EasyFlowDomain.Entities.values())
         nodesByLabel.put(label.name(), new LinkedHashSet<>());

      for (VertxDomain.Entities label : VertxDomain.Entities.values())
         nodesByLabel.put(label.name(), new LinkedHashSet<>());
   }

   @Override
   protected NeoPNode newNode(Node node, String nodetype) {

      if (nodetype == null) {
         System.out.println("null nodetype");
         return new NeoPTextNode(node, this);
      }

      Set<UUID> set = nodesByLabel.get(nodetype);
      if (set == null) nodesByLabel.put(nodetype, set = new LinkedHashSet<>());
      set.add(uuidOf(node));

      for (MetaDomain.Entities label : MetaDomain.Entities.values()) {
         if (nodetype.equals(label.name())) {
            return MetaDomain.newPNode(node, nodetype, this);
         }
      }

      for (TemplateDomain.Entities entities : TemplateDomain.Entities.values()) {
         if (nodetype.equals(entities.name())) {
            return TemplateDomain.newPNode(node, nodetype, this);
         }
      }

      for (JavaDomain.Entities entities : JavaDomain.Entities.values()) {
         if (nodetype.equals(entities.name())) {
            return JavaDomain.newPNode(node, nodetype, this);
         }
      }

      for (ProjectDomain.Entities label : ProjectDomain.Entities.values()) {
         if (nodetype.equals(label.name())) {
            return ProjectDomain.newPNode(node, nodetype, this);
         }
      }

      for (EasyFlowDomain.Entities label : EasyFlowDomain.Entities.values()) {
         if (nodetype.equals(label.name())) {
            return EasyFlowDomain.newPNode(node, nodetype, this);
         }
      }

      for (Html5Domain.Entities label : Html5Domain.Entities.values()) {
         if (nodetype.equals(label.name())) {
            return Html5Domain.newPNode(node, nodetype, this);
         }
      }

      for (VertxDomain.Entities label : VertxDomain.Entities.values()) {
         if (nodetype.equals(label.name())) {
            return VertxDomain.newPNode(node, nodetype, this);
         }
      }

      throw new IllegalArgumentException("nodetype " + nodetype + " is unsupported for node " + NeoModel.debugNode(node));
   }

   @Override
   public void deleteNode(Node node) throws ReferenceException {

      final String deleteLabel = node.getLabels().iterator().next().name();// assumes first (and only?) label is the node's label

      for (TemplateDomain.Entities label : TemplateDomain.Entities.values())
         if (label.name().equals(deleteLabel)) {
            TemplateDomain.deleteNode(node);
            return;
         }

      for (ProjectDomain.Entities label : ProjectDomain.Entities.values())
         if (label.name().equals(deleteLabel)) {
            ProjectDomain.deleteNode(node);
            return;
         }

      for (JavaDomain.Entities label : JavaDomain.Entities.values())
         if (label.name().equals(deleteLabel)) {
            JavaDomain.deleteNode(node);
            return;
         }

      for (EasyFlowDomain.Entities label : EasyFlowDomain.Entities.values())
         if (label.name().equals(deleteLabel)) {
            EasyFlowDomain.deleteNode(node);
            return;
         }

      for (Html5Domain.Entities label : Html5Domain.Entities.values())
         if (label.name().equals(deleteLabel)) {
            Html5Domain.deleteNode(node);
            return;
         }

      for (MetaDomain.Entities label : MetaDomain.Entities.values())
         if (label.name().equals(deleteLabel)) {
            MetaDomain.deleteNode(node);
            return;
         }

         for (VertxDomain.Entities label : VertxDomain.Entities.values())
         if (label.name().equals(deleteLabel)) {
            VertxDomain.deleteNode(node);
            return;
         }
   }

   @Override
   protected void addToMenu(JPopupMenu pop, PInputEvent event) {
      TemplateDomain.addToMenu(pop, event, this);
      EasyFlowDomain.addToMenu(pop, event, this);
      MetaDomain.addToMenu(pop, event, this);
      JavaDomain.addToMenu(pop, event, this);
      ProjectDomain.addToMenu(pop, event, this);
      Html5Domain.addToMenu(pop, event, this);
      VertxDomain.addToMenu(pop, event, this);
      super.addToMenu(pop, event);
   }

   public static void main(String[] args) {

      SwingUtil.setLookAndFeel_Nimbus();

      final JFrame frame = new JFrame();
      final GeneratorEditor contentPanel = new GeneratorEditor();
      final BaseNodeRenderPanel renderPanel = new BaseNodeRenderPanel();
      contentPanel.addPropertyChangeListener(renderPanel);

      frame.getContentPane().add(contentPanel.getCanvas(), BorderLayout.CENTER);
      frame.getContentPane().add(new JScrollPane(renderPanel), BorderLayout.EAST);
      frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
      frame.addWindowFocusListener(new WindowAdapter() {
         @Override
         public void windowGainedFocus(WindowEvent e) {
            contentPanel.getCanvas().requestFocusInWindow();
         }
      });

      SwingUtil.show(frame);
   }
}