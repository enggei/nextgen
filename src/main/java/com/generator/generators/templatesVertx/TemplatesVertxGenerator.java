package com.generator.generators.templatesVertx;

import com.generator.generators.templates.domain.GeneratedFile;
import com.generator.generators.templates.domain.TemplateParameter;
import com.generator.generators.templates.domain.TemplateStatement;
import com.generator.generators.templates.parser.TemplateFileParser;
import com.generator.util.FileUtil;
import com.generator.util.StringUtil;

import java.io.File;
import java.util.List;

/**
 * goe on 8/25/16.
 */
public class TemplatesVertxGenerator {

	public void createGroupVerticle(File groupTemplateFile, String packageName, String root) {

		final TemplatesVertxGroup group = new TemplatesVertxGroup();

		final List<TemplateStatement> statements = new TemplateFileParser().parse(groupTemplateFile).getStatements();
		final String groupName = getGroupName(groupTemplateFile);

		final TemplatesVertxGroup.GroupVerticleFactoryST easyFlowVerticles = group.newGroupVerticleFactory().
			setGroupName(groupName).
			setPackageName(packageName);

		for (TemplateStatement statement : statements) {
			final String name = statement.getName();

			final TemplatesVertxGroup.verticleDeclarationST verticleDeclarationST = group.newverticleDeclaration().
				setName(name).
				setGroupName(groupName);

			for (TemplateParameter templateParameter : statement.getParameters()) {
				switch (templateParameter.getDomainEntityType()) {

					case LISTPROPERTY: {

						final TemplatesVertxGroup.AddMessageST sendToMessage_ = group.newAddMessage().
							setName(templateParameter.getPropertyName());

						final TemplatesVertxGroup.ConsumeListMessageST consumeMessage_ = group.newConsumeListMessage().
							setStatement(name).
							setName(templateParameter.getPropertyName());

						for (String kvName : templateParameter.getKvNames())
							sendToMessage_.addParametersValue(kvName);

						verticleDeclarationST.addMessagesValue(consumeMessage_, sendToMessage_);
					}
					break;

					case KEYVALUELISTPROPERTY: {

						final TemplatesVertxGroup.AddMessageST sendToMessage_ = group.newAddMessage().
							setName(templateParameter.getPropertyName());

						final TemplatesVertxGroup.ConsumeKeyValueListMessageST consumeMessage_ = group.newConsumeKeyValueListMessage().
							setStatement(name).
							setName(templateParameter.getPropertyName());

						for (String kvName : templateParameter.getKvNames()) {
							consumeMessage_.addParametersValue(kvName);
							sendToMessage_.addParametersValue(kvName);
						}

						verticleDeclarationST.addMessagesValue(consumeMessage_, sendToMessage_);
					}
					break;

					case BOOLEANPROPERTY:
					case STATEMENTPROPERTY:
					case STRINGPROPERTY: {

						final TemplatesVertxGroup.SendMessageST sendToMessage_ = group.newSendMessage().
							setName(templateParameter.getPropertyName());

						final TemplatesVertxGroup.ConsumeStringMessageST consumeMessage_ = group.newConsumeStringMessage().
							setStatement(name).
							setName(templateParameter.getPropertyName());

						verticleDeclarationST.addMessagesValue(consumeMessage_, sendToMessage_);
					}
					break;
				}
			}

			easyFlowVerticles.addVerticlesValue(verticleDeclarationST, name, group.newnewVerticleInstance().setName(name));
		}

		FileUtil.write(easyFlowVerticles, new File(root, GeneratedFile.packageToPath(packageName, StringUtil.capitalize(groupName) + "Verticles.java")));
	}

	private static String getGroupName(File groupTemplateFile) {
		return StringUtil.capitalize(groupTemplateFile.getName().substring(0, groupTemplateFile.getName().length() - 4));
	}
}