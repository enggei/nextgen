package test;

import tmp.st.java.JavaST;

import java.io.File;

public class JavaGeneratorTests {

    public static void main(String[] args) {

        final JavaST javaST = new JavaST(new File("components/core/src/main/resources/templates/Java.stg"));
        System.out.println(javaST.newClassOrInterfaceDeclaration()
                .setName("HelloWorld")
                .addFields(javaST.newFieldDeclaration()
                        .addVariables(javaST.newVariableDeclaration()
                                .setName("name")
                        .setType(javaST.newClassOrInterfaceType().addNames("String")))));

    }
}
