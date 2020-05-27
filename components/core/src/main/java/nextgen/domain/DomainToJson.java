package nextgen.domain;

import nextgen.domain.domain.*;
import nextgen.java.JavaPatterns;
import nextgen.java.st.ClassOrInterfaceDeclaration;
import nextgen.java.st.EnumDeclaration;
import nextgen.java.st.MethodDeclaration;
import nextgen.java.st.PackageDeclaration;

import java.util.HashMap;
import java.util.Map;

import static com.generator.util.StringUtil.capitalize;
import static nextgen.java.JavaPatterns.*;
import static nextgen.java.VertxPatterns.jsonArrayType;
import static nextgen.java.VertxPatterns.jsonObjectType;

public class DomainToJson extends DomainPatterns {

    private static final String value = "value";
    private static final String node = "jsonObject";

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
                entityClassMap.put(entity, newJsonWrapper(entity.getName()));
                domainClass.addMembers(newEntityInstanceMethod(entity));
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

                final String srcName = relation.getSrc().getName();
                final String dstName = relation.getDst().getName();

                switch (relation.getDst().getType()) {
                    case PRIMITIVE:
                        srcEntity.addMembers(oneToOnePrimitive(srcEntity, relation, dstName));
                        srcEntity.addMembers(getSinglePrimitive(relation, dstName));
                        break;
                    case REFERENCE:
                        srcEntity.addMembers(oneToOneReference(srcEntity, relation, dstName));
                        srcEntity.addMembers(getSingleReference(relation, dstName));
                        break;
                    case EXTERNAL:
                        srcEntity.addFields(newPrivateFieldDeclaration().setName(DomainToPojos.variableName(relation)).setType(newClassOrInterfaceType(dstName)));
                        srcEntity.addMembers(DomainToPojos.oneToOne(srcName, relation, dstName));
                        srcEntity.addMembers(DomainToPojos.getSingle(relation, dstName));
                        srcEntity.addMembers(DomainToPojos.hasPropertyMethodDeclaration(newClassDeclaration(dstName)));
                        break;
                    case ENUM:
                        srcEntity.addMembers(oneToOneEnum(newClassDeclaration(srcName), relation, dstName));
                        srcEntity.addMembers(getSingleEnum(relation, dstName));
                        break;
                }
            }

            @Override
            protected void visitOneToMany(Relation relation) {

                final ClassOrInterfaceDeclaration srcEntity = entityClassMap.get(relation.getSrc());

                final String srcName = relation.getSrc().getName();
                final String dstName = relation.getDst().getName();
                switch (relation.getDst().getType()) {
                    case PRIMITIVE:
                        srcEntity.addMembers(oneToManyPrimitive(srcEntity, relation, dstName));
                        srcEntity.addMembers(getListPrimitive(relation, dstName));
                        break;
                    case REFERENCE:
                        srcEntity.addMembers(oneToManyReference(srcEntity, relation, dstName));
                        srcEntity.addMembers(getListReference(relation, dstName));
                        break;
                    case EXTERNAL:
                        srcEntity.addFields(newPrivateFieldDeclaration().setName(DomainToPojos.variableName(relation)).setType(listOf(newClassOrInterfaceType(dstName))));
                        srcEntity.addMembers(DomainToPojos.getList(relation, dstName));
                        srcEntity.addMembers(DomainToPojos.oneToMany(srcEntity, relation, dstName));
                        break;
                    case ENUM:
                        srcEntity.addMembers(oneToManyEnum(newClassDeclaration(srcName), relation, dstName));
                        srcEntity.addMembers(getListEnum(relation, dstName));
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

    private static MethodDeclaration getListReference(Relation relation, String dstEntity) {
        return newPublicMethodDeclaration("get" + capitalize(relation.getName()), streamOf(newClassOrInterfaceType(dstEntity)))
                .setBlockStmt(newReturnBlockStmt(newMethodCallExpression(newMethodCallExpression(newMethodCallExpression(node, "getJsonArray")
                        .addArguments(newStringLiteralExpression(relation.getName()))
                        .addArguments(newObjectCreationExpression(jsonArrayType)), "stream"), "map")
                        .addArguments(newLambdaExpression(newParameter("o"), newObjectCreationExpression(dstEntity)
                                .addArguments(newCastExpression()
                                        .setType(jsonObjectType)
                                        .setExpression(newExpression("o")))))));
    }

    private static MethodDeclaration getListPrimitive(Relation relation, String dstEntity) {
        return newPublicMethodDeclaration("get" + capitalize(relation.getName()), streamOf(newClassOrInterfaceType(dstEntity)))
                .setBlockStmt(newReturnBlockStmt(newMethodCallExpression(newMethodCallExpression(newMethodCallExpression(node, "getJsonArray")
                        .addArguments(newStringLiteralExpression(relation.getName()))
                        .addArguments(newObjectCreationExpression(jsonArrayType)), "stream"), "map")
                        .addArguments(newLambdaExpression(newParameter("o"), newCastExpression()
                                .setType(newClassOrInterfaceType(dstEntity))
                                .setExpression(newExpression("o"))))));
    }

    private static MethodDeclaration getListEnum(Relation relation, String dstEntity) {
        return newPublicMethodDeclaration("get" + capitalize(relation.getName()), streamOf(newClassOrInterfaceType(dstEntity)))
                .setBlockStmt(newReturnBlockStmt(newMethodCallExpression(newMethodCallExpression(newMethodCallExpression(node, "getJsonArray")
                        .addArguments(newStringLiteralExpression(relation.getName()))
                        .addArguments(newObjectCreationExpression(jsonArrayType)), "stream"), "map")
                        .addArguments(newLambdaExpression(newParameter("o"), newMethodCallExpression(dstEntity, "valueOf", newCastExpression()
                                .setType(StringType)
                                .setExpression(newExpression("o")))))));
    }

    private static MethodDeclaration getSinglePrimitive(Relation relation, String dstEntity) {
        return newPublicMethodDeclaration("get" + capitalize(relation.getName()), newClassOrInterfaceType(dstEntity))
                .setBlockStmt(newReturnBlockStmt(newMethodCallExpression(node, "get" + capitalize(dstEntity), newStringLiteralExpression(relation.getName()))));
    }

    private static MethodDeclaration getSingleReference(Relation relation, String dstEntity) {
        return newPublicMethodDeclaration("get" + capitalize(relation.getName()), newClassOrInterfaceType(dstEntity))
                .setBlockStmt(newReturnBlockStmt(newConditionalExpression()
                        .setCondition(isNull(newMethodCallExpression(node, "getJsonObject", newStringLiteralExpression(relation.getName()))))
                        .setThenExpression(newNull())
                        .setElseExpression(newObjectCreationExpression(dstEntity, newMethodCallExpression(node, "getJsonObject", newStringLiteralExpression(relation.getName()))))));
    }

    private static MethodDeclaration oneToOnePrimitive(ClassOrInterfaceDeclaration srcEntity, Relation relation, String dstEntity) {
        return newPublicMethodDeclaration("set" + capitalize(relation.getName()), newClassOrInterfaceType(srcEntity.getName()))
                .addParameters(newParameter(newClassOrInterfaceType(dstEntity), value))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newMethodCallExpression(node, "put")
                                .addArguments(newStringLiteralExpression(relation.getName()))
                                .addArguments(value)))
                        .addStatements(newReturnThis()));
    }

    private static MethodDeclaration oneToOneEnum(ClassOrInterfaceDeclaration srcEntity, Relation relation, String dstEntity) {
        return newPublicMethodDeclaration("set" + capitalize(relation.getName()), newClassOrInterfaceType(srcEntity.getName()))
                .addParameters(newParameter(newClassOrInterfaceType(dstEntity), value))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newMethodCallExpression(node, "put")
                                .addArguments(newStringLiteralExpression(relation.getName()))
                                .addArguments(newMethodCallExpression(value, "name"))))
                        .addStatements(newReturnThis()));
    }

    private static MethodDeclaration getSingleEnum(Relation relation, String dstEntity) {
        return newPublicMethodDeclaration("get" + capitalize(relation.getName()), newClassOrInterfaceType(dstEntity))
                .setBlockStmt(newReturnBlockStmt(newConditionalExpression()
                        .setCondition(isNull(newMethodCallExpression(node, "getString", newStringLiteralExpression(relation.getName()))))
                        .setThenExpression(newNull())
                        .setElseExpression(newMethodCallExpression(dstEntity, "valueOf", newMethodCallExpression(node, "getString", newStringLiteralExpression(relation.getName()))))));
    }


    private static MethodDeclaration oneToOneReference(ClassOrInterfaceDeclaration srcEntity, Relation relation, String dstEntity) {
        return newPublicMethodDeclaration("set" + capitalize(relation.getName()), newClassOrInterfaceType(srcEntity.getName()))
                .addParameters(newParameter(newClassOrInterfaceType(dstEntity), value))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newMethodCallExpression(node, "put")
                                .addArguments(newStringLiteralExpression(relation.getName()))
                                .addArguments(newMethodCallExpression(value, "getJsonObject"))))
                        .addStatements(newReturnThis()));
    }

    private static MethodDeclaration oneToManyReference(ClassOrInterfaceDeclaration srcEntity, Relation relation, String dstEntity) {
        return newPublicMethodDeclaration("add" + capitalize(relation.getName()), newClassOrInterfaceType(srcEntity.getName()))
                .addParameters(newParameter(newClassOrInterfaceType(dstEntity), value))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newVariableDeclarationExpression(jsonArrayType, "jsonArray", newMethodCallExpression(node, "getJsonArray", newStringLiteralExpression(relation.getName())))))
                        .addStatements(newIfStmt(isNull("jsonArray"), newExpressionStmt(newMethodCallExpression(node, "put")
                                .addArguments(newStringLiteralExpression(relation.getName()))
                                .addArguments(newBinaryExpression()
                                        .setLeft("jsonArray")
                                        .setOperator("=")
                                        .setRight(newObjectCreationExpression(jsonArrayType))))))
                        .addStatements(newExpressionStmt(newMethodCallExpression("jsonArray", "add", newMethodCallExpression(value, "getJsonObject"))))
                        .addStatements(newReturnThis()));
    }

    private static MethodDeclaration oneToManyPrimitive(ClassOrInterfaceDeclaration srcEntity, Relation relation, String dstEntity) {
        return newPublicMethodDeclaration("add" + capitalize(relation.getName()), newClassOrInterfaceType(srcEntity.getName()))
                .addParameters(newParameter(newClassOrInterfaceType(dstEntity), value))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newVariableDeclarationExpression(jsonArrayType, "jsonArray", newMethodCallExpression(node, "getJsonArray", newStringLiteralExpression(relation.getName())))))
                        .addStatements(newIfStmt(isNull("jsonArray"), newExpressionStmt(newMethodCallExpression(node, "put")
                                .addArguments(newStringLiteralExpression(relation.getName()))
                                .addArguments(newBinaryExpression()
                                        .setLeft("jsonArray")
                                        .setOperator("=")
                                        .setRight(newObjectCreationExpression(jsonArrayType))))))
                        .addStatements(newExpressionStmt(newMethodCallExpression("jsonArray", "add", value)))
                        .addStatements(newReturnThis()));
    }

    private static MethodDeclaration oneToManyEnum(ClassOrInterfaceDeclaration srcEntity, Relation relation, String dstEntity) {
        return newPublicMethodDeclaration("add" + capitalize(relation.getName()), newClassOrInterfaceType(srcEntity.getName()))
                .addParameters(newParameter(newClassOrInterfaceType(dstEntity), value))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newVariableDeclarationExpression(jsonArrayType, "jsonArray", newMethodCallExpression(node, "getJsonArray", newStringLiteralExpression(relation.getName())))))
                        .addStatements(newIfStmt(isNull("jsonArray"), newExpressionStmt(newMethodCallExpression(node, "put")
                                .addArguments(newStringLiteralExpression(relation.getName()))
                                .addArguments(newBinaryExpression()
                                        .setLeft("jsonArray")
                                        .setOperator("=")
                                        .setRight(newObjectCreationExpression(jsonArrayType))))))
                        .addStatements(newExpressionStmt(newMethodCallExpression("jsonArray", "add", newMethodCallExpression(value, "name"))))
                        .addStatements(newReturnThis()));
    }

