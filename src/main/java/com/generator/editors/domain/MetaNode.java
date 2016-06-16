package com.generator.editors.domain;

import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;

import java.util.*;

/**
 * User: goe
 * Date: 20.05.14
 */
public class MetaNode<E extends Enum<E>> {

    private final Node node;
    private final String domain;
    private final E label;
    private final UUID uuid;
    private final Map<String, MetaProperty> propertySet = new LinkedHashMap<>();    // changed from TreeMap

    public MetaNode(Node node, String domain, E label, UUID uuid) {
        this.node = node;
        this.domain = domain;
        this.label = label;
        this.uuid = uuid;
    }

    public Node getNode() {
        return node;
    }

    public E getLabel() {
        return label;
    }

    public UUID getUuid() {
        return uuid;
    }

    public MetaNode addProperty(MetaProperty property) {
        propertySet.put(property.getName(), property);
        return this;
    }

    public Set<MetaProperty> properties() {
        return new LinkedHashSet<>(propertySet.values());
    }

    public Map<String, Object> getPropertiesFrom(Node node) {
        final Map<String, Object> map = new TreeMap<>();
        for (MetaProperty metaProperty : propertySet.values()) {
            final Object value = metaProperty.valueIn(node);
            if (value != null && !value.equals("[]")) map.put(metaProperty.getName(), value);
        }
        return map;
    }

    public String print(Node node) {
        final StringBuilder out = new StringBuilder();
        out.append(node.getLabels()).append(" : ");
        for (MetaProperty metaProperty : properties())
            out.append("\n\t").append(getLabel()).append(".").append(metaProperty.getName()).append(":").append((String)metaProperty.valueIn(node));
        return out.append("\n").toString();
    }

    @Override
    public String toString() {
        return this.domain + "." + label + " : " + propertySet;
    }

    protected MetaNode validate(String[] kv) {
        for (int i = 0; i < kv.length; i += 2) {
            if (kv[i + 1] == null) continue;

            boolean found = false;
            for (MetaProperty metaProperty : properties()) {
                if (metaProperty.getName().equals(kv[i])) {
                    if (!metaProperty.validate(kv[i + 1]))
                        throw new IllegalArgumentException("Cannot make node '" + label + "'. The property '" + kv[i] + "' has an illegal value '" + kv[i + 1] + "'. Legal values are " + metaProperty.getLegalValues());
                    found = true;
                    break;
                }
            }
            if (!found)
                throw new IllegalArgumentException("Cannot make node '" + label + "'. The property '" + kv[i] + "' is not defined for '" + label + "'");
        }

        return this;
    }

    public static String showLabelsFor(Node node) {
        final StringBuilder out = new StringBuilder();
        boolean first = true;
        for (Label label : node.getLabels()) {
            if (!first) out.append(" ");
            out.append(label);
            first = false;
        }
        return out.toString().trim();
    }
}