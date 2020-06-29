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
}