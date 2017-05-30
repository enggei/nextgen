package com.generator.generators.meta;

import com.generator.generators.templates.domain.GeneratedFile;
import com.generator.util.StringUtil;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import static com.generator.editors.BaseDomainVisitor.*;
import static com.generator.generators.meta.MetaDomain.Properties.name;
import static com.generator.generators.meta.MetaDomain.Relations.ENUM_VALUE;

/**
 * Created 28.04.17.
 */
class GenerateJavaDomain extends MetaDomain.MetaDomainVisitor {

   private final MetaDomainGroup group;
   private MetaDomainGroup.DomainClassST domainClassST;
   private MetaDomainGroup.PropertyEditorST propertyEditorST;
   private final Set<String> properties = new LinkedHashSet<>();
   private final Set<String> entities = new LinkedHashSet<>();
   private final Set<String> relations = new LinkedHashSet<>();

   private String domainName;

   public GenerateJavaDomain(MetaDomainGroup group) {
      this.group = group;
   }

   @Override
   protected <T> T visitDomain(Node node) {

      domainName = StringUtil.capitalize(getString(node, name.name()));
      final String packageName = getString(node, MetaDomain.Properties.packageName.name());

      domainClassST = group.newDomainClass();
      domainClassST.setDomainName(domainName);
      domainClassST.setPackageName(packageName);

      for (Relationship entityRelation : outgoing(node, MetaDomain.Relations.ENTITY))
         visitEntity(other(node, entityRelation));

      for (Relationship entityRelation : outgoing(node, MetaDomain.Relations.RELATION))
         visitRelation(other(node, entityRelation));

      final String root = getString(node, MetaDomain.Properties.root.name());
      if (root != null) {
         final GeneratedFile javaFile = GeneratedFile.newJavaFile(root, packageName, domainName + "Domain");
         try {
            javaFile.write(domainClassST);
         } catch (IOException e1) {
            throw new IllegalStateException("Could not write to file " + javaFile.getFile().getAbsolutePath());
         }
      }

      return (T) domainClassST.toString();
   }

   @Override
   protected <T> T visitEntity(Node node) {

      final String name = getString(node, MetaDomain.Properties.name.name());
      final String qualifiedName = domainName + "_" + getString(node, MetaDomain.Properties.name.name());
      if (entities.contains(name))
         throw new IllegalStateException(name + " is defined twice");
      entities.add(qualifiedName);

      propertyEditorST = group.newPropertyEditor().
            setName(name);

      final String color = getString(node, MetaDomain.Properties.color.name());
      if (color == null || color.length() == 0)
         throw new IllegalStateException("no color set for " + name + ". Set color to all entities.");

      final MetaDomainGroup.PNodeDeclarationST declaration = group.newPNodeDeclaration().
            setName(name).
            setColor(color).
            setDomainName(domainName).
            setLabel(getString(node, MetaDomain.Properties.label.name()));

      for (Relationship propertyRelation : outgoing(node, MetaDomain.Relations.PROPERTY)) {
         final Node propertyNode = other(node, propertyRelation);
         visit(propertyNode);
         declaration.addPropertiesValue(getString(propertyNode, MetaDomain.Properties.name.name()));
      }

      node.getRelationships().forEach(relationship -> {

         if (MetaDomain.Relations.SRC.name().equals(relationship.getType().name())) {
            final Node relationNode = other(node, relationship);

            outgoing(relationNode, MetaDomain.Relations.DST).forEach(rel -> {
               final Node dst = other(relationNode, rel);
               declaration.addOutgoingValue(getString(dst, MetaDomain.Properties.name.name()), StringUtil.toUpper(getString(relationNode, MetaDomain.Properties.name.name())));

               if (hasOutgoing(relationNode, MetaDomain.Relations.PROPERTY))
                  declaration.addOutgoingWithPropertiesValue(getString(relationNode, MetaDomain.Properties.name.name()), StringUtil.toUpper(getString(relationNode, MetaDomain.Properties.name.name())));
            });

         } else if (MetaDomain.Relations.DST.name().equals(relationship.getType().name())) {
            final Node relationNode = other(node, relationship);

            outgoing(relationNode, MetaDomain.Relations.SRC).forEach(rel -> {
               final Node src = other(relationNode, rel);
               declaration.addIncomingValue(StringUtil.toUpper(getString(relationNode, MetaDomain.Properties.name.name())), getString(src, MetaDomain.Properties.name.name()));
            });
         }
      });

      domainClassST.addEntitiesValue(propertyEditorST, name, declaration);

      return null;
   }

   @Override
   protected <T> T visitRelation(Node node) {

      final String name = getString(node, "name");
      if (relations.contains(name)) throw new IllegalStateException("Relation '" + name + "' is defined twice");
      relations.add(name);

      final MetaDomainGroup.PropertyEditorST propertyEditorST = group.newPropertyEditor().
            setName(name);

      for (Relationship propertyRelation : outgoing(node, MetaDomain.Relations.PROPERTY)) {
         visit(other(node, propertyRelation));
         addToPropertyEditor(other(node, propertyRelation), propertyEditorST);
      }

      domainClassST.addRelationsValue(name, propertyEditorST);
      return (T) null;
   }

   @Override
   protected <T> T visitProperty(Node node) {

      final String name = getString(node, MetaDomain.Properties.name.name());
      if (!properties.contains(name))
         domainClassST.addPropertiesValue(name);
      properties.add(name);

      addToPropertyEditor(node, propertyEditorST);

      return null;
   }

   private static void addToPropertyEditor(Node node, MetaDomainGroup.PropertyEditorST propertyEditorST) {
      final String type = getString(node, MetaDomain.Properties.type.name());
      if ("String".equals(type)) {
         propertyEditorST.addPropertiesValue("JTextField", "new String[] { }", getString(node, MetaDomain.Properties.name.name()));
      } else if (type != null && type.toLowerCase().startsWith("boo")) {
         propertyEditorST.addPropertiesValue("JCheckBox", "new String[] { }", getString(node, MetaDomain.Properties.name.name()));
      } else if ("Enum".equals(type)) {

         final Set<String> values = new TreeSet<>();
         for (Relationship relationship : outgoing(node, ENUM_VALUE)) {
            final Node other = other(node, relationship);
            values.add("\"" + other.getProperty(getString(relationship, "property")) + "\"");
         }
         propertyEditorST.addPropertiesValue("JComboBox", "new String[] { " + StringUtil.list(values, ",") + " }", getString(node, MetaDomain.Properties.name.name()));
      }
   }
}
