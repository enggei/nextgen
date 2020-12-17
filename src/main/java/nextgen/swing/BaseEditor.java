package nextgen.swing;

public class BaseEditor<T> extends AbstractEditor {

   protected T model;

   public BaseEditor() {
   }

   public T getModel() {
      return model;
   }

   public void setModel(T model) {
      this.model = model;
   }
}
