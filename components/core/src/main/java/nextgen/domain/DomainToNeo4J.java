package nextgen.domain;

import nextgen.domain.domain.*;
import nextgen.java.JavaPatterns;
import nextgen.java.st.*;

import java.util.HashMap;
import java.util.Map;

import static com.generator.util.StringUtil.capitalize;
import static nextgen.java.JavaPatterns.*;
import static nextgen.java.Neo4JPatterns.*;

public class DomainToNeo4J extends DomainPatterns {

    private static final String node = "node";
    private static final String db = "db";
    private static final String dst = "dst";
    private static final String existing = "existing";
    private static final String relationship = "relationship";
    private static final String value = "value";

    private static final MethodCallExpression getDstNode = newMethodCallExpression(dst, "getNode");

    public static void generate(String root, String packageName, Domain domain) {

        final Map<Entity, ClassOrInterfaceDeclaration> entityClassMap = new HashMap<>();

        final PackageDeclaration packageDeclaration = newPackageDeclaration(packageName);
        final ClassOrInterfaceDeclaration domainClass = newDatabaseWrapper(domain);

        domain.getEntities().stream().filter(entity -> !entity.getIsEnum()).forEach(entity -> {

            domainClass.addMembers(newEntityInstanceMethod(entity));
            domainClass.addMembers(newExistingEntityMethod(entity));
            domainClass.addMembers(findAllNodesWithLabel(entity.getName()));

            entityClassMap.put(entity, newNeoWrapper(entity.getName()));
        });

        domain.getRelations().forEach(relation -> {

            final ClassOrInterfaceDeclaration srcEntity = entityClassMap.get(relation.getSrc());
            final ClassOrInterfaceDeclaration dstEntity = entityClassMap.get(relation.getDst());
            if (srcEntity == null)
                throw new IllegalStateException("srcEntity for " + relation.getName() + " is not registered in domain " + domain.getName());
            if (dstEntity == null)
                throw new IllegalStateException("dstEntity for " + relation.getName() + " is not registered in domain " + domain.getName());

            boolean isSame = relation.getSrc().equals(relation.getDst());
            final boolean primitive = isPrimitive(relation.getDst());
            final boolean external = isExternal(relation.getDst());

            switch (relation.getType()) {

                case OneToOne:

                    if (external) {
                        srcEntity.addFields(newPrivateFieldDeclaration().setName(DomainToPojos.variableName(relation)).setType(newClassOrInterfaceType(dstEntity.getName())));
                        srcEntity.addMembers(DomainToPojos.setPropertyMethodDeclaration(relation.getSrc(), dstEntity));
                        srcEntity.addMembers(DomainToPojos.getPropertyMethodDeclaration(dstEntity));
                        srcEntity.addMembers(DomainToPojos.hasPropertyMethodDeclaration(dstEntity));
                        break;
                    }

                    if (primitive) {
                        srcEntity.addMembers(setPropertyMethodDeclaration(relation.getSrc(), relation.getDst()));
                        srcEntity.addMembers(getPropertyMethodDeclaration(relation, relation.getDst()));
                        srcEntity.addMembers(getPropertyOrDefaultMethodDeclaration(relation, relation.getDst()));
                        srcEntity.addMembers(hasPropertyMethodDeclaration(relation));
                        srcEntity.addMembers(removePropertyMethodDeclaration(relation.getSrc(), relation));

                        domainClass.addMembers(findNodeWithLabelAndProperty(relation.getSrc().getName(), relation, relation.getDst()));
                        domainClass.addMembers(findAllNodesWithLabelAndProperty(relation.getSrc().getName(), relation, relation.getDst()));
                        break;
                    }

                    srcEntity.addMembers(oneToOneOutgoing(srcEntity, relation, dstEntity));
                    srcEntity.addMembers(getSingle(srcEntity, relation, dstEntity, getSingleOutgoingRelationship(node, relation.getName())));

                    if (!isSame) {
                        dstEntity.addMembers(oneToOneIncoming(dstEntity, relation, srcEntity));
                        dstEntity.addMembers(getSingle(dstEntity, relation, srcEntity, getSingleIncomingRelationship(node, relation.getName())));
                    }
                    break;

                case OneToMany:

                    srcEntity.addMembers(oneToManyOutgoing(srcEntity, relation, dstEntity));
                    srcEntity.addMembers(getMany(srcEntity, relation, dstEntity, streamOutgoing(node, relation.getName())));

                    if (!isSame) {
                        dstEntity.addMembers(oneToManyIncoming(dstEntity, relation, srcEntity));
                        dstEntity.addMembers(getSingle(dstEntity, relation, srcEntity, getSingleIncomingRelationship(node, relation.getName())));
                    }
                    break;

//                case ManyToOne:
//
//                    srcEntity.addMembers(manyToOneOutgoing(srcEntity, relation, dstEntity));
//                    srcEntity.addMembers(getSingle(srcEntity, relation, dstEntity, getSingleOutgoingRelationship(node, relation.getName())));
//
//                    if (!isSame) {
//                        dstEntity.addMembers(manyToOneIncoming(dstEntity, relation, srcEntity));
//                        dstEntity.addMembers(getMany(dstEntity, relation, srcEntity, streamIncoming(node, relation.getName())));
//                    }
//                    break;


//                case ManyToMany:
//
//                    srcEntity.addMembers(manyToManyOutgoing(srcEntity, relation, dstEntity));
//                    srcEntity.addMembers(getMany(srcEntity, relation, dstEntity, streamOutgoing(node, relation.getName())));
//
//                    if (!isSame) {
//                        dstEntity.addMembers(manyToManyIncoming(dstEntity, relation, srcEntity));
//                        dstEntity.addMembers(getMany(dstEntity, relation, srcEntity, streamIncoming(node, relation.getName())));
//                    }
//                    break;
            }
        });

        domain.getEnums().forEach(anEnum -> {

            final EnumDeclaration enumDeclaration = newPublicEnumDeclaration(anEnum.getName());
            anEnum.getValues().forEach(enumDeclaration::addEntries);

            JavaPatterns.writeToFile(enumDeclaration, packageDeclaration, root);
        });

        JavaPatterns.writeToFile(domainClass, packageDeclaration, root);

        for (ClassOrInterfaceDeclaration classOrInterfaceDeclaration : entityClassMap.values()) {
            JavaPatterns.writeToFile(classOrInterfaceDeclaration, packageDeclaration, root);
        }
    }

