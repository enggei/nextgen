package com.generator.generators.java;

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
 * Auto-generated from domain JavaDomainDomainPlugin
 */
public abstract class JavaDomainDomainPlugin extends Plugin {

	public enum Entities implements Label {
      _package, Class, Object, Field, FieldType, Instantiator, Method, Statement, Parameter, Constructor
   }

   public enum Relations implements RelationshipType {
      _PACKAGE, CLASS, OBJECT, FIELD, TYPE, INSTANTIATION, METHOD, BLOCK, NEXT, PARAMETER, CONSTRUCTOR
   }

   public enum Properties {
      name, elementType, scope
   }

	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

   JavaDomainDomainPlugin(App app) {
      super(app, "JavaDomain");

		final Node domainNode = getGraph().findOrCreate(Domain, AppMotif.Properties.name.name(), "JavaDomain");
		entitiesNodeMap.put(Entities._package, newDomainEntity(getGraph(), Entities._package, domainNode));
		entitiesNodeMap.put(Entities.Class, newDomainEntity(getGraph(), Entities.Class, domainNode));
		entitiesNodeMap.put(Entities.Object, newDomainEntity(getGraph(), Entities.Object, domainNode));
		entitiesNodeMap.put(Entities.Field, newDomainEntity(getGraph(), Entities.Field, domainNode));
		entitiesNodeMap.put(Entities.FieldType, newDomainEntity(getGraph(), Entities.FieldType, domainNode));
		entitiesNodeMap.put(Entities.Instantiator, newDomainEntity(getGraph(), Entities.Instantiator, domainNode));
		entitiesNodeMap.put(Entities.Method, newDomainEntity(getGraph(), Entities.Method, domainNode));
		entitiesNodeMap.put(Entities.Statement, newDomainEntity(getGraph(), Entities.Statement, domainNode));
		entitiesNodeMap.put(Entities.Parameter, newDomainEntity(getGraph(), Entities.Parameter, domainNode));
		entitiesNodeMap.put(Entities.Constructor, newDomainEntity(getGraph(), Entities.Constructor, domainNode));

		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities._package), Properties.name.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Class), Properties.name.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Object), Properties.name.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Field), Properties.scope.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Field), Properties.name.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.FieldType), Properties.name.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.FieldType), Properties.elementType.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Instantiator), Properties.name.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Method), Properties.name.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Statement), Properties.name.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Parameter), Properties.name.name());

		relate(domainNode, entitiesNodeMap.get(Entities._package), DomainPlugin.Relations.ENTITY);
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities._package), Relations.CLASS.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Class));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Class), Relations.OBJECT.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Object));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Class), Relations.FIELD.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Field));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Class), Relations.METHOD.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Method));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Class), Relations.CONSTRUCTOR.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Constructor));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Field), Relations.TYPE.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.FieldType));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Field), Relations.INSTANTIATION.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Instantiator));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Method), Relations.BLOCK.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Statement));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Method), Relations.PARAMETER.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Parameter));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Statement), Relations.NEXT.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Statement));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Parameter), Relations.TYPE.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Class));
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
		if (is_package(neoNode.getNode())) handle_package(pop, neoNode, selectedNodes);
		if (isClass(neoNode.getNode())) handleClass(pop, neoNode, selectedNodes);
		if (isObject(neoNode.getNode())) handleObject(pop, neoNode, selectedNodes);
		if (isField(neoNode.getNode())) handleField(pop, neoNode, selectedNodes);
		if (isFieldType(neoNode.getNode())) handleFieldType(pop, neoNode, selectedNodes);
		if (isInstantiator(neoNode.getNode())) handleInstantiator(pop, neoNode, selectedNodes);
		if (isMethod(neoNode.getNode())) handleMethod(pop, neoNode, selectedNodes);
		if (isStatement(neoNode.getNode())) handleStatement(pop, neoNode, selectedNodes);
		if (isParameter(neoNode.getNode())) handleParameter(pop, neoNode, selectedNodes);
		if (isConstructor(neoNode.getNode())) handleConstructor(pop, neoNode, selectedNodes);
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
		if (is_package(neoNode.getNode())) return new_packageEditor(neoNode);
		if (isClass(neoNode.getNode())) return newClassEditor(neoNode);
		if (isObject(neoNode.getNode())) return newObjectEditor(neoNode);
		if (isField(neoNode.getNode())) return newFieldEditor(neoNode);
		if (isFieldType(neoNode.getNode())) return newFieldTypeEditor(neoNode);
		if (isInstantiator(neoNode.getNode())) return newInstantiatorEditor(neoNode);
		if (isMethod(neoNode.getNode())) return newMethodEditor(neoNode);
		if (isStatement(neoNode.getNode())) return newStatementEditor(neoNode);
		if (isParameter(neoNode.getNode())) return newParameterEditor(neoNode);
		if (isConstructor(neoNode.getNode())) return newConstructorEditor(neoNode);
      return null;
   }

	protected void handle_package(JPopupMenu pop, NeoNode _packageNode, Set<NeoNode> selectedNodes) { }
	protected void handleClass(JPopupMenu pop, NeoNode classNode, Set<NeoNode> selectedNodes) { }
	protected void handleObject(JPopupMenu pop, NeoNode objectNode, Set<NeoNode> selectedNodes) { }
	protected void handleField(JPopupMenu pop, NeoNode fieldNode, Set<NeoNode> selectedNodes) { }
	protected void handleFieldType(JPopupMenu pop, NeoNode fieldTypeNode, Set<NeoNode> selectedNodes) { }
	protected void handleInstantiator(JPopupMenu pop, NeoNode instantiatorNode, Set<NeoNode> selectedNodes) { }
	protected void handleMethod(JPopupMenu pop, NeoNode methodNode, Set<NeoNode> selectedNodes) { }
	protected void handleStatement(JPopupMenu pop, NeoNode statementNode, Set<NeoNode> selectedNodes) { }
	protected void handleParameter(JPopupMenu pop, NeoNode parameterNode, Set<NeoNode> selectedNodes) { }
	protected void handleConstructor(JPopupMenu pop, NeoNode constructorNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent new_packageEditor(NeoNode _packageNode) { return null; }
	protected JComponent newClassEditor(NeoNode classNode) { return null; }
	protected JComponent newObjectEditor(NeoNode objectNode) { return null; }
	protected JComponent newFieldEditor(NeoNode fieldNode) { return null; }
	protected JComponent newFieldTypeEditor(NeoNode fieldTypeNode) { return null; }
	protected JComponent newInstantiatorEditor(NeoNode instantiatorNode) { return null; }
	protected JComponent newMethodEditor(NeoNode methodNode) { return null; }
	protected JComponent newStatementEditor(NeoNode statementNode) { return null; }
	protected JComponent newParameterEditor(NeoNode parameterNode) { return null; }
	protected JComponent newConstructorEditor(NeoNode constructorNode) { return null; }

	public static boolean is_package(Node node) { return hasLabel(node, Entities._package); }
	public static boolean isClass(Node node) { return hasLabel(node, Entities.Class); }
	public static boolean isObject(Node node) { return hasLabel(node, Entities.Object); }
	public static boolean isField(Node node) { return hasLabel(node, Entities.Field); }
	public static boolean isFieldType(Node node) { return hasLabel(node, Entities.FieldType); }
	public static boolean isInstantiator(Node node) { return hasLabel(node, Entities.Instantiator); }
	public static boolean isMethod(Node node) { return hasLabel(node, Entities.Method); }
	public static boolean isStatement(Node node) { return hasLabel(node, Entities.Statement); }
	public static boolean isParameter(Node node) { return hasLabel(node, Entities.Parameter); }
	public static boolean isConstructor(Node node) { return hasLabel(node, Entities.Constructor); }

	protected Node new_package() { return new_package(getGraph()); } 
	public static Node new_package(NeoModel graph) { return newInstanceNode(graph, Entities._package.name(), entitiesNodeMap.get(Entities._package)); } 
	protected Node new_package(Object name) { return new_package(getGraph(), name); } 
	public static Node new_package(NeoModel graph, Object name) {  	
		final Node newNode = new_package(graph); 	
		if (name != null) relate(newNode, newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newClass() { return newClass(getGraph()); } 
	public static Node newClass(NeoModel graph) { return newInstanceNode(graph, Entities.Class.name(), entitiesNodeMap.get(Entities.Class)); } 
	protected Node newClass(Object name) { return newClass(getGraph(), name); } 
	public static Node newClass(NeoModel graph, Object name) {  	
		final Node newNode = newClass(graph); 	
		if (name != null) relate(newNode, newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newObject() { return newObject(getGraph()); } 
	public static Node newObject(NeoModel graph) { return newInstanceNode(graph, Entities.Object.name(), entitiesNodeMap.get(Entities.Object)); } 
	protected Node newObject(Object name) { return newObject(getGraph(), name); } 
	public static Node newObject(NeoModel graph, Object name) {  	
		final Node newNode = newObject(graph); 	
		if (name != null) relate(newNode, newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newField() { return newField(getGraph()); } 
	public static Node newField(NeoModel graph) { return newInstanceNode(graph, Entities.Field.name(), entitiesNodeMap.get(Entities.Field)); } 
	protected Node newField(Object scope, Object name) { return newField(getGraph(), scope, name); } 
	public static Node newField(NeoModel graph, Object scope, Object name) {  	
		final Node newNode = newField(graph); 	
		if (scope != null) relate(newNode, newValueNode(graph, scope), RelationshipType.withName(Properties.scope.name()));
		if (name != null) relate(newNode, newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newFieldType() { return newFieldType(getGraph()); } 
	public static Node newFieldType(NeoModel graph) { return newInstanceNode(graph, Entities.FieldType.name(), entitiesNodeMap.get(Entities.FieldType)); } 
	protected Node newFieldType(Object name, Object elementType) { return newFieldType(getGraph(), name, elementType); } 
	public static Node newFieldType(NeoModel graph, Object name, Object elementType) {  	
		final Node newNode = newFieldType(graph); 	
		if (name != null) relate(newNode, newValueNode(graph, name), RelationshipType.withName(Properties.name.name()));
		if (elementType != null) relate(newNode, newValueNode(graph, elementType), RelationshipType.withName(Properties.elementType.name())); 	
		return newNode; 
	}

	protected Node newInstantiator() { return newInstantiator(getGraph()); } 
	public static Node newInstantiator(NeoModel graph) { return newInstanceNode(graph, Entities.Instantiator.name(), entitiesNodeMap.get(Entities.Instantiator)); } 
	protected Node newInstantiator(Object name) { return newInstantiator(getGraph(), name); } 
	public static Node newInstantiator(NeoModel graph, Object name) {  	
		final Node newNode = newInstantiator(graph); 	
		if (name != null) relate(newNode, newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newMethod() { return newMethod(getGraph()); } 
	public static Node newMethod(NeoModel graph) { return newInstanceNode(graph, Entities.Method.name(), entitiesNodeMap.get(Entities.Method)); } 
	protected Node newMethod(Object name) { return newMethod(getGraph(), name); } 
	public static Node newMethod(NeoModel graph, Object name) {  	
		final Node newNode = newMethod(graph); 	
		if (name != null) relate(newNode, newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newStatement() { return newStatement(getGraph()); } 
	public static Node newStatement(NeoModel graph) { return newInstanceNode(graph, Entities.Statement.name(), entitiesNodeMap.get(Entities.Statement)); } 
	protected Node newStatement(Object name) { return newStatement(getGraph(), name); } 
	public static Node newStatement(NeoModel graph, Object name) {  	
		final Node newNode = newStatement(graph); 	
		if (name != null) relate(newNode, newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newParameter() { return newParameter(getGraph()); } 
	public static Node newParameter(NeoModel graph) { return newInstanceNode(graph, Entities.Parameter.name(), entitiesNodeMap.get(Entities.Parameter)); } 
	protected Node newParameter(Object name) { return newParameter(getGraph(), name); } 
	public static Node newParameter(NeoModel graph, Object name) {  	
		final Node newNode = newParameter(graph); 	
		if (name != null) relate(newNode, newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newConstructor() { return newConstructor(getGraph()); } 
	public static Node newConstructor(NeoModel graph) { return newInstanceNode(graph, Entities.Constructor.name(), entitiesNodeMap.get(Entities.Constructor)); }


	public static void outgoing_PACKAGE(Node src, RelationConsumer consumer) { outgoing(src, Relations._PACKAGE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoing_PACKAGE(Node src) { return other(src, singleOutgoing(src, Relations._PACKAGE)); }
	public static void incoming_PACKAGE(Node src, RelationConsumer consumer) { incoming(src, Relations._PACKAGE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncoming_PACKAGE(Node src) { return other(src, singleIncoming(src, Relations._PACKAGE)); }

	public static void outgoingCLASS(Node src, RelationConsumer consumer) { outgoing(src, Relations.CLASS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingCLASS(Node src) { return other(src, singleOutgoing(src, Relations.CLASS)); }
	public static void incomingCLASS(Node src, RelationConsumer consumer) { incoming(src, Relations.CLASS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingCLASS(Node src) { return other(src, singleIncoming(src, Relations.CLASS)); }

	public static void outgoingOBJECT(Node src, RelationConsumer consumer) { outgoing(src, Relations.OBJECT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingOBJECT(Node src) { return other(src, singleOutgoing(src, Relations.OBJECT)); }
	public static void incomingOBJECT(Node src, RelationConsumer consumer) { incoming(src, Relations.OBJECT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingOBJECT(Node src) { return other(src, singleIncoming(src, Relations.OBJECT)); }

	public static void outgoingFIELD(Node src, RelationConsumer consumer) { outgoing(src, Relations.FIELD).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingFIELD(Node src) { return other(src, singleOutgoing(src, Relations.FIELD)); }
	public static void incomingFIELD(Node src, RelationConsumer consumer) { incoming(src, Relations.FIELD).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingFIELD(Node src) { return other(src, singleIncoming(src, Relations.FIELD)); }

	public static void outgoingTYPE(Node src, RelationConsumer consumer) { outgoing(src, Relations.TYPE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingTYPE(Node src) { return other(src, singleOutgoing(src, Relations.TYPE)); }
	public static void incomingTYPE(Node src, RelationConsumer consumer) { incoming(src, Relations.TYPE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingTYPE(Node src) { return other(src, singleIncoming(src, Relations.TYPE)); }

	public static void outgoingINSTANTIATION(Node src, RelationConsumer consumer) { outgoing(src, Relations.INSTANTIATION).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingINSTANTIATION(Node src) { return other(src, singleOutgoing(src, Relations.INSTANTIATION)); }
	public static void incomingINSTANTIATION(Node src, RelationConsumer consumer) { incoming(src, Relations.INSTANTIATION).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingINSTANTIATION(Node src) { return other(src, singleIncoming(src, Relations.INSTANTIATION)); }

	public static void outgoingMETHOD(Node src, RelationConsumer consumer) { outgoing(src, Relations.METHOD).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingMETHOD(Node src) { return other(src, singleOutgoing(src, Relations.METHOD)); }
	public static void incomingMETHOD(Node src, RelationConsumer consumer) { incoming(src, Relations.METHOD).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingMETHOD(Node src) { return other(src, singleIncoming(src, Relations.METHOD)); }

	public static void outgoingBLOCK(Node src, RelationConsumer consumer) { outgoing(src, Relations.BLOCK).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingBLOCK(Node src) { return other(src, singleOutgoing(src, Relations.BLOCK)); }
	public static void incomingBLOCK(Node src, RelationConsumer consumer) { incoming(src, Relations.BLOCK).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingBLOCK(Node src) { return other(src, singleIncoming(src, Relations.BLOCK)); }

	public static void outgoingNEXT(Node src, RelationConsumer consumer) { outgoing(src, Relations.NEXT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingNEXT(Node src) { return other(src, singleOutgoing(src, Relations.NEXT)); }
	public static void incomingNEXT(Node src, RelationConsumer consumer) { incoming(src, Relations.NEXT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingNEXT(Node src) { return other(src, singleIncoming(src, Relations.NEXT)); }

	public static void outgoingPARAMETER(Node src, RelationConsumer consumer) { outgoing(src, Relations.PARAMETER).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPARAMETER(Node src) { return other(src, singleOutgoing(src, Relations.PARAMETER)); }
	public static void incomingPARAMETER(Node src, RelationConsumer consumer) { incoming(src, Relations.PARAMETER).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPARAMETER(Node src) { return other(src, singleIncoming(src, Relations.PARAMETER)); }

	public static void outgoingCONSTRUCTOR(Node src, RelationConsumer consumer) { outgoing(src, Relations.CONSTRUCTOR).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingCONSTRUCTOR(Node src) { return other(src, singleOutgoing(src, Relations.CONSTRUCTOR)); }
	public static void incomingCONSTRUCTOR(Node src, RelationConsumer consumer) { incoming(src, Relations.CONSTRUCTOR).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingCONSTRUCTOR(Node src) { return other(src, singleIncoming(src, Relations.CONSTRUCTOR)); }


	public static Relationship relate_PACKAGE(Node src, Node dst) { return relate(src, dst, Relations._PACKAGE); }
	public static Relationship relateCLASS(Node src, Node dst) { return relate(src, dst, Relations.CLASS); }
	public static Relationship relateOBJECT(Node src, Node dst) { return relate(src, dst, Relations.OBJECT); }
	public static Relationship relateFIELD(Node src, Node dst) { return relate(src, dst, Relations.FIELD); }
	public static Relationship relateTYPE(Node src, Node dst) { return relate(src, dst, Relations.TYPE); }
	public static Relationship relateINSTANTIATION(Node src, Node dst) { return relate(src, dst, Relations.INSTANTIATION); }
	public static Relationship relateMETHOD(Node src, Node dst) { return relate(src, dst, Relations.METHOD); }
	public static Relationship relateBLOCK(Node src, Node dst) { return relate(src, dst, Relations.BLOCK); }
	public static Relationship relateNEXT(Node src, Node dst) { return relate(src, dst, Relations.NEXT); }
	public static Relationship relatePARAMETER(Node src, Node dst) { return relate(src, dst, Relations.PARAMETER); }
	public static Relationship relateCONSTRUCTOR(Node src, Node dst) { return relate(src, dst, Relations.CONSTRUCTOR); }

	// name
	public static <T> T getNameProperty(PropertyContainer container) { return getEntityProperty(container, Properties.name.name()); }
	public static <T> T getNameProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.name.name(), defaultValue); }
	public static boolean hasNameProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.name.name()); }
	public static <T extends PropertyContainer> T setNameProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.name.name(), value); return container; }
	protected <T extends PropertyContainer> T setNameProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.name.name(), value); return container; }
	public static <T extends PropertyContainer> T removeNameProperty(T container) { removeEntityProperty(container, Properties.name.name()); return container; }

	// elementType
	public static <T> T getElementTypeProperty(PropertyContainer container) { return getEntityProperty(container, Properties.elementType.name()); }
	public static <T> T getElementTypeProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.elementType.name(), defaultValue); }
	public static boolean hasElementTypeProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.elementType.name()); }
	public static <T extends PropertyContainer> T setElementTypeProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.elementType.name(), value); return container; }
	protected <T extends PropertyContainer> T setElementTypeProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.elementType.name(), value); return container; }
	public static <T extends PropertyContainer> T removeElementTypeProperty(T container) { removeEntityProperty(container, Properties.elementType.name()); return container; }

	// scope
	public static <T> T getScopeProperty(PropertyContainer container) { return getEntityProperty(container, Properties.scope.name()); }
	public static <T> T getScopeProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.scope.name(), defaultValue); }
	public static boolean hasScopeProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.scope.name()); }
	public static <T extends PropertyContainer> T setScopeProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.scope.name(), value); return container; }
	protected <T extends PropertyContainer> T setScopeProperty(T container, Object value) { setEntityProperty(getGraph(), container, Properties.scope.name(), value); return container; }
	public static <T extends PropertyContainer> T removeScopeProperty(T container) { removeEntityProperty(container, Properties.scope.name()); return container; }

}