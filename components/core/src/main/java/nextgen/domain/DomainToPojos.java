package nextgen.domain;

import nextgen.domain.domain.Domain;
import nextgen.domain.domain.Entity;
import nextgen.domain.domain.Relation;
import nextgen.java.JavaPatterns;
import nextgen.java.st.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static com.generator.util.StringUtil.capitalize;
import static nextgen.java.JavaPatterns.*;

public class DomainToPojos extends DomainPatterns {

    private static final String value = "value";

    public static void generate(File root, PackageDeclaration packageDeclaration, Domain domain) {
        generate(root.getAbsolutePath(), packageDeclaration.getName(), domain);

    }

    public static void generate(String root, String packageName, Domain domain) {

        final Map<Entity, ClassOrInterfaceDeclaration> entityClassMap = new HashMap<>();
        final PackageDeclaration packageDeclaration = newPackageDeclaration(packageName);
        final ClassOrInterfaceDeclaration domainClass = newPojoFactory(domain);

        new DomainVisitor(domain) {

            @Override
            protected void start(Domain domain) {

            }

            @Override
            protected void onPrimitive(Entity entity) {

            }

            @Override
            protected void onReference(Entity entity) {
                entityClassMap.put(entity, newPojo(entity.getName()));
                domainClass.addMembers(newEntityInstanceMethod(entity));
            }

            @Override
            protected void onExternal(Entity entity) {

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

                srcEntity.addFields(newPrivateFieldDeclaration().setName(variableName(relation)).setType(newClassOrInterfaceType(relation.getDst().getName())));
                srcEntity.addMembers(oneToOne(relation));
                srcEntity.addMembers(getSingle(relation));

                if (isLexical(relation)) srcEntity.addMembers(toStringMethod(relation));
            }

            @Override
            protected void visitOneToMany(Relation relation) {
                final ClassOrInterfaceDeclaration srcEntity = entityClassMap.get(relation.getSrc());
                final String dstName = relation.getDst().getName();
                final ClassOrInterfaceType listOf = listOf(newClassOrInterfaceType(dstName));

                srcEntity.addFields(newPrivateFinalFieldDeclaration().setName(variableName(relation)).setType(listOf).setInitializer(newObjectCreationExpression(ArrayListType)));
                srcEntity.addMembers(oneToMany(relation));
                srcEntity.addMembers(getList(relation));
            }

            @Override
            protected void end() {

                JavaPatterns.writeToFile(domainClass, packageDeclaration, root);

                for (Map.Entry<Entity, ClassOrInterfaceDeclaration> entry : entityClassMap.entrySet())
                    JavaPatterns.writeToFile(entry.getValue(), packageDeclaration, root);
            }
        };
    }

    public static MethodDeclaration getList(Relation relation) {
        return newPublicMethodDeclaration(getterName(relation), listOf(newClassOrInterfaceType(relation.getDst().getName())))
                .setBlockStmt(newReturnBlockStmt(newThisVariableExpression(variableName(relation))));
    }

    public static MethodDeclaration clearList(Relation relation) {
        return newPublicMethodDeclaration("clear" + capitalize(relation.getName()), newClassOrInterfaceType(relation.getSrc().getName()))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newMethodCallExpression(variableName(relation), "clear")))
                        .addStatements(newReturnThis()));
    }

    public static MethodDeclaration getSingle(Relation relation) {
        return newPublicMethodDeclaration(getterName(relation), newClassOrInterfaceType(relation.getDst().getName()))
                .setBlockStmt(newReturnBlockStmt(newThisVariableExpression(variableName(relation))));
    }

    public static MethodDeclaration oneToOne(Relation relation) {
        return newPublicMethodDeclaration(setterName(relation), newClassOrInterfaceType(relation.getSrc().getName()))
                .addParameters(newParameter(newClassOrInterfaceType(relation.getDst().getName()), variableName(relation)))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newAssignThisVariableExpression(variableName(relation))))
                        .addStatements(newReturnThis()));
    }

    public static MethodDeclaration oneToMany(Relation relation) {
        return newPublicMethodDeclaration("add" + capitalize(relation.getName()), newClassOrInterfaceType(relation.getSrc().getName()))
                .addParameters(newParameter(newClassOrInterfaceType(relation.getDst().getName()), value))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newMethodCallExpression(variableName(relation), "add", value)))
                        .addStatements(newReturnThis()));
    }

