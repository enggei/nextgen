package com.generator.generators.easyFlow;

import com.generator.editors.domain.MetaDomain;
import com.generator.editors.domain.MetaNode;
import com.generator.editors.domain.MetaProperty;
import com.generator.editors.domain.NeoModel;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;

import java.util.UUID;

import static com.generator.editors.domain.MetaRelation.Cardinality.OneToMany;
import static com.generator.editors.domain.MetaRelation.Cardinality.OneToOne;
import static com.generator.editors.domain.MetaRelation.Direction.OneWay;
import static com.generator.generators.easyFlow.EasyFlowDomain.ENTITIES.*;
import static com.generator.generators.easyFlow.EasyFlowDomain.RELATIONS.*;

/**
 *
 */
public class EasyFlowDomain extends MetaDomain<EasyFlowDomain.ENTITIES, EasyFlowDomain.RELATIONS> {

	public enum ENTITIES {
		Flow, ContextProperty, State, Event, SuperParameter
	}

	public enum RELATIONS implements RelationshipType {
		FROM, ON, TO, FINISH, PROPERTY, SUPERPARAMETERS
	}

	public EasyFlowDomain(final NeoModel model) {
		super(model, "EasyFlowDomain");

		try (Transaction tx = model.beginTx()) {

			addMetaNode(ENTITIES.Flow, UUID.randomUUID())
				.addProperty(new MetaProperty("name").setType("String"))
				.addProperty(new MetaProperty("extends").setType("String"))
				.addProperty(new MetaProperty("package").setType("String"))
				.addProperty(new MetaProperty("templateFile", "easyFlow.stg").setType("String"));
			addMetaNode(ENTITIES.ContextProperty, UUID.randomUUID())
				.addProperty(new MetaProperty("name").setType("String"))
				.addProperty(new MetaProperty("type").setType("String"))
				.addProperty(new MetaProperty("modifier").setType("String"))
				.addProperty(new MetaProperty("comment").setType("String"))
				.addProperty(new MetaProperty("value").setType("String"));
			addMetaNode(ENTITIES.State, UUID.randomUUID())
				.addProperty(new MetaProperty("name").setType("String"))
				.addProperty(new MetaProperty("comment").setType("String"));
			addMetaNode(ENTITIES.Event, UUID.randomUUID())
				.addProperty(new MetaProperty("name").setType("String"));
			addMetaNode(ENTITIES.SuperParameter, UUID.randomUUID())
				.addProperty(new MetaProperty("name").setType("String"))
				.addProperty(new MetaProperty("type").setType("String"));

			addMetaRelation(FROM, newNodeSet(Flow), newNodeSet(State), OneToOne, OneWay);
			addMetaRelation(ON, newNodeSet(State), newNodeSet(Event), OneToMany, OneWay);
			addMetaRelation(TO, newNodeSet(Event), newNodeSet(State), OneToOne, OneWay);
			addMetaRelation(FINISH, newNodeSet(Event), newNodeSet(State), OneToOne, OneWay);
			addMetaRelation(PROPERTY, newNodeSet(Flow), newNodeSet(ContextProperty), OneToMany, OneWay);
			addMetaRelation(SUPERPARAMETERS, newNodeSet(Flow), newNodeSet(SuperParameter), OneToMany, OneWay);

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
		return getNode(Flow);
	}

	@Override
	public final boolean isConstrained(Node node) {
		return super.isConstrained(node);
	}

	public Node addFlow(UUID uuid, String _name, String _contextName, String _extends, String _package, String _templateFile, String _contextGeneric) {
		return newNode(ENTITIES.Flow, uuid, "name", (_name == null || _name.trim().length() == 0) ? "[]" : _name, "contextName", (_contextName == null || _contextName.trim().length() == 0) ? "[]" : _contextName, "extends", (_extends == null || _extends.trim().length() == 0) ? "[]" : _extends, "package", (_package == null || _package.trim().length() == 0) ? "[]" : _package, "templateFile", (_templateFile == null || _templateFile.trim().length() == 0) ? "[]" : _templateFile, "contextGeneric", (_contextGeneric == null || _contextGeneric.trim().length() == 0) ? "[]" : _contextGeneric);
	}

	public Node addContextProperty(UUID uuid, String _name, String _type, String _modifier, String _comment, String _value) {
		return newNode(ENTITIES.ContextProperty, uuid, "name", (_name == null || _name.trim().length() == 0) ? "[]" : _name, "type", (_type == null || _type.trim().length() == 0) ? "[]" : _type, "modifier", (_modifier == null || _modifier.trim().length() == 0) ? "[]" : _modifier, "comment", (_comment == null || _comment.trim().length() == 0) ? "[]" : _comment, "value", (_value == null || _value.trim().length() == 0) ? "[]" : _value);
	}

	public Node addState(UUID uuid, String _name, String _comment) {
		return newNode(ENTITIES.State, uuid, "name", (_name == null || _name.trim().length() == 0) ? "[]" : _name, "comment", (_comment == null || _comment.trim().length() == 0) ? "[]" : _comment);
	}

	public Node addEvent(UUID uuid, String _name) {
		return newNode(ENTITIES.Event, uuid, "name", (_name == null || _name.trim().length() == 0) ? "[]" : _name);
	}

	public Node addSuperParameter(UUID uuid, String _name, String _type) {
		return newNode(ENTITIES.SuperParameter, uuid, "name", (_name == null || _name.trim().length() == 0) ? "[]" : _name, "type", (_type == null || _type.trim().length() == 0) ? "[]" : _type);
	}

	public EasyFlowDomain relateFlow_FROM_State(Node flowSrc, Node stateDst) {
		relate(RELATIONS.FROM, flowSrc, stateDst);
		return this;
	}


	public EasyFlowDomain relateState_ON_Event(Node stateSrc, Node eventDst) {
		relate(RELATIONS.ON, stateSrc, eventDst);
		return this;
	}


	public EasyFlowDomain relateEvent_TO_State(Node eventSrc, Node stateDst) {
		relate(RELATIONS.TO, eventSrc, stateDst);
		return this;
	}


	public EasyFlowDomain relateEvent_FINISH_State(Node eventSrc, Node stateDst) {
		relate(RELATIONS.FINISH, eventSrc, stateDst);
		return this;
	}


	public EasyFlowDomain relateFlow_PROPERTY_ContextProperty(Node flowSrc, Node contextpropertyDst) {
		relate(RELATIONS.PROPERTY, flowSrc, contextpropertyDst);
		return this;
	}


	public EasyFlowDomain relateFlow_SuperParameters_SuperParameter(Node flowSrc, Node superparameterDst) {
		relate(RELATIONS.SUPERPARAMETERS, flowSrc, superparameterDst);
		return this;
	}

}