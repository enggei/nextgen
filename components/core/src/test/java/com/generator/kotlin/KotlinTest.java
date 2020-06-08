package com.generator.kotlin;

import nextgen.templates.kotlin.ClassDeclaration;
import nextgen.templates.kotlin.PackageDeclaration;
import nextgen.templates.kotlin.Poko;
import org.junit.Test;

import static nextgen.templates.kotlin.KotlinST.*;

public class KotlinTest {

   @Test
   public void testKotlin() {
      PackageDeclaration packageDeclaration = newPackageDeclaration().setName("org.test");

      ClassDeclaration dataClass = newClassDeclaration()
         .setName("Country")
         .setAnnotations(newAnnotationDeclaration()
            .addAnnotations("NodeEntity", newAnnotationParam()
               .addParam("label", "NODE_COUNTRY")
            )
         )
         .setIsOpen(true)
         .addFields(newFieldDeclaration().setName("id").setType("Long").setIsNullable(true).setInitializer("null").setIsNonMember(true))
         .addFields(newFieldDeclaration().setName("uuid").setType("UUID").setInitializer("UUID.randomUUID()").setIsNonMember(true))
         .addFields(newFieldDeclaration().setName("epId").setType("Long").setIsMutable(true))
         .addFields(newFieldDeclaration().setName("code").setType("String").setIsMutable(true))
         .addFields(newFieldDeclaration().setName("name").setType("String").setIsMutable(true))
         .addFields(newFieldDeclaration()
            .addAnnotations(newAnnotationDeclaration()
               .addAnnotations("Relationship", newAnnotationParam()
                  .addParam("type", "REL_IS_PART_OF")
                  .addParam("direction", "Relationship.OUTGOING")
               )
            ).setName("isPartOfContinent").setType("Array<CountryIsPartOfContinentRelationship>").setInitializer("arrayOf()").setIsMutable(true))
         ;

      Poko poko = newPoko()
         .setPackageDeclaration(packageDeclaration)
         .setClassDeclaration(dataClass);

      System.out.println(poko);
   }
}
