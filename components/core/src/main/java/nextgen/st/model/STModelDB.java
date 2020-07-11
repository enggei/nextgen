package nextgen.st.model;

import nextgen.st.domain.*;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;

import static nextgen.st.model.STValueType.*;

public class STModelDB extends STModelNeoFactory {

    private final Collection<STGroupModel> groupModels;

    public STModelDB(String dir, Collection<STGroupModel> groupModels) {
        super(dir);
        this.groupModels = groupModels;
        cleanup();
    }

    public STModelDB remove(STValue stValue) {
        final STValue found = findSTValueByUuid(stValue.getUuid());
        if (found == null) return this;
        found.getIncomingValue().forEach(this::remove);
        delete(found.getNode());
        return this;
    }

    public STModelDB remove(STArgument stArgument) {
        final STArgument found = findSTArgumentByUuid(stArgument.getUuid());
        if (found == null) return this;
        delete(found.getNode());
        return this;
    }

    public STModelDB remove(STModel stModel) {
        final STModel found = findSTModelByUuid(stModel.getUuid());
        if (found == null) return this;
        stModel.getArguments().forEach(this::remove);
        delete(found.getNode());
        return this;
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

    public void cleanup() {
        doInTransaction(transaction -> {

            getDatabaseService().getAllNodes().forEach(node -> {
                if (node.getRelationships().iterator().hasNext()) return;
                System.out.println("deleting unnused node " + node);
                node.delete();
            });

            final Set<String> uuids = new LinkedHashSet<>();

            findAllSTModel().forEach(stModel -> {

                if (uuids.contains(stModel.getUuid())) {
                    final String newUuid = UUID.randomUUID().toString();
                    System.out.println("found duplicate uuid " + stModel.getUuid() + " -> new " + newUuid);
                    stModel.setUuid(newUuid);
                }
                uuids.add(stModel.getUuid());

                try {
                    final STTemplate stTemplate = findSTTemplateByUuid(stModel.getStTemplate());
                    stModel.getArguments().forEach(stArgument -> {
                        final Optional<STParameter> first = stTemplate.getParameters().filter(stParameter -> stArgument.getStParameter().equals(stParameter.uuid())).findFirst();
                        if (!first.isPresent())
                            remove(stArgument);
                        else {
                            switch (first.get().getType()) {
                                case SINGLE:
                                case LIST:
                                    final STValue value = stArgument.getValue();
                                    if (value == null)
                                        remove(stArgument);
                                    else if (value.getType().equals(STValueType.STMODEL)) {

                                        final AtomicBoolean duplicate = new AtomicBoolean(false);
                                        java.util.stream.StreamSupport.stream(value.getNode().getRelationships(Direction.OUTGOING, org.neo4j.graphdb.RelationshipType.withName("stModel")).spliterator(), false)
                                                .sorted(java.util.Comparator.comparing(o -> (Long) o.getProperty("_t", o.getId())))
                                                .forEach(relationship -> {
                                                    if (duplicate.get()) {
                                                        relationship.delete();
                                                    } else {
                                                        duplicate.set(true);
                                                    }
                                                });

                                        if (value.getStModel() == null)
                                            remove(stArgument);
                                    }
                                    break;
                                case KVLIST:

                                    stArgument.getKeyValues().forEach(stArgumentKV -> {
                                        final STValue stArgumentKVValue = stArgumentKV.getValue();
                                        if (stArgumentKVValue == null) delete(stArgumentKV.getNode());
                                    });

                                    break;
                            }
                        }
                    });
                } catch (IllegalStateException ise) {
                    ise.printStackTrace();

                    if(ise.getMessage().startsWith("Missing uuid")) {
                        remove(stModel);
                    }
                }
            });
        });
    }

    public STModel clone(STModel stModel) {

        final STTemplate stTemplate = findSTTemplateByUuid(stModel.getStTemplate());

        final STModel clone = newSTModel(stTemplate);

        forEachArgument(stTemplate, stModel, (stArgument, stParameter) -> {
            switch (stParameter.getType()) {
                case SINGLE:
                    clone.addArguments(newSTArgument(stParameter, stArgument.getValue()));
                    break;
                case LIST:
                    clone.addArguments(newSTArgument(stParameter, stArgument.getValue()));
                    break;
                case KVLIST:
                    final Collection<STArgumentKV> kvs = new ArrayList<>();
                    stParameter.getKeys().forEach(stParameterKey -> {
                        stArgument.getKeyValues()
                                .filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.uuid()))
                                .findAny()
                                .ifPresent(stArgumentKV -> kvs.add(newSTArgumentKV(stParameterKey, stArgumentKV.getValue())));
                    });
                    clone.addArguments(newSTArgument(stParameter, kvs));
                    break;
            }
        });

        return clone;
    }

    protected void forEachArgument(STTemplate stTemplate, STModel stModel, java.util.function.BiConsumer<nextgen.st.model.STArgument, nextgen.st.domain.STParameter> consumer) {
        stTemplate.getParameters().forEach(stParameter -> stModel.getArguments().filter(stArgument -> stArgument.getStParameter().equals(stParameter.uuid())).forEach(stArgument -> consumer.accept(stArgument, stParameter)));
    }
}