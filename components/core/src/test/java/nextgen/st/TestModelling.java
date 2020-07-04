package nextgen.st;

import nextgen.st.domain.STGroupModel;
import nextgen.st.domain.STParameter;
import nextgen.st.domain.STParameterKey;
import nextgen.st.domain.STTemplate;
import nextgen.st.model.STModel;
import nextgen.st.model.STModelDB;
import org.junit.Test;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
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

        db.doInTransaction(transaction -> {

            final STTemplate single = db.findSTTemplateByName("single");
            final STModel singleModel = db.newSTModel(single);

            final STParameter singleParameter = single.getParameters().iterator().next();
            db.addArgument(singleModel, singleParameter, db.newSTValue("YOLO"));

            final STTemplate list = db.findSTTemplateByName("list");
            final STModel listModel = db.newSTModel(list);

            final STParameter listParameter = list.getParameters().iterator().next();
            db.addArgument(listModel, listParameter, db.newSTValue("1"));
            db.addArgument(listModel, listParameter, db.newSTValue("2"));
            db.addArgument(listModel, listParameter, db.newSTValue(singleModel));

            final STTemplate kv = db.findSTTemplateByName("kv");
            final STModel kvModel = db.newSTModel(kv);

            final STParameter kvParameter = kv.getParameters().iterator().next();
            final List<STParameterKey> keys = kvParameter.getKeys().collect(Collectors.toList());
            db.addArgument(kvModel, kvParameter, asList(db.newSTArgumentKV(keys.get(0), db.newSTValue("Key_1")), db.newSTArgumentKV(keys.get(1), db.newSTValue("VAL_1"))));
            db.addArgument(kvModel, kvParameter, asList(db.newSTArgumentKV(keys.get(0), db.newSTValue("SINGLE")), db.newSTArgumentKV(keys.get(1), db.newSTValue(singleModel))));
            db.addArgument(kvModel, kvParameter, asList(db.newSTArgumentKV(keys.get(0), db.newSTValue("LIST")), db.newSTArgumentKV(keys.get(1), db.newSTValue(listModel))));
        });

        db.doInTransaction(transaction -> {
            db.findAllSTModel().forEach(stModel -> System.out.println(stRenderer.render(stModel)));
        });
    }

    private static void addTemplate(Map<String, STGroupModel> stGroupModelMap, STGroupModel stGroupModel, STTemplate stTemplate) {
        stGroupModelMap.put(stTemplate.uuid(), stGroupModel);
        stTemplate.getChildren().forEach(stTemplate1 -> addTemplate(stGroupModelMap, stGroupModel, stTemplate1));
    }
}