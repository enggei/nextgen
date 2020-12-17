package nextgen.swing;

public class ModelEditor<T> extends AbstractEditor {

   protected T model;

   public ModelEditor() {
   }

   public T getModel() {
      return model;
   }

   public void setModel(T model) {
      this.model = model;
   }
}
