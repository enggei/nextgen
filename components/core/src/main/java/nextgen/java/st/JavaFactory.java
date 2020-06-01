package nextgen.java.st;


public class JavaFactory {

	public static ClassOrInterfaceType booleanType = JavaFactory.newClassOrInterfaceType().addNames("boolean").setIsPrimitive(true);
	public static ClassOrInterfaceType intType = JavaFactory.newClassOrInterfaceType().addNames("int").setIsPrimitive(true);
	public static ClassOrInterfaceType doubleType = JavaFactory.newClassOrInterfaceType().addNames("double").setIsPrimitive(true);
	public static ClassOrInterfaceType floatType = JavaFactory.newClassOrInterfaceType().addNames("float").setIsPrimitive(true);
	public static ClassOrInterfaceType byteType = JavaFactory.newClassOrInterfaceType().addNames("byte").setIsPrimitive(true);
	public static ClassOrInterfaceType charType = JavaFactory.newClassOrInterfaceType().addNames("char").setIsPrimitive(true);
	public static ClassOrInterfaceType shortType = JavaFactory.newClassOrInterfaceType().addNames("short").setIsPrimitive(true);
	public static ClassOrInterfaceType longType = JavaFactory.newClassOrInterfaceType().addNames("long").setIsPrimitive(true);
	public static ClassOrInterfaceType voidType = JavaFactory.newClassOrInterfaceType().addNames("void").setIsPrimitive(true);
	public static ClassOrInterfaceType ObjectType = JavaFactory.newClassOrInterfaceType().setScope("java.lang").addNames("Object");
	public static ClassOrInterfaceType ClassType = JavaFactory.newClassOrInterfaceType().setScope("java.lang").addNames("Class");
	public static ClassOrInterfaceType ThrowableType = JavaFactory.newClassOrInterfaceType().setScope("java.lang").addNames("Throwable");
	public static ClassOrInterfaceType ThreadType = JavaFactory.newClassOrInterfaceType().setScope("java.lang").addNames("Thread");
	public static ClassOrInterfaceType StringType = JavaFactory.newClassOrInterfaceType().setScope("java.lang").addNames("String").setIsPrimitive(true);
	public static ClassOrInterfaceType StringBuilderType = JavaFactory.newClassOrInterfaceType().setScope("java.lang").addNames("StringBuilder");
	public static ClassOrInterfaceType InstantType = JavaFactory.newClassOrInterfaceType().setScope("java.time").addNames("Instant").setIsPrimitive(true);
	public static ClassOrInterfaceType BooleanType = JavaFactory.newClassOrInterfaceType().setScope("java.lang").addNames("Boolean").setIsPrimitive(true);
	public static ClassOrInterfaceType IntegerType = JavaFactory.newClassOrInterfaceType().setScope("java.lang").addNames("Integer").setIsPrimitive(true);
	public static ClassOrInterfaceType DoubleType = JavaFactory.newClassOrInterfaceType().setScope("java.lang").addNames("Double").setIsPrimitive(true);
	public static ClassOrInterfaceType FloatType = JavaFactory.newClassOrInterfaceType().setScope("java.lang").addNames("Float").setIsPrimitive(true);
	public static ClassOrInterfaceType ByteType = JavaFactory.newClassOrInterfaceType().setScope("java.lang").addNames("Byte").setIsPrimitive(true);
	public static ClassOrInterfaceType CharacterType = JavaFactory.newClassOrInterfaceType().setScope("java.lang").addNames("Character").setIsPrimitive(true);
	public static ClassOrInterfaceType ShortType = JavaFactory.newClassOrInterfaceType().setScope("java.lang").addNames("Short").setIsPrimitive(true);
	public static ClassOrInterfaceType LongType = JavaFactory.newClassOrInterfaceType().setScope("java.lang").addNames("Long").setIsPrimitive(true);
	public static ClassOrInterfaceType VoidType = JavaFactory.newClassOrInterfaceType().setScope("java.lang").addNames("Void").setIsPrimitive(true);
	public static ClassOrInterfaceType IterableType = JavaFactory.newClassOrInterfaceType().setScope("java.lang").addNames("Iterable");
	public static ClassOrInterfaceType CollectionType = JavaFactory.newClassOrInterfaceType().setScope("java.util").addNames("Collection");
	public static ClassOrInterfaceType ListType = JavaFactory.newClassOrInterfaceType().setScope("java.util").addNames("List").setIsTyped(true).setIsCollection(true);
	public static ClassOrInterfaceType LinkedListType = JavaFactory.newClassOrInterfaceType().setScope("java.util").addNames("LinkedList").setIsTyped(true).setIsCollection(true);
	public static ClassOrInterfaceType ArrayListType = JavaFactory.newClassOrInterfaceType().setScope("java.util").addNames("ArrayList").setIsTyped(true).setIsCollection(true);
	public static ClassOrInterfaceType MapType = JavaFactory.newClassOrInterfaceType().setScope("java.util").addNames("Map");
	public static ClassOrInterfaceType LinkedHashMapType = JavaFactory.newClassOrInterfaceType().setScope("java.util").addNames("LinkedHashMap").setIsTyped(true).setIsCollection(true);
	public static ClassOrInterfaceType TreeMapType = JavaFactory.newClassOrInterfaceType().setScope("java.util").addNames("TreeMap").setIsTyped(true).setIsCollection(true);
	public static ClassOrInterfaceType SetType = JavaFactory.newClassOrInterfaceType().setScope("java.util").addNames("Set").setIsTyped(true).setIsCollection(true);
	public static ClassOrInterfaceType LinkedHashSetType = JavaFactory.newClassOrInterfaceType().setScope("java.util").addNames("LinkedHashSet").setIsTyped(true).setIsCollection(true);
	public static ClassOrInterfaceType TreeSetType = JavaFactory.newClassOrInterfaceType().setScope("java.util").addNames("TreeSet").setIsTyped(true).setIsCollection(true);
	public static ClassOrInterfaceType HashSetType = JavaFactory.newClassOrInterfaceType().setScope("java.util").addNames("HashSet").setIsTyped(true).setIsCollection(true);
	public static ClassOrInterfaceType QueueType = JavaFactory.newClassOrInterfaceType().setScope("java.util").addNames("Queue");
	public static ClassOrInterfaceType ArrayDequeType = JavaFactory.newClassOrInterfaceType().setScope("java.util").addNames("ArrayDeque").setIsTyped(true).setIsCollection(true);
	public static ClassOrInterfaceType PriorityQueueType = JavaFactory.newClassOrInterfaceType().setScope("java.util").addNames("PriorityQueue").setIsTyped(true).setIsCollection(true);
	public static ClassOrInterfaceType CollectionsType = JavaFactory.newClassOrInterfaceType().setScope("java.util").addNames("Collections");
	public static ClassOrInterfaceType ObjectsType = JavaFactory.newClassOrInterfaceType().setScope("java.util").addNames("Objects");
	public static ClassOrInterfaceType StreamType = JavaFactory.newClassOrInterfaceType().setScope("java.util.stream").addNames("Stream").setIsTyped(true);
	public static ClassOrInterfaceType OptionalType = JavaFactory.newClassOrInterfaceType().setScope("java.util").addNames("Optional").setIsTyped(true);
	public static ClassOrInterfaceType StreamSupportType = JavaFactory.newClassOrInterfaceType().setScope("java.util.stream").addNames("StreamSupport");
	public static ClassOrInterfaceType CollectorsType = JavaFactory.newClassOrInterfaceType().setScope("java.util.stream").addNames("Collectors");
	public static ClassOrInterfaceType ConsumerType = JavaFactory.newClassOrInterfaceType().setScope("java.util.function").addNames("Consumer").setIsTyped(true);
	public static ClassOrInterfaceType BiConsumerType = JavaFactory.newClassOrInterfaceType().setScope("java.util.function").addNames("BiConsumer").setIsTyped(true);
	public static ClassOrInterfaceType AtomicIntegerType = JavaFactory.newClassOrInterfaceType().setScope("java.util.concurrent.atomic").addNames("AtomicInteger");
	public static ClassOrInterfaceType AtomicLongType = JavaFactory.newClassOrInterfaceType().setScope("java.util.concurrent.atomic").addNames("AtomicLong");
	public static ClassOrInterfaceType AtomicBooleanType = JavaFactory.newClassOrInterfaceType().setScope("java.util.concurrent.atomic").addNames("AtomicBoolean");
	public static ClassOrInterfaceType AtomicReferenceType = JavaFactory.newClassOrInterfaceType().setScope("java.util.concurrent.atomic").addNames("AtomicReference");
	public static ClassOrInterfaceType DoubleAccumulatorType = JavaFactory.newClassOrInterfaceType().setScope("java.util.concurrent.atomic").addNames("DoubleAccumulator");
	public static ClassOrInterfaceType LongAdderType = JavaFactory.newClassOrInterfaceType().setScope("java.util.concurrent.atomic").addNames("LongAdder");
	public static ClassOrInterfaceType DoubleAdderType = JavaFactory.newClassOrInterfaceType().setScope("java.util.concurrent.atomic").addNames("DoubleAdder");
	public static ClassOrInterfaceType AtomicMarkableReferenceType = JavaFactory.newClassOrInterfaceType().setScope("java.util.concurrent.atomic").addNames("AtomicMarkableReference");
	public static ClassOrInterfaceType FileType = JavaFactory.newClassOrInterfaceType().setScope("java.io").addNames("File");
	public static ClassOrInterfaceType FileReaderType = JavaFactory.newClassOrInterfaceType().setScope("java.io").addNames("FileReader");
	public static ClassOrInterfaceType FileWriterType = JavaFactory.newClassOrInterfaceType().setScope("java.io").addNames("FileWriter");
	public static ClassOrInterfaceType WriterType = JavaFactory.newClassOrInterfaceType().setScope("java.io").addNames("Writer");
	public static ClassOrInterfaceType BufferedWriterType = JavaFactory.newClassOrInterfaceType().setScope("java.io").addNames("BufferedWriter");
	public static ClassOrInterfaceType ReaderType = JavaFactory.newClassOrInterfaceType().setScope("java.io").addNames("Reader");
	public static ClassOrInterfaceType BufferedReaderType = JavaFactory.newClassOrInterfaceType().setScope("java.io").addNames("BufferedReader");
	public static ClassOrInterfaceType UUIDType = JavaFactory.newClassOrInterfaceType().setScope("java.util").addNames("UUID").setIsPrimitive(true);

