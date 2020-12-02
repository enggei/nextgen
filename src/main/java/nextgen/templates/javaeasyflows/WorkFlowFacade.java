package nextgen.templates.javaeasyflows;

public class WorkFlowFacade {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private Object _name;

	WorkFlowFacade(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("WorkFlowFacade");
		st.add("packageName", _packageName);
		st.add("name", _name);
		return st.render().trim();
	}

	public WorkFlowFacade setPackageName(Object value) {
		this._packageName = value;
		return this;
	}

	public Object getPackageName() {
		return this._packageName;
	}

	public Object getPackageName(Object defaultValue) {
		return this._packageName == null ? defaultValue : this._packageName;
	}

	public boolean hasPackageName() {
		return this._packageName != null;
	}

	public WorkFlowFacade removePackageName() {
		this._packageName = null;
		return this;
	} 

	public WorkFlowFacade setName(Object value) {
		this._name = value;
		return this;
	}

	public Object getName() {
		return this._name;
	}

	public Object getName(Object defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public WorkFlowFacade removeName() {
		this._name = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		WorkFlowFacade that = (WorkFlowFacade) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "WorkFlowFacade(packageName,name) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import net.openhft.compiler.CompilerUtils;\n" + 
				"import org.jeasy.flows.work.WorkReportPredicate;\n" + 
				"\n" + 
				"import java.util.List;\n" + 
				"import java.util.concurrent.ExecutorService;\n" + 
				"import java.util.stream.Collectors;\n" + 
				"import java.util.stream.Stream;\n" + 
				"\n" + 
				"public class ~name~ extends WorkFlowNeoFactory {\n" + 
				"\n" + 
				"	public ~name~(String dir) {\n" + 
				"		super(dir);\n" + 
				"	}\n" + 
				"\n" + 
				"	public WorkFlowFacade(org.neo4j.graphdb.GraphDatabaseService db) {\n" + 
				"		super(db);\n" + 
				"	}\n" + 
				"	\n" + 
				"	public org.jeasy.flows.work.Work newInstance(Work work) {\n" + 
				"		return newInstance(toCode(work));\n" + 
				"	}\n" + 
				"\n" + 
				"	public org.jeasy.flows.work.Work newInstance(nextgen.templates.javaeasyflows.Work javaCode) {\n" + 
				"		final String className = javaCode.getPackageName() + \".\" + javaCode.getName().toString();\n" + 
				"		try {\n" + 
				"			final Class<?> workClass = CompilerUtils.CACHED_COMPILER.loadFromJava(className, javaCode.toString());\n" + 
				"			return (org.jeasy.flows.work.Work) workClass.getDeclaredConstructor().newInstance();\n" + 
				"		} catch (Throwable e) {\n" + 
				"			throw new RuntimeException(e);\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	public org.jeasy.flows.workflow.ConditionalFlow toFlow(ConditionalFlow flow, ExecutorService executorService) {\n" + 
				"\n" + 
				"		final org.jeasy.flows.workflow.ConditionalFlow.Builder f = org.jeasy.flows.workflow.ConditionalFlow.Builder.aNewConditionalFlow()\n" + 
				"				.named(flow.getName())\n" + 
				"				.execute(toWork(flow.getExecute(), executorService));\n" + 
				"\n" + 
				"		final WorkInstance then = flow.getThen();\n" + 
				"		if (then != null) f.then(toWork(then, executorService));\n" + 
				"\n" + 
				"		final WorkInstance otherwise = flow.getOtherwise();\n" + 
				"		if (otherwise != null) f.otherwise(toWork(otherwise, executorService));\n" + 
				"\n" + 
				"		return f.build();\n" + 
				"	}\n" + 
				"\n" + 
				"	public org.jeasy.flows.workflow.SequentialFlow toFlow(SequentialFlow flow, ExecutorService executorService) {\n" + 
				"\n" + 
				"		final org.jeasy.flows.workflow.SequentialFlow.Builder f = org.jeasy.flows.workflow.SequentialFlow.Builder.aNewSequentialFlow()\n" + 
				"				.named(flow.getName())\n" + 
				"				.execute(toWork(flow.getExecute(), executorService));\n" + 
				"\n" + 
				"		flow.getThen().forEach(workType -> f.then(toWork(workType, executorService)));\n" + 
				"\n" + 
				"		return f.build();\n" + 
				"	}\n" + 
				"\n" + 
				"	public org.jeasy.flows.workflow.ParallelFlow toFlow(ParallelFlow flow, ExecutorService executorService) {\n" + 
				"\n" + 
				"		final org.jeasy.flows.workflow.ParallelFlow.Builder f = org.jeasy.flows.workflow.ParallelFlow.Builder.aNewParallelFlow(executorService)\n" + 
				"				.named(flow.getName())\n" + 
				"				.execute(toWork(flow.getExecute(), executorService));\n" + 
				"\n" + 
				"		return f.build();\n" + 
				"	}\n" + 
				"\n" + 
				"	public org.jeasy.flows.workflow.RepeatFlow toFlow(RepeatFlow flow, ExecutorService executorService) {\n" + 
				"\n" + 
				"		final org.jeasy.flows.workflow.RepeatFlow.Builder f = org.jeasy.flows.workflow.RepeatFlow.Builder.aNewRepeatFlow()\n" + 
				"				.named(flow.getName())\n" + 
				"				.repeat(toWork(flow.getRepeat(), executorService));\n" + 
				"\n" + 
				"		if (flow.getTimes() != null)\n" + 
				"			f.times(flow.getTimes());\n" + 
				"		else if (flow.getUntil() != null)\n" + 
				"			f.until(toWorkReportPredicate(flow.getUntil()));\n" + 
				"\n" + 
				"		return f.build();\n" + 
				"	}\n" + 
				"\n" + 
				"	public WorkInstance newWorkInstance(nextgen.model.workflow.Work work) {\n" + 
				"		return newWorkInstance().setType(WorkType.WORK).setWork(work);\n" + 
				"	}\n" + 
				"\n" + 
				"	public WorkInstance newWorkInstance(nextgen.model.workflow.SequentialFlow work) {\n" + 
				"		return newWorkInstance().setType(WorkType.SEQUENTIAL).setSequential(work);\n" + 
				"	}\n" + 
				"\n" + 
				"	public WorkInstance newWorkInstance(nextgen.model.workflow.ParallelFlow work) {\n" + 
				"		return newWorkInstance().setType(WorkType.PARALLEL).setParallel(work);\n" + 
				"	}\n" + 
				"\n" + 
				"	public WorkInstance newWorkInstance(nextgen.model.workflow.ConditionalFlow work) {\n" + 
				"		return newWorkInstance().setType(WorkType.CONDITIONAL).setConditional(work);\n" + 
				"	}\n" + 
				"\n" + 
				"	public WorkInstance newWorkInstance(nextgen.model.workflow.RepeatFlow work) {\n" + 
				"		return newWorkInstance().setType(WorkType.REPEAT).setRepeat(work);\n" + 
				"	}\n" + 
				"\n" + 
				"	private org.jeasy.flows.work.Work[] toWork(Stream<WorkInstance> stream, ExecutorService executorService) {\n" + 
				"		final List<WorkInstance> workTypes = stream.collect(Collectors.toList());\n" + 
				"		final org.jeasy.flows.work.Work[] works = new org.jeasy.flows.work.Work[workTypes.size()];\n" + 
				"		for (int i = 0; i < workTypes.size(); i++)\n" + 
				"			works[i] = toWork(workTypes.get(i), executorService);\n" + 
				"		return works;\n" + 
				"	}\n" + 
				"\n" + 
				"	private org.jeasy.flows.work.Work toWork(WorkInstance workInstance, ExecutorService executorService) {\n" + 
				"\n" + 
				"		switch (workInstance.getType()) {\n" + 
				"			case WORK:\n" + 
				"				return newInstance(workInstance.getWork());\n" + 
				"			case CONDITIONAL:\n" + 
				"				return toFlow(workInstance.getConditional(), executorService);\n" + 
				"			case SEQUENTIAL:\n" + 
				"				return toFlow(workInstance.getSequential(), executorService);\n" + 
				"			case PARALLEL:\n" + 
				"				return toFlow(workInstance.getParallel(), executorService);\n" + 
				"			case REPEAT:\n" + 
				"				return toFlow(workInstance.getRepeat(), executorService);\n" + 
				"		}\n" + 
				"\n" + 
				"		throw new RuntimeException(\"unsupported type \" + workInstance.getType());\n" + 
				"	}\n" + 
				"\n" + 
				"	private nextgen.templates.javaeasyflows.Work toCode(Work work) {\n" + 
				"		final nextgen.templates.javaeasyflows.Work w = nextgen.templates.javaeasyflows.JavaEasyFlowsPatterns.newWork();\n" + 
				"		w.setName(work.getName());\n" + 
				"		w.setPackageName(work.getPackage());\n" + 
				"		work.getInputs().forEach(workInput -> w.addInputs(workInput.getType(), workInput.getName()));\n" + 
				"		work.getStatements().forEach(workStatement -> w.addStatements(workStatement.getStatement()));\n" + 
				"		System.out.println(w.toString());\n" + 
				"		return w;\n" + 
				"	}\n" + 
				"\n" + 
				"	private WorkReportPredicate toWorkReportPredicate(UntilPredicate until) {\n" + 
				"		switch (until) {\n" + 
				"			case ALWAYS_TRUE:\n" + 
				"				return WorkReportPredicate.ALWAYS_TRUE;\n" + 
				"			case ALWAYS_FALSE:\n" + 
				"				return WorkReportPredicate.ALWAYS_FALSE;\n" + 
				"			case COMPLETED:\n" + 
				"				return WorkReportPredicate.COMPLETED;\n" + 
				"			case FAILED:\n" + 
				"				return WorkReportPredicate.FAILED;\n" + 
				"		}\n" + 
				"		throw new RuntimeException(\"unsupported untilPredicate \" + until);\n" + 
				"	}\n" + 
				"\n" + 
				"	public org.jeasy.flows.work.WorkReport run(org.jeasy.flows.work.WorkContext workContext, nextgen.templates.javaeasyflows.Work w) {\n" + 
				"      final org.jeasy.flows.workflow.WorkFlow workflow = org.jeasy.flows.workflow.SequentialFlow.Builder.aNewSequentialFlow()\n" + 
				"            .execute(newInstance(w))\n" + 
				"            .build();\n" + 
				"      return org.jeasy.flows.engine.WorkFlowEngineBuilder.aNewWorkFlowEngine()\n" + 
				"            .build()\n" + 
				"            .run(workflow, workContext);\n" + 
				"   }\n" + 
				"} >>";
}  