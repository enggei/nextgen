package com.network;


public final class NetworkTopologyPojos {


	public static Host newHost(String name,String ip,String mac) throws IllegalArgumentException {
		final Host entity = new Host().setName(name).setIp(ip).setMac(mac);
		if (!Host.isValid(entity.toJson())) throw new IllegalArgumentException(Host.getErrors(entity.toJson()).encode());
		return entity;
	}

	public static Host asHost(io.vertx.core.json.JsonObject jsonObject) throws IllegalArgumentException {
		if (!Host.isValid(jsonObject)) throw new IllegalArgumentException(Host.getErrors(jsonObject).encode());
		return new Host(jsonObject);
	}

	public static Port newPort(Integer port,String protocol,String state,String service) throws IllegalArgumentException {
		final Port entity = new Port().setPort(port).setProtocol(protocol).setState(state).setService(service);
		if (!Port.isValid(entity.toJson())) throw new IllegalArgumentException(Port.getErrors(entity.toJson()).encode());
		return entity;
	}

	public static Port asPort(io.vertx.core.json.JsonObject jsonObject) throws IllegalArgumentException {
		if (!Port.isValid(jsonObject)) throw new IllegalArgumentException(Port.getErrors(jsonObject).encode());
		return new Port(jsonObject);
	}

	public static class Host {
		private String name;
		private String ip;
		private String mac;

		public Host() {
		}

		public Host(io.vertx.core.json.JsonObject jsonObject) {
			this.name = jsonObject.getString("name");
			this.ip = jsonObject.getString("ip");
			this.mac = jsonObject.getString("mac");
	   }
		public String getName() {
			return name;
		}

		public Host setName(String name) {
	      this.name = name;
			return this;
		}

		public String getIp() {
			return ip;
		}

		public Host setIp(String ip) {
	      this.ip = ip;
			return this;
		}

		public String getMac() {
			return mac;
		}

		public Host setMac(String mac) {
	      this.mac = mac;
			return this;
		}


		public io.vertx.core.json.JsonObject toJson() {
			final io.vertx.core.json.JsonObject jsonObject = new io.vertx.core.json.JsonObject();
			jsonObject.put("name", name);
			jsonObject.put("ip", ip);
			jsonObject.put("mac", mac);;
			return jsonObject;
		}


		public static boolean isValid(io.vertx.core.json.JsonObject jsonObject) {
			if (jsonObject.getString("name") == null) return false;
			if (jsonObject.getString("ip") == null) return false;
			if (jsonObject.getString("mac") == null) return false;
	      return true;
	   }

	   public static io.vertx.core.json.JsonArray getErrors(io.vertx.core.json.JsonObject jsonObject) {
			final io.vertx.core.json.JsonArray errors = new io.vertx.core.json.JsonArray();
	      if (jsonObject.getString("name") == null) errors.add(new io.vertx.core.json.JsonObject().put("missing", "name"));
	      if (jsonObject.getString("ip") == null) errors.add(new io.vertx.core.json.JsonObject().put("missing", "ip"));
	      if (jsonObject.getString("mac") == null) errors.add(new io.vertx.core.json.JsonObject().put("missing", "mac"));
			return errors;
	   }
	}

	public static class Port {
		private Integer port;
		private String protocol;
		private String state;
		private String service;

		public Port() {
		}

		public Port(io.vertx.core.json.JsonObject jsonObject) {
			this.port = jsonObject.getInteger("port");
			this.protocol = jsonObject.getString("protocol");
			this.state = jsonObject.getString("state");
			this.service = jsonObject.getString("service");
	   }
		public Integer getPort() {
			return port;
		}

		public Port setPort(Integer port) {
	      this.port = port;
			return this;
		}

		public String getProtocol() {
			return protocol;
		}

		public Port setProtocol(String protocol) {
	      this.protocol = protocol;
			return this;
		}

		public String getState() {
			return state;
		}

		public Port setState(String state) {
	      this.state = state;
			return this;
		}

		public String getService() {
			return service;
		}

		public Port setService(String service) {
	      this.service = service;
			return this;
		}


		public io.vertx.core.json.JsonObject toJson() {
			final io.vertx.core.json.JsonObject jsonObject = new io.vertx.core.json.JsonObject();
			jsonObject.put("port", port);
			jsonObject.put("protocol", protocol);
			jsonObject.put("state", state);
			jsonObject.put("service", service);;
			return jsonObject;
		}


		public static boolean isValid(io.vertx.core.json.JsonObject jsonObject) {
			if (jsonObject.getInteger("port") == null) return false;
			if (jsonObject.getString("protocol") == null) return false;
			if (jsonObject.getString("state") == null) return false;
			if (jsonObject.getString("service") == null) return false;
	      return true;
	   }

	   public static io.vertx.core.json.JsonArray getErrors(io.vertx.core.json.JsonObject jsonObject) {
			final io.vertx.core.json.JsonArray errors = new io.vertx.core.json.JsonArray();
	      if (jsonObject.getInteger("port") == null) errors.add(new io.vertx.core.json.JsonObject().put("missing", "port"));
	      if (jsonObject.getString("protocol") == null) errors.add(new io.vertx.core.json.JsonObject().put("missing", "protocol"));
	      if (jsonObject.getString("state") == null) errors.add(new io.vertx.core.json.JsonObject().put("missing", "state"));
	      if (jsonObject.getString("service") == null) errors.add(new io.vertx.core.json.JsonObject().put("missing", "service"));
			return errors;
	   }
	}
}