	public static Modifier ModifierPUBLIC() { 
		return Modifier.PUBLIC;
	}

	public static Modifier ModifierPROTECTED() { 
		return Modifier.PROTECTED;
	}

	public static Modifier ModifierPRIVATE() { 
		return Modifier.PRIVATE;
	}

	public static Modifier ModifierSTATIC() { 
		return Modifier.STATIC;
	}

	public static Modifier ModifierABSTRACT() { 
		return Modifier.ABSTRACT;
	}

	public static Modifier ModifierFINAL() { 
		return Modifier.FINAL;
	}

	public static CatchClause newCatchClause() { 
		return new CatchClause();
	}

	public static TypeParameter newTypeParameter() { 
		return new TypeParameter();
	}

	public static ArrayCreationLevel newArrayCreationLevel() { 
		return new ArrayCreationLevel();
	}

	public static ThisVariableExpression newThisVariableExpression() { 
		return new ThisVariableExpression();
	}

	public static ConditionalExpression newConditionalExpression() { 
		return new ConditionalExpression();
	}

	public static EmptyStmt newEmptyStmt() { 
		return new EmptyStmt();
	}

	public static IfStmt newIfStmt() { 
		return new IfStmt();
	}

	public static SuperExpression newSuperExpression() { 
		return new SuperExpression();
	}

