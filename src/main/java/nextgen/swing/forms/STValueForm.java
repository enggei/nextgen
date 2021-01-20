package nextgen.swing.forms;

import javax.swing.*;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.CellConstraints;

public class STValueForm extends JPanel {

	JLabel lblValue = new JLabel("value");
	nextgen.swing.components.BaseTextArea txtValue = new nextgen.swing.components.BaseTextArea("");

	public STValueForm() {
		setLayout(new FormLayout("left:2400:none", "center:pref:none, center:150:grow"));
		final CellConstraints cc = new CellConstraints();
		add(lblValue, cc.xywh(1, 1, 1, 1, "LEFT, TOP"));
		add(new org.fife.ui.rtextarea.RTextScrollPane(txtValue), cc.xywh(1, 2, 1, 1, "FILL, FILL"));
	}

	public JLabel getLblValue() {
		return lblValue;
	}

	public nextgen.swing.components.BaseTextArea getTxtValue() {
		return txtValue;
	}


	public void modelToView(nextgen.model.STValue model) { 
		txtValue.setText(model.getValue());	
	}

	public void viewToModel(nextgen.model.STValue model) {
		model.setValue(txtValue.getText());	
	}  
	/*

	columns 		"left:2400:none"

	rows 		 	"center:pref:none, center:150:grow"

	*/
}  