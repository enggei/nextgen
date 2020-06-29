package nextgen.templates.kotlin;

public class KotlinST {

	private static final String stg = "delimiters \"~\", \"~\"\n" +
	"eom() ::= \"}\"\n" +
	"gt() ::= \">\"\n" +
	ArrayEqualsExpression.st + "\n" + 
	AssignExpression.st + "\n" + 
	CastExpression.st + "\n" + 
	ComplexStringExpression.st + "\n" + 
	ConstructorCallExpression.st + "\n" + 
	EqualsExpression.st + "\n" + 
	FunctionCallExpression.st + "\n" + 
	LiteralExpression.st + "\n" + 
	NullExpression.st + "\n" + 
	PairExpression.st + "\n" + 
	ScopeExpression.st + "\n" + 
	SimpleStringExpression.st + "\n" + 
	StringLiteralExpression.st + "\n" + 
	ThisExpression.st + "\n" + 
	ToStringExpression.st + "\n" + 
	AnnotationDeclaration.st + "\n" + 
	AnnotationParam.st + "\n" + 
	ClassDeclaration.st + "\n" + 
	OverrideEquals.st + "\n" + 
	OverrideHashCode.st + "\n" + 
	OverrideToString.st + "\n" + 
	DataClassDeclaration.st + "\n" + 
	Extending.st + "\n" + 
	FieldDeclaration.st + "\n" + 
	FunctionDeclaration.st + "\n" + 
	FunctionParam.st + "\n" + 
	PackageDeclaration.st + "\n" + 
	ImportStatement.st + "\n" + 
	ReturnStatement.st + "\n" + 
	TodoStatement.st + "\n" + 
	VarDeclarationStatement.st + "\n" + 
	ArrayInitializer.st + "\n" + 
	EmptyArrayInitializer.st + "\n" + 
	EmptyMapInitializer.st + "\n" + 
	ExpressionInitializer.st + "\n" + 
	ListInitializer.st + "\n" + 
	MapInitializer.st + "\n" + 
	MutableMapInitializer.st + "\n" + 
	MutableSetInitializer.st + "\n" + 
	NullInitializer.st + "\n" + 
	SetInitializer.st + "\n" + 
	KotlinFile.st + "\n" + 
	AnyType.st + "\n" + 
	ArrayType.st + "\n" + 
	BooleanType.st + "\n" + 
	DoubleType.st + "\n" + 
	FloatType.st + "\n" + 
	IntType.st + "\n" + 
	ListType.st + "\n" + 
	LongType.st + "\n" + 
	MapType.st + "\n" + 
	MutableListType.st + "\n" + 
	MutableMapType.st + "\n" + 
	MutableSetType.st + "\n" + 
	NamedType.st + "\n" + 
	NullableType.st + "\n" + 
	PairType.st + "\n" + 
	SetType.st + "\n" + 
	StringType.st + "\n" + 
	UnitType.st + "\n" ;

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

	private static org.stringtemplate.v4.STGroup stGroup = decorate(new org.stringtemplate.v4.STGroupString("KotlinST", stg, '~', '~'));

	public static void setSTGroup(final String stgFile) {
		stGroup = decorate(new org.stringtemplate.v4.STGroupFile(stgFile, '~', '~'));
	}

	public static ArrayEqualsExpression newArrayEqualsExpression() {
		return new ArrayEqualsExpression(stGroup);
	} 

	public static AssignExpression newAssignExpression() {
		return new AssignExpression(stGroup);
	} 

	public static CastExpression newCastExpression() {
		return new CastExpression(stGroup);
	} 

	public static ComplexStringExpression newComplexStringExpression() {
		return new ComplexStringExpression(stGroup);
	} 

	public static ConstructorCallExpression newConstructorCallExpression() {
		return new ConstructorCallExpression(stGroup);
	} 

	public static EqualsExpression newEqualsExpression() {
		return new EqualsExpression(stGroup);
	} 

	public static FunctionCallExpression newFunctionCallExpression() {
		return new FunctionCallExpression(stGroup);
	} 

	public static LiteralExpression newLiteralExpression() {
		return new LiteralExpression(stGroup);
	} 

	public static NullExpression newNullExpression() {
		return new NullExpression(stGroup);
	} 

	public static PairExpression newPairExpression() {
		return new PairExpression(stGroup);
	} 

	public static ScopeExpression newScopeExpression() {
		return new ScopeExpression(stGroup);
	} 

	public static SimpleStringExpression newSimpleStringExpression() {
		return new SimpleStringExpression(stGroup);
	} 

	public static StringLiteralExpression newStringLiteralExpression() {
		return new StringLiteralExpression(stGroup);
	} 

