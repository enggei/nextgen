package com.generator.generators.neo4j;

import org.neo4j.graphdb.*;

import java.util.UUID;

/**
 * Test domain of cinema-domain
 */
public class CinemaDomain {

   public enum Entities implements Label {
      Exhibitor, Screen, Site
   }

   public enum Relations implements RelationshipType {
      _VERSION, SITES, SCREENS
   }

   public enum Properties {
      _uuid, _deleted, _timestamp, name, region, screenType, status
   }

	public enum screenType {
		_2D, _3D
	}
	public enum status {
		ACTIVE, CLOSED, RENOVATING
	}

	public static Node newExhibitor(GraphDatabaseService db, String name) {
	   final Node node = db.createNode(Entities.Exhibitor);
		node.setProperty("_uuid", UUID.randomUUID().toString());
		node.setProperty(Properties.name.name(), name);
		return node;
	}

	public static void createExhibitorIndexOnName(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : Exhibitor (name)");
	}


	public static void findAllExhibitor(GraphDatabaseService db, NodeConsumer consumer) {
		final ResourceIterator<Node> nodes = db.findNodes(Entities.Exhibitor);
	   while (nodes.hasNext()) {
	   	if (consumer.handle(nodes.next())) {
	         nodes.close();
	      	return;
	   	}
	   }
		nodes.close();
	}

	public static Node findExhibitorBy_UUID(GraphDatabaseService db, String uuid) {
		return db.findNode(Entities.Exhibitor, "_uuid", uuid);
	}

	public static Node findExhibitorByName(GraphDatabaseService db, String name) {
		return db.findNode(Entities.Exhibitor, Properties.name.name(), name);
	}


	public static Node newScreen(GraphDatabaseService db, String name, screenType screenType) {
	   final Node node = db.createNode(Entities.Screen);
		node.setProperty("_uuid", UUID.randomUUID().toString());
		node.setProperty(Properties.name.name(), name);
		node.setProperty(Properties.screenType.name(), screenType.name());
		return node;
	}

	public static void createScreenIndexOnName(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : Screen (name)");
	}

	public static void createScreenIndexOnScreenType(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : Screen (screenType)");
	}


	public static void findAllScreen(GraphDatabaseService db, NodeConsumer consumer) {
		final ResourceIterator<Node> nodes = db.findNodes(Entities.Screen);
	   while (nodes.hasNext()) {
	   	if (consumer.handle(nodes.next())) {
	         nodes.close();
	      	return;
	   	}
	   }
		nodes.close();
	}

	public static Node findScreenBy_UUID(GraphDatabaseService db, String uuid) {
		return db.findNode(Entities.Screen, "_uuid", uuid);
	}

	public static Node findScreenByName(GraphDatabaseService db, String name) {
		return db.findNode(Entities.Screen, Properties.name.name(), name);
	}

	public static Node findScreenByScreenType(GraphDatabaseService db, screenType screenType) {
		return db.findNode(Entities.Screen, Properties.screenType.name(), screenType.name());
	}


	public static Node newSite(GraphDatabaseService db, String name) {
	   final Node node = db.createNode(Entities.Site);
		node.setProperty("_uuid", UUID.randomUUID().toString());
		node.setProperty(Properties.name.name(), name);
		return node;
	}

	public static void createSiteIndexOnName(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : Site (name)");
	}


	public static void findAllSite(GraphDatabaseService db, NodeConsumer consumer) {
		final ResourceIterator<Node> nodes = db.findNodes(Entities.Site);
	   while (nodes.hasNext()) {
	   	if (consumer.handle(nodes.next())) {
	         nodes.close();
	      	return;
	   	}
	   }
		nodes.close();
	}

	public static Node findSiteBy_UUID(GraphDatabaseService db, String uuid) {
		return db.findNode(Entities.Site, "_uuid", uuid);
	}

	public static Node findSiteByName(GraphDatabaseService db, String name) {
		return db.findNode(Entities.Site, Properties.name.name(), name);
	}


	public static Relationship relate_Exhibitor_SITES_Site(Node exhibitor, Node site, status status, String region) {
	   final Relationship relation = relate(exhibitor, site, Relations.SITES);
	   relation.setProperty(Properties.status.name(), status.name());
	   relation.setProperty(Properties.region.name(), region);
	   return relation;
	}

	public static void get_Site_SITES_for_Exhibitor(Node exhibitor, RelationConsumer consumer) {
		final Iterable<Relationship> relations = exhibitor.getRelationships(Direction.OUTGOING, Relations.SITES);
	   for (Relationship relationship : relations) {
			final Node other = relationship.getOtherNode(exhibitor);
	      if (isDeleted(other)) continue;
	   	if (consumer.handle(relationship, other)) break;
		}
	}

	public static Node get_Exhibitor_SITES_for_Site(Node site) {
		final Relationship relationship = site.getSingleRelationship(Relations.SITES, Direction.INCOMING);
		if (relationship == null) return null;
	   final Node node = relationship.getOtherNode(site);
	   return node == null || isDeleted(node) ? null : node;
	}

	public static Relationship relate_Site_SCREENS_Screen(Node site, Node screen) {
	   return relate(site, screen, Relations.SCREENS);
	}

