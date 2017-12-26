package com.generator.generators.json;

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
 * Auto-generated from domain JsonDomainPlugin
 */
public abstract class JsonDomainPlugin extends Plugin {

	protected final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(JsonDomainPlugin.class);

	public enum Entities implements Label {
      Json, Array, Number, String, Object, Pair
   }

   public enum Relations implements RelationshipType {
      JSON, ARRAY, ELEMENTS, PAIR, VALUE, STRING, NUMBER, OBJ
   }

   public enum Properties {
      name, value, key
   }

	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

	private final Node domainNode;

   JsonDomainPlugin(App app) {
      super(app, "Json");

		domainNode = DomainMotif.newDomainNode(getGraph(), "Json");
		entitiesNodeMap.put(Entities.Json, DomainMotif.newDomainEntity(getGraph(), Entities.Json, domainNode));
		entitiesNodeMap.put(Entities.Array, DomainMotif.newDomainEntity(getGraph(), Entities.Array, domainNode));
		entitiesNodeMap.put(Entities.Number, DomainMotif.newDomainEntity(getGraph(), Entities.Number, domainNode));
		entitiesNodeMap.put(Entities.String, DomainMotif.newDomainEntity(getGraph(), Entities.String, domainNode));
		entitiesNodeMap.put(Entities.Object, DomainMotif.newDomainEntity(getGraph(), Entities.Object, domainNode));
		entitiesNodeMap.put(Entities.Pair, DomainMotif.newDomainEntity(getGraph(), Entities.Pair, domainNode));

		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Array), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Number), Properties.value.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.String), Properties.value.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Pair), Properties.key.name());

		relate(domainNode, entitiesNodeMap.get(Entities.Json), DomainPlugin.Relations.ENTITY);
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Json), Relations.ARRAY.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Array));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Json), Relations.STRING.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.String));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Json), Relations.NUMBER.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Number));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Json), Relations.OBJ.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Object));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Array), Relations.ELEMENTS.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Number));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Object), Relations.PAIR.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Pair));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Pair), Relations.VALUE.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Array));
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
		if (isJson(neoNode.getNode())) handleJson(pop, neoNode, selectedNodes);
		if (isArray(neoNode.getNode())) handleArray(pop, neoNode, selectedNodes);
		if (isNumber(neoNode.getNode())) handleNumber(pop, neoNode, selectedNodes);
		if (isString(neoNode.getNode())) handleString(pop, neoNode, selectedNodes);
		if (isObject(neoNode.getNode())) handleObject(pop, neoNode, selectedNodes);
		if (isPair(neoNode.getNode())) handlePair(pop, neoNode, selectedNodes);
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
		if (isJson(neoNode.getNode())) return newJsonEditor(neoNode);
		if (isArray(neoNode.getNode())) return newArrayEditor(neoNode);
		if (isNumber(neoNode.getNode())) return newNumberEditor(neoNode);
		if (isString(neoNode.getNode())) return newStringEditor(neoNode);
		if (isObject(neoNode.getNode())) return newObjectEditor(neoNode);
		if (isPair(neoNode.getNode())) return newPairEditor(neoNode);
      return null;
   }

	public Node getDomainNode() { return domainNode; }

	public Node getEntityNode(Label label) { return entitiesNodeMap.get(label); }

	protected void handleJson(JPopupMenu pop, NeoNode jsonNode, Set<NeoNode> selectedNodes) { }
	protected void handleArray(JPopupMenu pop, NeoNode arrayNode, Set<NeoNode> selectedNodes) { }
	protected void handleNumber(JPopupMenu pop, NeoNode numberNode, Set<NeoNode> selectedNodes) { }
	protected void handleString(JPopupMenu pop, NeoNode stringNode, Set<NeoNode> selectedNodes) { }
	protected void handleObject(JPopupMenu pop, NeoNode objectNode, Set<NeoNode> selectedNodes) { }
	protected void handlePair(JPopupMenu pop, NeoNode pairNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newJsonEditor(NeoNode jsonNode) { return null; }
	protected JComponent newArrayEditor(NeoNode arrayNode) { return null; }
	protected JComponent newNumberEditor(NeoNode numberNode) { return null; }
	protected JComponent newStringEditor(NeoNode stringNode) { return null; }
	protected JComponent newObjectEditor(NeoNode objectNode) { return null; }
	protected JComponent newPairEditor(NeoNode pairNode) { return null; }

	public static boolean isJson(Node node) { return hasLabel(node, Entities.Json); }
	public static boolean isArray(Node node) { return hasLabel(node, Entities.Array); }
	public static boolean isNumber(Node node) { return hasLabel(node, Entities.Number); }
	public static boolean isString(Node node) { return hasLabel(node, Entities.String); }
	public static boolean isObject(Node node) { return hasLabel(node, Entities.Object); }
	public static boolean isPair(Node node) { return hasLabel(node, Entities.Pair); }

	protected Node newJson() { return newJson(getGraph()); }
	public static Node newJson(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Json)); }

	protected Node newArray() { return newArray(getGraph()); } 
	protected Node newArray(Object name) { return newArray(getGraph(), name); } 

	public static Node newArray(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Array)); } 
	public static Node newArray(NeoModel graph, Object name) {  	
		final Node newNode = newArray(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newNumber() { return newNumber(getGraph()); } 
	protected Node newNumber(Object value) { return newNumber(getGraph(), value); } 

	public static Node newNumber(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Number)); } 
	public static Node newNumber(NeoModel graph, Object value) {  	
		final Node newNode = newNumber(graph); 	
		if (value != null) relate(newNode, DomainMotif.newValueNode(graph, value), RelationshipType.withName(Properties.value.name())); 	
		return newNode; 
	}

	protected Node newString() { return newString(getGraph()); } 
	protected Node newString(Object value) { return newString(getGraph(), value); } 

	public static Node newString(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.String)); } 
	public static Node newString(NeoModel graph, Object value) {  	
		final Node newNode = newString(graph); 	
		if (value != null) relate(newNode, DomainMotif.newValueNode(graph, value), RelationshipType.withName(Properties.value.name())); 	
		return newNode; 
	}

	protected Node newObject() { return newObject(getGraph()); }
	public static Node newObject(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Object)); }

	protected Node newPair() { return newPair(getGraph()); } 
	protected Node newPair(Object key) { return newPair(getGraph(), key); } 

	public static Node newPair(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Pair)); } 
	public static Node newPair(NeoModel graph, Object key) {  	
		final Node newNode = newPair(graph); 	
		if (key != null) relate(newNode, DomainMotif.newValueNode(graph, key), RelationshipType.withName(Properties.key.name())); 	
		return newNode; 
	}


	public static void outgoingJSON(Node src, RelationConsumer consumer) { outgoing(src, Relations.JSON).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingJSON(Node src) { return other(src, singleOutgoing(src, Relations.JSON)); }
	public static void incomingJSON(Node src, RelationConsumer consumer) { incoming(src, Relations.JSON).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingJSON(Node src) { return other(src, singleIncoming(src, Relations.JSON)); }

	public static void outgoingARRAY(Node src, RelationConsumer consumer) { outgoing(src, Relations.ARRAY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingARRAY(Node src) { return other(src, singleOutgoing(src, Relations.ARRAY)); }
	public static void incomingARRAY(Node src, RelationConsumer consumer) { incoming(src, Relations.ARRAY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingARRAY(Node src) { return other(src, singleIncoming(src, Relations.ARRAY)); }

	public static void outgoingELEMENTS(Node src, RelationConsumer consumer) { outgoing(src, Relations.ELEMENTS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingELEMENTS(Node src) { return other(src, singleOutgoing(src, Relations.ELEMENTS)); }
	public static void incomingELEMENTS(Node src, RelationConsumer consumer) { incoming(src, Relations.ELEMENTS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingELEMENTS(Node src) { return other(src, singleIncoming(src, Relations.ELEMENTS)); }

	public static void outgoingPAIR(Node src, RelationConsumer consumer) { outgoing(src, Relations.PAIR).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPAIR(Node src) { return other(src, singleOutgoing(src, Relations.PAIR)); }
	public static void incomingPAIR(Node src, RelationConsumer consumer) { incoming(src, Relations.PAIR).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPAIR(Node src) { return other(src, singleIncoming(src, Relations.PAIR)); }

	public static void outgoingVALUE(Node src, RelationConsumer consumer) { outgoing(src, Relations.VALUE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingVALUE(Node src) { return other(src, singleOutgoing(src, Relations.VALUE)); }
	public static void incomingVALUE(Node src, RelationConsumer consumer) { incoming(src, Relations.VALUE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingVALUE(Node src) { return other(src, singleIncoming(src, Relations.VALUE)); }

	public static void outgoingSTRING(Node src, RelationConsumer consumer) { outgoing(src, Relations.STRING).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingSTRING(Node src) { return other(src, singleOutgoing(src, Relations.STRING)); }
	public static void incomingSTRING(Node src, RelationConsumer consumer) { incoming(src, Relations.STRING).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingSTRING(Node src) { return other(src, singleIncoming(src, Relations.STRING)); }

	public static void outgoingNUMBER(Node src, RelationConsumer consumer) { outgoing(src, Relations.NUMBER).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingNUMBER(Node src) { return other(src, singleOutgoing(src, Relations.NUMBER)); }
	public static void incomingNUMBER(Node src, RelationConsumer consumer) { incoming(src, Relations.NUMBER).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingNUMBER(Node src) { return other(src, singleIncoming(src, Relations.NUMBER)); }

	public static void outgoingOBJ(Node src, RelationConsumer consumer) { outgoing(src, Relations.OBJ).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingOBJ(Node src) { return other(src, singleOutgoing(src, Relations.OBJ)); }
	public static void incomingOBJ(Node src, RelationConsumer consumer) { incoming(src, Relations.OBJ).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingOBJ(Node src) { return other(src, singleIncoming(src, Relations.OBJ)); }


	public static Relationship relateJSON(Node src, Node dst) { return relate(src, dst, Relations.JSON); }
	public static Relationship relateARRAY(Node src, Node dst) { return relate(src, dst, Relations.ARRAY); }
	public static Relationship relateELEMENTS(Node src, Node dst) { return relate(src, dst, Relations.ELEMENTS); }
	public static Relationship relatePAIR(Node src, Node dst) { return relate(src, dst, Relations.PAIR); }
	public static Relationship relateVALUE(Node src, Node dst) { return relate(src, dst, Relations.VALUE); }
	public static Relationship relateSTRING(Node src, Node dst) { return relate(src, dst, Relations.STRING); }
	public static Relationship relateNUMBER(Node src, Node dst) { return relate(src, dst, Relations.NUMBER); }
	public static Relationship relateOBJ(Node src, Node dst) { return relate(src, dst, Relations.OBJ); }

	// name
	public static <T> T getNameProperty(PropertyContainer container) { return getNameProperty(container, null); }
	public static <T> T getNameProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.name.name(), defaultValue); }
	public static boolean hasNameProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.name.name()); }
	public static <T extends PropertyContainer> T setNameProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.name.name(), value); return container; }
	public static <T extends PropertyContainer> T removeNameProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.name.name()); return container; }

	protected <T extends PropertyContainer> T setNameProperty(T container, Object value) { setNameProperty(getGraph(), container, value); return container; }

	// value
	public static <T> T getValueProperty(PropertyContainer container) { return getValueProperty(container, null); }
	public static <T> T getValueProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.value.name(), defaultValue); }
	public static boolean hasValueProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.value.name()); }
	public static <T extends PropertyContainer> T setValueProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.value.name(), value); return container; }
	public static <T extends PropertyContainer> T removeValueProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.value.name()); return container; }

	protected <T extends PropertyContainer> T setValueProperty(T container, Object value) { setValueProperty(getGraph(), container, value); return container; }

	// key
	public static <T> T getKeyProperty(PropertyContainer container) { return getKeyProperty(container, null); }
	public static <T> T getKeyProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.key.name(), defaultValue); }
	public static boolean hasKeyProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.key.name()); }
	public static <T extends PropertyContainer> T setKeyProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.key.name(), value); return container; }
	public static <T extends PropertyContainer> T removeKeyProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.key.name()); return container; }

	protected <T extends PropertyContainer> T setKeyProperty(T container, Object value) { setKeyProperty(getGraph(), container, value); return container; }

}