package nextgen.templates;

import nextgen.templates.javascript.*;
import nextgen.templates.materialui.MaterialUIComponent;
import nextgen.templates.materialui.StyleClass;
import nextgen.utils.StringUtil;

import java.util.Map;

import static nextgen.templates.JavaScriptPatterns.*;
import static nextgen.templates.MaterialUIPatterns.*;
import static nextgen.templates.javascript.JavaScriptST.newElement;
import static nextgen.utils.StringUtil.*;

public class WebappPatterns {

   public static Element asElement(MaterialUIComponent component) {
      return newElement().setName(component.getName());
   }

   public static Element asElement(ClassComponent component) {
      return newElement().setName(component.getName());
   }

   public static MaterialUIComponent addComponent(String name, Map<String, MaterialUIComponent> componentMap) {
      final MaterialUIComponent materialUIComponent = newMaterialUIComponent(name);
      componentMap.put(name, materialUIComponent);
      return materialUIComponent;
   }

   public static ClassComponent addPage(String name, Map<String, ClassComponent> pageMap) {
      final ClassComponent classComponent = newClassComponent()
            .setName(name)
            .addImports("{ inject, observer }", "mobx-react");

      pageMap.put(name, classComponent);
      return classComponent;
   }

   public static MethodDeclaration addPageEvent(String methodName, ClassComponent classComponent) {
      final MethodDeclaration function = newMethodDeclaration(methodName);
      classComponent.addEvents(methodName, function);
      return function;
   }

   public static Object pageComponentPath(MaterialUIComponent component) {
      return "../components/" + component.getName() + ".js";
   }

   public static Object samePackagePath(MaterialUIComponent component) {
      return "./" + component.getName() + ".js";
   }

   public static AgentDeclaration addEndpoint(String name, Superagent superagent) {
      final AgentDeclaration agentDeclaration = newAgentDeclaration().setName(name);
      superagent.addAgentDeclarations(agentDeclaration, name);
      return agentDeclaration;
   }

   public static MobXStore addStore(String storeName, Map<String, MobXStore> storeMap, IndexJS indexJS, App app) {
      final MobXStore store = newMobXStore().setName(storeName);
      store.addImports("agent", "../Agent");
      storeMap.put(storeName, store);
      indexJS.addStores(lowFirst(storeName));
      app.addStores(lowFirst(storeName));
      return store;
   }

   public static MobXStore appStore(String appName, Map<String, MobXStore> storeMap, IndexJS indexJS, App app) {
      return WebappPatterns.addStore("AppStore", storeMap, indexJS, app)
            .addObservables(newObservable("appName", sq(appName)))
            .addObservables(newObservable("token", "window.localStorage.getItem('jwt')"))
            .addObservables(newObservable("appLoaded", "false"))
            .addConstructorStatements(newReaction()
                  .setDataFunction(newArrowFunction().setExpression("this.token"))
                  .setEffectFunction(newArrowFunction()
                        .addParams("token")
                        .addStatements(newIf("token")
                              .setThen("window.localStorage.setItem('jwt',token);")
                              .setOtherwise("window.localStorage.removeItem('jwt');"))))
            .addActions(newAction("setToken")
                  .addParams("token")
                  .addStatements("this.token = token;"))
            .addActions(newAction("setAppLoaded")
                  .addStatements("this.appLoaded = true;"));
   }

