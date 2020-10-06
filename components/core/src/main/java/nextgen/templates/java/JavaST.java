package nextgen.templates.java;

public class JavaST {

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
	.append("eom() ::= \"}\"\n")
	.append("gt() ::= \">\"\n")
	.append(Bean.st + "\n")
	.append(BeanListener.st + "\n")
	.append(BoundedExternalListAccessors.st + "\n")
	.append(BoundedExternalReferenceAccessors.st + "\n")
	.append(BoundedListAccessors.st + "\n")
	.append(BoundedListReferenceAccessors.st + "\n")
	.append(BoundedPrimitiveAccessors.st + "\n")
	.append(BoundedReferenceAccessors.st + "\n")
	.append(Enum.st + "\n")
	.append(EnumValue.st + "\n")
	.append(Pojo.st + "\n")
	.append(ListAccessors.st + "\n")
	.append(PrimitiveAccessors.st + "\n")
	.append(ReferenceAccessors.st + "\n")
	.append(PojoFactory.st + "\n")
	.append(Script.st + "\n")
	.append(Singleton.st + "\n")
	.append(ValueObject.st + "\n")
	.append(ArrayCreationLevel.st + "\n")
	.append(CompilationUnit.st + "\n")
	.append(ClassOrInterfaceDeclaration.st + "\n")
	.append(ConstructorDeclaration.st + "\n")
	.append(FieldDeclaration.st + "\n")
	.append(EnumDeclaration.st + "\n")
	.append(EnumConstant.st + "\n")
	.append(ImportDeclaration.st + "\n")
	.append(AnnotationDeclaration.st + "\n")
	.append(AnnotationMemberDeclaration.st + "\n")
	.append(FinalFieldDeclaration.st + "\n")
	.append(MethodDeclaration.st + "\n")
	.append(Parameter.st + "\n")
	.append(ModuleDeclaration.st + "\n")
	.append(PackageDeclaration.st + "\n")
	.append(PrivateFieldDeclaration.st + "\n")
	.append(PrivateFinalFieldDeclaration.st + "\n")
	.append(PublicFinalFieldDeclaration.st + "\n")
	.append(StaticFinalFieldDeclaration.st + "\n")
	.append(StaticPrivateFinalFieldDeclaration.st + "\n")
	.append(StaticPublicFinalFieldDeclaration.st + "\n")
	.append(VariableDeclaration.st + "\n")
	.append(ArrayAccessExpression.st + "\n")
	.append(ArrayCreationExpression.st + "\n")
	.append(ArrayInitializerExpression.st + "\n")
	.append(AssignExpression.st + "\n")
	.append(AssignThisVariableExpression.st + "\n")
	.append(BinaryExpression.st + "\n")
	.append(BooleanLiteralExpression.st + "\n")
	.append(CastExpression.st + "\n")
	.append(CharLiteralExpression.st + "\n")
	.append(ClassExpression.st + "\n")
	.append(ConditionalExpression.st + "\n")
	.append(DoubleLiteralExpression.st + "\n")
	.append(EnclosedExpression.st + "\n")
	.append(FieldAccessExpression.st + "\n")
	.append(InstanceOfExpression.st + "\n")
	.append(IntegerLiteralExpression.st + "\n")
	.append(LambdaExpression.st + "\n")
	.append(LongExpression.st + "\n")
	.append(MarkerAnnotationExpression.st + "\n")
	.append(MethodCallExpression.st + "\n")
	.append(MethodReferenceExpression.st + "\n")
	.append(NameExpression.st + "\n")
	.append(NormalAnnotationExpression.st + "\n")
	.append(NullLiteralExpression.st + "\n")
	.append(ObjectCreationExpression.st + "\n")
	.append(SingleMemberAnnotationExpression.st + "\n")
	.append(StringLiteralExpression.st + "\n")
	.append(SuperExpression.st + "\n")
	.append(ThisExpression.st + "\n")
	.append(ThisVariableExpression.st + "\n")
	.append(UnaryExpression.st + "\n")
	.append(VariableDeclarationExpression.st + "\n")
	.append(JavaPackageInfo.st + "\n")
	.append(MemberValuePair.st + "\n")
	.append(QualifierName.st + "\n")
	.append(AssertStmt.st + "\n")
	.append(BlockStmt.st + "\n")
	.append(BreakStmt.st + "\n")
	.append(CatchClause.st + "\n")
	.append(ContinueStmt.st + "\n")
	.append(DoStmt.st + "\n")
	.append(EmptyStmt.st + "\n")
	.append(ExplicitConstructorInvocationStmt.st + "\n")
	.append(ExpressionStmt.st + "\n")
	.append(ForEachStmt.st + "\n")
	.append(ForStmt.st + "\n")
	.append(IfStmt.st + "\n")
	.append(LabeledStmt.st + "\n")
	.append(ReturnStmt.st + "\n")
	.append(SwitchEntryStmt.st + "\n")
	.append(SwitchStmt.st + "\n")
	.append(SynchronizedStmt.st + "\n")
	.append(ThrowStmt.st + "\n")
	.append(TryStmt.st + "\n")
	.append(WhileStmt.st + "\n")
	.append(ClassOrInterfaceType.st + "\n")
	.append(TypeParameter.st + "\n")
	.append(JavaLibrary.st + "\n")
	.append(JavaPackage.st + "\n")
	.append(JavaPatterns.st + "\n")
	.append(PasswordUtils.st + "\n")
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

	private static org.stringtemplate.v4.STGroup stGroup = decorate(new org.stringtemplate.v4.STGroupString("JavaST", stg, '~', '~'));

	public static void setSTGroup(final String stgFile) {
		stGroup = decorate(new org.stringtemplate.v4.STGroupFile(stgFile, '~', '~'));
	}

	public static Bean newBean() {
		return new Bean(stGroup);
	}  

	public static BeanListener newBeanListener() {
		return new BeanListener(stGroup);
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

	public static Script newScript() {
		return new Script(stGroup);
	}  

	public static Singleton newSingleton() {
		return new Singleton(stGroup);
	}  

	public static ValueObject newValueObject() {
		return new ValueObject(stGroup);
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

	public static JavaLibrary newJavaLibrary() {
		return new JavaLibrary(stGroup);
	}  

	public static JavaPackage newJavaPackage() {
		return new JavaPackage(stGroup);
	}  

	public static JavaPatterns newJavaPatterns() {
		return new JavaPatterns(stGroup);
	}  

	public static PasswordUtils newPasswordUtils() {
		return new PasswordUtils(stGroup);
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