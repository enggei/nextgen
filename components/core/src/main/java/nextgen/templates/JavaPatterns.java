package nextgen.templates;

import nextgen.st.STGenerator;
import nextgen.templates.java.Enum;
import nextgen.templates.java.*;

import java.io.File;
import java.util.Collection;

public class JavaPatterns extends JavaST {

    public static void writeEnum(File root, PackageDeclaration packageDeclaration, String name, Object[] enumValues) {
        final Enum content = JavaST.newEnum().setName(name).setPackage(packageDeclaration.getName());
        for (Object enumValue : enumValues)
            content.addEnumValues(enumValue);
        STGenerator.writeJavaFile(content, packageDeclaration.getName(), name, root);
    }

    public static void writeEnum(File root, PackageDeclaration packageDeclaration, String name, Collection<EnumValue> enumValues) {
        final Enum content = JavaST.newEnum().setName(name).setPackage(packageDeclaration.getName());
        for (EnumValue enumValue : enumValues)
            content.addEnumValues(enumValue);
        STGenerator.writeJavaFile(content, packageDeclaration.getName(), name, root);
    }

    public static PackageDeclaration newPackageDeclaration(String packageName) {
        return newPackageDeclaration().setName(packageName);
    }

    public static PackageDeclaration newPackageDeclaration(PackageDeclaration parent, String packageName) {
        return newPackageDeclaration().setName(parent.getName() + "." + packageName);
    }

    public static ObjectCreationExpression newArrayListInstance() {
        return newObjectCreationExpression().setType(newArrayListType());
    }

    public static ObjectCreationExpression newThread(Object body) {
        return newObjectCreationExpression()
                .setScope(CoreTypes.ThreadType)
                .addArguments(newLambdaExpression().setBody(body));
    }

    public static Statement invokeLater(Object body) {
        return newExpressionStmt()
                .setExpression(newMethodCallExpression()
                        .setScope(SwingTypes.SwingUtilitiesType)
                        .setName("invokeLater")
                        .addArguments(newLambdaExpression()
                                .setBody(body)));
    }

    public static Object newInvokeLater(Object statement) {
        return newInvokeLater().setStatement(statement);
    }

    public static Object newInvokeLater(Object... statements) {
        final InvokeLater invokeLater = newInvokeLater();
        for (Object statement : statements)
            invokeLater.addStatements(statement);
        return invokeLater;
    }

    public static MethodDeclaration newProtectedMethod(String name, BlockStmt blockStmt) {
        return newMethodDeclaration()
                .addModifiers("protected")
                .setName(name)
                .setBlockStmt(blockStmt);
    }

    public static Parameter newParameter(String type, String name) {
        return newParameter().setType(type).setName(name);
    }

    public static MethodDeclaration newMethodDeclarationFrom(MethodDeclaration prototype) {

        final MethodDeclaration methodDeclaration = newMethodDeclaration()
                .setName(prototype.getName())
                .setType(prototype.getType());

        prototype.getModifiers().forEach(methodDeclaration::addModifiers);
        prototype.getParameters().forEach(methodDeclaration::addParameters);
        return methodDeclaration;
    }
}