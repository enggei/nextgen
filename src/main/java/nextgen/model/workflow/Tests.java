package nextgen.model.workflow;

import nextgen.templates.domain.Domain;
import nextgen.templates.domain.Entity;
import org.jeasy.flows.engine.WorkFlowEngine;
import org.jeasy.flows.engine.WorkFlowEngineBuilder;
import org.jeasy.flows.work.WorkContext;
import org.jeasy.flows.work.WorkReport;
import org.jeasy.flows.workflow.SequentialFlow;
import org.jeasy.flows.workflow.WorkFlow;
import org.junit.*;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import static nextgen.templates.domain.DomainPatterns.*;

public class Tests {

   @Test
   public void testWorkflow() {

      final WorkFlowFacade db = new WorkFlowFacade("/home/goe/projects/nextgen/components/core/src/main/java/nextgen/workflow/db");

      db.doInTransaction(transaction -> {

         final File mainJava = new File(new File("/home/goe/projects/nextgen2"), "src/main/java");
         final Domain domain = stDomain("STDomain");
         final String packageName = "nextgen.st.domain";

         final WorkContext workContext = new WorkContext();
         workContext.put("mainJava", mainJava);
         workContext.put("packageName", packageName);
         workContext.put("domain", domain);

         db.findAllWork().findFirst().ifPresent(work -> {
            final WorkFlow workflow = SequentialFlow.Builder.aNewSequentialFlow()
                  .execute(db.newInstance(work))
                  .build();

            final WorkFlowEngine workFlowEngine = WorkFlowEngineBuilder.aNewWorkFlowEngine().build();
            final WorkReport workReport = workFlowEngine.run(workflow, workContext);

            final WorkContext reportWorkContext = workReport.getWorkContext();
         });
      });
   }

   @Test
   public void testAllFlows() {

      final WorkFlowFacade db = new WorkFlowFacade("/home/goe/projects/nextgen/components/core/src/main/java/nextgen/workflow/db");

      db.doInTransaction(transaction -> {

         final AtomicInteger workNo = new AtomicInteger(0);

         final Work work1 = getWork(db, workNo);
         final Work work2 = getWork(db, workNo);
         final Work work3 = getWork(db, workNo);
         final Work work4 = getWork(db, workNo);
         final Work work5 = getWork(db, workNo);

         final nextgen.model.workflow.RepeatFlow repeatFlow = db.newRepeatFlow()
               .setName("repeat 3 times")
               .setRepeat(db.newWorkInstance(work1))
               .setTimes(3);

         final nextgen.model.workflow.ParallelFlow parallelFlow = db.newParallelFlow()
               .setName("Parallel")
               .addExecute(db.newWorkInstance(work2))
               .addExecute(db.newWorkInstance(work3));

         final nextgen.model.workflow.ConditionalFlow conditionalFlow = db.newConditionalFlow()
               .setName("Conditional")
               .setExecute(db.newWorkInstance(parallelFlow))
               .setThen(db.newWorkInstance(work4))
               .setOtherwise(db.newWorkInstance(work5));

         final nextgen.model.workflow.SequentialFlow sequentialFlow = db.newSequentialFlow()
               .setName("Sequential")
               .setExecute(db.newWorkInstance(repeatFlow))
               .addThen(db.newWorkInstance(conditionalFlow));

         final ExecutorService executorService = Executors.newFixedThreadPool(2);

         final SequentialFlow workflow = db.toFlow(sequentialFlow, executorService);
         final WorkFlowEngine workFlowEngine = WorkFlowEngineBuilder.aNewWorkFlowEngine().build();
         final WorkContext workContext = new WorkContext();
         final WorkReport workReport = workFlowEngine.run(workflow, workContext);
         executorService.shutdown();
      });
   }

   public Work getWork(WorkFlowFacade db, AtomicInteger workNo) {
      return db.newWork()
            .setName("Work_" + workNo.incrementAndGet())
            .setPackage("test")
            .addStatements(db.newWorkStatement()
                  .setStatement("System.out.println(\"Work " + workNo.get() + "\");"));
   }

   public Domain stDomain(String name) {

      // ST
      final Entity stParameterType = newEnum("STParameterType", "SINGLE,LIST,KVLIST");

      final Entity stParameterKey = newEntity("STParameterKey")
            .addRelations(newStringField("name"))
            .addRelations(newStringField("argumentType"));

      final Entity stParameter = newEntity("STParameter")
            .addRelations(newStringField("name", true))
            .addRelations(newEnumField("type", stParameterType))
            .addRelations(newOneToMany("keys", stParameterKey))
            .addRelations(newStringField("argumentType"));

      final Entity stTemplate = newEntity("STTemplate")
            .addRelations(newStringField("name", true))
            .addRelations(newStringField("text"))
            .addRelations(newOneToManyString("implements"))
            .addRelations(newOneToMany("parameters", stParameter))
            .addRelations(newOneToManySelf("children"));

      final Entity stInterface = newEntity("STInterface")
            .addRelations(newStringField("name"));

      final Entity stEnumValue = newEntity("STEnumValue")
            .addRelations(newStringField("name", true))
            .addRelations(newStringField("lexical"));

      final Entity stEnum = newEntity("STEnum")
            .addRelations(newStringField("name", true))
            .addRelations(newOneToMany("values", stEnumValue));

      final Entity stGroupModel = newEntity("STGroupModel")
            .addRelations(newStringField("name", true))
            .addRelations(newStringField("delimiter"))
            .addRelations(newStringField("icon"))
            .addRelations(newStringField("tags"))
            .addRelations(newOneToMany("templates", stTemplate))
            .addRelations(newOneToMany("interfaces", stInterface))
            .addRelations(newOneToMany("enums", stEnum));

      final Entity stDirectory = newEntity("STGDirectory")
            .addRelations(newStringField("path"))
            .addRelations(newOneToMany("groups", stGroupModel));

      // ST Parsing
      final Entity stgErrorType = newEnum("STGErrorType", "COMPILE,RUNTIME,IO,INTERNAL");

      final Entity stgError = newEntity("STGError")
            .addRelations(newEnumField("type", stgErrorType))
            .addRelations(newStringField("message"))
            .addRelations(newIntegerField("line"))
            .addRelations(newIntegerField("charPosition"));

      final Entity stgParseResult = newEntity("STGParseResult")
            .addRelations(newOneToOne("parsed", stGroupModel))
            .addRelations(newOneToMany("errors", stgError));

      return newDomain(name)
            .addEntities(stgParseResult)
            .addEntities(stDirectory);
   }
}
