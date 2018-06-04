package com.generator.generators.neo4j;

import com.generator.generators.java.JavaGroup;
import com.generator.util.StringUtil;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * Created 28.04.18.
 */
public final class NeoDomainGenerator {

   private static final Neo4jGroup group = new Neo4jGroup();
   private static final JavaGroup javaGroup = new JavaGroup();

   private final String name;
   private final String description;
   private final Map<String, NeoEntity> entities = new TreeMap<>();
   private final Map<String, NeoFunction> functions = new TreeMap<>();
   private final Map<String, NeoRelation> relations = new TreeMap<>();

   public Map<String, Motif> getMotifs() {

      final Map<String, Motif> structureMap = new LinkedHashMap<>();

      for (NeoEntity neoEntity : entities.values()) {
         final Motif structure = structureMap.computeIfAbsent(neoEntity.label, Motif::new);

         for (NeoRelation neoRelation : relations.values()) {
            if (neoEntity.label.equals(neoRelation.src)) {
               structure.dst.add(neoRelation.dst);
               structure.relationTypes.put(neoRelation.dst, neoRelation.name);
            }
         }
      }

      return structureMap;
   }

   // todo: create all possible paths in domain:
   public Map<String, Set<Motif>> getAllPaths() {

      final Map<String, Set<Motif>> structureMap = new LinkedHashMap<>();

      for (NeoEntity neoEntity : entities.values()) {
         Set<Motif> motifs = structureMap.get(neoEntity.label);
         if (motifs == null) {
            structureMap.put(neoEntity.label, motifs = new LinkedHashSet<>());
         }

         motifs.add(new Motif(neoEntity.label));

//         for (NeoRelation neoRelation : relations.values()) {
//            if (neoEntity.label.equals(neoRelation.src)) {
//               structure.dst.add(neoRelation.dst);
//               structure.relationTypes.put(neoRelation.dst, neoRelation.name);
//            }
//         }
      }
      return structureMap;
   }

   public enum NeoPropertyType {
      String, Integer, Long, Enum, Boolean
   }

   public enum Cardinality {
      ONE_TO_ONE,
      ONE_TO_MANY,
      MANY_TO_ONE,
      MANY_TO_MANY
   }

   NeoDomainGenerator(String name, String description) {
      this.name = name;
      this.description = description;
   }

   public NeoDomainGenerator(JsonObject json) {
      this.name = json.getString("name");
      this.description = json.getString("description");

      for (Object o : json.getJsonArray("entities")) {
         final NeoEntity entity = new NeoEntity((JsonObject) o);
         entities.put(entity.label, entity);
      }

      for (Object o : json.getJsonArray("relations")) {
         final NeoRelation relation = new NeoRelation((JsonObject) o);
         relations.put(relation.key(), relation);
      }

      for (Object o : json.getJsonArray("functions")) {
         final NeoFunction function = new NeoFunction((JsonObject) o);
         functions.put(function.name, function);
      }
   }

   public JsonObject cypherQueries() {

      final JsonObject queries = new JsonObject();

      queries.put("nodes", new JsonArray());
      for (NeoEntity neoEntity : entities.values()) {
         final Neo4jGroup.cypherMatchNodeST matchNodeST = group.newcypherMatchNode().setLabel(neoEntity.label).setId("n");
         for (NeoProperty neoProperty : neoEntity.properties.values())
            if (neoProperty.required) matchNodeST.addPropertiesValue(neoProperty.name);

         queries.getJsonArray("nodes").add(matchNodeST.toString());
      }

      queries.put("relations", new JsonArray());
      for (NeoRelation neoRelation : relations.values()) {
         final Neo4jGroup.cypherMatchRelationST matchRelationST = group.newcypherMatchRelation().setSrc("()").setSrcRel("-").setDstRel("->").setDst("()").setType(neoRelation.name);
         for (NeoProperty neoProperty : neoRelation.properties.values())
            if (neoProperty.required) matchRelationST.addPropertiesValue(neoProperty.name);
         queries.getJsonArray("relations").add(matchRelationST.toString());
      }

      return queries;
   }

