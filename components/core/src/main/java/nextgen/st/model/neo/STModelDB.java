package nextgen.st.model.neo;

import nextgen.st.domain.STGroupModel;
import nextgen.st.domain.STParameter;
import nextgen.st.domain.STParameterKey;
import nextgen.st.domain.STTemplate;
import nextgen.st.model.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;
import java.util.stream.Stream;

public class STModelDB extends STModelNeoNeoFactory {

    private final Collection<STGroupModel> groupModels;

    public STModelDB(String dir, Collection<STGroupModel> groupModels) {
        super(dir);
        this.groupModels = groupModels;
    }

    public Stream<STModel> getAllSTModels() {
        return findAllSTModelNeo().map(this::map);
    }

    public STModelNeo save(STModel stModel) {
        final STModelNeo singleModelNeo = findOrCreateSTModelNeoByUuid(stModel.getUuid().toString());
        singleModelNeo.setStTemplate(stModel.getStTemplate().uuid());
        singleModelNeo.setFile(save(stModel.getFile()));
        singleModelNeo.removeAllArguments();
        stModel.getArguments().forEach(stArgument -> singleModelNeo.addArguments(save(stArgument)));
        return singleModelNeo;
    }

    public STFileNeo save(STFile stFile) {

        if (stFile == null) return null;

        final STFileNeo stFileNeo = findOrCreateSTFileNeoByUuid(stFile.getUuid().toString());
        stFileNeo.setName(stFile.getName());
        stFileNeo.setPackageName(stFile.getPackageName());
        stFileNeo.setPath(stFile.getPath());
        stFileNeo.setType(stFile.getType());
        return stFileNeo;
    }

    public STArgumentNeo save(STArgument stArgument) {
        final STArgumentNeo stArgumentNeo = findOrCreateSTArgumentNeoByUuid(stArgument.getUuid().toString());
        stArgumentNeo.setStParameter(stArgument.getStParameter().uuid());
        stArgumentNeo.setValue(save(stArgument.getValue()));
        stArgumentNeo.removeAllKeyValues();
        for (STArgumentKV stArgumentKV : stArgument.getKeyValues()) stArgumentNeo.addKeyValues(save(stArgumentKV));
        return stArgumentNeo;
    }

    public STArgumentKVNeo save(STArgumentKV stArgumentKV) {
        final STArgumentKVNeo stArgumentKVNeo = findOrCreateSTArgumentKVNeoByUuid(stArgumentKV.getUuid().toString());
        stArgumentKVNeo.setStParameterKey(stArgumentKV.getStParameterKey().uuid());
        stArgumentKVNeo.setValue(save(stArgumentKV.getValue()));
        return stArgumentKVNeo;
    }

    public STValueNeo save(STValue stValue) {

        if (stValue == null) return null;

        final STValueNeo stValueNeo = findOrCreateSTValueNeoByUuid(stValue.getUuid().toString());
        stValueNeo.setType(stValue.getType().name());
        switch (stValue.getType()) {
            case STMODEL:
                stValueNeo.removeValue();
                stValueNeo.setStModel(save(((STModel) stValue.getValue())));
                break;
            case PRIMITIVE:
            case ENUM:
                stValueNeo.removeStModel();
                stValueNeo.setValue(stValue.getValue().toString());
                break;
        }
        return stValueNeo;
    }

    private STModel map(STModelNeo stModelNeo) {
        final STTemplate stTemplate = findSTModel(stModelNeo.getStTemplate());
        final STModel stModel = new STModel(UUID.fromString(stModelNeo.getUuid()));
        stModel.setStTemplate(stTemplate);
        stModel.setFile(map(stModelNeo.getFile()));
        stModelNeo.getArgumentsSorted().forEach(stArgumentNeo -> stModel.addArguments(map(stArgumentNeo, stTemplate)));
        return stModel;
    }

