package nextgen.swing.forms;

import javax.swing.*;

import static nextgen.swing.ComponentFactory.*;

public class DomainForm extends JPanel {

	JLabel name_JLabel;
	JTextField name_JTextField;
	JLabel entities_JLabel;
	JComponent entities_JComponent;
	JComponent values_JComponent;

	public DomainForm() {
		setLayout(new com.jgoodies.forms.layout.FormLayout("center:max(50dlu;pref):none, fill:pref:grow", "center:30:none, center:30:none, center:30:grow"));
	}

	public JLabel getNameJLabel() {
		return name_JLabel;
	}

	public DomainForm setName(JLabel component) {
		if (component == null) return this;
		add(this.name_JLabel = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 1, 1, 1, "CENTER, CENTER"));
		return this;
	}

	public JTextField getNameJTextField() {
		return name_JTextField;
	}

	public DomainForm setName(JTextField component) {
		if (component == null) return this;
		add(this.name_JTextField = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 1, 1, 1, "FILL, CENTER"));
		return this;
	}

	public JLabel getEntitiesJLabel() {
		return entities_JLabel;
	}

	public DomainForm setEntities(JLabel component) {
		if (component == null) return this;
		add(this.entities_JLabel = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 2, 1, 1, "CENTER, CENTER"));
		return this;
	}

	public JComponent getEntitiesJComponent() {
		return entities_JComponent;
	}

	public DomainForm setEntities(JComponent component) {
		if (component == null) return this;
		add(this.entities_JComponent = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 2, 1, 2, "FILL, FILL"));
		return this;
	}

	public JComponent getValuesJComponent() {
		return values_JComponent;
	}

	public DomainForm setValues(JComponent component) {
		if (component == null) return this;
		add(this.values_JComponent = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 3, 1, 2, "DEFAULT, FILL"));
		return this;
	}


	/*

	 columns 	2	"center:max(50dlu;pref):none, fill:pref:grow"

	 rows 		3 	"center:30:none, center:30:none, center:30:grow"

	 col 2 1 CENTER max(50dlu;pref) none
	 col 3 1 FILL pref grow
	 row 1 2 CENTER 30 none
	 row 1 3 CENTER 30 none
	 row 1 4 CENTER 30 grow
	 cell 2 2 1 1 CENTER CENTER Label name
	 cell 3 2 1 1 FILL CENTER TextField name
	 cell 2 3 1 1 CENTER CENTER Label entities
	 cell 3 3 2 1 FILL FILL Component entities
	 cell 2 4 1 1 CENTER CENTER NONE null
	 cell 3 4 2 1 DEFAULT FILL Component values

	*/	
}