package nextgen.swing.model;

public class STModelPanel extends nextgen.swing.AbstractEditor {

   public STModelPanel(nextgen.model.STModel model) {


      final ColumnPanel center = newColumnPanel();

      final org.fife.ui.rsyntaxtextarea.RSyntaxTextArea textArea = nextgen.utils.SwingUtil.newRSyntaxTextArea();
      textArea.setEditable(false);
      textArea.setText(appModel().render(model));
      center.append(textArea);

      add(center, java.awt.BorderLayout.CENTER);
   }
}