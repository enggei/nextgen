package com.generator.generators.easyFlow;

import org.junit.Test;

public class EasyFlowConverterGroupTests {

	final EasyFlowConverterGroup group = new EasyFlowConverterGroup(new java.io.File("/media/storage/nextgen/src/main/java/com/generator/generators/easyFlow/EasyFlowConverter.stg"));


   @Test
   public void testEasyFlowConverter() {
       // todo add EasyFlowConverterGroup- tests here;

		System.out.println(group.newdeclaration());
	} ;

}