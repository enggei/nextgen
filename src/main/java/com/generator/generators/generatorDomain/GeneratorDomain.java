package com.generator.generators.generatorDomain;

import com.generator.editors.domain.MetaDomain;
import com.generator.editors.domain.MetaNode;
import com.generator.editors.domain.MetaProperty;
import com.generator.editors.domain.NeoModel;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;

import java.util.UUID;

import static com.generator.generators.generatorDomain.GeneratorDomain.ENTITIES.*;
import static com.generator.generators.generatorDomain.GeneratorDomain.RELATIONS.*;
import static com.generator.editors.domain.MetaRelation.Cardinality.OneToMany;
import static com.generator.editors.domain.MetaRelation.Cardinality.OneToOne;
import static com.generator.editors.domain.MetaRelation.Direction.OneWay;

/**
 * Meta-domain to describe meta-domain
 */
public class GeneratorDomain extends MetaDomain<GeneratorDomain.ENTITIES, GeneratorDomain.RELATIONS> {

	public enum ENTITIES {
		ENTITY, DOMAIN, RELATION, PROPERTY, STATEMENTPARAMETER, TEMPLATEGROUP, STATEMENT
	}

	public enum RELATIONS implements RelationshipType {
		CONSTRAINT, FEATURE, TERM, SOURCES, DESTINATIONS, STATEMENTS, PARAMETERS, STGROUP
	}

	public GeneratorDomain(final NeoModel model) {
		super(model, "GeneratorDomain");

		System.out.println("check removal of templateFile and targetFile");

		try (Transaction tx = model.beginTx()) {

			addMetaNode(ENTITIES.ENTITY, UUID.randomUUID())
				.addProperty(new MetaProperty("name", "name").setType("String"))
				.addProperty(new MetaProperty("background", "#8dd3c7").setType("color hex"))
				.addProperty(new MetaProperty("selectedBackground", "#8dd3c7").setType("color hex"))
				.addProperty(new MetaProperty("labelColor", "#b30000").setType("color hex"))
				.addProperty(new MetaProperty("selectedLabelColor", "#fee8c8").setType("color hex"))
				.addProperty(new MetaProperty("width", "22").setType("integer"))
				.addProperty(new MetaProperty("height", "20").setType("integer"))
				.addProperty(new MetaProperty("root").setType("boolean"))
				.addProperty(new MetaProperty("comments").setType("String"));
			addMetaNode(ENTITIES.DOMAIN, UUID.randomUUID())
				.addProperty(new MetaProperty("name", "name").setType("String"))
//                    .addProperty(new MetaProperty("templateFile", "/media/storage/projects/generator/src/com/generator/generators/generator/generatorDomain.stg").setType("String"))
				.addProperty(new MetaProperty("package").setType("java package"))
				.addProperty(new MetaProperty("comments").setType("String"))
//                    .addProperty(new MetaProperty("targetFile", "/media/storage/projects/generator/src/com/generator/generators").setType("File"))
			;
			addMetaNode(ENTITIES.RELATION, UUID.randomUUID())
				.addProperty(new MetaProperty("name", "name").setType("String"))
				.addProperty(new MetaProperty("cardinality", "OneToMany").setType("Cardinality"))
				.addProperty(new MetaProperty("direction", "OneWay").setType("direction"))
				.addProperty(new MetaProperty("comments").setType("String"));
			addMetaNode(ENTITIES.PROPERTY, UUID.randomUUID())
				.addProperty(new MetaProperty("name", "name").setType("String"))
				.addProperty(new MetaProperty("value").setType("String"))
				.addProperty(new MetaProperty("type", "String").setType("type"))
				.addProperty(new MetaProperty("comments").setType("String"));
			addMetaNode(ENTITIES.STATEMENTPARAMETER, UUID.randomUUID())
				.addProperty(new MetaProperty("name").setType("String"));
			addMetaNode(ENTITIES.TEMPLATEGROUP, UUID.randomUUID());
			addMetaNode(ENTITIES.STATEMENT, UUID.randomUUID())
				.addProperty(new MetaProperty("content").setType("String"))
				.addProperty(new MetaProperty("name").setType("String"));

			addMetaRelation(CONSTRAINT, newNodeSet(DOMAIN), newNodeSet(RELATION), OneToMany, OneWay)
				.addProperty(new MetaProperty("comments").setType("String"));
			addMetaRelation(FEATURE, newNodeSet(ENTITY, RELATION), newNodeSet(PROPERTY), OneToMany, OneWay)
				.addProperty(new MetaProperty("comments").setType("String"));
			addMetaRelation(TERM, newNodeSet(DOMAIN), newNodeSet(ENTITY), OneToMany, OneWay)
				.addProperty(new MetaProperty("comments").setType("String"));
			addMetaRelation(SOURCES, newNodeSet(RELATION), newNodeSet(ENTITY), OneToMany, OneWay)
				.addProperty(new MetaProperty("comments").setType("String"));
			addMetaRelation(DESTINATIONS, newNodeSet(RELATION), newNodeSet(ENTITY), OneToMany, OneWay)
				.addProperty(new MetaProperty("comments").setType("String"));
			addMetaRelation(STATEMENTS, newNodeSet(TEMPLATEGROUP), newNodeSet(STATEMENT), OneToMany, OneWay);
			addMetaRelation(PARAMETERS, newNodeSet(STATEMENT), newNodeSet(STATEMENTPARAMETER), OneToMany, OneWay);
			addMetaRelation(STGROUP, newNodeSet(DOMAIN), newNodeSet(TEMPLATEGROUP), OneToOne, OneWay);

			validate();

			tx.success();
		}
	}

