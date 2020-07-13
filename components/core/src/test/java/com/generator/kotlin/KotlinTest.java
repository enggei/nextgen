package com.generator.kotlin;

import nextgen.templates.DomainPatterns;
import nextgen.templates.KotlinPatterns;
import nextgen.templates.domain.Domain;
import nextgen.templates.kotlin.*;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static nextgen.templates.DomainPatterns.*;
import static nextgen.templates.KotlinPatterns.newEnumField;
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
        TypeDeclaration mutableSetOfStrings = newMutableSetType().setType(stringType);

        ParameterDeclaration uuidField = newParameterDeclaration(uuidType, "uuid", newFunctionCallExpression().setScope("UUID").setFunctionName("randomUUID"));
        ParameterDeclaration idField = newParameterDeclaration(nullableLongType, "id", newNullExpression());

        List<PropertyDeclaration> properties = asList(
                newPropertyDeclaration(longType, "epId", true),
                newPropertyDeclaration(stringType, "code", true),
                newPropertyDeclaration(stringType, "name", true),
                newPropertyDeclaration(countryIsPartOfContinentRelationshipTypeArray, "isPartOfContinent", newEmptyArrayInitializer(), true)
                        .setAnnotations(singletonList(newAnnotationDeclaration("Relationship",
                                asList(newAssignExpression("type", "REL_IS_PART_OF"),
                                        newAssignExpression("direction", "Relationship.OUTGOING")
                                ))
                        ))
        );

        List<ParameterDefinition> parameters = asList(
                idField,
                uuidField
        );

        List<ParameterDefinition> fields = new ArrayList<>();
        fields.addAll(parameters);
        fields.addAll(properties);

        String dataClassName = "Thing";
        DataClassDeclaration thingClass = newDataClassDeclaration(dataClassName)
                .setAnnotations(singletonList(newAnnotationDeclaration("NodeEntity", singletonList(
                        newAssignExpression("label", newStringValueExpression("NODE_THING"))))
                ))
                .setFields(asList(
                        newPropertyDeclaration(nullableLongType, "id").setInitializer(newNullExpression()),
                        newPropertyDeclaration(nullableStringType, "name").setInitializer(newNullExpression()),
                        newPropertyDeclaration(mutableSetOfStrings, "stuff").setInitializer(newMutableSetInitializer())
                ));

        NamedType anotherThingType = newNamedType().setName("AnotherThing");
        InterfaceDeclaration anotherThingsInterface = newInterfaceDeclaration(anotherThingType.getName());

        NamedType somethingType = newNamedType().setName("Something");
        InterfaceDeclaration somethingInterface = newInterfaceDeclaration(somethingType.getName()).addExtends(newImplementingInterface(anotherThingType));

        CompanionObject companionObject = newCompanionObject()
                .setObjectDeclaration(newObjectDeclaration()
                    .addFields(
                            newPropertyDeclaration(newNamedType().setName("Logger"), "log",
                                    newFunctionCallExpression()
                                            .setScope("LoggerFactory")
                                            .setFunctionName("getLogger")
                                            .addArguments(
                                                    newReferenceExpression(className, newPropertyAccessorExpression(
                                                                    newLiteralExpression("class"),
                                                                    newLiteralExpression("java")
                                                            )
                                                    )
                                            )
                            ).setIsPrivate(true))
                );

        NamedType entityType = newNamedType().setName("Entity");

        ClassDeclaration countryClass = newClassDeclaration(className)
                .setAnnotations(singletonList(newAnnotationDeclaration("NodeEntity", singletonList(
                        newAssignExpression("label", "NODE_COUNTRY"))
                )))
                .setIsOpen(true)
                .setFields(fields)
                .setExtends(asList(
                        newExtendingClass(entityType,
                                asList(newLiteralExpression("id"), newLiteralExpression("uuid"))
                        ),
                        newImplementingInterface().setType(somethingType)
                ))
                .setCompanionObject(companionObject)
                .setOverrideEquals(createEqualsFunction(className,
                        fields.stream().filter(fieldDeclaration -> !Objects.equals(getNameFromParameterDefinition(fieldDeclaration), "id")).collect(Collectors.toList()))
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
                newImportStatement().setScope("org.slf4j").setName("Logger"),
                newImportStatement().setScope("org.slf4j").setName("LoggerFactory"),
                newImportStatement().setScope("java.util").setName("*")
        );

        KotlinFile kotlinFile = newKotlinFile()
                .setPackageDeclaration(packageDeclaration)
                .setImports(imports)
                .setCompilationUnit(asList(
                        anotherThingsInterface,
                        somethingInterface,
                        countryClass
                ));

        System.out.println(kotlinFile);

