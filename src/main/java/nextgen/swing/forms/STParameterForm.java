package nextgen.swing.forms;

import javax.swing.*;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.CellConstraints;

public class STParameterForm extends JPanel {

	JLabel lblName = new JLabel("name");
	JTextField txtName = new JTextField("");
	JLabel lblKeys = new JLabel("keys");
	nextgen.swing.table.STParameterKeyTable tblKeys = new nextgen.swing.table.STParameterKeyTable();
	JLabel lblArgumentType = new JLabel("argumentType");
	nextgen.swing.components.BaseTextArea txtArgumentType = new nextgen.swing.components.BaseTextArea("");

	public STParameterForm() {
		setLayout(new FormLayout("left:1024:none", "center:pref:none, center:pref:none, center:200:grow, center:pref:none, center:150:grow"));
		final CellConstraints cc = new CellConstraints();
		add(lblName, cc.xywh(1, 1, 1, 1, "LEFT, TOP"));
		add(txtName, cc.xywh(1, 2, 1, 1, "FILL, FILL"));
		add(lblKeys, cc.xywh(1, 3, 1, 1, "LEFT, TOP"));
		add(new JScrollPane(tblKeys), cc.xywh(1, 3, 1, 1, "FILL, FILL"));
		add(lblArgumentType, cc.xywh(1, 4, 1, 1, "LEFT, TOP"));
		add(new org.fife.ui.rtextarea.RTextScrollPane(txtArgumentType), cc.xywh(1, 5, 1, 1, "FILL, FILL"));
	}

	public JLabel getLblName() {
		return lblName;
	}

	public JTextField getTxtName() {
		return txtName;
	}

	public JLabel getLblKeys() {
		return lblKeys;
	}

	public nextgen.swing.table.STParameterKeyTable getTblKeys() {
		return tblKeys;
	}

	public JLabel getLblArgumentType() {
		return lblArgumentType;
	}

	public nextgen.swing.components.BaseTextArea getTxtArgumentType() {
		return txtArgumentType;
	}


	public void modelToView(nextgen.model.STParameter model) { 
		txtName.setText(model.getName());
		tblKeys.setContent(model.getKeys());
		txtArgumentType.setText(model.getArgumentType());	
	}

	public void viewToModel(nextgen.model.STParameter model) {
		model.setName(txtName.getText());
		model.setArgumentType(txtArgumentType.getText());	
	}  
	/*

	columns 		"left:1024:none"

	rows 		 	"center:pref:none, center:pref:none, center:200:grow, center:pref:none, center:150:grow"

	*/
}  