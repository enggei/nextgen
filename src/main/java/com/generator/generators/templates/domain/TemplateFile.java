package com.generator.generators.templates.domain;

import com.generator.domain.BaseEntity;
import com.generator.generators.STGenerator;
import com.generator.util.FileUtil;

import java.io.File;
import java.util.*;

import static com.generator.generators.templates.domain.TemplateEntities.TEMPLATEFILE;

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

	public TemplateFile(File file) {
		super(TEMPLATEFILE);
		this.file = file;
	}

	public TemplateFile(UUID uuid, File file, Map<String, TemplateImport> imports, Map<String, TemplateStatement> statements) {
		super(uuid, TEMPLATEFILE);
		this.file = file;
		this.imports.putAll(imports);
		this.statements.putAll(statements);
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

	public void addImport(TemplateImport templateImport) {
		this.imports.put(templateImport.getName(), templateImport);
	}

//   public void removeImport(String name) {
//      this.imports.remove(name);
//   }

	public List<TemplateStatement> getStatements() {
		return new ArrayList<>(statements.values());
	}

	public TemplateStatement getTemplateStatement(String name) {
		return statements.get(name);
	}

	public void addStatement(TemplateStatement statement) {
		this.statements.remove(statement.getName());
		this.statements.put(statement.getName(), statement);
	}

	public void removeStatement(String name) {

		final TemplateStatement remove = this.statements.get(name);
		if (remove == null) return;

		// don't delete if other statements are referencing the statement:
		for (TemplateStatement other : statements.values())
			if (other.getUuid().equals(remove.getUuid())) continue;

		this.statements.remove(name);
	}

	public void save() {
		FileUtil.write(toString(), this.file);
	}

	@Override
	public String toString() {
		final StringBuilder content = new StringBuilder("/* uuid : " + getUuid()).append(" */\n");

		//if (domainEntity.getDelimiter() != STGenerator.DEFAULT_DELIMITER)
		// todo: hardcoded delimiter :
		content.append("delimiters \"").append("~").append("\", \"").append("~").append("\"\n");

		for (TemplateImport templateImport : getImports())
			content.append("import \"").append(templateImport).append("\"\n");
		for (TemplateStatement statementEntry : getStatements())
			content.append("\n").append(statementEntry).append("\n");
		return content.toString();
	}

	public Set<TemplateStatement> getReferencedTemplates(TemplateStatement statement) {
		final Set<TemplateStatement> list = new LinkedHashSet<>();
		for (TemplateStatement other : this.statements.values()) {
			if (other.equals(statement)) continue;
		}
		return list;
	}

	public TemplateStatement getTemplateStatement(UUID uuid) {
		for (TemplateStatement statement : statements.values())
			if (uuid.equals(statement.getUuid())) return statement;
		return null;
	}

	public String render(Statement statement) {
		return new STGenerator<>(this.file).generate(statement);
	}

	public char getDelimiter() {
		// todo: hardcoded delimiter (default)
		return '~';
	}
}