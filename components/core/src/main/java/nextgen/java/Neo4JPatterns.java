package nextgen.java;

import nextgen.java.st.*;
@Deprecated
public class Neo4JPatterns extends JavaPatterns {

    public static final String corePackage = "org.neo4j.graphdb";
    public static final String factoryPackage = corePackage + ".factory";

    public static final ClassOrInterfaceType neoGraphDatabaseFactoryType = newClassOrInterfaceType().setScope(factoryPackage).addNames("GraphDatabaseFactory");
    public static final ClassOrInterfaceType neoGraphDatabaseSettingsType = newClassOrInterfaceType().setScope(factoryPackage).addNames("GraphDatabaseSettings");

    public static final ClassOrInterfaceType neoGraphDatabaseServiceType = newClassOrInterfaceType().setScope(corePackage).addNames("GraphDatabaseService");
    public static final ClassOrInterfaceType neoNodeType = newClassOrInterfaceType().setScope(corePackage).addNames("Node");
    public static final ClassOrInterfaceType neoLabelType = newClassOrInterfaceType().setScope(corePackage).addNames("Label");
    public static final ClassOrInterfaceType neoDirectionType = newClassOrInterfaceType().setScope(corePackage).addNames("Direction");
    public static final ClassOrInterfaceType neoRelationshipType = newClassOrInterfaceType().setScope(corePackage).addNames("Relationship");
    public static final ClassOrInterfaceType neoRelationshipTypeType = newClassOrInterfaceType().setScope(corePackage).addNames("RelationshipType");
    public static final ClassOrInterfaceType neoTransactionType = newClassOrInterfaceType().setScope(corePackage).addNames("Transaction");

    public static final FieldAccessExpression INCOMING = newFieldAccessExpression(neoDirectionType, "INCOMING");
    public static final FieldAccessExpression OUTGOING = newFieldAccessExpression(neoDirectionType, "OUTGOING");

    public static Statement doInTransaction(Object db, BlockStmt blockStmt) {
        return newTryStmt()
                .addResources(newTransactionVariable(db, "tx"))
                .setTryBlock(blockStmt.addStatements(txSuccessStatement("tx")))
                .addCatchClauses(newCatchClause(newParameter(ThrowableType, "t"), newBlockStmt(newMethodCallExpression("t", "printStackTrace"))));
    }

    public static ExpressionStmt txSuccessStatement(String tx) {
        return newExpressionStmt(newMethodCallExpression(tx, "success"));
    }

    public static VariableDeclaration newTransactionVariable(Object db, String name) {
        return newVariableDeclaration(neoTransactionType, name, newMethodCallExpression(db, "beginTx"));
    }

    public static MethodCallExpression newGraphDatabase(String pathVariable) {
        return newMethodCallExpression("newGraphDatabase")
                .setScope(newMethodCallExpression("setConfig")
                        .addArguments(newFieldAccessExpression(neoGraphDatabaseSettingsType, "allow_upgrade"))
                        .addArguments(newStringLiteralExpression("true"))
                        .setScope(newMethodCallExpression(newObjectCreationExpression(neoGraphDatabaseFactoryType), "newEmbeddedDatabaseBuilder", newObjectCreationExpression(FileType, pathVariable))));
    }

    public static MethodCallExpression createNode(Object db) {
        return newMethodCallExpression(db, "createNode");
    }

    public static MethodCallExpression createNode(Object db, String label) {
        return newMethodCallExpression(db, "createNode", label(label));
    }

    public static MethodCallExpression streamNodesByLabel(Object db, String label) {
        return stream(findNodes(db, label));
    }

    public static MethodCallExpression streamNodesByLabel(Object db, String label, String property, Object valueVariable) {
        return stream(findNodesWithProperty(db, label, property, valueVariable));
    }

    public static MethodCallExpression findNodes(Object db, String label) {
        return newMethodCallExpression(db, "findNodes", label(label));
    }

    public static MethodCallExpression findNodesWithProperty(Object db, String label, String property, Object valueVariable) {
        return newMethodCallExpression(db, "findNodes")
                .addArguments(label(label))
                .addArguments(newStringLiteralExpression(property))
                .addArguments(valueVariable);
    }

    public static MethodCallExpression label(String label) {
        return newMethodCallExpression(neoLabelType, "label", newStringLiteralExpression(label));
    }

    public static MethodCallExpression withName(String relationType) {
        return newMethodCallExpression(neoRelationshipTypeType, "withName", newStringLiteralExpression(relationType));
    }

