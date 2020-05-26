package nextgen.java;

import nextgen.java.st.ClassOrInterfaceType;
import nextgen.java.st.MethodDeclaration;
import nextgen.java.st.SingleMemberAnnotationExpression;

public class JUnitPatterns extends JavaPatterns {

    public static final String junitCore = "org.junit";

    public static final ClassOrInterfaceType testType = newClassOrInterfaceType().setScope(junitCore).addNames("Test");

    public static MethodDeclaration newTestMethod(String name) {
        return newPublicMethodDeclaration(name)
                .addAnnotations(newTestAnnotation());
    }

    public static SingleMemberAnnotationExpression newTestAnnotation() {
        return newSingleMemberAnnotationExpression()
                .setName(testType);
    }
}