	public static AnnotationMemberDeclaration newAnnotationMemberDeclaration() { 
		return new AnnotationMemberDeclaration();
	}

	public static CompilationUnit newCompilationUnit() { 
		return new CompilationUnit();
	}

	public static StringLiteralExpression newStringLiteralExpression() { 
		return new StringLiteralExpression();
	}

	public static LambdaExpression newLambdaExpression() { 
		return new LambdaExpression();
	}

	public static MarkerAnnotationExpression newMarkerAnnotationExpression() { 
		return new MarkerAnnotationExpression();
	}

	public static ForStmt newForStmt() { 
		return new ForStmt();
	}

	public static StaticFinalFieldDeclaration newStaticFinalFieldDeclaration() { 
		return new StaticFinalFieldDeclaration();
	}

	public static ReturnStmt newReturnStmt() { 
		return new ReturnStmt();
	}

	public static ExplicitConstructorInvocationStmt newExplicitConstructorInvocationStmt() { 
		return new ExplicitConstructorInvocationStmt();
	}

	public static BooleanLiteralExpression newBooleanLiteralExpression() { 
		return new BooleanLiteralExpression();
	}

	public static ArrayAccessExpression newArrayAccessExpression() { 
		return new ArrayAccessExpression();
	}

	public static SwitchEntryStmt newSwitchEntryStmt() { 
		return new SwitchEntryStmt();
	}

