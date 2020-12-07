package nextgen.model.workflow;

import org.jeasy.flows.engine.WorkFlowEngine;
import org.jeasy.flows.engine.WorkFlowEngineBuilder;
import org.jeasy.flows.work.WorkContext;
import org.jeasy.flows.work.WorkReport;
import org.jeasy.flows.workflow.SequentialFlow;
import org.jeasy.flows.workflow.WorkFlow;
import org.junit.Test;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Tests {

   @Test
   public void testWorkflow() {

      final WorkFlowFacade db = new WorkFlowFacade("/home/goe/projects/nextgen/components/core/src/main/java/nextgen/workflow/db");

      db.doInTransaction(transaction -> {

         final File mainJava = new File(new File("/home/goe/projects/nextgen2"), "src/main/java");
         final String packageName = "nextgen.st.domain";

         final WorkContext workContext = new WorkContext();
         workContext.put("mainJava", mainJava);
         workContext.put("packageName", packageName);

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
}
