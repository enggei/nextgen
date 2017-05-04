package com.generator.generators.javaparser;

import com.generator.editors.BaseDomainVisitor;
import com.generator.editors.NeoModel;
import org.neo4j.graphdb.*;
import com.github.javaparser.ast.*;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.comments.*;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.stmt.*;
import com.github.javaparser.ast.type.*;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.*;

public class NeoVisitorAdapter extends VoidVisitorAdapter<Object>  {

	// 
   private NeoModel graph;
   private Stack <org.neo4j.graphdb.Node> nodes = new Stack<org.neo4j.graphdb.Node>();
   public NeoVisitorAdapter() {
   }

   public NeoVisitorAdapter( NeoModel graph,  Stack<org.neo4j.graphdb.Node> nodes) {
      this.graph = graph; 
      this.nodes = nodes; 
   }
   public NeoModel Graph() {
      return graph;
   }

   public void addNode(org.neo4j.graphdb.Node delegate) {
       this.nodes.add(delegate);
   }

   public void removeNode(org.neo4j.graphdb.Node delegate) {
       this.nodes.remove(delegate);
   }

   public Iterator<org.neo4j.graphdb.Node> iterateNodes() {
       return this.nodes.iterator();
   }

   public Stack<org.neo4j.graphdb.Node> getNodes() {
       return this.nodes;
   }


