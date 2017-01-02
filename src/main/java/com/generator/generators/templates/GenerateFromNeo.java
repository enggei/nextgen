package com.generator.generators.templates;

import com.generator.generators.templates.domain.GeneratedFile;

import java.io.IOException;
import java.util.function.Consumer;

/**
 * goe on 10/1/16.
 */
public class GenerateFromNeo implements Consumer<TemplatesNeo.TemplateGroupNode>{

	private final String root;

	public GenerateFromNeo(String root) {
		this.root = root;
	}

	@Override
	public void accept(TemplatesNeo.TemplateGroupNode templateGroupNode) {

		final String packageName = TemplatesNeo.newStringNode(templateGroupNode.getPackage()).getValue();

		try {

			final TemplateNeoGeneratorGroup groupGeneratorNeo = new TemplateNeoGeneratorGroup();
			final String groupName = TemplatesNeo.newStringNode(templateGroupNode.getName()).getValue() + "Group";
			GeneratedFile.newJavaFile(root, packageName, groupName).write(templateGroupNode.visit(groupGeneratorNeo));

			final TemplateNeoGeneratorSwing swingGeneratorNeo = new TemplateNeoGeneratorSwing();
			final String swingName = TemplatesNeo.newStringNode(templateGroupNode.getName()).getValue() + "Swing";
			GeneratedFile.newJavaFile(root, packageName, swingName).write(templateGroupNode.visit(swingGeneratorNeo));

			final TemplateNeoGeneratorNeo neoGeneratorNeo = new TemplateNeoGeneratorNeo();
			final String neoName = TemplatesNeo.newStringNode(templateGroupNode.getName()).getValue() + "Neo";
			GeneratedFile.newJavaFile(root, packageName, neoName).write(templateGroupNode.visit(neoGeneratorNeo));

			final TemplateNeoGeneratorVertx neoGeneratorVertx = new TemplateNeoGeneratorVertx();
			final String vertxName = TemplatesNeo.newStringNode(templateGroupNode.getName()).getValue() + "Verticles";
			GeneratedFile.newJavaFile(root, packageName, vertxName).write(templateGroupNode.visit(neoGeneratorVertx));

			final TemplateNeoGeneratorJunit neoGeneratorJunit = new TemplateNeoGeneratorJunit();
			final String junitName = TemplatesNeo.newStringNode(templateGroupNode.getName()).getValue() + "Tests";
			GeneratedFile.newJavaFile(root, packageName, junitName).write(templateGroupNode.visit(neoGeneratorJunit));

//			final TemplateNeoGeneratorTraverser neoGeneratorTraverser = new TemplateNeoGeneratorTraverser();
//			final String traverserName = TemplatesNeo.newStringNode(templateGroupNode.getName()).getValue() + "Traverser";
//			GeneratedFile.newJavaFile(root, packageName, traverserName).write(templateGroupNode.visit(neoGeneratorTraverser));

			//todo duality of Template parameters (as input-constraints, but also as value-holders. 2 directional graphs: one for the constraint (the template), and one for the model (data)
			// todo make a neo-generator, which uses neo-nodes to traverse (independent of group!)

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}