package nextgen.templates.kotlin;

public class KotlinST {

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
	.append("eom() ::= \"}\"\n")
	.append("gt() ::= \">\"\n")
	.append(ArrayEqualsExpression.st + "\n")
	.append(AssertNotNullExpression.st + "\n")
	.append(AssignExpression.st + "\n")
	.append(CastExpression.st + "\n")
	.append(ComparisonExpression.st + "\n")
	.append(ConstructorCallExpression.st + "\n")
	.append(EscapedLiteralExpression.st + "\n")
	.append(FunctionCallExpression.st + "\n")
	.append(GroupedExpression.st + "\n")
	.append(IfExpression.st + "\n")
	.append(LiteralExpression.st + "\n")
	.append(LogicalExpression.st + "\n")
	.append(NullExpression.st + "\n")
	.append(ObjectExpression.st + "\n")
	.append(PairExpression.st + "\n")
	.append(PropertyAccessorExpression.st + "\n")
	.append(RawStringExpression.st + "\n")
	.append(ReferenceExpression.st + "\n")
	.append(ScopeExpression.st + "\n")
	.append(StringValueExpression.st + "\n")
	.append(ThisExpression.st + "\n")
	.append(AnnotationDeclaration.st + "\n")
	.append(ClassDeclaration.st + "\n")
	.append(CompanionObject.st + "\n")
	.append(OverrideEquals.st + "\n")
	.append(OverrideHashCode.st + "\n")
	.append(OverrideToString.st + "\n")
	.append(DataClassDeclaration.st + "\n")
	.append(EnumClassDeclaration.st + "\n")
	.append(EnumField.st + "\n")
	.append(ExtendingClass.st + "\n")
	.append(FunctionDeclaration.st + "\n")
	.append(FunctionParam.st + "\n")
	.append(ImplementingInterface.st + "\n")
	.append(InterfaceDeclaration.st + "\n")
	.append(ObjectDeclaration.st + "\n")
	.append(PackageDeclaration.st + "\n")
	.append(ParameterDeclaration.st + "\n")
	.append(PropertyDeclaration.st + "\n")
	.append(KotlinStringTemplateExpression.st + "\n")
	.append(KotlinStringTemplateSingleValue.st + "\n")
	.append(CommentBlock.st + "\n")
	.append(IfStatement.st + "\n")
	.append(ImportStatement.st + "\n")
	.append(ReturnStatement.st + "\n")
	.append(SingleLineComment.st + "\n")
	.append(TodoStatement.st + "\n")
	.append(VarDeclarationStatement.st + "\n")
	.append(ArrayInitializer.st + "\n")
	.append(EmptyArrayInitializer.st + "\n")
	.append(EmptyMapInitializer.st + "\n")
	.append(ListInitializer.st + "\n")
	.append(MapInitializer.st + "\n")
	.append(MutableListInitializer.st + "\n")
	.append(MutableMapInitializer.st + "\n")
	.append(MutableSetInitializer.st + "\n")
	.append(SetInitializer.st + "\n")
	.append(KotlinFile.st + "\n")
	.append(AnyType.st + "\n")
	.append(ArrayType.st + "\n")
	.append(BooleanType.st + "\n")
	.append(DoubleType.st + "\n")
	.append(FloatType.st + "\n")
	.append(IntType.st + "\n")
	.append(ListType.st + "\n")
	.append(LongType.st + "\n")
	.append(MapType.st + "\n")
	.append(MutableListType.st + "\n")
	.append(MutableMapType.st + "\n")
	.append(MutableSetType.st + "\n")
	.append(NamedType.st + "\n")
	.append(NullableType.st + "\n")
	.append(PairType.st + "\n")
	.append(SetType.st + "\n")
	.append(StarType.st + "\n")
	.append(StringType.st + "\n")
	.append(TemplateType.st + "\n")
	.append(UnitType.st + "\n")
	.toString()  ;

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

	public static AssertNotNullExpression newAssertNotNullExpression() {
		return new AssertNotNullExpression(stGroup);
	}  

	public static AssignExpression newAssignExpression() {
		return new AssignExpression(stGroup);
	}  

	public static CastExpression newCastExpression() {
		return new CastExpression(stGroup);
	}  

	public static ComparisonExpression newComparisonExpression() {
		return new ComparisonExpression(stGroup);
	}  

	public static ConstructorCallExpression newConstructorCallExpression() {
		return new ConstructorCallExpression(stGroup);
	}  

	public static EscapedLiteralExpression newEscapedLiteralExpression() {
		return new EscapedLiteralExpression(stGroup);
	}  

