package nextgen.java;

import nextgen.java.st.ClassOrInterfaceType;

public class VertxPatterns extends JavaPatterns {

    public static final String vertxCore = "io.vertx.core";
    public static final String vertxCoreJson = vertxCore + ".json";

    public static final ClassOrInterfaceType jsonObjectType = newClassOrInterfaceType().setScope(vertxCoreJson).addNames("JsonObject");
    public static final ClassOrInterfaceType jsonArrayType = newClassOrInterfaceType().setScope(vertxCoreJson).addNames("JsonArray");


}