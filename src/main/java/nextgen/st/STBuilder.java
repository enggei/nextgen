package nextgen.st;

public class STBuilder {

   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STBuilder.class);

   protected final nextgen.st.STTemplateModel model;

   public STBuilder(String templateUuid) {
      final nextgen.model.STTemplate stTemplate = appModel().db.findSTTemplateByUuid(templateUuid);
      org.stringtemplate.v4.ST st = appModel().stRenderer.newInstanceOf(stTemplate);
      this.model = new nextgen.st.STTemplateModel(stTemplate, st);
   }

   public nextgen.st.STBuilder set(String name, Object value) {
      return add(name, value);
   }

   public STBuilder add(String parameterName, Object value) {

      final java.util.concurrent.atomic.AtomicBoolean found = new java.util.concurrent.atomic.AtomicBoolean(false);

      model.stTemplate().getParameters().filter(stParameter -> stParameter.getName().equals(parameterName)).findFirst().ifPresent(stParameter -> {
         found.set(true);
         switch (stParameter.getType()) {
            case SINGLE:
               if (get(stParameter.getName()) != null) model.st().remove(parameterName);
               model.st().add(parameterName, value);
               break;
            case LIST:
               model.st().add(parameterName, value);
               break;
            case KVLIST:
               break;
         }
      });

      if (!found.get()) log.warn("parameterName " + parameterName + " NOT found in template " + model.stTemplate().getName());

      return this;
   }

   public STBuilder add(String parameterName, Object... kv) {

      final java.util.concurrent.atomic.AtomicBoolean found = new java.util.concurrent.atomic.AtomicBoolean(false);

      model.stTemplate().getParameters().filter(stParameter -> stParameter.getName().equals(parameterName)).findFirst().ifPresent(stParameter -> {

         found.set(true);

         if (stParameter.getType() == nextgen.model.STParameterType.KVLIST) {

            final java.util.Map<String, Object> kvMap = new java.util.LinkedHashMap<>();
            for (int i = 0; i < kv.length; i += 2) kvMap.put(kv[i].toString(), kv[i + 1]);

            final org.stringtemplate.v4.ST aggrSpec = new org.stringtemplate.v4.ST("~name~.{~keys:{it|~it~};separator=\",\"~}", '~', '~')
                  .add("name", stParameter.getName());

            final java.util.List<Object> values = new java.util.ArrayList<>();

            stParameter.getKeys().forEach(stParameterKey -> {
               final Object value = kvMap.get(stParameterKey.getName());
               if (value == null) return;
               aggrSpec.add("keys", stParameterKey.getName());
               values.add(value);
            });

            model.st().addAggr(aggrSpec.render(), values.toArray());

         } else {
            log.warn("parameterName " + parameterName + " is NOT a KVLIST in template " + model.stTemplate().getName());
         }
      });

      if (!found.get()) log.warn("parameterName " + parameterName + " NOT found in template " + model.stTemplate().getName());

      return this;
   }

   public STBuilder append(String parameterName, String value, String delimiter) {
      final Object existing = get(parameterName);
      add(parameterName, existing == null || existing.toString().trim().length() == 0 ? value : (existing + delimiter + value));
      return this;
   }

   public STBuilder setTrue(String parameterName) {
      model.stTemplate().getParameters().filter(stParameter -> stParameter.getName().equals(parameterName)).findFirst().ifPresent(stParameter -> model.st().add(parameterName, "true"));
      return this;
   }

   @SuppressWarnings("unchecked")
   public <T> T get(String parameterName) {
      final java.util.Optional<nextgen.model.STParameter> found = model.stTemplate().getParameters().filter(stParameter -> stParameter.getName().equals(parameterName)).findFirst();
      if (found.isEmpty()) return null;
      return (T) model.st().getAttribute(parameterName);
   }

   @Override
   public String toString() {
      return model.st().render();
   }

   private nextgen.swing.STAppPresentationModel appModel() {
      return nextgen.swing.AppModel.getInstance().getSTAppPresentationModel();
   }

   public nextgen.st.STBuilder writeJavaFile(String root) {
      final java.io.File file = new java.io.File(root);
      final Object packageName = getPackageName();
      final Object name = getName();
      nextgen.st.STGenerator.writeJavaFile(this, packageName, name, file);
      return this;
   }

   public Object getName() {
      return model.st().getAttribute("name");
   }

   public Object getPackageName() {
      Object packageName = model.st().getAttribute("package");
      if (packageName == null) packageName = model.st().getAttribute("packageName");
      return packageName;
   }


}