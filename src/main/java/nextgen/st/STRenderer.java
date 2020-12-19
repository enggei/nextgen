package nextgen.st;

import nextgen.model.*;
import nextgen.templates.java.MethodCallExpression;
import nextgen.utils.StringUtil;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import static nextgen.templates.java.JavaPatterns.newMethodCallExpression;

public class STRenderer {

   private static final java.util.Map<nextgen.model.STGroupModel, STCache> cacheMap = new java.util.LinkedHashMap<>();

   private nextgen.swing.STAppPresentationModel appModel() {
      return nextgen.swing.AppModel.getInstance().getSTAppPresentationModel();
   }

   public String render(STModel stModel) {

      if (stModel == null) return null;

      final STTemplate stTemplate = stModel.getStTemplate();
      if (stTemplate == null) return null;

      final ST st = newInstanceOf(stTemplate);
      if (st == null) return null;

      stTemplate.getParameters()
            .forEach(stParameter ->
                  stModel.getArgumentsSorted()
                        .filter(stArgument -> stArgument.getStParameter().equals(stParameter))
                        .forEach(stArgument -> {
                           switch (stParameter.getType()) {

                              case SINGLE:
                              case LIST:
                                 st.add(stParameter.getName(), render(stArgument.getValue()));
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

      return st.render().trim();
   }

   public Object render(STArgument stArgument, STParameterKey stParameterKey) {
      final STArgumentKV found = stArgument.getKeyValues()
            .filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey))
            .findFirst()
            .orElse(null);
      return found == null ? null : render(found.getValue());
   }

   public String render(STValue value) {
      if (value == null) return null;

      if (!value.hasType()) {
         System.out.println("\tIllegal STValue " + value.toString());
         String s = value.getValue();
         return s == null ? render(value.getStModel()) : (s.trim().length() == 0 ? null : s.trim());
      }

      switch (value.getType()) {
         case STMODEL:
            return render(value.getStModel());
         case PRIMITIVE:
            final String s = value.getValue();
            return s == null || s.trim().length() == 0 ? null : s.trim();
         case ENUM:
            final nextgen.model.STEnumValue enumValue = value.getStEnumValue();
            if (enumValue == null) return null;
            final String lexical = enumValue.getLexical();
            return lexical == null || lexical.length() == 0 ? enumValue.getName() : lexical;
      }
      return null;
   }

   public MethodCallExpression renderGeneratorCode(STModel stModel) {

      if (stModel == null) return null;

      final STTemplate stTemplate = stModel.getStTemplate();
      if (stTemplate == null) return null;

      final nextgen.model.STGroupModel groupModel = appModel().getSTGroup(stTemplate);

      final AtomicReference<MethodCallExpression> expression = new AtomicReference<>(newMethodCallExpression()
            .setScope(StringUtil.capitalize(groupModel.getName()) + "ST")
            .setName("new" + StringUtil.capitalize(stTemplate.getName())));

      stTemplate.getParameters()
            .forEach(stParameter ->
                  stModel.getArgumentsSorted()
                        .filter(stArgument -> stArgument.getStParameter().equals(stParameter))
                        .forEach(stArgument -> {

                           switch (stParameter.getType()) {

                              case SINGLE:
                                 Object singleValue = renderGeneratorCode(stArgument.getValue());
                                 if (singleValue == null) break;

                                 expression.set(newMethodCallExpression()
                                       .setScope(expression.get())
                                       .setName("set" + StringUtil.capitalize(stParameter.getName()))
                                       .addArguments(singleValue));
                                 break;

                              case LIST:
                                 Object listValue = renderGeneratorCode(stArgument.getValue());
                                 if (listValue == null) break;

                                 expression.set(newMethodCallExpression()
                                       .setScope(expression.get())
                                       .setName("add" + StringUtil.capitalize(stParameter.getName()))
                                       .addArguments(listValue));
                                 break;

                              case KVLIST:

                                 final MethodCallExpression methodCallExpression = newMethodCallExpression()
                                       .setScope(expression.get())
                                       .setName("add" + StringUtil.capitalize(stParameter.getName()));

                                 stParameter.getKeys()
                                       .forEach(stParameterKey -> {
                                          Object value = renderGeneratorCode(stArgument, stParameterKey);
                                          methodCallExpression.addArguments(value == null ? "null" : value);
                                       });

                                 expression.set(methodCallExpression);
                                 break;
                           }
                        }));

      return expression.get();
   }

   private Object renderGeneratorCode(STArgument stArgument, STParameterKey stParameterKey) {
      final STArgumentKV found = stArgument.getKeyValues()
            .filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey))
            .findFirst()
            .orElse(null);
      return found == null ? null : renderGeneratorCode(found.getValue());
   }

   private Object renderGeneratorCode(STValue value) {
      if (value == null || value.getType() == null) return null;

      switch (value.getType()) {
         case STMODEL:
            return renderGeneratorCode(value.getStModel());
         case PRIMITIVE:
            final String s = value.getValue();
            return s == null || s.trim().length() == 0 ? null : (s.equals("true") || s.equals("false") ? s : ("\"" + StringUtil.escape(s.trim()).replaceAll("\n", "\\\\n\" + \n\t\t\t\"") + "\""));
         case ENUM:
            final nextgen.model.STEnumValue enumValue = value.getStEnumValue();
            if (enumValue == null) return null;
            return enumValue.getIncomingValuesSTEnum()
                  .findFirst()
                  .map(stEnum -> stEnum.getName() + "." + enumValue.getName())
                  .orElse(null);

      }
      return null;
   }

   private org.stringtemplate.v4.ST newInstanceOf(nextgen.model.STTemplate stTemplate) {

      final nextgen.model.STGroupModel stGroupModel = appModel().getSTGroup(stTemplate);

      final STCache cache = cacheMap.get(stGroupModel);
      if (cache != null && cache.isValid())
         return cache.getInstanceOf(stTemplate);

      if (cache == null) {
         final nextgen.st.STRenderer.STCache stCache = new nextgen.st.STRenderer.STCache(stGroupModel);
         cacheMap.put(stGroupModel, stCache);
         return stCache.getInstanceOf(stTemplate);
      }

      return cache.refresh(stGroupModel).getInstanceOf(stTemplate);
   }

   private static final class STCache {

      private STGroup stGroup;
      private long lastUpdated;

      private STCache(nextgen.model.STGroupModel stGroupModel) {
         this.stGroup = STGenerator.toSTGroup(stGroupModel);
         this.lastUpdated = System.currentTimeMillis();
      }

      private org.stringtemplate.v4.ST getInstanceOf(nextgen.model.STTemplate stTemplate) {
         this.lastUpdated = System.currentTimeMillis();
         return stGroup.getInstanceOf(stTemplate.getName());
      }

      public boolean isValid() {
         return (System.currentTimeMillis() - lastUpdated < 2000L);
      }

      public nextgen.st.STRenderer.STCache refresh(nextgen.model.STGroupModel stGroupModel) {
         this.stGroup = STGenerator.toSTGroup(stGroupModel);
         this.lastUpdated = System.currentTimeMillis();
         return this;
      }
   }
}