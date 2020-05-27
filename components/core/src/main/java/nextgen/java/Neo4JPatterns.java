package nextgen.java;

import nextgen.java.st.*;

public class Neo4JPatterns extends JavaPatterns {

    public static final String graphdbPackage = "org.neo4j.graphdb";
    public static final String factoryPackage = graphdbPackage + ".factory";

    public static final ClassOrInterfaceType neoGraphDatabaseFactoryType = newClassOrInterfaceType().setScope(factoryPackage).addNames("GraphDatabaseFactory");
    public static final ClassOrInterfaceType neoGraphDatabaseSettingsType = newClassOrInterfaceType().setScope(factoryPackage).addNames("GraphDatabaseSettings");

    public static final ClassOrInterfaceType neoGraphDatabaseServiceType = newClassOrInterfaceType().setScope(graphdbPackage).addNames("GraphDatabaseService");
    public static final ClassOrInterfaceType neoNodeType = newClassOrInterfaceType().setScope(graphdbPackage).addNames("Node");
    public static final ClassOrInterfaceType neoLabelType = newClassOrInterfaceType().setScope(graphdbPackage).addNames("Label");
    public static final ClassOrInterfaceType neoDirectionType = newClassOrInterfaceType().setScope(graphdbPackage).addNames("Direction");
    public static final ClassOrInterfaceType neoRelationshipType = newClassOrInterfaceType().setScope(graphdbPackage).addNames("Relationship");
    public static final ClassOrInterfaceType neoRelationshipTypeType = newClassOrInterfaceType().setScope(graphdbPackage).addNames("RelationshipType");
    public static final ClassOrInterfaceType neoTransactionType = newClassOrInterfaceType().setScope(graphdbPackage).addNames("Transaction");

    public static final FieldAccessExpression INCOMING = newFieldAccessExpression(neoDirectionType, "INCOMING");
    public static final FieldAccessExpression OUTGOING = newFieldAccessExpression(neoDirectionType, "OUTGOING");

    public static Statement doInStatement(Object db, BlockStmt blockStmt) {
        return newTryStmt()
                .addResources(newTransactionVariable(db, "tx"))
                .setTryBlock(blockStmt
                        .addStatements(txSuccessStatement("tx")))
                .addCatchClauses(newCatchClause()
                        .setParameter(newParameter()
                                .setType(ThrowableType)
                                .setName("t"))
                        .setBody(newBlockStmt()
                                .addStatements(newExpressionStmt()
                                        .setExpression(newMethodCallExpression()
                                                .setScope("t")
                                                .setName("printStackTrace")))));
    }

    public static ExpressionStmt txSuccessStatement(String tx) {
        return newExpressionStmt()
                .setExpression(newMethodCallExpression(tx, "success"));
    }

    public static VariableDeclaration newTransactionVariable(Object db, String name) {
        return newVariableDeclaration()
                .setType(neoTransactionType)
                .setName(name)
                .setInitializer(newMethodCallExpression(db, "beginTx"));
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
        return stream(newMethodCallExpression(findNodes(db, label), "stream"));
    }

    public static MethodCallExpression streamNodesByLabel(Object db, String label, String property, Object valueVariable) {
        return stream(newMethodCallExpression(findNodesWithProperty(db, label, property, valueVariable), "stream"));
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
        return stream(getOutgoingRelationships(node, relationType));
    }

    public static MethodCallExpression streamOutgoingNodes(Object node, String relationType) {
        return newMethodCallExpression(stream(getOutgoingRelationships(node, relationType)), "map", newLambdaExpression(newParameter("r"), newExpression(getOtherNode("r", node))));
    }

    public static MethodCallExpression streamIncoming(Object node, String relationType) {
        return stream(getIncomingRelationships(node, relationType));
    }

    public static MethodCallExpression getOutgoingRelationships(Object node, String relationType) {
        return newMethodCallExpression(node, "getRelationships")
                .addArguments(OUTGOING)
                .addArguments(withName(relationType));
    }

