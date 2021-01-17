package nextgen.swing.forms;

import javax.swing.*;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.CellConstraints;

public class STGroupActionForm extends JPanel {

	JLabel lblName = new JLabel("name");
	JTextField txtName = new JTextField("");

	public STGroupActionForm() {
		setLayout(new FormLayout("left:1024:none", "center:pref:none, center:pref:none"));
		final CellConstraints cc = new CellConstraints();
		add(lblName, cc.xywh(1, 1, 1, 1, "LEFT, TOP"));
		add(txtName, cc.xywh(1, 2, 1, 1, "FILL, FILL"));
	}

	public JLabel getLblName() {
		return lblName;
	}

	public JTextField getTxtName() {
		return txtName;
	}


	public void modelToView(nextgen.model.STGroupAction model) { 
		txtName.setText(model.getName());	
	}

	public void viewToModel(nextgen.model.STGroupAction model) {
		model.setName(txtName.getText());	
	}  
	/*

	columns 		"left:1024:none"

	rows 		 	"center:pref:none, center:pref:none"

	*/
}  