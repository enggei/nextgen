package nextgen.utils;

import nextgen.st.domain.STEnum;
import nextgen.st.domain.STGroupModel;
import nextgen.st.domain.STTemplate;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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

   public static Set<STTemplate> findSTInterfacesByName(String name, STGroupModel stGroupModel) {
      final Set<STTemplate> set = new LinkedHashSet<>();
      getAllSTTemplates(stGroupModel)
            .forEach(stTemplate -> {
               stTemplate.getImplements()
                     .filter(name::equals)
                     .findFirst()
                     .ifPresent(s -> set.add(stTemplate));
            });
      return set;
   }

   public static STEnum findSTEnumByName(String name, STGroupModel stGroupModel) {
      return stGroupModel.getEnums()
            .filter(stEnum -> stEnum.getName().equals(name))
            .findFirst()
            .orElseGet(null);
   }
}
