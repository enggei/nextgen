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

public class STGroupModelForm extends JPanel {

	nextgen.model.STGroupModel model;
	JLabel language_JLabel = newJLabel("language");
	JTextField language_JTextField = newJTextField("language");
	JLabel name_JLabel = newJLabel("name");
	JTextField name_JTextField = newJTextField("name");
	JLabel delimiter_JLabel = newJLabel("delimiter");
	JTextField delimiter_JTextField = newJTextField("delimiter");
	JLabel icon_JLabel = newJLabel("icon");
	JTextField icon_JTextField = newJTextField("icon");
	JTextFieldModel languageModel = new JTextFieldModel(getLanguageJTextField());
	JTextFieldModel nameModel = new JTextFieldModel(getNameJTextField());
	JTextFieldModel delimiterModel = new JTextFieldModel(getDelimiterJTextField());
	JTextFieldModel iconModel = new JTextFieldModel(getIconJTextField());

	public STGroupModelForm() {
		setLayout(new FormLayout("center:max(50dlu;pref):none, fill:pref:grow", "center:30:none, center:30:none, center:30:none, center:30:none"));
		add(this.language_JLabel, new CellConstraints().xywh(1, 1, 1, 1, "CENTER, CENTER"));
		add(this.language_JTextField, new CellConstraints().xywh(2, 1, 1, 1, "FILL, CENTER"));
		add(this.name_JLabel, new CellConstraints().xywh(1, 2, 1, 1, "CENTER, CENTER"));
		add(this.name_JTextField, new CellConstraints().xywh(2, 2, 1, 1, "FILL, CENTER"));
		add(this.delimiter_JLabel, new CellConstraints().xywh(1, 3, 1, 1, "CENTER, CENTER"));
		add(this.delimiter_JTextField, new CellConstraints().xywh(2, 3, 1, 1, "FILL, CENTER"));
		add(this.icon_JLabel, new CellConstraints().xywh(1, 4, 1, 1, "CENTER, CENTER"));
		add(this.icon_JTextField, new CellConstraints().xywh(2, 4, 1, 1, "FILL, CENTER"));
	}

	public <T extends JLabel> T getLanguageJLabel() {
		return (T) language_JLabel;
	}

	public <T extends JTextField> T getLanguageJTextField() {
		return (T) language_JTextField;
	}

	public <T extends JLabel> T getNameJLabel() {
		return (T) name_JLabel;
	}

	public <T extends JTextField> T getNameJTextField() {
		return (T) name_JTextField;
	}

	public <T extends JLabel> T getDelimiterJLabel() {
		return (T) delimiter_JLabel;
	}

	public <T extends JTextField> T getDelimiterJTextField() {
		return (T) delimiter_JTextField;
	}

	public <T extends JLabel> T getIconJLabel() {
		return (T) icon_JLabel;
	}

	public <T extends JTextField> T getIconJTextField() {
		return (T) icon_JTextField;
	}


	public void modelToView(nextgen.model.STGroupModel model) {
		this.model = model;
		languageModel.setValue(model.getLanguage());
		nameModel.setValue(model.getName());
		delimiterModel.setValue(model.getDelimiter());
		iconModel.setValue(model.getIcon());
	}

	public void modelToView() {
		languageModel.setValue(model.getLanguage());
		nameModel.setValue(model.getName());
		delimiterModel.setValue(model.getDelimiter());
		iconModel.setValue(model.getIcon());
	}

	public nextgen.model.STGroupModel viewToModel() {
		model.setLanguage((String) languageModel.getValue());
		model.setName((String) nameModel.getValue());
		model.setDelimiter((String) delimiterModel.getValue());
		model.setIcon((String) iconModel.getValue());
		return model;
	}


	/*

	columns 		"center:max(50dlu;pref):none, fill:pref:grow"

	rows 		 	"center:30:none, center:30:none, center:30:none, center:30:none"


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