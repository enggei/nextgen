package com.generator.generators.url;

import com.generator.generators.url.parser.urlLexer;
import com.generator.generators.url.parser.urlParser;
import com.generator.generators.url.parser.urlNodeListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

/**
 * Created 10.09.17.
 */
public class Tests {

   @Test
   public void testParser() {

      final String[] urls = new String[]{
            "ftps://geirove:password@example.com/pub/file.txt",
            "http://svn.example.com:9834/repos",
            "http://localhost:8080/demo/my-demo-servlet?param1=hello&param2=goodbye",
            "http://localhost:8080/demo/my-demo-servlet?value=hello%20world",
            "https://github.com/dpaukov/combinatoricslib3#3-simple-permutations",   // this does not currently work
      };

      for (String url : urls) {
         final urlNodeListener listener = new urlNodeListener(true) {
            @Override
            public void enterUser(urlParser.UserContext arg) {
               super.enterUser(arg);
               System.out.println(delim + arg.getText());
            }
         };
         new ParseTreeWalker().walk(listener, new urlParser(new CommonTokenStream(new urlLexer(CharStreams.fromString(url)))).fragmentaddress());
      }
   }
}