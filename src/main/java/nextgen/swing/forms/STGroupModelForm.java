package nextgen.swing.forms;

import javax.swing.*;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.CellConstraints;

public class STGroupModelForm extends JPanel {

	JLabel lblLanguage = new JLabel("language");
	nextgen.swing.components.BaseTextArea txtLanguage = new nextgen.swing.components.BaseTextArea("");
	JLabel lblName = new JLabel("name");
	JTextField txtName = new JTextField("");
	JLabel lblFiles = new JLabel("files");
	nextgen.swing.table.STGroupFileTable tblFiles = new nextgen.swing.table.STGroupFileTable();
	JLabel lblTemplates = new JLabel("templates");
	nextgen.swing.table.STTemplateTable tblTemplates = new nextgen.swing.table.STTemplateTable();
	JLabel lblInterfaces = new JLabel("interfaces");
	nextgen.swing.table.STInterfaceTable tblInterfaces = new nextgen.swing.table.STInterfaceTable();
	JLabel lblEnums = new JLabel("enums");
	nextgen.swing.table.STEnumTable tblEnums = new nextgen.swing.table.STEnumTable();
	JLabel lblActions = new JLabel("actions");
	nextgen.swing.table.STGroupActionTable tblActions = new nextgen.swing.table.STGroupActionTable();
	JLabel lblDelimiter = new JLabel("delimiter");
	JTextField txtDelimiter = new JTextField("");
	JLabel lblIcon = new JLabel("icon");
	JTextField txtIcon = new JTextField("");

	public STGroupModelForm() {
		setLayout(new FormLayout("left:2400:none", "center:pref:none, center:150:grow, center:pref:none, center:pref:none, center:200:grow, center:200:grow, center:200:grow, center:200:grow, center:200:grow, center:pref:none, center:pref:none, center:pref:none, center:pref:none"));
		final CellConstraints cc = new CellConstraints();
		add(lblLanguage, cc.xywh(1, 1, 1, 1, "LEFT, TOP"));
		add(new org.fife.ui.rtextarea.RTextScrollPane(txtLanguage), cc.xywh(1, 2, 1, 1, "FILL, FILL"));
		add(lblName, cc.xywh(1, 3, 1, 1, "LEFT, TOP"));
		add(txtName, cc.xywh(1, 4, 1, 1, "FILL, FILL"));
		add(lblFiles, cc.xywh(1, 5, 1, 1, "LEFT, TOP"));
		add(new JScrollPane(tblFiles), cc.xywh(1, 5, 1, 1, "FILL, FILL"));
		add(lblTemplates, cc.xywh(1, 6, 1, 1, "LEFT, TOP"));
		add(new JScrollPane(tblTemplates), cc.xywh(1, 6, 1, 1, "FILL, FILL"));
		add(lblInterfaces, cc.xywh(1, 7, 1, 1, "LEFT, TOP"));
		add(new JScrollPane(tblInterfaces), cc.xywh(1, 7, 1, 1, "FILL, FILL"));
		add(lblEnums, cc.xywh(1, 8, 1, 1, "LEFT, TOP"));
		add(new JScrollPane(tblEnums), cc.xywh(1, 8, 1, 1, "FILL, FILL"));
		add(lblActions, cc.xywh(1, 9, 1, 1, "LEFT, TOP"));
		add(new JScrollPane(tblActions), cc.xywh(1, 9, 1, 1, "FILL, FILL"));
		add(lblDelimiter, cc.xywh(1, 10, 1, 1, "LEFT, TOP"));
		add(txtDelimiter, cc.xywh(1, 11, 1, 1, "FILL, FILL"));
		add(lblIcon, cc.xywh(1, 12, 1, 1, "LEFT, TOP"));
		add(txtIcon, cc.xywh(1, 13, 1, 1, "FILL, FILL"));
	}

	public JLabel getLblLanguage() {
		return lblLanguage;
	}

	public nextgen.swing.components.BaseTextArea getTxtLanguage() {
		return txtLanguage;
	}

	public JLabel getLblName() {
		return lblName;
	}

	public JTextField getTxtName() {
		return txtName;
	}

	public JLabel getLblFiles() {
		return lblFiles;
	}

	public nextgen.swing.table.STGroupFileTable getTblFiles() {
		return tblFiles;
	}

	public JLabel getLblTemplates() {
		return lblTemplates;
	}

	public nextgen.swing.table.STTemplateTable getTblTemplates() {
		return tblTemplates;
	}

	public JLabel getLblInterfaces() {
		return lblInterfaces;
	}

	public nextgen.swing.table.STInterfaceTable getTblInterfaces() {
		return tblInterfaces;
	}

	public JLabel getLblEnums() {
		return lblEnums;
	}

	public nextgen.swing.table.STEnumTable getTblEnums() {
		return tblEnums;
	}

	public JLabel getLblActions() {
		return lblActions;
	}

	public nextgen.swing.table.STGroupActionTable getTblActions() {
		return tblActions;
	}

	public JLabel getLblDelimiter() {
		return lblDelimiter;
	}

	public JTextField getTxtDelimiter() {
		return txtDelimiter;
	}

	public JLabel getLblIcon() {
		return lblIcon;
	}

	public JTextField getTxtIcon() {
		return txtIcon;
	}


	public void modelToView(nextgen.model.STGroupModel model) { 
		txtLanguage.setText(model.getLanguage());
		txtName.setText(model.getName());
		tblFiles.setContent(model.getFiles());
		tblTemplates.setContent(model.getTemplates());
		tblInterfaces.setContent(model.getInterfaces());
		tblEnums.setContent(model.getEnums());
		tblActions.setContent(model.getActions());
		txtDelimiter.setText(model.getDelimiter());
		txtIcon.setText(model.getIcon());	
	}

	public void viewToModel(nextgen.model.STGroupModel model) {
		model.setLanguage(txtLanguage.getText());
		model.setName(txtName.getText());
		model.setDelimiter(txtDelimiter.getText());
		model.setIcon(txtIcon.getText());	
	}  
	/*

	columns 		"left:2400:none"

	rows 		 	"center:pref:none, center:150:grow, center:pref:none, center:pref:none, center:200:grow, center:200:grow, center:200:grow, center:200:grow, center:200:grow, center:pref:none, center:pref:none, center:pref:none, center:pref:none"

	*/
}  