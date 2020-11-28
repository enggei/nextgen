package nextgen.templates.stringtemplate;

public class DomainVisitorRunner {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private Object _name;
	private Object _rootNode;
	private Object _initStatements;
	private Object _endStatements;
	private Object _dbDir;
	private Object _templatesDir;
	private Object _entityUuid;
	private java.util.List<Object> _imports = new java.util.ArrayList<>();
	private java.util.List<Object> _entityVisitors = new java.util.ArrayList<>();
	private java.util.List<Object> _relationVisitors = new java.util.ArrayList<>();

	DomainVisitorRunner(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("DomainVisitorRunner");
		st.add("packageName", _packageName);
		st.add("name", _name);
		st.add("rootNode", _rootNode);
		st.add("initStatements", _initStatements);
		st.add("endStatements", _endStatements);
		st.add("dbDir", _dbDir);
		st.add("templatesDir", _templatesDir);
		st.add("entityUuid", _entityUuid);
		for (Object o : _imports) st.add("imports", o);
		for (Object o : _entityVisitors) st.add("entityVisitors", o);
		for (Object o : _relationVisitors) st.add("relationVisitors", o);
		return st.render().trim();
	}

	public DomainVisitorRunner setPackageName(Object value) {
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

	public DomainVisitorRunner removePackageName() {
		this._packageName = null;
		return this;
	} 

	public DomainVisitorRunner setName(Object value) {
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

	public DomainVisitorRunner removeName() {
		this._name = null;
		return this;
	} 

	public DomainVisitorRunner setRootNode(Object value) {
		this._rootNode = value;
		return this;
	}

	public Object getRootNode() {
		return this._rootNode;
	}

	public Object getRootNode(Object defaultValue) {
		return this._rootNode == null ? defaultValue : this._rootNode;
	}

	public boolean hasRootNode() {
		return this._rootNode != null;
	}

	public DomainVisitorRunner removeRootNode() {
		this._rootNode = null;
		return this;
	} 

	public DomainVisitorRunner setInitStatements(Object value) {
		this._initStatements = value;
		return this;
	}

	public Object getInitStatements() {
		return this._initStatements;
	}

	public Object getInitStatements(Object defaultValue) {
		return this._initStatements == null ? defaultValue : this._initStatements;
	}

	public boolean hasInitStatements() {
		return this._initStatements != null;
	}

	public DomainVisitorRunner removeInitStatements() {
		this._initStatements = null;
		return this;
	} 

	public DomainVisitorRunner setEndStatements(Object value) {
		this._endStatements = value;
		return this;
	}

	public Object getEndStatements() {
		return this._endStatements;
	}

	public Object getEndStatements(Object defaultValue) {
		return this._endStatements == null ? defaultValue : this._endStatements;
	}

	public boolean hasEndStatements() {
		return this._endStatements != null;
	}

	public DomainVisitorRunner removeEndStatements() {
		this._endStatements = null;
		return this;
	} 

	public DomainVisitorRunner setDbDir(Object value) {
		this._dbDir = value;
		return this;
	}

	public Object getDbDir() {
		return this._dbDir;
	}

	public Object getDbDir(Object defaultValue) {
		return this._dbDir == null ? defaultValue : this._dbDir;
	}

	public boolean hasDbDir() {
		return this._dbDir != null;
	}

	public DomainVisitorRunner removeDbDir() {
		this._dbDir = null;
		return this;
	} 

	public DomainVisitorRunner setTemplatesDir(Object value) {
		this._templatesDir = value;
		return this;
	}

	public Object getTemplatesDir() {
		return this._templatesDir;
	}

	public Object getTemplatesDir(Object defaultValue) {
		return this._templatesDir == null ? defaultValue : this._templatesDir;
	}

	public boolean hasTemplatesDir() {
		return this._templatesDir != null;
	}

	public DomainVisitorRunner removeTemplatesDir() {
		this._templatesDir = null;
		return this;
	} 

	public DomainVisitorRunner setEntityUuid(Object value) {
		this._entityUuid = value;
		return this;
	}

	public Object getEntityUuid() {
		return this._entityUuid;
	}

	public Object getEntityUuid(Object defaultValue) {
		return this._entityUuid == null ? defaultValue : this._entityUuid;
	}

	public boolean hasEntityUuid() {
		return this._entityUuid != null;
	}

	public DomainVisitorRunner removeEntityUuid() {
		this._entityUuid = null;
		return this;
	} 

	public DomainVisitorRunner addImports(Object value) {
		this._imports.add(value);
		return this;
	}

	public DomainVisitorRunner setImports(Object[] value) {
		this._imports.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public DomainVisitorRunner setImports(java.util.Collection<Object> values) {
		this._imports.addAll(values);
		return this;
	}

	public DomainVisitorRunner removeImports(Object value) {
		this._imports.remove(value);
		return this;
	}

	public DomainVisitorRunner removeImports(int index) {
		this._imports.remove(index);
		return this;
	}

	public java.util.List<Object> getImports() {
		return this._imports;
	} 

	public DomainVisitorRunner addEntityVisitors(Object value) {
		this._entityVisitors.add(value);
		return this;
	}

	public DomainVisitorRunner setEntityVisitors(Object[] value) {
		this._entityVisitors.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public DomainVisitorRunner setEntityVisitors(java.util.Collection<Object> values) {
		this._entityVisitors.addAll(values);
		return this;
	}

	public DomainVisitorRunner removeEntityVisitors(Object value) {
		this._entityVisitors.remove(value);
		return this;
	}

	public DomainVisitorRunner removeEntityVisitors(int index) {
		this._entityVisitors.remove(index);
		return this;
	}

	public java.util.List<Object> getEntityVisitors() {
		return this._entityVisitors;
	} 

	public DomainVisitorRunner addRelationVisitors(Object value) {
		this._relationVisitors.add(value);
		return this;
	}

	public DomainVisitorRunner setRelationVisitors(Object[] value) {
		this._relationVisitors.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public DomainVisitorRunner setRelationVisitors(java.util.Collection<Object> values) {
		this._relationVisitors.addAll(values);
		return this;
	}

	public DomainVisitorRunner removeRelationVisitors(Object value) {
		this._relationVisitors.remove(value);
		return this;
	}

	public DomainVisitorRunner removeRelationVisitors(int index) {
		this._relationVisitors.remove(index);
		return this;
	}

	public java.util.List<Object> getRelationVisitors() {
		return this._relationVisitors;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DomainVisitorRunner that = (DomainVisitorRunner) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "DomainVisitorRunner(packageName,imports,name,rootNode,initStatements,entityVisitors,relationVisitors,endStatements,dbDir,templatesDir,entityUuid) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import nextgen.domains.meta.DomainEntity;\n" + 
				"import nextgen.st.STRenderer;\n" + 
				"import nextgen.model.STGroupModel;\n" +
				"import nextgen.model.STModelDB;\n" +
				"import org.neo4j.graphdb.*;\n" + 
				"\n" + 
				"import java.util.*;\n" + 
				"import java.io.File;\n" + 
				"\n" + 
				"~imports:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"public class ~name~ implements Runnable {\n" + 
				"\n" + 
				"	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(~name~.class);\n" + 
				"	private final STModelDB db;\n" + 
				"	private final STRenderer renderer;\n" + 
				"	private final DomainEntity domainEntity;\n" + 
				"\n" + 
				"	public ~name~(STModelDB db, STRenderer renderer, DomainEntity domainEntity) {\n" + 
				"		this.db = db;\n" + 
				"		this.renderer = renderer;\n" + 
				"		this.domainEntity = domainEntity;\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void run() {\n" + 
				"		db.doInTransaction(transaction -> {\n" + 
				"			final Visitor visitor = new Visitor();\n" + 
				"			visitor.visit~rootNode;format=\"capitalize\"~(domainEntity.getNode());\n" + 
				"			visitor.end();\n" + 
				"		});\n" + 
				"	}\n" + 
				"\n" + 
				"	private static final class Visitor {\n" + 
				"		\n" + 
				"		private final Set<Node> visitedNodes = new LinkedHashSet<>();\n" + 
				"\n" + 
				"		Visitor() {\n" + 
				"			~initStatements~\n" + 
				"		}\n" + 
				"		\n" + 
				"		~entityVisitors:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"		~relationVisitors:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"		void end() {\n" + 
				"			~endStatements~\n" + 
				"		}\n" + 
				"\n" + 
				"		private Iterable<Relationship> get(Node node, String components) {\n" + 
				"			return node.getRelationships(Direction.OUTGOING, RelationshipType.withName(components));\n" + 
				"		}\n" + 
				"\n" + 
				"		private String getProperty(PropertyContainer propertyContainer, String name, String defaultValue) {\n" + 
				"			return propertyContainer.hasProperty(name) ? (String) propertyContainer.getProperty(name) : defaultValue;\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	public static void main(String[] args) {\n" + 
				"		final nextgen.model.STModelDB db = new nextgen.model.STModelDB(\"~dbDir~\", \"~templatesDir~\");\n" +
				"		final new nextgen.st.STRenderer renderer = new nextgen.st.STRenderer(db.getGroupModels());\n" + 
				"		final DomainEntity domainEntity = db.getInTransaction(transaction -> new DomainEntity(db.getDatabaseService().findNode(org.neo4j.graphdb.Label.label(\"DomainEntity\"), \"uuid\", \"~entityUuid~\")));\n" + 
				"		new Thread(new ~name~(db, renderer, domainEntity)).start();\n" + 
				"	}\n" + 
				"} >>";
}  