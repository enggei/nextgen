package nextgen.utils;

import nextgen.templates.JavaPatterns;
import nextgen.workflow.WorkFlowFacade;
import org.jeasy.flows.work.WorkContext;
import org.jeasy.flows.work.WorkReport;

public class DomainUtil {

   public static void importDomain(String statements, WorkFlowFacade db) {

      final WorkContext workContext = new WorkContext();
      workContext.put("db", db.getDatabaseService());

      final nextgen.templates.javaeasyflows.Work w = nextgen.templates.JavaEasyFlowsPatterns.newWork();
      w.setName("DomainImporter");
      w.setPackageName("tmp");
      w.addImports(JavaPatterns.newImportDeclaration("nextgen.templates.domain").setIsAsterisk(true));
      w.addImports(JavaPatterns.newImportDeclaration("nextgen.templates.DomainPatterns"));
      w.addInputs("org.neo4j.graphdb.GraphDatabaseService", "db");
      w.setStatements(getImportStatements(statements));
      System.out.println(w.toString());

      final WorkReport workReport = db.run(workContext, w);
      final WorkContext reportWorkContext = workReport.getWorkContext();

   }

   private static Object[] getImportStatements(String statements) {
      return new Object[]{
            "System.out.println(\"here\");",
            statements
      };
   }
}