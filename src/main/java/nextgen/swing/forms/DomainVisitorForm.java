package nextgen.swing.forms;

import javax.swing.*;

import com.jgoodies.binding.adapter.Bindings;
import com.jgoodies.binding.value.AbstractValueModel;
import com.jgoodies.binding.value.ValueModel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.CellConstraints;

import nextgen.swing.ComponentFactory;
import static nextgen.swing.ComponentFactory.*;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

public class DomainVisitorForm extends JPanel {

	nextgen.model.DomainVisitor model;
	JLabel name_JLabel = newJLabel("name");
	JTextField name_JTextField = newJTextField("name");
	JLabel onDomain_JLabel = newJLabel("onDomain");
	RSyntaxTextArea onDomain_RSyntaxTextArea = newRSyntaxTextArea("onDomain");
	JLabel onEntity_JLabel = newJLabel("onEntity");
	RSyntaxTextArea onEntity_RSyntaxTextArea = newRSyntaxTextArea("onEntity");
	JLabel onRelation_JLabel = newJLabel("onRelation");
	RSyntaxTextArea onRelation_RSyntaxTextArea = newRSyntaxTextArea("onRelation");
	JLabel onComplete_JLabel = newJLabel("onComplete");
	RSyntaxTextArea onComplete_RSyntaxTextArea = newRSyntaxTextArea("onComplete");
	JLabel onEntityEntity_JLabel = newJLabel("onEntityEntity");
	RSyntaxTextArea onEntityEntity_RSyntaxTextArea = newRSyntaxTextArea("onEntityEntity");
	JLabel onEnumEntity_JLabel = newJLabel("onEnumEntity");
	RSyntaxTextArea onEnumEntity_RSyntaxTextArea = newRSyntaxTextArea("onEnumEntity");
	JLabel onPrimitiveEntity_JLabel = newJLabel("onPrimitiveEntity");
	RSyntaxTextArea onPrimitiveEntity_RSyntaxTextArea = newRSyntaxTextArea("onPrimitiveEntity");
	JLabel onOneEntityRelation_JLabel = newJLabel("onOneEntityRelation");
	RSyntaxTextArea onOneEntityRelation_RSyntaxTextArea = newRSyntaxTextArea("onOneEntityRelation");
	JLabel onOneEnumRelation_JLabel = newJLabel("onOneEnumRelation");
	RSyntaxTextArea onOneEnumRelation_RSyntaxTextArea = newRSyntaxTextArea("onOneEnumRelation");
	JLabel onOnePrimitiveRelation_JLabel = newJLabel("onOnePrimitiveRelation");
	RSyntaxTextArea onOnePrimitiveRelation_RSyntaxTextArea = newRSyntaxTextArea("onOnePrimitiveRelation");
	JLabel onManyEntityRelation_JLabel = newJLabel("onManyEntityRelation");
	RSyntaxTextArea onManyEntityRelation_RSyntaxTextArea = newRSyntaxTextArea("onManyEntityRelation");
	JLabel onManyEnumRelation_JLabel = newJLabel("onManyEnumRelation");
	RSyntaxTextArea onManyEnumRelation_RSyntaxTextArea = newRSyntaxTextArea("onManyEnumRelation");
	JLabel onManyPrimitiveRelation_JLabel = newJLabel("onManyPrimitiveRelation");
	RSyntaxTextArea onManyPrimitiveRelation_RSyntaxTextArea = newRSyntaxTextArea("onManyPrimitiveRelation");
	JLabel onOptionalEntityRelation_JLabel = newJLabel("onOptionalEntityRelation");
	RSyntaxTextArea onOptionalEntityRelation_RSyntaxTextArea = newRSyntaxTextArea("onOptionalEntityRelation");
	JLabel onOptionalEnumRelation_JLabel = newJLabel("onOptionalEnumRelation");
	RSyntaxTextArea onOptionalEnumRelation_RSyntaxTextArea = newRSyntaxTextArea("onOptionalEnumRelation");
	JLabel onOptionalPrimitiveRelation_JLabel = newJLabel("onOptionalPrimitiveRelation");
	RSyntaxTextArea onOptionalPrimitiveRelation_RSyntaxTextArea = newRSyntaxTextArea("onOptionalPrimitiveRelation");
	JTextFieldModel nameModel = new JTextFieldModel(getNameJTextField());
	RSyntaxTextAreaModel onDomainModel = new RSyntaxTextAreaModel(getOnDomainRSyntaxTextArea());
	RSyntaxTextAreaModel onEntityModel = new RSyntaxTextAreaModel(getOnEntityRSyntaxTextArea());
	RSyntaxTextAreaModel onRelationModel = new RSyntaxTextAreaModel(getOnRelationRSyntaxTextArea());
	RSyntaxTextAreaModel onCompleteModel = new RSyntaxTextAreaModel(getOnCompleteRSyntaxTextArea());
	RSyntaxTextAreaModel onEntityEntityModel = new RSyntaxTextAreaModel(getOnEntityEntityRSyntaxTextArea());
	RSyntaxTextAreaModel onEnumEntityModel = new RSyntaxTextAreaModel(getOnEnumEntityRSyntaxTextArea());
	RSyntaxTextAreaModel onPrimitiveEntityModel = new RSyntaxTextAreaModel(getOnPrimitiveEntityRSyntaxTextArea());
	RSyntaxTextAreaModel onOneEntityRelationModel = new RSyntaxTextAreaModel(getOnOneEntityRelationRSyntaxTextArea());
	RSyntaxTextAreaModel onOneEnumRelationModel = new RSyntaxTextAreaModel(getOnOneEnumRelationRSyntaxTextArea());
	RSyntaxTextAreaModel onOnePrimitiveRelationModel = new RSyntaxTextAreaModel(getOnOnePrimitiveRelationRSyntaxTextArea());
	RSyntaxTextAreaModel onManyEntityRelationModel = new RSyntaxTextAreaModel(getOnManyEntityRelationRSyntaxTextArea());
	RSyntaxTextAreaModel onManyEnumRelationModel = new RSyntaxTextAreaModel(getOnManyEnumRelationRSyntaxTextArea());
	RSyntaxTextAreaModel onManyPrimitiveRelationModel = new RSyntaxTextAreaModel(getOnManyPrimitiveRelationRSyntaxTextArea());
	RSyntaxTextAreaModel onOptionalEntityRelationModel = new RSyntaxTextAreaModel(getOnOptionalEntityRelationRSyntaxTextArea());
	RSyntaxTextAreaModel onOptionalEnumRelationModel = new RSyntaxTextAreaModel(getOnOptionalEnumRelationRSyntaxTextArea());
	RSyntaxTextAreaModel onOptionalPrimitiveRelationModel = new RSyntaxTextAreaModel(getOnOptionalPrimitiveRelationRSyntaxTextArea());

