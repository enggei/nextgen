package nextgen.swing;

public class STProjectEditor extends SearchReplaceEditor {

   private final String uuid;
   private final nextgen.model.STProject model;

   public STProjectEditor(nextgen.model.STProject model) {
      super();

      this.model = model;
      this.uuid = model.getUuid();
   }

   @Override
   protected java.util.stream.Stream<nextgen.model.STModel> getSTModels() {
      return nextgen.utils.STModelUtil.aggregateModels(model).stream();
   }

   public String getUuid() {
      return uuid;
   }

   public nextgen.model.STProject getModel() {
      return model;
   }
}