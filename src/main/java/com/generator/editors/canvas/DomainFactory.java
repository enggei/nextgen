package com.generator.editors.canvas;

import com.generator.editors.NeoModel;
import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.NeoPNode;
import com.generator.editors.canvas.neo.NeoPTextNode;
import com.generator.generators.meta.MetaDomain;
import com.generator.generators.project.ProjectDomain;
import com.generator.generators.templates.editor.TemplateDomain;
import org.neo4j.graphdb.Node;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

import static com.generator.editors.NeoModel.uuidOf;

/**
 * Created 19.01.17.
 */
public class DomainFactory {

   public static DomainFactory newTestFactory() {
      return new DomainFactory();
   }

   public NeoPNode newNode(Node node, String nodetype, NeoEditor neoEditor) {

      if (nodetype == null) {
         System.out.println("null nodetype");
         return new NeoPTextNode(node, neoEditor);
      }

      Set<UUID> set = neoEditor.nodesByLabel.get(nodetype);
      if(set==null) neoEditor.nodesByLabel.put(nodetype, set = new LinkedHashSet<>());
      set.add(uuidOf(node));

      for (MetaDomain.LABELS label : MetaDomain.LABELS.values()) {
         if (nodetype.equals(label.name())) {
            return MetaDomain.newPNode(node, nodetype, neoEditor);
         }
      }

      for (TemplateDomain.TemplateLabels templateLabels : TemplateDomain.TemplateLabels.values()) {
         if (nodetype.equals(templateLabels.name())) {
            return TemplateDomain.newPNode(node, nodetype, neoEditor);
         }
      }

      for (ProjectDomain.LABELS label : ProjectDomain.LABELS.values()) {
         if (nodetype.equals(label.name())) {
            return ProjectDomain.newPNode(node, nodetype, neoEditor);
         }
      }

      throw new IllegalArgumentException("nodetype " + nodetype + " is unsupported for node " + NeoModel.debugNode(node));
   }
}