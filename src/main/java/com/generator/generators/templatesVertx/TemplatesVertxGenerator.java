package com.generator.generators.templatesVertx;

import com.generator.generators.templates.TemplateVisitor;
import com.generator.generators.templates.domain.TemplateParameter;
import com.generator.generators.templates.domain.TemplateStatement;
import com.generator.util.FileUtil;
import com.generator.util.StringUtil;

import java.io.File;

import static com.generator.generators.templates.domain.GeneratedFile.packageToPath;

/**
 * goe on 8/25/16.
 */
public class TemplatesVertxGenerator implements TemplateVisitor {

	private final String root;
	private final String packageName;
	private final TemplatesVertxGroup group = new TemplatesVertxGroup();

	private File groupTemplateFile;
	private TemplatesVertxGroup.GroupVerticleFactoryST easyFlowVerticles;
	private String statementName;
	private TemplatesVertxGroup.verticleDeclarationST verticleDeclarationST;

	public TemplatesVertxGenerator(String root, String packageName) {
		this.root = root;
		this.packageName = packageName;
	}

	@Override
	public void onStartGroupTemplateFile(File groupTemplateFile) {

		this.groupTemplateFile = groupTemplateFile;

		easyFlowVerticles = group.newGroupVerticleFactory().
			setGroupName(getGroupName()).
			setPackageName(packageName);
	}

	@Override
	public void onStartStatement(TemplateStatement statement) {

		statementName = statement.getName();

		verticleDeclarationST = group.newverticleDeclaration().
			setName(statementName).
			setGroupName(getGroupName());
	}

	@Override
	public void onStartTemplateParameter(TemplateParameter parameter, TemplateStatement statement) {

	}

	@Override
	public void onKeyValueTemplateParameter(TemplateParameter templateParameter, TemplateStatement statement) {
		final TemplatesVertxGroup.AddMessageST sendToMessage_ = group.newAddMessage().
			setName(templateParameter.getPropertyName());

		final TemplatesVertxGroup.ConsumeKeyValueListMessageST consumeMessage_ = group.newConsumeKeyValueListMessage().
			setStatement(statementName).
			setName(templateParameter.getPropertyName());

		for (String kvName : templateParameter.getKvNames()) {
			consumeMessage_.addParametersValue(kvName);
			sendToMessage_.addParametersValue(kvName);
		}

		verticleDeclarationST.addMessagesValue(consumeMessage_, sendToMessage_);
	}

	@Override
	public void onStringTemplateParameter(TemplateParameter templateParameter, TemplateStatement statement) {
		final TemplatesVertxGroup.SendMessageST sendToMessage_ = group.newSendMessage().
			setName(templateParameter.getPropertyName());

		final TemplatesVertxGroup.ConsumeStringMessageST consumeMessage_ = group.newConsumeStringMessage().
			setStatement(statementName).
			setName(templateParameter.getPropertyName());

		verticleDeclarationST.addMessagesValue(consumeMessage_, sendToMessage_);
	}

	@Override
	public void onBooleanTemplateParameter(TemplateParameter templateParameter, TemplateStatement statement) {
		onStringTemplateParameter(templateParameter, statement);
	}

	@Override
	public void onStatementTemplateParameter(TemplateParameter templateParameter, TemplateStatement statement) {
		onStringTemplateParameter(templateParameter, statement);
	}

	@Override
	public void onListTemplateParameter(TemplateParameter templateParameter, TemplateStatement statement) {
		final TemplatesVertxGroup.AddMessageST sendToMessage_ = group.newAddMessage().
			setName(templateParameter.getPropertyName());

		final TemplatesVertxGroup.ConsumeListMessageST consumeMessage_ = group.newConsumeListMessage().
			setStatement(statementName).
			setName(templateParameter.getPropertyName());

		verticleDeclarationST.addMessagesValue(consumeMessage_, sendToMessage_);
	}

	@Override
	public void onEndTemplateParameter(TemplateParameter templateParameter, TemplateStatement statement) {

	}

	@Override
	public void onEndStatement(TemplateStatement statement) {
		easyFlowVerticles.addVerticlesValue(verticleDeclarationST, statementName, group.newnewVerticleInstance().setName(statementName));
	}

	@Override
	public void onEndGroupTemplateFile(File groupTemplateFile) {
		FileUtil.write(easyFlowVerticles, new File(root, packageToPath(packageName) + getGroupName() + "Verticles" + ".java"));
	}

	private String getGroupName() {
		return StringUtil.capitalize(groupTemplateFile.getName().substring(0, groupTemplateFile.getName().length() - 4));
	}
}