   public JsonObject toJson() {

      final JsonObject domainJson = new JsonObject().
            put("name", name).
            put("description", description);

      domainJson.put("entities", new JsonArray());
      for (NeoEntity neoEntity : entities.values())
         domainJson.getJsonArray("entities").add(neoEntity.toJson());

      domainJson.put("relations", new JsonArray());
      for (NeoRelation neoRelation : relations.values())
         domainJson.getJsonArray("relations").add(neoRelation.toJson());

      domainJson.put("functions", new JsonArray());
      for (NeoFunction neoFunction : functions.values())
         domainJson.getJsonArray("functions").add(neoFunction.toJson());

      return domainJson;
   }

   public String toDomain(String packageName) {

      final Neo4jGroup.DomainST domainST = group.newDomain().
            setPackageName(packageName).
            setName(name).
            setDescription(description);

      final Set<NeoProperty> domainProperties = new TreeSet<>();

      for (String entity : entities.keySet()) {

         domainST.addEntitiesValue(entity);
         domainST.addMethodsValue(entities.get(entity).getDomainMethods());

         domainProperties.addAll(entities.get(entity).properties.values());
      }

      for (NeoRelation relation : relations.values()) {

         if (!domainST.getRelationsValues().contains(relation.name))
            domainST.addRelationsValue(relation.name);
         domainST.addMethodsValue(relation.getDomainMethods());

         domainProperties.addAll(relation.properties.values());
      }

      for (NeoProperty property : domainProperties) {

         if (!domainST.getPropertiesValues().contains(property.name))
            domainST.addPropertiesValue(property.name);

         final Neo4jGroup.propertyAccessorsST accessorsST = group.newpropertyAccessors().
               setName(property.name).
               setType(NeoPropertyType.Enum.equals(property.type) ? property.name : property.type);

         domainST.addMethodsValue(accessorsST);

         if (NeoPropertyType.Enum.equals(property.type)) {

            accessorsST.setEnumType(property.name);

            final StringBuilder values = new StringBuilder();
            boolean first = true;
            for (String enumValue : property.enumValues) {
               if (!first) values.append(", ");
               values.append(enumValue);
               first = false;
            }
            domainST.addEnumsValue(property.name, values);
         }
      }

      return domainST.toString();
   }

   public String toPojos(String packageName) {

      final JavaGroup.ClassST domainClass = javaGroup.newClass().
            setPackage(packageName).
            setScope("public").
            setIsFinal(true).
            setName(name + "Pojos");

      for (String entity : entities.keySet()) {

         final JavaGroup.PojoST pojoST = javaGroup.newPojo().
               setScope("public static").
               setName(entity).
               setJson(true).
               setInnerClass(true);

         final JavaGroup.methodST newPojoMethod = javaGroup.newmethod().
               setName("new" + entity).
               setReturnValue(entity).
               setScope("public static").
               addThrowsExceptionsValue("IllegalArgumentException");
         final StringBuilder setValues = new StringBuilder();
         for (NeoProperty neoProperty : entities.get(entity).properties.values()) {
            final boolean isEnumProperty = NeoPropertyType.Enum.equals(neoProperty.type);
            pojoST.addPropertiesValue(null, isEnumProperty ? name + "." + neoProperty.name : neoProperty.type.name(), StringUtil.lowFirst(neoProperty.name), isEnumProperty, null, null, true);

            setValues.append(".set").append(StringUtil.capitalize(neoProperty.name)).append("(").append(StringUtil.lowFirst(neoProperty.name)).append(")");
            newPojoMethod.addParametersValue(StringUtil.lowFirst(neoProperty.name), isEnumProperty ? name + "." + neoProperty.name : neoProperty.type.name());
         }

         newPojoMethod.addStatementsValue(javaGroup.newstatements().
               addStatementsValue("final " + entity + " entity = new " + entity + "()" + setValues).
               addStatementsValue("if (!" + entity + ".isValid(entity.toJson())) throw new IllegalArgumentException(" + entity + ".getErrors(entity.toJson()).encode())").
               addStatementsValue("return entity"));
         domainClass.addMethodsValue(newPojoMethod);

         domainClass.addMethodsValue(javaGroup.newmethod().
               setName("as" + entity).
               setReturnValue(entity).
               setScope("public static").
               addThrowsExceptionsValue("IllegalArgumentException").
               addParametersValue("jsonObject", "io.vertx.core.json.JsonObject").
               addStatementsValue(javaGroup.newstatements().
                     addStatementsValue("if (!" + entity + ".isValid(jsonObject)) throw new IllegalArgumentException(" + entity + ".getErrors(jsonObject).encode())").
                     addStatementsValue("return new " + entity + "(jsonObject)")));
         domainClass.addInnerClassesValue(pojoST);
      }

      return domainClass.toString();
   }

