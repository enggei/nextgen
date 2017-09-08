package com.generator.generators.durandal;

import org.junit.Test;

/**
 * Created 08.09.17.
 */
public class Tests {

   @Test
   public void testDurandal() {

      final DurandalGroup durandalGroup = new DurandalGroup();

      System.out.println(durandalGroup.newappHTML().setSplashTitle("TEST"));
   }
}
