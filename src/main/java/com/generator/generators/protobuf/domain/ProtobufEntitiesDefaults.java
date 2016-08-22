package com.generator.generators.protobuf.domain;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;

import javax.swing.*;
import java.io.File;
import java.util.*;

/**
 * User: goe
 * Date: 08.12.13
 */
public class ProtobufEntitiesDefaults extends ProtobufEntitiesModel {

   //todo test protobuf-entities-iterator interface for ProtobufEntitiesGraph, and make graph generic.


   /* actions- sketches:

   NOTe: all actions should cascade, like 'expand'. Each node has constraints.

   how to expand inwards and outwards ?
   *  1_ add 'ProtobufEnum', given selected nodes
   *
   *  Labels as sets, group by 'set-name'
   *  KeyEvent.VK_G : generate menu:
   *      generate
   *  collapse unconnected
   *  circle selected (for each selected, spread randomly on plane, and create satellites for outgoing
   *  save 'layout'
   * */


   public static final Map<String, ProtobufFieldConstraint> defaultConstraints = new LinkedHashMap<String, ProtobufFieldConstraint>() {{
      put("required", newFieldConstraint(UUID.fromString("59457ead-5e9f-46a9-b6ab-a1d0e8ac633c"), "required"));
      put("optional", newFieldConstraint(UUID.fromString("337f74a5-b0cd-4291-9f0d-0d3591946e80"), "optional"));
      put("repeated", newFieldConstraint(UUID.fromString("ac4f5d03-40cd-468a-bac1-b9ced6f0f35b"), "repeated"));
   }};

   public static final Map<String, ProtobufFieldType> defaultScalarValues = new TreeMap<String, ProtobufFieldType>() {{
      put("double", newtype(UUID.fromString("fedfde0a-6680-4006-bc24-6ac614c91ce3"), "double"));
      put("float", newtype(UUID.fromString("5d9e3b1e-1774-4fe4-89f5-5ad7105dd4c7"), "float"));
      put("int32", newtype(UUID.fromString("e21f9891-1eb4-4cbb-b799-2f81fb608dd4"), "int32"));
      put("int64", newtype(UUID.fromString("80ba8528-0374-429c-8bf4-7db8be1ca728"), "uint32"));
      put("uint32", newtype(UUID.fromString("83699c2c-3b26-45de-a8e5-8781afe540b8"), "uint32"));
      put("uint64", newtype(UUID.fromString("83175ddb-4976-4f25-bcc9-d508219c8ae1"), "uint64"));
      put("sint32", newtype(UUID.fromString("a7e8d67b-7338-4d91-bca6-bf769e490df9"), "sint32"));
      put("sint64", newtype(UUID.fromString("2b8c2a6c-7953-4e26-8124-b702d1bca452"), "sint64"));
      put("fixed32", newtype(UUID.fromString("c642a1aa-74ef-42be-a4f2-251d8c847e17"), "fixed32"));
      put("fixed64", newtype(UUID.fromString("93187fdf-6343-4a29-a127-64c40370a7a3"), "fixed64"));
      put("sfixed32", newtype(UUID.fromString("c0005968-9814-40c0-a4ca-6b6cf4016742"), "sfixed32"));
      put("sfixed64", newtype(UUID.fromString("a520f581-c55a-40ba-acf9-ee1a1a181e6b"), "sfixed64"));
      put("bool", newtype(UUID.fromString("35392a5f-a6ad-4a75-a7c6-57850ff729b9"), "bool"));
      put("string", newtype(UUID.fromString("496620d0-f988-4798-8e73-5d22a476f9a9"), "string"));
      put("bytes", newtype(UUID.fromString("334bb81d-c8de-4821-a353-90af3e4c0e8e"), "bytes"));
   }};

