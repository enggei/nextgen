package nextgen.templates.javascript;

import static nextgen.templates.javascript.JavaScriptST.*;

/**
 * Tests for JavaScriptST
 **/
public class JavaScriptSTTests {

	@org.junit.Test
	public void testAll() {
		testBlockStmt();
		testConditional();
		testIf();
		testDecorator();
		testArrowFunction();
		testFunction();
		testFunctionCall();
		testFunctionExpression();
		testReturnStmt();
		testJsonArray();
		testJsonObject();
		testNameArray();
		testNameValue();
		testApp();
		testIndexCSS();
		testIndexHtml();
		testIndexJS();
		testJSX();
		testClassComponent();
		testDependency();
		testDestructorProp();
		testDiv();
		testElement();
		testForm();
		testUl();
		testFunctionalComponent();
		testMapProperty();
		testMethodDeclaration();
		testNamedImport();
		testProp();
		testReturnStatement();
		testState();
		testForwardRef();
		testLink();
		testReactRouterLinkImport();
		testWithRouterImport();
		testStatement();
		testSuperagent();
		testAgentDeclaration();
		testAgentEndpoint();
		testAgentRequest();
		testConstVariable();
	}

	@org.junit.Test
	public void testBlockStmt() {
		System.out.println("BlockStmt:\n" + newBlockStmt());
	}  

	@org.junit.Test
	public void testConditional() {
		System.out.println("Conditional:\n" + newConditional());
	}  

	@org.junit.Test
	public void testIf() {
		System.out.println("If:\n" + newIf());
	}  

	@org.junit.Test
	public void testDecorator() {
		System.out.println("Decorator:\n" + newDecorator());
	}  

	@org.junit.Test
	public void testArrowFunction() {
		System.out.println("ArrowFunction:\n" + newArrowFunction());
	}  

	@org.junit.Test
	public void testFunction() {
		System.out.println("Function:\n" + newFunction());
	}  

	@org.junit.Test
	public void testFunctionCall() {
		System.out.println("FunctionCall:\n" + newFunctionCall());
	}  

	@org.junit.Test
	public void testFunctionExpression() {
		System.out.println("FunctionExpression:\n" + newFunctionExpression());
	}  

	@org.junit.Test
	public void testReturnStmt() {
		System.out.println("ReturnStmt:\n" + newReturnStmt());
	}  

	@org.junit.Test
	public void testJsonArray() {
		System.out.println("JsonArray:\n" + newJsonArray());
	}  

	@org.junit.Test
	public void testJsonObject() {
		System.out.println("JsonObject:\n" + newJsonObject());
	}  

	@org.junit.Test
	public void testNameArray() {
		System.out.println("NameArray:\n" + newNameArray());
	}  

	@org.junit.Test
	public void testNameValue() {
		System.out.println("NameValue:\n" + newNameValue());
	}  

	@org.junit.Test
	public void testApp() {
		System.out.println("App:\n" + newApp());
	}  

	@org.junit.Test
	public void testIndexCSS() {
		System.out.println("IndexCSS:\n" + newIndexCSS());
	}  

	@org.junit.Test
	public void testIndexHtml() {
		System.out.println("IndexHtml:\n" + newIndexHtml());
	}  

	@org.junit.Test
	public void testIndexJS() {
		System.out.println("IndexJS:\n" + newIndexJS());
	}  

	@org.junit.Test
	public void testJSX() {
		System.out.println("JSX:\n" + newJSX());
	}  

	@org.junit.Test
	public void testClassComponent() {
		System.out.println("ClassComponent:\n" + newClassComponent());
	}  

	@org.junit.Test
	public void testDependency() {
		System.out.println("Dependency:\n" + newDependency());
	}  

	@org.junit.Test
	public void testDestructorProp() {
		System.out.println("DestructorProp:\n" + newDestructorProp());
	}  

	@org.junit.Test
	public void testDiv() {
		System.out.println("Div:\n" + newDiv());
	}  

	@org.junit.Test
	public void testElement() {
		System.out.println("Element:\n" + newElement());
	}  

	@org.junit.Test
	public void testForm() {
		System.out.println("Form:\n" + newForm());
	}  

	@org.junit.Test
	public void testUl() {
		System.out.println("Ul:\n" + newUl());
	}  

	@org.junit.Test
	public void testFunctionalComponent() {
		System.out.println("FunctionalComponent:\n" + newFunctionalComponent());
	}  

	@org.junit.Test
	public void testMapProperty() {
		System.out.println("MapProperty:\n" + newMapProperty());
	}  

	@org.junit.Test
	public void testMethodDeclaration() {
		System.out.println("MethodDeclaration:\n" + newMethodDeclaration());
	}  

	@org.junit.Test
	public void testNamedImport() {
		System.out.println("NamedImport:\n" + newNamedImport());
	}  

	@org.junit.Test
	public void testProp() {
		System.out.println("Prop:\n" + newProp());
	}  

	@org.junit.Test
	public void testReturnStatement() {
		System.out.println("ReturnStatement:\n" + newReturnStatement());
	}  

	@org.junit.Test
	public void testState() {
		System.out.println("State:\n" + newState());
	}  

	@org.junit.Test
	public void testForwardRef() {
		System.out.println("ForwardRef:\n" + newForwardRef());
	}  

	@org.junit.Test
	public void testLink() {
		System.out.println("Link:\n" + newLink());
	}  

	@org.junit.Test
	public void testReactRouterLinkImport() {
		System.out.println("ReactRouterLinkImport:\n" + newReactRouterLinkImport());
	}  

	@org.junit.Test
	public void testWithRouterImport() {
		System.out.println("WithRouterImport:\n" + newWithRouterImport());
	}  

	@org.junit.Test
	public void testStatement() {
		System.out.println("Statement:\n" + newStatement());
	}  

	@org.junit.Test
	public void testSuperagent() {
		System.out.println("Superagent:\n" + newSuperagent());
	}  

	@org.junit.Test
	public void testAgentDeclaration() {
		System.out.println("AgentDeclaration:\n" + newAgentDeclaration());
	}  

	@org.junit.Test
	public void testAgentEndpoint() {
		System.out.println("AgentEndpoint:\n" + newAgentEndpoint());
	}  

	@org.junit.Test
	public void testAgentRequest() {
		System.out.println("AgentRequest:\n" + newAgentRequest());
	}  

	@org.junit.Test
	public void testConstVariable() {
		System.out.println("ConstVariable:\n" + newConstVariable());
	}  
} 