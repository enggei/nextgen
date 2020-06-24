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
		testDeleteNode();
		testEnumAccessors();
		testEnumListAccessors();
		testExternalAccessors();
		testIncomingReferenceStream();
		testListPrimitiveAccessors();
		testListReferenceAccessors();
		testNodeToJsonObject();
		testPrimitiveAccessors();
		testReferenceAccessors();
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
	public void testDeleteNode() {
		System.out.println("\n--- TEST DeleteNode:\n" + newDeleteNode());
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
	public void testNodeToJsonObject() {
		System.out.println("\n--- TEST NodeToJsonObject:\n" + newNodeToJsonObject());
	} 

	@org.junit.Test
	public void testPrimitiveAccessors() {
		System.out.println("\n--- TEST PrimitiveAccessors:\n" + newPrimitiveAccessors());
	} 

	@org.junit.Test
	public void testReferenceAccessors() {
		System.out.println("\n--- TEST ReferenceAccessors:\n" + newReferenceAccessors());
	} 
} 