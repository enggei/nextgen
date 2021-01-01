package nextgen.model.domain.swing;

import javax.swing.*;

public class DomainPropertyForm extends JPanel {

	JLabel name_JLabel;
	JTextField name_JTextField;
	JLabel value_JLabel;
	JTextField value_JTextField;

	public DomainPropertyForm() {
		setLayout(new com.jgoodies.forms.layout.FormLayout("left:pref:none, left:pref:grow", "top:pref:none, top:pref:none"));
	}

	public DomainPropertyForm setName(JLabel component) {
		if (component == null) return this;
		add(this.name_JLabel = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 1, 1, 1, "CENTER, CENTER"));
		return this;
	}

	public DomainPropertyForm setName(JTextField component) {
		if (component == null) return this;
		add(this.name_JTextField = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 1, 1, 1, "FILL, CENTER"));
		return this;
	}

	public DomainPropertyForm setValue(JLabel component) {
		if (component == null) return this;
		add(this.value_JLabel = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 2, 1, 1, "CENTER, CENTER"));
		return this;
	}

	public DomainPropertyForm setValue(JTextField component) {
		if (component == null) return this;
		add(this.value_JTextField = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 2, 1, 1, "FILL, CENTER"));
		return this;
	}



	/*

	 columns 	2	"left:pref:none, left:pref:grow"

	 rows 		2 	"top:pref:none, top:pref:none"

	 col 2 1 LEFT pref none
	 col 3 1 LEFT pref grow
	 row 1 2 TOP pref none
	 row 1 3 TOP pref none
	 cell 2 2 1 1 CENTER CENTER Label name
	 cell 3 2 1 1 FILL CENTER TextField name
	 cell 2 3 1 1 CENTER CENTER Label value
	 cell 3 3 1 1 FILL CENTER TextField value

	*/	
}