	public static ThisExpression newThisExpression() {
		return new ThisExpression(stGroup);
	} 

	public static ToStringExpression newToStringExpression() {
		return new ToStringExpression(stGroup);
	} 

	public static AnnotationDeclaration newAnnotationDeclaration() {
		return new AnnotationDeclaration(stGroup);
	} 

	public static AnnotationParam newAnnotationParam() {
		return new AnnotationParam(stGroup);
	} 

	public static ClassDeclaration newClassDeclaration() {
		return new ClassDeclaration(stGroup);
	} 

	public static OverrideEquals newOverrideEquals() {
		return new OverrideEquals(stGroup);
	} 

	public static OverrideHashCode newOverrideHashCode() {
		return new OverrideHashCode(stGroup);
	} 

	public static OverrideToString newOverrideToString() {
		return new OverrideToString(stGroup);
	} 

	public static DataClassDeclaration newDataClassDeclaration() {
		return new DataClassDeclaration(stGroup);
	} 

	public static Extending newExtending() {
		return new Extending(stGroup);
	} 

	public static FieldDeclaration newFieldDeclaration() {
		return new FieldDeclaration(stGroup);
	} 

	public static FunctionDeclaration newFunctionDeclaration() {
		return new FunctionDeclaration(stGroup);
	} 

	public static FunctionParam newFunctionParam() {
		return new FunctionParam(stGroup);
	} 

	public static PackageDeclaration newPackageDeclaration() {
		return new PackageDeclaration(stGroup);
	} 

	public static ImportStatement newImportStatement() {
		return new ImportStatement(stGroup);
	} 

	public static ReturnStatement newReturnStatement() {
		return new ReturnStatement(stGroup);
	} 

	public static TodoStatement newTodoStatement() {
		return new TodoStatement(stGroup);
	} 

	public static VarDeclarationStatement newVarDeclarationStatement() {
		return new VarDeclarationStatement(stGroup);
	} 

	public static ArrayInitializer newArrayInitializer() {
		return new ArrayInitializer(stGroup);
	} 

	public static EmptyArrayInitializer newEmptyArrayInitializer() {
		return new EmptyArrayInitializer(stGroup);
	} 

	public static EmptyMapInitializer newEmptyMapInitializer() {
		return new EmptyMapInitializer(stGroup);
	} 

	public static ExpressionInitializer newExpressionInitializer() {
		return new ExpressionInitializer(stGroup);
	} 

	public static ListInitializer newListInitializer() {
		return new ListInitializer(stGroup);
	} 

	public static MapInitializer newMapInitializer() {
		return new MapInitializer(stGroup);
	} 

	public static MutableMapInitializer newMutableMapInitializer() {
		return new MutableMapInitializer(stGroup);
	} 

	public static MutableSetInitializer newMutableSetInitializer() {
		return new MutableSetInitializer(stGroup);
	} 

	public static NullInitializer newNullInitializer() {
		return new NullInitializer(stGroup);
	} 

	public static SetInitializer newSetInitializer() {
		return new SetInitializer(stGroup);
	} 

	public static KotlinFile newKotlinFile() {
		return new KotlinFile(stGroup);
	} 

	public static AnyType newAnyType() {
		return new AnyType(stGroup);
	} 

	public static ArrayType newArrayType() {
		return new ArrayType(stGroup);
	} 

	public static BooleanType newBooleanType() {
		return new BooleanType(stGroup);
	} 

	public static DoubleType newDoubleType() {
		return new DoubleType(stGroup);
	} 

	public static FloatType newFloatType() {
		return new FloatType(stGroup);
	} 

	public static IntType newIntType() {
		return new IntType(stGroup);
	} 

	public static ListType newListType() {
		return new ListType(stGroup);
	} 

	public static LongType newLongType() {
		return new LongType(stGroup);
	} 

	public static MapType newMapType() {
		return new MapType(stGroup);
	} 

	public static MutableListType newMutableListType() {
		return new MutableListType(stGroup);
	} 

	public static MutableMapType newMutableMapType() {
		return new MutableMapType(stGroup);
	} 

	public static MutableSetType newMutableSetType() {
		return new MutableSetType(stGroup);
	} 

	public static NamedType newNamedType() {
		return new NamedType(stGroup);
	} 

	public static NullableType newNullableType() {
		return new NullableType(stGroup);
	} 

	public static PairType newPairType() {
		return new PairType(stGroup);
	} 

	public static SetType newSetType() {
		return new SetType(stGroup);
	} 

	public static StringType newStringType() {
		return new StringType(stGroup);
	} 

	public static UnitType newUnitType() {
		return new UnitType(stGroup);
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