   public String toVerticle(String packageName) {

      final String verticleName = name + "Verticle";

      final Neo4jGroup.DomainVerticleST domainVerticleST = group.newDomainVerticle().
            setName(verticleName).
            setPackageName(packageName);

      for (String entity : entities.keySet()) {

         final Neo4jGroup.verticle_new_entityST verticle_new_entityST = group.newverticle_new_entity().setLabel(entity);
         final Neo4jGroup.verticle_update_entityST verticle_update_entityST = group.newverticle_update_entity().setLabel(entity);
         final Neo4jGroup.verticle_delete_entityST verticle_delete_entityST = group.newverticle_delete_entity().setLabel(entity);
         final Neo4jGroup.verticle_get_all_entitiesST verticle_get_all_entitiesST = group.newverticle_get_all_entities().setLabel(entity);
         final Neo4jGroup.verticle_get_entityST verticle_get_entityST = group.newverticle_get_entity().setLabel(entity);
         final Neo4jGroup.verticle_map_entityST verticle_map_entityST = group.newverticle_map_entity().setLabel(entity);

         for (NeoProperty neoProperty : entities.get(entity).properties.values()) {
            if (neoProperty.unique)
               verticle_new_entityST.setUniqueProperty(neoProperty.name).setUniqueType(neoProperty.type);
            verticle_update_entityST.addPropertiesValue(neoProperty.name, NeoPropertyType.Enum.equals(neoProperty.type), neoProperty.type);
            verticle_new_entityST.addPropertiesValue(neoProperty.required, neoProperty.name, neoProperty.type, NeoPropertyType.Enum.equals(neoProperty.type));
            verticle_get_all_entitiesST.addPropertiesValue(neoProperty.name);
            verticle_map_entityST.addPropertiesValue(neoProperty.name);
         }

         domainVerticleST.addIncomingValue("New" + entity, verticle_new_entityST, "new." + name.toLowerCase() + "." + entity.toLowerCase());
         domainVerticleST.addIncomingValue("Update" + entity, verticle_update_entityST, "update." + name.toLowerCase() + "." + entity.toLowerCase());
         domainVerticleST.addIncomingValue("Delete" + entity, verticle_delete_entityST, "delete." + name.toLowerCase() + "." + entity.toLowerCase());
         domainVerticleST.addIncomingValue("Get" + entity, verticle_get_entityST, "get." + name.toLowerCase() + "." + entity.toLowerCase());
         domainVerticleST.addIncomingValue("GetAll" + entity, verticle_get_all_entitiesST, "get.all." + name.toLowerCase() + "." + entity.toLowerCase());

         domainVerticleST.addMappingsValue(verticle_map_entityST);
      }

      for (NeoRelation relation : relations.values()) {

         final Neo4jGroup.verticle_relateST verticle_relateST = group.newverticle_relate().
               setRelation(relation.name.toUpperCase()).
               setSrc(relation.src).
               setDst(relation.dst);

         switch (relation.cardinality) {
            case ONE_TO_ONE: {
               domainVerticleST.addIncomingValue("get_" + relation.src + "_" + relation.name + "_FOR_" + relation.dst, group.newverticle_get_single().setDirection("OUTGOING").setSrc(relation.src).setDst(relation.dst).setRelation(relation.name), "get." + relation.src.toLowerCase() + "." + relation.name.toLowerCase() + ".for." + relation.dst.toLowerCase());
               domainVerticleST.addIncomingValue("get_" + relation.dst + "_" + relation.name + "_FOR_" + relation.src, group.newverticle_get_single().setDirection("INCOMING").setSrc(relation.src).setDst(relation.dst).setRelation(relation.name), "get." + relation.dst.toLowerCase() + "." + relation.name.toLowerCase() + ".for." + relation.src.toLowerCase());
               break;
            }
            case ONE_TO_MANY: {
               domainVerticleST.addIncomingValue("get_" + relation.src + "_" + relation.name + "_FOR_" + relation.dst, group.newverticle_get_single().setDirection("INCOMING").setSrc(relation.dst).setDst(relation.src).setRelation(relation.name), "get." + relation.src.toLowerCase() + "." + relation.name.toLowerCase() + ".for." + relation.dst.toLowerCase());
               domainVerticleST.addIncomingValue("get_" + relation.dst + "_" + relation.name + "_FOR_" + relation.src, group.newverticle_get_many().setDirection("OUTGOING").setSrc(relation.src).setDst(relation.dst).setRelation(relation.name), "get." + relation.dst.toLowerCase() + "." + relation.name.toLowerCase() + ".for." + relation.src.toLowerCase());

               break;
            }
            case MANY_TO_ONE: {
               domainVerticleST.addIncomingValue("get_" + relation.src + "_" + relation.name + "_FOR_" + relation.dst, group.newverticle_get_single().setDirection("OUTGOING").setSrc(relation.dst).setDst(relation.src).setRelation(relation.name), "get." + relation.src.toLowerCase() + "." + relation.name.toLowerCase() + ".for." + relation.dst.toLowerCase());
               domainVerticleST.addIncomingValue("get_" + relation.dst + "_" + relation.name + "_FOR_" + relation.src, group.newverticle_get_many().setDirection("INCOMING").setSrc(relation.src).setDst(relation.dst).setRelation(relation.name), "get." + relation.dst.toLowerCase() + "." + relation.name.toLowerCase() + ".for." + relation.src.toLowerCase());

               break;
            }
            case MANY_TO_MANY: {
               domainVerticleST.addIncomingValue("get_" + relation.dst + "_" + relation.name + "_FOR_" + relation.src, group.newverticle_get_many().setDirection("OUTGOING").setSrc(relation.src).setDst(relation.dst).setRelation(relation.name), "get." + relation.dst.toLowerCase() + "." + relation.name.toLowerCase() + ".for." + relation.src.toLowerCase());
               domainVerticleST.addIncomingValue("get_" + relation.src + "_" + relation.name + "_FOR_" + relation.dst, group.newverticle_get_many().setDirection("INCOMING").setSrc(relation.dst).setDst(relation.src).setRelation(relation.name), "get." + relation.src.toLowerCase() + "." + relation.name.toLowerCase() + ".for." + relation.dst.toLowerCase());

               break;
            }
         }

         for (NeoProperty neoProperty : relation.properties.values()) {
            if (neoProperty.required) {
               verticle_relateST.addPropertiesValue(NeoPropertyType.Enum.equals(neoProperty.type), NeoPropertyType.Enum.equals(neoProperty.type) ? neoProperty.name : neoProperty.type, neoProperty.required, neoProperty.name);
            }
         }

         domainVerticleST.addIncomingValue("relate_" + relation.src + "_" + relation.name + "_" + relation.dst, verticle_relateST, "relate." + relation.src.toLowerCase() + "." + relation.name.toLowerCase() + "." + relation.dst.toLowerCase());

      }

      for (String function : functions.keySet()) {
         domainVerticleST.addIncomingValue(function, "log.warn(\"" + function + " not implemented\");", name.toLowerCase() + "." + function.toLowerCase());
      }

      return domainVerticleST.toString();
   }

