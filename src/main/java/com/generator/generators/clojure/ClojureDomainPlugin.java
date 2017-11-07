package com.generator.generators.clojure;

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
 * Auto-generated from domain ClojureDomainPlugin
 */
public abstract class ClojureDomainPlugin extends Plugin {

	public enum Entities implements Label {
      Repl, Form, Result, Symbol
   }

   public enum Relations implements RelationshipType {
      REPL, FORM, EVALUATION, SYMBOL
   }

   public enum Properties {
      buffer, name
   }

	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

   ClojureDomainPlugin(App app) {
      super(app, "Clojure");

		final Node domainNode = getGraph().findOrCreate(Domain, AppMotif.Properties.name.name(), "Clojure");
		entitiesNodeMap.put(Entities.Repl, newDomainEntity(getGraph(), Entities.Repl, domainNode));
		entitiesNodeMap.put(Entities.Form, newDomainEntity(getGraph(), Entities.Form, domainNode));
		entitiesNodeMap.put(Entities.Result, newDomainEntity(getGraph(), Entities.Result, domainNode));
		entitiesNodeMap.put(Entities.Symbol, newDomainEntity(getGraph(), Entities.Symbol, domainNode));

		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Form), Properties.name.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Result), Properties.buffer.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Symbol), Properties.name.name());

		relate(domainNode, entitiesNodeMap.get(Entities.Repl), DomainPlugin.Relations.ENTITY);
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Repl), Relations.FORM.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Form));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Repl), Relations.SYMBOL.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Symbol));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Form), Relations.EVALUATION.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Result));
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
		if (isRepl(neoNode.getNode())) handleRepl(pop, neoNode, selectedNodes);
		if (isForm(neoNode.getNode())) handleForm(pop, neoNode, selectedNodes);
		if (isResult(neoNode.getNode())) handleResult(pop, neoNode, selectedNodes);
		if (isSymbol(neoNode.getNode())) handleSymbol(pop, neoNode, selectedNodes);
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
		if (isRepl(neoNode.getNode())) return newReplEditor(neoNode);
		if (isForm(neoNode.getNode())) return newFormEditor(neoNode);
		if (isResult(neoNode.getNode())) return newResultEditor(neoNode);
		if (isSymbol(neoNode.getNode())) return newSymbolEditor(neoNode);
      return null;
   }

	protected void handleRepl(JPopupMenu pop, NeoNode replNode, Set<NeoNode> selectedNodes) { }
	protected void handleForm(JPopupMenu pop, NeoNode formNode, Set<NeoNode> selectedNodes) { }
	protected void handleResult(JPopupMenu pop, NeoNode resultNode, Set<NeoNode> selectedNodes) { }
	protected void handleSymbol(JPopupMenu pop, NeoNode symbolNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newReplEditor(NeoNode replNode) { return null; }
	protected JComponent newFormEditor(NeoNode formNode) { return null; }
	protected JComponent newResultEditor(NeoNode resultNode) { return null; }
	protected JComponent newSymbolEditor(NeoNode symbolNode) { return null; }

	public static boolean isRepl(Node node) { return hasLabel(node, Entities.Repl); }
	public static boolean isForm(Node node) { return hasLabel(node, Entities.Form); }
	public static boolean isResult(Node node) { return hasLabel(node, Entities.Result); }
	public static boolean isSymbol(Node node) { return hasLabel(node, Entities.Symbol); }

	protected Node newRepl() { return newRepl(getGraph()); } 
	public static Node newRepl(NeoModel graph) { return newInstanceNode(graph, Entities.Repl.name(), entitiesNodeMap.get(Entities.Repl)); }

	protected Node newForm() { return newForm(getGraph()); } 
	public static Node newForm(NeoModel graph) { return newInstanceNode(graph, Entities.Form.name(), entitiesNodeMap.get(Entities.Form)); } 
	protected Node newForm(Object name) { return newForm(getGraph(), name); } 
	public static Node newForm(NeoModel graph, Object name) {  	
		final Node newNode = newForm(graph); 	
		if (name != null) relate(newNode, newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newResult() { return newResult(getGraph()); } 
	public static Node newResult(NeoModel graph) { return newInstanceNode(graph, Entities.Result.name(), entitiesNodeMap.get(Entities.Result)); } 
	protected Node newResult(Object buffer) { return newResult(getGraph(), buffer); } 
	public static Node newResult(NeoModel graph, Object buffer) {  	
		final Node newNode = newResult(graph); 	
		if (buffer != null) relate(newNode, newValueNode(graph, buffer), RelationshipType.withName(Properties.buffer.name())); 	
		return newNode; 
	}

	protected Node newSymbol() { return newSymbol(getGraph()); } 
	public static Node newSymbol(NeoModel graph) { return newInstanceNode(graph, Entities.Symbol.name(), entitiesNodeMap.get(Entities.Symbol)); } 
	protected Node newSymbol(Object name) { return newSymbol(getGraph(), name); } 
	public static Node newSymbol(NeoModel graph, Object name) {  	
		final Node newNode = newSymbol(graph); 	
		if (name != null) relate(newNode, newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}


	public static void outgoingREPL(Node src, RelationConsumer consumer) { outgoing(src, Relations.REPL).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingREPL(Node src) { return other(src, singleOutgoing(src, Relations.REPL)); }
	public static void incomingREPL(Node src, RelationConsumer consumer) { incoming(src, Relations.REPL).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingREPL(Node src) { return other(src, singleIncoming(src, Relations.REPL)); }

	public static void outgoingFORM(Node src, RelationConsumer consumer) { outgoing(src, Relations.FORM).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingFORM(Node src) { return other(src, singleOutgoing(src, Relations.FORM)); }
	public static void incomingFORM(Node src, RelationConsumer consumer) { incoming(src, Relations.FORM).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingFORM(Node src) { return other(src, singleIncoming(src, Relations.FORM)); }

	public static void outgoingEVALUATION(Node src, RelationConsumer consumer) { outgoing(src, Relations.EVALUATION).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingEVALUATION(Node src) { return other(src, singleOutgoing(src, Relations.EVALUATION)); }
	public static void incomingEVALUATION(Node src, RelationConsumer consumer) { incoming(src, Relations.EVALUATION).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingEVALUATION(Node src) { return other(src, singleIncoming(src, Relations.EVALUATION)); }

	public static void outgoingSYMBOL(Node src, RelationConsumer consumer) { outgoing(src, Relations.SYMBOL).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingSYMBOL(Node src) { return other(src, singleOutgoing(src, Relations.SYMBOL)); }
	public static void incomingSYMBOL(Node src, RelationConsumer consumer) { incoming(src, Relations.SYMBOL).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingSYMBOL(Node src) { return other(src, singleIncoming(src, Relations.SYMBOL)); }


	public static Relationship relateREPL(Node src, Node dst) { return relate(src, dst, Relations.REPL); }
	public static Relationship relateFORM(Node src, Node dst) { return relate(src, dst, Relations.FORM); }
	public static Relationship relateEVALUATION(Node src, Node dst) { return relate(src, dst, Relations.EVALUATION); }
	public static Relationship relateSYMBOL(Node src, Node dst) { return relate(src, dst, Relations.SYMBOL); }

	// buffer
	public static <T> T getBufferProperty(PropertyContainer container) { return getEntityProperty(container, Properties.buffer.name()); }
	public static <T> T getBufferProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.buffer.name(), defaultValue); }
	public static boolean hasBufferProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.buffer.name()); }
	public static <T extends PropertyContainer> T setBufferProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.buffer.name(), value); return container; }
	protected <T extends PropertyContainer> T setBufferProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.buffer.name(), value); return container; }
	public static <T extends PropertyContainer> T removeBufferProperty(T container) { removeEntityProperty(container, Properties.buffer.name()); return container; }

	// name
	public static <T> T getNameProperty(PropertyContainer container) { return getEntityProperty(container, Properties.name.name()); }
	public static <T> T getNameProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.name.name(), defaultValue); }
	public static boolean hasNameProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.name.name()); }
	public static <T extends PropertyContainer> T setNameProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.name.name(), value); return container; }
	protected <T extends PropertyContainer> T setNameProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.name.name(), value); return container; }
	public static <T extends PropertyContainer> T removeNameProperty(T container) { removeEntityProperty(container, Properties.name.name()); return container; }

}