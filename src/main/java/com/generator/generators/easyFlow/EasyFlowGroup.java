package com.generator.generators.easyFlow;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'easyFlow.stg' file<br/>
 */
public final class EasyFlowGroup {
	// old easyFlow
	private final STGroup stGroup;
	private final char delimiter;

	public EasyFlowGroup() {
		final String generatorPath = System.getProperty("generator.path");

		if (generatorPath != null) {
			this.stGroup = new org.stringtemplate.v4.STGroupFile(generatorPath + java.io.File.separator + "easyFlow" + java.io.File.separator + "easyFlow.stg");
			this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
			this.delimiter = stGroup.delimiterStartChar;
		} else {
			this.stGroup = new org.stringtemplate.v4.STGroupFile(EasyFlowGroup.class.getResource("/com/generator/generators/easyFlow/easyFlow.stg"), "UTF-8", '~', '~');
			this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
			this.delimiter = stGroup.delimiterStartChar;
		}
	}

	public EasyFlowGroup(STGroup stGroup) {
		this.stGroup = stGroup;
		this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
		this.delimiter = stGroup.delimiterStartChar;
	}

	public EasyFlowGroup(java.io.File templateFile) {
		this.stGroup = new org.stringtemplate.v4.STGroupFile(templateFile.getAbsolutePath());
		this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
		this.delimiter = stGroup.delimiterStartChar;
	}

	public STGroup getSTGroup() {
		return stGroup;
	}

	public char getDelimiter() {
		return delimiter;
	}

	public interface easyFlowGroupTemplate {

	}


	public bugfixST newbugfix() {
		return new bugfixST(stGroup);
	}


	public declarationST newdeclaration() {
		return new declarationST(stGroup);
	}


	public easyFlowST neweasyFlow() {
		return new easyFlowST(stGroup);
	}


	public dependencyST newdependency() {
		return new dependencyST(stGroup);
	}


	public implST newimpl() {
		return new implST(stGroup);
	}


	public transitST newtransit() {
		return new transitST(stGroup);
	}

	public final class bugfixST implements easyFlowGroupTemplate {

		private final ST template;

		private bugfixST(STGroup group) {
			template = group.getInstanceOf("bugfix");
		}

		@Override
		public String toString() {
			return template.render();
		}
	}

	public final class declarationST implements easyFlowGroupTemplate {

		private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
		private final AtomicBoolean stateIsSet = new AtomicBoolean(false);
		private final ST template;

		private declarationST(STGroup group) {
			template = group.getInstanceOf("declaration");
		}

		public declarationST setName(Object value) {
			tryToSetStringProperty(template, value, nameIsSet, "name");
			return this;
		}
		public declarationST setState(Object value) {
			tryToSetStringProperty(template, value, stateIsSet, "state");
			return this;
		}

		@Override
		public String toString() {
			return template.render();
		}
	}

	public final class easyFlowST implements easyFlowGroupTemplate {

		private final AtomicBoolean extendsIsSet = new AtomicBoolean(false);
		private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
		private final AtomicBoolean packageIsSet = new AtomicBoolean(false);
		private final AtomicBoolean startStateIsSet = new AtomicBoolean(false);
		private final AtomicBoolean superParamsIsSet = new AtomicBoolean(false);
		private final AtomicBoolean eventsIsSet = new AtomicBoolean(false);
		private final AtomicBoolean transitionsIsSet = new AtomicBoolean(false);
		private final AtomicBoolean propertiesIsSet = new AtomicBoolean(false);
		private final AtomicBoolean statesIsSet = new AtomicBoolean(false);
		private final ST template;

		private easyFlowST(STGroup group) {
			template = group.getInstanceOf("easyFlow");
		}

