package nextgen.swing.forms;

import javax.swing.*;

public class TextAreaCrudForm extends JPanel {

	JScrollPane scrtextArea;
	JButton btndelete;
	JButton btntoClipboard;
	JButton btnfromClipboard;

	public TextAreaCrudForm() {
		setLayout(new com.jgoodies.forms.layout.FormLayout("fill:75:grow, fill:75:none, fill:75:none, left:75:none", "top:pref:none, top:pref:none"));
	}

	public TextAreaCrudForm setScrtextArea(JScrollPane component) {
		if (component == null) return this;
		add(this.scrtextArea = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 1, 4, 1, "FILL, CENTER"));
		return this;
	}

	public TextAreaCrudForm setBtndelete(JButton component) {
		if (component == null) return this;
		add(this.btndelete = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 2, 1, 1, "FILL, FILL"));
		return this;
	}

	public TextAreaCrudForm setBtntoClipboard(JButton component) {
		if (component == null) return this;
		add(this.btntoClipboard = component, new com.jgoodies.forms.layout.CellConstraints().xywh(3, 2, 1, 1, "FILL, FILL"));
		return this;
	}

	public TextAreaCrudForm setBtnfromClipboard(JButton component) {
		if (component == null) return this;
		add(this.btnfromClipboard = component, new com.jgoodies.forms.layout.CellConstraints().xywh(4, 2, 1, 1, "FILL, FILL"));
		return this;
	}



	/*

	 columns 	4	"fill:75:grow, fill:75:none, fill:75:none, left:75:none"

	 rows 		2 	"top:pref:none, top:pref:none"

	 col 2 1 FILL 75 grow
	 col 3 1 FILL 75 none
	 col 4 1 FILL 75 none
	 col 5 1 LEFT 75 none
	 row 1 2 TOP pref none
	 row 1 3 TOP pref none
	 cell 2 2 1 4 FILL CENTER ScrollPane textArea
	 cell 2 3 1 1 FILL FILL NONE 
	 cell 3 2 1 1 CENTER CENTER NONE null
	 cell 3 3 1 1 FILL FILL Button delete
	 cell 4 2 1 1 CENTER CENTER NONE null
	 cell 4 3 1 1 FILL FILL Button toClipboard
	 cell 5 2 1 1 CENTER CENTER NONE null
	 cell 5 3 1 1 FILL FILL Button fromClipboard

	*/	
}