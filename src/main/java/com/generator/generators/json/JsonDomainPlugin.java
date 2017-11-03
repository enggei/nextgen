package com.generator.generators.json;

import com.generator.app.App;
import com.generator.app.AppMotif;
import com.generator.app.Plugin;
import com.generator.app.nodes.NeoNode;
import com.generator.app.DomainMotif;
import com.generator.neo.NeoModel;
import org.neo4j.graphdb.*;

import javax.swing.*;
import java.util.Set;

import static com.generator.util.NeoUtil.*;

/**
 * Auto-generated from domain JsonDomainPlugin
 */
abstract class JsonDomainPlugin extends Plugin {

	public enum Entities implements Label {
      Json, Array, String, Number, Object, Pair, Key, Value
   }

   public enum Relations implements RelationshipType {
      ARRAY, STRING, NUMBER, OBJ, PAIR, KEY, VALUE
   }

   public enum Properties {
   }

   JsonDomainPlugin(App app) {
      super(app, "Json");
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

	protected void handleJson(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleArray(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleString(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleNumber(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleObject(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handlePair(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleKey(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleValue(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newJsonEditor(NeoNode neoNode) { return null; }
	protected JComponent newArrayEditor(NeoNode neoNode) { return null; }
	protected JComponent newStringEditor(NeoNode neoNode) { return null; }
	protected JComponent newNumberEditor(NeoNode neoNode) { return null; }
	protected JComponent newObjectEditor(NeoNode neoNode) { return null; }
	protected JComponent newPairEditor(NeoNode neoNode) { return null; }
	protected JComponent newKeyEditor(NeoNode neoNode) { return null; }
	protected JComponent newValueEditor(NeoNode neoNode) { return null; }

	protected Node newJson(String name) { return newJson(getGraph(), name); }
	protected Node newJson() { return newJson(getGraph()); } 
	protected Node newArray(String name) { return newArray(getGraph(), name); }
	protected Node newArray() { return newArray(getGraph()); } 
	protected Node newString(String name) { return newString(getGraph(), name); }
	protected Node newString() { return newString(getGraph()); } 
	protected Node newNumber(String name) { return newNumber(getGraph(), name); }
	protected Node newNumber() { return newNumber(getGraph()); } 
	protected Node newObject(String name) { return newObject(getGraph(), name); }
	protected Node newObject() { return newObject(getGraph()); } 
	protected Node newPair(String name) { return newPair(getGraph(), name); }
	protected Node newPair() { return newPair(getGraph()); } 
	protected Node newKey(String name) { return newKey(getGraph(), name); }
	protected Node newKey() { return newKey(getGraph()); } 
	protected Node newValue(String name) { return newValue(getGraph(), name); }
	protected Node newValue() { return newValue(getGraph()); } 

	public static boolean isJson(Node node) { return hasLabel(node, Entities.Json); }
	public static boolean isArray(Node node) { return hasLabel(node, Entities.Array); }
	public static boolean isString(Node node) { return hasLabel(node, Entities.String); }
	public static boolean isNumber(Node node) { return hasLabel(node, Entities.Number); }
	public static boolean isObject(Node node) { return hasLabel(node, Entities.Object); }
	public static boolean isPair(Node node) { return hasLabel(node, Entities.Pair); }
	public static boolean isKey(Node node) { return hasLabel(node, Entities.Key); }
	public static boolean isValue(Node node) { return hasLabel(node, Entities.Value); }

	public static Node newJson(NeoModel graph, String name) { return graph.newNode(Entities.Json, AppMotif.Properties.name.name(), name); }
	public static Node newJson(NeoModel graph) { return graph.newNode(Entities.Json); }
	public static Node newArray(NeoModel graph, String name) { return graph.newNode(Entities.Array, AppMotif.Properties.name.name(), name); }
	public static Node newArray(NeoModel graph) { return graph.newNode(Entities.Array); }
	public static Node newString(NeoModel graph, String name) { return graph.newNode(Entities.String, AppMotif.Properties.name.name(), name); }
	public static Node newString(NeoModel graph) { return graph.newNode(Entities.String); }
	public static Node newNumber(NeoModel graph, String name) { return graph.newNode(Entities.Number, AppMotif.Properties.name.name(), name); }
	public static Node newNumber(NeoModel graph) { return graph.newNode(Entities.Number); }
	public static Node newObject(NeoModel graph, String name) { return graph.newNode(Entities.Object, AppMotif.Properties.name.name(), name); }
	public static Node newObject(NeoModel graph) { return graph.newNode(Entities.Object); }
	public static Node newPair(NeoModel graph, String name) { return graph.newNode(Entities.Pair, AppMotif.Properties.name.name(), name); }
	public static Node newPair(NeoModel graph) { return graph.newNode(Entities.Pair); }
	public static Node newKey(NeoModel graph, String name) { return graph.newNode(Entities.Key, AppMotif.Properties.name.name(), name); }
	public static Node newKey(NeoModel graph) { return graph.newNode(Entities.Key); }
	public static Node newValue(NeoModel graph, String name) { return graph.newNode(Entities.Value, AppMotif.Properties.name.name(), name); }
	public static Node newValue(NeoModel graph) { return graph.newNode(Entities.Value); }

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


	public static Relationship relateARRAY(Node src, Node dst) { return relate(src, dst, Relations.ARRAY); }
	public static Relationship relateSTRING(Node src, Node dst) { return relate(src, dst, Relations.STRING); }
	public static Relationship relateNUMBER(Node src, Node dst) { return relate(src, dst, Relations.NUMBER); }
	public static Relationship relateOBJ(Node src, Node dst) { return relate(src, dst, Relations.OBJ); }
	public static Relationship relatePAIR(Node src, Node dst) { return relate(src, dst, Relations.PAIR); }
	public static Relationship relateKEY(Node src, Node dst) { return relate(src, dst, Relations.KEY); }
	public static Relationship relateVALUE(Node src, Node dst) { return relate(src, dst, Relations.VALUE); }

	// get name as property of a node (node.name)
	public static String getNameProperty(PropertyContainer node) { return DomainMotif.getName(node); }
	public static String getNameProperty(NeoNode neoNode) { return DomainMotif.getName(neoNode); }
	public static void setNameProperty(PropertyContainer node, String name) { DomainMotif.setName(node, name); }
	public static void setNameProperty(NeoNode neoNode, String name) { DomainMotif.setName(neoNode, name); }

	// get name for Domain-Property (entityNode -> name -> valueNode.name)	
	public static String getEntityName(Node classNode) { return DomainMotif.getPropertyValue(classNode, AppMotif.Properties.name.name()); }
	public static String getEntityName(Node classNode, String defaultValue) { return DomainMotif.getPropertyValue(classNode, AppMotif.Properties.name.name(), defaultValue); }

}