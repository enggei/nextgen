package nextgen.domain;

import nextgen.domain.domain.Domain;
import nextgen.domain.domain.Entity;
import nextgen.domain.domain.Relation;
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

        new DomainVisitor(domain) {

            @Override
            protected void start(Domain domain) {

            }

            @Override
            protected void onPrimitive(Entity entity) {

            }

            @Override
            protected void onReference(Entity entity) {
                domainClass.addMembers(newEntityInstanceMethod(entity));
                domainClass.addMembers(newExistingEntityMethod(entity));
                domainClass.addMembers(findAllNodesWithLabel(entity.getName()));

                entityClassMap.put(entity, newNeoWrapper(entity.getName()));
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
                final String srcName = relation.getSrc().getName();
                final String dstName = relation.getDst().getName();

                switch (relation.getDst().getType()) {

                    case PRIMITIVE:
                        srcEntity.addMembers(setPropertyMethodDeclaration(relation.getSrc(), relation, relation.getDst()));
                        srcEntity.addMembers(getPropertyMethodDeclaration(relation, relation.getDst()));
                        srcEntity.addMembers(getPropertyOrDefaultMethodDeclaration(relation, relation.getDst()));
                        srcEntity.addMembers(hasPropertyMethodDeclaration(relation));
                        srcEntity.addMembers(removePropertyMethodDeclaration(relation.getSrc(), relation));

                        domainClass.addMembers(findNodeWithLabelAndProperty(srcName, relation, relation.getDst()));
                        domainClass.addMembers(findAllNodesWithLabelAndProperty(srcName, relation, relation.getDst()));
                        break;
                    case REFERENCE:
                        srcEntity.addMembers(oneToOneOutgoing(srcEntity, relation, newClassDeclaration(dstName)));
                        srcEntity.addMembers(getSingle(srcEntity, relation, newClassDeclaration(dstName), getSingleOutgoingRelationship(node, relation.getName())));
                        srcEntity.addMembers(remove(srcEntity, relation, newClassDeclaration(dstName)));

//                    if (!isSame && entityClassMap.containsKey(relation.getDst())) {
//                        final ClassOrInterfaceDeclaration dstEntity = entityClassMap.get(relation.getDst());
//                        dstEntity.addMembers(oneToOneIncoming(newClassDeclaration(dstName), relation, srcEntity));
//                        dstEntity.addMembers(getSingle(dstEntity, relation, srcEntity, getSingleIncomingRelationship(node, relation.getName())));
//                    }
                        break;
                    case EXTERNAL:
                        srcEntity.addFields(newPrivateFieldDeclaration().setName(DomainToPojos.variableName(relation)).setType(newClassOrInterfaceType(dstName)));
                        srcEntity.addMembers(DomainToPojos.oneToOne(srcName, relation, dstName));
                        srcEntity.addMembers(DomainToPojos.getSingle(relation, dstName));
                        srcEntity.addMembers(DomainToPojos.hasPropertyMethodDeclaration(newClassDeclaration(dstName)));
                        break;
                    case ENUM:
                        srcEntity.addMembers(setPropertyMethodDeclaration(relation.getSrc(), relation, relation.getDst()));
                        srcEntity.addMembers(getPropertyMethodDeclaration(relation, relation.getDst()));
                        srcEntity.addMembers(getPropertyOrDefaultMethodDeclaration(relation, relation.getDst()));
                        srcEntity.addMembers(hasPropertyMethodDeclaration(relation));
                        srcEntity.addMembers(removePropertyMethodDeclaration(relation.getSrc(), relation));

                        domainClass.addMembers(findNodeWithLabelAndProperty(srcName, relation, relation.getDst()));
                        domainClass.addMembers(findAllNodesWithLabelAndProperty(srcName, relation, relation.getDst()));
                        break;
                }
            }

            @Override
            protected void visitOneToMany(Relation relation) {

                final ClassOrInterfaceDeclaration srcEntity = entityClassMap.get(relation.getSrc());
                final String dstName = relation.getDst().getName();

                switch (relation.getDst().getType()) {

                    case PRIMITIVE:
                        srcEntity.addMembers(oneToManyOutgoingPrimitive(srcEntity, relation, newClassDeclaration(dstName)));
                        srcEntity.addMembers(getManyPrimitive(srcEntity, relation, newClassDeclaration(dstName), streamOutgoing(node, relation.getName())));
                        break;
                    case REFERENCE:
                        srcEntity.addMembers(oneToManyOutgoing(srcEntity, relation, newClassDeclaration(dstName)));
                        srcEntity.addMembers(getMany(srcEntity, relation, newClassDeclaration(dstName), streamOutgoing(node, relation.getName())));
                        srcEntity.addMembers(remove(srcEntity, relation, newClassDeclaration(dstName)));

//                    if (!isSame && entityClassMap.containsKey(relation.getDst())) {
//                        final ClassOrInterfaceDeclaration dstEntity = entityClassMap.get(relation.getDst());
//                        dstEntity.addMembers(oneToManyIncoming(dstEntity, relation, srcEntity));
//                        dstEntity.addMembers(getSingle(dstEntity, relation, srcEntity, getSingleIncomingRelationship(node, relation.getName())));
//                    }
                        break;
                    case EXTERNAL:
                        srcEntity.addFields(newPrivateFieldDeclaration().setName(DomainToPojos.variableName(relation)).setType(listOf(newClassOrInterfaceType(dstName))));
                        srcEntity.addMembers(DomainToPojos.getList(relation, dstName));
                        srcEntity.addMembers(DomainToPojos.oneToMany(srcEntity, relation, dstName));
                        break;
                    case ENUM:
                        srcEntity.addMembers(oneToManyOutgoingEnum(srcEntity, relation, newClassDeclaration(dstName)));
                        srcEntity.addMembers(getManyEnum(srcEntity, relation, newClassDeclaration(dstName), streamOutgoing(node, relation.getName())));
                        break;
                }

            }

            @Override
            protected void end() {

                JavaPatterns.writeToFile(domainClass, packageDeclaration, root);

                for (ClassOrInterfaceDeclaration classOrInterfaceDeclaration : entityClassMap.values()) {
                    JavaPatterns.writeToFile(classOrInterfaceDeclaration, packageDeclaration, root);
                }
            }
        };
    }

    public static MethodDeclaration oneToManyOutgoingPrimitive(ClassOrInterfaceDeclaration srcEntity, Relation relation, ClassOrInterfaceDeclaration dstEntity) {
        return newAddMethodDeclaration(srcEntity, relation, dstEntity)
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newFinalVariableDeclarationExpression(optionalOf(neoNodeType), existing, newMethodCallExpression(hasPropertyValue("value").setScope(streamOutgoingNodes(node, relation.getName())), "findAny"))))
                        .addStatements(newIfStmt(newMethodCallExpression(existing, "isPresent"), newReturnThis()))
                        .addStatements(newExpressionStmt(newFinalVariableDeclarationExpression(neoNodeType, "newNode", createNode(newMethodCallExpression(node, "getGraphDatabase"), dstEntity.getName()))))
                        .addStatements(newExpressionStmt(setProperty("newNode", "value", "dst")))
                        .addStatements(newExpressionStmt(createRelationshipTo(node, "newNode", relation.getName())))
                        .addStatements(newReturnThis()));
    }

    public static MethodDeclaration oneToManyOutgoingEnum(ClassOrInterfaceDeclaration srcEntity, Relation relation, ClassOrInterfaceDeclaration dstEntity) {
        return newAddMethodDeclaration(srcEntity, relation, dstEntity)
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newFinalVariableDeclarationExpression(optionalOf(neoNodeType), existing, newMethodCallExpression(hasPropertyValue("value").setScope(streamOutgoingNodes(node, relation.getName())), "findAny"))))
                        .addStatements(newIfStmt(newMethodCallExpression(existing, "isPresent"), newReturnThis()))
                        .addStatements(newExpressionStmt(newFinalVariableDeclarationExpression(neoNodeType, "newNode", createNode(newMethodCallExpression(node, "getGraphDatabase"), dstEntity.getName()))))
                        .addStatements(newExpressionStmt(setProperty("newNode", "value", "dst")))
                        .addStatements(newExpressionStmt(createRelationshipTo(node, "newNode", relation.getName())))
                        .addStatements(newReturnThis()));
    }

    public static MethodDeclaration oneToManyIncoming(ClassOrInterfaceDeclaration srcEntity, Relation relation, ClassOrInterfaceDeclaration dstEntity) {
        return newSetMethodDeclaration(srcEntity, relation, dstEntity)
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newFinalVariableDeclarationExpression(optionalOf(neoRelationshipType), existing, newMethodCallExpression(isRelated(node, getDstNode).setScope(streamIncoming(node, relation.getName())), "findAny"))))
                        .addStatements(newIfStmt(newMethodCallExpression(existing, "isPresent"), newReturnThis()))
                        .addStatements(newExpressionStmt(deleteIncoming(node, relation.getName())))
                        .addStatements(newExpressionStmt(createRelationshipTo(getDstNode, node, relation.getName())))
                        .addStatements(newReturnThis()));
    }

    public static MethodDeclaration oneToManyOutgoing(ClassOrInterfaceDeclaration srcEntity, Relation relation, ClassOrInterfaceDeclaration dstEntity) {
        return newAddMethodDeclaration(srcEntity, relation, dstEntity)
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newFinalVariableDeclarationExpression(optionalOf(neoRelationshipType), existing, newMethodCallExpression(isRelated(node, getDstNode).setScope(streamOutgoing(node, relation.getName())), "findAny"))))
                        .addStatements(newIfStmt(newMethodCallExpression(existing, "isPresent"), newReturnThis()))
                        .addStatements(newExpressionStmt(createRelationshipTo(node, getDstNode, relation.getName())))
                        .addStatements(newReturnThis()));
    }

    public static MethodDeclaration remove(ClassOrInterfaceDeclaration srcEntity, Relation relation, ClassOrInterfaceDeclaration dstEntity) {
        return newRemoveMethodDeclaration(srcEntity, relation, dstEntity)
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newFinalVariableDeclarationExpression(optionalOf(neoRelationshipType), existing, newMethodCallExpression(isRelated(node, getDstNode).setScope(streamOutgoing(node, relation.getName())), "findAny"))))
                        .addStatements(newExpressionStmt(newMethodCallExpression(existing, "ifPresent", newMethodReferenceExpression(neoRelationshipType, "delete"))))
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

    public static MethodDeclaration newRemoveMethodDeclaration(ClassOrInterfaceDeclaration srcEntity, Relation relation, ClassOrInterfaceDeclaration dstEntity) {
        return newPublicMethodDeclaration("remove" + capitalize(relation.getName()), newClassOrInterfaceType(srcEntity.getName()))
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

    public static MethodDeclaration getManyPrimitive(ClassOrInterfaceDeclaration srcEntity, Relation relation, ClassOrInterfaceDeclaration dstEntity, Object stream) {
        return newPublicMethodDeclaration("get" + capitalize(relation.getName()), streamOf(newClassOrInterfaceType(dstEntity.getName())))
                .setBlockStmt(newReturnBlockStmt(mapToPrimitive(dstEntity, stream)));
    }

    public static MethodDeclaration getManyEnum(ClassOrInterfaceDeclaration srcEntity, Relation relation, ClassOrInterfaceDeclaration dstEntity, Object stream) {
        return newPublicMethodDeclaration("get" + capitalize(relation.getName()), streamOf(newClassOrInterfaceType(dstEntity.getName())))
                .setBlockStmt(newReturnBlockStmt(mapToEnum(dstEntity, stream)));
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
        return newPublicMethodDeclaration("findAll" + capitalize(label), streamOf(newClassOrInterfaceType(label)))
                .setBlockStmt(newReturnBlockStmt(newMethodCallExpression()
                        .setScope(streamNodesByLabel(db, label))
                        .setName("map")
                        .addArguments(newMethodReferenceExpression()
                                .setIdentifier("new" + label)
                                .setScope(newThisExpression()))));
    }

    private static MethodDeclaration findAllNodesWithLabelAndProperty(String label, Relation relation, Entity dstEntity) {
        return newPublicMethodDeclaration("findAll" + capitalize(label) + "By" + capitalize(relation.getName()), streamOf(newClassOrInterfaceType(label)))
                .addParameters(newParameter(asJavaType(dstEntity), value))
                .setBlockStmt(newReturnBlockStmt(newMethodCallExpression(streamNodesByLabel(db, label, relation.getName(), asNeoParameter(dstEntity)), "map")
                        .addArguments(newMethodReferenceExpression()
                                .setIdentifier("new" + label)
                                .setScope(newThisExpression()))));
    }

    private static Object asNeoParameter(Entity property) {
        return isEnum(property) ? newMethodCallExpression(value, "name") : value;
    }

    private static MethodDeclaration findNodeWithLabelAndProperty(String entityName, Relation relation, Entity dstEntity) {
        return newPublicMethodDeclaration("find" + capitalize(entityName) + "By" + capitalize(relation.getName()), newClassOrInterfaceType(entityName))
                .addParameters(newParameter(asJavaType(dstEntity), value))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newFinalVariableDeclarationExpression(neoNodeType, node, findNode(db, entityName, relation.getName(), asNeoParameter(dstEntity)))))
                        .addStatements(newReturnStmt(newConditionalExpression()
                                .setCondition(isNull(node))
                                .setThenExpression(newNull())
                                .setElseExpression(newObjectCreationExpression(entityName, node)))));
    }

    private static MethodDeclaration setPropertyMethodDeclaration(Entity entity, Relation relation, Entity property) {
        return newPublicMethodDeclaration("set" + capitalize(relation.getName()), newClassOrInterfaceType(entity.getName()))
                .addParameters(newParameter(newClassOrInterfaceType(property.getName()), value))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(setProperty(node, relation.getName(), asNeoParameter(property))))
                        .addStatements(newReturnThis()));
    }

    private static MethodDeclaration getPropertyMethodDeclaration(Relation relation, Entity property) {
        return newPublicMethodDeclaration("get" + capitalize(relation.getName()), asJavaType(property))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newIfStmt()
                                .setCondition(hasProperty(node, relation.getName()))
                                .setThen(newReturnStmt(isEnum(property) ?
                                        getEnumProperty(node, relation.getName(), property.getName()) :
                                        getProperty(node, relation.getName(), asJavaType(property)))))
                        .addStatements(newReturnStmt(property.getName().equals("boolean") ? newFalseExpression() : newNull())));
    }

    private static MethodDeclaration getPropertyOrDefaultMethodDeclaration(Relation relation, Entity property) {
        return newPublicMethodDeclaration("get" + capitalize(relation.getName()), asJavaType(property))
                .addParameters(newParameter(asJavaType(property), "defaultValue"))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newIfStmt()
                                .setCondition(hasProperty(node, relation.getName()))
                                .setThen(newReturnStmt(isEnum(property) ?
                                        getEnumProperty(node, relation.getName(), property.getName()) :
                                        getProperty(node, relation.getName(), asJavaType(property)))))
                        .addStatements(newReturnStmt(property.getName().equals("boolean") ? newFalseExpression() : newExpression("defaultValue"))));
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

    private static MethodCallExpression mapToPrimitive(ClassOrInterfaceDeclaration dstEntity, Object stream) {
        return newMethodCallExpression(stream, "map")
                .addArguments(newLambdaExpression(newParameter(relationship), newCastExpression().setType(newClassOrInterfaceType(dstEntity.getName())).setExpression(getProperty(getOtherNode(relationship, node), "value"))));
    }

    private static MethodCallExpression mapToEnum(ClassOrInterfaceDeclaration dstEntity, Object stream) {
        return newMethodCallExpression(stream, "map")
                .addArguments(newLambdaExpression(newParameter(relationship), newCastExpression().setType(newClassOrInterfaceType(dstEntity.getName())).setExpression(getProperty(getOtherNode(relationship, node), "value"))));
    }

    private static IfStmt deleteOrReturnIfAlreadyRelated() {
        return newIfStmt()
                .setCondition(notNull(relationship))
                .setThen(newBlockStmt()
                        .addStatements(newIfStmt(newMethodCallExpression(getOtherNode(relationship, node), "equals").addArguments(getDstNode), newReturnThis()))
                        .addStatements(newExpressionStmt(newMethodCallExpression(relationship, "delete"))));
    }
}