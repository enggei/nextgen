package com.nextgen.core.template;

import com.nextgen.core.template.st.TemplateParameter;
import com.nextgen.core.template.st.TemplateStatement;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;

import java.util.LinkedHashMap;
import java.util.Map;

final class STTemplateManager {

    private final Node stTemplateNode;
    private final Map<String, Node> existingParameters = new LinkedHashMap<>();
    private final Map<String, Map<String, Node>> existingKeyValues = new LinkedHashMap<>();
    private final GraphDatabaseService db;

    STTemplateManager(GraphDatabaseService db, Node stTemplateNode) {

        this.db = db;

        Template.get_STTemplateParameter_PARAMETER_for_STTemplate(stTemplateNode, (relationship, other) -> {
            existingParameters.put(Template.getName(other), other);

            final Map<String, Node> keyValues = new LinkedHashMap<>();
            Template.get_STKeyValue_KEY_VALUE_for_STTemplateParameter(other, (relationship1, other1) -> {
                keyValues.put(Template.getName(other1), other1);
                return false;
            });
            existingKeyValues.put(Template.getName(other), keyValues);

            return false;
        });

        this.stTemplateNode = stTemplateNode;
    }

    void merge(TemplateStatement templateStatement) {

        Template.setText(stTemplateNode, templateStatement.getText());
        Template.setName(stTemplateNode, templateStatement.getName());

        for (TemplateParameter templateParameter : templateStatement.getParameters()) {

            // find existing parameter:
            final Node existingParameter = existingParameters.remove(templateParameter.getPropertyName());
            if (existingParameter == null) {
                // add new parameter
                addNewParameter(templateParameter);

            } else {

                // existing parameter, check types:
                if (templateParameter.getType().name().equals(Template.getParameterType(existingParameter).name())) {
                    for (String key : templateParameter.getKvNames()) {
                        if (existingKeyValues.get(templateParameter.getPropertyName()).keySet().contains(key))
                            continue;
                        // new key; add it
                        Template.relate_STTemplateParameter_KEY_VALUE_STKeyValue(existingParameter, Template.newSTKeyValue(db, key));
                    }

                    // remove any old keys:
                    for (Map.Entry<String, Node> existingKvEntry : existingKeyValues.get(templateParameter.getPropertyName()).entrySet()) {
                        if (templateParameter.getKvNames().contains(existingKvEntry.getKey())) continue;
                        deleteSTKeyValue(existingKvEntry.getValue());
                    }

                } else {

                    if (Template.ParameterType.STRINGPROPERTY.equals(Template.getParameterType(existingParameter)) && Template.ParameterType.LISTPROPERTY.equals(templateParameter.getType())) {

                        // single to list
                        // ok, just keep existing and allow to add more values

                        Template.setParameterType(existingParameter, Template.ParameterType.LISTPROPERTY);

                    } else if (Template.ParameterType.LISTPROPERTY.equals(Template.getParameterType(existingParameter)) && Template.ParameterType.KEYVALUELISTPROPERTY.equals(templateParameter.getType())) {

                        // list to keyvalue
                        // assign first key to existing values

                        // change parameter-type and add key-values:
                        Template.setParameterType(existingParameter, Template.ParameterType.KEYVALUELISTPROPERTY);
                        for (String key : templateParameter.getKvNames())
                            Template.relate_STTemplateParameter_KEY_VALUE_STKeyValue(existingParameter, Template.newSTKeyValue(db, key));

                        // get current list-values, and turn valueNode into a key-value node, take its current value and put it as value in first key:
                        Template.get_Value_PARAMETER_REFERENCE_for_STTemplateParameter(existingParameter, (relationship, valueNode) -> {

                            final Node stInstanceReference = Template.get_STInstance_INSTANCE_REFERENCE_for_Value(valueNode);

                            // get first key-value parameter
                            Template.get_STKeyValue_KEY_VALUE_for_STTemplateParameter(existingParameter, (relationship1, keyValueParameter) -> {

                                // create a key-value node for current value:
                                final Node kv = Template.newValue(db, null);
                                Template.relate_Value_KEY_REFERENCE_STKeyValue(kv, keyValueParameter);
                                Template.relate_SrcValue_KV_VALUES_Value(valueNode, kv);

                                if (stInstanceReference == null) {
                                    Template.setValue(kv, Template.getValue(valueNode));
                                    Template.setValue(valueNode, "");
                                } else {
                                    Template.relate_Value_INSTANCE_REFERENCE_STInstance(kv, stInstanceReference);
                                    valueNode.getSingleRelationship(Template.Relations.INSTANCE_REFERENCE, Direction.OUTGOING).delete();
                                }

                                return true;
                            });

                            return false;
                        });

                    } else {

                        // single to keyvalue
                        // what to do with the current value ? assign to first element and which key ?

                        // list to single
                        // there might be many values, which one to keep and which ones to delete ?

                        // keyvalue to single
                        // list of key values to single value, not compatible

                        // keyvalue to list
                        // keep any key-value? merge all these into the list ?

                        // delete existing and replace with new parameter:
                        deleteSTParameter(existingParameter);
                        addNewParameter(templateParameter);
                    }
                }
            }
        }

        // remove any old parameters, along with its values
        for (Node oldParameter : existingParameters.values())
            deleteSTParameter(oldParameter);

    }

