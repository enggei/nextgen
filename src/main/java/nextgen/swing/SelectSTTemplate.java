package nextgen.swing;

import nextgen.model.*;

import javax.swing.*;
import java.util.*;

public class SelectSTTemplate extends nextgen.swing.BaseEditor<nextgen.model.STTemplate> {

   private final Map<JRadioButton, STTemplate> map = new LinkedHashMap<>();

   public SelectSTTemplate(Set<STTemplate> templateSet) {
      setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
      setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));

      for (STTemplate template : templateSet) {
         final JRadioButton jRadioButton = ComponentFactory.newJRadioButton(template.getName());
         add(jRadioButton);
         map.put(jRadioButton, template);
      }
   }

   @Override
   public String title() {
      return "Select or add New";
   }

   @Override
   public STTemplate getModel() {

      final Optional<JRadioButton> selected = Arrays.stream(getComponents())
            .filter(component -> component instanceof JRadioButton)
            .map(component -> (JRadioButton) component)
            .filter(AbstractButton::isSelected)
            .findFirst();

      return selected.isEmpty() ? null : map.get(selected.get());
   }
}