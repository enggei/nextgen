package com.generator.generators.templateGroup;

import com.generator.generators.generatorDomain.GeneratorDomainGroup;
import com.generator.generators.templates.domain.TemplateParameter;
import com.generator.generators.templates.domain.TemplateStatement;
import com.generator.generators.templates.parser.TemplateFileParser;
import com.generator.generators.templatesNeo.TemplatesNeoGroup;
import com.generator.generators.templatesSwing.TemplatesSwingGroup;
import com.generator.generators.templatesVertx.TemplatesVertxGroup;
import com.generator.util.FileUtil;
import com.generator.util.StringUtil;

import java.io.File;
import java.util.List;

import static com.generator.generators.templates.domain.GeneratedFile.packageToPath;

/**
 * User: goe
 * Date: 05.07.13
 */
public class TemplateGroupGenerator {

	public void writeGroupClassFile(File groupTemplateFile, String packageName, String root) {
		FileUtil.write(getGroupClassDeclarationST(groupTemplateFile, packageName), new File(root, packageToPath(packageName) + getGroupName(groupTemplateFile) + "Group" + ".java"));
	}

	public void writeNeoClassFile(File groupTemplateFile, String packageName, String root) {
		FileUtil.write(getNeoGroupDeclaration(groupTemplateFile, packageName), new File(root, packageToPath(packageName) + getGroupName(groupTemplateFile) + "Neo" + ".java"));
	}

	public TemplateGroupGroup.GroupClassDeclarationST getGroupClassDeclarationST(File groupTemplateFile, String packageName) {

		final TemplateGroupGroup group = new TemplateGroupGroup();

		final List<TemplateStatement> statements = new TemplateFileParser().parse(groupTemplateFile).getStatements();

		final TemplateGroupGroup.GroupClassDeclarationST groupClassDeclaration = group.newGroupClassDeclaration().
			setName(getGroupName(groupTemplateFile) + "Group").
			setDomain(groupTemplateFile.getName().substring(0, groupTemplateFile.getName().length() - 4));

		if (packageName != null)
			groupClassDeclaration.setPackageName(packageName);   // only add package (and imports) if packageName is set

		for (TemplateStatement statement : statements) {
			final TemplateGroupGroup.NewStatementDeclarationST declarationST = group.newNewStatementDeclaration();

			for (TemplateParameter templateParameter : statement.getParameters()) {
				Object setter = null;
				switch (templateParameter.getDomainEntityType()) {
					case KEYVALUELISTPROPERTY:

						final TemplateGroupGroup.StatementKeyValueListPropertySetterST kvSetter = group.newStatementKeyValueListPropertySetter().setPropertyName(templateParameter.getPropertyName()).setStatementName(statement.getName());
						for (String kvName : templateParameter.getKvNames()) kvSetter.addKvNamesValue(kvName);
						setter = kvSetter;
						break;

					case STRINGPROPERTY:
					case BOOLEANPROPERTY:
					case STATEMENTPROPERTY:
						setter = group.newStatementStringPropertySetter().setPropertyName(templateParameter.getPropertyName()).setStatementName(statement.getName());
						break;

					case LISTPROPERTY:
						setter = group.newStatementListPropertySetter().setPropertyName(templateParameter.getPropertyName()).setStatementName(statement.getName());
						break;
				}

				declarationST.addPropertiesValue(templateParameter.getPropertyName(), setter);
			}

			groupClassDeclaration.addStatementsValue(declarationST.setName(statement.getName()), group.newNewStatementInstance().setName(statement.getName()));
		}
		return groupClassDeclaration;
	}

	public TemplatesNeoGroup.NeoGroupClassDeclarationST getNeoGroupDeclaration(File groupTemplateFile, String packageName) {

		final TemplatesNeoGroup group = new TemplatesNeoGroup();
		final GeneratorDomainGroup domainGroup = new GeneratorDomainGroup();

		final List<TemplateStatement> statements = new TemplateFileParser().parse(groupTemplateFile).getStatements();

		final TemplatesNeoGroup.NeoGroupClassDeclarationST groupClassDeclaration = group.newNeoGroupClassDeclaration().
			setName(getGroupName(groupTemplateFile)).
			setDomain(getGroupName(groupTemplateFile));

		final GeneratorDomainGroup.visitorST visitorST = domainGroup.newvisitor().
			setDomain(getGroupName(groupTemplateFile)).
			setPackage(packageName);

		if (packageName != null)
			groupClassDeclaration.setPackageName(packageName);   // only add package (and imports) if packageName is set

		for (TemplateStatement statement : statements) {
			final TemplatesNeoGroup.declarationST declarationST = group.newdeclaration().
				setGroupName(getGroupName(groupTemplateFile));

			visitorST.addTermsValue(
				domainGroup.newtermCase().
					setTerm(statement.getName()),
				domainGroup.newtermImpl().
					setTerm(statement.getName()));

			for (TemplateParameter templateParameter : statement.getParameters()) {
				Object setter = null;
				switch (templateParameter.getDomainEntityType()) {
					case KEYVALUELISTPROPERTY:

						final TemplatesNeoGroup.keyValueListSetterST kvSetter = group.newkeyValueListSetter().
							setPropertyName(templateParameter.getPropertyName()).
							setStatementName(statement.getName()).
							setGroupName(getGroupName(groupTemplateFile));
						for (String kvName : templateParameter.getKvNames()) kvSetter.addKvNamesValue(kvName);
						setter = kvSetter;
						break;

					case STRINGPROPERTY:
					case BOOLEANPROPERTY:
						setter = group.newstringSetter().
							setPropertyName(templateParameter.getPropertyName()).
							setStatementName(statement.getName()).
							setGroupName(getGroupName(groupTemplateFile));
						break;

					case STATEMENTPROPERTY:
						setter = group.newstringSetter().
							setPropertyName(templateParameter.getPropertyName()).
							setStatementName(statement.getName()).
							setGroupName(getGroupName(groupTemplateFile));
						break;

					case LISTPROPERTY:
						setter = group.newlistSetter().
							setPropertyName(templateParameter.getPropertyName()).
							setStatementName(statement.getName()).
							setGroupName(getGroupName(groupTemplateFile));
						break;
				}

				declarationST.addPropertiesValue(templateParameter.getPropertyName(), setter);
			}

			groupClassDeclaration.addStatementsValue(declarationST.setName(statement.getName()), group.newnewInstance().setName(statement.getName()));
		}

		return groupClassDeclaration;
	}

