package nextgen.templates.nextgen;

public class DomainFacade {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private Object _name;
	private Object _factory;
	private java.util.List<Object> _imports = new java.util.ArrayList<>();
	private java.util.List<Object> _methods = new java.util.ArrayList<>();

	DomainFacade(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("DomainFacade");
		st.add("packageName", _packageName);
		st.add("name", _name);
		st.add("factory", _factory);
		for (Object o : _imports) st.add("imports", o);
		for (Object o : _methods) st.add("methods", o);
		return st.render().trim();
	}

	public DomainFacade setPackageName(Object value) {
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

	public DomainFacade removePackageName() {
		this._packageName = null;
		return this;
	} 

	public DomainFacade setName(Object value) {
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

	public DomainFacade removeName() {
		this._name = null;
		return this;
	} 

	public DomainFacade setFactory(Object value) {
		this._factory = value;
		return this;
	}

	public Object getFactory() {
		return this._factory;
	}

	public Object getFactory(Object defaultValue) {
		return this._factory == null ? defaultValue : this._factory;
	}

	public boolean hasFactory() {
		return this._factory != null;
	}

	public DomainFacade removeFactory() {
		this._factory = null;
		return this;
	} 

	public DomainFacade addImports(Object value) {
		this._imports.add(value);
		return this;
	}

	public DomainFacade setImports(Object[] value) {
		this._imports.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public DomainFacade setImports(java.util.Collection<Object> values) {
		this._imports.addAll(values);
		return this;
	}

	public DomainFacade removeImports(Object value) {
		this._imports.remove(value);
		return this;
	}

	public DomainFacade removeImports(int index) {
		this._imports.remove(index);
		return this;
	}

	public java.util.List<Object> getImports() {
		return this._imports;
	} 

	public DomainFacade addMethods(Object value) {
		this._methods.add(value);
		return this;
	}

	public DomainFacade setMethods(Object[] value) {
		this._methods.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public DomainFacade setMethods(java.util.Collection<Object> values) {
		this._methods.addAll(values);
		return this;
	}

	public DomainFacade removeMethods(Object value) {
		this._methods.remove(value);
		return this;
	}

	public DomainFacade removeMethods(int index) {
		this._methods.remove(index);
		return this;
	}

	public java.util.List<Object> getMethods() {
		return this._methods;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DomainFacade that = (DomainFacade) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "DomainFacade(packageName,imports,name,factory,methods) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import net.openhft.compiler.CompilerUtils;\n" + 
				"import org.jeasy.flows.work.WorkReportPredicate;\n" + 
				"import org.neo4j.graphdb.GraphDatabaseService;\n" + 
				"\n" + 
				"import java.util.List;\n" + 
				"import java.util.ArrayList;\n" + 
				"import java.util.Optional;\n" + 
				"import java.util.stream.Collectors;\n" + 
				"import java.util.stream.Stream;\n" + 
				"import java.util.concurrent.ExecutorService;\n" + 
				"\n" + 
				"~imports:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"public class ~name~ extends ~factory~ {\n" + 
				"\n" + 
				"	public ~name~(String dir) {\n" + 
				"		super(dir);\n" + 
				"	}\n" + 
				"\n" + 
				"	public ~name~(GraphDatabaseService db) {\n" + 
				"		super(db);\n" + 
				"	}\n" + 
				"\n" + 
				"	~methods:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"	public static List<STTemplate> aggregateTemplates(STGroupModel stGroup) {\n" + 
				"		final List<STTemplate> stTemplates = new ArrayList<>();\n" + 
				"		stGroup.getTemplates().forEach(stTemplate -> {\n" + 
				"			stTemplates.add(stTemplate);\n" + 
				"			addChildren(stTemplate.getChildren().collect(Collectors.toList()), stTemplates);\n" + 
				"		});\n" + 
				"		return stTemplates;\n" + 
				"	}\n" + 
				"\n" + 
				"	public static List<STTemplate> aggregateTemplates(Stream<STGroupModel> stream) {\n" + 
				"		final List<STTemplate> stTemplates = new ArrayList<>();\n" + 
				"		stream.forEach(stGroupModel -> stTemplates.addAll(aggregateTemplates(stGroupModel)));\n" + 
				"		return stTemplates;\n" + 
				"	}\n" + 
				"\n" + 
				"	private static void addChildren(List<STTemplate> collect, List<STTemplate> stTemplates) {\n" + 
				"		stTemplates.addAll(collect);\n" + 
				"		for (STTemplate stTemplate : collect)\n" + 
				"			addChildren(stTemplate.getChildren().collect(Collectors.toList()), stTemplates);\n" + 
				"	}\n" + 
				"\n" + 
				"	public Stream<STGroupModel> getAllSTGroups() {\n" + 
				"		return findAllSTGroupModel()\n" + 
				"				.sorted((g1, g2) -> g1.getName().compareToIgnoreCase(g2.getName()));\n" + 
				"	}\n" + 
				"\n" + 
				"	public static Stream<STTemplate> getTemplates(STGroupModel stGroupModel) {\n" + 
				"		return stGroupModel.getTemplates()\n" + 
				"				.sorted((t1, t2) -> t1.getName().compareToIgnoreCase(t2.getName()));\n" + 
				"	}\n" + 
				"\n" + 
				"	public static Stream<STTemplate> getTemplates(STTemplate stTemplate) {\n" + 
				"		return stTemplate.getChildren()\n" + 
				"				.sorted((t1, t2) -> t1.getName().compareToIgnoreCase(t2.getName()));\n" + 
				"	}\n" + 
				"\n" + 
				"	public static Stream<STTemplate> getTemplates(Stream<STGroupModel> stGroupModel) {\n" + 
				"		final Optional<STGroupModel> first = stGroupModel.findFirst();\n" + 
				"		if (!first.isPresent()) return Stream.empty();\n" + 
				"		return getTemplates(first.get());\n" + 
				"	}\n" + 
				"\n" + 
				"	public static STGroupModel getSTGroup(STTemplate stTemplate) {\n" + 
				"\n" + 
				"		final Optional<STGroupModel> stGroupModel = stTemplate.getIncomingTemplatesSTGroupModel().findAny();\n" + 
				"		if (stGroupModel.isPresent()) return stGroupModel.get();\n" + 
				"\n" + 
				"		final Optional<STTemplate> parent = stTemplate.getIncomingChildrenSTTemplate().findAny();\n" + 
				"		if (parent.isPresent()) return getSTGroup(parent.get());\n" + 
				"\n" + 
				"		throw new RuntimeException(stTemplate.getName() + \" has no STGroup. This is an error.\");\n" + 
				"	}\n" + 
				"\n" + 
				"	public Stream<Project> getAllProjects() {\n" + 
				"		return findAllProject()\n" + 
				"				.sorted((p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()));\n" + 
				"	}\n" + 
				"\n" + 
				"	public STGroupModel newSTGroupModel(String name, String delimiter) {\n" + 
				"		return newSTGroupModel()\n" + 
				"				.setName(name)\n" + 
				"				.setDelimiter(delimiter);\n" + 
				"	}\n" + 
				"\n" + 
				"	public STTemplate newSTTemplate(String name, STGroupModel stGroup) {\n" + 
				"		final STTemplate stTemplate = newSTTemplate()\n" + 
				"				.setName(name)\n" + 
				"				.setText(\"\");\n" + 
				"		stGroup.addTemplates(stTemplate);\n" + 
				"		return stTemplate;\n" + 
				"	}\n" + 
				"\n" + 
				"	public STTemplate newSTTemplate(String name, STTemplate parent) {\n" + 
				"		final STTemplate stTemplate = newSTTemplate()\n" + 
				"				.setName(name)\n" + 
				"				.setText(\"\");\n" + 
				"		parent.addChildren(stTemplate);\n" + 
				"		return stTemplate;\n" + 
				"	}\n" + 
				"\n" + 
				"	public org.jeasy.flows.work.Work newInstance(Work work) {\n" + 
				"		final templates.javaeasyflows.Work javaCode = toCode(work);\n" + 
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
				"	public WorkInstance newWorkInstance(nextgen.domain.Work work) {\n" + 
				"		return newWorkInstance().setType(WorkType.WORK).setWork(work);\n" + 
				"	}\n" + 
				"\n" + 
				"	public WorkInstance newWorkInstance(nextgen.domain.SequentialFlow work) {\n" + 
				"		return newWorkInstance().setType(WorkType.SEQUENTIAL).setSequential(work);\n" + 
				"	}\n" + 
				"\n" + 
				"	public WorkInstance newWorkInstance(nextgen.domain.ParallelFlow work) {\n" + 
				"		return newWorkInstance().setType(WorkType.PARALLEL).setParallel(work);\n" + 
				"	}\n" + 
				"\n" + 
				"	public WorkInstance newWorkInstance(nextgen.domain.ConditionalFlow work) {\n" + 
				"		return newWorkInstance().setType(WorkType.CONDITIONAL).setConditional(work);\n" + 
				"	}\n" + 
				"\n" + 
				"	public WorkInstance newWorkInstance(nextgen.domain.RepeatFlow work) {\n" + 
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
				"	private templates.javaeasyflows.Work toCode(Work work) {\n" + 
				"		final templates.javaeasyflows.Work w = templates.JavaEasyFlowsPatterns.newWork();\n" + 
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
				"	public Work newWork(String name, Project project) {\n" + 
				"		final Work work = newWork()\n" + 
				"				.setName(name)\n" + 
				"				.setPackage(\"projects.\" + project.getName().toLowerCase());\n" + 
				"		project.addWork(work);\n" + 
				"		return work;\n" + 
				"	}\n" + 
				"\n" + 
				"	public SequentialFlow newSequentialFlow(String name, Project project) {\n" + 
				"		final SequentialFlow flow = newSequentialFlow()\n" + 
				"				.setName(name);\n" + 
				"		project.addFlows(newWorkInstance(flow));\n" + 
				"		return flow;\n" + 
				"	}\n" + 
				"\n" + 
				"	public ConditionalFlow newConditionalFlow(String name, Project project) {\n" + 
				"		final ConditionalFlow flow = newConditionalFlow()\n" + 
				"				.setName(name);\n" + 
				"		project.addFlows(newWorkInstance(flow));\n" + 
				"		return flow;\n" + 
				"	}\n" + 
				"\n" + 
				"	public ParallelFlow newParallelFlow(String name, Project project) {\n" + 
				"		final ParallelFlow flow = newParallelFlow()\n" + 
				"				.setName(name);\n" + 
				"		project.addFlows(newWorkInstance(flow));\n" + 
				"		return flow;\n" + 
				"	}\n" + 
				"\n" + 
				"	public RepeatFlow newRepeatFlow(String name, Project project) {\n" + 
				"		final RepeatFlow flow = newRepeatFlow()\n" + 
				"				.setName(name);\n" + 
				"		project.addFlows(newWorkInstance(flow));\n" + 
				"		return flow;\n" + 
				"	}\n" + 
				"\n" + 
				"	public void mergeTemplate(STGParseResult parseResult, STTemplate model) {\n" + 
				"\n" + 
				"	}\n" + 
				"\n" + 
				"	public void generateSTGroup(STGroupModel stGroup) {\n" + 
				"\n" + 
				"	}\n" + 
				"} >>";
}  