package com.generator.generators.maven;

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
 * Auto-generated from domain MavenDomainPlugin
 */
public abstract class MavenDomainPlugin extends Plugin {

	public enum Entities implements Label {
      POM, BaseBuild, Filter, Plugin, Dependency, Exclusion, Execution, Configuration, Resource, Include, Exclude, TestResource, KeyValue, property
   }

   public enum Relations implements RelationshipType {
      POM, BASEBUILD, FILTERS, PLUGINS, DEPENDENCIES, EXCLUSIONS, EXECUTIONS, CONFIGURATION, RESOURCES, INCLUDES, EXCLUDES, TEST_RESOURCE, KEYVALUE, PROPERTIES
   }

   public enum Properties {
      defaultGoal, directory, finalName, propertyFile, groupId, artifactId, version, type, scope, optional, id, phase, inherited, goals, extension, value, name, targetPath, filtering, key, packaging, classifier
   }

	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

	private final Node domainNode;

   MavenDomainPlugin(App app) {
      super(app, "Maven");

		domainNode = DomainMotif.newDomainNode(getGraph(), "Maven");
		entitiesNodeMap.put(Entities.POM, DomainMotif.newDomainEntity(getGraph(), Entities.POM, domainNode));
		entitiesNodeMap.put(Entities.BaseBuild, DomainMotif.newDomainEntity(getGraph(), Entities.BaseBuild, domainNode));
		entitiesNodeMap.put(Entities.Filter, DomainMotif.newDomainEntity(getGraph(), Entities.Filter, domainNode));
		entitiesNodeMap.put(Entities.Plugin, DomainMotif.newDomainEntity(getGraph(), Entities.Plugin, domainNode));
		entitiesNodeMap.put(Entities.Dependency, DomainMotif.newDomainEntity(getGraph(), Entities.Dependency, domainNode));
		entitiesNodeMap.put(Entities.Exclusion, DomainMotif.newDomainEntity(getGraph(), Entities.Exclusion, domainNode));
		entitiesNodeMap.put(Entities.Execution, DomainMotif.newDomainEntity(getGraph(), Entities.Execution, domainNode));
		entitiesNodeMap.put(Entities.Configuration, DomainMotif.newDomainEntity(getGraph(), Entities.Configuration, domainNode));
		entitiesNodeMap.put(Entities.Resource, DomainMotif.newDomainEntity(getGraph(), Entities.Resource, domainNode));
		entitiesNodeMap.put(Entities.Include, DomainMotif.newDomainEntity(getGraph(), Entities.Include, domainNode));
		entitiesNodeMap.put(Entities.Exclude, DomainMotif.newDomainEntity(getGraph(), Entities.Exclude, domainNode));
		entitiesNodeMap.put(Entities.TestResource, DomainMotif.newDomainEntity(getGraph(), Entities.TestResource, domainNode));
		entitiesNodeMap.put(Entities.KeyValue, DomainMotif.newDomainEntity(getGraph(), Entities.KeyValue, domainNode));
		entitiesNodeMap.put(Entities.property, DomainMotif.newDomainEntity(getGraph(), Entities.property, domainNode));

		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.POM), Properties.groupId.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.POM), Properties.artifactId.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.POM), Properties.version.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.POM), Properties.packaging.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.POM), Properties.classifier.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.BaseBuild), Properties.defaultGoal.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.BaseBuild), Properties.directory.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.BaseBuild), Properties.finalName.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Filter), Properties.propertyFile.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Plugin), Properties.artifactId.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Plugin), Properties.version.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Plugin), Properties.extension.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Plugin), Properties.inherited.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Plugin), Properties.groupId.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Dependency), Properties.groupId.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Dependency), Properties.artifactId.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Dependency), Properties.version.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Dependency), Properties.type.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Dependency), Properties.scope.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Dependency), Properties.optional.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Exclusion), Properties.groupId.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Exclusion), Properties.artifactId.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Execution), Properties.id.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Execution), Properties.phase.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Execution), Properties.inherited.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Execution), Properties.goals.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Configuration), Properties.value.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Configuration), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Resource), Properties.targetPath.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Resource), Properties.filtering.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Resource), Properties.directory.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Include), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Exclude), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.KeyValue), Properties.key.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.KeyValue), Properties.value.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.property), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.property), Properties.value.name());

		relate(domainNode, entitiesNodeMap.get(Entities.POM), DomainPlugin.Relations.ENTITY);
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.POM), Relations.BASEBUILD.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.BaseBuild));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.POM), Relations.DEPENDENCIES.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Dependency));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.POM), Relations.PROPERTIES.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.property));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.BaseBuild), Relations.FILTERS.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Filter));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.BaseBuild), Relations.PLUGINS.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Plugin));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.BaseBuild), Relations.RESOURCES.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Resource));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.BaseBuild), Relations.TEST_RESOURCE.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.TestResource));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Plugin), Relations.DEPENDENCIES.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Dependency));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Plugin), Relations.EXECUTIONS.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Execution));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Plugin), Relations.CONFIGURATION.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Configuration));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Dependency), Relations.EXCLUSIONS.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Exclusion));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Resource), Relations.INCLUDES.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Include));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Resource), Relations.EXCLUDES.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Exclude));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.TestResource), Relations.KEYVALUE.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.KeyValue));
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
		if (isPOM(neoNode.getNode())) handlePOM(pop, neoNode, selectedNodes);
		if (isBaseBuild(neoNode.getNode())) handleBaseBuild(pop, neoNode, selectedNodes);
		if (isFilter(neoNode.getNode())) handleFilter(pop, neoNode, selectedNodes);
		if (isPlugin(neoNode.getNode())) handlePlugin(pop, neoNode, selectedNodes);
		if (isDependency(neoNode.getNode())) handleDependency(pop, neoNode, selectedNodes);
		if (isExclusion(neoNode.getNode())) handleExclusion(pop, neoNode, selectedNodes);
		if (isExecution(neoNode.getNode())) handleExecution(pop, neoNode, selectedNodes);
		if (isConfiguration(neoNode.getNode())) handleConfiguration(pop, neoNode, selectedNodes);
		if (isResource(neoNode.getNode())) handleResource(pop, neoNode, selectedNodes);
		if (isInclude(neoNode.getNode())) handleInclude(pop, neoNode, selectedNodes);
		if (isExclude(neoNode.getNode())) handleExclude(pop, neoNode, selectedNodes);
		if (isTestResource(neoNode.getNode())) handleTestResource(pop, neoNode, selectedNodes);
		if (isKeyValue(neoNode.getNode())) handleKeyValue(pop, neoNode, selectedNodes);
		if (isproperty(neoNode.getNode())) handleproperty(pop, neoNode, selectedNodes);
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
		if (isPOM(neoNode.getNode())) return newPOMEditor(neoNode);
		if (isBaseBuild(neoNode.getNode())) return newBaseBuildEditor(neoNode);
		if (isFilter(neoNode.getNode())) return newFilterEditor(neoNode);
		if (isPlugin(neoNode.getNode())) return newPluginEditor(neoNode);
		if (isDependency(neoNode.getNode())) return newDependencyEditor(neoNode);
		if (isExclusion(neoNode.getNode())) return newExclusionEditor(neoNode);
		if (isExecution(neoNode.getNode())) return newExecutionEditor(neoNode);
		if (isConfiguration(neoNode.getNode())) return newConfigurationEditor(neoNode);
		if (isResource(neoNode.getNode())) return newResourceEditor(neoNode);
		if (isInclude(neoNode.getNode())) return newIncludeEditor(neoNode);
		if (isExclude(neoNode.getNode())) return newExcludeEditor(neoNode);
		if (isTestResource(neoNode.getNode())) return newTestResourceEditor(neoNode);
		if (isKeyValue(neoNode.getNode())) return newKeyValueEditor(neoNode);
		if (isproperty(neoNode.getNode())) return newpropertyEditor(neoNode);
      return null;
   }

	public Node getDomainNode() { return domainNode; }

	public Node getEntityNode(Label label) { return entitiesNodeMap.get(label); }

	protected void handlePOM(JPopupMenu pop, NeoNode pOMNode, Set<NeoNode> selectedNodes) { }
	protected void handleBaseBuild(JPopupMenu pop, NeoNode baseBuildNode, Set<NeoNode> selectedNodes) { }
	protected void handleFilter(JPopupMenu pop, NeoNode filterNode, Set<NeoNode> selectedNodes) { }
	protected void handlePlugin(JPopupMenu pop, NeoNode pluginNode, Set<NeoNode> selectedNodes) { }
	protected void handleDependency(JPopupMenu pop, NeoNode dependencyNode, Set<NeoNode> selectedNodes) { }
	protected void handleExclusion(JPopupMenu pop, NeoNode exclusionNode, Set<NeoNode> selectedNodes) { }
	protected void handleExecution(JPopupMenu pop, NeoNode executionNode, Set<NeoNode> selectedNodes) { }
	protected void handleConfiguration(JPopupMenu pop, NeoNode configurationNode, Set<NeoNode> selectedNodes) { }
	protected void handleResource(JPopupMenu pop, NeoNode resourceNode, Set<NeoNode> selectedNodes) { }
	protected void handleInclude(JPopupMenu pop, NeoNode includeNode, Set<NeoNode> selectedNodes) { }
	protected void handleExclude(JPopupMenu pop, NeoNode excludeNode, Set<NeoNode> selectedNodes) { }
	protected void handleTestResource(JPopupMenu pop, NeoNode testResourceNode, Set<NeoNode> selectedNodes) { }
	protected void handleKeyValue(JPopupMenu pop, NeoNode keyValueNode, Set<NeoNode> selectedNodes) { }
	protected void handleproperty(JPopupMenu pop, NeoNode propertyNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newPOMEditor(NeoNode pOMNode) { return null; }
	protected JComponent newBaseBuildEditor(NeoNode baseBuildNode) { return null; }
	protected JComponent newFilterEditor(NeoNode filterNode) { return null; }
	protected JComponent newPluginEditor(NeoNode pluginNode) { return null; }
	protected JComponent newDependencyEditor(NeoNode dependencyNode) { return null; }
	protected JComponent newExclusionEditor(NeoNode exclusionNode) { return null; }
	protected JComponent newExecutionEditor(NeoNode executionNode) { return null; }
	protected JComponent newConfigurationEditor(NeoNode configurationNode) { return null; }
	protected JComponent newResourceEditor(NeoNode resourceNode) { return null; }
	protected JComponent newIncludeEditor(NeoNode includeNode) { return null; }
	protected JComponent newExcludeEditor(NeoNode excludeNode) { return null; }
	protected JComponent newTestResourceEditor(NeoNode testResourceNode) { return null; }
	protected JComponent newKeyValueEditor(NeoNode keyValueNode) { return null; }
	protected JComponent newpropertyEditor(NeoNode propertyNode) { return null; }

	public static boolean isPOM(Node node) { return hasLabel(node, Entities.POM); }
	public static boolean isBaseBuild(Node node) { return hasLabel(node, Entities.BaseBuild); }
	public static boolean isFilter(Node node) { return hasLabel(node, Entities.Filter); }
	public static boolean isPlugin(Node node) { return hasLabel(node, Entities.Plugin); }
	public static boolean isDependency(Node node) { return hasLabel(node, Entities.Dependency); }
	public static boolean isExclusion(Node node) { return hasLabel(node, Entities.Exclusion); }
	public static boolean isExecution(Node node) { return hasLabel(node, Entities.Execution); }
	public static boolean isConfiguration(Node node) { return hasLabel(node, Entities.Configuration); }
	public static boolean isResource(Node node) { return hasLabel(node, Entities.Resource); }
	public static boolean isInclude(Node node) { return hasLabel(node, Entities.Include); }
	public static boolean isExclude(Node node) { return hasLabel(node, Entities.Exclude); }
	public static boolean isTestResource(Node node) { return hasLabel(node, Entities.TestResource); }
	public static boolean isKeyValue(Node node) { return hasLabel(node, Entities.KeyValue); }
	public static boolean isproperty(Node node) { return hasLabel(node, Entities.property); }

	protected Node newPOM() { return newPOM(getGraph()); } 
	protected Node newPOM(Object groupId, Object artifactId, Object version, Object packaging, Object classifier) { return newPOM(getGraph(), groupId, artifactId, version, packaging, classifier); } 

	public static Node newPOM(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.POM)); } 
	public static Node newPOM(NeoModel graph, Object groupId, Object artifactId, Object version, Object packaging, Object classifier) {  	
		final Node newNode = newPOM(graph); 	
		if (groupId != null) relate(newNode, DomainMotif.newValueNode(graph, groupId), RelationshipType.withName(Properties.groupId.name()));
		if (artifactId != null) relate(newNode, DomainMotif.newValueNode(graph, artifactId), RelationshipType.withName(Properties.artifactId.name()));
		if (version != null) relate(newNode, DomainMotif.newValueNode(graph, version), RelationshipType.withName(Properties.version.name()));
		if (packaging != null) relate(newNode, DomainMotif.newValueNode(graph, packaging), RelationshipType.withName(Properties.packaging.name()));
		if (classifier != null) relate(newNode, DomainMotif.newValueNode(graph, classifier), RelationshipType.withName(Properties.classifier.name())); 	
		return newNode; 
	}

	protected Node newBaseBuild() { return newBaseBuild(getGraph()); } 
	protected Node newBaseBuild(Object defaultGoal, Object directory, Object finalName) { return newBaseBuild(getGraph(), defaultGoal, directory, finalName); } 

	public static Node newBaseBuild(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.BaseBuild)); } 
	public static Node newBaseBuild(NeoModel graph, Object defaultGoal, Object directory, Object finalName) {  	
		final Node newNode = newBaseBuild(graph); 	
		if (defaultGoal != null) relate(newNode, DomainMotif.newValueNode(graph, defaultGoal), RelationshipType.withName(Properties.defaultGoal.name()));
		if (directory != null) relate(newNode, DomainMotif.newValueNode(graph, directory), RelationshipType.withName(Properties.directory.name()));
		if (finalName != null) relate(newNode, DomainMotif.newValueNode(graph, finalName), RelationshipType.withName(Properties.finalName.name())); 	
		return newNode; 
	}

	protected Node newFilter() { return newFilter(getGraph()); } 
	protected Node newFilter(Object propertyFile) { return newFilter(getGraph(), propertyFile); } 

	public static Node newFilter(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Filter)); } 
	public static Node newFilter(NeoModel graph, Object propertyFile) {  	
		final Node newNode = newFilter(graph); 	
		if (propertyFile != null) relate(newNode, DomainMotif.newValueNode(graph, propertyFile), RelationshipType.withName(Properties.propertyFile.name())); 	
		return newNode; 
	}

	protected Node newPlugin() { return newPlugin(getGraph()); } 
	protected Node newPlugin(Object artifactId, Object version, Object extension, Object inherited, Object groupId) { return newPlugin(getGraph(), artifactId, version, extension, inherited, groupId); } 

	public static Node newPlugin(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Plugin)); } 
	public static Node newPlugin(NeoModel graph, Object artifactId, Object version, Object extension, Object inherited, Object groupId) {  	
		final Node newNode = newPlugin(graph); 	
		if (artifactId != null) relate(newNode, DomainMotif.newValueNode(graph, artifactId), RelationshipType.withName(Properties.artifactId.name()));
		if (version != null) relate(newNode, DomainMotif.newValueNode(graph, version), RelationshipType.withName(Properties.version.name()));
		if (extension != null) relate(newNode, DomainMotif.newValueNode(graph, extension), RelationshipType.withName(Properties.extension.name()));
		if (inherited != null) relate(newNode, DomainMotif.newValueNode(graph, inherited), RelationshipType.withName(Properties.inherited.name()));
		if (groupId != null) relate(newNode, DomainMotif.newValueNode(graph, groupId), RelationshipType.withName(Properties.groupId.name())); 	
		return newNode; 
	}

	protected Node newDependency() { return newDependency(getGraph()); } 
	protected Node newDependency(Object groupId, Object artifactId, Object version, Object type, Object scope, Object optional) { return newDependency(getGraph(), groupId, artifactId, version, type, scope, optional); } 

	public static Node newDependency(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Dependency)); } 
	public static Node newDependency(NeoModel graph, Object groupId, Object artifactId, Object version, Object type, Object scope, Object optional) {  	
		final Node newNode = newDependency(graph); 	
		if (groupId != null) relate(newNode, DomainMotif.newValueNode(graph, groupId), RelationshipType.withName(Properties.groupId.name()));
		if (artifactId != null) relate(newNode, DomainMotif.newValueNode(graph, artifactId), RelationshipType.withName(Properties.artifactId.name()));
		if (version != null) relate(newNode, DomainMotif.newValueNode(graph, version), RelationshipType.withName(Properties.version.name()));
		if (type != null) relate(newNode, DomainMotif.newValueNode(graph, type), RelationshipType.withName(Properties.type.name()));
		if (scope != null) relate(newNode, DomainMotif.newValueNode(graph, scope), RelationshipType.withName(Properties.scope.name()));
		if (optional != null) relate(newNode, DomainMotif.newValueNode(graph, optional), RelationshipType.withName(Properties.optional.name())); 	
		return newNode; 
	}

	protected Node newExclusion() { return newExclusion(getGraph()); } 
	protected Node newExclusion(Object groupId, Object artifactId) { return newExclusion(getGraph(), groupId, artifactId); } 

	public static Node newExclusion(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Exclusion)); } 
	public static Node newExclusion(NeoModel graph, Object groupId, Object artifactId) {  	
		final Node newNode = newExclusion(graph); 	
		if (groupId != null) relate(newNode, DomainMotif.newValueNode(graph, groupId), RelationshipType.withName(Properties.groupId.name()));
		if (artifactId != null) relate(newNode, DomainMotif.newValueNode(graph, artifactId), RelationshipType.withName(Properties.artifactId.name())); 	
		return newNode; 
	}

	protected Node newExecution() { return newExecution(getGraph()); } 
	protected Node newExecution(Object id, Object phase, Object inherited, Object goals) { return newExecution(getGraph(), id, phase, inherited, goals); } 

	public static Node newExecution(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Execution)); } 
	public static Node newExecution(NeoModel graph, Object id, Object phase, Object inherited, Object goals) {  	
		final Node newNode = newExecution(graph); 	
		if (id != null) relate(newNode, DomainMotif.newValueNode(graph, id), RelationshipType.withName(Properties.id.name()));
		if (phase != null) relate(newNode, DomainMotif.newValueNode(graph, phase), RelationshipType.withName(Properties.phase.name()));
		if (inherited != null) relate(newNode, DomainMotif.newValueNode(graph, inherited), RelationshipType.withName(Properties.inherited.name()));
		if (goals != null) relate(newNode, DomainMotif.newValueNode(graph, goals), RelationshipType.withName(Properties.goals.name())); 	
		return newNode; 
	}

	protected Node newConfiguration() { return newConfiguration(getGraph()); } 
	protected Node newConfiguration(Object value, Object name) { return newConfiguration(getGraph(), value, name); } 

	public static Node newConfiguration(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Configuration)); } 
	public static Node newConfiguration(NeoModel graph, Object value, Object name) {  	
		final Node newNode = newConfiguration(graph); 	
		if (value != null) relate(newNode, DomainMotif.newValueNode(graph, value), RelationshipType.withName(Properties.value.name()));
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newResource() { return newResource(getGraph()); } 
	protected Node newResource(Object targetPath, Object filtering, Object directory) { return newResource(getGraph(), targetPath, filtering, directory); } 

	public static Node newResource(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Resource)); } 
	public static Node newResource(NeoModel graph, Object targetPath, Object filtering, Object directory) {  	
		final Node newNode = newResource(graph); 	
		if (targetPath != null) relate(newNode, DomainMotif.newValueNode(graph, targetPath), RelationshipType.withName(Properties.targetPath.name()));
		if (filtering != null) relate(newNode, DomainMotif.newValueNode(graph, filtering), RelationshipType.withName(Properties.filtering.name()));
		if (directory != null) relate(newNode, DomainMotif.newValueNode(graph, directory), RelationshipType.withName(Properties.directory.name())); 	
		return newNode; 
	}

	protected Node newInclude() { return newInclude(getGraph()); } 
	protected Node newInclude(Object name) { return newInclude(getGraph(), name); } 

	public static Node newInclude(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Include)); } 
	public static Node newInclude(NeoModel graph, Object name) {  	
		final Node newNode = newInclude(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newExclude() { return newExclude(getGraph()); } 
	protected Node newExclude(Object name) { return newExclude(getGraph(), name); } 

	public static Node newExclude(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Exclude)); } 
	public static Node newExclude(NeoModel graph, Object name) {  	
		final Node newNode = newExclude(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newTestResource() { return newTestResource(getGraph()); }
	public static Node newTestResource(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.TestResource)); }

	protected Node newKeyValue() { return newKeyValue(getGraph()); } 
	protected Node newKeyValue(Object key, Object value) { return newKeyValue(getGraph(), key, value); } 

	public static Node newKeyValue(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.KeyValue)); } 
	public static Node newKeyValue(NeoModel graph, Object key, Object value) {  	
		final Node newNode = newKeyValue(graph); 	
		if (key != null) relate(newNode, DomainMotif.newValueNode(graph, key), RelationshipType.withName(Properties.key.name()));
		if (value != null) relate(newNode, DomainMotif.newValueNode(graph, value), RelationshipType.withName(Properties.value.name())); 	
		return newNode; 
	}

	protected Node newproperty() { return newproperty(getGraph()); } 
	protected Node newproperty(Object name, Object value) { return newproperty(getGraph(), name, value); } 

	public static Node newproperty(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.property)); } 
	public static Node newproperty(NeoModel graph, Object name, Object value) {  	
		final Node newNode = newproperty(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name()));
		if (value != null) relate(newNode, DomainMotif.newValueNode(graph, value), RelationshipType.withName(Properties.value.name())); 	
		return newNode; 
	}


	public static void outgoingPOM(Node src, RelationConsumer consumer) { outgoing(src, Relations.POM).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPOM(Node src) { return other(src, singleOutgoing(src, Relations.POM)); }
	public static void incomingPOM(Node src, RelationConsumer consumer) { incoming(src, Relations.POM).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPOM(Node src) { return other(src, singleIncoming(src, Relations.POM)); }

	public static void outgoingBASEBUILD(Node src, RelationConsumer consumer) { outgoing(src, Relations.BASEBUILD).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingBASEBUILD(Node src) { return other(src, singleOutgoing(src, Relations.BASEBUILD)); }
	public static void incomingBASEBUILD(Node src, RelationConsumer consumer) { incoming(src, Relations.BASEBUILD).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingBASEBUILD(Node src) { return other(src, singleIncoming(src, Relations.BASEBUILD)); }

	public static void outgoingFILTERS(Node src, RelationConsumer consumer) { outgoing(src, Relations.FILTERS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingFILTERS(Node src) { return other(src, singleOutgoing(src, Relations.FILTERS)); }
	public static void incomingFILTERS(Node src, RelationConsumer consumer) { incoming(src, Relations.FILTERS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingFILTERS(Node src) { return other(src, singleIncoming(src, Relations.FILTERS)); }

	public static void outgoingPLUGINS(Node src, RelationConsumer consumer) { outgoing(src, Relations.PLUGINS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPLUGINS(Node src) { return other(src, singleOutgoing(src, Relations.PLUGINS)); }
	public static void incomingPLUGINS(Node src, RelationConsumer consumer) { incoming(src, Relations.PLUGINS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPLUGINS(Node src) { return other(src, singleIncoming(src, Relations.PLUGINS)); }

	public static void outgoingDEPENDENCIES(Node src, RelationConsumer consumer) { outgoing(src, Relations.DEPENDENCIES).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingDEPENDENCIES(Node src) { return other(src, singleOutgoing(src, Relations.DEPENDENCIES)); }
	public static void incomingDEPENDENCIES(Node src, RelationConsumer consumer) { incoming(src, Relations.DEPENDENCIES).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingDEPENDENCIES(Node src) { return other(src, singleIncoming(src, Relations.DEPENDENCIES)); }

	public static void outgoingEXCLUSIONS(Node src, RelationConsumer consumer) { outgoing(src, Relations.EXCLUSIONS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingEXCLUSIONS(Node src) { return other(src, singleOutgoing(src, Relations.EXCLUSIONS)); }
	public static void incomingEXCLUSIONS(Node src, RelationConsumer consumer) { incoming(src, Relations.EXCLUSIONS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingEXCLUSIONS(Node src) { return other(src, singleIncoming(src, Relations.EXCLUSIONS)); }

	public static void outgoingEXECUTIONS(Node src, RelationConsumer consumer) { outgoing(src, Relations.EXECUTIONS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingEXECUTIONS(Node src) { return other(src, singleOutgoing(src, Relations.EXECUTIONS)); }
	public static void incomingEXECUTIONS(Node src, RelationConsumer consumer) { incoming(src, Relations.EXECUTIONS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingEXECUTIONS(Node src) { return other(src, singleIncoming(src, Relations.EXECUTIONS)); }

	public static void outgoingCONFIGURATION(Node src, RelationConsumer consumer) { outgoing(src, Relations.CONFIGURATION).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingCONFIGURATION(Node src) { return other(src, singleOutgoing(src, Relations.CONFIGURATION)); }
	public static void incomingCONFIGURATION(Node src, RelationConsumer consumer) { incoming(src, Relations.CONFIGURATION).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingCONFIGURATION(Node src) { return other(src, singleIncoming(src, Relations.CONFIGURATION)); }

	public static void outgoingRESOURCES(Node src, RelationConsumer consumer) { outgoing(src, Relations.RESOURCES).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingRESOURCES(Node src) { return other(src, singleOutgoing(src, Relations.RESOURCES)); }
	public static void incomingRESOURCES(Node src, RelationConsumer consumer) { incoming(src, Relations.RESOURCES).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingRESOURCES(Node src) { return other(src, singleIncoming(src, Relations.RESOURCES)); }

	public static void outgoingINCLUDES(Node src, RelationConsumer consumer) { outgoing(src, Relations.INCLUDES).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingINCLUDES(Node src) { return other(src, singleOutgoing(src, Relations.INCLUDES)); }
	public static void incomingINCLUDES(Node src, RelationConsumer consumer) { incoming(src, Relations.INCLUDES).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingINCLUDES(Node src) { return other(src, singleIncoming(src, Relations.INCLUDES)); }

	public static void outgoingEXCLUDES(Node src, RelationConsumer consumer) { outgoing(src, Relations.EXCLUDES).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingEXCLUDES(Node src) { return other(src, singleOutgoing(src, Relations.EXCLUDES)); }
	public static void incomingEXCLUDES(Node src, RelationConsumer consumer) { incoming(src, Relations.EXCLUDES).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingEXCLUDES(Node src) { return other(src, singleIncoming(src, Relations.EXCLUDES)); }

	public static void outgoingTEST_RESOURCE(Node src, RelationConsumer consumer) { outgoing(src, Relations.TEST_RESOURCE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingTEST_RESOURCE(Node src) { return other(src, singleOutgoing(src, Relations.TEST_RESOURCE)); }
	public static void incomingTEST_RESOURCE(Node src, RelationConsumer consumer) { incoming(src, Relations.TEST_RESOURCE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingTEST_RESOURCE(Node src) { return other(src, singleIncoming(src, Relations.TEST_RESOURCE)); }

	public static void outgoingKEYVALUE(Node src, RelationConsumer consumer) { outgoing(src, Relations.KEYVALUE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingKEYVALUE(Node src) { return other(src, singleOutgoing(src, Relations.KEYVALUE)); }
	public static void incomingKEYVALUE(Node src, RelationConsumer consumer) { incoming(src, Relations.KEYVALUE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingKEYVALUE(Node src) { return other(src, singleIncoming(src, Relations.KEYVALUE)); }

	public static void outgoingPROPERTIES(Node src, RelationConsumer consumer) { outgoing(src, Relations.PROPERTIES).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPROPERTIES(Node src) { return other(src, singleOutgoing(src, Relations.PROPERTIES)); }
	public static void incomingPROPERTIES(Node src, RelationConsumer consumer) { incoming(src, Relations.PROPERTIES).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPROPERTIES(Node src) { return other(src, singleIncoming(src, Relations.PROPERTIES)); }


	public static Relationship relatePOM(Node src, Node dst) { return relate(src, dst, Relations.POM); }
	public static Relationship relateBASEBUILD(Node src, Node dst) { return relate(src, dst, Relations.BASEBUILD); }
	public static Relationship relateFILTERS(Node src, Node dst) { return relate(src, dst, Relations.FILTERS); }
	public static Relationship relatePLUGINS(Node src, Node dst) { return relate(src, dst, Relations.PLUGINS); }
	public static Relationship relateDEPENDENCIES(Node src, Node dst) { return relate(src, dst, Relations.DEPENDENCIES); }
	public static Relationship relateEXCLUSIONS(Node src, Node dst) { return relate(src, dst, Relations.EXCLUSIONS); }
	public static Relationship relateEXECUTIONS(Node src, Node dst) { return relate(src, dst, Relations.EXECUTIONS); }
	public static Relationship relateCONFIGURATION(Node src, Node dst) { return relate(src, dst, Relations.CONFIGURATION); }
	public static Relationship relateRESOURCES(Node src, Node dst) { return relate(src, dst, Relations.RESOURCES); }
	public static Relationship relateINCLUDES(Node src, Node dst) { return relate(src, dst, Relations.INCLUDES); }
	public static Relationship relateEXCLUDES(Node src, Node dst) { return relate(src, dst, Relations.EXCLUDES); }
	public static Relationship relateTEST_RESOURCE(Node src, Node dst) { return relate(src, dst, Relations.TEST_RESOURCE); }
	public static Relationship relateKEYVALUE(Node src, Node dst) { return relate(src, dst, Relations.KEYVALUE); }
	public static Relationship relatePROPERTIES(Node src, Node dst) { return relate(src, dst, Relations.PROPERTIES); }

	// defaultGoal
	public static <T> T getDefaultGoalProperty(PropertyContainer container) { return getDefaultGoalProperty(container, null); }
	public static <T> T getDefaultGoalProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.defaultGoal.name(), defaultValue); }
	public static boolean hasDefaultGoalProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.defaultGoal.name()); }
	public static <T extends PropertyContainer> T setDefaultGoalProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.defaultGoal.name(), value); return container; }
	public static <T extends PropertyContainer> T removeDefaultGoalProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.defaultGoal.name()); return container; }

	protected <T extends PropertyContainer> T setDefaultGoalProperty(T container, Object value) { setDefaultGoalProperty(getGraph(), container, value); return container; }

	// directory
	public static <T> T getDirectoryProperty(PropertyContainer container) { return getDirectoryProperty(container, null); }
	public static <T> T getDirectoryProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.directory.name(), defaultValue); }
	public static boolean hasDirectoryProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.directory.name()); }
	public static <T extends PropertyContainer> T setDirectoryProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.directory.name(), value); return container; }
	public static <T extends PropertyContainer> T removeDirectoryProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.directory.name()); return container; }

	protected <T extends PropertyContainer> T setDirectoryProperty(T container, Object value) { setDirectoryProperty(getGraph(), container, value); return container; }

	// finalName
	public static <T> T getFinalNameProperty(PropertyContainer container) { return getFinalNameProperty(container, null); }
	public static <T> T getFinalNameProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.finalName.name(), defaultValue); }
	public static boolean hasFinalNameProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.finalName.name()); }
	public static <T extends PropertyContainer> T setFinalNameProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.finalName.name(), value); return container; }
	public static <T extends PropertyContainer> T removeFinalNameProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.finalName.name()); return container; }

	protected <T extends PropertyContainer> T setFinalNameProperty(T container, Object value) { setFinalNameProperty(getGraph(), container, value); return container; }

	// propertyFile
	public static <T> T getPropertyFileProperty(PropertyContainer container) { return getPropertyFileProperty(container, null); }
	public static <T> T getPropertyFileProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.propertyFile.name(), defaultValue); }
	public static boolean hasPropertyFileProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.propertyFile.name()); }
	public static <T extends PropertyContainer> T setPropertyFileProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.propertyFile.name(), value); return container; }
	public static <T extends PropertyContainer> T removePropertyFileProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.propertyFile.name()); return container; }

	protected <T extends PropertyContainer> T setPropertyFileProperty(T container, Object value) { setPropertyFileProperty(getGraph(), container, value); return container; }

	// groupId
	public static <T> T getGroupIdProperty(PropertyContainer container) { return getGroupIdProperty(container, null); }
	public static <T> T getGroupIdProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.groupId.name(), defaultValue); }
	public static boolean hasGroupIdProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.groupId.name()); }
	public static <T extends PropertyContainer> T setGroupIdProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.groupId.name(), value); return container; }
	public static <T extends PropertyContainer> T removeGroupIdProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.groupId.name()); return container; }

	protected <T extends PropertyContainer> T setGroupIdProperty(T container, Object value) { setGroupIdProperty(getGraph(), container, value); return container; }

	// artifactId
	public static <T> T getArtifactIdProperty(PropertyContainer container) { return getArtifactIdProperty(container, null); }
	public static <T> T getArtifactIdProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.artifactId.name(), defaultValue); }
	public static boolean hasArtifactIdProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.artifactId.name()); }
	public static <T extends PropertyContainer> T setArtifactIdProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.artifactId.name(), value); return container; }
	public static <T extends PropertyContainer> T removeArtifactIdProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.artifactId.name()); return container; }

	protected <T extends PropertyContainer> T setArtifactIdProperty(T container, Object value) { setArtifactIdProperty(getGraph(), container, value); return container; }

	// version
	public static <T> T getVersionProperty(PropertyContainer container) { return getVersionProperty(container, null); }
	public static <T> T getVersionProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.version.name(), defaultValue); }
	public static boolean hasVersionProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.version.name()); }
	public static <T extends PropertyContainer> T setVersionProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.version.name(), value); return container; }
	public static <T extends PropertyContainer> T removeVersionProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.version.name()); return container; }

	protected <T extends PropertyContainer> T setVersionProperty(T container, Object value) { setVersionProperty(getGraph(), container, value); return container; }

	// type
	public static <T> T getTypeProperty(PropertyContainer container) { return getTypeProperty(container, null); }
	public static <T> T getTypeProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.type.name(), defaultValue); }
	public static boolean hasTypeProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.type.name()); }
	public static <T extends PropertyContainer> T setTypeProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.type.name(), value); return container; }
	public static <T extends PropertyContainer> T removeTypeProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.type.name()); return container; }

	protected <T extends PropertyContainer> T setTypeProperty(T container, Object value) { setTypeProperty(getGraph(), container, value); return container; }

	// scope
	public static <T> T getScopeProperty(PropertyContainer container) { return getScopeProperty(container, null); }
	public static <T> T getScopeProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.scope.name(), defaultValue); }
	public static boolean hasScopeProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.scope.name()); }
	public static <T extends PropertyContainer> T setScopeProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.scope.name(), value); return container; }
	public static <T extends PropertyContainer> T removeScopeProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.scope.name()); return container; }

	protected <T extends PropertyContainer> T setScopeProperty(T container, Object value) { setScopeProperty(getGraph(), container, value); return container; }

	// optional
	public static <T> T getOptionalProperty(PropertyContainer container) { return getOptionalProperty(container, null); }
	public static <T> T getOptionalProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.optional.name(), defaultValue); }
	public static boolean hasOptionalProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.optional.name()); }
	public static <T extends PropertyContainer> T setOptionalProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.optional.name(), value); return container; }
	public static <T extends PropertyContainer> T removeOptionalProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.optional.name()); return container; }

	protected <T extends PropertyContainer> T setOptionalProperty(T container, Object value) { setOptionalProperty(getGraph(), container, value); return container; }

	// id
	public static <T> T getIdProperty(PropertyContainer container) { return getIdProperty(container, null); }
	public static <T> T getIdProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.id.name(), defaultValue); }
	public static boolean hasIdProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.id.name()); }
	public static <T extends PropertyContainer> T setIdProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.id.name(), value); return container; }
	public static <T extends PropertyContainer> T removeIdProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.id.name()); return container; }

	protected <T extends PropertyContainer> T setIdProperty(T container, Object value) { setIdProperty(getGraph(), container, value); return container; }

	// phase
	public static <T> T getPhaseProperty(PropertyContainer container) { return getPhaseProperty(container, null); }
	public static <T> T getPhaseProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.phase.name(), defaultValue); }
	public static boolean hasPhaseProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.phase.name()); }
	public static <T extends PropertyContainer> T setPhaseProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.phase.name(), value); return container; }
	public static <T extends PropertyContainer> T removePhaseProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.phase.name()); return container; }

	protected <T extends PropertyContainer> T setPhaseProperty(T container, Object value) { setPhaseProperty(getGraph(), container, value); return container; }

	// inherited
	public static <T> T getInheritedProperty(PropertyContainer container) { return getInheritedProperty(container, null); }
	public static <T> T getInheritedProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.inherited.name(), defaultValue); }
	public static boolean hasInheritedProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.inherited.name()); }
	public static <T extends PropertyContainer> T setInheritedProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.inherited.name(), value); return container; }
	public static <T extends PropertyContainer> T removeInheritedProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.inherited.name()); return container; }

	protected <T extends PropertyContainer> T setInheritedProperty(T container, Object value) { setInheritedProperty(getGraph(), container, value); return container; }

	// goals
	public static <T> T getGoalsProperty(PropertyContainer container) { return getGoalsProperty(container, null); }
	public static <T> T getGoalsProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.goals.name(), defaultValue); }
	public static boolean hasGoalsProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.goals.name()); }
	public static <T extends PropertyContainer> T setGoalsProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.goals.name(), value); return container; }
	public static <T extends PropertyContainer> T removeGoalsProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.goals.name()); return container; }

	protected <T extends PropertyContainer> T setGoalsProperty(T container, Object value) { setGoalsProperty(getGraph(), container, value); return container; }

	// extension
	public static <T> T getExtensionProperty(PropertyContainer container) { return getExtensionProperty(container, null); }
	public static <T> T getExtensionProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.extension.name(), defaultValue); }
	public static boolean hasExtensionProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.extension.name()); }
	public static <T extends PropertyContainer> T setExtensionProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.extension.name(), value); return container; }
	public static <T extends PropertyContainer> T removeExtensionProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.extension.name()); return container; }

	protected <T extends PropertyContainer> T setExtensionProperty(T container, Object value) { setExtensionProperty(getGraph(), container, value); return container; }

	// value
	public static <T> T getValueProperty(PropertyContainer container) { return getValueProperty(container, null); }
	public static <T> T getValueProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.value.name(), defaultValue); }
	public static boolean hasValueProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.value.name()); }
	public static <T extends PropertyContainer> T setValueProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.value.name(), value); return container; }
	public static <T extends PropertyContainer> T removeValueProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.value.name()); return container; }

	protected <T extends PropertyContainer> T setValueProperty(T container, Object value) { setValueProperty(getGraph(), container, value); return container; }

	// name
	public static <T> T getNameProperty(PropertyContainer container) { return getNameProperty(container, null); }
	public static <T> T getNameProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.name.name(), defaultValue); }
	public static boolean hasNameProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.name.name()); }
	public static <T extends PropertyContainer> T setNameProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.name.name(), value); return container; }
	public static <T extends PropertyContainer> T removeNameProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.name.name()); return container; }

	protected <T extends PropertyContainer> T setNameProperty(T container, Object value) { setNameProperty(getGraph(), container, value); return container; }

	// targetPath
	public static <T> T getTargetPathProperty(PropertyContainer container) { return getTargetPathProperty(container, null); }
	public static <T> T getTargetPathProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.targetPath.name(), defaultValue); }
	public static boolean hasTargetPathProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.targetPath.name()); }
	public static <T extends PropertyContainer> T setTargetPathProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.targetPath.name(), value); return container; }
	public static <T extends PropertyContainer> T removeTargetPathProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.targetPath.name()); return container; }

	protected <T extends PropertyContainer> T setTargetPathProperty(T container, Object value) { setTargetPathProperty(getGraph(), container, value); return container; }

	// filtering
	public static <T> T getFilteringProperty(PropertyContainer container) { return getFilteringProperty(container, null); }
	public static <T> T getFilteringProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.filtering.name(), defaultValue); }
	public static boolean hasFilteringProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.filtering.name()); }
	public static <T extends PropertyContainer> T setFilteringProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.filtering.name(), value); return container; }
	public static <T extends PropertyContainer> T removeFilteringProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.filtering.name()); return container; }

	protected <T extends PropertyContainer> T setFilteringProperty(T container, Object value) { setFilteringProperty(getGraph(), container, value); return container; }

	// key
	public static <T> T getKeyProperty(PropertyContainer container) { return getKeyProperty(container, null); }
	public static <T> T getKeyProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.key.name(), defaultValue); }
	public static boolean hasKeyProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.key.name()); }
	public static <T extends PropertyContainer> T setKeyProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.key.name(), value); return container; }
	public static <T extends PropertyContainer> T removeKeyProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.key.name()); return container; }

	protected <T extends PropertyContainer> T setKeyProperty(T container, Object value) { setKeyProperty(getGraph(), container, value); return container; }

	// packaging
	public static <T> T getPackagingProperty(PropertyContainer container) { return getPackagingProperty(container, null); }
	public static <T> T getPackagingProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.packaging.name(), defaultValue); }
	public static boolean hasPackagingProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.packaging.name()); }
	public static <T extends PropertyContainer> T setPackagingProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.packaging.name(), value); return container; }
	public static <T extends PropertyContainer> T removePackagingProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.packaging.name()); return container; }

	protected <T extends PropertyContainer> T setPackagingProperty(T container, Object value) { setPackagingProperty(getGraph(), container, value); return container; }

	// classifier
	public static <T> T getClassifierProperty(PropertyContainer container) { return getClassifierProperty(container, null); }
	public static <T> T getClassifierProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.classifier.name(), defaultValue); }
	public static boolean hasClassifierProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.classifier.name()); }
	public static <T extends PropertyContainer> T setClassifierProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.classifier.name(), value); return container; }
	public static <T extends PropertyContainer> T removeClassifierProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.classifier.name()); return container; }

	protected <T extends PropertyContainer> T setClassifierProperty(T container, Object value) { setClassifierProperty(getGraph(), container, value); return container; }

}