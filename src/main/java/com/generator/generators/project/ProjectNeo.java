package com.generator.generators.project;

import org.neo4j.graphdb.*;

import java.util.UUID;
import java.util.function.Consumer;

import static com.generator.editors.BaseDomainVisitor.*;
import static com.generator.generators.project.ProjectNeo.ProjectLabels.*;

/**
 * Wraps Neo4j methods based on 'Project.stg' file <br/>
 * 
 * todo: refactor to static methods (no need for node-encapsulation, just let clients get the NeoNodes, but static treatment of each node as a specific type
 */
public final class ProjectNeo {

	private final GraphDatabaseService graph;

	public enum ProjectLabels implements Label {
		Project,   	
		Project_aspect,
		Project_bugfix,
		Project_project,
		Project_stringValue,
		Project_writeFile, 
		StringNode
	}

   public ProjectNeo(final GraphDatabaseService graph) {
 		this.graph = graph;
	}

   public static boolean isAspect(Node node) {
   	return node != null && node.hasLabel(Project_aspect);
   }

   public static aspectNode newAspect(Node node) {
   	return new aspectNode(node);
   }

   public aspectNode newAspect() {
   	return new aspectNode(graph);
   }

   public ResourceIterator<aspectNode> findAllAspect() { 
   	return graph.findNodes(Project_aspect).map(ProjectNeo::newAspect);
   } 

   public static boolean isBugfix(Node node) {
   	return node != null && node.hasLabel(Project_bugfix);
   }

   public static bugfixNode newBugfix(Node node) {
   	return new bugfixNode(node);
   }

   public bugfixNode newBugfix() {
   	return new bugfixNode(graph);
   }

   public ResourceIterator<bugfixNode> findAllBugfix() { 
   	return graph.findNodes(Project_bugfix).map(ProjectNeo::newBugfix);
   } 

   public static boolean isProject(Node node) {
   	return node != null && node.hasLabel(Project_project);
   }

   public static projectNode newProject(Node node) {
   	return new projectNode(node);
   }

   public projectNode newProject() {
   	return new projectNode(graph);
   }

   public ResourceIterator<projectNode> findAllProject() { 
   	return graph.findNodes(Project_project).map(ProjectNeo::newProject);
   } 

   public static boolean isStringValue(Node node) {
   	return node != null && node.hasLabel(Project_stringValue);
   }

   public static stringValueNode newStringValue(Node node) {
   	return new stringValueNode(node);
   }

   public stringValueNode newStringValue() {
   	return new stringValueNode(graph);
   }

   public ResourceIterator<stringValueNode> findAllStringValue() { 
   	return graph.findNodes(Project_stringValue).map(ProjectNeo::newStringValue);
   } 

   public static boolean isWriteFile(Node node) {
   	return node != null && node.hasLabel(Project_writeFile);
   }

   public static writeFileNode newWriteFile(Node node) {
   	return new writeFileNode(node);
   }

   public writeFileNode newWriteFile() {
   	return new writeFileNode(graph);
   }

   public ResourceIterator<writeFileNode> findAllWriteFile() { 
   	return graph.findNodes(Project_writeFile).map(ProjectNeo::newWriteFile);
   } 

	public static final class aspectNode {

		// Project
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			name_param, tasks_param
		}


		private enum KeyValueLabels implements Label {
		}

