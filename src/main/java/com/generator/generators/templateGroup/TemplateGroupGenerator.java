package com.generator.generators.templateGroup;

import com.generator.generators.templates.domain.TemplateParameter;
import com.generator.generators.templates.domain.TemplateStatement;
import com.generator.generators.templates.parser.TemplateFileParser;
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

	private static String getGroupName(File groupTemplateFile) {
		return StringUtil.capitalize(groupTemplateFile.getName().substring(0, groupTemplateFile.getName().length() - 4));
	}
}