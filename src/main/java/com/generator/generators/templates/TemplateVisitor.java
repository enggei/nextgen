package com.generator.generators.templates;

import com.generator.generators.templateGroup.TemplateGroupGenerator;
import com.generator.generators.templates.domain.TemplateParameter;
import com.generator.generators.templates.domain.TemplateStatement;
import com.generator.generators.templates.parser.TemplateFileParser;

import java.io.File;

/**
 * goe on 8/29/16.
 */
public interface TemplateVisitor {

	static void visit(File groupTemplateFile, TemplateVisitor... visitors) {

		for (TemplateVisitor visitor : visitors) visitor.onStartGroupTemplateFile(groupTemplateFile);

		for (TemplateStatement statement : new TemplateFileParser().parse(groupTemplateFile).getStatements()) {

			for (TemplateVisitor visitor : visitors) visitor.onStartStatement(statement);
			for (TemplateParameter templateParameter : statement.getParameters()) {

				for (TemplateVisitor visitor : visitors) visitor.onStartTemplateParameter(templateParameter, statement);
				switch (templateParameter.getDomainEntityType()) {
					case KEYVALUELISTPROPERTY:

						for (TemplateVisitor visitor : visitors)
							visitor.onKeyValueTemplateParameter(templateParameter, statement);
						break;
					case STRINGPROPERTY:

						for (TemplateVisitor visitor : visitors)
							visitor.onStringTemplateParameter(templateParameter, statement);
						break;
					case BOOLEANPROPERTY:

						for (TemplateVisitor visitor : visitors)
							visitor.onBooleanTemplateParameter(templateParameter, statement);
						break;
					case STATEMENTPROPERTY:

						for (TemplateVisitor visitor : visitors)
							visitor.onStatementTemplateParameter(templateParameter, statement);
						break;
					case LISTPROPERTY:

						for (TemplateVisitor visitor : visitors)
							visitor.onListTemplateParameter(templateParameter, statement);
						break;
				}

				for (TemplateVisitor visitor : visitors) visitor.onEndTemplateParameter(templateParameter, statement);
			}

			for (TemplateVisitor visitor : visitors) visitor.onEndStatement(statement);
		}

		for (TemplateVisitor visitor : visitors) visitor.onEndGroupTemplateFile(groupTemplateFile);
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
		final File groupTemplateFile = new File("/media/storage/nextgen/src/main/java/com/generator/generators/templatesSwing/templatesSwing.stg");
		final String root = "src/main/java/";
		final String packageName = "com.generator.generators.templatesSwing";

		TemplateVisitor.visit(groupTemplateFile, new TemplateGroupGenerator(root, packageName));
	}
}