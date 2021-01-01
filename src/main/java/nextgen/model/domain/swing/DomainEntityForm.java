package nextgen.model.domain.swing;

import javax.swing.*;

public class DomainEntityForm extends JPanel {

	JLabel name_JLabel;
	JTextField name_JTextField;
	JLabel properties_JLabel;
	JComponent properties_JComponent;
	JLabel relations_JLabel;
	JComponent relations_JComponent;

	public DomainEntityForm() {
		setLayout(new com.jgoodies.forms.layout.FormLayout("fill:pref:none, fill:pref:grow", "fill:pref:none, top:pref:none, top:pref:grow"));
	}

	public DomainEntityForm setName(JLabel component) {
		if (component == null) return this;
		add(this.name_JLabel = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 1, 1, 1, "DEFAULT, DEFAULT"));
		return this;
	}

	public DomainEntityForm setName(JTextField component) {
		if (component == null) return this;
		add(this.name_JTextField = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 1, 1, 1, "CENTER, DEFAULT"));
		return this;
	}

	public DomainEntityForm setProperties(JLabel component) {
		if (component == null) return this;
		add(this.properties_JLabel = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 2, 1, 1, "DEFAULT, DEFAULT"));
		return this;
	}

	public DomainEntityForm setProperties(JComponent component) {
		if (component == null) return this;
		add(this.properties_JComponent = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 2, 1, 1, "CENTER, DEFAULT"));
		return this;
	}

	public DomainEntityForm setRelations(JLabel component) {
		if (component == null) return this;
		add(this.relations_JLabel = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 3, 1, 1, "DEFAULT, DEFAULT"));
		return this;
	}

	public DomainEntityForm setRelations(JComponent component) {
		if (component == null) return this;
		add(this.relations_JComponent = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 3, 1, 1, "CENTER, CENTER"));
		return this;
	}



	/*

	 columns 	2	"fill:pref:none, fill:pref:grow"

	 rows 		3 	"fill:pref:none, top:pref:none, top:pref:grow"

	 col 2 1 FILL pref none
	 col 3 1 FILL pref grow
	 row 1 2 FILL pref none
	 row 1 3 TOP pref none
	 row 1 4 TOP pref grow
	 cell 2 2 1 1 DEFAULT DEFAULT Label name
	 cell 3 2 1 1 CENTER DEFAULT TextField name
	 cell 2 3 1 1 DEFAULT DEFAULT Label properties
	 cell 3 3 1 1 CENTER DEFAULT Component properties
	 cell 2 4 1 1 DEFAULT DEFAULT Label relations
	 cell 3 4 1 1 CENTER CENTER Component relations

	*/	
}