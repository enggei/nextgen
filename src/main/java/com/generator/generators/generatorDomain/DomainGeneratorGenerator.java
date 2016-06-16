package com.generator.generators.generatorDomain;

import com.generator.editors.domain.NeoModel;
import com.generator.generators.templates.domain.GeneratedFile;
import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;

import java.awt.*;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import static com.generator.editors.domain.MetaDomain.MetaRelations.DefaultValue;

/**
 * goe on 4/23/15.
 */
public class DomainGeneratorGenerator extends GeneratorDomainVisitor {

	private final GeneratorDomainGroup stGroup = new GeneratorDomainGroup();

	private GeneratorDomainGroup.domainST domainST;

	public DomainGeneratorGenerator(Component component) {
		super(component, "Generate Domain-generator");
	}

	@Override
	<T> T visitDOMAIN(Node node) {

		this.domainST = stGroup.newdomain().
			setName(get(node, "name")).
			setPackage(get(node, "package"));

		if (has(node, "root"))
			this.targetFile = GeneratedFile.newJavaFile(get(node, "root").toString(), get(node, "package").toString(), get(node, "name").toString()).getFile();

		if (has(node, "comments")) domainST.setComments(get(node, "comments"));

		for (Relationship rel : outgoing(node, GeneratorDomain.RELATIONS.TERM))
			visitENTITY(rel.getOtherNode(node));

		for (Relationship relationship : outgoing(node, GeneratorDomain.RELATIONS.CONSTRAINT))
			visitRELATION(relationship.getOtherNode(node));

		return (T) this.domainST.toString();
	}

	@Override
	<T> T visitENTITY(Node node) {

		final GeneratorDomainGroup.entityDeclarationST declarationST = stGroup.newentityDeclaration().
			setName(get(node, "name"));

		if (isTrue(node, "root"))
			domainST.setRoot(get(node, "name"));

		// add-method
		final GeneratorDomainGroup.addEntityST addEntityST = stGroup.newaddEntity().
			setName(get(node, "name"));

		// add node-properties
		for (Relationship feature : outgoing(node, GeneratorDomain.RELATIONS.FEATURE)) {
			final Node nodePropertyNode = feature.getOtherNode(node);

			final String propertyValue = get(nodePropertyNode, "value", "");

			if (propertyValue.contains(",")) {
				final GeneratorDomainGroup.propertyInstantiationLegalValuesST propertyInstantiationST = stGroup.newpropertyInstantiationLegalValues().
					setName(get(nodePropertyNode, "name")).
					setType(get(nodePropertyNode, "type"));

				for (String s : propertyValue.split(",")) {
					if (s.trim().length() == 0) continue;
					propertyInstantiationST.addLegalValuesValue(s);
				}

				declarationST.addPropertiesValue(propertyInstantiationST);

			} else {
				declarationST.addPropertiesValue(stGroup.newpropertyInstantiation().
					setName(get(nodePropertyNode, "name")).
					setType(get(nodePropertyNode, "type")).
					setDefaultValue(get(nodePropertyNode, "value")));

				addEntityST.addPropertiesValue(get(nodePropertyNode, "name"));
			}
		}

		// todo add node default values here
		GeneratorDomainGroup.defaultValuesST defaultValues = null;
		GeneratorDomainGroup.defaultValuesAccessorST defaultValueAccessor = null;
		for (Relationship relationship : outgoing(node, DefaultValue)) {

			final Node defaultValueNode = relationship.getOtherNode(node);

			final GeneratorDomainGroup.defaultValueInitializationST defaultValueInitializationST = stGroup.newdefaultValueInitialization().
				setUuid(get(defaultValueNode, NeoModel.TAG_UUID)).
				setType(get(node, "name")).
				setValueKey(get(defaultValueNode, "name"));

			for (String propertyKey : defaultValueNode.getPropertyKeys()) {
				if (NeoModel.TAG_UUID.equals(propertyKey)) continue; // uuid already set above
				if (get(defaultValueNode, propertyKey, "").length() == 0) continue;
				defaultValueInitializationST.addKeyValuesValue(propertyKey, get(defaultValueNode, propertyKey, ""));
			}

			if (defaultValues == null) defaultValues = stGroup.newdefaultValues();
			defaultValues.addValuesValue(defaultValueInitializationST);

			if (defaultValueAccessor == null)
				defaultValueAccessor = stGroup.newdefaultValuesAccessor().
					setName(get(node, "name"));
		}

		domainST.addEntitiesValue(addEntityST, declarationST, defaultValueAccessor, defaultValues, get(node, "name"));

		return (T) declarationST;
	}

