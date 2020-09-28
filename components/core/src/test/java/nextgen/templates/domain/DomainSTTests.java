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
		testRelation();
	}

	@org.junit.Test
	public void testDomain() {
		System.out.println("Domain:\n" + newDomain());
	}  

	@org.junit.Test
	public void testEntity() {
		System.out.println("Entity:\n" + newEntity());
	}  

	@org.junit.Test
	public void testRelation() {
		System.out.println("Relation:\n" + newRelation());
	}  
} 