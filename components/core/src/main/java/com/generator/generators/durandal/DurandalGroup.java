package com.generator.generators.durandal;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'durandal.stg' file<br/>
 */
public final class DurandalGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public DurandalGroup() {
		this(new STGroupString(stg));
   }

   public DurandalGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public DurandalGroup(java.io.File templateFile) {
   	this.stGroup = new org.stringtemplate.v4.STGroupFile(templateFile.getAbsolutePath());
	   this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
	   this.delimiter = stGroup.delimiterStartChar;
	}

   public STGroup getSTGroup() {
      return stGroup;
   }

   public char getDelimiter() {
      return delimiter;
   }

	public interface DurandalGroupTemplate {

	}

   public modelST newmodel() {
      return new modelST(stGroup);
   } 

   public moduleJSST newmoduleJS() {
      return new moduleJSST(stGroup);
   } 

   public shellHTMLST newshellHTML() {
      return new shellHTMLST(stGroup);
   } 

   public shellJSST newshellJS() {
      return new shellJSST(stGroup);
   } 

   public appHTMLST newappHTML() {
      return new appHTMLST(stGroup);
   } 

   public bugfix2ST newbugfix2() {
      return new bugfix2ST(stGroup);
   } 

   public eomST neweom() {
      return new eomST(stGroup);
   } 

   public gtST newgt() {
      return new gtST(stGroup);
   } 

   public mainJSST newmainJS() {
      return new mainJSST(stGroup);
   } 

   public final class modelST implements DurandalGroupTemplate {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean statementsIsSet = new AtomicBoolean(false);
      private final ST template;

      private modelST(STGroup group) {
   		template = group.getInstanceOf("model");
   	}

      public modelST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
      public modelST addStatementsValue(Object value) {
      	tryToSetListProperty(template, value, statementsIsSet, "statements");
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class moduleJSST implements DurandalGroupTemplate {

      private final AtomicBoolean returnValueIsSet = new AtomicBoolean(false);
      private final AtomicBoolean statementsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dependenciesIsSet = new AtomicBoolean(false);
      private final ST template;

      private moduleJSST(STGroup group) {
   		template = group.getInstanceOf("moduleJS");
   	}

      public moduleJSST setReturnValue(Object value) {
      	tryToSetStringProperty(template, value, returnValueIsSet, "returnValue");   
         return this;
      } 
      public moduleJSST addStatementsValue(Object value) {
      	tryToSetListProperty(template, value, statementsIsSet, "statements");
         return this;
      } 
      public moduleJSST addDependenciesValue(Object importName_, Object refName_) {
         dependenciesIsSet.set(true);
         template.addAggr("dependencies.{importName, refName}", ( (importName_==null || importName_.toString().length()==0) ? null : importName_), ( (refName_==null || refName_.toString().length()==0) ? null : refName_));
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class shellHTMLST implements DurandalGroupTemplate {

      private final ST template;

      private shellHTMLST(STGroup group) {
   		template = group.getInstanceOf("shellHTML");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class shellJSST implements DurandalGroupTemplate {

      private final AtomicBoolean routesIsSet = new AtomicBoolean(false);
      private final ST template;

      private shellJSST(STGroup group) {
   		template = group.getInstanceOf("shellJS");
   	}

      public shellJSST addRoutesValue(Object title_, Object moduleId_, Object nav_, Object route_) {
         routesIsSet.set(true);
         template.addAggr("routes.{title, moduleId, nav, route}", ( (title_==null || title_.toString().length()==0) ? null : title_), ( (moduleId_==null || moduleId_.toString().length()==0) ? null : moduleId_), ( (nav_==null || nav_.toString().length()==0) ? null : nav_), ( (route_==null || route_.toString().length()==0) ? null : route_));
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class appHTMLST implements DurandalGroupTemplate {

      private final AtomicBoolean appStylesheetPathIsSet = new AtomicBoolean(false);
      private final AtomicBoolean splashTitleIsSet = new AtomicBoolean(false);
      private final ST template;

      private appHTMLST(STGroup group) {
   		template = group.getInstanceOf("appHTML");
   	}

      public appHTMLST setAppStylesheetPath(Object value) {
      	tryToSetStringProperty(template, value, appStylesheetPathIsSet, "appStylesheetPath");   
         return this;
      } 
      public appHTMLST setSplashTitle(Object value) {
      	tryToSetStringProperty(template, value, splashTitleIsSet, "splashTitle");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class bugfix2ST implements DurandalGroupTemplate {

      private final ST template;

      private bugfix2ST(STGroup group) {
   		template = group.getInstanceOf("bugfix2");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class eomST implements DurandalGroupTemplate {

      private final ST template;

      private eomST(STGroup group) {
   		template = group.getInstanceOf("eom");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class gtST implements DurandalGroupTemplate {

      private final ST template;

      private gtST(STGroup group) {
   		template = group.getInstanceOf("gt");
   	}

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

   public final class mainJSST implements DurandalGroupTemplate {

      private final AtomicBoolean pluginsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean appTitleIsSet = new AtomicBoolean(false);
      private final AtomicBoolean pathsIsSet = new AtomicBoolean(false);
      private final ST template;

      private mainJSST(STGroup group) {
   		template = group.getInstanceOf("mainJS");
   	}

      public mainJSST addPluginsValue(Object name_) {
         pluginsIsSet.set(true);
         template.addAggr("plugins.{name}", ( (name_==null || name_.toString().length()==0) ? null : name_));
         return this;
      } 
      public mainJSST setAppTitle(Object value) {
      	tryToSetStringProperty(template, value, appTitleIsSet, "appTitle");   
         return this;
      } 
      public mainJSST addPathsValue(Object name_, Object path_) {
         pathsIsSet.set(true);
         template.addAggr("paths.{name, path}", ( (name_==null || name_.toString().length()==0) ? null : name_), ( (path_==null || path_.toString().length()==0) ? null : path_));
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

	static void tryToSetStringProperty(ST template, Object value, AtomicBoolean alreadySet, String name) {
		if (alreadySet.get()) return;
		if (value == null || value.toString().length() == 0) return;
		alreadySet.set(true);
		template.add(name, value);
	}

	static boolean tryToSetListProperty(ST template, Object value, AtomicBoolean alreadySet, String name) {
		if (value == null || value.toString().length() == 0) return true;
		alreadySet.set(true);
		template.add(name, value);
		return false;
	}

	private enum FormatCode {
	      capitalize, toUpper, lowFirst, toLower, humpToCap, camelHump, splitCamelHump, singlify, packageToPath
	   }

	   private final class DefaultAttributeRenderer implements org.stringtemplate.v4.AttributeRenderer {

	      @Override
	      public String toString(Object o, String formatString, java.util.Locale locale) {

	         final String text = o.toString();

	         if (formatString == null) return text;

	         switch (FormatCode.valueOf(formatString)) {
	            case capitalize:
	               return capitalize(text);
	            case toUpper:
	               return toUpper(text);
	            case lowFirst:
	               return lowFirst(text);
	            case toLower:
	               return text.toLowerCase();
	            case humpToCap:
	               return humpToCap(text);
	            case camelHump:
	               return camelHump(text);
	            case splitCamelHump:
	               return splitCamelHump(text);
	            case singlify:
	               String s = toUpper(text).substring(0, 1) + text.substring(1);
	               if (s.toLowerCase().endsWith("ies")) return s.substring(0, s.length() - 3) + "y";
	               else if (s.toLowerCase().endsWith("es") || s.toLowerCase().endsWith("nts")) return s.substring(0, s.length() - 1);
	               else if (s.toLowerCase().endsWith("ions") || s.toLowerCase().endsWith("mns"))
	                  return s.substring(0, s.length() - 1);
	               return s;
	            case packageToPath:
	               return packageToPath((text));
	            default:
	               return o.toString();
	         }
	      }

	      private String capitalize(String string) {
	         if (string == null || string.length() == 0) return "";
	         return Character.toUpperCase(string.charAt(0)) + (string.length() > 1 ? string.substring(1) : "");
	      }

	      private String lowFirst(String string) {
	         if (string == null || string.length() == 0) return "";
	         return Character.toLowerCase(string.charAt(0)) + (string.length() > 1 ? string.substring(1) : "");
	      }

	      private String toUpper(String text) {
	         return text.toUpperCase();
	      }

	      private String humpToCap(String text) {
	         final char[] chars = text.toCharArray();
	         final StringBuilder out = new StringBuilder();
	         boolean first = true;
	         for (int i = 0; i < chars.length; i++) {
	            char aChar = chars[i];
	            if (!first && Character.isUpperCase(aChar) && (i < chars.length - 2 && Character.isLowerCase(chars[i + 1]))) {
	               out.append("_");
	            }
	            first = false;
	            out.append(Character.toUpperCase(aChar));
	         }
	         return out.toString();
	      }

	      private String camelHump(String text) {
	         final char[] chars = text.toCharArray();
	         final StringBuilder out = new StringBuilder();
	         boolean capitalize = true;
	         for (char aChar : chars) {
	            if (Character.isWhitespace(aChar)) {
	               capitalize = true;
	               continue;
	            }
	            out.append(capitalize ? Character.toUpperCase(aChar) : aChar);
	            capitalize = false;
	         }
	         return out.toString();
	      }

	      private String splitCamelHump(String text) {
	         final char[] chars = text.toCharArray();
	         final StringBuilder out = new StringBuilder();
	         boolean first = true;
	         for (char aChar : chars) {
	            if (Character.isUpperCase(aChar)) out.append(" ");
	            out.append(first ? Character.toUpperCase(aChar) : Character.toLowerCase(aChar));
	            first = false;
	         }
	         return out.toString();
	      }

	      private String packageToPath(String packageName) {
	          return (packageName == null ? "" : (packageName.replaceAll("[.]", "/") + java.io.File.separator));
	      }
	   } 

	public String list(String delimiter, Object... elements) {
		final StringBuilder list = new StringBuilder();
		boolean first = true;
		for (Object element : elements) {
			if (!first) list.append(delimiter);
			list.append(element);
			first = false;
		}
		return list.toString() + delimiter;
	}

	public static void toSTGFile(java.io.File dir) throws java.io.IOException {
		final java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(dir, "DurandalGroup.stg")));
		out.write(stg);
		out.close();
   }

	private static final String stg = new StringBuilder()
		.append("delimiters \"~\", \"~\"\n")
		.append("eom() ::= <<}>>\n")
		.append("gt() ::= <<> >>\n")
		.append("model(name,statements) ::= <<var ~name~ = function () {\n" + 
	"	var self = this;\n" + 
	"\n" + 
	"	~statements:{it|~it~;};separator=\"\\n\\n\"~\n" + 
	"}; >>\n")
		.append("moduleJS(returnValue,statements,dependencies) ::= <<define([~dependencies:{it|'~it.importName~'};separator=\", \"~], function (~dependencies:{it|~it.refName~};separator=\", \"~) {\n" + 
	"\n" + 
	"   ~statements:{it|~it~};separator=\"\\n\"~\n" + 
	"\n" + 
	"	return ~returnValue~;\n" + 
	"}); >>\n")
		.append("shellHTML() ::= <<<div>\n" + 
	"    <nav class=\"navbar navbar-default navbar-fixed-top\" role=\"navigation\">\n" + 
	"        <div class=\"navbar-header\">\n" + 
	"            <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\">\n" + 
	"                <span class=\"sr-only\">Toggle Navigation</span>\n" + 
	"                <span class=\"icon-bar\"></span>\n" + 
	"                <span class=\"icon-bar\"></span>\n" + 
	"                <span class=\"icon-bar\"></span>\n" + 
	"            </button>\n" + 
	"            <a class=\"navbar-brand\" href=\"#\">\n" + 
	"                <i class=\"fa fa-home\"></i>\n" + 
	"                <span></span>\n" + 
	"            </a>\n" + 
	"        </div>\n" + 
	"\n" + 
	"        <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\n" + 
	"            <ul class=\"nav navbar-nav\" data-bind=\"foreach: router.navigationModel\">\n" + 
	"                <li data-bind=\"css: { active: isActive }\">\n" + 
	"                    <a data-bind=\"attr: { href: hash }, text: title\"></a>\n" + 
	"                </li>\n" + 
	"            </ul>\n" + 
	"\n" + 
	"            <ul class=\"nav navbar-nav navbar-right\">\n" + 
	"                <li class=\"loader\" data-bind=\"css: { active: router.isNavigating }\">\n" + 
	"                    <i class=\"fa fa-spinner fa-spin fa-2x\"></i>\n" + 
	"                </li>\n" + 
	"            </ul>\n" + 
	"\n" + 
	"            <form class=\"navbar-form navbar-right\" role=\"search\" data-bind=\"submit:search\">\n" + 
	"                <div class=\"form-group\">\n" + 
	"                    <input type=\"text\" class=\"form-control\" id=\"searchTerm\" placeholder=\"Search\"/>\n" + 
	"                </div>\n" + 
	"            </form>\n" + 
	"        </div>\n" + 
	"    </nav>\n" + 
	"\n" + 
	"    <div class=\"page-host\" data-bind=\"router: { transition:'entrance' }\"></div>\n" + 
	"</div> >>\n")
		.append("shellJS(routes) ::= <<define(['plugins/router', 'durandal/app', 'material', 'knockout'], function (router, app, material, ko) {\n" + 
	"\n" + 
	"    return {\n" + 
	"\n" + 
	"        router: router,\n" + 
	"\n" + 
	"        search: function (formElement) {\n" + 
	"            var menuItem = $(formElement).find(\"#searchTerm\").val().toLowerCase();\n" + 
	"            for (var i = 0; i < router.routes.length; i++) {\n" + 
	"                var obj = router.routes[i];\n" + 
	"                if (obj.route.toLowerCase().includes(menuItem)) {\n" + 
	"                    router.navigate(obj.route);\n" + 
	"                    return;\n" + 
	"                }\n" + 
	"            }\n" + 
	"        },\n" + 
	"\n" + 
	"        activate: function () {\n" + 
	"\n" + 
	"            $.material.init();\n" + 
	"\n" + 
	"            return router.map([\n" + 
	"               ~routes:{it|{route: ['~it.route~'], moduleId: '~it.moduleId~/~it.moduleId~', title: '~it.title~'~if(it.nav)~, nav: ~it.nav~~endif~~bugfix2()~};separator=\",\\n\"~ \n" + 
	"            ]).buildNavigationModel().\n" + 
	"                mapUnknownRoutes().\n" + 
	"                activate();\n" + 
	"        }\n" + 
	"    };\n" + 
	"}); >>\n")
		.append("appHTML(appStylesheetPath,splashTitle) ::= <<<!DOCTYPE html>\n" + 
	"<html>\n" + 
	"<head>\n" + 
	"\n" + 
	"    <meta charset=\"utf-8\"/>\n" + 
	"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge, chrome=1\"/>\n" + 
	"    <meta name=\"apple-mobile-web-app-capable\" content=\"yes\"/>\n" + 
	"    <meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\"/>\n" + 
	"    <meta name=\"format-detection\" content=\"telephone=no\"/>\n" + 
	"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n" + 
	"\n" + 
	"    <!-- uncomment this to force a refresh on the favicon -->\n" + 
	"    <!--<link rel=\"shortcut icon\" href=\"https://localhost:8080/favicon.ico?v=2\" />-->\n" + 
	"\n" + 
	"    <link rel=\"apple-touch-startup-image\" href=\"./lib/durandal/img/ios-startup-image-landscape.png\" media=\"(orientation:landscape)\"/>\n" + 
	"    <link rel=\"apple-touch-startup-image\" href=\"./lib/durandal/img/ios-startup-image-portrait.png\" media=\"(orientation:portrait)\"/>\n" + 
	"    <link rel=\"apple-touch-icon\" href=\"./lib/durandal/img/icon.png\"/>\n" + 
	"\n" + 
	"    <link rel=\"stylesheet\" href=\"./lib/bootstrap/css/bootstrap.min.css\"/>\n" + 
	"    <link rel=\"stylesheet\" href=\"./lib/font-awesome/css/font-awesome.min.css\"/>\n" + 
	"    <link rel=\"stylesheet\" href=\"./lib/durandal/css/durandal.css\"/>\n" + 
	"\n" + 
	"    <link href=\"./lib/bootstrap/css/bootstrap-material-design.min.css\" rel=\"stylesheet\">\n" + 
	"    <link href=\"./lib/bootstrap/css/ripples.min.css\" rel=\"stylesheet\">\n" + 
	"\n" + 
	"    <link rel=\"stylesheet\" href=\"./lib/css/ie10mobile.css\"/>\n" + 
	"    <link rel=\"stylesheet\" href=\"./lib/durandal/css/starterkit.css\"/>\n" + 
	"\n" + 
	"    <!-- use this file to set all app-specific css-->\n" + 
	"    ~if(appStylesheetPath)~<link rel=\"stylesheet\" href=\"~appStylesheetPath~\"/>~endif~\n" + 
	"\n" + 
	"    <script type=\"text/javascript\">\n" + 
	"        if (navigator.userAgent.match(/IEMobile\\/10\\.0/)) {\n" + 
	"            var msViewportStyle = document.createElement(\"style\");\n" + 
	"            var mq = \"@@-ms-viewport{width:auto!important}\";\n" + 
	"            msViewportStyle.appendChild(document.createTextNode(mq));\n" + 
	"            document.getElementsByTagName(\"head\")[0].appendChild(msViewportStyle);\n" + 
	"        }\n" + 
	"    </script>\n" + 
	"</head>\n" + 
	"<body>\n" + 
	"<div id=\"applicationHost\">\n" + 
	"    <div class=\"splash\">\n" + 
	"        <div class=\"message\">~splashTitle~</div>\n" + 
	"        <i class=\"fa fa-spinner fa-spin\"></i>\n" + 
	"    </div>\n" + 
	"</div>\n" + 
	"<script src=\"./lib/require/require.js\" data-main=\"./main.js\"></script>\n" + 
	"</body>\n" + 
	"</html> >>\n")
		.append("bugfix2() ::= <<} >>\n")
		.append("eom() ::= <<} >>\n")
		.append("gt() ::= <<> >>\n")
		.append("mainJS(plugins,appTitle,paths) ::= <<requirejs.config({\n" + 
	"    paths: {\n" + 
	"		'durandal': 'lib/durandal/js',\n" + 
	"        'plugins': 'lib/durandal/js/plugins',\n" + 
	"        'transitions': 'lib/durandal/js/transitions',\n" + 
	"        'jquery': 'lib/jquery/jquery-1.9.1.min',\n" + 
	"        'jquery-ui': 'lib/jquery-ui/jquery-ui.min',\n" + 
	"        'knockout': 'lib/knockout/knockout-3.1.0',\n" + 
	"        'knockoutMapping': 'lib/knockout/knockout.mapping-latest',\n" + 
	"        'text': 'lib/require/text',\n" + 
	"        'sockjs': 'lib/sockjs/sockjs.min',\n" + 
	"        'eventbus': 'lib/vertx/vertxbus-3.1.0',\n" + 
	"        'material': 'lib/bootstrap/js/material.min',\n" + 
	"        'dropdown': 'lib/bootstrap/js/dropdown',\n" + 
	"        'materialRipples': 'lib/bootstrap/js/ripples.min'~if(paths)~\n" + 
	"			~paths:{it|'~it.name~': '~it.path~',};separator=\",\\n\"~~endif~\n" + 
	"    }\n" + 
	"});\n" + 
	"\n" + 
	"define(['durandal/system', 'durandal/app'], function (system, app) {\n" + 
	"\n" + 
	"    system.debug(true);\n" + 
	"\n" + 
	"    app.title = '~appTitle~';\n" + 
	"\n" + 
	"    app.configurePlugins({\n" + 
	"		 router: true,\n" + 
	"       dialog: true,\n" + 
	"       numberFormatter: true,\n" + 
	"       flash: true~if(plugins)~\n" + 
	"		~plugins:{it|~it.name~: true};separator=\",\\n\"~~endif~\n" + 
	"    });\n" + 
	"\n" + 
	"    app.start().then(function () {\n" + 
	"        app.setRoot('shell', 'entrance');\n" + 
	"    });\n" + 
	"}); >>\n").toString();
} 