package com.generator.generators.java;

import org.neo4j.graphdb.*;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * 
 */
public class JavaCypher {

	public static JClassMatcher newJClassMatcher() {
		return new JClassMatcher();
	}

	public static JClassMatcher newJClassMatcher(String id) {
		return new JClassMatcher(id);
	}

	public static final class JClassMatcher extends NodeMatcher {

	   private JClassMatcher() {
	      super("jClass", "JClass");
	   }

	   private JClassMatcher(String id) {
	   	super(id, "JClass");
	   }

	   public JClassMatcher matchScope(String scope) {
	      properties.put("scope", scope);
	   	return this;
		}

		public JClassMatcher returnScope() {
	      returnValues.add(id + "." + "scope");
	   	return this;
		}

	   public JClassMatcher matchName(String name) {
	      properties.put("name", name);
	   	return this;
		}

		public JClassMatcher returnName() {
	      returnValues.add(id + "." + "name");
	   	return this;
		}


		public JClassMatcher returnNode() {
		   returnValues.add(id);
			return this;
		}

		public JClassMatcher returnExpression(String expression) {
			returnValues.add(expression);
		   return this;
		}
	}

	public static JFieldMatcher newJFieldMatcher() {
		return new JFieldMatcher();
	}

	public static JFieldMatcher newJFieldMatcher(String id) {
		return new JFieldMatcher(id);
	}

	public static final class JFieldMatcher extends NodeMatcher {

	   private JFieldMatcher() {
	      super("jField", "JField");
	   }

	   private JFieldMatcher(String id) {
	   	super(id, "JField");
	   }

	   public JFieldMatcher matchName(String name) {
	      properties.put("name", name);
	   	return this;
		}

		public JFieldMatcher returnName() {
	      returnValues.add(id + "." + "name");
	   	return this;
		}

	   public JFieldMatcher matchScope(String scope) {
	      properties.put("scope", scope);
	   	return this;
		}

		public JFieldMatcher returnScope() {
	      returnValues.add(id + "." + "scope");
	   	return this;
		}


		public JFieldMatcher returnNode() {
		   returnValues.add(id);
			return this;
		}

		public JFieldMatcher returnExpression(String expression) {
			returnValues.add(expression);
		   return this;
		}
	}

	public static JPackageMatcher newJPackageMatcher() {
		return new JPackageMatcher();
	}

	public static JPackageMatcher newJPackageMatcher(String id) {
		return new JPackageMatcher(id);
	}

	public static final class JPackageMatcher extends NodeMatcher {

	   private JPackageMatcher() {
	      super("jPackage", "JPackage");
	   }

	   private JPackageMatcher(String id) {
	   	super(id, "JPackage");
	   }

	   public JPackageMatcher matchName(String name) {
	      properties.put("name", name);
	   	return this;
		}

		public JPackageMatcher returnName() {
	      returnValues.add(id + "." + "name");
	   	return this;
		}


		public JPackageMatcher returnNode() {
		   returnValues.add(id);
			return this;
		}

		public JPackageMatcher returnExpression(String expression) {
			returnValues.add(expression);
		   return this;
		}
	}

	public static JClass_FIELDS_JFieldMatcher newJClass_FIELDS_JFieldMatcher() {
		return new JClass_FIELDS_JFieldMatcher();
	}

	public static JField_FIELDS_JClassMatcher newJField_FIELDS_JClassMatcher() {
		return new JField_FIELDS_JClassMatcher();
	}

	public static final class JClass_FIELDS_JFieldMatcher extends RelationMatcher {

	   private JClass_FIELDS_JFieldMatcher() {
	      super("FIELDS");
	      this.srcRel = "-";
	      this.dstRel = "->";
	   }


	   public JClass_FIELDS_JFieldMatcher setJClassMatcher(Matcher jClassMatcher) {
	      this.src = jClassMatcher.toString();
			this.returnValues.addAll(jClassMatcher.returnValues());
	      return this;
	   }

	   public JClass_FIELDS_JFieldMatcher setJFieldMatcher(Matcher jFieldMatcher) {
	      this.dst = jFieldMatcher.toString();
			this.returnValues.addAll(jFieldMatcher.returnValues());
	      return this;
	   }
	}