	@Override
	<T> T visitRELATION(Node node) {

		validateHasProperty(node, "name");
		validateHasProperty(node, "direction");
		validateHasProperty(node, "cardinality");

		final Object relationName = get(node, "name");
		final Object relationDirection = get(node, "direction");
		final Object relationCardinality = get(node, "cardinality");

		final GeneratorDomainGroup.relationDeclarationST relationDeclarationST = stGroup.newrelationDeclaration().
			setName(relationName).
			setDirection(relationDirection).
			setCardinality(relationCardinality);

		// add relationship-properties
		final Set<String> properties = new LinkedHashSet<>();
		for (Relationship feature : outgoing(node, GeneratorDomain.RELATIONS.FEATURE)) {
			final Node relationPropertyNode = feature.getOtherNode(node);
			relationDeclarationST.addPropertiesValue(stGroup.newpropertyInstantiation().
				setName(get(relationPropertyNode, "name")).
				setType(get(relationPropertyNode, "type")).
				setDefaultValue(get(relationPropertyNode, "value")));

			properties.add(get(relationPropertyNode, "name", "?"));
		}

		// find sources and destinations for this relation:
		Set<String> sources = new TreeSet<>();
		for (Relationship relationProperty : all(node, GeneratorDomain.RELATIONS.SOURCES)) {

			// NEW, improved model
			final Object sourceName = getOtherProperty(node, relationProperty, "name");
			if (sourceName != null) {
				relationDeclarationST.addSourceValue(sourceName);
				sources.add(sourceName.toString());
			}

			// old, deprecated
			final Node sourcesNode = relationProperty.getOtherNode(node);
			for (Relationship sourceMember : incoming(sourcesNode, DynamicRelationshipType.withName("MEMBER"))) {
				final Object oldSourcename = getOtherProperty(sourcesNode, sourceMember, "name");
				if (sources.contains(oldSourcename)) continue;
				relationDeclarationST.addSourceValue(oldSourcename);
				sources.add(oldSourcename.toString());
			}
		}

		Set<String> destinations = new TreeSet<>();
		for (Relationship relationProperty : all(node, GeneratorDomain.RELATIONS.DESTINATIONS)) {

			// NEW, improved model
			final Object destinationName = getOtherProperty(node, relationProperty, "name");
			if (destinationName != null) {
				relationDeclarationST.addDestinationValue(destinationName);
				destinations.add(destinationName.toString());
			}

			// old, deprecated
			final Node destinationsNode = relationProperty.getOtherNode(node);
			for (Relationship destinationMember : incoming(destinationsNode, DynamicRelationshipType.withName("MEMBER"))) {
				final Object oldDestinationname = getOtherProperty(destinationsNode, destinationMember, "name");
				if (destinations.contains(oldDestinationname)) continue;
				relationDeclarationST.addDestinationValue(oldDestinationname);
				destinations.add(oldDestinationname.toString());
			}
		}

		final Relationship domainRelation = singleIncoming(node, GeneratorDomain.RELATIONS.CONSTRAINT);
		final StringBuilder adders = new StringBuilder();
		if ("OneToOne".equals(relationCardinality)) {
			for (String source : sources) {
				for (String dest : destinations) {
					System.out.println(source + " -> [:" + relationName + "] -> " + dest);

					final GeneratorDomainGroup.addRelationST addRelationST = stGroup.newaddRelation().
						setName(get(node, "name")).
						setDomain(getOtherProperty(node, domainRelation, "name")).
						setSrc(source).
						setDst(dest);

					for (String property : properties)
						addRelationST.addPropertiesValue(property);

					adders.append(addRelationST.toString()).append("\n");
				}
			}

		} else if ("OneToMany".equals(relationCardinality)) {
			for (String source : sources) {
				for (String dest : destinations) {
					System.out.println(source + " -> *[:" + relationName + "] -> " + dest);

					final GeneratorDomainGroup.addRelationST addRelationST = stGroup.newaddRelation().
						setName(get(node, "name")).
						setDomain(getOtherProperty(node, domainRelation, "name")).
						setSrc(source).
						setDst(dest);

					for (String property : properties)
						addRelationST.addPropertiesValue(property);

					adders.append(addRelationST.toString()).append("\n");
				}
			}
		}

		domainST.addRelationsValue(adders, relationDeclarationST, relationName);

		return (T) relationDeclarationST;
	}

	@Override
	public <T> void done(T result) {
		showOutput(result);
	}
}