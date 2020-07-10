package nextgen.templates.java;

public class JavaST {

	private static final String stg = "delimiters \"~\", \"~\"\n" +
	"eom() ::= \"}\"\n" +
	"gt() ::= \">\"\n" +
	ArrayListType.st + "\n" + 
	ListType.st + "\n" + 
	SetType.st + "\n" + 
	Bean.st + "\n" + 
	BoundedExternalListAccessors.st + "\n" + 
	BoundedExternalReferenceAccessors.st + "\n" + 
	BoundedListAccessors.st + "\n" + 
	BoundedListReferenceAccessors.st + "\n" + 
	BoundedPrimitiveAccessors.st + "\n" + 
	BoundedReferenceAccessors.st + "\n" + 
	Enum.st + "\n" + 
	EnumValue.st + "\n" + 
	Pojo.st + "\n" + 
	ListAccessors.st + "\n" + 
	PrimitiveAccessors.st + "\n" + 
	ReferenceAccessors.st + "\n" + 
	PojoFactory.st + "\n" + 
	SupplierType.st + "\n" + 
	ArrayCreationLevel.st + "\n" + 
	CompilationUnit.st + "\n" + 
	ClassOrInterfaceDeclaration.st + "\n" + 
	ConstructorDeclaration.st + "\n" + 
	FieldDeclaration.st + "\n" + 
	EnumDeclaration.st + "\n" + 
	EnumConstant.st + "\n" + 
	ImportDeclaration.st + "\n" + 
	AnnotationDeclaration.st + "\n" + 
	AnnotationMemberDeclaration.st + "\n" + 
	FinalFieldDeclaration.st + "\n" + 
	MethodDeclaration.st + "\n" + 
	Parameter.st + "\n" + 
	ModuleDeclaration.st + "\n" + 
	PackageDeclaration.st + "\n" + 
	PrivateFieldDeclaration.st + "\n" + 
	PrivateFinalFieldDeclaration.st + "\n" + 
	PublicFinalFieldDeclaration.st + "\n" + 
	StaticFinalFieldDeclaration.st + "\n" + 
	StaticPrivateFinalFieldDeclaration.st + "\n" + 
	StaticPublicFinalFieldDeclaration.st + "\n" + 
	VariableDeclaration.st + "\n" + 
	ArrayAccessExpression.st + "\n" + 
	ArrayCreationExpression.st + "\n" + 
	ArrayInitializerExpression.st + "\n" + 
	AssignExpression.st + "\n" + 
	AssignThisVariableExpression.st + "\n" + 
	BinaryExpression.st + "\n" + 
	BooleanLiteralExpression.st + "\n" + 
	CastExpression.st + "\n" + 
	CharLiteralExpression.st + "\n" + 
	ClassExpression.st + "\n" + 
	ConditionalExpression.st + "\n" + 
	DoubleLiteralExpression.st + "\n" + 
	EnclosedExpression.st + "\n" + 
	FieldAccessExpression.st + "\n" + 
	InstanceOfExpression.st + "\n" + 
	IntegerLiteralExpression.st + "\n" + 
	LambdaExpression.st + "\n" + 
	LongExpression.st + "\n" + 
	MarkerAnnotationExpression.st + "\n" + 
	MethodCallExpression.st + "\n" + 
	MethodReferenceExpression.st + "\n" + 
	NameExpression.st + "\n" + 
	NormalAnnotationExpression.st + "\n" + 
	NullLiteralExpression.st + "\n" + 
	ObjectCreationExpression.st + "\n" + 
	SingleMemberAnnotationExpression.st + "\n" + 
	StringLiteralExpression.st + "\n" + 
	SuperExpression.st + "\n" + 
	ThisExpression.st + "\n" + 
	ThisVariableExpression.st + "\n" + 
	UnaryExpression.st + "\n" + 
	VariableDeclarationExpression.st + "\n" + 
	JavaPackageInfo.st + "\n" + 
	MemberValuePair.st + "\n" + 
	QualifierName.st + "\n" + 
	AssertStmt.st + "\n" + 
	BlockStmt.st + "\n" + 
	BreakStmt.st + "\n" + 
	CatchClause.st + "\n" + 
	ContinueStmt.st + "\n" + 
	DoStmt.st + "\n" + 
	EmptyStmt.st + "\n" + 
	ExplicitConstructorInvocationStmt.st + "\n" + 
	ExpressionStmt.st + "\n" + 
	ForEachStmt.st + "\n" + 
	ForStmt.st + "\n" + 
	IfStmt.st + "\n" + 
	LabeledStmt.st + "\n" + 
	ReturnStmt.st + "\n" + 
	SwitchEntryStmt.st + "\n" + 
	SwitchStmt.st + "\n" + 
	SynchronizedStmt.st + "\n" + 
	ThrowStmt.st + "\n" + 
	TryStmt.st + "\n" + 
	WhileStmt.st + "\n" + 
	ClassOrInterfaceType.st + "\n" + 
	TypeParameter.st + "\n" + 
	JavaPatterns.st + "\n" + 
	InvokeLater.st + "\n" + 
	NewInstance.st + "\n" + 
	Switch.st + "\n" + 
	ProjectTypes.st + "\n" ;

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

