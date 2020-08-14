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
        return new App.App_Routes(name, name + ".js", Character.toLowerCase(name.charAt(0)) + name.substring(1));
    }

    public static App.App_Routes newAppRoute(String name, String param) {
        return new App.App_Routes(name, name + ".js", Character.toLowerCase(name.charAt(0)) + name.substring(1) + "/:" + param);
    }

    public static ArrowFunction newArrowFunction(Object expression) {
        return newArrowFunction().setExpression(expression);
    }

    public static ArrowFunction newArrowFunction(String parameter, Object expression) {
        return newArrowFunction().addParams(parameter).setExpression(expression);
    }

    public static AgentRequest newAgentRequest(String endpoint, String method) {
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
}