   public ProtobufEntitiesDefaults(GraphDatabaseService graphDb, String name) {
      super(graphDb, name);

      for (ProtobufFieldConstraint defaultConstraint : ProtobufEntitiesDefaults.defaultConstraints.values()) {
         final Node node = getNode(defaultConstraint.getUuid());
         if (node == null) new ProtobufFieldConstraintNode(newNode(ProtobufEntities.class.getName(), defaultConstraint.getUuid(), ProtobufEntities.ProtobufFieldConstraint.name()), graphDb).setName(defaultConstraint.getName());
      }

      for (ProtobufFieldType defaultFieldType : ProtobufEntitiesDefaults.defaultScalarValues.values()) {
         final Node node = getNode(defaultFieldType.getUuid());
         if (node == null) new ProtobufFieldTypeNode(newNode(ProtobufEntities.class.getName(), defaultFieldType.getUuid(), ProtobufEntities.ProtobufFieldType.name()), graphDb).setName(defaultFieldType.getName());
      }
   }

   public Set<String> getProtoFieldConstraints() {
      return new TreeSet<>(defaultConstraints.keySet());
   }

   public ProtobufFieldConstraint getProtobufFieldConstraint(String name) {
      return new ProtobufFieldConstraintNode(getNode(defaultConstraints.get(name).getUuid()), graphDb);
   }

   public Set<String> getProtobufFieldTypes() {
      return new TreeSet<>(defaultScalarValues.keySet());
   }

   public ProtobufFieldType getProtbufFieldType(String name) {
      return new ProtobufFieldTypeNode(getNode(defaultScalarValues.get(name).getUuid()), graphDb);
   }

   private static ProtobufFieldConstraint newFieldConstraint(final UUID uuid, final String name) {
      return new ProtobufFieldConstraint() {

         @Override
         public String getName() {
            return name;
         }

         @Override
         public ProtobufFieldConstraint setName(String value) {
            return this;
         }

         @Override
         public UUID getUuid() {
            return uuid;
         }

         @Override
         public ProtobufEntities getDomainType() {
            return ProtobufEntities.ProtobufFieldConstraint;
         }
      };
   }

   private static ProtobufFieldType newtype(final UUID uuid, final String name) {
      return new ProtobufFieldType() {
         @Override
         public String getName() {
            return name;
         }

         @Override
         public ProtobufFieldType setName(String value) {
            return this;
         }

         @Override
         public UUID getUuid() {
            return uuid;
         }

         @Override
         public ProtobufEntities getDomainType() {
            return ProtobufEntities.ProtobufFieldType;
         }
      };
   }

   public static void main(String[] args) {

      final String MATRIX_DB = "src/com/generator/domain/protobuf/neo/db/protobuf-test";
      final GraphDatabaseService db = new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabase(new File(MATRIX_DB));
      final ProtobufEntitiesDefaults model = new ProtobufEntitiesDefaults(db, "TEST-1");

//      final ProtobufPackage aPackage = model.newProtobufPackage();
//      aPackage.setPackageName("TEST");

      // how to reference and re-use entities:
//      final ProtobufMessage parentMessage = model.newProtobufMessage().setName("ParentMessage").setComment("This is the parents parent message");
//      final ProtobufPackage parentPackage = model.newProtobufPackage().setPackageName("PARENT").
//            addProtobufMessage(
//                  parentMessage);
//      aPackage.
//            addOptions(model.newProtobufPackageOption().setName("Option1").projectTo("Value1")).
//            addOptions(model.newProtobufPackageOption().setName("Option2").projectTo("Value2")).
//            addImports(parentPackage).
//            addProtobufMessage(
//                  model.newProtobufMessage().setName("Message 1").setComment("MessageComment1").setParent(parentMessage).
//                        addProperties(model.newProtobufMessageField().setFieldConstraint(model.getProtobufFieldConstraint("required")).setType(model.getProtbufFieldType("string")).setName("name").setComment("comment").setDefaultValue("defaultValue"))
//            );


      //final ProtobufRenderer renderer = new ProtobufRenderer(new File("src\\com\\generator\\domain\\protobuf\\Protobuf.stg"));
      final ProtobufRenderer renderer = new ProtobufRenderer(new File("D:\\projects\\generator\\src\\com\\generator\\domain\\protobuf\\Protobuf.dat.stg"));
      final ProtobufRenderer protobufRenderer = model.traverse(renderer);

      final ProtobufEntitiesGraph panel = new ProtobufEntitiesGraph(model);

      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            final JFrame f = new JFrame("Protobuf");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.add(panel);
            f.addKeyListener(panel);
            f.pack();
            f.setVisible(true);
         }
      });
   }
}