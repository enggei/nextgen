package com.generator.editors.domain;

import org.neo4j.graphdb.*;

import java.util.*;

/**
 * User: goe
 * Date: 20.05.14
 */
public class MetaRelation<E extends Enum<E>, R extends Enum<R>> {

    public enum Cardinality {OneToOne, OneToMany}

    public enum Direction {OneWay, BothWays}

    private final Enum<R> name;
    private final Cardinality cardinality;
    private final Direction direction;
    private final Map<String, E> sourceMap = new LinkedHashMap<>();
    private final Map<String, E> targetMap = new LinkedHashMap<>();

    private final Map<String, MetaProperty> propertySet = new LinkedHashMap<>();    // changed from TreeMap


    public MetaRelation(Enum<R> name, Set<E> source, Set<E> target, Cardinality cardinality, Direction direction) {
        this.name = name;
        for (E node : source)
            this.sourceMap.put(node.name(), node);
        for (E node : target)
            this.targetMap.put(node.name(), node);
        this.cardinality = cardinality;
        this.direction = direction;
    }


    public RelationshipType getType() {
        return DynamicRelationshipType.withName(this.name.name());
    }

    public MetaRelation addProperty(MetaProperty property) {
        propertySet.put(property.getName(), property);
        return this;
    }

    // todo: test this validation
    protected MetaRelation validate(String[] kv) {
        for (int i = 0; i < kv.length; i += 2) {
            if (kv[i + 1] == null) continue;

            boolean found = false;
            for (MetaProperty metaProperty : properties()) {
                if (metaProperty.getName().equals(kv[i])) {
                    if (!metaProperty.validate(kv[i + 1]))
                        throw new IllegalArgumentException("Cannot make relationship '" + getName() + "'. The property '" + kv[i] + "' has an illegal value '" + kv[i + 1] + "'. Legal values are " + metaProperty.getLegalValues());
                    found = true;
                    break;
                }
            }
            if (!found)
                throw new IllegalArgumentException("Cannot make relationship '" + getName() + "'. The property '" + kv[i] + "' is not defined for '" + getName() + "'");
        }

        return this;
    }


    public Set<MetaProperty> properties() {
        return new LinkedHashSet<>(propertySet.values());
    }

    public Map<String, Object> getPropertiesFrom(Relationship relationship) {
        final Map<String, Object> map = new TreeMap<>();
        for (MetaProperty metaProperty : propertySet.values()) {
            final Object value = metaProperty.valueIn(relationship);
            if (value != null) map.put(metaProperty.getName(), value);
        }
        return map;
    }

    public void validate(Collection<MetaNode<E>> nodes) {
        validate(nodes, sources(), "source");
        validate(nodes, targets(), "target");
    }

    public boolean validate(Node sourceNode, Node targetNode) {
        for (Label label : sourceNode.getLabels()) {
            if (sourceMap.containsKey(label.name())) {
                for (Label targetLabel : targetNode.getLabels()) {
                    if (targetMap.containsKey(targetLabel.name())) {
                        return true;
                    }
                }
            }
        }

        throw new IllegalArgumentException(this.name + " cannot validate " + printLabelsFor(sourceNode) + " -> " + printLabelsFor(targetNode));
    }

    private String printLabelsFor(Node node) {
        final StringBuilder out = new StringBuilder();
        for (Label label : node.getLabels()) out.append(label).append(" ");
        return "[" + out.toString().trim() + "]";
    }

    public boolean isSource(MetaNode node) {
        return sourceMap.containsKey(node.getLabel().name());
    }

    public boolean isTarget(MetaNode node) {
        return targetMap.containsKey(node.getLabel().name());
    }

    public Enum<R> getName() {
        return name;
    }

    public Set<E> sources() {
        return new LinkedHashSet<>(this.sourceMap.values());
    }

    public Set<E> targets() {
        return new LinkedHashSet<>(this.targetMap.values());
    }

    public Cardinality getCardinality() {
        return cardinality;
    }

    public String cypher(E source, E target) {
        return "(s:" + source + ")-[:" + name + "]-(t:" + target + ")";
    }

    public void validate(Collection<MetaNode<E>> nodes, Set<E> nodeNames, String nodeType) {
        for (E nodeName : nodeNames) {
            boolean found = false;
            for (MetaNode node : nodes) {
                if (nodeName.equals(node.getLabel())) {
                    found = true;
                    break;
                }
            }
            if (!found)
                throw new IllegalStateException("'" + name + "' could not find " + nodeType + "-node : '" + nodeName + "' in " + nodes);
        }
    }

    @Override
    public String toString() {
        return name + " : " + sourceMap + " " + cardinality + " " + targetMap;
    }
}