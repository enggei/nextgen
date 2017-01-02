package com.generator.generators.javaparser;

import com.generator.util.StringUtil;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.TypeParameter;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.comments.BlockComment;
import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.ast.comments.LineComment;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.stmt.*;
import com.github.javaparser.ast.type.*;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

class DebugVisitorAdapter extends VoidVisitorAdapter<Object>  {

   private int indent;

   public DebugVisitorAdapter() {
   }


   @Override
   public void visit( PrimitiveType arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "PrimitiveType:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( MultiTypeParameter arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "MultiTypeParameter:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( Parameter arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "Parameter:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( PackageDeclaration arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "PackageDeclaration:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( ObjectCreationExpr arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "ObjectCreationExpr:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( NullLiteralExpr arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "NullLiteralExpr:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( ReturnStmt arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "ReturnStmt:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( UnionType arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "UnionType:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( IntersectionType arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "IntersectionType:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( ReferenceType arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "ReferenceType:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( QualifiedNameExpr arg0,  Object arg) {
       //System.out.println(StringUtil.pad(indent++, "-", "QualifiedNameExpr:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( MarkerAnnotationExpr arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "MarkerAnnotationExpr:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( LongLiteralMinValueExpr arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "LongLiteralMinValueExpr:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( LongLiteralExpr arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "LongLiteralExpr:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( LineComment arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "LineComment:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( TypeExpr arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "TypeExpr:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( JavadocComment arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "JavadocComment:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( NormalAnnotationExpr arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "NormalAnnotationExpr:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( NameExpr arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "NameExpr:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( MethodDeclaration arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "MethodDeclaration:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( MethodCallExpr arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "MethodCallExpr:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( MemberValuePair arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "MemberValuePair:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( VariableDeclaratorId arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "VariableDeclaratorId:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( VariableDeclarator arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "VariableDeclarator:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( VariableDeclarationExpr arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "VariableDeclarationExpr:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( UnknownType arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "UnknownType:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( UnaryExpr arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "UnaryExpr:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( TypeParameter arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "TypeParameter:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( MethodReferenceExpr arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "MethodReferenceExpr:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( LambdaExpr arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "LambdaExpr:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( WildcardType arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "WildcardType:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( WhileStmt arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "WhileStmt:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( VoidType arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "VoidType:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( SwitchStmt arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "SwitchStmt:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( SwitchEntryStmt arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "SwitchEntryStmt:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( SuperExpr arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "SuperExpr:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( StringLiteralExpr arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "StringLiteralExpr:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( SingleMemberAnnotationExpr arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "SingleMemberAnnotationExpr:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( TypeDeclarationStmt arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "TypeDeclarationStmt:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( TryStmt arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "TryStmt:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( ThrowStmt arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "ThrowStmt:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( ThisExpr arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "ThisExpr:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( SynchronizedStmt arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "SynchronizedStmt:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( ClassExpr arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "ClassExpr:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( CharLiteralExpr arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "CharLiteralExpr:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( CatchClause arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "CatchClause:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( CastExpr arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "CastExpr:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( BreakStmt arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "BreakStmt:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( BooleanLiteralExpr arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "BooleanLiteralExpr:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( ConstructorDeclaration arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "ConstructorDeclaration:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( ConditionalExpr arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "ConditionalExpr:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( CompilationUnit arg0,  Object arg) {
       //System.out.println(StringUtil.pad(indent++, "-", "CompilationUnit:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( ClassOrInterfaceType arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "ClassOrInterfaceType:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( ClassOrInterfaceDeclaration arg0,  Object arg) {
       //System.out.println(StringUtil.pad(indent++, "-", "ClassOrInterfaceDeclaration:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( ArrayInitializerExpr arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "ArrayInitializerExpr:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( ArrayCreationExpr arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "ArrayCreationExpr:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( ArrayAccessExpr arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "ArrayAccessExpr:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( AnnotationMemberDeclaration arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "AnnotationMemberDeclaration:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( AnnotationDeclaration arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "AnnotationDeclaration:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( LabeledStmt arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "LabeledStmt:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( BlockStmt arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "BlockStmt:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( BlockComment arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "BlockComment:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( BinaryExpr arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "BinaryExpr:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( AssignExpr arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "AssignExpr:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( AssertStmt arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "AssertStmt:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( IfStmt arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "IfStmt:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( ForStmt arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "ForStmt:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( ForeachStmt arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "ForeachStmt:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( FieldDeclaration arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "FieldDeclaration:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( FieldAccessExpr arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "FieldAccessExpr:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( ExpressionStmt arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "ExpressionStmt:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( IntegerLiteralMinValueExpr arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "IntegerLiteralMinValueExpr:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( IntegerLiteralExpr arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "IntegerLiteralExpr:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( InstanceOfExpr arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "InstanceOfExpr:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( InitializerDeclaration arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "InitializerDeclaration:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( ImportDeclaration arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "ImportDeclaration:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( EmptyStmt arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "EmptyStmt:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( EmptyMemberDeclaration arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "EmptyMemberDeclaration:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( DoubleLiteralExpr arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "DoubleLiteralExpr:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( DoStmt arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "DoStmt:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( ContinueStmt arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "ContinueStmt:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( ExplicitConstructorInvocationStmt arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "ExplicitConstructorInvocationStmt:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( EnumDeclaration arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "EnumDeclaration:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( EnumConstantDeclaration arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "EnumConstantDeclaration:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( EnclosedExpr arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "EnclosedExpr:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 
   @Override
   public void visit( EmptyTypeDeclaration arg0,  Object arg) {
       System.out.println(StringUtil.pad(indent++, "-", "EmptyTypeDeclaration:" + arg0.toString().trim() + " children: " + arg0.getChildrenNodes().size()));
       indent++;
       super.visit(arg0, arg);
       indent--;
   } 

}