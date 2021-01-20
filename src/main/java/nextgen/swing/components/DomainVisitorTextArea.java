package nextgen.swing.components;

import org.fife.ui.autocomplete.BasicCompletion;

public class DomainVisitorTextArea extends JavaTextArea {

   public DomainVisitorTextArea(String text) {
      super(text);

      setClearWhitespaceLinesEnabled(true);

//      getModel().getIncomingVisitorsDomain().forEach(domain -> domain.getEntities().forEach(domainEntity -> {
//         final String capFirst = nextgen.utils.StringUtil.capitalize(domainEntity.getName());
//         addCodeTemplate(false, provider,  "isDst" + capFirst, "if (dstName.equals(\"" + domainEntity.getName() + "\")) {\n\t", "\n}");
//         addCodeTemplate(false, provider,  "isSrc" + capFirst, "if (srcName.equals(\"" + domainEntity.getName() + "\")) {\n\t", "\n}");
//      }));
//
//      getModel().getTemplates().forEach(stTemplate -> {
//         final String lowFirst = nextgen.utils.StringUtil.lowFirst(stTemplate.getName());
//         final String capFirst = nextgen.utils.StringUtil.capitalize(stTemplate.getName());
//
//         addCodeTemplate(true, provider,  "new" + capFirst, "STBuilder ", " = new" + capFirst + "();");
//         addCodeTemplate(true, provider,  "new" + capFirst + "Entity", "STBuilder ", " = new" + capFirst + "(entity, \"" + lowFirst + "\");");
//         addCodeTemplate(false, provider,  "get" + capFirst, "get(\"" + lowFirst, "\")");
//         addCodeTemplate(false, provider,  "get" + capFirst + "Entity", "get(entity, \"" + lowFirst, "\")");
//
//         stTemplate.getParameters().sorted((p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName())).forEach(stParameter -> {
//            addCodeTemplate(true, provider,  "set" + stTemplate.getName() + stParameter.getName(), "set(\"" + stParameter.getName() + "\", ", ");");
//         });
//      });
   }

   @Override
   protected void assignActions() {
      super.assignActions();

      provider.addCompletion(new BasicCompletion(provider, "domainName"));
      provider.addCompletion(new BasicCompletion(provider, "entityType"));
      provider.addCompletion(new BasicCompletion(provider, "entityEnums"));
      provider.addCompletion(new BasicCompletion(provider, "entityName"));
      provider.addCompletion(new BasicCompletion(provider, "relationName"));
      provider.addCompletion(new BasicCompletion(provider, "srcName"));
      provider.addCompletion(new BasicCompletion(provider, "dstName"));
      provider.addCompletion(new BasicCompletion(provider, "relationType"));
   }
}