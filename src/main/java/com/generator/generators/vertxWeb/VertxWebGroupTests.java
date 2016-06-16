
 package com.generator.generators.vertxWeb;
import org.junit.Test;

public class VertxWebGroupTests {

	static {
      System.setProperty("generator.path", "src/main/java/com/generator/generators");
   }

   final VertxWebGroup group = new VertxWebGroup();

    @Test
   public void testVertxWeb() {
       // todo add VertxWebGroup- tests here;

		 System.out.println(group.newserverVerticle().
			 setName("NAME"));
	 } ;
}  