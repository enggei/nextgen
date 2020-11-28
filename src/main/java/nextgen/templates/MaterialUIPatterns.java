package nextgen.templates;

import nextgen.templates.materialui.MaterialUIComponent;
import nextgen.templates.materialui.MaterialUIST;
import nextgen.templates.materialui.PaperElement;
import nextgen.templates.materialui.StyleClass;

public class MaterialUIPatterns extends MaterialUIST {

    public static StyleClass newStyleClass(String name) {
        return newStyleClass().setName(name);
    }

    public static MaterialUIComponent newMaterialUIComponent(String name) {
        return newMaterialUIComponent().setName(name);
    }

    public static PaperElement newPaperElement(String className) {
        return newPaperElement().setClassName(styleClass(className));
    }

    public static Object styleClass(String name) {
        return "{classes." + name + "}";
    }
}