		public easyFlowST setExtends(Object value) {
			tryToSetStringProperty(template, value, extendsIsSet, "extends");
			return this;
		}
		public easyFlowST setName(Object value) {
			tryToSetStringProperty(template, value, nameIsSet, "name");
			return this;
		}
		public easyFlowST setPackage(Object value) {
			tryToSetStringProperty(template, value, packageIsSet, "package");
			return this;
		}
		public easyFlowST setStartState(Object value) {
			tryToSetStringProperty(template, value, startStateIsSet, "startState");
			return this;
		}
		public easyFlowST addSuperParamsValue(Object name_, Object type_) {
			superParamsIsSet.set(true);
			template.addAggr("superParams.{name, type}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (type_==null || type_.toString().length()==0) ? null : type_));
			return this;
		}
		public easyFlowST addEventsValue(Object name_) {
			eventsIsSet.set(true);
			template.addAggr("events.{name}", ( (name_==null || name_.toString().length()==0) ? null : name_));
			return this;
		}
		public easyFlowST addTransitionsValue(Object value) {
			tryToSetListProperty(template, value, transitionsIsSet, "transitions");
			return this;
		}
		public easyFlowST addPropertiesValue(Object comment_, Object modifier_, Object name_, Object type_, Object value_) {
			propertiesIsSet.set(true);
			template.addAggr("properties.{comment, modifier, name, type, value}", ( (comment_==null || comment_.toString().length()==0) ? null : comment_), ( (modifier_==null || modifier_.toString().length()==0) ? null : modifier_), ( (name_==null || name_.toString().length()==0) ? null : name_), ( (type_==null || type_.toString().length()==0) ? null : type_), ( (value_==null || value_.toString().length()==0) ? null : value_));
			return this;
		}
		public easyFlowST addStatesValue(Object name_) {
			statesIsSet.set(true);
			template.addAggr("states.{name}", ( (name_==null || name_.toString().length()==0) ? null : name_));
			return this;
		}

		@Override
		public String toString() {
			return template.render();
		}
	}

	public final class dependencyST implements easyFlowGroupTemplate {

		private final ST template;

		private dependencyST(STGroup group) {
			template = group.getInstanceOf("dependency");
		}

		@Override
		public String toString() {
			return template.render();
		}
	}

	public final class implST implements easyFlowGroupTemplate {

		private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
		private final AtomicBoolean stateIsSet = new AtomicBoolean(false);
		private final ST template;

		private implST(STGroup group) {
			template = group.getInstanceOf("impl");
		}

		public implST setName(Object value) {
			tryToSetStringProperty(template, value, nameIsSet, "name");
			return this;
		}
		public implST setState(Object value) {
			tryToSetStringProperty(template, value, stateIsSet, "state");
			return this;
		}

		@Override
		public String toString() {
			return template.render();
		}
	}

	public final class transitST implements easyFlowGroupTemplate {

		private final AtomicBoolean eventIsSet = new AtomicBoolean(false);
		private final AtomicBoolean stateIsSet = new AtomicBoolean(false);
		private final AtomicBoolean transitsIsSet = new AtomicBoolean(false);
		private final AtomicBoolean finalStateIsSet = new AtomicBoolean(false);
		private final ST template;

		private transitST(STGroup group) {
			template = group.getInstanceOf("transit");
		}

		public transitST setEvent(Object value) {
			tryToSetStringProperty(template, value, eventIsSet, "event");
			return this;
		}
		public transitST setState(Object value) {
			tryToSetStringProperty(template, value, stateIsSet, "state");
			return this;
		}
		public transitST addTransitsValue(Object value) {
			tryToSetListProperty(template, value, transitsIsSet, "transits");
			return this;
		}
		public transitST setFinalState(Object value) {
			tryToSetStringProperty(template, value, finalStateIsSet, "finalState");
			return this;
		}

		@Override
		public String toString() {
			return template.render();
		}
	}

	static void tryToSetStringProperty(ST template, Object value, AtomicBoolean alreadySet, String name) {
		if (alreadySet.get()) return;
		if (value == null || value.toString().length() == 0) return;
		alreadySet.set(true);
		template.add(name, value);
	}

