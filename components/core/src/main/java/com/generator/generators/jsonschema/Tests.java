package com.generator.generators.jsonschema;

import com.generator.util.FileUtil;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Test;

import java.io.File;

import static com.generator.generators.jsonschema.JsonSchema.*;

public class Tests {

    @Test
    public void defineEntity() {

        JSONObject jsonSchema = new JSONObject(new JSONTokener(FileUtil.readIntact(new File("/home/goe/projects/nextgen/components/core/src/main/java/com/generator/generators/jsonschema/entity-schema.json"))));
        final String s = jsonSchema.toString();
        System.out.println(s);

        final JsonSchema parse = new JsonSchemaListener().parse(s);

        System.out.println(parse);
    }

    @Test
    public void testSimple() {

        final JsonSchema schema = new JsonSchema().
                setId("http://example.com/product.schema.json").
                setSchema(SCHEMA_DRAFT_7).
                setTitle("Product").
                setDescription("Product description").
                setType(Type.OBJECT);

        schema.add(new IntegerProperty().
                setName("productId").
                setDescription("Unique identifier for a product").
                setRequired(true));

        schema.add(new StringProperty().
                setName("productName").
                setDescription("Name of the product").
                setRequired(true));

        schema.add(new NumericProperty().
                setName("price").
                setDescription("Price of the product").
                setRequired(true).
                setExclusiveMinimum(0));

        schema.add(new NumericProperty("latitude", "The latitude", false).setMinimum(-90).setMaximum(90));
        schema.add(new NumericProperty("longitude", "The longitude", false).setMinimum(-180).setMaximum(180));

        schema.add(new ArrayProperty().
                setName("tags").
                setDescription("Tags for the product").
                setRequired(false).
                setItems(new ArrayProperty.TypedArrayItem(Type.STRING)));

        final ObjectProperty veggie = new ObjectProperty("veggie", "Vegetable", false).
                add(new StringProperty("veggieName", "Name", true)).
                add(new BooleanProperty("veggieLike", "Like", true));
        schema.addDefinition(veggie);

        schema.add(new ArrayProperty().
                setName("vegetables").
                setDescription("Vegetables").
                setRequired(true).
                setMinItems(1).
                setUniqueItems(true).
                setItems(new ArrayProperty.ReferencedArrayItem(veggie.reference())));

        schema.add(new ReferenceProperty("warehouseLocation", "Coordinates for warehouse", false, "https://example.com/geographical-location.schema.json"));
        System.out.println(schema);


        JSONObject jsonSchema = new JSONObject(new JSONTokener(schema.toString()));
        final String s = jsonSchema.toString();
        System.out.println(s);
    }
}