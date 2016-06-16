package com.generator.generators.templates.domain;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.util.UUID;

import static com.generator.generators.templates.domain.TemplateEntities.STATEMENTPROPERTY;

/**
 * User: geirove
 * Date: 30.08.12
 */
public class StatementProperty extends Property {

	private final String propertyName;
	protected Statement statement;

	public StatementProperty(UUID uuid, String propertyName) {
		super(uuid, STATEMENTPROPERTY);
		this.propertyName = propertyName;
	}

	public StatementProperty(UUID uuid, String propertyName, Statement statement) {
		super(uuid, STATEMENTPROPERTY);
		this.propertyName = propertyName;
		this.statement = statement;
	}

	public StatementProperty(StatementProperty statementProperty) {
		super(STATEMENTPROPERTY);
		this.propertyName = statementProperty.getPropertyName();
		this.statement = new Statement(statementProperty.getStatement());
	}

	public StatementProperty(String name, Statement statement) {
		super(UUID.randomUUID(), STATEMENTPROPERTY);
		this.propertyName = name;
		this.statement = statement;
	}

	public StatementProperty(Statement statement) {
		super(UUID.randomUUID(), STATEMENTPROPERTY);
		this.propertyName = null;
		this.statement = statement;
	}

	public StatementProperty(String name) {
		super(UUID.randomUUID(), STATEMENTPROPERTY);
		this.propertyName = name;
	}

	public Statement getStatement() {
		return statement;
	}

	public StatementProperty setStatement(Statement statement) {
		this.statement = statement;
		return this;
	}

	@Override
	public JsonObject toJson() {

		final JsonObject statementJson = new JsonObject().
			put("name", statement.getStatementName());

		final JsonArray jsonProperties = new JsonArray();
		for (Property property : statement.getProperties())
			jsonProperties.add(property.toJson());
		statementJson.put("properties", jsonProperties);

		return newJson().
			put("statement", statementJson);
	}

	@Override
	public String getPropertyName() {
		return propertyName;
	}

	@Override
	public boolean removeProperty(UUID uuid) {
		return statement.removeProperty(uuid);
	}

	@Override
	public void renameTemplateStatement(String oldName, String newName) {
		statement.renameTemplateStatement(oldName, newName);
	}

	@Override
	public Property copy() {
		return new StatementProperty(this.uuid, this.propertyName, this.statement.copy());
	}

	@Override
	public String toString() {
		return (getPropertyName() == null ? "" : (getPropertyName() + ":")) + getStatement();
	}
}