		private aspectNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(Project_aspect);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private aspectNode(final Node node) {
			// assuming node has label Project_aspect
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException(toString() + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
			tryToDeleteNode(node);
		}	

		public Node node() {
			return node;
		}

		public UUID getUuid() {
			return uuid;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			aspectNode that = (aspectNode) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return uuid.hashCode();
		}

		@Override
		public String toString() {
			return getClass().getName() + "  " + uuid;
		}

	   // name
	   public aspectNode setName(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.name_param))
	   		singleOutgoing(node, Parameters.name_param).delete();
	   	node.createRelationshipTo(target, Parameters.name_param);
	      return this;
	   }

	   public Node getName() {
	   	if (!hasOutgoing(node, Parameters.name_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.name_param);
	   	return other(node, relationship);
	   }

	   public void removeName() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.name_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // tasks
	   public aspectNode addTasksValue(Node target) {
	   	if (node == null) return this;
	   	if (isAlreadyRelated(node, target, Parameters.tasks_param)) return this;
	   	node.createRelationshipTo(target, Parameters.tasks_param);
	      return this;
	   }

	   public void forEachTasks(Consumer<Node> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.tasks_param))
	   		consumer.accept(other(node, relationship));
	   } 

		public interface aspectNodeVisitor<T> {

			T visit(aspectNode node);	

		}

		public <T> T visit(aspectNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class bugfixNode {

		// Project
	   private final Node node;
		private final UUID uuid;

		private bugfixNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(Project_bugfix);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private bugfixNode(final Node node) {
			// assuming node has label Project_bugfix
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException(toString() + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
			tryToDeleteNode(node);
		}	

		public Node node() {
			return node;
		}

		public UUID getUuid() {
			return uuid;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			bugfixNode that = (bugfixNode) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return uuid.hashCode();
		}

		@Override
		public String toString() {
			return getClass().getName() + "  " + uuid;
		}


		public interface bugfixNodeVisitor<T> {

			T visit(bugfixNode node);	

		}

		public <T> T visit(bugfixNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class projectNode {

		// Project
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			aspects_param, comments_param, groups_param, name_param, packageName_param, roots_param
		}

		private enum GroupsRelationships implements RelationshipType {
			name, packageName, path, reference
		} 
		private enum RootsRelationships implements RelationshipType {
			path, reference
		} 

		private enum KeyValueLabels implements Label {
			Groups, Roots, 
		}

		private projectNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(Project_project);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private projectNode(final Node node) {
			// assuming node has label Project_project
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException(toString() + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
			tryToDeleteNode(node);
		}	

		public Node node() {
			return node;
		}

		public UUID getUuid() {
			return uuid;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			projectNode that = (projectNode) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return uuid.hashCode();
		}

		@Override
		public String toString() {
			return getClass().getName() + "  " + uuid;
		}

	   // aspects
	   public projectNode addAspectsValue(Node target) {
	   	if (node == null) return this;
	   	if (isAlreadyRelated(node, target, Parameters.aspects_param)) return this;
	   	node.createRelationshipTo(target, Parameters.aspects_param);
	      return this;
	   }

	   public void forEachAspects(Consumer<Node> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.aspects_param))
	   		consumer.accept(other(node, relationship));
	   } 

	   // comments
	   public projectNode setComments(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.comments_param))
	   		singleOutgoing(node, Parameters.comments_param).delete();
	   	node.createRelationshipTo(target, Parameters.comments_param);
	      return this;
	   }

	   public Node getComments() {
	   	if (!hasOutgoing(node, Parameters.comments_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.comments_param);
	   	return other(node, relationship);
	   }

	   public void removeComments() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.comments_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   public interface GroupsKeyValue {

	   	public Node getNameValue();

	   	public Node getPackageNameValue();

	   	public Node getPathValue();

	   	public Node getReferenceValue();

	   	public GroupsKeyValue setNameValue(Node value);

	   	public GroupsKeyValue setPackageNameValue(Node value);

	   	public GroupsKeyValue setPathValue(Node value);

	   	public GroupsKeyValue setReferenceValue(Node value);

	   	public Node node();

	   	public UUID getUuid();
	   }

	   public projectNode addGroupsValue(GroupsKeyValue value) {
	   	this.node.createRelationshipTo(value.node(), Parameters.groups_param);
	      return this;
	   }

	   public GroupsKeyValue newGroupsKeyValue(GraphDatabaseService graph) {
	   	final Node node = graph.createNode(KeyValueLabels.Groups);
	   	node.setProperty("_uuid", UUID.randomUUID().toString());
	   	return newGroupsKeyValue(node);
	   }

	   public static GroupsKeyValue newGroupsKeyValue(Node node) {
	   	if (node==null) throw new IllegalArgumentException("node for newGroupsKeyValue cannot be null");

	   	final UUID uuid = UUID.fromString(getString(node, "_uuid"));

	   	return new GroupsKeyValue() {

	   		@Override
	   		public Node getNameValue() {
	   			if (!hasOutgoing(node, GroupsRelationships.name)) return null;
	   			return other(node, singleOutgoing(node, GroupsRelationships.name));
	   		} 

	   		@Override
	   		public GroupsKeyValue setNameValue(Node value) {
	   			if (hasOutgoing(node, GroupsRelationships.name)) {
	   				final Relationship outgoing = singleOutgoing(node, GroupsRelationships.name);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, GroupsRelationships.name);

	   			return this;
	   		} 

	   		@Override
	   		public Node getPackageNameValue() {
	   			if (!hasOutgoing(node, GroupsRelationships.packageName)) return null;
	   			return other(node, singleOutgoing(node, GroupsRelationships.packageName));
	   		} 

	   		@Override
	   		public GroupsKeyValue setPackageNameValue(Node value) {
	   			if (hasOutgoing(node, GroupsRelationships.packageName)) {
	   				final Relationship outgoing = singleOutgoing(node, GroupsRelationships.packageName);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, GroupsRelationships.packageName);

	   			return this;
	   		} 

	   		@Override
	   		public Node getPathValue() {
	   			if (!hasOutgoing(node, GroupsRelationships.path)) return null;
	   			return other(node, singleOutgoing(node, GroupsRelationships.path));
	   		} 

	   		@Override
	   		public GroupsKeyValue setPathValue(Node value) {
	   			if (hasOutgoing(node, GroupsRelationships.path)) {
	   				final Relationship outgoing = singleOutgoing(node, GroupsRelationships.path);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, GroupsRelationships.path);

	   			return this;
	   		} 

	   		@Override
	   		public Node getReferenceValue() {
	   			if (!hasOutgoing(node, GroupsRelationships.reference)) return null;
	   			return other(node, singleOutgoing(node, GroupsRelationships.reference));
	   		} 

	   		@Override
	   		public GroupsKeyValue setReferenceValue(Node value) {
	   			if (hasOutgoing(node, GroupsRelationships.reference)) {
	   				final Relationship outgoing = singleOutgoing(node, GroupsRelationships.reference);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, GroupsRelationships.reference);

	   			return this;
	   		} 

	   		@Override
	   		public Node node() {
	   			return node;
	   		}

	   		@Override
	   		public UUID getUuid() {
	   			return uuid;
	   		}

	   		@Override
	   		public boolean equals(Object o) {
	   			if (this == o) return true;
	   			if (o == null || getClass() != o.getClass()) return false;
	   			StringNode that = (StringNode) o;
	   			return uuid.equals(that.getUuid());
	   		}

	   		@Override
	   		public int hashCode() {
	   			return uuid.hashCode();
	   		}
	   	};
	   }

	   public void forEachGroupsValue(Consumer<GroupsKeyValue> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.groups_param)) {
	   		consumer.accept(newGroupsKeyValue(other(node, relationship)));
	   	}
	   } 

	   // name
	   public projectNode setName(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.name_param))
	   		singleOutgoing(node, Parameters.name_param).delete();
	   	node.createRelationshipTo(target, Parameters.name_param);
	      return this;
	   }

	   public Node getName() {
	   	if (!hasOutgoing(node, Parameters.name_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.name_param);
	   	return other(node, relationship);
	   }

	   public void removeName() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.name_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // packageName
	   public projectNode setPackageName(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.packageName_param))
	   		singleOutgoing(node, Parameters.packageName_param).delete();
	   	node.createRelationshipTo(target, Parameters.packageName_param);
	      return this;
	   }

	   public Node getPackageName() {
	   	if (!hasOutgoing(node, Parameters.packageName_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.packageName_param);
	   	return other(node, relationship);
	   }

	   public void removePackageName() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.packageName_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   public interface RootsKeyValue {

	   	public Node getPathValue();

	   	public Node getReferenceValue();

	   	public RootsKeyValue setPathValue(Node value);

	   	public RootsKeyValue setReferenceValue(Node value);

	   	public Node node();

	   	public UUID getUuid();
	   }

	   public projectNode addRootsValue(RootsKeyValue value) {
	   	this.node.createRelationshipTo(value.node(), Parameters.roots_param);
	      return this;
	   }

	   public RootsKeyValue newRootsKeyValue(GraphDatabaseService graph) {
	   	final Node node = graph.createNode(KeyValueLabels.Roots);
	   	node.setProperty("_uuid", UUID.randomUUID().toString());
	   	return newRootsKeyValue(node);
	   }

	   public static RootsKeyValue newRootsKeyValue(Node node) {
	   	if (node==null) throw new IllegalArgumentException("node for newRootsKeyValue cannot be null");

	   	final UUID uuid = UUID.fromString(getString(node, "_uuid"));

	   	return new RootsKeyValue() {

	   		@Override
	   		public Node getPathValue() {
	   			if (!hasOutgoing(node, RootsRelationships.path)) return null;
	   			return other(node, singleOutgoing(node, RootsRelationships.path));
	   		} 

	   		@Override
	   		public RootsKeyValue setPathValue(Node value) {
	   			if (hasOutgoing(node, RootsRelationships.path)) {
	   				final Relationship outgoing = singleOutgoing(node, RootsRelationships.path);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, RootsRelationships.path);

	   			return this;
	   		} 

	   		@Override
	   		public Node getReferenceValue() {
	   			if (!hasOutgoing(node, RootsRelationships.reference)) return null;
	   			return other(node, singleOutgoing(node, RootsRelationships.reference));
	   		} 

	   		@Override
	   		public RootsKeyValue setReferenceValue(Node value) {
	   			if (hasOutgoing(node, RootsRelationships.reference)) {
	   				final Relationship outgoing = singleOutgoing(node, RootsRelationships.reference);
	   				final Node other = other(node, outgoing);
	   				outgoing.delete();
	   				tryToDeleteNode(other);
	   			} 

	   			if (value != null)
	   				node.createRelationshipTo(value, RootsRelationships.reference);

	   			return this;
	   		} 

	   		@Override
	   		public Node node() {
	   			return node;
	   		}

	   		@Override
	   		public UUID getUuid() {
	   			return uuid;
	   		}

	   		@Override
	   		public boolean equals(Object o) {
	   			if (this == o) return true;
	   			if (o == null || getClass() != o.getClass()) return false;
	   			StringNode that = (StringNode) o;
	   			return uuid.equals(that.getUuid());
	   		}

	   		@Override
	   		public int hashCode() {
	   			return uuid.hashCode();
	   		}
	   	};
	   }

	   public void forEachRootsValue(Consumer<RootsKeyValue> consumer) {
	   	for (Relationship relationship : node.getRelationships(Direction.OUTGOING, Parameters.roots_param)) {
	   		consumer.accept(newRootsKeyValue(other(node, relationship)));
	   	}
	   } 

		public interface projectNodeVisitor<T> {

			T visit(projectNode node);	

		}

		public <T> T visit(projectNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class stringValueNode {

		// Project
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			value_param
		}


		private enum KeyValueLabels implements Label {
		}

		private stringValueNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(Project_stringValue);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private stringValueNode(final Node node) {
			// assuming node has label Project_stringValue
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException(toString() + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
			tryToDeleteNode(node);
		}	

		public Node node() {
			return node;
		}

		public UUID getUuid() {
			return uuid;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			stringValueNode that = (stringValueNode) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return uuid.hashCode();
		}

		@Override
		public String toString() {
			return getClass().getName() + "  " + uuid;
		}

	   // value
	   public stringValueNode setValue(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.value_param))
	   		singleOutgoing(node, Parameters.value_param).delete();
	   	node.createRelationshipTo(target, Parameters.value_param);
	      return this;
	   }

	   public Node getValue() {
	   	if (!hasOutgoing(node, Parameters.value_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.value_param);
	   	return other(node, relationship);
	   }

	   public void removeValue() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.value_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

		public interface stringValueNodeVisitor<T> {

			T visit(stringValueNode node);	

		}

		public <T> T visit(stringValueNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public static final class writeFileNode {

		// Project
	   private final Node node;
		private final UUID uuid;

		private enum Parameters implements RelationshipType {
			comment_param, content_param, dir_param, filetype_param, name_param
		}


		private enum KeyValueLabels implements Label {
		}

		private writeFileNode(final GraphDatabaseService graph) {
			this.node = graph.createNode(Project_writeFile);
			this.node.setProperty("_uuid", UUID.randomUUID().toString());
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		private writeFileNode(final Node node) {
			// assuming node has label Project_writeFile
			this.node = node;
			this.uuid = UUID.fromString(getString(node, "_uuid"));
		}

		public void delete() throws IllegalStateException {
			if (node.hasRelationship(Direction.INCOMING))
				throw new IllegalStateException(toString() + " has " + node.getDegree(Direction.INCOMING) + " dependent incoming relations. Delete these first.");
			tryToDeleteNode(node);
		}	

		public Node node() {
			return node;
		}

		public UUID getUuid() {
			return uuid;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			writeFileNode that = (writeFileNode) o;
			return uuid.equals(that.uuid);
		}

		@Override
		public int hashCode() {
			return uuid.hashCode();
		}

		@Override
		public String toString() {
			return getClass().getName() + "  " + uuid;
		}

	   // comment
	   public writeFileNode setComment(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.comment_param))
	   		singleOutgoing(node, Parameters.comment_param).delete();
	   	node.createRelationshipTo(target, Parameters.comment_param);
	      return this;
	   }

	   public Node getComment() {
	   	if (!hasOutgoing(node, Parameters.comment_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.comment_param);
	   	return other(node, relationship);
	   }

	   public void removeComment() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.comment_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // content
	   public writeFileNode setContent(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.content_param))
	   		singleOutgoing(node, Parameters.content_param).delete();
	   	node.createRelationshipTo(target, Parameters.content_param);
	      return this;
	   }

	   public Node getContent() {
	   	if (!hasOutgoing(node, Parameters.content_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.content_param);
	   	return other(node, relationship);
	   }

	   public void removeContent() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.content_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // dir
	   public writeFileNode setDir(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.dir_param))
	   		singleOutgoing(node, Parameters.dir_param).delete();
	   	node.createRelationshipTo(target, Parameters.dir_param);
	      return this;
	   }

	   public Node getDir() {
	   	if (!hasOutgoing(node, Parameters.dir_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.dir_param);
	   	return other(node, relationship);
	   }

	   public void removeDir() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.dir_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // filetype
	   public writeFileNode setFiletype(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.filetype_param))
	   		singleOutgoing(node, Parameters.filetype_param).delete();
	   	node.createRelationshipTo(target, Parameters.filetype_param);
	      return this;
	   }

	   public Node getFiletype() {
	   	if (!hasOutgoing(node, Parameters.filetype_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.filetype_param);
	   	return other(node, relationship);
	   }

	   public void removeFiletype() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.filetype_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

	   // name
	   public writeFileNode setName(Node target) {
	   	if (node == null) return this;
	   	if (hasOutgoing(node, Parameters.name_param))
	   		singleOutgoing(node, Parameters.name_param).delete();
	   	node.createRelationshipTo(target, Parameters.name_param);
	      return this;
	   }

	   public Node getName() {
	   	if (!hasOutgoing(node, Parameters.name_param)) return null;
	   	final Relationship relationship = singleOutgoing(node, Parameters.name_param);
	   	return other(node, relationship);
	   }

	   public void removeName() {
	   	final Relationship outgoing = singleOutgoing(node, Parameters.name_param);
	   	if (outgoing == null) return;
	   	final Node other = other(node, outgoing);
	   	outgoing.delete();
	   	tryToDeleteNode(other);
	   } 

		public interface writeFileNodeVisitor<T> {

			T visit(writeFileNode node);	

		}

		public <T> T visit(writeFileNodeVisitor<T> visitor) {
			return visitor.visit(this);
		}
	} 

	public interface ProjectNeoAction {

		void doAction(Transaction tx) throws Throwable;

		void exception(Throwable throwable);
	}

	public void doInTransaction(ProjectNeoAction committer) {
		try (Transaction tx = graph.beginTx()) {
			try {
				committer.doAction(tx);
				tx.success();
			} catch (Throwable throwable) {
				committer.exception(throwable);
				tx.failure();
			}
		}
	}

	public static boolean isStringNode(Node node) {
		return node != null && node.hasLabel(StringNode);
	}

	// convenience-method for instantiating a new StringNode, and setting the value
	public Node newStringNode(String value) {
		if (value==null) throw new IllegalArgumentException("value for newStringNode cannot be null");

		final Node node = graph.createNode(StringNode);
		node.setProperty("_uuid", UUID.randomUUID().toString());
		return newStringNode(node).setValue(value).node();
	}

	public static StringNode newStringNode(Node node) {

		//if (node==null) throw new IllegalArgumentException("node for newStringNode cannot be null");
		if (node==null) return null;

		final UUID uuid = UUID.fromString(getString(node, "_uuid"));

		return new StringNode() {
			@Override
			public StringNode setValue(String value) {
				node.setProperty("value", value);
				return this;
			}

			@Override
			public String getValue() {
				return getString(node, "value");
			}

			@Override
			public Node node() {
				return node;
			}

			@Override
			public UUID getUuid() {
				return uuid;
			}

			@Override
			public boolean equals(Object o) {
				if (this == o) return true;
				if (o == null || getClass() != o.getClass()) return false;
				StringNode that = (StringNode) o;
				return uuid.equals(that.getUuid());
			}

			@Override
			public int hashCode() {
				return uuid.hashCode();
			}

			@Override
			public String toString() {
				return getValue();
			}	
		};
	}

	public interface StringNode {

		public StringNode setValue(String value);

		public String getValue();

		public Node node();

		public UUID getUuid();
	} 
} 