	@Override
	protected final ENTITIES entity(String s) {
		return ENTITIES.valueOf(s);
	}

	@Override
	protected final RELATIONS relation(String s) {
		return RELATIONS.valueOf(s);
	}

	@Override
	public final MetaNode<ENTITIES> getRootNode() {
		return getNode(DOMAIN);
	}

	@Override
	public final boolean isConstrained(Node node) {
		return super.isConstrained(node);
	}

	public Node addENTITY(UUID uuid, String _name, String _background, String _selectedBackground, String _labelColor, String _selectedLabelColor, String _width, String _height, String _root, String _comments) {
		return newNode(ENTITIES.ENTITY, uuid, "name", (_name == null || _name.trim().length() == 0) ? "[]" : _name, "background", (_background == null || _background.trim().length() == 0) ? "[]" : _background, "selectedBackground", (_selectedBackground == null || _selectedBackground.trim().length() == 0) ? "[]" : _selectedBackground, "labelColor", (_labelColor == null || _labelColor.trim().length() == 0) ? "[]" : _labelColor, "selectedLabelColor", (_selectedLabelColor == null || _selectedLabelColor.trim().length() == 0) ? "[]" : _selectedLabelColor, "width", (_width == null || _width.trim().length() == 0) ? "[]" : _width, "height", (_height == null || _height.trim().length() == 0) ? "[]" : _height, "root", (_root == null || _root.trim().length() == 0) ? "[]" : _root, "comments", (_comments == null || _comments.trim().length() == 0) ? "[]" : _comments);
	}

	public Node addDOMAIN(UUID uuid, String _name, String _templateFile, String _package, String _comments, String _targetFile) {
		return newNode(ENTITIES.DOMAIN, uuid, "name", (_name == null || _name.trim().length() == 0) ? "[]" : _name, "templateFile", (_templateFile == null || _templateFile.trim().length() == 0) ? "[]" : _templateFile, "package", (_package == null || _package.trim().length() == 0) ? "[]" : _package, "comments", (_comments == null || _comments.trim().length() == 0) ? "[]" : _comments, "targetFile", (_targetFile == null || _targetFile.trim().length() == 0) ? "[]" : _targetFile);
	}

	public Node addRELATION(UUID uuid, String _name, String _cardinality, String _direction, String _comments) {
		return newNode(ENTITIES.RELATION, uuid, "name", (_name == null || _name.trim().length() == 0) ? "[]" : _name, "cardinality", (_cardinality == null || _cardinality.trim().length() == 0) ? "[]" : _cardinality, "direction", (_direction == null || _direction.trim().length() == 0) ? "[]" : _direction, "comments", (_comments == null || _comments.trim().length() == 0) ? "[]" : _comments);
	}

