package nextgen.st.importers;

import io.vertx.core.json.JsonObject;
import nextgen.st.STGenerator;
import nextgen.utils.FileUtil;
import nextgen.utils.StringUtil;
import com.github.kklisura.cdt.launch.ChromeLauncher;
import com.github.kklisura.cdt.protocol.commands.Page;
import com.github.kklisura.cdt.protocol.commands.Runtime;
import com.github.kklisura.cdt.protocol.types.runtime.Evaluate;
import com.github.kklisura.cdt.services.ChromeDevToolsService;
import com.github.kklisura.cdt.services.ChromeService;
import com.github.kklisura.cdt.services.types.ChromeTab;
import nextgen.st.STParser;
import nextgen.st.domain.STGroupModel;
import nextgen.st.domain.STJsonFactory;
import nextgen.st.domain.STTemplate;
import nextgen.st.model.STModelDB;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static nextgen.st.STGenerator.toSTGroup;

public class MaterialUIImporter extends BaseImporter {

   public static void main(String[] args) throws IOException {
      new MaterialUIImporter();
   }

   public MaterialUIImporter() throws IOException {

      final String downloadDir = "/home/goe/projects/nextgen/components/core/resources/html";

      final String[] components = getApiUrls();
      final Set<File> htmlFiles = tryToDownloadApiPages(downloadDir, components);
      final List<ApiComponent> apiComponents = parseHtmlFiles(htmlFiles);
      apiComponents.addAll(manualComponents());

      final String groupName = "MaterialUI";
      final File stGroupFile = new File(templatesDir, groupName + ".json");
      final STGroupModel stGroupModel = stGroupFile.exists()
            ? STJsonFactory.newSTGroupModel(stGroupFile).setName(groupName).setDelimiter("~")
            : STJsonFactory.newSTGroupModel().setName(groupName).setDelimiter("~");

      for (ApiComponent apiComponent : apiComponents) {
         final STTemplate componentTemplate = getComponentTemplate(stGroupModel, apiComponent);
         addImportTemplate(stGroupModel, apiComponent, componentTemplate);
         getElementTemplate(stGroupModel, apiComponent, componentTemplate);
      }

      FileUtil.write(stGroupModel.getJsonObject().encodePrettily(), stGroupFile);

      STGroupModel generatorSTGroup = new STGroupModel(new JsonObject(STParser.read(new File("/home/goe/projects/nextgen/components/core/src/main/java/nextgen/st/StringTemplate.json"))));
      new STGenerator(toSTGroup(generatorSTGroup)).generateSTGroup(stGroupModel, "nextgen.templates", "/home/goe/projects/nextgen/components/core/src/main/java");
   }

   private Set<ApiComponent> manualComponents() {
      final Set<ApiComponent> set = new LinkedHashSet<>();

      final ApiComponent box = new ApiComponent("Box");
      box.importStatement = "import Box from '@material-ui/core/Box';";
      box.apiElements.add(new ApiElement("mt", "string", null, "Box"));
      box.canHaveChildrenElements = true;
      set.add(box);

      final ApiComponent lockOutlinedIcon = new ApiComponent("LockOutlinedIcon");
      lockOutlinedIcon.importStatement = "import LockOutlinedIcon from '@material-ui/icons/LockOutlined';";
      set.add(lockOutlinedIcon);

      final ApiComponent menuIcon = new ApiComponent("MenuIcon");
      menuIcon.importStatement = "import MenuIcon from '@material-ui/icons/Menu';";
      set.add(menuIcon);

      return set;
   }

   public static STTemplate getComponentTemplate(STGroupModel stGroupModel, ApiComponent apiComponent) {
      return STModelDB.findSTTemplateByName(stGroupModel, apiComponent.templateName)
            .orElseGet(() -> {
               final STTemplate newTemplate = STJsonFactory.newSTTemplate()
                     .setName(apiComponent.templateName)
                     .setText(apiComponent.componentName + "\n\n\t" + apiComponent.importTemplateName + "\n\n\t" + apiComponent.elementTemplateName);
               stGroupModel.addTemplates(newTemplate);
               return newTemplate;
            });
   }

