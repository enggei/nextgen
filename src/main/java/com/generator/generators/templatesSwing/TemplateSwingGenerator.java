package com.generator.generators.templatesSwing;

import com.generator.generators.templates.domain.GeneratedFile;
import com.generator.generators.templates.domain.TemplateParameter;
import com.generator.generators.templates.domain.TemplateStatement;
import com.generator.generators.templates.parser.TemplateFileParser;
import com.generator.util.FileUtil;
import com.generator.util.StringUtil;

import java.io.File;

import static com.generator.generators.templates.domain.GeneratedFile.*;

/**
 * goe on 8/25/16.
 */
public class TemplateSwingGenerator {

	public void createGroupPanel(File groupTemplateFile, String packageName, String root) {

		final TemplatesSwingGroup group = new TemplatesSwingGroup();

		final String groupName = getGroupName(groupTemplateFile);

		final TemplatesSwingGroup.GroupPanelST groupPanelST = group.newGroupPanel().
			setName(groupName + "GroupPanel").
			setPackageName(packageName);

		final TemplatesSwingGroup.TemplatesSwingST swingST = group.newTemplatesSwing().
			setPackageName(packageName).
			setGroupName(groupName);

		for (TemplateStatement templateStatement : (new TemplateFileParser().parse(groupTemplateFile).getStatements())) {

			swingST.addStatementsValue(templateStatement.getName(), group.newnewAction().setGroupName(groupName).setName(templateStatement.getName()));

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

		//FileUtil.write(groupPanelST, new File(root, packageToPath(packageName, getGroupName(groupTemplateFile) + "GroupPanel.java")));
		FileUtil.write(swingST, new File(root, packageToPath(packageName, getGroupName(groupTemplateFile) + "Swing.java")));
	}

	private static String getGroupName(File groupTemplateFile) {
		return StringUtil.capitalize(groupTemplateFile.getName().substring(0, groupTemplateFile.getName().length() - 4));
	}
}