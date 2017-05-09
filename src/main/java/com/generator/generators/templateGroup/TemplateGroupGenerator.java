package com.generator.generators.templateGroup;

import com.generator.generators.templates.TemplateVisitor;
import com.generator.generators.templates.domain.TemplateParameter;
import com.generator.generators.templates.domain.TemplateStatement;
import com.generator.util.FileUtil;
import com.generator.util.StringUtil;

import java.io.File;

import static com.generator.generators.templates.domain.GeneratedFile.packageToPath;

/**
 * User: goe
 * Date: 05.07.13
 */
public class TemplateGroupGenerator implements TemplateVisitor {

	private final String root;
	private final String packageName;
	private final TemplateGroupDomainGroup group = new TemplateGroupDomainGroup();

	private File groupTemplateFile;
	private TemplateGroupDomainGroup.GroupClassDeclarationST groupClassDeclaration;
	private TemplateGroupDomainGroup.NewStatementDeclarationST declarationST;
	private Object setter;

	public TemplateGroupGenerator(String root, String packageName) {
		this.root = root;
		this.packageName = packageName;
	}

	@Override
	public void onStartGroupTemplateFile(File groupTemplateFile) {

		this.groupTemplateFile = groupTemplateFile;

		groupClassDeclaration = group.newGroupClassDeclaration().
			setName(getGroupName()).
			setDomain(groupTemplateFile.getName().substring(0, groupTemplateFile.getName().length() - 4)).
			setPackageName(packageName);
	}

	@Override
	public void onStartStatement(TemplateStatement statement) {
		declarationST = group.newNewStatementDeclaration().setGroupname(getGroupName());
	}

	@Override
	public void onStartTemplateParameter(TemplateParameter parameter, TemplateStatement statement) {
		setter = null;
	}

	@Override
	public void onKeyValueTemplateParameter(TemplateParameter templateParameter, TemplateStatement statement) {

		final TemplateGroupDomainGroup.StatementKeyValueListPropertySetterST kvSetter = group.newStatementKeyValueListPropertySetter().
			setPropertyName(templateParameter.getPropertyName()).
			setStatementName(statement.getName());
		templateParameter.getKvNames().forEach(kvSetter::addKvNamesValue);

		setter = kvSetter;
	}

	@Override
	public void onStringTemplateParameter(TemplateParameter templateParameter, TemplateStatement statement) {
		setter = group.newStatementStringPropertySetter().setPropertyName(templateParameter.getPropertyName()).setStatementName(statement.getName());
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
		setter = group.newStatementListPropertySetter().setPropertyName(templateParameter.getPropertyName()).setStatementName(statement.getName());
	}

	@Override
	public void onEndTemplateParameter(TemplateParameter templateParameter, TemplateStatement statement) {
		declarationST.addPropertiesValue(templateParameter.getPropertyName(), setter);
	}

	@Override
	public void onEndStatement(TemplateStatement statement) {
		groupClassDeclaration.addStatementsValue(declarationST.setName(statement.getName()), group.newNewStatementInstance().setName(statement.getName()));
	}

	@Override
	public void onEndGroupTemplateFile(File groupTemplateFile) {
		FileUtil.write(groupClassDeclaration, new File(root, packageToPath(packageName) + getGroupName() + ".java"));
	}

	private String getGroupName() {
		return StringUtil.capitalize(groupTemplateFile.getName().substring(0, groupTemplateFile.getName().length() - 4) + "Group");
	}
}