	public static final class JField_FIELDS_JClassMatcher extends RelationMatcher {

	   private JField_FIELDS_JClassMatcher() {
	      super("FIELDS");
	      this.srcRel = "<-";
	      this.dstRel = "-";
	   }


	   public JField_FIELDS_JClassMatcher setJFieldMatcher(Matcher jFieldMatcher) {
	      this.src = jFieldMatcher.toString();
			this.returnValues.addAll(jFieldMatcher.returnValues());
	      return this;
	   }

	   public JField_FIELDS_JClassMatcher setJClassMatcher(Matcher jClassMatcher) {
	      this.dst = jClassMatcher.toString();
			this.returnValues.addAll(jClassMatcher.returnValues());
	      return this;
	   }
	}

	public static JPackageSrc_PARENT_JPackageDstMatcher newJPackageSrc_PARENT_JPackageDstMatcher() {
		return new JPackageSrc_PARENT_JPackageDstMatcher();
	}

	public static JPackageDst_PARENT_JPackageSrcMatcher newJPackageDst_PARENT_JPackageSrcMatcher() {
		return new JPackageDst_PARENT_JPackageSrcMatcher();
	}

	public static final class JPackageSrc_PARENT_JPackageDstMatcher extends RelationMatcher {

	   private JPackageSrc_PARENT_JPackageDstMatcher() {
	      super("PARENT");
	      this.srcRel = "-";
	      this.dstRel = "->";
	   }


	   public JPackageSrc_PARENT_JPackageDstMatcher setJPackageSrcMatcher(Matcher jPackageSrcMatcher) {
	      this.src = jPackageSrcMatcher.toString();
			this.returnValues.addAll(jPackageSrcMatcher.returnValues());
	      return this;
	   }

	   public JPackageSrc_PARENT_JPackageDstMatcher setJPackageDstMatcher(Matcher jPackageDstMatcher) {
	      this.dst = jPackageDstMatcher.toString();
			this.returnValues.addAll(jPackageDstMatcher.returnValues());
	      return this;
	   }
	}

	public static final class JPackageDst_PARENT_JPackageSrcMatcher extends RelationMatcher {

	   private JPackageDst_PARENT_JPackageSrcMatcher() {
	      super("PARENT");
	      this.srcRel = "<-";
	      this.dstRel = "-";
	   }


	   public JPackageDst_PARENT_JPackageSrcMatcher setJPackageDstMatcher(Matcher jPackageDstMatcher) {
	      this.src = jPackageDstMatcher.toString();
			this.returnValues.addAll(jPackageDstMatcher.returnValues());
	      return this;
	   }

	   public JPackageDst_PARENT_JPackageSrcMatcher setJPackageSrcMatcher(Matcher jPackageSrcMatcher) {
	      this.dst = jPackageSrcMatcher.toString();
			this.returnValues.addAll(jPackageSrcMatcher.returnValues());
	      return this;
	   }
	}

	public static JPackage_CLASSES_JClassMatcher newJPackage_CLASSES_JClassMatcher() {
		return new JPackage_CLASSES_JClassMatcher();
	}

	public static JClass_CLASSES_JPackageMatcher newJClass_CLASSES_JPackageMatcher() {
		return new JClass_CLASSES_JPackageMatcher();
	}

	public static final class JPackage_CLASSES_JClassMatcher extends RelationMatcher {

	   private JPackage_CLASSES_JClassMatcher() {
	      super("CLASSES");
	      this.srcRel = "-";
	      this.dstRel = "->";
	   }


	   public JPackage_CLASSES_JClassMatcher setJPackageMatcher(Matcher jPackageMatcher) {
	      this.src = jPackageMatcher.toString();
			this.returnValues.addAll(jPackageMatcher.returnValues());
	      return this;
	   }

	   public JPackage_CLASSES_JClassMatcher setJClassMatcher(Matcher jClassMatcher) {
	      this.dst = jClassMatcher.toString();
			this.returnValues.addAll(jClassMatcher.returnValues());
	      return this;
	   }
	}

