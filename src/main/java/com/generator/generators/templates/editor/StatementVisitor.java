package com.generator.generators.templates.editor;

import com.generator.editors.NeoModel;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;

import static com.generator.editors.BaseDomainVisitor.*;
import static com.generator.editors.BaseDomainVisitor.get;
import static com.generator.editors.BaseDomainVisitor.getString;
import static com.generator.generators.templates.editor.TemplateDomain.TemplateLabels.Statement;
import static com.generator.generators.templates.editor.TemplateDomain.TemplateRelations.TEMPLATE_GROUP;
import static com.generator.generators.templates.editor.TemplateDomain.TemplateRelations.TEMPLATE_PARAMETER;
import static com.generator.generators.templates.editor.TemplateDomain.TemplateRelations.TEMPLATE_STATEMENT;

/**
* goe on 12/29/16.
*/
public class StatementVisitor {

	final void visitStatement(Node statement) {

		if (!hasLabel(statement, Statement.name()))
			throw new IllegalArgumentException(NeoModel.getNameOrLabelFrom(statement) + " is not a " + Statement.name());

		final Node statementTemplate = other(statement, singleOutgoing(statement, TEMPLATE_STATEMENT));
		final Node templateGroup = other(statementTemplate, singleOutgoing(statementTemplate, TEMPLATE_GROUP));

		onStatementStart(statementTemplate, templateGroup);

		for (Relationship templateParameterRelation : incoming(statementTemplate, TEMPLATE_PARAMETER)) {
			final Node templateParameter = other(statementTemplate, templateParameterRelation);

			final RelationshipType parameterName = RelationshipType.withName(get(templateParameter, TemplateDomain.TemplateProperties.name.name()));

			switch (TemplateDomain.TemplateLabels.valueOf(getString(templateParameterRelation, TemplateDomain.TemplateProperties.relationType.name()))) {

				case SingleTemplateParameter: {

					final Relationship relationship = singleOutgoing(statement, parameterName);
					final Node value = other(statement, relationship);
					if (value == null) continue;

					onSingleValue(parameterName.name(), other(statement, relationship), TemplateDomain.TemplateLabels.valueOf(getString(relationship, TemplateDomain.TemplateProperties.relationType.name())));
					break;
				}
				case ListTemplateParameter: {

					for (Relationship relationship : outgoing(statement, parameterName))
						onListValue(parameterName.name(), other(statement, relationship), TemplateDomain.TemplateLabels.valueOf(getString(relationship, TemplateDomain.TemplateProperties.relationType.name())));
					break;
				}
				case KeyValueTemplateParameter: {

					for (Relationship relationship : outgoing(statement, parameterName)) {
						final Node kvSet = other(statement, relationship);

						onStartKeyValueSet(parameterName.name(), kvSet);

						for (String key : getString(templateParameter, TemplateDomain.TemplateProperties.keys.name()).split(" ")) {
							final Relationship kvRelation = singleOutgoing(kvSet, RelationshipType.withName(key));
							if (kvRelation == null) continue;

							final Node kvValue = other(kvSet, kvRelation);
							onKeyValue(key, kvValue, TemplateDomain.TemplateLabels.valueOf(getString(kvRelation, TemplateDomain.TemplateProperties.relationType.name())));
						}

						onEndKeyValueSet(kvSet);
					}
					break;
				}
			}
		}

		onStatementEnd();
	}

	protected void onStatementStart(Node statementTemplate, Node templateGroup) {
	}

	protected void onSingleValue(String name, Node referenceNode, TemplateDomain.TemplateLabels referenceNodeType) {
	}

	protected void onListValue(String name, Node referenceNode, TemplateDomain.TemplateLabels referenceNodeType) {
	}

	protected void onStartKeyValueSet(String name, Node kvNode) {
	}

	protected void onKeyValue(String name, Node referenceNode, TemplateDomain.TemplateLabels referenceNodeType) {
	}

	protected void onEndKeyValueSet(Node kvNode) {
	}

	protected void onStatementEnd() {
	}
}