   public static void addImportTemplate(STGroupModel stGroupModel, ApiComponent apiComponent, STTemplate componentTemplate) {
      STParser.parseTemplateAndGet(apiComponent.importStatement)
            .ifPresent(stTemplate -> {
               final STTemplate importTemplate = STModelDB.findSTTemplateByName(stGroupModel, apiComponent.importTemplateName)
                     .orElseGet(() -> {
                        final STTemplate newTemplate = STJsonFactory.newSTTemplate()
                              .setName(apiComponent.importTemplateName);
                        componentTemplate.addChildren(newTemplate);
                        return newTemplate;
                     });

               importTemplate.setText(apiComponent.importStatement);
            });
   }

   public static void getElementTemplate(STGroupModel stGroupModel, ApiComponent apiComponent, STTemplate componentTemplate) {
      STParser.parseTemplateAndGet(apiComponent.elementTemplateText())
            .ifPresent(stTemplate -> {
               final STTemplate elementTemplate = STModelDB.findSTTemplateByName(stGroupModel, apiComponent.elementTemplateName)
                     .orElseGet(() -> {
                        final STTemplate newTemplate = STJsonFactory.newSTTemplate()
                              .setName(apiComponent.elementTemplateName)
                              .setText(apiComponent.elementTemplateText());
                        componentTemplate.addChildren(newTemplate);
                        return newTemplate;
                     });

               STParser.mergeTemplate(stTemplate, elementTemplate);
            });
   }

   public static List<ApiComponent> parseHtmlFiles(Set<File> htmlFiles) throws IOException {
      final List<ApiComponent> apiComponents = new ArrayList<>();
      for (File htmlFile : htmlFiles) {
         final Document doc = Jsoup.parse(htmlFile, "utf-8");
         //if (apiComponents.isEmpty()) System.out.println(doc);
         //printApiUrls(apiComponents, doc);

         final ApiComponent apiComponent = new ApiComponent(htmlFile.getName()
               .substring(0, htmlFile.getName().length() - 5));
         apiComponent.importStatement = doc.select("code")
               .text()
               .substring(0, doc.select("code").text().indexOf(";") + 1);
         apiComponents.add(apiComponent);

         final Elements tables = doc.select("table");
         final Element apiTable = tables.get(0);
         final Elements trs = apiTable.select("tr");
         for (int i = 0; i < trs.size(); i++) {
            if (i == 0) continue;
            Element tr = trs.get(i);
            final Elements tds = tr.select("td");
            final Element nameTd = tds.get(0);
            final Element typeTd = tds.get(1);
            final Element defaultTd = tds.get(2);
            final Element descriptionTd = tds.get(3);

            final ApiElement apiElement = new ApiElement(
                  nameTd.child(0).text(),
                  typeTd.child(0).text(),
                  defaultTd.childNodeSize() == 0 ? "" : defaultTd.child(0).text(),
                  descriptionTd.childNodeSize() == 0 ? "" : descriptionTd.text()
            );
            apiComponents.get(apiComponents.size() - 1).apiElements.add(apiElement);

            if (apiElement.isChildren || apiComponent.componentName.equals("Container"))
               apiComponent.canHaveChildrenElements = true;

            if (apiComponent.componentName.equals("TextField") && apiElement.parameterName.equals("InputProps"))
               apiElement.parameterName = "_" + apiElement.parameterName;
         }
      }
      return apiComponents;
   }

   public static Set<File> tryToDownloadApiPages(String root, String[] components) {
      final ChromeLauncher launcher = new ChromeLauncher();
      final ChromeService chromeService = launcher.launch(true);

      final Set<File> htmlFiles = new LinkedHashSet<>();
      for (String api : components) {

         final String component = api.substring(api.indexOf("/api/") + "/api/".length(), api.length() - 1);

         final File file = new File(root, component + ".html");
         htmlFiles.add(file);
         if (file.exists()) continue;

         final ChromeTab tab = chromeService.createTab();
         final ChromeDevToolsService devToolsService = chromeService.createDevToolsService(tab);
         final Page page = devToolsService.getPage();
         final Runtime runtime = devToolsService.getRuntime();
         page.onLoadEventFired(event -> {
            final Evaluate evaluation = runtime.evaluate("document.documentElement.outerHTML");
            FileUtil.write(evaluation.getResult().getValue().toString(), FileUtil.tryToCreateFileIfNotExists(file));
            devToolsService.close();
         });
         page.enable();
         page.navigate(api);
         devToolsService.waitUntilClosed();
         chromeService.closeTab(tab);
      }

      launcher.close();
      return htmlFiles;
   }

