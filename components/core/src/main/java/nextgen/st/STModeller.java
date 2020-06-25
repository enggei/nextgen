package nextgen.st;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

import static nextgen.st.model.STModelJsonFactory.*;

public class STModeller {

    public static STModule newModule(String name) {
        return newSTModule().setName(name);
    }

    public static STValue newValue(STModel stModel) {
        return newValue(STValueType.STMODEL, stModel.uuid());
    }

    public static STValue newValue(String value) {
        return newValue(STValueType.PRIMITIVE, value);
    }

    public static STValue newValue(STValueType primitive, String s) {
        return newSTValue().setType(primitive).setValue(s);
    }

    public static STArgumentKV newKVArgument(String key, STValue value) {
        return newSTArgumentKV()
                .setKey(key)
                .setValue(value);
    }

    public static STModel addSTModel(STModule stModule, STTemplate stTemplate) {
        final STModel entityModel = newSTModel().setStTemplate(stTemplate.uuid());
        stModule.addModels(entityModel);
        return entityModel;
    }

    public static void addArgument(STTemplate kv, STModel kvModel, String parameterName, STArgumentKV... kvs) {
        kv.getParameters()
                .filter(stParameter -> stParameter.getName().equalsIgnoreCase(parameterName))
                .findFirst()
                .ifPresent(stParameter -> {
                    final STArgument stArgument = newSTArgument()
                            .setStParameter(stParameter.uuid());
                    for (STArgumentKV stArgumentKV : kvs) {
                        stArgument.addKeyValues(stArgumentKV);
                    }
                    kvModel.addArguments(stArgument);
                });
    }

    public static void addArgument(STTemplate stTemplate, STModel entityModel, String parameterName, STValue parameterValue) {
        stTemplate.getParameters()
                .filter(stParameter -> stParameter.getName().equalsIgnoreCase(parameterName))
                .findFirst()
                .ifPresent(stParameter -> {
                    entityModel.addArguments(newSTArgument()
                            .setStParameter(stParameter.uuid())
                            .setValue(parameterValue));
                });
    }

    public static Optional<STGroupModel> find(final Map<String, STGroupModel> stGroupModelMap, String groupName) {
        return stGroupModelMap.values().stream()
                .filter(stGroupModel -> stGroupModel.getName().equals(groupName))
                .findFirst();
    }

    public static Optional<STTemplate> find(STGroupModel stGroupModel, String templateName) {
        final Iterator<STTemplate> iterator = stGroupModel.getTemplates().iterator();
        while (iterator.hasNext()) {
            final STTemplate stTemplate = find(iterator.next(), templateName);
            if (stTemplate != null) return Optional.of(stTemplate);
        }
        return Optional.empty();
    }

    private static STTemplate find(STTemplate stTemplate, String templateName) {

        if (stTemplate.getName().equalsIgnoreCase(templateName)) return stTemplate;

        final Iterator<STTemplate> iterator = stTemplate.getChildren().iterator();
        while (iterator.hasNext()) {
            final STTemplate child = find(iterator.next(), templateName);
            if (child != null) return child;
        }

        return null;
    }
}