	public static ContinueStmt newContinueStmt() { 
		return new ContinueStmt();
	}

	public static VariableDeclaration newVariableDeclaration() { 
		return new VariableDeclaration();
	}

	public static BreakStmt newBreakStmt() { 
		return new BreakStmt();
	}

	public static PublicFinalFieldDeclaration newPublicFinalFieldDeclaration() { 
		return new PublicFinalFieldDeclaration();
	}

	public static ThisExpression newThisExpression() { 
		return new ThisExpression();
	}

	public static ThrowStmt newThrowStmt() { 
		return new ThrowStmt();
	}

	public static PackageDeclaration newPackageDeclaration() { 
		return new PackageDeclaration();
	}

	public static LongExpression newLongExpression() { 
		return new LongExpression();
	}

	public static Parameter newParameter() { 
		return new Parameter();
	}

	public static NullLiteralExpression newNullLiteralExpression() { 
		return new NullLiteralExpression();
	}

	public static staticPublicFinalFieldDeclaration newStaticPublicFinalFieldDeclaration() { 
		return new staticPublicFinalFieldDeclaration();
	}

	public static MethodCallExpression newMethodCallExpression() { 
		return new MethodCallExpression();
	}

	public static InstanceOfExpression newInstanceOfExpression() { 
		return new InstanceOfExpression();
	}

	public static BlockStmt newBlockStmt() { 
		return new BlockStmt();
	}

	public static UnaryExpression newUnaryExpression() { 
		return new UnaryExpression();
	}

	public static ClassOrInterfaceType newClassOrInterfaceType() { 
		return new ClassOrInterfaceType();
	}

	public static AnnotationDeclaration newAnnotationDeclaration() { 
		return new AnnotationDeclaration();
	}

	public static CastExpression newCastExpression() { 
		return new CastExpression();
	}

	public static ObjectCreationExpression newObjectCreationExpression() { 
		return new ObjectCreationExpression();
	}

	public static BinaryExpression newBinaryExpression() { 
		return new BinaryExpression();
	}

	public static ExpressionStmt newExpressionStmt() { 
		return new ExpressionStmt();
	}

	public static DoubleLiteralExpression newDoubleLiteralExpression() { 
		return new DoubleLiteralExpression();
	}

	public static PrivateFieldDeclaration newPrivateFieldDeclaration() { 
		return new PrivateFieldDeclaration();
	}

