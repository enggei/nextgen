package com.nextgen.core.template;

import com.nextgen.core.GeneratedFile;
import com.nextgen.core.ImportExportManager;
import com.nextgen.core.template.st.TemplateFile;
import com.nextgen.core.template.st.TemplateParser;
import com.nextgen.core.template.st.TemplateStatement;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.neo4j.graphdb.Node;

import java.io.File;
import java.util.UUID;

public class TemplateVerticleImpl extends TemplateVerticle {

    @Override
    protected void importGroup(JsonArray relations, JsonArray nodes, Message<JsonObject> message) {
        message.reply(newSuccess(ImportExportManager.importGraph(db, relations, nodes)));
    }

    @Override
    protected void exportGroup(String stGroup, Message<JsonObject> message) {
        final Node stGroupNode = Template.findSTGroupBy_UUID(db, UUID.fromString(stGroup));
        message.reply(newSuccess(new JsonObject().put("result", ImportExportManager.exportGraph(stGroupNode))));
    }

    @Override
    protected void importSTG(String name, String text, Message<JsonObject> message) {

        try {

            final File stg_parse_attempt = File.createTempFile(name, ".stg");
            GeneratedFile.writeToFile(text, stg_parse_attempt);

            final StringBuilder errors = new StringBuilder("Errors");
            final TemplateFile templateFile = TemplateParser.parse(stg_parse_attempt, errors);
            stg_parse_attempt.delete();

            final Node newSTGroup = Template.newSTGroup(db, templateFile.getDelimiter(), name);

            for (TemplateStatement templateStatement : templateFile.getStatements()) {

                // ignore default templates:
                if ("eom".equals(templateStatement.getName())) continue;
                if ("gt".equals(templateStatement.getName())) continue;

                final Node templateNode = Template.newSTTemplate(db, templateStatement.getText(), templateStatement.getName());
                Template.relate_STGroup_TEMPLATE_STTemplate(newSTGroup, templateNode);

                new STTemplateManager(db, templateNode).merge(templateStatement);
            }

            message.reply(newSuccess(newImportSTGReply(Template.getDelimiter(newSTGroup), Template.getUUID(newSTGroup).toString(), Template.getName(newSTGroup))));

        } catch (Exception e) {
            message.reply(newException(e));
        }
    }
}