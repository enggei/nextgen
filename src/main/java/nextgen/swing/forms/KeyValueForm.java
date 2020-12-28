package nextgen.swing.forms;

import javax.swing.*;

public class KeyValueForm extends JPanel {

	JLabel lblkey;
	JComponent compvalue;

	public KeyValueForm() {
		setLayout(new com.jgoodies.forms.layout.FormLayout("fill:120:none, left:75:grow", "top:pref:grow"));
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

	 columns 	2	"fill:120:none, left:75:grow"

	 rows 		1 	"top:pref:grow"

	 col 2 1 FILL 120 none
	 col 3 1 LEFT 75 grow
	 row 1 2 TOP pref grow
	 cell 2 2 1 1 FILL TOP Label key
	 cell 3 2 1 1 FILL TOP Component value

	*/	
}