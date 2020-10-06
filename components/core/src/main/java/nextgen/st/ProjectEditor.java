package nextgen.st;
import nextgen.st.model.Project;

import javax.swing.*;
import java.awt.*;

public class ProjectEditor extends JPanel {

   private final Project model;
   private final STAppPresentationModel presentationModel;

   public ProjectEditor(Project model, STAppPresentationModel presentationModel) {
      super(new BorderLayout());
      this.model = model;
      this.presentationModel = presentationModel;

      setBackground(Color.BLACK);

   }

   public Project getModel() {
      return model;
   }
}
