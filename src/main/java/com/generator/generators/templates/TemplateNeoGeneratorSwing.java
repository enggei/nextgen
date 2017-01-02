package com.generator.generators.templates;

import com.generator.generators.templatesSwing.TemplatesSwingGroup;

/**
 * goe on 10/1/16.
 */
public class TemplateNeoGeneratorSwing extends TemplateVisitorNeo<TemplatesSwingGroup.TemplatesSwingST> {

	private final TemplatesSwingGroup group = new TemplatesSwingGroup();

	// onTemplateGroup
	private String groupName;
	private TemplatesSwingGroup.CanvasListenerST canvasListenerST;
	private TemplatesSwingGroup.TemplatesSwingST swingST;
	private TemplatesSwingGroup.TemplateGroupActionsST groupActionsST;

	// onTemplateStatement
	private TemplatesSwingGroup.statementActionsST canvasActionsST;
	private String statementName;

	@Override
	protected void onTemplateGroup(TemplatesNeo.TemplateGroupNode templateGroupNode) {

		groupName = getStringNodeValue(templateGroupNode.getName());

		canvasListenerST = group.newCanvasListener().
			setGroupName(groupName);

		swingST = group.newTemplatesSwing().
			setPackageName(getStringNodeValue(templateGroupNode.getPackage())).
			setGroupName(groupName);


		groupActionsST = group.newTemplateGroupActions().
			setName(groupName).
			setPackageName(getStringNodeValue(templateGroupNode.getPackage()));

	}

	@Override
	protected void onTemplateStatement(TemplatesNeo.TemplateStatementNode statementNode) {

		statementName = getStringNodeValue(statementNode.getName());

		canvasActionsST = group.newstatementActions().
			setGroupName(groupName).
			setName(statementName);

		final TemplatesSwingGroup.newActionST newActionST = group.newnewAction().
			setGroupName(groupName).
			setName(statementName);

		swingST.addStatementsValue(statementName, newActionST);
	}

	@Override
	protected void onStringTemplateParameter(TemplatesNeo.StringTemplateParameterNode stringTemplateParameterNode) {

		final String parameterName = getStringNodeValue(stringTemplateParameterNode.getName());

		final TemplatesSwingGroup.setStringActionST setStringActionST = group.newsetStringAction().
			setGroupName(groupName).
			setStatement(statementName).
			setName(parameterName);

		canvasActionsST.addActionsValue(setStringActionST);
	}

	@Override
	protected void onBooleanTemplateParameter(TemplatesNeo.BooleanTemplateParameterNode booleanTemplateParameterNode) {

		final String parameterName = getStringNodeValue(booleanTemplateParameterNode.getName());

		final TemplatesSwingGroup.setStringActionST setStringActionST = group.newsetStringAction().
			setGroupName(groupName).
			setStatement(statementName).
			setName(parameterName);

		canvasActionsST.addActionsValue(setStringActionST);
	}

	@Override
	protected void onListTemplateParameter(TemplatesNeo.ListTemplateParameterNode listTemplateParameterNode) {

		final String parameterName = getStringNodeValue(listTemplateParameterNode.getName());

		final TemplatesSwingGroup.addListActionST addListActionST = group.newaddListAction().
			setGroupName(groupName).
			setStatement(statementName).
			setName(parameterName);

		canvasActionsST.addActionsValue(addListActionST);
	}

	@Override
	protected void onKeyValueListTemplateParameter(TemplatesNeo.KeyValueListTemplateParameterNode keyValueListTemplateParameterNode) {

	}

	@Override
	protected void onStatementTemplateParameter(TemplatesNeo.StatementTemplateParameterNode statementTemplateParameterNode) {

		final String parameterName = getStringNodeValue(statementTemplateParameterNode.getName());

		final TemplatesSwingGroup.setStringActionST setStringActionST = group.newsetStringAction().
			setGroupName(groupName).
			setStatement(statementName).
			setName(parameterName);

		canvasActionsST.addActionsValue(setStringActionST);
	}

	@Override
	protected void onTemplateStatementEnd(TemplatesNeo.TemplateStatementNode statementNode) {
		canvasListenerST.addStatementsValue(canvasActionsST);
	}

	@Override
	protected TemplatesSwingGroup.TemplatesSwingST onTemplateGroupEnd(TemplatesNeo.TemplateGroupNode templateGroupNode) {

		System.out.println(groupActionsST);

		return swingST;
	}
}