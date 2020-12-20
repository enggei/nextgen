package nextgen.swing.model;

public class STValuePanel extends nextgen.swing.AbstractEditor {

   public STValuePanel(nextgen.model.STValue model) {


      final ColumnPanel center = newColumnPanel();

      switch (model.getType()) {
         case STMODEL:
            center.add(new nextgen.swing.model.STModelPanel(model.getStModel()));
            break;
         case PRIMITIVE:
            center.add(newTextField(model.getValue(), 15));
            break;
         case ENUM:
            final nextgen.model.STEnumValue enumValue = model.getStEnumValue();
            center.add(nextgen.utils.SwingUtil.newComboBox(appModel().asCollection(enumValue), nextgen.model.STEnumValue::getName, enumValue));
            break;
      }

      add(center, java.awt.BorderLayout.CENTER);
   }
}