	public Node addPROPERTY(UUID uuid, String _name, String _value, String _type, String _comments) {
		return newNode(ENTITIES.PROPERTY, uuid, "name", (_name == null || _name.trim().length() == 0) ? "[]" : _name, "value", (_value == null || _value.trim().length() == 0) ? "[]" : _value, "type", (_type == null || _type.trim().length() == 0) ? "[]" : _type, "comments", (_comments == null || _comments.trim().length() == 0) ? "[]" : _comments);
	}

	public Node addSTATEMENTPARAMETER(UUID uuid, String _name) {
		return newNode(ENTITIES.STATEMENTPARAMETER, uuid, "name", (_name == null || _name.trim().length() == 0) ? "[]" : _name);
	}

	public Node addTEMPLATEGROUP(UUID uuid) {
		return newNode(ENTITIES.TEMPLATEGROUP, uuid);
	}

	public Node addSTATEMENT(UUID uuid, String _content, String _name) {
		return newNode(ENTITIES.STATEMENT, uuid, "content", (_content == null || _content.trim().length() == 0) ? "[]" : _content, "name", (_name == null || _name.trim().length() == 0) ? "[]" : _name);
	}

	public GeneratorDomain relateDOMAIN_CONSTRAINT_RELATION(Node domainSrc, Node relationDst, String _comments) {
		relate(RELATIONS.CONSTRAINT, domainSrc, relationDst, "comments", (_comments == null || _comments.trim().length() == 0) ? "[]" : _comments);
		return this;
	}

	public GeneratorDomain relateENTITY_FEATURE_PROPERTY(Node entitySrc, Node propertyDst, String _comments) {
		relate(RELATIONS.FEATURE, entitySrc, propertyDst, "comments", (_comments == null || _comments.trim().length() == 0) ? "[]" : _comments);
		return this;
	}

	public GeneratorDomain relateRELATION_FEATURE_PROPERTY(Node relationSrc, Node propertyDst, String _comments) {
		relate(RELATIONS.FEATURE, relationSrc, propertyDst, "comments", (_comments == null || _comments.trim().length() == 0) ? "[]" : _comments);
		return this;
	}


	public GeneratorDomain relateDOMAIN_TERM_ENTITY(Node domainSrc, Node entityDst, String _comments) {
		relate(RELATIONS.TERM, domainSrc, entityDst, "comments", (_comments == null || _comments.trim().length() == 0) ? "[]" : _comments);
		return this;
	}


	public GeneratorDomain relateRELATION_SOURCES_ENTITY(Node relationSrc, Node entityDst, String _comments) {
		relate(RELATIONS.SOURCES, relationSrc, entityDst, "comments", (_comments == null || _comments.trim().length() == 0) ? "[]" : _comments);
		return this;
	}


	public GeneratorDomain relateRELATION_DESTINATIONS_ENTITY(Node relationSrc, Node entityDst, String _comments) {
		relate(RELATIONS.DESTINATIONS, relationSrc, entityDst, "comments", (_comments == null || _comments.trim().length() == 0) ? "[]" : _comments);
		return this;
	}


	public GeneratorDomain relateTEMPLATEGROUP_Statements_STATEMENT(Node templategroupSrc, Node statementDst) {
		relate(RELATIONS.STATEMENTS, templategroupSrc, statementDst);
		return this;
	}


	public GeneratorDomain relateSTATEMENT_Parameters_STATEMENTPARAMETER(Node statementSrc, Node statementparameterDst) {
		relate(RELATIONS.PARAMETERS, statementSrc, statementparameterDst);
		return this;
	}


	public GeneratorDomain relateDOMAIN_StGroup_TEMPLATEGROUP(Node domainSrc, Node templategroupDst) {
		relate(RELATIONS.STGROUP, domainSrc, templategroupDst);
		return this;
	}

}