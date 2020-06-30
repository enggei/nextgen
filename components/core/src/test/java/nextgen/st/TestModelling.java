package nextgen.st;

import nextgen.st.domain.STGroupModel;
import nextgen.st.domain.STTemplate;
import nextgen.st.model.STModel;
import nextgen.st.model.STModule;
import org.junit.Test;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import static nextgen.st.STModeller.*;
import static nextgen.st.STParser.readJsonObject;

public class TestModelling {

    @Test
    public void testModel() {

        final File templatesDir = new File("/home/goe/projects/nextgen/components/core/src/main/resources/templates");

        final Map<String, STGroupModel> stGroupModelMap = new LinkedHashMap<>();
        Optional.ofNullable(STApp.list(templatesDir, ".json"))
                .ifPresent(files -> {
                    for (File file : files) {
                        final STGroupModel stGroupModel = new STGroupModel(readJsonObject(file));
                        stGroupModelMap.put(stGroupModel.uuid(), stGroupModel);
                        stGroupModel.getTemplates().forEach(stTemplate -> addTemplate(stGroupModelMap, stGroupModel, stTemplate));
                    }
                });

        final STModule stModule = newModule("TestModel");

        find(stGroupModelMap, "Test")
                .ifPresent(domainSTGroupModel ->

                        find(domainSTGroupModel, "single").ifPresent(single -> {

                            final STModel singleModel = addSTModel(stModule, single);
                            addArgument(single, singleModel, "value", newValue("HelloWorld"));

                            find(domainSTGroupModel, "list").ifPresent(list -> {

                                final STModel listModel = addSTModel(stModule, list);
                                addArgument(list, listModel, "value", newValue("1"));
                                addArgument(list, listModel, "value", newValue("2"));
                                addArgument(list, listModel, "value", newValue(singleModel));

                                find(domainSTGroupModel, "kv").ifPresent(kv -> {

                                    final STModel kvModel = addSTModel(stModule, kv);
                                    addArgument(kv, kvModel, "value", newKVArgument("key", newValue("KEY_1")), newKVArgument("value", newValue("VAL_1")));
                                    addArgument(kv, kvModel, "value", newKVArgument("key", newValue("KEY_2")), newKVArgument("value", newValue(singleModel)));
                                    addArgument(kv, kvModel, "value", newKVArgument("key", newValue("KEY_3")), newKVArgument("value", newValue(listModel)));
                                });
                            });
                        }));

        System.out.println(stModule.getJsonObject().encodePrettily());

        final STRenderer stRenderer = new STRenderer(templatesDir);
        stRenderer.addModule(stModule);

        stModule.getModels().forEach(stModel -> {
            System.out.println(stRenderer.render(stModel));
        });
    }



    private static void addTemplate(Map<String, STGroupModel> stGroupModelMap, STGroupModel stGroupModel, STTemplate stTemplate) {
        stGroupModelMap.put(stTemplate.uuid(), stGroupModel);
        stTemplate.getChildren().forEach(stTemplate1 -> addTemplate(stGroupModelMap, stGroupModel, stTemplate1));
    }
}