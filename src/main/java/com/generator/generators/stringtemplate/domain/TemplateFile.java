package com.generator.generators.stringtemplate.domain;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * User: geirove
 * Date: 27.11.12
 * <p>
 */
public class TemplateFile {

	private File file;
	private final Map<String, TemplateImport> imports = new TreeMap<>();
	private final Map<String, TemplateStatement> statements = new TreeMap<>();

	public TemplateFile(File file, Map<String, TemplateImport> imports, Map<String, TemplateStatement> statements) {
		this.file = file;
		this.imports.putAll(imports);
		this.statements.putAll(statements);
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
}