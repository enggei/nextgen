package com.generator.generators.mobx;

import org.junit.Test;

/**
 * Created 20.09.17.
 */
public class Tests {
   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Tests.class);
   //@Test
   public void testMobXGroup() {

      final MobXGroup mobXGroup = new MobXGroup();

      final MobXGroup.ModelST modelST = mobXGroup.newModel().
            setName("Todo").
            addObservablesValue(null, "id");
      log.info(modelST.toString());
   }
}
