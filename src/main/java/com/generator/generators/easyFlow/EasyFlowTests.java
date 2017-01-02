package com.generator.generators.easyFlow;

import org.junit.Test;

public class EasyFlowTests {

    @Test
   public void testEasyFlowGroup() {

      System.setProperty("generator.path", "src/main/java/com/generator/generators");
      final EasyFlowGroup group = new EasyFlowGroup();

   	// todo add EasyFlowGroup- tests here;
		 System.out.println(group.neweasyFlow().setName("NAME"));

   } ;
}