	public static final class JClass_CLASSES_JPackageMatcher extends RelationMatcher {

	   private JClass_CLASSES_JPackageMatcher() {
	      super("CLASSES");
	      this.srcRel = "<-";
	      this.dstRel = "-";
	   }


	   public JClass_CLASSES_JPackageMatcher setJClassMatcher(Matcher jClassMatcher) {
	      this.src = jClassMatcher.toString();
			this.returnValues.addAll(jClassMatcher.returnValues());
	      return this;
	   }

	   public JClass_CLASSES_JPackageMatcher setJPackageMatcher(Matcher jPackageMatcher) {
	      this.dst = jPackageMatcher.toString();
			this.returnValues.addAll(jPackageMatcher.returnValues());
	      return this;
	   }
	}

	public static Long getLong(String name, Map<String, Object> map) {
      return (Long) map.get(name);
   }

   public static String getString(String name, Map<String, Object> map) {
      return (String) map.get(name);
   }

   public static Integer getInteger(String name, Map<String, Object> map) {
      return (Integer) map.get(name);
   }

	public static Number getNumber(String name, Map<String, Object> map) {
      return (Number) map.get(name);
   }

	public static abstract class CypherQuery {

      public abstract String query();

      public abstract Map<String, Object> params();
   }

	public interface CypherConsumer {

      /**
       * @return true if stop iteration
       */
      boolean handle(Map<String,Object> element);
   }

	public static void execute(GraphDatabaseService db, String cypher, CypherConsumer consumer) {
      final Result result = db.execute(cypher);
      while (result.hasNext()) {
         if (consumer.handle(result.next())) {
            result.close();
            return;
         }
      }
      result.close();
   }

	public static void execute(GraphDatabaseService db, String cypher, Map<String,Object> params, CypherConsumer consumer) {
      final Result result = db.execute(cypher, params);
      while (result.hasNext()) {
         if (consumer.handle(result.next())) {
            result.close();
            return;
         }
      }
      result.close();
   }

	public static void execute(GraphDatabaseService db, CypherQuery query, CypherConsumer consumer) {
      execute(db, query.query(), query.params(), consumer);
   }

	public interface Matcher {

		Set<String> returnValues();
	}

	public static EmptyMatcher newEmptyMatcher(final String id) {
      return new EmptyMatcher(id);
   }

   public static final class EmptyMatcher extends NodeMatcher {

      private EmptyMatcher(String id) {
         super(id, null);
      }

      public EmptyMatcher returnNode() {
         returnValues.add(id);
         return this;
      }

      public EmptyMatcher returnExpression(String expression) {
         returnValues.add(expression);
         return this;
      }
   }

	public static OrRelationMatcher newOrRelationMatcher(String... types) {
      final StringBuilder params = new StringBuilder();
      boolean first = true;
      for (String type : types) {
         if (!first) params.append("|");
         params.append(type);
         first = false;
      }
      return new OrRelationMatcher(params.toString());
   }

   public static final class OrRelationMatcher extends RelationMatcher {

      private OrRelationMatcher(String type) {
         super(type);
      }

      public OrRelationMatcher srcRel(String srcRel) {
         this.srcRel = srcRel;
         return this;
      }

      public OrRelationMatcher dstRel(String dstRel) {
         this.dstRel = dstRel;
         return this;
      }

      public OrRelationMatcher setSrcMatcher(Matcher srcMatcher) {
         this.src = srcMatcher.toString();
         this.returnValues.addAll(srcMatcher.returnValues());
         return this;
      }

      public OrRelationMatcher setDstMatcher(Matcher dstMatcher) {
         this.dst = dstMatcher.toString();
         this.returnValues.addAll(dstMatcher.returnValues());
         return this;
      }
   }

	public static class NodeMatcher implements Matcher {

      final String id;
      final String label;
      final Map<String, String> properties = new LinkedHashMap<>();
		final Set<String> returnValues = new LinkedHashSet<>();

      NodeMatcher(String id, String label) {
         this.id = id;
         this.label = label;
      }

      @Override
      public Set<String> returnValues() {
      	return returnValues;
		}

