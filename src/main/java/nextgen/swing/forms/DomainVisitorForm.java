package nextgen.swing.forms;

import javax.swing.*;

import static nextgen.swing.ComponentFactory.*;

public class DomainVisitorForm extends JPanel {

	JLabel onDomain_JLabel;
	JLabel onEntity_JLabel;
	JLabel onRelation_JLabel;
	JLabel onComplete_JLabel;
	JComponent onDomain_JComponent;
	JComponent onEntity_JComponent;
	JComponent onRelation_JComponent;
	JComponent onComplete_JComponent;
	JLabel templates_JLabel;
	JComponent templates_JComponent;

	public DomainVisitorForm() {
		setLayout(new com.jgoodies.forms.layout.FormLayout("center:pref:none, center:pref:grow", "center:pref:grow(.3), center:pref:grow(.3), center:pref:grow(.3), center:pref:grow(.3), center:pref:grow(.5)"));
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

	public <T extends JComponent> T getOnDomainJComponent() {
		return (T) onDomain_JComponent;
	}

	public <T extends JComponent> T getOnDomainJComponent(java.util.function.Supplier<T> supplier) {
		if (this.onDomain_JComponent == null) setOnDomain(supplier.get());
   	return (T) this.onDomain_JComponent;
	}

	public DomainVisitorForm setOnDomain(JComponent component) {
		if (component == null) return this;
		add(this.onDomain_JComponent = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 1, 1, 1, "FILL, FILL"));
		return this;
	}

	public <T extends JComponent> T getOnEntityJComponent() {
		return (T) onEntity_JComponent;
	}

	public <T extends JComponent> T getOnEntityJComponent(java.util.function.Supplier<T> supplier) {
		if (this.onEntity_JComponent == null) setOnEntity(supplier.get());
   	return (T) this.onEntity_JComponent;
	}

