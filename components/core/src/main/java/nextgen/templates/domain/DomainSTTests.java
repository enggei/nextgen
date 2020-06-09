package nextgen.templates.domain;

import static nextgen.templates.domain.DomainST.*;

/**
 * Tests for DomainST
 **/
public class DomainSTTests {

	@org.junit.Test
	public void testAll() {
		testDomain();
		testEntity();
		testEnumField();
		testExternalReferenceField();
		testExternalReferenceList();
		testPrimitiveField();
		testPrimitiveList();
		testReferenceField();
		testReferenceList();
	}

	@org.junit.Test
	public void testDomain() {
		System.out.println("\n--- TEST Domain:\n" + newDomain());
	} 

	@org.junit.Test
	public void testEntity() {
		System.out.println("\n--- TEST Entity:\n" + newEntity());
	} 

	@org.junit.Test
	public void testEnumField() {
		System.out.println("\n--- TEST EnumField:\n" + newEnumField());
	} 

	@org.junit.Test
	public void testExternalReferenceField() {
		System.out.println("\n--- TEST ExternalReferenceField:\n" + newExternalReferenceField());
	} 

	@org.junit.Test
	public void testExternalReferenceList() {
		System.out.println("\n--- TEST ExternalReferenceList:\n" + newExternalReferenceList());
	} 

	@org.junit.Test
	public void testPrimitiveField() {
		System.out.println("\n--- TEST PrimitiveField:\n" + newPrimitiveField());
	} 

	@org.junit.Test
	public void testPrimitiveList() {
		System.out.println("\n--- TEST PrimitiveList:\n" + newPrimitiveList());
	} 

	@org.junit.Test
	public void testReferenceField() {
		System.out.println("\n--- TEST ReferenceField:\n" + newReferenceField());
	} 

	@org.junit.Test
	public void testReferenceList() {
		System.out.println("\n--- TEST ReferenceList:\n" + newReferenceList());
	} 
} 