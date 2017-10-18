package com.generator.generators.stringtemplate.domain;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STErrorListener;
import org.stringtemplate.v4.STGroupFile;
import org.stringtemplate.v4.misc.ErrorType;
import org.stringtemplate.v4.misc.STMessage;

import java.io.File;
import java.util.*;

import static com.generator.generators.stringtemplate.domain.TemplateEntities.TEMPLATEFILE;

/**
 * User: geirove
 * Date: 27.11.12
 * <p>
 * responsible for mapping between TemplateStatements
 */
public class TemplateFile extends BaseEntity<TemplateEntities> {

	private File file;
	private final Map<String, TemplateImport> imports = new TreeMap<>();
	private final Map<String, TemplateStatement> statements = new TreeMap<>();
	private String delimiter = "~";

	private TemplateFile(UUID uuid, File file, Map<String, TemplateImport> imports, Map<String, TemplateStatement> statements) {
		super(uuid, TEMPLATEFILE);
		this.file = file;
		this.imports.putAll(imports);
		this.statements.putAll(statements);
	}

	public TemplateFile(UUID uuid, char delimiterStartChar, File file, Map<String, TemplateImport> imports, Map<String, TemplateStatement> statements) {
		super(uuid, TEMPLATEFILE);
		this.file = file;
		this.imports.putAll(imports);
		this.statements.putAll(statements);
		this.delimiter = delimiterStartChar + "";
	}

