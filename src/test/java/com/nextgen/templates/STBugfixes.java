package com.nextgen.templates;

import com.generator.generators.templates.domain.TemplateStatement;
import com.generator.generators.templates.parser.TemplateFileParser;
import org.junit.Assert;
import org.junit.Test;
import org.stringtemplate.v4.ST;

import java.io.IOException;


/**
 * goe on 12/29/16.
 */
public class STBugfixes {

	@Test
	public void showBugStatementDelimiter() throws IOException {
		final String statement = "This contains extra >>";
		final TemplateStatement parsed = new TemplateFileParser().parse("~", "Teststatement", statement);
		System.out.println(parsed.getText());
	}

	@Test
	public void testStatementDelimiterFix() throws IOException {
		final String original = "This contains extra >>";

		// todo: move this into TemplateFileParser, and make it invisible for users:

		// fix: escape any >:
		String statement = original.replaceAll(">", "_bugfixOne_");
		final TemplateStatement parsed = new TemplateFileParser().parse("~", "Teststatement", statement);
		final String fixed = parsed.getText().replaceAll("_bugfixOne_", ">");
		System.out.println(fixed);

		Assert.assertEquals(original, fixed);
	}

	@Test
	public void showBugAnonymousMethod() throws IOException {

		final String[] originals = {
			"~kv:{it| {it.name};};separator=\"\n\"~",
			"~kv:{it| {it.name};}~"
		};

		new ST(originals[0], '~', '~');
	}

	@Test
	public void testAnonymousMethodFix() throws IOException {

		final String[] originals = {
			"~kv:{it| {it.name};};separator=\"\n\"~",
			"~kv:{it| {it.name};}~"
		};

		 // todo: how to fix ?
		final String statement = originals[1].replaceAll("};[^~]", "_bugfixTwo_");
		System.out.println(statement);

		final ST st = new ST(statement, '~', '~');
		st.addAggr("kv.{name}","NAME");
		System.out.println(st.render().replaceAll("_bugfixTwo_","};"));
	}
}