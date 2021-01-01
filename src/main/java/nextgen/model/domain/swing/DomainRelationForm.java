package nextgen.model.domain.swing;

import javax.swing.*;

public class DomainRelationForm extends JPanel {

	JLabel name_JLabel;
	JTextField name_JTextField;
	JLabel properties_JLabel;
	JComponent properties_JComponent;
	JLabel entity_JLabel;
	JComponent entity_JComponent;

	public DomainRelationForm() {
		setLayout(new com.jgoodies.forms.layout.FormLayout("left:pref:none, left:pref:none", "top:pref:none, top:pref:none, top:pref:grow, top:pref:none, top:pref:grow"));
	}

	public DomainRelationForm setName(JLabel component) {
		if (component == null) return this;
		add(this.name_JLabel = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 1, 1, 1, "DEFAULT, DEFAULT"));
		return this;
	}

	public DomainRelationForm setName(JTextField component) {
		if (component == null) return this;
		add(this.name_JTextField = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 1, 1, 1, "FILL, CENTER"));
		return this;
	}

	public DomainRelationForm setProperties(JLabel component) {
		if (component == null) return this;
		add(this.properties_JLabel = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 2, 1, 1, "DEFAULT, DEFAULT"));
		return this;
	}

	public DomainRelationForm setProperties(JComponent component) {
		if (component == null) return this;
		add(this.properties_JComponent = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 2, 1, 2, "DEFAULT, DEFAULT"));
		return this;
	}

	public DomainRelationForm setEntity(JLabel component) {
		if (component == null) return this;
		add(this.entity_JLabel = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 4, 1, 1, "DEFAULT, DEFAULT"));
		return this;
	}

	public DomainRelationForm setEntity(JComponent component) {
		if (component == null) return this;
		add(this.entity_JComponent = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 4, 1, 2, "FILL, TOP"));
		return this;
	}



	/*

	 columns 	2	"left:pref:none, left:pref:none"

	 rows 		5 	"top:pref:none, top:pref:none, top:pref:grow, top:pref:none, top:pref:grow"

	 col 2 1 LEFT pref none
	 col 3 1 LEFT pref none
	 row 1 2 TOP pref none
	 row 1 3 TOP pref none
	 row 1 4 TOP pref grow
	 row 1 5 TOP pref none
	 row 1 6 TOP pref grow
	 cell 2 2 1 1 DEFAULT DEFAULT Label name
	 cell 3 2 1 1 FILL CENTER TextField name
	 cell 2 3 1 1 DEFAULT DEFAULT Label properties
	 cell 3 3 2 1 DEFAULT DEFAULT Component properties
	 cell 2 4 1 1 LEFT TOP NONE null
	 cell 3 4 1 1 CENTER CENTER NONE null
	 cell 2 5 1 1 DEFAULT DEFAULT Label entity
	 cell 3 5 2 1 FILL TOP Component entity
	 cell 2 6 1 1 CENTER CENTER NONE null
	 cell 3 6 1 1 CENTER CENTER NONE null

	*/	
}