   public String toCypherDomain(String packageName) {

      final Neo4jGroup.DomainCypherST domainST = group.newDomainCypher().
            setPackageName(packageName).
            setName(name).
            setDescription(description);

      // use set to avoid duplicates
      final Set<String> matchers = new LinkedHashSet<>();
      for (String entity : entities.keySet()) {

         final Neo4jGroup.NodeMatcherST nodeMatcherST = group.newNodeMatcher().
               setLabel(entities.get(entity).label);

         for (NeoProperty property : entities.get(entity).properties.values())
            nodeMatcherST.addPropertiesValue(property.name);

         matchers.add(nodeMatcherST.toString());
      }

      for (String matcher : matchers)
         domainST.addMethodsValue(matcher);

      final Set<String> relationMatchers = new LinkedHashSet<>();
      for (NeoRelation relation : relations.values()) {

         final Neo4jGroup.RelationMatcherST relationMatcherST = group.newRelationMatcher().
               setSrc(relation.src).
               setDst(relation.dst).
               setType(relation.name);

         for (NeoProperty property : relation.properties.values())
            relationMatcherST.addPropertiesValue(property.name);

         relationMatchers.add(relationMatcherST.toString());
      }

      for (String relationMatcher : relationMatchers)
         domainST.addMethodsValue(relationMatcher);

      return domainST.toString();
   }