   private static String elementValue(ApiElement apiElement) {

      if (apiElement.name.equals("justify")) return stringReference(apiElement.parameterName);
      if (apiElement.name.equals("color")) return stringReference(apiElement.parameterName);
      if (apiElement.name.equals("align")) return stringReference(apiElement.parameterName);
      if (apiElement.name.equals("display")) return stringReference(apiElement.parameterName);
      if (apiElement.name.equals("variant")) return stringReference(apiElement.parameterName);
      if (apiElement.name.equals("position")) return stringReference(apiElement.parameterName);
      if (apiElement.name.equals("edge")) return stringReference(apiElement.parameterName);
      if (apiElement.name.equals("margin")) return stringReference(apiElement.parameterName);

      final String elementType = apiElement.type.trim();
      if (elementType.equals("bool")) return "";

      if (elementType.equals("object")) return valueReference(apiElement.parameterName);
      if (elementType.equals("array")) return valueReference(apiElement.parameterName);
      if (elementType.equals("any")) return valueReference(apiElement.parameterName);
      if (elementType.equals("element")) return valueReference(apiElement.parameterName);
      if (elementType.equals("func")) return valueReference(apiElement.parameterName);
      if (elementType.equals("number")) return valueReference(apiElement.parameterName);
      if (elementType.equals("node")) return valueReference(apiElement.parameterName);
      if (elementType.equals("elementType")) return valueReference(apiElement.parameterName);
      if (elementType.equals("ref")) return valueReference(apiElement.parameterName);
      if (elementType.equals("unsupportedProp")) return valueReference(apiElement.parameterName);
      if (elementType.equals("number | string")) return valueReference(apiElement.parameterName);
      if (elementType.equals("element type")) return valueReference(apiElement.parameterName);
      if (elementType.equals("{ error?: node, info?: node, success?: node, warning?: node }"))
         return valueReference(apiElement.parameterName);
      if (elementType.equals("number | { appear?: number, enter?: number, exit?: number }"))
         return valueReference(apiElement.parameterName);
      if (elementType.equals("HTML element | func")) return valueReference(apiElement.parameterName);
      if (elementType.equals("HTML element | React.Component | func"))
         return valueReference(apiElement.parameterName);
      if (elementType.equals("{ left: number, top: number }")) return valueReference(apiElement.parameterName);
      if (elementType.equals("{ component?: element type }")) return valueReference(apiElement.parameterName);
      if (elementType.equals("HTML element | object | func")) return valueReference(apiElement.parameterName);
      if (elementType.equals("node | func")) return valueReference(apiElement.parameterName);
      if (elementType.equals("Array<string> | number | string")) return valueReference(apiElement.parameterName);
      if (elementType.equals("refType.isRequired")) return valueReference(apiElement.parameterName);
      if (elementType.equals("number | Array<number>")) return valueReference(apiElement.parameterName);
      if (elementType.equals("bool | array")) return valueReference(apiElement.parameterName);
      if (elementType.equals("string | func")) return valueReference(apiElement.parameterName);
      if (elementType.equals("number | { enter?: number, exit?: number }"))
         return valueReference(apiElement.parameterName);
      if (elementType.equals("Array<element>")) return valueReference(apiElement.parameterName);
      if (elementType.equals("Array<string>")) return valueReference(apiElement.parameterName);
      if (elementType.equals("Array<string> | string")) return valueReference(apiElement.parameterName);

      if (elementType.equals("string")) return stringReference(apiElement.parameterName);
      if (elementType.contains("'")) return valueReference(apiElement.parameterName);
      if (elementType.equals("0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10"))
         return valueReference(apiElement.parameterName);

      return valueReference(apiElement.parameterName);
   }

