package nextgen.templates;

import nextgen.templates.typescript.TypeScriptST;
import nextgen.templates.typescript.Types;
import nextgen.templates.typescript.VariableDeclaration;

public class TypeScriptPatterns extends TypeScriptST {

    public static VariableDeclaration newBoolean(String name) {
        return newVariableDeclaration().setType(Types.booleanType).setName(name);
    }

    public static VariableDeclaration newBoolean(String name, boolean initializer) {
        return newBoolean(name).setInitializer(initializer);
    }

    public static VariableDeclaration newDecimal(String name) {
        return newVariableDeclaration().setName(name);
    }
}