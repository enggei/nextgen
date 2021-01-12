package nextgen.swing.forms;

import javax.swing.*;

import static nextgen.swing.ComponentFactory.*;

public class STValueForm extends JPanel {

	JLabel value_JLabel;
	JScrollPane value_JScrollPane;

	public STValueForm() {
		setLayout(new com.jgoodies.forms.layout.FormLayout("center:max(50dlu;pref):none, fill:pref:grow", "center:30:none, center:30:none, center:30:none"));
	}

	public <T extends JLabel> T getValueJLabel() {
		return (T) value_JLabel;
	}

	public <T extends JLabel> T getValueJLabel(java.util.function.Supplier<T> supplier) {
		if (this.value_JLabel == null) setValue(supplier.get());
   	return (T) this.value_JLabel;
	}

	public STValueForm setValue(JLabel component) {
		if (component == null) return this;
		add(this.value_JLabel = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 1, 1, 1, "CENTER, CENTER"));
		return this;
	}

	public <T extends JScrollPane> T getValueJScrollPane() {
		return (T) value_JScrollPane;
	}

	public <T extends JScrollPane> T getValueJScrollPane(java.util.function.Supplier<T> supplier) {
		if (this.value_JScrollPane == null) setValue(supplier.get());
   	return (T) this.value_JScrollPane;
	}

	public STValueForm setValue(JScrollPane component) {
		if (component == null) return this;
		add(this.value_JScrollPane = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 1, 1, 3, "FILL, FILL"));
		return this;
	}


	public void setModel(nextgen.model.STValue model) {
		setValue(newJLabel("Value"));
		getValueJScrollPane(() -> newRTextScrollPane(newRSyntaxTextArea())).getTextArea().setText(model.getValue());
	}

	public void onSave(nextgen.model.STValue model) {
		model.setValue(((org.fife.ui.rtextarea.RTextScrollPane) getValueJScrollPane()).getTextArea().getText());
	}

	/*

	 columns 	2	"center:max(50dlu;pref):none, fill:pref:grow"

	 rows 		3 	"center:30:none, center:30:none, center:30:none"

	 col 2 1 CENTER max(50dlu;pref) none
	 col 3 1 FILL pref grow
	 row 1 2 CENTER 30 none
	 row 1 3 CENTER 30 none
	 row 1 4 CENTER 30 none
	 cell 2 2 1 1 CENTER CENTER Label value
	 cell 3 2 3 1 FILL FILL ScrollPane value
	 cell 2 3 1 1 CENTER CENTER NONE null
	 cell 3 3 1 1 FILL CENTER NONE root
	 cell 2 4 1 1 CENTER CENTER NONE 
	 cell 3 4 1 1 CENTER CENTER NONE null

	*/	
}