    public static MethodCallExpression getIncomingRelationships(Object node, String relationType) {
        return newMethodCallExpression(node, "getRelationships")
                .addArguments(INCOMING)
                .addArguments(withName(relationType));
    }

    public static MethodCallExpression getSingleOutgoingRelationship(Object src, String relationType) {
        return newMethodCallExpression(src, "getSingleRelationship")
                .addArguments(withName(relationType))
                .addArguments(OUTGOING);
    }

    public static MethodCallExpression getSingleIncomingRelationship(Object src, String relationType) {
        return newMethodCallExpression(src, "getSingleRelationship")
                .addArguments(withName(relationType))
                .addArguments(INCOMING);
    }

    public static MethodCallExpression deleteOutgoing(Object node, String relationType) {
        return newMethodCallExpression(getOutgoingRelationships(node, relationType), "forEach")
                .addArguments(deleteRelationReferenceExpression());
    }

    public static MethodCallExpression deleteIncoming(Object node, String relationType) {
        return newMethodCallExpression(getIncomingRelationships(node, relationType), "forEach")
                .addArguments(deleteRelationReferenceExpression());
    }

    public static MethodCallExpression createRelationshipTo(Object src, Object dst, String relationType) {
        return newMethodCallExpression(src, "createRelationshipTo")
                .addArguments(dst)
                .addArguments(withName(relationType));
    }

    public static MethodCallExpression isRelated(Object src, Object dst) {
        return newMethodCallExpression("filter")
                .addArguments(newLambdaExpression(newParameter("r"), newMethodCallExpression(getOtherNode("r", src), "equals", dst)));
    }

    public static MethodCallExpression hasPropertyValue(String property) {
        return newMethodCallExpression("filter")
                .addArguments(newLambdaExpression(newParameter("n"), newMethodCallExpression("dst", "equals", getProperty("n", property))));
    }

    public static MethodCallExpression getOtherNode(Object relationship, Object src) {
        return newMethodCallExpression(relationship, "getOtherNode", src);
    }

    public static MethodCallExpression removeProperty(Object propertyContainer, String property) {
        return newMethodCallExpression(propertyContainer, "removeProperty", newStringLiteralExpression(property));
    }

    public static MethodCallExpression setProperty(Object propertyContainer, String property, Object value) {
        return newMethodCallExpression(propertyContainer, "setProperty")
                .addArguments(newStringLiteralExpression(property))
                .addArguments(value);
    }

    public static MethodCallExpression setEnumProperty(Object propertyContainer, String property, Object value) {
        return newMethodCallExpression(propertyContainer, "setProperty")
                .addArguments(newStringLiteralExpression(property))
                .addArguments(newMethodCallExpression(value, "name"));
    }

    public static MethodCallExpression getProperty(Object propertyContainer, String property) {
        return newMethodCallExpression(propertyContainer, "getProperty", newStringLiteralExpression(property));
    }

    public static MethodCallExpression getEnumProperty(Object propertyContainer, String property, String enumName) {
        return newMethodCallExpression(enumName, "valueOf", getProperty(propertyContainer, property, StringType));
    }

    public static CastExpression getProperty(Object propertyContainer, String property, ClassOrInterfaceType classOrInterfaceType) {
        return newCastExpression()
                .setType(classOrInterfaceType)
                .setExpression(getProperty(propertyContainer, property));
    }

    public static MethodCallExpression hasProperty(Object propertyContainer, String property) {
        return newMethodCallExpression(propertyContainer, "hasProperty", newStringLiteralExpression(property));
    }

    public static MethodCallExpression stream(Expression expression) {
        return newMethodCallExpression(StreamSupportType, "stream")
                .addArguments(newMethodCallExpression(expression, "spliterator"))
                .addArguments(newFalseExpression());
    }

    public static MethodReferenceExpression deleteRelationReferenceExpression() {
        return newMethodReferenceExpression()
                .setIdentifier("delete")
                .setScope(neoRelationshipType);
    }
}