	private static org.stringtemplate.v4.STGroup stGroup = decorate(new org.stringtemplate.v4.STGroupString("JavaST", stg, '~', '~'));

	public static void setSTGroup(final String stgFile) {
		stGroup = decorate(new org.stringtemplate.v4.STGroupFile(stgFile, '~', '~'));
	}

	public static ArrayListType newArrayListType() {
		return new ArrayListType(stGroup);
	} 

	public static ListType newListType() {
		return new ListType(stGroup);
	} 

	public static SetType newSetType() {
		return new SetType(stGroup);
	} 

	public static Bean newBean() {
		return new Bean(stGroup);
	} 

	public static BoundedExternalListAccessors newBoundedExternalListAccessors() {
		return new BoundedExternalListAccessors(stGroup);
	} 

	public static BoundedExternalReferenceAccessors newBoundedExternalReferenceAccessors() {
		return new BoundedExternalReferenceAccessors(stGroup);
	} 

	public static BoundedListAccessors newBoundedListAccessors() {
		return new BoundedListAccessors(stGroup);
	} 

	public static BoundedListReferenceAccessors newBoundedListReferenceAccessors() {
		return new BoundedListReferenceAccessors(stGroup);
	} 

	public static BoundedPrimitiveAccessors newBoundedPrimitiveAccessors() {
		return new BoundedPrimitiveAccessors(stGroup);
	} 

	public static BoundedReferenceAccessors newBoundedReferenceAccessors() {
		return new BoundedReferenceAccessors(stGroup);
	} 

	public static Enum newEnum() {
		return new Enum(stGroup);
	} 

	public static EnumValue newEnumValue() {
		return new EnumValue(stGroup);
	} 

	public static Pojo newPojo() {
		return new Pojo(stGroup);
	} 

	public static ListAccessors newListAccessors() {
		return new ListAccessors(stGroup);
	} 

	public static PrimitiveAccessors newPrimitiveAccessors() {
		return new PrimitiveAccessors(stGroup);
	} 

	public static ReferenceAccessors newReferenceAccessors() {
		return new ReferenceAccessors(stGroup);
	} 

	public static PojoFactory newPojoFactory() {
		return new PojoFactory(stGroup);
	} 

	public static SupplierType newSupplierType() {
		return new SupplierType(stGroup);
	} 

	public static ArrayCreationLevel newArrayCreationLevel() {
		return new ArrayCreationLevel(stGroup);
	} 

	public static CompilationUnit newCompilationUnit() {
		return new CompilationUnit(stGroup);
	} 

	public static ClassOrInterfaceDeclaration newClassOrInterfaceDeclaration() {
		return new ClassOrInterfaceDeclaration(stGroup);
	} 

	public static ConstructorDeclaration newConstructorDeclaration() {
		return new ConstructorDeclaration(stGroup);
	} 

	public static FieldDeclaration newFieldDeclaration() {
		return new FieldDeclaration(stGroup);
	} 

	public static EnumDeclaration newEnumDeclaration() {
		return new EnumDeclaration(stGroup);
	} 

	public static EnumConstant newEnumConstant() {
		return new EnumConstant(stGroup);
	} 

	public static ImportDeclaration newImportDeclaration() {
		return new ImportDeclaration(stGroup);
	} 

	public static AnnotationDeclaration newAnnotationDeclaration() {
		return new AnnotationDeclaration(stGroup);
	} 

