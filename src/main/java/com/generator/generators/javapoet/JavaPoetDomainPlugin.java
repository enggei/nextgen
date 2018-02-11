package com.generator.generators.javapoet;

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
 * Auto-generated from domain JavaPoetDomainPlugin
 */
public abstract class JavaPoetDomainPlugin extends Plugin {

	protected final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(JavaPoetDomainPlugin.class);

	public enum Entities implements Label {
      JavaFile, TypeSpec, Field, Modifier, Statement, StatementParameter, TypeName, Method, Parameter, library
   }

   public enum Relations implements RelationshipType {
      JAVAFILE, LIBRARY, PACKAGENAME, TYPESPEC, FIELDS, MODIFIERS, TYPE, NAME, INITIALIZER, STATEMENT, NEXT, ISCONTROLFLOWSTART, ISCONTROLFLOWEND, STATEMENT_PARAMETER, STATEMENT_PARAMETER_TYPE, ISARRAY, TYPEARGUMENTS, SUBTYPE, SUPERTYPE, METHODS, STATEMENTS, RETURNS, PARAMETER, LIBRARYTYPES
   }

   public enum Properties {
      packageName, type, name, statement, isControlFlowStart, isControlFlowEnd, isArray
   }

	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

	private final Node domainNode;

   JavaPoetDomainPlugin(App app) {
      super(app, "JavaPoet");

		domainNode = DomainMotif.newDomainNode(getGraph(), "JavaPoet");
		entitiesNodeMap.put(Entities.JavaFile, DomainMotif.newDomainEntity(getGraph(), Entities.JavaFile, domainNode));
		entitiesNodeMap.put(Entities.TypeSpec, DomainMotif.newDomainEntity(getGraph(), Entities.TypeSpec, domainNode));
		entitiesNodeMap.put(Entities.Field, DomainMotif.newDomainEntity(getGraph(), Entities.Field, domainNode));
		entitiesNodeMap.put(Entities.Modifier, DomainMotif.newDomainEntity(getGraph(), Entities.Modifier, domainNode));
		entitiesNodeMap.put(Entities.Statement, DomainMotif.newDomainEntity(getGraph(), Entities.Statement, domainNode));
		entitiesNodeMap.put(Entities.StatementParameter, DomainMotif.newDomainEntity(getGraph(), Entities.StatementParameter, domainNode));
		entitiesNodeMap.put(Entities.TypeName, DomainMotif.newDomainEntity(getGraph(), Entities.TypeName, domainNode));
		entitiesNodeMap.put(Entities.Method, DomainMotif.newDomainEntity(getGraph(), Entities.Method, domainNode));
		entitiesNodeMap.put(Entities.Parameter, DomainMotif.newDomainEntity(getGraph(), Entities.Parameter, domainNode));
		entitiesNodeMap.put(Entities.library, DomainMotif.newDomainEntity(getGraph(), Entities.library, domainNode));

		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.JavaFile), Properties.packageName.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.TypeSpec), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Field), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Modifier), Properties.type.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Statement), Properties.statement.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Statement), Properties.isControlFlowStart.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Statement), Properties.isControlFlowEnd.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.StatementParameter), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.StatementParameter), Properties.type.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.TypeName), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.TypeName), Properties.packageName.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.TypeName), Properties.isArray.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Method), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Parameter), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.library), Properties.name.name());

		relate(domainNode, entitiesNodeMap.get(Entities.JavaFile), DomainPlugin.Relations.ENTITY);
		relate(domainNode, entitiesNodeMap.get(Entities.library), DomainPlugin.Relations.ENTITY);
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.JavaFile), Relations.TYPESPEC.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.TypeSpec));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.TypeSpec), Relations.FIELDS.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Field));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.TypeSpec), Relations.MODIFIERS.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Modifier));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.TypeSpec), Relations.METHODS.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Method));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Field), Relations.MODIFIERS.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Modifier));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Field), Relations.INITIALIZER.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Statement));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Field), Relations.TYPE.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.TypeName));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Statement), Relations.NEXT.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Statement));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Statement), Relations.STATEMENT_PARAMETER.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.StatementParameter));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.StatementParameter), Relations.STATEMENT_PARAMETER_TYPE.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.TypeName));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.TypeName), Relations.TYPEARGUMENTS.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.TypeName));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.TypeName), Relations.SUBTYPE.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.TypeName));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.TypeName), Relations.SUPERTYPE.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.TypeName));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Method), Relations.STATEMENTS.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.Statement));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Method), Relations.RETURNS.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.TypeName));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Method), Relations.PARAMETER.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Parameter));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Parameter), Relations.MODIFIERS.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Modifier));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Parameter), Relations.TYPE.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.TypeName));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.library), Relations.LIBRARYTYPES.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.TypeName));
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
		if (isJavaFile(neoNode.getNode())) handleJavaFile(pop, neoNode, selectedNodes);
		if (isTypeSpec(neoNode.getNode())) handleTypeSpec(pop, neoNode, selectedNodes);
		if (isField(neoNode.getNode())) handleField(pop, neoNode, selectedNodes);
		if (isModifier(neoNode.getNode())) handleModifier(pop, neoNode, selectedNodes);
		if (isStatement(neoNode.getNode())) handleStatement(pop, neoNode, selectedNodes);
		if (isStatementParameter(neoNode.getNode())) handleStatementParameter(pop, neoNode, selectedNodes);
		if (isTypeName(neoNode.getNode())) handleTypeName(pop, neoNode, selectedNodes);
		if (isMethod(neoNode.getNode())) handleMethod(pop, neoNode, selectedNodes);
		if (isParameter(neoNode.getNode())) handleParameter(pop, neoNode, selectedNodes);
		if (islibrary(neoNode.getNode())) handlelibrary(pop, neoNode, selectedNodes);
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
		if (isJavaFile(neoNode.getNode())) return newJavaFileEditor(neoNode);
		if (isTypeSpec(neoNode.getNode())) return newTypeSpecEditor(neoNode);
		if (isField(neoNode.getNode())) return newFieldEditor(neoNode);
		if (isModifier(neoNode.getNode())) return newModifierEditor(neoNode);
		if (isStatement(neoNode.getNode())) return newStatementEditor(neoNode);
		if (isStatementParameter(neoNode.getNode())) return newStatementParameterEditor(neoNode);
		if (isTypeName(neoNode.getNode())) return newTypeNameEditor(neoNode);
		if (isMethod(neoNode.getNode())) return newMethodEditor(neoNode);
		if (isParameter(neoNode.getNode())) return newParameterEditor(neoNode);
		if (islibrary(neoNode.getNode())) return newlibraryEditor(neoNode);
      return null;
   }

	public Node getDomainNode() { return domainNode; }

	public Node getEntityNode(Label label) { return entitiesNodeMap.get(label); }

	protected void handleJavaFile(JPopupMenu pop, NeoNode javaFileNode, Set<NeoNode> selectedNodes) { }
	protected void handleTypeSpec(JPopupMenu pop, NeoNode typeSpecNode, Set<NeoNode> selectedNodes) { }
	protected void handleField(JPopupMenu pop, NeoNode fieldNode, Set<NeoNode> selectedNodes) { }
	protected void handleModifier(JPopupMenu pop, NeoNode modifierNode, Set<NeoNode> selectedNodes) { }
	protected void handleStatement(JPopupMenu pop, NeoNode statementNode, Set<NeoNode> selectedNodes) { }
	protected void handleStatementParameter(JPopupMenu pop, NeoNode statementParameterNode, Set<NeoNode> selectedNodes) { }
	protected void handleTypeName(JPopupMenu pop, NeoNode typeNameNode, Set<NeoNode> selectedNodes) { }
	protected void handleMethod(JPopupMenu pop, NeoNode methodNode, Set<NeoNode> selectedNodes) { }
	protected void handleParameter(JPopupMenu pop, NeoNode parameterNode, Set<NeoNode> selectedNodes) { }
	protected void handlelibrary(JPopupMenu pop, NeoNode libraryNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newJavaFileEditor(NeoNode javaFileNode) { return null; }
	protected JComponent newTypeSpecEditor(NeoNode typeSpecNode) { return null; }
	protected JComponent newFieldEditor(NeoNode fieldNode) { return null; }
	protected JComponent newModifierEditor(NeoNode modifierNode) { return null; }
	protected JComponent newStatementEditor(NeoNode statementNode) { return null; }
	protected JComponent newStatementParameterEditor(NeoNode statementParameterNode) { return null; }
	protected JComponent newTypeNameEditor(NeoNode typeNameNode) { return null; }
	protected JComponent newMethodEditor(NeoNode methodNode) { return null; }
	protected JComponent newParameterEditor(NeoNode parameterNode) { return null; }
	protected JComponent newlibraryEditor(NeoNode libraryNode) { return null; }

	public static boolean isJavaFile(Node node) { return hasLabel(node, Entities.JavaFile); }
	public static boolean isTypeSpec(Node node) { return hasLabel(node, Entities.TypeSpec); }
	public static boolean isField(Node node) { return hasLabel(node, Entities.Field); }
	public static boolean isModifier(Node node) { return hasLabel(node, Entities.Modifier); }
	public static boolean isStatement(Node node) { return hasLabel(node, Entities.Statement); }
	public static boolean isStatementParameter(Node node) { return hasLabel(node, Entities.StatementParameter); }
	public static boolean isTypeName(Node node) { return hasLabel(node, Entities.TypeName); }
	public static boolean isMethod(Node node) { return hasLabel(node, Entities.Method); }
	public static boolean isParameter(Node node) { return hasLabel(node, Entities.Parameter); }
	public static boolean islibrary(Node node) { return hasLabel(node, Entities.library); }

	protected Node newJavaFile() { return newJavaFile(getGraph()); } 
	protected Node newJavaFile(Object packageName) { return newJavaFile(getGraph(), packageName); } 

	public static Node newJavaFile(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.JavaFile)); } 
	public static Node newJavaFile(NeoModel graph, Object packageName) {  	
		final Node newNode = newJavaFile(graph); 	
		if (packageName != null) relate(newNode, DomainMotif.newValueNode(graph, packageName), RelationshipType.withName(Properties.packageName.name())); 	
		return newNode; 
	}

	protected Node newTypeSpec() { return newTypeSpec(getGraph()); } 
	protected Node newTypeSpec(Object name) { return newTypeSpec(getGraph(), name); } 

	public static Node newTypeSpec(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.TypeSpec)); } 
	public static Node newTypeSpec(NeoModel graph, Object name) {  	
		final Node newNode = newTypeSpec(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newField() { return newField(getGraph()); } 
	protected Node newField(Object name) { return newField(getGraph(), name); } 

	public static Node newField(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Field)); } 
	public static Node newField(NeoModel graph, Object name) {  	
		final Node newNode = newField(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newModifier() { return newModifier(getGraph()); } 
	protected Node newModifier(Object type) { return newModifier(getGraph(), type); } 

	public static Node newModifier(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Modifier)); } 
	public static Node newModifier(NeoModel graph, Object type) {  	
		final Node newNode = newModifier(graph); 	
		if (type != null) relate(newNode, DomainMotif.newValueNode(graph, type), RelationshipType.withName(Properties.type.name())); 	
		return newNode; 
	}

	protected Node newStatement() { return newStatement(getGraph()); } 
	protected Node newStatement(Object statement, Object isControlFlowStart, Object isControlFlowEnd) { return newStatement(getGraph(), statement, isControlFlowStart, isControlFlowEnd); } 

	public static Node newStatement(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Statement)); } 
	public static Node newStatement(NeoModel graph, Object statement, Object isControlFlowStart, Object isControlFlowEnd) {  	
		final Node newNode = newStatement(graph); 	
		if (statement != null) relate(newNode, DomainMotif.newValueNode(graph, statement), RelationshipType.withName(Properties.statement.name()));
		if (isControlFlowStart != null) relate(newNode, DomainMotif.newValueNode(graph, isControlFlowStart), RelationshipType.withName(Properties.isControlFlowStart.name()));
		if (isControlFlowEnd != null) relate(newNode, DomainMotif.newValueNode(graph, isControlFlowEnd), RelationshipType.withName(Properties.isControlFlowEnd.name())); 	
		return newNode; 
	}

	protected Node newStatementParameter() { return newStatementParameter(getGraph()); } 
	protected Node newStatementParameter(Object name, Object type) { return newStatementParameter(getGraph(), name, type); } 

	public static Node newStatementParameter(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.StatementParameter)); } 
	public static Node newStatementParameter(NeoModel graph, Object name, Object type) {  	
		final Node newNode = newStatementParameter(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name()));
		if (type != null) relate(newNode, DomainMotif.newValueNode(graph, type), RelationshipType.withName(Properties.type.name())); 	
		return newNode; 
	}

	protected Node newTypeName() { return newTypeName(getGraph()); } 
	protected Node newTypeName(Object name, Object packageName, Object isArray) { return newTypeName(getGraph(), name, packageName, isArray); } 

	public static Node newTypeName(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.TypeName)); } 
	public static Node newTypeName(NeoModel graph, Object name, Object packageName, Object isArray) {  	
		final Node newNode = newTypeName(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name()));
		if (packageName != null) relate(newNode, DomainMotif.newValueNode(graph, packageName), RelationshipType.withName(Properties.packageName.name()));
		if (isArray != null) relate(newNode, DomainMotif.newValueNode(graph, isArray), RelationshipType.withName(Properties.isArray.name())); 	
		return newNode; 
	}

	protected Node newMethod() { return newMethod(getGraph()); } 
	protected Node newMethod(Object name) { return newMethod(getGraph(), name); } 

	public static Node newMethod(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Method)); } 
	public static Node newMethod(NeoModel graph, Object name) {  	
		final Node newNode = newMethod(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
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

	protected Node newlibrary() { return newlibrary(getGraph()); } 
	protected Node newlibrary(Object name) { return newlibrary(getGraph(), name); } 

	public static Node newlibrary(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.library)); } 
	public static Node newlibrary(NeoModel graph, Object name) {  	
		final Node newNode = newlibrary(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}


	public static void outgoingJAVAFILE(Node src, RelationConsumer consumer) { outgoing(src, Relations.JAVAFILE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingJAVAFILE(Node src) { return other(src, singleOutgoing(src, Relations.JAVAFILE)); }
	public static void incomingJAVAFILE(Node src, RelationConsumer consumer) { incoming(src, Relations.JAVAFILE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingJAVAFILE(Node src) { return other(src, singleIncoming(src, Relations.JAVAFILE)); }

	public static void outgoingLIBRARY(Node src, RelationConsumer consumer) { outgoing(src, Relations.LIBRARY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingLIBRARY(Node src) { return other(src, singleOutgoing(src, Relations.LIBRARY)); }
	public static void incomingLIBRARY(Node src, RelationConsumer consumer) { incoming(src, Relations.LIBRARY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingLIBRARY(Node src) { return other(src, singleIncoming(src, Relations.LIBRARY)); }

	public static void outgoingPACKAGENAME(Node src, RelationConsumer consumer) { outgoing(src, Relations.PACKAGENAME).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPACKAGENAME(Node src) { return other(src, singleOutgoing(src, Relations.PACKAGENAME)); }
	public static void incomingPACKAGENAME(Node src, RelationConsumer consumer) { incoming(src, Relations.PACKAGENAME).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPACKAGENAME(Node src) { return other(src, singleIncoming(src, Relations.PACKAGENAME)); }

	public static void outgoingTYPESPEC(Node src, RelationConsumer consumer) { outgoing(src, Relations.TYPESPEC).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingTYPESPEC(Node src) { return other(src, singleOutgoing(src, Relations.TYPESPEC)); }
	public static void incomingTYPESPEC(Node src, RelationConsumer consumer) { incoming(src, Relations.TYPESPEC).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingTYPESPEC(Node src) { return other(src, singleIncoming(src, Relations.TYPESPEC)); }

	public static void outgoingFIELDS(Node src, RelationConsumer consumer) { outgoing(src, Relations.FIELDS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingFIELDS(Node src) { return other(src, singleOutgoing(src, Relations.FIELDS)); }
	public static void incomingFIELDS(Node src, RelationConsumer consumer) { incoming(src, Relations.FIELDS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingFIELDS(Node src) { return other(src, singleIncoming(src, Relations.FIELDS)); }

	public static void outgoingMODIFIERS(Node src, RelationConsumer consumer) { outgoing(src, Relations.MODIFIERS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingMODIFIERS(Node src) { return other(src, singleOutgoing(src, Relations.MODIFIERS)); }
	public static void incomingMODIFIERS(Node src, RelationConsumer consumer) { incoming(src, Relations.MODIFIERS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingMODIFIERS(Node src) { return other(src, singleIncoming(src, Relations.MODIFIERS)); }

	public static void outgoingTYPE(Node src, RelationConsumer consumer) { outgoing(src, Relations.TYPE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingTYPE(Node src) { return other(src, singleOutgoing(src, Relations.TYPE)); }
	public static void incomingTYPE(Node src, RelationConsumer consumer) { incoming(src, Relations.TYPE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingTYPE(Node src) { return other(src, singleIncoming(src, Relations.TYPE)); }

	public static void outgoingNAME(Node src, RelationConsumer consumer) { outgoing(src, Relations.NAME).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingNAME(Node src) { return other(src, singleOutgoing(src, Relations.NAME)); }
	public static void incomingNAME(Node src, RelationConsumer consumer) { incoming(src, Relations.NAME).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingNAME(Node src) { return other(src, singleIncoming(src, Relations.NAME)); }

	public static void outgoingINITIALIZER(Node src, RelationConsumer consumer) { outgoing(src, Relations.INITIALIZER).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingINITIALIZER(Node src) { return other(src, singleOutgoing(src, Relations.INITIALIZER)); }
	public static void incomingINITIALIZER(Node src, RelationConsumer consumer) { incoming(src, Relations.INITIALIZER).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingINITIALIZER(Node src) { return other(src, singleIncoming(src, Relations.INITIALIZER)); }

	public static void outgoingSTATEMENT(Node src, RelationConsumer consumer) { outgoing(src, Relations.STATEMENT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingSTATEMENT(Node src) { return other(src, singleOutgoing(src, Relations.STATEMENT)); }
	public static void incomingSTATEMENT(Node src, RelationConsumer consumer) { incoming(src, Relations.STATEMENT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingSTATEMENT(Node src) { return other(src, singleIncoming(src, Relations.STATEMENT)); }

	public static void outgoingNEXT(Node src, RelationConsumer consumer) { outgoing(src, Relations.NEXT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingNEXT(Node src) { return other(src, singleOutgoing(src, Relations.NEXT)); }
	public static void incomingNEXT(Node src, RelationConsumer consumer) { incoming(src, Relations.NEXT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingNEXT(Node src) { return other(src, singleIncoming(src, Relations.NEXT)); }

	public static void outgoingISCONTROLFLOWSTART(Node src, RelationConsumer consumer) { outgoing(src, Relations.ISCONTROLFLOWSTART).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingISCONTROLFLOWSTART(Node src) { return other(src, singleOutgoing(src, Relations.ISCONTROLFLOWSTART)); }
	public static void incomingISCONTROLFLOWSTART(Node src, RelationConsumer consumer) { incoming(src, Relations.ISCONTROLFLOWSTART).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingISCONTROLFLOWSTART(Node src) { return other(src, singleIncoming(src, Relations.ISCONTROLFLOWSTART)); }

	public static void outgoingISCONTROLFLOWEND(Node src, RelationConsumer consumer) { outgoing(src, Relations.ISCONTROLFLOWEND).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingISCONTROLFLOWEND(Node src) { return other(src, singleOutgoing(src, Relations.ISCONTROLFLOWEND)); }
	public static void incomingISCONTROLFLOWEND(Node src, RelationConsumer consumer) { incoming(src, Relations.ISCONTROLFLOWEND).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingISCONTROLFLOWEND(Node src) { return other(src, singleIncoming(src, Relations.ISCONTROLFLOWEND)); }

	public static void outgoingSTATEMENT_PARAMETER(Node src, RelationConsumer consumer) { outgoing(src, Relations.STATEMENT_PARAMETER).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingSTATEMENT_PARAMETER(Node src) { return other(src, singleOutgoing(src, Relations.STATEMENT_PARAMETER)); }
	public static void incomingSTATEMENT_PARAMETER(Node src, RelationConsumer consumer) { incoming(src, Relations.STATEMENT_PARAMETER).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingSTATEMENT_PARAMETER(Node src) { return other(src, singleIncoming(src, Relations.STATEMENT_PARAMETER)); }

	public static void outgoingSTATEMENT_PARAMETER_TYPE(Node src, RelationConsumer consumer) { outgoing(src, Relations.STATEMENT_PARAMETER_TYPE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingSTATEMENT_PARAMETER_TYPE(Node src) { return other(src, singleOutgoing(src, Relations.STATEMENT_PARAMETER_TYPE)); }
	public static void incomingSTATEMENT_PARAMETER_TYPE(Node src, RelationConsumer consumer) { incoming(src, Relations.STATEMENT_PARAMETER_TYPE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingSTATEMENT_PARAMETER_TYPE(Node src) { return other(src, singleIncoming(src, Relations.STATEMENT_PARAMETER_TYPE)); }

	public static void outgoingISARRAY(Node src, RelationConsumer consumer) { outgoing(src, Relations.ISARRAY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingISARRAY(Node src) { return other(src, singleOutgoing(src, Relations.ISARRAY)); }
	public static void incomingISARRAY(Node src, RelationConsumer consumer) { incoming(src, Relations.ISARRAY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingISARRAY(Node src) { return other(src, singleIncoming(src, Relations.ISARRAY)); }

	public static void outgoingTYPEARGUMENTS(Node src, RelationConsumer consumer) { outgoing(src, Relations.TYPEARGUMENTS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingTYPEARGUMENTS(Node src) { return other(src, singleOutgoing(src, Relations.TYPEARGUMENTS)); }
	public static void incomingTYPEARGUMENTS(Node src, RelationConsumer consumer) { incoming(src, Relations.TYPEARGUMENTS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingTYPEARGUMENTS(Node src) { return other(src, singleIncoming(src, Relations.TYPEARGUMENTS)); }

	public static void outgoingSUBTYPE(Node src, RelationConsumer consumer) { outgoing(src, Relations.SUBTYPE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingSUBTYPE(Node src) { return other(src, singleOutgoing(src, Relations.SUBTYPE)); }
	public static void incomingSUBTYPE(Node src, RelationConsumer consumer) { incoming(src, Relations.SUBTYPE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingSUBTYPE(Node src) { return other(src, singleIncoming(src, Relations.SUBTYPE)); }

	public static void outgoingSUPERTYPE(Node src, RelationConsumer consumer) { outgoing(src, Relations.SUPERTYPE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingSUPERTYPE(Node src) { return other(src, singleOutgoing(src, Relations.SUPERTYPE)); }
	public static void incomingSUPERTYPE(Node src, RelationConsumer consumer) { incoming(src, Relations.SUPERTYPE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingSUPERTYPE(Node src) { return other(src, singleIncoming(src, Relations.SUPERTYPE)); }

	public static void outgoingMETHODS(Node src, RelationConsumer consumer) { outgoing(src, Relations.METHODS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingMETHODS(Node src) { return other(src, singleOutgoing(src, Relations.METHODS)); }
	public static void incomingMETHODS(Node src, RelationConsumer consumer) { incoming(src, Relations.METHODS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingMETHODS(Node src) { return other(src, singleIncoming(src, Relations.METHODS)); }

	public static void outgoingSTATEMENTS(Node src, RelationConsumer consumer) { outgoing(src, Relations.STATEMENTS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingSTATEMENTS(Node src) { return other(src, singleOutgoing(src, Relations.STATEMENTS)); }
	public static void incomingSTATEMENTS(Node src, RelationConsumer consumer) { incoming(src, Relations.STATEMENTS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingSTATEMENTS(Node src) { return other(src, singleIncoming(src, Relations.STATEMENTS)); }

	public static void outgoingRETURNS(Node src, RelationConsumer consumer) { outgoing(src, Relations.RETURNS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingRETURNS(Node src) { return other(src, singleOutgoing(src, Relations.RETURNS)); }
	public static void incomingRETURNS(Node src, RelationConsumer consumer) { incoming(src, Relations.RETURNS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingRETURNS(Node src) { return other(src, singleIncoming(src, Relations.RETURNS)); }

	public static void outgoingPARAMETER(Node src, RelationConsumer consumer) { outgoing(src, Relations.PARAMETER).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPARAMETER(Node src) { return other(src, singleOutgoing(src, Relations.PARAMETER)); }
	public static void incomingPARAMETER(Node src, RelationConsumer consumer) { incoming(src, Relations.PARAMETER).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPARAMETER(Node src) { return other(src, singleIncoming(src, Relations.PARAMETER)); }

	public static void outgoingLIBRARYTYPES(Node src, RelationConsumer consumer) { outgoing(src, Relations.LIBRARYTYPES).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingLIBRARYTYPES(Node src) { return other(src, singleOutgoing(src, Relations.LIBRARYTYPES)); }
	public static void incomingLIBRARYTYPES(Node src, RelationConsumer consumer) { incoming(src, Relations.LIBRARYTYPES).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingLIBRARYTYPES(Node src) { return other(src, singleIncoming(src, Relations.LIBRARYTYPES)); }


	public static Relationship relateJAVAFILE(Node src, Node dst) { return relate(src, dst, Relations.JAVAFILE); }
	public static Relationship relateLIBRARY(Node src, Node dst) { return relate(src, dst, Relations.LIBRARY); }
	public static Relationship relatePACKAGENAME(Node src, Node dst) { return relate(src, dst, Relations.PACKAGENAME); }
	public static Relationship relateTYPESPEC(Node src, Node dst) { return relate(src, dst, Relations.TYPESPEC); }
	public static Relationship relateFIELDS(Node src, Node dst) { return relate(src, dst, Relations.FIELDS); }
	public static Relationship relateMODIFIERS(Node src, Node dst) { return relate(src, dst, Relations.MODIFIERS); }
	public static Relationship relateTYPE(Node src, Node dst) { return relate(src, dst, Relations.TYPE); }
	public static Relationship relateNAME(Node src, Node dst) { return relate(src, dst, Relations.NAME); }
	public static Relationship relateINITIALIZER(Node src, Node dst) { return relate(src, dst, Relations.INITIALIZER); }
	public static Relationship relateSTATEMENT(Node src, Node dst) { return relate(src, dst, Relations.STATEMENT); }
	public static Relationship relateNEXT(Node src, Node dst) { return relate(src, dst, Relations.NEXT); }
	public static Relationship relateISCONTROLFLOWSTART(Node src, Node dst) { return relate(src, dst, Relations.ISCONTROLFLOWSTART); }
	public static Relationship relateISCONTROLFLOWEND(Node src, Node dst) { return relate(src, dst, Relations.ISCONTROLFLOWEND); }
	public static Relationship relateSTATEMENT_PARAMETER(Node src, Node dst) { return relate(src, dst, Relations.STATEMENT_PARAMETER); }
	public static Relationship relateSTATEMENT_PARAMETER_TYPE(Node src, Node dst) { return relate(src, dst, Relations.STATEMENT_PARAMETER_TYPE); }
	public static Relationship relateISARRAY(Node src, Node dst) { return relate(src, dst, Relations.ISARRAY); }
	public static Relationship relateTYPEARGUMENTS(Node src, Node dst) { return relate(src, dst, Relations.TYPEARGUMENTS); }
	public static Relationship relateSUBTYPE(Node src, Node dst) { return relate(src, dst, Relations.SUBTYPE); }
	public static Relationship relateSUPERTYPE(Node src, Node dst) { return relate(src, dst, Relations.SUPERTYPE); }
	public static Relationship relateMETHODS(Node src, Node dst) { return relate(src, dst, Relations.METHODS); }
	public static Relationship relateSTATEMENTS(Node src, Node dst) { return relate(src, dst, Relations.STATEMENTS); }
	public static Relationship relateRETURNS(Node src, Node dst) { return relate(src, dst, Relations.RETURNS); }
	public static Relationship relatePARAMETER(Node src, Node dst) { return relate(src, dst, Relations.PARAMETER); }
	public static Relationship relateLIBRARYTYPES(Node src, Node dst) { return relate(src, dst, Relations.LIBRARYTYPES); }

	// packageName
	public static <T> T getPackageNameProperty(PropertyContainer container) { return getPackageNameProperty(container, null); }
	public static <T> T getPackageNameProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.packageName.name(), defaultValue); }
	public static boolean hasPackageNameProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.packageName.name()); }
	public static <T extends PropertyContainer> T setPackageNameProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.packageName.name(), value); return container; }
	public static <T extends PropertyContainer> T removePackageNameProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.packageName.name()); return container; }

	protected <T extends PropertyContainer> T setPackageNameProperty(T container, Object value) { setPackageNameProperty(getGraph(), container, value); return container; }

	// type
	public static <T> T getTypeProperty(PropertyContainer container) { return getTypeProperty(container, null); }
	public static <T> T getTypeProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.type.name(), defaultValue); }
	public static boolean hasTypeProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.type.name()); }
	public static <T extends PropertyContainer> T setTypeProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.type.name(), value); return container; }
	public static <T extends PropertyContainer> T removeTypeProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.type.name()); return container; }

	protected <T extends PropertyContainer> T setTypeProperty(T container, Object value) { setTypeProperty(getGraph(), container, value); return container; }

	// name
	public static <T> T getNameProperty(PropertyContainer container) { return getNameProperty(container, null); }
	public static <T> T getNameProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.name.name(), defaultValue); }
	public static boolean hasNameProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.name.name()); }
	public static <T extends PropertyContainer> T setNameProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.name.name(), value); return container; }
	public static <T extends PropertyContainer> T removeNameProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.name.name()); return container; }

	protected <T extends PropertyContainer> T setNameProperty(T container, Object value) { setNameProperty(getGraph(), container, value); return container; }

	// statement
	public static <T> T getStatementProperty(PropertyContainer container) { return getStatementProperty(container, null); }
	public static <T> T getStatementProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.statement.name(), defaultValue); }
	public static boolean hasStatementProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.statement.name()); }
	public static <T extends PropertyContainer> T setStatementProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.statement.name(), value); return container; }
	public static <T extends PropertyContainer> T removeStatementProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.statement.name()); return container; }

	protected <T extends PropertyContainer> T setStatementProperty(T container, Object value) { setStatementProperty(getGraph(), container, value); return container; }

	// isControlFlowStart
	public static <T> T getIsControlFlowStartProperty(PropertyContainer container) { return getIsControlFlowStartProperty(container, null); }
	public static <T> T getIsControlFlowStartProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.isControlFlowStart.name(), defaultValue); }
	public static boolean hasIsControlFlowStartProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.isControlFlowStart.name()); }
	public static <T extends PropertyContainer> T setIsControlFlowStartProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.isControlFlowStart.name(), value); return container; }
	public static <T extends PropertyContainer> T removeIsControlFlowStartProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.isControlFlowStart.name()); return container; }

	protected <T extends PropertyContainer> T setIsControlFlowStartProperty(T container, Object value) { setIsControlFlowStartProperty(getGraph(), container, value); return container; }

	// isControlFlowEnd
	public static <T> T getIsControlFlowEndProperty(PropertyContainer container) { return getIsControlFlowEndProperty(container, null); }
	public static <T> T getIsControlFlowEndProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.isControlFlowEnd.name(), defaultValue); }
	public static boolean hasIsControlFlowEndProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.isControlFlowEnd.name()); }
	public static <T extends PropertyContainer> T setIsControlFlowEndProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.isControlFlowEnd.name(), value); return container; }
	public static <T extends PropertyContainer> T removeIsControlFlowEndProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.isControlFlowEnd.name()); return container; }

	protected <T extends PropertyContainer> T setIsControlFlowEndProperty(T container, Object value) { setIsControlFlowEndProperty(getGraph(), container, value); return container; }

	// isArray
	public static <T> T getIsArrayProperty(PropertyContainer container) { return getIsArrayProperty(container, null); }
	public static <T> T getIsArrayProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.isArray.name(), defaultValue); }
	public static boolean hasIsArrayProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.isArray.name()); }
	public static <T extends PropertyContainer> T setIsArrayProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.isArray.name(), value); return container; }
	public static <T extends PropertyContainer> T removeIsArrayProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.isArray.name()); return container; }

	protected <T extends PropertyContainer> T setIsArrayProperty(T container, Object value) { setIsArrayProperty(getGraph(), container, value); return container; }

}