package com.generator.generators.chromeBookmarks;

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

import static com.generator.app.DomainMotif.*;
import static com.generator.util.NeoUtil.*;

/**
 * Auto-generated from domain ChromeBookmarksDomainPlugin
 */
public abstract class ChromeBookmarksDomainPlugin extends Plugin {

	public enum Entities implements Label {
      Catalog, Group, Bookmark
   }

   public enum Relations implements RelationshipType {
      CATALOG, GROUP, BOOKMARK
   }

   public enum Properties {
      name, icon, date, href
   }

	private static final Map<Label,Node> entitiesNodeMap = new LinkedHashMap<>();

	private final Node domainNode;

   ChromeBookmarksDomainPlugin(App app) {
      super(app, "ChromeBookmarks");

		domainNode = DomainMotif.newDomainNode(getGraph(), "ChromeBookmarks");
		entitiesNodeMap.put(Entities.Catalog, newDomainEntity(getGraph(), Entities.Catalog, domainNode));
		entitiesNodeMap.put(Entities.Group, newDomainEntity(getGraph(), Entities.Group, domainNode));
		entitiesNodeMap.put(Entities.Bookmark, newDomainEntity(getGraph(), Entities.Bookmark, domainNode));

		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Catalog), Properties.name.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Group), Properties.name.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Bookmark), Properties.icon.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Bookmark), Properties.date.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Bookmark), Properties.href.name());
		newDomainEntityProperty(getGraph(), domainNode, entitiesNodeMap.get(Entities.Bookmark), Properties.name.name());

		relate(domainNode, entitiesNodeMap.get(Entities.Catalog), DomainPlugin.Relations.ENTITY);
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Catalog), Relations.GROUP.name(), DomainDomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Group));
		newDomainEntityRelation(getGraph(), entitiesNodeMap.get(Entities.Group), Relations.BOOKMARK.name(), DomainDomainPlugin.RelationCardinality.LIST, entitiesNodeMap.get(Entities.Bookmark));
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {
		if (isCatalog(neoNode.getNode())) handleCatalog(pop, neoNode, selectedNodes);
		if (isGroup(neoNode.getNode())) handleGroup(pop, neoNode, selectedNodes);
		if (isBookmark(neoNode.getNode())) handleBookmark(pop, neoNode, selectedNodes);
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
		if (isCatalog(neoNode.getNode())) return newCatalogEditor(neoNode);
		if (isGroup(neoNode.getNode())) return newGroupEditor(neoNode);
		if (isBookmark(neoNode.getNode())) return newBookmarkEditor(neoNode);
      return null;
   }

	protected Node getDomainNode() { return domainNode; }

	protected void handleCatalog(JPopupMenu pop, NeoNode catalogNode, Set<NeoNode> selectedNodes) { }
	protected void handleGroup(JPopupMenu pop, NeoNode groupNode, Set<NeoNode> selectedNodes) { }
	protected void handleBookmark(JPopupMenu pop, NeoNode bookmarkNode, Set<NeoNode> selectedNodes) { }	

	protected JComponent newCatalogEditor(NeoNode catalogNode) { return null; }
	protected JComponent newGroupEditor(NeoNode groupNode) { return null; }
	protected JComponent newBookmarkEditor(NeoNode bookmarkNode) { return null; }

	public static boolean isCatalog(Node node) { return hasLabel(node, Entities.Catalog); }
	public static boolean isGroup(Node node) { return hasLabel(node, Entities.Group); }
	public static boolean isBookmark(Node node) { return hasLabel(node, Entities.Bookmark); }

	protected Node newCatalog() { return newCatalog(getGraph()); } 
	protected Node newCatalog(Object name) { return newCatalog(getGraph(), name); } 

	public static Node newCatalog(NeoModel graph) { return newInstanceNode(graph, Entities.Catalog.name(), entitiesNodeMap.get(Entities.Catalog)); } 
	public static Node newCatalog(NeoModel graph, Object name) {  	
		final Node newNode = newCatalog(graph); 	
		if (name != null) relate(newNode, newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newGroup() { return newGroup(getGraph()); } 
	protected Node newGroup(Object name) { return newGroup(getGraph(), name); } 

	public static Node newGroup(NeoModel graph) { return newInstanceNode(graph, Entities.Group.name(), entitiesNodeMap.get(Entities.Group)); } 
	public static Node newGroup(NeoModel graph, Object name) {  	
		final Node newNode = newGroup(graph); 	
		if (name != null) relate(newNode, newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}

	protected Node newBookmark() { return newBookmark(getGraph()); } 
	protected Node newBookmark(Object icon, Object date, Object href, Object name) { return newBookmark(getGraph(), icon, date, href, name); } 

	public static Node newBookmark(NeoModel graph) { return newInstanceNode(graph, Entities.Bookmark.name(), entitiesNodeMap.get(Entities.Bookmark)); } 
	public static Node newBookmark(NeoModel graph, Object icon, Object date, Object href, Object name) {  	
		final Node newNode = newBookmark(graph); 	
		if (icon != null) relate(newNode, newValueNode(graph, icon), RelationshipType.withName(Properties.icon.name()));
		if (date != null) relate(newNode, newValueNode(graph, date), RelationshipType.withName(Properties.date.name()));
		if (href != null) relate(newNode, newValueNode(graph, href), RelationshipType.withName(Properties.href.name()));
		if (name != null) relate(newNode, newValueNode(graph, name), RelationshipType.withName(Properties.name.name())); 	
		return newNode; 
	}


	public static void outgoingCATALOG(Node src, RelationConsumer consumer) { outgoing(src, Relations.CATALOG).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingCATALOG(Node src) { return other(src, singleOutgoing(src, Relations.CATALOG)); }
	public static void incomingCATALOG(Node src, RelationConsumer consumer) { incoming(src, Relations.CATALOG).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingCATALOG(Node src) { return other(src, singleIncoming(src, Relations.CATALOG)); }

	public static void outgoingGROUP(Node src, RelationConsumer consumer) { outgoing(src, Relations.GROUP).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingGROUP(Node src) { return other(src, singleOutgoing(src, Relations.GROUP)); }
	public static void incomingGROUP(Node src, RelationConsumer consumer) { incoming(src, Relations.GROUP).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingGROUP(Node src) { return other(src, singleIncoming(src, Relations.GROUP)); }

	public static void outgoingBOOKMARK(Node src, RelationConsumer consumer) { outgoing(src, Relations.BOOKMARK).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleOutgoingBOOKMARK(Node src) { return other(src, singleOutgoing(src, Relations.BOOKMARK)); }
	public static void incomingBOOKMARK(Node src, RelationConsumer consumer) { incoming(src, Relations.BOOKMARK).forEach(relationship -> consumer.accept(relationship, other(src, relationship))); }
	public static Node singleIncomingBOOKMARK(Node src) { return other(src, singleIncoming(src, Relations.BOOKMARK)); }


	public static Relationship relateCATALOG(Node src, Node dst) { return relate(src, dst, Relations.CATALOG); }
	public static Relationship relateGROUP(Node src, Node dst) { return relate(src, dst, Relations.GROUP); }
	public static Relationship relateBOOKMARK(Node src, Node dst) { return relate(src, dst, Relations.BOOKMARK); }

	// name
	public static <T> T getNameProperty(PropertyContainer container) { return getEntityProperty(container, Properties.name.name()); }
	public static <T> T getNameProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.name.name(), defaultValue); }
	public static boolean hasNameProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.name.name()); }
	public static <T extends PropertyContainer> T setNameProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.name.name(), value); return container; }
	public static <T extends PropertyContainer> T removeNameProperty(T container) { removeEntityProperty(container, Properties.name.name()); return container; }

	protected <T extends PropertyContainer> T setNameProperty(T container, Object value) { setNameProperty(getGraph(), container, value); return container; }

	// icon
	public static <T> T getIconProperty(PropertyContainer container) { return getEntityProperty(container, Properties.icon.name()); }
	public static <T> T getIconProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.icon.name(), defaultValue); }
	public static boolean hasIconProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.icon.name()); }
	public static <T extends PropertyContainer> T setIconProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.icon.name(), value); return container; }
	public static <T extends PropertyContainer> T removeIconProperty(T container) { removeEntityProperty(container, Properties.icon.name()); return container; }

	protected <T extends PropertyContainer> T setIconProperty(T container, Object value) { setIconProperty(getGraph(), container, value); return container; }

	// date
	public static <T> T getDateProperty(PropertyContainer container) { return getEntityProperty(container, Properties.date.name()); }
	public static <T> T getDateProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.date.name(), defaultValue); }
	public static boolean hasDateProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.date.name()); }
	public static <T extends PropertyContainer> T setDateProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.date.name(), value); return container; }
	public static <T extends PropertyContainer> T removeDateProperty(T container) { removeEntityProperty(container, Properties.date.name()); return container; }

	protected <T extends PropertyContainer> T setDateProperty(T container, Object value) { setDateProperty(getGraph(), container, value); return container; }

	// href
	public static <T> T getHrefProperty(PropertyContainer container) { return getEntityProperty(container, Properties.href.name()); }
	public static <T> T getHrefProperty(PropertyContainer container, T defaultValue) { return getEntityProperty(container, Properties.href.name(), defaultValue); }
	public static boolean hasHrefProperty(PropertyContainer container) { return hasEntityProperty(container, Properties.href.name()); }
	public static <T extends PropertyContainer> T setHrefProperty(NeoModel graph, T container, Object value) { setEntityProperty(graph, container, Properties.href.name(), value); return container; }
	public static <T extends PropertyContainer> T removeHrefProperty(T container) { removeEntityProperty(container, Properties.href.name()); return container; }

	protected <T extends PropertyContainer> T setHrefProperty(T container, Object value) { setHrefProperty(getGraph(), container, value); return container; }

}