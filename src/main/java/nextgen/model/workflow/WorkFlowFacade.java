package nextgen.model.workflow;

import net.openhft.compiler.CompilerUtils;
import org.jeasy.flows.work.WorkReportPredicate;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WorkFlowFacade extends WorkFlowNeoFactory {

	public WorkFlowFacade(String dir) {
		super(dir);
	}

	public WorkFlowFacade(org.neo4j.graphdb.GraphDatabaseService db) {
		super(db);
	}

	public org.jeasy.flows.work.Work newInstance(Work work) {
		return newInstance(toCode(work));
	}

	public org.jeasy.flows.work.Work newInstance(nextgen.templates.javaeasyflows.Work javaCode) {
		final String className = javaCode.getPackageName() + "." + javaCode.getName().toString();
		try {
			final Class<?> workClass = CompilerUtils.CACHED_COMPILER.loadFromJava(className, javaCode.toString());
			return (org.jeasy.flows.work.Work) workClass.getDeclaredConstructor().newInstance();
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	public org.jeasy.flows.workflow.ConditionalFlow toFlow(ConditionalFlow flow, ExecutorService executorService) {

		final org.jeasy.flows.workflow.ConditionalFlow.Builder f = org.jeasy.flows.workflow.ConditionalFlow.Builder.aNewConditionalFlow()
				.named(flow.getName())
				.execute(toWork(flow.getExecute(), executorService));

		final WorkInstance then = flow.getThen();
		if (then != null) f.then(toWork(then, executorService));

		final WorkInstance otherwise = flow.getOtherwise();
		if (otherwise != null) f.otherwise(toWork(otherwise, executorService));

		return f.build();
	}

	public org.jeasy.flows.workflow.SequentialFlow toFlow(SequentialFlow flow, ExecutorService executorService) {

		final org.jeasy.flows.workflow.SequentialFlow.Builder f = org.jeasy.flows.workflow.SequentialFlow.Builder.aNewSequentialFlow()
				.named(flow.getName())
				.execute(toWork(flow.getExecute(), executorService));

		flow.getThen().forEach(workType -> f.then(toWork(workType, executorService)));

		return f.build();
	}

	public org.jeasy.flows.workflow.ParallelFlow toFlow(ParallelFlow flow, ExecutorService executorService) {

		final org.jeasy.flows.workflow.ParallelFlow.Builder f = org.jeasy.flows.workflow.ParallelFlow.Builder.aNewParallelFlow(executorService)
				.named(flow.getName())
				.execute(toWork(flow.getExecute(), executorService));

		return f.build();
	}

	public org.jeasy.flows.workflow.RepeatFlow toFlow(RepeatFlow flow, ExecutorService executorService) {

		final org.jeasy.flows.workflow.RepeatFlow.Builder f = org.jeasy.flows.workflow.RepeatFlow.Builder.aNewRepeatFlow()
				.named(flow.getName())
				.repeat(toWork(flow.getRepeat(), executorService));

		if (flow.getTimes() != null)
			f.times(flow.getTimes());
		else if (flow.getUntil() != null)
			f.until(toWorkReportPredicate(flow.getUntil()));

		return f.build();
	}

	public WorkInstance newWorkInstance(nextgen.model.workflow.Work work) {
		return newWorkInstance().setType(WorkType.WORK).setWork(work);
	}

	public WorkInstance newWorkInstance(nextgen.model.workflow.SequentialFlow work) {
		return newWorkInstance().setType(WorkType.SEQUENTIAL).setSequential(work);
	}

	public WorkInstance newWorkInstance(nextgen.model.workflow.ParallelFlow work) {
		return newWorkInstance().setType(WorkType.PARALLEL).setParallel(work);
	}

	public WorkInstance newWorkInstance(nextgen.model.workflow.ConditionalFlow work) {
		return newWorkInstance().setType(WorkType.CONDITIONAL).setConditional(work);
	}

	public WorkInstance newWorkInstance(nextgen.model.workflow.RepeatFlow work) {
		return newWorkInstance().setType(WorkType.REPEAT).setRepeat(work);
	}

	private org.jeasy.flows.work.Work[] toWork(Stream<WorkInstance> stream, ExecutorService executorService) {
		final List<WorkInstance> workTypes = stream.collect(Collectors.toList());
		final org.jeasy.flows.work.Work[] works = new org.jeasy.flows.work.Work[workTypes.size()];
		for (int i = 0; i < workTypes.size(); i++)
			works[i] = toWork(workTypes.get(i), executorService);
		return works;
	}

	private org.jeasy.flows.work.Work toWork(WorkInstance workInstance, ExecutorService executorService) {

		switch (workInstance.getType()) {
			case WORK:
				return newInstance(workInstance.getWork());
			case CONDITIONAL:
				return toFlow(workInstance.getConditional(), executorService);
			case SEQUENTIAL:
				return toFlow(workInstance.getSequential(), executorService);
			case PARALLEL:
				return toFlow(workInstance.getParallel(), executorService);
			case REPEAT:
				return toFlow(workInstance.getRepeat(), executorService);
		}

		throw new RuntimeException("unsupported type " + workInstance.getType());
	}

	private nextgen.templates.javaeasyflows.Work toCode(Work work) {
		final nextgen.templates.javaeasyflows.Work w = nextgen.templates.javaeasyflows.JavaEasyFlowsPatterns.newWork();
		w.setName(work.getName());
		w.setPackageName(work.getPackage());
		work.getInputs().forEach(workInput -> w.addInputs(workInput.getType(), workInput.getName()));
		work.getStatements().forEach(workStatement -> w.addStatements(workStatement.getStatement()));
		System.out.println(w.toString());
		return w;
	}

	private WorkReportPredicate toWorkReportPredicate(UntilPredicate until) {
		switch (until) {
			case ALWAYS_TRUE:
				return WorkReportPredicate.ALWAYS_TRUE;
			case ALWAYS_FALSE:
				return WorkReportPredicate.ALWAYS_FALSE;
			case COMPLETED:
				return WorkReportPredicate.COMPLETED;
			case FAILED:
				return WorkReportPredicate.FAILED;
		}
		throw new RuntimeException("unsupported untilPredicate " + until);
	}

	public org.jeasy.flows.work.WorkReport run(org.jeasy.flows.work.WorkContext workContext, nextgen.templates.javaeasyflows.Work w) {
      final org.jeasy.flows.workflow.WorkFlow workflow = org.jeasy.flows.workflow.SequentialFlow.Builder.aNewSequentialFlow()
            .execute(newInstance(w))
            .build();
      return org.jeasy.flows.engine.WorkFlowEngineBuilder.aNewWorkFlowEngine()
            .build()
            .run(workflow, workContext);
   }
}