package nextgen.swing.forms;

import javax.swing.*;

public class ButtonFormRight extends JPanel {

	JButton btnone;
	JButton btntwo;
	JButton btnthree;

	public ButtonFormRight() {
		setLayout(new com.jgoodies.forms.layout.FormLayout("fill:pref:grow, fill:75:none, fill:75:none, fill:75:none", "top:pref:none"));
	}

	public ButtonFormRight setBtnone(JButton component) {
		if (component == null) return this;
		add(this.btnone = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 1, 1, 1, "FILL, CENTER"));
		return this;
	}

	public ButtonFormRight setBtntwo(JButton component) {
		if (component == null) return this;
		add(this.btntwo = component, new com.jgoodies.forms.layout.CellConstraints().xywh(3, 1, 1, 1, "FILL, CENTER"));
		return this;
	}

	public ButtonFormRight setBtnthree(JButton component) {
		if (component == null) return this;
		add(this.btnthree = component, new com.jgoodies.forms.layout.CellConstraints().xywh(4, 1, 1, 1, "FILL, CENTER"));
		return this;
	}



	/*

	 columns 	4	"fill:pref:grow, fill:75:none, fill:75:none, fill:75:none"

	 rows 		1 	"top:pref:none"

	 col 2 1 FILL pref grow
	 col 3 1 FILL 75 none
	 col 4 1 FILL 75 none
	 col 5 1 FILL 75 none
	 row 1 2 TOP pref none
	 cell 2 2 1 1 FILL FILL NONE value
	 cell 3 2 1 1 FILL CENTER Button one
	 cell 4 2 1 1 FILL CENTER Button two
	 cell 5 2 1 1 FILL CENTER Button three

	*/	
}