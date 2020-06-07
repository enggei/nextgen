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
	}

	@org.junit.Test
	public void testDomain() {
		System.out.println("\n--- TEST Domain:\n" + newDomain());
	} 

	@org.junit.Test
	public void testEntity() {
		System.out.println("\n--- TEST Entity:\n" + newEntity());
	} 
} 