   public NeoDomainGenerator add(NeoRelation relation) {
      this.relations.put(relation.key(), relation);
      return this;
   }

   public NeoDomainGenerator add(NeoEntity entity) {
      this.entities.put(entity.label, entity);
      return this;
   }

   public NeoDomainGenerator add(NeoFunction function) {
      this.functions.put(function.name, function);
      return this;
   }

   public static final class NeoEntity {

      private final String label;
      private final Map<String, NeoProperty> properties = new LinkedHashMap<>();

      public NeoEntity(String label) {
         this.label = label;
      }

      public NeoEntity(JsonObject jsonObject) {
         this.label = jsonObject.getString("label");
         for (Object o : jsonObject.getJsonArray("properties")) {
            final NeoProperty property = new NeoProperty((JsonObject) o);
            this.properties.put(property.name, property);
         }
      }

      public NeoEntity add(NeoProperty property) {
         this.properties.put(property.name, property);
         return this;
      }

      public JsonObject toJson() {
         final JsonObject jsonObject = new JsonObject();
         jsonObject.put("label", label);

         jsonObject.put("properties", new JsonArray());
         for (NeoProperty neoProperty : properties.values())
            jsonObject.getJsonArray("properties").add(neoProperty.toJson());

         return jsonObject;
      }

      public Object getDomainMethods() {
         final Neo4jGroup.methodsST methodsST = group.newmethods();

         // new domain-entity:
         Neo4jGroup.entityMethodsST newDomainEntityST = group.newentityMethods().
               setLabel(label);

         for (String key : properties.keySet())
            if (properties.get(key).required)
               newDomainEntityST.addRequiredPropertiesValue(properties.get(key).name, NeoPropertyType.Enum.equals(properties.get(key).type) ? properties.get(key).name : properties.get(key).type, NeoPropertyType.Enum.equals(properties.get(key).type));

         methodsST.addMethodsValue(newDomainEntityST);

         return methodsST;
      }
   }

   public static final class NeoFunction {

      private final String name;
      private final Map<String, NeoProperty> properties = new LinkedHashMap<>();

      public NeoFunction(String name) {
         this.name = name;
      }

