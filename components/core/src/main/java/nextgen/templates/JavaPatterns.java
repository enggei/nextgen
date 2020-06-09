package nextgen.templates;

import nextgen.st.STGenerator;
import nextgen.templates.java.*;
import nextgen.templates.java.Enum;

import java.io.File;

public class JavaPatterns extends JavaST {

    public static void writeEnum(File root, PackageDeclaration packageDeclaration, String name, Object[] enumValues) {
        final Enum content = JavaST.newEnum().setName(name).setPackage(packageDeclaration);
        for (Object enumValue : enumValues)
            content.addEnumValues(enumValue);
        STGenerator.writeToFile(content, packageDeclaration.getName(), name, "java", root);
    }

    public static PackageDeclaration newPackageDeclaration(String packageName) {
        return newPackageDeclaration().setName(packageName);
    }

    public static PackageDeclaration newPackageDeclaration(PackageDeclaration parent, String packageName) {
        return newPackageDeclaration().setName(parent.getName() + "." + packageName);
    }

    public static void writePojo(File root, Pojo content) {
        STGenerator.writeToFile(content, content.getPackage(), content.getName(), "java", root);
    }

    public static void writePojoFactory(File root, PojoFactory content) {
        final PackageDeclaration packageDeclaration = (PackageDeclaration) content.getPackage();
        STGenerator.writeToFile(content, packageDeclaration.getName(), content.getName().toString(), "java", root);
    }
}