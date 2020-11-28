package nextgen.swing;

public class STProjectEditorGrid extends SearchReplaceEditor {

   private final String uuid;
   private final nextgen.st.model.STProject model;

   public STProjectEditorGrid(nextgen.st.model.STProject model) {
      super();

      this.model = model;
      this.uuid = model.getUuid();
   }

   @Override
   protected java.util.stream.Stream<nextgen.st.model.STModel> getSTModels() {
      return nextgen.utils.STModelUtil.aggregateModels(model).stream();
   }

   public String getUuid() {
      return uuid;
   }

   public nextgen.st.model.STProject getModel() {
      return model;
   }
}