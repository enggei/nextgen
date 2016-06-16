package com.generator.editors.graph;

import com.generator.editors.domain.MetaNode;
import com.generator.editors.domain.NeoModel;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

/**
 * goe on 5/12/15.
 * todo: graphnode is base for many forms of rendering-shapes (e.g. ProtobufMessage should render as envelope, and having its fields inside))
 * Use Parser-BNF renderer (Composite with buffering as pattern)
 */
public class GraphNode<E extends Enum<E>> {

	protected final Node node;
	protected final UUID uuid;
	private final MetaNode<E> metaNode;

	protected final Set<GraphRelation> outgoing = new LinkedHashSet<>();  // should this be Other GraphNodes ?
	protected final Set<GraphRelation> incoming = new LinkedHashSet<>();

	public GraphNode(Node node, MetaNode<E> metaNode) {
		this.node = node;
		this.uuid = NeoModel.uuidOf(node);
		this.metaNode = metaNode;
	}

	public Node node() {
		return node;
	}

	public MetaNode<E> getMetaNode() {
		return metaNode;
	}

	public UUID uuid() {
		return uuid;
	}

	public void updated(String property, String value) {
		System.out.println("property = " + property + ", value = " + value);
		// override this to update graph-nodes if required
	}

//    public Set<String> allProperties() {
//        final Set<String> set = new TreeSet<>();
//        for (String propertyKey : node.getPropertyKeys()) {
//            if (NeoModel.TAG_UUID.equals(propertyKey)) continue;  // nb do not include uuid - keep it 'invisible'
//            set.add(propertyKey);
//        }
//        return set;
//    }
//
//    public Set<String> allLabels() {
//        final Set<String> set = new TreeSet<>();
//        for (org.neo4j.graphdb.Label label : node.getLabels())
//            set.add(label.name());
//        return set;
//    }

	public GraphNode removeOutgoing(Relationship relationship) {
		GraphRelation found = null;
		for (GraphRelation graphRelation : outgoing)
			if (graphRelation.is(relationship)) {
				found = graphRelation;
				break;
			}

		if (found != null)
			this.outgoing.remove(found);

		return this;
	}

	public GraphNode removeIncoming(Relationship relationship) {
		GraphRelation found = null;
		for (GraphRelation graphRelation : incoming)
			if (graphRelation.is(relationship)) {
				found = graphRelation;
				break;
			}

		if (found != null)
			this.incoming.remove(found);

		return this;
	}

	@SuppressWarnings("unchecked")
	public GraphNode remove() {

		for (GraphRelation graphRelation : outgoing)
			graphRelation.getOther(this).incoming.remove(graphRelation);
		outgoing.clear();

		for (GraphRelation graphRelation : incoming)
			graphRelation.getOther(this).outgoing.remove(graphRelation);
		incoming.clear();

		return this;
	}

	public Set<GraphRelation> getOutgoing() {
		return outgoing;
	}

	public Set<GraphRelation> getIncoming() {
		return incoming;
	}

	public void addOutgoing(GraphRelation graphRelation) {
		for (GraphRelation shortestPathGraphRelation : outgoing) {
			if (shortestPathGraphRelation.equals(graphRelation)) {
				shortestPathGraphRelation.update(graphRelation);
				return;
			}
		}

		this.outgoing.add(graphRelation);
	}

	public void addIncoming(GraphRelation graphRelation) {
		for (GraphRelation shortestPathGraphRelation : incoming) {
			if (shortestPathGraphRelation.equals(graphRelation)) {
				shortestPathGraphRelation.update(graphRelation);
				return;
			}
		}

		this.incoming.add(graphRelation);
	}
}