package com.generator.generators.templates;

import com.generator.generators.templatesNeo.TemplatesNeoGroup;

/**
 * goe on 10/1/16.
 */
public class TemplateNeoGeneratorNeo extends TemplateVisitorNeo<TemplatesNeoGroup.NeoGroupClassDeclarationST> {

	private final TemplatesNeoGroup group = new TemplatesNeoGroup();

	// onTemplateGroup
	private String groupName;
	private TemplatesNeoGroup.NeoGroupClassDeclarationST groupClassDeclaration;

	// on TemplateStatement
	private String statementName;
	private TemplatesNeoGroup.declarationST declarationST;
	private TemplatesNeoGroup.newInstanceST newInstanceST;

	@Override
	protected void onTemplateGroup(TemplatesNeo.TemplateGroupNode templateGroupNode) {

		groupName = getStringNodeValue(templateGroupNode.getName());

		groupClassDeclaration = group.newNeoGroupClassDeclaration().
			setName(getStringNodeValue(templateGroupNode.getName())).
			setPackageName(getStringNodeValue(templateGroupNode.getPackage()));
	}

	@Override
	protected void onTemplateStatement(TemplatesNeo.TemplateStatementNode statementNode) {

		statementName = getStringNodeValue(statementNode.getName());

		declarationST = group.newdeclaration().
			setGroupName(groupName).
			setName(statementName);

		newInstanceST = group.newnewInstance().
			setName(statementName).
			setGroupName(groupName);
	}

	@Override
	protected void onStringTemplateParameter(TemplatesNeo.StringTemplateParameterNode stringTemplateParameterNode) {

		final String parameterName = getStringNodeValue(stringTemplateParameterNode.getName());

		final TemplatesNeoGroup.stringSetterST setter = group.newstringSetter().
			setPropertyName(parameterName).
			setStatementName(statementName);

		declarationST.addPropertiesValue(parameterName, null, setter);
	}

	@Override
	protected void onBooleanTemplateParameter(TemplatesNeo.BooleanTemplateParameterNode booleanTemplateParameterNode) {

		final String parameterName = getStringNodeValue(booleanTemplateParameterNode.getName());

		final TemplatesNeoGroup.stringSetterST setter = group.newstringSetter().
			setPropertyName(parameterName).
			setStatementName(statementName);

		declarationST.addPropertiesValue(parameterName, null, setter);
	}

	@Override
	protected void onListTemplateParameter(TemplatesNeo.ListTemplateParameterNode listTemplateParameterNode) {

		final String parameterName = getStringNodeValue(listTemplateParameterNode.getName());

		final TemplatesNeoGroup.listSetterST setter = group.newlistSetter().
			setPropertyName(parameterName).
			setStatementName(statementName);

		declarationST.addPropertiesValue(parameterName, null, setter);
	}

	@Override
	protected void onKeyValueListTemplateParameter(TemplatesNeo.KeyValueListTemplateParameterNode keyValueListTemplateParameterNode) {

		final String parameterName = getStringNodeValue(keyValueListTemplateParameterNode.getName());

		final TemplatesNeoGroup.keyValueListSetterST setter = group.newkeyValueListSetter().
			setPropertyName(parameterName).
			setStatementName(statementName);

		// nb: assumes all keyvalues are stringNodeValues. If other types of nodes, this needs to be fixed:
		keyValueListTemplateParameterNode.forEachKvNames(node -> setter.addKvNamesValue(getStringNodeValue(node)));

		final TemplatesNeoGroup.keyValueRelationshipsST relationshipsST = group.newkeyValueRelationships().
			setName(parameterName);

		// nb: assumes all keyvalues are stringNodeValues. If other types of nodes, this needs to be fixed:
		keyValueListTemplateParameterNode.forEachKvNames(node -> relationshipsST.addTypesValue(getStringNodeValue(node)));

		declarationST.addPropertiesValue(parameterName, relationshipsST, setter);
	}

	@Override
	protected void onStatementTemplateParameter(TemplatesNeo.StatementTemplateParameterNode statementTemplateParameterNode) {

		final String parameterName = getStringNodeValue(statementTemplateParameterNode.getName());

		final TemplatesNeoGroup.stringSetterST setter = group.newstringSetter().
			setPropertyName(parameterName).
			setStatementName(statementName);

		declarationST.addPropertiesValue(parameterName, null, setter);
	}

	@Override
	protected void onTemplateStatementEnd(TemplatesNeo.TemplateStatementNode statementNode) {
		groupClassDeclaration.addStatementsValue(declarationST, statementName, newInstanceST);
	}

	@Override
	protected TemplatesNeoGroup.NeoGroupClassDeclarationST onTemplateGroupEnd(TemplatesNeo.TemplateGroupNode templateGroupNode) {
		return groupClassDeclaration;
	}
}