	public static FunctionCallExpression newFunctionCallExpression() {
		return new FunctionCallExpression(stGroup);
	}  

	public static GroupedExpression newGroupedExpression() {
		return new GroupedExpression(stGroup);
	}  

	public static IfExpression newIfExpression() {
		return new IfExpression(stGroup);
	}  

	public static LiteralExpression newLiteralExpression() {
		return new LiteralExpression(stGroup);
	}  

	public static LogicalExpression newLogicalExpression() {
		return new LogicalExpression(stGroup);
	}  

	public static NullExpression newNullExpression() {
		return new NullExpression(stGroup);
	}  

	public static ObjectExpression newObjectExpression() {
		return new ObjectExpression(stGroup);
	}  

	public static PairExpression newPairExpression() {
		return new PairExpression(stGroup);
	}  

	public static PropertyAccessorExpression newPropertyAccessorExpression() {
		return new PropertyAccessorExpression(stGroup);
	}  

	public static RawStringExpression newRawStringExpression() {
		return new RawStringExpression(stGroup);
	}  

	public static ReferenceExpression newReferenceExpression() {
		return new ReferenceExpression(stGroup);
	}  

	public static ScopeExpression newScopeExpression() {
		return new ScopeExpression(stGroup);
	}  

	public static StringValueExpression newStringValueExpression() {
		return new StringValueExpression(stGroup);
	}  

	public static ThisExpression newThisExpression() {
		return new ThisExpression(stGroup);
	}  

	public static AnnotationDeclaration newAnnotationDeclaration() {
		return new AnnotationDeclaration(stGroup);
	}  

	public static ClassDeclaration newClassDeclaration() {
		return new ClassDeclaration(stGroup);
	}  

	public static CompanionObject newCompanionObject() {
		return new CompanionObject(stGroup);
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

	public static EnumClassDeclaration newEnumClassDeclaration() {
		return new EnumClassDeclaration(stGroup);
	}  

	public static EnumField newEnumField() {
		return new EnumField(stGroup);
	}  

	public static ExtendingClass newExtendingClass() {
		return new ExtendingClass(stGroup);
	}  

	public static FunctionDeclaration newFunctionDeclaration() {
		return new FunctionDeclaration(stGroup);
	}  

	public static FunctionParam newFunctionParam() {
		return new FunctionParam(stGroup);
	}  

	public static ImplementingInterface newImplementingInterface() {
		return new ImplementingInterface(stGroup);
	}  

	public static InterfaceDeclaration newInterfaceDeclaration() {
		return new InterfaceDeclaration(stGroup);
	}  

	public static ObjectDeclaration newObjectDeclaration() {
		return new ObjectDeclaration(stGroup);
	}  

	public static PackageDeclaration newPackageDeclaration() {
		return new PackageDeclaration(stGroup);
	}  

	public static ParameterDeclaration newParameterDeclaration() {
		return new ParameterDeclaration(stGroup);
	}  

	public static PropertyDeclaration newPropertyDeclaration() {
		return new PropertyDeclaration(stGroup);
	}  

	public static KotlinStringTemplateExpression newKotlinStringTemplateExpression() {
		return new KotlinStringTemplateExpression(stGroup);
	}  

	public static KotlinStringTemplateSingleValue newKotlinStringTemplateSingleValue() {
		return new KotlinStringTemplateSingleValue(stGroup);
	}  

	public static CommentBlock newCommentBlock() {
		return new CommentBlock(stGroup);
	}  

	public static IfStatement newIfStatement() {
		return new IfStatement(stGroup);
	}  

	public static ImportStatement newImportStatement() {
		return new ImportStatement(stGroup);
	}  

	public static ReturnStatement newReturnStatement() {
		return new ReturnStatement(stGroup);
	}  

	public static SingleLineComment newSingleLineComment() {
		return new SingleLineComment(stGroup);
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

	public static ListInitializer newListInitializer() {
		return new ListInitializer(stGroup);
	}  

	public static MapInitializer newMapInitializer() {
		return new MapInitializer(stGroup);
	}  

	public static MutableListInitializer newMutableListInitializer() {
		return new MutableListInitializer(stGroup);
	}  

	public static MutableMapInitializer newMutableMapInitializer() {
		return new MutableMapInitializer(stGroup);
	}  

	public static MutableSetInitializer newMutableSetInitializer() {
		return new MutableSetInitializer(stGroup);
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

	public static StarType newStarType() {
		return new StarType(stGroup);
	}  

	public static StringType newStringType() {
		return new StringType(stGroup);
	}  

	public static TemplateType newTemplateType() {
		return new TemplateType(stGroup);
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