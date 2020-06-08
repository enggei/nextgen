package nextgen.templates.kotlin;

import static nextgen.templates.kotlin.KotlinST.*;

/**
 * Tests for KotlinST
 **/
public class KotlinSTTests {

	@org.junit.Test
	public void testAll() {
		testDataClass();
	}

	@org.junit.Test
	public void testDataClass() {
		System.out.println("\n--- TEST DataClass:\n" + newDataClass());
	} 
} 