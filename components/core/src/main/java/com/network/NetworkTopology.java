package com.network;

import org.neo4j.graphdb.*;

import java.util.UUID;

/**
 * 
 */
public class NetworkTopology {

   public enum Entities implements Label {
      Host, Port
   }

   public enum Relations implements RelationshipType {
      _VERSION, PORTS
   }

   public enum Properties {
      _uuid, _deleted, _timestamp, ip, mac, name, port, protocol, service, state
   }


	public static Node newHost(GraphDatabaseService db, String name, String ip, String mac) {
	   final Node node = db.createNode(Entities.Host);
		node.setProperty("_uuid", UUID.randomUUID().toString());
		node.setProperty(Properties.name.name(), name);
		node.setProperty(Properties.ip.name(), ip);
		node.setProperty(Properties.mac.name(), mac);
		return node;
	}

	public static void createHostIndexOnName(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : Host (name)");
	}

	public static void createHostIndexOnIp(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : Host (ip)");
	}

	public static void createHostIndexOnMac(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : Host (mac)");
	}


	public static void findAllHost(GraphDatabaseService db, NodeConsumer consumer) {
		final ResourceIterator<Node> nodes = db.findNodes(Entities.Host);
	   while (nodes.hasNext()) {
	   	if (consumer.handle(nodes.next())) {
	         nodes.close();
	      	return;
	   	}
	   }
		nodes.close();
	}

	public static Node findHostBy_UUID(GraphDatabaseService db, String uuid) {
		return db.findNode(Entities.Host, "_uuid", uuid);
	}

	public static Node findHostByName(GraphDatabaseService db, String name) {
		return db.findNode(Entities.Host, Properties.name.name(), name);
	}

	public static Node findHostByIp(GraphDatabaseService db, String ip) {
		return db.findNode(Entities.Host, Properties.ip.name(), ip);
	}

	public static Node findHostByMac(GraphDatabaseService db, String mac) {
		return db.findNode(Entities.Host, Properties.mac.name(), mac);
	}


	public static Node newPort(GraphDatabaseService db, Integer port, String protocol, String state, String service) {
	   final Node node = db.createNode(Entities.Port);
		node.setProperty("_uuid", UUID.randomUUID().toString());
		node.setProperty(Properties.port.name(), port);
		node.setProperty(Properties.protocol.name(), protocol);
		node.setProperty(Properties.state.name(), state);
		node.setProperty(Properties.service.name(), service);
		return node;
	}

	public static void createPortIndexOnPort(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : Port (port)");
	}

	public static void createPortIndexOnProtocol(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : Port (protocol)");
	}

	public static void createPortIndexOnState(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : Port (state)");
	}

	public static void createPortIndexOnService(GraphDatabaseService db) {
		db.execute("CREATE INDEX ON : Port (service)");
	}


	public static void findAllPort(GraphDatabaseService db, NodeConsumer consumer) {
		final ResourceIterator<Node> nodes = db.findNodes(Entities.Port);
	   while (nodes.hasNext()) {
	   	if (consumer.handle(nodes.next())) {
	         nodes.close();
	      	return;
	   	}
	   }
		nodes.close();
	}

	public static Node findPortBy_UUID(GraphDatabaseService db, String uuid) {
		return db.findNode(Entities.Port, "_uuid", uuid);
	}

	public static Node findPortByPort(GraphDatabaseService db, Integer port) {
		return db.findNode(Entities.Port, Properties.port.name(), port);
	}

	public static Node findPortByProtocol(GraphDatabaseService db, String protocol) {
		return db.findNode(Entities.Port, Properties.protocol.name(), protocol);
	}

	public static Node findPortByState(GraphDatabaseService db, String state) {
		return db.findNode(Entities.Port, Properties.state.name(), state);
	}

	public static Node findPortByService(GraphDatabaseService db, String service) {
		return db.findNode(Entities.Port, Properties.service.name(), service);
	}


	public static Relationship relate_Host_PORTS_Port(Node host, Node port) {
	   return relate(host, port, Relations.PORTS);
	}

	public static void get_Port_PORTS_for_Host(Node host, RelationConsumer consumer) {
		final Iterable<Relationship> relations = host.getRelationships(Direction.OUTGOING, Relations.PORTS);
	   for (Relationship relationship : relations) {
			final Node other = relationship.getOtherNode(host);
	      if (isDeleted(other)) continue;
	   	if (consumer.handle(relationship, other)) break;
		}
	}

	public static Node get_Host_PORTS_for_Port(Node port) {
		final Relationship relationship = port.getSingleRelationship(Relations.PORTS, Direction.INCOMING);
		if (relationship == null) return null;
	   final Node node = relationship.getOtherNode(port);
	   return node == null || isDeleted(node) ? null : node;
	}

	public static String getIp(PropertyContainer container) {
		return (String) container.getProperty(Properties.ip.name());
	}

	public static String getIp(PropertyContainer container, String defaultValue) {
		return container == null || !container.hasProperty(Properties.ip.name()) ? defaultValue : (String) container.getProperty(Properties.ip.name());
	}

	public static void setIp(PropertyContainer container, String ip) {
		// todo validation
		container.setProperty(Properties.ip.name(), ip);
	}

	public static String getMac(PropertyContainer container) {
		return (String) container.getProperty(Properties.mac.name());
	}

	public static String getMac(PropertyContainer container, String defaultValue) {
		return container == null || !container.hasProperty(Properties.mac.name()) ? defaultValue : (String) container.getProperty(Properties.mac.name());
	}

	public static void setMac(PropertyContainer container, String mac) {
		// todo validation
		container.setProperty(Properties.mac.name(), mac);
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

	public static Integer getPort(PropertyContainer container) {
		return (Integer) container.getProperty(Properties.port.name());
	}

	public static Integer getPort(PropertyContainer container, Integer defaultValue) {
		return container == null || !container.hasProperty(Properties.port.name()) ? defaultValue : (Integer) container.getProperty(Properties.port.name());
	}

	public static void setPort(PropertyContainer container, Integer port) {
		// todo validation
		container.setProperty(Properties.port.name(), port);
	}

	public static String getProtocol(PropertyContainer container) {
		return (String) container.getProperty(Properties.protocol.name());
	}

	public static String getProtocol(PropertyContainer container, String defaultValue) {
		return container == null || !container.hasProperty(Properties.protocol.name()) ? defaultValue : (String) container.getProperty(Properties.protocol.name());
	}

	public static void setProtocol(PropertyContainer container, String protocol) {
		// todo validation
		container.setProperty(Properties.protocol.name(), protocol);
	}

	public static String getService(PropertyContainer container) {
		return (String) container.getProperty(Properties.service.name());
	}

	public static String getService(PropertyContainer container, String defaultValue) {
		return container == null || !container.hasProperty(Properties.service.name()) ? defaultValue : (String) container.getProperty(Properties.service.name());
	}

	public static void setService(PropertyContainer container, String service) {
		// todo validation
		container.setProperty(Properties.service.name(), service);
	}

	public static String getState(PropertyContainer container) {
		return (String) container.getProperty(Properties.state.name());
	}

	public static String getState(PropertyContainer container, String defaultValue) {
		return container == null || !container.hasProperty(Properties.state.name()) ? defaultValue : (String) container.getProperty(Properties.state.name());
	}

	public static void setState(PropertyContainer container, String state) {
		// todo validation
		container.setProperty(Properties.state.name(), state);
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