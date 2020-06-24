package nextgen.templates;

import nextgen.templates.javascript.*;

public class JavaScriptPatterns extends JavaScriptST {

    public static ExpressionStmt newExpressionStmt(Object expression) {
        return newExpressionStmt().setExpression(expression);
    }

    public static Observable newObservable(String name) {
        return newObservable().setName(name);
    }

    public static Observable newObservable(String name, String initializer) {
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
}