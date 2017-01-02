package com.generator.generators.templates;

import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;

/**
 * goe on 10/1/16.
 */
public abstract class TemplateVisitorNeo<G> implements TemplatesNeo.TemplateGroupNode.TemplateGroupNodeVisitor<G>, TemplatesNeo.TemplateStatementNode.TemplateStatementNodeVisitor<Void> {

	@Override
	public final G visit(TemplatesNeo.TemplateGroupNode templateGroupNode) {

		onTemplateGroup(templateGroupNode);

		templateGroupNode.forEachTemplateStatements(node -> visit(TemplatesNeo.newTemplateStatement(node)));

		return onTemplateGroupEnd(templateGroupNode);
	}

	@Override
	public final Void visit(TemplatesNeo.TemplateStatementNode statementNode) {
		onTemplateStatement(statementNode);

		statementNode.forEachTemplateParameters(node -> {

			if (TemplatesNeo.isStringTemplateParameter(node)) {
				TemplatesNeo.newStringTemplateParameter(node).visit(stringTemplateParameterNode -> {

					onStringTemplateParameter(stringTemplateParameterNode);

					return null;
				});

			} else if (TemplatesNeo.isBooleanTemplateParameter(node)) {
				TemplatesNeo.newBooleanTemplateParameter(node).visit(booleanTemplateParameterNode -> {

					onBooleanTemplateParameter(booleanTemplateParameterNode);

					return null;
				});

			} else if (TemplatesNeo.isListTemplateParameter(node)) {
				TemplatesNeo.newListTemplateParameter(node).visit(listTemplateParameterNode -> {

					onListTemplateParameter(listTemplateParameterNode);

					return null;
				});

			} else if (TemplatesNeo.isKeyValueListTemplateParameter(node)) {
				TemplatesNeo.newKeyValueListTemplateParameter(node).visit(keyValueListTemplateParameterNode -> {

					onKeyValueListTemplateParameter(keyValueListTemplateParameterNode);

					return null;
				});


			} else if (TemplatesNeo.isTemplateStatement(node)) {
				TemplatesNeo.newStatementTemplateParameter(node).visit(statementTemplateParameterNode -> {

					onStatementTemplateParameter(statementTemplateParameterNode);

					return null;
				});
			}
		});

		onTemplateStatementEnd(statementNode);

		return null;
	}

	protected void onTemplateGroup(TemplatesNeo.TemplateGroupNode templateGroupNode) {

	}

	protected void onTemplateStatement(TemplatesNeo.TemplateStatementNode statementNode) {

	}

	protected void onStringTemplateParameter(TemplatesNeo.StringTemplateParameterNode stringTemplateParameterNode) {

	}

	protected void onBooleanTemplateParameter(TemplatesNeo.BooleanTemplateParameterNode booleanTemplateParameterNode) {

	}

	protected void onListTemplateParameter(TemplatesNeo.ListTemplateParameterNode listTemplateParameterNode) {

	}

	protected void onKeyValueListTemplateParameter(TemplatesNeo.KeyValueListTemplateParameterNode keyValueListTemplateParameterNode) {

	}

	protected void onStatementTemplateParameter(TemplatesNeo.StatementTemplateParameterNode statementTemplateParameterNode) {

	}

	protected void onTemplateStatementEnd(TemplatesNeo.TemplateStatementNode statementNode) {

	}

	protected G onTemplateGroupEnd(TemplatesNeo.TemplateGroupNode templateGroupNode) {
		return null;
	}

	// convenience method for getting value from StringNode
	protected String getStringNodeValue(Node node) {
		if (TemplatesNeo.isStringNode(node)) return TemplatesNeo.newStringNode(node).getValue();
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