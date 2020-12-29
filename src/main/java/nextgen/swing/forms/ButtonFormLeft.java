package nextgen.swing.forms;

import javax.swing.*;

public class ButtonFormLeft extends JPanel {

	JButton btnone;
	JButton btntwo;
	JButton btnthree;

	public ButtonFormLeft() {
		setLayout(new com.jgoodies.forms.layout.FormLayout("left:pref:none, left:pref:none, left:pref:none", "center:pref:none"));
	}

	public ButtonFormLeft setBtnone(JButton component) {
		if (component == null) return this;
		add(this.btnone = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 1, 1, 1, "LEFT, CENTER"));
		return this;
	}

	public ButtonFormLeft setBtntwo(JButton component) {
		if (component == null) return this;
		add(this.btntwo = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 1, 1, 1, "LEFT, CENTER"));
		return this;
	}

	public ButtonFormLeft setBtnthree(JButton component) {
		if (component == null) return this;
		add(this.btnthree = component, new com.jgoodies.forms.layout.CellConstraints().xywh(3, 1, 1, 1, "LEFT, CENTER"));
		return this;
	}



	/*

	 columns 	3	"left:pref:none, left:pref:none, left:pref:none"

	 rows 		1 	"center:pref:none"

	 col 2 1 LEFT pref none
	 col 3 1 LEFT pref none
	 col 4 1 LEFT pref none
	 row 1 2 CENTER pref none
	 cell 2 2 1 1 LEFT CENTER Button one
	 cell 3 2 1 1 LEFT CENTER Button two
	 cell 4 2 1 1 LEFT CENTER Button three

	*/	
}