package nextgen.swing;

public class BaseEditor<T> extends AbstractEditor {

   protected String uuid;
   protected T model;

   public BaseEditor() {
      this.uuid = java.util.UUID.randomUUID().toString();
   }

   public BaseEditor(T model) {
      this.model = model;
      this.uuid = java.util.UUID.randomUUID().toString();
   }

   public BaseEditor(T model, String uuid) {
      this.model = model;
      this.uuid = uuid;
   }

   public T getModel() {
      return model;
   }

   public void setModel(T model) {
      this.model = model;
   }

   public String getUuid() {
      return uuid;
   }

   @Override
   public String toString() {
      return uuid + " " + model;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      nextgen.swing.BaseEditor<?> that = (nextgen.swing.BaseEditor<?>) o;

      return uuid.equals(that.uuid);
   }

   @Override
   public int hashCode() {
      return uuid.hashCode();
   }
}