      public NeoFunction(JsonObject jsonObject) {
         this.name = jsonObject.getString("name");
         for (Object o : jsonObject.getJsonArray("properties")) {
            final NeoProperty property = new NeoProperty((JsonObject) o);
            this.properties.put(property.name, property);
         }
      }

      public NeoFunction add(NeoProperty property) {
         this.properties.put(property.name, property);
         return this;
      }

      public JsonObject toJson() {
         final JsonObject jsonObject = new JsonObject();
         jsonObject.put("name", name);
         jsonObject.put("properties", new JsonArray());
         for (NeoProperty neoProperty : properties.values())
            jsonObject.getJsonArray("properties").add(neoProperty.toJson());

         return jsonObject;
      }

//      public Object getDomainMethods() {
//         final Neo4jGroup.methodsST methodsST = group.newmethods();
//
//         // new domain-entity:
//         Neo4jGroup.entityMethodsST newDomainEntityST = group.newFnewentityMethods().
//               setLabel(name);
//
//         for (String key : properties.keySet())
//            if (properties.get(key).required)
//               newDomainEntityST.addRequiredPropertiesValue(properties.get(key).name, NeoPropertyType.Enum.equals(properties.get(key).type) ? properties.get(key).name : properties.get(key).type, NeoPropertyType.Enum.equals(properties.get(key).type));
//
//         methodsST.addMethodsValue(newDomainEntityST);
//
//         return methodsST;
//      }
   }

   public static final class NeoRelation {

      private final String name;
      private final String src;
      private final String dst;
      private final Cardinality cardinality;
      private final Map<String, NeoProperty> properties = new LinkedHashMap<>();

      public NeoRelation(String name, String src, String dst, Cardinality cardinality) {
         this.name = name;
         this.src = src + (src.equals(dst) ? "Src" : "");
         this.dst = dst + (src.equals(dst) ? "Dst" : "");
         this.cardinality = cardinality;
      }

      public NeoRelation(JsonObject jsonObject) {
         this.name = jsonObject.getString("name");
         this.src = jsonObject.getString("src") + (jsonObject.getString("src").equals(jsonObject.getString("dst")) ? "Src" : "");
         this.dst = jsonObject.getString("dst") + (jsonObject.getString("src").equals(jsonObject.getString("dst")) ? "Dst" : "");
         this.cardinality = Cardinality.valueOf(jsonObject.getString("cardinality"));

         for (Object o : jsonObject.getJsonArray("properties")) {
            final NeoProperty property = new NeoProperty((JsonObject) o);
            this.properties.put(property.name, property);
         }
      }

      public NeoRelation add(NeoProperty property) {
         this.properties.put(property.name, property);
         return this;
      }

      public JsonObject toJson() {
         final JsonObject jsonObject = new JsonObject();
         jsonObject.put("name", name);
         jsonObject.put("src", src);
         jsonObject.put("dst", dst);
         jsonObject.put("cardinality", cardinality.name());

         jsonObject.put("properties", new JsonArray());
         for (NeoProperty neoProperty : properties.values())
            jsonObject.getJsonArray("properties").add(neoProperty.toJson());

         return jsonObject;
      }

      public Object getDomainMethods() {
         final Neo4jGroup.methodsST methodsST = group.newmethods();

         // new domain-entity:
         final Neo4jGroup.relationMethodsST relationMethodsST = group.newrelationMethods().
               setName(name).
               setSrc(src).
               setDst(dst);

         switch (cardinality) {
            case ONE_TO_ONE:
               relationMethodsST.addMethodsValue(group.newoneToOne().setDst(dst).setSrc(src).setName(name));
               break;
            case ONE_TO_MANY:
               relationMethodsST.addMethodsValue(group.newoneToMany().setDst(dst).setSrc(src).setName(name).setSrcDirection("OUTGOING").setDstDirection("INCOMING"));
               break;
            case MANY_TO_ONE:
               relationMethodsST.addMethodsValue(group.newoneToMany().setDst(src).setSrc(dst).setName(name).setSrcDirection("INCOMING").setDstDirection("OUTGOING"));
               break;
            case MANY_TO_MANY:
               relationMethodsST.addMethodsValue(group.newmanyToMany().setDst(src).setSrc(dst).setName(name));
               break;
         }

         for (String key : properties.keySet())
            if (properties.get(key).required)
               relationMethodsST.addRequiredPropertiesValue(properties.get(key).name, NeoPropertyType.Enum.equals(properties.get(key).type) ? properties.get(key).name : properties.get(key).type, NeoPropertyType.Enum.equals(properties.get(key).type));

         methodsST.addMethodsValue(relationMethodsST);

         return methodsST;
      }

