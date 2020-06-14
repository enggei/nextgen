package nextgen.templates.neo4j;

public class Neo4JST {

	private static final String stg = "delimiters \"~\", \"~\"\n" +
	"eom() ::= \"}\"\n" +
	"gt() ::= \">\"\n" +
	NeoFactory.st + "\n" + 
	NeoFactoryAccessors.st + "\n" + 
	NeoFactoryPropertyAccessors.st + "\n" + 
	NodeWrapper.st + "\n" + 
	EnumAccessors.st + "\n" + 
	EnumListAccessors.st + "\n" + 
	ExternalAccessors.st + "\n" + 
	IncomingReferenceStream.st + "\n" + 
	ListPrimitiveAccessors.st + "\n" + 
	ListReferenceAccessors.st + "\n" + 
	PrimitiveAccessors.st + "\n" + 
	ReferenceAccessors.st + "\n" + 
	Direction.st + "\n" + 
	GraphDatabaseFactory.st + "\n" + 
	GraphDatabaseService.st + "\n" + 
	GraphDatabaseSettings.st + "\n" + 
	Label.st + "\n" + 
	Node.st + "\n" + 
	Relationship.st + "\n" + 
	RelationshipType.st + "\n" + 
	Transaction.st + "\n";

	public static org.stringtemplate.v4.STGroup decorate(final org.stringtemplate.v4.STGroup stGroup) {
		stGroup.registerRenderer(Object.class, new DefaultAttributeRenderer());
		stGroup.setListener(new org.stringtemplate.v4.STErrorListener() {
			@Override
			public void compileTimeError(org.stringtemplate.v4.misc.STMessage stMessage) {
				System.out.println("compileTimeError " + stMessage.toString());
			}

			@Override
			public void runTimeError(org.stringtemplate.v4.misc.STMessage stMessage) {
				final org.stringtemplate.v4.misc.STRuntimeMessage stRuntimeMessage = (org.stringtemplate.v4.misc.STRuntimeMessage) stMessage;
				System.out.println("runTimeError " + stMessage.self.getName() + " " + stRuntimeMessage.getSourceLocation());
			}

			@Override
			public void IOError(org.stringtemplate.v4.misc.STMessage stMessage) {
				System.out.println("IOError " + stMessage.toString());
			}

			@Override
			public void internalError(org.stringtemplate.v4.misc.STMessage stMessage) {
				System.out.println("internalError " + stMessage.toString());
			}
		});

		return stGroup;
	}

	private static org.stringtemplate.v4.STGroup stGroup = decorate(new org.stringtemplate.v4.STGroupString("Neo4JST", stg, '~', '~'));

	public static void setSTGroup(final String stgFile) {
		stGroup = decorate(new org.stringtemplate.v4.STGroupFile(stgFile, '~', '~'));
	}

	public static NeoFactory newNeoFactory() {
		return new NeoFactory(stGroup);
	}

	public static NeoFactoryAccessors newNeoFactoryAccessors() {
		return new NeoFactoryAccessors(stGroup);
	}

	public static NeoFactoryPropertyAccessors newNeoFactoryPropertyAccessors() {
		return new NeoFactoryPropertyAccessors(stGroup);
	}

	public static NodeWrapper newNodeWrapper() {
		return new NodeWrapper(stGroup);
	}

	public static EnumAccessors newEnumAccessors() {
		return new EnumAccessors(stGroup);
	}

	public static EnumListAccessors newEnumListAccessors() {
		return new EnumListAccessors(stGroup);
	}

	public static ExternalAccessors newExternalAccessors() {
		return new ExternalAccessors(stGroup);
	}

	public static IncomingReferenceStream newIncomingReferenceStream() {
		return new IncomingReferenceStream(stGroup);
	}

	public static ListPrimitiveAccessors newListPrimitiveAccessors() {
		return new ListPrimitiveAccessors(stGroup);
	}

	public static ListReferenceAccessors newListReferenceAccessors() {
		return new ListReferenceAccessors(stGroup);
	}

	public static PrimitiveAccessors newPrimitiveAccessors() {
		return new PrimitiveAccessors(stGroup);
	}

	public static ReferenceAccessors newReferenceAccessors() {
		return new ReferenceAccessors(stGroup);
	}

	public static Direction newDirection() {
		return new Direction(stGroup);
	}

	public static GraphDatabaseFactory newGraphDatabaseFactory() {
		return new GraphDatabaseFactory(stGroup);
	}

	public static GraphDatabaseService newGraphDatabaseService() {
		return new GraphDatabaseService(stGroup);
	}

	public static GraphDatabaseSettings newGraphDatabaseSettings() {
		return new GraphDatabaseSettings(stGroup);
	}

	public static Label newLabel() {
		return new Label(stGroup);
	}

	public static Node newNode() {
		return new Node(stGroup);
	}

	public static Relationship newRelationship() {
		return new Relationship(stGroup);
	}

	public static RelationshipType newRelationshipType() {
		return new RelationshipType(stGroup);
	}

	public static Transaction newTransaction() {
		return new Transaction(stGroup);
	}

	private static final class DefaultAttributeRenderer implements org.stringtemplate.v4.AttributeRenderer {

		@Override
		public String toString(Object o, String formatString, java.util.Locale locale) {

			final String text = o.toString();
			if (formatString == null) return text;

			final String s = text.length() > 1 ? text.substring(1) : "";

			switch (formatString) {
				case "capitalize":
					return Character.toUpperCase(text.charAt(0)) + s;
				case "toUpper":
					return text.toUpperCase();
				case "lowFirst":
					return Character.toLowerCase(text.charAt(0)) + s;
				case "toLower":
					return text.toLowerCase();
				case "dotToCap":
					final StringBuilder formatted = new StringBuilder();
					final char[] chars = o.toString().toCharArray();
					for (int i = 0; i < chars.length; i++)
            		if (chars[i] != '.')
							formatted.append(i == 0 || chars[i - 1] == '.' ? Character.toUpperCase(chars[i]) : chars[i]);
					return formatted.toString().trim();
				default:
					return o.toString();
			}
		}
	}
} 