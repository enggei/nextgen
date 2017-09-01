package com.projects.javats;

import com.generator.generators.durandal.DurandalDomainGroup;
import com.generator.generators.html5.Html5DomainGroup;
import com.generator.util.FileUtil;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;

/**
 * Created 10.05.17.
 * todo turn this into an editor
 */
public class Generator {

   private final File webroot = new File("/home/goe/projects/nextgen/src/test/web");

   private final DurandalDomainGroup durandal = new DurandalDomainGroup();
   private final Html5DomainGroup html = new Html5DomainGroup();

   @BeforeClass
   public static void setup() {
      System.setProperty("generator.path", "src/main/java/com/generator/generators");
   }

   @Test
   public void generateMonitorPage() {

      final Html5DomainGroup.sectionST sectionST = html.
            newsection().
            setContent(html.newdiv().setClass("page-headers").
                  setContent(
                        html.newh2().
                              setContent("Monitor") + "\n" +
                              html.newdiv().setContent(
                                    html.newul().setContent(
                                          html.newbutton().
                                                setClass("btn btn-primary").
                                                setDatabind("click: createtorrent").
                                                setContent("Create torrent"))) + "" + html.newinput()));

      final DurandalDomainGroup.modelST monitor = durandal.newmodel().setName("Monitor");
      monitor.addStatementsValue("self.eb = new EventBus(utils.getHost(\"eventbus/\"), null, {debug: true})");
      monitor.addStatementsValue("self.eb.onopen = function () {\n" +
            "\tconsole.log(\"Eventbus opened\");\n" +
            "\n" +
            "\tself.eb.registerHandler(\"session.alert\", function (err, msg) {\n" +
            "\t\tconsole.info(\"session.alert: \" + msg.body);\n" +
            "\t})\n" +
            "}");
      monitor.addStatementsValue("self.createtorrent = function () {\n" +
            "}");

      final DurandalDomainGroup.moduleJSST moduleJSST = durandal.newmoduleJS().
            addStatementsValue(monitor).
            setReturnValue("new Monitor()");

      moduleJSST.addDependenciesValue("eventbus", "EventBus").
            addDependenciesValue("plugins/router", "r").
            addDependenciesValue("knockout", "ko").
            addDependenciesValue("knockoutMapping", "mapping").
            addDependenciesValue("utils", "utils");


      final File moduleDir = FileUtil.tryToCreateDirIfNotExists(new File(webroot, "monitor"));
      FileUtil.write(sectionST, FileUtil.tryToCreateFileIfNotExists(new File(moduleDir, "monitor.html")));
      FileUtil.write(moduleJSST, FileUtil.tryToCreateFileIfNotExists(new File(moduleDir, "monitor.js")));
   }
}