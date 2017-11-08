package com.generator.generators.chromeBookmarks;

import com.generator.app.App;
import com.generator.app.nodes.NeoNode;
import com.generator.util.FileUtil;
import com.generator.util.StringUtil;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created 08.11.17.
 */
public class ChromeBookmarksPlugin extends ChromeBookmarksDomainPlugin {

   public ChromeBookmarksPlugin(App app) {
      super(app);
   }

   @Override
   protected void addActionsTo(JMenu menu) {

      menu.add(new App.TransactionAction("New Catalog", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String name = SwingUtil.showInputDialog("Name", app);
            if (name == null || name.length() == 0) return;

            fireNodesLoaded(newCatalog(name));
         }
      });
   }

   @Override
   protected void handleCatalog(JPopupMenu pop, NeoNode catalogNode, Set<NeoNode> selectedNodes) {

      pop.add(new App.TransactionAction("Import From Chrome", app) {

         private final SimpleDateFormat dd_mm_yyyy = new SimpleDateFormat("dd_MM_yyyy");

         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            final File file = SwingUtil.showOpenFile(app, "/home/goe/projects/nextgen/src/main/java/com/generator/generators/chromeBookmarks");
            if (file == null || !file.getName().toLowerCase().endsWith(".html")) return;

            FileUtil.readString(file, new FileUtil.LineHandler() {

               private String currentGroup;
               private String currentHref;
               private String icon;
               private Date hrefDate;

               private final String attributeRegexp = "([^ ]*=\"[^\"]*\")";
               private final String name = "<A\\b[^>]*>(.*?)</A>";

               @Override
               public boolean handleLine(String line) {

                  final int href = line.indexOf("HREF=");
                  if (href == -1) {
                     // <DT><H3 ADD_DATE="1458640527" LAST_MODIFIED="0">03_2016</H3>
                     if (line.trim().startsWith("<DT><H3")) {
                        int start = line.indexOf(">", line.indexOf("ADD_DATE")) + 1;
                        int end = line.indexOf("<", start);
                        currentGroup = line.substring(start, end);
                     }
                     return false;
                  }

                  final int hrefStart = href + 6;
                  final int hrefEnd = line.indexOf("\"", hrefStart);
                  currentHref = line.substring(hrefStart, hrefEnd);

                  final int addDateStart = line.indexOf("ADD_DATE=") + 10;
                  final int addDateEnd = line.indexOf("\"", addDateStart);
                  hrefDate = new Date(Long.parseLong(line.substring(addDateStart, addDateEnd)));

                  final int iconStart = line.indexOf("ICON=") + 6;
                  final int iconEnd = line.indexOf("\"", iconStart);
                  icon = iconStart == -1 ? null : (line.substring(iconStart, iconEnd));

                  for (String group : StringUtil.match(attributeRegexp, line, 1)) {
                     if (group.startsWith("HREF")) currentHref = group.substring(6, group.length() - 1);
                     if (group.startsWith("ADD_DATE"))
                        hrefDate = new Date(Long.parseLong(group.substring(10, group.length() - 1) + "000"));
                     if (group.startsWith("ICON")) icon = group.substring(6, group.length() - 1);
                  }

                  for (String group : StringUtil.match(name, line, 1)) {

                     final Set<Node> foundGroupNode = new LinkedHashSet<>();
                     outgoingGROUP(catalogNode.getNode(), (relationship, groupNode) -> {
                        if(currentGroup.equals(getNameProperty(groupNode)))
                           foundGroupNode.add(groupNode);
                     });

                     if(foundGroupNode.isEmpty()) {
                        final Node newGroup = newGroup(currentGroup);
                        relateGROUP(catalogNode.getNode(), newGroup);
                        foundGroupNode.add(newGroup);
                     }

                     final Node groupNode = foundGroupNode.iterator().next();

                     final Set<Node> foundBookmarkNode = new LinkedHashSet<>();
                     outgoingBOOKMARK(groupNode, (relationship, bookmarkNode) -> {
                        if(currentHref.equals(getHrefProperty(bookmarkNode)))
                           foundBookmarkNode.add(bookmarkNode);
                     });

                     if(foundBookmarkNode.isEmpty()) {
                        final String date = hrefDate==null ? null : dd_mm_yyyy.format(hrefDate);
                        final Node newBookmark = newBookmark(icon, hrefDate==null ? null : date, currentHref, group);
                        relateBOOKMARK(groupNode, newBookmark);
                        foundBookmarkNode.add(newBookmark);
                     }

                     currentHref = null;
                     hrefDate = null;
                     icon = null;
                  }

                  return false;
               }
            });
         }
      });
   }
}