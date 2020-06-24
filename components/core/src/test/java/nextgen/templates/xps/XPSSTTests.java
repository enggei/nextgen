package nextgen.templates.xps;

import static nextgen.templates.xps.XPSST.*;

/**
 * Tests for XPSST
 **/
public class XPSSTTests {

	@org.junit.Test
	public void testAll() {
		testUtserver();
	}

	@org.junit.Test
	public void testUtserver() {
		System.out.println("\n--- TEST Utserver:\n" + newUtserver());
	} 
} 