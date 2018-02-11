package com.generator.generators.durandal;

import org.junit.Test;

/**
 * Created 08.09.17.
 */
public class Tests {
   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Tests.class);
   //@Test
   public void testDurandal() {

      final DurandalGroup durandalGroup = new DurandalGroup();

      log.info(durandalGroup.newappHTML().setSplashTitle("TEST").toString());
   }
}
