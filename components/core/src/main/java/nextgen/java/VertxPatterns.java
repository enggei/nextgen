package nextgen.java;

import nextgen.java.JavaPatterns;
import nextgen.java.st.ClassOrInterfaceType;
import nextgen.java.st.MethodCallExpression;

public class VertxPatterns extends JavaPatterns {

    public static final String corePackage = "io.vertx.core";
    public static final String json = corePackage + ".json";

    public static final ClassOrInterfaceType vertxType = newClassOrInterfaceType().setScope(corePackage).addNames("Vertx");
    public static final ClassOrInterfaceType deploymentOptionsType = newClassOrInterfaceType().setScope(corePackage).addNames("DeploymentOptions");

    public static final ClassOrInterfaceType jsonObjectType = newClassOrInterfaceType().setScope(json).addNames("JsonObject");
    public static final ClassOrInterfaceType jsonArrayType = newClassOrInterfaceType().setScope(json).addNames("JsonArray");

    public static MethodCallExpression newVertxInstance() {
        return newMethodCallExpression(vertxType, "vertx");
    }

    public static MethodCallExpression getJsonObject(Object jsonObject, String name) {
        return newMethodCallExpression(jsonObject, "getJsonObject", newStringLiteralExpression(name));
    }

    public static MethodCallExpression getJsonObjectOrDefault(Object jsonObject, String name, Object defaultValue) {
        return newMethodCallExpression(jsonObject, "getJsonObject", newStringLiteralExpression(name), defaultValue);
    }

    public static MethodCallExpression getJsonArray(Object jsonObject, String name) {
        return newMethodCallExpression(jsonObject, "getJsonArray", newStringLiteralExpression(name));
    }

    public static MethodCallExpression getJsonArrayOrDefault(Object jsonObject, String name) {
        return newMethodCallExpression(jsonObject, "getJsonArray", newStringLiteralExpression(name)).addArguments(newObjectCreationExpression(jsonArrayType));
    }

    public static MethodCallExpression getJsonArrayOrDefault(Object jsonObject, String name, Object defaultValue) {
        return newMethodCallExpression(jsonObject, "getJsonArray", newStringLiteralExpression(name)).addArguments(defaultValue);
    }

    public static MethodCallExpression put(Object jsonObject, String key, Object value) {
        return newMethodCallExpression(jsonObject, "put", newStringLiteralExpression(key), value);
    }

    public static MethodCallExpression getString(Object jsonObject, String key) {
        return newMethodCallExpression(jsonObject, "getString", newStringLiteralExpression(key));
    }

    public static MethodCallExpression getObject(Object jsonObject, String key) {
        return newMethodCallExpression(jsonObject, "getValue", newStringLiteralExpression(key));
    }

    public static MethodCallExpression getObjectOrDefault(Object jsonObject, String key, Object defaultValue) {
        return newMethodCallExpression(jsonObject, "getValue", newStringLiteralExpression(key), defaultValue);
    }

    public static MethodCallExpression add(Object jsonArray, Object value) {
        return newMethodCallExpression(jsonArray, "add", value);
    }
}