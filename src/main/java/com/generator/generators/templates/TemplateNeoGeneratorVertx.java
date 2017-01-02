package com.generator.generators.templates;

import com.generator.generators.templatesVertx.TemplatesVertxGroup;

/**
 * goe on 10/1/16.
 */
public class TemplateNeoGeneratorVertx extends TemplateVisitorNeo<TemplatesVertxGroup.GroupVerticleFactoryST> {

	private final TemplatesVertxGroup group = new TemplatesVertxGroup();

	// onTemplateGroup
	private String groupName;
	private TemplatesVertxGroup.GroupVerticleFactoryST groupVerticleFactoryST;

	// onTemplateStatement
	private String statementName;
	private TemplatesVertxGroup.verticleDeclarationST verticleDeclarationST;
	private TemplatesVertxGroup.newVerticleInstanceST newVerticleInstanceST;

	@Override
	protected void onTemplateGroup(TemplatesNeo.TemplateGroupNode templateGroupNode) {

		groupName = getStringNodeValue(templateGroupNode.getName());

		groupVerticleFactoryST = group.newGroupVerticleFactory().
			setGroupName(groupName).
			setPackageName(getStringNodeValue(templateGroupNode.getPackage()));
	}

	@Override
	protected void onTemplateStatement(TemplatesNeo.TemplateStatementNode statementNode) {

		statementName = getStringNodeValue(statementNode.getName());

		verticleDeclarationST = group.newverticleDeclaration().
			setName(statementName).
			setGroupName(groupName);

		newVerticleInstanceST = group.newnewVerticleInstance().
			setName(statementName);
	}

	@Override
	protected void onStringTemplateParameter(TemplatesNeo.StringTemplateParameterNode stringTemplateParameterNode) {

		final String parameterName = getStringNodeValue(stringTemplateParameterNode.getName());

		final TemplatesVertxGroup.SendMessageST sendToMessage_ = group.newSendMessage().
			setName(parameterName);

		final TemplatesVertxGroup.ConsumeStringMessageST consumeMessage_ = group.newConsumeStringMessage().
			setStatement(statementName).
			setName(parameterName);

		verticleDeclarationST.addMessagesValue(consumeMessage_, sendToMessage_);
	}

	@Override
	protected void onBooleanTemplateParameter(TemplatesNeo.BooleanTemplateParameterNode booleanTemplateParameterNode) {

		final String parameterName = getStringNodeValue(booleanTemplateParameterNode.getName());

		final TemplatesVertxGroup.SendMessageST sendToMessage_ = group.newSendMessage().
			setName(parameterName);

		final TemplatesVertxGroup.ConsumeStringMessageST consumeMessage_ = group.newConsumeStringMessage().
			setStatement(statementName).
			setName(parameterName);

		verticleDeclarationST.addMessagesValue(consumeMessage_, sendToMessage_);
	}

	@Override
	protected void onListTemplateParameter(TemplatesNeo.ListTemplateParameterNode listTemplateParameterNode) {

		final String parameterName = getStringNodeValue(listTemplateParameterNode.getName());

		final TemplatesVertxGroup.AddMessageST sendToMessage_ = group.newAddMessage().
			setName(parameterName);

		final TemplatesVertxGroup.ConsumeListMessageST consumeMessage_ = group.newConsumeListMessage().
			setStatement(statementName).
			setName(parameterName);

		verticleDeclarationST.addMessagesValue(consumeMessage_, sendToMessage_);
	}

	@Override
	protected void onKeyValueListTemplateParameter(TemplatesNeo.KeyValueListTemplateParameterNode keyValueListTemplateParameterNode) {

		final String parameterName = getStringNodeValue(keyValueListTemplateParameterNode.getName());

		final TemplatesVertxGroup.AddMessageST sendToMessage_ = group.newAddMessage().
			setName(parameterName);

		final TemplatesVertxGroup.ConsumeKeyValueListMessageST consumeMessage_ = group.newConsumeKeyValueListMessage().
			setStatement(statementName).
			setName(parameterName);

		keyValueListTemplateParameterNode.forEachKvNames(node -> {
			consumeMessage_.addParametersValue(getStringNodeValue(node));
			sendToMessage_.addParametersValue(getStringNodeValue(node));
		});

		verticleDeclarationST.addMessagesValue(consumeMessage_, sendToMessage_);
	}

	@Override
	protected void onStatementTemplateParameter(TemplatesNeo.StatementTemplateParameterNode statementTemplateParameterNode) {

		final String parameterName = getStringNodeValue(statementTemplateParameterNode.getName());

		final TemplatesVertxGroup.SendMessageST sendToMessage_ = group.newSendMessage().
			setName(parameterName);

		final TemplatesVertxGroup.ConsumeStringMessageST consumeMessage_ = group.newConsumeStringMessage().
			setStatement(statementName).
			setName(parameterName);

		verticleDeclarationST.addMessagesValue(consumeMessage_, sendToMessage_);
	}

	@Override
	protected void onTemplateStatementEnd(TemplatesNeo.TemplateStatementNode statementNode) {
		groupVerticleFactoryST.addVerticlesValue(verticleDeclarationST, statementName, newVerticleInstanceST);
	}

	@Override
	protected TemplatesVertxGroup.GroupVerticleFactoryST onTemplateGroupEnd(TemplatesNeo.TemplateGroupNode templateGroupNode) {
		return groupVerticleFactoryST;
	}
}