//        STGenerator.writeKotlinFile(kotlinFile, packageDeclaration, "CodeGenTests", new File("/media/Storage/projects/tv2/sportsdata-api.tmp/libraries/sportdata-domain/src/main/kotlin"));
    }

    @Test
    public void testExpressions() {

        PairType pairOfStringAndIntType = newPairType(newStringType(), newIntType());
        FunctionDeclaration testFunction = newFunctionDeclaration()
                .setName("test")
                .setReturnType(pairOfStringAndIntType)
                .setStatements(asList(
                        newVarDeclarationStatement(
                                "aMap",
                                newMapType(pairOfStringAndIntType),
                                newMutableMapInitializer()),
                        newReturnStatement(newPairExpression()
                                .setFirst(newStringValueExpression("Test"))
                                .setSecond(newLiteralExpression("123")))
                ));

        System.out.println(testFunction);
    }

    @Test
    public void testAnonymousObject() {

        NamedType mouseAdapterType = newNamedType().setName("MouseAdapter");

        ObjectExpression objectExpression = newObjectExpression()
                .addExtends(newExtendingClass(mouseAdapterType, singletonList(newNullExpression())))
                .addFields(
                        newPropertyDeclaration(newIntType(), "abc", newLiteralExpression("0")).setIsPrivate(true)
                );
        VarDeclarationStatement varDeclarationStatement = newVarDeclarationStatement("a", true, objectExpression).setName("a");

        System.out.println(varDeclarationStatement);
    }

    @Test
    public void testObjectDeclaration() {

        ObjectDeclaration objectDeclaration = newObjectDeclaration()
                .setName("DataProviderManager")
//                .addExtends(newImplementingInterface("Whatever"))
//                .addExtends(newExtendingClass("Manager"))
                .addMembers(newFunctionDeclaration().setName("registerDataProvider").addParams(newFunctionParam().setName("provider").setTypeDeclaration(newNamedType().setName("DataProvider"))))
                ;

        System.out.println(objectDeclaration);
    }

    @Test
    public void testRawStringExpression() {

        VarDeclarationStatement rawStringTest = newVarDeclarationStatement("raw", newRawStringExpression(
                "This is a raw \\unescaped\\ String\n" +
                        "on multiple lines\n" +
                        "$$$"
        ));

        System.out.println(rawStringTest);
    }

    @Test
    public void testIfStatement() {

        IfStatement ifStatement = newIfStatement()
                .setLogicalExpression(
                        newLogicalExpression(
                                newLiteralExpression("a"),
                                LogicalOperator.and,
                                newLiteralExpression("b")
                        )
                ).setStatements(
                        singletonList(newReturnStatement(newNullExpression()))
                );

        System.out.println(ifStatement);
    }

    @Test
    public void testIfExpression() {

        IfExpression ifExpression = newIfExpression(
                        newLogicalExpression(
                                newLiteralExpression("a"),
                                LogicalOperator.and,
                                newLiteralExpression("b")
                        ),
                newStringValueExpression("FALSE"),
                newStringValueExpression("TRUE")
        );

        VarDeclarationStatement varDeclarationStatement = newVarDeclarationStatement("c", ifExpression);

        System.out.println(varDeclarationStatement);
    }

    @Test
    public void testEnumClassDeclaration() {

        EnumClassDeclaration enumClassDeclaration = newEnumClassDeclaration()
                .setName("Gender")
                .setParams(singletonList(newPropertyDeclaration(newStringType(), "code")))
                .setValues(
                        asList(
                                newEnumField().setName("male").setInputs(singletonList(newStringValueExpression("M"))),
                                newEnumField().setName("female").setInputs(singletonList(newStringValueExpression("F")))
                        )
                );

        System.out.println(enumClassDeclaration);
    }

    @Test
    public void testNeo4jOgmBaseDomainEntities() {

        String basePackageName = "dev.linguafranca.domain.neo4j";
        String conversionPackageName = basePackageName + ".conversion";

        KotlinFile neo4jOgmUUIDAttributeConverter = newKotlinFile(
                newPackageDeclaration(conversionPackageName),
                singletonList(createNeo4jOgmUuidAttributeConverterClass())
        );

        System.out.println(neo4jOgmUUIDAttributeConverter);

        KotlinFile neo4jOgmBaseDomainEntities = newKotlinFile(
                newPackageDeclaration(basePackageName),
                asList(
                        createNeo4jOgmAbstractEntityClass(),
                        createNeo4jOgmEnumNodeInterface(),
                        createNeo4jOgmRelationshipInterface()
                ),
                singletonList(
                        newImportStatement(conversionPackageName, "UUIDAttributeConverter")
                )
        );

        System.out.println(neo4jOgmBaseDomainEntities);
    }

    @Test
    public void testLinguaFrancaDomainModel() {

        final String annotationScopeOgm = "org.neo4j.ogm.annotation";
        final String annotationScopeOgmTypeconversion = "org.neo4j.ogm.annotation.typeconversion";

        TypeDeclaration longType = newNamedType().setName("Long");
        NullableType nullableLongType = newNullableType(longType);
        TypeDeclaration stringType = newNamedType().setName("String");
        NullableType nullableStringType = newNullableType(stringType);
        TypeDeclaration uuidType = newNamedType().setName("java.util.UUID");
        NamedType entityType = newNamedType().setName("Entity");

        ParameterDeclaration idField = newParameterDeclaration(nullableLongType, "id", newNullExpression());
        ParameterDeclaration uuidField = newParameterDeclaration(uuidType, "uuid", newFunctionCallExpression().setScope("java.util.UUID").setFunctionName("randomUUID"));

        List<PropertyDeclaration> ipaProperties = singletonList(
                newPropertyDeclaration(stringType, "ipa", true)
                        .addAnnotations(newAnnotationDeclaration(annotationScopeOgm, "Index", singletonList(newAssignExpression("unique", newLiteralExpression("true")))))
        );

        List<ParameterDefinition> ipaParameters = asList(
                idField,
                uuidField
        );

        List<ParameterDefinition> ipaFields = new ArrayList<>();
        ipaFields.addAll(ipaParameters);
        ipaFields.addAll(ipaProperties);

        // IPA
        final NamedType ipaType = newNamedType().setName("IPA");
        final String ipaClassName = ipaType.getName();
        AnnotationDeclaration nodeEntityAnnotation = newAnnotationDeclaration(annotationScopeOgm, "NodeEntity");

        ClassDeclaration ipa = newClassDeclaration("IPA")
                .setIsOpen(true)
                .addAnnotations(nodeEntityAnnotation)
                .setFields(ipaFields)
                .setExtends(singletonList(
                        newExtendingClass(entityType,
                                asList(newLiteralExpression("id"), newLiteralExpression("uuid"))
                        )
                ))
                .setOverrideEquals(createEqualsFunction(ipaClassName,
                        ipaFields.stream().filter(fieldDeclaration -> !Objects.equals(getNameFromParameterDefinition(fieldDeclaration), "id")).collect(Collectors.toList()))
                )
                .setOverrideToString(createToStringFunction(ipaClassName, ipaFields))
                .setOverrideHashCode(createHashCodeFunction(uuidField))
                .setMembers(singletonList(
                        createCopyFunction(ipaClassName, ipaFields))
                );

        System.out.println(ipa);

        // LexicalClassification
        final NamedType lexicalClassificationType = newNamedType().setName("LexicalClassification");
        final String lexicalClassificationClassName = lexicalClassificationType.getName();
        final NamedType functionalClassificationType = newNamedType().setName("FunctionalClassification");
        final String functionalClassificationEnumName = functionalClassificationType.getName();
        TypeDeclaration enumStarTemplate = newTemplateType()
                .setName("Enum")
                .setTemplates(singletonList(newStarType()));
        NamedType enumNodeType = newNamedType().setName("EnumNode");

        EnumClassDeclaration functionalClassificationEnum = newEnumClassDeclaration(functionalClassificationEnumName,
                buildEnumFields(
                        "Adjective",
                        "Adverb",
                        "Noun",
                        "Verb",
                        "Interjection",
                        "AuxiliaryVerb",
                        "Clitic",
                        "Coverb",
                        "Conjunction",
                        "Determiner",
                        "Particle",
                        "Classifier",
                        "Adposition",
                        "Preverb",
                        "Pronoun",
                        "Contraction",
                        "CardinalNumber"
                ))
                .setComments(newSingleLineComment(" From https://en.wikipedia.org/wiki/Part_of_speech#Functional_classification"));

        List<PropertyDeclaration> lexicalClassificationProperties = singletonList(
                newPropertyDeclaration(functionalClassificationType, "classification", true)
                        .setIsAbstract(true)
        );

        List<ParameterDefinition> lexicalClassificationParameters = asList(
                idField,
                uuidField
        );

        List<ParameterDefinition> lexicalClassificationFields = new ArrayList<>(lexicalClassificationParameters);

        ClassDeclaration lexicalClassification = newClassDeclaration(lexicalClassificationClassName)
                .setIsAbstract(true)
                .setSubclasses(singletonList(functionalClassificationEnum))
                .setProperties(lexicalClassificationProperties)
                .setMembers(singletonList(
                        newFunctionDeclaration("enumVal", enumStarTemplate)
                                .setOverride(true)
                                .setStatements(singletonList(newTodoStatement("not implemented")))
                ))
                .setFields(lexicalClassificationFields)
                .setExtends(asList(
                        newExtendingClass(entityType,
                                asList(newLiteralExpression("id"), newLiteralExpression("uuid"))
                        ),
                        newImplementingInterface(enumNodeType)
                ));

        System.out.println(lexicalClassification);
    }
}