    private void addNewParameter(TemplateParameter templateParameter) {
        final Node newSTTemplateParameter = Template.newSTTemplateParameter(db, Template.ParameterType.valueOf(templateParameter.getType().name()), templateParameter.getPropertyName());
        Template.relate_STTemplate_PARAMETER_STTemplateParameter(stTemplateNode, newSTTemplateParameter);
        for (String key : templateParameter.getKvNames())
            Template.relate_STTemplateParameter_KEY_VALUE_STKeyValue(newSTTemplateParameter, Template.newSTKeyValue(db, key));
    }

    void deleteSTParameter(Node stParameter) {

        final Relationship parameterRelation = stParameter.getSingleRelationship(Template.Relations.PARAMETER, Direction.INCOMING);
        if (parameterRelation != null) parameterRelation.delete();

        stParameter.getRelationships(Template.Relations.PARAMETER_REFERENCE, Direction.INCOMING).forEach(relationship -> deleteValueNode(relationship.getOtherNode(stParameter)));

        stParameter.getRelationships(Template.Relations.KEY_VALUE, Direction.OUTGOING).forEach(relationship -> deleteSTKeyValue(relationship.getOtherNode(stParameter)));
    }

    private void deleteSTKeyValue(Node stKeyValue) {

        stKeyValue.getSingleRelationship(Template.Relations.KEY_VALUE, Direction.INCOMING).delete();

        Template.get_Value_KEY_REFERENCE_for_STKeyValue(stKeyValue, (KEY_REFERENCE, valueNode) -> {
            deleteValueNode(valueNode);
            return false;
        });
    }

    void deleteValueNode(Node valueNode) {

        final Relationship parameterReference = valueNode.getSingleRelationship(Template.Relations.PARAMETER_REFERENCE, Direction.OUTGOING);
        if (parameterReference != null) parameterReference.delete();

        final Relationship instanceReference = valueNode.getSingleRelationship(Template.Relations.INSTANCE_REFERENCE, Direction.OUTGOING);
        if (instanceReference != null) instanceReference.delete();

        final Relationship keyValueReference = valueNode.getSingleRelationship(Template.Relations.KEY_REFERENCE, Direction.OUTGOING);
        if (keyValueReference != null) keyValueReference.delete();

        valueNode.getRelationships(Template.Relations.VALUES, Direction.INCOMING).forEach(Relationship::delete);

        Template.get_Value_KV_VALUES_for_SrcValue(valueNode, (KV_VALUES, kvValue) -> {
            KV_VALUES.delete();
            deleteValueNode(kvValue);
            return false;
        });

        valueNode.delete();
    }
}