    private STFile map(STFileNeo fileNeo) {

        if (fileNeo == null) return null;

        final STFile stFile = new STFile(UUID.fromString(fileNeo.getUuid()));
        stFile.setPackageName(fileNeo.getPackageName());
        stFile.setName(fileNeo.getName());
        stFile.setType(fileNeo.getType());
        stFile.setPath(fileNeo.getPath());
        return stFile;
    }

    private STArgument map(STArgumentNeo stArgumentNeo, STTemplate stTemplate) {
        final STParameter stParameter = findSTParameter(stArgumentNeo.getStParameter(), stTemplate);
        final STArgument stArgument = new STArgument(UUID.fromString(stArgumentNeo.getUuid()));
        stArgument.setStParameter(stParameter);
        stArgument.setValue(map(stArgumentNeo.getValue()));
        stArgumentNeo.getKeyValuesSorted().forEach(stArgumentKVNeo -> stArgument.addKeyValues(map(stArgumentKVNeo, stParameter)));
        return stArgument;
    }

    private STArgumentKV map(STArgumentKVNeo stArgumentKVNeo, STParameter stParameter) {
        final STArgumentKV stArgumentKV = new STArgumentKV(UUID.fromString(stArgumentKVNeo.getUuid()));
        stArgumentKV.setStParameterKey(findSTParameterKey(stArgumentKVNeo.getStParameterKey(), stParameter));
        stArgumentKV.setValue(map(stArgumentKVNeo.getValue()));
        return stArgumentKV;
    }

    private STValue map(STValueNeo stValueNeo) {

        if (stValueNeo == null) return null;

        final STValue stValue = new STValue(UUID.fromString(stValueNeo.getUuid()));
        stValue.setType(STValueType.valueOf(stValueNeo.getType()));
        switch (stValue.getType()) {
            case STMODEL:
                stValue.setValue(map(stValueNeo.getStModel()));
                break;
            case PRIMITIVE:
            case ENUM:
                stValue.setValue(stValueNeo.getValue());
                break;
        }
        return stValue;
    }

    private STParameterKey findSTParameterKey(String stParameterKeyUuid, STParameter stParameter) {
        final Iterator<STParameterKey> iterator = stParameter.getKeys().iterator();
        while (iterator.hasNext()) {
            final STParameterKey stParameterKey = iterator.next();
            if (stParameterKey.uuid().equals(stParameterKeyUuid)) return stParameterKey;
        }
        throw new IllegalStateException("Missing stParameterKeyUuid " + stParameterKeyUuid + " in stParameter " + stParameter.getName());
    }

    private STParameter findSTParameter(String stParameterUuid, STTemplate stTemplate) {
        final Iterator<STParameter> iterator = stTemplate.getParameters().iterator();
        while (iterator.hasNext()) {
            final STParameter stParameter = iterator.next();
            if (stParameter.uuid().equals(stParameterUuid)) return stParameter;
        }
        throw new IllegalStateException("Missing stParameterUuid " + stParameterUuid + " in template " + stTemplate.getName());
    }

    private STTemplate findSTModel(String stTemplateUuid) {
        for (STGroupModel groupModel : groupModels) {
            final STTemplate stTemplate = find(groupModel, stTemplateUuid);
            if (stTemplate != null) return stTemplate;
        }
        throw new IllegalStateException("Missing stTemplateUuid " + stTemplateUuid);
    }

    private STTemplate find(STGroupModel groupModel, String stTemplateUuid) {
        final Iterator<STTemplate> iterator = groupModel.getTemplates().iterator();
        while (iterator.hasNext()) {
            final STTemplate stTemplate = find(iterator.next(), stTemplateUuid);
            if (stTemplate != null) return stTemplate;
        }
        return null;
    }

    private STTemplate find(STTemplate stTemplate, String stTemplateUuid) {
        if (stTemplateUuid.equals(stTemplate.uuid())) return stTemplate;

        final Iterator<STTemplate> iterator = stTemplate.getChildren().iterator();
        while (iterator.hasNext()) {
            final STTemplate child = find(iterator.next(), stTemplateUuid);
            if (child != null) return child;
        }
        return null;
    }
}