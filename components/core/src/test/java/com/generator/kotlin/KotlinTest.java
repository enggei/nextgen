package com.generator.kotlin;

import nextgen.templates.kotlin.ClassDeclaration;
import nextgen.templates.kotlin.FieldDeclaration;
import nextgen.templates.kotlin.PackageDeclaration;
import nextgen.templates.kotlin.Poko;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static nextgen.templates.kotlin.KotlinST.*;

public class KotlinTest {

   @Test
   public void testKotlin() {
      PackageDeclaration packageDeclaration = newPackageDeclaration().setName("org.test");

      String className = "Country";

      List<FieldDeclaration> fields = Arrays.asList(
         newFieldDeclaration().setName("id").setType("Long").setIsNullable(true).setInitializer("null").setIsNonMember(true),
         newFieldDeclaration().setName("uuid").setType("UUID").setInitializer("UUID.randomUUID()").setIsNonMember(true),
         newFieldDeclaration().setName("epId").setType("Long").setIsMutable(true),
         newFieldDeclaration().setName("code").setType("String").setIsMutable(true),
         newFieldDeclaration().setName("name").setType("String").setIsMutable(true),
         newFieldDeclaration()
            .addAnnotations(newAnnotationDeclaration()
               .addAnnotations("Relationship", newAnnotationParam()
                  .addParam("type", "REL_IS_PART_OF")
                  .addParam("direction", "Relationship.OUTGOING")
               )
            ).setName("isPartOfContinent").setType("Array<CountryIsPartOfContinentRelationship>").setInitializer("arrayOf()").setIsMutable(true)
      );

      ClassDeclaration dataClass = newClassDeclaration()
         .setName(className)
         .setAnnotations(newAnnotationDeclaration()
            .addAnnotations("NodeEntity", newAnnotationParam()
               .addParam("label", "NODE_COUNTRY")
            )
         )
         .setIsOpen(true)
         .addFields(fields)
         .addExtends(newExtending().setClassName("Entity")
            .addParams("id")
            .addParams("uuid"))
         .setOverrideEquals(newOverrideEquals().setClassName(className)
            .addFields(fields.stream().map(FieldDeclaration::getName).filter(n -> !n.equals("id")).toArray())
         )
         ;


      Poko poko = newPoko()
         .setPackageDeclaration(packageDeclaration)
         .setClassDeclaration(dataClass);

      System.out.println(poko);
   }
}
