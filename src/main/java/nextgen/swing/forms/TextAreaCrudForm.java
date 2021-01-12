package nextgen.swing.forms;

import javax.swing.*;

import static nextgen.swing.ComponentFactory.*;

public class TextAreaCrudForm extends JPanel {

	JScrollPane textArea_JScrollPane;
	JButton delete_JButton;
	JButton toClipboard_JButton;
	JButton fromClipboard_JButton;

	public TextAreaCrudForm() {
		setLayout(new com.jgoodies.forms.layout.FormLayout("fill:75:grow, fill:75:none, fill:75:none, left:75:none", "top:pref:grow, top:pref:none"));
	}

	public <T extends JScrollPane> T getTextAreaJScrollPane() {
		return (T) textArea_JScrollPane;
	}

	public <T extends JScrollPane> T getTextAreaJScrollPane(java.util.function.Supplier<T> supplier) {
		if (this.textArea_JScrollPane == null) setTextArea(supplier.get());
   	return (T) this.textArea_JScrollPane;
	}

	public TextAreaCrudForm setTextArea(JScrollPane component) {
		if (component == null) return this;
		add(this.textArea_JScrollPane = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 1, 4, 1, "FILL, FILL"));
		return this;
	}

	public <T extends JButton> T getDeleteJButton() {
		return (T) delete_JButton;
	}

	public <T extends JButton> T getDeleteJButton(java.util.function.Supplier<T> supplier) {
		if (this.delete_JButton == null) setDelete(supplier.get());
   	return (T) this.delete_JButton;
	}

	public TextAreaCrudForm setDelete(JButton component) {
		if (component == null) return this;
		add(this.delete_JButton = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 2, 1, 1, "FILL, FILL"));
		return this;
	}

	public <T extends JButton> T getToClipboardJButton() {
		return (T) toClipboard_JButton;
	}

	public <T extends JButton> T getToClipboardJButton(java.util.function.Supplier<T> supplier) {
		if (this.toClipboard_JButton == null) setToClipboard(supplier.get());
   	return (T) this.toClipboard_JButton;
	}

	public TextAreaCrudForm setToClipboard(JButton component) {
		if (component == null) return this;
		add(this.toClipboard_JButton = component, new com.jgoodies.forms.layout.CellConstraints().xywh(3, 2, 1, 1, "FILL, FILL"));
		return this;
	}

	public <T extends JButton> T getFromClipboardJButton() {
		return (T) fromClipboard_JButton;
	}

	public <T extends JButton> T getFromClipboardJButton(java.util.function.Supplier<T> supplier) {
		if (this.fromClipboard_JButton == null) setFromClipboard(supplier.get());
   	return (T) this.fromClipboard_JButton;
	}

	public TextAreaCrudForm setFromClipboard(JButton component) {
		if (component == null) return this;
		add(this.fromClipboard_JButton = component, new com.jgoodies.forms.layout.CellConstraints().xywh(4, 2, 1, 1, "FILL, FILL"));
		return this;
	}


	public void setModel(nextgen.model.STValue model) {
		final org.fife.ui.rtextarea.RTextArea textArea = getTextAreaJScrollPane(() -> newRTextScrollPane(newRSyntaxTextArea())).getTextArea();
		textArea.setText(model.getValue());
		textArea.setEditable(model.getType().equals(nextgen.model.STValueType.PRIMITIVE));
	}

	public void onSave(nextgen.model.STValue model) {
		model.setValue(((org.fife.ui.rtextarea.RTextScrollPane) getTextAreaJScrollPane()).getTextArea().getText());
	}

	/*

	 columns 	4	"fill:75:grow, fill:75:none, fill:75:none, left:75:none"

	 rows 		2 	"top:pref:grow, top:pref:none"

	 col 2 1 FILL 75 grow
	 col 3 1 FILL 75 none
	 col 4 1 FILL 75 none
	 col 5 1 LEFT 75 none
	 row 1 2 TOP pref grow
	 row 1 3 TOP pref none
	 cell 2 2 1 4 FILL FILL ScrollPane textArea
	 cell 2 3 1 1 FILL FILL NONE null
	 cell 3 2 1 1 CENTER CENTER NONE null
	 cell 3 3 1 1 FILL FILL Button delete
	 cell 4 2 1 1 CENTER CENTER NONE null
	 cell 4 3 1 1 FILL FILL Button toClipboard
	 cell 5 2 1 1 CENTER CENTER NONE null
	 cell 5 3 1 1 FILL FILL Button fromClipboard

	*/	
}