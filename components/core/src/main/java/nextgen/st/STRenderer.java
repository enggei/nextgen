package nextgen.st;

import nextgen.st.domain.STEnumValue;
import nextgen.st.domain.STGroupModel;
import nextgen.st.domain.STParameterKey;
import nextgen.st.domain.STTemplate;
import nextgen.st.model.STArgument;
import nextgen.st.model.STArgumentKV;
import nextgen.st.model.STModel;
import nextgen.st.model.STValue;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class STRenderer {

    private final Set<STMapper> mappers = new LinkedHashSet<>();

    public STRenderer(Collection<STGroupModel> groupModels) {
        setGroupModels(groupModels);
    }

    public void setGroupModels(Collection<STGroupModel> groupModels) {
        for (STGroupModel stGroupModel : groupModels)
            mappers.add(new STMapper(stGroupModel));
    }

    public String render(STModel stModel) {

        final ST st = newInstanceOf(stModel.getStTemplate());
        if (st == null) return null;

        stModel.getStTemplate().getParameters()
                .forEach(stParameter ->
                        stModel.getArguments()
                                .stream()
                                .filter(stArgument -> stArgument.getStParameter().equals(stParameter))
                                .forEach(stArgument -> {

                                    switch (stParameter.getType()) {

                                        case SINGLE:
                                        case LIST:
                                            st.add(stParameter.getName(), render(stArgument));
                                            break;

                                        case KVLIST:

                                            final ST aggrSpec = new ST("~name~.{~keys:{it|~it~};separator=\",\"~}", '~', '~')
                                                    .add("name", stParameter.getName());

                                            final int keys = (int) stParameter.getKeys().count();
                                            final Object[] values = new Object[keys];

                                            final AtomicInteger index = new AtomicInteger(-1);
                                            stParameter.getKeys().forEach(stParameterKey -> {
                                                aggrSpec.add("keys", stParameterKey.getName());
                                                values[index.incrementAndGet()] = render(stArgument, stParameterKey);
                                            });

                                            st.addAggr(aggrSpec.render(), values);
                                            break;
                                    }
                                }));
        return st.render();
    }

    private ST newInstanceOf(STTemplate stTemplate) {
        for (STMapper mapper : mappers) {
            final STTemplate found = mapper.find(stTemplate);
            if (found != null) return mapper.newInstanceOf(stTemplate);
        }
        return null;
    }

    public Object render(STArgument stArgument, STParameterKey stParameterKey) {
        final STArgumentKV found = stArgument.getKeyValues()
                .stream()
                .filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey))
                .findFirst()
                .orElse(null);
        return found == null ? null : render(found.getValue());
    }

    public Object render(STArgument stArgument) {

        final List<STArgumentKV> kvs = new ArrayList<>(stArgument.getKeyValues());
        if (kvs.isEmpty())
            return render(stArgument.getValue());

        final StringBuilder kv = new StringBuilder();
        for (STArgumentKV stArgumentKV : kvs) {
            kv.append(stArgumentKV.getStParameterKey()).append("=").append(render(stArgumentKV.getValue()));
        }
        return kv.toString();
    }

    public String render(STValue value) {
        if (value == null) return null;

        switch (value.getType()) {
            case STMODEL:
                return render(value.getStModel());
            case PRIMITIVE:
                final String s = value.getValue() == null ? null : value.getValue().toString();
                return s == null || s.trim().length() == 0 ? null : s;
            case ENUM:
                final Object enumValue = value.getValue();
                return (enumValue instanceof STEnumValue) ? ((STEnumValue) enumValue).getLexical() : (enumValue == null ? null : enumValue.toString());
        }
        return null;
    }

    private static final class STMapper {

        private final STGroupModel groupModel;
        private long lastUpdated = System.currentTimeMillis();
        private STGroup stGroup;

        public STMapper(STGroupModel groupModel) {
            this.groupModel = groupModel;
        }

        public STTemplate find(STTemplate stTemplate) {
            return find(stTemplate, groupModel.getTemplates().iterator());
        }

        private STTemplate find(STTemplate stTemplate, Iterator<STTemplate> iterator) {
            while (iterator.hasNext()) {
                final STTemplate next = iterator.next();
                if (next.equals(stTemplate)) return next;

                final STTemplate found = find(stTemplate, next.getChildren().iterator());
                if (found != null) return found;
            }
            return null;
        }

        public ST newInstanceOf(STTemplate stTemplate) {

            // simple timer-based cache
            if (stGroup == null || (System.currentTimeMillis() - lastUpdated > 2000L)) {
                stGroup = STGenerator.toSTGroup(groupModel);
                lastUpdated = System.currentTimeMillis();
            }

            return stGroup.getInstanceOf(stTemplate.getName());
        }
    }
}