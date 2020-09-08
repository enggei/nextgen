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
		System.out.println("DomainVisitorRunner:\n" + newDomainVisitorRunner());
	}  

	@org.junit.Test
	public void testVisitNodeMethod() {
		System.out.println("VisitNodeMethod:\n" + newVisitNodeMethod());
	}  

	@org.junit.Test
	public void testVisitRelationMethod() {
		System.out.println("VisitRelationMethod:\n" + newVisitRelationMethod());
	}  

	@org.junit.Test
	public void testNeoDomain() {
		System.out.println("NeoDomain:\n" + newNeoDomain());
	}  

	@org.junit.Test
	public void testFindBy() {
		System.out.println("FindBy:\n" + newFindBy());
	}  

	@org.junit.Test
	public void testNeoEntity() {
		System.out.println("NeoEntity:\n" + newNeoEntity());
	}  

	@org.junit.Test
	public void testKVAccessors() {
		System.out.println("KVAccessors:\n" + newKVAccessors());
	}  

	@org.junit.Test
	public void testListAccessors() {
		System.out.println("ListAccessors:\n" + newListAccessors());
	}  

	@org.junit.Test
	public void testSingleAccessors() {
		System.out.println("SingleAccessors:\n" + newSingleAccessors());
	}  

	@org.junit.Test
	public void testScriptRunner() {
		System.out.println("ScriptRunner:\n" + newScriptRunner());
	}  

	@org.junit.Test
	public void testSTDomain() {
		System.out.println("STDomain:\n" + newSTDomain());
	}  

	@org.junit.Test
	public void testNewEntityInstance() {
		System.out.println("NewEntityInstance:\n" + newNewEntityInstance());
	}  

	@org.junit.Test
	public void testStgString() {
		System.out.println("StgString:\n" + newStgString());
	}  

	@org.junit.Test
	public void testSTDomainTests() {
		System.out.println("STDomainTests:\n" + newSTDomainTests());
	}  

	@org.junit.Test
	public void testTemplateTestMethod() {
		System.out.println("TemplateTestMethod:\n" + newTemplateTestMethod());
	}  

	@org.junit.Test
	public void testSTEntity() {
		System.out.println("STEntity:\n" + newSTEntity());
	}  

	@org.junit.Test
	public void testEntityKVListAccessors() {
		System.out.println("EntityKVListAccessors:\n" + newEntityKVListAccessors());
	}  

	@org.junit.Test
	public void testEntityListAccessors() {
		System.out.println("EntityListAccessors:\n" + newEntityListAccessors());
	}  

	@org.junit.Test
	public void testEntitySingleAccessors() {
		System.out.println("EntitySingleAccessors:\n" + newEntitySingleAccessors());
	}  

	@org.junit.Test
	public void testSTEnum() {
		System.out.println("STEnum:\n" + newSTEnum());
	}  

	@org.junit.Test
	public void testSTEnumValue() {
		System.out.println("STEnumValue:\n" + newSTEnumValue());
	}  

	@org.junit.Test
	public void testSTInterface() {
		System.out.println("STInterface:\n" + newSTInterface());
	}  
} 