   public static MobXStore userStore(Map<String, MobXStore> storeMap, IndexJS indexJS, App app) {
      return WebappPatterns.addStore("UserStore", storeMap, indexJS, app)
            .addObservables(newObservable("loading"))
            .addObservables(newObservable("errors", "undefined"))
            .addObservables(newObservable("currentuser"))
            .addObservables(newObservable("updatingUser"))
            .addObservables(newObservable("updatingUserErrors"))
            .addActions(newAction("setUser")
                  .addParams("user")
                  .addStatements("this.currentUser = user;"))
            .addActions(newAction("setErrors")
                  .addParams("errors")
                  .addStatements("this.errors = errors;"))
            .addActions(newAction("pullUser")
                  .addStatements("this.loading = true;")
                  .addStatements("this.errors = undefined;")
                  .addStatements(newReturnStmt(newAgentRequest("Auth", "currentUser")
                        .addThen(newArrowFunction("response", newFunctionCall("this.setUser")
                              .addParameters("response.user")))
                        .setFinally(newFunctionCall("action")
                              .addParameters(newArrowFunction("this.loadingUser = false"))))))
            .addActions(newAction("updateUser")
                  .addStatements("this.updatingUser = true;")
                  .addStatements(newReturnStmt(newAgentRequest("Auth", "save")
                        .addThen(newFunctionCall("action")
                              .addParameters(newArrowFunction("this.currentUser = user")))
                        .setFinally(newFunctionCall("action")
                              .addParameters(newArrowFunction("this.updatingUser = false"))))))
            .addActions(newAction("forgetUser")
                  .addStatements("this.currentUser = undefined;"));
   }

   public static MobXStore authStore(Map<String, MobXStore> storeMap, IndexJS indexJS, App app, MobXStore appStore, MobXStore userStore, AgentDeclaration authEndpoint) {
      return WebappPatterns.addStore("AuthStore", storeMap, indexJS, app)
            .addImports(StringUtil.lowFirst(appStore.getName()), "./" + appStore.getName())
            .addImports(StringUtil.lowFirst(userStore.getName()), "./" + userStore.getName())
            .addObservables(newObservable("values", "{ username: 'geirove', password: 'geirove' }"))
            .addObservables(newObservable("errors", null))
            .addObservables(newObservable("inProgress", "false"))
            .addActions(newAction("setUsername")
                  .addParams("username")
                  .addStatements("this.values.username = username;"))
            .addActions(newAction("setPassword")
                  .addParams("password")
                  .addStatements("this.values.password = password;"))
            .addActions(newAction("reset")
                  .addStatements("this.values.username = '';")
                  .addStatements("this.values.password = '';")
                  .addStatements("this.errors = undefined;"))
            .addActions(newAction("login")
                  .addStatements("this.inProgress = true;;")
                  .addStatements("this.errors = undefined;")
                  .addStatements(newReturnStmt(newAgentRequest(authEndpoint.getName(), "login")
                        .addParams("this.values.username")
                        .addParams("this.values.password")
                        .addThen(newArrowFunction(newJsonObject("user"), "appStore.setToken(user.token)"))
                        .addThen(newArrowFunction("userStore.pullUser()"))
                        .setFinally(newFunctionCall("action")
                              .addParameters(newArrowFunction("this.inProgress = false"))))))
            .addActions(newAction("logout")
                  .addStatements("appStore.setToken(undefined);")
                  .addStatements("userStore.forgetUser();")
                  .addStatements(newReturnStmt("Promise.resolve()")));
   }

   public static MaterialUIComponent navigationBar(Map<String, MaterialUIComponent> componentMap, String appName, MaterialUIComponent userMenu, MaterialUIComponent loginMenu) {
      return addComponent("NavigationBar", componentMap)
            .addComponentImports(newReactRouterLinkImport())
            .addImports(newJsonObject("inject", "observer"), "mobx-react")
            .addComponentImports(newAppBarImport())
            .addComponentImports(newToolbarImport())
            .addComponentImports(newTypographyImport())
            .addComponentImports(newButtonImport())
            .addImports(userMenu.getName(), samePackagePath(userMenu))
            .addImports(loginMenu.getName(), samePackagePath(loginMenu))
            .addStyleClasses(newStyleClass("navBar")
                  .addAttributes("flex", "1"))
            .addConst(newJsonObject("userStore"), "props")
            .setRenderElement(newDiv()
                  .addChildren(newAppBarElement()
                        .setColor("primary")
                        .setPosition("static")
                        .addChildren(newToolbarElement()
                              .addChildren(asElement(userMenu)
                                    .addProps(newProp("currentUser", newJsonObject("userStore.currentUser"))))
                              .addChildren(newTypographyElement()
                                    .setVariant("h6")
                                    .setClassName(styleClass("navBar"))
                                    .addChildren(appName))
                              .addChildren(asElement(loginMenu)
                                    .addProps(newProp("currentUser", newJsonObject("userStore.currentUser")))))));
   }

