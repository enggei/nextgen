package nextgen.model.domain.swing;

import javax.swing.*;

public class DomainForm extends JPanel {

	JLabel name_JLabel;
	JTextField name_JTextField;
	JLabel properties_JLabel;
	JComponent properties_JComponent;
	JLabel roots_JLabel;
	JComponent roots_JComponent;

	public DomainForm() {
		setLayout(new com.jgoodies.forms.layout.FormLayout("fill:pref:none, fill:pref:grow", "top:pref:none, top:pref:none, top:pref:none"));
	}

	public DomainForm setName(JLabel component) {
		if (component == null) return this;
		add(this.name_JLabel = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 1, 1, 1, "CENTER, DEFAULT"));
		return this;
	}

	public DomainForm setName(JTextField component) {
		if (component == null) return this;
		add(this.name_JTextField = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 1, 1, 1, "LEFT, CENTER"));
		return this;
	}

	public DomainForm setProperties(JLabel component) {
		if (component == null) return this;
		add(this.properties_JLabel = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 2, 1, 1, "CENTER, DEFAULT"));
		return this;
	}

	public DomainForm setProperties(JComponent component) {
		if (component == null) return this;
		add(this.properties_JComponent = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 2, 1, 1, "LEFT, CENTER"));
		return this;
	}

	public DomainForm setRoots(JLabel component) {
		if (component == null) return this;
		add(this.roots_JLabel = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 3, 1, 1, "CENTER, DEFAULT"));
		return this;
	}

	public DomainForm setRoots(JComponent component) {
		if (component == null) return this;
		add(this.roots_JComponent = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 3, 1, 1, "LEFT, CENTER"));
		return this;
	}



	/*

	 columns 	2	"fill:pref:none, fill:pref:grow"

	 rows 		3 	"top:pref:none, top:pref:none, top:pref:none"

	 col 2 1 FILL pref none
	 col 3 1 FILL pref grow
	 row 1 2 TOP pref none
	 row 1 3 TOP pref none
	 row 1 4 TOP pref none
	 cell 2 2 1 1 CENTER DEFAULT Label name
	 cell 3 2 1 1 LEFT CENTER TextField name
	 cell 2 3 1 1 CENTER DEFAULT Label properties
	 cell 3 3 1 1 LEFT CENTER Component properties
	 cell 2 4 1 1 CENTER DEFAULT Label roots
	 cell 3 4 1 1 LEFT CENTER Component roots

	*/	
}