	public DomainVisitorForm() {
		setLayout(new FormLayout("center:max(50dlu;pref):none, fill:pref:grow", "center:pref:none, center:pref:none, center:pref:none, center:pref:none, center:pref:none, center:pref:none, center:pref:none, center:pref:none, center:pref:none, center:pref:none, center:pref:none, center:pref:none, center:pref:none, center:pref:none, center:pref:none, center:pref:none, center:pref:none"));
		add(this.name_JLabel, new CellConstraints().xywh(1, 1, 1, 1, "LEFT, TOP"));
		add(this.name_JTextField, new CellConstraints().xywh(2, 1, 1, 1, "FILL, FILL"));
		add(newJScrollPane(this.onDomain_JLabel), new CellConstraints().xywh(1, 2, 1, 1, "LEFT, TOP"));
		add(newJScrollPane(this.onDomain_RSyntaxTextArea), new CellConstraints().xywh(2, 2, 1, 1, "FILL, FILL"));
		add(newJScrollPane(this.onEntity_JLabel), new CellConstraints().xywh(1, 3, 1, 1, "LEFT, TOP"));
		add(newJScrollPane(this.onEntity_RSyntaxTextArea), new CellConstraints().xywh(2, 3, 1, 1, "FILL, FILL"));
		add(newJScrollPane(this.onRelation_JLabel), new CellConstraints().xywh(1, 4, 1, 1, "LEFT, TOP"));
		add(newJScrollPane(this.onRelation_RSyntaxTextArea), new CellConstraints().xywh(2, 4, 1, 1, "FILL, FILL"));
		add(newJScrollPane(this.onComplete_JLabel), new CellConstraints().xywh(1, 5, 1, 1, "LEFT, TOP"));
		add(newJScrollPane(this.onComplete_RSyntaxTextArea), new CellConstraints().xywh(2, 5, 1, 1, "FILL, FILL"));
		add(newJScrollPane(this.onEntityEntity_JLabel), new CellConstraints().xywh(1, 6, 1, 1, "LEFT, TOP"));
		add(newJScrollPane(this.onEntityEntity_RSyntaxTextArea), new CellConstraints().xywh(2, 6, 1, 1, "FILL, FILL"));
		add(newJScrollPane(this.onEnumEntity_JLabel), new CellConstraints().xywh(1, 7, 1, 1, "LEFT, TOP"));
		add(newJScrollPane(this.onEnumEntity_RSyntaxTextArea), new CellConstraints().xywh(2, 7, 1, 1, "FILL, FILL"));
		add(newJScrollPane(this.onPrimitiveEntity_JLabel), new CellConstraints().xywh(1, 8, 1, 1, "LEFT, TOP"));
		add(newJScrollPane(this.onPrimitiveEntity_RSyntaxTextArea), new CellConstraints().xywh(2, 8, 1, 1, "FILL, FILL"));
		add(newJScrollPane(this.onOneEntityRelation_JLabel), new CellConstraints().xywh(1, 9, 1, 1, "LEFT, TOP"));
		add(newJScrollPane(this.onOneEntityRelation_RSyntaxTextArea), new CellConstraints().xywh(2, 9, 1, 1, "FILL, FILL"));
		add(newJScrollPane(this.onOneEnumRelation_JLabel), new CellConstraints().xywh(1, 10, 1, 1, "LEFT, TOP"));
		add(newJScrollPane(this.onOneEnumRelation_RSyntaxTextArea), new CellConstraints().xywh(2, 10, 1, 1, "FILL, FILL"));
		add(newJScrollPane(this.onOnePrimitiveRelation_JLabel), new CellConstraints().xywh(1, 11, 1, 1, "LEFT, TOP"));
		add(newJScrollPane(this.onOnePrimitiveRelation_RSyntaxTextArea), new CellConstraints().xywh(2, 11, 1, 1, "FILL, FILL"));
		add(newJScrollPane(this.onManyEntityRelation_JLabel), new CellConstraints().xywh(1, 12, 1, 1, "LEFT, TOP"));
		add(newJScrollPane(this.onManyEntityRelation_RSyntaxTextArea), new CellConstraints().xywh(2, 12, 1, 1, "FILL, FILL"));
		add(newJScrollPane(this.onManyEnumRelation_JLabel), new CellConstraints().xywh(1, 13, 1, 1, "LEFT, TOP"));
		add(newJScrollPane(this.onManyEnumRelation_RSyntaxTextArea), new CellConstraints().xywh(2, 13, 1, 1, "FILL, FILL"));
		add(newJScrollPane(this.onManyPrimitiveRelation_JLabel), new CellConstraints().xywh(1, 14, 1, 1, "LEFT, TOP"));
		add(newJScrollPane(this.onManyPrimitiveRelation_RSyntaxTextArea), new CellConstraints().xywh(2, 14, 1, 1, "FILL, FILL"));
		add(newJScrollPane(this.onOptionalEntityRelation_JLabel), new CellConstraints().xywh(1, 15, 1, 1, "LEFT, TOP"));
		add(newJScrollPane(this.onOptionalEntityRelation_RSyntaxTextArea), new CellConstraints().xywh(2, 15, 1, 1, "FILL, FILL"));
		add(newJScrollPane(this.onOptionalEnumRelation_JLabel), new CellConstraints().xywh(1, 16, 1, 1, "LEFT, TOP"));
		add(newJScrollPane(this.onOptionalEnumRelation_RSyntaxTextArea), new CellConstraints().xywh(2, 16, 1, 1, "FILL, FILL"));
		add(newJScrollPane(this.onOptionalPrimitiveRelation_JLabel), new CellConstraints().xywh(1, 17, 1, 1, "LEFT, TOP"));
		add(newJScrollPane(this.onOptionalPrimitiveRelation_RSyntaxTextArea), new CellConstraints().xywh(2, 17, 1, 1, "FILL, FILL"));
	}

