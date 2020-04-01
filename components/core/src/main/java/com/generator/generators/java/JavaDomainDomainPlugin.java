package com.generator.generators.java;

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
 * Auto-generated from domain JavaDomainDomainPlugin
 */
public abstract class JavaDomainDomainPlugin extends Plugin {

	public enum Entities implements Label {
      _package, Class, Object, Field, Method, Statement, Parameter, Constructor, Instantiator, Map, List, Set, Jar
   }

   public enum Relations implements RelationshipType {
      _PACKAGE, JAR, CLASS, INSTANCE, FIELD, TYPE, METHOD, BLOCK, NEXT, PARAMETER, CONSTRUCTOR, INSTANTIATION, MAP, LIST, SET, RETURNVALUE
   }

   public enum Properties {
      name, code, scope, hasSetter, isFinal, isEqha, isToString, hasGetter, isArray, isAbstract, implementation, valueType, keyType, elementName, elementType
   }

	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

	private final Node domainNode;

   JavaDomainDomainPlugin(App app) {
      super(app, "JavaDomain");

		domainNode = DomainMotif.newDomainNode(getGraph(), "JavaDomain");
		entitiesNodeMap.put(Entities._package, DomainMotif.newDomainEntity(getGraph(), Entities._package, domainNode));
		entitiesNodeMap.put(Entities.Class, DomainMotif.newDomainEntity(getGraph(), Entities.Class, domainNode));
		entitiesNodeMap.put(Entities.Object, DomainMotif.newDomainEntity(getGraph(), Entities.Object, domainNode));
		entitiesNodeMap.put(Entities.Field, DomainMotif.newDomainEntity(getGraph(), Entities.Field, domainNode));
		entitiesNodeMap.put(Entities.Method, DomainMotif.newDomainEntity(getGraph(), Entities.Method, domainNode));
		entitiesNodeMap.put(Entities.Statement, DomainMotif.newDomainEntity(getGraph(), Entities.Statement, domainNode));
		entitiesNodeMap.put(Entities.Parameter, DomainMotif.newDomainEntity(getGraph(), Entities.Parameter, domainNode));
		entitiesNodeMap.put(Entities.Constructor, DomainMotif.newDomainEntity(getGraph(), Entities.Constructor, domainNode));
		entitiesNodeMap.put(Entities.Instantiator, DomainMotif.newDomainEntity(getGraph(), Entities.Instantiator, domainNode));
		entitiesNodeMap.put(Entities.Map, DomainMotif.newDomainEntity(getGraph(), Entities.Map, domainNode));
		entitiesNodeMap.put(Entities.List, DomainMotif.newDomainEntity(getGraph(), Entities.List, domainNode));
		entitiesNodeMap.put(Entities.Set, DomainMotif.newDomainEntity(getGraph(), Entities.Set, domainNode));
		entitiesNodeMap.put(Entities.Jar, DomainMotif.newDomainEntity(getGraph(), Entities.Jar, domainNode));

		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities._package), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Class), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Class), Properties.isAbstract.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Class), Properties.isFinal.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Class), Properties.scope.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Object), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Field), Properties.scope.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Field), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Field), Properties.hasSetter.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Field), Properties.isFinal.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Field), Properties.isEqha.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Field), Properties.isToString.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Field), Properties.hasGetter.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Field), Properties.isArray.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Method), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Method), Properties.scope.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Statement), Properties.code.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Parameter), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Constructor), Properties.scope.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Instantiator), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Map), Properties.implementation.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Map), Properties.valueType.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Map), Properties.keyType.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Map), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.List), Properties.elementName.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.List), Properties.elementType.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.List), Properties.implementation.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.List), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Set), Properties.elementName.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Set), Properties.implementation.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Set), Properties.elementType.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Set), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Jar), Properties.name.name());

		relate(domainNode, entitiesNodeMap.get(Entities._package), DomainPlugin.Relations.ENTITY);
		relate(domainNode, entitiesNodeMap.get(Entities.Jar), DomainPlugin.Relations.ENTITY);
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities._package), Relations.CLASS.name(), DomainDomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Class));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Class), Relations.INSTANCE.name(), DomainDomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Object));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Class), Relations.FIELD.name(), DomainDomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Field));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Class), Relations.METHOD.name(), DomainDomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Method));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Class), Relations.CONSTRUCTOR.name(), DomainDomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Constructor));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Class), Relations.MAP.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Map));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Class), Relations.LIST.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.List));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Class), Relations.SET.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Set));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Field), Relations.TYPE.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Class));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Field), Relations.INSTANTIATION.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Instantiator));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Method), Relations.BLOCK.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Statement));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Method), Relations.PARAMETER.name(), DomainDomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Parameter));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Method), Relations.RETURNVALUE.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Class));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Statement), Relations.NEXT.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Statement));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Parameter), Relations.TYPE.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Class));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Constructor), Relations.PARAMETER.name(), DomainDomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Field));
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
		if (isMethod(neoNode.getNode())) handleMethod(pop, neoNode, selectedNodes);
		if (isStatement(neoNode.getNode())) handleStatement(pop, neoNode, selectedNodes);
		if (isParameter(neoNode.getNode())) handleParameter(pop, neoNode, selectedNodes);
		if (isConstructor(neoNode.getNode())) handleConstructor(pop, neoNode, selectedNodes);
		if (isInstantiator(neoNode.getNode())) handleInstantiator(pop, neoNode, selectedNodes);
		if (isMap(neoNode.getNode())) handleMap(pop, neoNode, selectedNodes);
		if (isList(neoNode.getNode())) handleList(pop, neoNode, selectedNodes);
		if (isSet(neoNode.getNode())) handleSet(pop, neoNode, selectedNodes);
		if (isJar(neoNode.getNode())) handleJar(pop, neoNode, selectedNodes);
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
		if (is_package(neoNode.getNode())) return new_packageEditor(neoNode);
		if (isClass(neoNode.getNode())) return newClassEditor(neoNode);
		if (isObject(neoNode.getNode())) return newObjectEditor(neoNode);
		if (isField(neoNode.getNode())) return newFieldEditor(neoNode);
		if (isMethod(neoNode.getNode())) return newMethodEditor(neoNode);
		if (isStatement(neoNode.getNode())) return newStatementEditor(neoNode);
		if (isParameter(neoNode.getNode())) return newParameterEditor(neoNode);
		if (isConstructor(neoNode.getNode())) return newConstructorEditor(neoNode);
		if (isInstantiator(neoNode.getNode())) return newInstantiatorEditor(neoNode);
		if (isMap(neoNode.getNode())) return newMapEditor(neoNode);
		if (isList(neoNode.getNode())) return newListEditor(neoNode);
		if (isSet(neoNode.getNode())) return newSetEditor(neoNode);
		if (isJar(neoNode.getNode())) return newJarEditor(neoNode);
      return null;
   }

	public Node getDomainNode() { return domainNode; }

	public Node getEntityNode(Label label) { return entitiesNodeMap.get(label); }

	protected void handle_package(JPopupMenu pop, NeoNode _packageNode, Set<NeoNode> selectedNodes) { }
	protected void handleClass(JPopupMenu pop, NeoNode classNode, Set<NeoNode> selectedNodes) { }
	protected void handleObject(JPopupMenu pop, NeoNode objectNode, Set<NeoNode> selectedNodes) { }
	protected void handleField(JPopupMenu pop, NeoNode fieldNode, Set<NeoNode> selectedNodes) { }
	protected void handleMethod(JPopupMenu pop, NeoNode methodNode, Set<NeoNode> selectedNodes) { }
	protected void handleStatement(JPopupMenu pop, NeoNode statementNode, Set<NeoNode> selectedNodes) { }
	protected void handleParameter(JPopupMenu pop, NeoNode parameterNode, Set<NeoNode> selectedNodes) { }
	protected void handleConstructor(JPopupMenu pop, NeoNode constructorNode, Set<NeoNode> selectedNodes) { }
	protected void handleInstantiator(JPopupMenu pop, NeoNode instantiatorNode, Set<NeoNode> selectedNodes) { }
	protected void handleMap(JPopupMenu pop, NeoNode mapNode, Set<NeoNode> selectedNodes) { }
	protected void handleList(JPopupMenu pop, NeoNode listNode, Set<NeoNode> selectedNodes) { }
	protected void handleSet(JPopupMenu pop, NeoNode setNode, Set<NeoNode> selectedNodes) { }
	protected void handleJar(JPopupMenu pop, NeoNode jarNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent new_packageEditor(NeoNode _packageNode) { return null; }
	protected JComponent newClassEditor(NeoNode classNode) { return null; }
	protected JComponent newObjectEditor(NeoNode objectNode) { return null; }
	protected JComponent newFieldEditor(NeoNode fieldNode) { return null; }
	protected JComponent newMethodEditor(NeoNode methodNode) { return null; }
	protected JComponent newStatementEditor(NeoNode statementNode) { return null; }
	protected JComponent newParameterEditor(NeoNode parameterNode) { return null; }
	protected JComponent newConstructorEditor(NeoNode constructorNode) { return null; }
	protected JComponent newInstantiatorEditor(NeoNode instantiatorNode) { return null; }
	protected JComponent newMapEditor(NeoNode mapNode) { return null; }
	protected JComponent newListEditor(NeoNode listNode) { return null; }
	protected JComponent newSetEditor(NeoNode setNode) { return null; }
	protected JComponent newJarEditor(NeoNode jarNode) { return null; }

	public static boolean is_package(Node node) { return hasLabel(node, Entities._package); }
	public static boolean isClass(Node node) { return hasLabel(node, Entities.Class); }
	public static boolean isObject(Node node) { return hasLabel(node, Entities.Object); }
	public static boolean isField(Node node) { return hasLabel(node, Entities.Field); }
	public static boolean isMethod(Node node) { return hasLabel(node, Entities.Method); }
	public static boolean isStatement(Node node) { return hasLabel(node, Entities.Statement); }
	public static boolean isParameter(Node node) { return hasLabel(node, Entities.Parameter); }
	public static boolean isConstructor(Node node) { return hasLabel(node, Entities.Constructor); }
	public static boolean isInstantiator(Node node) { return hasLabel(node, Entities.Instantiator); }
	public static boolean isMap(Node node) { return hasLabel(node, Entities.Map); }
	public static boolean isList(Node node) { return hasLabel(node, Entities.List); }
	public static boolean isSet(Node node) { return hasLabel(node, Entities.Set); }
	public static boolean isJar(Node node) { return hasLabel(node, Entities.Jar); }

	protected Node new_package() { return new_package(getGraph()); } 
	protected Node new_package(Object name) { return new_package(getGraph(), name); } 

	public static Node new_package(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities._package)); } 
	public static Node new_package(NeoModel graph, Object name) {  	
		final Node newNode = new_package(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newClass() { return newClass(getGraph()); } 
	protected Node newClass(Object name, Object isAbstract, Object isFinal, Object scope) { return newClass(getGraph(), name, isAbstract, isFinal, scope); } 

	public static Node newClass(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Class)); } 
	public static Node newClass(NeoModel graph, Object name, Object isAbstract, Object isFinal, Object scope) {  	
		final Node newNode = newClass(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name()));
		if (isAbstract != null) relate(newNode, DomainMotif.newValueNode(graph, isAbstract), RelationshipType.withName(Properties.isAbstract.name()));
		if (isFinal != null) relate(newNode, DomainMotif.newValueNode(graph, isFinal), RelationshipType.withName(Properties.isFinal.name()));
		if (scope != null) relate(newNode, DomainMotif.newValueNode(graph, scope), RelationshipType.withName(Properties.scope.name())); 	
		return newNode; 
	}

	protected Node newObject() { return newObject(getGraph()); } 
	protected Node newObject(Object name) { return newObject(getGraph(), name); } 

	public static Node newObject(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Object)); } 
	public static Node newObject(NeoModel graph, Object name) {  	
		final Node newNode = newObject(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newField() { return newField(getGraph()); } 
	protected Node newField(Object scope, Object name, Object hasSetter, Object isFinal, Object isEqha, Object isToString, Object hasGetter, Object isArray) { return newField(getGraph(), scope, name, hasSetter, isFinal, isEqha, isToString, hasGetter, isArray); } 

	public static Node newField(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Field)); } 
	public static Node newField(NeoModel graph, Object scope, Object name, Object hasSetter, Object isFinal, Object isEqha, Object isToString, Object hasGetter, Object isArray) {  	
		final Node newNode = newField(graph); 	
		if (scope != null) relate(newNode, DomainMotif.newValueNode(graph, scope), RelationshipType.withName(Properties.scope.name()));
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name()));
		if (hasSetter != null) relate(newNode, DomainMotif.newValueNode(graph, hasSetter), RelationshipType.withName(Properties.hasSetter.name()));
		if (isFinal != null) relate(newNode, DomainMotif.newValueNode(graph, isFinal), RelationshipType.withName(Properties.isFinal.name()));
		if (isEqha != null) relate(newNode, DomainMotif.newValueNode(graph, isEqha), RelationshipType.withName(Properties.isEqha.name()));
		if (isToString != null) relate(newNode, DomainMotif.newValueNode(graph, isToString), RelationshipType.withName(Properties.isToString.name()));
		if (hasGetter != null) relate(newNode, DomainMotif.newValueNode(graph, hasGetter), RelationshipType.withName(Properties.hasGetter.name()));
		if (isArray != null) relate(newNode, DomainMotif.newValueNode(graph, isArray), RelationshipType.withName(Properties.isArray.name())); 	
		return newNode; 
	}

	protected Node newMethod() { return newMethod(getGraph()); } 
	protected Node newMethod(Object name, Object scope) { return newMethod(getGraph(), name, scope); } 

	public static Node newMethod(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Method)); } 
	public static Node newMethod(NeoModel graph, Object name, Object scope) {  	
		final Node newNode = newMethod(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name()));
		if (scope != null) relate(newNode, DomainMotif.newValueNode(graph, scope), RelationshipType.withName(Properties.scope.name())); 	
		return newNode; 
	}

	protected Node newStatement() { return newStatement(getGraph()); } 
	protected Node newStatement(Object code) { return newStatement(getGraph(), code); } 

	public static Node newStatement(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Statement)); } 
	public static Node newStatement(NeoModel graph, Object code) {  	
		final Node newNode = newStatement(graph); 	
		if (code != null) relate(newNode, DomainMotif.newValueNode(graph, code), RelationshipType.withName(Properties.code.name())); 	
		return newNode; 
	}

	protected Node newParameter() { return newParameter(getGraph()); } 
	protected Node newParameter(Object name) { return newParameter(getGraph(), name); } 

	public static Node newParameter(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Parameter)); } 
	public static Node newParameter(NeoModel graph, Object name) {  	
		final Node newNode = newParameter(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newConstructor() { return newConstructor(getGraph()); } 
	protected Node newConstructor(Object scope) { return newConstructor(getGraph(), scope); } 

	public static Node newConstructor(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Constructor)); } 
	public static Node newConstructor(NeoModel graph, Object scope) {  	
		final Node newNode = newConstructor(graph); 	
		if (scope != null) relate(newNode, DomainMotif.newValueNode(graph, scope), RelationshipType.withName(Properties.scope.name())); 	
		return newNode; 
	}

	protected Node newInstantiator() { return newInstantiator(getGraph()); } 
	protected Node newInstantiator(Object name) { return newInstantiator(getGraph(), name); } 

	public static Node newInstantiator(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Instantiator)); } 
	public static Node newInstantiator(NeoModel graph, Object name) {  	
		final Node newNode = newInstantiator(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newMap() { return newMap(getGraph()); } 
	protected Node newMap(Object implementation, Object valueType, Object keyType, Object name) { return newMap(getGraph(), implementation, valueType, keyType, name); } 

	public static Node newMap(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Map)); } 
	public static Node newMap(NeoModel graph, Object implementation, Object valueType, Object keyType, Object name) {  	
		final Node newNode = newMap(graph); 	
		if (implementation != null) relate(newNode, DomainMotif.newValueNode(graph, implementation), RelationshipType.withName(Properties.implementation.name()));
		if (valueType != null) relate(newNode, DomainMotif.newValueNode(graph, valueType), RelationshipType.withName(Properties.valueType.name()));
		if (keyType != null) relate(newNode, DomainMotif.newValueNode(graph, keyType), RelationshipType.withName(Properties.keyType.name()));
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newList() { return newList(getGraph()); } 
	protected Node newList(Object elementName, Object elementType, Object implementation, Object name) { return newList(getGraph(), elementName, elementType, implementation, name); } 

	public static Node newList(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.List)); } 
	public static Node newList(NeoModel graph, Object elementName, Object elementType, Object implementation, Object name) {  	
		final Node newNode = newList(graph); 	
		if (elementName != null) relate(newNode, DomainMotif.newValueNode(graph, elementName), RelationshipType.withName(Properties.elementName.name()));
		if (elementType != null) relate(newNode, DomainMotif.newValueNode(graph, elementType), RelationshipType.withName(Properties.elementType.name()));
		if (implementation != null) relate(newNode, DomainMotif.newValueNode(graph, implementation), RelationshipType.withName(Properties.implementation.name()));
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newSet() { return newSet(getGraph()); } 
	protected Node newSet(Object elementName, Object implementation, Object elementType, Object name) { return newSet(getGraph(), elementName, implementation, elementType, name); } 

	public static Node newSet(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Set)); } 
	public static Node newSet(NeoModel graph, Object elementName, Object implementation, Object elementType, Object name) {  	
		final Node newNode = newSet(graph); 	
		if (elementName != null) relate(newNode, DomainMotif.newValueNode(graph, elementName), RelationshipType.withName(Properties.elementName.name()));
		if (implementation != null) relate(newNode, DomainMotif.newValueNode(graph, implementation), RelationshipType.withName(Properties.implementation.name()));
		if (elementType != null) relate(newNode, DomainMotif.newValueNode(graph, elementType), RelationshipType.withName(Properties.elementType.name()));
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newJar() { return newJar(getGraph()); } 
	protected Node newJar(Object name) { return newJar(getGraph(), name); } 

	public static Node newJar(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Jar)); } 
	public static Node newJar(NeoModel graph, Object name) {  	
		final Node newNode = newJar(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}


	public static void outgoing_PACKAGE(Node src, RelationConsumer consumer) { outgoing(src, Relations._PACKAGE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoing_PACKAGE(Node src) { return other(src, singleOutgoing(src, Relations._PACKAGE)); }
	public static void incoming_PACKAGE(Node src, RelationConsumer consumer) { incoming(src, Relations._PACKAGE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncoming_PACKAGE(Node src) { return other(src, singleIncoming(src, Relations._PACKAGE)); }

	public static void outgoingJAR(Node src, RelationConsumer consumer) { outgoing(src, Relations.JAR).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingJAR(Node src) { return other(src, singleOutgoing(src, Relations.JAR)); }
	public static void incomingJAR(Node src, RelationConsumer consumer) { incoming(src, Relations.JAR).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingJAR(Node src) { return other(src, singleIncoming(src, Relations.JAR)); }

	public static void outgoingCLASS(Node src, RelationConsumer consumer) { outgoing(src, Relations.CLASS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingCLASS(Node src) { return other(src, singleOutgoing(src, Relations.CLASS)); }
	public static void incomingCLASS(Node src, RelationConsumer consumer) { incoming(src, Relations.CLASS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingCLASS(Node src) { return other(src, singleIncoming(src, Relations.CLASS)); }

	public static void outgoingINSTANCE(Node src, RelationConsumer consumer) { outgoing(src, Relations.INSTANCE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingINSTANCE(Node src) { return other(src, singleOutgoing(src, Relations.INSTANCE)); }
	public static void incomingINSTANCE(Node src, RelationConsumer consumer) { incoming(src, Relations.INSTANCE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingINSTANCE(Node src) { return other(src, singleIncoming(src, Relations.INSTANCE)); }

	public static void outgoingFIELD(Node src, RelationConsumer consumer) { outgoing(src, Relations.FIELD).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingFIELD(Node src) { return other(src, singleOutgoing(src, Relations.FIELD)); }
	public static void incomingFIELD(Node src, RelationConsumer consumer) { incoming(src, Relations.FIELD).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingFIELD(Node src) { return other(src, singleIncoming(src, Relations.FIELD)); }

	public static void outgoingTYPE(Node src, RelationConsumer consumer) { outgoing(src, Relations.TYPE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingTYPE(Node src) { return other(src, singleOutgoing(src, Relations.TYPE)); }
	public static void incomingTYPE(Node src, RelationConsumer consumer) { incoming(src, Relations.TYPE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingTYPE(Node src) { return other(src, singleIncoming(src, Relations.TYPE)); }

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

	public static void outgoingINSTANTIATION(Node src, RelationConsumer consumer) { outgoing(src, Relations.INSTANTIATION).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingINSTANTIATION(Node src) { return other(src, singleOutgoing(src, Relations.INSTANTIATION)); }
	public static void incomingINSTANTIATION(Node src, RelationConsumer consumer) { incoming(src, Relations.INSTANTIATION).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingINSTANTIATION(Node src) { return other(src, singleIncoming(src, Relations.INSTANTIATION)); }

	public static void outgoingMAP(Node src, RelationConsumer consumer) { outgoing(src, Relations.MAP).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingMAP(Node src) { return other(src, singleOutgoing(src, Relations.MAP)); }
	public static void incomingMAP(Node src, RelationConsumer consumer) { incoming(src, Relations.MAP).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingMAP(Node src) { return other(src, singleIncoming(src, Relations.MAP)); }

	public static void outgoingLIST(Node src, RelationConsumer consumer) { outgoing(src, Relations.LIST).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingLIST(Node src) { return other(src, singleOutgoing(src, Relations.LIST)); }
	public static void incomingLIST(Node src, RelationConsumer consumer) { incoming(src, Relations.LIST).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingLIST(Node src) { return other(src, singleIncoming(src, Relations.LIST)); }

	public static void outgoingSET(Node src, RelationConsumer consumer) { outgoing(src, Relations.SET).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingSET(Node src) { return other(src, singleOutgoing(src, Relations.SET)); }
	public static void incomingSET(Node src, RelationConsumer consumer) { incoming(src, Relations.SET).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingSET(Node src) { return other(src, singleIncoming(src, Relations.SET)); }

	public static void outgoingRETURNVALUE(Node src, RelationConsumer consumer) { outgoing(src, Relations.RETURNVALUE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingRETURNVALUE(Node src) { return other(src, singleOutgoing(src, Relations.RETURNVALUE)); }
	public static void incomingRETURNVALUE(Node src, RelationConsumer consumer) { incoming(src, Relations.RETURNVALUE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingRETURNVALUE(Node src) { return other(src, singleIncoming(src, Relations.RETURNVALUE)); }


	public static Relationship relate_PACKAGE(Node src, Node dst) { return relate(src, dst, Relations._PACKAGE); }
	public static Relationship relateJAR(Node src, Node dst) { return relate(src, dst, Relations.JAR); }
	public static Relationship relateCLASS(Node src, Node dst) { return relate(src, dst, Relations.CLASS); }
	public static Relationship relateINSTANCE(Node src, Node dst) { return relate(src, dst, Relations.INSTANCE); }
	public static Relationship relateFIELD(Node src, Node dst) { return relate(src, dst, Relations.FIELD); }
	public static Relationship relateTYPE(Node src, Node dst) { return relate(src, dst, Relations.TYPE); }
	public static Relationship relateMETHOD(Node src, Node dst) { return relate(src, dst, Relations.METHOD); }
	public static Relationship relateBLOCK(Node src, Node dst) { return relate(src, dst, Relations.BLOCK); }
	public static Relationship relateNEXT(Node src, Node dst) { return relate(src, dst, Relations.NEXT); }
	public static Relationship relatePARAMETER(Node src, Node dst) { return relate(src, dst, Relations.PARAMETER); }
	public static Relationship relateCONSTRUCTOR(Node src, Node dst) { return relate(src, dst, Relations.CONSTRUCTOR); }
	public static Relationship relateINSTANTIATION(Node src, Node dst) { return relate(src, dst, Relations.INSTANTIATION); }
	public static Relationship relateMAP(Node src, Node dst) { return relate(src, dst, Relations.MAP); }
	public static Relationship relateLIST(Node src, Node dst) { return relate(src, dst, Relations.LIST); }
	public static Relationship relateSET(Node src, Node dst) { return relate(src, dst, Relations.SET); }
	public static Relationship relateRETURNVALUE(Node src, Node dst) { return relate(src, dst, Relations.RETURNVALUE); }

	// name
	public static <T> T getNameProperty(PropertyContainer container) { return getNameProperty(container, null); }
	public static <T> T getNameProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.name.name(), defaultValue); }
	public static boolean hasNameProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.name.name()); }
	public static <T extends PropertyContainer> T setNameProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.name.name(), value); return container; }
	public static <T extends PropertyContainer> T removeNameProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.name.name()); return container; }

	protected <T extends PropertyContainer> T setNameProperty(T container, Object value) { setNameProperty(getGraph(), container, value); return container; }

	// code
	public static <T> T getCodeProperty(PropertyContainer container) { return getCodeProperty(container, null); }
	public static <T> T getCodeProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.code.name(), defaultValue); }
	public static boolean hasCodeProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.code.name()); }
	public static <T extends PropertyContainer> T setCodeProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.code.name(), value); return container; }
	public static <T extends PropertyContainer> T removeCodeProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.code.name()); return container; }

	protected <T extends PropertyContainer> T setCodeProperty(T container, Object value) { setCodeProperty(getGraph(), container, value); return container; }

	// scope
	public static <T> T getScopeProperty(PropertyContainer container) { return getScopeProperty(container, null); }
	public static <T> T getScopeProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.scope.name(), defaultValue); }
	public static boolean hasScopeProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.scope.name()); }
	public static <T extends PropertyContainer> T setScopeProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.scope.name(), value); return container; }
	public static <T extends PropertyContainer> T removeScopeProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.scope.name()); return container; }

	protected <T extends PropertyContainer> T setScopeProperty(T container, Object value) { setScopeProperty(getGraph(), container, value); return container; }

	// hasSetter
	public static <T> T getHasSetterProperty(PropertyContainer container) { return getHasSetterProperty(container, null); }
	public static <T> T getHasSetterProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.hasSetter.name(), defaultValue); }
	public static boolean hasHasSetterProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.hasSetter.name()); }
	public static <T extends PropertyContainer> T setHasSetterProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.hasSetter.name(), value); return container; }
	public static <T extends PropertyContainer> T removeHasSetterProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.hasSetter.name()); return container; }

	protected <T extends PropertyContainer> T setHasSetterProperty(T container, Object value) { setHasSetterProperty(getGraph(), container, value); return container; }

	// isFinal
	public static <T> T getIsFinalProperty(PropertyContainer container) { return getIsFinalProperty(container, null); }
	public static <T> T getIsFinalProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.isFinal.name(), defaultValue); }
	public static boolean hasIsFinalProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.isFinal.name()); }
	public static <T extends PropertyContainer> T setIsFinalProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.isFinal.name(), value); return container; }
	public static <T extends PropertyContainer> T removeIsFinalProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.isFinal.name()); return container; }

	protected <T extends PropertyContainer> T setIsFinalProperty(T container, Object value) { setIsFinalProperty(getGraph(), container, value); return container; }

	// isEqha
	public static <T> T getIsEqhaProperty(PropertyContainer container) { return getIsEqhaProperty(container, null); }
	public static <T> T getIsEqhaProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.isEqha.name(), defaultValue); }
	public static boolean hasIsEqhaProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.isEqha.name()); }
	public static <T extends PropertyContainer> T setIsEqhaProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.isEqha.name(), value); return container; }
	public static <T extends PropertyContainer> T removeIsEqhaProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.isEqha.name()); return container; }

	protected <T extends PropertyContainer> T setIsEqhaProperty(T container, Object value) { setIsEqhaProperty(getGraph(), container, value); return container; }

	// isToString
	public static <T> T getIsToStringProperty(PropertyContainer container) { return getIsToStringProperty(container, null); }
	public static <T> T getIsToStringProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.isToString.name(), defaultValue); }
	public static boolean hasIsToStringProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.isToString.name()); }
	public static <T extends PropertyContainer> T setIsToStringProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.isToString.name(), value); return container; }
	public static <T extends PropertyContainer> T removeIsToStringProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.isToString.name()); return container; }

	protected <T extends PropertyContainer> T setIsToStringProperty(T container, Object value) { setIsToStringProperty(getGraph(), container, value); return container; }

	// hasGetter
	public static <T> T getHasGetterProperty(PropertyContainer container) { return getHasGetterProperty(container, null); }
	public static <T> T getHasGetterProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.hasGetter.name(), defaultValue); }
	public static boolean hasHasGetterProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.hasGetter.name()); }
	public static <T extends PropertyContainer> T setHasGetterProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.hasGetter.name(), value); return container; }
	public static <T extends PropertyContainer> T removeHasGetterProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.hasGetter.name()); return container; }

	protected <T extends PropertyContainer> T setHasGetterProperty(T container, Object value) { setHasGetterProperty(getGraph(), container, value); return container; }

	// isArray
	public static <T> T getIsArrayProperty(PropertyContainer container) { return getIsArrayProperty(container, null); }
	public static <T> T getIsArrayProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.isArray.name(), defaultValue); }
	public static boolean hasIsArrayProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.isArray.name()); }
	public static <T extends PropertyContainer> T setIsArrayProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.isArray.name(), value); return container; }
	public static <T extends PropertyContainer> T removeIsArrayProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.isArray.name()); return container; }

	protected <T extends PropertyContainer> T setIsArrayProperty(T container, Object value) { setIsArrayProperty(getGraph(), container, value); return container; }

	// isAbstract
	public static <T> T getIsAbstractProperty(PropertyContainer container) { return getIsAbstractProperty(container, null); }
	public static <T> T getIsAbstractProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.isAbstract.name(), defaultValue); }
	public static boolean hasIsAbstractProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.isAbstract.name()); }
	public static <T extends PropertyContainer> T setIsAbstractProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.isAbstract.name(), value); return container; }
	public static <T extends PropertyContainer> T removeIsAbstractProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.isAbstract.name()); return container; }

	protected <T extends PropertyContainer> T setIsAbstractProperty(T container, Object value) { setIsAbstractProperty(getGraph(), container, value); return container; }

	// implementation
	public static <T> T getImplementationProperty(PropertyContainer container) { return getImplementationProperty(container, null); }
	public static <T> T getImplementationProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.implementation.name(), defaultValue); }
	public static boolean hasImplementationProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.implementation.name()); }
	public static <T extends PropertyContainer> T setImplementationProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.implementation.name(), value); return container; }
	public static <T extends PropertyContainer> T removeImplementationProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.implementation.name()); return container; }

	protected <T extends PropertyContainer> T setImplementationProperty(T container, Object value) { setImplementationProperty(getGraph(), container, value); return container; }

	// valueType
	public static <T> T getValueTypeProperty(PropertyContainer container) { return getValueTypeProperty(container, null); }
	public static <T> T getValueTypeProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.valueType.name(), defaultValue); }
	public static boolean hasValueTypeProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.valueType.name()); }
	public static <T extends PropertyContainer> T setValueTypeProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.valueType.name(), value); return container; }
	public static <T extends PropertyContainer> T removeValueTypeProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.valueType.name()); return container; }

	protected <T extends PropertyContainer> T setValueTypeProperty(T container, Object value) { setValueTypeProperty(getGraph(), container, value); return container; }

	// keyType
	public static <T> T getKeyTypeProperty(PropertyContainer container) { return getKeyTypeProperty(container, null); }
	public static <T> T getKeyTypeProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.keyType.name(), defaultValue); }
	public static boolean hasKeyTypeProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.keyType.name()); }
	public static <T extends PropertyContainer> T setKeyTypeProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.keyType.name(), value); return container; }
	public static <T extends PropertyContainer> T removeKeyTypeProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.keyType.name()); return container; }

	protected <T extends PropertyContainer> T setKeyTypeProperty(T container, Object value) { setKeyTypeProperty(getGraph(), container, value); return container; }

	// elementName
	public static <T> T getElementNameProperty(PropertyContainer container) { return getElementNameProperty(container, null); }
	public static <T> T getElementNameProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.elementName.name(), defaultValue); }
	public static boolean hasElementNameProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.elementName.name()); }
	public static <T extends PropertyContainer> T setElementNameProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.elementName.name(), value); return container; }
	public static <T extends PropertyContainer> T removeElementNameProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.elementName.name()); return container; }

	protected <T extends PropertyContainer> T setElementNameProperty(T container, Object value) { setElementNameProperty(getGraph(), container, value); return container; }

	// elementType
	public static <T> T getElementTypeProperty(PropertyContainer container) { return getElementTypeProperty(container, null); }
	public static <T> T getElementTypeProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.elementType.name(), defaultValue); }
	public static boolean hasElementTypeProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.elementType.name()); }
	public static <T extends PropertyContainer> T setElementTypeProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.elementType.name(), value); return container; }
	public static <T extends PropertyContainer> T removeElementTypeProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.elementType.name()); return container; }

	protected <T extends PropertyContainer> T setElementTypeProperty(T container, Object value) { setElementTypeProperty(getGraph(), container, value); return container; }

}