      @Override
      public String toString() {
         final StringBuilder cypher = new StringBuilder();

         cypher.append("(").append(id);

         if (label != null)
            cypher.append(":").append(label);

         if (!properties.isEmpty()) {
            cypher.append(" {");
            boolean first = true;
            for (Map.Entry<String, String> entry : properties.entrySet()) {
               if (!first) cypher.append(", ");
               cypher.append(entry.getKey()).append(":").append("$").append(entry.getValue());
               first = false;
            }
            cypher.append("}");
         }
         cypher.append(")");

         return cypher.toString();
      }
   }

   public static class RelationMatcher implements Matcher {

      final String type;
      String src;
      String srcRel;
      String dst;
      String dstRel;
      final Map<String, String> properties = new LinkedHashMap<>();
		final Set<String> returnValues = new LinkedHashSet<>();

      RelationMatcher(String type) {
         this.type = type;
      }

		@Override
      public Set<String> returnValues() {
      	return returnValues;
		}

      @Override
      public String toString() {
         final StringBuilder cypher = new StringBuilder();

         if (src != null) cypher.append(src);
         if (srcRel != null) cypher.append(srcRel);
         cypher.append("[:").append(type);

         if (!properties.isEmpty()) {
            cypher.append(" {");
            boolean first = true;
            for (Map.Entry<String, String> entry : properties.entrySet()) {
               if (!first) cypher.append(", ");
               cypher.append(entry.getKey()).append(":").append("$").append(entry.getValue());
               first = false;
            }
            cypher.append("}");
         }
         cypher.append("]");
         if (dstRel != null) cypher.append(dstRel);
         if (dst != null) cypher.append(dst);

         return cypher.toString();
      }
   }

	public static CypherMatcher newCypherMatcher(Matcher matcher) {
		return new CypherMatcher(matcher);
	}

	public static final class CypherMatcher extends CypherQuery {

      private final Matcher matcher;
      private final Set<CypherQuery> unions = new LinkedHashSet<>();
      private boolean unionAll = false;
      final Map<String, Object> parameters = new LinkedHashMap<>();
      final Set<String> where = new LinkedHashSet<>();
      final Set<String> orderBy = new LinkedHashSet<>();

      private CypherMatcher(Matcher matcher) {
         this.matcher = matcher;
      }

      public CypherMatcher addUnion(CypherQuery unionQuery) {
         this.unions.add(unionQuery);
         this.parameters.putAll(unionQuery.params());
         return this;
      }

      public CypherMatcher addUnionAll(CypherQuery unionQuery) {
         this.unions.add(unionQuery);
         this.parameters.putAll(unionQuery.params());
         this.unionAll = true;
         return this;
      }

      public CypherMatcher addParam(String name, Object value) {
         parameters.put(name, value);
         return this;
      }

      public CypherMatcher addWhere(String expression) {
         where.add(expression);
         return this;
      }

      public CypherMatcher addOrderBy(String element) {
         orderBy.add(element);
         return this;
      }

      @Override
      public String query() {
         final StringBuilder match = new StringBuilder("MATCH " + matcher + where() + returnValues());
         for (CypherQuery union : unions)
            match.append(" UNION ").append(unionAll ? "ALL " : "").append(union.query());

         boolean first = true;
         for (String element : orderBy) {
            if (first) match.append(" ORDER BY ");
            else match.append(", ");
            match.append(element);
            first = false;
         }

         return match.toString();
      }

      @Override
      public Map<String, Object> params() {
         return parameters;
      }

      private String where() {
         if (where.isEmpty()) return "";

         final StringBuilder out = new StringBuilder(" WHERE ");

         boolean first = true;
         for (String where : where) {
            if (!first) out.append(" AND ");
            out.append(where);
            first = false;
         }

         return out.toString();
      }

      private String returnValues() {
         final StringBuilder out = new StringBuilder(" return ");

         boolean first = true;
         for (String returnValue : matcher.returnValues()) {
            if (!first) out.append(", ");
            out.append(returnValue);
            first = false;
         }

         return out.toString();
      }
   }
}