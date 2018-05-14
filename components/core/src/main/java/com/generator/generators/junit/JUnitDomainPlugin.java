package com.generator.generators.junit;

import com.generator.app.App;
import com.generator.app.DomainMotif;
import com.generator.app.Plugin;
import com.generator.app.nodes.NeoNode;
import com.generator.generators.domain.DomainPlugin;
import com.generator.neo.NeoModel;
import org.neo4j.graphdb.*;

import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static com.generator.util.NeoUtil.*;

/**
 * Auto-generated from domain JUnitDomainPlugin
 */
public abstract class JUnitDomainPlugin extends Plugin {

	protected final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(JUnitDomainPlugin.class);

	public enum Entities implements Label {
   }

   public enum Relations implements RelationshipType {
   }

   public enum Properties {
   }

	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

	private final Node domainNode;

   JUnitDomainPlugin(App app) {
      super(app, "JUnit");

		domainNode = DomainMotif.newDomainNode(getGraph(), "JUnit");


   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
      return null;
   }

	public Node getDomainNode() { return domainNode; }

	public Node getEntityNode(Label label) { return entitiesNodeMap.get(label); }

	






}