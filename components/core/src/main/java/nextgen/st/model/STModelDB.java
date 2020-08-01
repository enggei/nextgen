package nextgen.st.model;

import nextgen.st.STAppEvents;
import nextgen.st.domain.*;
import nextgen.utils.Neo4JUtil;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.event.TransactionData;
import org.neo4j.graphdb.event.TransactionEventHandler;

import java.util.*;

import static nextgen.st.model.STValueType.*;

public class STModelDB extends STModelNeoFactory {

    private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STModel.class);

    private final Collection<STGroupModel> groupModels;

    public STModelDB(String dir, Collection<STGroupModel> groupModels) {
        super(dir);
        this.groupModels = groupModels;

        getDatabaseService().registerTransactionEventHandler(new TransactionEventHandler.Adapter<Object>() {
            @Override
            public Object beforeCommit(TransactionData data) throws Exception {

//                System.out.println("deletedNodes");
//                data.deletedNodes().forEach(node -> System.out.println(Neo4JUtil.toString(node)));
//                System.out.println("deletedRelationships");
//                data.deletedRelationships().forEach(relationship -> System.out.println(Neo4JUtil.toString(relationship)));
//
//                System.out.println("createdNodes");
//                data.createdNodes().forEach(node -> System.out.println(Neo4JUtil.toString(node)));
//                System.out.println("createdRelationships");
//                data.createdRelationships().forEach(relationship -> System.out.println(Neo4JUtil.toString(relationship)));

                return super.beforeCommit(data);
            }

            @Override
            public void afterCommit(TransactionData data, Object state) {
                super.afterCommit(data, state);
            }

            @Override
            public void afterRollback(TransactionData data, Object state) {
                super.afterRollback(data, state);
            }
        });

        cleanup();
    }

    public Collection<STGroupModel> getGroupModels() {
        return groupModels;
    }

    public STModelDB remove(Script script) {
        delete(script.getNode());
        return this;
    }

    public STModelDB remove(STValue stValue) {
        final STValue found = findSTValueByUuid(stValue.getUuid());
        if (found == null) return this;
        //found.getIncomingValue().forEach(this::remove);
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

    public static Optional<STTemplate> findSTTemplateByName(STGroupModel groupModel, String name) {
        final Iterator<STTemplate> iterator = groupModel.getTemplates().iterator();
        while (iterator.hasNext()) {
            final STTemplate stTemplate = findSTTemplateByName(iterator.next(), name);
            if (stTemplate != null) return Optional.of(stTemplate);
        }
        return Optional.empty();
    }

    public static STTemplate findSTTemplateByName(STTemplate stTemplate, String name) {
        if (name.equals(stTemplate.getName())) return stTemplate;

        final Iterator<STTemplate> iterator = stTemplate.getChildren().iterator();
        while (iterator.hasNext()) {
            final STTemplate child = findSTTemplateByName(iterator.next(), name);
            if (child != null) return child;
        }
        return null;
    }

    public STGroupModel findSTGroupModelByTemplateUuid(String uuid) {
        for (STGroupModel groupModel : groupModels) {
            final STTemplate stTemplate = findSTTemplateByUuid(groupModel, uuid);
            if (stTemplate != null) return groupModel;
        }
        return null;
    }

    public STTemplate findSTTemplateByUuid(String uuid) {
        for (STGroupModel groupModel : groupModels) {
            final STTemplate stTemplate = findSTTemplateByUuid(groupModel, uuid);
            if (stTemplate != null) return stTemplate;
        }
        return null;
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

    public Project newProject(String name) {
        return newProject()
                .setUuid(UUID.randomUUID().toString())
                .setName(name);
    }

    public Script newScript(String name) {
        return newScript()
                .setUuid(UUID.randomUUID().toString())
                .setName(name);
    }

    public STFile newSTFile(String name, String type, String path, String packageName) {
        return newSTFile()
                .setUuid(UUID.randomUUID().toString())
                .setName(newSTValue(name))
                .setType(findOrCreateSTValueByValue(type))
                .setPath(newSTValue(path))
                .setPackageName(newSTValue(packageName));
    }

    public STModel newSTModel(String stGroupModel, STTemplate stTemplate) {
        final STModel stModel = newSTModel()
                .setUuid(UUID.randomUUID().toString())
                .setStTemplate(stTemplate.uuid())
                .setStGroup(stGroupModel);
        STAppEvents.postSTModelCreated(stModel);
        return stModel;
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

    public Script newScript(Node node) {
        return new Script(node);
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
            deleteUnnusedNodes();
            deleteUnnusedFiles();
        });
    }

    public void deleteUnnusedFiles() {
        findAllSTFile().forEach(stFile -> {
            if (stFile.getIncomingFiles().iterator().hasNext()) return;
            log.info("deleting unnused stFile-" + stFile.getUuid());
            log.info(Neo4JUtil.toString(stFile.getNode()));
            stFile.getNode().getRelationships().forEach(Relationship::delete);
            stFile.getNode().delete();
        });
    }

    public void deleteUnnusedNodes() {
        getDatabaseService().getAllNodes().forEach(node -> {
            if (node.getRelationships().iterator().hasNext()) return;
            if (node.hasLabel(Label.label("Script"))) return;
            log.info("deleting unnused node");
            log.info(Neo4JUtil.toString(node));
            node.delete();
        });
    }

    public STModel clone(STModel stModel) {

        final STTemplate stTemplate = findSTTemplateByUuid(stModel.getStTemplate());

        final STModel clone = newSTModel(stModel.getStGroup(), stTemplate);

        // ensure cloned-arguments are in same order as stModel-arguments:
        stModel.getArgumentsSorted()
                .forEach(stArgument -> stTemplate.getParameters()
                        .filter(stParameter -> stArgument.getStParameter().equals(stParameter.uuid()))
                        .findFirst()
                        .ifPresent(stParameter -> {
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

                        }));

        return clone;
    }

}