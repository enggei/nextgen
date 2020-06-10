package nextgen.templates.vertx;

public enum VertxTypes {

	JsonArrayType() {
		@Override
		public String toString() { return "io.vertx.core.json.JsonArray"; }
	},
	JsonObjectType() {
		@Override
		public String toString() { return "io.vertx.core.json.JsonObject"; }
	}
}