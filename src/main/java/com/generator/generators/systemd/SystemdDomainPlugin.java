package com.generator.generators.systemd;

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
 * Auto-generated from domain SystemdDomainPlugin
 */
public abstract class SystemdDomainPlugin extends Plugin {

	protected final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(SystemdDomainPlugin.class);

	public enum Entities implements Label {
      service, ServiceFile
   }

   public enum Relations implements RelationshipType {
      SERVICE, FILE
   }

   public enum Properties {
      content, name
   }

	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

	private final Node domainNode;

   SystemdDomainPlugin(App app) {
      super(app, "Systemd");

		domainNode = DomainMotif.newDomainNode(getGraph(), "Systemd");
		entitiesNodeMap.put(Entities.service, DomainMotif.newDomainEntity(getGraph(), Entities.service, domainNode));
		entitiesNodeMap.put(Entities.ServiceFile, DomainMotif.newDomainEntity(getGraph(), Entities.ServiceFile, domainNode));

		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.service), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.ServiceFile), Properties.content.name());

		relate(domainNode, entitiesNodeMap.get(Entities.service), DomainPlugin.Relations.ENTITY);
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.service), Relations.FILE.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.ServiceFile));
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
		if (isservice(neoNode.getNode())) handleservice(pop, neoNode, selectedNodes);
		if (isServiceFile(neoNode.getNode())) handleServiceFile(pop, neoNode, selectedNodes);
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
		if (isservice(neoNode.getNode())) return newserviceEditor(neoNode);
		if (isServiceFile(neoNode.getNode())) return newServiceFileEditor(neoNode);
      return null;
   }

	public Node getDomainNode() { return domainNode; }

	public Node getEntityNode(Label label) { return entitiesNodeMap.get(label); }

	protected void handleservice(JPopupMenu pop, NeoNode serviceNode, Set<NeoNode> selectedNodes) { }
	protected void handleServiceFile(JPopupMenu pop, NeoNode serviceFileNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newserviceEditor(NeoNode serviceNode) { return null; }
	protected JComponent newServiceFileEditor(NeoNode serviceFileNode) { return null; }

	public static boolean isservice(Node node) { return hasLabel(node, Entities.service); }
	public static boolean isServiceFile(Node node) { return hasLabel(node, Entities.ServiceFile); }

	protected Node newservice() { return newservice(getGraph()); } 
	protected Node newservice(Object name) { return newservice(getGraph(), name); } 

	public static Node newservice(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.service)); } 
	public static Node newservice(NeoModel graph, Object name) {  	
		final Node newNode = newservice(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newServiceFile() { return newServiceFile(getGraph()); } 
	protected Node newServiceFile(Object content) { return newServiceFile(getGraph(), content); } 

	public static Node newServiceFile(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.ServiceFile)); } 
	public static Node newServiceFile(NeoModel graph, Object content) {  	
		final Node newNode = newServiceFile(graph); 	
		if (content != null) relate(newNode, DomainMotif.newValueNode(graph, content), RelationshipType.withName(Properties.content.name())); 	
		return newNode; 
	}


	public static void outgoingSERVICE(Node src, RelationConsumer consumer) { outgoing(src, Relations.SERVICE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingSERVICE(Node src) { return other(src, singleOutgoing(src, Relations.SERVICE)); }
	public static void incomingSERVICE(Node src, RelationConsumer consumer) { incoming(src, Relations.SERVICE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingSERVICE(Node src) { return other(src, singleIncoming(src, Relations.SERVICE)); }

	public static void outgoingFILE(Node src, RelationConsumer consumer) { outgoing(src, Relations.FILE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingFILE(Node src) { return other(src, singleOutgoing(src, Relations.FILE)); }
	public static void incomingFILE(Node src, RelationConsumer consumer) { incoming(src, Relations.FILE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingFILE(Node src) { return other(src, singleIncoming(src, Relations.FILE)); }


	public static Relationship relateSERVICE(Node src, Node dst) { return relate(src, dst, Relations.SERVICE); }
	public static Relationship relateFILE(Node src, Node dst) { return relate(src, dst, Relations.FILE); }

	// content
	public static <T> T getContentProperty(PropertyContainer container) { return getContentProperty(container, null); }
	public static <T> T getContentProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.content.name(), defaultValue); }
	public static boolean hasContentProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.content.name()); }
	public static <T extends PropertyContainer> T setContentProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.content.name(), value); return container; }
	public static <T extends PropertyContainer> T removeContentProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.content.name()); return container; }

	protected <T extends PropertyContainer> T setContentProperty(T container, Object value) { setContentProperty(getGraph(), container, value); return container; }

	// name
	public static <T> T getNameProperty(PropertyContainer container) { return getNameProperty(container, null); }
	public static <T> T getNameProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.name.name(), defaultValue); }
	public static boolean hasNameProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.name.name()); }
	public static <T extends PropertyContainer> T setNameProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.name.name(), value); return container; }
	public static <T extends PropertyContainer> T removeNameProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.name.name()); return container; }

	protected <T extends PropertyContainer> T setNameProperty(T container, Object value) { setNameProperty(getGraph(), container, value); return container; }

}