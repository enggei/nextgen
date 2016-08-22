package com.generator.generators.templatesNeo;

import com.generator.generators.generatorDomain.GeneratorDomainGroup;
import com.generator.generators.templates.domain.TemplateParameter;
import com.generator.generators.templates.domain.TemplateStatement;
import com.generator.generators.templates.parser.TemplateFileParser;
import com.generator.generators.templatesNeo.TemplatesNeoGroup;
import com.generator.util.FileUtil;
import com.generator.util.StringUtil;

import java.io.File;
import java.util.List;

import static com.generator.generators.templates.domain.GeneratedFile.packageToPath;

/**
 * goe on 8/22/16.
 */
public class TemplateNeoGenerator {

	public void writeNeoClassFile(File groupTemplateFile, String packageName, String root) {
		FileUtil.write(getNeoGroupDeclaration(groupTemplateFile, packageName), new File(root, packageToPath(packageName) + getGroupName(groupTemplateFile) + "Neo" + ".java"));
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

	private static String getGroupName(File groupTemplateFile) {
		return StringUtil.capitalize(groupTemplateFile.getName().substring(0, groupTemplateFile.getName().length() - 4));
	}
}