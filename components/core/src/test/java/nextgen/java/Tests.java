package nextgen.java;

import nextgen.java.st.*;
import org.junit.Test;

import static nextgen.java.JavaPatterns.*;

public class Tests {

    @Test
    public void test() {

        final String className = "HelloWorld";

        final String model1 = "public class " + className + " {\n" +
                "\n" +
                "\tpublic " + className + "() { }\n" +
                "}";

        final ClassOrInterfaceDeclaration model2 = newClassOrInterfaceDeclaration()
                .addModifiers(ModifierPUBLIC())
                .setName(className)
                .addMembers(newConstructorDeclaration()
                        .addModifiers(Modifier.PUBLIC)
                        .setName(className));

        final ClassOrInterfaceDeclaration model3 = newPublicClassDeclaration(className)
                .addMembers(newPublicConstructorDeclaration(className));

        final JavaGenerator javaGenerator = new JavaGenerator();

        System.out.println(model1);
        System.out.println(javaGenerator.generate(model2));
        System.out.println(javaGenerator.generate(model3));
    }
}