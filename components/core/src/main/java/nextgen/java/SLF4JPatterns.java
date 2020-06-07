package nextgen.java;

import nextgen.java.st.ClassOrInterfaceType;
import nextgen.java.st.FieldDeclaration;

import static nextgen.java.JavaPatterns.*;
import static nextgen.java.st.JavaFactory.newClassOrInterfaceType;
@Deprecated
public class SLF4JPatterns {

    public static final String corePackage = "org.slf4j";

    public static final ClassOrInterfaceType loggerType = newClassOrInterfaceType().setScope(corePackage).addNames("Logger");
    public static final ClassOrInterfaceType loggerFactoryType = newClassOrInterfaceType().setScope(corePackage).addNames("LoggerFactory");

    public static final String log = "log";

    public static FieldDeclaration newLog(String className) {
        return newLog(className, log);
    }

    public static FieldDeclaration newLog(String className, String loggerName) {
        return newProtectedStaticFinalFieldDeclaration(loggerType, loggerName, newMethodCallExpression(loggerFactoryType, "getLogger", newExpression(className + ".class")));
    }

}