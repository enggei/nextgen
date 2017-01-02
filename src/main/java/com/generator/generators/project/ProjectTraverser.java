package com.generator.generators.project;

import com.generator.generators.templates.TemplatesNeo;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;

public abstract class ProjectTraverser<G> {

	public abstract G visit(TemplatesNeo.TemplateGroupNode templateGroupNode);

	// convenience method for getting value from StringNode
	protected String getStringNodeValue(Node node) {
		if (ProjectNeo.isStringNode(node)) return ProjectNeo.newStringNode(node).getValue();
		// add other cases here ? if this only covers node-types in TemplatesNeo, I can do it all here (and recursive render all values)
		throw new IllegalArgumentException("node " + node.getProperty("_uuid") + " is not a StringNode. Please handle node as one of (" + getLabelsFrom(node) + ")");
	}

	protected static String getLabelsFrom(Node node) {
		final StringBuilder out = new StringBuilder();
		boolean first = true;
		for (Label label : node.getLabels()) {
			if (!first) out.append(", ");
			out.append(label.name());
			first = false;
		}
		return out.toString();
	}
} 