      public String key() {
         return src + "_" + name + "_" + dst;
      }

      @Override
      public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;

         NeoRelation that = (NeoRelation) o;

         return (name != null ? name.equals(that.name) : that.name == null) && (src != null ? src.equals(that.src) : that.src == null) && (dst != null ? dst.equals(that.dst) : that.dst == null);
      }

      @Override
      public int hashCode() {
         int result = name != null ? name.hashCode() : 0;
         result = 31 * result + (src != null ? src.hashCode() : 0);
         result = 31 * result + (dst != null ? dst.hashCode() : 0);
         return result;
      }
   }

   public static final class NeoProperty implements Comparable<NeoProperty> {

      private final String name;
      private final Boolean required;
      private final Boolean unique;
      private final NeoPropertyType type;

      private final Set<String> enumValues = new TreeSet<>();

      public NeoProperty(String name, Boolean required, Boolean unique, NeoPropertyType type) {
         this.name = name;
         this.required = required;
         this.unique = unique;
         this.type = type;
      }

      public NeoProperty addEnumValue(String enumValue) {
         this.enumValues.add(enumValue);
         return this;
      }

      NeoProperty(JsonObject jsonObject) {
         this.name = jsonObject.getString("name");
         this.type = NeoPropertyType.valueOf(jsonObject.getString("type"));
         this.required = jsonObject.getBoolean("required");
         this.unique = jsonObject.getBoolean("unique");
         if (NeoPropertyType.Enum.equals(this.type)) {
            for (Object o : jsonObject.getJsonArray("enumValues"))
               this.enumValues.add((String) o);
         }
      }

      JsonObject toJson() {
         final JsonObject jsonObject = new JsonObject();
         jsonObject.put("name", name);
         jsonObject.put("type", type.name());
         jsonObject.put("required", required);
         jsonObject.put("unique", unique);
         if (NeoPropertyType.Enum.equals(this.type)) {
            jsonObject.put("enumValues", new JsonArray());
            for (String enumValue : enumValues)
               jsonObject.getJsonArray("enumValues").add(enumValue);
         }
         return jsonObject;
      }


      @Override
      public int compareTo(@NotNull NeoProperty o) {
         final int nameCompare = this.name.compareToIgnoreCase(o.name);
         return nameCompare == 0 ? this.type.compareTo(o.type) : nameCompare;
      }

      @Override
      public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;

         NeoProperty property = (NeoProperty) o;

         return name.equals(property.name) && type == property.type;
      }

      @Override
      public int hashCode() {
         int result = name.hashCode();
         result = 31 * result + type.hashCode();
         return result;
      }
   }

   public static final class Motif {

      private final String src;
      private final Set<String> dst = new LinkedHashSet<>();
      private Map<String, String> relationTypes = new LinkedHashMap<>();

      Motif(String src) {
         this.src = src;
      }

      public Set<String> getDst() {
         return dst;
      }

      public String relationsFor(String dst) {
         return relationTypes.get(dst);
      }

      @Override
      public String toString() {
         final StringBuilder out = new StringBuilder();
         for (String dstLabel : dst)
            out.append(src).append(" -> [").append(relationTypes.get(dstLabel)).append("] -> ").append(dstLabel).append("\n");
         if (dst.isEmpty()) out.append(src);
         return out.toString().trim();
      }
   }
}