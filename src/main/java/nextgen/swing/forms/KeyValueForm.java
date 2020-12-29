package nextgen.swing.forms;

import javax.swing.*;

public class KeyValueForm extends JPanel {

	JComponent compkey;
	JComponent compvalue;

	public KeyValueForm() {
		setLayout(new com.jgoodies.forms.layout.FormLayout("left:120:none, left:pref:grow", "top:pref:none, top:pref:grow"));
	}

	public KeyValueForm setCompkey(JComponent component) {
		if (component == null) return this;
		add(this.compkey = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 1, 1, 1, "LEFT, TOP"));
		return this;
	}

	public KeyValueForm setCompvalue(JComponent component) {
		if (component == null) return this;
		add(this.compvalue = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 1, 1, 2, "FILL, TOP"));
		return this;
	}



	/*

	 columns 	2	"left:120:none, left:pref:grow"

	 rows 		2 	"top:pref:none, top:pref:grow"

	 col 2 1 LEFT 120 none
	 col 3 1 LEFT pref grow
	 row 1 2 TOP pref none
	 row 1 3 TOP pref grow
	 cell 2 2 1 1 LEFT TOP Component key
	 cell 3 2 2 1 FILL TOP Component value
	 cell 2 3 1 1 CENTER CENTER NONE null
	 cell 3 3 1 1 CENTER CENTER NONE null

	*/	
}