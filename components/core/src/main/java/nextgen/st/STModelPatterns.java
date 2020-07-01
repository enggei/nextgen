package nextgen.st;

import nextgen.st.domain.*;
import nextgen.st.model.*;

import java.util.*;

public class STModelPatterns extends STModelFactory {

    public static STModule newSTModule(String name) {
        return newSTModule().setName(name);
    }

    public static STModel newSTModel(STModule stModule, STTemplate stTemplate) {
        final STModel stModel = newSTModel(stTemplate);
        stModule.addModels(stModel);
        return stModel;
    }

    public static STModel newSTModel(STTemplate stTemplate) {
        return newSTModel().setStTemplate(stTemplate);
    }

    public static STArgument newSTArgument(STParameter stParameter, STValue stValue) {
        return newSTArgument()
                .setStParameter(stParameter)
                .setValue(stValue);
    }

    public static STArgument newSTArgument(STParameter stParameter, STArgumentKV... kvs) {
        return newSTArgument(stParameter, Arrays.asList(kvs));
    }

    public static STArgument newSTArgument(STParameter stParameter, Collection<STArgumentKV> kvs) {
        final STArgument stArgument = newSTArgument().setStParameter(stParameter);

        stParameter.getKeys()
                .forEach(stParameterKey -> kvs.stream()
                        .filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey))
                        .findFirst()
                        .ifPresent(stArgument::addKeyValues));
        return stArgument;
    }

    public static STArgumentKV newSTArgument(STParameterKey stParameterKey, STValue value) {
        return newSTArgumentKV()
                .setStParameterKey(stParameterKey)
                .setValue(value);
    }

    public static STValue newSTValue(STModel stModel) {
        return newSTValue().setType(STValueType.STMODEL).setValue(stModel);
    }

    public static STValue newSTValue(STEnumValue value) {
        return newSTValue().setType(STValueType.ENUM).setValue(value);
    }

    public static STValue newSTValue(Object value) {
        return newSTValue().setType(STValueType.PRIMITIVE).setValue(value);
    }

    public static void setArgument(STModel stModel, STArgument stArgument) {

        stModel.getArguments()
                .stream()
                .filter(argument -> argument.getStParameter().equals(stArgument.getStParameter()))
                .findAny()
                .ifPresent(stModel::removeArguments);

        stModel.addArguments(stArgument);
    }

    public static void addArgument(STTemplate stTemplate, STModel stModel, STArgument stArgument) {
        stTemplate.getParameters()
                .filter(parameter -> parameter.equals(stArgument.getStParameter()))
                .findFirst()
                .ifPresent(parameter -> stModel.addArguments(stArgument));
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