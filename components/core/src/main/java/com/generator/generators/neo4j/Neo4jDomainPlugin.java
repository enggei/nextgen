package com.generator.generators.neo4j;

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
 * Auto-generated from domain Neo4jDomainPlugin
 */
public abstract class Neo4jDomainPlugin extends Plugin {

	protected final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Neo4jDomainPlugin.class);

	public enum Entities implements Label {
      NeoDomain, NeoRelation, NeoEntity, NeoProperty, PropertyEnum, NeoFunction
   }

   public enum Relations implements RelationshipType {
      NEODOMAIN, RELATIONS, NAME, CARDINALITY, SRC, ENTITY_PROPERTIES, ISREQUIRED, TYPE, PROPERTYENUMS, ISUNIQUE, DST, RELATION_PROPERTIES, PACKAGENAME, DESCRIPTION, ENTITIES, ROOT, FUNCTIONS, FUNCTION_PROPERTIES
   }

   public enum Properties {
      name, cardinality, isRequired, type, isUnique, packageName, description, root
   }

	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

	private final Node domainNode;

   Neo4jDomainPlugin(App app) {
      super(app, "Neo4j");

		domainNode = DomainMotif.newDomainNode(getGraph(), "Neo4j");
		entitiesNodeMap.put(Entities.NeoDomain, DomainMotif.newDomainEntity(getGraph(), Entities.NeoDomain, domainNode));
		entitiesNodeMap.put(Entities.NeoRelation, DomainMotif.newDomainEntity(getGraph(), Entities.NeoRelation, domainNode));
		entitiesNodeMap.put(Entities.NeoEntity, DomainMotif.newDomainEntity(getGraph(), Entities.NeoEntity, domainNode));
		entitiesNodeMap.put(Entities.NeoProperty, DomainMotif.newDomainEntity(getGraph(), Entities.NeoProperty, domainNode));
		entitiesNodeMap.put(Entities.PropertyEnum, DomainMotif.newDomainEntity(getGraph(), Entities.PropertyEnum, domainNode));
		entitiesNodeMap.put(Entities.NeoFunction, DomainMotif.newDomainEntity(getGraph(), Entities.NeoFunction, domainNode));

		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.NeoDomain), Properties.packageName.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.NeoDomain), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.NeoDomain), Properties.description.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.NeoDomain), Properties.root.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.NeoRelation), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.NeoRelation), Properties.cardinality.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.NeoEntity), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.NeoProperty), Properties.isRequired.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.NeoProperty), Properties.type.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.NeoProperty), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.NeoProperty), Properties.isUnique.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.PropertyEnum), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.NeoFunction), Properties.name.name());

		relate(domainNode, entitiesNodeMap.get(Entities.NeoDomain), DomainPlugin.Relations.ENTITY);
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.NeoDomain), Relations.RELATIONS.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.NeoRelation));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.NeoDomain), Relations.ENTITIES.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.NeoEntity));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.NeoDomain), Relations.FUNCTIONS.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.NeoFunction));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.NeoRelation), Relations.SRC.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.NeoEntity));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.NeoRelation), Relations.DST.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.NeoEntity));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.NeoRelation), Relations.RELATION_PROPERTIES.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.NeoProperty));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.NeoEntity), Relations.ENTITY_PROPERTIES.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.NeoProperty));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.NeoProperty), Relations.PROPERTYENUMS.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.PropertyEnum));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.NeoFunction), Relations.FUNCTION_PROPERTIES.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.NeoProperty));
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
		if (isNeoDomain(neoNode.getNode())) handleNeoDomain(pop, neoNode, selectedNodes);
		if (isNeoRelation(neoNode.getNode())) handleNeoRelation(pop, neoNode, selectedNodes);
		if (isNeoEntity(neoNode.getNode())) handleNeoEntity(pop, neoNode, selectedNodes);
		if (isNeoProperty(neoNode.getNode())) handleNeoProperty(pop, neoNode, selectedNodes);
		if (isPropertyEnum(neoNode.getNode())) handlePropertyEnum(pop, neoNode, selectedNodes);
		if (isNeoFunction(neoNode.getNode())) handleNeoFunction(pop, neoNode, selectedNodes);
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
		if (isNeoDomain(neoNode.getNode())) return newNeoDomainEditor(neoNode);
		if (isNeoRelation(neoNode.getNode())) return newNeoRelationEditor(neoNode);
		if (isNeoEntity(neoNode.getNode())) return newNeoEntityEditor(neoNode);
		if (isNeoProperty(neoNode.getNode())) return newNeoPropertyEditor(neoNode);
		if (isPropertyEnum(neoNode.getNode())) return newPropertyEnumEditor(neoNode);
		if (isNeoFunction(neoNode.getNode())) return newNeoFunctionEditor(neoNode);
      return null;
   }

	public Node getDomainNode() { return domainNode; }

	public Node getEntityNode(Label label) { return entitiesNodeMap.get(label); }

	protected void handleNeoDomain(JPopupMenu pop, NeoNode neoDomainNode, Set<NeoNode> selectedNodes) { }
	protected void handleNeoRelation(JPopupMenu pop, NeoNode neoRelationNode, Set<NeoNode> selectedNodes) { }
	protected void handleNeoEntity(JPopupMenu pop, NeoNode neoEntityNode, Set<NeoNode> selectedNodes) { }
	protected void handleNeoProperty(JPopupMenu pop, NeoNode neoPropertyNode, Set<NeoNode> selectedNodes) { }
	protected void handlePropertyEnum(JPopupMenu pop, NeoNode propertyEnumNode, Set<NeoNode> selectedNodes) { }
	protected void handleNeoFunction(JPopupMenu pop, NeoNode neoFunctionNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newNeoDomainEditor(NeoNode neoDomainNode) { return null; }
	protected JComponent newNeoRelationEditor(NeoNode neoRelationNode) { return null; }
	protected JComponent newNeoEntityEditor(NeoNode neoEntityNode) { return null; }
	protected JComponent newNeoPropertyEditor(NeoNode neoPropertyNode) { return null; }
	protected JComponent newPropertyEnumEditor(NeoNode propertyEnumNode) { return null; }
	protected JComponent newNeoFunctionEditor(NeoNode neoFunctionNode) { return null; }

	public static boolean isNeoDomain(Node node) { return hasLabel(node, Entities.NeoDomain); }
	public static boolean isNeoRelation(Node node) { return hasLabel(node, Entities.NeoRelation); }
	public static boolean isNeoEntity(Node node) { return hasLabel(node, Entities.NeoEntity); }
	public static boolean isNeoProperty(Node node) { return hasLabel(node, Entities.NeoProperty); }
	public static boolean isPropertyEnum(Node node) { return hasLabel(node, Entities.PropertyEnum); }
	public static boolean isNeoFunction(Node node) { return hasLabel(node, Entities.NeoFunction); }

	protected Node newNeoDomain() { return newNeoDomain(getGraph()); } 
	protected Node newNeoDomain(Object packageName, Object name, Object description, Object root) { return newNeoDomain(getGraph(), packageName, name, description, root); } 

	public static Node newNeoDomain(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.NeoDomain)); } 
	public static Node newNeoDomain(NeoModel graph, Object packageName, Object name, Object description, Object root) {  	
		final Node newNode = newNeoDomain(graph); 	
		if (packageName != null) relate(newNode, DomainMotif.newValueNode(graph, packageName), RelationshipType.withName(Properties.packageName.name()));
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name()));
		if (description != null) relate(newNode, DomainMotif.newValueNode(graph, description), RelationshipType.withName(Properties.description.name()));
		if (root != null) relate(newNode, DomainMotif.newValueNode(graph, root), RelationshipType.withName(Properties.root.name())); 	
		return newNode; 
	}
	/* todo
	public Action newNeoDomainAction() {
		return new App.TransactionAction("New NeoDomain", app) {
			@Override
	   	public void actionPerformed(java.awt.event.ActionEvent e, Transaction tx) throws Exception {

			final Map<String,String> properties = new java.util.HashMap<>();
			   final String packageName = com.generator.util.SwingUtil.showInputDialog("packageName", app);
				if (packageName != null && packageName.length() > 0)
					properties.put("packageName", packageName);

			   final String name = com.generator.util.SwingUtil.showInputDialog("name", app);
				if (name != null && name.length() > 0)
					properties.put("name", name);

			   final String description = com.generator.util.SwingUtil.showInputDialog("description", app);
				if (description != null && description.length() > 0)
					properties.put("description", description);

			   final String root = com.generator.util.SwingUtil.showInputDialog("root", app);
				if (root != null && root.length() > 0)
					properties.put("root", root);


			if (properties.isEmpty()) return;

		   //fireNodesLoaded(new());
	   	}
		};
	}
	*/

	protected Node newNeoRelation() { return newNeoRelation(getGraph()); } 
	protected Node newNeoRelation(Object name, Object cardinality) { return newNeoRelation(getGraph(), name, cardinality); } 

	public static Node newNeoRelation(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.NeoRelation)); } 
	public static Node newNeoRelation(NeoModel graph, Object name, Object cardinality) {  	
		final Node newNode = newNeoRelation(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name()));
		if (cardinality != null) relate(newNode, DomainMotif.newValueNode(graph, cardinality), RelationshipType.withName(Properties.cardinality.name())); 	
		return newNode; 
	}
	/* todo
	public Action newNeoRelationAction() {
		return new App.TransactionAction("New NeoRelation", app) {
			@Override
	   	public void actionPerformed(java.awt.event.ActionEvent e, Transaction tx) throws Exception {

			final Map<String,String> properties = new java.util.HashMap<>();
			   final String name = com.generator.util.SwingUtil.showInputDialog("name", app);
				if (name != null && name.length() > 0)
					properties.put("name", name);

			   final String cardinality = com.generator.util.SwingUtil.showInputDialog("cardinality", app);
				if (cardinality != null && cardinality.length() > 0)
					properties.put("cardinality", cardinality);


			if (properties.isEmpty()) return;

		   //fireNodesLoaded(new());
	   	}
		};
	}
	*/

	protected Node newNeoEntity() { return newNeoEntity(getGraph()); } 
	protected Node newNeoEntity(Object name) { return newNeoEntity(getGraph(), name); } 

	public static Node newNeoEntity(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.NeoEntity)); } 
	public static Node newNeoEntity(NeoModel graph, Object name) {  	
		final Node newNode = newNeoEntity(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}
	/* todo
	public Action newNeoEntityAction() {
		return new App.TransactionAction("New NeoEntity", app) {
			@Override
	   	public void actionPerformed(java.awt.event.ActionEvent e, Transaction tx) throws Exception {

			final Map<String,String> properties = new java.util.HashMap<>();
			   final String name = com.generator.util.SwingUtil.showInputDialog("name", app);
				if (name != null && name.length() > 0)
					properties.put("name", name);


			if (properties.isEmpty()) return;

		   //fireNodesLoaded(new());
	   	}
		};
	}
	*/

	protected Node newNeoProperty() { return newNeoProperty(getGraph()); } 
	protected Node newNeoProperty(Object isRequired, Object type, Object name, Object isUnique) { return newNeoProperty(getGraph(), isRequired, type, name, isUnique); } 

	public static Node newNeoProperty(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.NeoProperty)); } 
	public static Node newNeoProperty(NeoModel graph, Object isRequired, Object type, Object name, Object isUnique) {  	
		final Node newNode = newNeoProperty(graph); 	
		if (isRequired != null) relate(newNode, DomainMotif.newValueNode(graph, isRequired), RelationshipType.withName(Properties.isRequired.name()));
		if (type != null) relate(newNode, DomainMotif.newValueNode(graph, type), RelationshipType.withName(Properties.type.name()));
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name()));
		if (isUnique != null) relate(newNode, DomainMotif.newValueNode(graph, isUnique), RelationshipType.withName(Properties.isUnique.name())); 	
		return newNode; 
	}
	/* todo
	public Action newNeoPropertyAction() {
		return new App.TransactionAction("New NeoProperty", app) {
			@Override
	   	public void actionPerformed(java.awt.event.ActionEvent e, Transaction tx) throws Exception {

			final Map<String,String> properties = new java.util.HashMap<>();
			   final String isRequired = com.generator.util.SwingUtil.showInputDialog("isRequired", app);
				if (isRequired != null && isRequired.length() > 0)
					properties.put("isRequired", isRequired);

			   final String type = com.generator.util.SwingUtil.showInputDialog("type", app);
				if (type != null && type.length() > 0)
					properties.put("type", type);

			   final String name = com.generator.util.SwingUtil.showInputDialog("name", app);
				if (name != null && name.length() > 0)
					properties.put("name", name);

			   final String isUnique = com.generator.util.SwingUtil.showInputDialog("isUnique", app);
				if (isUnique != null && isUnique.length() > 0)
					properties.put("isUnique", isUnique);


			if (properties.isEmpty()) return;

		   //fireNodesLoaded(new());
	   	}
		};
	}
	*/

	protected Node newPropertyEnum() { return newPropertyEnum(getGraph()); } 
	protected Node newPropertyEnum(Object name) { return newPropertyEnum(getGraph(), name); } 

	public static Node newPropertyEnum(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.PropertyEnum)); } 
	public static Node newPropertyEnum(NeoModel graph, Object name) {  	
		final Node newNode = newPropertyEnum(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}
	/* todo
	public Action newPropertyEnumAction() {
		return new App.TransactionAction("New PropertyEnum", app) {
			@Override
	   	public void actionPerformed(java.awt.event.ActionEvent e, Transaction tx) throws Exception {

			final Map<String,String> properties = new java.util.HashMap<>();
			   final String name = com.generator.util.SwingUtil.showInputDialog("name", app);
				if (name != null && name.length() > 0)
					properties.put("name", name);


			if (properties.isEmpty()) return;

		   //fireNodesLoaded(new());
	   	}
		};
	}
	*/

	protected Node newNeoFunction() { return newNeoFunction(getGraph()); } 
	protected Node newNeoFunction(Object name) { return newNeoFunction(getGraph(), name); } 

	public static Node newNeoFunction(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.NeoFunction)); } 
	public static Node newNeoFunction(NeoModel graph, Object name) {  	
		final Node newNode = newNeoFunction(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}
	/* todo
	public Action newNeoFunctionAction() {
		return new App.TransactionAction("New NeoFunction", app) {
			@Override
	   	public void actionPerformed(java.awt.event.ActionEvent e, Transaction tx) throws Exception {

			final Map<String,String> properties = new java.util.HashMap<>();
			   final String name = com.generator.util.SwingUtil.showInputDialog("name", app);
				if (name != null && name.length() > 0)
					properties.put("name", name);


			if (properties.isEmpty()) return;

		   //fireNodesLoaded(new());
	   	}
		};
	}
	*/


	public static void outgoingNEODOMAIN(Node src, RelationConsumer consumer) { outgoing(src, Relations.NEODOMAIN).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingNEODOMAIN(Node src) { return other(src, singleOutgoing(src, Relations.NEODOMAIN)); }
	public static void incomingNEODOMAIN(Node src, RelationConsumer consumer) { incoming(src, Relations.NEODOMAIN).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingNEODOMAIN(Node src) { return other(src, singleIncoming(src, Relations.NEODOMAIN)); }

	public static void outgoingRELATIONS(Node src, RelationConsumer consumer) { outgoing(src, Relations.RELATIONS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingRELATIONS(Node src) { return other(src, singleOutgoing(src, Relations.RELATIONS)); }
	public static void incomingRELATIONS(Node src, RelationConsumer consumer) { incoming(src, Relations.RELATIONS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingRELATIONS(Node src) { return other(src, singleIncoming(src, Relations.RELATIONS)); }

	public static void outgoingNAME(Node src, RelationConsumer consumer) { outgoing(src, Relations.NAME).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingNAME(Node src) { return other(src, singleOutgoing(src, Relations.NAME)); }
	public static void incomingNAME(Node src, RelationConsumer consumer) { incoming(src, Relations.NAME).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingNAME(Node src) { return other(src, singleIncoming(src, Relations.NAME)); }

	public static void outgoingCARDINALITY(Node src, RelationConsumer consumer) { outgoing(src, Relations.CARDINALITY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingCARDINALITY(Node src) { return other(src, singleOutgoing(src, Relations.CARDINALITY)); }
	public static void incomingCARDINALITY(Node src, RelationConsumer consumer) { incoming(src, Relations.CARDINALITY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingCARDINALITY(Node src) { return other(src, singleIncoming(src, Relations.CARDINALITY)); }

	public static void outgoingSRC(Node src, RelationConsumer consumer) { outgoing(src, Relations.SRC).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingSRC(Node src) { return other(src, singleOutgoing(src, Relations.SRC)); }
	public static void incomingSRC(Node src, RelationConsumer consumer) { incoming(src, Relations.SRC).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingSRC(Node src) { return other(src, singleIncoming(src, Relations.SRC)); }

	public static void outgoingENTITY_PROPERTIES(Node src, RelationConsumer consumer) { outgoing(src, Relations.ENTITY_PROPERTIES).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingENTITY_PROPERTIES(Node src) { return other(src, singleOutgoing(src, Relations.ENTITY_PROPERTIES)); }
	public static void incomingENTITY_PROPERTIES(Node src, RelationConsumer consumer) { incoming(src, Relations.ENTITY_PROPERTIES).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingENTITY_PROPERTIES(Node src) { return other(src, singleIncoming(src, Relations.ENTITY_PROPERTIES)); }

	public static void outgoingISREQUIRED(Node src, RelationConsumer consumer) { outgoing(src, Relations.ISREQUIRED).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingISREQUIRED(Node src) { return other(src, singleOutgoing(src, Relations.ISREQUIRED)); }
	public static void incomingISREQUIRED(Node src, RelationConsumer consumer) { incoming(src, Relations.ISREQUIRED).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingISREQUIRED(Node src) { return other(src, singleIncoming(src, Relations.ISREQUIRED)); }

	public static void outgoingTYPE(Node src, RelationConsumer consumer) { outgoing(src, Relations.TYPE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingTYPE(Node src) { return other(src, singleOutgoing(src, Relations.TYPE)); }
	public static void incomingTYPE(Node src, RelationConsumer consumer) { incoming(src, Relations.TYPE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingTYPE(Node src) { return other(src, singleIncoming(src, Relations.TYPE)); }

	public static void outgoingPROPERTYENUMS(Node src, RelationConsumer consumer) { outgoing(src, Relations.PROPERTYENUMS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPROPERTYENUMS(Node src) { return other(src, singleOutgoing(src, Relations.PROPERTYENUMS)); }
	public static void incomingPROPERTYENUMS(Node src, RelationConsumer consumer) { incoming(src, Relations.PROPERTYENUMS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPROPERTYENUMS(Node src) { return other(src, singleIncoming(src, Relations.PROPERTYENUMS)); }

	public static void outgoingISUNIQUE(Node src, RelationConsumer consumer) { outgoing(src, Relations.ISUNIQUE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingISUNIQUE(Node src) { return other(src, singleOutgoing(src, Relations.ISUNIQUE)); }
	public static void incomingISUNIQUE(Node src, RelationConsumer consumer) { incoming(src, Relations.ISUNIQUE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingISUNIQUE(Node src) { return other(src, singleIncoming(src, Relations.ISUNIQUE)); }

	public static void outgoingDST(Node src, RelationConsumer consumer) { outgoing(src, Relations.DST).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingDST(Node src) { return other(src, singleOutgoing(src, Relations.DST)); }
	public static void incomingDST(Node src, RelationConsumer consumer) { incoming(src, Relations.DST).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingDST(Node src) { return other(src, singleIncoming(src, Relations.DST)); }

	public static void outgoingRELATION_PROPERTIES(Node src, RelationConsumer consumer) { outgoing(src, Relations.RELATION_PROPERTIES).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingRELATION_PROPERTIES(Node src) { return other(src, singleOutgoing(src, Relations.RELATION_PROPERTIES)); }
	public static void incomingRELATION_PROPERTIES(Node src, RelationConsumer consumer) { incoming(src, Relations.RELATION_PROPERTIES).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingRELATION_PROPERTIES(Node src) { return other(src, singleIncoming(src, Relations.RELATION_PROPERTIES)); }

	public static void outgoingPACKAGENAME(Node src, RelationConsumer consumer) { outgoing(src, Relations.PACKAGENAME).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPACKAGENAME(Node src) { return other(src, singleOutgoing(src, Relations.PACKAGENAME)); }
	public static void incomingPACKAGENAME(Node src, RelationConsumer consumer) { incoming(src, Relations.PACKAGENAME).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPACKAGENAME(Node src) { return other(src, singleIncoming(src, Relations.PACKAGENAME)); }

	public static void outgoingDESCRIPTION(Node src, RelationConsumer consumer) { outgoing(src, Relations.DESCRIPTION).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingDESCRIPTION(Node src) { return other(src, singleOutgoing(src, Relations.DESCRIPTION)); }
	public static void incomingDESCRIPTION(Node src, RelationConsumer consumer) { incoming(src, Relations.DESCRIPTION).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingDESCRIPTION(Node src) { return other(src, singleIncoming(src, Relations.DESCRIPTION)); }

	public static void outgoingENTITIES(Node src, RelationConsumer consumer) { outgoing(src, Relations.ENTITIES).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingENTITIES(Node src) { return other(src, singleOutgoing(src, Relations.ENTITIES)); }
	public static void incomingENTITIES(Node src, RelationConsumer consumer) { incoming(src, Relations.ENTITIES).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingENTITIES(Node src) { return other(src, singleIncoming(src, Relations.ENTITIES)); }

	public static void outgoingROOT(Node src, RelationConsumer consumer) { outgoing(src, Relations.ROOT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingROOT(Node src) { return other(src, singleOutgoing(src, Relations.ROOT)); }
	public static void incomingROOT(Node src, RelationConsumer consumer) { incoming(src, Relations.ROOT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingROOT(Node src) { return other(src, singleIncoming(src, Relations.ROOT)); }

	public static void outgoingFUNCTIONS(Node src, RelationConsumer consumer) { outgoing(src, Relations.FUNCTIONS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingFUNCTIONS(Node src) { return other(src, singleOutgoing(src, Relations.FUNCTIONS)); }
	public static void incomingFUNCTIONS(Node src, RelationConsumer consumer) { incoming(src, Relations.FUNCTIONS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingFUNCTIONS(Node src) { return other(src, singleIncoming(src, Relations.FUNCTIONS)); }

	public static void outgoingFUNCTION_PROPERTIES(Node src, RelationConsumer consumer) { outgoing(src, Relations.FUNCTION_PROPERTIES).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingFUNCTION_PROPERTIES(Node src) { return other(src, singleOutgoing(src, Relations.FUNCTION_PROPERTIES)); }
	public static void incomingFUNCTION_PROPERTIES(Node src, RelationConsumer consumer) { incoming(src, Relations.FUNCTION_PROPERTIES).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingFUNCTION_PROPERTIES(Node src) { return other(src, singleIncoming(src, Relations.FUNCTION_PROPERTIES)); }


	public static Relationship relateNEODOMAIN(Node src, Node dst) { return relate(src, dst, Relations.NEODOMAIN); }
	public static Relationship relateRELATIONS(Node src, Node dst) { return relate(src, dst, Relations.RELATIONS); }
	public static Relationship relateNAME(Node src, Node dst) { return relate(src, dst, Relations.NAME); }
	public static Relationship relateCARDINALITY(Node src, Node dst) { return relate(src, dst, Relations.CARDINALITY); }
	public static Relationship relateSRC(Node src, Node dst) { return relate(src, dst, Relations.SRC); }
	public static Relationship relateENTITY_PROPERTIES(Node src, Node dst) { return relate(src, dst, Relations.ENTITY_PROPERTIES); }
	public static Relationship relateISREQUIRED(Node src, Node dst) { return relate(src, dst, Relations.ISREQUIRED); }
	public static Relationship relateTYPE(Node src, Node dst) { return relate(src, dst, Relations.TYPE); }
	public static Relationship relatePROPERTYENUMS(Node src, Node dst) { return relate(src, dst, Relations.PROPERTYENUMS); }
	public static Relationship relateISUNIQUE(Node src, Node dst) { return relate(src, dst, Relations.ISUNIQUE); }
	public static Relationship relateDST(Node src, Node dst) { return relate(src, dst, Relations.DST); }
	public static Relationship relateRELATION_PROPERTIES(Node src, Node dst) { return relate(src, dst, Relations.RELATION_PROPERTIES); }
	public static Relationship relatePACKAGENAME(Node src, Node dst) { return relate(src, dst, Relations.PACKAGENAME); }
	public static Relationship relateDESCRIPTION(Node src, Node dst) { return relate(src, dst, Relations.DESCRIPTION); }
	public static Relationship relateENTITIES(Node src, Node dst) { return relate(src, dst, Relations.ENTITIES); }
	public static Relationship relateROOT(Node src, Node dst) { return relate(src, dst, Relations.ROOT); }
	public static Relationship relateFUNCTIONS(Node src, Node dst) { return relate(src, dst, Relations.FUNCTIONS); }
	public static Relationship relateFUNCTION_PROPERTIES(Node src, Node dst) { return relate(src, dst, Relations.FUNCTION_PROPERTIES); }

	// name
	public static <T> T getNameProperty(PropertyContainer container) { return getNameProperty(container, null); }
	public static <T> T getNameProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.name.name(), defaultValue); }
	public static boolean hasNameProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.name.name()); }
	public static <T extends PropertyContainer> T setNameProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.name.name(), value); return container; }
	public static <T extends PropertyContainer> T removeNameProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.name.name()); return container; }

	protected <T extends PropertyContainer> T setNameProperty(T container, Object value) { setNameProperty(getGraph(), container, value); return container; }

	// cardinality
	public static <T> T getCardinalityProperty(PropertyContainer container) { return getCardinalityProperty(container, null); }
	public static <T> T getCardinalityProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.cardinality.name(), defaultValue); }
	public static boolean hasCardinalityProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.cardinality.name()); }
	public static <T extends PropertyContainer> T setCardinalityProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.cardinality.name(), value); return container; }
	public static <T extends PropertyContainer> T removeCardinalityProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.cardinality.name()); return container; }

	protected <T extends PropertyContainer> T setCardinalityProperty(T container, Object value) { setCardinalityProperty(getGraph(), container, value); return container; }

	// isRequired
	public static <T> T getIsRequiredProperty(PropertyContainer container) { return getIsRequiredProperty(container, null); }
	public static <T> T getIsRequiredProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.isRequired.name(), defaultValue); }
	public static boolean hasIsRequiredProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.isRequired.name()); }
	public static <T extends PropertyContainer> T setIsRequiredProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.isRequired.name(), value); return container; }
	public static <T extends PropertyContainer> T removeIsRequiredProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.isRequired.name()); return container; }

	protected <T extends PropertyContainer> T setIsRequiredProperty(T container, Object value) { setIsRequiredProperty(getGraph(), container, value); return container; }

	// type
	public static <T> T getTypeProperty(PropertyContainer container) { return getTypeProperty(container, null); }
	public static <T> T getTypeProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.type.name(), defaultValue); }
	public static boolean hasTypeProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.type.name()); }
	public static <T extends PropertyContainer> T setTypeProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.type.name(), value); return container; }
	public static <T extends PropertyContainer> T removeTypeProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.type.name()); return container; }

	protected <T extends PropertyContainer> T setTypeProperty(T container, Object value) { setTypeProperty(getGraph(), container, value); return container; }

	// isUnique
	public static <T> T getIsUniqueProperty(PropertyContainer container) { return getIsUniqueProperty(container, null); }
	public static <T> T getIsUniqueProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.isUnique.name(), defaultValue); }
	public static boolean hasIsUniqueProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.isUnique.name()); }
	public static <T extends PropertyContainer> T setIsUniqueProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.isUnique.name(), value); return container; }
	public static <T extends PropertyContainer> T removeIsUniqueProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.isUnique.name()); return container; }

	protected <T extends PropertyContainer> T setIsUniqueProperty(T container, Object value) { setIsUniqueProperty(getGraph(), container, value); return container; }

	// packageName
	public static <T> T getPackageNameProperty(PropertyContainer container) { return getPackageNameProperty(container, null); }
	public static <T> T getPackageNameProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.packageName.name(), defaultValue); }
	public static boolean hasPackageNameProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.packageName.name()); }
	public static <T extends PropertyContainer> T setPackageNameProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.packageName.name(), value); return container; }
	public static <T extends PropertyContainer> T removePackageNameProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.packageName.name()); return container; }

	protected <T extends PropertyContainer> T setPackageNameProperty(T container, Object value) { setPackageNameProperty(getGraph(), container, value); return container; }

	// description
	public static <T> T getDescriptionProperty(PropertyContainer container) { return getDescriptionProperty(container, null); }
	public static <T> T getDescriptionProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.description.name(), defaultValue); }
	public static boolean hasDescriptionProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.description.name()); }
	public static <T extends PropertyContainer> T setDescriptionProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.description.name(), value); return container; }
	public static <T extends PropertyContainer> T removeDescriptionProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.description.name()); return container; }

	protected <T extends PropertyContainer> T setDescriptionProperty(T container, Object value) { setDescriptionProperty(getGraph(), container, value); return container; }

	// root
	public static <T> T getRootProperty(PropertyContainer container) { return getRootProperty(container, null); }
	public static <T> T getRootProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.root.name(), defaultValue); }
	public static boolean hasRootProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.root.name()); }
	public static <T extends PropertyContainer> T setRootProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.root.name(), value); return container; }
	public static <T extends PropertyContainer> T removeRootProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.root.name()); return container; }

	protected <T extends PropertyContainer> T setRootProperty(T container, Object value) { setRootProperty(getGraph(), container, value); return container; }

}