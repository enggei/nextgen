package com.generator.generators.microservice;

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
 * Auto-generated from domain MicroserviceDomainPlugin
 */
public abstract class MicroserviceDomainPlugin extends Plugin {

	protected final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(MicroserviceDomainPlugin.class);

	public enum Entities implements Label {
      Service, Endpoint, EndpointParameter, NeoVerticle, Action, DomainEntity, DomainProperty, Event
   }

   public enum Relations implements RelationshipType {
      SERVICE, VERSION, NAME, ENDPOINT, PARAMETERS, URI, MESSAGE, ACTION, PERSISTENCE, ADDRESS, DOMAINENTITY, PROPERTY, TYPE, DEFAULTVALUE, ISEQHA, ISLEXICAL, SINGLERELATED, PACKAGENAME, ROOT
   }

   public enum Properties {
      version, name, uri, message, action, address, type, defaultValue, isEqha, isLexical, packageName, root
   }

	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

	private final Node domainNode;

   MicroserviceDomainPlugin(App app) {
      super(app, "Microservice");

		domainNode = DomainMotif.newDomainNode(getGraph(), "Microservice");
		entitiesNodeMap.put(Entities.Service, DomainMotif.newDomainEntity(getGraph(), Entities.Service, domainNode));
		entitiesNodeMap.put(Entities.Endpoint, DomainMotif.newDomainEntity(getGraph(), Entities.Endpoint, domainNode));
		entitiesNodeMap.put(Entities.EndpointParameter, DomainMotif.newDomainEntity(getGraph(), Entities.EndpointParameter, domainNode));
		entitiesNodeMap.put(Entities.NeoVerticle, DomainMotif.newDomainEntity(getGraph(), Entities.NeoVerticle, domainNode));
		entitiesNodeMap.put(Entities.Action, DomainMotif.newDomainEntity(getGraph(), Entities.Action, domainNode));
		entitiesNodeMap.put(Entities.DomainEntity, DomainMotif.newDomainEntity(getGraph(), Entities.DomainEntity, domainNode));
		entitiesNodeMap.put(Entities.DomainProperty, DomainMotif.newDomainEntity(getGraph(), Entities.DomainProperty, domainNode));
		entitiesNodeMap.put(Entities.Event, DomainMotif.newDomainEntity(getGraph(), Entities.Event, domainNode));

		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Service), Properties.version.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Service), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Service), Properties.packageName.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Service), Properties.root.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Endpoint), Properties.uri.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Endpoint), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Endpoint), Properties.message.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Endpoint), Properties.action.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.NeoVerticle), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Action), Properties.address.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Action), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.DomainEntity), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.DomainProperty), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.DomainProperty), Properties.type.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.DomainProperty), Properties.defaultValue.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.DomainProperty), Properties.isEqha.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.DomainProperty), Properties.isLexical.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Event), Properties.name.name());
		DomainMotif.newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Event), Properties.address.name());

		relate(domainNode, entitiesNodeMap.get(Entities.Service), DomainPlugin.Relations.ENTITY);
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Service), Relations.ENDPOINT.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Endpoint));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Service), Relations.PERSISTENCE.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.NeoVerticle));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Service), Relations.DOMAINENTITY.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.DomainEntity));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Service), Relations.MESSAGE.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Event));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Endpoint), Relations.PARAMETERS.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.EndpointParameter));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.NeoVerticle), Relations.ACTION.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Action));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.DomainEntity), Relations.PERSISTENCE.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.NeoVerticle));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.DomainEntity), Relations.PROPERTY.name(), DomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.DomainProperty));
		DomainMotif.newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.DomainEntity), Relations.SINGLERELATED.name(), DomainPlugin.RelationCardinality.SINGLE, entitiesNodeMap.get(Entities.DomainEntity));
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
		if (isService(neoNode.getNode())) handleService(pop, neoNode, selectedNodes);
		if (isEndpoint(neoNode.getNode())) handleEndpoint(pop, neoNode, selectedNodes);
		if (isEndpointParameter(neoNode.getNode())) handleEndpointParameter(pop, neoNode, selectedNodes);
		if (isNeoVerticle(neoNode.getNode())) handleNeoVerticle(pop, neoNode, selectedNodes);
		if (isAction(neoNode.getNode())) handleAction(pop, neoNode, selectedNodes);
		if (isDomainEntity(neoNode.getNode())) handleDomainEntity(pop, neoNode, selectedNodes);
		if (isDomainProperty(neoNode.getNode())) handleDomainProperty(pop, neoNode, selectedNodes);
		if (isEvent(neoNode.getNode())) handleEvent(pop, neoNode, selectedNodes);
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
		if (isService(neoNode.getNode())) return newServiceEditor(neoNode);
		if (isEndpoint(neoNode.getNode())) return newEndpointEditor(neoNode);
		if (isEndpointParameter(neoNode.getNode())) return newEndpointParameterEditor(neoNode);
		if (isNeoVerticle(neoNode.getNode())) return newNeoVerticleEditor(neoNode);
		if (isAction(neoNode.getNode())) return newActionEditor(neoNode);
		if (isDomainEntity(neoNode.getNode())) return newDomainEntityEditor(neoNode);
		if (isDomainProperty(neoNode.getNode())) return newDomainPropertyEditor(neoNode);
		if (isEvent(neoNode.getNode())) return newEventEditor(neoNode);
      return null;
   }

	public Node getDomainNode() { return domainNode; }

	public Node getEntityNode(Label label) { return entitiesNodeMap.get(label); }

	protected void handleService(JPopupMenu pop, NeoNode serviceNode, Set<NeoNode> selectedNodes) { }
	protected void handleEndpoint(JPopupMenu pop, NeoNode endpointNode, Set<NeoNode> selectedNodes) { }
	protected void handleEndpointParameter(JPopupMenu pop, NeoNode endpointParameterNode, Set<NeoNode> selectedNodes) { }
	protected void handleNeoVerticle(JPopupMenu pop, NeoNode neoVerticleNode, Set<NeoNode> selectedNodes) { }
	protected void handleAction(JPopupMenu pop, NeoNode actionNode, Set<NeoNode> selectedNodes) { }
	protected void handleDomainEntity(JPopupMenu pop, NeoNode domainEntityNode, Set<NeoNode> selectedNodes) { }
	protected void handleDomainProperty(JPopupMenu pop, NeoNode domainPropertyNode, Set<NeoNode> selectedNodes) { }
	protected void handleEvent(JPopupMenu pop, NeoNode eventNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newServiceEditor(NeoNode serviceNode) { return null; }
	protected JComponent newEndpointEditor(NeoNode endpointNode) { return null; }
	protected JComponent newEndpointParameterEditor(NeoNode endpointParameterNode) { return null; }
	protected JComponent newNeoVerticleEditor(NeoNode neoVerticleNode) { return null; }
	protected JComponent newActionEditor(NeoNode actionNode) { return null; }
	protected JComponent newDomainEntityEditor(NeoNode domainEntityNode) { return null; }
	protected JComponent newDomainPropertyEditor(NeoNode domainPropertyNode) { return null; }
	protected JComponent newEventEditor(NeoNode eventNode) { return null; }

	public static boolean isService(Node node) { return hasLabel(node, Entities.Service); }
	public static boolean isEndpoint(Node node) { return hasLabel(node, Entities.Endpoint); }
	public static boolean isEndpointParameter(Node node) { return hasLabel(node, Entities.EndpointParameter); }
	public static boolean isNeoVerticle(Node node) { return hasLabel(node, Entities.NeoVerticle); }
	public static boolean isAction(Node node) { return hasLabel(node, Entities.Action); }
	public static boolean isDomainEntity(Node node) { return hasLabel(node, Entities.DomainEntity); }
	public static boolean isDomainProperty(Node node) { return hasLabel(node, Entities.DomainProperty); }
	public static boolean isEvent(Node node) { return hasLabel(node, Entities.Event); }

	protected Node newService() { return newService(getGraph()); } 
	protected Node newService(Object version, Object name, Object packageName, Object root) { return newService(getGraph(), version, name, packageName, root); } 

	public static Node newService(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Service)); } 
	public static Node newService(NeoModel graph, Object version, Object name, Object packageName, Object root) {  	
		final Node newNode = newService(graph); 	
		if (version != null) relate(newNode, DomainMotif.newValueNode(graph, version), RelationshipType.withName(Properties.version.name()));
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name()));
		if (packageName != null) relate(newNode, DomainMotif.newValueNode(graph, packageName), RelationshipType.withName(Properties.packageName.name()));
		if (root != null) relate(newNode, DomainMotif.newValueNode(graph, root), RelationshipType.withName(Properties.root.name())); 	
		return newNode; 
	}
	/* todo
	public Action newServiceAction() {
		return new App.TransactionAction("New Service", app) {
			@Override
	   	public void actionPerformed(java.awt.event.ActionEvent e, Transaction tx) throws Exception {

			final Map<String,String> properties = new java.util.HashMap<>();
			   final String version = com.generator.util.SwingUtil.showInputDialog("version", app);
				if (version != null && version.length() > 0)
					properties.put("version", version);

			   final String name = com.generator.util.SwingUtil.showInputDialog("name", app);
				if (name != null && name.length() > 0)
					properties.put("name", name);

			   final String packageName = com.generator.util.SwingUtil.showInputDialog("packageName", app);
				if (packageName != null && packageName.length() > 0)
					properties.put("packageName", packageName);

			   final String root = com.generator.util.SwingUtil.showInputDialog("root", app);
				if (root != null && root.length() > 0)
					properties.put("root", root);


			if (properties.isEmpty()) return;

		   //fireNodesLoaded(new());
	   	}
		};
	}
	*/

	protected Node newEndpoint() { return newEndpoint(getGraph()); } 
	protected Node newEndpoint(Object uri, Object name, Object message, Object action) { return newEndpoint(getGraph(), uri, name, message, action); } 

	public static Node newEndpoint(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Endpoint)); } 
	public static Node newEndpoint(NeoModel graph, Object uri, Object name, Object message, Object action) {  	
		final Node newNode = newEndpoint(graph); 	
		if (uri != null) relate(newNode, DomainMotif.newValueNode(graph, uri), RelationshipType.withName(Properties.uri.name()));
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name()));
		if (message != null) relate(newNode, DomainMotif.newValueNode(graph, message), RelationshipType.withName(Properties.message.name()));
		if (action != null) relate(newNode, DomainMotif.newValueNode(graph, action), RelationshipType.withName(Properties.action.name())); 	
		return newNode; 
	}
	/* todo
	public Action newEndpointAction() {
		return new App.TransactionAction("New Endpoint", app) {
			@Override
	   	public void actionPerformed(java.awt.event.ActionEvent e, Transaction tx) throws Exception {

			final Map<String,String> properties = new java.util.HashMap<>();
			   final String uri = com.generator.util.SwingUtil.showInputDialog("uri", app);
				if (uri != null && uri.length() > 0)
					properties.put("uri", uri);

			   final String name = com.generator.util.SwingUtil.showInputDialog("name", app);
				if (name != null && name.length() > 0)
					properties.put("name", name);

			   final String message = com.generator.util.SwingUtil.showInputDialog("message", app);
				if (message != null && message.length() > 0)
					properties.put("message", message);

			   final String action = com.generator.util.SwingUtil.showInputDialog("action", app);
				if (action != null && action.length() > 0)
					properties.put("action", action);


			if (properties.isEmpty()) return;

		   //fireNodesLoaded(new());
	   	}
		};
	}
	*/

	protected Node newEndpointParameter() { return newEndpointParameter(getGraph()); }
	public static Node newEndpointParameter(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.EndpointParameter)); }
	/* todo
	public Action newEndpointParameterAction() {
		return new App.TransactionAction("New EndpointParameter", app) {
			@Override
	   	public void actionPerformed(java.awt.event.ActionEvent e, Transaction tx) throws Exception {

			final Map<String,String> properties = new java.util.HashMap<>();

			if (properties.isEmpty()) return;

		   //fireNodesLoaded(new());
	   	}
		};
	}
	*/

	protected Node newNeoVerticle() { return newNeoVerticle(getGraph()); } 
	protected Node newNeoVerticle(Object name) { return newNeoVerticle(getGraph(), name); } 

	public static Node newNeoVerticle(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.NeoVerticle)); } 
	public static Node newNeoVerticle(NeoModel graph, Object name) {  	
		final Node newNode = newNeoVerticle(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}
	/* todo
	public Action newNeoVerticleAction() {
		return new App.TransactionAction("New NeoVerticle", app) {
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

	protected Node newAction() { return newAction(getGraph()); } 
	protected Node newAction(Object address, Object name) { return newAction(getGraph(), address, name); } 

	public static Node newAction(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Action)); } 
	public static Node newAction(NeoModel graph, Object address, Object name) {  	
		final Node newNode = newAction(graph); 	
		if (address != null) relate(newNode, DomainMotif.newValueNode(graph, address), RelationshipType.withName(Properties.address.name()));
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}
	/* todo
	public Action newActionAction() {
		return new App.TransactionAction("New Action", app) {
			@Override
	   	public void actionPerformed(java.awt.event.ActionEvent e, Transaction tx) throws Exception {

			final Map<String,String> properties = new java.util.HashMap<>();
			   final String address = com.generator.util.SwingUtil.showInputDialog("address", app);
				if (address != null && address.length() > 0)
					properties.put("address", address);

			   final String name = com.generator.util.SwingUtil.showInputDialog("name", app);
				if (name != null && name.length() > 0)
					properties.put("name", name);


			if (properties.isEmpty()) return;

		   //fireNodesLoaded(new());
	   	}
		};
	}
	*/

	protected Node newDomainEntity() { return newDomainEntity(getGraph()); } 
	protected Node newDomainEntity(Object name) { return newDomainEntity(getGraph(), name); } 

	public static Node newDomainEntity(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.DomainEntity)); } 
	public static Node newDomainEntity(NeoModel graph, Object name) {  	
		final Node newNode = newDomainEntity(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}
	/* todo
	public Action newDomainEntityAction() {
		return new App.TransactionAction("New DomainEntity", app) {
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

	protected Node newDomainProperty() { return newDomainProperty(getGraph()); } 
	protected Node newDomainProperty(Object name, Object type, Object defaultValue, Object isEqha, Object isLexical) { return newDomainProperty(getGraph(), name, type, defaultValue, isEqha, isLexical); } 

	public static Node newDomainProperty(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.DomainProperty)); } 
	public static Node newDomainProperty(NeoModel graph, Object name, Object type, Object defaultValue, Object isEqha, Object isLexical) {  	
		final Node newNode = newDomainProperty(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name()));
		if (type != null) relate(newNode, DomainMotif.newValueNode(graph, type), RelationshipType.withName(Properties.type.name()));
		if (defaultValue != null) relate(newNode, DomainMotif.newValueNode(graph, defaultValue), RelationshipType.withName(Properties.defaultValue.name()));
		if (isEqha != null) relate(newNode, DomainMotif.newValueNode(graph, isEqha), RelationshipType.withName(Properties.isEqha.name()));
		if (isLexical != null) relate(newNode, DomainMotif.newValueNode(graph, isLexical), RelationshipType.withName(Properties.isLexical.name())); 	
		return newNode; 
	}
	/* todo
	public Action newDomainPropertyAction() {
		return new App.TransactionAction("New DomainProperty", app) {
			@Override
	   	public void actionPerformed(java.awt.event.ActionEvent e, Transaction tx) throws Exception {

			final Map<String,String> properties = new java.util.HashMap<>();
			   final String name = com.generator.util.SwingUtil.showInputDialog("name", app);
				if (name != null && name.length() > 0)
					properties.put("name", name);

			   final String type = com.generator.util.SwingUtil.showInputDialog("type", app);
				if (type != null && type.length() > 0)
					properties.put("type", type);

			   final String defaultValue = com.generator.util.SwingUtil.showInputDialog("defaultValue", app);
				if (defaultValue != null && defaultValue.length() > 0)
					properties.put("defaultValue", defaultValue);

			   final String isEqha = com.generator.util.SwingUtil.showInputDialog("isEqha", app);
				if (isEqha != null && isEqha.length() > 0)
					properties.put("isEqha", isEqha);

			   final String isLexical = com.generator.util.SwingUtil.showInputDialog("isLexical", app);
				if (isLexical != null && isLexical.length() > 0)
					properties.put("isLexical", isLexical);


			if (properties.isEmpty()) return;

		   //fireNodesLoaded(new());
	   	}
		};
	}
	*/

	protected Node newEvent() { return newEvent(getGraph()); } 
	protected Node newEvent(Object name, Object address) { return newEvent(getGraph(), name, address); } 

	public static Node newEvent(NeoModel graph) { return DomainMotif.newInstanceNode(graph, entitiesNodeMap.get(Entities.Event)); } 
	public static Node newEvent(NeoModel graph, Object name, Object address) {  	
		final Node newNode = newEvent(graph); 	
		if (name != null) relate(newNode, DomainMotif.newValueNode(graph, name), RelationshipType.withName(Properties.name.name()));
		if (address != null) relate(newNode, DomainMotif.newValueNode(graph, address), RelationshipType.withName(Properties.address.name())); 	
		return newNode; 
	}
	/* todo
	public Action newEventAction() {
		return new App.TransactionAction("New Event", app) {
			@Override
	   	public void actionPerformed(java.awt.event.ActionEvent e, Transaction tx) throws Exception {

			final Map<String,String> properties = new java.util.HashMap<>();
			   final String name = com.generator.util.SwingUtil.showInputDialog("name", app);
				if (name != null && name.length() > 0)
					properties.put("name", name);

			   final String address = com.generator.util.SwingUtil.showInputDialog("address", app);
				if (address != null && address.length() > 0)
					properties.put("address", address);


			if (properties.isEmpty()) return;

		   //fireNodesLoaded(new());
	   	}
		};
	}
	*/


	public static void outgoingSERVICE(Node src, RelationConsumer consumer) { outgoing(src, Relations.SERVICE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingSERVICE(Node src) { return other(src, singleOutgoing(src, Relations.SERVICE)); }
	public static void incomingSERVICE(Node src, RelationConsumer consumer) { incoming(src, Relations.SERVICE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingSERVICE(Node src) { return other(src, singleIncoming(src, Relations.SERVICE)); }

	public static void outgoingVERSION(Node src, RelationConsumer consumer) { outgoing(src, Relations.VERSION).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingVERSION(Node src) { return other(src, singleOutgoing(src, Relations.VERSION)); }
	public static void incomingVERSION(Node src, RelationConsumer consumer) { incoming(src, Relations.VERSION).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingVERSION(Node src) { return other(src, singleIncoming(src, Relations.VERSION)); }

	public static void outgoingNAME(Node src, RelationConsumer consumer) { outgoing(src, Relations.NAME).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingNAME(Node src) { return other(src, singleOutgoing(src, Relations.NAME)); }
	public static void incomingNAME(Node src, RelationConsumer consumer) { incoming(src, Relations.NAME).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingNAME(Node src) { return other(src, singleIncoming(src, Relations.NAME)); }

	public static void outgoingENDPOINT(Node src, RelationConsumer consumer) { outgoing(src, Relations.ENDPOINT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingENDPOINT(Node src) { return other(src, singleOutgoing(src, Relations.ENDPOINT)); }
	public static void incomingENDPOINT(Node src, RelationConsumer consumer) { incoming(src, Relations.ENDPOINT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingENDPOINT(Node src) { return other(src, singleIncoming(src, Relations.ENDPOINT)); }

	public static void outgoingPARAMETERS(Node src, RelationConsumer consumer) { outgoing(src, Relations.PARAMETERS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPARAMETERS(Node src) { return other(src, singleOutgoing(src, Relations.PARAMETERS)); }
	public static void incomingPARAMETERS(Node src, RelationConsumer consumer) { incoming(src, Relations.PARAMETERS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPARAMETERS(Node src) { return other(src, singleIncoming(src, Relations.PARAMETERS)); }

	public static void outgoingURI(Node src, RelationConsumer consumer) { outgoing(src, Relations.URI).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingURI(Node src) { return other(src, singleOutgoing(src, Relations.URI)); }
	public static void incomingURI(Node src, RelationConsumer consumer) { incoming(src, Relations.URI).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingURI(Node src) { return other(src, singleIncoming(src, Relations.URI)); }

	public static void outgoingMESSAGE(Node src, RelationConsumer consumer) { outgoing(src, Relations.MESSAGE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingMESSAGE(Node src) { return other(src, singleOutgoing(src, Relations.MESSAGE)); }
	public static void incomingMESSAGE(Node src, RelationConsumer consumer) { incoming(src, Relations.MESSAGE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingMESSAGE(Node src) { return other(src, singleIncoming(src, Relations.MESSAGE)); }

	public static void outgoingACTION(Node src, RelationConsumer consumer) { outgoing(src, Relations.ACTION).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingACTION(Node src) { return other(src, singleOutgoing(src, Relations.ACTION)); }
	public static void incomingACTION(Node src, RelationConsumer consumer) { incoming(src, Relations.ACTION).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingACTION(Node src) { return other(src, singleIncoming(src, Relations.ACTION)); }

	public static void outgoingPERSISTENCE(Node src, RelationConsumer consumer) { outgoing(src, Relations.PERSISTENCE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPERSISTENCE(Node src) { return other(src, singleOutgoing(src, Relations.PERSISTENCE)); }
	public static void incomingPERSISTENCE(Node src, RelationConsumer consumer) { incoming(src, Relations.PERSISTENCE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPERSISTENCE(Node src) { return other(src, singleIncoming(src, Relations.PERSISTENCE)); }

	public static void outgoingADDRESS(Node src, RelationConsumer consumer) { outgoing(src, Relations.ADDRESS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingADDRESS(Node src) { return other(src, singleOutgoing(src, Relations.ADDRESS)); }
	public static void incomingADDRESS(Node src, RelationConsumer consumer) { incoming(src, Relations.ADDRESS).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingADDRESS(Node src) { return other(src, singleIncoming(src, Relations.ADDRESS)); }

	public static void outgoingDOMAINENTITY(Node src, RelationConsumer consumer) { outgoing(src, Relations.DOMAINENTITY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingDOMAINENTITY(Node src) { return other(src, singleOutgoing(src, Relations.DOMAINENTITY)); }
	public static void incomingDOMAINENTITY(Node src, RelationConsumer consumer) { incoming(src, Relations.DOMAINENTITY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingDOMAINENTITY(Node src) { return other(src, singleIncoming(src, Relations.DOMAINENTITY)); }

	public static void outgoingPROPERTY(Node src, RelationConsumer consumer) { outgoing(src, Relations.PROPERTY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPROPERTY(Node src) { return other(src, singleOutgoing(src, Relations.PROPERTY)); }
	public static void incomingPROPERTY(Node src, RelationConsumer consumer) { incoming(src, Relations.PROPERTY).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPROPERTY(Node src) { return other(src, singleIncoming(src, Relations.PROPERTY)); }

	public static void outgoingTYPE(Node src, RelationConsumer consumer) { outgoing(src, Relations.TYPE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingTYPE(Node src) { return other(src, singleOutgoing(src, Relations.TYPE)); }
	public static void incomingTYPE(Node src, RelationConsumer consumer) { incoming(src, Relations.TYPE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingTYPE(Node src) { return other(src, singleIncoming(src, Relations.TYPE)); }

	public static void outgoingDEFAULTVALUE(Node src, RelationConsumer consumer) { outgoing(src, Relations.DEFAULTVALUE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingDEFAULTVALUE(Node src) { return other(src, singleOutgoing(src, Relations.DEFAULTVALUE)); }
	public static void incomingDEFAULTVALUE(Node src, RelationConsumer consumer) { incoming(src, Relations.DEFAULTVALUE).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingDEFAULTVALUE(Node src) { return other(src, singleIncoming(src, Relations.DEFAULTVALUE)); }

	public static void outgoingISEQHA(Node src, RelationConsumer consumer) { outgoing(src, Relations.ISEQHA).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingISEQHA(Node src) { return other(src, singleOutgoing(src, Relations.ISEQHA)); }
	public static void incomingISEQHA(Node src, RelationConsumer consumer) { incoming(src, Relations.ISEQHA).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingISEQHA(Node src) { return other(src, singleIncoming(src, Relations.ISEQHA)); }

	public static void outgoingISLEXICAL(Node src, RelationConsumer consumer) { outgoing(src, Relations.ISLEXICAL).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingISLEXICAL(Node src) { return other(src, singleOutgoing(src, Relations.ISLEXICAL)); }
	public static void incomingISLEXICAL(Node src, RelationConsumer consumer) { incoming(src, Relations.ISLEXICAL).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingISLEXICAL(Node src) { return other(src, singleIncoming(src, Relations.ISLEXICAL)); }

	public static void outgoingSINGLERELATED(Node src, RelationConsumer consumer) { outgoing(src, Relations.SINGLERELATED).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingSINGLERELATED(Node src) { return other(src, singleOutgoing(src, Relations.SINGLERELATED)); }
	public static void incomingSINGLERELATED(Node src, RelationConsumer consumer) { incoming(src, Relations.SINGLERELATED).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingSINGLERELATED(Node src) { return other(src, singleIncoming(src, Relations.SINGLERELATED)); }

	public static void outgoingPACKAGENAME(Node src, RelationConsumer consumer) { outgoing(src, Relations.PACKAGENAME).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingPACKAGENAME(Node src) { return other(src, singleOutgoing(src, Relations.PACKAGENAME)); }
	public static void incomingPACKAGENAME(Node src, RelationConsumer consumer) { incoming(src, Relations.PACKAGENAME).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingPACKAGENAME(Node src) { return other(src, singleIncoming(src, Relations.PACKAGENAME)); }

	public static void outgoingROOT(Node src, RelationConsumer consumer) { outgoing(src, Relations.ROOT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingROOT(Node src) { return other(src, singleOutgoing(src, Relations.ROOT)); }
	public static void incomingROOT(Node src, RelationConsumer consumer) { incoming(src, Relations.ROOT).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingROOT(Node src) { return other(src, singleIncoming(src, Relations.ROOT)); }


	public static Relationship relateSERVICE(Node src, Node dst) { return relate(src, dst, Relations.SERVICE); }
	public static Relationship relateVERSION(Node src, Node dst) { return relate(src, dst, Relations.VERSION); }
	public static Relationship relateNAME(Node src, Node dst) { return relate(src, dst, Relations.NAME); }
	public static Relationship relateENDPOINT(Node src, Node dst) { return relate(src, dst, Relations.ENDPOINT); }
	public static Relationship relatePARAMETERS(Node src, Node dst) { return relate(src, dst, Relations.PARAMETERS); }
	public static Relationship relateURI(Node src, Node dst) { return relate(src, dst, Relations.URI); }
	public static Relationship relateMESSAGE(Node src, Node dst) { return relate(src, dst, Relations.MESSAGE); }
	public static Relationship relateACTION(Node src, Node dst) { return relate(src, dst, Relations.ACTION); }
	public static Relationship relatePERSISTENCE(Node src, Node dst) { return relate(src, dst, Relations.PERSISTENCE); }
	public static Relationship relateADDRESS(Node src, Node dst) { return relate(src, dst, Relations.ADDRESS); }
	public static Relationship relateDOMAINENTITY(Node src, Node dst) { return relate(src, dst, Relations.DOMAINENTITY); }
	public static Relationship relatePROPERTY(Node src, Node dst) { return relate(src, dst, Relations.PROPERTY); }
	public static Relationship relateTYPE(Node src, Node dst) { return relate(src, dst, Relations.TYPE); }
	public static Relationship relateDEFAULTVALUE(Node src, Node dst) { return relate(src, dst, Relations.DEFAULTVALUE); }
	public static Relationship relateISEQHA(Node src, Node dst) { return relate(src, dst, Relations.ISEQHA); }
	public static Relationship relateISLEXICAL(Node src, Node dst) { return relate(src, dst, Relations.ISLEXICAL); }
	public static Relationship relateSINGLERELATED(Node src, Node dst) { return relate(src, dst, Relations.SINGLERELATED); }
	public static Relationship relatePACKAGENAME(Node src, Node dst) { return relate(src, dst, Relations.PACKAGENAME); }
	public static Relationship relateROOT(Node src, Node dst) { return relate(src, dst, Relations.ROOT); }

	// version
	public static <T> T getVersionProperty(PropertyContainer container) { return getVersionProperty(container, null); }
	public static <T> T getVersionProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.version.name(), defaultValue); }
	public static boolean hasVersionProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.version.name()); }
	public static <T extends PropertyContainer> T setVersionProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.version.name(), value); return container; }
	public static <T extends PropertyContainer> T removeVersionProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.version.name()); return container; }

	protected <T extends PropertyContainer> T setVersionProperty(T container, Object value) { setVersionProperty(getGraph(), container, value); return container; }

	// name
	public static <T> T getNameProperty(PropertyContainer container) { return getNameProperty(container, null); }
	public static <T> T getNameProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.name.name(), defaultValue); }
	public static boolean hasNameProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.name.name()); }
	public static <T extends PropertyContainer> T setNameProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.name.name(), value); return container; }
	public static <T extends PropertyContainer> T removeNameProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.name.name()); return container; }

	protected <T extends PropertyContainer> T setNameProperty(T container, Object value) { setNameProperty(getGraph(), container, value); return container; }

	// uri
	public static <T> T getUriProperty(PropertyContainer container) { return getUriProperty(container, null); }
	public static <T> T getUriProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.uri.name(), defaultValue); }
	public static boolean hasUriProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.uri.name()); }
	public static <T extends PropertyContainer> T setUriProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.uri.name(), value); return container; }
	public static <T extends PropertyContainer> T removeUriProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.uri.name()); return container; }

	protected <T extends PropertyContainer> T setUriProperty(T container, Object value) { setUriProperty(getGraph(), container, value); return container; }

	// message
	public static <T> T getMessageProperty(PropertyContainer container) { return getMessageProperty(container, null); }
	public static <T> T getMessageProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.message.name(), defaultValue); }
	public static boolean hasMessageProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.message.name()); }
	public static <T extends PropertyContainer> T setMessageProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.message.name(), value); return container; }
	public static <T extends PropertyContainer> T removeMessageProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.message.name()); return container; }

	protected <T extends PropertyContainer> T setMessageProperty(T container, Object value) { setMessageProperty(getGraph(), container, value); return container; }

	// action
	public static <T> T getActionProperty(PropertyContainer container) { return getActionProperty(container, null); }
	public static <T> T getActionProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.action.name(), defaultValue); }
	public static boolean hasActionProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.action.name()); }
	public static <T extends PropertyContainer> T setActionProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.action.name(), value); return container; }
	public static <T extends PropertyContainer> T removeActionProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.action.name()); return container; }

	protected <T extends PropertyContainer> T setActionProperty(T container, Object value) { setActionProperty(getGraph(), container, value); return container; }

	// address
	public static <T> T getAddressProperty(PropertyContainer container) { return getAddressProperty(container, null); }
	public static <T> T getAddressProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.address.name(), defaultValue); }
	public static boolean hasAddressProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.address.name()); }
	public static <T extends PropertyContainer> T setAddressProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.address.name(), value); return container; }
	public static <T extends PropertyContainer> T removeAddressProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.address.name()); return container; }

	protected <T extends PropertyContainer> T setAddressProperty(T container, Object value) { setAddressProperty(getGraph(), container, value); return container; }

	// type
	public static <T> T getTypeProperty(PropertyContainer container) { return getTypeProperty(container, null); }
	public static <T> T getTypeProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.type.name(), defaultValue); }
	public static boolean hasTypeProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.type.name()); }
	public static <T extends PropertyContainer> T setTypeProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.type.name(), value); return container; }
	public static <T extends PropertyContainer> T removeTypeProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.type.name()); return container; }

	protected <T extends PropertyContainer> T setTypeProperty(T container, Object value) { setTypeProperty(getGraph(), container, value); return container; }

	// defaultValue
	public static <T> T getDefaultValueProperty(PropertyContainer container) { return getDefaultValueProperty(container, null); }
	public static <T> T getDefaultValueProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.defaultValue.name(), defaultValue); }
	public static boolean hasDefaultValueProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.defaultValue.name()); }
	public static <T extends PropertyContainer> T setDefaultValueProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.defaultValue.name(), value); return container; }
	public static <T extends PropertyContainer> T removeDefaultValueProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.defaultValue.name()); return container; }

	protected <T extends PropertyContainer> T setDefaultValueProperty(T container, Object value) { setDefaultValueProperty(getGraph(), container, value); return container; }

	// isEqha
	public static <T> T getIsEqhaProperty(PropertyContainer container) { return getIsEqhaProperty(container, null); }
	public static <T> T getIsEqhaProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.isEqha.name(), defaultValue); }
	public static boolean hasIsEqhaProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.isEqha.name()); }
	public static <T extends PropertyContainer> T setIsEqhaProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.isEqha.name(), value); return container; }
	public static <T extends PropertyContainer> T removeIsEqhaProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.isEqha.name()); return container; }

	protected <T extends PropertyContainer> T setIsEqhaProperty(T container, Object value) { setIsEqhaProperty(getGraph(), container, value); return container; }

	// isLexical
	public static <T> T getIsLexicalProperty(PropertyContainer container) { return getIsLexicalProperty(container, null); }
	public static <T> T getIsLexicalProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.isLexical.name(), defaultValue); }
	public static boolean hasIsLexicalProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.isLexical.name()); }
	public static <T extends PropertyContainer> T setIsLexicalProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.isLexical.name(), value); return container; }
	public static <T extends PropertyContainer> T removeIsLexicalProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.isLexical.name()); return container; }

	protected <T extends PropertyContainer> T setIsLexicalProperty(T container, Object value) { setIsLexicalProperty(getGraph(), container, value); return container; }

	// packageName
	public static <T> T getPackageNameProperty(PropertyContainer container) { return getPackageNameProperty(container, null); }
	public static <T> T getPackageNameProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.packageName.name(), defaultValue); }
	public static boolean hasPackageNameProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.packageName.name()); }
	public static <T extends PropertyContainer> T setPackageNameProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.packageName.name(), value); return container; }
	public static <T extends PropertyContainer> T removePackageNameProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.packageName.name()); return container; }

	protected <T extends PropertyContainer> T setPackageNameProperty(T container, Object value) { setPackageNameProperty(getGraph(), container, value); return container; }

	// root
	public static <T> T getRootProperty(PropertyContainer container) { return getRootProperty(container, null); }
	public static <T> T getRootProperty(PropertyContainer container, T defaultValue) { return DomainMotif.getEntityProperty(container, Properties.root.name(), defaultValue); }
	public static boolean hasRootProperty(PropertyContainer container) { return DomainMotif.hasEntityProperty(container, Properties.root.name()); }
	public static <T extends PropertyContainer> T setRootProperty(NeoModel graph, T container, Object value) { DomainMotif.setEntityProperty(graph, container, Properties.root.name(), value); return container; }
	public static <T extends PropertyContainer> T removeRootProperty(T container) { DomainMotif.removeEntityProperty(container, Properties.root.name()); return container; }

	protected <T extends PropertyContainer> T setRootProperty(T container, Object value) { setRootProperty(getGraph(), container, value); return container; }

}