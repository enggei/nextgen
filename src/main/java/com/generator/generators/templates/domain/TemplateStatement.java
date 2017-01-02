package com.generator.generators.templates.domain;

import com.generator.domain.BaseEntity;
import org.stringtemplate.v4.ST;

import java.util.*;

import static com.generator.generators.templates.domain.TemplateEntities.TEMPLATESTATEMENT;

/**
 * User: geirove
 * Date: 27.11.12
 */
public class TemplateStatement extends BaseEntity<TemplateEntities> {

	private String name;
	private String text;
	private char delimiter;
	private TemplateStatementType type;
	private final Map<String, TemplateParameter> parameters = new LinkedHashMap<>();

	private static final Set<String> TEMPLATESTATEMENT_KEYWORDS = Collections.unmodifiableSet(new TreeSet<String>() {{
		add("true");
		add("false");
		add("import");
		add("default");
		add("key");
		add("group");
		add("implements");
		add("first");
		add("last");
		add("rest");
		add("trunc");
		add("strip");
		add("trim");
		add("length");
		add("strlen");
		add("reverse");
		add("if");
		add("else");
		add("elseif");
		add("endif");
		add("delimiters");
	}});

	public TemplateStatement(Statement statement, TemplateStatementType type, String text, char delimiter) {
		super(TEMPLATESTATEMENT);
		validateName(statement.getStatementName());
		this.name = statement.getStatementName();
		this.type = type;
		this.text = text;
		this.delimiter = delimiter;
		for (final Property property : statement.getProperties()) {
			validateName(property.getPropertyName());
			parameters.put(property.getPropertyName(), new TemplateParameter(property));
		}
	}

	public TemplateStatement(String name, TemplateStatementType type, List<TemplateParameter> parameters, String text, char delimiter) {
		super(TEMPLATESTATEMENT);
		validateName(name);
		this.name = name;
		this.type = type;
		this.text = text;
		this.delimiter = delimiter;
		for (TemplateParameter parameter : parameters) {
			try {
				validateName(parameter.getPropertyName());
			} catch (Exception e) {
				throw new IllegalArgumentException("Parameter in '" + name + "' is illegal.", e);
			}
			this.parameters.put(parameter.getPropertyName(), parameter);
		}
	}

	public TemplateStatement(UUID uuid, String name, TemplateStatementType type, String text, char delimiter) {
		super(uuid, TEMPLATESTATEMENT);
		validateName(name);
		this.name = name;
		this.type = type;
		this.text = text;
		this.delimiter = delimiter;
	}

	public TemplateStatement(UUID uuid, String name, TemplateStatementType type, List<TemplateParameter> parameters, String text, char delimiter) {
		super(uuid, TEMPLATESTATEMENT);
		validateName(name);
		this.name = name;
		this.type = type;
		this.text = text;
		this.delimiter = delimiter;
		for (TemplateParameter parameter : parameters) {
			validateName(parameter.getPropertyName());
			this.parameters.put(parameter.getPropertyName(), parameter);
		}
	}