	/**
	 * deep copy of template file
	 *
	 * @param path path to new file-location
	 * @return copy of this-sprites-state, with all new objects (all new UUIDS)
	 */
	public TemplateFile copy(String path) {

		final Map<String, TemplateImport> copiedImports = new LinkedHashMap<>();
		for (Map.Entry<String, TemplateImport> entry : imports.entrySet())
			copiedImports.put(entry.getKey(), entry.getValue());

		final Map<String, TemplateStatement> copiedStatements = new LinkedHashMap<>();
		for (Map.Entry<String, TemplateStatement> entry : statements.entrySet())
			copiedStatements.put(entry.getKey(), new TemplateStatement(entry.getValue()));

		return new TemplateFile(UUID.randomUUID(), new File(path), copiedImports, copiedStatements);
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getName() {
		return file.getName();
	}

	public List<TemplateImport> getImports() {
		return new ArrayList<>(imports.values());
	}

	public List<TemplateStatement> getStatements() {
		return new ArrayList<>(statements.values());
	}

	public TemplateStatement getTemplateStatement(String name) {
		return statements.get(name);
	}

	@Override
	public String toString() {
		final StringBuilder content = new StringBuilder("/* uuid : " + getUuid()).append(" */\n");

		//if (domainEntity.getDelimiter() != STGenerator.DEFAULT_DELIMITER)
		// todo: hardcoded delimiter :
		content.append("delimiters \"").append(delimiter).append("\", \"").append(delimiter).append("\"\n");

		for (TemplateImport templateImport : getImports())
			content.append("import \"").append(templateImport).append("\"\n");
		for (TemplateStatement statementEntry : getStatements())
			content.append("\n").append(statementEntry).append("\n");
		return content.toString();
	}

	public String render(Statement statement) {
		return new STGenerator<>(this.file).generate(statement);
	}

	public char getDelimiter() {
		return delimiter.charAt(0);
	}

	public static final class STGenerator<T extends Statement> {

		private static final DefaultAttributeRenderer defaultAttributeRenderer = new DefaultAttributeRenderer();

		private final STGroupFile groupFile;
		private final STErrorListener errorListener;

		STGenerator(STGroupFile groupFile) {
			this.groupFile = groupFile;
			this.errorListener = null;
			groupFile.registerRenderer(String.class, defaultAttributeRenderer);
		}

		STGenerator(String groupFile) {
			this(getTemplateGroup(groupFile));
		}

		STGenerator(File templateFile) {
			this(templateFile.getAbsolutePath());
		}

		static STGroupFile getTemplateGroup(String template) {
			final STGroupFile groupFile = new STGroupFile(template);
			groupFile.registerRenderer(String.class, defaultAttributeRenderer);
			return groupFile;
		}

		String generate(T statement) {
			return render(statement);
		}

		private String render(Statement statement) {
			final ST template = createSTFrom(statement);
			return template == null ? "" : template.render();
		}

		private ST createSTFrom(Statement statement) {
			return createSTFrom(statement, groupFile);
		}

		ST createSTFrom(Statement statement, STGroupFile groupFile) {
			final ST template = groupFile.getInstanceOf(statement.getStatementName());
			if (template == null) {
				final IllegalArgumentException cause = new IllegalArgumentException("template '" + statement.getStatementName() + "' is not found in " + groupFile.fileName);
				if (errorListener != null) {
					errorListener.IOError(new STMessage(ErrorType.INVALID_TEMPLATE_NAME, null, cause, statement.getStatementName()));
					return null;
				} else {
					throw cause;
				}
			}
			fill(template, statement.getProperties(), null, groupFile);
			return template;
		}

		void fill(ST template, List<Property> properties, String propertyName, STGroupFile groupFile) {

			if (properties == null) return;
			for (Property property : properties) {
				try {
					if (property instanceof StringProperty) {
						template.add(property.getPropertyName() == null ? propertyName : property.getPropertyName(), ((StringProperty) property).getValue());
					} else if (property instanceof BooleanProperty) {
						final Boolean value = ((BooleanProperty) property).getValue();
						if (value != null && value)
							template.add(property.getPropertyName() == null ? propertyName : property.getPropertyName(), true);
					} else if (property instanceof StatementProperty) {
						template.add(property.getPropertyName() == null ? propertyName : property.getPropertyName(), createSTFrom(((StatementProperty) property).getStatement(), groupFile).render());
					} else if (property instanceof ListProperty) {
						fill(template, ((ListProperty) property).getElements(), property.getPropertyName(), groupFile);
					} else if (property instanceof KeyValueListProperty) {
						for (List<Property> kvProperty : ((KeyValueListProperty) property).getElements()) {
							final KeyedValue aggregate = new KeyedValue(property.getPropertyName());
							fill(aggregate, kvProperty, groupFile);
							aggregate.addToTemplate(template);
						}
					}
				} catch (Exception e) {
					if (e.getMessage().contains("no such attribute:")) {
						System.out.print(e.getMessage() + " in template '" + template.getName() + "'. ignoring\n");
					} else
						throw new IllegalArgumentException(" '" + template.getName() + "' : " + e.getMessage());
				}
			}
		}

		private void fill(KeyedValue aggregate, List<Property> properties, STGroupFile groupFile) {
			for (Property property : properties) {
				if (property instanceof StringProperty) {
					aggregate.add(property.getPropertyName(), ((StringProperty) property).getValue());
				} else if (property instanceof BooleanProperty) {
					final Boolean value = ((BooleanProperty) property).getValue();
					if (value != null && value)
						aggregate.add(property.getPropertyName(), true);
				} else if (property instanceof StatementProperty) {
					aggregate.add(property.getPropertyName(), createSTFrom(((StatementProperty) property).getStatement(), groupFile).render());
				} else {
					System.out.println("ignoring " + aggregate.getName() + ".'" + property.getPropertyName() + "': cannot have a list of values in StringTemplate-output. Only one value can be assigned to a key in a key/value list in StringTemplate.");
				}
			}
		}

		public static final class KeyedValue {

			private final String name;
			private final List<Map<String, String>> values = new LinkedList<>();
			private int index = 0;

			KeyedValue(String name) {
				this.name = name;
			}

			public String getName() {
				return name;
			}

			public void add(String key, Object value) {
				if (value == null || value.toString().length() == 0) return;
				if (values.size() < (index + 1)) values.add(new HashMap<>());
				values.get(index).put(key, value.toString());
			}

			void addToTemplate(ST template) {
				for (Map<String, String> value : values) {
					boolean first = true;
					final StringBuilder keyName = new StringBuilder(name + ".{");

					final List<String> keys = new ArrayList<>(value.keySet());
					for (String key : keys) {
						if (!first) keyName.append(",");
						keyName.append(key);
						first = false;
					}
					keyName.append("}");

					final Object[] values = new Object[keys.size()];
					for (int i = 0; i < keys.size(); i++)
						values[i] = value.get(keys.get(i));
					template.addAggr(keyName.toString(), values);
				}
			}
		}

		private static final class DefaultAttributeRenderer implements org.stringtemplate.v4.AttributeRenderer {

			private enum FormatCode {
				capitalize, toUpper, lowFirst, toLower, humpToCap, camelHump, splitCamelHump
			}

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
					default:
						return o.toString();
				}
			}

			public String capitalize(String string) {
				if (string == null || string.length() == 0) return "";
				return Character.toUpperCase(string.charAt(0)) + (string.length() > 1 ? string.substring(1) : "");
			}

			public String lowFirst(String string) {
				if (string == null || string.length() == 0) return "";
				return Character.toLowerCase(string.charAt(0)) + (string.length() > 1 ? string.substring(1) : "");
			}

			public String toUpper(String text) {
				return text.toUpperCase();
			}

			public String humpToCap(String text) {
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

			public String camelHump(String text) {
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

			public String splitCamelHump(String text) {
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
		}
	}
}