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

        domain.getEntities().forEach(entity -> {

            final boolean isPrimitiveOrExternal = isPrimitive(entity) || isExternal(entity);

            entityClassMap.put(entity, isPrimitiveOrExternal ? newClassOrInterfaceDeclaration().setName(entity.getName()) : newJsonWrapper(entity.getName()));

            // do not process primitive entities, they represent an existing type (String, Long, etc)
            if (isPrimitiveOrExternal) return;

            domainClass.addMembers(newEntityInstanceMethod(entity));
        });

        domain.getRelations().forEach(relation -> {

            final ClassOrInterfaceDeclaration srcEntity = entityClassMap.get(relation.getSrc());
            final ClassOrInterfaceDeclaration dstEntity = entityClassMap.get(relation.getDst());
            if (srcEntity == null)
                throw new IllegalStateException("srcEntity for " + relation.getName() + " is not registered in domain " + domain.getName());
            if (dstEntity == null)
                throw new IllegalStateException("dstEntity for " + relation.getName() + " is not registered in domain " + domain.getName());

            final boolean primitive = isPrimitive(relation.getDst());
            final boolean external = isExternal(relation.getDst());
            final String dstName = dstEntity.getName();

            switch (relation.getType()) {

                case OneToOne:

                    if (external) {

                        srcEntity.addFields(newPrivateFieldDeclaration().setName(DomainToPojos.variableName(relation)).setType(newClassOrInterfaceType(dstName)));
                        srcEntity.addMembers(DomainToPojos.setPropertyMethodDeclaration(relation.getSrc(), dstEntity));
                        srcEntity.addMembers(DomainToPojos.getPropertyMethodDeclaration(dstEntity));
                        srcEntity.addMembers(DomainToPojos.hasPropertyMethodDeclaration(dstEntity));
                        break;
                    }

                    srcEntity.addMembers(primitive ? oneToOnePrimitive(srcEntity, relation, dstEntity) : oneToOneReference(srcEntity, relation, dstEntity));
                    srcEntity.addMembers(primitive ? getSinglePrimitive(relation, dstEntity) : getSingleReference(relation, dstEntity));

                   break;

                case OneToMany:

                    if (external) {
                        srcEntity.addMembers(DomainToPojos.getList(relation, dstName));
                        srcEntity.addMembers(DomainToPojos.oneToMany(srcEntity, relation, dstName));
                        break;
                    }

                    srcEntity.addMembers(primitive ? oneToManyPrimitive(srcEntity, relation, dstEntity) : oneToManyReference(srcEntity, relation, dstEntity));
                    srcEntity.addMembers(primitive ? getListPrimitive(relation, dstEntity) : getListReference(relation, dstEntity));
                    break;
            }
        });

        domain.getEnums().forEach(anEnum -> {

            final EnumDeclaration enumDeclaration = newPublicEnumDeclaration(anEnum.getName());
            anEnum.getValues().forEach(enumDeclaration::addEntries);

            JavaPatterns.writeToFile(enumDeclaration, packageDeclaration, root);
        });

        JavaPatterns.writeToFile(domainClass, packageDeclaration, root);

        for (Map.Entry<Entity, ClassOrInterfaceDeclaration> entry : entityClassMap.entrySet()) {

            // do not write primitive entities or external ones, they represent an existing type (String, Long, ASTNode,etc)
            if (isPrimitive(entry.getKey())) continue;
            if (isExternal(entry.getKey())) continue;

            JavaPatterns.writeToFile(entry.getValue(), packageDeclaration, root);
        }
    }

    private static MethodDeclaration getListReference(Relation relation, ClassOrInterfaceDeclaration dstEntity) {
        return newPublicMethodDeclaration("get" + capitalize(relation.getName()), streamOf(newClassOrInterfaceType(dstEntity.getName())))
                .setBlockStmt(newReturnBlockStmt(newMethodCallExpression(newMethodCallExpression(newMethodCallExpression(node, "getJsonArray")
                        .addArguments(newStringLiteralExpression(relation.getName()))
                        .addArguments(newObjectCreationExpression(jsonArrayType)), "stream"), "map")
                        .addArguments(newLambdaExpression(newParameter("o"), newObjectCreationExpression(dstEntity.getName())
                                .addArguments(newCastExpression()
                                        .setType(jsonObjectType)
                                        .setExpression(newExpression("o")))))));
    }

    private static MethodDeclaration getListPrimitive(Relation relation, ClassOrInterfaceDeclaration dstEntity) {
        return newPublicMethodDeclaration("get" + capitalize(relation.getName()), streamOf(newClassOrInterfaceType(dstEntity.getName())))
                .setBlockStmt(newReturnBlockStmt(newMethodCallExpression(newMethodCallExpression(newMethodCallExpression(node, "getJsonArray")
                        .addArguments(newStringLiteralExpression(relation.getName()))
                        .addArguments(newObjectCreationExpression(jsonArrayType)), "stream"), "map")
                        .addArguments(newLambdaExpression(newParameter("o"), newCastExpression()
                                .setType(newClassOrInterfaceType(dstEntity.getName()))
                                .setExpression(newExpression("o"))))));
    }

    private static MethodDeclaration getSinglePrimitive(Relation relation, ClassOrInterfaceDeclaration dstEntity) {
        return newPublicMethodDeclaration("get" + capitalize(relation.getName()), newClassOrInterfaceType(dstEntity.getName()))
                .setBlockStmt(newReturnBlockStmt(newConditionalExpression()
                        .setCondition(isNull(newMethodCallExpression(node, "getJsonObject", newStringLiteralExpression(relation.getName()))))
                        .setThenExpression(newNull())
                        .setElseExpression(newMethodCallExpression(node, "get" + capitalize(dstEntity.getName()), newStringLiteralExpression(relation.getName())))));
    }

    private static MethodDeclaration getSingleReference(Relation relation, ClassOrInterfaceDeclaration dstEntity) {
        return newPublicMethodDeclaration("get" + capitalize(relation.getName()), newClassOrInterfaceType(dstEntity.getName()))
                .setBlockStmt(newReturnBlockStmt(newConditionalExpression()
                        .setCondition(isNull(newMethodCallExpression(node, "getJsonObject", newStringLiteralExpression(relation.getName()))))
                        .setThenExpression(newNull())
                        .setElseExpression(newObjectCreationExpression(dstEntity.getName(), newMethodCallExpression(node, "getJsonObject", newStringLiteralExpression(relation.getName()))))));
    }

    private static MethodDeclaration oneToOnePrimitive(ClassOrInterfaceDeclaration srcEntity, Relation relation, ClassOrInterfaceDeclaration dstEntity) {
        return newPublicMethodDeclaration("set" + capitalize(relation.getName()), newClassOrInterfaceType(srcEntity.getName()))
                .addParameters(newParameter(newClassOrInterfaceType(dstEntity.getName()), value))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newMethodCallExpression(node, "put")
                                .addArguments(newStringLiteralExpression(relation.getName()))
                                .addArguments(value)))
                        .addStatements(newReturnThis()));
    }

    private static MethodDeclaration oneToOneReference(ClassOrInterfaceDeclaration srcEntity, Relation relation, ClassOrInterfaceDeclaration dstEntity) {
        return newPublicMethodDeclaration("set" + capitalize(relation.getName()), newClassOrInterfaceType(srcEntity.getName()))
                .addParameters(newParameter(newClassOrInterfaceType(dstEntity.getName()), value))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newMethodCallExpression(node, "put")
                                .addArguments(newStringLiteralExpression(relation.getName()))
                                .addArguments(newMethodCallExpression(value, "getJsonObject"))))
                        .addStatements(newReturnThis()));
    }

    private static MethodDeclaration oneToManyReference(ClassOrInterfaceDeclaration srcEntity, Relation relation, ClassOrInterfaceDeclaration dstEntity) {
        return newPublicMethodDeclaration("add" + capitalize(relation.getName()), newClassOrInterfaceType(srcEntity.getName()))
                .addParameters(newParameter(newClassOrInterfaceType(dstEntity.getName()), value))
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

    private static MethodDeclaration oneToManyPrimitive(ClassOrInterfaceDeclaration srcEntity, Relation relation, ClassOrInterfaceDeclaration dstEntity) {
        return newPublicMethodDeclaration("add" + capitalize(relation.getName()), newClassOrInterfaceType(srcEntity.getName()))
                .addParameters(newParameter(newClassOrInterfaceType(dstEntity.getName()), value))
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