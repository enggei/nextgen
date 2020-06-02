package nextgen.domain;

import com.generator.util.StringUtil;
import nextgen.domain.domain.Domain;
import nextgen.domain.domain.Entity;
import nextgen.domain.domain.Relation;
import nextgen.java.JavaPatterns;
import nextgen.java.VertxPatterns;
import nextgen.java.st.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static nextgen.java.JavaPatterns.*;
import static nextgen.java.VertxPatterns.*;

public class DomainToJson extends DomainPatterns {

    private static final String value = "value";
    private static final String jsonObject = "jsonObject";

    private static final MethodCallExpression getJsonObject = newMethodCallExpression(value, "getJsonObject");

    public static void generate(File root, PackageDeclaration packageDeclaration, Domain domain) {
        generate(root.getAbsolutePath(), packageDeclaration.getName(), domain);
    }

    public static void generate(String root, String packageName, Domain domain) {

        final Map<Entity, ClassOrInterfaceDeclaration> entityClassMap = new HashMap<>();

        final PackageDeclaration packageDeclaration = newPackageDeclaration(packageName);
        final ClassOrInterfaceDeclaration domainClass = newJsonFactory(domain);

        new DomainVisitor(domain) {

            @Override
            protected void start(Domain domain) {

            }

            @Override
            protected void onPrimitive(Entity entity) {
                entityClassMap.put(entity, newClass(entity.getName()));
            }

            @Override
            protected void onReference(Entity entity) {
                entityClassMap.put(entity, newJsonWrapper(entity));
                domainClass.addMembers(newEntityInstanceMethod(entity));
                domainClass.addMembers(newExistingInstanceMethod(entity));
            }

            @Override
            protected void onExternal(Entity entity) {
                entityClassMap.put(entity, newClass(entity.getName()));
            }

            @Override
            protected void onEnum(Entity entity) {
                final EnumDeclaration enumDeclaration = newPublicEnumDeclaration(entity.getName());
                entity.getEnumValues().forEach(enumDeclaration::addEntries);
                JavaPatterns.writeToFile(enumDeclaration, packageDeclaration, root);
            }

            @Override
            protected void visitOneToOne(Relation relation) {

                final ClassOrInterfaceDeclaration srcEntity = entityClassMap.get(relation.getSrc());

                switch (relation.getDst().getType()) {
                    case PRIMITIVE:
                        srcEntity.addMembers(oneToOnePrimitive(relation));
                        srcEntity.addMembers(getSinglePrimitive(relation));
                        srcEntity.addMembers(getSinglePrimitiveOrDefault(relation));
                        if (isLexical(relation)) srcEntity.addMembers(getToString(relation));
                        break;
                    case REFERENCE:
                        srcEntity.addMembers(oneToOneReference(relation));
                        srcEntity.addMembers(getSingleReference(relation));
                        break;
                    case EXTERNAL:

                        if (relation.getDst().getName().endsWith("JsonObject")) {
                            srcEntity.addMembers(oneToOnePrimitive(relation));
                            srcEntity.addMembers(getSingleJsonObject(relation));
                            srcEntity.addMembers(getSingleJsonObjectOrDefault(relation));

                        } else if (relation.getDst().getName().endsWith("JsonArray")) {
                            srcEntity.addMembers(oneToOnePrimitive(relation));
                            srcEntity.addMembers(getSingleJsonArray(relation));
                            srcEntity.addMembers(getSingleJsonArrayOrDefault(relation));

                        } else if (relation.getDst().getName().endsWith("Object")) {
                            srcEntity.addMembers(oneToOnePrimitive(relation));
                            srcEntity.addMembers(getObjectReference(relation));
                            srcEntity.addMembers(getObjectReferenceOrDefault(relation));

                        } else {
                            srcEntity.addFields(DomainToPojos.newField(relation));
                            srcEntity.addMembers(DomainToPojos.oneToOne(relation));
                            srcEntity.addMembers(DomainToPojos.getSingle(relation));
                            srcEntity.addMembers(DomainToPojos.hasPropertyMethodDeclaration(relation));
                        }

                        break;
                    case ENUM:
                        srcEntity.addMembers(oneToOneEnum(relation));
                        srcEntity.addMembers(getSingleEnum(relation));
                        break;
                }
            }

            @Override
            protected void visitOneToMany(Relation relation) {

                final ClassOrInterfaceDeclaration srcEntity = entityClassMap.get(relation.getSrc());

                switch (relation.getDst().getType()) {
                    case PRIMITIVE:
                        srcEntity.addMembers(oneToManyPrimitive(relation));
                        srcEntity.addMembers(getListPrimitive(relation));
                        srcEntity.addMembers(clearList(relation));
                        break;
                    case REFERENCE:
                        srcEntity.addMembers(oneToManyReference(relation));
                        srcEntity.addMembers(getListReference(relation));
                        srcEntity.addMembers(removeFromListReference(relation));
                        srcEntity.addMembers(clearList(relation));
                        break;
                    case EXTERNAL:
                        srcEntity.addFields(DomainToPojos.newListField(relation));
                        srcEntity.addMembers(DomainToPojos.getList(relation));
                        srcEntity.addMembers(DomainToPojos.oneToMany(relation));
                        srcEntity.addMembers(DomainToPojos.clearList(relation));
                        break;
                    case ENUM:
                        srcEntity.addMembers(oneToManyEnum(relation));
                        srcEntity.addMembers(getListEnum(relation));
                        srcEntity.addMembers(clearList(relation));
                        break;
                }
            }

            @Override
            protected void end() {

                JavaPatterns.writeToFile(domainClass, packageDeclaration, root);

                for (Map.Entry<Entity, ClassOrInterfaceDeclaration> entry : entityClassMap.entrySet()) {
                    switch (entry.getKey().getType()) {
                        case PRIMITIVE:
                            break;
                        case REFERENCE:

                            final Optional<MethodDeclaration> toString = entry.getValue().getMembers()
                                    .stream()
                                    .filter(classOrInterfaceMember -> classOrInterfaceMember instanceof MethodDeclaration)
                                    .map(classOrInterfaceMember -> (MethodDeclaration) classOrInterfaceMember)
                                    .filter(methodDeclaration -> methodDeclaration.getName().equals("toString"))
                                    .findAny();

                            if (!toString.isPresent())
                                entry.getValue().addMembers(newToStringMethod(newMethodCallExpression(jsonObject, "encode")));

                            JavaPatterns.writeToFile(entry.getValue(), packageDeclaration, root);
                            break;
                        case EXTERNAL:
                            break;
                        case ENUM:
                            JavaPatterns.writeToFile(entry.getValue(), packageDeclaration, root);
                            break;
                    }
                }
            }
        };
    }

