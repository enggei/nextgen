package nextgen.st;

import nextgen.st.domain.STGroupModel;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

public class STGenerator {

    public static STGroup toSTGroup(STGroupModel model) {
        return new STGroupString(model.getName(), toStg(model), model.getDelimiter().charAt(0), model.getDelimiter().charAt(0));
    }

    public static String toStg(STGroupModel model) {
        final STGroup templateGroup = newTemplateGroup();

        final ST stGroupTemplate = templateGroup.getInstanceOf("STGroupTemplate");
        stGroupTemplate.add("delimiter", model.getDelimiter());

        model.getTemplates()
                .stream()
                .filter(stTemplate -> !(stTemplate.getName().equals("eom") || stTemplate.getName().equals("gt")))
                .forEach(stModel -> {

                    final ST stTemplate = templateGroup.getInstanceOf("STTemplate");
                    stTemplate.add("name", stModel.getName());
                    stTemplate.add("content", stModel.getText());
                    stModel.getParameters().forEach(stParameter -> stTemplate.add("params", stParameter.getName()));

                    stGroupTemplate.add("templates", stTemplate);
                });

        return stGroupTemplate.render();
    }

    private static STGroup newTemplateGroup() {

        final String stg = "delimiters \"~\", \"~\"" +
                "\n\ngt() ::= \">\"" +
                "\n\neot() ::= <<~gt()~~gt()~>>" +
                "\n\nSTGroupTemplate(delimiter,templates) ::= <<delimiters \"~delimiter~\",\"~delimiter~\"" +
                "\n\neom() ::= \"}\"" +
                "\n\ngt() ::= \">\"" +
                "\n\n~templates:{it|~it~};separator=\"\\n\\n\"~ >>" +
                "\n\nSTTemplate(content,name,params) ::= <<~name~(~params:{it|~it~};separator=\",\"~) ::= <<~content~~eot()~ >>";

        return new NamedSTGroup("TemplateTemplate", stg, "~");
    }

    private static final class NamedSTGroup extends STGroupString {

        public NamedSTGroup(String sourceName, String text, String delimiter) {
            super(sourceName, text, delimiter.charAt(0), delimiter.charAt(0));
        }

        @Override
        public String getName() {
            return sourceName;
        }
    }
}