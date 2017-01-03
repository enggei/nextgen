package com.generator.generators.templates.editor;

import com.generator.editors.NeoModel;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.stringtemplate.v4.AttributeRenderer;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupString;

import java.io.File;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.generator.editors.BaseDomainVisitor.get;
import static com.generator.editors.NeoModel.uuidOf;
import static com.generator.generators.templates.editor.TemplateDomain.TemplateLabels.*;
import static com.generator.generators.templates.editor.TemplateDomain.TemplateRelations.*;

/**
 * goe on 11/28/16.
 * todo: export cypher / import cypher
 * todo: create group and neo from templateGroup (replace functionality in TemplateFileEditor)
 * todo: create a method for cleanup: remove all non-related SingleValues and Statements
 * todo: create a method for cloning nodes /trees ?
 */
public class TemplateDomain {

	public enum TemplateLabels implements Label {
		TemplateGroup, TemplateStatement,
		SingleTemplateParameter, ListTemplateParameter, KeyValueTemplateParameter,
		Statement, SingleValue, KeyValueSet,
		Project, Directory
	}

	public enum TemplateProperties implements Label {
		name, relationType, value, keys, text, delimiter,
		packageName, path, outputFormat,
		// statementLabel is property on TemplateStatement to render statement
		statementLabel
	}

	public enum TemplateRelations implements RelationshipType {
		TEMPLATE_GROUP, IMPORT, TEMPLATE_STATEMENT, TEMPLATE_PARAMETER, DIRECTORY_MEMBER, PROJECT_DIRECTORY
	}

	public static Node newProject(NeoModel db, String name) {
		final Node node = db.newNode(Project);
		node.setProperty(TemplateProperties.name.name(), name);
		return node;
	}

	public static Node newDirectory(NeoModel db, String path) {
		final Node node = db.newNode(Directory);
		node.setProperty(TemplateProperties.name.name(), path);
		return node;
	}

	public static Node newTemplateGroup(NeoModel db, String name, String delimiter) {
		final Node node = db.newNode(TemplateGroup);
		node.setProperty(TemplateProperties.name.name(), name);
		node.setProperty(TemplateProperties.delimiter.name(), delimiter);

		// fixes for bugs in template (always include)
//		newTemplateStatement(db, node, "bugFixEndMethod", "}");
//		newTemplateStatement(db, node, "bugFixEndStatement", ">");

		return node;
	}

	public static Node newTemplateStatement(NeoModel db, Node templateGroup, String templateStatementName, String templateStatementText) {

		final StringBuilder existingReferences = new StringBuilder("");
		new TemplateGroupVisitor() {
			@Override
			protected void onTemplateStatementStart(String name, String text, Node templateStatement) {
				if (templateStatementName.equals(name))
					existingReferences.append("\n").append(NeoModel.getNameOrLabelFrom(templateStatement)).append(" (").append(uuidOf(templateStatement)).append(")");
			}
		}.visitTemplateGroup(templateGroup);

		if (existingReferences.length() > 0)
			throw new IllegalArgumentException("cannot create new TemplateStatement since the name is already taken in TemplateGroup by " + existingReferences);

		final Node node = db.newNode(TemplateStatement);
		node.setProperty(TemplateProperties.name.name(), templateStatementName);
		node.setProperty(TemplateProperties.text.name(), templateStatementText);
		node.createRelationshipTo(templateGroup, TEMPLATE_GROUP);
		return node;
	}

	public static Node newSingleTemplateParameter(NeoModel db, Node templateStatement, String newName) {

		final Set<Node> existing = new LinkedHashSet<>();
		new TemplateGroupVisitor() {
			@Override
			protected void onSingleTemplateParameter(String name, Node parameterNode) {
				// name already exist, and is a singleTemplateParameter. use this instead
				if (name.equals(newName)) existing.add(parameterNode);
			}
		}.visitTemplateStatement(templateStatement);

		if (existing.isEmpty()) {
			final Node node = db.newNode(SingleTemplateParameter);
			node.setProperty(TemplateProperties.name.name(), newName);
			final Relationship relationship = node.createRelationshipTo(templateStatement, TEMPLATE_PARAMETER);
			relationship.setProperty(TemplateProperties.relationType.name(), SingleTemplateParameter.name());
			return node;
		}

		return existing.iterator().next();
	}

