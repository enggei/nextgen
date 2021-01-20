package nextgen.swing.forms;

import javax.swing.*;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.CellConstraints;

public class DomainEntityForm extends JPanel {

	JLabel lblName = new JLabel("name");
	JTextField txtName = new JTextField("");
	JLabel lblEnums = new JLabel("enums");
	nextgen.swing.components.BaseTextArea txtEnums = new nextgen.swing.components.BaseTextArea("");

	public DomainEntityForm() {
		setLayout(new FormLayout("left:2400:none", "center:pref:none, center:pref:none, center:pref:none, center:150:grow"));
		final CellConstraints cc = new CellConstraints();
		add(lblName, cc.xywh(1, 1, 1, 1, "LEFT, TOP"));
		add(txtName, cc.xywh(1, 2, 1, 1, "FILL, FILL"));
		add(lblEnums, cc.xywh(1, 3, 1, 1, "LEFT, TOP"));
		add(new org.fife.ui.rtextarea.RTextScrollPane(txtEnums), cc.xywh(1, 4, 1, 1, "FILL, FILL"));
	}

	public JLabel getLblName() {
		return lblName;
	}

	public JTextField getTxtName() {
		return txtName;
	}

	public JLabel getLblEnums() {
		return lblEnums;
	}

	public nextgen.swing.components.BaseTextArea getTxtEnums() {
		return txtEnums;
	}


	public void modelToView(nextgen.model.DomainEntity model) { 
		txtName.setText(model.getName());
		txtEnums.setText(model.getEnums());	
	}

	public void viewToModel(nextgen.model.DomainEntity model) {
		model.setName(txtName.getText());
		model.setEnums(txtEnums.getText());	
	}  
	/*

	columns 		"left:2400:none"

	rows 		 	"center:pref:none, center:pref:none, center:pref:none, center:150:grow"

	*/
}  