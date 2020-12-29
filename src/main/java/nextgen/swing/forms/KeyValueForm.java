package nextgen.swing.forms;

import javax.swing.*;

public class KeyValueForm extends JPanel {

	JLabel lblkey;
	JComponent compvalue;

	public KeyValueForm() {
		setLayout(new com.jgoodies.forms.layout.FormLayout("left:120:none, left:75:grow", "top:pref:none, top:pref:grow"));
	}

	public KeyValueForm setLblkey(JLabel component) {
		if (component == null) return this;
		add(this.lblkey = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 1, 1, 1, "LEFT, CENTER"));
		return this;
	}

	public KeyValueForm setCompvalue(JComponent component) {
		if (component == null) return this;
		add(this.compvalue = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 1, 1, 2, "FILL, FILL"));
		return this;
	}



	/*

	 columns 	2	"left:120:none, left:75:grow"

	 rows 		2 	"top:pref:none, top:pref:grow"

	 col 2 1 LEFT 120 none
	 col 3 1 LEFT 75 grow
	 row 1 2 TOP pref none
	 row 1 3 TOP pref grow
	 cell 2 2 1 1 LEFT CENTER Label key
	 cell 3 2 2 1 FILL FILL Component value
	 cell 2 3 1 1 CENTER CENTER NONE null
	 cell 3 3 1 1 CENTER CENTER NONE null

	*/	
}