	public static Node newListTemplateParameter(NeoModel db, Node templateStatement, String newName) {

		final Set<Node> existing = new LinkedHashSet<>();
		new TemplateGroupVisitor() {
			@Override
			protected void onListTemplateParameter(String name, Node parameterNode) {
				if (name.equals(newName)) existing.add(parameterNode);
			}
		}.visitTemplateStatement(templateStatement);

		if (existing.isEmpty()) {
			final Node node = db.newNode(ListTemplateParameter);
			node.setProperty(TemplateProperties.name.name(), newName);
			final Relationship relationship = node.createRelationshipTo(templateStatement, TEMPLATE_PARAMETER);
			relationship.setProperty(TemplateProperties.relationType.name(), ListTemplateParameter.name());
			return node;
		}

		return existing.iterator().next();
	}

	public static Node newKeyValueListTemplateParameter(NeoModel db, Node templateStatement, String newName, String[] newKeys) {

		final Set<Node> existing = new LinkedHashSet<>();
		new TemplateGroupVisitor() {

			@Override
			protected void onKeyValueTemplateParameter(String name, String oldKeys, Node parameterNode) {

				if (name.equals(newName)) {
					existing.add(parameterNode);

					// append any new keys
					final StringBuilder serialized = new StringBuilder(oldKeys);
					for (String newKey : newKeys) {
						boolean hasKey = false;
						for (String oldKey : oldKeys.split(" ")) {
							if (newKey.equals(oldKey)) {
								hasKey = true;
								break;
							}
						}
						if (!hasKey) serialized.append(" ").append(newKey);
					}
					parameterNode.setProperty(TemplateProperties.keys.name(), serialized.toString().trim());
				}
			}
		}.visitTemplateStatement(templateStatement);

		if (existing.isEmpty()) {
			final Node node = db.newNode(KeyValueTemplateParameter);
			node.setProperty(TemplateProperties.name.name(), newName);
			final StringBuilder serialized = new StringBuilder();
			for (String key : newKeys) serialized.append(key).append(" ");
			node.setProperty(TemplateProperties.keys.name(), serialized.toString().trim());
			final Relationship relationship = node.createRelationshipTo(templateStatement, TEMPLATE_PARAMETER);
			relationship.setProperty(TemplateProperties.relationType.name(), KeyValueTemplateParameter.name());
			return node;
		}

		return existing.iterator().next();
	}

	public static Node newStatement(NeoModel db, Node templateStatement) {
		final Node newNode = db.newNode(Statement);
		newNode.createRelationshipTo(templateStatement, TEMPLATE_STATEMENT);
		return newNode;
	}

	public static Node newSingleValue(NeoModel db, Object value) {
		Node newNode = db.newNode(SingleValue);
		newNode.setProperty(TemplateProperties.value.name(), value.toString());
		return newNode;
	}

	public static Node newKeyValueSet(NeoModel db, Node statement, Node templateParameter) {
		final Node newNode = db.newNode(KeyValueSet);
		newNode.createRelationshipTo(templateParameter, TEMPLATE_PARAMETER);
		statement.createRelationshipTo(newNode, RelationshipType.withName(get(templateParameter, TemplateProperties.name.name())));
		return newNode;
	}