    public static MethodDeclaration manyToOneOutgoing(ClassOrInterfaceDeclaration srcEntity, Relation relation, ClassOrInterfaceDeclaration dstEntity) {
        return newSetMethodDeclaration(srcEntity, relation, dstEntity)
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newFinalVariableDeclarationExpression(neoRelationshipType, relationship, getSingleOutgoingRelationship(node, relation.getName()))))
                        .addStatements(deleteOrReturnIfAlreadyRelated())
                        .addStatements(newExpressionStmt(deleteOutgoing(node, relation.getName())))
                        .addStatements(newExpressionStmt(createRelationshipTo(node, getDstNode, relation.getName())))
                        .addStatements(newReturnThis()));
    }

    public static MethodDeclaration manyToOneIncoming(ClassOrInterfaceDeclaration srcEntity, Relation relation, ClassOrInterfaceDeclaration dstEntity) {
        return newAddMethodDeclaration(srcEntity, relation, dstEntity)
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newFinalVariableDeclarationExpression(optionalOf(neoRelationshipType), existing, isRelated(node, getDstNode).setScope(findAnyIncoming(node, relation.getName())))))
                        .addStatements(newIfStmt(newMethodCallExpression(existing, "isPresent"), newReturnThis()))
                        .addStatements(newExpressionStmt(deleteOutgoing(getDstNode, relation.getName())))
                        .addStatements(newExpressionStmt(createRelationshipTo(getDstNode, node, relation.getName())))
                        .addStatements(newReturnThis()));
    }

    public static MethodDeclaration oneToManyOutgoing(ClassOrInterfaceDeclaration srcEntity, Relation relation, ClassOrInterfaceDeclaration dstEntity) {
        return newAddMethodDeclaration(srcEntity, relation, dstEntity)
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newFinalVariableDeclarationExpression(optionalOf(neoRelationshipType), existing, isRelated(node, getDstNode).setScope(findAnyOutgoing(node, relation.getName())))))
                        .addStatements(newIfStmt(newMethodCallExpression(existing, "isPresent"), newReturnThis()))
                        .addStatements(newExpressionStmt(deleteIncoming(getDstNode, relation.getName())))
                        .addStatements(newExpressionStmt(createRelationshipTo(node, getDstNode, relation.getName())))
                        .addStatements(newReturnThis()));
    }

    public static MethodDeclaration oneToManyIncoming(ClassOrInterfaceDeclaration srcEntity, Relation relation, ClassOrInterfaceDeclaration dstEntity) {
        return newSetMethodDeclaration(srcEntity, relation, dstEntity)
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newFinalVariableDeclarationExpression(optionalOf(neoRelationshipType), existing, isRelated(node, getDstNode).setScope(findAnyIncoming(node, relation.getName())))))
                        .addStatements(newIfStmt(newMethodCallExpression(existing, "isPresent"), newReturnThis()))
                        .addStatements(newExpressionStmt(deleteIncoming(node, relation.getName())))
                        .addStatements(newExpressionStmt(createRelationshipTo(getDstNode, node, relation.getName())))
                        .addStatements(newReturnThis()));
    }

    public static MethodDeclaration manyToManyOutgoing(ClassOrInterfaceDeclaration srcEntity, Relation relation, ClassOrInterfaceDeclaration dstEntity) {
        return newAddMethodDeclaration(srcEntity, relation, dstEntity)
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newFinalVariableDeclarationExpression(optionalOf(neoRelationshipType), existing, isRelated(node, getDstNode).setScope(findAnyOutgoing(node, relation.getName())))))
                        .addStatements(newIfStmt(newMethodCallExpression(existing, "isPresent"), newReturnThis()))
                        .addStatements(newExpressionStmt(createRelationshipTo(node, getDstNode, relation.getName())))
                        .addStatements(newReturnThis()));
    }

    public static MethodDeclaration manyToManyIncoming(ClassOrInterfaceDeclaration srcEntity, Relation relation, ClassOrInterfaceDeclaration dstEntity) {
        return newAddMethodDeclaration(srcEntity, relation, dstEntity)
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newFinalVariableDeclarationExpression(optionalOf(neoRelationshipType), existing, isRelated(node, getDstNode).setScope(findAnyIncoming(node, relation.getName())))))
                        .addStatements(newIfStmt(newMethodCallExpression(existing, "isPresent"), newReturnThis()))
                        .addStatements(newExpressionStmt(createRelationshipTo(getDstNode, node, relation.getName())))
                        .addStatements(newReturnThis()));
    }

    public static MethodDeclaration oneToOneOutgoing(ClassOrInterfaceDeclaration srcEntity, Relation relation, ClassOrInterfaceDeclaration dstEntity) {
        return newSetMethodDeclaration(srcEntity, relation, dstEntity)
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newFinalVariableDeclarationExpression(neoRelationshipType, relationship, getSingleOutgoingRelationship(node, relation.getName()))))
                        .addStatements(deleteOrReturnIfAlreadyRelated())
                        .addStatements(newExpressionStmt(deleteIncoming(getDstNode, relation.getName())))
                        .addStatements(newExpressionStmt(createRelationshipTo(node, getDstNode, relation.getName())))
                        .addStatements(newReturnThis()));
    }

    public static MethodDeclaration oneToOneIncoming(ClassOrInterfaceDeclaration srcEntity, Relation relation, ClassOrInterfaceDeclaration dstEntity) {
        return newSetMethodDeclaration(srcEntity, relation, dstEntity)
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newFinalVariableDeclarationExpression(neoRelationshipType, relationship, getSingleIncomingRelationship(node, relation.getName()))))
                        .addStatements(deleteOrReturnIfAlreadyRelated())
                        .addStatements(newExpressionStmt(deleteOutgoing(getDstNode, relation.getName())))
                        .addStatements(newExpressionStmt(createRelationshipTo(getDstNode, node, relation.getName())))
                        .addStatements(newReturnThis()));
    }

    public static MethodDeclaration newAddMethodDeclaration(ClassOrInterfaceDeclaration srcEntity, Relation relation, ClassOrInterfaceDeclaration dstEntity) {
        return newPublicMethodDeclaration("add" + capitalize(relation.getName()), newClassOrInterfaceType(srcEntity.getName()))
                .addParameters(newParameter(newClassOrInterfaceType(dstEntity.getName()), dst));
    }

    public static MethodDeclaration newSetMethodDeclaration(ClassOrInterfaceDeclaration srcEntity, Relation relation, ClassOrInterfaceDeclaration dstEntity) {
        return newPublicMethodDeclaration("set" + capitalize(relation.getName()), newClassOrInterfaceType(srcEntity.getName()))
                .addParameters(newParameter(newClassOrInterfaceType(dstEntity.getName()), dst));
    }

    public static MethodDeclaration getMany(ClassOrInterfaceDeclaration srcEntity, Relation relation, ClassOrInterfaceDeclaration dstEntity, Object stream) {
        return newPublicMethodDeclaration("get" + capitalize(relation.getName()), streamOf(newClassOrInterfaceType(dstEntity.getName())))
                .setBlockStmt(newReturnBlockStmt(mapToEntity(dstEntity, stream)));
    }

    public static MethodDeclaration getSingle(ClassOrInterfaceDeclaration srcEntity, Relation relation, ClassOrInterfaceDeclaration dstEntity, Object initializer) {
        return newPublicMethodDeclaration("get" + capitalize(relation.getName()), newClassOrInterfaceType(dstEntity.getName()))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newFinalVariableDeclarationExpression(neoRelationshipType, relationship, initializer)))
                        .addStatements(newReturnStmt(newConditionalExpression()
                                .setCondition(isNull(relationship))
                                .setThenExpression(newNull())
                                .setElseExpression(newObjectCreationExpression(dstEntity.getName())
                                        .addArguments(getOtherNode(relationship, node))))));
    }

    public static ClassOrInterfaceDeclaration newDatabaseWrapper(Domain domain) {

        final String className = domain.getName() + "NeoFactory";

        return newPublicClassDeclaration(className)
                .addFields(newPrivateFinalFieldDeclaration(neoGraphDatabaseServiceType, db))
                .addMembers(newPublicConstructorDeclaration()
                        .setName(className)
                        .addParameters(newParameter(StringType, "dir"))
                        .setBlockStmt(newBlockStmt(newThisConstructorCall()
                                .addArguments(newGraphDatabase("dir")))))
                .addMembers(newPublicConstructorDeclaration()
                        .setName(className)
                        .addParameters(newParameter(neoGraphDatabaseServiceType, db))
                        .setBlockStmt(newBlockStmt(newAssignThisVariableExpression(db))))
                .addMembers(newPublicMethodDeclaration("getDatabaseService", neoGraphDatabaseServiceType)
                        .setBlockStmt(newReturnBlockStmt(newThisVariableExpression(db))));
    }

    public static ClassOrInterfaceDeclaration newNeoWrapper(String name) {
        return newPublicClassDeclaration(name)
                .addFields(newPrivateFinalFieldDeclaration(neoNodeType, node))
                .addMembers(newPublicConstructorDeclaration(name, newParameter(neoNodeType, node))
                        .setBlockStmt(newBlockStmt(newAssignThisVariableExpression(node))))
                .addMembers(newPublicMethodDeclaration("getNode", neoNodeType)
                        .setBlockStmt(newReturnBlockStmt(newThisVariableExpression(node))))
                .addMembers(newEqualsMethod(newBlockStmt()
                        .addStatements(newIfStmt("this == o", returnTrue()))
                        .addStatements(newIfStmt("o == null || getClass() != o.getClass()", returnFalse()))
                        .addStatements(newExpressionStmt(newFinalVariableDeclarationExpression(newClassOrInterfaceType(name), "other", newCastExpression()
                                .setType(newClassOrInterfaceType(name))
                                .setExpression(newExpression("o")))))
                        .addStatements(newReturnStmt(newMethodCallExpression(node, "equals", newFieldAccessExpression("other", node))))))
                .addMembers(newHashMethod(node));
    }

    private static MethodDeclaration newEntityInstanceMethod(Entity entity) {
        return newPublicMethodDeclaration("new" + entity.getName(), newClassOrInterfaceType(entity.getName()))
                .setBlockStmt(newReturnBlockStmt(newMethodCallExpression()
                        .setName("new" + entity.getName())
                        .addArguments(createNode(db, entity.getName()))));
    }

    private static MethodDeclaration newExistingEntityMethod(Entity entity) {
        return newPublicMethodDeclaration("new" + entity.getName(), newClassOrInterfaceType(entity.getName()))
                .addParameters(newParameter(neoNodeType, node))
                .setBlockStmt(newReturnBlockStmt(newObjectCreationExpression(entity.getName())
                        .addArguments(newExpression(node))));
    }

    private static MethodDeclaration findAllNodesWithLabel(String label) {
        return newPublicMethodDeclaration("findAll" + label, streamOf(newClassOrInterfaceType(label)))
                .setBlockStmt(newReturnBlockStmt(newMethodCallExpression()
                        .setScope(streamNodesByLabel(db, label))
                        .setName("map")
                        .addArguments(newMethodReferenceExpression()
                                .setIdentifier("new" + label)
                                .setScope(newThisExpression()))));
    }

    private static MethodDeclaration findAllNodesWithLabelAndProperty(String label, Relation relation, Entity dstEntity) {

        final Object valueVariable = asNeoParameter(dstEntity);

        return newPublicMethodDeclaration("findAll" + label + "By" + relation.getName(), streamOf(newClassOrInterfaceType(label)))
                .addParameters(newParameter(asJavaType(dstEntity), value))
                .setBlockStmt(newReturnBlockStmt(newMethodCallExpression(streamNodesByLabel(db, label, relation.getName(), valueVariable), "map")
                        .addArguments(newMethodReferenceExpression()
                                .setIdentifier("new" + label)
                                .setScope(newThisExpression()))));
    }

    private static Object asNeoParameter(Entity property) {
        return isEnum(property) ? newMethodCallExpression(value, "name") : value;
    }

    private static MethodDeclaration findNodeWithLabelAndProperty(String entityName, Relation relation, Entity dstEntity) {
        return newPublicMethodDeclaration("find" + entityName + "By" + relation.getName(), newClassOrInterfaceType(entityName))
                .addParameters(newParameter(asJavaType(dstEntity), value))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newFinalVariableDeclarationExpression(neoNodeType, node, findNode(db, entityName, relation.getName(), asNeoParameter(dstEntity)))))
                        .addStatements(newReturnStmt(newConditionalExpression()
                                .setCondition(isNull(node))
                                .setThenExpression(newNull())
                                .setElseExpression(newObjectCreationExpression(entityName, node)))));
    }

    private static MethodDeclaration setPropertyMethodDeclaration(Entity entity, Entity property) {
        return newPublicMethodDeclaration("set" + property.getName(), newClassOrInterfaceType(entity.getName()))
                .addParameters(newParameter(newClassOrInterfaceType(property.getName()), value))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(setProperty(node, property.getName(), asNeoParameter(property))))
                        .addStatements(newReturnThis()));
    }

    private static MethodDeclaration getPropertyMethodDeclaration(Relation relation, Entity property) {
        return newPublicMethodDeclaration("get" + capitalize(property.getName()), asJavaType(property))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newIfStmt()
                                .setCondition(hasProperty(node, property.getName()))
                                .setThen(newReturnStmt(isEnum(property) ?
                                        getEnumProperty(node, relation.getName(), property.getName()) :
                                        getProperty(node, relation.getName(), asJavaType(property)))))
                        .addStatements(newReturnStmt(property.getName().equals("Boolean") ? newFalseExpression() : newNull())));
    }

    private static MethodDeclaration getPropertyOrDefaultMethodDeclaration(Relation relation, Entity property) {
        return newPublicMethodDeclaration("get" + capitalize(property.getName()), asJavaType(property))
                .addParameters(newParameter(asJavaType(property), "defaultValue"))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newIfStmt()
                                .setCondition(hasProperty(node, property.getName()))
                                .setThen(newReturnStmt(isEnum(property) ?
                                        getEnumProperty(node, relation.getName(), property.getName()) :
                                        getProperty(node, relation.getName(), asJavaType(property)))))
                        .addStatements(newReturnStmt(property.getName().equals("Boolean") ? newFalseExpression() : newExpression("defaultValue"))));
    }

    private static MethodDeclaration hasPropertyMethodDeclaration(Relation relation) {
        return newPublicMethodDeclaration("has" + capitalize(relation.getName()), booleanType)
                .setBlockStmt(newReturnBlockStmt(hasProperty(node, relation.getName())));
    }

    private static MethodDeclaration removePropertyMethodDeclaration(Entity entity, Relation relation) {
        return newPublicMethodDeclaration("remove" + capitalize(relation.getName()), newClassOrInterfaceType(entity.getName()))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(removeProperty(node, relation.getName())))
                        .addStatements(newReturnThis()));
    }

    private static MethodCallExpression mapToEntity(ClassOrInterfaceDeclaration dstEntity, Object stream) {
        return newMethodCallExpression(stream, "map")
                .addArguments(newLambdaExpression(newParameter(relationship), newObjectCreationExpression(dstEntity.getName(), getOtherNode(relationship, node))));
    }

    private static IfStmt deleteOrReturnIfAlreadyRelated() {
        return newIfStmt()
                .setCondition(notNull(relationship))
                .setThen(newBlockStmt()
                        .addStatements(newIfStmt(newMethodCallExpression(getOtherNode(relationship, node), "equals").addArguments(getDstNode), newReturnThis()))
                        .addStatements(newExpressionStmt(newMethodCallExpression(relationship, "delete"))));
    }
}