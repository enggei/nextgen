package nextgen.templates.materialui;

import static nextgen.templates.materialui.MaterialUIST.*;

/**
 * Tests for MaterialUIST
 **/
public class MaterialUISTTests {

	@org.junit.Test
	public void testAll() {
		testComponent();
		testStyleClass();
		testSimpleElement();
		testButtonElement();
		testDividerElement();
		testGridContainerElement();
		testGridItemElement();
		testLinkElement();
		testPaperElement();
		testTypographyElement();
	}

	@org.junit.Test
	public void testComponent() {
		System.out.println("\n--- TEST Component:\n" + newComponent());
	} 

	@org.junit.Test
	public void testStyleClass() {
		System.out.println("\n--- TEST StyleClass:\n" + newStyleClass());
	} 

	@org.junit.Test
	public void testSimpleElement() {
		System.out.println("\n--- TEST SimpleElement:\n" + newSimpleElement());
	} 

	@org.junit.Test
	public void testButtonElement() {
		System.out.println("\n--- TEST ButtonElement:\n" + newButtonElement());
	} 

	@org.junit.Test
	public void testDividerElement() {
		System.out.println("\n--- TEST DividerElement:\n" + newDividerElement());
	} 

	@org.junit.Test
	public void testGridContainerElement() {
		System.out.println("\n--- TEST GridContainerElement:\n" + newGridContainerElement());
	} 

	@org.junit.Test
	public void testGridItemElement() {
		System.out.println("\n--- TEST GridItemElement:\n" + newGridItemElement());
	} 

	@org.junit.Test
	public void testLinkElement() {
		System.out.println("\n--- TEST LinkElement:\n" + newLinkElement());
	} 

	@org.junit.Test
	public void testPaperElement() {
		System.out.println("\n--- TEST PaperElement:\n" + newPaperElement());
	} 

	@org.junit.Test
	public void testTypographyElement() {
		System.out.println("\n--- TEST TypographyElement:\n" + newTypographyElement());
	} 
} 