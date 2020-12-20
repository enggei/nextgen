package nextgen.swing;

public interface FormPanelParameters {
   String columnSpecs();

   String rowSpecs();

   java.util.stream.Stream<FormComponent> components();

   interface FormComponent {
      javax.swing.JComponent component();

      Object constraints();
   }
}