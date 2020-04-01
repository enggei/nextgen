package com.generator.generators.stringtemplate;

import com.generator.app.App;
import com.generator.app.DomainMotif;
import com.generator.app.Plugin;
import com.generator.app.nodes.NeoNode;
import com.generator.generators.domain.DomainDomainPlugin;
import com.generator.generators.domain.DomainPlugin;
import com.generator.neo.NeoModel;
import org.neo4j.graphdb.*;

import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static com.generator.util.NeoUtil.*;

/**
 * Auto-generated from domain StringTemplateDomainPlugin
 */
public abstract class StringTemplateDomainPlugin extends Plugin {

	protected final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(StringTemplateDomainPlugin.class);

	public enum Entities implements Label {
      STGroup, STTemplate, STGroupBuilder, TemplateMap, TemplateStatement, TemplateSection, ParameterMapping
   }

   public enum Relations implements RelationshipType {
      STGROUP, STGROUPBUILDER, NAME, TEMPLATE, TEXT, MAPS, DELIMITER, STATEMENTS, SECTION, SECTIONTYPE, CONTENT, NEXT, ATTRIBUTEOPERATOR, PARAMETER_MAPPING, REFERENCE, VALUE, SEPARATOR
   }

   public enum Properties {
      name, text, delimiter, SectionType, AttributeOperator, reference, value, separator
   }

	public enum SectionType {
		MAP_REFERENCE, FIRST_REST, STRING, SINGLE_VALUE, LIST, ITERATOR, ITERATION_NUMBER, KEY_VALUE_LIST, IF, LENGTH, NEWLINE, SPACE, COMMENT, ESCAPE, UNICODE, METHOD_REFERENCE, ELSE
	}
	public enum AttributeOperator {
		FIRST, REST, LAST, LENGTH, STRIP
	}


	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

	private final Node domainNode;

