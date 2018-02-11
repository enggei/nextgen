package com.generator.generators.rivescript;

import com.rivescript.ConcatMode;
import com.rivescript.Config;
import com.rivescript.RiveScript;
import com.rivescript.macro.Subroutine;
import com.rivescript.session.ConcurrentHashMapSessionManager;
import com.rivescript.session.SessionManager;
import com.rivescript.util.StringUtils;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created 13.10.17.
 */
public class Tests {
   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Tests.class);
   public static void main(String[] args) {

      // https://www.rivescript.com/docs/tutorial

      // Create a new bot with the default settings.
      final SessionManager sessionManager = new ConcurrentHashMapSessionManager();

      final Map<String, String> errors = new LinkedHashMap<>();

      RiveScript bot = new RiveScript(Config.newBuilder()
            .throwExceptions(false)          // Whether exception throwing is enabled
            .strict(true)                    // Whether strict syntax checking is enabled
            .utf8(false)                     // Whether UTF-8 mode is enabled
            .unicodePunctuation("[.,!?;:]")  // The unicode punctuation pattern
            .forceCase(false)                // Whether forcing triggers to lowercase is enabled
            .concat(ConcatMode.NONE)         // The concat mode
            .depth(50)                       // The recursion depth limit
            .sessionManager(sessionManager)  // The session manager for user variables
            .errorMessages(errors)           // Map of custom error messages
            .build());

      bot.setSubroutine("newNode", new Subroutine() {
         @Override
         public String call(RiveScript rs, String[] strings) {
            return "creating a " + strings[0] + " node: getGraph().newNode(Label.label(\"" + strings[0] + "\"); with UUID " + UUID.randomUUID();
         }
      });

      // Load a directory full of RiveScript documents (.rive files)
      bot.loadDirectory("src/main/java/com/generator/generators/rivescript/replies");
      // Load an individual file.
//      bot.loadFile("src/main/java/com/generator/generators/rivescript/replies/eliza.rive");

      // Sort the replies after loading them!
      bot.sortReplies();

      // Get a reply.
      String reply = bot.reply("user", "create node Entity");
      log.info(reply);
   }

   //@Test
   public void testGroup() {

      final RivescriptGroup group = new RivescriptGroup();
      log.info(group.newscript().setVersion("1.0").setName("Hello world").toString());

      log.info(group.newscript().
            setVersion("2.0").
            setName("begin").
            addGroupsValue(group.newbegin().
                  addTriggersValue(group.newtrigger().
                        setName("request").addResponsesValue("{ok}", null, null))).
            addGroupsValue(group.newvariable().
                  setName("master").
                  setValue("localuser")).toString());
   }
}
