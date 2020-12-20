package nextgen.swing.model;

public class STFilePanel extends nextgen.swing.AbstractEditor {

   public STFilePanel(nextgen.model.STFile model) {

      final BasePanel namePanel = newFlowPanel().append(newLabel("Name")).append(new nextgen.swing.model.STValuePanel(model.getName()));
      final BasePanel pathPanel = newFlowPanel().append(newLabel("Path")).append(new STValuePanel(model.getPath()));
      final BasePanel typePanel = newFlowPanel().append(newLabel("Type")).append(new STValuePanel(model.getType()));

      final BasePanel center = newColumnPanel().append(namePanel).append(pathPanel).append(typePanel);


      add(center, java.awt.BorderLayout.CENTER);
   }
}