   StringTemplateDomainPlugin(App app) {
      super(app, "StringTemplate");

		domainNode = DomainMotif.newDomainNode(getGraph(), "StringTemplate");
		entitiesNodeMap.put(Entities.STGroup, DomainMotif.newDomainEntity(getGraph(), Entities.STGroup, domainNode));
		entitiesNodeMap.put(Entities.STTemplate, DomainMotif.newDomainEntity(getGraph(), Entities.STTemplate, domainNode));
		entitiesNodeMap.put(Entities.STGroupBuilder, DomainMotif.newDomainEntity(getGraph(), Entities.STGroupBuilder, domainNode));
		entitiesNodeMap.put(Entities.TemplateMap, DomainMotif.newDomainEntity(getGraph(), Entities.TemplateMap, domainNode));
		entitiesNodeMap.put(Entities.TemplateStatement, DomainMotif.newDomainEntity(getGraph(), Entities.TemplateStatement, domainNode));
		entitiesNodeMap.put(Entities.TemplateSection, DomainMotif.newDomainEntity(getGraph(), Entities.TemplateSection, domainNode));
		entitiesNodeMap.put(Entities.ParameterMapping, DomainMotif.newDomainEntity(getGraph(), Entities.ParameterMapping, domainNode));

		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.STGroup), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.STTemplate), Properties.text.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.STTemplate), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.STGroupBuilder), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.STGroupBuilder), Properties.delimiter.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.TemplateStatement), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.TemplateSection), Properties.SectionType.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.TemplateSection), Properties.AttributeOperator.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.TemplateSection), Properties.separator.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.TemplateSection), Properties.value.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.ParameterMapping), Properties.reference.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.ParameterMapping), Properties.value.name());

		relate(domainNode, entitiesNodeMap.get(Entities.STGroup), DomainPlugin.Relations.ENTITY);
		relate(domainNode, entitiesNodeMap.get(Entities.STGroupBuilder), DomainPlugin.Relations.ENTITY);
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.STGroup), Relations.TEMPLATE.name(), DomainDomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.STTemplate));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.STGroupBuilder), Relations.MAPS.name(), DomainDomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.TemplateMap));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.STGroupBuilder), Relations.STATEMENTS.name(), DomainDomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.TemplateStatement));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.TemplateStatement), Relations.SECTION.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.TemplateSection));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.TemplateSection), Relations.CONTENT.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.TemplateSection));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.TemplateSection), Relations.NEXT.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.TemplateSection));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.TemplateSection), Relations.PARAMETER_MAPPING.name(), DomainDomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.ParameterMapping));
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
		if (isSTGroup(neoNode.getNode())) handleSTGroup(pop, neoNode, selectedNodes);
		if (isSTTemplate(neoNode.getNode())) handleSTTemplate(pop, neoNode, selectedNodes);
		if (isSTGroupBuilder(neoNode.getNode())) handleSTGroupBuilder(pop, neoNode, selectedNodes);
		if (isTemplateMap(neoNode.getNode())) handleTemplateMap(pop, neoNode, selectedNodes);
		if (isTemplateStatement(neoNode.getNode())) handleTemplateStatement(pop, neoNode, selectedNodes);
		if (isTemplateSection(neoNode.getNode())) handleTemplateSection(pop, neoNode, selectedNodes);
		if (isParameterMapping(neoNode.getNode())) handleParameterMapping(pop, neoNode, selectedNodes);
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
		if (isSTGroup(neoNode.getNode())) return newSTGroupEditor(neoNode);
		if (isSTTemplate(neoNode.getNode())) return newSTTemplateEditor(neoNode);
		if (isSTGroupBuilder(neoNode.getNode())) return newSTGroupBuilderEditor(neoNode);
		if (isTemplateMap(neoNode.getNode())) return newTemplateMapEditor(neoNode);
		if (isTemplateStatement(neoNode.getNode())) return newTemplateStatementEditor(neoNode);
		if (isTemplateSection(neoNode.getNode())) return newTemplateSectionEditor(neoNode);
		if (isParameterMapping(neoNode.getNode())) return newParameterMappingEditor(neoNode);
      return null;
   }

	public Node getDomainNode() { return domainNode; }

	public Node getEntityNode(Label label) { return entitiesNodeMap.get(label); }

	protected void handleSTGroup(JPopupMenu pop, NeoNode sTGroupNode, Set<NeoNode> selectedNodes) { }
	protected void handleSTTemplate(JPopupMenu pop, NeoNode sTTemplateNode, Set<NeoNode> selectedNodes) { }
	protected void handleSTGroupBuilder(JPopupMenu pop, NeoNode sTGroupBuilderNode, Set<NeoNode> selectedNodes) { }
	protected void handleTemplateMap(JPopupMenu pop, NeoNode templateMapNode, Set<NeoNode> selectedNodes) { }
	protected void handleTemplateStatement(JPopupMenu pop, NeoNode templateStatementNode, Set<NeoNode> selectedNodes) { }
	protected void handleTemplateSection(JPopupMenu pop, NeoNode templateSectionNode, Set<NeoNode> selectedNodes) { }
	protected void handleParameterMapping(JPopupMenu pop, NeoNode parameterMappingNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newSTGroupEditor(NeoNode sTGroupNode) { return null; }
	protected JComponent newSTTemplateEditor(NeoNode sTTemplateNode) { return null; }
	protected JComponent newSTGroupBuilderEditor(NeoNode sTGroupBuilderNode) { return null; }
	protected JComponent newTemplateMapEditor(NeoNode templateMapNode) { return null; }
	protected JComponent newTemplateStatementEditor(NeoNode templateStatementNode) { return null; }
	protected JComponent newTemplateSectionEditor(NeoNode templateSectionNode) { return null; }
	protected JComponent newParameterMappingEditor(NeoNode parameterMappingNode) { return null; }

	public static boolean isSTGroup(Node node) { return hasLabel(node, Entities.STGroup); }
	public static boolean isSTTemplate(Node node) { return hasLabel(node, Entities.STTemplate); }
	public static boolean isSTGroupBuilder(Node node) { return hasLabel(node, Entities.STGroupBuilder); }
	public static boolean isTemplateMap(Node node) { return hasLabel(node, Entities.TemplateMap); }
	public static boolean isTemplateStatement(Node node) { return hasLabel(node, Entities.TemplateStatement); }
	public static boolean isTemplateSection(Node node) { return hasLabel(node, Entities.TemplateSection); }
	public static boolean isParameterMapping(Node node) { return hasLabel(node, Entities.ParameterMapping); }

	protected Node newSTGroup() { return newSTGroup(getGraph()); } 
	protected Node newSTGroup(Object name) { return newSTGroup(getGraph(), name); } 

	public static Node newSTGroup(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.STGroup)); } 
	public static Node newSTGroup(NeoModel graph, Object name) {  	
		final Node newNode = newSTGroup(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}
	/* todo
	public Action newSTGroupAction() {
		return new App.TransactionAction("New STGroup", app) {
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

	protected Node newSTTemplate() { return newSTTemplate(getGraph()); } 
	protected Node newSTTemplate(Object text, Object name) { return newSTTemplate(getGraph(), text, name); } 

	public static Node newSTTemplate(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.STTemplate)); } 
	public static Node newSTTemplate(NeoModel graph, Object text, Object name) {  	
		final Node newNode = newSTTemplate(graph); 	
		if (text != null) relate(newNode, DomainMotif.newValueNode(graph, text), RelationshipType.withName(Properties.text.name()));
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}
	/* todo
	public Action newSTTemplateAction() {
		return new App.TransactionAction("New STTemplate", app) {
			@Override
	   	public void actionPerformed(java.awt.event.ActionEvent e, Transaction tx) throws Exception {

			final Map<String,String> properties = new java.util.HashMap<>();
			   final String text = com.generator.util.SwingUtil.showInputDialog("text", app);
				if (text != null && text.length() > 0)
					properties.put("text", text);

			   final String name = com.generator.util.SwingUtil.showInputDialog("name", app);
				if (name != null && name.length() > 0)
					properties.put("name", name);


			if (properties.isEmpty()) return;

		   //fireNodesLoaded(new());
	   	}
		};
	}
	*/

	protected Node newSTGroupBuilder() { return newSTGroupBuilder(getGraph()); } 
	protected Node newSTGroupBuilder(Object name, Object delimiter) { return newSTGroupBuilder(getGraph(), name, delimiter); } 

	public static Node newSTGroupBuilder(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.STGroupBuilder)); } 
	public static Node newSTGroupBuilder(NeoModel graph, Object name, Object delimiter) {  	
		final Node newNode = newSTGroupBuilder(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name()));
		if (delimiter != null) relate(newNode, DomainMotif.newValueNode(graph, delimiter), RelationshipType.withName(Properties.delimiter.name())); 	
		return newNode; 
	}
	/* todo
	public Action newSTGroupBuilderAction() {
		return new App.TransactionAction("New STGroupBuilder", app) {
			@Override
	   	public void actionPerformed(java.awt.event.ActionEvent e, Transaction tx) throws Exception {

			final Map<String,String> properties = new java.util.HashMap<>();
			   final String name = com.generator.util.SwingUtil.showInputDialog("name", app);
				if (name != null && name.length() > 0)
					properties.put("name", name);

			   final String delimiter = com.generator.util.SwingUtil.showInputDialog("delimiter", app);
				if (delimiter != null && delimiter.length() > 0)
					properties.put("delimiter", delimiter);


			if (properties.isEmpty()) return;

		   //fireNodesLoaded(new());
	   	}
		};
	}
	*/

	protected Node newTemplateMap() { return newTemplateMap(getGraph()); }
	public static Node newTemplateMap(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.TemplateMap)); }
	/* todo
	public Action newTemplateMapAction() {
		return new App.TransactionAction("New TemplateMap", app) {
			@Override
	   	public void actionPerformed(java.awt.event.ActionEvent e, Transaction tx) throws Exception {

			final Map<String,String> properties = new java.util.HashMap<>();

			if (properties.isEmpty()) return;

		   //fireNodesLoaded(new());
	   	}
		};
	}
	*/

	protected Node newTemplateStatement() { return newTemplateStatement(getGraph()); } 
	protected Node newTemplateStatement(Object name) { return newTemplateStatement(getGraph(), name); } 

	public static Node newTemplateStatement(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.TemplateStatement)); } 
	public static Node newTemplateStatement(NeoModel graph, Object name) {  	
		final Node newNode = newTemplateStatement(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}
	/* todo
	public Action newTemplateStatementAction() {
		return new App.TransactionAction("New TemplateStatement", app) {
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

	protected Node newTemplateSection() { return newTemplateSection(getGraph()); } 
	protected Node newTemplateSection(Object SectionType, Object AttributeOperator, Object separator, Object value) { return newTemplateSection(getGraph(), SectionType, AttributeOperator, separator, value); } 

	public static Node newTemplateSection(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.TemplateSection)); } 
	public static Node newTemplateSection(NeoModel graph, Object SectionType, Object AttributeOperator, Object separator, Object value) {  	
		final Node newNode = newTemplateSection(graph); 	
		if (SectionType != null) relate(newNode, DomainMotif.newValueNode(graph, SectionType), RelationshipType.withName(Properties.SectionType.name()));
		if (AttributeOperator != null) relate(newNode, DomainMotif.newValueNode(graph, AttributeOperator), RelationshipType.withName(Properties.AttributeOperator.name()));
		if (separator != null) relate(newNode, DomainMotif.newValueNode(graph, separator), RelationshipType.withName(Properties.separator.name()));
		if (value != null) relate(newNode, DomainMotif.newValueNode(graph, value), RelationshipType.withName(Properties.value.name())); 	
		return newNode; 
	}
	/* todo
	public Action newTemplateSectionAction() {
		return new App.TransactionAction("New TemplateSection", app) {
			@Override
	   	public void actionPerformed(java.awt.event.ActionEvent e, Transaction tx) throws Exception {

			final Map<String,String> properties = new java.util.HashMap<>();
			   final String SectionType = com.generator.util.SwingUtil.showInputDialog("SectionType", app);
				if (SectionType != null && SectionType.length() > 0)
					properties.put("SectionType", SectionType);

			   final String AttributeOperator = com.generator.util.SwingUtil.showInputDialog("AttributeOperator", app);
				if (AttributeOperator != null && AttributeOperator.length() > 0)
					properties.put("AttributeOperator", AttributeOperator);

			   final String separator = com.generator.util.SwingUtil.showInputDialog("separator", app);
				if (separator != null && separator.length() > 0)
					properties.put("separator", separator);

			   final String value = com.generator.util.SwingUtil.showInputDialog("value", app);
				if (value != null && value.length() > 0)
					properties.put("value", value);


			if (properties.isEmpty()) return;

		   //fireNodesLoaded(new());
	   	}
		};
	}
	*/

	protected Node newParameterMapping() { return newParameterMapping(getGraph()); } 
	protected Node newParameterMapping(Object reference, Object value) { return newParameterMapping(getGraph(), reference, value); } 

	public static Node newParameterMapping(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.ParameterMapping)); } 
	public static Node newParameterMapping(NeoModel graph, Object reference, Object value) {  	
		final Node newNode = newParameterMapping(graph); 	
		if (reference != null) relate(newNode, DomainMotif.newValueNode(graph, reference), RelationshipType.withName(Properties.reference.name()));
		if (value != null) relate(newNode, DomainMotif.newValueNode(graph, value), RelationshipType.withName(Properties.value.name())); 	
		return newNode; 
	}
	/* todo
	public Action newParameterMappingAction() {
		return new App.TransactionAction("New ParameterMapping", app) {
			@Override
	   	public void actionPerformed(java.awt.event.ActionEvent e, Transaction tx) throws Exception {

			final Map<String,String> properties = new java.util.HashMap<>();
			   final String reference = com.generator.util.SwingUtil.showInputDialog("reference", app);
				if (reference != null && reference.length() > 0)
					properties.put("reference", reference);

			   final String value = com.generator.util.SwingUtil.showInputDialog("value", app);
				if (value != null && value.length() > 0)
					properties.put("value", value);


			if (properties.isEmpty()) return;

		   //fireNodesLoaded(new());
	   	}
		};
	}
	*/


	public static void outgoingSTGROUP(Node src, RelationConsumer consumer) { outgoing(src, Relations.STGROUP).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingSTGROUP(Node src) { return other(src, singleOutgoing(src, Relations.STGROUP)); }
	public static void incomingSTGROUP(Node src, RelationConsumer consumer) { incoming(src, Relations.STGROUP).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingSTGROUP(Node src) { return other(src, singleIncoming(src, Relations.STGROUP)); }

	public static void outgoingSTGROUPBUILDER(Node src, RelationConsumer consumer) { outgoing(src, Relations.STGROUPBUILDER).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingSTGROUPBUILDER(Node src) { return other(src, singleOutgoing(src, Relations.STGROUPBUILDER)); }
	public static void incomingSTGROUPBUILDER(Node src, RelationConsumer consumer) { incoming(src, Relations.STGROUPBUILDER).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingSTGROUPBUILDER(Node src) { return other(src, singleIncoming(src, Relations.STGROUPBUILDER)); }

	public static void outgoingNAME(Node src, RelationConsumer consumer) { outgoing(src, Relations.NAME).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingNAME(Node src) { return other(src, singleOutgoing(src, Relations.NAME)); }
	public static void incomingNAME(Node src, RelationConsumer consumer) { incoming(src, Relations.NAME).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingNAME(Node src) { return other(src, singleIncoming(src, Relations.NAME)); }

	public static void outgoingTEMPLATE(Node src, RelationConsumer consumer) { outgoing(src, Relations.TEMPLATE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingTEMPLATE(Node src) { return other(src, singleOutgoing(src, Relations.TEMPLATE)); }
	public static void incomingTEMPLATE(Node src, RelationConsumer consumer) { incoming(src, Relations.TEMPLATE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingTEMPLATE(Node src) { return other(src, singleIncoming(src, Relations.TEMPLATE)); }

	public static void outgoingTEXT(Node src, RelationConsumer consumer) { outgoing(src, Relations.TEXT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingTEXT(Node src) { return other(src, singleOutgoing(src, Relations.TEXT)); }
	public static void incomingTEXT(Node src, RelationConsumer consumer) { incoming(src, Relations.TEXT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingTEXT(Node src) { return other(src, singleIncoming(src, Relations.TEXT)); }

	public static void outgoingMAPS(Node src, RelationConsumer consumer) { outgoing(src, Relations.MAPS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingMAPS(Node src) { return other(src, singleOutgoing(src, Relations.MAPS)); }
	public static void incomingMAPS(Node src, RelationConsumer consumer) { incoming(src, Relations.MAPS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingMAPS(Node src) { return other(src, singleIncoming(src, Relations.MAPS)); }

	public static void outgoingDELIMITER(Node src, RelationConsumer consumer) { outgoing(src, Relations.DELIMITER).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingDELIMITER(Node src) { return other(src, singleOutgoing(src, Relations.DELIMITER)); }
	public static void incomingDELIMITER(Node src, RelationConsumer consumer) { incoming(src, Relations.DELIMITER).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingDELIMITER(Node src) { return other(src, singleIncoming(src, Relations.DELIMITER)); }

	public static void outgoingSTATEMENTS(Node src, RelationConsumer consumer) { outgoing(src, Relations.STATEMENTS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingSTATEMENTS(Node src) { return other(src, singleOutgoing(src, Relations.STATEMENTS)); }
	public static void incomingSTATEMENTS(Node src, RelationConsumer consumer) { incoming(src, Relations.STATEMENTS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingSTATEMENTS(Node src) { return other(src, singleIncoming(src, Relations.STATEMENTS)); }

	public static void outgoingSECTION(Node src, RelationConsumer consumer) { outgoing(src, Relations.SECTION).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingSECTION(Node src) { return other(src, singleOutgoing(src, Relations.SECTION)); }
	public static void incomingSECTION(Node src, RelationConsumer consumer) { incoming(src, Relations.SECTION).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingSECTION(Node src) { return other(src, singleIncoming(src, Relations.SECTION)); }

	public static void outgoingSECTIONTYPE(Node src, RelationConsumer consumer) { outgoing(src, Relations.SECTIONTYPE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingSECTIONTYPE(Node src) { return other(src, singleOutgoing(src, Relations.SECTIONTYPE)); }
	public static void incomingSECTIONTYPE(Node src, RelationConsumer consumer) { incoming(src, Relations.SECTIONTYPE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingSECTIONTYPE(Node src) { return other(src, singleIncoming(src, Relations.SECTIONTYPE)); }

	public static void outgoingCONTENT(Node src, RelationConsumer consumer) { outgoing(src, Relations.CONTENT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingCONTENT(Node src) { return other(src, singleOutgoing(src, Relations.CONTENT)); }
	public static void incomingCONTENT(Node src, RelationConsumer consumer) { incoming(src, Relations.CONTENT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingCONTENT(Node src) { return other(src, singleIncoming(src, Relations.CONTENT)); }

	public static void outgoingNEXT(Node src, RelationConsumer consumer) { outgoing(src, Relations.NEXT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingNEXT(Node src) { return other(src, singleOutgoing(src, Relations.NEXT)); }
	public static void incomingNEXT(Node src, RelationConsumer consumer) { incoming(src, Relations.NEXT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingNEXT(Node src) { return other(src, singleIncoming(src, Relations.NEXT)); }

	public static void outgoingATTRIBUTEOPERATOR(Node src, RelationConsumer consumer) { outgoing(src, Relations.ATTRIBUTEOPERATOR).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingATTRIBUTEOPERATOR(Node src) { return other(src, singleOutgoing(src, Relations.ATTRIBUTEOPERATOR)); }
	public static void incomingATTRIBUTEOPERATOR(Node src, RelationConsumer consumer) { incoming(src, Relations.ATTRIBUTEOPERATOR).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingATTRIBUTEOPERATOR(Node src) { return other(src, singleIncoming(src, Relations.ATTRIBUTEOPERATOR)); }

	public static void outgoingPARAMETER_MAPPING(Node src, RelationConsumer consumer) { outgoing(src, Relations.PARAMETER_MAPPING).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPARAMETER_MAPPING(Node src) { return other(src, singleOutgoing(src, Relations.PARAMETER_MAPPING)); }
	public static void incomingPARAMETER_MAPPING(Node src, RelationConsumer consumer) { incoming(src, Relations.PARAMETER_MAPPING).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPARAMETER_MAPPING(Node src) { return other(src, singleIncoming(src, Relations.PARAMETER_MAPPING)); }

	public static void outgoingREFERENCE(Node src, RelationConsumer consumer) { outgoing(src, Relations.REFERENCE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingREFERENCE(Node src) { return other(src, singleOutgoing(src, Relations.REFERENCE)); }
	public static void incomingREFERENCE(Node src, RelationConsumer consumer) { incoming(src, Relations.REFERENCE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingREFERENCE(Node src) { return other(src, singleIncoming(src, Relations.REFERENCE)); }

	public static void outgoingVALUE(Node src, RelationConsumer consumer) { outgoing(src, Relations.VALUE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingVALUE(Node src) { return other(src, singleOutgoing(src, Relations.VALUE)); }
	public static void incomingVALUE(Node src, RelationConsumer consumer) { incoming(src, Relations.VALUE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingVALUE(Node src) { return other(src, singleIncoming(src, Relations.VALUE)); }

	public static void outgoingSEPARATOR(Node src, RelationConsumer consumer) { outgoing(src, Relations.SEPARATOR).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingSEPARATOR(Node src) { return other(src, singleOutgoing(src, Relations.SEPARATOR)); }
	public static void incomingSEPARATOR(Node src, RelationConsumer consumer) { incoming(src, Relations.SEPARATOR).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingSEPARATOR(Node src) { return other(src, singleIncoming(src, Relations.SEPARATOR)); }


	public static Relationship relateSTGROUP(Node src, Node dst) { return relate(src, dst, Relations.STGROUP); }
	public static Relationship relateSTGROUPBUILDER(Node src, Node dst) { return relate(src, dst, Relations.STGROUPBUILDER); }
	public static Relationship relateNAME(Node src, Node dst) { return relate(src, dst, Relations.NAME); }
	public static Relationship relateTEMPLATE(Node src, Node dst) { return relate(src, dst, Relations.TEMPLATE); }
	public static Relationship relateTEXT(Node src, Node dst) { return relate(src, dst, Relations.TEXT); }
	public static Relationship relateMAPS(Node src, Node dst) { return relate(src, dst, Relations.MAPS); }
	public static Relationship relateDELIMITER(Node src, Node dst) { return relate(src, dst, Relations.DELIMITER); }
	public static Relationship relateSTATEMENTS(Node src, Node dst) { return relate(src, dst, Relations.STATEMENTS); }
	public static Relationship relateSECTION(Node src, Node dst) { return relate(src, dst, Relations.SECTION); }
	public static Relationship relateSECTIONTYPE(Node src, Node dst) { return relate(src, dst, Relations.SECTIONTYPE); }
	public static Relationship relateCONTENT(Node src, Node dst) { return relate(src, dst, Relations.CONTENT); }
	public static Relationship relateNEXT(Node src, Node dst) { return relate(src, dst, Relations.NEXT); }
	public static Relationship relateATTRIBUTEOPERATOR(Node src, Node dst) { return relate(src, dst, Relations.ATTRIBUTEOPERATOR); }
	public static Relationship relatePARAMETER_MAPPING(Node src, Node dst) { return relate(src, dst, Relations.PARAMETER_MAPPING); }
	public static Relationship relateREFERENCE(Node src, Node dst) { return relate(src, dst, Relations.REFERENCE); }
	public static Relationship relateVALUE(Node src, Node dst) { return relate(src, dst, Relations.VALUE); }
	public static Relationship relateSEPARATOR(Node src, Node dst) { return relate(src, dst, Relations.SEPARATOR); }

	// name
	public static <T> T getNameProperty(PropertyContainer container) { return getNameProperty(container, null); }
	public static <T> T getNameProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.name.name(), defaultValue); }
	public static boolean hasNameProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.name.name()); }
	public static <T extends PropertyContainer> T setNameProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.name.name(), value); return container; }
	public static <T extends PropertyContainer> T removeNameProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.name.name()); return container; }

	protected <T extends PropertyContainer> T setNameProperty(T container, Object value) { setNameProperty(getGraph(), container, value); return container; }

	// text
	public static <T> T getTextProperty(PropertyContainer container) { return getTextProperty(container, null); }
	public static <T> T getTextProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.text.name(), defaultValue); }
	public static boolean hasTextProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.text.name()); }
	public static <T extends PropertyContainer> T setTextProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.text.name(), value); return container; }
	public static <T extends PropertyContainer> T removeTextProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.text.name()); return container; }

	protected <T extends PropertyContainer> T setTextProperty(T container, Object value) { setTextProperty(getGraph(), container, value); return container; }

	// delimiter
	public static <T> T getDelimiterProperty(PropertyContainer container) { return getDelimiterProperty(container, null); }
	public static <T> T getDelimiterProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.delimiter.name(), defaultValue); }
	public static boolean hasDelimiterProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.delimiter.name()); }
	public static <T extends PropertyContainer> T setDelimiterProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.delimiter.name(), value); return container; }
	public static <T extends PropertyContainer> T removeDelimiterProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.delimiter.name()); return container; }

	protected <T extends PropertyContainer> T setDelimiterProperty(T container, Object value) { setDelimiterProperty(getGraph(), container, value); return container; }

	// SectionType
	public static <T> T getSectionTypeProperty(PropertyContainer container) { return getSectionTypeProperty(container, null); }
	public static <T> T getSectionTypeProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.SectionType.name(), defaultValue); }
	public static boolean hasSectionTypeProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.SectionType.name()); }
	public static <T extends PropertyContainer> T setSectionTypeProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.SectionType.name(), value); return container; }
	public static <T extends PropertyContainer> T removeSectionTypeProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.SectionType.name()); return container; }

	protected <T extends PropertyContainer> T setSectionTypeProperty(T container, Object value) { setSectionTypeProperty(getGraph(), container, value); return container; }

	// AttributeOperator
	public static <T> T getAttributeOperatorProperty(PropertyContainer container) { return getAttributeOperatorProperty(container, null); }
	public static <T> T getAttributeOperatorProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.AttributeOperator.name(), defaultValue); }
	public static boolean hasAttributeOperatorProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.AttributeOperator.name()); }
	public static <T extends PropertyContainer> T setAttributeOperatorProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.AttributeOperator.name(), value); return container; }
	public static <T extends PropertyContainer> T removeAttributeOperatorProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.AttributeOperator.name()); return container; }

	protected <T extends PropertyContainer> T setAttributeOperatorProperty(T container, Object value) { setAttributeOperatorProperty(getGraph(), container, value); return container; }

	// reference
	public static <T> T getReferenceProperty(PropertyContainer container) { return getReferenceProperty(container, null); }
	public static <T> T getReferenceProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.reference.name(), defaultValue); }
	public static boolean hasReferenceProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.reference.name()); }
	public static <T extends PropertyContainer> T setReferenceProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.reference.name(), value); return container; }
	public static <T extends PropertyContainer> T removeReferenceProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.reference.name()); return container; }

	protected <T extends PropertyContainer> T setReferenceProperty(T container, Object value) { setReferenceProperty(getGraph(), container, value); return container; }

	// value
	public static <T> T getValueProperty(PropertyContainer container) { return getValueProperty(container, null); }
	public static <T> T getValueProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.value.name(), defaultValue); }
	public static boolean hasValueProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.value.name()); }
	public static <T extends PropertyContainer> T setValueProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.value.name(), value); return container; }
	public static <T extends PropertyContainer> T removeValueProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.value.name()); return container; }

	protected <T extends PropertyContainer> T setValueProperty(T container, Object value) { setValueProperty(getGraph(), container, value); return container; }

	// separator
	public static <T> T getSeparatorProperty(PropertyContainer container) { return getSeparatorProperty(container, null); }
	public static <T> T getSeparatorProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.separator.name(), defaultValue); }
	public static boolean hasSeparatorProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.separator.name()); }
	public static <T extends PropertyContainer> T setSeparatorProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.separator.name(), value); return container; }
	public static <T extends PropertyContainer> T removeSeparatorProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.separator.name()); return container; }

	protected <T extends PropertyContainer> T setSeparatorProperty(T container, Object value) { setSeparatorProperty(getGraph(), container, value); return container; }

}