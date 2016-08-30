package com.generator.generators.templatesSwing;

import com.generator.generators.templateGroup.TemplateGroupConstraints;
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
public class TemplateSwingGenerator implements TemplateVisitor {

	private final String root;
	private final String packageName;
	private final TemplatesSwingGroup group = new TemplatesSwingGroup();

	private File groupTemplateFile;
	private TemplatesSwingGroup.TemplatesSwingST swingST;
	private Object propertyName;

	// test of domain-constraints:
	// todo: move into constructor
	final TemplateGroupConstraints groupConstraints = new TemplateGroupConstraints();

	public TemplateSwingGenerator(String root, String packageName) {
		this.root = root;
		this.packageName = packageName;
	}

	@Override
	public void onStartGroupTemplateFile(File groupTemplateFile) {

		this.groupTemplateFile = groupTemplateFile;

		swingST = group.newTemplatesSwing().
			setPackageName(packageName).
			setGroupName(getGroupName());
	}

	@Override
	public void onStartStatement(TemplateStatement statement) {

		swingST.addStatementsValue(statement.getName(), group.newnewAction().
			setGroupName(getGroupName()).
			setName(statement.getName()));
	}

	@Override
	public void onStartTemplateParameter(TemplateParameter parameter, TemplateStatement statement) {
		propertyName = parameter.getPropertyName();
	}

	@Override
	public void onKeyValueTemplateParameter(TemplateParameter templateParameter, TemplateStatement statement) {

	}

	@Override
	public void onStringTemplateParameter(TemplateParameter templateParameter, TemplateStatement statement) {
	}

	@Override
	public void onBooleanTemplateParameter(TemplateParameter templateParameter, TemplateStatement statement) {

	}

	@Override
	public void onStatementTemplateParameter(TemplateParameter templateParameter, TemplateStatement statement) {

	}

	@Override
	public void onListTemplateParameter(TemplateParameter templateParameter, TemplateStatement statement) {

	}

	@Override
	public void onEndTemplateParameter(TemplateParameter templateParameter, TemplateStatement statement) {

	}

	@Override
	public void onEndStatement(TemplateStatement statement) {
	}

	@Override
	public void onEndGroupTemplateFile(File groupTemplateFile) {
		FileUtil.write(swingST, new File(root, packageToPath(packageName, getGroupName() + "Swing.java")));
	}

	private String getGroupName() {
		return StringUtil.capitalize(groupTemplateFile.getName().substring(0, groupTemplateFile.getName().length() - 4));
	}
}