package nextgen.st.model;

import nextgen.st.domain.*;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;

import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;
import java.util.UUID;

import static nextgen.st.model.STValueType.*;

public class STModelDB extends STModelNeoFactory {

    private final Collection<STGroupModel> groupModels;

    public STModelDB(String dir, Collection<STGroupModel> groupModels) {
        super(dir);
        this.groupModels = groupModels;
    }

    public STModelDB remove(STValue stValue) {
        final STValue found = findSTValueByUuid(stValue.getUuid());
        if (found == null) return this;
        delete(found.getNode());
        return this;
    }

    public STModelDB remove(STModel stModel) {
        final STModel found = findSTModelByUuid(stModel.getUuid());
        if (found == null) return this;
        deleteTree(found.getNode());
        return this;
    }

    // ONLY delete this value-node and its relations
    private void delete(Node node) {

        for (Relationship incoming : node.getRelationships(Direction.INCOMING))
            incoming.delete();

        for (Relationship outgoing : node.getRelationships(Direction.OUTGOING))
            outgoing.delete();

        node.delete();
    }

    // deletes node and its outgoing relations (NOT if it has incoming dependencies)
    private void deleteTree(Node node) {

        final Iterator<Relationship> incoming = node.getRelationships(Direction.INCOMING).iterator();
        if (incoming.hasNext()) return;

        for (Relationship outgoing : node.getRelationships(Direction.OUTGOING)) {
            final Node otherNode = outgoing.getOtherNode(node);
            outgoing.delete();
            deleteTree(otherNode);
        }

        node.delete();
    }

    public String getSTModelValue(STModel stModel, String parameterName, String defaultValue) {

        final STTemplate stTemplate = findSTTemplateByUuid(stModel.getStTemplate());

        final Optional<STParameter> foundParameter = stTemplate.getParameters()
                .filter(stParameter -> stParameter.getName().equals(parameterName))
                .findAny();
        if (!foundParameter.isPresent()) return defaultValue;

        return stModel.getArguments()
                .filter(stArgument -> stArgument.getStParameter().equals(foundParameter.get().uuid()))
                .map(stArgument -> stArgument.getValue().getValue())
                .findFirst()
                .orElse(defaultValue);
    }

    public String getSTModelName(STModel stModel, String defaultValue) {
        return getSTModelValue(stModel, "name", defaultValue);
    }

    public String getSTModelPackage(STModel stModel, String defaultValue) {
        final String found = getSTModelValue(stModel, "package", null);
        if (found != null) return found;
        return getSTModelValue(stModel, "packageName", defaultValue);
    }

    public STTemplate findSTTemplateByName(String name) {
        for (STGroupModel groupModel : groupModels) {
            final STTemplate stTemplate = findSTTemplateByName(groupModel, name);
            if (stTemplate != null) return stTemplate;
        }
        return null;
    }

    private STTemplate findSTTemplateByName(STGroupModel groupModel, String name) {
        final Iterator<STTemplate> iterator = groupModel.getTemplates().iterator();
        while (iterator.hasNext()) {
            final STTemplate stTemplate = findSTTemplateByName(iterator.next(), name);
            if (stTemplate != null) return stTemplate;
        }
        return null;
    }

    private STTemplate findSTTemplateByName(STTemplate stTemplate, String name) {
        if (name.equals(stTemplate.getName())) return stTemplate;

        final Iterator<STTemplate> iterator = stTemplate.getChildren().iterator();
        while (iterator.hasNext()) {
            final STTemplate child = findSTTemplateByName(iterator.next(), name);
            if (child != null) return child;
        }
        return null;
    }

    public STTemplate findSTTemplateByUuid(String uuid) {
        for (STGroupModel groupModel : groupModels) {
            final STTemplate stTemplate = findSTTemplateByUuid(groupModel, uuid);
            if (stTemplate != null) return stTemplate;
        }
        throw new IllegalStateException("Missing uuid " + uuid);
    }

    private STTemplate findSTTemplateByUuid(STGroupModel groupModel, String stTemplateUuid) {
        final Iterator<STTemplate> iterator = groupModel.getTemplates().iterator();
        while (iterator.hasNext()) {
            final STTemplate stTemplate = findSTTemplateByUuid(iterator.next(), stTemplateUuid);
            if (stTemplate != null) return stTemplate;
        }
        return null;
    }

    private STTemplate findSTTemplateByUuid(STTemplate stTemplate, String stTemplateUuid) {
        if (stTemplateUuid.equals(stTemplate.uuid())) return stTemplate;

        final Iterator<STTemplate> iterator = stTemplate.getChildren().iterator();
        while (iterator.hasNext()) {
            final STTemplate child = findSTTemplateByUuid(iterator.next(), stTemplateUuid);
            if (child != null) return child;
        }
        return null;
    }

    public void addArgument(STModel stModel, STParameter stParameter, final Collection<STArgumentKV> kvs) {
        stModel.addArguments(newSTArgument(stParameter, kvs));
    }

    public void addArgument(STModel stModel, STParameter stParameter, STValue value) {
        stModel.addArguments(newSTArgument(stParameter, value));
    }

    public void setArgument(STModel stModel, STParameter stParameter, STValue value) {
        stModel.getArguments()
                .filter(stArgument -> stArgument.getStParameter().equals(stParameter.uuid()))
                .findAny()
                .ifPresent(stModel::removeArguments);

        stModel.addArguments(newSTArgument(stParameter, value));
    }

    public STFile newSTFile(String name, String type, String path, String packageName) {
        return newSTFile()
                .setUuid(UUID.randomUUID().toString())
                .setName(name)
                .setType(type)
                .setPath(path)
                .setPackageName(packageName);
    }

    public STModel newSTModel(STTemplate stTemplate) {
        return newSTModel()
                .setUuid(UUID.randomUUID().toString())
                .setStTemplate(stTemplate.uuid());
    }

    public STArgument newSTArgument(STParameter stParameter, final Collection<STArgumentKV> kvs) {
        final STArgument stArgument = newSTArgument(stParameter);
        for (STArgumentKV kv : kvs) stArgument.addKeyValues(kv);
        return stArgument;
    }

    public STArgument newSTArgument(STParameter stParameter, STValue stValue) {
        return newSTArgument(stParameter)
                .setValue(stValue);
    }

    public STValue newSTValue(STModel stModel) {
        return newSTValue()
                .setUuid(UUID.randomUUID().toString())
                .setType(STMODEL)
                .setStModel(stModel);
    }

    public STValue newSTValue(String value) {
        return newSTValue()
                .setUuid(UUID.randomUUID().toString())
                .setType(PRIMITIVE)
                .setValue(value);
    }

    public STValue newSTValue(STEnumValue stEnumValue) {
        return newSTValue()
                .setUuid(UUID.randomUUID().toString())
                .setType(ENUM)
                .setValue(stEnumValue.getLexical() == null || stEnumValue.getLexical().trim().length() == 0 ? stEnumValue.getName() : stEnumValue.getLexical());
    }

    public STArgumentKV newSTArgumentKV(STParameterKey key, STValue stValue) {
        return newSTArgumentKV()
                .setUuid(UUID.randomUUID().toString())
                .setStParameterKey(key.uuid())
                .setValue(stValue);
    }

    private STArgument newSTArgument(STParameter stParameter) {
        return newSTArgument()
                .setUuid(UUID.randomUUID().toString())
                .setStParameter(stParameter.uuid());
    }
}