package com.network;

import org.neo4j.graphdb.*;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * 
 */
public class NetworkTopologyCypher {

	public static HostMatcher newHostMatcher() {
		return new HostMatcher();
	}

	public static HostMatcher newHostMatcher(String id) {
		return new HostMatcher(id);
	}

	public static final class HostMatcher extends NodeMatcher {

	   private HostMatcher() {
	      super("host", "Host");
	   }

	   private HostMatcher(String id) {
	   	super(id, "Host");
	   }

	   public HostMatcher matchName(String name) {
	      properties.put("name", name);
	   	return this;
		}

		public HostMatcher returnName() {
	      returnValues.add(id + "." + "name");
	   	return this;
		}

	   public HostMatcher matchIp(String ip) {
	      properties.put("ip", ip);
	   	return this;
		}

		public HostMatcher returnIp() {
	      returnValues.add(id + "." + "ip");
	   	return this;
		}

	   public HostMatcher matchMac(String mac) {
	      properties.put("mac", mac);
	   	return this;
		}

		public HostMatcher returnMac() {
	      returnValues.add(id + "." + "mac");
	   	return this;
		}


		public HostMatcher returnNode() {
		   returnValues.add(id);
			return this;
		}

		public HostMatcher returnExpression(String expression) {
			returnValues.add(expression);
		   return this;
		}
	}

	public static PortMatcher newPortMatcher() {
		return new PortMatcher();
	}

	public static PortMatcher newPortMatcher(String id) {
		return new PortMatcher(id);
	}

	public static final class PortMatcher extends NodeMatcher {

	   private PortMatcher() {
	      super("port", "Port");
	   }

	   private PortMatcher(String id) {
	   	super(id, "Port");
	   }

	   public PortMatcher matchPort(String port) {
	      properties.put("port", port);
	   	return this;
		}

		public PortMatcher returnPort() {
	      returnValues.add(id + "." + "port");
	   	return this;
		}

	   public PortMatcher matchProtocol(String protocol) {
	      properties.put("protocol", protocol);
	   	return this;
		}

		public PortMatcher returnProtocol() {
	      returnValues.add(id + "." + "protocol");
	   	return this;
		}

	   public PortMatcher matchState(String state) {
	      properties.put("state", state);
	   	return this;
		}

		public PortMatcher returnState() {
	      returnValues.add(id + "." + "state");
	   	return this;
		}

	   public PortMatcher matchService(String service) {
	      properties.put("service", service);
	   	return this;
		}

		public PortMatcher returnService() {
	      returnValues.add(id + "." + "service");
	   	return this;
		}


		public PortMatcher returnNode() {
		   returnValues.add(id);
			return this;
		}

		public PortMatcher returnExpression(String expression) {
			returnValues.add(expression);
		   return this;
		}
	}

	public static Host_PORTS_PortMatcher newHost_PORTS_PortMatcher() {
		return new Host_PORTS_PortMatcher();
	}

	public static Port_PORTS_HostMatcher newPort_PORTS_HostMatcher() {
		return new Port_PORTS_HostMatcher();
	}

	public static final class Host_PORTS_PortMatcher extends RelationMatcher {

	   private Host_PORTS_PortMatcher() {
	      super("PORTS");
	      this.srcRel = "-";
	      this.dstRel = "->";
	   }


	   public Host_PORTS_PortMatcher setHostMatcher(Matcher hostMatcher) {
	      this.src = hostMatcher.toString();
			this.returnValues.addAll(hostMatcher.returnValues());
	      return this;
	   }

	   public Host_PORTS_PortMatcher setPortMatcher(Matcher portMatcher) {
	      this.dst = portMatcher.toString();
			this.returnValues.addAll(portMatcher.returnValues());
	      return this;
	   }
	}

	public static final class Port_PORTS_HostMatcher extends RelationMatcher {

	   private Port_PORTS_HostMatcher() {
	      super("PORTS");
	      this.srcRel = "<-";
	      this.dstRel = "-";
	   }


	   public Port_PORTS_HostMatcher setPortMatcher(Matcher portMatcher) {
	      this.src = portMatcher.toString();
			this.returnValues.addAll(portMatcher.returnValues());
	      return this;
	   }

	   public Port_PORTS_HostMatcher setHostMatcher(Matcher hostMatcher) {
	      this.dst = hostMatcher.toString();
			this.returnValues.addAll(hostMatcher.returnValues());
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
      System.out.println(cypher);
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
      System.out.println(cypher);
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

      protected final String id;
      protected final String label;
      protected final Map<String, String> properties = new LinkedHashMap<>();
		protected final Set<String> returnValues = new LinkedHashSet<>();

      public NodeMatcher(String id, String label) {
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

      protected final String type;
      protected String src;
      protected String srcRel;
      protected String dst;
      protected String dstRel;
      protected final Map<String, String> properties = new LinkedHashMap<>();
		protected final Set<String> returnValues = new LinkedHashSet<>();

      public RelationMatcher(String type) {
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
      protected final Map<String, Object> parameters = new LinkedHashMap<>();
      protected final Set<String> where = new LinkedHashSet<>();
      protected final Set<String> orderBy = new LinkedHashSet<>();

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