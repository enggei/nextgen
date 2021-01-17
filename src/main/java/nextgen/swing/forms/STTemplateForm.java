package nextgen.swing.forms;

import javax.swing.*;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.CellConstraints;

public class STTemplateForm extends JPanel {

	JLabel lblParameters = new JLabel("parameters");
	nextgen.swing.table.STParameterTable tblParameters = new nextgen.swing.table.STParameterTable();
	JLabel lblName = new JLabel("name");
	JTextField txtName = new JTextField("");
	JLabel lblText = new JLabel("text");
	nextgen.swing.components.BaseTextArea txtText = new nextgen.swing.components.BaseTextArea("");
	JLabel lblChildren = new JLabel("children");
	nextgen.swing.table.STTemplateTable tblChildren = new nextgen.swing.table.STTemplateTable();

	public STTemplateForm() {
		setLayout(new FormLayout("left:1024:none", "center:200:grow, center:pref:none, center:pref:none, center:pref:none, center:150:grow, center:200:grow"));
		final CellConstraints cc = new CellConstraints();
		add(lblParameters, cc.xywh(1, 1, 1, 1, "LEFT, TOP"));
		add(new JScrollPane(tblParameters), cc.xywh(1, 1, 1, 1, "FILL, FILL"));
		add(lblName, cc.xywh(1, 2, 1, 1, "LEFT, TOP"));
		add(txtName, cc.xywh(1, 3, 1, 1, "FILL, FILL"));
		add(lblText, cc.xywh(1, 4, 1, 1, "LEFT, TOP"));
		add(new org.fife.ui.rtextarea.RTextScrollPane(txtText), cc.xywh(1, 5, 1, 1, "FILL, FILL"));
		add(lblChildren, cc.xywh(1, 6, 1, 1, "LEFT, TOP"));
		add(new JScrollPane(tblChildren), cc.xywh(1, 6, 1, 1, "FILL, FILL"));
	}

	public JLabel getLblParameters() {
		return lblParameters;
	}

	public nextgen.swing.table.STParameterTable getTblParameters() {
		return tblParameters;
	}

	public JLabel getLblName() {
		return lblName;
	}

	public JTextField getTxtName() {
		return txtName;
	}

	public JLabel getLblText() {
		return lblText;
	}

	public nextgen.swing.components.BaseTextArea getTxtText() {
		return txtText;
	}

	public JLabel getLblChildren() {
		return lblChildren;
	}

	public nextgen.swing.table.STTemplateTable getTblChildren() {
		return tblChildren;
	}


	public void modelToView(nextgen.model.STTemplate model) { 
		tblParameters.setContent(model.getParameters());
		txtName.setText(model.getName());
		txtText.setText(model.getText());
		tblChildren.setContent(model.getChildren());	
	}

	public void viewToModel(nextgen.model.STTemplate model) {
		model.setName(txtName.getText());
		model.setText(txtText.getText());	
	}  
	/*

	columns 		"left:1024:none"

	rows 		 	"center:200:grow, center:pref:none, center:pref:none, center:pref:none, center:150:grow, center:200:grow"

	*/
}  