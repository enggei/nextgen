package nextgen.swing.forms;

import javax.swing.*;

import static nextgen.swing.ComponentFactory.*;

public class DomainVisitorForm extends JPanel {

	JLabel onDomain_JLabel;
	JLabel onEntity_JLabel;
	JLabel onRelation_JLabel;
	JLabel onComplete_JLabel;
	JScrollPane onDomain_JScrollPane;
	JScrollPane onEntity_JScrollPane;
	JScrollPane onRelation_JScrollPane;
	JScrollPane onComplete_JScrollPane;
	JLabel templates_JLabel;
	JScrollPane templates_JScrollPane;

	public DomainVisitorForm() {
		setLayout(new com.jgoodies.forms.layout.FormLayout("center:pref:none, center:pref:grow", "center:pref:grow(.1), center:pref:grow(.2), center:pref:grow(.5), center:pref:grow(.1), center:pref:none"));
	}

	public <T extends JLabel> T getOnDomainJLabel() {
		return (T) onDomain_JLabel;
	}

	public <T extends JLabel> T getOnDomainJLabel(java.util.function.Supplier<T> supplier) {
		if (this.onDomain_JLabel == null) setOnDomain(supplier.get());
   	return (T) this.onDomain_JLabel;
	}

	public DomainVisitorForm setOnDomain(JLabel component) {
		if (component == null) return this;
		add(this.onDomain_JLabel = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 1, 1, 1, "LEFT, TOP"));
		return this;
	}

	public <T extends JLabel> T getOnEntityJLabel() {
		return (T) onEntity_JLabel;
	}

	public <T extends JLabel> T getOnEntityJLabel(java.util.function.Supplier<T> supplier) {
		if (this.onEntity_JLabel == null) setOnEntity(supplier.get());
   	return (T) this.onEntity_JLabel;
	}

	public DomainVisitorForm setOnEntity(JLabel component) {
		if (component == null) return this;
		add(this.onEntity_JLabel = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 2, 1, 1, "LEFT, TOP"));
		return this;
	}

	public <T extends JLabel> T getOnRelationJLabel() {
		return (T) onRelation_JLabel;
	}

	public <T extends JLabel> T getOnRelationJLabel(java.util.function.Supplier<T> supplier) {
		if (this.onRelation_JLabel == null) setOnRelation(supplier.get());
   	return (T) this.onRelation_JLabel;
	}

	public DomainVisitorForm setOnRelation(JLabel component) {
		if (component == null) return this;
		add(this.onRelation_JLabel = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 3, 1, 1, "LEFT, TOP"));
		return this;
	}

	public <T extends JLabel> T getOnCompleteJLabel() {
		return (T) onComplete_JLabel;
	}

	public <T extends JLabel> T getOnCompleteJLabel(java.util.function.Supplier<T> supplier) {
		if (this.onComplete_JLabel == null) setOnComplete(supplier.get());
   	return (T) this.onComplete_JLabel;
	}

	public DomainVisitorForm setOnComplete(JLabel component) {
		if (component == null) return this;
		add(this.onComplete_JLabel = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 4, 1, 1, "LEFT, TOP"));
		return this;
	}

	public <T extends JScrollPane> T getOnDomainJScrollPane() {
		return (T) onDomain_JScrollPane;
	}

	public <T extends JScrollPane> T getOnDomainJScrollPane(java.util.function.Supplier<T> supplier) {
		if (this.onDomain_JScrollPane == null) setOnDomain(supplier.get());
   	return (T) this.onDomain_JScrollPane;
	}

	public DomainVisitorForm setOnDomain(JScrollPane component) {
		if (component == null) return this;
		add(this.onDomain_JScrollPane = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 1, 1, 1, "FILL, FILL"));
		return this;
	}

	public <T extends JScrollPane> T getOnEntityJScrollPane() {
		return (T) onEntity_JScrollPane;
	}

	public <T extends JScrollPane> T getOnEntityJScrollPane(java.util.function.Supplier<T> supplier) {
		if (this.onEntity_JScrollPane == null) setOnEntity(supplier.get());
   	return (T) this.onEntity_JScrollPane;
	}

	public DomainVisitorForm setOnEntity(JScrollPane component) {
		if (component == null) return this;
		add(this.onEntity_JScrollPane = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 2, 1, 1, "FILL, FILL"));
		return this;
	}

	public <T extends JScrollPane> T getOnRelationJScrollPane() {
		return (T) onRelation_JScrollPane;
	}

	public <T extends JScrollPane> T getOnRelationJScrollPane(java.util.function.Supplier<T> supplier) {
		if (this.onRelation_JScrollPane == null) setOnRelation(supplier.get());
   	return (T) this.onRelation_JScrollPane;
	}

	public DomainVisitorForm setOnRelation(JScrollPane component) {
		if (component == null) return this;
		add(this.onRelation_JScrollPane = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 3, 1, 1, "FILL, FILL"));
		return this;
	}

	public <T extends JScrollPane> T getOnCompleteJScrollPane() {
		return (T) onComplete_JScrollPane;
	}

	public <T extends JScrollPane> T getOnCompleteJScrollPane(java.util.function.Supplier<T> supplier) {
		if (this.onComplete_JScrollPane == null) setOnComplete(supplier.get());
   	return (T) this.onComplete_JScrollPane;
	}

	public DomainVisitorForm setOnComplete(JScrollPane component) {
		if (component == null) return this;
		add(this.onComplete_JScrollPane = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 4, 1, 1, "FILL, FILL"));
		return this;
	}

	public <T extends JLabel> T getTemplatesJLabel() {
		return (T) templates_JLabel;
	}

	public <T extends JLabel> T getTemplatesJLabel(java.util.function.Supplier<T> supplier) {
		if (this.templates_JLabel == null) setTemplates(supplier.get());
   	return (T) this.templates_JLabel;
	}

	public DomainVisitorForm setTemplates(JLabel component) {
		if (component == null) return this;
		add(this.templates_JLabel = component, new com.jgoodies.forms.layout.CellConstraints().xywh(1, 5, 1, 1, "LEFT, TOP"));
		return this;
	}

	public <T extends JScrollPane> T getTemplatesJScrollPane() {
		return (T) templates_JScrollPane;
	}

	public <T extends JScrollPane> T getTemplatesJScrollPane(java.util.function.Supplier<T> supplier) {
		if (this.templates_JScrollPane == null) setTemplates(supplier.get());
   	return (T) this.templates_JScrollPane;
	}

	public DomainVisitorForm setTemplates(JScrollPane component) {
		if (component == null) return this;
		add(this.templates_JScrollPane = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 5, 1, 1, "FILL, FILL"));
		return this;
	}


	public void setModel(nextgen.model.DomainVisitor model) {
		getOnDomainJLabel(() -> newJLabel("On Domain"));
		getOnDomainJScrollPane(() -> newRTextScrollPane(newRSyntaxTextArea())).getTextArea().setText(model.getOnDomain());

		getOnEntityJLabel(() -> newJLabel("On Entity"));
		getOnEntityJScrollPane(() -> newRTextScrollPane(newRSyntaxTextArea())).getTextArea().setText(model.getOnEntity());

		getOnRelationJLabel(() -> newJLabel("On Relation"));
		getOnRelationJScrollPane(() -> newRTextScrollPane(newRSyntaxTextArea())).getTextArea().setText(model.getOnRelation());

		getOnCompleteJLabel(() -> newJLabel("On Complete"));
		getOnCompleteJScrollPane(() -> newRTextScrollPane(newRSyntaxTextArea())).getTextArea().setText(model.getOnComplete());

		final StringBuilder templates = new StringBuilder();
		model.getTemplates().sorted(java.util.Comparator.comparing(nextgen.model.STTemplate::getName)).forEach(s -> {
			templates.append(s.getUuid()).append(" ").append(s.getName()).append("\n");
			s.getParameters().sorted((p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName())).forEach(stParameter -> templates.append("\t").append(stParameter.getName()).append(" ").append(stParameter.getType().name()).append("\n"));
		});
		getTemplatesJLabel(() -> newJLabel("Templates"));
		getTemplatesJScrollPane(() -> newRTextScrollPane(newRSyntaxTextArea())).getTextArea().setText(templates.toString());
	}

	public void onSave(nextgen.model.DomainVisitor model) {
		model.setOnDomain(((org.fife.ui.rtextarea.RTextScrollPane) getOnDomainJScrollPane()).getTextArea().getText());
		model.setOnEntity(((org.fife.ui.rtextarea.RTextScrollPane) getOnEntityJScrollPane()).getTextArea().getText());
		model.setOnRelation(((org.fife.ui.rtextarea.RTextScrollPane) getOnRelationJScrollPane()).getTextArea().getText());
		model.setOnComplete(((org.fife.ui.rtextarea.RTextScrollPane) getOnCompleteJScrollPane()).getTextArea().getText());

		model.removeAllFields();
		org.fife.ui.rtextarea.RTextArea fields = ((org.fife.ui.rtextarea.RTextScrollPane) getTemplatesJScrollPane()).getTextArea();
		java.util.Arrays.stream(fields.getText().split("[\r\n]")).forEach(model::addFields);
	}

	/*

	 columns 	2	"center:pref:none, center:pref:grow"

	 rows 		5 	"center:pref:grow(.1), center:pref:grow(.2), center:pref:grow(.5), center:pref:grow(.1), center:pref:none"

	 col 2 1 CENTER pref none
	 col 3 1 CENTER pref grow
	 row 1 2 CENTER pref grow(.1)
	 row 1 3 CENTER pref grow(.2)
	 row 1 4 CENTER pref grow(.5)
	 row 1 5 CENTER pref grow(.1)
	 row 1 6 CENTER pref none
	 cell 2 2 1 1 LEFT TOP Label onDomain
	 cell 2 3 1 1 LEFT TOP Label onEntity
	 cell 2 4 1 1 LEFT TOP Label onRelation
	 cell 2 5 1 1 LEFT TOP Label onComplete
	 cell 3 2 1 1 FILL FILL ScrollPane onDomain
	 cell 3 3 1 1 FILL FILL ScrollPane onEntity
	 cell 3 4 1 1 FILL FILL ScrollPane onRelation
	 cell 3 5 1 1 FILL FILL ScrollPane onComplete
	 cell 2 6 1 1 LEFT TOP Label templates
	 cell 3 6 1 1 FILL FILL ScrollPane templates

	*/	
}