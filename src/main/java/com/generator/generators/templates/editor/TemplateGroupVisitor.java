package com.generator.generators.templates.editor;

import com.generator.editors.BaseDomainVisitor;
import com.generator.editors.NeoModel;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;

import static com.generator.editors.BaseDomainVisitor.*;
import static com.generator.editors.BaseDomainVisitor.get;
import static com.generator.editors.BaseDomainVisitor.getString;
import static com.generator.generators.templates.editor.TemplateDomain.TemplateLabels.TemplateGroup;
import static com.generator.generators.templates.editor.TemplateDomain.TemplateLabels.TemplateStatement;
import static com.generator.generators.templates.editor.TemplateDomain.TemplateRelations.STATEMENT_PARAMETER;
import static com.generator.generators.templates.editor.TemplateDomain.TemplateRelations.TEMPLATE_GROUP;
import static com.generator.generators.templates.editor.TemplateDomain.TemplateRelations.TEMPLATE_PARAMETER;

/**
 * goe on 12/29/16.
 */
public class TemplateGroupVisitor {

    final void visitTemplateGroup(Node templateGroup) {

        if (!hasLabel(templateGroup, TemplateGroup.name()))
            throw new IllegalArgumentException(NeoModel.getNameOrLabelFrom(templateGroup) + " is not a " + TemplateGroup.name());

        onTemplateGroupStart(get(templateGroup, TemplateDomain.TemplateProperties.name.name()), get(templateGroup, TemplateDomain.TemplateProperties.delimiter.name()), templateGroup);

        for (Relationship relationship : incoming(templateGroup, TEMPLATE_GROUP))
            visitTemplateStatement(other(templateGroup, relationship));

        onTemplateGroupEnd();
    }

    final void visitTemplateStatement(Node templateStatement) {

        if (!hasLabel(templateStatement, TemplateStatement.name()))
            throw new IllegalArgumentException(NeoModel.getNameOrLabelFrom(templateStatement) + " is not a " + TemplateStatement.name());

        onTemplateStatementStart(get(templateStatement, TemplateDomain.TemplateProperties.name.name()).toString(), get(templateStatement, TemplateDomain.TemplateProperties.text.name()).toString(), templateStatement);

        for (Relationship parameterRelationship : incoming(templateStatement, TEMPLATE_PARAMETER)) {
            final Node templateParameter = other(templateStatement, parameterRelationship);
            onTemplateParameterStart(getString(templateParameter, TemplateDomain.TemplateProperties.name.name()));
            switch (TemplateDomain.TemplateLabels.valueOf(getString(parameterRelationship, TemplateDomain.TemplateProperties.relationType.name()))) {

                case SingleTemplateParameter:
                    // use this to check if templateParameter is statement-parameter
                    //final Relationship statementParameterRelation = BaseDomainVisitor.singleOutgoing(templateParameter, STATEMENT_PARAMETER);
                    onSingleTemplateParameter(get(templateParameter, TemplateDomain.TemplateProperties.name.name()), templateParameter);
                    break;

                case ListTemplateParameter:
                    onListTemplateParameter(get(templateParameter, TemplateDomain.TemplateProperties.name.name()), templateParameter);
                    break;

                case KeyValueTemplateParameter:
                    onKeyValueTemplateParameter(get(templateParameter, TemplateDomain.TemplateProperties.name.name()), get(templateParameter, TemplateDomain.TemplateProperties.keys.name()), templateParameter);
                    break;
            }
            onTemplateParameterEnd(getString(templateParameter, TemplateDomain.TemplateProperties.name.name()));
        }

        onTemplateStatementEnd(get(templateStatement, TemplateDomain.TemplateProperties.name.name()).toString(), get(templateStatement, TemplateDomain.TemplateProperties.text.name()), templateStatement);
    }

    protected void onTemplateGroupStart(String name, String delimiter, Node templateGroup) {
    }

    protected void onTemplateStatementStart(String name, String text, Node templateStatement) {
    }

    protected void onTemplateParameterStart(String name) {
    }

    protected void onTemplateParameterEnd(String name) {
    }

    protected void onSingleTemplateParameter(String name, Node parameterNode) {
    }

    protected void onListTemplateParameter(String name, Node parameterNode) {
    }

    protected void onKeyValueTemplateParameter(String name, String keys, Node parameterNode) {
    }

    protected void onTemplateStatementEnd(String name, String text, Node templateStatement) {
    }

    protected void onTemplateGroupEnd() {
    }
}
