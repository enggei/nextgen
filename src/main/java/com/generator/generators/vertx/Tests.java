package com.generator.generators.vertx;

import com.generator.ProjectConstants;
import org.junit.Test;

/**
 * Created 08.09.17.
 */
public class Tests {

   @Test
   public void testBaseVerticle() {

      final VertxGroup vertxGroup = new VertxGroup();
      System.out.println(vertxGroup.newBaseRouterVerticle().
            setPackageName(ProjectConstants.TEST_PACKAGE + ".vertx").
            setName("TestBaseVerticle").
            addEndpointsValue("get","getUser","user"));
   }
}
