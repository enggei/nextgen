package com.generator.kotlin;

import nextgen.st.STGenerator;
import nextgen.templates.DomainPatterns;
import nextgen.templates.domain.Domain;
import nextgen.templates.kotlin.*;
import org.junit.Test;

import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static nextgen.templates.DomainPatterns.*;
import static nextgen.templates.KotlinPatterns.*;

public class KotlinTest {

    private File root = new File("src/test/java");
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

        String className = "Country";

        TypeDeclaration longType = newNamedType().setName("Long");
        NullableType nullableLongType = newNullableType(longType);
        TypeDeclaration stringType = newNamedType().setName("String");
        NullableType nullableStringType = newNullableType(stringType);
        TypeDeclaration uuidType = newNamedType().setName("UUID");
        TypeDeclaration countryIsPartOfContinentRelationshipType = newNamedType().setName("CountryIsPartOfContinentRelationship");
        ArrayType countryIsPartOfContinentRelationshipTypeArray = newArrayType().setType(countryIsPartOfContinentRelationshipType);

        FieldDeclaration uuidField = newFieldDeclaration(uuidType, "uuid").setInitializer(
                newExpressionInitializer().setExpression(newFunctionCallExpression().setScope("UUID").setFunctionName("randomUUID"))
        ).setIsNonMember(true);

        List<FieldDeclaration> fields = asList(
                newFieldDeclaration(nullableLongType, "id").setInitializer(newNullInitializer()).setIsNonMember(true),
                uuidField,
                newFieldDeclaration(longType, "epId", true),
                newFieldDeclaration(stringType, "code", true),
                newFieldDeclaration(stringType, "name", true),
                newFieldDeclaration(countryIsPartOfContinentRelationshipTypeArray, "isPartOfContinent", true)
                        .setAnnotations(singletonList(newAnnotationDeclaration()
                                .addAnnotations("Relationship", singletonList(newAnnotationParam()
                                        .addParam("type", "REL_IS_PART_OF")
                                        .addParam("direction", "Relationship.OUTGOING")
                                ))
                        )).setInitializer(newEmptyArrayInitializer())
        );


        String dataClassName = "Thing";
        DataClassDeclaration thingClass = newDataClassDeclaration(dataClassName)
                .setAnnotations(singletonList(newAnnotationDeclaration()
                        .addAnnotations("NodeEntity", singletonList(newAnnotationParam()
                                .addParam("label", newStringLiteralExpression().setLiteral("NODE_THING"))
                        ))
                ))
                .setFields(asList(
                        newFieldDeclaration(nullableLongType, "id").setInitializer(newNullInitializer()),
                        newFieldDeclaration(nullableStringType, "name").setInitializer(newNullInitializer())
                ));

        ClassDeclaration countryClass = newClassDeclaration(className)
                .setAnnotations(singletonList(newAnnotationDeclaration()
                        .addAnnotations("NodeEntity", singletonList(newAnnotationParam()
                                .addParam("label", "NODE_COUNTRY")
                        ))
                ))
                .setIsOpen(true)
                .setFields(fields)
                .setExtends(singletonList(newExtending().setClassName("Entity")
                        .addParams("id")
                        .addParams("uuid")))
                .setOverrideEquals(createEqualsFunction(className,
                        fields.stream().filter(fieldDeclaration -> !fieldDeclaration.getName().equals("id")).collect(Collectors.toList()))
                )
                .setOverrideToString(createToStringFunction(className, fields))
                .setOverrideHashCode(createHashCodeFunction(uuidField))
                .setMembers(singletonList(
                        createCopyFunction(className, fields))
                )
                .setSubclasses(singletonList(thingClass));

        PackageDeclaration packageDeclaration = newPackageDeclaration().setName("org.test");

        List<ImportStatement> imports = asList(
                newImportStatement().setScope("no.tv2.sport.data.domain").setName("NODE_COUNTRY"),
                newImportStatement().setScope("no.tv2.sport.data.domain").setName("REL_IS_PART_OF"),
                newImportStatement().setScope("no.tv2.sport.data.domain.sportsapp").setName("CountryIsPartOfContinentRelationship"),
                newImportStatement().setScope("no.tv2.sport.neo4j").setName("Entity"),
                newImportStatement().setScope("org.neo4j.ogm.annotation").setName("NodeEntity"),
                newImportStatement().setScope("org.neo4j.ogm.annotation").setName("Relationship"),
                newImportStatement().setScope("java.util").setName("*")
        );

        KotlinFile kotlinFile = newKotlinFile()
                .setPackageDeclaration(packageDeclaration)
                .setImports(imports)
                .setCompilationUnit(singletonList(countryClass));

        System.out.println(kotlinFile);

        STGenerator.writeKotlinFile(kotlinFile, packageDeclaration, "CodeGenTests", new File("/media/Storage/projects/tv2/sportsdata-api.tmp/libraries/sportdata-domain/src/main/kotlin"));
    }

    @Test
    public void testExpressions() {

        PairType pairOfStringAndIntType = newPairType().setFirst(newStringType()).setSecond(newIntType());
        FunctionDeclaration testFunction = newFunctionDeclaration()
                .setName("test")
                .setReturnType(pairOfStringAndIntType)
                .setStatements(asList(
                        newVarDeclarationStatement()
                            .setName("aMap")
                            .setType(newMapType()
                                .setFirst(pairOfStringAndIntType.getFirst())
                                .setSecond(pairOfStringAndIntType.getSecond()))
                            .setInitializer(newMutableMapInitializer()),
                        newReturnStatement()
                            .setExpression(newPairExpression()
                                .setFirst(newStringLiteralExpression().setLiteral("Test"))
                                .setSecond(newLiteralExpression().setLiteral("123")))
                ));

        System.out.println(testFunction);
    }
}
