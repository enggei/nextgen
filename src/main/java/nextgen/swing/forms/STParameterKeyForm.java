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

public class STParameterKeyForm extends JPanel {

	nextgen.model.STParameterKey model;
	JLabel name_JLabel = newJLabel("name");
	JTextField name_JTextField = newJTextField("name");
	JLabel argumentType_JLabel = newJLabel("argumentType");
	RSyntaxTextArea argumentType_RSyntaxTextArea = newRSyntaxTextArea("argumentType");
	JTextFieldModel nameModel = new JTextFieldModel(getNameJTextField());
	RSyntaxTextAreaModel argumentTypeModel = new RSyntaxTextAreaModel(getArgumentTypeRSyntaxTextArea());

	public STParameterKeyForm() {
		setLayout(new FormLayout("center:max(50dlu;pref):none, fill:pref:grow", "center:pref:none, center:pref:none"));
		add(this.name_JLabel, new CellConstraints().xywh(1, 1, 1, 1, "LEFT, TOP"));
		add(this.name_JTextField, new CellConstraints().xywh(2, 1, 1, 1, "FILL, FILL"));
		add(newJScrollPane(this.argumentType_JLabel), new CellConstraints().xywh(1, 2, 1, 1, "LEFT, TOP"));
		add(newJScrollPane(this.argumentType_RSyntaxTextArea), new CellConstraints().xywh(2, 2, 1, 1, "FILL, FILL"));
	}

	public <T extends JLabel> T getNameJLabel() {
		return (T) name_JLabel;
	}

	public <T extends JTextField> T getNameJTextField() {
		return (T) name_JTextField;
	}

	public <T extends JLabel> T getArgumentTypeJLabel() {
		return (T) argumentType_JLabel;
	}

	public <T extends RSyntaxTextArea> T getArgumentTypeRSyntaxTextArea() {
		return (T) argumentType_RSyntaxTextArea;
	}


	public void modelToView(nextgen.model.STParameterKey model) {
		this.model = model;
		nameModel.setValue(model.getName());
		argumentTypeModel.setValue(model.getArgumentType());
	}

	public void modelToView() {
		nameModel.setValue(model.getName());
		argumentTypeModel.setValue(model.getArgumentType());
	}

	public nextgen.model.STParameterKey viewToModel() {
		model.setName((String) nameModel.getValue());
		model.setArgumentType((String) argumentTypeModel.getValue());
		return model;
	}


	/*

	columns 		"center:max(50dlu;pref):none, fill:pref:grow"

	rows 		 	"center:pref:none, center:pref:none"


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