    private static MethodDeclaration getToString(Relation relation) {
        return newToStringMethod(newExpression(newMethodCallExpression(jsonObject, getterName(relation.getDst()), newStringLiteralExpression(relation.getName()))));
    }

    private static MethodDeclaration getListReference(Relation relation) {
        return newPublicMethodDeclaration(getterName(relation), streamOf(newClassOrInterfaceType(relation.getDst().getName())))
                .setBlockStmt(newReturnBlockStmt(map(stream(getJsonArrayOrDefault(jsonObject, relation.getName())), newLambdaExpression("o", newObjectCreationExpression(relation.getDst().getName())
                        .addArguments(newCastExpression(jsonObjectType, newExpression("o")))))));
    }

    private static MethodDeclaration clearList(Relation relation) {
        return newPublicMethodDeclaration("clear" + StringUtil.capitalize(relation.getName()), newClassOrInterfaceType(relation.getSrc().getName()))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(put(jsonObject, relation.getName(), newObjectCreationExpression(jsonArrayType))))
                        .addStatements(newReturnThis()));
    }

    private static MethodDeclaration removeFromListReference(Relation relation) {
        return newPublicMethodDeclaration(removeName(relation), newClassOrInterfaceType(relation.getSrc().getName()))
                .addParameters(newParameter(newClassOrInterfaceType(relation.getDst().getName()), "value"))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newFinalVariableDeclarationExpression(jsonArrayType, "jsonArray", getJsonArrayOrDefault(jsonObject, relation.getName()))))
                        .addStatements(newForStmt()
                                .addInitialization(newVariableDeclaration(intType, "i", "0"))
                                .setCompare(newBinaryExpression()
                                        .setLeft("i")
                                        .setOperator("<")
                                        .setRight(newMethodCallExpression("jsonArray", "size")))
                                .addUpdate(newUnaryExpression()
                                        .setExpression(newExpression("i"))
                                        .setOperator("++")
                                        .setIsPostfix(true))
                                .setBody(newBlockStmt()
                                        .addStatements(newExpressionStmt(newFinalVariableDeclarationExpression(jsonObjectType, "o", newMethodCallExpression("jsonArray", "getJsonObject", "i"))))
                                        .addStatements(newIfStmt()
                                                .setCondition(isEqual(getString(newMethodCallExpression("value", "getJsonObject"), "uuid"), getString("o", "uuid")))
                                                .setThen(newBlockStmt()
                                                        .addStatements(newExpressionStmt(newMethodCallExpression("jsonArray", "remove", "i")))
                                                        .addStatements(newReturnThis())))))
                        .addStatements(newReturnThis()));
    }

    private static MethodDeclaration getListPrimitive(Relation relation) {
        return newPublicMethodDeclaration(getterName(relation), streamOf(newClassOrInterfaceType(relation.getDst().getName())))
                .setBlockStmt(newReturnBlockStmt(map(stream(getJsonArrayOrDefault(jsonObject, relation.getName())), newLambdaExpression("o", newCastExpression(newClassOrInterfaceType(relation.getDst().getName()), newExpression("o"))))));
    }

    private static MethodDeclaration getListEnum(Relation relation) {
        return newPublicMethodDeclaration(getterName(relation), streamOf(newClassOrInterfaceType(relation.getDst().getName())))
                .setBlockStmt(newReturnBlockStmt(map(stream(getJsonArrayOrDefault(jsonObject, relation.getName())), newLambdaExpression("o", valueOf(relation.getDst().getName(), newCastExpression(StringType, newExpression("o")))))));
    }

    private static MethodDeclaration getSinglePrimitive(Relation relation) {
        return newPublicMethodDeclaration(getterName(relation), newClassOrInterfaceType(relation.getDst().getName()))
                .setBlockStmt(newReturnBlockStmt(newMethodCallExpression(jsonObject, getterName(relation.getDst()), newStringLiteralExpression(relation.getName()))));
    }

    private static MethodDeclaration getSinglePrimitiveOrDefault(Relation relation) {
        return newPublicMethodDeclaration(getterName(relation), newClassOrInterfaceType(relation.getDst().getName()))
                .addParameters(newParameter(newClassOrInterfaceType(relation.getDst().getName()), "defaultValue"))
                .setBlockStmt(newReturnBlockStmt(newMethodCallExpression(jsonObject, getterName(relation.getDst()), newStringLiteralExpression(relation.getName()), "defaultValue")));
    }

    private static MethodDeclaration getSingleJsonObject(Relation relation) {
        return newPublicMethodDeclaration(getterName(relation), newClassOrInterfaceType(relation.getDst().getName()))
                .setBlockStmt(newReturnBlockStmt(getJsonObject(jsonObject, relation.getName())));
    }

    private static MethodDeclaration getSingleJsonObjectOrDefault(Relation relation) {
        return newPublicMethodDeclaration(getterName(relation), newClassOrInterfaceType(relation.getDst().getName()))
                .addParameters(newParameter(newClassOrInterfaceType(relation.getDst().getName()), "defaultValue"))
                .setBlockStmt(newReturnBlockStmt(getJsonObjectOrDefault(jsonObject, relation.getName(), "defaultValue")));
    }

    private static MethodDeclaration getSingleJsonArray(Relation relation) {
        return newPublicMethodDeclaration(getterName(relation), newClassOrInterfaceType(relation.getDst().getName()))
                .setBlockStmt(newReturnBlockStmt(getJsonArray(jsonObject, relation.getName())));
    }

    private static MethodDeclaration getSingleJsonArrayOrDefault(Relation relation) {
        return newPublicMethodDeclaration(getterName(relation), newClassOrInterfaceType(relation.getDst().getName()))
                .addParameters(newParameter(newClassOrInterfaceType(relation.getDst().getName()), "defaultValue"))
                .setBlockStmt(newReturnBlockStmt(getJsonArrayOrDefault(jsonObject, relation.getName(), "defaultValue")));
    }

    private static MethodDeclaration getSingleReference(Relation relation) {
        return newPublicMethodDeclaration(getterName(relation), newClassOrInterfaceType(relation.getDst().getName()))
                .setBlockStmt(newReturnBlockStmt(newConditionalExpression()
                        .setCondition(isNull(getJsonObject(jsonObject, relation.getName())))
                        .setThenExpression(newNull())
                        .setElseExpression(newObjectCreationExpression(relation.getDst().getName(), getJsonObject(jsonObject, relation.getName())))));
    }

    private static MethodDeclaration getSingleReferenceOrDefault(Relation relation) {
        return newPublicMethodDeclaration(getterName(relation), newClassOrInterfaceType(relation.getDst().getName()))
                .setBlockStmt(newReturnBlockStmt(newConditionalExpression()
                        .setCondition(isNull(getJsonObject(jsonObject, relation.getName())))
                        .setThenExpression(newNull())
                        .setElseExpression(newObjectCreationExpression(relation.getDst().getName(), getJsonObject(jsonObject, relation.getName())))));
    }

    private static MethodDeclaration getObjectReference(Relation relation) {
        return newPublicMethodDeclaration(getterName(relation), newClassOrInterfaceType(relation.getDst().getName()))
                .setBlockStmt(newReturnBlockStmt(getObject(jsonObject, relation.getName())));
    }

    private static MethodDeclaration getObjectReferenceOrDefault(Relation relation) {
        return newPublicMethodDeclaration(getterName(relation), newClassOrInterfaceType(relation.getDst().getName()))
                .addParameters(newParameter(ObjectType, "defaultValue"))
                .setBlockStmt(newReturnBlockStmt(getObjectOrDefault(jsonObject, relation.getName(), "defaultValue")));
    }

    private static MethodDeclaration oneToOnePrimitive(Relation relation) {
        return newPublicMethodDeclaration(setterName(relation), newClassOrInterfaceType(relation.getSrc().getName()))
                .addParameters(asDstParameter(relation))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(put(jsonObject, relation.getName(), value)))
                        .addStatements(newReturnThis()));
    }

    private static Parameter asDstParameter(Relation relation) {
        return newParameter(newClassOrInterfaceType(relation.getDst().getName()), value);
    }

    private static MethodDeclaration oneToOneEnum(Relation relation) {
        return newPublicMethodDeclaration(setterName(relation), newClassOrInterfaceType(relation.getSrc().getName()))
                .addParameters(asDstParameter(relation))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(put(jsonObject, relation.getName(), nameOf(value))))
                        .addStatements(newReturnThis()));
    }

    private static MethodDeclaration getSingleEnum(Relation relation) {
        return newPublicMethodDeclaration(getterName(relation), newClassOrInterfaceType(relation.getDst().getName()))
                .setBlockStmt(newReturnBlockStmt(newConditionalExpression()
                        .setCondition(isNull(getString(jsonObject, relation.getName())))
                        .setThenExpression(newNull())
                        .setElseExpression(valueOf(relation.getDst().getName(), getString(jsonObject, relation.getName())))));
    }


    private static MethodDeclaration oneToOneReference(Relation relation) {
        return newPublicMethodDeclaration(setterName(relation), newClassOrInterfaceType(relation.getSrc().getName()))
                .addParameters(asDstParameter(relation))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(put(jsonObject, relation.getName(), getJsonObject)))
                        .addStatements(newReturnThis()));
    }

    private static MethodDeclaration oneToManyReference(Relation relation) {
        return newPublicMethodDeclaration(adderName(relation), newClassOrInterfaceType(relation.getSrc().getName()))
                .addParameters(asDstParameter(relation))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newVariableDeclarationExpression(jsonArrayType, "jsonArray", getJsonArray(jsonObject, relation.getName()))))
                        .addStatements(newIfStmt(isNull("jsonArray"), newExpressionStmt(put(jsonObject, relation.getName(), newAssignExpression("jsonArray", newObjectCreationExpression(jsonArrayType))))))
                        .addStatements(newExpressionStmt(VertxPatterns.add("jsonArray", getJsonObject)))
                        .addStatements(newReturnThis()));
    }

    private static MethodDeclaration oneToManyPrimitive(Relation relation) {
        return newPublicMethodDeclaration(adderName(relation), newClassOrInterfaceType(relation.getSrc().getName()))
                .addParameters(asDstParameter(relation))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newVariableDeclarationExpression(jsonArrayType, "jsonArray", getJsonArray(jsonObject, relation.getName()))))
                        .addStatements(newIfStmt(isNull("jsonArray"), newExpressionStmt(put(jsonObject, relation.getName(), newAssignExpression("jsonArray", newObjectCreationExpression(jsonArrayType))))))
                        .addStatements(newExpressionStmt(add("jsonArray", value)))
                        .addStatements(newReturnThis()));
    }

    private static MethodDeclaration oneToManyEnum(Relation relation) {
        return newPublicMethodDeclaration(adderName(relation), newClassOrInterfaceType(relation.getSrc().getName()))
                .addParameters(asDstParameter(relation))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newVariableDeclarationExpression(jsonArrayType, "jsonArray", getJsonArray(jsonObject, relation.getName()))))
                        .addStatements(newIfStmt(isNull("jsonArray"), newExpressionStmt(put(jsonObject, relation.getName(), newAssignExpression("jsonArray", newObjectCreationExpression(jsonArrayType))))))
                        .addStatements(newExpressionStmt(add("jsonArray", newMethodCallExpression(value, "name"))))
                        .addStatements(newReturnThis()));
    }

    private static ClassOrInterfaceDeclaration newJsonWrapper(Entity entity) {
        return newPublicClassDeclaration(entity.getName())
                .addFields(newPrivateFinalFieldDeclaration(jsonObjectType, jsonObject))
                .addMembers(newPublicConstructorDeclaration(entity.getName())
                        .setBlockStmt(newBlockStmt()
                                .addStatements(newExpressionStmt(newAssignThisExpression(jsonObject, newObjectCreationExpression(jsonObjectType))))
                                .addStatements(newExpressionStmt(put(jsonObject, "uuid", newToString(newMethodCallExpression(UUIDType, "randomUUID")))))))
                .addMembers(newPublicConstructorDeclaration(entity.getName(), newParameter(jsonObjectType, jsonObject))
                        .setBlockStmt(newBlockStmt()
                                .addStatements(newExpressionStmt(newAssignThisVariableExpression(jsonObject)))
                                .addStatements(newExpressionStmt(newVariableDeclaration(StringType, "uuidString", getString(jsonObject, "uuid"))))
                                .addStatements(newIfStmt(isNull("uuidString"), newExpressionStmt(put(jsonObject, "uuid", newToString(newMethodCallExpression(UUIDType, "randomUUID"))))))))
                .addMembers(newPublicMethodDeclaration("getJsonObject", jsonObjectType)
                        .setBlockStmt(newReturnBlockStmt(newThisVariableExpression(jsonObject))))
                .addMembers(newEqualsMethod(entity.getName(), isEqual(getString(jsonObject, "uuid"), getString(newMethodCallExpression("other", "getJsonObject"), "uuid"))))
                .addMembers(newHashMethod(getString(jsonObject, "uuid")));
    }

    private static ClassOrInterfaceDeclaration newJsonFactory(Domain domain) {
        return newPublicClassDeclaration(domain.getName() + "JsonFactory");
    }

    private static MethodDeclaration newEntityInstanceMethod(Entity entity) {
        return newPublicStaticMethodDeclaration("new" + entity.getName(), newClassOrInterfaceType(entity.getName()))
                .setBlockStmt(newReturnBlockStmt(newObjectCreationExpression(entity.getName())));
    }

    private static MethodDeclaration newExistingInstanceMethod(Entity entity) {
        return newPublicStaticMethodDeclaration("new" + entity.getName(), newClassOrInterfaceType(entity.getName()))
                .addParameters(newParameter(jsonObjectType, jsonObject))
                .setBlockStmt(newReturnBlockStmt(newObjectCreationExpression(entity.getName(), jsonObject)));
    }
}