//    public static MethodDeclaration manyToOne(ClassOrInterfaceDeclaration relation.getSrc().getName(), Relation relation, String relation.getDst()) {
//        return newPublicMethodDeclaration(setterName(relation));
//    }
//
//    public static MethodDeclaration manyToMany(ClassOrInterfaceDeclaration relation.getSrc().getName(), Relation relation, String relation.getDst()) {
//        return newPublicMethodDeclaration("add" + capitalize(relation.getName()));
//    }
//
//    public static ClassOrInterfaceMember setPropertyMethodDeclaration(Entity entity, ClassOrInterfaceDeclaration property) {
//        return newPublicMethodDeclaration("set" + capitalize(property.getName()), newClassOrInterfaceType(entity.getName()))
//                .addParameters(newParameter(newClassOrInterfaceType(property.getName()), variableName(property)))
//                .setBlockStmt(newBlockStmt()
//                        .addStatements(newExpressionStmt(newAssignThisVariableExpression(variableName(property))))
//                        .addStatements(newReturnThis()));
//    }
//
//    public static ClassOrInterfaceMember getPropertyMethodDeclaration(ClassOrInterfaceDeclaration property) {
//        return newPublicMethodDeclaration("get" + capitalize(property.getName()), newClassOrInterfaceType(property.getName()))
//                .setBlockStmt(newReturnBlockStmt(newThisVariableExpression(variableName(property))));
//    }

    public static ClassOrInterfaceMember hasPropertyMethodDeclaration(Relation relation) {
        return newPublicMethodDeclaration("has" + capitalize(relation.getName()), booleanType)
                .setBlockStmt(newReturnBlockStmt(notNull(variableName(relation))));
    }

    public static ClassOrInterfaceDeclaration newPojo(String name) {
        return newPublicClassDeclaration(name)
                .addFields(newPrivateFinalFieldDeclaration(UUIDType, "uuid"))
                .addMembers(newPublicConstructorDeclaration(name)
                        .setBlockStmt(newBlockStmt(newAssignExpression()
                                .setTarget(newThisVariableExpression()
                                        .setValue("uuid"))
                                .setOperator("=")
                                .setValue(newMethodCallExpression(UUIDType, "randomUUID")))))
                .addMembers(newPublicConstructorDeclaration(name)
                        .addParameters(newParameter(UUIDType, "uuid"))
                        .setBlockStmt(newBlockStmt(newAssignExpression()
                                .setTarget(newThisVariableExpression()
                                        .setValue("uuid"))
                                .setOperator("=")
                                .setValue("uuid"))))
                .addMembers(newPublicMethodDeclaration("getUuid", UUIDType)
                        .setBlockStmt(newReturnBlockStmt(newExpression("uuid"))))
                .addMembers(newHashMethod("uuid"))
                .addMembers(newEqualsMethod(newBlockStmt()
                        .addStatements(newIfStmt("this == o", returnTrue()))
                        .addStatements(newIfStmt("o == null || getClass() != o.getClass()", returnFalse()))
                        .addStatements(newExpressionStmt(newFinalVariableDeclarationExpression(newClassOrInterfaceType(name), "other", newCastExpression()
                                .setType(newClassOrInterfaceType(name))
                                .setExpression(newExpression("o")))))
                        .addStatements(newReturnStmt(newMethodCallExpression("uuid", "equals", newFieldAccessExpression("other", "uuid"))))));
    }

    public static ClassOrInterfaceDeclaration newPojoFactory(Domain domain) {
        return newPublicClassDeclaration(domain.getName() + "Factory")
                .addExtend(domain.getExtendsClass() != null ? newClassOrInterfaceType(domain.getExtendsClass()) : null);
    }

    public static MethodDeclaration newEntityInstanceMethod(Entity entity) {
        return newPublicStaticMethodDeclaration("new" + entity.getName(), newClassOrInterfaceType(entity.getName()))
                .setBlockStmt(newReturnBlockStmt(newObjectCreationExpression(entity.getName())));
    }

    public static PrivateFieldDeclaration newField(Relation relation) {
        return newPrivateFieldDeclaration().setName(variableName(relation)).setType(newClassOrInterfaceType(relation.getDst().getName()));
    }

    public static PrivateFieldDeclaration newListField(Relation relation) {
        return newPrivateFieldDeclaration().setName(variableName(relation)).setType(listOf(newClassOrInterfaceType(relation.getDst().getName()))).setInitializer(newObjectCreationExpression(ArrayListType));
    }

    public static MethodDeclaration toStringMethod(Relation relation) {

        final String variableName = variableName(relation);

        switch (relation.getDst().getType()) {

            case PRIMITIVE:
                return relation.getDst().getName().equals("String") ?
                        newToStringMethod(newConditionalExpression()
                                .setCondition(isNull(variableName))
                                .setThenExpression("null")
                                .setElseExpression(variableName)) :
                        newToStringMethod(newConditionalExpression()
                                .setCondition(isNull(variableName))
                                .setThenExpression("null")
                                .setElseExpression(newToString(variableName)));

            case REFERENCE:
            case EXTERNAL:
                return newToStringMethod(newConditionalExpression()
                        .setCondition(isNull(variableName))
                        .setThenExpression("null")
                        .setElseExpression(newToString(variableName)));

            case ENUM:
                return newToStringMethod(newConditionalExpression()
                        .setCondition(isNull(variableName))
                        .setThenExpression("null")
                        .setElseExpression(nameOf(variableName)));
        }

        return null;
    }
}