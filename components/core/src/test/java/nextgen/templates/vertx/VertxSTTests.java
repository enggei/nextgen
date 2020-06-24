package nextgen.templates.vertx;

import static nextgen.templates.vertx.VertxST.*;

/**
 * Tests for VertxST
 **/
public class VertxSTTests {

	@org.junit.Test
	public void testAll() {
		testDomainVerticle();
		testDomainAction();
		testJsonFactory();
		testJsonWrapper();
		testEnumAccessors();
		testExternalAccessors();
		testListEnumAccessors();
		testListPrimitiveAccessors();
		testListReferenceAccessors();
		testPrimitiveAccessors();
		testReferenceAccessors();
		testWebVerticle();
		testRouteHandler();
		testSendEventBusAction();
	}

	@org.junit.Test
	public void testDomainVerticle() {
		System.out.println("\n--- TEST DomainVerticle:\n" + newDomainVerticle());
	} 

	@org.junit.Test
	public void testDomainAction() {
		System.out.println("\n--- TEST DomainAction:\n" + newDomainAction());
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
	public void testListEnumAccessors() {
		System.out.println("\n--- TEST ListEnumAccessors:\n" + newListEnumAccessors());
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
	public void testWebVerticle() {
		System.out.println("\n--- TEST WebVerticle:\n" + newWebVerticle());
	} 

	@org.junit.Test
	public void testRouteHandler() {
		System.out.println("\n--- TEST RouteHandler:\n" + newRouteHandler());
	} 

	@org.junit.Test
	public void testSendEventBusAction() {
		System.out.println("\n--- TEST SendEventBusAction:\n" + newSendEventBusAction());
	} 
} 