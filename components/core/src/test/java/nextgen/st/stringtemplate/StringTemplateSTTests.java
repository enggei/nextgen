package nextgen.st.stringtemplate;

import static nextgen.st.stringtemplate.StringTemplateST.*;

/**
 * Tests for StringTemplateST
 **/
public class StringTemplateSTTests {

	@org.junit.Test
	public void testAll() {
		testDomainVisitorRunner();
		testVisitNodeMethod();
		testVisitRelationMethod();
		testNeoDomain();
		testFindBy();
		testNeoEntity();
		testKVAccessors();
		testListAccessors();
		testSingleAccessors();
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
	public void testVisitNodeMethod() {
		System.out.println("\n--- TEST VisitNodeMethod:\n" + newVisitNodeMethod());
	} 

	@org.junit.Test
	public void testVisitRelationMethod() {
		System.out.println("\n--- TEST VisitRelationMethod:\n" + newVisitRelationMethod());
	} 

	@org.junit.Test
	public void testNeoDomain() {
		System.out.println("\n--- TEST NeoDomain:\n" + newNeoDomain());
	} 

	@org.junit.Test
	public void testFindBy() {
		System.out.println("\n--- TEST FindBy:\n" + newFindBy());
	} 

	@org.junit.Test
	public void testNeoEntity() {
		System.out.println("\n--- TEST NeoEntity:\n" + newNeoEntity());
	} 

	@org.junit.Test
	public void testKVAccessors() {
		System.out.println("\n--- TEST KVAccessors:\n" + newKVAccessors());
	} 

	@org.junit.Test
	public void testListAccessors() {
		System.out.println("\n--- TEST ListAccessors:\n" + newListAccessors());
	} 

	@org.junit.Test
	public void testSingleAccessors() {
		System.out.println("\n--- TEST SingleAccessors:\n" + newSingleAccessors());
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