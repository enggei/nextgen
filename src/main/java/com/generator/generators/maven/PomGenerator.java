package com.generator.generators.maven;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;

import static com.generator.editors.BaseDomainVisitor.getString;
import static com.generator.editors.BaseDomainVisitor.other;
import static com.generator.editors.BaseDomainVisitor.outgoing;

/**
 * Created 24.03.17.
 */
public class PomGenerator extends MavenDomain.MavenDomainVisitor {

   private final MavenGroup group;

   private MavenGroup.pomST pomST;

   public PomGenerator(MavenGroup group) {
      this.group = group;
   }

   @Override
   <T> T visitPom(Node node) {

      pomST = group.newpom();

      for (Relationship relationship : outgoing(node, MavenDomain.Relations.DEPENDENCY))
         visit(other(node, relationship));

      return super.visitPom(node);
   }

   @Override
   <T> T visitLibrary(Node node) {

      final String artifactId = getString(node, MavenDomain.Properties.artifactId.name());
      final String groupId = getString(node, MavenDomain.Properties.groupId.name());
      final String scope = getString(node, MavenDomain.Properties.scope.name());
      final String version = getString(node, MavenDomain.Properties.version.name());
      pomST.addDependencyValue(artifactId, groupId, scope, version);

      return super.visitLibrary(node);
   }
}