	public static AnnotationMemberDeclaration newAnnotationMemberDeclaration() {
		return new AnnotationMemberDeclaration(stGroup);
	} 

	public static FinalFieldDeclaration newFinalFieldDeclaration() {
		return new FinalFieldDeclaration(stGroup);
	} 

	public static MethodDeclaration newMethodDeclaration() {
		return new MethodDeclaration(stGroup);
	} 

	public static Parameter newParameter() {
		return new Parameter(stGroup);
	} 

	public static ModuleDeclaration newModuleDeclaration() {
		return new ModuleDeclaration(stGroup);
	} 

	public static PackageDeclaration newPackageDeclaration() {
		return new PackageDeclaration(stGroup);
	} 

	public static PrivateFieldDeclaration newPrivateFieldDeclaration() {
		return new PrivateFieldDeclaration(stGroup);
	} 

	public static PrivateFinalFieldDeclaration newPrivateFinalFieldDeclaration() {
		return new PrivateFinalFieldDeclaration(stGroup);
	} 

	public static PublicFinalFieldDeclaration newPublicFinalFieldDeclaration() {
		return new PublicFinalFieldDeclaration(stGroup);
	} 

	public static StaticFinalFieldDeclaration newStaticFinalFieldDeclaration() {
		return new StaticFinalFieldDeclaration(stGroup);
	} 

	public static StaticPrivateFinalFieldDeclaration newStaticPrivateFinalFieldDeclaration() {
		return new StaticPrivateFinalFieldDeclaration(stGroup);
	} 

	public static StaticPublicFinalFieldDeclaration newStaticPublicFinalFieldDeclaration() {
		return new StaticPublicFinalFieldDeclaration(stGroup);
	} 

	public static VariableDeclaration newVariableDeclaration() {
		return new VariableDeclaration(stGroup);
	} 

	public static ArrayAccessExpression newArrayAccessExpression() {
		return new ArrayAccessExpression(stGroup);
	} 

	public static ArrayCreationExpression newArrayCreationExpression() {
		return new ArrayCreationExpression(stGroup);
	} 

	public static ArrayInitializerExpression newArrayInitializerExpression() {
		return new ArrayInitializerExpression(stGroup);
	} 

	public static AssignExpression newAssignExpression() {
		return new AssignExpression(stGroup);
	} 

	public static AssignThisVariableExpression newAssignThisVariableExpression() {
		return new AssignThisVariableExpression(stGroup);
	} 

	public static BinaryExpression newBinaryExpression() {
		return new BinaryExpression(stGroup);
	} 

	public static BooleanLiteralExpression newBooleanLiteralExpression() {
		return new BooleanLiteralExpression(stGroup);
	} 

	public static CastExpression newCastExpression() {
		return new CastExpression(stGroup);
	} 

	public static CharLiteralExpression newCharLiteralExpression() {
		return new CharLiteralExpression(stGroup);
	} 

	public static ClassExpression newClassExpression() {
		return new ClassExpression(stGroup);
	} 

	public static ConditionalExpression newConditionalExpression() {
		return new ConditionalExpression(stGroup);
	} 

	public static DoubleLiteralExpression newDoubleLiteralExpression() {
		return new DoubleLiteralExpression(stGroup);
	} 

	public static EnclosedExpression newEnclosedExpression() {
		return new EnclosedExpression(stGroup);
	} 

	public static FieldAccessExpression newFieldAccessExpression() {
		return new FieldAccessExpression(stGroup);
	} 

	public static InstanceOfExpression newInstanceOfExpression() {
		return new InstanceOfExpression(stGroup);
	} 

	public static IntegerLiteralExpression newIntegerLiteralExpression() {
		return new IntegerLiteralExpression(stGroup);
	} 

	public static LambdaExpression newLambdaExpression() {
		return new LambdaExpression(stGroup);
	} 

	public static LongExpression newLongExpression() {
		return new LongExpression(stGroup);
	} 

	public static MarkerAnnotationExpression newMarkerAnnotationExpression() {
		return new MarkerAnnotationExpression(stGroup);
	} 

	public static MethodCallExpression newMethodCallExpression() {
		return new MethodCallExpression(stGroup);
	} 

	public static MethodReferenceExpression newMethodReferenceExpression() {
		return new MethodReferenceExpression(stGroup);
	} 

	public static NameExpression newNameExpression() {
		return new NameExpression(stGroup);
	} 

