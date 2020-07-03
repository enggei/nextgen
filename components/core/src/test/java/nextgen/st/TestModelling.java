package nextgen.st;

import nextgen.st.domain.STGroupModel;
import nextgen.st.domain.STParameterKey;
import nextgen.st.domain.STTemplate;
import nextgen.st.model.STModel;
import nextgen.st.model.neo.STModelDB;
import org.junit.Test;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

import static nextgen.st.STModelPatterns.*;
import static nextgen.st.STParser.readJsonObject;

public class TestModelling {

    @Test
    public void testModel() {

        final File templatesDir = new File("src/main/resources/templates");

        final Map<String, STGroupModel> stGroupModelMap = new LinkedHashMap<>();
        Optional.ofNullable(STApp.list(templatesDir, ".json"))
                .ifPresent(files -> {
                    for (File file : files) {
                        final STGroupModel stGroupModel = new STGroupModel(readJsonObject(file));
                        stGroupModelMap.put(stGroupModel.uuid(), stGroupModel);
                        stGroupModel.getTemplates().forEach(stTemplate -> addTemplate(stGroupModelMap, stGroupModel, stTemplate));
                    }
                });

        final STRenderer stRenderer = new STRenderer(stGroupModelMap.values());
        final STModelDB db = new STModelDB("src/test/testdb", stGroupModelMap.values());

        find(stGroupModelMap, "Test")
                .ifPresent(domainSTGroupModel ->

                        find(domainSTGroupModel, "single").ifPresent(single -> {

                            final STModel singleModel = newSTModel().setStTemplate(single);
                            single.getParameters().findFirst().ifPresent(stParameter -> addArgument(single, singleModel, newSTArgument(stParameter, newSTValue("HelloWorld"))));

                            find(domainSTGroupModel, "list").ifPresent(list -> {

                                list.getParameters().findFirst().ifPresent(stParameter -> {

                                    final STModel listModel = newSTModel().setStTemplate(list);
                                    addArgument(list, listModel, newSTArgument(stParameter, newSTValue("1")));
                                    addArgument(list, listModel, newSTArgument(stParameter, newSTValue("2")));
                                    addArgument(list, listModel, newSTArgument(stParameter, newSTValue(singleModel)));

                                    find(domainSTGroupModel, "kv").ifPresent(kv -> {

                                        final STModel kvModel = newSTModel().setStTemplate(kv);

                                        kv.getParameters().forEach(kvParameter -> {
                                            final List<STParameterKey> keys = kvParameter.getKeys().collect(Collectors.toList());
                                            addArgument(kv, kvModel, newSTArgument(kvParameter, newSTArgument(keys.get(0), newSTValue("KEY_1")), newSTArgument(keys.get(1), newSTValue("VAL_1"))));
                                            addArgument(kv, kvModel, newSTArgument(kvParameter, newSTArgument(keys.get(0), newSTValue("KEY_2")), newSTArgument(keys.get(1), newSTValue(singleModel))));
                                            addArgument(kv, kvModel, newSTArgument(kvParameter, newSTArgument(keys.get(0), newSTValue("KEY_3")), newSTArgument(keys.get(1), newSTValue(listModel))));
                                        });

                                        System.out.println(stRenderer.render(kvModel));

                                        db.doInTransaction(transaction -> {
                                            db.save(singleModel);
                                            db.save(listModel);
                                            db.save(kvModel);
                                        });
                                    });

                                    System.out.println(stRenderer.render(listModel));
                                });
                            });

                            System.out.println(stRenderer.render(singleModel));
                        }));
        System.out.println("-----");
        db.doInTransaction(transaction -> {
            db.getAllSTModels().forEach(stModel -> System.out.println(stRenderer.render(stModel)));
        });
    }

    private static void addTemplate(Map<String, STGroupModel> stGroupModelMap, STGroupModel stGroupModel, STTemplate stTemplate) {
        stGroupModelMap.put(stTemplate.uuid(), stGroupModel);
        stTemplate.getChildren().forEach(stTemplate1 -> addTemplate(stGroupModelMap, stGroupModel, stTemplate1));
    }
}