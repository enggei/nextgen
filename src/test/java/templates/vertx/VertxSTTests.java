package templates.vertx;

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
		testServer();
		testWebVerticle();
		testRouteHandler();
		testSendEventBusAction();
	}

	@org.junit.Test
	public void testDomainVerticle() {
		System.out.println("DomainVerticle:\n" + newDomainVerticle());
	}  

	@org.junit.Test
	public void testDomainAction() {
		System.out.println("DomainAction:\n" + newDomainAction());
	}  

	@org.junit.Test
	public void testJsonFactory() {
		System.out.println("JsonFactory:\n" + newJsonFactory());
	}  

	@org.junit.Test
	public void testJsonWrapper() {
		System.out.println("JsonWrapper:\n" + newJsonWrapper());
	}  

	@org.junit.Test
	public void testEnumAccessors() {
		System.out.println("EnumAccessors:\n" + newEnumAccessors());
	}  

	@org.junit.Test
	public void testExternalAccessors() {
		System.out.println("ExternalAccessors:\n" + newExternalAccessors());
	}  

	@org.junit.Test
	public void testListEnumAccessors() {
		System.out.println("ListEnumAccessors:\n" + newListEnumAccessors());
	}  

	@org.junit.Test
	public void testListPrimitiveAccessors() {
		System.out.println("ListPrimitiveAccessors:\n" + newListPrimitiveAccessors());
	}  

	@org.junit.Test
	public void testListReferenceAccessors() {
		System.out.println("ListReferenceAccessors:\n" + newListReferenceAccessors());
	}  

	@org.junit.Test
	public void testPrimitiveAccessors() {
		System.out.println("PrimitiveAccessors:\n" + newPrimitiveAccessors());
	}  

	@org.junit.Test
	public void testReferenceAccessors() {
		System.out.println("ReferenceAccessors:\n" + newReferenceAccessors());
	}  

	@org.junit.Test
	public void testServer() {
		System.out.println("Server:\n" + newServer());
	}  

	@org.junit.Test
	public void testWebVerticle() {
		System.out.println("WebVerticle:\n" + newWebVerticle());
	}  

	@org.junit.Test
	public void testRouteHandler() {
		System.out.println("RouteHandler:\n" + newRouteHandler());
	}  

	@org.junit.Test
	public void testSendEventBusAction() {
		System.out.println("SendEventBusAction:\n" + newSendEventBusAction());
	}  
} 