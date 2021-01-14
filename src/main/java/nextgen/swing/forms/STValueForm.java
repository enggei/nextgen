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

public class STValueForm extends JPanel {

	nextgen.model.STValue model;
	JLabel value_JLabel = newJLabel("value");
	JTextField value_JTextField = newJTextField("value");
	JTextFieldModel valueModel = new JTextFieldModel(getValueJTextField());

	public STValueForm() {
		setLayout(new FormLayout("center:max(50dlu;pref):none, fill:pref:grow", "center:30:none"));
		add(this.value_JLabel, new CellConstraints().xywh(1, 1, 1, 1, "CENTER, CENTER"));
		add(this.value_JTextField, new CellConstraints().xywh(2, 1, 1, 1, "FILL, CENTER"));
	}

	public <T extends JLabel> T getValueJLabel() {
		return (T) value_JLabel;
	}

	public <T extends JTextField> T getValueJTextField() {
		return (T) value_JTextField;
	}


	public void modelToView(nextgen.model.STValue model) {
		this.model = model;
		valueModel.setValue(model.getValue());
	}

	public void modelToView() {
		valueModel.setValue(model.getValue());
	}

	public nextgen.model.STValue viewToModel() {
		model.setValue((String) valueModel.getValue());
		return model;
	}


	/*

	columns 		"center:max(50dlu;pref):none, fill:pref:grow"

	rows 		 	"center:30:none"


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