package nextgen.swing.forms;

import javax.swing.*;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.CellConstraints;

public class STEnumValueForm extends JPanel {

	JLabel lblName = new JLabel("name");
	JTextField txtName = new JTextField("");
	JLabel lblLexical = new JLabel("lexical");
	nextgen.swing.components.BaseTextArea txtLexical = new nextgen.swing.components.BaseTextArea("");

	public STEnumValueForm() {
		setLayout(new FormLayout("left:1024:none", "center:pref:none, center:pref:none, center:pref:none, center:150:grow"));
		final CellConstraints cc = new CellConstraints();
		add(lblName, cc.xywh(1, 1, 1, 1, "LEFT, TOP"));
		add(txtName, cc.xywh(1, 2, 1, 1, "FILL, FILL"));
		add(lblLexical, cc.xywh(1, 3, 1, 1, "LEFT, TOP"));
		add(new org.fife.ui.rtextarea.RTextScrollPane(txtLexical), cc.xywh(1, 4, 1, 1, "FILL, FILL"));
	}

	public JLabel getLblName() {
		return lblName;
	}

	public JTextField getTxtName() {
		return txtName;
	}

	public JLabel getLblLexical() {
		return lblLexical;
	}

	public nextgen.swing.components.BaseTextArea getTxtLexical() {
		return txtLexical;
	}


	public void modelToView(nextgen.model.STEnumValue model) { 
		txtName.setText(model.getName());
		txtLexical.setText(model.getLexical());	
	}

	public void viewToModel(nextgen.model.STEnumValue model) {
		model.setName(txtName.getText());
		model.setLexical(txtLexical.getText());	
	}  
	/*

	columns 		"left:1024:none"

	rows 		 	"center:pref:none, center:pref:none, center:pref:none, center:150:grow"

	*/
}  