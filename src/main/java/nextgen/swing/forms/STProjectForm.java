package nextgen.swing.forms;

import javax.swing.*;

import static nextgen.swing.ComponentFactory.*;

public class STProjectForm extends JPanel {

	JLabel name_JLabel;
	JTextField name_JTextField;
	JLabel root_JLabel;
	JTextField root_JTextField;
	JLabel values_JLabel;
	JComponent values_JComponent;
	JLabel models_JLabel;
	JComponent models_JComponent;

	public STProjectForm() {
		setLayout(new com.jgoodies.forms.layout.FormLayout("center:max(50dlu;pref):none, fill:pref:grow", "center:30:none, center:30:none, center:30:none, center:max(50dlu;pref):none, center:30:none, center:pref:grow"));
	}

	public <T extends JLabel> T getNameJLabel() {
		return (T) name_JLabel;
	}

	public <T extends JLabel> T getNameJLabel(java.util.function.Supplier<T> supplier) {
		if (this.name_JLabel == null) setName(supplier.get());
   	return (T) this.name_JLabel;
	}

	public STProjectForm setName(JLabel component) {
		if (component == null) return this;
		add(this.name_JLabel = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 1, 1, 1, "CENTER, CENTER"));
		return this;
	}

	public <T extends JTextField> T getNameJTextField() {
		return (T) name_JTextField;
	}

	public <T extends JTextField> T getNameJTextField(java.util.function.Supplier<T> supplier) {
		if (this.name_JTextField == null) setName(supplier.get());
   	return (T) this.name_JTextField;
	}

	public STProjectForm setName(JTextField component) {
		if (component == null) return this;
		add(this.name_JTextField = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 1, 1, 1, "FILL, CENTER"));
		return this;
	}

	public <T extends JLabel> T getRootJLabel() {
		return (T) root_JLabel;
	}

	public <T extends JLabel> T getRootJLabel(java.util.function.Supplier<T> supplier) {
		if (this.root_JLabel == null) setRoot(supplier.get());
   	return (T) this.root_JLabel;
	}

	public STProjectForm setRoot(JLabel component) {
		if (component == null) return this;
		add(this.root_JLabel = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 2, 1, 1, "CENTER, CENTER"));
		return this;
	}

	public <T extends JTextField> T getRootJTextField() {
		return (T) root_JTextField;
	}

	public <T extends JTextField> T getRootJTextField(java.util.function.Supplier<T> supplier) {
		if (this.root_JTextField == null) setRoot(supplier.get());
   	return (T) this.root_JTextField;
	}

	public STProjectForm setRoot(JTextField component) {
		if (component == null) return this;
		add(this.root_JTextField = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 2, 1, 1, "FILL, CENTER"));
		return this;
	}

	public <T extends JLabel> T getValuesJLabel() {
		return (T) values_JLabel;
	}

	public <T extends JLabel> T getValuesJLabel(java.util.function.Supplier<T> supplier) {
		if (this.values_JLabel == null) setValues(supplier.get());
   	return (T) this.values_JLabel;
	}

	public STProjectForm setValues(JLabel component) {
		if (component == null) return this;
		add(this.values_JLabel = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 3, 1, 1, "CENTER, CENTER"));
		return this;
	}

	public <T extends JComponent> T getValuesJComponent() {
		return (T) values_JComponent;
	}

	public <T extends JComponent> T getValuesJComponent(java.util.function.Supplier<T> supplier) {
		if (this.values_JComponent == null) setValues(supplier.get());
   	return (T) this.values_JComponent;
	}

	public STProjectForm setValues(JComponent component) {
		if (component == null) return this;
		add(this.values_JComponent = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 3, 1, 2, "DEFAULT, FILL"));
		return this;
	}

	public <T extends JLabel> T getModelsJLabel() {
		return (T) models_JLabel;
	}

	public <T extends JLabel> T getModelsJLabel(java.util.function.Supplier<T> supplier) {
		if (this.models_JLabel == null) setModels(supplier.get());
   	return (T) this.models_JLabel;
	}

	public STProjectForm setModels(JLabel component) {
		if (component == null) return this;
		add(this.models_JLabel = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 5, 1, 1, "CENTER, CENTER"));
		return this;
	}

	public <T extends JComponent> T getModelsJComponent() {
		return (T) models_JComponent;
	}

	public <T extends JComponent> T getModelsJComponent(java.util.function.Supplier<T> supplier) {
		if (this.models_JComponent == null) setModels(supplier.get());
   	return (T) this.models_JComponent;
	}

	public STProjectForm setModels(JComponent component) {
		if (component == null) return this;
		add(this.models_JComponent = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 5, 1, 2, "DEFAULT, FILL"));
		return this;
	}


	public void setModel(nextgen.model.STProject model) {
		setName(newJLabel("Name")); 
		setName(newJTextField(model.getName())); 
		setRoot(newJLabel("Root")); 
		setRoot(newJTextField(model.getRoot())); 
		setValues(newJLabel("Values")); 
		setValues(newJScrollPane(new nextgen.swing.table.STValueTable().setSelectionListener(nextgen.events.STValueSelected::post).setContent(model.getValues().sorted((v1,v2) -> v1.getValue("").compareToIgnoreCase(v2.getValue(""))))));
		setModels(newJLabel("Models")); 
		setModels(newJScrollPane(new nextgen.swing.table.STModelTable().setSelectionListener(nextgen.events.STModelSelected::post).setContent(model.getModels().sorted(nextgen.swing.STAppPresentationModel.grouptemplateNameComparator()))));
	}

	public void onSave(nextgen.model.STProject model) {
		model.setName(getNameJTextField().getText().trim());
		model.setRoot(getRootJTextField().getText().trim());
	}

	/*

	 columns 	2	"center:max(50dlu;pref):none, fill:pref:grow"

	 rows 		6 	"center:30:none, center:30:none, center:30:none, center:max(50dlu;pref):none, center:30:none, center:pref:grow"

	 col 2 1 CENTER max(50dlu;pref) none
	 col 3 1 FILL pref grow
	 row 1 2 CENTER 30 none
	 row 1 3 CENTER 30 none
	 row 1 4 CENTER 30 none
	 row 1 5 CENTER max(50dlu;pref) none
	 row 1 6 CENTER 30 none
	 row 1 7 CENTER pref grow
	 cell 2 2 1 1 CENTER CENTER Label name
	 cell 3 2 1 1 FILL CENTER TextField name
	 cell 2 3 1 1 CENTER CENTER Label root
	 cell 3 3 1 1 FILL CENTER TextField root
	 cell 2 4 1 1 CENTER CENTER Label values
	 cell 3 4 2 1 DEFAULT FILL Component values
	 cell 2 5 1 1 CENTER CENTER NONE null
	 cell 3 5 1 1 CENTER CENTER NONE null
	 cell 2 6 1 1 CENTER CENTER Label models
	 cell 3 6 2 1 DEFAULT FILL Component models
	 cell 2 7 1 1 CENTER CENTER NONE null
	 cell 3 7 1 1 CENTER CENTER NONE null

	*/	
}