	static boolean tryToSetListProperty(ST template, Object value, AtomicBoolean alreadySet, String name) {
		if (value == null || value.toString().length() == 0) return true;
		alreadySet.set(true);
		template.add(name, value);
		return false;
	}

	private enum FormatCode {
		capitalize, toUpper, lowFirst, toLower, humpToCap, camelHump, splitCamelHump, singlify, packageToPath
	}

	private final class DefaultAttributeRenderer implements org.stringtemplate.v4.AttributeRenderer {

		@Override
		public String toString(Object o, String formatString, java.util.Locale locale) {

			final String text = o.toString();

			if (formatString == null) return text;

			switch (FormatCode.valueOf(formatString)) {
				case capitalize:
					return capitalize(text);
				case toUpper:
					return toUpper(text);
				case lowFirst:
					return lowFirst(text);
				case toLower:
					return text.toLowerCase();
				case humpToCap:
					return humpToCap(text);
				case camelHump:
					return camelHump(text);
				case splitCamelHump:
					return splitCamelHump(text);
				case singlify:
					String s = toUpper(text).substring(0, 1) + text.substring(1);
					if (s.toLowerCase().endsWith("ies")) return s.substring(0, s.length() - 3) + "y";
					else if (s.toLowerCase().endsWith("es") || s.toLowerCase().endsWith("nts")) return s.substring(0, s.length() - 1);
					else if (s.toLowerCase().endsWith("ions") || s.toLowerCase().endsWith("mns"))
						return s.substring(0, s.length() - 1);
					return s;
				case packageToPath:
					return packageToPath((text));
				default:
					return o.toString();
			}
		}

		private String capitalize(String string) {
			if (string == null || string.length() == 0) return "";
			return Character.toUpperCase(string.charAt(0)) + (string.length() > 1 ? string.substring(1) : "");
		}

		private String lowFirst(String string) {
			if (string == null || string.length() == 0) return "";
			return Character.toLowerCase(string.charAt(0)) + (string.length() > 1 ? string.substring(1) : "");
		}

		private String toUpper(String text) {
			return text.toUpperCase();
		}

		private String humpToCap(String text) {
			final char[] chars = text.toCharArray();
			final StringBuilder out = new StringBuilder();
			boolean first = true;
			for (int i = 0; i < chars.length; i++) {
				char aChar = chars[i];
				if (!first && Character.isUpperCase(aChar) && (i < chars.length - 2 && Character.isLowerCase(chars[i + 1]))) {
					out.append("_");
				}
				first = false;
				out.append(Character.toUpperCase(aChar));
			}
			return out.toString();
		}

		private String camelHump(String text) {
			final char[] chars = text.toCharArray();
			final StringBuilder out = new StringBuilder();
			boolean capitalize = true;
			for (char aChar : chars) {
				if (Character.isWhitespace(aChar)) {
					capitalize = true;
					continue;
				}
				out.append(capitalize ? Character.toUpperCase(aChar) : aChar);
				capitalize = false;
			}
			return out.toString();
		}

		private String splitCamelHump(String text) {
			final char[] chars = text.toCharArray();
			final StringBuilder out = new StringBuilder();
			boolean first = true;
			for (char aChar : chars) {
				if (Character.isUpperCase(aChar)) out.append(" ");
				out.append(first ? Character.toUpperCase(aChar) : Character.toLowerCase(aChar));
				first = false;
			}
			return out.toString();
		}

		private String packageToPath(String packageName) {
			return (packageName == null ? "" : (packageName.replaceAll("[.]", "/") + java.io.File.separator));
		}
	}

	public String list(String delimiter, Object... elements) {
		final StringBuilder list = new StringBuilder();
		boolean first = true;
		for (Object element : elements) {
			if (!first) list.append(delimiter);
			list.append(element);
			first = false;
		}
		return list.toString() + delimiter;
	}
}