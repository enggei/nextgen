package com.generator.generators.openapi3;

import org.junit.Test;

/**
 * Created 05.02.18.
 */
public class Tests {

   @Test
   public void testSpec() {

      final Openapi3Group group = new Openapi3Group();

      final Openapi3Group.specificationST specificationST = group.newspecification().
            setTitle("Swagger Petstore").
            setVersion("1.0.0");




      System.out.println(specificationST);
   }
}