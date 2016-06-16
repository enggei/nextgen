package com.generator.generators.generatorDomain;

import com.generator.generators.templates.domain.GeneratedFile;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;

import java.awt.*;

/**
 * goe on 5/15/15.
 */
public class DomainEditorGenerator extends GeneratorDomainVisitor {

	private final GeneratorDomainGroup stGroup = new GeneratorDomainGroup();

	private GeneratorDomainGroup.editorST editorST;

	protected DomainEditorGenerator(Component component) {
		super(component, "Generate Domain-editor");
	}

	@Override
	<T> T visitDOMAIN(Node node) {

		this.editorST = stGroup.neweditor().
			setName(get(node, "name")).
			setPackage(get(node, "package"));

		if (has(node, "root"))
			this.targetFile = GeneratedFile.newJavaFile(get(node, "root").toString(), get(node, "package").toString(), get(node, "name").toString()+"Editor").getFile();

		if (has(node, "comments")) editorST.setComments(get(node, "comments"));

		for (Relationship rel : outgoing(node, GeneratorDomain.RELATIONS.TERM))
			visitENTITY(rel.getOtherNode(node));

		for (Relationship relationship : outgoing(node, GeneratorDomain.RELATIONS.CONSTRAINT))
			visitRELATION(relationship.getOtherNode(node));

		return (T) this.editorST.toString();
	}

	@Override
	<T> T visitENTITY(Node node) {

		Object domainName = get(otherIncoming(node, GeneratorDomain.RELATIONS.TERM), "name");

		final GeneratorDomainGroup.entityGraphNodeDeclarationST declarationST = stGroup.newentityGraphNodeDeclaration().
			setName(get(node, "name"));

		final GeneratorDomainGroup.graphEditorDeclarationST editorDeclarationST = stGroup.newgraphEditorDeclaration().
			setName(get(node, "name"));

		final GeneratorDomainGroup.entityEditorImplementationST editorImplementationST = stGroup.newentityEditorImplementation().
			setName(get(node, "name")).
			setDomain(domainName);

		final GeneratorDomainGroup.entityGraphNodeImplementationST implementationST = stGroup.newentityGraphNodeImplementation().
			setDomain(domainName).
			setName(get(node, "name")).
			setGBackground(get(node, "background")).
			setGSelBackground(get(node, "selectedBackground")).
			setGLabelColor(get(node, "labelColor")).
			setGSelLabelColor(get(node, "selectedLabelColor")).
			setWidth(get(node, "width")).
			setHeight(get(node, "height"));

		final GeneratorDomainGroup.entityRightClickST rightClickST = stGroup.newentityRightClick().
			setDomain(domainName).
			setName(get(node, "name"));

		editorST.addEntitiesValue(editorDeclarationST, editorImplementationST, declarationST, implementationST, get(node, "name"), rightClickST);

		return (T) declarationST;
	}

	@Override
	<T> T visitRELATION(Node node) {

		final GeneratorDomainGroup.graphRelationDeclarationST declarationST = stGroup.newgraphRelationDeclaration().
			setName(get(node, "name"));

		final GeneratorDomainGroup.graphRelationImplST implST = stGroup.newgraphRelationImpl().
			setName(get(node, "name")).setDomain(get(other(node, singleIncoming(node, GeneratorDomain.RELATIONS.CONSTRAINT)), "name"));

		editorST.addRelationsValue(declarationST, implST, get(node, "name"));

		return super.visitRELATION(node);
	}

	@Override
	public <T> void done(T result) {
		showOutput(result);
	}
}