	public <T extends JLabel> T getNameJLabel() {
		return (T) name_JLabel;
	}

	public <T extends JTextField> T getNameJTextField() {
		return (T) name_JTextField;
	}

	public <T extends JLabel> T getOnDomainJLabel() {
		return (T) onDomain_JLabel;
	}

	public <T extends RSyntaxTextArea> T getOnDomainRSyntaxTextArea() {
		return (T) onDomain_RSyntaxTextArea;
	}

	public <T extends JLabel> T getOnEntityJLabel() {
		return (T) onEntity_JLabel;
	}

	public <T extends RSyntaxTextArea> T getOnEntityRSyntaxTextArea() {
		return (T) onEntity_RSyntaxTextArea;
	}

	public <T extends JLabel> T getOnRelationJLabel() {
		return (T) onRelation_JLabel;
	}

	public <T extends RSyntaxTextArea> T getOnRelationRSyntaxTextArea() {
		return (T) onRelation_RSyntaxTextArea;
	}

	public <T extends JLabel> T getOnCompleteJLabel() {
		return (T) onComplete_JLabel;
	}

	public <T extends RSyntaxTextArea> T getOnCompleteRSyntaxTextArea() {
		return (T) onComplete_RSyntaxTextArea;
	}

	public <T extends JLabel> T getOnEntityEntityJLabel() {
		return (T) onEntityEntity_JLabel;
	}

