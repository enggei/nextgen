package nextgen.domain;

import nextgen.domain.domain.Domain;
import nextgen.domain.domain.Entity;
import nextgen.domain.domain.Relation;
import nextgen.java.JavaPatterns;
import nextgen.java.st.*;
import org.jetbrains.annotations.NotNull;

import java.io.File;
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

    public static void generate(File root, PackageDeclaration packageDeclaration, Domain domain) {
        generate(root.getAbsolutePath(), packageDeclaration.getName(), domain);
    }

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
                final String dstName = relation.getDst().getName();

                switch (relation.getDst().getType()) {

                    case PRIMITIVE:
                        srcEntity.addMembers(setPropertyMethodDeclaration(relation));
                        srcEntity.addMembers(getPropertyMethodDeclaration(relation));
                        srcEntity.addMembers(getPropertyOrDefaultMethodDeclaration(relation));
                        srcEntity.addMembers(hasPropertyMethodDeclaration(relation));
                        srcEntity.addMembers(removePropertyMethodDeclaration(relation));

                        if (isLexical(relation)) srcEntity.addMembers(toStringMethod(relation));

                        domainClass.addMembers(findNodeWithLabelAndProperty(relation));
                        domainClass.addMembers(findOrCreateNodeWithLabelAndProperty(relation));
                        domainClass.addMembers(findAllNodesWithLabelAndProperty(relation));
                        break;
                    case REFERENCE:
                        srcEntity.addMembers(oneToOneOutgoing(relation));
                        srcEntity.addMembers(getSingleOutgoing(relation));
                        srcEntity.addMembers(remove(relation));

                        final ClassOrInterfaceDeclaration dstEntity = entityClassMap.get(relation.getDst());
                        dstEntity.addMembers(getManyIncoming(relation));
                        break;
                    case EXTERNAL:
                        srcEntity.addFields(newPrivateFieldDeclaration().setName(DomainToPojos.variableName(relation)).setType(newClassOrInterfaceType(dstName)));
                        srcEntity.addMembers(DomainToPojos.oneToOne(relation));
                        srcEntity.addMembers(DomainToPojos.getSingle(relation));
                        srcEntity.addMembers(DomainToPojos.hasPropertyMethodDeclaration(relation));
                        break;
                    case ENUM:
                        srcEntity.addMembers(setPropertyMethodDeclaration(relation));
                        srcEntity.addMembers(getPropertyMethodDeclaration(relation));
                        srcEntity.addMembers(getPropertyOrDefaultMethodDeclaration(relation));
                        srcEntity.addMembers(hasPropertyMethodDeclaration(relation));
                        srcEntity.addMembers(removePropertyMethodDeclaration(relation));

                        domainClass.addMembers(findNodeWithLabelAndProperty(relation));
                        domainClass.addMembers(findAllNodesWithLabelAndProperty(relation));
                        break;
                }
            }

            @Override
            protected void visitOneToMany(Relation relation) {

                final ClassOrInterfaceDeclaration srcEntity = entityClassMap.get(relation.getSrc());
                final String dstName = relation.getDst().getName();

                switch (relation.getDst().getType()) {

                    case PRIMITIVE:
                        srcEntity.addMembers(oneToManyOutgoingPrimitive(relation));
                        srcEntity.addMembers(getManyPrimitive(relation));
                        break;
                    case REFERENCE:
                        srcEntity.addMembers(oneToManyOutgoing(relation));
                        srcEntity.addMembers(getMany(relation));
                        srcEntity.addMembers(remove(relation));

                        final ClassOrInterfaceDeclaration dstEntity = entityClassMap.get(relation.getDst());
                        dstEntity.addMembers(getManyIncoming(relation));
                        break;
                    case EXTERNAL:
                        srcEntity.addFields(newPrivateFieldDeclaration().setName(DomainToPojos.variableName(relation)).setType(listOf(newClassOrInterfaceType(dstName))));
                        srcEntity.addMembers(DomainToPojos.getList(relation));
                        srcEntity.addMembers(DomainToPojos.oneToMany(relation));
                        break;
                    case ENUM:
                        srcEntity.addMembers(oneToManyOutgoingEnum(relation));
                        srcEntity.addMembers(getManyEnum(relation));
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

    public static MethodDeclaration oneToManyOutgoingPrimitive(Relation relation) {
        return newAddMethodDeclaration(relation)
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newFinalVariableDeclarationExpression(optionalOf(neoNodeType), existing, findAny(hasPropertyValue(streamOutgoingNodes(node, relation.getName()), value, dst)))))
                        .addStatements(returnThisIfExists())
                        .addStatements(newExpressionStmt(newFinalVariableDeclarationExpression(neoNodeType, "newNode", createNode(newMethodCallExpression(node, "getGraphDatabase"), relation.getDst().getName()))))
                        .addStatements(newExpressionStmt(setProperty("newNode", value, dst)))
                        .addStatements(newExpressionStmt(createRelationshipTo(node, "newNode", relation.getName())))
                        .addStatements(newReturnThis()));
    }

    public static IfStmt returnThisIfExists() {
        return newIfStmt(newMethodCallExpression(existing, "isPresent"), newReturnThis());
    }

    public static MethodDeclaration oneToManyOutgoingEnum(Relation relation) {
        return newAddMethodDeclaration(relation)
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newFinalVariableDeclarationExpression(optionalOf(neoNodeType), existing, findAny(hasPropertyValue(streamOutgoingNodes(node, relation.getName()), value, dst)))))
                        .addStatements(returnThisIfExists())
                        .addStatements(newExpressionStmt(newFinalVariableDeclarationExpression(neoNodeType, "newNode", createNode(newMethodCallExpression(node, "getGraphDatabase"), relation.getDst().getName()))))
                        .addStatements(newExpressionStmt(setProperty("newNode", value, dst)))
                        .addStatements(newExpressionStmt(createRelationshipTo(node, "newNode", relation.getName())))
                        .addStatements(newReturnThis()));
    }

    public static MethodDeclaration oneToManyOutgoing(Relation relation) {
        return newAddMethodDeclaration(relation)
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newFinalVariableDeclarationExpression(optionalOf(neoRelationshipType), existing, findAny(isRelated(streamOutgoing(node, relation.getName()), node, getDstNode)))))
                        .addStatements(returnThisIfExists())
                        .addStatements(newExpressionStmt(createRelationshipTo(node, getDstNode, relation.getName())))
                        .addStatements(newReturnThis()));
    }

    public static MethodDeclaration remove(Relation relation) {
        return newRemoveMethodDeclaration(relation)
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newFinalVariableDeclarationExpression(optionalOf(neoRelationshipType), existing, findAny(isRelated(streamOutgoing(node, relation.getName()), node, getDstNode)))))
                        .addStatements(newExpressionStmt(newMethodCallExpression(existing, "ifPresent", newMethodReferenceExpression(neoRelationshipType, "delete"))))
                        .addStatements(newReturnThis()));
    }

    public static MethodDeclaration oneToOneOutgoing(Relation relation) {
        return newSetMethodDeclaration(relation)
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newFinalVariableDeclarationExpression(neoRelationshipType, relationship, getSingleOutgoingRelationship(node, relation.getName()))))
                        .addStatements(deleteOrReturnIfAlreadyRelated())
                        .addStatements(newExpressionStmt(createRelationshipTo(node, getDstNode, relation.getName())))
                        .addStatements(newReturnThis()));
    }

    public static MethodDeclaration newAddMethodDeclaration(Relation relation) {
        return newPublicMethodDeclaration(adderName(relation), newClassOrInterfaceType(relation.getSrc().getName()))
                .addParameters(newParameter(newClassOrInterfaceType(relation.getDst().getName()), dst));
    }

    public static MethodDeclaration newRemoveMethodDeclaration(Relation relation) {
        return newPublicMethodDeclaration("remove" + capitalize(relation.getName()), newClassOrInterfaceType(relation.getSrc().getName()))
                .addParameters(newParameter(newClassOrInterfaceType(relation.getDst().getName()), dst));
    }

    public static MethodDeclaration newSetMethodDeclaration(Relation relation) {
        return newPublicMethodDeclaration(setterName(relation), newClassOrInterfaceType(relation.getSrc().getName()))
                .addParameters(newParameter(newClassOrInterfaceType(relation.getDst().getName()), dst));
    }

    public static MethodDeclaration getMany(Relation relation) {
        return newPublicMethodDeclaration(getterName(relation), streamOf(newClassOrInterfaceType(relation.getDst().getName())))
                .setBlockStmt(newReturnBlockStmt(mapToEntity(relation.getDst(), streamOutgoing(node, relation.getName()))));
    }

    public static MethodDeclaration getManyIncoming(Relation relation) {
        return newPublicMethodDeclaration("getIncoming" + capitalize(relation.getName()), streamOf(newClassOrInterfaceType(relation.getSrc().getName())))
                .setBlockStmt(newReturnBlockStmt(mapToEntity(relation.getSrc(), streamIncoming(node, relation.getName()))));
    }

    public static MethodDeclaration getManyPrimitive(Relation relation) {
        return newPublicMethodDeclaration(getterName(relation), streamOf(newClassOrInterfaceType(relation.getDst().getName())))
                .setBlockStmt(newReturnBlockStmt(mapToPrimitive(relation.getDst(), streamOutgoing(node, relation.getName()))));
    }

    public static MethodDeclaration getManyEnum(Relation relation) {
        return newPublicMethodDeclaration(getterName(relation), streamOf(newClassOrInterfaceType(relation.getDst().getName())))
                .setBlockStmt(newReturnBlockStmt(mapToEnum(relation.getDst(), streamOutgoing(node, relation.getName()))));
    }

    public static MethodDeclaration getSingleOutgoing(Relation relation) {
        return newPublicMethodDeclaration(getterName(relation), newClassOrInterfaceType(relation.getDst().getName()))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newFinalVariableDeclarationExpression(neoRelationshipType, relationship, getSingleOutgoingRelationship(node, relation.getName()))))
                        .addStatements(newReturnStmt(newConditionalExpression()
                                .setCondition(isNull(relationship))
                                .setThenExpression(newNull())
                                .setElseExpression(newObjectCreationExpression(relation.getDst().getName())
                                        .addArguments(getOtherNode(relationship, node))))));
    }

    public static ClassOrInterfaceDeclaration newDatabaseWrapper(Domain domain) {

        final String className = domain.getName() + "NeoFactory";

        return newPublicClassDeclaration(className)
                .addFields(newPrivateFinalFieldDeclaration(neoGraphDatabaseServiceType, db))
                .addMembers(newPublicConstructorDeclaration()
                        .setName(className)
                        .addParameters(newParameter(StringType, "dir"))
                        .setBlockStmt(newBlockStmt()
                                .addStatements(newExpressionStmt(newThisConstructorCall(newGraphDatabase("dir"))))
                                .addStatements(newAddShutdownHook(newMethodReferenceExpression("shutdown","db")))))
                .addMembers(newPublicConstructorDeclaration()
                        .setName(className)
                        .addParameters(newParameter(neoGraphDatabaseServiceType, db))
                        .setBlockStmt(newBlockStmt(newAssignThisVariableExpression(db))))
                .addMembers(newPublicMethodDeclaration("getDatabaseService", neoGraphDatabaseServiceType)
                        .setBlockStmt(newReturnBlockStmt(newThisVariableExpression(db))))
                .addMembers(newPublicMethodDeclaration("doInTransaction")
                        .addParameters(newParameter(consumerOf(neoTransactionType), "action"))
                        .setBlockStmt(newBlockStmt(newMethodCallExpression(null, "doInTransaction", "action", newMethodReferenceExpression(ThrowableType, "printStackTrace")))))
                .addMembers(newPublicMethodDeclaration("doInTransaction")
                        .addParameters(newParameter(consumerOf(neoTransactionType), "action"))
                        .addParameters(newParameter(consumerOf(ThrowableType), "onException"))
                        .setBlockStmt(newBlockStmt(newTryStmt()
                                .addResources(newTransactionVariable(db, "tx"))
                                .setTryBlock(newBlockStmt()
                                        .addStatements(newExpressionStmt(newMethodCallExpression("action", "accept", "tx")))
                                        .addStatements(txSuccessStatement("tx")))
                                .addCatchClauses(newCatchClause(newParameter(ThrowableType, "t"), newBlockStmt(newMethodCallExpression("onException", "accept", "t")))))));
    }

    public static ClassOrInterfaceDeclaration newNeoWrapper(String name) {
        return newPublicClassDeclaration(name)
                .addFields(newPrivateFinalFieldDeclaration(neoNodeType, node))
                .addMembers(newPublicConstructorDeclaration(name, newParameter(neoNodeType, node))
                        .setBlockStmt(newBlockStmt(newAssignThisVariableExpression(node))))
                .addMembers(newPublicMethodDeclaration("getNode", neoNodeType)
                        .setBlockStmt(newReturnBlockStmt(newThisVariableExpression(node))))
                .addMembers(newEqualsMethod(name, node))
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
                .setBlockStmt(newReturnBlockStmt(map(streamNodesByLabel(db, label), newMethodReferenceExpression("new" + label, newThisExpression()))));
    }

    private static MethodDeclaration findAllNodesWithLabelAndProperty(Relation relation) {
        return newPublicMethodDeclaration("findAll" + capitalize(relation.getSrc().getName()) + "By" + capitalize(relation.getName()), streamOf(newClassOrInterfaceType(relation.getSrc().getName())))
                .addParameters(newParameter(newClassOrInterfaceType(relation.getDst().getName()), value))
                .setBlockStmt(newReturnBlockStmt(map(streamNodesByLabel(db, relation.getSrc().getName(), relation.getName(), asArgument(relation.getDst())), newMethodReferenceExpression("new" + relation.getSrc().getName(), newThisExpression()))));
    }

    private static Object asArgument(Entity entity) {
        switch (entity.getType()) {
            case PRIMITIVE:
            case REFERENCE:
            case EXTERNAL:
                return value;
            case ENUM:
                return newMethodCallExpression(value, "name");
        }
        throw new RuntimeException("unsupported entity type " + entity.getType());
    }

    private static Expression getEntityProperty(Relation relation, Entity entity) {
        switch (entity.getType()) {
            case PRIMITIVE:
                return getProperty(node, relation.getName(), newClassOrInterfaceType(entity.getName()));
            case ENUM:
                return getEnumProperty(node, relation.getName(), entity.getName());
        }
        throw new RuntimeException("unsupported entity type " + entity.getType());
    }

    private static MethodDeclaration findNodeWithLabelAndProperty(Relation relation) {
        return newPublicMethodDeclaration(findNodeByPropertyName(relation), newClassOrInterfaceType(relation.getSrc().getName()))
                .addParameters(newParameter(newClassOrInterfaceType(relation.getDst().getName()), value))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newFinalVariableDeclarationExpression(neoNodeType, node, findNode(db, relation.getSrc().getName(), relation.getName(), asArgument(relation.getDst())))))
                        .addStatements(newReturnStmt(newConditionalExpression()
                                .setCondition(isNull(node))
                                .setThenExpression(newNull())
                                .setElseExpression(newObjectCreationExpression(relation.getSrc().getName(), node)))));
    }

    @NotNull
    private static String findNodeByPropertyName(Relation relation) {
        return "find" + capitalize(relation.getSrc().getName()) + "By" + capitalize(relation.getName());
    }

    private static MethodDeclaration findOrCreateNodeWithLabelAndProperty(Relation relation) {
        return newPublicMethodDeclaration("findOrCreate" + capitalize(relation.getSrc().getName()) + "By" + capitalize(relation.getName()), newClassOrInterfaceType(relation.getSrc().getName()))
                .addParameters(newParameter(newClassOrInterfaceType(relation.getDst().getName()), value))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(newFinalVariableDeclarationExpression(newClassOrInterfaceType(relation.getSrc().getName()), "existing", newMethodCallExpression(null, findNodeByPropertyName(relation), value))))
                        .addStatements(newReturnStmt(newConditionalExpression()
                                .setCondition(isNull("existing"))
                                .setThenExpression(newMethodCallExpression(newMethodCallExpression("new" + relation.getSrc().getName()), setterName(relation), value))
                                .setElseExpression("existing"))));
    }

    private static MethodDeclaration setPropertyMethodDeclaration(Relation relation) {
        return newPublicMethodDeclaration(setterName(relation), newClassOrInterfaceType(relation.getSrc().getName()))
                .addParameters(newParameter(newClassOrInterfaceType(relation.getDst().getName()), value))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newIfStmt()
                                .setCondition(isNull(value))
                                .setThen(newExpressionStmt(removeProperty(node, relation.getName())))
                                .setElseStmt(newExpressionStmt(setProperty(node, relation.getName(), asArgument(relation.getDst())))))
                        .addStatements(newReturnThis()));
    }

    private static MethodDeclaration getPropertyMethodDeclaration(Relation relation) {
        return newPublicMethodDeclaration(getterName(relation), newClassOrInterfaceType(relation.getDst().getName()))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newIfStmt()
                                .setCondition(hasProperty(node, relation.getName()))
                                .setThen(newReturnStmt(getEntityProperty(relation, relation.getDst()))))
                        .addStatements(newReturnStmt(relation.getDst().getName().equals("Boolean") ? newFalseExpression() : newNull())));
    }

    private static MethodDeclaration getPropertyOrDefaultMethodDeclaration(Relation relation) {
        return newPublicMethodDeclaration(getterName(relation), newClassOrInterfaceType(relation.getDst().getName()))
                .addParameters(newParameter(newClassOrInterfaceType(relation.getDst().getName()), "defaultValue"))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newIfStmt()
                                .setCondition(hasProperty(node, relation.getName()))
                                .setThen(newReturnStmt(getEntityProperty(relation, relation.getDst()))))
                        .addStatements(newReturnStmt(newExpression("defaultValue"))));
    }

    private static MethodDeclaration hasPropertyMethodDeclaration(Relation relation) {
        return newPublicMethodDeclaration("has" + capitalize(relation.getName()), booleanType)
                .setBlockStmt(newReturnBlockStmt(hasProperty(node, relation.getName())));
    }

    private static MethodDeclaration removePropertyMethodDeclaration(Relation relation) {
        return newPublicMethodDeclaration(removeName(relation), newClassOrInterfaceType(relation.getSrc().getName()))
                .setBlockStmt(newBlockStmt()
                        .addStatements(newExpressionStmt(removeProperty(node, relation.getName())))
                        .addStatements(newReturnThis()));
    }

    private static MethodCallExpression mapToEntity(Entity dstEntity, Expression stream) {
        return map(stream, newLambdaExpression(relationship, newObjectCreationExpression(dstEntity.getName(), getOtherNode(relationship, node))));
    }

    private static MethodCallExpression mapToPrimitive(Entity dstEntity, Expression stream) {
        return map(stream, newLambdaExpression(relationship, newCastExpression().setType(newClassOrInterfaceType(dstEntity.getName())).setExpression(getProperty(getOtherNode(relationship, node), value))));
    }

    private static MethodCallExpression mapToEnum(Entity dstEntity, Expression stream) {
        return map(stream, newLambdaExpression(relationship, newCastExpression().setType(newClassOrInterfaceType(dstEntity.getName())).setExpression(getProperty(getOtherNode(relationship, node), value))));
    }

    private static IfStmt deleteOrReturnIfAlreadyRelated() {
        return newIfStmt()
                .setCondition(notNull(relationship))
                .setThen(newBlockStmt()
                        .addStatements(newIfStmt(isEqual(getOtherNode(relationship, node), getDstNode), newReturnThis()))
                        .addStatements(newExpressionStmt(newMethodCallExpression(relationship, "delete"))));
    }

    public static MethodDeclaration toStringMethod(Relation relation) {
        return relation.getDst().getName().equals("String") ?
                newToStringMethod(newCastExpression(StringType, getProperty(node, relation.getName())))
                : newToStringMethod(newConditionalExpression()
                .setCondition(hasProperty(node, relation.getName()))
                .setThenExpression(newMethodCallExpression(getProperty(node, relation.getName()), "toString"))
                .setElseExpression(newExpression("")));
    }
}