   public static MaterialUIComponent userMenu(Map<String, MaterialUIComponent> componentMap) {
      return addComponent("UserMenu", componentMap)
            .addComponentImports(newReactRouterLinkImport())
            .addComponentImports(newButtonImport())
            .addComponentImports(newMenuImport())
            .addComponentImports(newMenuItemImport())
            .addComponentImports(newMenuListImport())
            .addComponentImports(newIconButtonImport())
            .addComponentImports(newMenuIconImport())
            .addConst("[anchorEl, setAnchorEl]", "React.useState(null)")
            .addConst("LoginLink", "React.forwardRef( (props, ref) => (\n" +
                  "<Link innerRef={ ref } to=\"/login\" { ...props } />\n" +
                  "))")
            .addConst("LogoutLink", "React.forwardRef( (props, ref) => (\n" +
                  "<Link innerRef={ ref } to=\"/logout\" { ...props } />\n" +
                  "))")
            .addConst(newJsonObject("currentUser"), "props")
            .addFunctions(newFunction("handleClick")
                  .addParameters("event")
                  .addStatements("setAnchorEl(event.currentTarget);"))
            .addFunctions(newFunction("handleClose")
                  .addStatements("setAnchorEl(null);"))
            .setRenderCondition("currentUser")
            .setRenderTrue(newDiv()
                  .addChildren(newIconButtonElement()
                        .setEdge("start")
                        .setColor("inherit")
                        .setOnClick(newJsonObject("handleClick"))
                        .addChildren(newMenuIconElement()))
                  .addChildren(newMenuElement()
                        .setId("simple-menu")
                        .setAnchorEl(newJsonObject("anchorEl"))
                        .setKeepMounted(true)
                        .setOpen(newJsonObject("Boolean(anchorEl)"))
                        .setOnClose(newJsonObject("handleClose"))
                        .addChildren("{ console.info(\"Current user \" + currentUser) }")
                        .addChildren("{ currentUser.menus.map((e, i) => (<MenuItem key={e.key} component={ React.forwardRef( (props, ref) => (<Link innerRef={ ref } to={e.url} { ...props } />)) } onClick={handleClose}> {e.label} </MenuItem>))}")
                        .addChildren(newMenuItemElement()
                              .setComponent(newJsonObject("LogoutLink"))
                              .setOnClick(newJsonObject("handleClose"))
                              .addChildren("Logout"))))
            .setRenderFalse(newDiv()
                  .addChildren(newIconButtonElement()
                        .setEdge("start")
                        .setColor("inherit")
                        .setOnClick(newJsonObject("handleClick"))
                        .addChildren(newMenuIconElement()))
                  .addChildren(newMenuElement()
                        .setId("simple-menu")
                        .setAnchorEl(newJsonObject("anchorEl"))
                        .setKeepMounted(true)
                        .setOpen(newJsonObject("Boolean(anchorEl)"))
                        .setOnClose(newJsonObject("handleClose"))
                        .addChildren(newMenuItemElement()
                              .setComponent(newJsonObject("LoginLink"))
                              .setOnClick(newJsonObject("handleClose"))
                              .addChildren("Login"))));
   }

   public static MaterialUIComponent copyright(Map<String, MaterialUIComponent> componentMap) {
      return addComponent("Copyright", componentMap)
            .addComponentImports(newTypographyImport())
            .addComponentImports(newLinkImport())
            .setRenderElement(newTypographyElement()
                  .setVariant("body2")
                  .setColor("textSecondary")
                  .setAlign("center")
                  .addChildren(newJsonObject().addValues("'Copyright © Petty '} { new Date().getFullYear()")));
   }