   private static String stringReference(String elementName) {
      return "=" + "\"~" + elementName + "~\"";
   }

   private static String valueReference(String elementName) {
      return "=" + "~" + elementName + "~";
   }

   public static void printApiUrls(List<ApiComponent> apiComponents, Document doc) {
      if (apiComponents.isEmpty()) {

         final Set<String> apiUrls = new LinkedHashSet<>();

         final Elements ahrefs = doc.select("a[href]");
         for (Element ahref : ahrefs) {
            final String attr = ahref.attr("href");
            if (attr == null) continue;
            if (!attr.startsWith("/api/")) continue;
            if (attr.contains("#")) continue;
            apiUrls.add("\"https://material-ui.com" + attr.trim() + "\",");
         }

         for (String apiUrl : apiUrls) {
            System.out.println(apiUrl);
         }
      }
   }

   static final class ApiComponent {

      String name;
      String importStatement;
      final Set<ApiElement> apiElements = new TreeSet<>();

      String componentName;
      String templateName;
      String importTemplateName;
      String elementTemplateName;
      boolean canHaveChildrenElements;

      public ApiComponent(String name) {
         this.name = name;
         this.templateName = StringUtil.capitalize(filter(name));
         this.componentName = StringUtil.capitalize(filter(name));
         this.importTemplateName = templateName + "Import";
         this.elementTemplateName = templateName + "Element";

         // add some api elements missing in api
         apiElements.add(new ApiElement("className", "object", null, "component style"));
         apiElements.add(new ApiElement("id", "string", null, "component id"));
         apiElements.add(new ApiElement("style", "node", null, "component style"));
         apiElements.add(new ApiElement("key", "node", null, "component key"));


         if (templateName.equals("Button")) apiElements.add(new ApiElement("type", "string", null, "button type"));
         if (templateName.equals("IconButton")) {
            apiElements.add(new ApiElement("onClick", "node", null, "on click"));
         }

         if (templateName.equals("Menu")) {
            apiElements.add(new ApiElement("keepMounted", "bool", null, ""));
            apiElements.add(new ApiElement("open", "node", null, ""));
         }

         if (templateName.equals("MenuItem")) {
            apiElements.add(new ApiElement("onClick", "node", null, ""));
         }

         if (templateName.contains("Item") || templateName.equals("TableRow") || templateName.equals("TableCell")) {
            apiElements.add(new ApiElement("key", "node", null, ""));
         }
      }

      public String elementTemplateText() {
         final StringBuilder elementTemplateText = new StringBuilder();
         elementTemplateText.append("<").append(componentName);

         for (ApiElement apiElement : apiElements) {
            if (apiElement.isChildren) continue;
            if (apiElement.isRequired)
               elementTemplateText.append("\n\t").append(apiElement.parameterName).append(elementValue(apiElement));
            else
               elementTemplateText.append("~if(")
                     .append(apiElement.parameterName)
                     .append(")~\n\t")
                     .append(apiElement.name)
                     .append(elementValue(apiElement))
                     .append("~endif~");
         }

         elementTemplateText.append("~attribute:{it|\n" +
               "\t\n" +
               "\t~it.name~=~it.value~}~");

         if (canHaveChildrenElements)
            elementTemplateText.append("~if(children)~>\n\t~children:{it|~it~};separator=\"\\n\"~\n</")
                  .append(componentName)
                  .append(">~else~ />~endif~");
         else
            elementTemplateText.append(" />");

         return elementTemplateText.toString();
      }

      @Override
      public String toString() {
         final StringBuilder out = new StringBuilder();
         for (ApiElement apiElement : apiElements)
            out.append("\n\t\t").append(apiElement);
         return name + " :\n\t" + templateName + "\n\t" + componentName + out.toString();
      }
   }

   static final class ApiElement implements Comparable<ApiElement> {
      String name;
      String type;
      String defaultValue;
      String description;

      String parameterName;
      boolean isChildren;
      public boolean isRequired;

