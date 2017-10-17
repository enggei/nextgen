package com.generator.generators.rivescript;

import org.junit.Test;

/**
 * Created 13.10.17.
 */
public class Tests {

   @Test
   public void testGroup() {

      final RivescriptGroup group = new RivescriptGroup();
      System.out.println(group.newscript().setVersion("1.0").setName("Hello world"));

      System.out.println(group.newscript().
            setVersion("2.0").
            setName("begin").
            addGroupsValue(group.newbegin().
                  addTriggersValue(group.newtrigger().
                        setName("request").addResponsesValue("{ok}", null, null))).
            addGroupsValue(group.newvariable().
                  setName("master").
                  setValue("localuser")));
   }
}
