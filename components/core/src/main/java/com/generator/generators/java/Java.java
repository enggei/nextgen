package com.generator.generators.java;

import org.neo4j.graphdb.*;

import java.util.UUID;

/**
 * 
 */
public class Java {

   public enum Entities implements Label {
      JClass, JField, JPackage
   }

   public enum Relations implements RelationshipType {
      _VERSION, FIELDS, PARENT, CLASSES
   }

   public enum Properties {
      _uuid, _deleted, _timestamp, name, scope
   }

	public enum scope {
		PACKAGE, PRIVATE, PROTECTED, PUBLIC
	}

	public static Node newJClass(GraphDatabaseService db, scope scope, String name) {
	   final Node node = db.createNode(Entities.JClass);
		node.setProperty("_uuid", UUID.randomUUID().toString());
		node.setProperty(Properties.scope.name(), scope.name());
		node.setProperty(Properties.name.name(), name);
		return node;
	}

	public static void createJClassIndexOnScope(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : JClass (scope)");
	}

	public static void createJClassIndexOnName(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : JClass (name)");
	}


	public static void findAllJClass(GraphDatabaseService db, NodeConsumer consumer) {
		final ResourceIterator<Node> nodes = db.findNodes(Entities.JClass);
	   while (nodes.hasNext()) {
	   	if (consumer.handle(nodes.next())) {
	         nodes.close();
	      	return;
	   	}
	   }
		nodes.close();
	}

	public static Node findJClassBy_UUID(GraphDatabaseService db, String uuid) {
		return db.findNode(Entities.JClass, "_uuid", uuid);
	}

	public static Node findJClassByScope(GraphDatabaseService db, scope scope) {
		return db.findNode(Entities.JClass, Properties.scope.name(), scope.name());
	}

	public static Node findJClassByName(GraphDatabaseService db, String name) {
		return db.findNode(Entities.JClass, Properties.name.name(), name);
	}


	public static Node newJField(GraphDatabaseService db, String name, scope scope) {
	   final Node node = db.createNode(Entities.JField);
		node.setProperty("_uuid", UUID.randomUUID().toString());
		node.setProperty(Properties.name.name(), name);
		node.setProperty(Properties.scope.name(), scope.name());
		return node;
	}

	public static void createJFieldIndexOnName(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : JField (name)");
	}

	public static void createJFieldIndexOnScope(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : JField (scope)");
	}


	public static void findAllJField(GraphDatabaseService db, NodeConsumer consumer) {
		final ResourceIterator<Node> nodes = db.findNodes(Entities.JField);
	   while (nodes.hasNext()) {
	   	if (consumer.handle(nodes.next())) {
	         nodes.close();
	      	return;
	   	}
	   }
		nodes.close();
	}

	public static Node findJFieldBy_UUID(GraphDatabaseService db, String uuid) {
		return db.findNode(Entities.JField, "_uuid", uuid);
	}

	public static Node findJFieldByName(GraphDatabaseService db, String name) {
		return db.findNode(Entities.JField, Properties.name.name(), name);
	}

	public static Node findJFieldByScope(GraphDatabaseService db, scope scope) {
		return db.findNode(Entities.JField, Properties.scope.name(), scope.name());
	}


	public static Node newJPackage(GraphDatabaseService db, String name) {
	   final Node node = db.createNode(Entities.JPackage);
		node.setProperty("_uuid", UUID.randomUUID().toString());
		node.setProperty(Properties.name.name(), name);
		return node;
	}

	public static void createJPackageIndexOnName(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : JPackage (name)");
	}


	public static void findAllJPackage(GraphDatabaseService db, NodeConsumer consumer) {
		final ResourceIterator<Node> nodes = db.findNodes(Entities.JPackage);
	   while (nodes.hasNext()) {
	   	if (consumer.handle(nodes.next())) {
	         nodes.close();
	      	return;
	   	}
	   }
		nodes.close();
	}

	public static Node findJPackageBy_UUID(GraphDatabaseService db, String uuid) {
		return db.findNode(Entities.JPackage, "_uuid", uuid);
	}

