package nextgen.templates;

import nextgen.templates.javascript.*;

public class JavaScriptPatterns extends JavaScriptST {

    public static Observable newObservable(String name) {
        return newObservable().setName(name);
    }

    public static Observable newObservable(String name, Object initializer) {
        return newObservable().setName(name).setInitializer(initializer);
    }

    public static Action newAction(String name) {
        return newAction().setName(name);
    }

    public static ReturnStmt newReturnStmt(Object returnValue) {
        return newReturnStmt().setReturnValue(returnValue);
    }

    public static App.App_Routes newAppRoute(String name) {
        return new App.App_Routes(name, name + ".js", Character.toLowerCase(name.charAt(0)) + name.substring(1), null);
    }

    public static App.App_Routes newAppRoute(String name, String param) {
        return new App.App_Routes(name, name + ".js", Character.toLowerCase(name.charAt(0)) + name.substring(1) + "/:" + param, null);
    }

    public static ArrowFunction newArrowFunction(Object expression) {
        return newArrowFunction().setExpression(expression);
    }

    public static ArrowFunction newArrowFunction(Object parameter, Object expression) {
        return newArrowFunction().addParams(parameter).setExpression(expression);
    }

    public static AgentRequest newAgentRequest(Object endpoint, Object method) {
        return newAgentRequest().setEndpoint(endpoint).setMethod(method);
    }

    public static FunctionCall newFunctionCall(String name) {
        return newFunctionCall().setName(name);
    }

    public static If newIf(Object condition) {
        return newIf().setCondition(condition);
    }

    public static Decorator newDecorator(String name) {
        return newDecorator().setName(name);
    }

    public static Function newFunction(String name) {
        return newFunction().setName(name);
    }

    public static MethodDeclaration newMethodDeclaration(String name) {
        return newMethodDeclaration().setName(name);
    }

    public static Prop newProp(String name, Object value) {
        return newProp().setName(name).setValue(value);
    }

    public static AgentEndpoint newAgentEndpoint(String name, String url, String action) {
        return newAgentEndpoint().setName(name).setUrl(url).setAction(action);
    }

    public static JsonObject newJsonObject(Object... values) {
        return newJsonObject().setValues(values);
    }

    public static Element newElement(String name) {
        return newElement().setName(name);
    }

    public static Object debug(String here) {
        return "console.info(\"" + here + "\");";
    }

    public static NameValue newNameValue(String name, Object value) {
        return newNameValue().setName(name).setValue(value);
    }
}