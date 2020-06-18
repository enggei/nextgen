package com.generator.kotlin;

import nextgen.templates.DomainPatterns;
import nextgen.templates.domain.Domain;
import nextgen.templates.kotlin.*;
import org.junit.Test;
import org.test.json.KotlinTestJsonFactory;
import org.test.neo4j.Country;
import org.test.neo4j.KotlinTestNeoFactory;

import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static nextgen.templates.DomainPatterns.*;
import static nextgen.templates.kotlin.KotlinST.*;

public class KotlinTest {

    private File root = new File("src/test/java");
    private File db = new File("src/test/java/db");

    @Test
    public void testNeo4J() {

        final KotlinTestNeoFactory db = new KotlinTestNeoFactory(this.db.getAbsolutePath());

        db.doInTransaction(transaction -> {

            for (int i = 0; i < 100; i++) {
                final Country sverige = db.findAllCountryByName("Sverige").findAny().orElseGet(() -> db.newCountry().setName("Sverige"));

                final Country norge = db.newCountry().setName("Norge").setId(1L)
                        .addCities(db.newCity().setName("Oslo"))
                        .addCities(db.newCity().setName("Bergen"));
            }
        });

        db.doInTransaction(transaction -> {

            db.findAllCountry().forEach(country -> System.out.println(country.getName()));

            db.findOrCreateCapitolByName("Sverige");


            // post as json:

            db.findAllCountry().forEach(country ->  {
                System.out.println(KotlinTestJsonFactory.newCountry().setName(country.getName()));
            });


        });


    }

    @Test
    public void testKotlinDomain() {

        final Domain domain = DomainPatterns.newDomain("KotlinDomain")
                .setPackageName("org.test")
                .setName("KotlinTest")
                .addEntities(newEntity("Country")
                        .addRelations(newStringField("name"))
                        .addRelations(newLongField("id"))
                        .addRelations(newExternalRef("map", File.class))
                        .addRelations(newExternalRef("population", AtomicInteger.class))
                        .addRelations(newRef("capitol", newEntity("Capitol")
                                .addRelations(newStringField("name"))))
                        .addRelations(newList("cities", newEntity("City")
                                .addRelations(newStringField("name"))
                                .addRelations(newLongField("population")))));

        DomainPatterns.writePojo(root, "org.test", domain);
        DomainPatterns.writeJsonWrapper(root, "org.test.json", domain);
        DomainPatterns.writeNeo(root, "org.test.neo4j", domain);
    }

    @Test
    public void testKotlin() {
        PackageDeclaration packageDeclaration = newPackageDeclaration().setName("org.test");

        String className = "Country";

        TypeDeclaration longType = newNamedType().setName("Long");
        TypeDeclaration stringType = newNamedType().setName("String");
        TypeDeclaration uuidType = newNamedType().setName("UUID");
        TypeDeclaration countryIsPartOfContinentRelationshipType = newNamedType().setName("CountryIsPartOfContinentRelationship");
        ArrayType countryIsPartOfContinentRelationshipTypeArray = newArrayType().setType(countryIsPartOfContinentRelationshipType);

        List<FieldDeclaration> fields = asList(
                newFieldDeclaration().setName("id").setType(longType).setIsNullable(true).setInitializer(newNullInitializer()).setIsNonMember(true),
                newFieldDeclaration().setName("uuid").setType(uuidType).setInitializer(
                   newExpressionInitializer().setExpression(newFunctionCallExpression().setScope("UUID").setFunctionName("randomUUID"))
                ).setIsNonMember(true),
                newFieldDeclaration().setName("epId").setType(longType).setIsMutable(true),
                newFieldDeclaration().setName("code").setType(stringType).setIsMutable(true),
                newFieldDeclaration().setName("name").setType(stringType).setIsMutable(true),
                newFieldDeclaration()
                    .addAnnotations(singletonList(newAnnotationDeclaration()
                       .addAnnotations("Relationship", singletonList(newAnnotationParam()
                          .addParam("type", "REL_IS_PART_OF")
                          .addParam("direction", "Relationship.OUTGOING")
                       ))
                    )).setName("isPartOfContinent").setType(countryIsPartOfContinentRelationshipTypeArray).setInitializer(newEmptyArrayInitializer()).setIsMutable(true)
        );

        ClassDeclaration dataClass = newClassDeclaration()
                .setName(className)
                .setAnnotations(singletonList(newAnnotationDeclaration()
                        .addAnnotations("NodeEntity", singletonList(newAnnotationParam()
                           .addParam("label", "NODE_COUNTRY")
                        ))
                ))
                .setIsOpen(true)
                .addFields(fields)
                .addExtends(newExtending().setClassName("Entity")
                        .addParams("id")
                        .addParams("uuid"))
                .setOverrideEquals(newOverrideEquals()
                        .setClassName(className)
                        .setFields(fields.stream()
                                .map(FieldDeclaration::getName)
                                .filter(name -> !name.equals("id"))
                                .collect(Collectors.toList())))
                .setOverrideHashCode(newOverrideHashCode())
           ;


        Poko poko = newPoko()
                .setPackageDeclaration(packageDeclaration)
                .setClassDeclaration(dataClass);

        System.out.println(poko);
    }
}