	public <T extends RSyntaxTextArea> T getOnEntityEntityRSyntaxTextArea() {
		return (T) onEntityEntity_RSyntaxTextArea;
	}

	public <T extends JLabel> T getOnEnumEntityJLabel() {
		return (T) onEnumEntity_JLabel;
	}

	public <T extends RSyntaxTextArea> T getOnEnumEntityRSyntaxTextArea() {
		return (T) onEnumEntity_RSyntaxTextArea;
	}

	public <T extends JLabel> T getOnPrimitiveEntityJLabel() {
		return (T) onPrimitiveEntity_JLabel;
	}

	public <T extends RSyntaxTextArea> T getOnPrimitiveEntityRSyntaxTextArea() {
		return (T) onPrimitiveEntity_RSyntaxTextArea;
	}

	public <T extends JLabel> T getOnOneEntityRelationJLabel() {
		return (T) onOneEntityRelation_JLabel;
	}

	public <T extends RSyntaxTextArea> T getOnOneEntityRelationRSyntaxTextArea() {
		return (T) onOneEntityRelation_RSyntaxTextArea;
	}

	public <T extends JLabel> T getOnOneEnumRelationJLabel() {
		return (T) onOneEnumRelation_JLabel;
	}

	public <T extends RSyntaxTextArea> T getOnOneEnumRelationRSyntaxTextArea() {
		return (T) onOneEnumRelation_RSyntaxTextArea;
	}

	public <T extends JLabel> T getOnOnePrimitiveRelationJLabel() {
		return (T) onOnePrimitiveRelation_JLabel;
	}

	public <T extends RSyntaxTextArea> T getOnOnePrimitiveRelationRSyntaxTextArea() {
		return (T) onOnePrimitiveRelation_RSyntaxTextArea;
	}

