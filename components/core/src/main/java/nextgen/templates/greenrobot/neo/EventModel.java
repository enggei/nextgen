package nextgen.templates.greenrobot.neo;

import nextgen.st.model.*;
import nextgen.st.domain.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class EventModel {

   public static final String stGroupModelUuid = "fd17be4e-a3b6-4b52-a001-b0b3257b6f21";
   public static final String stTemplateUuid = "56afaa61-e68a-4ded-9563-4e9c38e6320d";

   private final STModelDB db;
   private final STModel stModel;
   private final STTemplate stTemplate;

   public EventModel(STModelDB db) {
      this.db = db;
      this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
      this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);
   }

   public EventModel(STModelDB db, STModel stModel) {
      this.db = db;
      this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
      this.stModel = stModel;
   }

   public EventModel(STModelDB db, org.neo4j.graphdb.Node node) {
      this.db = db;
      this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
      this.stModel = this.db.newSTModel(node);
   }

   public EventModel(STModelDB db, String uuid) {
      this.db = db;
      this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
      this.stModel = this.db.findOrCreateSTModelByUuid(uuid);
   }

   public EventModel(nextgen.st.model.STModelDB db, nextgen.templates.greenrobot.Event template) {
      this.db = db;
      this.stTemplate = this.db.findSTTemplateByUuid(stTemplateUuid);
      this.stModel = this.db.newSTModel(stGroupModelUuid, this.stTemplate);

      setName(template.getName());
      template.streamFields().forEach(kv -> addFields(kv.getType().toString(), kv.getName().toString()));
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      EventModel that = (EventModel) o;
      return stModel.equals(that.stModel);
   }

   @Override
   public int hashCode() {
      return java.util.Objects.hash(stModel);
   }

   public String getUuid() {
      return stModel.getUuid();
   }

   public STValue asSTValue() {
      return db.newSTValue(stModel);
   }

   public EventModel setPackageName(String value) {
      return setPackageName(db.newSTValue(value));
   }

   public EventModel setPackageName(STValue value) {
      return set(value, "packageName");
   }

   public STValue getPackageName() {
      return get("packageName");
   }

   public STArgument getPackageNameArgument() {
      return getArgument("packageName");
   }

   public EventModel removePackageName() {
      return removeArgument("packageName");
   }

   public EventModel setName(String value) {
      return setName(db.newSTValue(value));
   }

   public EventModel setName(STValue value) {
      return set(value, "name");
   }

   public STValue getName() {
      return get("name");
   }

   public STArgument getNameArgument() {
      return getArgument("name");
   }

   public EventModel removeName() {
      return removeArgument("name");
   }


   public EventModel addFields(String _type, String _name) {
      return addFields(db.newSTValue(_type), db.newSTValue(_name));
   }

   public EventModel addFields(EventModel_Fields value) {
      return addFields(value.getType(), value.getName());
   }

   public EventModel addFields(STValue _type, STValue _name) {
      findParameter("fields")
            .ifPresent(stParameter -> {
               final Collection<STArgumentKV> kvs = new ArrayList<>();
               addKV(_type, stParameter, kvs, "type");
               addKV(_name, stParameter, kvs, "name");
               db.newSTArgument(stParameter, kvs);
            });

      return this;
   }

   public java.util.stream.Stream<EventModel_Fields> streamFields() {
      return findParameter("fields")
            .map(stParameter -> stModel.getArguments()
                  .filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
                  .map(stArgument -> new EventModel_Fields(stArgument, stParameter)))
            .orElseGet(Stream::empty);
   }

   public final class EventModel_Fields {

      STArgument stArgument;
      STParameter stParameter;

      public EventModel_Fields(STArgument stArgument, STParameter stParameter) {
         this.stArgument = stArgument;
         this.stParameter = stParameter;
      }

      public EventModel_Fields setType(String value) {
         return setType(db.newSTValue(value));
      }

      public EventModel_Fields setType(STValue value) {
         return setKVValue("type", value);
      }

      public STValue getType() {
         return getKVValue("type");
      }


      public EventModel_Fields setName(String value) {
         return setName(db.newSTValue(value));
      }

      public EventModel_Fields setName(STValue value) {
         return setKVValue("name", value);
      }

      public STValue getName() {
         return getKVValue("name");
      }


      private EventModel_Fields setKVValue(String name, STValue value) {

         stParameter.getKeys()
               .filter(stParameterKey -> stParameterKey.getName().equals(name))
               .findAny()
               .ifPresent(stParameterKey -> {

                  stArgument.getKeyValues()
                        .filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.getUuid()))
                        .findAny()
                        .ifPresent(stArgumentKV -> stArgument.removeKeyValues(stArgumentKV));

                  stArgument.addKeyValues(db.newSTArgumentKV(stParameterKey, value));
               });

         return this;
      }

      private STValue getKVValue(String name) {
         final AtomicReference<STValue> value = new AtomicReference<>();
         stParameter.getKeys()
               .filter(param -> param.getName().equals(name))
               .findFirst().flatMap(stParameter -> stArgument.getKeyValues()
               .filter(stArgument -> stArgument.getStParameterKey().equals(stParameter.getUuid()))
               .findAny()).ifPresent(stArgument -> value.set(stArgument.getValue()));

         return value.get();
      }
   }

   private EventModel set(STValue value, String name) {
      findParameter(name)
            .ifPresent(stParameter -> {

               stModel.getArguments()
                     .filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
                     .findAny()
                     .ifPresent(stModel::removeArguments);

               stModel.addArguments(db.newSTArgument(stParameter, value));
            });
      return this;
   }

   private STValue get(String name) {
      final AtomicReference<STValue> value = new AtomicReference<>();
      findParameter(name).flatMap(stParameter -> stModel.getArguments()
            .filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
            .findAny()).ifPresent(stArgument -> value.set(stArgument.getValue()));
      return value.get();
   }

   private STArgument getArgument(String name) {
      final AtomicReference<STArgument> value = new AtomicReference<>();
      findParameter(name).flatMap(stParameter -> stModel.getArguments()
            .filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
            .findAny()).ifPresent(value::set);
      return value.get();
   }

   private EventModel removeArgument(String name) {
      final STArgument stArgument = getArgument(name);
      if (stArgument != null) stModel.removeArguments(stArgument);
      return this;
   }

   private EventModel add(STValue value, String name) {
      findParameter(name)
            .ifPresent(stParameter -> stModel.addArguments(db.newSTArgument(stParameter, value)));
      return this;
   }

   private Stream<STValue> stream(String name) {
      return findParameter(name)
            .map(stParameter -> stModel.getArguments()
                  .filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
                  .map(STArgument::getValue)).orElseGet(Stream::empty);
   }

   private Optional<STParameter> findParameter(String name) {
      return stTemplate.getParameters()
            .filter(param -> param.getName().equals(name))
            .findFirst();
   }

   private void addKV(STValue _type, STParameter stParameter, Collection<STArgumentKV> kvs, String type) {
      stParameter.getKeys()
            .filter(stParameterKey -> stParameterKey.getName().equals(type))
            .findFirst()
            .ifPresent(stParameterKey -> kvs.add(db.newSTArgumentKV(stParameterKey, _type)));
   }
}