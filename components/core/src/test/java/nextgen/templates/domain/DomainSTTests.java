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
		testJavaProject();
		testRelation();
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
	public void testJavaProject() {
		System.out.println("\n--- TEST JavaProject:\n" + newJavaProject());
	} 

	@org.junit.Test
	public void testRelation() {
		System.out.println("\n--- TEST Relation:\n" + newRelation());
	} 
} 