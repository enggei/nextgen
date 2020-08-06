package nextgen.templates.text;

import static nextgen.templates.text.TextST.*;

/**
 * Tests for TextST
 **/
public class TextSTTests {

	@org.junit.Test
	public void testAll() {
		testBlock();
		testEncapsulation();
		testLine();
		testSequence();
	}

	@org.junit.Test
	public void testBlock() {
		System.out.println("\n--- TEST Block:\n" + newBlock());
	} 

	@org.junit.Test
	public void testEncapsulation() {
		System.out.println("\n--- TEST Encapsulation:\n" + newEncapsulation());
	} 

	@org.junit.Test
	public void testLine() {
		System.out.println("\n--- TEST Line:\n" + newLine());
	} 

	@org.junit.Test
	public void testSequence() {
		System.out.println("\n--- TEST Sequence:\n" + newSequence());
	} 
} 