	public static void get_Screen_SCREENS_for_Site(Node site, RelationConsumer consumer) {
		final Iterable<Relationship> relations = site.getRelationships(Direction.OUTGOING, Relations.SCREENS);
	   for (Relationship relationship : relations) {
			final Node other = relationship.getOtherNode(site);
	      if (isDeleted(other)) continue;
	   	if (consumer.handle(relationship, other)) break;
		}
	}

	public static Node get_Site_SCREENS_for_Screen(Node screen) {
		final Relationship relationship = screen.getSingleRelationship(Relations.SCREENS, Direction.INCOMING);
		if (relationship == null) return null;
	   final Node node = relationship.getOtherNode(screen);
	   return node == null || isDeleted(node) ? null : node;
	}

	public static String getName(PropertyContainer container) {
		return (String) container.getProperty(Properties.name.name());
	}

	public static String getName(PropertyContainer container, String defaultValue) {
		return container == null || !container.hasProperty(Properties.name.name()) ? defaultValue : (String) container.getProperty(Properties.name.name());
	}

	public static void setName(PropertyContainer container, String name) {
		// todo validation
		container.setProperty(Properties.name.name(), name);
	}

	public static String getRegion(PropertyContainer container) {
		return (String) container.getProperty(Properties.region.name());
	}

	public static String getRegion(PropertyContainer container, String defaultValue) {
		return container == null || !container.hasProperty(Properties.region.name()) ? defaultValue : (String) container.getProperty(Properties.region.name());
	}

	public static void setRegion(PropertyContainer container, String region) {
		// todo validation
		container.setProperty(Properties.region.name(), region);
	}

	public static screenType getScreenType(PropertyContainer container) {
		return screenType.valueOf(container.getProperty(Properties.screenType.name()).toString());
	}

	public static screenType getScreenType(PropertyContainer container, screenType defaultValue) {
		return container == null || !container.hasProperty(Properties.screenType.name()) ? defaultValue : screenType.valueOf(container.getProperty(Properties.screenType.name()).toString());
	}

	public static void setScreenType(PropertyContainer container, screenType screenType) {
		// todo validation
		container.setProperty(Properties.screenType.name(), screenType.name());
	}

	public static status getStatus(PropertyContainer container) {
		return status.valueOf(container.getProperty(Properties.status.name()).toString());
	}

	public static status getStatus(PropertyContainer container, status defaultValue) {
		return container == null || !container.hasProperty(Properties.status.name()) ? defaultValue : status.valueOf(container.getProperty(Properties.status.name()).toString());
	}

	public static void setStatus(PropertyContainer container, status status) {
		// todo validation
		container.setProperty(Properties.status.name(), status.name());
	}

	public interface NodeConsumer {

      /**
       * @return true if stop iteration
       */
	   boolean handle(Node node);
   }

	public interface RelationConsumer {

      /**
       * @return true if stop iteration
       */
      boolean handle(Relationship relationship, Node other);
   }

	public interface TransactionHandler {

      /**
       * @return true if successfull, false if failed
       */
      void execute() throws Exception;

      void handleException(Exception e);
   }

   public static void doInTransaction(GraphDatabaseService db, TransactionHandler transactionHandler) {
      try (Transaction tx = db.beginTx()) {
         transactionHandler.execute();
         tx.success();
      } catch (Exception e) {
         transactionHandler.handleException(e);
      }
   }

	private static Relationship relate(Node source, Node target, RelationshipType relationshipType, Object... properties) {

      // if already related, merge properties:
      for (Object o : outgoing(source, relationshipType)) {
         final Relationship relationship = (Relationship) o;
         if (target.equals(other(source, relationship))) {
            for (int i = 0; i < properties.length; i += 2)
               relationship.setProperty(properties[i].toString(), properties[i + 1]);
            return relationship;
         }
      }

      final Relationship relationship = source.createRelationshipTo(target, relationshipType);
      for (int i = 0; i < properties.length; i += 2)
         relationship.setProperty(properties[i].toString(), properties[i + 1]);

      return relationship;
   }

   private static Iterable<?> outgoing(Node node, RelationshipType type) {
      return node == null ? java.util.Collections.emptyList() : node.getRelationships(Direction.OUTGOING, type);
   }

	private static Node other(Node node, Relationship relationship) {
      return relationship == null ? null : relationship.getOtherNode(node);
   }

	public static void deleteNode(Node node) {
      node.setProperty(Properties._deleted.name(), true);
      node.setProperty(Properties._timestamp.name(), System.currentTimeMillis());
   }

   private static boolean isDeleted(Node node) {
      return node==null ? true : (Boolean) node.getProperty(Properties._deleted.name(), false);
   }

	public static void newVersion(Node oldNode, Node newNode) {
      final Relationship versionRelation = newNode.createRelationshipTo(oldNode, Relations._VERSION);
      versionRelation.setProperty(Properties._timestamp.name(), System.currentTimeMillis());
   }

   public static void getAllVersionsOf(Node node, java.util.function.Consumer<Node> consumer) {
      final Relationship versionRelation = node.getSingleRelationship(Relations._VERSION, Direction.OUTGOING);
      if (versionRelation == null) return;

      final Node oldVersion = versionRelation.getOtherNode(node);
      consumer.accept(oldVersion);

      getAllVersionsOf(oldVersion, consumer);
   }
}