   public static MaterialUIComponent loading(Map<String, MaterialUIComponent> componentMap) {
      return addComponent("Loading", componentMap)
            .addStyleClasses(newStyleClass("spinner")
                  .addAttributes("borderRadius", sq("50%"))
                  .addAttributes("width", sq("20px"))
                  .addAttributes("height", sq("20px"))
                  .addAttributes("margin", sq("10px auto"))
                  .addAttributes("position", sq("relative"))
                  .addAttributes("borderTop", sq("3px solid rgba(0, 0, 0, 0.1)"))
                  .addAttributes("borderRight", sq("3px solid rgba(0, 0, 0, 0.1)"))
                  .addAttributes("borderBottom", sq("3px solid rgba(0, 0, 0, 0.1)"))
                  .addAttributes("borderLeft", sq("3px solid #818a91"))
                  .addAttributes("transform", sq("translateZ(0)"))
                  .addAttributes("animation", sq("loading-spinner 0.5s infinite linear")))
            .setRenderElement(newDiv()
                  .setClassName(styleClass("spinner"))
                  .addChildren(JavaScriptPatterns.newElement("style")
                        .addChildren(newJsonObject("`\n" +
                              "@keyframes loading-spinner {\n" +
                              "0% { transform : rotate(0deg); }\n" +
                              "100% { transform : rotate(360deg); }\n" +
                              "}\n" +
                              "`"))));
   }

   public static MaterialUIComponent loginMenu(Map<String, MaterialUIComponent> componentMap) {
      return addComponent("LoginMenu", componentMap)
            .addComponentImports(newButtonImport())
            .addImports(newJsonObject("Link"), "react-router-dom")
            .addImports(newJsonObject("inject", "observer"), "mobx-react")
            .addConst("LoginLink", "React.forwardRef( (props, ref) => (\n" +
                  "<Link innerRef={ ref } to=\"/login\" { ...props } />\n" +
                  "))")
            .addConst("LogoutLink", "React.forwardRef( (props, ref) => (\n" +
                  "<Link innerRef={ ref } to=\"/logout\" { ...props } />\n" +
                  "))")
            .addConst(newJsonObject("currentUser"), "props")
            .setRenderCondition("currentUser")
            .setRenderTrue(newButtonElement()
                  .setColor("inherit")
                  .setComponent(newJsonObject("LogoutLink"))
                  .addChildren("Logout"))
            .setRenderFalse(newButtonElement()
                  .setColor("inherit")
                  .setComponent(newJsonObject("LoginLink"))
                  .addChildren("Login"));
   }

   public static MaterialUIComponent logoutForm(Map<String, MaterialUIComponent> componentMap) {
      return addComponent("LogoutForm", componentMap)
            .addComponentImports(newButtonImport())
            .addComponentImports(newTypographyImport())
            .addStyleClasses(paperStyle())
            .addStyleClasses(fullWidthFormStyle())
            .addStyleClasses(newStyleClass("submit")
                  .addAttributes("margin", "theme.spacing(3, 0, 2)"))
            .addConst("{onSubmit}", "props")
            .setRenderElement(newDiv()
                  .setClassName(styleClass("paper"))
                  .addChildren(newForm()
                        .setClassName(styleClass("form"))
                        .setOnSubmit("{ onSubmit }")
                        .setNoValidate(true)
                        .addChildren(newButtonElement()
                              .setType("submit")
                              .setFullWidth(true)
                              .setVariant("contained")
                              .setColor("primary")
                              .setClassName(styleClass("submit"))
                              .addChildren("Logout"))));
   }