	public <T extends JLabel> T getOnManyEntityRelationJLabel() {
		return (T) onManyEntityRelation_JLabel;
	}

	public <T extends RSyntaxTextArea> T getOnManyEntityRelationRSyntaxTextArea() {
		return (T) onManyEntityRelation_RSyntaxTextArea;
	}

	public <T extends JLabel> T getOnManyEnumRelationJLabel() {
		return (T) onManyEnumRelation_JLabel;
	}

	public <T extends RSyntaxTextArea> T getOnManyEnumRelationRSyntaxTextArea() {
		return (T) onManyEnumRelation_RSyntaxTextArea;
	}

	public <T extends JLabel> T getOnManyPrimitiveRelationJLabel() {
		return (T) onManyPrimitiveRelation_JLabel;
	}

	public <T extends RSyntaxTextArea> T getOnManyPrimitiveRelationRSyntaxTextArea() {
		return (T) onManyPrimitiveRelation_RSyntaxTextArea;
	}

	public <T extends JLabel> T getOnOptionalEntityRelationJLabel() {
		return (T) onOptionalEntityRelation_JLabel;
	}

	public <T extends RSyntaxTextArea> T getOnOptionalEntityRelationRSyntaxTextArea() {
		return (T) onOptionalEntityRelation_RSyntaxTextArea;
	}

	public <T extends JLabel> T getOnOptionalEnumRelationJLabel() {
		return (T) onOptionalEnumRelation_JLabel;
	}

	public <T extends RSyntaxTextArea> T getOnOptionalEnumRelationRSyntaxTextArea() {
		return (T) onOptionalEnumRelation_RSyntaxTextArea;
	}

	public <T extends JLabel> T getOnOptionalPrimitiveRelationJLabel() {
		return (T) onOptionalPrimitiveRelation_JLabel;
	}

	public <T extends RSyntaxTextArea> T getOnOptionalPrimitiveRelationRSyntaxTextArea() {
		return (T) onOptionalPrimitiveRelation_RSyntaxTextArea;
	}


	public void modelToView(nextgen.model.DomainVisitor model) {
		this.model = model;
		nameModel.setValue(model.getName());
		onDomainModel.setValue(model.getOnDomain());
		onEntityModel.setValue(model.getOnEntity());
		onRelationModel.setValue(model.getOnRelation());
		onCompleteModel.setValue(model.getOnComplete());
		onEntityEntityModel.setValue(model.getOnEntityEntity());
		onEnumEntityModel.setValue(model.getOnEnumEntity());
		onPrimitiveEntityModel.setValue(model.getOnPrimitiveEntity());
		onOneEntityRelationModel.setValue(model.getOnOneEntityRelation());
		onOneEnumRelationModel.setValue(model.getOnOneEnumRelation());
		onOnePrimitiveRelationModel.setValue(model.getOnOnePrimitiveRelation());
		onManyEntityRelationModel.setValue(model.getOnManyEntityRelation());
		onManyEnumRelationModel.setValue(model.getOnManyEnumRelation());
		onManyPrimitiveRelationModel.setValue(model.getOnManyPrimitiveRelation());
		onOptionalEntityRelationModel.setValue(model.getOnOptionalEntityRelation());
		onOptionalEnumRelationModel.setValue(model.getOnOptionalEnumRelation());
		onOptionalPrimitiveRelationModel.setValue(model.getOnOptionalPrimitiveRelation());
	}

