package nextgen.domain;

import nextgen.domain.domain.Domain;
import nextgen.domain.domain.Entity;
import nextgen.domain.domain.Property;
import nextgen.domain.domain.Relation;
import nextgen.java.JavaPatterns;
import nextgen.java.st.*;

import java.util.HashMap;
import java.util.Map;

import static com.generator.util.StringUtil.capitalize;
import static nextgen.java.JavaPatterns.*;

public class DomainToPojos extends DomainPatterns {

    private static final String value = "value";

    public static void generate(String root, String packageName, Domain domain) {

        final Map<Entity, ClassOrInterfaceDeclaration> entityClassMap = new HashMap<>();

        final PackageDeclaration packageDeclaration = newPackageDeclaration(packageName);
        final ClassOrInterfaceDeclaration domainClass = newPojoFactory(domain);

        domain.getEntities().stream().filter(Entity::getIsEnum).forEach(entity -> {
            final EnumDeclaration enumDeclaration = newPublicEnumDeclaration(entity.getName());

//            if(entity.getName().equals("PropertyType"))
//            else if(entity.getName().equals("PropertyType"))

            //entity.getValues().forEach(enumDeclaration::addEntries);
            //JavaPatterns.writeToFile(enumDeclaration, packageDeclaration, root);
        });

        domain.getEntities().stream().filter(entity -> !entity.getIsEnum()).forEach(entity -> {
            entityClassMap.put(entity, newPojo(entity.getName()));
            // do not process primitive entities, they represent an existing type (String, Long, etc)
            if (isPrimitive(entity)) return;
            domainClass.addMembers(newEntityInstanceMethod(entity));
        });

        JavaPatterns.writeToFile(domainClass, packageDeclaration, root);

        domain.getRelations().forEach(relation -> {

            final ClassOrInterfaceDeclaration srcEntity = entityClassMap.get(relation.getSrc());
            if (srcEntity == null)
                throw new IllegalStateException("srcEntity for " + relation.getName() + " is not registered in domain " + domain.getName());

            final String srcName = relation.getSrc().getName();
            final String dstName = relation.getDst().getName();

            final ClassOrInterfaceType listOf = listOf(newClassOrInterfaceType(dstName));

            switch (relation.getType()) {

                case OneToOne:
                    srcEntity.addFields(newPrivateFieldDeclaration().setName(variableName(relation)).setType(newClassOrInterfaceType(dstName)));
                    srcEntity.addMembers(oneToOne(srcName, relation, dstName));
                    srcEntity.addMembers(getSingle(relation, dstName));

                    if (relation.getName().equals("name") && dstName.equals("String"))
                        srcEntity.addMembers(newToStringMethod(newExpression(variableName(relation))));
                    break;

                case OneToMany:
                    srcEntity.addFields(newPrivateFinalFieldDeclaration().setName(variableName(relation)).setType(listOf).setInitializer(newObjectCreationExpression(ArrayListType)));
                    srcEntity.addMembers(oneToMany(srcEntity, relation, dstName));
                    srcEntity.addMembers(getList(relation, dstName));
                    break;

//                case ManyToOne:
//                    srcEntity.addFields(newPrivateFieldDeclaration().setName(variableName(relation)).setType(newClassOrInterfaceType(dstName)));
//                    srcEntity.addMembers(manyToOne(srcEntity, relation, dstName));
//                    srcEntity.addMembers(getSingle(relation, dstName));
//                    break;
//
//
//                case ManyToMany:
//                    srcEntity.addFields(newPrivateFinalFieldDeclaration().setName(variableName(relation)).setType(listOf).setInitializer(newObjectCreationExpression(ArrayListType)));
//                    srcEntity.addMembers(manyToMany(srcEntity, relation, dstName));
//                    srcEntity.addMembers(getList(relation, dstName));
//                    break;
            }
        });


        for (Map.Entry<Entity, ClassOrInterfaceDeclaration> entry : entityClassMap.entrySet()) {
            // do not write primitive entities, they represent an existing type (String,Long, etc)
            if (isPrimitive(entry.getKey())) continue;
            JavaPatterns.writeToFile(entry.getValue(), packageDeclaration, root);
        }
    }

    public static MethodDeclaration getList(Relation relation, String dstEntity) {
        return newPublicMethodDeclaration("get" + capitalize(relation.getName()), listOf(newClassOrInterfaceType(dstEntity)))
                .setBlockStmt(newReturnBlockStmt(newThisVariableExpression(variableName(relation))));
    }

    public static MethodDeclaration getSingle(Relation relation, String dstEntity) {
        return newPublicMethodDeclaration("get" + capitalize(relation.getName()), newClassOrInterfaceType(dstEntity))
                .setBlockStmt(newReturnBlockStmt(newThisVariableExpression(variableName(relation))));
    }

    private static MethodDeclaration oneToOne(String srcEntity, Relation relation, String dstEntity) {
        return newPublicMethodDeclaration("set" + capitalize(relation.getName()), newClassOrInterfaceType(srcEntity))
                .addParameters(newParameter(newClassOrInterfaceType(dstEntity), variableName(relation)))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newAssignThisVariableExpression(variableName(relation))))
                        .addStatements(newReturnThis()));
    }

    public static MethodDeclaration oneToMany(ClassOrInterfaceDeclaration srcEntity, Relation relation, String dstEntity) {
        return newPublicMethodDeclaration("add" + capitalize(relation.getName()), newClassOrInterfaceType(srcEntity.getName()))
                .addParameters(newParameter(newClassOrInterfaceType(dstEntity), value))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newMethodCallExpression(variableName(relation), "add", value)))
                        .addStatements(newReturnThis()));
    }

    private static MethodDeclaration manyToOne(ClassOrInterfaceDeclaration srcEntity, Relation relation, String dstEntity) {
        return newPublicMethodDeclaration("set" + capitalize(relation.getName()));
    }

    private static MethodDeclaration manyToMany(ClassOrInterfaceDeclaration srcEntity, Relation relation, String dstEntity) {
        return newPublicMethodDeclaration("add" + capitalize(relation.getName()));
    }

    public static ClassOrInterfaceMember setPropertyMethodDeclaration(Entity entity, ClassOrInterfaceDeclaration property) {
        return newPublicMethodDeclaration("set" + capitalize(property.getName()), newClassOrInterfaceType(entity.getName()))
                .addParameters(newParameter(newClassOrInterfaceType(property.getName()), variableName(property)))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newAssignThisVariableExpression(variableName(property))))
                        .addStatements(newReturnThis()));
    }

    public static ClassOrInterfaceMember getPropertyMethodDeclaration(ClassOrInterfaceDeclaration property) {
        return newPublicMethodDeclaration("get" + capitalize(property.getName()), newClassOrInterfaceType(property.getName()))
                .setBlockStmt(newReturnBlockStmt(newThisVariableExpression(variableName(property))));
    }

    public static ClassOrInterfaceMember hasPropertyMethodDeclaration(ClassOrInterfaceDeclaration property) {
        return newPublicMethodDeclaration("has" + capitalize(property.getName()), booleanType)
                .setBlockStmt(newReturnBlockStmt(notNull(variableName(property))));
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
        return newPublicClassDeclaration(domain.getName() + "Factory");
    }

    public static MethodDeclaration newEntityInstanceMethod(Entity entity) {
        return newPublicStaticMethodDeclaration("new" + entity.getName(), newClassOrInterfaceType(entity.getName()))
                .setBlockStmt(newReturnBlockStmt(newObjectCreationExpression(entity.getName())));
    }
}