   public static MaterialUIComponent loginForm(Map<String, MaterialUIComponent> componentMap) {
      return addComponent("LoginForm", componentMap)
            .addComponentImports(newAvatarImport())
            .addComponentImports(newButtonImport())
            .addComponentImports(newTextFieldImport())
            .addComponentImports(newFormControlLabelImport())
            .addComponentImports(newCheckboxImport())
            .addComponentImports(newLinkImport())
            .addComponentImports(newGridImport())
            .addComponentImports(newLockOutlinedIconImport())
            .addComponentImports(newTypographyImport())
            .addStyleClasses(paperStyle())
            .addStyleClasses(newStyleClass("avatar")
                  .addAttributes("margin", "theme.spacing(1)")
                  .addAttributes("backgroundColor", "theme.palette.secondary.main"))
            .addStyleClasses(fullWidthFormStyle())
            .addStyleClasses(newStyleClass("submit")
                  .addAttributes("margin", "theme.spacing(3, 0, 2)"))
            .addConst("{ onSubmit, handleUsernameChange, handlePasswordChange }", "props")
            .setRenderElement(newDiv()
                  .setClassName(styleClass("paper"))
                  .addChildren(newAvatarElement()
                        .setClassName(styleClass("avatar"))
                        .addChildren(newLockOutlinedIconElement()))
                  .addChildren(newTypographyElement()
                        .setComponent(dq("h1"))
                        .setVariant("h5")
                        .addChildren("Log in"))
                  .addChildren(newForm()
                        .setClassName(styleClass("form"))
                        .setOnSubmit("{ onSubmit }")
                        .setNoValidate(true)
                        .addChildren(newTextFieldElement()
                              .setOnChange("{ handleUsernameChange }")
                              .setVariant("outlined")
                              .setMargin("normal")
                              .setRequired(true)
                              .setFullWidth(true)
                              .setId("email")
                              .setLabel(dq("Email Address"))
                              .setName("name")
                              .setAutoComplete("email")
                              .setAutoFocus(true))
                        .addChildren(newTextFieldElement()
                              .setOnChange("{ handlePasswordChange }")
                              .setVariant("outlined")
                              .setMargin("normal")
                              .setRequired(true)
                              .setFullWidth(true)
                              .setName("password")
                              .setLabel(dq("Pasword"))
                              .setType("password")
                              .setId("password")
                              .setAutoComplete("current-password"))
                        .addChildren(newButtonElement()
                              .setClassName(styleClass("submit"))
                              .setType("submit")
                              .setFullWidth(true)
                              .setVariant("contained")
                              .setColor("primary")
                              .addChildren("Log in"))));
   }

   public static ClassComponent logoutPage(Map<String, ClassComponent> pageMap, MobXStore authStore, MaterialUIComponent logoutComponent, MaterialUIComponent copyright) {
      final ClassComponent logoutPage = addPage("LogoutPage", pageMap)
            .addImports("{ withRouter }", "react-router-dom")
            .addImports(logoutComponent.getName(), pageComponentPath(logoutComponent))
            .addImports(copyright.getName(), pageComponentPath(copyright))
            .addComponentImports(newContainerImport())
            .addComponentImports(newBoxImport())
            .addDecorators(newDecorator("withRouter"))
            .addDecorators(newDecorator("inject").addParameters(sq(lowFirst(authStore.getName()))))
            .addDecorators(newDecorator("observer"))
            .setRenderElement(newContainerElement()
                  .setComponent(dq("main"))
                  .setMaxWidth("xs")
                  .addChildren(asElement(logoutComponent)
                        .addProps(newProp("authStore", "{ this.props.authStore }"))
                        .addProps(newProp("onSubmit", "{ this.handleSubmitForm }")))
                  .addChildren(newBoxElement()
                        .setMt("{8}")
                        .addChildren(asElement(copyright))));
      addPageEvent("handleSubmitForm", logoutPage)
            .addParameters("e")
            .addStatements("e.preventDefault();")
            .addStatements("this.props.authStore.logout().then(() => this.props.history.replace('/')).catch(e => { console.info(\"" + logoutPage
                  .getName() + ".handleSubmitForm.errors \" + e); });");
      return logoutPage;
   }

