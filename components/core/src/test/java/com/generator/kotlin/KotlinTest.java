package com.generator.kotlin;

import nextgen.templates.DomainPatterns;
import nextgen.templates.domain.Domain;
import nextgen.templates.domain.DomainST;
import nextgen.templates.kotlin.ClassDeclaration;
import nextgen.templates.kotlin.FieldDeclaration;
import nextgen.templates.kotlin.PackageDeclaration;
import nextgen.templates.kotlin.Poko;
import org.junit.Test;
import org.test.json.KotlinTestJsonFactory;
import org.test.neo4j.Capitol;
import org.test.neo4j.Country;
import org.test.neo4j.KotlinTestNeoFactory;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Collectors;

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
                .setOverrideEquals(newOverrideEquals()
                        .setClassName(className)
                        .setFields(fields.stream()
                                .map(FieldDeclaration::getName)
                                .filter(name -> !name.equals("id"))
                                .collect(Collectors.toList())));


        Poko poko = newPoko()
                .setPackageDeclaration(packageDeclaration)
                .setClassDeclaration(dataClass);

        System.out.println(poko);
    }
}