	public static NormalAnnotationExpression newNormalAnnotationExpression() {
		return new NormalAnnotationExpression(stGroup);
	} 

	public static NullLiteralExpression newNullLiteralExpression() {
		return new NullLiteralExpression(stGroup);
	} 

	public static ObjectCreationExpression newObjectCreationExpression() {
		return new ObjectCreationExpression(stGroup);
	} 

	public static SingleMemberAnnotationExpression newSingleMemberAnnotationExpression() {
		return new SingleMemberAnnotationExpression(stGroup);
	} 

	public static StringLiteralExpression newStringLiteralExpression() {
		return new StringLiteralExpression(stGroup);
	} 

	public static SuperExpression newSuperExpression() {
		return new SuperExpression(stGroup);
	} 

	public static ThisExpression newThisExpression() {
		return new ThisExpression(stGroup);
	} 

	public static ThisVariableExpression newThisVariableExpression() {
		return new ThisVariableExpression(stGroup);
	} 

	public static UnaryExpression newUnaryExpression() {
		return new UnaryExpression(stGroup);
	} 

	public static VariableDeclarationExpression newVariableDeclarationExpression() {
		return new VariableDeclarationExpression(stGroup);
	} 

	public static JavaPackageInfo newJavaPackageInfo() {
		return new JavaPackageInfo(stGroup);
	} 

	public static MemberValuePair newMemberValuePair() {
		return new MemberValuePair(stGroup);
	} 

	public static QualifierName newQualifierName() {
		return new QualifierName(stGroup);
	} 

	public static AssertStmt newAssertStmt() {
		return new AssertStmt(stGroup);
	} 

	public static BlockStmt newBlockStmt() {
		return new BlockStmt(stGroup);
	} 

	public static BreakStmt newBreakStmt() {
		return new BreakStmt(stGroup);
	} 

	public static CatchClause newCatchClause() {
		return new CatchClause(stGroup);
	} 

	public static ContinueStmt newContinueStmt() {
		return new ContinueStmt(stGroup);
	} 

	public static DoStmt newDoStmt() {
		return new DoStmt(stGroup);
	} 

	public static EmptyStmt newEmptyStmt() {
		return new EmptyStmt(stGroup);
	} 

	public static ExplicitConstructorInvocationStmt newExplicitConstructorInvocationStmt() {
		return new ExplicitConstructorInvocationStmt(stGroup);
	} 

	public static ExpressionStmt newExpressionStmt() {
		return new ExpressionStmt(stGroup);
	} 

	public static ForEachStmt newForEachStmt() {
		return new ForEachStmt(stGroup);
	} 

	public static ForStmt newForStmt() {
		return new ForStmt(stGroup);
	} 

	public static IfStmt newIfStmt() {
		return new IfStmt(stGroup);
	} 

	public static LabeledStmt newLabeledStmt() {
		return new LabeledStmt(stGroup);
	} 

	public static ReturnStmt newReturnStmt() {
		return new ReturnStmt(stGroup);
	} 

	public static SwitchEntryStmt newSwitchEntryStmt() {
		return new SwitchEntryStmt(stGroup);
	} 

	public static SwitchStmt newSwitchStmt() {
		return new SwitchStmt(stGroup);
	} 

	public static SynchronizedStmt newSynchronizedStmt() {
		return new SynchronizedStmt(stGroup);
	} 

	public static ThrowStmt newThrowStmt() {
		return new ThrowStmt(stGroup);
	} 

	public static TryStmt newTryStmt() {
		return new TryStmt(stGroup);
	} 

	public static WhileStmt newWhileStmt() {
		return new WhileStmt(stGroup);
	} 

	public static ClassOrInterfaceType newClassOrInterfaceType() {
		return new ClassOrInterfaceType(stGroup);
	} 

	public static TypeParameter newTypeParameter() {
		return new TypeParameter(stGroup);
	} 

	public static JavaPatterns newJavaPatterns() {
		return new JavaPatterns(stGroup);
	} 

	public static InvokeLater newInvokeLater() {
		return new InvokeLater(stGroup);
	} 

	public static NewInstance newNewInstance() {
		return new NewInstance(stGroup);
	} 

	public static Switch newSwitch() {
		return new Switch(stGroup);
	} 

	public static ProjectTypes newProjectTypes() {
		return new ProjectTypes(stGroup);
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