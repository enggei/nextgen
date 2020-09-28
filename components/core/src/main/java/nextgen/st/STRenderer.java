package nextgen.st;

import nextgen.st.domain.STGroupModel;
import nextgen.st.domain.STParameterKey;
import nextgen.st.domain.STTemplate;
import nextgen.st.model.*;
import nextgen.templates.java.BlockStmt;
import nextgen.templates.java.MethodCallExpression;
import nextgen.templates.java.PackageDeclaration;
import nextgen.utils.StringUtil;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static nextgen.templates.JavaPatterns.*;

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

      if (stModel == null) return null;

      final STMapper stMapper = findSTMapper(stModel.getStTemplate());
      if (stMapper == null) return null;

      final STTemplate stTemplate = stMapper.find(stModel.getStTemplate());
      if (stTemplate == null) return null;

      final ST st = stMapper.newInstanceOf(stTemplate);
      if (st == null) return null;

      stTemplate.getParameters()
            .forEach(stParameter ->
                  stModel.getArgumentsSorted()
                        .filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
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

   public void renderNeoCode(STModel stModel, Collection<String> neoFacades, Collection<String> modelStatements) {

      if (stModel == null) return;

      final STMapper stMapper = findSTMapper(stModel.getStTemplate());
      if (stMapper == null) return;

      final STTemplate stTemplate = stMapper.find(stModel.getStTemplate());
      if (stTemplate == null) return;

      final STGroupModel groupModel = stMapper.groupModel;
      final String facadeType = "nextgen.templates." + groupModel.getName()
            .toLowerCase() + ".neo." + StringUtil.capitalize(groupModel) + "Neo";
      final String facadeName = groupModel.getName().toLowerCase() + "Neo";

      neoFacades.add("final " + facadeType + " " + facadeName + " = new " + facadeType + "(db);");

      modelStatements.add(facadeName + ".find" + StringUtil.capitalize(stTemplate.getName()) + "Model(" + StringUtil.dq(stModel
            .getUuid()) + ");");
   }

   public MethodCallExpression renderGeneratorCode(STModel stModel, Set<String> imports) {

      if (stModel == null) return null;

      final STMapper stMapper = findSTMapper(stModel.getStTemplate());
      if (stMapper == null) return null;

      final STTemplate stTemplate = stMapper.find(stModel.getStTemplate());
      if (stTemplate == null) return null;

      final AtomicReference<MethodCallExpression> expression = new AtomicReference<>(newMethodCallExpression()
            .setScope(StringUtil.capitalize(stMapper.groupModel.getName()) + "ST")
            .setName("new" + StringUtil.capitalize(stTemplate.getName())));

      final STGroupModel groupModel = stMapper.groupModel;
      imports.add("nextgen.templates." + groupModel.getName().toLowerCase());

      stTemplate.getParameters()
            .forEach(stParameter ->
                  stModel.getArgumentsSorted()
                        .filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
                        .forEach(stArgument -> {

                           switch (stParameter.getType()) {

                              case SINGLE:
                                 Object singleValue = renderGeneratorCode(stArgument.getValue(), imports);
                                 if (singleValue == null) break;

                                 expression.set(newMethodCallExpression()
                                       .setScope(expression.get())
                                       .setName("set" + StringUtil.capitalize(stParameter.getName()))
                                       .addArguments(singleValue));
                                 break;

                              case LIST:
                                 Object listValue = renderGeneratorCode(stArgument.getValue(), imports);
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
                                          Object value = renderGeneratorCode(stArgument, stParameterKey, imports);
                                          methodCallExpression.addArguments(value == null ? "null" : value);
                                       });

                                 expression.set(methodCallExpression);
                                 break;
                           }
                        }));

      return expression.get();
   }

   public Object render(STArgument stArgument, STParameterKey stParameterKey) {
      final STArgumentKV found = stArgument.getKeyValues()
            .filter(stArgumentKV -> stArgumentKV.getStParameterKey()
                  .equals(stParameterKey.getUuid()))
            .findFirst()
            .orElse(null);
      return found == null ? null : render(found.getValue());
   }

   public String render(STValue value) {
      if (value == null) return null;

      if (!value.hasType()) {
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
            final Object enumValue = value.getValue();
            return enumValue == null ? null : enumValue.toString().trim();
      }
      return null;
   }

   public Object renderGeneratorCode(STArgument stArgument, STParameterKey stParameterKey, Set<String> imports) {
      final STArgumentKV found = stArgument.getKeyValues()
            .filter(stArgumentKV -> stArgumentKV.getStParameterKey()
                  .equals(stParameterKey.getUuid()))
            .findFirst()
            .orElse(null);
      return found == null ? null : renderGeneratorCode(found.getValue(), imports);
   }

   public Object renderGeneratorCode(STValue value, Set<String> imports) {
      if (value == null || value.getType() == null) return null;

      switch (value.getType()) {
         case STMODEL:
            return renderGeneratorCode(value.getStModel(), imports);
         case PRIMITIVE:
            final String s = value.getValue();
            return s == null || s.trim().length() == 0 ? null : ("\"" + asJavaString(s.trim()) + "\"");
         case ENUM:
            final Object enumValue = value.getValue();
            return enumValue == null ? null : ("\"" + enumValue.toString().trim() + "\"");
      }
      return null;
   }

   private String asJavaString(String s) {
      return StringUtil.escape(s).replaceAll("\n", "\\\\n\" + \n\t\t\t\"");
   }

   private STMapper findSTMapper(String stTemplate) {
      for (STMapper mapper : mappers) {
         final STTemplate found = mapper.find(stTemplate);
         if (found != null) return mapper;
      }
      return null;
   }

   public STGroupModel findSTGroupModel(STTemplate stTemplate) {
      STMapper stMapper = findSTMapper(stTemplate.getUuid());
      return stMapper.groupModel;
   }

   private static final class STMapper {

      private final STGroupModel groupModel;
      private long lastUpdated = System.currentTimeMillis();
      private STGroup stGroup;

      public STMapper(STGroupModel groupModel) {
         this.groupModel = groupModel;
      }

      public STTemplate find(String stTemplate) {
         return find(stTemplate, groupModel.getTemplates().iterator());
      }

      private STTemplate find(String stTemplate, Iterator<STTemplate> iterator) {
         while (iterator.hasNext()) {
            final STTemplate next = iterator.next();
            if (next.getUuid().equals(stTemplate)) return next;
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