package com.generator.generators.templates;

import com.generator.generators.templates.domain.TemplateFile;
import com.generator.generators.templates.domain.TemplateImport;
import com.generator.generators.templates.domain.TemplateParameter;
import com.generator.generators.templates.domain.TemplateStatement;
import org.neo4j.graphdb.Node;

import java.io.File;

import static com.generator.generators.templates.domain.GeneratedFile.pathToPackage;

/**
 * goe on 10/1/16.
 */
public final class ParseTemplateToNeo {

	private ParseTemplateToNeo() {
	}

	public static TemplatesNeo.TemplateGroupNode parse(String root, TemplateFile templateFile, TemplatesNeo db) {

		final String groupName = templateFile.getName().substring(0, templateFile.getName().length() - 4);
		final String subPath = templateFile.getFile().getAbsolutePath().substring(new File(root).getAbsolutePath().length() + 1);
		final String builderPackage = pathToPackage(subPath.substring(0, subPath.lastIndexOf("/")));

		final TemplatesNeo.TemplateGroupNode templateGroupNode = db.newTemplateGroup().
			setName(db.newStringNode(groupName)).
			setPackage(db.newStringNode(builderPackage)).
			setDelimiter(db.newStringNode(templateFile.getDelimiter() + ""));

		for (TemplateImport templateImport : templateFile.getImports()) {

			// todo: implement these in generators, so templates etc. can be inherited and support fully the ST template functionalities

			templateGroupNode.addImportsValue(db.newTemplateImport().
				setName(db.newStringNode(templateImport.getName())).
				node());
		}

		for (TemplateStatement templateStatement : templateFile.getStatements()) {

			final TemplatesNeo.TemplateStatementNode templateStatementNode = db.newTemplateStatement().
				setName(db.newStringNode(templateStatement.getName())).
				setText(db.newStringNode(templateStatement.getText()));

			templateGroupNode.addTemplateStatementsValue(templateStatementNode.node());

			for (TemplateParameter templateParameter : templateStatement.getParameters()) {

				final Node parameterName = db.newStringNode(templateParameter.getPropertyName());

				switch (templateParameter.getDomainEntityType()) {

					case KEYVALUELISTPROPERTY:

						final TemplatesNeo.KeyValueListTemplateParameterNode keyValueListTemplateParameterNode = db.newKeyValueListTemplateParameter().
							setName(parameterName);

						for (String kvName : templateParameter.getKvNames())
							keyValueListTemplateParameterNode.addKvNamesValue(db.newStringNode(kvName));

						templateStatementNode.addTemplateParametersValue(keyValueListTemplateParameterNode.node());

						break;

					case STRINGPROPERTY:

						templateStatementNode.addTemplateParametersValue(db.newStringTemplateParameter().
							setName(parameterName).node());

						break;

					case BOOLEANPROPERTY:

						templateStatementNode.addTemplateParametersValue(db.newBooleanTemplateParameter().
							setName(parameterName).node());

						break;

					case STATEMENTPROPERTY:

						templateStatementNode.addTemplateParametersValue(db.newStatementTemplateParameter().
							setName(parameterName).node());

						break;

					case LISTPROPERTY:

						templateStatementNode.addTemplateParametersValue(db.newListTemplateParameter().
							setName(parameterName).node());

						break;
				}
			}

		}
		return templateGroupNode;
	}
}