	public TemplateStatement(TemplateStatement statement) {
		super(TEMPLATESTATEMENT);
		validateName(statement.getName());
		this.name = statement.getName();
		this.type = statement.getStatementType();
		this.text = statement.getText();
		this.delimiter = statement.getDelimiter();
		for (TemplateParameter parameter : statement.getParameters()) {
			validateName(parameter.getPropertyName());
			this.parameters.put(parameter.getPropertyName(), new TemplateParameter(parameter));
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TemplateStatementType getStatementType() {
		return type;
	}

	public void setType(TemplateStatementType type) {
		this.type = type;
	}

	public char getDelimiter() {
		return delimiter;
	}

	public List<TemplateParameter> getParameters() {
		return new ArrayList<>(this.parameters.values());
	}

	public void setParameters(List<TemplateParameter> parameters) {
		this.parameters.clear();
		for (TemplateParameter parameter : parameters) {
			validateName(parameter.getPropertyName());
			this.parameters.put(parameter.getPropertyName(), parameter);
		}
	}

	public String getText() {
		return text.trim();
	}

	public Set<String> getParameterNames() {
		return Collections.unmodifiableSet(parameters.keySet());
	}

	public TemplateParameter getParameter(String name) {
		return parameters.get(name);
	}

	public Statement asStatement(List<Property> properties) {
		return new Statement(UUID.randomUUID(), name, properties);
	}

	public Statement asStatement() {
		final List<Property> properties = new ArrayList<>();
		for (TemplateParameter parameter : parameters.values()) {

			final Property property = parameter.asProperty();
			switch (parameter.getDomainEntityType()) {

				case STRINGPROPERTY:
					((StringProperty) property).setValue("value");
					break;

				case STATEMENTPROPERTY:
					break;

				case LISTPROPERTY:
					break;

				case KEYVALUELISTPROPERTY:
					((KeyValueListProperty) property).addPropertySet(parameter.getKvNamesAsPropertySet("value"));
					break;

				case BOOLEANPROPERTY:
					((BooleanProperty) property).setValue(true);
					break;
			}
			properties.add(property);
		}
		return new Statement(UUID.randomUUID(), name, properties);
	}

	private void validateName(String name) {
		if (TEMPLATESTATEMENT_KEYWORDS.contains(name))
			throw new IllegalArgumentException("template statement name cannot be '" + name + "': It is a reserved word.");
	}

	public String render(List<Property> properties) {
		final ST template = new ST(text);

		for (Property property : properties) {
			if (property instanceof StringProperty) {
				template.add(property.getPropertyName(), ((StringProperty) property).getValue());
			} else if (property instanceof BooleanProperty) {
				final Boolean value = ((BooleanProperty) property).getValue();
				if (value != null && value)
					template.add(property.getPropertyName(), value);
			}
			// todo: use
		}

		return template.render();
	}

	@Override
	public String toString() {
		return getHeaderStringFor() + "\n" + formatTemplateMethod() + getStartTagFor(getStatementType()) + getText() + getEndTagFor(getStatementType());
	}

	private String getHeaderStringFor() {
		final StringBuilder documentation = new StringBuilder("/** ");
		for (TemplateParameter templateParameter : getParameters()) {
			documentation.append(templateParameter.getPropertyName()).append(",");
			documentation.append(templateParameter.getDomainEntityType().name());
			for (String kvName : templateParameter.getKvNames()) {
				documentation.append(",");
				documentation.append(kvName);
			}
			documentation.append(";");
		}

		documentation.append(" **/");
		return documentation.toString();
	}

	public StringBuilder formatTemplateMethod() {
		final StringBuilder head = new StringBuilder();
		head.append(getName()).append((TemplateStatementType.METHOD.equals(getStatementType()) || TemplateStatementType.SINGLE.equals(getStatementType())) ? "(" : "");
		boolean first = true;
		for (String propertyEntry : getParameterNames()) {
			if (!first) head.append(",");
			first = false;
			head.append(propertyEntry);
		}
		head.append((TemplateStatementType.METHOD.equals(getStatementType()) || TemplateStatementType.SINGLE.equals(getStatementType())) ? ") " : " ");
		return head;
	}

	public String getEndTagFor(TemplateStatementType type) {
		switch (type) {
			case METHOD:
				return "\n>>";
			case MAP:
				return "]";
			case SINGLE:
				return "\"";
		}
		throw new IllegalArgumentException("unsupported type: " + type);
	}

	public String getStartTagFor(TemplateStatementType type) {
		switch (type) {
			case METHOD:
				return "::= <<";
			case MAP:
				return "::= [";
			case SINGLE:
				return "::= \"";
		}
		throw new IllegalArgumentException("unsupported type: " + type);
	}

	public TemplateStatement copy() {
		final List<TemplateParameter> copiedParameters = new ArrayList<>(this.parameters.size());
		for (Map.Entry<String, TemplateParameter> parameterEntry : this.parameters.entrySet())
			copiedParameters.add(parameterEntry.getValue().copy());
		return new TemplateStatement(this.uuid, this.name, this.type, copiedParameters, this.text, this.delimiter);
	}

	public TemplateParameter getParameter(UUID uuid) {
		for (TemplateParameter parameter : parameters.values())
			if (parameter.getUuid().equals(uuid)) return parameter;
		return null;
	}

	public static Set<UUID> getAllMissingInRight(TemplateStatement left, TemplateStatement right) {
		final Set<UUID> newParameters = new LinkedHashSet<>();
		for (TemplateParameter committedParameter : left.getParameters()) {
			boolean found = false;
			for (TemplateParameter oldParameter : right.getParameters()) {
				if (committedParameter.equals(oldParameter)) {
					found = true;
					break;
				}
			}
			if (!found) newParameters.add(committedParameter.getUuid());
		}
		return newParameters;
	}

	public TemplateStatement addParameter(TemplateParameter parameter) {
		this.parameters.put(parameter.getPropertyName(), parameter);
		return this;
	}
}