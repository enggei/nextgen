package com.generator.util;

import com.generator.BaseDomainVisitor;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;

import java.util.Collections;
import java.util.Vector;

/**
 * Created by sogern on 20.07.16.
 */
public class BaseMotif
{
	// todo: revise and remove vector (list)
	// todo: implement and test Neo traversal

	// Linked list:
	// Source --LAST--> ListItem --LINK--> ListItem [--LINK--> ListItem ...] <--FIRST-- Source
	public static Iterable<Node> getLinkedListFor(Node source, final RelationshipType last, final RelationshipType link) {

		final Vector<Node> list = new Vector<>();

		Node listItem = BaseDomainVisitor.other(source, BaseDomainVisitor.singleOutgoing(source, last));
		if (listItem == null)
			return Collections.emptyList();

		list.add(listItem);

		while (BaseDomainVisitor.hasOutgoing(listItem, link)) {
			listItem = BaseDomainVisitor.other(listItem, BaseDomainVisitor.singleOutgoing(listItem, link));
			list.add(listItem);
		}

		return list;
	}

	public static void addLinkedListItem(Node source, Node listItem, final RelationshipType first, final RelationshipType last, final RelationshipType link) {

		// on first entry
		if (!BaseDomainVisitor.hasOutgoing(source, first) && !BaseDomainVisitor.hasOutgoing(source, last)) {
			source.createRelationshipTo(listItem, first);
			source.createRelationshipTo(listItem, last);
			return;
		}

		//
		Node currentLast = BaseDomainVisitor.other(source, BaseDomainVisitor.singleOutgoing(source, last));
		if (currentLast == null) throw new IllegalStateException("currentLast is null when adding linked list item");

		BaseDomainVisitor.outgoing(source, last).forEach(Relationship::delete);

		listItem.createRelationshipTo(currentLast, link);
		source.createRelationshipTo(listItem, last);
	}

	public static void deleteLinkedListItem(Node listItem, final RelationshipType first, final RelationshipType last, final RelationshipType link) {

		Node nextItem = BaseDomainVisitor.other(listItem, BaseDomainVisitor.singleIncoming(listItem, link));
		Node prevItem = BaseDomainVisitor.other(listItem, BaseDomainVisitor.singleOutgoing(listItem, link));

		// single element
		if (nextItem == null && prevItem == null) {
			BaseDomainVisitor.outgoing(BaseDomainVisitor.other(listItem, BaseDomainVisitor.singleIncoming(listItem, first)), first).forEach(Relationship::delete);
			BaseDomainVisitor.outgoing(BaseDomainVisitor.other(listItem, BaseDomainVisitor.singleIncoming(listItem, last)), last).forEach(Relationship::delete);

			deleteNode(listItem);
			return;
		}

		// last in list
		if (nextItem == null) {
			Node source = BaseDomainVisitor.other(listItem, BaseDomainVisitor.singleIncoming(listItem, last));
			BaseDomainVisitor.outgoing(source, last).forEach(Relationship::delete);

			source.createRelationshipTo(prevItem, last);

			deleteNode(listItem);
			return;
		}

		// first in list
		if (prevItem == null) {
			Node source = BaseDomainVisitor.other(listItem, BaseDomainVisitor.singleIncoming(listItem, first));
			BaseDomainVisitor.outgoing(source, first).forEach(Relationship::delete);

			source.createRelationshipTo(nextItem, first);

			deleteNode(listItem);
			return;
		}

		// between first and last
		BaseDomainVisitor.outgoing(prevItem, link).forEach(Relationship::delete);

		prevItem.createRelationshipTo(nextItem, link);

		deleteNode(listItem);
	}

	private static void deleteNode(Node node) {
		if (node == null) return;

		for (Relationship relationship : node.getRelationships())
			relationship.delete();

		node.delete();
	}
}
