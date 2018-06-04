package com.generator.generators.log;

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
 * Auto-generated from domain LogDomainPlugin
 */
public abstract class LogDomainPlugin extends Plugin {

	protected final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LogDomainPlugin.class);

	public enum Entities implements Label {
      LogFile, LogFormat
   }

   public enum Relations implements RelationshipType {
      LOGFILE, FORMAT
   }

   public enum Properties {
      name, path
   }

	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

	private final Node domainNode;

   LogDomainPlugin(App app) {
      super(app, "Log");

		domainNode = DomainMotif.newDomainNode(getGraph(), "Log");
		entitiesNodeMap.put(Entities.LogFile, DomainMotif.newDomainEntity(getGraph(), Entities.LogFile, domainNode));
		entitiesNodeMap.put(Entities.LogFormat, DomainMotif.newDomainEntity(getGraph(), Entities.LogFormat, domainNode));

		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.LogFile), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.LogFile), Properties.path.name());

		relate(domainNode, entitiesNodeMap.get(Entities.LogFile), DomainPlugin.Relations.ENTITY);
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.LogFile), Relations.FORMAT.name(), DomainDomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.LogFormat));
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
		if (isLogFile(neoNode.getNode())) handleLogFile(pop, neoNode, selectedNodes);
		if (isLogFormat(neoNode.getNode())) handleLogFormat(pop, neoNode, selectedNodes);
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
		if (isLogFile(neoNode.getNode())) return newLogFileEditor(neoNode);
		if (isLogFormat(neoNode.getNode())) return newLogFormatEditor(neoNode);
      return null;
   }

	public Node getDomainNode() { return domainNode; }

	public Node getEntityNode(Label label) { return entitiesNodeMap.get(label); }

	protected void handleLogFile(JPopupMenu pop, NeoNode logFileNode, Set<NeoNode> selectedNodes) { }
	protected void handleLogFormat(JPopupMenu pop, NeoNode logFormatNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newLogFileEditor(NeoNode logFileNode) { return null; }
	protected JComponent newLogFormatEditor(NeoNode logFormatNode) { return null; }

	public static boolean isLogFile(Node node) { return hasLabel(node, Entities.LogFile); }
	public static boolean isLogFormat(Node node) { return hasLabel(node, Entities.LogFormat); }

	protected Node newLogFile() { return newLogFile(getGraph()); } 
	protected Node newLogFile(Object name, Object path) { return newLogFile(getGraph(), name, path); } 

	public static Node newLogFile(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.LogFile)); } 
	public static Node newLogFile(NeoModel graph, Object name, Object path) {  	
		final Node newNode = newLogFile(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name()));
		if (path != null) relate(newNode, DomainMotif.newValueNode(graph, path), RelationshipType.withName(Properties.path.name())); 	
		return newNode; 
	}

	protected Node newLogFormat() { return newLogFormat(getGraph()); }
	public static Node newLogFormat(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.LogFormat)); }


	public static void outgoingLOGFILE(Node src, RelationConsumer consumer) { outgoing(src, Relations.LOGFILE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingLOGFILE(Node src) { return other(src, singleOutgoing(src, Relations.LOGFILE)); }
	public static void incomingLOGFILE(Node src, RelationConsumer consumer) { incoming(src, Relations.LOGFILE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingLOGFILE(Node src) { return other(src, singleIncoming(src, Relations.LOGFILE)); }

	public static void outgoingFORMAT(Node src, RelationConsumer consumer) { outgoing(src, Relations.FORMAT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingFORMAT(Node src) { return other(src, singleOutgoing(src, Relations.FORMAT)); }
	public static void incomingFORMAT(Node src, RelationConsumer consumer) { incoming(src, Relations.FORMAT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingFORMAT(Node src) { return other(src, singleIncoming(src, Relations.FORMAT)); }


	public static Relationship relateLOGFILE(Node src, Node dst) { return relate(src, dst, Relations.LOGFILE); }
	public static Relationship relateFORMAT(Node src, Node dst) { return relate(src, dst, Relations.FORMAT); }

	// name
	public static <T> T getNameProperty(PropertyContainer container) { return getNameProperty(container, null); }
	public static <T> T getNameProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.name.name(), defaultValue); }
	public static boolean hasNameProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.name.name()); }
	public static <T extends PropertyContainer> T setNameProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.name.name(), value); return container; }
	public static <T extends PropertyContainer> T removeNameProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.name.name()); return container; }

	protected <T extends PropertyContainer> T setNameProperty(T container, Object value) { setNameProperty(getGraph(), container, value); return container; }

	// path
	public static <T> T getPathProperty(PropertyContainer container) { return getPathProperty(container, null); }
	public static <T> T getPathProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.path.name(), defaultValue); }
	public static boolean hasPathProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.path.name()); }
	public static <T extends PropertyContainer> T setPathProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.path.name(), value); return container; }
	public static <T extends PropertyContainer> T removePathProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.path.name()); return container; }

	protected <T extends PropertyContainer> T setPathProperty(T container, Object value) { setPathProperty(getGraph(), container, value); return container; }

}