
 package com.generator.generators.webapp;
import org.junit.Test;

public class WebappGroupTests {

	static {
      System.setProperty("generator.path", "src/main/java/com/generator/generators");
   }

   final WebappGroup group = new WebappGroup();

    @Test
   public void testWebapp() {
       // todo add WebappGroup- tests here;

		 System.out.println(group.newappHtml().setAppname("T E S T"));
		 System.out.println(group.newappJs().setAppname("T E S T"));

		 System.out.println(group.newshellJs());
		 System.out.println(group.newshellHtml());
	 } ;
}  