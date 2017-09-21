package com.generator.generators.mobx;

import org.junit.Test;

/**
 * Created 20.09.17.
 */
public class Tests {

   @Test
   public void testMobXGroup() {

      final MobXGroup mobXGroup = new MobXGroup();

      final MobXGroup.ModelST modelST = mobXGroup.newModel().
            setName("Todo").
            addObservablesValue(null, "id");
      System.out.println(modelST);
   }
}