	public void createGroupVerticle(File groupTemplateFile, String packageName, String root) {

		final TemplatesVertxGroup group = new TemplatesVertxGroup();

		final List<TemplateStatement> statements = new TemplateFileParser().parse(groupTemplateFile).getStatements();
		final String groupName = getGroupName(groupTemplateFile);

		for (TemplateStatement statement : statements) {
			final String name = statement.getName();

			final TemplatesVertxGroup.GroupVerticleST groupVerticleST = group.newGroupVerticle().
				setName(name).
				setGroupPackage(packageName + "." + groupName + "Group").
				setPackage(packageName + ".vertx").
				setGroupName(groupName + "Group");

			for (TemplateParameter templateParameter : statement.getParameters()) {
				switch (templateParameter.getDomainEntityType()) {

					case LISTPROPERTY: {

						final TemplatesVertxGroup.AddMessageST sendToMessage_ = group.newAddMessage().
							setName(templateParameter.getPropertyName());

						final TemplatesVertxGroup.ConsumeListMessageST consumeMessage_ = group.newConsumeListMessage().
							setName(templateParameter.getPropertyName());

						for (String kvName : templateParameter.getKvNames())
							sendToMessage_.addParametersValue(kvName);

						groupVerticleST.addMessagesValue(consumeMessage_, sendToMessage_);
					}
					break;

					case KEYVALUELISTPROPERTY: {

						final TemplatesVertxGroup.AddMessageST sendToMessage_ = group.newAddMessage().
							setName(templateParameter.getPropertyName());

						final TemplatesVertxGroup.ConsumeKeyValueListMessageST consumeMessage_ = group.newConsumeKeyValueListMessage().
							setName(templateParameter.getPropertyName());

						for (String kvName : templateParameter.getKvNames()) {
							consumeMessage_.addParametersValue(kvName);
							sendToMessage_.addParametersValue(kvName);
						}

						groupVerticleST.addMessagesValue(consumeMessage_, sendToMessage_);
					}
					break;

					case BOOLEANPROPERTY:
					case STATEMENTPROPERTY:
					case STRINGPROPERTY: {

						final TemplatesVertxGroup.SendMessageST sendToMessage_ = group.newSendMessage().
							setName(templateParameter.getPropertyName());

						final TemplatesVertxGroup.ConsumeStringMessageST consumeMessage_ = group.newConsumeStringMessage().
							setName(templateParameter.getPropertyName());

						groupVerticleST.addMessagesValue(consumeMessage_, sendToMessage_);
					}
					break;
				}
			}

			// todo remove single-file write here and move into single file below
			FileUtil.write(groupVerticleST, new File(root, packageToPath(packageName + ".vertx", name + "Verticle.java")));
		}

		// todo: move verticle into factory and write here
//		FileUtil.write(groupVerticleST, new File(root, GeneratedFile.packageToPath(packageName + ".vertx", name + "Verticle.java")));
	}

	public void createGroupPanel(File groupTemplateFile, String packageName, String root) {

		final TemplatesSwingGroup group = new TemplatesSwingGroup();

		final String groupName = getGroupName(groupTemplateFile);

		final TemplatesSwingGroup.GroupPanelST groupPanelST = group.newGroupPanel().
			setName(groupName + "GroupPanel").
			setPackageName(packageName);

		for (TemplateStatement templateStatement : (new TemplateFileParser().parse(groupTemplateFile).getStatements())) {

			final TemplatesSwingGroup.addVerticleActionST addVerticleActionST = group.newaddVerticleAction().
				setPackageName(packageName + ".vertx").
				setName(templateStatement.getName());

			final TemplatesSwingGroup.TemplatePanelST templatePanelST = group.newTemplatePanel().
				setName(templateStatement.getName());

			for (TemplateParameter templateParameter : templateStatement.getParameters()) {

				final String propertyName = templateParameter.getPropertyName();

				switch (templateParameter.getDomainEntityType()) {

					case STRINGPROPERTY:
						templatePanelST.addPropertiesValue(group.newstringPropertyEditor().
							setName(propertyName).
							setGroupName(templateStatement.getName()));
						break;

					case LISTPROPERTY:
						// todo
						break;

					case KEYVALUELISTPROPERTY:
						// todo
						break;

					case STATEMENTPROPERTY:
						// todo

						break;
				}
			}

			groupPanelST.addVerticlesValue(addVerticleActionST, templatePanelST);
		}

		FileUtil.write(groupPanelST, new File(root, packageToPath(packageName, getGroupName(groupTemplateFile) + "GroupPanel.java")));
	}

	public static String getGroupName(File groupTemplateFile) {
		return StringUtil.capitalize(groupTemplateFile.getName().substring(0, groupTemplateFile.getName().length() - 4));
	}
}