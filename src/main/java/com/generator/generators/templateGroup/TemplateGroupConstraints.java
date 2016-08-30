package com.generator.generators.templateGroup;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * goe on 8/29/16.
 */
public class TemplateGroupConstraints {

	//todo: DomainConstraints are a generic object for all Templates. It will be set through a UI on each .stg node in TemplateEditor (using FormLayout)

	private final Set<String> roots = new LinkedHashSet<>();
	private final Map<String, TemplateStatementConstraint> constraints = new LinkedHashMap<>();

	public TemplateGroupConstraints addRoot(String templateName) {
		this.roots.add(templateName);
		return this;
	}

	public TemplateGroupConstraints addStatementConstraint(TemplateStatementConstraint statementConstraint) {
		this.constraints.put(statementConstraint.getStatementName(), statementConstraint);
		return this;
	}

	public static class TemplateStatementConstraint {

		private final String statementName;
		private final Map<String, TemplateParameterConstraint> parameterConstraints = new LinkedHashMap<>();

		public TemplateStatementConstraint(String statementName) {
			this.statementName = statementName;
		}

		public String getStatementName() {
			return statementName;
		}

		public TemplateStatementConstraint addParameterConstraint(TemplateParameterConstraint parameterConstraint) {
			parameterConstraints.put(parameterConstraint.getParameterName(), parameterConstraint);
			return this;
		}
	}

	public static class TemplateParameterConstraint {

		private String parameterName;
		private final Set<String> allowedTemplates = new LinkedHashSet<>();
		private final Set<String> allowedValues = new LinkedHashSet<>();
		private boolean isTrueFalse = false;

		public TemplateParameterConstraint(String parameterName) {
			this.parameterName = parameterName;
		}

		public String getParameterName() {
			return parameterName;
		}

		public TemplateParameterConstraint addAllowedTemplate(String templateName) {
			this.allowedTemplates.add(templateName);
			return this;
		}

		public TemplateParameterConstraint addAllowedValue(String value) {
			this.allowedValues.add(value);
			return this;
		}

		public TemplateParameterConstraint isTrueFalseValue() {
			this.isTrueFalse = true;
			return this;
		}
	}
}