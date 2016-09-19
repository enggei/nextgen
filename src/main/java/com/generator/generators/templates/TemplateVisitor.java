package com.generator.generators.templates;

import com.generator.generators.templates.domain.TemplateParameter;
import com.generator.generators.templates.domain.TemplateStatement;
import com.generator.generators.templates.parser.TemplateFileParser;
import com.generator.generators.templatesNeo.TemplateNeoGenerator;

import java.io.File;

/**
 * goe on 8/29/16.
 */
public interface TemplateVisitor {

	public static void visit(File groupTemplateFile, TemplateVisitor visitor) {

		visitor.onStartGroupTemplateFile(groupTemplateFile);

		for (TemplateStatement statement : new TemplateFileParser().parse(groupTemplateFile).getStatements()) {

			visitor.onStartStatement(statement);
			for (TemplateParameter templateParameter : statement.getParameters()) {

				visitor.onStartTemplateParameter(templateParameter, statement);
				switch (templateParameter.getDomainEntityType()) {
					case KEYVALUELISTPROPERTY:

						visitor.onKeyValueTemplateParameter(templateParameter, statement);
						break;
					case STRINGPROPERTY:

						visitor.onStringTemplateParameter(templateParameter, statement);
						break;
					case BOOLEANPROPERTY:

						visitor.onBooleanTemplateParameter(templateParameter, statement);
						break;
					case STATEMENTPROPERTY:

						visitor.onStatementTemplateParameter(templateParameter, statement);
						break;
					case LISTPROPERTY:

						visitor.onListTemplateParameter(templateParameter, statement);
						break;
				}

				visitor.onEndTemplateParameter(templateParameter, statement);
			}

			visitor.onEndStatement(statement);
		}

		visitor.onEndGroupTemplateFile(groupTemplateFile);
	}


	void onStartGroupTemplateFile(File groupTemplateFile);

	void onStartStatement(TemplateStatement statement);

	void onStartTemplateParameter(TemplateParameter parameter, TemplateStatement statement);

	void onKeyValueTemplateParameter(TemplateParameter templateParameter, TemplateStatement statement);

	void onStringTemplateParameter(TemplateParameter templateParameter, TemplateStatement statement);

	void onBooleanTemplateParameter(TemplateParameter templateParameter, TemplateStatement statement);

	void onStatementTemplateParameter(TemplateParameter templateParameter, TemplateStatement statement);

	void onListTemplateParameter(TemplateParameter templateParameter, TemplateStatement statement);

	void onEndTemplateParameter(TemplateParameter templateParameter, TemplateStatement statement);

	void onEndStatement(TemplateStatement statement);

	void onEndGroupTemplateFile(File groupTemplateFile);

	public static void main(String[] args) {

		System.setProperty("generator.path", "src/main/java/com/generator/generators");

		// a dynamic visitor for use in generators (traverses a StringTemplate
		final File groupTemplateFile = new File("/media/storage/nextgen/src/main/java/com/generator/generators/templatesNeo/templatesNeo.stg");
		final String root = "src/main/java/";
		final String packageName = "com.generator.generators.templatesNeo";

		TemplateVisitor.visit(groupTemplateFile, new TemplateNeoGenerator(root, packageName));
	}
}