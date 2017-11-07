package com.generator.generators.json;

import com.generator.app.App;
import com.generator.app.AppMotif;
import com.generator.app.Plugin;
import com.generator.app.nodes.NeoNode;
import com.generator.generators.domain.DomainPlugin;
import com.generator.neo.NeoModel;
import org.neo4j.graphdb.*;

import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static com.generator.app.DomainMotif.*;
import static com.generator.generators.domain.DomainDomainPlugin.Entities.Domain;
import static com.generator.util.NeoUtil.*;

/**
 * Auto-generated from domain JsonDomainPlugin
 */
public abstract class JsonDomainPlugin extends Plugin {

	public enum Entities implements Label {
      Json, Array, String, Number, Object, Pair, Key, Value
   }

   public enum Relations implements RelationshipType {
      JSON, ARRAY, STRING, NUMBER, OBJ, PAIR, KEY, VALUE
   }

   public enum Properties {
   }

	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

   JsonDomainPlugin(App app) {
      super(app, "Json");

		final Node domainNode = getGraph().findOrCreate(Domain, AppMotif.Properties.name.name(), "Json");
		entitiesNodeMap.put(Entities.Json, newDomainEntity(getGraph(), Entities.Json, domainNode));
		entitiesNodeMap.put(Entities.Array, newDomainEntity(getGraph(), Entities.Array, domainNode));
		entitiesNodeMap.put(Entities.String, newDomainEntity(getGraph(), Entities.String, domainNode));
		entitiesNodeMap.put(Entities.Number, newDomainEntity(getGraph(), Entities.Number, domainNode));
		entitiesNodeMap.put(Entities.Object, newDomainEntity(getGraph(), Entities.Object, domainNode));
		entitiesNodeMap.put(Entities.Pair, newDomainEntity(getGraph(), Entities.Pair, domainNode));
		entitiesNodeMap.put(Entities.Key, newDomainEntity(getGraph(), Entities.Key, domainNode));
		entitiesNodeMap.put(Entities.Value, newDomainEntity(getGraph(), Entities.Value, domainNode));


		relate(domainNode, entitiesNodeMap.get(Entities.Json), DomainPlugin.Relations.ENTITY);
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Json), Relations.ARRAY.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Array));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Json), Relations.STRING.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.String));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Json), Relations.NUMBER.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Number));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Json), Relations.OBJ.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Object));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Object), Relations.PAIR.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Pair));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Pair), Relations.KEY.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Key));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Pair), Relations.VALUE.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Value));
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
		if (isJson(neoNode.getNode())) handleJson(pop, neoNode, selectedNodes);
		if (isArray(neoNode.getNode())) handleArray(pop, neoNode, selectedNodes);
		if (isString(neoNode.getNode())) handleString(pop, neoNode, selectedNodes);
		if (isNumber(neoNode.getNode())) handleNumber(pop, neoNode, selectedNodes);
		if (isObject(neoNode.getNode())) handleObject(pop, neoNode, selectedNodes);
		if (isPair(neoNode.getNode())) handlePair(pop, neoNode, selectedNodes);
		if (isKey(neoNode.getNode())) handleKey(pop, neoNode, selectedNodes);
		if (isValue(neoNode.getNode())) handleValue(pop, neoNode, selectedNodes);
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
		if (isJson(neoNode.getNode())) return newJsonEditor(neoNode);
		if (isArray(neoNode.getNode())) return newArrayEditor(neoNode);
		if (isString(neoNode.getNode())) return newStringEditor(neoNode);
		if (isNumber(neoNode.getNode())) return newNumberEditor(neoNode);
		if (isObject(neoNode.getNode())) return newObjectEditor(neoNode);
		if (isPair(neoNode.getNode())) return newPairEditor(neoNode);
		if (isKey(neoNode.getNode())) return newKeyEditor(neoNode);
		if (isValue(neoNode.getNode())) return newValueEditor(neoNode);
      return null;
   }

	protected void handleJson(JPopupMenu pop, NeoNode jsonNode, Set<NeoNode> selectedNodes) { }
	protected void handleArray(JPopupMenu pop, NeoNode arrayNode, Set<NeoNode> selectedNodes) { }
	protected void handleString(JPopupMenu pop, NeoNode stringNode, Set<NeoNode> selectedNodes) { }
	protected void handleNumber(JPopupMenu pop, NeoNode numberNode, Set<NeoNode> selectedNodes) { }
	protected void handleObject(JPopupMenu pop, NeoNode objectNode, Set<NeoNode> selectedNodes) { }
	protected void handlePair(JPopupMenu pop, NeoNode pairNode, Set<NeoNode> selectedNodes) { }
	protected void handleKey(JPopupMenu pop, NeoNode keyNode, Set<NeoNode> selectedNodes) { }
	protected void handleValue(JPopupMenu pop, NeoNode valueNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newJsonEditor(NeoNode jsonNode) { return null; }
	protected JComponent newArrayEditor(NeoNode arrayNode) { return null; }
	protected JComponent newStringEditor(NeoNode stringNode) { return null; }
	protected JComponent newNumberEditor(NeoNode numberNode) { return null; }
	protected JComponent newObjectEditor(NeoNode objectNode) { return null; }
	protected JComponent newPairEditor(NeoNode pairNode) { return null; }
	protected JComponent newKeyEditor(NeoNode keyNode) { return null; }
	protected JComponent newValueEditor(NeoNode valueNode) { return null; }

	public static boolean isJson(Node node) { return hasLabel(node, Entities.Json); }
	public static boolean isArray(Node node) { return hasLabel(node, Entities.Array); }
	public static boolean isString(Node node) { return hasLabel(node, Entities.String); }
	public static boolean isNumber(Node node) { return hasLabel(node, Entities.Number); }
	public static boolean isObject(Node node) { return hasLabel(node, Entities.Object); }
	public static boolean isPair(Node node) { return hasLabel(node, Entities.Pair); }
	public static boolean isKey(Node node) { return hasLabel(node, Entities.Key); }
	public static boolean isValue(Node node) { return hasLabel(node, Entities.Value); }

	protected Node newJson() { return newJson(getGraph()); } 
	public static Node newJson(NeoModel graph) { return newInstanceNode(graph, Entities.Json.name(), entitiesNodeMap.get(Entities.Json)); }

	protected Node newArray() { return newArray(getGraph()); } 
	public static Node newArray(NeoModel graph) { return newInstanceNode(graph, Entities.Array.name(), entitiesNodeMap.get(Entities.Array)); }

	protected Node newString() { return newString(getGraph()); } 
	public static Node newString(NeoModel graph) { return newInstanceNode(graph, Entities.String.name(), entitiesNodeMap.get(Entities.String)); }

	protected Node newNumber() { return newNumber(getGraph()); } 
	public static Node newNumber(NeoModel graph) { return newInstanceNode(graph, Entities.Number.name(), entitiesNodeMap.get(Entities.Number)); }

	protected Node newObject() { return newObject(getGraph()); } 
	public static Node newObject(NeoModel graph) { return newInstanceNode(graph, Entities.Object.name(), entitiesNodeMap.get(Entities.Object)); }

	protected Node newPair() { return newPair(getGraph()); } 
	public static Node newPair(NeoModel graph) { return newInstanceNode(graph, Entities.Pair.name(), entitiesNodeMap.get(Entities.Pair)); }

	protected Node newKey() { return newKey(getGraph()); } 
	public static Node newKey(NeoModel graph) { return newInstanceNode(graph, Entities.Key.name(), entitiesNodeMap.get(Entities.Key)); }

	protected Node newValue() { return newValue(getGraph()); } 
	public static Node newValue(NeoModel graph) { return newInstanceNode(graph, Entities.Value.name(), entitiesNodeMap.get(Entities.Value)); }


	public static void outgoingJSON(Node src, RelationConsumer consumer) { outgoing(src, Relations.JSON).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingJSON(Node src) { return other(src, singleOutgoing(src, Relations.JSON)); }
	public static void incomingJSON(Node src, RelationConsumer consumer) { incoming(src, Relations.JSON).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingJSON(Node src) { return other(src, singleIncoming(src, Relations.JSON)); }

	public static void outgoingARRAY(Node src, RelationConsumer consumer) { outgoing(src, Relations.ARRAY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingARRAY(Node src) { return other(src, singleOutgoing(src, Relations.ARRAY)); }
	public static void incomingARRAY(Node src, RelationConsumer consumer) { incoming(src, Relations.ARRAY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingARRAY(Node src) { return other(src, singleIncoming(src, Relations.ARRAY)); }

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

	public static void outgoingPAIR(Node src, RelationConsumer consumer) { outgoing(src, Relations.PAIR).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPAIR(Node src) { return other(src, singleOutgoing(src, Relations.PAIR)); }
	public static void incomingPAIR(Node src, RelationConsumer consumer) { incoming(src, Relations.PAIR).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPAIR(Node src) { return other(src, singleIncoming(src, Relations.PAIR)); }

	public static void outgoingKEY(Node src, RelationConsumer consumer) { outgoing(src, Relations.KEY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingKEY(Node src) { return other(src, singleOutgoing(src, Relations.KEY)); }
	public static void incomingKEY(Node src, RelationConsumer consumer) { incoming(src, Relations.KEY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingKEY(Node src) { return other(src, singleIncoming(src, Relations.KEY)); }

	public static void outgoingVALUE(Node src, RelationConsumer consumer) { outgoing(src, Relations.VALUE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingVALUE(Node src) { return other(src, singleOutgoing(src, Relations.VALUE)); }
	public static void incomingVALUE(Node src, RelationConsumer consumer) { incoming(src, Relations.VALUE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingVALUE(Node src) { return other(src, singleIncoming(src, Relations.VALUE)); }


	public static Relationship relateJSON(Node src, Node dst) { return relate(src, dst, Relations.JSON); }
	public static Relationship relateARRAY(Node src, Node dst) { return relate(src, dst, Relations.ARRAY); }
	public static Relationship relateSTRING(Node src, Node dst) { return relate(src, dst, Relations.STRING); }
	public static Relationship relateNUMBER(Node src, Node dst) { return relate(src, dst, Relations.NUMBER); }
	public static Relationship relateOBJ(Node src, Node dst) { return relate(src, dst, Relations.OBJ); }
	public static Relationship relatePAIR(Node src, Node dst) { return relate(src, dst, Relations.PAIR); }
	public static Relationship relateKEY(Node src, Node dst) { return relate(src, dst, Relations.KEY); }
	public static Relationship relateVALUE(Node src, Node dst) { return relate(src, dst, Relations.VALUE); }

}