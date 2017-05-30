package com.generator.generators.regexp;

import org.junit.Test;

/**
 * Created 28.05.17.
 */
public class RegexpUtilTests {

   @Test
   public void testGenericRegexp() {
      final RegexpGeneric regexpGeneric = new RegexpGenericImpl();

      final RegexpGeneric.RegexpGenericContext context = new RegexpGeneric.RegexpGenericContext();
      context.sampleCount = 100;
      context.changeSupport.addPropertyChangeListener(evt -> System.out.println(evt.getNewValue()));

      regexpGeneric.start(context);
   }
}