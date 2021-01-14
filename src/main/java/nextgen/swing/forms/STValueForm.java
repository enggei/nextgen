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
	RSyntaxTextArea value_RSyntaxTextArea = newRSyntaxTextArea("value");
	RSyntaxTextAreaModel valueModel = new RSyntaxTextAreaModel(getValueRSyntaxTextArea());

	public STValueForm() {
		setLayout(new FormLayout("center:max(50dlu;pref):none, fill:pref:grow", "center:pref:none"));
		add(newJScrollPane(this.value_JLabel), new CellConstraints().xywh(1, 1, 1, 1, "LEFT, TOP"));
		add(newJScrollPane(this.value_RSyntaxTextArea), new CellConstraints().xywh(2, 1, 1, 1, "FILL, FILL"));
	}

	public <T extends JLabel> T getValueJLabel() {
		return (T) value_JLabel;
	}

	public <T extends RSyntaxTextArea> T getValueRSyntaxTextArea() {
		return (T) value_RSyntaxTextArea;
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

	rows 		 	"center:pref:none"


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