   public void visitPrimitiveType(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "PrimitiveType");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( PrimitiveType arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("PrimitiveType"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("PrimitiveType"));
       	relationship.setProperty("nodeType", "PrimitiveType");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitMultiTypeParameter(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "MultiTypeParameter");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( MultiTypeParameter arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("MultiTypeParameter"));
       node.setProperty("name",arg0.getName());
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("MultiTypeParameter"));
       	relationship.setProperty("nodeType", "MultiTypeParameter");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitParameter(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "Parameter");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( Parameter arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("Parameter"));
       node.setProperty("name",arg0.getName());
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("Parameter"));
       	relationship.setProperty("nodeType", "Parameter");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitPackageDeclaration(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "PackageDeclaration");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( PackageDeclaration arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("PackageDeclaration"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("PackageDeclaration"));
       	relationship.setProperty("nodeType", "PackageDeclaration");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitObjectCreationExpr(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "ObjectCreationExpr");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( ObjectCreationExpr arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("ObjectCreationExpr"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("ObjectCreationExpr"));
       	relationship.setProperty("nodeType", "ObjectCreationExpr");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitNullLiteralExpr(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "NullLiteralExpr");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( NullLiteralExpr arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("NullLiteralExpr"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("NullLiteralExpr"));
       	relationship.setProperty("nodeType", "NullLiteralExpr");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitReturnStmt(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "ReturnStmt");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( ReturnStmt arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("ReturnStmt"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("ReturnStmt"));
       	relationship.setProperty("nodeType", "ReturnStmt");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitUnionType(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "UnionType");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( UnionType arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("UnionType"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("UnionType"));
       	relationship.setProperty("nodeType", "UnionType");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitIntersectionType(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "IntersectionType");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( IntersectionType arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("IntersectionType"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("IntersectionType"));
       	relationship.setProperty("nodeType", "IntersectionType");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitReferenceType(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "ReferenceType");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( ReferenceType arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("ReferenceType"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("ReferenceType"));
       	relationship.setProperty("nodeType", "ReferenceType");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitQualifiedNameExpr(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "QualifiedNameExpr");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( QualifiedNameExpr arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("QualifiedNameExpr"));
       node.setProperty("name",arg0.getName());
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("QualifiedNameExpr"));
       	relationship.setProperty("nodeType", "QualifiedNameExpr");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitMarkerAnnotationExpr(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "MarkerAnnotationExpr");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( MarkerAnnotationExpr arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("MarkerAnnotationExpr"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("MarkerAnnotationExpr"));
       	relationship.setProperty("nodeType", "MarkerAnnotationExpr");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitLongLiteralMinValueExpr(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "LongLiteralMinValueExpr");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( LongLiteralMinValueExpr arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("LongLiteralMinValueExpr"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("LongLiteralMinValueExpr"));
       	relationship.setProperty("nodeType", "LongLiteralMinValueExpr");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitLongLiteralExpr(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "LongLiteralExpr");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( LongLiteralExpr arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("LongLiteralExpr"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("LongLiteralExpr"));
       	relationship.setProperty("nodeType", "LongLiteralExpr");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitLineComment(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "LineComment");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( LineComment arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("LineComment"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("LineComment"));
       	relationship.setProperty("nodeType", "LineComment");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitTypeExpr(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "TypeExpr");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( TypeExpr arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("TypeExpr"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("TypeExpr"));
       	relationship.setProperty("nodeType", "TypeExpr");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitJavadocComment(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "JavadocComment");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( JavadocComment arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("JavadocComment"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("JavadocComment"));
       	relationship.setProperty("nodeType", "JavadocComment");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitNormalAnnotationExpr(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "NormalAnnotationExpr");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( NormalAnnotationExpr arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("NormalAnnotationExpr"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("NormalAnnotationExpr"));
       	relationship.setProperty("nodeType", "NormalAnnotationExpr");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitNameExpr(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "NameExpr");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( NameExpr arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("NameExpr"));
       node.setProperty("name",arg0.getName());
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("NameExpr"));
       	relationship.setProperty("nodeType", "NameExpr");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitMethodDeclaration(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "MethodDeclaration");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( MethodDeclaration arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("MethodDeclaration"));
       node.setProperty("name",arg0.getName());
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("MethodDeclaration"));
       	relationship.setProperty("nodeType", "MethodDeclaration");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitMethodCallExpr(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "MethodCallExpr");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( MethodCallExpr arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("MethodCallExpr"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("MethodCallExpr"));
       	relationship.setProperty("nodeType", "MethodCallExpr");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitMemberValuePair(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "MemberValuePair");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( MemberValuePair arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("MemberValuePair"));
       node.setProperty("name",arg0.getName());
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("MemberValuePair"));
       	relationship.setProperty("nodeType", "MemberValuePair");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitVariableDeclaratorId(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "VariableDeclaratorId");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( VariableDeclaratorId arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("VariableDeclaratorId"));
       node.setProperty("name",arg0.getName());
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("VariableDeclaratorId"));
       	relationship.setProperty("nodeType", "VariableDeclaratorId");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitVariableDeclarator(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "VariableDeclarator");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( VariableDeclarator arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("VariableDeclarator"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("VariableDeclarator"));
       	relationship.setProperty("nodeType", "VariableDeclarator");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitVariableDeclarationExpr(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "VariableDeclarationExpr");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( VariableDeclarationExpr arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("VariableDeclarationExpr"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("VariableDeclarationExpr"));
       	relationship.setProperty("nodeType", "VariableDeclarationExpr");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitUnknownType(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "UnknownType");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( UnknownType arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("UnknownType"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("UnknownType"));
       	relationship.setProperty("nodeType", "UnknownType");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitUnaryExpr(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "UnaryExpr");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( UnaryExpr arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("UnaryExpr"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("UnaryExpr"));
       	relationship.setProperty("nodeType", "UnaryExpr");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitTypeParameter(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "TypeParameter");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( TypeParameter arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("TypeParameter"));
       node.setProperty("name",arg0.getName());
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("TypeParameter"));
       	relationship.setProperty("nodeType", "TypeParameter");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitMethodReferenceExpr(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "MethodReferenceExpr");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( MethodReferenceExpr arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("MethodReferenceExpr"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("MethodReferenceExpr"));
       	relationship.setProperty("nodeType", "MethodReferenceExpr");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitLambdaExpr(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "LambdaExpr");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( LambdaExpr arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("LambdaExpr"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("LambdaExpr"));
       	relationship.setProperty("nodeType", "LambdaExpr");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitWildcardType(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "WildcardType");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( WildcardType arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("WildcardType"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("WildcardType"));
       	relationship.setProperty("nodeType", "WildcardType");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitWhileStmt(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "WhileStmt");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( WhileStmt arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("WhileStmt"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("WhileStmt"));
       	relationship.setProperty("nodeType", "WhileStmt");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitVoidType(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "VoidType");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( VoidType arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("VoidType"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("VoidType"));
       	relationship.setProperty("nodeType", "VoidType");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitSwitchStmt(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "SwitchStmt");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( SwitchStmt arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("SwitchStmt"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("SwitchStmt"));
       	relationship.setProperty("nodeType", "SwitchStmt");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitSwitchEntryStmt(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "SwitchEntryStmt");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( SwitchEntryStmt arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("SwitchEntryStmt"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("SwitchEntryStmt"));
       	relationship.setProperty("nodeType", "SwitchEntryStmt");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitSuperExpr(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "SuperExpr");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( SuperExpr arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("SuperExpr"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("SuperExpr"));
       	relationship.setProperty("nodeType", "SuperExpr");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitStringLiteralExpr(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "StringLiteralExpr");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( StringLiteralExpr arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("StringLiteralExpr"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("StringLiteralExpr"));
       	relationship.setProperty("nodeType", "StringLiteralExpr");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitSingleMemberAnnotationExpr(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "SingleMemberAnnotationExpr");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( SingleMemberAnnotationExpr arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("SingleMemberAnnotationExpr"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("SingleMemberAnnotationExpr"));
       	relationship.setProperty("nodeType", "SingleMemberAnnotationExpr");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitTypeDeclarationStmt(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "TypeDeclarationStmt");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( TypeDeclarationStmt arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("TypeDeclarationStmt"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("TypeDeclarationStmt"));
       	relationship.setProperty("nodeType", "TypeDeclarationStmt");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitTryStmt(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "TryStmt");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( TryStmt arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("TryStmt"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("TryStmt"));
       	relationship.setProperty("nodeType", "TryStmt");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitThrowStmt(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "ThrowStmt");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( ThrowStmt arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("ThrowStmt"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("ThrowStmt"));
       	relationship.setProperty("nodeType", "ThrowStmt");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitThisExpr(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "ThisExpr");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( ThisExpr arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("ThisExpr"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("ThisExpr"));
       	relationship.setProperty("nodeType", "ThisExpr");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitSynchronizedStmt(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "SynchronizedStmt");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( SynchronizedStmt arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("SynchronizedStmt"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("SynchronizedStmt"));
       	relationship.setProperty("nodeType", "SynchronizedStmt");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitClassExpr(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "ClassExpr");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( ClassExpr arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("ClassExpr"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("ClassExpr"));
       	relationship.setProperty("nodeType", "ClassExpr");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitCharLiteralExpr(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "CharLiteralExpr");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( CharLiteralExpr arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("CharLiteralExpr"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("CharLiteralExpr"));
       	relationship.setProperty("nodeType", "CharLiteralExpr");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitCatchClause(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "CatchClause");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( CatchClause arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("CatchClause"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("CatchClause"));
       	relationship.setProperty("nodeType", "CatchClause");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitCastExpr(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "CastExpr");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( CastExpr arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("CastExpr"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("CastExpr"));
       	relationship.setProperty("nodeType", "CastExpr");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitBreakStmt(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "BreakStmt");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( BreakStmt arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("BreakStmt"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("BreakStmt"));
       	relationship.setProperty("nodeType", "BreakStmt");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitBooleanLiteralExpr(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "BooleanLiteralExpr");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( BooleanLiteralExpr arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("BooleanLiteralExpr"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("BooleanLiteralExpr"));
       	relationship.setProperty("nodeType", "BooleanLiteralExpr");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitConstructorDeclaration(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "ConstructorDeclaration");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( ConstructorDeclaration arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("ConstructorDeclaration"));
       node.setProperty("name",arg0.getName());
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("ConstructorDeclaration"));
       	relationship.setProperty("nodeType", "ConstructorDeclaration");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitConditionalExpr(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "ConditionalExpr");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( ConditionalExpr arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("ConditionalExpr"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("ConditionalExpr"));
       	relationship.setProperty("nodeType", "ConditionalExpr");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitCompilationUnit(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "CompilationUnit");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( CompilationUnit arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("CompilationUnit"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("CompilationUnit"));
       	relationship.setProperty("nodeType", "CompilationUnit");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitClassOrInterfaceType(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "ClassOrInterfaceType");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( ClassOrInterfaceType arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("ClassOrInterfaceType"));
       node.setProperty("name",arg0.getName());
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("ClassOrInterfaceType"));
       	relationship.setProperty("nodeType", "ClassOrInterfaceType");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitClassOrInterfaceDeclaration(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "ClassOrInterfaceDeclaration");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( ClassOrInterfaceDeclaration arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("ClassOrInterfaceDeclaration"));
       node.setProperty("name",arg0.getName());
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("ClassOrInterfaceDeclaration"));
       	relationship.setProperty("nodeType", "ClassOrInterfaceDeclaration");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitArrayInitializerExpr(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "ArrayInitializerExpr");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( ArrayInitializerExpr arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("ArrayInitializerExpr"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("ArrayInitializerExpr"));
       	relationship.setProperty("nodeType", "ArrayInitializerExpr");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitArrayCreationExpr(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "ArrayCreationExpr");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( ArrayCreationExpr arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("ArrayCreationExpr"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("ArrayCreationExpr"));
       	relationship.setProperty("nodeType", "ArrayCreationExpr");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitArrayAccessExpr(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "ArrayAccessExpr");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( ArrayAccessExpr arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("ArrayAccessExpr"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("ArrayAccessExpr"));
       	relationship.setProperty("nodeType", "ArrayAccessExpr");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitAnnotationMemberDeclaration(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "AnnotationMemberDeclaration");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( AnnotationMemberDeclaration arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("AnnotationMemberDeclaration"));
       node.setProperty("name",arg0.getName());
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("AnnotationMemberDeclaration"));
       	relationship.setProperty("nodeType", "AnnotationMemberDeclaration");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitAnnotationDeclaration(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "AnnotationDeclaration");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( AnnotationDeclaration arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("AnnotationDeclaration"));
       node.setProperty("name",arg0.getName());
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("AnnotationDeclaration"));
       	relationship.setProperty("nodeType", "AnnotationDeclaration");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitLabeledStmt(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "LabeledStmt");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( LabeledStmt arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("LabeledStmt"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("LabeledStmt"));
       	relationship.setProperty("nodeType", "LabeledStmt");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitBlockStmt(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "BlockStmt");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( BlockStmt arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("BlockStmt"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("BlockStmt"));
       	relationship.setProperty("nodeType", "BlockStmt");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitBlockComment(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "BlockComment");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( BlockComment arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("BlockComment"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("BlockComment"));
       	relationship.setProperty("nodeType", "BlockComment");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitBinaryExpr(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "BinaryExpr");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( BinaryExpr arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("BinaryExpr"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("BinaryExpr"));
       	relationship.setProperty("nodeType", "BinaryExpr");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitAssignExpr(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "AssignExpr");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( AssignExpr arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("AssignExpr"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("AssignExpr"));
       	relationship.setProperty("nodeType", "AssignExpr");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitAssertStmt(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "AssertStmt");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( AssertStmt arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("AssertStmt"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("AssertStmt"));
       	relationship.setProperty("nodeType", "AssertStmt");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitIfStmt(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "IfStmt");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( IfStmt arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("IfStmt"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("IfStmt"));
       	relationship.setProperty("nodeType", "IfStmt");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitForStmt(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "ForStmt");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( ForStmt arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("ForStmt"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("ForStmt"));
       	relationship.setProperty("nodeType", "ForStmt");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitForeachStmt(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "ForeachStmt");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( ForeachStmt arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("ForeachStmt"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("ForeachStmt"));
       	relationship.setProperty("nodeType", "ForeachStmt");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitFieldDeclaration(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "FieldDeclaration");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( FieldDeclaration arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("FieldDeclaration"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("FieldDeclaration"));
       	relationship.setProperty("nodeType", "FieldDeclaration");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitFieldAccessExpr(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "FieldAccessExpr");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( FieldAccessExpr arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("FieldAccessExpr"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("FieldAccessExpr"));
       	relationship.setProperty("nodeType", "FieldAccessExpr");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitExpressionStmt(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "ExpressionStmt");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( ExpressionStmt arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("ExpressionStmt"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("ExpressionStmt"));
       	relationship.setProperty("nodeType", "ExpressionStmt");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitIntegerLiteralMinValueExpr(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "IntegerLiteralMinValueExpr");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( IntegerLiteralMinValueExpr arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("IntegerLiteralMinValueExpr"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("IntegerLiteralMinValueExpr"));
       	relationship.setProperty("nodeType", "IntegerLiteralMinValueExpr");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitIntegerLiteralExpr(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "IntegerLiteralExpr");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( IntegerLiteralExpr arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("IntegerLiteralExpr"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("IntegerLiteralExpr"));
       	relationship.setProperty("nodeType", "IntegerLiteralExpr");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitInstanceOfExpr(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "InstanceOfExpr");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( InstanceOfExpr arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("InstanceOfExpr"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("InstanceOfExpr"));
       	relationship.setProperty("nodeType", "InstanceOfExpr");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitInitializerDeclaration(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "InitializerDeclaration");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( InitializerDeclaration arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("InitializerDeclaration"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("InitializerDeclaration"));
       	relationship.setProperty("nodeType", "InitializerDeclaration");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitImportDeclaration(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "ImportDeclaration");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( ImportDeclaration arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("ImportDeclaration"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("ImportDeclaration"));
       	relationship.setProperty("nodeType", "ImportDeclaration");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitEmptyStmt(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "EmptyStmt");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( EmptyStmt arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("EmptyStmt"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("EmptyStmt"));
       	relationship.setProperty("nodeType", "EmptyStmt");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitEmptyMemberDeclaration(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "EmptyMemberDeclaration");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( EmptyMemberDeclaration arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("EmptyMemberDeclaration"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("EmptyMemberDeclaration"));
       	relationship.setProperty("nodeType", "EmptyMemberDeclaration");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitDoubleLiteralExpr(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "DoubleLiteralExpr");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( DoubleLiteralExpr arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("DoubleLiteralExpr"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("DoubleLiteralExpr"));
       	relationship.setProperty("nodeType", "DoubleLiteralExpr");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitDoStmt(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "DoStmt");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( DoStmt arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("DoStmt"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("DoStmt"));
       	relationship.setProperty("nodeType", "DoStmt");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitContinueStmt(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "ContinueStmt");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( ContinueStmt arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("ContinueStmt"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("ContinueStmt"));
       	relationship.setProperty("nodeType", "ContinueStmt");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitExplicitConstructorInvocationStmt(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "ExplicitConstructorInvocationStmt");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( ExplicitConstructorInvocationStmt arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("ExplicitConstructorInvocationStmt"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("ExplicitConstructorInvocationStmt"));
       	relationship.setProperty("nodeType", "ExplicitConstructorInvocationStmt");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitEnumDeclaration(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "EnumDeclaration");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( EnumDeclaration arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("EnumDeclaration"));
       node.setProperty("name",arg0.getName());
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("EnumDeclaration"));
       	relationship.setProperty("nodeType", "EnumDeclaration");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitEnumConstantDeclaration(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "EnumConstantDeclaration");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( EnumConstantDeclaration arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("EnumConstantDeclaration"));
       node.setProperty("name",arg0.getName());
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("EnumConstantDeclaration"));
       	relationship.setProperty("nodeType", "EnumConstantDeclaration");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitEnclosedExpr(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "EnclosedExpr");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( EnclosedExpr arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("EnclosedExpr"));
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("EnclosedExpr"));
       	relationship.setProperty("nodeType", "EnclosedExpr");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 

   public void visitEmptyTypeDeclaration(org.neo4j.graphdb.Node node) {
   	System.out.println(node.hasProperty("name") ? node.getProperty("name").toString() : "EmptyTypeDeclaration");
   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);
   }

   @Override
   public void visit( EmptyTypeDeclaration arg0,  Object arg) {
       org.neo4j.graphdb.Node node = graph.createNode(Label.label("EmptyTypeDeclaration"));
       node.setProperty("name",arg0.getName());
       if(!nodes.isEmpty()) {
       	final Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName("EmptyTypeDeclaration"));
       	relationship.setProperty("nodeType", "EmptyTypeDeclaration");
       }
       nodes.push(node);
       super.visit(arg0, arg);
       nodes.pop();
   } 
   public void visit( Relationship relationship,  org.neo4j.graphdb.Node node) {
       final String nodeType = relationship.getProperty("nodeType").toString();
        switch(nodeType) { 
       case "PrimitiveType": visitPrimitiveType(BaseDomainVisitor.other(node, relationship)); break;
       case "MultiTypeParameter": visitMultiTypeParameter(BaseDomainVisitor.other(node, relationship)); break;
       case "Parameter": visitParameter(BaseDomainVisitor.other(node, relationship)); break;
       case "PackageDeclaration": visitPackageDeclaration(BaseDomainVisitor.other(node, relationship)); break;
       case "ObjectCreationExpr": visitObjectCreationExpr(BaseDomainVisitor.other(node, relationship)); break;
       case "NullLiteralExpr": visitNullLiteralExpr(BaseDomainVisitor.other(node, relationship)); break;
       case "ReturnStmt": visitReturnStmt(BaseDomainVisitor.other(node, relationship)); break;
       case "UnionType": visitUnionType(BaseDomainVisitor.other(node, relationship)); break;
       case "IntersectionType": visitIntersectionType(BaseDomainVisitor.other(node, relationship)); break;
       case "ReferenceType": visitReferenceType(BaseDomainVisitor.other(node, relationship)); break;
       case "QualifiedNameExpr": visitQualifiedNameExpr(BaseDomainVisitor.other(node, relationship)); break;
       case "MarkerAnnotationExpr": visitMarkerAnnotationExpr(BaseDomainVisitor.other(node, relationship)); break;
       case "LongLiteralMinValueExpr": visitLongLiteralMinValueExpr(BaseDomainVisitor.other(node, relationship)); break;
       case "LongLiteralExpr": visitLongLiteralExpr(BaseDomainVisitor.other(node, relationship)); break;
       case "LineComment": visitLineComment(BaseDomainVisitor.other(node, relationship)); break;
       case "TypeExpr": visitTypeExpr(BaseDomainVisitor.other(node, relationship)); break;
       case "JavadocComment": visitJavadocComment(BaseDomainVisitor.other(node, relationship)); break;
       case "NormalAnnotationExpr": visitNormalAnnotationExpr(BaseDomainVisitor.other(node, relationship)); break;
       case "NameExpr": visitNameExpr(BaseDomainVisitor.other(node, relationship)); break;
       case "MethodDeclaration": visitMethodDeclaration(BaseDomainVisitor.other(node, relationship)); break;
       case "MethodCallExpr": visitMethodCallExpr(BaseDomainVisitor.other(node, relationship)); break;
       case "MemberValuePair": visitMemberValuePair(BaseDomainVisitor.other(node, relationship)); break;
       case "VariableDeclaratorId": visitVariableDeclaratorId(BaseDomainVisitor.other(node, relationship)); break;
       case "VariableDeclarator": visitVariableDeclarator(BaseDomainVisitor.other(node, relationship)); break;
       case "VariableDeclarationExpr": visitVariableDeclarationExpr(BaseDomainVisitor.other(node, relationship)); break;
       case "UnknownType": visitUnknownType(BaseDomainVisitor.other(node, relationship)); break;
       case "UnaryExpr": visitUnaryExpr(BaseDomainVisitor.other(node, relationship)); break;
       case "TypeParameter": visitTypeParameter(BaseDomainVisitor.other(node, relationship)); break;
       case "MethodReferenceExpr": visitMethodReferenceExpr(BaseDomainVisitor.other(node, relationship)); break;
       case "LambdaExpr": visitLambdaExpr(BaseDomainVisitor.other(node, relationship)); break;
       case "WildcardType": visitWildcardType(BaseDomainVisitor.other(node, relationship)); break;
       case "WhileStmt": visitWhileStmt(BaseDomainVisitor.other(node, relationship)); break;
       case "VoidType": visitVoidType(BaseDomainVisitor.other(node, relationship)); break;
       case "SwitchStmt": visitSwitchStmt(BaseDomainVisitor.other(node, relationship)); break;
       case "SwitchEntryStmt": visitSwitchEntryStmt(BaseDomainVisitor.other(node, relationship)); break;
       case "SuperExpr": visitSuperExpr(BaseDomainVisitor.other(node, relationship)); break;
       case "StringLiteralExpr": visitStringLiteralExpr(BaseDomainVisitor.other(node, relationship)); break;
       case "SingleMemberAnnotationExpr": visitSingleMemberAnnotationExpr(BaseDomainVisitor.other(node, relationship)); break;
       case "TypeDeclarationStmt": visitTypeDeclarationStmt(BaseDomainVisitor.other(node, relationship)); break;
       case "TryStmt": visitTryStmt(BaseDomainVisitor.other(node, relationship)); break;
       case "ThrowStmt": visitThrowStmt(BaseDomainVisitor.other(node, relationship)); break;
       case "ThisExpr": visitThisExpr(BaseDomainVisitor.other(node, relationship)); break;
       case "SynchronizedStmt": visitSynchronizedStmt(BaseDomainVisitor.other(node, relationship)); break;
       case "ClassExpr": visitClassExpr(BaseDomainVisitor.other(node, relationship)); break;
       case "CharLiteralExpr": visitCharLiteralExpr(BaseDomainVisitor.other(node, relationship)); break;
       case "CatchClause": visitCatchClause(BaseDomainVisitor.other(node, relationship)); break;
       case "CastExpr": visitCastExpr(BaseDomainVisitor.other(node, relationship)); break;
       case "BreakStmt": visitBreakStmt(BaseDomainVisitor.other(node, relationship)); break;
       case "BooleanLiteralExpr": visitBooleanLiteralExpr(BaseDomainVisitor.other(node, relationship)); break;
       case "ConstructorDeclaration": visitConstructorDeclaration(BaseDomainVisitor.other(node, relationship)); break;
       case "ConditionalExpr": visitConditionalExpr(BaseDomainVisitor.other(node, relationship)); break;
       case "CompilationUnit": visitCompilationUnit(BaseDomainVisitor.other(node, relationship)); break;
       case "ClassOrInterfaceType": visitClassOrInterfaceType(BaseDomainVisitor.other(node, relationship)); break;
       case "ClassOrInterfaceDeclaration": visitClassOrInterfaceDeclaration(BaseDomainVisitor.other(node, relationship)); break;
       case "ArrayInitializerExpr": visitArrayInitializerExpr(BaseDomainVisitor.other(node, relationship)); break;
       case "ArrayCreationExpr": visitArrayCreationExpr(BaseDomainVisitor.other(node, relationship)); break;
       case "ArrayAccessExpr": visitArrayAccessExpr(BaseDomainVisitor.other(node, relationship)); break;
       case "AnnotationMemberDeclaration": visitAnnotationMemberDeclaration(BaseDomainVisitor.other(node, relationship)); break;
       case "AnnotationDeclaration": visitAnnotationDeclaration(BaseDomainVisitor.other(node, relationship)); break;
       case "LabeledStmt": visitLabeledStmt(BaseDomainVisitor.other(node, relationship)); break;
       case "BlockStmt": visitBlockStmt(BaseDomainVisitor.other(node, relationship)); break;
       case "BlockComment": visitBlockComment(BaseDomainVisitor.other(node, relationship)); break;
       case "BinaryExpr": visitBinaryExpr(BaseDomainVisitor.other(node, relationship)); break;
       case "AssignExpr": visitAssignExpr(BaseDomainVisitor.other(node, relationship)); break;
       case "AssertStmt": visitAssertStmt(BaseDomainVisitor.other(node, relationship)); break;
       case "IfStmt": visitIfStmt(BaseDomainVisitor.other(node, relationship)); break;
       case "ForStmt": visitForStmt(BaseDomainVisitor.other(node, relationship)); break;
       case "ForeachStmt": visitForeachStmt(BaseDomainVisitor.other(node, relationship)); break;
       case "FieldDeclaration": visitFieldDeclaration(BaseDomainVisitor.other(node, relationship)); break;
       case "FieldAccessExpr": visitFieldAccessExpr(BaseDomainVisitor.other(node, relationship)); break;
       case "ExpressionStmt": visitExpressionStmt(BaseDomainVisitor.other(node, relationship)); break;
       case "IntegerLiteralMinValueExpr": visitIntegerLiteralMinValueExpr(BaseDomainVisitor.other(node, relationship)); break;
       case "IntegerLiteralExpr": visitIntegerLiteralExpr(BaseDomainVisitor.other(node, relationship)); break;
       case "InstanceOfExpr": visitInstanceOfExpr(BaseDomainVisitor.other(node, relationship)); break;
       case "InitializerDeclaration": visitInitializerDeclaration(BaseDomainVisitor.other(node, relationship)); break;
       case "ImportDeclaration": visitImportDeclaration(BaseDomainVisitor.other(node, relationship)); break;
       case "EmptyStmt": visitEmptyStmt(BaseDomainVisitor.other(node, relationship)); break;
       case "EmptyMemberDeclaration": visitEmptyMemberDeclaration(BaseDomainVisitor.other(node, relationship)); break;
       case "DoubleLiteralExpr": visitDoubleLiteralExpr(BaseDomainVisitor.other(node, relationship)); break;
       case "DoStmt": visitDoStmt(BaseDomainVisitor.other(node, relationship)); break;
       case "ContinueStmt": visitContinueStmt(BaseDomainVisitor.other(node, relationship)); break;
       case "ExplicitConstructorInvocationStmt": visitExplicitConstructorInvocationStmt(BaseDomainVisitor.other(node, relationship)); break;
       case "EnumDeclaration": visitEnumDeclaration(BaseDomainVisitor.other(node, relationship)); break;
       case "EnumConstantDeclaration": visitEnumConstantDeclaration(BaseDomainVisitor.other(node, relationship)); break;
       case "EnclosedExpr": visitEnclosedExpr(BaseDomainVisitor.other(node, relationship)); break;
       case "EmptyTypeDeclaration": visitEmptyTypeDeclaration(BaseDomainVisitor.other(node, relationship)); break;
       }
   } 

}