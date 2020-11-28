package nextgen.st.importers;

import nextgen.utils.FileUtil;
import nextgen.st.STGenerator;
import nextgen.st.STParser;
import nextgen.st.model.STGroupModel;
import nextgen.st.model.STTemplate;
import nextgen.st.model.STModelDB;

import java.io.File;
import java.io.IOException;

import static nextgen.st.STParser.readJsonObject;

public class Html5Importer extends BaseImporter {

//    public static void main(String[] args) throws IOException {
//        new Html5Importer();
//    }
//
//    public Html5Importer() throws IOException {
//
//        final File oldSTGFile = new File("/home/goe/projects/nextgen/components/core/src/main/java/com/generator/generators/html5/Html5Group.stg");
//        final nextgen.st.parser.ParseResult parseResult = STParser.parse(oldSTGFile);
//
//        parseResult.getErrors().forEach(System.out::println);
//        if (!parseResult.getErrors().isEmpty()) return;
//
//        final String groupName = "Html5";
//        final File stGroupFile = new File(templatesDir, groupName + ".json");
//        final STGroupModel stGroupModel = stGroupFile.exists()
//                ? new STGroupModel(stGroupFile)
//                : new STGroupModel().setName(groupName).setDelimiter("~");
//
//        final nextgen.st.parser.ParsedSTGroupModel parsed = parseResult.getParsed();
//        parsed.getTemplates().forEach(oldTemplate -> {
//            System.out.println(oldTemplate.getName());
//
//            if (oldTemplate.getName().equals("object")) {
//                oldTemplate.setName("_object");
//            }
//
//            oldTemplate.getParameters().forEach(stParameter -> {
//
//                if (stParameter.getName().equals("class")) {
//                    stParameter.setName("_class");
//
//                    oldTemplate.setText(oldTemplate.getText()
//                            .replaceAll("~if\\(class\\)~", "~if(_class)~")
//                            .replaceAll("~class~", "~_class~")
//                    );
//                } else if (stParameter.getName().equals("object")) {
//                    stParameter.setName("_object");
//                    oldTemplate.setText(oldTemplate.getText()
//                            .replaceAll("~if\\(object\\)~", "~if(_object)~")
//                            .replaceAll("~object~", "~_object~")
//                    );
//                }
//            });
//
//            STParser.parseTemplateAndGet(oldTemplate.getText())
//                    .ifPresent(stTemplate -> {
//                        final STTemplate elementTemplate = STModelDB.findSTTemplateByName(stGroupModel, oldTemplate.getName())
//                                .orElseGet(() -> {
//                                    final STTemplate newTemplate = new STTemplate()
//                                            .setName(oldTemplate.getName())
//                                            .setText(oldTemplate.getText());
//                                    stGroupModel.addTemplates(newTemplate);
//                                    return newTemplate;
//                                });
//
//                        STParser.mergeTemplate(stTemplate, elementTemplate);
//                    });
//        });
//
//        FileUtil.write(stGroupModel.getJsonObject().encodePrettily(), stGroupFile);
//
//        final STGroupModel generator = new STGroupModel(readJsonObject(new File("/home/goe/projects/nextgen/components/core/src/main/java/nextgen/st/StringTemplate.json")));
//
//        final STGenerator stGenerator = new STGenerator(generator);
//        stGenerator.generateSTGroup(stGroupModel, "nextgen.templates", new File(root, "main/java").getAbsolutePath());
//    }
}
