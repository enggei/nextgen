package com.generator.editors.domain;

import org.neo4j.cypher.javacompat.ExecutionEngine;
import org.neo4j.cypher.javacompat.ExecutionResult;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.index.Index;
import org.neo4j.graphdb.index.IndexHits;
import org.neo4j.graphdb.traversal.TraversalDescription;
import org.neo4j.helpers.collection.IteratorUtil;
import org.neo4j.kernel.impl.util.StringLogger;
import org.stringtemplate.v4.ST;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

/**
 * User: goe
 * Date: 19.05.14
 */
public class NeoModel {

	public static final String TAG_UUID = "_uuid";

	private final GraphDatabaseService graphDb;
	private final ExecutionEngine engine;
	private final Index<Node> uuids;

	public NeoModel(final GraphDatabaseService graphDb) {
		this.graphDb = graphDb;
		this.engine = new ExecutionEngine(graphDb, StringLogger.SYSTEM);

		try (Transaction tx = graphDb.beginTx()) {
			this.uuids = graphDb.index().forNodes(TAG_UUID);
			tx.success();
		}

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				close();
				System.out.println("db shutdown");
			}
		});
	}

	public void close() {
		graphDb.shutdown();
	}

	public interface Committer {

		void doAction(Transaction tx) throws Throwable;

		void exception(Throwable throwable);
	}

	public void doInTransaction(Committer committer) {
		try (Transaction tx = beginTx()) {
			System.out.println("start tx");
			try {
				committer.doAction(tx);
				tx.success();
			} catch (Throwable throwable) {
				committer.exception(throwable);
				tx.failure();
			}
			System.out.println("end tx");
		}
	}

	public Node newNode(String label, String... kv) {
		return newNode(label, UUID.randomUUID(), kv);
	}

	public Node newNode(MetaDomain.MetaLabels label, final UUID uuid, String... kv) {
		return newNode(label == null ? null : label.name(), uuid, kv);
	}

	public Node newNode(final UUID uuid, String... kv) {
		return newNode((String) null, uuid, kv);
	}

	public Node newNode(final String label, final UUID uuid, String... kv) {

		Node node = getNode(uuid);
		if (node == null) {
			node = label == null ? graphDb.createNode() : graphDb.createNode(DynamicLabel.label(label));
			node.setProperty(TAG_UUID, uuid.toString());
			uuids.add(node, TAG_UUID, uuid.toString());
		}

		for (int i = 0; i < kv.length; i += 2)
			if (kv[i + 1] != null && !kv[i + 1].equals("[]")) {
				node.setProperty(kv[i], kv[i + 1]);
			}

		return node;
	}

	public Set<Node> getAll(String label) {
		final ST cypher = new ST("MATCH (entity~if(label)~:~label~~endif~) RETURN entity", '~', '~');
		if (label != null && label.length() != 0)
			cypher.add("label", label);

		final ExecutionResult res = query(cypher.render());
		final Iterator<Node> n_column = res.columnAs("entity");
		final Set<Node> result = new LinkedHashSet<>();
		try {
			for (Node node : IteratorUtil.asIterable(n_column))
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
		final ExecutionResult res = query(cypher.render());
		final Iterator<Node> n_column = res.columnAs("entity");
		final Set<Node> result = new LinkedHashSet<>();
		for (Node node : IteratorUtil.asIterable(n_column))
			result.add(node);
		return result;
	}

	public Set<Node> getAll(String label, String property, String value) {
		final ST cypher = new ST("MATCH (entity:~label~) WHERE entity.~property~ = \"~value~\" RETURN entity", '~', '~');
		cypher.add("label", label);
		cypher.add("property", property);
		cypher.add("value", value);
		final ExecutionResult res = query(cypher.render());
		final Iterator<Node> n_column = res.columnAs("entity");
		final Set<Node> result = new LinkedHashSet<>();
		for (Node node : IteratorUtil.asIterable(n_column))
			result.add(node);
		return result;
	}

	public Node getNode(final UUID uuid) {
		final IndexHits<Node> indexHits = uuids.get(TAG_UUID, uuid);
		return indexHits.size() == 0 ? null : indexHits.getSingle();
	}

	public ExecutionResult query(String query) {
		System.out.println(query);
		return engine.execute(query);
	}

	public Transaction beginTx() {
		return graphDb.beginTx();
	}

	public TraversalDescription traverser() {
		return graphDb.traversalDescription();
	}

	public static UUID uuidOf(Node node) {
		return node == null ? null : UUID.fromString(node.getProperty(TAG_UUID).toString());
	}

	public static String getNameOrLabelFrom(Node node) {

		if (node == null) return "NULL";

		if (node.hasProperty("name")) {
			return node.getProperty("name").toString();
		} else {
			final StringBuilder lbl = new StringBuilder();
			for (Label label : node.getLabels()) lbl.append(label).append(" ");
			return lbl.toString().trim();
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
}