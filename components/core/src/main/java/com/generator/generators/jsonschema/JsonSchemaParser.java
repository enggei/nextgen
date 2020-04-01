package com.generator.generators.jsonschema;

import com.generator.generators.json.parser.JSONBaseVisitor;
import com.generator.generators.json.parser.JSONLexer;
import com.generator.generators.json.parser.JSONParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.LinkedHashSet;
import java.util.Set;

public class JsonSchemaParser extends JSONBaseVisitor {

    private final JsonSchema jsonSchema = new JsonSchema();

    final Set<String> tmp = new LinkedHashSet<>();

    public JsonSchema parse(String schema) {
        final JSONParser parser = new JSONParser(new CommonTokenStream(new JSONLexer(CharStreams.fromString(schema))));
        visit(parser.json());
        for (String s : tmp) {
            System.out.println(s);
        }
        return jsonSchema;
    }

    @Override
    public Object visitObj(JSONParser.ObjContext ctx) {
        //System.out.println("Obj " + ctx.getText());
        return super.visitObj(ctx);
    }

    @Override
    public Object visitPair(JSONParser.PairContext ctx) {
        //System.out.println("Pair " + ctx.getText());

        final String key = ctx.getChild(0).getText();

        switch (key) {
            case "\"$schema\"":
                jsonSchema.setSchema(ctx.getChild(1).getText());
                break;
            case "\"type\"":
                break;
            case "\"title\"":
                break;
            case "\"definitions\"":
                break;
            case "\"required\"":
                break;
            case "\"properties\"":
                break;
            case "\"name\"":
                break;
            case "\"default\"":
                break;
            case "\"examples\"":
                break;
            case "\"pattern\"":
                break;
            case "\"$id\"":
                break;
            case "\"packageName\"":
                break;
            case "\"items\"":
                break;
            case "\"column\"":
                break;
            case "\"nullable\"":
                break;
            case "\"isEnum\"":
                break;
            case "\"ui.hidden\"":
                break;
            case "\"db.create\"":
                break;
            default:
                tmp.add("case \"\\\"" + key.substring(1, key.length() - 1) + "\\\"\":  break;");
                break;
        }

        return super.visitPair(ctx);
    }

    @Override
    public Object visitArray(JSONParser.ArrayContext ctx) {
        //System.out.println("Array " + ctx.getText());
        return super.visitArray(ctx);
    }

    @Override
    public Object visitValue(JSONParser.ValueContext ctx) {
        //System.out.println("Value " + ctx.getText());
        return super.visitValue(ctx);
    }
}