	public DomainVisitorForm setOnEntity(JComponent component) {
		if (component == null) return this;
		add(this.onEntity_JComponent = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 2, 1, 1, "FILL, FILL"));
		return this;
	}

	public <T extends JComponent> T getOnRelationJComponent() {
		return (T) onRelation_JComponent;
	}

	public <T extends JComponent> T getOnRelationJComponent(java.util.function.Supplier<T> supplier) {
		if (this.onRelation_JComponent == null) setOnRelation(supplier.get());
   	return (T) this.onRelation_JComponent;
	}

	public DomainVisitorForm setOnRelation(JComponent component) {
		if (component == null) return this;
		add(this.onRelation_JComponent = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 3, 1, 1, "FILL, FILL"));
		return this;
	}

	public <T extends JComponent> T getOnCompleteJComponent() {
		return (T) onComplete_JComponent;
	}

	public <T extends JComponent> T getOnCompleteJComponent(java.util.function.Supplier<T> supplier) {
		if (this.onComplete_JComponent == null) setOnComplete(supplier.get());
   	return (T) this.onComplete_JComponent;
	}

	public DomainVisitorForm setOnComplete(JComponent component) {
		if (component == null) return this;
		add(this.onComplete_JComponent = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 4, 1, 1, "FILL, FILL"));
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

	public <T extends JComponent> T getTemplatesJComponent() {
		return (T) templates_JComponent;
	}

	public <T extends JComponent> T getTemplatesJComponent(java.util.function.Supplier<T> supplier) {
		if (this.templates_JComponent == null) setTemplates(supplier.get());
   	return (T) this.templates_JComponent;
	}

	public DomainVisitorForm setTemplates(JComponent component) {
		if (component == null) return this;
		add(this.templates_JComponent = component, new com.jgoodies.forms.layout.CellConstraints().xywh(2, 5, 1, 1, "FILL, FILL"));
		return this;
	}


	public void setModel(nextgen.model.DomainVisitor model) {
		final StringBuilder onDomain = new StringBuilder();
		model.getOnDomainSorted().forEach(s -> onDomain.append(s).append("\n"));
		getOnDomainJLabel(() -> newJLabel("On Domain"));
		getOnDomainJComponent(nextgen.swing.ComponentFactory::newRSyntaxTextArea).setText(onDomain.toString());

		final StringBuilder onEntity = new StringBuilder();
		model.getOnEntitySorted().forEach(s -> onEntity.append(s).append("\n"));
		getOnEntityJLabel(() -> newJLabel("On Entity"));
		getOnEntityJComponent(nextgen.swing.ComponentFactory::newRSyntaxTextArea).setText(onEntity.toString());

		final StringBuilder onRelation = new StringBuilder();
		model.getOnRelationSorted().forEach(s -> onRelation.append(s).append("\n"));
		getOnRelationJLabel(() -> newJLabel("On Relation"));
		getOnRelationJComponent(nextgen.swing.ComponentFactory::newRSyntaxTextArea).setText(onRelation.toString());

		final StringBuilder onComplete = new StringBuilder();
		model.getOnCompleteSorted().forEach(s -> onComplete.append(s).append("\n"));
		getOnCompleteJLabel(() -> newJLabel("On Complete"));
		getOnCompleteJComponent(nextgen.swing.ComponentFactory::newRSyntaxTextArea).setText(onComplete.toString());

		final StringBuilder templates = new StringBuilder();
		model.getTemplates().sorted(java.util.Comparator.comparing(nextgen.model.STTemplate::getName)).forEach(s -> templates.append(s.getUuid()).append(" ").append(s.getName()).append("\n"));
		getTemplatesJLabel(() -> newJLabel("Templates"));
		getTemplatesJComponent(nextgen.swing.ComponentFactory::newRSyntaxTextArea).setText(templates.toString());
	}

	public void onSave(nextgen.model.DomainVisitor model) {
		model.removeAllOnDomain();
		org.fife.ui.rsyntaxtextarea.RSyntaxTextArea onDomain = getOnDomainJComponent();
		java.util.Arrays.stream(onDomain.getText().split("[\r\n]")).forEach(model::addOnDomain);

		model.removeAllOnEntity();
		org.fife.ui.rsyntaxtextarea.RSyntaxTextArea onEntity = getOnEntityJComponent();
		java.util.Arrays.stream(onEntity.getText().split("[\r\n]")).forEach(model::addOnEntity);

		model.removeAllOnRelation();
		org.fife.ui.rsyntaxtextarea.RSyntaxTextArea onRelation = getOnRelationJComponent();
		java.util.Arrays.stream(onRelation.getText().split("[\r\n]")).forEach(model::addOnRelation);

		model.removeAllOnComplete();
		org.fife.ui.rsyntaxtextarea.RSyntaxTextArea onComplete = getOnCompleteJComponent();
		java.util.Arrays.stream(onComplete.getText().split("[\r\n]")).forEach(model::addOnComplete);

		model.removeAllFields();
		org.fife.ui.rsyntaxtextarea.RSyntaxTextArea fields = getTemplatesJComponent();
		java.util.Arrays.stream(fields.getText().split("[\r\n]")).forEach(model::addFields);
	}

	/*

	 columns 	2	"center:pref:none, center:pref:grow"

	 rows 		5 	"center:pref:grow(.3), center:pref:grow(.3), center:pref:grow(.3), center:pref:grow(.3), center:pref:grow(.5)"

	 col 2 1 CENTER pref none
	 col 3 1 CENTER pref grow
	 row 1 2 CENTER pref grow(.3)
	 row 1 3 CENTER pref grow(.3)
	 row 1 4 CENTER pref grow(.3)
	 row 1 5 CENTER pref grow(.3)
	 row 1 6 CENTER pref grow(.5)
	 cell 2 2 1 1 LEFT TOP Label onDomain
	 cell 2 3 1 1 LEFT TOP Label onEntity
	 cell 2 4 1 1 LEFT TOP Label onRelation
	 cell 2 5 1 1 LEFT TOP Label onComplete
	 cell 3 2 1 1 FILL FILL Component onDomain
	 cell 3 3 1 1 FILL FILL Component onEntity
	 cell 3 4 1 1 FILL FILL Component onRelation
	 cell 3 5 1 1 FILL FILL Component onComplete
	 cell 2 6 1 1 LEFT TOP Label templates
	 cell 3 6 1 1 FILL FILL Component templates

	*/	
}