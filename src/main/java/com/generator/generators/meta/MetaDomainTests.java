package com.generator.generators.meta;

import org.junit.Test;

/**
 * Created 27.03.17.
 */
public class MetaDomainTests {

   static {
      System.setProperty("generator.path", "src/main/java/com/generator/generators");
   }

   @Test
   public void testInterfaces() {

      System.out.println(new MetaDomainGroup().newEntityInterface().setPackageName("com.test").setEntity("Database"));
   }
}