      public ApiElement(String name, String type, String defaultValue, String description) {
         this.name = filter(name);
         this.parameterName = filter(name);
         this.type = type;
         this.defaultValue = defaultValue;
         this.description = description;
         this.isChildren = name.contains("children");
         this.isRequired = name.contains("*");
      }

      @Override
      public String toString() {
         return name + " : " + parameterName + " : " + type + " : " + defaultValue + " : " + description;
      }

      @Override
      public int compareTo(ApiElement o) {
         return this.name.compareToIgnoreCase(o.name);
      }
   }

   public static String[] getApiUrls() {
      return new String[]{
            "https://material-ui.com/api/accordion/",
            "https://material-ui.com/api/accordion-actions/",
            "https://material-ui.com/api/accordion-details/",
            "https://material-ui.com/api/accordion-summary/",
            "https://material-ui.com/api/alert/",
            "https://material-ui.com/api/alert-title/",
            "https://material-ui.com/api/app-bar/",
            "https://material-ui.com/api/autocomplete/",
            "https://material-ui.com/api/avatar/",
            "https://material-ui.com/api/avatar-group/",
            "https://material-ui.com/api/backdrop/",
            "https://material-ui.com/api/badge/",
            "https://material-ui.com/api/bottom-navigation/",
            "https://material-ui.com/api/bottom-navigation-action/",
            "https://material-ui.com/api/breadcrumbs/",
            "https://material-ui.com/api/button/",
            "https://material-ui.com/api/button-base/",
            "https://material-ui.com/api/button-group/",
            "https://material-ui.com/api/card/",
            "https://material-ui.com/api/card-action-area/",
            "https://material-ui.com/api/card-actions/",
            "https://material-ui.com/api/card-content/",
            "https://material-ui.com/api/card-header/",
            "https://material-ui.com/api/card-media/",
            "https://material-ui.com/api/checkbox/",
            "https://material-ui.com/api/chip/",
            "https://material-ui.com/api/circular-progress/",
            "https://material-ui.com/api/click-away-listener/",
            "https://material-ui.com/api/collapse/",
            "https://material-ui.com/api/container/",
            "https://material-ui.com/api/css-baseline/",
            "https://material-ui.com/api/dialog/",
            "https://material-ui.com/api/dialog-actions/",
            "https://material-ui.com/api/dialog-content/",
            "https://material-ui.com/api/dialog-content-text/",
            "https://material-ui.com/api/dialog-title/",
            "https://material-ui.com/api/divider/",
            "https://material-ui.com/api/drawer/",
            "https://material-ui.com/api/expansion-panel/",
            "https://material-ui.com/api/expansion-panel-actions/",
            "https://material-ui.com/api/expansion-panel-details/",
            "https://material-ui.com/api/expansion-panel-summary/",
            "https://material-ui.com/api/fab/",
            "https://material-ui.com/api/fade/",
            "https://material-ui.com/api/filled-input/",
            "https://material-ui.com/api/form-control/",
            "https://material-ui.com/api/form-control-label/",
            "https://material-ui.com/api/form-group/",
            "https://material-ui.com/api/form-helper-text/",
            "https://material-ui.com/api/form-label/",
            "https://material-ui.com/api/grid/",
            "https://material-ui.com/api/grid-list/",
            "https://material-ui.com/api/grid-list-tile/",
            "https://material-ui.com/api/grid-list-tile-bar/",
            "https://material-ui.com/api/grow/",
            "https://material-ui.com/api/hidden/",
            "https://material-ui.com/api/icon/",
            "https://material-ui.com/api/icon-button/",
            "https://material-ui.com/api/input/",
            "https://material-ui.com/api/input-adornment/",
            "https://material-ui.com/api/input-base/",
            "https://material-ui.com/api/input-label/",
            "https://material-ui.com/api/linear-progress/",
            "https://material-ui.com/api/link/",
            "https://material-ui.com/api/list/",
            "https://material-ui.com/api/list-item/",
            "https://material-ui.com/api/list-item-avatar/",
            "https://material-ui.com/api/list-item-icon/",
            "https://material-ui.com/api/list-item-secondary-action/",
            "https://material-ui.com/api/list-item-text/",
            "https://material-ui.com/api/list-subheader/",
            "https://material-ui.com/api/menu/",
            "https://material-ui.com/api/menu-item/",
            "https://material-ui.com/api/menu-list/",
            "https://material-ui.com/api/mobile-stepper/",
            "https://material-ui.com/api/modal/",
            "https://material-ui.com/api/native-select/",
            "https://material-ui.com/api/no-ssr/",
            "https://material-ui.com/api/outlined-input/",
            "https://material-ui.com/api/pagination/",
            "https://material-ui.com/api/pagination-item/",
            "https://material-ui.com/api/paper/",
            "https://material-ui.com/api/popover/",
            "https://material-ui.com/api/popper/",
            "https://material-ui.com/api/portal/",
            "https://material-ui.com/api/radio/",
            "https://material-ui.com/api/radio-group/",
            "https://material-ui.com/api/rating/",
            "https://material-ui.com/api/root-ref/",
            "https://material-ui.com/api/scoped-css-baseline/",
            "https://material-ui.com/api/select/",
            "https://material-ui.com/api/skeleton/",
            "https://material-ui.com/api/slide/",
            "https://material-ui.com/api/slider/",
            "https://material-ui.com/api/snackbar/",
            "https://material-ui.com/api/snackbar-content/",
            "https://material-ui.com/api/speed-dial/",
            "https://material-ui.com/api/speed-dial-action/",
            "https://material-ui.com/api/speed-dial-icon/",
            "https://material-ui.com/api/step/",
            "https://material-ui.com/api/step-button/",
            "https://material-ui.com/api/step-connector/",
            "https://material-ui.com/api/step-content/",
            "https://material-ui.com/api/step-icon/",
            "https://material-ui.com/api/step-label/",
            "https://material-ui.com/api/stepper/",
            "https://material-ui.com/api/svg-icon/",
            "https://material-ui.com/api/swipeable-drawer/",
            "https://material-ui.com/api/switch/",
            "https://material-ui.com/api/tab/",
            "https://material-ui.com/api/tab-context/",
            "https://material-ui.com/api/table/",
            "https://material-ui.com/api/table-body/",
            "https://material-ui.com/api/table-cell/",
            "https://material-ui.com/api/table-container/",
            "https://material-ui.com/api/table-footer/",
            "https://material-ui.com/api/table-head/",
            "https://material-ui.com/api/table-pagination/",
            "https://material-ui.com/api/table-row/",
            "https://material-ui.com/api/table-sort-label/",
            "https://material-ui.com/api/tab-list/",
            "https://material-ui.com/api/tab-panel/",
            "https://material-ui.com/api/tabs/",
            "https://material-ui.com/api/tab-scroll-button/",
            "https://material-ui.com/api/textarea-autosize/",
            "https://material-ui.com/api/text-field/",
            "https://material-ui.com/api/timeline/",
            "https://material-ui.com/api/timeline-connector/",
            "https://material-ui.com/api/timeline-content/",
            "https://material-ui.com/api/timeline-dot/",
            "https://material-ui.com/api/timeline-item/",
            "https://material-ui.com/api/timeline-opposite-content/",
            "https://material-ui.com/api/timeline-separator/",
            "https://material-ui.com/api/toggle-button/",
            "https://material-ui.com/api/toggle-button-group/",
            "https://material-ui.com/api/toolbar/",
            "https://material-ui.com/api/tooltip/",
            "https://material-ui.com/api/tree-item/",
            "https://material-ui.com/api/tree-view/",
            "https://material-ui.com/api/typography/",
            "https://material-ui.com/api/unstable-trap-focus/",
            "https://material-ui.com/api/zoom/"
      };
   }

   private static String filter(String name) {
      final StringBuilder filteredName = new StringBuilder();

      final char[] chars = name.toCharArray();
      for (int i = 0; i < chars.length; i++) {
         char aChar = chars[i];
         if (i > 0 && chars[i - 1] == '-') {
            filteredName.append(Character.toUpperCase(aChar));
         } else if (aChar != '-') {
            filteredName.append(aChar);
         }
      }

      return filteredName.toString()
            .replaceAll("\\*", "");
   }
}