    public static MethodCallExpression findNode(Object db, String label, String property, Object value) {
        return newMethodCallExpression(db, "findNode")
                .addArguments(label(label))
                .addArguments(newStringLiteralExpression(property))
                .addArguments(value);
    }

    public static MethodCallExpression streamOutgoing(Object node, String relationType) {
        return asStream(getOutgoingRelationships(node, relationType));
    }

    public static MethodCallExpression streamIncoming(Object node, String relationType) {
        return asStream(getIncomingRelationships(node, relationType));
    }

    public static MethodCallExpression streamOutgoingNodes(Object node, String relationType) {
        return map(streamOutgoing(node, relationType), newLambdaExpression("r", newExpression(getOtherNode("r", node))));
    }

    public static MethodCallExpression streamIncomingNodes(Object node, String relationType) {
        return map(streamIncomingNodes(node, relationType), newLambdaExpression("r", newExpression(getOtherNode("r", node))));
    }

    public static MethodCallExpression getOutgoingRelationships(Object node, String relationType) {
        return newMethodCallExpression(node, "getRelationships", OUTGOING, withName(relationType));
    }

    public static MethodCallExpression getIncomingRelationships(Object node, String relationType) {
        return newMethodCallExpression(node, "getRelationships", INCOMING, withName(relationType));
    }

    public static MethodCallExpression getSingleOutgoingRelationship(Object src, String relationType) {
        return newMethodCallExpression(src, "getSingleRelationship", withName(relationType), OUTGOING);
    }

    public static MethodCallExpression getSingleIncomingRelationship(Object src, String relationType) {
        return newMethodCallExpression(src, "getSingleRelationship", withName(relationType), INCOMING);
    }

    public static MethodCallExpression deleteOutgoing(Object node, String relationType) {
        return forEach(getOutgoingRelationships(node, relationType), deleteRelationReferenceExpression());
    }

    public static MethodCallExpression deleteIncoming(Object node, String relationType) {
        return forEach(getIncomingRelationships(node, relationType), deleteRelationReferenceExpression());
    }

    public static MethodCallExpression createRelationshipTo(Object src, Object dst, String relationType) {
        return newMethodCallExpression(src, "createRelationshipTo", dst, withName(relationType));
    }

    public static MethodCallExpression isRelated(Expression scope, Object src, Object dst) {
        return filter(scope, newLambdaExpression("r", isEqual(getOtherNode("r", src), dst)));
    }

    public static MethodCallExpression hasPropertyValue(Expression scope, String property, Object value) {
        return filter(scope, newLambdaExpression("n", isEqual(value, getProperty("n", property))));
    }

    public static MethodCallExpression getOtherNode(Object relationship, Object src) {
        return newMethodCallExpression(relationship, "getOtherNode", src);
    }

    public static MethodCallExpression removeProperty(Object propertyContainer, String property) {
        return newMethodCallExpression(propertyContainer, "removeProperty", newStringLiteralExpression(property));
    }

    public static MethodCallExpression setProperty(Object propertyContainer, String property, Object value) {
        return newMethodCallExpression(propertyContainer, "setProperty", newStringLiteralExpression(property), value);
    }

    public static MethodCallExpression setEnumProperty(Object propertyContainer, String property, Object value) {
        return newMethodCallExpression(propertyContainer, "setProperty", newStringLiteralExpression(property), nameOf(value));
    }

    public static MethodCallExpression getProperty(Object propertyContainer, String property) {
        return newMethodCallExpression(propertyContainer, "getProperty", newStringLiteralExpression(property));
    }

    public static MethodCallExpression getEnumProperty(Object propertyContainer, String property, String enumName) {
        return valueOf(enumName, getProperty(propertyContainer, property, StringType));
    }

    public static MethodCallExpression hasProperty(Object propertyContainer, String property) {
        return newMethodCallExpression(propertyContainer, "hasProperty", newStringLiteralExpression(property));
    }

    public static MethodCallExpression asStream(Expression expression) {
        return newMethodCallExpression(StreamSupportType, "stream", newMethodCallExpression(expression, "spliterator"), newFalseExpression());
    }

    public static MethodReferenceExpression deleteRelationReferenceExpression() {
        return newMethodReferenceExpression()
                .setIdentifier("delete")
                .setScope(neoRelationshipType);
    }

    public static CastExpression getProperty(Object propertyContainer, String property, ClassOrInterfaceType classOrInterfaceType) {
        return newCastExpression(classOrInterfaceType, getProperty(propertyContainer, property));
    }
}