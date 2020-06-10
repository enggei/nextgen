package nextgen.templates.vertx;

import static nextgen.templates.vertx.VertxST.*;

/**
 * Tests for VertxST
 **/
public class VertxSTTests {

	@org.junit.Test
	public void testAll() {
		testJsonFactory();
		testJsonWrapper();
		testEnumAccessors();
		testExternalAccessors();
		testListPrimitiveAccessors();
		testListReferenceAccessors();
		testPrimitiveAccessors();
		testReferenceAccessors();
	}

	@org.junit.Test
	public void testJsonFactory() {
		System.out.println("\n--- TEST JsonFactory:\n" + newJsonFactory());
	} 

	@org.junit.Test
	public void testJsonWrapper() {
		System.out.println("\n--- TEST JsonWrapper:\n" + newJsonWrapper());
	} 

	@org.junit.Test
	public void testEnumAccessors() {
		System.out.println("\n--- TEST EnumAccessors:\n" + newEnumAccessors());
	} 

	@org.junit.Test
	public void testExternalAccessors() {
		System.out.println("\n--- TEST ExternalAccessors:\n" + newExternalAccessors());
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
} 