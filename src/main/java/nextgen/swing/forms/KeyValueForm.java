package nextgen.swing.forms;

import javax.swing.*;

public class KeyValueForm extends JPanel {

	JLabel lblkey;
	JComponent compvalue;

	public KeyValueForm() {
		setLayout(new com.jgoodies.forms.layout.FormLayout("center:75:none, center:75:none, fill:pref:grow, left:pref:none", "top:pref:none"));
	}

	public KeyValueForm setLblkey(JLabel component) {
		add(this.lblkey = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 1, 1, 1, "FILL, TOP"));
		return this;
	}

	public KeyValueForm setCompvalue(JComponent component) {
		add(this.compvalue = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 1, 1, 1, "FILL, TOP"));
		return this;
	}



	/*

	 columns 	4	"center:75:none, center:75:none, fill:pref:grow, left:pref:none"

	 rows 		1 	"top:pref:none"

	 col 1 1 CENTER 75 none
	 col 2 1 CENTER 75 none
	 col 3 1 FILL pref grow
	 col 5 1 LEFT pref none
	 row 1 2 TOP pref none
	 cell 2 2 1 1 FILL TOP Label key
	 cell 3 2 1 1 FILL TOP Component value
	 cell 5 2 1 1 CENTER CENTER NONE null

	*/	
}