package nextgen.templates.text;

import static nextgen.templates.text.TextST.*;

/**
 * Tests for TextST
 **/
public class TextSTTests {

	@org.junit.Test
	public void testAll() {
		testBlock();
		testLine();
	}

	@org.junit.Test
	public void testBlock() {
		System.out.println("\n--- TEST Block:\n" + newBlock());
	} 

	@org.junit.Test
	public void testLine() {
		System.out.println("\n--- TEST Line:\n" + newLine());
	} 
} 