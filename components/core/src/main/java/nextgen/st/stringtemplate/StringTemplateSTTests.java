package nextgen.st.stringtemplate;

import static nextgen.st.stringtemplate.StringTemplateST.*;

/**
 * Tests for StringTemplateST
 **/
public class StringTemplateSTTests {

	@org.junit.Test
	public void testAll() {
		testSTDomain();
		testNewEntityInstance();
		testStgString();
		testSTDomainTests();
		testTemplateTestMethod();
		testSTEntity();
		testEntityKVListAccessors();
		testEntityListAccessors();
		testEntitySingleAccessors();
		testSTG();
		testTemplate();
	}

	@org.junit.Test
	public void testSTDomain() {
		System.out.println("\n--- TEST STDomain:\n" + newSTDomain());
	} 

	@org.junit.Test
	public void testNewEntityInstance() {
		System.out.println("\n--- TEST NewEntityInstance:\n" + newNewEntityInstance());
	} 

	@org.junit.Test
	public void testStgString() {
		System.out.println("\n--- TEST StgString:\n" + newStgString());
	} 

	@org.junit.Test
	public void testSTDomainTests() {
		System.out.println("\n--- TEST STDomainTests:\n" + newSTDomainTests());
	} 

	@org.junit.Test
	public void testTemplateTestMethod() {
		System.out.println("\n--- TEST TemplateTestMethod:\n" + newTemplateTestMethod());
	} 

	@org.junit.Test
	public void testSTEntity() {
		System.out.println("\n--- TEST STEntity:\n" + newSTEntity());
	} 

	@org.junit.Test
	public void testEntityKVListAccessors() {
		System.out.println("\n--- TEST EntityKVListAccessors:\n" + newEntityKVListAccessors());
	} 

	@org.junit.Test
	public void testEntityListAccessors() {
		System.out.println("\n--- TEST EntityListAccessors:\n" + newEntityListAccessors());
	} 

	@org.junit.Test
	public void testEntitySingleAccessors() {
		System.out.println("\n--- TEST EntitySingleAccessors:\n" + newEntitySingleAccessors());
	} 

	@org.junit.Test
	public void testSTG() {
		System.out.println("\n--- TEST STG:\n" + newSTG());
	} 

	@org.junit.Test
	public void testTemplate() {
		System.out.println("\n--- TEST Template:\n" + newTemplate());
	} 
} 