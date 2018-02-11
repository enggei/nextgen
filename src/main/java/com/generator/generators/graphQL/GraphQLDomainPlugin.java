package com.generator.generators.graphQL;

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
 * Auto-generated from domain GraphQLDomainPlugin
 */
public abstract class GraphQLDomainPlugin extends Plugin {

	protected final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(GraphQLDomainPlugin.class);

	public enum Entities implements Label {
   }

   public enum Relations implements RelationshipType {
   }

   public enum Properties {
   }

	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

	private final Node domainNode;

   GraphQLDomainPlugin(App app) {
      super(app, "GraphQL");

		domainNode = DomainMotif.newDomainNode(getGraph(), "GraphQL");


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