package nextgen.swing.forms;

import javax.swing.*;

import static nextgen.swing.ComponentFactory.*;

public class STProjectForm extends JPanel {

	JLabel name_JLabel;
	JTextField name_JTextField;
	JLabel root_JLabel;
	JTextField root_JTextField;
	JLabel Values_JLabel;
	JTextArea null_JTextArea;

	public STProjectForm() {
		setLayout(new com.jgoodies.forms.layout.FormLayout("center:max(50dlu;pref):none, fill:pref:grow", "center:30:none, center:30:none, center:30:none, center:pref:grow"));
	}

	public STProjectForm setName(JLabel component) {
		if (component == null) return this;
		add(this.name_JLabel = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 1, 1, 1, "CENTER, CENTER"));
		return this;
	}

	public STProjectForm setName(JTextField component) {
		if (component == null) return this;
		add(this.name_JTextField = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 1, 1, 1, "FILL, CENTER"));
		return this;
	}

	public STProjectForm setRoot(JLabel component) {
		if (component == null) return this;
		add(this.root_JLabel = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 2, 1, 1, "CENTER, CENTER"));
		return this;
	}

	public STProjectForm setRoot(JTextField component) {
		if (component == null) return this;
		add(this.root_JTextField = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 2, 1, 1, "FILL, CENTER"));
		return this;
	}

	public STProjectForm setValues(JLabel component) {
		if (component == null) return this;
		add(this.Values_JLabel = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 3, 1, 1, "CENTER, CENTER"));
		return this;
	}

	public STProjectForm setNull(JTextArea component) {
		if (component == null) return this;
		add(this.null_JTextArea = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 3, 1, 2, "DEFAULT, FILL"));
		return this;
	}


	public void setModel(nextgen.model.STProject model) {
		setName(newJLabel("Name")); 
		setName(newJTextField(model.getName())); 
		setRoot(newJLabel("Root")); 
		setRoot(newJTextField(model.getRoot())); 
		setValues(newJLabel("Values")); 
		setNull(newJTextArea());
	}

	/*

	 columns 	2	"center:max(50dlu;pref):none, fill:pref:grow"

	 rows 		4 	"center:30:none, center:30:none, center:30:none, center:pref:grow"

	 col 2 1 CENTER max(50dlu;pref) none
	 col 3 1 FILL pref grow
	 row 1 2 CENTER 30 none
	 row 1 3 CENTER 30 none
	 row 1 4 CENTER 30 none
	 row 1 5 CENTER pref grow
	 cell 2 2 1 1 CENTER CENTER Label name
	 cell 3 2 1 1 FILL CENTER TextField name
	 cell 2 3 1 1 CENTER CENTER Label root
	 cell 3 3 1 1 FILL CENTER TextField root
	 cell 2 4 1 1 CENTER CENTER Label Values
	 cell 3 4 2 1 DEFAULT FILL TextArea null
	 cell 2 5 1 1 CENTER CENTER NONE null
	 cell 3 5 1 1 CENTER CENTER NONE null

	*/	
}