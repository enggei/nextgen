package nextgen.templates;


import nextgen.templates.materialui.*;

public class MaterialUIPatterns extends MaterialUIST {

    public static Component.Component_Components button() {
        return asImport(ComponentTypes.Button);
    }

    public static Component.Component_Components link() {
        return asImport(ComponentTypes.Link);
    }

    public static Component.Component_Components grid() {
        return asImport(ComponentTypes.Grid);
    }

    public static Component.Component_Components paper() {
        return asImport(ComponentTypes.Paper);
    }

    public static Component.Component_Components divider() {
        return asImport(ComponentTypes.Divider);
    }

    public static Component.Component_Components typography() {
        return asImport(ComponentTypes.Typography);
    }

    public static Component newComponent(String name) {
        return MaterialUIPatterns.newComponent()
                .setName(name);
    }

    public static Component.Component_Components asImport(ComponentTypes type) {
        return new Component.Component_Components(type.name(), type.toString());
    }

    public static StyleClass newStyle(String name) {
        return MaterialUIPatterns.newStyleClass()
                .setName(name);
    }

    public static SimpleElement newSimpleElement(String name, String className) {
        return MaterialUIST.newSimpleElement()
                .setName(name)
                .setClassName(className);
    }

    public static SimpleElement newSimpleElement(String name) {
        return MaterialUIST.newSimpleElement().setName(name);
    }
}