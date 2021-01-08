package domain.neo;

import domain.meta.*;
import nextgen.st.STGenerator;
import nextgen.templates.javaneo4jembedded.NeoFactory;

public class NeoSTDomain {
   public static void main(String[] args) {

      final String root = args.length <= 0 ? "./src/main/java" : args[0];
      final MetaDomain domain = NeoFactoryImpl.newNeo();

      final NeoFactory transform = new NeoTransformer("domain.neo").transform(domain);
      STGenerator.writeJavaFile(transform, transform.getPackage().toString(), transform.getName().toString(), root);
   }
}