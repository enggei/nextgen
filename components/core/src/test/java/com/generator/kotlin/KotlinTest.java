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
         .addFields(newFieldDeclaration().addFields(false, true, "id", "Long?", "null"))
         .addFields(newFieldDeclaration().addFields(false, true, "uuid", "UUID", "UUID.randomUUID()"))
         .addFields(newFieldDeclaration().addFields(true, false, "epId", "Long", null))
         .addFields(newFieldDeclaration().addFields(true, false, "code", "String", null))
         .addFields(newFieldDeclaration().addFields(true, false, "name", "String", null))
         .addFields(newFieldDeclaration()
            .addAnnotations(newAnnotationDeclaration()
               .addAnnotations("Relationship", newAnnotationParam()
                  .addParam("type", "REL_IS_PART_OF")
                  .addParam("direction", "Relationship.OUTGOING")
               )
            )
            .addFields(true, false, "isPartOfContinent", "Array<CountryIsPartOfContinentRelationship>", "arrayOf()"))
         ;

      Poko poko = newPoko()
         .setPackageDeclaration(packageDeclaration)
         .setClassDeclaration(dataClass);

      System.out.println(poko);
   }
}
