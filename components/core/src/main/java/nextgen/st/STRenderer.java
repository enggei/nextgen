package nextgen.st;

import nextgen.st.model.*;
import nextgen.st.domain.*;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import static nextgen.st.STParser.readJsonObject;

public class STRenderer {

    private final Set<STMapper> mappers = new LinkedHashSet<>();

    public STRenderer(Set<STGroupModel> groupModels) {
        setGroupModels(groupModels);
    }

    public STRenderer(File templatesDir) {
        Optional.ofNullable(STApp.list(templatesDir, ".json"))
                .map(files -> {
                    final Set<STGroupModel> stGroupModels = new LinkedHashSet<>();
                    for (File file : files) stGroupModels.add(new STGroupModel(readJsonObject(file)));
                    return stGroupModels;
                })
                .ifPresent(this::setGroupModels);
    }

    public void setGroupModels(Set<STGroupModel> groupModels) {
        for (STGroupModel stGroupModel : groupModels)
            mappers.add(new STMapper(stGroupModel));
    }

    public ST render(STModel stModel, STModule stModule) {

        final STMapper stMapper = findMapper(stModel.getStTemplate());
        if (stMapper == null) return null;

        final STTemplate stTemplate = stMapper.find(stModel.getStTemplate());
        final ST st = stMapper.newInstanceOf(stTemplate);

        stTemplate.getParameters()
                .forEach(stParameter ->
                        stModel.getArguments()
                                .filter(stArgument -> stArgument.getStParameter().equals(stParameter.uuid()))
                                .forEach(stArgument -> {

                                    switch (stParameter.getType()) {

                                        case SINGLE:
                                        case LIST:
                                            st.add(stParameter.getName(), render(stArgument, stModule));
                                            break;

                                        case KVLIST:

                                            final ST aggrSpec = new ST("~name~.{~keys:{it|~it~};separator=\",\"~}", '~', '~')
                                                    .add("name", stParameter.getName());

                                            final int keys = (int) stParameter.getKeys().count();
                                            final Object[] values = new Object[keys];

                                            final AtomicInteger index = new AtomicInteger(-1);
                                            stParameter.getKeys().forEach(stParameterKey -> {
                                                aggrSpec.add("keys", stParameterKey.getName());
                                                values[index.incrementAndGet()] = render(stArgument, stModule, stParameterKey);
                                            });

                                            st.addAggr(aggrSpec.render(), values);
                                            break;
                                    }
                                }));
        return st;
    }

    private Object render(STArgument stArgument, STModule stModule, STParameterKey stParameterKey) {
        final STArgumentKV found = stArgument.getKeyValues()
                .filter(stArgumentKV -> stArgumentKV.getKey().equals(stParameterKey.getName()))
                .findFirst()
                .orElse(null);
        return found == null ? null : render(found.getValue(), stModule);
    }

    private Object render(STArgument stArgument, STModule stModule) {
        return render(stArgument.getValue(), stModule);
    }

    private Object render(STValue value, STModule stModule) {
        if (value == null) return null;

        switch (value.getType()) {
            case STMODEL:
                return render(findSTModel(value.getValue(), stModule), stModule);
            case PRIMITIVE:
                return value.getValue();
        }
        return null;
    }

    private STMapper findMapper(String templateUuid) {
        for (STMapper mapper : mappers) {
            final STTemplate stTemplate = mapper.find(templateUuid);
            if (stTemplate != null) return mapper;
        }
        return null;
    }

    private STModel findSTModel(String uuid, STModule stModule) {
        return stModule.getModels().filter(stModel -> uuid.equals(stModel.uuid())).findFirst().orElse(null);
    }

    private static final class STMapper {

        private final STGroupModel groupModel;
        private final STGroup stGroup;

        public STMapper(STGroupModel groupModel) {
            this.groupModel = groupModel;
            this.stGroup = STGenerator.toSTGroup(groupModel);
        }

        public STTemplate find(String templateUuid) {
            return find(templateUuid, groupModel.getTemplates().iterator());
        }

        private STTemplate find(STTemplate stTemplate, String templateUuid) {
            if (stTemplate.uuid().equals(templateUuid)) return stTemplate;
            return find(templateUuid, stTemplate.getChildren().iterator());
        }

        public STTemplate find(String templateUuid, Iterator<STTemplate> iterator) {
            while (iterator.hasNext()) {
                final STTemplate found = find(iterator.next(), templateUuid);
                if (found != null) return found;
            }
            return null;
        }

        public ST newInstanceOf(STTemplate stTemplate) {
            return stGroup.getInstanceOf(stTemplate.getName());
        }
    }
}