	public static EnumConstant newEnumConstant() { 
		return new EnumConstant();
	}

	public static NormalAnnotationExpression newNormalAnnotationExpression() { 
		return new NormalAnnotationExpression();
	}

	public static AssignExpression newAssignExpression() { 
		return new AssignExpression();
	}

	public static WhileStmt newWhileStmt() { 
		return new WhileStmt();
	}

	public static EnclosedExpression newEnclosedExpression() { 
		return new EnclosedExpression();
	}

	public static MemberValuePair newMemberValuePair() { 
		return new MemberValuePair();
	}

	public static DoStmt newDoStmt() { 
		return new DoStmt();
	}

	public static ForEachStmt newForEachStmt() { 
		return new ForEachStmt();
	}

	public static QualifierName newQualifierName() { 
		return new QualifierName();
	}

	public static ConstructorDeclaration newConstructorDeclaration() { 
		return new ConstructorDeclaration();
	}

	public static IntegerLiteralExpression newIntegerLiteralExpression() { 
		return new IntegerLiteralExpression();
	}

	public static SwitchStmt newSwitchStmt() { 
		return new SwitchStmt();
	}

	public static FinalFieldDeclaration newFinalFieldDeclaration() { 
		return new FinalFieldDeclaration();
	}

	public static EnumDeclaration newEnumDeclaration() { 
		return new EnumDeclaration();
	}

	public static NameExpression newNameExpression() { 
		return new NameExpression();
	}

	public static MethodDeclaration newMethodDeclaration() { 
		return new MethodDeclaration();
	}

	public static ClassExpression newClassExpression() { 
		return new ClassExpression();
	}

	public static SynchronizedStmt newSynchronizedStmt() { 
		return new SynchronizedStmt();
	}

	public static LabeledStmt newLabeledStmt() { 
		return new LabeledStmt();
	}

	public static MethodReferenceExpression newMethodReferenceExpression() { 
		return new MethodReferenceExpression();
	}

	public static TryStmt newTryStmt() { 
		return new TryStmt();
	}

	public static FieldDeclaration newFieldDeclaration() { 
		return new FieldDeclaration();
	}

	public static AssertStmt newAssertStmt() { 
		return new AssertStmt();
	}

	public static FieldAccessExpression newFieldAccessExpression() { 
		return new FieldAccessExpression();
	}

	public static ArrayCreationExpression newArrayCreationExpression() { 
		return new ArrayCreationExpression();
	}

	public static ArrayInitializerExpression newArrayInitializerExpression() { 
		return new ArrayInitializerExpression();
	}

	public static VariableDeclarationExpression newVariableDeclarationExpression() { 
		return new VariableDeclarationExpression();
	}

	public static AssignThisVariableExpression newAssignThisVariableExpression() { 
		return new AssignThisVariableExpression();
	}

	public static JavaPackageInfo newJavaPackageInfo() { 
		return new JavaPackageInfo();
	}

	public static ModuleDeclaration newModuleDeclaration() { 
		return new ModuleDeclaration();
	}

	public static ImportDeclaration newImportDeclaration() { 
		return new ImportDeclaration();
	}

	public static StaticPrivateFinalFieldDeclaration newStaticPrivateFinalFieldDeclaration() { 
		return new StaticPrivateFinalFieldDeclaration();
	}

	public static ClassOrInterfaceDeclaration newClassOrInterfaceDeclaration() { 
		return new ClassOrInterfaceDeclaration();
	}

	public static CharLiteralExpression newCharLiteralExpression() { 
		return new CharLiteralExpression();
	}

	public static PrivateFinalFieldDeclaration newPrivateFinalFieldDeclaration() { 
		return new PrivateFinalFieldDeclaration();
	}

	public static SingleMemberAnnotationExpression newSingleMemberAnnotationExpression() { 
		return new SingleMemberAnnotationExpression();
	}
}