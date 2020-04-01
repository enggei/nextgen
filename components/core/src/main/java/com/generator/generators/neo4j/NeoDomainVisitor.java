package com.generator.generators.neo4j;

import org.neo4j.graphdb.Node;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class NeoDomainVisitor {

   public void visit(Node domainNode) {

      final Map<String, NeoDomainGenerator.NeoEntity> entityMap = new LinkedHashMap<>();

      Neo4jDomainPlugin.outgoingENTITIES(domainNode, (entityRelation, entityNode) -> {

         final NeoDomainGenerator.NeoEntity neoEntity = new NeoDomainGenerator.NeoEntity(Neo4jDomainPlugin.getNameProperty(entityNode, "NULL"));
         entityMap.put(Neo4jDomainPlugin.getNameProperty(entityNode, "NULL"), neoEntity);

         Neo4jDomainPlugin.outgoingENTITY_PROPERTIES(entityNode, (propertyRelation, propertyNode) -> {
            final NeoDomainGenerator.NeoProperty neoProperty = new NeoDomainGenerator.NeoProperty(Neo4jDomainPlugin.getNameProperty(propertyNode), Neo4jDomainPlugin.getIsRequiredProperty(propertyNode, Boolean.FALSE), Neo4jDomainPlugin.getIsUniqueProperty(propertyNode, Boolean.FALSE), NeoDomainGenerator.NeoPropertyType.valueOf(Neo4jDomainPlugin.getTypeProperty(propertyNode, "")));
            Neo4jDomainPlugin.outgoingPROPERTYENUMS(propertyNode, (enumRelation, propertyEnumNode) -> neoProperty.addEnumValue(Neo4jDomainPlugin.getNameProperty(propertyEnumNode)));
            neoEntity.add(neoProperty);
         });

         visitNeoEntity(neoEntity);
      });

      Neo4jDomainPlugin.outgoingRELATIONS(domainNode, (relationRelation, relationNode) -> {

         final Node srcNode = Neo4jDomainPlugin.singleOutgoingSRC(relationNode);
         if (srcNode == null) return;
         final Node dstNode = Neo4jDomainPlugin.singleOutgoingDST(relationNode);
         if (dstNode == null) return;

         final NeoDomainGenerator.NeoRelation neoRelation = new NeoDomainGenerator.NeoRelation(Neo4jDomainPlugin.getNameProperty(relationNode), Neo4jDomainPlugin.getNameProperty(srcNode), Neo4jDomainPlugin.getNameProperty(dstNode), NeoDomainGenerator.Cardinality.valueOf(Neo4jDomainPlugin.getCardinalityProperty(relationNode)));

         Neo4jDomainPlugin.outgoingRELATION_PROPERTIES(relationNode, (propertyRelation, propertyNode) -> {
            final NeoDomainGenerator.NeoProperty neoProperty = new NeoDomainGenerator.NeoProperty(Neo4jDomainPlugin.getNameProperty(propertyNode), Neo4jDomainPlugin.getIsRequiredProperty(propertyNode, Boolean.FALSE), Neo4jDomainPlugin.getIsUniqueProperty(propertyNode, Boolean.FALSE), NeoDomainGenerator.NeoPropertyType.valueOf(Neo4jDomainPlugin.getTypeProperty(propertyNode, "")));
            Neo4jDomainPlugin.outgoingPROPERTYENUMS(propertyNode, (enumRelation, propertyEnumNode) -> neoProperty.addEnumValue(Neo4jDomainPlugin.getNameProperty(propertyEnumNode)));
            neoRelation.add(neoProperty);
         });

         visitNeoRelation(neoRelation, entityMap.get(Neo4jDomainPlugin.getNameProperty(srcNode, "NULL")), entityMap.get(Neo4jDomainPlugin.getNameProperty(dstNode, "NULL")));
      });

      Neo4jDomainPlugin.outgoingFUNCTIONS(domainNode, (entityRelation, functionNode) -> {

         final NeoDomainGenerator.NeoFunction neoFunction = new NeoDomainGenerator.NeoFunction(Neo4jDomainPlugin.getNameProperty(functionNode, "NULL"));

         Neo4jDomainPlugin.outgoingFUNCTION_PROPERTIES(functionNode, (propertyRelation, propertyNode) -> {
            final NeoDomainGenerator.NeoProperty neoProperty = new NeoDomainGenerator.NeoProperty(Neo4jDomainPlugin.getNameProperty(propertyNode), Neo4jDomainPlugin.getIsRequiredProperty(propertyNode, Boolean.FALSE), Neo4jDomainPlugin.getIsUniqueProperty(propertyNode, Boolean.FALSE), NeoDomainGenerator.NeoPropertyType.valueOf(Neo4jDomainPlugin.getTypeProperty(propertyNode, "")));
            Neo4jDomainPlugin.outgoingPROPERTYENUMS(propertyNode, (enumRelation, propertyEnumNode) -> neoProperty.addEnumValue(Neo4jDomainPlugin.getNameProperty(propertyEnumNode)));
            neoFunction.add(neoProperty);
         });

         visitNeoFunction(neoFunction);
      });
   }

   protected void visitNeoRelation(NeoDomainGenerator.NeoRelation neoRelation, NeoDomainGenerator.NeoEntity src, NeoDomainGenerator.NeoEntity dst) {

   }

   protected void visitNeoEntity(NeoDomainGenerator.NeoEntity neoEntity) {

   }

   protected void visitNeoFunction(NeoDomainGenerator.NeoFunction neoFunction) {

   }
}