	public void modelToView() {
		nameModel.setValue(model.getName());
		onDomainModel.setValue(model.getOnDomain());
		onEntityModel.setValue(model.getOnEntity());
		onRelationModel.setValue(model.getOnRelation());
		onCompleteModel.setValue(model.getOnComplete());
		onEntityEntityModel.setValue(model.getOnEntityEntity());
		onEnumEntityModel.setValue(model.getOnEnumEntity());
		onPrimitiveEntityModel.setValue(model.getOnPrimitiveEntity());
		onOneEntityRelationModel.setValue(model.getOnOneEntityRelation());
		onOneEnumRelationModel.setValue(model.getOnOneEnumRelation());
		onOnePrimitiveRelationModel.setValue(model.getOnOnePrimitiveRelation());
		onManyEntityRelationModel.setValue(model.getOnManyEntityRelation());
		onManyEnumRelationModel.setValue(model.getOnManyEnumRelation());
		onManyPrimitiveRelationModel.setValue(model.getOnManyPrimitiveRelation());
		onOptionalEntityRelationModel.setValue(model.getOnOptionalEntityRelation());
		onOptionalEnumRelationModel.setValue(model.getOnOptionalEnumRelation());
		onOptionalPrimitiveRelationModel.setValue(model.getOnOptionalPrimitiveRelation());
	}

	public nextgen.model.DomainVisitor viewToModel() {
		model.setName((String) nameModel.getValue());
		model.setOnDomain((String) onDomainModel.getValue());
		model.setOnEntity((String) onEntityModel.getValue());
		model.setOnRelation((String) onRelationModel.getValue());
		model.setOnComplete((String) onCompleteModel.getValue());
		model.setOnEntityEntity((String) onEntityEntityModel.getValue());
		model.setOnEnumEntity((String) onEnumEntityModel.getValue());
		model.setOnPrimitiveEntity((String) onPrimitiveEntityModel.getValue());
		model.setOnOneEntityRelation((String) onOneEntityRelationModel.getValue());
		model.setOnOneEnumRelation((String) onOneEnumRelationModel.getValue());
		model.setOnOnePrimitiveRelation((String) onOnePrimitiveRelationModel.getValue());
		model.setOnManyEntityRelation((String) onManyEntityRelationModel.getValue());
		model.setOnManyEnumRelation((String) onManyEnumRelationModel.getValue());
		model.setOnManyPrimitiveRelation((String) onManyPrimitiveRelationModel.getValue());
		model.setOnOptionalEntityRelation((String) onOptionalEntityRelationModel.getValue());
		model.setOnOptionalEnumRelation((String) onOptionalEnumRelationModel.getValue());
		model.setOnOptionalPrimitiveRelation((String) onOptionalPrimitiveRelationModel.getValue());
		return model;
	}


	/*

	columns 		"center:max(50dlu;pref):none, fill:pref:grow"

	rows 		 	"center:pref:none, center:pref:none, center:pref:none, center:pref:none, center:pref:none, center:pref:none, center:pref:none, center:pref:none, center:pref:none, center:pref:none, center:pref:none, center:pref:none, center:pref:none, center:pref:none, center:pref:none, center:pref:none, center:pref:none"


	*/	

	public static final class JTextFieldModel extends AbstractValueModel {

		private String value;
		private final ValueModel valueModel = new AbstractValueModel() {

			@Override
			public Object getValue() { return value; }

			@Override
			public void setValue(Object o) { 
				String old = value;
				value = o == null ? null : o.toString();
				fireValueChange(old, value);
			}
		};

		public JTextFieldModel(JTextField component) {
			Bindings.bind(component, valueModel);
		}

		@Override
		public Object getValue() {
			return valueModel.getValue();
		}

		@Override
		public void setValue(Object o) {
			Object old = getValue();
			valueModel.setValue(o);
			fireValueChange(old, valueModel.getValue());
		}
	}

	public static final class RSyntaxTextAreaModel extends AbstractValueModel {

		private String value;
		private final ValueModel valueModel = new AbstractValueModel() {

			@Override
			public Object getValue() { return value; }

			@Override
			public void setValue(Object o) {
				String old = value;
				value = o == null ? null : o.toString();
				fireValueChange(old, value);
			}
		};

		public RSyntaxTextAreaModel(RSyntaxTextArea component) {
			Bindings.bind(component, valueModel);
		}

		@Override
		public Object getValue() {
			return valueModel.getValue();
		}

		@Override
		public void setValue(Object o) {
			Object old = getValue();
			valueModel.setValue(o);
			fireValueChange(old, valueModel.getValue());
		}
	}
}  