package nextgen.templates.neo4j;

import static nextgen.templates.neo4j.Neo4JST.*;

/**
 * Tests for Neo4JST
 **/
public class Neo4JSTTests {

	@org.junit.Test
	public void testAll() {
		testNeoFactory();
		testNeoFactoryAccessors();
		testNeoFactoryPropertyAccessors();
		testNodeWrapper();
		testEnumAccessors();
		testEnumListAccessors();
		testExternalAccessors();
		testIncomingReferenceStream();
		testListPrimitiveAccessors();
		testListReferenceAccessors();
		testPrimitiveAccessors();
		testReferenceAccessors();
		testDirection();
		testGraphDatabaseFactory();
		testGraphDatabaseService();
		testGraphDatabaseSettings();
		testLabel();
		testNode();
		testRelationship();
		testRelationshipType();
		testTransaction();
	}

	@org.junit.Test
	public void testNeoFactory() {
		System.out.println("\n--- TEST NeoFactory:\n" + newNeoFactory());
	} 

	@org.junit.Test
	public void testNeoFactoryAccessors() {
		System.out.println("\n--- TEST NeoFactoryAccessors:\n" + newNeoFactoryAccessors());
	} 

	@org.junit.Test
	public void testNeoFactoryPropertyAccessors() {
		System.out.println("\n--- TEST NeoFactoryPropertyAccessors:\n" + newNeoFactoryPropertyAccessors());
	} 

	@org.junit.Test
	public void testNodeWrapper() {
		System.out.println("\n--- TEST NodeWrapper:\n" + newNodeWrapper());
	} 

	@org.junit.Test
	public void testEnumAccessors() {
		System.out.println("\n--- TEST EnumAccessors:\n" + newEnumAccessors());
	} 

	@org.junit.Test
	public void testEnumListAccessors() {
		System.out.println("\n--- TEST EnumListAccessors:\n" + newEnumListAccessors());
	} 

	@org.junit.Test
	public void testExternalAccessors() {
		System.out.println("\n--- TEST ExternalAccessors:\n" + newExternalAccessors());
	} 

	@org.junit.Test
	public void testIncomingReferenceStream() {
		System.out.println("\n--- TEST IncomingReferenceStream:\n" + newIncomingReferenceStream());
	} 

	@org.junit.Test
	public void testListPrimitiveAccessors() {
		System.out.println("\n--- TEST ListPrimitiveAccessors:\n" + newListPrimitiveAccessors());
	} 

	@org.junit.Test
	public void testListReferenceAccessors() {
		System.out.println("\n--- TEST ListReferenceAccessors:\n" + newListReferenceAccessors());
	} 

	@org.junit.Test
	public void testPrimitiveAccessors() {
		System.out.println("\n--- TEST PrimitiveAccessors:\n" + newPrimitiveAccessors());
	} 

	@org.junit.Test
	public void testReferenceAccessors() {
		System.out.println("\n--- TEST ReferenceAccessors:\n" + newReferenceAccessors());
	} 

	@org.junit.Test
	public void testDirection() {
		System.out.println("\n--- TEST Direction:\n" + newDirection());
	} 

	@org.junit.Test
	public void testGraphDatabaseFactory() {
		System.out.println("\n--- TEST GraphDatabaseFactory:\n" + newGraphDatabaseFactory());
	} 

	@org.junit.Test
	public void testGraphDatabaseService() {
		System.out.println("\n--- TEST GraphDatabaseService:\n" + newGraphDatabaseService());
	} 

	@org.junit.Test
	public void testGraphDatabaseSettings() {
		System.out.println("\n--- TEST GraphDatabaseSettings:\n" + newGraphDatabaseSettings());
	} 

	@org.junit.Test
	public void testLabel() {
		System.out.println("\n--- TEST Label:\n" + newLabel());
	} 

	@org.junit.Test
	public void testNode() {
		System.out.println("\n--- TEST Node:\n" + newNode());
	} 

	@org.junit.Test
	public void testRelationship() {
		System.out.println("\n--- TEST Relationship:\n" + newRelationship());
	} 

	@org.junit.Test
	public void testRelationshipType() {
		System.out.println("\n--- TEST RelationshipType:\n" + newRelationshipType());
	} 

	@org.junit.Test
	public void testTransaction() {
		System.out.println("\n--- TEST Transaction:\n" + newTransaction());
	} 
} 