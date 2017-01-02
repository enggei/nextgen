package com.generator.editors;

import org.neo4j.graphdb.*;
import org.neo4j.graphdb.index.Index;
import org.neo4j.graphdb.index.IndexHits;
import org.neo4j.graphdb.index.RelationshipIndex;
import org.neo4j.graphdb.schema.IndexDefinition;
import org.neo4j.graphdb.schema.Schema;
import org.neo4j.graphdb.traversal.TraversalDescription;
import org.neo4j.helpers.collection.Iterators;
import org.stringtemplate.v4.ST;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * User: goe
 * Date: 19.05.14
 */
public class NeoModel {

	public static final String TAG_UUID = "_uuid";
	public static final String TAG_LAYOUT = "_layout";

	private final GraphDatabaseService graphDb;
	private final Index<Node> uuids;
	private final RelationshipIndex relUuids;

	public interface NeoModelListener {

		public void closed(NeoModel model);
	}

	public NeoModel(final GraphDatabaseService graphDb) {
		this(graphDb, null);
	}

	public NeoModel(final GraphDatabaseService graphDb, NeoModelListener listener) {

		this.graphDb = graphDb;

		try (Transaction tx = graphDb.beginTx()) {
			this.uuids = graphDb.index().forNodes(TAG_UUID);
			this.relUuids = graphDb.index().forRelationships(TAG_UUID);
			tx.success();
		}

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				close();
				if (listener != null) listener.closed(NeoModel.this);
			}
		});
	}

	public GraphDatabaseService getGraphDb() {
		return graphDb;
	}

	// DATABASE
	public void close() {
		graphDb.shutdown();
	}

	public void dropAll() {
		query("MATCH (n) OPTIONAL MATCH (n)-[r]-() DELETE n, r");
	}

	public Result query(String query) {
		System.out.println(query);
		return graphDb.execute(query);
	}

	public Transaction beginTx() {
		return graphDb.beginTx();
	}

	public TraversalDescription traverser() {
		return graphDb.traversalDescription();
	}

	public void addIndex(final String label, final String property) {

		final Label nodeLabel = Label.label(label);
		final AtomicBoolean found = new AtomicBoolean(false);

		Schema schema = graphDb.schema();

		Iterable<IndexDefinition> indices = schema.getIndexes(nodeLabel);

		indices.forEach(indexDefinition -> {
			for (String key : indexDefinition.getPropertyKeys()) {
				if (key.compareTo(property) != 0)
					continue;
				found.set(true);
				return;
			}
		});

		if (found.get())
			return;

		schema.indexFor(nodeLabel).
			on(property).
			create();
	}

	// NODE
	public Node createNode(Label label) {
		return newNode(label.name(), UUID.randomUUID());
	}

	public Node newNode(Label label, String... kv) {
		return newNode(label.name(), UUID.randomUUID(), kv);
	}

	public Node newNode(String label, String... kv) {
		return newNode(label, UUID.randomUUID(), kv);
	}

	public Node newNode(final UUID uuid, String... kv) {
		return newNode(null, uuid, kv);
	}

	public Node newNode(final String label, final UUID uuid, String... kv) {

		Node node = getNode(uuid);
		if (node == null) {
			System.out.println("newNode " + uuid + " (" + label + ")");
			node = label == null ? graphDb.createNode() : graphDb.createNode(() -> label);
			node.setProperty(TAG_UUID, uuid.toString());
			uuids.add(node, TAG_UUID, uuid.toString());
		}

		for (int i = 0; i < kv.length; i += 2)
			if (kv[i + 1] != null && !kv[i + 1].equals("[]")) {
				node.setProperty(kv[i], kv[i + 1]);
			}

		return node;
	}

	public static UUID uuidOf(Node node) {
		return node == null ? null : hasUUID(node) ? UUID.fromString(node.getProperty(TAG_UUID).toString()) : null;
	}

	public static String getNameOrLabelFrom(Node node) {

		if (node == null) return "NULL";

		if (node.hasProperty("name")) {
			return node.getProperty("name").toString();

		} else {

			// if node has labels, show all
			final StringBuilder lbl = new StringBuilder();
			for (Label label : node.getLabels()) lbl.append(label).append(" ");
			if (lbl.length() > 0) return lbl.toString().trim();

			// if no labels, show uuid:
			return hasUUID(node) ? uuidOf(node).toString() : "[" + node.getPropertyKeys() + "]";
		}
	}

	public static boolean hasUUID(Node node) {
		return node.hasProperty(NeoModel.TAG_UUID);
	}

	public static Object getProperty(String name, Node node, Object defaultValue) {
		return node.hasProperty(name) ? node.getProperty(name) : defaultValue;
	}

	public static boolean hasOutgoing(Node node, RelationshipType relationship) {
		return node.getRelationships(Direction.OUTGOING, relationship).iterator().hasNext();
	}

	public Node getNode(final UUID uuid) {
		final IndexHits<Node> indexHits = uuids.get(TAG_UUID, uuid);
		return indexHits.size() == 0 ? null : indexHits.getSingle();
	}

	public Node mergeNode(final UUID uuid) {
		final IndexHits<Node> indexHits = uuids.get(TAG_UUID, uuid);
		return indexHits.size() == 0 ? newNode(uuid) : indexHits.getSingle();
	}

	// NODES

	public Set<Node> getAll(String label) {
		final ST cypher = new ST("MATCH (entity~if(label)~:~label~~endif~) RETURN entity", '~', '~');
		if (label != null && label.length() != 0)
			cypher.add("label", label);

		final Result res = query(cypher.render());
		final Iterator<Node> n_column = res.columnAs("entity");
		final Set<Node> result = new LinkedHashSet<>();
		try {
			for (Node node : Iterators.asIterable(n_column))
				result.add(node);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Set<Node> getAll(String property, String value) {

		// http://docs.neo4j.org/chunked/stable/query-match.html
		final ST cypher = new ST("MATCH (entity) ~if(property)~WHERE entity.~property~ = '~value~'~endif~ RETURN entity", '~', '~');
		cypher.add("property", property);
		cypher.add("value", value);
		final Result res = query(cypher.render());
		final Iterator<Node> n_column = res.columnAs("entity");
		final Set<Node> result = new LinkedHashSet<>();
		for (Node node : Iterators.asIterable(n_column))
			result.add(node);
		return result;
	}

	public Set<Node> getAll(String label, String property, String value) {
		final ST cypher = new ST("MATCH (entity:~label~) WHERE entity.~property~ = \"~value~\" RETURN entity", '~', '~');
		cypher.add("label", label);
		cypher.add("property", property);
		cypher.add("value", value);
		final Result res = query(cypher.render());
		final Iterator<Node> n_column = res.columnAs("entity");
		final Set<Node> result = new LinkedHashSet<>();
		for (Node node : Iterators.asIterable(n_column))
			result.add(node);
		return result;
	}

	public ResourceIterator<Node> findNodes(Label label) {
		return graphDb.findNodes(label);
	}

	// LABELS

	public ResourceIterable<Label> getAllLabels() {
		return graphDb.getAllLabels();
	}

	public ResourceIterable<Label> getAllLabelsInUse() {
		return graphDb.getAllLabelsInUse();
	}


	// RELATIONSHIP

	public Relationship newRelationship(final Node source, final Node target, final RelationshipType type, Object... kv) {
		return newRelationship(source, target, type, UUID.randomUUID(), kv);
	}

	public Relationship newRelationship(final Node source, final Node target, final RelationshipType type, final UUID uuid, Object... kv) {

		if (kv.length % 2 != 0)
			throw new IllegalArgumentException("Expecting key value PAIRS");

		Relationship relationship = getRelationship(uuid);
		if (relationship == null) {
			relationship = source.createRelationshipTo(target, type);
			relationship.setProperty(TAG_UUID, uuid.toString());
			relUuids.add(relationship, TAG_UUID, uuid.toString());
		}

		for (int i = 0; i < kv.length; i += 2)
			if (kv[i + 1] != null && !kv[i + 1].equals("[]")) {
				relationship.setProperty(kv[i].toString(), kv[i + 1]);
			}

		return relationship;
	}

	public Relationship getRelationship(final UUID uuid) {
		final IndexHits<Relationship> indexHits = relUuids.get(TAG_UUID, uuid);
		return indexHits.size() == 0 ? null : indexHits.getSingle();
	}

	// RELATIONSHIPS

	public ResourceIterable<RelationshipType> getAllRelationshipTypes() {
		return graphDb.getAllRelationshipTypes();
	}

	public ResourceIterable<RelationshipType> getAllRelationshipTypesInUse() {
		return graphDb.getAllRelationshipTypesInUse();
	}

	public PropertyContainer setProperties(PropertyContainer propertyContainer, Object... kv) {
		if (kv.length % 2 != 0)
			throw new IllegalArgumentException("Expecting key value PAIRS");

		for (int i = 0; i < kv.length; i += 2)
			if (kv[i + 1] != null && !kv[i + 1].equals("[]")) {
				propertyContainer.setProperty(kv[i].toString(), kv[i + 1]);
			}

		return propertyContainer;
	}

	// TRANSACTION SUPPORT

	public interface Committer {

		void doAction(Transaction tx) throws Throwable;

		void exception(Throwable throwable);
	}

	public void doInTransaction(Committer committer) {
		try (Transaction tx = beginTx()) {
			try {
				committer.doAction(tx);
				tx.success();
			} catch (Throwable throwable) {
				committer.exception(throwable);
				tx.failure();
			}
		}
	}

	public static String debugNode(Node node) {
		return BaseDomainVisitor.uuidOf(node) + "(" + NeoModel.getNameOrLabelFrom(node) + ")";
	}
}