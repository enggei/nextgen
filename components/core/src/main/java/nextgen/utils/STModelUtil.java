package nextgen.utils;

import nextgen.st.domain.STGroupModel;
import nextgen.st.domain.STTemplate;

import java.util.ArrayList;
import java.util.List;

public class STModelUtil {

   public static STTemplate findSTemplateByName(String name, STGroupModel stGroupModel) {
      return getAllSTTemplates(stGroupModel).stream()
            .filter(stTemplate -> stTemplate.getName().equals(name))
            .findAny()
            .orElse(null);
   }

   public static List<STTemplate> getAllSTTemplates(STGroupModel stGroupModel) {
      final List<STTemplate> list = new ArrayList<>();
      stGroupModel.getTemplates().forEach(stTemplate -> {
         list.add(stTemplate);
         list.addAll(getAllSTTemplates(stTemplate));
      });
      return list;
   }

   public static List<STTemplate> getAllSTTemplates(STTemplate stTemplate) {
      final List<STTemplate> list = new ArrayList<>();
      stTemplate.getChildren().forEach(stTemplate1 -> {
         list.add(stTemplate1);
         list.addAll(getAllSTTemplates(stTemplate1));
      });
      return list;
   }


}
