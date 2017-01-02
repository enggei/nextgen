package com.generator.generators.templates;

import com.generator.generators.junit.JunitGroup;

/**
 * goe on 10/1/16.
 */
public class TemplateNeoGeneratorJunit extends TemplateVisitorNeo<JunitGroup.testsST> {

	private final JunitGroup group = new JunitGroup();

	private JunitGroup.testsST testsST;

	@Override
	protected void onTemplateGroup(TemplatesNeo.TemplateGroupNode templateGroupNode) {

		final String groupName = getStringNodeValue(templateGroupNode.getName()) + "Tests";

		testsST = group.newtests().
			setName(groupName).
			setPackageName(getStringNodeValue(templateGroupNode.getPackage()));

		testsST.addTestsValue(group.
			newtemplateGroupTest().
			setGroupName(getStringNodeValue(templateGroupNode.getName()) + "Group").
			setName(getStringNodeValue(templateGroupNode.getName())));

		// todo: perhaps use root instead of testPath ?
		testsST.addTestsValue(group.
			newtemplateNeoTest().
			setName(getStringNodeValue(templateGroupNode.getName())).
			setDbPath(templateGroupNode.node().hasProperty("testPath") ? templateGroupNode.node().getProperty("testPath") : "/home/goe/aaatest"));
	}

	@Override
	protected void onTemplateStatement(TemplatesNeo.TemplateStatementNode statementNode) {

		final String statementName = "test" + getStringNodeValue(statementNode.getName());

		final JunitGroup.testST testST = group.newtest().
			setName(statementName).
			addStatementsValue("// test " + statementName);

		testsST.addTestsValue(testST);
	}

	@Override
	protected void onStringTemplateParameter(TemplatesNeo.StringTemplateParameterNode stringTemplateParameterNode) {

	}

	@Override
	protected void onBooleanTemplateParameter(TemplatesNeo.BooleanTemplateParameterNode booleanTemplateParameterNode) {

	}

	@Override
	protected void onListTemplateParameter(TemplatesNeo.ListTemplateParameterNode listTemplateParameterNode) {

	}

	@Override
	protected void onKeyValueListTemplateParameter(TemplatesNeo.KeyValueListTemplateParameterNode keyValueListTemplateParameterNode) {

	}

	@Override
	protected void onStatementTemplateParameter(TemplatesNeo.StatementTemplateParameterNode statementTemplateParameterNode) {

	}

	@Override
	protected void onTemplateStatementEnd(TemplatesNeo.TemplateStatementNode statementNode) {

	}

	@Override
	protected JunitGroup.testsST onTemplateGroupEnd(TemplatesNeo.TemplateGroupNode templateGroupNode) {
		return testsST;
	}
}