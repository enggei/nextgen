package com.generator.editors.domain;

import com.generator.editors.BaseDomainVisitor;
import com.generator.editors.NeoModel;
import com.generator.util.StringUtil;
import org.neo4j.graphdb.*;

import java.io.File;
import java.util.*;
import java.util.function.Consumer;

/**
 * goe on 1/3/17.
 */
public class MetaModel {

	public static void main(String[] args) {

		final org.neo4j.graphdb.GraphDatabaseService db = new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabase(new File("/home/goe/aaatest"));
		final NeoModel model = new NeoModel(db);

		final MetaVisitor visitor = new MetaVisitor();

		model.doInTransaction(new NeoModel.Committer() {
			@Override
			public void doAction(org.neo4j.graphdb.Transaction tx) throws Throwable {

				model.getGraphDb().getAllLabelsInUse().forEach(new Consumer<Label>() {
					@Override
					public void accept(Label label) {
						visitor.onLabel(label, model.getGraphDb());
					}
				});

				model.getGraphDb().getAllRelationshipTypesInUse().forEach(new Consumer<RelationshipType>() {
					@Override
					public void accept(RelationshipType relationshipType) {
						visitor.onRelationshipType(relationshipType, model.getGraphDb());
					}
				});
			}

			@Override
			public void exception(Throwable throwable) {
				throw new RuntimeException(throwable);
			}
		});

		visitor.outgoing.entrySet().forEach(new Consumer<Map.Entry<String, Set<String>>>() {
			@Override
			public void accept(Map.Entry<String, Set<String>> entry) {
				System.out.println(entry.getKey() + " -> [" + StringUtil.list(entry.getValue()) + "]");
			}
		});
		System.out.println("--");
		visitor.incoming.entrySet().forEach(new Consumer<Map.Entry<String, Set<String>>>() {
			@Override
			public void accept(Map.Entry<String, Set<String>> entry) {
				System.out.println(entry.getKey() + " <- [" + StringUtil.list(entry.getValue()) + "]");
			}
		});
	}

	private static class MetaVisitor {

		final Map<String, Set<String>> outgoing = new TreeMap<>();
		final Map<String, Set<String>> incoming = new TreeMap<>();
		final Set<String> relations = new TreeSet<>();

		public void onLabel(Label label, GraphDatabaseService db) {

			final Set<String> out = getTypesetForLabel(label, Direction.OUTGOING);
			final Set<String> in = getTypesetForLabel(label, Direction.INCOMING);

			db.findNodes(label).forEachRemaining(new Consumer<Node>() {
				@Override
				public void accept(Node node) {
					node.getRelationships(Direction.OUTGOING).forEach(new Consumer<Relationship>() {
						@Override
						public void accept(Relationship relationship) {
							out.add(relationship.getType().name());
							final String x = node.getLabels().iterator().next() + " -> " + relationship.getType() + " -> " + BaseDomainVisitor.other(node, relationship).getLabels().iterator().next();
							if (relations.contains(x)) return;
							relations.add(x);
							System.out.println(x);
							//replaceRelation(relationship, "DIRECTORY_MEMBER", "Project", "PROJECT_DIRECTORY");
						}
					});

					node.getRelationships(Direction.INCOMING).forEach(new Consumer<Relationship>() {
						@Override
						public void accept(Relationship relationship) {
							in.add(relationship.getType().name());
							final String x = node.getLabels().iterator().next() + " <- " + relationship.getType() + " <- " + BaseDomainVisitor.other(node, relationship).getLabels().iterator().next();
							if (relations.contains(x)) return;
							relations.add(x);
							System.out.println(x);
						}
					});
				}
			});
		}

		public void onRelationshipType(RelationshipType relationshipType, GraphDatabaseService db) {

		}

		private Set<String> getTypesetForLabel(Label label, Direction direction) {

			switch (direction) {

				case OUTGOING: {
					Set<String> types = outgoing.get(label.name());
					if (types == null) outgoing.put(label.name(), types = new TreeSet<>());
					return types;
				}
				case INCOMING: {
					Set<String> types = incoming.get(label.name());
					if (types == null) incoming.put(label.name(), types = new TreeSet<>());
					return types;
				}
			}
			return Collections.emptySet();
		}

		private static void replaceRelation(Relationship relationship, String existingRelationship, String startNodeLabel, String newRelationship) {
			if (relationship.getType().name().equals(existingRelationship)) {
				for (Label startLbl : relationship.getStartNode().getLabels()) {
					if (startLbl.name().equals(startNodeLabel)) {
						relationship.getStartNode().createRelationshipTo(relationship.getEndNode(), RelationshipType.withName(newRelationship));
						relationship.delete();
					}
				}
			}
		}
	}
}