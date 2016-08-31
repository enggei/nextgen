package com.generator.generators.templatesGraphStream;

import com.generator.generators.generatorDomain.GeneratorDomainGroup;
import com.generator.generators.templates.TemplateVisitor;
import com.generator.generators.templates.domain.TemplateParameter;
import com.generator.generators.templates.domain.TemplateStatement;
import com.generator.util.FileUtil;
import com.generator.util.StringUtil;

import java.io.File;

import static com.generator.generators.templates.domain.GeneratedFile.packageToPath;

/**
 * goe on 8/22/16.
 */
public class GraphStreamGenerator implements TemplateVisitor {

	private final String root;
	private final String packageName;
	private final TemplatesGraphStreamGroup group = new TemplatesGraphStreamGroup();
	private final GeneratorDomainGroup domainGroup = new GeneratorDomainGroup();

	private File groupTemplateFile;
	private TemplatesGraphStreamGroup.GroupClassDeclarationST groupClassDeclaration;
	private GeneratorDomainGroup.visitorST visitorST;
	private TemplatesGraphStreamGroup.declarationST declarationST;
	private Object setter;
	private Object relationships;

	public GraphStreamGenerator(String root, String packageName) {
		this.root = root;
		this.packageName = packageName;
	}

	@Override
	public void onStartGroupTemplateFile(File groupTemplateFile) {

		this.groupTemplateFile = groupTemplateFile;

		groupClassDeclaration = group.newGroupClassDeclaration().
			setName(getGroupName()).
			setPackageName(packageName);   // only add package (and imports) if packageName is set;

		visitorST = domainGroup.newvisitor().
			setDomain(getGroupName()).
			setPackage(packageName);
	}

	@Override
	public void onStartStatement(TemplateStatement statement) {

		declarationST = group.newdeclaration().
			setGroupName(getGroupName());

		visitorST.addTermsValue(
			domainGroup.newtermCase().
				setTerm(statement.getName()),
			domainGroup.newtermImpl().
				setTerm(statement.getName()));
	}

	@Override
	public void onStartTemplateParameter(TemplateParameter parameter, TemplateStatement statement) {
		setter = null;
		relationships = null;
	}

	@Override
	public void onKeyValueTemplateParameter(TemplateParameter templateParameter, TemplateStatement statement) {
		final TemplatesGraphStreamGroup.keyValueListSetterST kvSetter = group.newkeyValueListSetter().
			setPropertyName(templateParameter.getPropertyName()).
			setStatementName(statement.getName());
		templateParameter.getKvNames().forEach(kvSetter::addKvNamesValue);
		setter = kvSetter;

		final TemplatesGraphStreamGroup.keyValueRelationshipsST relationshipsST = group.newkeyValueRelationships().
			setName(templateParameter.getPropertyName());
		templateParameter.getKvNames().forEach(relationshipsST::addTypesValue);

		relationships = relationshipsST;
	}

	@Override
	public void onStringTemplateParameter(TemplateParameter templateParameter, TemplateStatement statement) {
		setter = group.newstringSetter().
			setPropertyName(templateParameter.getPropertyName()).
			setStatementName(statement.getName());
	}

	@Override
	public void onBooleanTemplateParameter(TemplateParameter templateParameter, TemplateStatement statement) {
		setter = group.newstringSetter().
			setPropertyName(templateParameter.getPropertyName()).
			setStatementName(statement.getName());
	}

	@Override
	public void onStatementTemplateParameter(TemplateParameter templateParameter, TemplateStatement statement) {
		setter = group.newstringSetter().
			setPropertyName(templateParameter.getPropertyName()).
			setStatementName(statement.getName());
	}

	@Override
	public void onListTemplateParameter(TemplateParameter templateParameter, TemplateStatement statement) {
		setter = group.newlistSetter().
			setPropertyName(templateParameter.getPropertyName()).
			setStatementName(statement.getName());
	}

	@Override
	public void onEndTemplateParameter(TemplateParameter templateParameter, TemplateStatement statement) {
		declarationST.addPropertiesValue(templateParameter.getPropertyName(), relationships, setter);
	}

	@Override
	public void onEndStatement(TemplateStatement statement) {
		groupClassDeclaration.addStatementsValue(declarationST.setName(statement.getName()), statement.getName(), group.newnewInstance().setName(statement.getName()).setGroupName(getGroupName()));
	}

	@Override
	public void onEndGroupTemplateFile(File groupTemplateFile) {
		FileUtil.write(groupClassDeclaration, new File(root, packageToPath(packageName) + getGroupName() + "GraphStream" + ".java"));
	}

	private String getGroupName() {
		return StringUtil.capitalize(groupTemplateFile.getName().substring(0, groupTemplateFile.getName().length() - 4));
	}
}