	public static String render(Node statement) {

		final StringBuilder out = new StringBuilder();

		new StatementVisitor() {

			private ST st;

			// key-value set
			private StringBuilder aggr;
			boolean first = true;
			final Map<String, String> aggrValues = new LinkedHashMap<>();

			@Override
			protected void onStatementStart(Node statementTemplate, Node templateGroup) {
				final STGroupString stGroup = new STGroupString(asSTGString(templateGroup));
				stGroup.registerRenderer(String.class, newTemplateStringRenderer());
				st = stGroup.getInstanceOf(get(statementTemplate, TemplateProperties.name.name()));
			}

			@Override
			protected void onSingleValue(String name, Node referenceNode, TemplateLabels referenceNodeType) {
				st.add(name, renderReferenceNode(referenceNode, referenceNodeType));
			}

			@Override
			protected void onListValue(String name, Node referenceNode, TemplateLabels referenceNodeType) {
				st.add(name, renderReferenceNode(referenceNode, referenceNodeType));
			}

			@Override
			protected void onStartKeyValueSet(String name, Node keyValueNode) {
				aggr = new StringBuilder(name + ".{");
				first = true;
				aggrValues.clear();
			}

			@Override
			protected void onKeyValue(String key, Node referenceNode, TemplateLabels referenceNodeType) {
				if (!first) aggr.append(",");
				first = false;
				aggr.append(key);
				aggrValues.put(key, renderReferenceNode(referenceNode, referenceNodeType));
			}

			@Override
			protected void onEndKeyValueSet(Node keyValueNode) {
				if (first) return;

				final Object[] values = new Object[aggrValues.keySet().size()];
				int index = 0;
				for (String key : aggrValues.keySet())
					values[index++] = aggrValues.get(key);
				aggr.append("}");
				st.addAggr(aggr.toString(), values);
			}

			@Override
			protected void onStatementEnd() {
				out.append(st.render());
			}


		}.visitStatement(statement);

		return out.toString();
	}

	public static String renderReferenceNode(Node referenceNode, TemplateLabels referenceNodeType) {

		if (referenceNode == null) return null;

		switch (referenceNodeType) {

			case Statement:
				return render(referenceNode);

			case SingleValue:
				return get(referenceNode, TemplateProperties.value.name());
		}

		throw new IllegalArgumentException("cannot render " + NeoModel.getNameOrLabelFrom(referenceNode) + "(" + referenceNodeType + ")");
	}


	static String asSTGString(Node templateGroup) {
		final StringBuilder out = new StringBuilder();
		final AtomicBoolean firstParameter = new AtomicBoolean(true);

		new TemplateGroupVisitor() {
			@Override
			protected void onTemplateGroupStart(String name, String delimiter, Node templateGroup) {
				out.append("/* ").append(name).append(" ").append(uuidOf(templateGroup)).append("*/").append("\n");
				out.append("delimiters \"").append(delimiter).append("\", \"").append(delimiter).append("\"");
			}

			@Override
			protected void onTemplateStatementStart(String name, String text, Node templateStatement) {
				out.append("\n\n").append(name).append("(");
				firstParameter.set(true);
			}

			@Override
			protected void onSingleTemplateParameter(String name, Node parameterNode) {
				if (!firstParameter.get()) out.append(",");
				out.append(name);
				firstParameter.set(false);
			}

			@Override
			protected void onListTemplateParameter(String name, Node parameterNode) {
				if (!firstParameter.get()) out.append(",");
				out.append(name);
				firstParameter.set(false);
			}

			@Override
			protected void onKeyValueTemplateParameter(String name, String keys, Node parameterNode) {
				if (!firstParameter.get()) out.append(",");
				out.append(name);
				firstParameter.set(false);
			}

			@Override
			protected void onTemplateStatementEnd(String name, String text, Node templateStatement) {
				// ST bug if error message when tail of a template is '>>>' avoid by add a space before end of statement
				out.append(") ::= <<").append(text).append(text.endsWith(">") ? " >>" : ">>");
			}

		}.visitTemplateGroup(templateGroup);

		return out.toString();
	}

	private static AttributeRenderer newTemplateStringRenderer() {
		return new AttributeRenderer() {

			@Override
			public String toString(Object o, String formatString, Locale locale) {

				final String text = o.toString();

				if (formatString == null) return text;

				switch (formatString) {
					case "capitalize":
						return capitalize(text);
					case "toUpper":
						return toUpper(text);
					case "lowFirst":
						return lowFirst(text);
					case "toLower":
						return text.toLowerCase();
					case "humpToCap":
						return humpToCap(text);
					case "camelHump":
						return camelHump(text);
					case "splitCamelHump":
						return splitCamelHump(text);
					case "packageToPath":
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
				return (packageName == null ? "" : (packageName.replaceAll("[.]", "/") + File.separator));
			}
		};
	}
}