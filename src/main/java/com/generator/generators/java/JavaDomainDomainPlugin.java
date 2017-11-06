package com.generator.generators.java;

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
 * Auto-generated from domain JavaDomainDomainPlugin
 */
abstract class JavaDomainDomainPlugin extends Plugin {

	public enum Entities implements Label {
      _package, Class, Object, Field, FieldType, Instantiator, Method, Statement, Parameter, Constructor
   }

   public enum Relations implements RelationshipType {
      CLASS, OBJECT, FIELD, TYPE, INSTANTIATION, METHOD, BLOCK, NEXT, PARAMETER, CONSTRUCTOR
   }

   public enum Properties {
      elementType, scope
   }

   JavaDomainDomainPlugin(App app) {
      super(app, "JavaDomain");
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

	protected void handle_package(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleClass(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleObject(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleField(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleFieldType(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleInstantiator(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleMethod(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleStatement(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleParameter(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }
	protected void handleConstructor(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent new_packageEditor(NeoNode neoNode) { return null; }
	protected JComponent newClassEditor(NeoNode neoNode) { return null; }
	protected JComponent newObjectEditor(NeoNode neoNode) { return null; }
	protected JComponent newFieldEditor(NeoNode neoNode) { return null; }
	protected JComponent newFieldTypeEditor(NeoNode neoNode) { return null; }
	protected JComponent newInstantiatorEditor(NeoNode neoNode) { return null; }
	protected JComponent newMethodEditor(NeoNode neoNode) { return null; }
	protected JComponent newStatementEditor(NeoNode neoNode) { return null; }
	protected JComponent newParameterEditor(NeoNode neoNode) { return null; }
	protected JComponent newConstructorEditor(NeoNode neoNode) { return null; }

	protected Node new_package(String name) { return new_package(getGraph(), name); }
	protected Node new_package() { return new_package(getGraph()); } 
	protected Node newClass(String name) { return newClass(getGraph(), name); }
	protected Node newClass() { return newClass(getGraph()); } 
	protected Node newObject(String name) { return newObject(getGraph(), name); }
	protected Node newObject() { return newObject(getGraph()); } 
	protected Node newField(String name) { return newField(getGraph(), name); }
	protected Node newField() { return newField(getGraph()); } 
	protected Node newFieldType(String name) { return newFieldType(getGraph(), name); }
	protected Node newFieldType() { return newFieldType(getGraph()); } 
	protected Node newInstantiator(String name) { return newInstantiator(getGraph(), name); }
	protected Node newInstantiator() { return newInstantiator(getGraph()); } 
	protected Node newMethod(String name) { return newMethod(getGraph(), name); }
	protected Node newMethod() { return newMethod(getGraph()); } 
	protected Node newStatement(String name) { return newStatement(getGraph(), name); }
	protected Node newStatement() { return newStatement(getGraph()); } 
	protected Node newParameter(String name) { return newParameter(getGraph(), name); }
	protected Node newParameter() { return newParameter(getGraph()); } 
	protected Node newConstructor(String name) { return newConstructor(getGraph(), name); }
	protected Node newConstructor() { return newConstructor(getGraph()); } 

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

	public static Node new_package(NeoModel graph, String name) { return graph.newNode(Entities._package, AppMotif.Properties.name.name(), name); }
	public static Node new_package(NeoModel graph) { return graph.newNode(Entities._package); }
	public static Node newClass(NeoModel graph, String name) { return graph.newNode(Entities.Class, AppMotif.Properties.name.name(), name); }
	public static Node newClass(NeoModel graph) { return graph.newNode(Entities.Class); }
	public static Node newObject(NeoModel graph, String name) { return graph.newNode(Entities.Object, AppMotif.Properties.name.name(), name); }
	public static Node newObject(NeoModel graph) { return graph.newNode(Entities.Object); }
	public static Node newField(NeoModel graph, String name) { return graph.newNode(Entities.Field, AppMotif.Properties.name.name(), name); }
	public static Node newField(NeoModel graph) { return graph.newNode(Entities.Field); }
	public static Node newFieldType(NeoModel graph, String name) { return graph.newNode(Entities.FieldType, AppMotif.Properties.name.name(), name); }
	public static Node newFieldType(NeoModel graph) { return graph.newNode(Entities.FieldType); }
	public static Node newInstantiator(NeoModel graph, String name) { return graph.newNode(Entities.Instantiator, AppMotif.Properties.name.name(), name); }
	public static Node newInstantiator(NeoModel graph) { return graph.newNode(Entities.Instantiator); }
	public static Node newMethod(NeoModel graph, String name) { return graph.newNode(Entities.Method, AppMotif.Properties.name.name(), name); }
	public static Node newMethod(NeoModel graph) { return graph.newNode(Entities.Method); }
	public static Node newStatement(NeoModel graph, String name) { return graph.newNode(Entities.Statement, AppMotif.Properties.name.name(), name); }
	public static Node newStatement(NeoModel graph) { return graph.newNode(Entities.Statement); }
	public static Node newParameter(NeoModel graph, String name) { return graph.newNode(Entities.Parameter, AppMotif.Properties.name.name(), name); }
	public static Node newParameter(NeoModel graph) { return graph.newNode(Entities.Parameter); }
	public static Node newConstructor(NeoModel graph, String name) { return graph.newNode(Entities.Constructor, AppMotif.Properties.name.name(), name); }
	public static Node newConstructor(NeoModel graph) { return graph.newNode(Entities.Constructor); }

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

	// get name as property of a node (node.name)
	public static String getNameProperty(PropertyContainer node) { return DomainMotif.getName(node); }
	public static String getNameProperty(NeoNode neoNode) { return DomainMotif.getName(neoNode); }
	public static void setNameProperty(PropertyContainer node, String name) { DomainMotif.setName(node, name); }
	public static void setNameProperty(NeoNode neoNode, String name) { DomainMotif.setName(neoNode, name); }

	// get name for Domain-Property (entityNode -> name -> valueNode.name)	
	public static String getEntityName(Node classNode) { return DomainMotif.getEntityProperty(classNode, AppMotif.Properties.name.name()); }
	public static String getEntityName(Node classNode, String defaultValue) { return DomainMotif.getEntityProperty(classNode, AppMotif.Properties.name.name(), defaultValue); }

	public static <T> T getElementType(PropertyContainer container) { return get(container, Properties.elementType.name()); }
	public static <T> T getElementType(PropertyContainer container, T defaultValue) { return has(container, Properties.elementType.name()) ? get(container, Properties.elementType.name()) : defaultValue; }
	public static boolean hasElementType(PropertyContainer container) { return has(container, Properties.elementType.name()); }
	public static <T extends PropertyContainer> T setElementType(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.elementType.name());
	   else
	   	container.setProperty(Properties.elementType.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removeElementType(T container) {
		if (has(container, Properties.elementType.name())) container.removeProperty(Properties.elementType.name());
	      return container;
	}

	public static <T> T getScope(PropertyContainer container) { return get(container, Properties.scope.name()); }
	public static <T> T getScope(PropertyContainer container, T defaultValue) { return has(container, Properties.scope.name()) ? get(container, Properties.scope.name()) : defaultValue; }
	public static boolean hasScope(PropertyContainer container) { return has(container, Properties.scope.name()); }
	public static <T extends PropertyContainer> T setScope(T container, Object value) {
		if (value == null)
	   	container.removeProperty(Properties.scope.name());
	   else
	   	container.setProperty(Properties.scope.name(), value);
	   return container;
	}
	public static <T extends PropertyContainer> T removeScope(T container) {
		if (has(container, Properties.scope.name())) container.removeProperty(Properties.scope.name());
	      return container;
	}

}