//    private static MethodDeclaration hasPropertyMethodDeclaration(Property property) {
//        return newPublicMethodDeclaration("has" + capitalize(property.getName()), booleanType)
//                .setBlockStmt(newReturnBlockStmt(notNull(newMethodCallExpression(node, jsonGetter(property), newStringLiteralExpression(property.getName())))));
//    }
//
//    private static MethodDeclaration getPropertyMethodDeclaration(Property property) {
//        return newPublicMethodDeclaration("get" + capitalize(property.getName()), asJavaType(property))
//                .setBlockStmt(newReturnBlockStmt(isEnumProperty(property) ?
//                        newMethodCallExpression(property.getEnumType(), "valueOf", newMethodCallExpression(node, jsonGetter(property), newStringLiteralExpression(property.getName()))) :
//                        newMethodCallExpression(node, jsonGetter(property), newStringLiteralExpression(property.getName()))));
//    }
//
//    private static MethodDeclaration setPropertyMethodDeclaration(Entity entity, Property property) {
//        return newPublicMethodDeclaration("set" + capitalize(property.getName()), newClassOrInterfaceType(entity.getName()))
//                .addParameters(newParameter(asJavaType(property), value))
//                .setBlockStmt(newBlockStmt()
//                        .addStatements(newExpressionStmt(newMethodCallExpression(node, "put")
//                                .addArguments(newStringLiteralExpression(property.getName()))
//                                .addArguments(isEnumProperty(property) ? newMethodCallExpression(value, "name") : value)))
//                        .addStatements(newReturnThis()));
//    }

    private static ClassOrInterfaceDeclaration newJsonWrapper(String name) {
        return newPublicClassDeclaration(name)
                .addFields(newPrivateFinalFieldDeclaration(jsonObjectType, node))
                .addMembers(newPublicConstructorDeclaration(name)
                        .setBlockStmt(newBlockStmt(newAssignThisExpression(node, newObjectCreationExpression(jsonObjectType)))))
                .addMembers(newPublicConstructorDeclaration(name, newParameter(jsonObjectType, node))
                        .setBlockStmt(newBlockStmt(newAssignThisVariableExpression(node))))
                .addMembers(newPublicMethodDeclaration("getJsonObject", jsonObjectType)
                        .setBlockStmt(newReturnBlockStmt(newThisVariableExpression(node))))
                .addMembers(newToStringMethod(newMethodCallExpression(node, "encode")))
                .addMembers(newEqualsMethod(newBlockStmt()
                        .addStatements(newIfStmt("this == o", returnTrue()))
                        .addStatements(newIfStmt("o == null || getClass() != o.getClass()", returnFalse()))
                        .addStatements(newExpressionStmt(newFinalVariableDeclarationExpression(newClassOrInterfaceType(name), "other", newCastExpression()
                                .setType(newClassOrInterfaceType(name))
                                .setExpression(newExpression("o")))))
                        .addStatements(newReturnStmt(newMethodCallExpression(node, "equals", newFieldAccessExpression("other", node))))))
                .addMembers(newHashMethod(node));
    }

    private static ClassOrInterfaceDeclaration newJsonFactory(Domain domain) {
        return newPublicClassDeclaration(domain.getName() + "JsonFactory");
    }

    private static MethodDeclaration newEntityInstanceMethod(Entity entity) {
        return newPublicStaticMethodDeclaration("new" + entity.getName(), newClassOrInterfaceType(entity.getName()))
                .setBlockStmt(newReturnBlockStmt(newObjectCreationExpression(entity.getName())));
    }

//    private static String jsonGetter(Property property) {
//        switch (property.getType()) {
//            case STRING:
//                return "getString";
//            case INTEGER:
//                return "getInteger";
//            case DOUBLE:
//                return "getDouble";
//            case BOOLEAN:
//                return "getBoolean";
//            case ENUM:
//                return "getString";
//            case LONG:
//                return "getLong";
//        }
//
//        return "getValue";
//    }
}