	public static Node findJPackageByName(GraphDatabaseService db, String name) {
		return db.findNode(Entities.JPackage, Properties.name.name(), name);
	}


	public static Relationship relate_JClass_FIELDS_JField(Node jClass, Node jField) {
	   return relate(jClass, jField, Relations.FIELDS);
	}

	public static void get_JField_FIELDS_for_JClass(Node jClass, RelationConsumer consumer) {
		final Iterable<Relationship> relations = jClass.getRelationships(Direction.OUTGOING, Relations.FIELDS);
	   for (Relationship relationship : relations) {
			final Node other = relationship.getOtherNode(jClass);
	      if (isDeleted(other)) continue;
	   	if (consumer.handle(relationship, other)) break;
		}
	}

	public static Node get_JClass_FIELDS_for_JField(Node jField) {
		final Relationship relationship = jField.getSingleRelationship(Relations.FIELDS, Direction.INCOMING);
		if (relationship == null) return null;
	   final Node node = relationship.getOtherNode(jField);
	   return node == null || isDeleted(node) ? null : node;
	}

	public static Relationship relate_JPackageSrc_PARENT_JPackageDst(Node jPackageSrc, Node jPackageDst) {
	   return relate(jPackageSrc, jPackageDst, Relations.PARENT);
	}

	public static void get_JPackageDst_PARENT_for_JPackageSrc(Node jPackageSrc, RelationConsumer consumer) {
		final Iterable<Relationship> relations = jPackageSrc.getRelationships(Direction.OUTGOING, Relations.PARENT);
	   for (Relationship relationship : relations) {
			final Node other = relationship.getOtherNode(jPackageSrc);
	      if (isDeleted(other)) continue;
	   	if (consumer.handle(relationship, other)) break;
		}
	}

	public static Node get_JPackageSrc_PARENT_for_JPackageDst(Node jPackageDst) {
		final Relationship relationship = jPackageDst.getSingleRelationship(Relations.PARENT, Direction.INCOMING);
		if (relationship == null) return null;
	   final Node node = relationship.getOtherNode(jPackageDst);
	   return node == null || isDeleted(node) ? null : node;
	}

	public static Relationship relate_JPackage_CLASSES_JClass(Node jPackage, Node jClass) {
	   return relate(jPackage, jClass, Relations.CLASSES);
	}

	public static void get_JClass_CLASSES_for_JPackage(Node jPackage, RelationConsumer consumer) {
		final Iterable<Relationship> relations = jPackage.getRelationships(Direction.OUTGOING, Relations.CLASSES);
	   for (Relationship relationship : relations) {
			final Node other = relationship.getOtherNode(jPackage);
	      if (isDeleted(other)) continue;
	   	if (consumer.handle(relationship, other)) break;
		}
	}

	public static Node get_JPackage_CLASSES_for_JClass(Node jClass) {
		final Relationship relationship = jClass.getSingleRelationship(Relations.CLASSES, Direction.INCOMING);
		if (relationship == null) return null;
	   final Node node = relationship.getOtherNode(jClass);
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

	public static scope getScope(PropertyContainer container) {
		return scope.valueOf(container.getProperty(Properties.scope.name()).toString());
	}

	public static scope getScope(PropertyContainer container, scope defaultValue) {
		return container == null || !container.hasProperty(Properties.scope.name()) ? defaultValue : scope.valueOf(container.getProperty(Properties.scope.name()).toString());
	}

	public static void setScope(PropertyContainer container, scope scope) {
		// todo validation
		container.setProperty(Properties.scope.name(), scope.name());
	}

	public static GraphDatabaseService newDatabase(String path) {
		return new org.neo4j.graphdb.factory.GraphDatabaseFactory().
				newEmbeddedDatabaseBuilder(new java.io.File(path)).
				setConfig(org.neo4j.graphdb.factory.GraphDatabaseSettings.allow_store_upgrade, "true").
				newGraphDatabase();
	}

	public static String getUuid(Node node) {
		return (String) node.getProperty(Properties._uuid.name());
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