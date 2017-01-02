package com.generator.generators.templates;

import com.generator.generators.templateGroup.TemplateGroupGroup;

/**
 * goe on 9/30/16.
 */
public class TemplateNeoGeneratorGroup extends TemplateVisitorNeo<TemplateGroupGroup.GroupClassDeclarationST> {

	private final TemplateGroupGroup group = new TemplateGroupGroup();

	// onTemplateGroup
	private String groupName;
	private TemplateGroupGroup.GroupClassDeclarationST groupClassDeclaration;

	// onTemplateStatement
	private String statementName;
	private TemplateGroupGroup.NewStatementDeclarationST newStatementDeclarationST;
	private TemplateGroupGroup.NewStatementInstanceST newStatementInstanceST;

	@Override
	protected void onTemplateGroup(TemplatesNeo.TemplateGroupNode templateGroupNode) {

		groupName = getStringNodeValue(templateGroupNode.getName()) + "Group";

		groupClassDeclaration = group.newGroupClassDeclaration().
			setName(groupName).
			setDomain(groupName).
			setPackageName(getStringNodeValue(templateGroupNode.getPackage()));
	}

	@Override
	protected void onTemplateStatement(TemplatesNeo.TemplateStatementNode statementNode) {

		statementName = getStringNodeValue(statementNode.getName());
		
		newStatementDeclarationST = group.newNewStatementDeclaration().
			setName(statementName).
			setGroupname(groupName);

		newStatementInstanceST = group.newNewStatementInstance().
			setName(statementName);
	}

	@Override
	protected void onStringTemplateParameter(TemplatesNeo.StringTemplateParameterNode stringTemplateParameterNode) {
		
		final String parameterName = getStringNodeValue(stringTemplateParameterNode.getName());

		final TemplateGroupGroup.StatementStringPropertySetterST statementStringPropertySetterST = group.newStatementStringPropertySetter().
			setStatementName(statementName).
			setPropertyName(parameterName);

		newStatementDeclarationST.addPropertiesValue(parameterName, statementStringPropertySetterST);
	}

	@Override
	protected void onBooleanTemplateParameter(TemplatesNeo.BooleanTemplateParameterNode booleanTemplateParameterNode) {

		final String parameterName = getStringNodeValue(booleanTemplateParameterNode.getName());

		final TemplateGroupGroup.StatementStringPropertySetterST statementStringPropertySetterST = group.newStatementStringPropertySetter().
			setStatementName(statementName).
			setPropertyName(parameterName);

		newStatementDeclarationST.addPropertiesValue(parameterName, statementStringPropertySetterST);
	}

	@Override
	protected void onListTemplateParameter(TemplatesNeo.ListTemplateParameterNode listTemplateParameterNode) {

		final String parameterName = getStringNodeValue(listTemplateParameterNode.getName());

		final TemplateGroupGroup.StatementListPropertySetterST statementListPropertySetterST = group.newStatementListPropertySetter().
			setPropertyName(parameterName).
			setStatementName(statementName);

		newStatementDeclarationST.addPropertiesValue(parameterName, statementListPropertySetterST);
	}

	@Override
	protected void onKeyValueListTemplateParameter(TemplatesNeo.KeyValueListTemplateParameterNode keyValueListTemplateParameterNode) {

		final String parameterName = getStringNodeValue(keyValueListTemplateParameterNode.getName());

		final TemplateGroupGroup.StatementKeyValueListPropertySetterST statementKeyValueListPropertySetterST = group.newStatementKeyValueListPropertySetter().
			setPropertyName(parameterName).
			setStatementName(statementName);

		keyValueListTemplateParameterNode.forEachKvNames(kvNode -> statementKeyValueListPropertySetterST.addKvNamesValue(getStringNodeValue(kvNode)));

		newStatementDeclarationST.addPropertiesValue(parameterName, statementKeyValueListPropertySetterST);
	}

	@Override
	protected void onStatementTemplateParameter(TemplatesNeo.StatementTemplateParameterNode statementTemplateParameterNode) {

		final String parameterName = getStringNodeValue(statementTemplateParameterNode.getName());

		final TemplateGroupGroup.StatementStringPropertySetterST statementStringPropertySetterST = group.newStatementStringPropertySetter().
			setStatementName(statementName).
			setPropertyName(parameterName);

		newStatementDeclarationST.addPropertiesValue(parameterName, statementStringPropertySetterST);
	}

	@Override
	protected void onTemplateStatementEnd(TemplatesNeo.TemplateStatementNode statementNode) {
		groupClassDeclaration.addStatementsValue(newStatementDeclarationST, newStatementInstanceST);
	}

	@Override
	protected TemplateGroupGroup.GroupClassDeclarationST onTemplateGroupEnd(TemplatesNeo.TemplateGroupNode templateGroupNode) {
		return groupClassDeclaration;
	}
}