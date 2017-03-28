package com.generator.generators.project;

import org.neo4j.graphdb.Node;

import static com.generator.editors.BaseDomainVisitor.getString;

/**
 * Created 24.03.17.
 */
public class FileGenerator extends ProjectDomain.ProjectDomainVisitor {

   @Override
   <T> T visitFile(Node node) {

//      final String root = getString(node, ProjectDomain.Properties.name.name());
//      final String outputFormat = getString(node, ProjectDomain.Properties.outputFormat.name());
//
//      final Node statementNode = other(node, projectRelation);
//
//      assert outputFormat != null;
//      switch (outputFormat) {
//
//         case "java": {
//
//            final String packageParameter = getString(projectRelation, TemplateDomain.Properties.packageName.name());
//            final String nameParameter = getString(projectRelation, ProjectDomain.Properties.name.name());
//
//            new TemplateDomain.StatementVisitor() {
//
//               private String nameValue;
//               private String packageValue;
//
//               @Override
//               protected void onSingleValue(String name, Node referenceNode, TemplateDomain.Entities referenceNodeType) {
//                  assert nameParameter != null;
//                  if (nameParameter.equals(name))
//                     nameValue = renderReferenceNode(referenceNode, referenceNodeType);
//                  else {
//                     assert packageParameter != null;
//                     if (packageParameter.equals(name))
//                        packageValue = renderReferenceNode(referenceNode, referenceNodeType);
//                  }
//               }
//
//               @Override
//               protected void onStatementEnd() {
//                  final GeneratedFile generatedFile = GeneratedFile.newJavaFile(root, packageValue, nameValue);
//                  try {
//                     generatedFile.write(render(statementNode));
//                  } catch (IOException e1) {
//                     SwingUtil.showException(component, e1);
//                  }
//               }
//            }.visitStatement(statementNode);
//
//            break;
//         }
//
//         case "other": {
//
//            final String filename = getString(projectRelation, ProjectDomain.Properties.name.name());
//
//            assert filename != null;
//            final GeneratedFile generatedFile = new GeneratedFile(new File(root, filename));
//            try {
//               generatedFile.write(render(statementNode));
//            } catch (IOException e1) {
//               SwingUtil.showException(component, e1);
//            }
//            break;
//         }
//      }


      return super.visitFile(node);
   }
}