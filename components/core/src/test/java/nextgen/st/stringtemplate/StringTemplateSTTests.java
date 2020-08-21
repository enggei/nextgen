package nextgen.st.stringtemplate;

import static nextgen.st.stringtemplate.StringTemplateST.*;

/**
 * Tests for StringTemplateST
 **/
public class StringTemplateSTTests {

	@org.junit.Test
	public void testAll() {
		testDomainVisitorRunner();
		testScriptRunner();
		testSTDomain();
		testNewEntityInstance();
		testStgString();
		testSTDomainTests();
		testTemplateTestMethod();
		testSTEntity();
		testEntityKVListAccessors();
		testEntityListAccessors();
		testEntitySingleAccessors();
		testSTEnum();
		testSTEnumValue();
		testSTInterface();
	}

	@org.junit.Test
	public void testDomainVisitorRunner() {
		System.out.println("\n--- TEST DomainVisitorRunner:\n" + newDomainVisitorRunner());
	} 

	@org.junit.Test
	public void testScriptRunner() {
		System.out.println("\n--- TEST ScriptRunner:\n" + newScriptRunner());
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
	public void testSTEnum() {
		System.out.println("\n--- TEST STEnum:\n" + newSTEnum());
	} 

	@org.junit.Test
	public void testSTEnumValue() {
		System.out.println("\n--- TEST STEnumValue:\n" + newSTEnumValue());
	} 

	@org.junit.Test
	public void testSTInterface() {
		System.out.println("\n--- TEST STInterface:\n" + newSTInterface());
	} 
} 