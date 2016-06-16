package com.generator.generators.generatorDomain;

import com.generator.generators.templates.domain.GeneratedFile;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;

import java.awt.*;

/**
 * goe on 4/23/15.
 */
public class DomainVisitorGenerator extends GeneratorDomainVisitor {

	private final GeneratorDomainGroup stGroup = new GeneratorDomainGroup();

	private GeneratorDomainGroup.visitorST visitorST;

	public DomainVisitorGenerator(Component component) {
		super(component, "Generate Domain-visitor");

	}

	@Override
	<T> T visitDOMAIN(Node node) {

		this.visitorST = stGroup.newvisitor().
			setPackage(get(node, "package")).
			setDomain(get(node, "name"));

		if (has(node, "root"))
			this.targetFile = GeneratedFile.newJavaFile(get(node, "root").toString(), get(node, "package").toString(), get(node, "name").toString() + "Visitor").getFile();

		for (Relationship rel : outgoing(node, GeneratorDomain.RELATIONS.TERM))
			visitENTITY(other(node, rel));

		return (T) visitorST.toString();
	}

	@Override
	<T> T visitENTITY(Node node) {

		final GeneratorDomainGroup.termImplST termImplST = stGroup.newtermImpl().
			setTerm(get(node, "name"));

		final GeneratorDomainGroup.termCaseST termCaseST = stGroup.newtermCase().
			setTerm(get(node, "name"));

		visitorST.addTermsValue(termCaseST, termImplST);

		return (T) get(node, "name");
	}

	@Override
	public <T> void done(T result) {
		showOutput(result);
	}
}