   public static ClassComponent loginPage(Map<String, ClassComponent> pageMap, MobXStore authStore, MaterialUIComponent loginForm, MaterialUIComponent copyright, MaterialUIComponent listErrors, String onSuccessLogin) {
      final ClassComponent loginPage = addPage("LoginPage", pageMap)
            .addImports("{ withRouter }", "react-router-dom")
            .addComponentImports(newContainerImport())
            .addComponentImports(newBoxImport())
            .addImports(loginForm.getName(), pageComponentPath(loginForm))
            .addImports(listErrors.getName(), pageComponentPath(listErrors))
            .addImports(copyright.getName(), pageComponentPath(copyright))
            .addDecorators(newDecorator("withRouter"))
            .addDecorators(newDecorator("inject").addParameters(sq(lowFirst(authStore.getName()))))
            .addDecorators(newDecorator("observer"))
            .setRenderElement(newContainerElement()
                  .setComponent(dq("main"))
                  .setMaxWidth("xs")
                  .addChildren(asElement(listErrors)
                        .addProps(newProp("errors", newJsonObject("this.props.authStore.errors"))))
                  .addChildren(asElement(loginForm)
                        .addProps(newProp("authStore", "{ this.props.authStore }"))
                        .addProps(newProp("onSubmit", "{ this.handleSubmitForm }"))
                        .addProps(newProp("handleUsernameChange", "{ this.handleUsernameChange }"))
                        .addProps(newProp("handlePasswordChange", "{ this.handlePasswordChange }")))
                  .addChildren(newBoxElement()
                        .setMt("{8}")
                        .addChildren(asElement(copyright))));
      addPageEvent("handleSubmitForm", loginPage)
            .addParameters("e")
            .addStatements("e.preventDefault();")
            .addStatements("this.props.authStore.login().then(() => this.props.history.push('/" + onSuccessLogin + "')).catch(e => { console.info(\"" + loginPage
                  .getName() + ".handleSubmitForm.errors \" + e); });");
      addPageEvent("handleUsernameChange", loginPage)
            .addParameters("e")
            .addStatements("this.props.authStore.setUsername(e.target.value);");
      addPageEvent("handlePasswordChange", loginPage)
            .addParameters("e")
            .addStatements("this.props.authStore.setPassword(e.target.value);");
      return loginPage;
   }

   public static MaterialUIComponent listErrors(Map<String, MaterialUIComponent> componentMap) {
      return addComponent("ListErrors", componentMap)
            .addComponentImports(newTypographyImport())
            .addComponentImports(newListImport())
            .addComponentImports(newListItemTextImport())
            .addStyleClasses(newStyleClass("errors")
                  .addAttributes("color", sq("red")))
            .addConst("errors", "props.errors")
            .setRenderCondition("errors")
            .setRenderTrue(newListElement()
                  .setClassName(styleClass("errors"))
                  .addChildren(newJsonObject(newFunctionCall("map")
                        .setScope("Object.keys(errors)")
                        .addParameters(newArrowFunction("key", newJsonObject(newReturnStmt(newListItemTextElement()
                              .setKey(newJsonObject("key"))
                              .setPrimary(newJsonObject("errors[key]")))))))))
            .setRenderFalse("null");
   }


   public static StyleClass fullWidthFormStyle() {
      return newStyleClass("form")
            .addAttributes("width", sq("100%"))
            .addAttributes("marginTop", "theme.spacing(1)");
   }

   public static StyleClass paperStyle() {
      return newStyleClass("paper")
            .addAttributes("marginTop", "theme.spacing(8)")
            .addAttributes("display", sq("flex"))
            .addAttributes("flexDirection", sq("column"))
            .addAttributes("alignItems", sq("center"));
   }
}