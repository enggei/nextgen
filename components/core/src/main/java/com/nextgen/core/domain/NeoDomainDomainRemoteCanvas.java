package com.nextgen.core.domain;

import com.nextgen.core.JsonCanvas;
import com.nextgen.core.NodeCanvas;
import io.vertx.core.http.WebSocket;
import io.vertx.core.http.WebSocketFrame;
import org.piccolo2d.event.PInputEvent;

import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpClient;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.*;

public class NeoDomainDomainRemoteCanvas extends JsonCanvas {

	private final String uuid = UUID.randomUUID().toString();
	private final Vertx vertx;
	private final Integer port;
	private final String host;

	public NeoDomainDomainRemoteCanvas(Vertx vertx, Integer port, String host) {
		this.vertx = vertx;
		this.port = port;
		this.host = host;
	}

	@Override
	protected void addContextMenuActions(PInputEvent event, JPopupMenu pop, Set<BasePNode> selectedNodes, Point mousePosition, NodeCanvas canvas) {

		final JMenu mnuOpen = new JMenu("Open");
				// default actions 
		pop.add(new SwingAction("New NeoDomain") {
			@Override
			protected void onActionPerformed(java.awt.event.ActionEvent e) {

				final NeoDomainForm projectForm = new NeoDomainForm();
				projectForm.show(canvas, new ConfirmAction() {
					@Override
					public void verifyAndCommit() throws Exception {
						newNeoDomain(projectForm.getNeoDomain(), new NeoDomainHandler() {
							@Override
							public void onSuccess(NeoDomain project) {
								addNode(newNeoDomainNode(project.toJson()), new LayoutAtPosition(mousePosition));
							}
						});
					}
				});
			}
		});

		mnuOpen.add(new SwingAction("Open NeoDomain") {
			@Override
			protected void onActionPerformed(java.awt.event.ActionEvent e) {
				getAllNeoDomain();
			}
		});

				pop.add(mnuOpen);

		super.addContextMenuActions(event, pop, selectedNodes, mousePosition, canvas);
	}

	@Override
	protected void onKeyPressed(PInputEvent event) {

		switch (event.getKeyCode()) {
			case KeyEvent.VK_E:
				if (event.isControlDown()) {
					getAllNeoDomain();
				}
				return;

		}

		super.onKeyPressed(event);
	}

	// NODES

	public NeoDomainNode newNeoDomainNode(JsonObject jsonObject) {
		return new NeoDomainNode(jsonObject);
	}

	class NeoDomainNode extends JsonPNode {

		NeoDomainNode(JsonObject neoDomain) {
			super(neoDomain, "name", Color.decode("#3690c0"), Color.decode("#e31a1c"), Color.decode("#e31a1c"));
		}

		@Override
		protected void onRightClick(PInputEvent event, JPopupMenu pop, NodeCanvas canvas, Point mousePosition) {

			// default actions 
			pop.add(new SwingAction("Edit") {
				@Override
				protected void onActionPerformed(ActionEvent e) {

					final NeoDomainForm form = new NeoDomainForm(content());
					form.show(canvas, new ConfirmAction() {
						@Override
						public void verifyAndCommit() throws Exception {
							updateNeoDomain(form.getNeoDomain(), new NeoDomainHandler() {
								@Override
								public void onSuccess(NeoDomain updated) {
									setContent(updated.toJson());
									nodeChangeSupport.firePropertyChange(nodeEvent("content"), null, updated.toJson());
								}
							});
						}
					});
				}
			});

			// ONE 'NeoDomain' (NeoDomain) -> DOMAIN_VISITORS -> MANY 'NeoVisitor' (NeoVisitor)
			final JMenu DOMAIN_VISITORSMenu = new JMenu("DOMAIN_VISITORS");

			DOMAIN_VISITORSMenu.add(new SwingAction("Get All DOMAIN_VISITORS") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					get_NeoVisitor_DOMAIN_VISITORS_FOR_NeoDomain(getUUID(), new ExpandNeoVisitor_DOMAIN_VISITORS_FOR_NeoDomainHandler(getThis()));
				}
			});

			DOMAIN_VISITORSMenu.add(new SwingAction("Add NeoVisitor") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					add_NeoVisitor_DOMAIN_VISITORS_FOR_NeoDomain(getThis(), canvas);
				}
			});

			if (DOMAIN_VISITORSMenu.getMenuComponentCount() != 0) pop.add(DOMAIN_VISITORSMenu);


			// ONE 'NeoDomain' (NeoDomain) -> RENDERER -> MANY 'NeoDomainRenderer' (NeoDomainRenderer)
			final JMenu RENDERERMenu = new JMenu("RENDERER");

			RENDERERMenu.add(new SwingAction("Get All RENDERER") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					get_NeoDomainRenderer_RENDERER_FOR_NeoDomain(getUUID(), new ExpandNeoDomainRenderer_RENDERER_FOR_NeoDomainHandler(getThis()));
				}
			});

			RENDERERMenu.add(new SwingAction("Add NeoDomainRenderer") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					add_NeoDomainRenderer_RENDERER_FOR_NeoDomain(getThis(), canvas);
				}
			});

			if (RENDERERMenu.getMenuComponentCount() != 0) pop.add(RENDERERMenu);


			// ONE 'NeoDomain' (NeoDomain) -> ENTITIES -> MANY 'NeoEntity' (NeoEntity)
			final JMenu ENTITIESMenu = new JMenu("ENTITIES");

			ENTITIESMenu.add(new SwingAction("Get All ENTITIES") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					get_NeoEntity_ENTITIES_FOR_NeoDomain(getUUID(), new ExpandNeoEntity_ENTITIES_FOR_NeoDomainHandler(getThis()));
				}
			});

			ENTITIESMenu.add(new SwingAction("Add NeoEntity") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					add_NeoEntity_ENTITIES_FOR_NeoDomain(getThis(), canvas);
				}
			});

			if (ENTITIESMenu.getMenuComponentCount() != 0) pop.add(ENTITIESMenu);



			super.onRightClick(event, pop, canvas, mousePosition);
		}

		@Override
		protected void onKeyPressed(PInputEvent event, NodeCanvas canvas) {

			switch (event.getKeyCode()) {
				case KeyEvent.VK_E:
					// ONE 'NeoDomain' (NeoDomain) -> DOMAIN_VISITORS -> MANY 'NeoVisitor' (NeoVisitor)
					if (event.isControlDown()) get_NeoVisitor_DOMAIN_VISITORS_FOR_NeoDomain(getUUID(), new ExpandNeoVisitor_DOMAIN_VISITORS_FOR_NeoDomainHandler(getThis()));

					// ONE 'NeoDomain' (NeoDomain) -> RENDERER -> MANY 'NeoDomainRenderer' (NeoDomainRenderer)
					if (event.isControlDown()) get_NeoDomainRenderer_RENDERER_FOR_NeoDomain(getUUID(), new ExpandNeoDomainRenderer_RENDERER_FOR_NeoDomainHandler(getThis()));

					// ONE 'NeoDomain' (NeoDomain) -> ENTITIES -> MANY 'NeoEntity' (NeoEntity)
					if (event.isControlDown()) get_NeoEntity_ENTITIES_FOR_NeoDomain(getUUID(), new ExpandNeoEntity_ENTITIES_FOR_NeoDomainHandler(getThis()));

				return;
			}

			super.onKeyPressed(event, canvas);
		}
	}

	// NeoDomainDomain NeoDomain
	protected final class NeoDomainForm extends JPanel {

		private final String title = "New NeoDomain";
		private final PropertyComponent nameComponent = new PropertyComponent("String");
		private String uuid;

		protected NeoDomainForm() {
			super(new BorderLayout());
				this.uuid = null;

			int c = 1, r = 1;
			final FormPanel form = new FormPanel("100dlu,4dlu,150dlu", "pref,4dlu");
			form.addLabel(NeoDomainDomain.Properties.name.name(), c, r);
			c += 2;
			form.add(nameComponent.getComponent(), c, r);

			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			add(form.build(), BorderLayout.CENTER);
		}

		protected NeoDomainForm(JsonObject content) {
			this();
			this.uuid = content.getString("uuid");
			nameComponent.setValue(content.getValue("name"));
		}

		public PropertyComponent getNameComponent() {
			return nameComponent;
		}

		protected NeoDomainForm setNameValue(String name) {
			nameComponent.setValue(name);
			return this;
		}

		protected <T> T getNameValue() {
			return nameComponent.getValue();
		}

		@Deprecated
		protected JsonObject toJson() {
			return new JsonObject()	
				.put("name", (String) getNameValue());}

		protected NeoDomain getNeoDomain() {
			final JsonObject jsonObject = new JsonObject()
				.put("name", (String) getNameValue());
			if (uuid != null) jsonObject.put("uuid", uuid);
			return mapNeoDomain(jsonObject);
		}

		protected void show(NodeCanvas canvas, ConfirmAction confirmAction) {
			showDialog(this, canvas, title, confirmAction);
		}
	}

	public void newNeoDomain(String name, NeoDomainHandler handler) {
		final JsonObject parameters = new JsonObject().
			put("name", name);
		newNeoDomain(mapNeoDomain(parameters), handler);
	}

	void newNeoDomain(NeoDomain parameters, NeoDomainHandler handler) {
		send("neoDomainDomain.new.neoDomain", new JsonObject().put("NeoDomain", parameters.toJson()), handler);
	}


	public NeoDomain newNeoDomain(String name) {
		return newNeoDomain(new JsonObject().
			put("name", name));
	}

	public NeoDomain newNeoDomain(JsonObject parameters) {
		return mapNeoDomain(parameters);
	}

	public void updateNeoDomain(NeoDomain neoDomain, NeoDomainHandler handler) {
		send("neoDomainDomain.update.neoDomain", new JsonObject().put("uuid", neoDomain.getUUID().toString()).put("NeoDomain", neoDomain.toJson()), handler);
	}

	public void deleteNeoDomain(UUID uuid,  DeleteHandler handler) {
		send("neoDomainDomain.delete.neoDomain", new JsonObject().put("uuid", uuid.toString()), handler);
	}

	public void getNeoDomain(UUID uuid, NeoDomainHandler handler) {
		send("neoDomainDomain.get.neoDomain", new JsonObject().put("uuid", uuid.toString()), handler);
	}

	public void getAllNeoDomain(NeoDomainListHandler handler) {
		send("neoDomainDomain.get.all.neoDomain", new JsonObject(), handler);
	}

	public static abstract class NeoDomainListHandler extends ListHandler<NeoDomain> {

		@Override
		protected NeoDomain map(JsonObject jsonObject) {
			return mapNeoDomain(jsonObject);
		}
	}

	public static abstract class NeoDomainHandler extends MessageHandler {

		public abstract void onSuccess(NeoDomain neoDomain);

		@Override
		protected void handleSuccess(JsonObject payload) {
			onSuccess(mapNeoDomain(payload));
		}
	}

	interface NeoDomain {

		enum Properties {
			name
		}


		UUID getUUID();

		JsonObject toJson();

		String getName();

		NeoDomain setName(String name);

	}

	private static NeoDomain mapNeoDomain(JsonObject payload) {
		return new NeoDomain() {

			@Override
			public UUID getUUID() {
				return UUID.fromString(payload.getString("uuid"));
			}
					@Override
			public JsonObject toJson() {
				return payload;
			}

			@Override
			public String toString() {
				return payload.encode();
			}

			@Override
			public String getName() {
				return payload.getString("name");
			}

			@Override
			public NeoDomain setName(String name) {
				payload.put("name", name);
				return this;
			}

		};
	}

	protected void getAllNeoDomain() {
		getAllNeoDomain(new NeoDomainListHandler() {
			@Override
			public void onSuccess(java.util.Iterator<NeoDomain> it) {
				final Set<BasePNode> nodes = new LinkedHashSet<>();
				while (it.hasNext()) nodes.add(newNeoDomainNode(it.next().toJson()));
				addNodes(nodes, new LayoutRelativeTo(getMousePosition() == null ? getCenterPosition() : getMousePosition()));
			}
		});
	}


	public NeoVisitorNode newNeoVisitorNode(JsonObject jsonObject) {
		return new NeoVisitorNode(jsonObject);
	}

	class NeoVisitorNode extends JsonPNode {

		NeoVisitorNode(JsonObject neoVisitor) {
			super(neoVisitor, "name", Color.decode("#238b45"), Color.decode("#8c2d04"), Color.decode("#fdbb84"));
		}

		@Override
		protected void onRightClick(PInputEvent event, JPopupMenu pop, NodeCanvas canvas, Point mousePosition) {

			// default actions 
			pop.add(new SwingAction("Edit") {
				@Override
				protected void onActionPerformed(ActionEvent e) {

					final NeoVisitorForm form = new NeoVisitorForm(content());
					form.show(canvas, new ConfirmAction() {
						@Override
						public void verifyAndCommit() throws Exception {
							updateNeoVisitor(form.getNeoVisitor(), new NeoVisitorHandler() {
								@Override
								public void onSuccess(NeoVisitor updated) {
									setContent(updated.toJson());
									nodeChangeSupport.firePropertyChange(nodeEvent("content"), null, updated.toJson());
								}
							});
						}
					});
				}
			});

			// ONE 'NeoVisitor' (NeoVisitor) -> VISITOR_PARAMETERS -> MANY 'VisitorParameter' (VisitorParameter)
			final JMenu VISITOR_PARAMETERSMenu = new JMenu("VISITOR_PARAMETERS");

			VISITOR_PARAMETERSMenu.add(new SwingAction("Get All VISITOR_PARAMETERS") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					get_VisitorParameter_VISITOR_PARAMETERS_FOR_NeoVisitor(getUUID(), new ExpandVisitorParameter_VISITOR_PARAMETERS_FOR_NeoVisitorHandler(getThis()));
				}
			});

			VISITOR_PARAMETERSMenu.add(new SwingAction("Add VisitorParameter") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					add_VisitorParameter_VISITOR_PARAMETERS_FOR_NeoVisitor(getThis(), canvas);
				}
			});

			if (VISITOR_PARAMETERSMenu.getMenuComponentCount() != 0) pop.add(VISITOR_PARAMETERSMenu);



			super.onRightClick(event, pop, canvas, mousePosition);
		}

		@Override
		protected void onKeyPressed(PInputEvent event, NodeCanvas canvas) {

			switch (event.getKeyCode()) {
				case KeyEvent.VK_E:
					// ONE 'NeoVisitor' (NeoVisitor) -> VISITOR_PARAMETERS -> MANY 'VisitorParameter' (VisitorParameter)
					if (event.isControlDown()) get_VisitorParameter_VISITOR_PARAMETERS_FOR_NeoVisitor(getUUID(), new ExpandVisitorParameter_VISITOR_PARAMETERS_FOR_NeoVisitorHandler(getThis()));

				return;
			}

			super.onKeyPressed(event, canvas);
		}
	}

	// NeoDomainDomain NeoVisitor
	protected final class NeoVisitorForm extends JPanel {

		private final String title = "New NeoVisitor";
		private final PropertyComponent nameComponent = new PropertyComponent("String");
		private String uuid;

		protected NeoVisitorForm() {
			super(new BorderLayout());
				this.uuid = null;

			int c = 1, r = 1;
			final FormPanel form = new FormPanel("100dlu,4dlu,150dlu", "pref,4dlu");
			form.addLabel(NeoDomainDomain.Properties.name.name(), c, r);
			c += 2;
			form.add(nameComponent.getComponent(), c, r);

			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			add(form.build(), BorderLayout.CENTER);
		}

		protected NeoVisitorForm(JsonObject content) {
			this();
			this.uuid = content.getString("uuid");
			nameComponent.setValue(content.getValue("name"));
		}

		public PropertyComponent getNameComponent() {
			return nameComponent;
		}

		protected NeoVisitorForm setNameValue(String name) {
			nameComponent.setValue(name);
			return this;
		}

		protected <T> T getNameValue() {
			return nameComponent.getValue();
		}

		@Deprecated
		protected JsonObject toJson() {
			return new JsonObject()	
				.put("name", (String) getNameValue());}

		protected NeoVisitor getNeoVisitor() {
			final JsonObject jsonObject = new JsonObject()
				.put("name", (String) getNameValue());
			if (uuid != null) jsonObject.put("uuid", uuid);
			return mapNeoVisitor(jsonObject);
		}

		protected void show(NodeCanvas canvas, ConfirmAction confirmAction) {
			showDialog(this, canvas, title, confirmAction);
		}
	}

	public NeoVisitor newNeoVisitor(String name) {
		return newNeoVisitor(new JsonObject().
			put("name", name));
	}

	public NeoVisitor newNeoVisitor(JsonObject parameters) {
		return mapNeoVisitor(parameters);
	}

	public void updateNeoVisitor(NeoVisitor neoVisitor, NeoVisitorHandler handler) {
		send("neoDomainDomain.update.neoVisitor", new JsonObject().put("uuid", neoVisitor.getUUID().toString()).put("NeoVisitor", neoVisitor.toJson()), handler);
	}

	public void deleteNeoVisitor(UUID uuid,  DeleteHandler handler) {
		send("neoDomainDomain.delete.neoVisitor", new JsonObject().put("uuid", uuid.toString()), handler);
	}

	public void getNeoVisitor(UUID uuid, NeoVisitorHandler handler) {
		send("neoDomainDomain.get.neoVisitor", new JsonObject().put("uuid", uuid.toString()), handler);
	}

	public void getAllNeoVisitor(NeoVisitorListHandler handler) {
		send("neoDomainDomain.get.all.neoVisitor", new JsonObject(), handler);
	}

	public static abstract class NeoVisitorListHandler extends ListHandler<NeoVisitor> {

		@Override
		protected NeoVisitor map(JsonObject jsonObject) {
			return mapNeoVisitor(jsonObject);
		}
	}

	public static abstract class NeoVisitorHandler extends MessageHandler {

		public abstract void onSuccess(NeoVisitor neoVisitor);

		@Override
		protected void handleSuccess(JsonObject payload) {
			onSuccess(mapNeoVisitor(payload));
		}
	}

	interface NeoVisitor {

		enum Properties {
			name
		}


		UUID getUUID();

		JsonObject toJson();

		String getName();

		NeoVisitor setName(String name);

	}

	private static NeoVisitor mapNeoVisitor(JsonObject payload) {
		return new NeoVisitor() {

			@Override
			public UUID getUUID() {
				return UUID.fromString(payload.getString("uuid"));
			}
					@Override
			public JsonObject toJson() {
				return payload;
			}

			@Override
			public String toString() {
				return payload.encode();
			}

			@Override
			public String getName() {
				return payload.getString("name");
			}

			@Override
			public NeoVisitor setName(String name) {
				payload.put("name", name);
				return this;
			}

		};
	}

	protected void getAllNeoVisitor() {
		getAllNeoVisitor(new NeoVisitorListHandler() {
			@Override
			public void onSuccess(java.util.Iterator<NeoVisitor> it) {
				final Set<BasePNode> nodes = new LinkedHashSet<>();
				while (it.hasNext()) nodes.add(newNeoVisitorNode(it.next().toJson()));
				addNodes(nodes, new LayoutRelativeTo(getMousePosition() == null ? getCenterPosition() : getMousePosition()));
			}
		});
	}


	public VisitorParameterNode newVisitorParameterNode(JsonObject jsonObject) {
		return new VisitorParameterNode(jsonObject);
	}

	class VisitorParameterNode extends JsonPNode {

		VisitorParameterNode(JsonObject visitorParameter) {
			super(visitorParameter, "name", Color.decode("#084594"), Color.decode("#8c2d04"), Color.decode("#d7301f"));
		}

		@Override
		protected void onRightClick(PInputEvent event, JPopupMenu pop, NodeCanvas canvas, Point mousePosition) {

			// default actions 
			pop.add(new SwingAction("Edit") {
				@Override
				protected void onActionPerformed(ActionEvent e) {

					final VisitorParameterForm form = new VisitorParameterForm(content());
					form.show(canvas, new ConfirmAction() {
						@Override
						public void verifyAndCommit() throws Exception {
							updateVisitorParameter(form.getVisitorParameter(), new VisitorParameterHandler() {
								@Override
								public void onSuccess(VisitorParameter updated) {
									setContent(updated.toJson());
									nodeChangeSupport.firePropertyChange(nodeEvent("content"), null, updated.toJson());
								}
							});
						}
					});
				}
			});


			super.onRightClick(event, pop, canvas, mousePosition);
		}

		@Override
		protected void onKeyPressed(PInputEvent event, NodeCanvas canvas) {

			switch (event.getKeyCode()) {
				case KeyEvent.VK_E:
				return;
			}

			super.onKeyPressed(event, canvas);
		}
	}

	// NeoDomainDomain VisitorParameter
	protected final class VisitorParameterForm extends JPanel {

		private final String title = "New VisitorParameter";
		private final PropertyComponent typeComponent = new PropertyComponent("String");
		private final PropertyComponent nameComponent = new PropertyComponent("String");
		private String uuid;

		protected VisitorParameterForm() {
			super(new BorderLayout());
				this.uuid = null;

			int c = 1, r = 1;
			final FormPanel form = new FormPanel("100dlu,4dlu,150dlu", "pref,4dlu,pref,4dlu");
			form.addLabel(NeoDomainDomain.Properties.type.name(), c, r);
			c += 2;
			form.add(typeComponent.getComponent(), c, r);

			r +=2;
			c = 1;
			form.addLabel(NeoDomainDomain.Properties.name.name(), c, r);
			c += 2;
			form.add(nameComponent.getComponent(), c, r);

			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			add(form.build(), BorderLayout.CENTER);
		}

		protected VisitorParameterForm(JsonObject content) {
			this();
			this.uuid = content.getString("uuid");
			typeComponent.setValue(content.getValue("type"));
			nameComponent.setValue(content.getValue("name"));
		}

		public PropertyComponent getTypeComponent() {
			return typeComponent;
		}

		protected VisitorParameterForm setTypeValue(String type) {
			typeComponent.setValue(type);
			return this;
		}

		protected <T> T getTypeValue() {
			return typeComponent.getValue();
		}


		public PropertyComponent getNameComponent() {
			return nameComponent;
		}

		protected VisitorParameterForm setNameValue(String name) {
			nameComponent.setValue(name);
			return this;
		}

		protected <T> T getNameValue() {
			return nameComponent.getValue();
		}

		@Deprecated
		protected JsonObject toJson() {
			return new JsonObject()	
				.put("type", (String) getTypeValue())
				.put("name", (String) getNameValue());}

		protected VisitorParameter getVisitorParameter() {
			final JsonObject jsonObject = new JsonObject()
				.put("type", (String) getTypeValue())
				.put("name", (String) getNameValue());
			if (uuid != null) jsonObject.put("uuid", uuid);
			return mapVisitorParameter(jsonObject);
		}

		protected void show(NodeCanvas canvas, ConfirmAction confirmAction) {
			showDialog(this, canvas, title, confirmAction);
		}
	}

	public VisitorParameter newVisitorParameter(String type, String name) {
		return newVisitorParameter(new JsonObject().
			put("type", type).
			put("name", name));
	}

	public VisitorParameter newVisitorParameter(JsonObject parameters) {
		return mapVisitorParameter(parameters);
	}

	public void updateVisitorParameter(VisitorParameter visitorParameter, VisitorParameterHandler handler) {
		send("neoDomainDomain.update.visitorParameter", new JsonObject().put("uuid", visitorParameter.getUUID().toString()).put("VisitorParameter", visitorParameter.toJson()), handler);
	}

	public void deleteVisitorParameter(UUID uuid,  DeleteHandler handler) {
		send("neoDomainDomain.delete.visitorParameter", new JsonObject().put("uuid", uuid.toString()), handler);
	}

	public void getVisitorParameter(UUID uuid, VisitorParameterHandler handler) {
		send("neoDomainDomain.get.visitorParameter", new JsonObject().put("uuid", uuid.toString()), handler);
	}

	public void getAllVisitorParameter(VisitorParameterListHandler handler) {
		send("neoDomainDomain.get.all.visitorParameter", new JsonObject(), handler);
	}

	public static abstract class VisitorParameterListHandler extends ListHandler<VisitorParameter> {

		@Override
		protected VisitorParameter map(JsonObject jsonObject) {
			return mapVisitorParameter(jsonObject);
		}
	}

	public static abstract class VisitorParameterHandler extends MessageHandler {

		public abstract void onSuccess(VisitorParameter visitorParameter);

		@Override
		protected void handleSuccess(JsonObject payload) {
			onSuccess(mapVisitorParameter(payload));
		}
	}

	interface VisitorParameter {

		enum Properties {
			type,
			name
		}


		UUID getUUID();

		JsonObject toJson();

		String getType();

		VisitorParameter setType(String type);

		String getName();

		VisitorParameter setName(String name);

	}

	private static VisitorParameter mapVisitorParameter(JsonObject payload) {
		return new VisitorParameter() {

			@Override
			public UUID getUUID() {
				return UUID.fromString(payload.getString("uuid"));
			}
					@Override
			public JsonObject toJson() {
				return payload;
			}

			@Override
			public String toString() {
				return payload.encode();
			}

			@Override
			public String getType() {
				return payload.getString("type");
			}

			@Override
			public VisitorParameter setType(String type) {
				payload.put("type", type);
				return this;
			}

			@Override
			public String getName() {
				return payload.getString("name");
			}

			@Override
			public VisitorParameter setName(String name) {
				payload.put("name", name);
				return this;
			}

		};
	}

	protected void getAllVisitorParameter() {
		getAllVisitorParameter(new VisitorParameterListHandler() {
			@Override
			public void onSuccess(java.util.Iterator<VisitorParameter> it) {
				final Set<BasePNode> nodes = new LinkedHashSet<>();
				while (it.hasNext()) nodes.add(newVisitorParameterNode(it.next().toJson()));
				addNodes(nodes, new LayoutRelativeTo(getMousePosition() == null ? getCenterPosition() : getMousePosition()));
			}
		});
	}


	public NeoEntityNode newNeoEntityNode(JsonObject jsonObject) {
		return new NeoEntityNode(jsonObject);
	}

	class NeoEntityNode extends JsonPNode {

		NeoEntityNode(JsonObject neoEntity) {
			super(neoEntity, "name", Color.decode("#3690c0"), Color.decode("#e31a1c"), Color.decode("#e31a1c"));
		}

		@Override
		protected void onRightClick(PInputEvent event, JPopupMenu pop, NodeCanvas canvas, Point mousePosition) {

			// default actions 
			pop.add(new SwingAction("Edit") {
				@Override
				protected void onActionPerformed(ActionEvent e) {

					final NeoEntityForm form = new NeoEntityForm(content());
					form.show(canvas, new ConfirmAction() {
						@Override
						public void verifyAndCommit() throws Exception {
							updateNeoEntity(form.getNeoEntity(), new NeoEntityHandler() {
								@Override
								public void onSuccess(NeoEntity updated) {
									setContent(updated.toJson());
									nodeChangeSupport.firePropertyChange(nodeEvent("content"), null, updated.toJson());
								}
							});
						}
					});
				}
			});

			// ONE 'NeoEntity' (NeoEntity) -> ENTITY_VISITORS -> MANY 'NeoVisitor' (NeoVisitor)
			final JMenu ENTITY_VISITORSMenu = new JMenu("ENTITY_VISITORS");

			ENTITY_VISITORSMenu.add(new SwingAction("Get All ENTITY_VISITORS") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					get_NeoVisitor_ENTITY_VISITORS_FOR_NeoEntity(getUUID(), new ExpandNeoVisitor_ENTITY_VISITORS_FOR_NeoEntityHandler(getThis()));
				}
			});

			ENTITY_VISITORSMenu.add(new SwingAction("Add NeoVisitor") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					add_NeoVisitor_ENTITY_VISITORS_FOR_NeoEntity(getThis(), canvas);
				}
			});

			if (ENTITY_VISITORSMenu.getMenuComponentCount() != 0) pop.add(ENTITY_VISITORSMenu);


			// MANY 'NeoEntity' (NeoEntity) -> ENTITY_RELATION -> MANY 'NeoRelation' (NeoRelation)
			final JMenu ENTITY_RELATIONMenu = new JMenu("ENTITY_RELATION");

			ENTITY_RELATIONMenu.add(new SwingAction("Get All ENTITY_RELATION") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					get_NeoRelation_ENTITY_RELATION_FOR_NeoEntity(getUUID(), new ExpandNeoRelation_ENTITY_RELATION_FOR_NeoEntityHandler(getThis()));
				}
			});

			ENTITY_RELATIONMenu.add(new SwingAction("Add NeoRelation") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					add_NeoRelation_ENTITY_RELATION_FOR_NeoEntity(getThis(), canvas);
				}
			});

			if (ENTITY_RELATIONMenu.getMenuComponentCount() != 0) pop.add(ENTITY_RELATIONMenu);


			// ONE 'NeoEntity' (NeoEntity) -> ENTITY_PROPERTIES -> MANY 'NeoProperty' (NeoProperty)
			final JMenu ENTITY_PROPERTIESMenu = new JMenu("ENTITY_PROPERTIES");

			ENTITY_PROPERTIESMenu.add(new SwingAction("Get All ENTITY_PROPERTIES") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					get_NeoProperty_ENTITY_PROPERTIES_FOR_NeoEntity(getUUID(), new ExpandNeoProperty_ENTITY_PROPERTIES_FOR_NeoEntityHandler(getThis()));
				}
			});

			ENTITY_PROPERTIESMenu.add(new SwingAction("Add NeoProperty") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					add_NeoProperty_ENTITY_PROPERTIES_FOR_NeoEntity(getThis(), canvas);
				}
			});

			if (ENTITY_PROPERTIESMenu.getMenuComponentCount() != 0) pop.add(ENTITY_PROPERTIESMenu);



			super.onRightClick(event, pop, canvas, mousePosition);
		}

		@Override
		protected void onKeyPressed(PInputEvent event, NodeCanvas canvas) {

			switch (event.getKeyCode()) {
				case KeyEvent.VK_E:
					// ONE 'NeoEntity' (NeoEntity) -> ENTITY_VISITORS -> MANY 'NeoVisitor' (NeoVisitor)
					if (event.isControlDown()) get_NeoVisitor_ENTITY_VISITORS_FOR_NeoEntity(getUUID(), new ExpandNeoVisitor_ENTITY_VISITORS_FOR_NeoEntityHandler(getThis()));

					// MANY 'NeoEntity' (NeoEntity) -> ENTITY_RELATION -> MANY 'NeoRelation' (NeoRelation)
					if (event.isControlDown()) get_NeoRelation_ENTITY_RELATION_FOR_NeoEntity(getUUID(), new ExpandNeoRelation_ENTITY_RELATION_FOR_NeoEntityHandler(getThis()));

					// ONE 'NeoEntity' (NeoEntity) -> ENTITY_PROPERTIES -> MANY 'NeoProperty' (NeoProperty)
					if (event.isControlDown()) get_NeoProperty_ENTITY_PROPERTIES_FOR_NeoEntity(getUUID(), new ExpandNeoProperty_ENTITY_PROPERTIES_FOR_NeoEntityHandler(getThis()));

				return;
			}

			super.onKeyPressed(event, canvas);
		}
	}

	// NeoDomainDomain NeoEntity
	protected final class NeoEntityForm extends JPanel {

		private final String title = "New NeoEntity";
		private final PropertyComponent highlightedColorComponent = new PropertyComponent("String");
		private final PropertyComponent selectedColorComponent = new PropertyComponent("String");
		private final PropertyComponent defaultColorComponent = new PropertyComponent("String");
		private final PropertyComponent labelComponent = new PropertyComponent("String");
		private final PropertyComponent nameComponent = new PropertyComponent("String");
		private String uuid;

		protected NeoEntityForm() {
			super(new BorderLayout());
				this.uuid = null;

			int c = 1, r = 1;
			final FormPanel form = new FormPanel("100dlu,4dlu,150dlu", "pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu");
			form.addLabel(NeoDomainDomain.Properties.highlightedColor.name(), c, r);
			c += 2;
			form.add(highlightedColorComponent.getComponent(), c, r);

			r +=2;
			c = 1;
			form.addLabel(NeoDomainDomain.Properties.selectedColor.name(), c, r);
			c += 2;
			form.add(selectedColorComponent.getComponent(), c, r);

			r +=2;
			c = 1;
			form.addLabel(NeoDomainDomain.Properties.defaultColor.name(), c, r);
			c += 2;
			form.add(defaultColorComponent.getComponent(), c, r);

			r +=2;
			c = 1;
			form.addLabel(NeoDomainDomain.Properties.label.name(), c, r);
			c += 2;
			form.add(labelComponent.getComponent(), c, r);

			r +=2;
			c = 1;
			form.addLabel(NeoDomainDomain.Properties.name.name(), c, r);
			c += 2;
			form.add(nameComponent.getComponent(), c, r);

			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			add(form.build(), BorderLayout.CENTER);
		}

		protected NeoEntityForm(JsonObject content) {
			this();
			this.uuid = content.getString("uuid");
			highlightedColorComponent.setValue(content.getValue("highlightedColor"));
			selectedColorComponent.setValue(content.getValue("selectedColor"));
			defaultColorComponent.setValue(content.getValue("defaultColor"));
			labelComponent.setValue(content.getValue("label"));
			nameComponent.setValue(content.getValue("name"));
		}

		public PropertyComponent getHighlightedColorComponent() {
			return highlightedColorComponent;
		}

		protected NeoEntityForm setHighlightedColorValue(String highlightedColor) {
			highlightedColorComponent.setValue(highlightedColor);
			return this;
		}

		protected <T> T getHighlightedColorValue() {
			return highlightedColorComponent.getValue();
		}


		public PropertyComponent getSelectedColorComponent() {
			return selectedColorComponent;
		}

		protected NeoEntityForm setSelectedColorValue(String selectedColor) {
			selectedColorComponent.setValue(selectedColor);
			return this;
		}

		protected <T> T getSelectedColorValue() {
			return selectedColorComponent.getValue();
		}


		public PropertyComponent getDefaultColorComponent() {
			return defaultColorComponent;
		}

		protected NeoEntityForm setDefaultColorValue(String defaultColor) {
			defaultColorComponent.setValue(defaultColor);
			return this;
		}

		protected <T> T getDefaultColorValue() {
			return defaultColorComponent.getValue();
		}


		public PropertyComponent getLabelComponent() {
			return labelComponent;
		}

		protected NeoEntityForm setLabelValue(String label) {
			labelComponent.setValue(label);
			return this;
		}

		protected <T> T getLabelValue() {
			return labelComponent.getValue();
		}


		public PropertyComponent getNameComponent() {
			return nameComponent;
		}

		protected NeoEntityForm setNameValue(String name) {
			nameComponent.setValue(name);
			return this;
		}

		protected <T> T getNameValue() {
			return nameComponent.getValue();
		}

		@Deprecated
		protected JsonObject toJson() {
			return new JsonObject()	
				.put("highlightedColor", (String) getHighlightedColorValue())
				.put("selectedColor", (String) getSelectedColorValue())
				.put("defaultColor", (String) getDefaultColorValue())
				.put("label", (String) getLabelValue())
				.put("name", (String) getNameValue());}

		protected NeoEntity getNeoEntity() {
			final JsonObject jsonObject = new JsonObject()
				.put("highlightedColor", (String) getHighlightedColorValue())
				.put("selectedColor", (String) getSelectedColorValue())
				.put("defaultColor", (String) getDefaultColorValue())
				.put("label", (String) getLabelValue())
				.put("name", (String) getNameValue());
			if (uuid != null) jsonObject.put("uuid", uuid);
			return mapNeoEntity(jsonObject);
		}

		protected void show(NodeCanvas canvas, ConfirmAction confirmAction) {
			showDialog(this, canvas, title, confirmAction);
		}
	}

	public NeoEntity newNeoEntity(String highlightedColor, String selectedColor, String defaultColor, String label, String name) {
		return newNeoEntity(new JsonObject().
			put("highlightedColor", highlightedColor).
			put("selectedColor", selectedColor).
			put("defaultColor", defaultColor).
			put("label", label).
			put("name", name));
	}

	public NeoEntity newNeoEntity(JsonObject parameters) {
		return mapNeoEntity(parameters);
	}

	public void updateNeoEntity(NeoEntity neoEntity, NeoEntityHandler handler) {
		send("neoDomainDomain.update.neoEntity", new JsonObject().put("uuid", neoEntity.getUUID().toString()).put("NeoEntity", neoEntity.toJson()), handler);
	}

	public void deleteNeoEntity(UUID uuid,  DeleteHandler handler) {
		send("neoDomainDomain.delete.neoEntity", new JsonObject().put("uuid", uuid.toString()), handler);
	}

	public void getNeoEntity(UUID uuid, NeoEntityHandler handler) {
		send("neoDomainDomain.get.neoEntity", new JsonObject().put("uuid", uuid.toString()), handler);
	}

	public void getAllNeoEntity(NeoEntityListHandler handler) {
		send("neoDomainDomain.get.all.neoEntity", new JsonObject(), handler);
	}

	public static abstract class NeoEntityListHandler extends ListHandler<NeoEntity> {

		@Override
		protected NeoEntity map(JsonObject jsonObject) {
			return mapNeoEntity(jsonObject);
		}
	}

	public static abstract class NeoEntityHandler extends MessageHandler {

		public abstract void onSuccess(NeoEntity neoEntity);

		@Override
		protected void handleSuccess(JsonObject payload) {
			onSuccess(mapNeoEntity(payload));
		}
	}

	interface NeoEntity {

		enum Properties {
			highlightedColor,
			selectedColor,
			defaultColor,
			label,
			name
		}


		UUID getUUID();

		JsonObject toJson();

		String getHighlightedColor();

		NeoEntity setHighlightedColor(String highlightedColor);

		String getSelectedColor();

		NeoEntity setSelectedColor(String selectedColor);

		String getDefaultColor();

		NeoEntity setDefaultColor(String defaultColor);

		String getLabel();

		NeoEntity setLabel(String label);

		String getName();

		NeoEntity setName(String name);

	}

	private static NeoEntity mapNeoEntity(JsonObject payload) {
		return new NeoEntity() {

			@Override
			public UUID getUUID() {
				return UUID.fromString(payload.getString("uuid"));
			}
					@Override
			public JsonObject toJson() {
				return payload;
			}

			@Override
			public String toString() {
				return payload.encode();
			}

			@Override
			public String getHighlightedColor() {
				return payload.getString("highlightedColor");
			}

			@Override
			public NeoEntity setHighlightedColor(String highlightedColor) {
				payload.put("highlightedColor", highlightedColor);
				return this;
			}

			@Override
			public String getSelectedColor() {
				return payload.getString("selectedColor");
			}

			@Override
			public NeoEntity setSelectedColor(String selectedColor) {
				payload.put("selectedColor", selectedColor);
				return this;
			}

			@Override
			public String getDefaultColor() {
				return payload.getString("defaultColor");
			}

			@Override
			public NeoEntity setDefaultColor(String defaultColor) {
				payload.put("defaultColor", defaultColor);
				return this;
			}

			@Override
			public String getLabel() {
				return payload.getString("label");
			}

			@Override
			public NeoEntity setLabel(String label) {
				payload.put("label", label);
				return this;
			}

			@Override
			public String getName() {
				return payload.getString("name");
			}

			@Override
			public NeoEntity setName(String name) {
				payload.put("name", name);
				return this;
			}

		};
	}

	protected void getAllNeoEntity() {
		getAllNeoEntity(new NeoEntityListHandler() {
			@Override
			public void onSuccess(java.util.Iterator<NeoEntity> it) {
				final Set<BasePNode> nodes = new LinkedHashSet<>();
				while (it.hasNext()) nodes.add(newNeoEntityNode(it.next().toJson()));
				addNodes(nodes, new LayoutRelativeTo(getMousePosition() == null ? getCenterPosition() : getMousePosition()));
			}
		});
	}


	public NeoRelationNode newNeoRelationNode(JsonObject jsonObject) {
		return new NeoRelationNode(jsonObject);
	}

	class NeoRelationNode extends JsonPNode {

		NeoRelationNode(JsonObject neoRelation) {
			super(neoRelation, "name", Color.decode("#3690c0"), Color.decode("#e31a1c"), Color.decode("#e31a1c"));
		}

		@Override
		protected void onRightClick(PInputEvent event, JPopupMenu pop, NodeCanvas canvas, Point mousePosition) {

			// default actions 
			pop.add(new SwingAction("Edit") {
				@Override
				protected void onActionPerformed(ActionEvent e) {

					final NeoRelationForm form = new NeoRelationForm(content());
					form.show(canvas, new ConfirmAction() {
						@Override
						public void verifyAndCommit() throws Exception {
							updateNeoRelation(form.getNeoRelation(), new NeoRelationHandler() {
								@Override
								public void onSuccess(NeoRelation updated) {
									setContent(updated.toJson());
									nodeChangeSupport.firePropertyChange(nodeEvent("content"), null, updated.toJson());
								}
							});
						}
					});
				}
			});

			// ONE 'NeoRelation' (NeoRelation) -> RELATION_PROPERTIES -> MANY 'NeoProperty' (NeoProperty)
			final JMenu RELATION_PROPERTIESMenu = new JMenu("RELATION_PROPERTIES");

			RELATION_PROPERTIESMenu.add(new SwingAction("Get All RELATION_PROPERTIES") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					get_NeoProperty_RELATION_PROPERTIES_FOR_NeoRelation(getUUID(), new ExpandNeoProperty_RELATION_PROPERTIES_FOR_NeoRelationHandler(getThis()));
				}
			});

			RELATION_PROPERTIESMenu.add(new SwingAction("Add NeoProperty") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					add_NeoProperty_RELATION_PROPERTIES_FOR_NeoRelation(getThis(), canvas);
				}
			});

			if (RELATION_PROPERTIESMenu.getMenuComponentCount() != 0) pop.add(RELATION_PROPERTIESMenu);


			// MANY 'NeoRelation' (NeoRelation) -> RELATION_ENTITY -> MANY 'NeoEntity' (NeoEntity)
			final JMenu RELATION_ENTITYMenu = new JMenu("RELATION_ENTITY");

			RELATION_ENTITYMenu.add(new SwingAction("Get All RELATION_ENTITY") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					get_NeoEntity_RELATION_ENTITY_FOR_NeoRelation(getUUID(), new ExpandNeoEntity_RELATION_ENTITY_FOR_NeoRelationHandler(getThis()));
				}
			});

			RELATION_ENTITYMenu.add(new SwingAction("Add NeoEntity") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					add_NeoEntity_RELATION_ENTITY_FOR_NeoRelation(getThis(), canvas);
				}
			});

			if (RELATION_ENTITYMenu.getMenuComponentCount() != 0) pop.add(RELATION_ENTITYMenu);



			super.onRightClick(event, pop, canvas, mousePosition);
		}

		@Override
		protected void onKeyPressed(PInputEvent event, NodeCanvas canvas) {

			switch (event.getKeyCode()) {
				case KeyEvent.VK_E:
					// ONE 'NeoRelation' (NeoRelation) -> RELATION_PROPERTIES -> MANY 'NeoProperty' (NeoProperty)
					if (event.isControlDown()) get_NeoProperty_RELATION_PROPERTIES_FOR_NeoRelation(getUUID(), new ExpandNeoProperty_RELATION_PROPERTIES_FOR_NeoRelationHandler(getThis()));

					// MANY 'NeoRelation' (NeoRelation) -> RELATION_ENTITY -> MANY 'NeoEntity' (NeoEntity)
					if (event.isControlDown()) get_NeoEntity_RELATION_ENTITY_FOR_NeoRelation(getUUID(), new ExpandNeoEntity_RELATION_ENTITY_FOR_NeoRelationHandler(getThis()));

				return;
			}

			super.onKeyPressed(event, canvas);
		}
	}

	// NeoDomainDomain NeoRelation
	protected final class NeoRelationForm extends JPanel {

		private final String title = "New NeoRelation";
		private final PropertyComponent cardinalityComponent = new PropertyComponent(NeoRelation.Cardinality.values());
		private final PropertyComponent nameComponent = new PropertyComponent("String");
		private String uuid;

		protected NeoRelationForm() {
			super(new BorderLayout());
				this.uuid = null;

			int c = 1, r = 1;
			final FormPanel form = new FormPanel("100dlu,4dlu,150dlu", "pref,4dlu,pref,4dlu");
			form.addLabel(NeoDomainDomain.Properties.cardinality.name(), c, r);
			c += 2;
			form.add(cardinalityComponent.getComponent(), c, r);

			r +=2;
			c = 1;
			form.addLabel(NeoDomainDomain.Properties.name.name(), c, r);
			c += 2;
			form.add(nameComponent.getComponent(), c, r);

			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			add(form.build(), BorderLayout.CENTER);
		}

		protected NeoRelationForm(JsonObject content) {
			this();
			this.uuid = content.getString("uuid");
			cardinalityComponent.setValue(content.getValue("cardinality"));
			nameComponent.setValue(content.getValue("name"));
		}

		public PropertyComponent getCardinalityComponent() {
			return cardinalityComponent;
		}

		protected NeoRelationForm setCardinalityValue(NeoRelation.Cardinality cardinality) {
			cardinalityComponent.setValue(cardinality);
			return this;
		}

		protected <T> T getCardinalityValue() {
			return cardinalityComponent.getValue();
		}


		public PropertyComponent getNameComponent() {
			return nameComponent;
		}

		protected NeoRelationForm setNameValue(String name) {
			nameComponent.setValue(name);
			return this;
		}

		protected <T> T getNameValue() {
			return nameComponent.getValue();
		}

		@Deprecated
		protected JsonObject toJson() {
			return new JsonObject()	
				.put("Cardinality", (NeoRelation.Cardinality) getCardinalityValue())
				.put("name", (String) getNameValue());}

		protected NeoRelation getNeoRelation() {
			final JsonObject jsonObject = new JsonObject()
				.put("Cardinality", (NeoRelation.Cardinality) getCardinalityValue())
				.put("name", (String) getNameValue());
			if (uuid != null) jsonObject.put("uuid", uuid);
			return mapNeoRelation(jsonObject);
		}

		protected void show(NodeCanvas canvas, ConfirmAction confirmAction) {
			showDialog(this, canvas, title, confirmAction);
		}
	}

	public NeoRelation newNeoRelation(NeoRelation.Cardinality Cardinality, String name) {
		return newNeoRelation(new JsonObject().
			put("Cardinality", Cardinality.name()).
			put("name", name));
	}

	public NeoRelation newNeoRelation(JsonObject parameters) {
		return mapNeoRelation(parameters);
	}

	public void updateNeoRelation(NeoRelation neoRelation, NeoRelationHandler handler) {
		send("neoDomainDomain.update.neoRelation", new JsonObject().put("uuid", neoRelation.getUUID().toString()).put("NeoRelation", neoRelation.toJson()), handler);
	}

	public void deleteNeoRelation(UUID uuid,  DeleteHandler handler) {
		send("neoDomainDomain.delete.neoRelation", new JsonObject().put("uuid", uuid.toString()), handler);
	}

	public void getNeoRelation(UUID uuid, NeoRelationHandler handler) {
		send("neoDomainDomain.get.neoRelation", new JsonObject().put("uuid", uuid.toString()), handler);
	}

	public void getAllNeoRelation(NeoRelationListHandler handler) {
		send("neoDomainDomain.get.all.neoRelation", new JsonObject(), handler);
	}

	public static abstract class NeoRelationListHandler extends ListHandler<NeoRelation> {

		@Override
		protected NeoRelation map(JsonObject jsonObject) {
			return mapNeoRelation(jsonObject);
		}
	}

	public static abstract class NeoRelationHandler extends MessageHandler {

		public abstract void onSuccess(NeoRelation neoRelation);

		@Override
		protected void handleSuccess(JsonObject payload) {
			onSuccess(mapNeoRelation(payload));
		}
	}

	interface NeoRelation {

		enum Properties {
			cardinality,
			name
		}

		enum Cardinality { ONE_TO_MANY, MANY_TO_ONE, ONE_TO_ONE, MANY_TO_MANY } 

		UUID getUUID();

		JsonObject toJson();

		Cardinality getCardinality();

		NeoRelation setCardinality(Cardinality cardinality);

		String getName();

		NeoRelation setName(String name);

	}

	private static NeoRelation mapNeoRelation(JsonObject payload) {
		return new NeoRelation() {

			@Override
			public UUID getUUID() {
				return UUID.fromString(payload.getString("uuid"));
			}
					@Override
			public JsonObject toJson() {
				return payload;
			}

			@Override
			public String toString() {
				return payload.encode();
			}

			@Override
			public Cardinality getCardinality() {
				return Cardinality.valueOf(payload.getString("cardinality"));
			}

			@Override
			public NeoRelation setCardinality(Cardinality cardinality) {
				payload.put("Cardinality", cardinality.name());
				return this;
			}

			@Override
			public String getName() {
				return payload.getString("name");
			}

			@Override
			public NeoRelation setName(String name) {
				payload.put("name", name);
				return this;
			}

		};
	}

	protected void getAllNeoRelation() {
		getAllNeoRelation(new NeoRelationListHandler() {
			@Override
			public void onSuccess(java.util.Iterator<NeoRelation> it) {
				final Set<BasePNode> nodes = new LinkedHashSet<>();
				while (it.hasNext()) nodes.add(newNeoRelationNode(it.next().toJson()));
				addNodes(nodes, new LayoutRelativeTo(getMousePosition() == null ? getCenterPosition() : getMousePosition()));
			}
		});
	}


	public NeoPropertyNode newNeoPropertyNode(JsonObject jsonObject) {
		return new NeoPropertyNode(jsonObject);
	}

	class NeoPropertyNode extends JsonPNode {

		NeoPropertyNode(JsonObject neoProperty) {
			super(neoProperty, "name", Color.decode("#3690c0"), Color.decode("#e31a1c"), Color.decode("#e31a1c"));
		}

		@Override
		protected void onRightClick(PInputEvent event, JPopupMenu pop, NodeCanvas canvas, Point mousePosition) {

			// default actions 
			pop.add(new SwingAction("Edit") {
				@Override
				protected void onActionPerformed(ActionEvent e) {

					final NeoPropertyForm form = new NeoPropertyForm(content());
					form.show(canvas, new ConfirmAction() {
						@Override
						public void verifyAndCommit() throws Exception {
							updateNeoProperty(form.getNeoProperty(), new NeoPropertyHandler() {
								@Override
								public void onSuccess(NeoProperty updated) {
									setContent(updated.toJson());
									nodeChangeSupport.firePropertyChange(nodeEvent("content"), null, updated.toJson());
								}
							});
						}
					});
				}
			});


			super.onRightClick(event, pop, canvas, mousePosition);
		}

		@Override
		protected void onKeyPressed(PInputEvent event, NodeCanvas canvas) {

			switch (event.getKeyCode()) {
				case KeyEvent.VK_E:
				return;
			}

			super.onKeyPressed(event, canvas);
		}
	}

	// NeoDomainDomain NeoProperty
	protected final class NeoPropertyForm extends JPanel {

		private final String title = "New NeoProperty";
		private final PropertyComponent enumValuesComponent = new PropertyComponent("String");
		private final PropertyComponent valueTypeComponent = new PropertyComponent(NeoProperty.ValueType.values());
		private final PropertyComponent nameComponent = new PropertyComponent("String");
		private String uuid;

		protected NeoPropertyForm() {
			super(new BorderLayout());
				this.uuid = null;

			int c = 1, r = 1;
			final FormPanel form = new FormPanel("100dlu,4dlu,150dlu", "pref,4dlu,pref,4dlu,pref,4dlu");
			form.addLabel(NeoDomainDomain.Properties.enumValues.name(), c, r);
			c += 2;
			form.add(enumValuesComponent.getComponent(), c, r);

			r +=2;
			c = 1;
			form.addLabel(NeoDomainDomain.Properties.valueType.name(), c, r);
			c += 2;
			form.add(valueTypeComponent.getComponent(), c, r);

			r +=2;
			c = 1;
			form.addLabel(NeoDomainDomain.Properties.name.name(), c, r);
			c += 2;
			form.add(nameComponent.getComponent(), c, r);

			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			add(form.build(), BorderLayout.CENTER);
		}

		protected NeoPropertyForm(JsonObject content) {
			this();
			this.uuid = content.getString("uuid");
			enumValuesComponent.setValue(content.getValue("enumValues"));
			valueTypeComponent.setValue(content.getValue("valueType"));
			nameComponent.setValue(content.getValue("name"));
		}

		public PropertyComponent getEnumValuesComponent() {
			return enumValuesComponent;
		}

		protected NeoPropertyForm setEnumValuesValue(String enumValues) {
			enumValuesComponent.setValue(enumValues);
			return this;
		}

		protected <T> T getEnumValuesValue() {
			return enumValuesComponent.getValue();
		}


		public PropertyComponent getValueTypeComponent() {
			return valueTypeComponent;
		}

		protected NeoPropertyForm setValueTypeValue(NeoProperty.ValueType valueType) {
			valueTypeComponent.setValue(valueType);
			return this;
		}

		protected <T> T getValueTypeValue() {
			return valueTypeComponent.getValue();
		}


		public PropertyComponent getNameComponent() {
			return nameComponent;
		}

		protected NeoPropertyForm setNameValue(String name) {
			nameComponent.setValue(name);
			return this;
		}

		protected <T> T getNameValue() {
			return nameComponent.getValue();
		}

		@Deprecated
		protected JsonObject toJson() {
			return new JsonObject()	
				.put("enumValues", (String) getEnumValuesValue())
				.put("ValueType", (NeoProperty.ValueType) getValueTypeValue())
				.put("name", (String) getNameValue());}

		protected NeoProperty getNeoProperty() {
			final JsonObject jsonObject = new JsonObject()
				.put("enumValues", (String) getEnumValuesValue())
				.put("ValueType", (NeoProperty.ValueType) getValueTypeValue())
				.put("name", (String) getNameValue());
			if (uuid != null) jsonObject.put("uuid", uuid);
			return mapNeoProperty(jsonObject);
		}

		protected void show(NodeCanvas canvas, ConfirmAction confirmAction) {
			showDialog(this, canvas, title, confirmAction);
		}
	}

	public NeoProperty newNeoProperty(String enumValues, NeoProperty.ValueType ValueType, String name) {
		return newNeoProperty(new JsonObject().
			put("enumValues", enumValues).
			put("ValueType", ValueType.name()).
			put("name", name));
	}

	public NeoProperty newNeoProperty(JsonObject parameters) {
		return mapNeoProperty(parameters);
	}

	public void updateNeoProperty(NeoProperty neoProperty, NeoPropertyHandler handler) {
		send("neoDomainDomain.update.neoProperty", new JsonObject().put("uuid", neoProperty.getUUID().toString()).put("NeoProperty", neoProperty.toJson()), handler);
	}

	public void deleteNeoProperty(UUID uuid,  DeleteHandler handler) {
		send("neoDomainDomain.delete.neoProperty", new JsonObject().put("uuid", uuid.toString()), handler);
	}

	public void getNeoProperty(UUID uuid, NeoPropertyHandler handler) {
		send("neoDomainDomain.get.neoProperty", new JsonObject().put("uuid", uuid.toString()), handler);
	}

	public void getAllNeoProperty(NeoPropertyListHandler handler) {
		send("neoDomainDomain.get.all.neoProperty", new JsonObject(), handler);
	}

	public static abstract class NeoPropertyListHandler extends ListHandler<NeoProperty> {

		@Override
		protected NeoProperty map(JsonObject jsonObject) {
			return mapNeoProperty(jsonObject);
		}
	}

	public static abstract class NeoPropertyHandler extends MessageHandler {

		public abstract void onSuccess(NeoProperty neoProperty);

		@Override
		protected void handleSuccess(JsonObject payload) {
			onSuccess(mapNeoProperty(payload));
		}
	}

	interface NeoProperty {

		enum Properties {
			enumValues,
			valueType,
			name
		}

		enum ValueType { String, Double, Integer, Boolean, Enum } 

		UUID getUUID();

		JsonObject toJson();

		String getEnumValues();

		NeoProperty setEnumValues(String enumValues);

		ValueType getValueType();

		NeoProperty setValueType(ValueType valueType);

		String getName();

		NeoProperty setName(String name);

	}

	private static NeoProperty mapNeoProperty(JsonObject payload) {
		return new NeoProperty() {

			@Override
			public UUID getUUID() {
				return UUID.fromString(payload.getString("uuid"));
			}
					@Override
			public JsonObject toJson() {
				return payload;
			}

			@Override
			public String toString() {
				return payload.encode();
			}

			@Override
			public String getEnumValues() {
				return payload.getString("enumValues");
			}

			@Override
			public NeoProperty setEnumValues(String enumValues) {
				payload.put("enumValues", enumValues);
				return this;
			}

			@Override
			public ValueType getValueType() {
				return ValueType.valueOf(payload.getString("valueType"));
			}

			@Override
			public NeoProperty setValueType(ValueType valueType) {
				payload.put("ValueType", valueType.name());
				return this;
			}

			@Override
			public String getName() {
				return payload.getString("name");
			}

			@Override
			public NeoProperty setName(String name) {
				payload.put("name", name);
				return this;
			}

		};
	}

	protected void getAllNeoProperty() {
		getAllNeoProperty(new NeoPropertyListHandler() {
			@Override
			public void onSuccess(java.util.Iterator<NeoProperty> it) {
				final Set<BasePNode> nodes = new LinkedHashSet<>();
				while (it.hasNext()) nodes.add(newNeoPropertyNode(it.next().toJson()));
				addNodes(nodes, new LayoutRelativeTo(getMousePosition() == null ? getCenterPosition() : getMousePosition()));
			}
		});
	}


	public NeoDomainRendererNode newNeoDomainRendererNode(JsonObject jsonObject) {
		return new NeoDomainRendererNode(jsonObject);
	}

	class NeoDomainRendererNode extends JsonPNode {

		NeoDomainRendererNode(JsonObject neoDomainRenderer) {
			super(neoDomainRenderer, "root", Color.decode("#3690c0"), Color.decode("#e31a1c"), Color.decode("#e31a1c"));
		}

		@Override
		protected void onRightClick(PInputEvent event, JPopupMenu pop, NodeCanvas canvas, Point mousePosition) {

			// default actions 
			pop.add(new SwingAction("Edit") {
				@Override
				protected void onActionPerformed(ActionEvent e) {

					final NeoDomainRendererForm form = new NeoDomainRendererForm(content());
					form.show(canvas, new ConfirmAction() {
						@Override
						public void verifyAndCommit() throws Exception {
							updateNeoDomainRenderer(form.getNeoDomainRenderer(), new NeoDomainRendererHandler() {
								@Override
								public void onSuccess(NeoDomainRenderer updated) {
									setContent(updated.toJson());
									nodeChangeSupport.firePropertyChange(nodeEvent("content"), null, updated.toJson());
								}
							});
						}
					});
				}
			});


			super.onRightClick(event, pop, canvas, mousePosition);
		}

		@Override
		protected void onKeyPressed(PInputEvent event, NodeCanvas canvas) {

			switch (event.getKeyCode()) {
				case KeyEvent.VK_E:
				return;
			}

			super.onKeyPressed(event, canvas);
		}
	}

	// NeoDomainDomain NeoDomainRenderer
	protected final class NeoDomainRendererForm extends JPanel {

		private final String title = "New NeoDomainRenderer";
		private final PropertyComponent packageNameComponent = new PropertyComponent("String");
		private final PropertyComponent rootComponent = new PropertyComponent("String");
		private String uuid;

		protected NeoDomainRendererForm() {
			super(new BorderLayout());
				this.uuid = null;

			int c = 1, r = 1;
			final FormPanel form = new FormPanel("100dlu,4dlu,150dlu", "pref,4dlu,pref,4dlu");
			form.addLabel(NeoDomainDomain.Properties.packageName.name(), c, r);
			c += 2;
			form.add(packageNameComponent.getComponent(), c, r);

			r +=2;
			c = 1;
			form.addLabel(NeoDomainDomain.Properties.root.name(), c, r);
			c += 2;
			form.add(rootComponent.getComponent(), c, r);

			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			add(form.build(), BorderLayout.CENTER);
		}

		protected NeoDomainRendererForm(JsonObject content) {
			this();
			this.uuid = content.getString("uuid");
			packageNameComponent.setValue(content.getValue("packageName"));
			rootComponent.setValue(content.getValue("root"));
		}

		public PropertyComponent getPackageNameComponent() {
			return packageNameComponent;
		}

		protected NeoDomainRendererForm setPackageNameValue(String packageName) {
			packageNameComponent.setValue(packageName);
			return this;
		}

		protected <T> T getPackageNameValue() {
			return packageNameComponent.getValue();
		}


		public PropertyComponent getRootComponent() {
			return rootComponent;
		}

		protected NeoDomainRendererForm setRootValue(String root) {
			rootComponent.setValue(root);
			return this;
		}

		protected <T> T getRootValue() {
			return rootComponent.getValue();
		}

		@Deprecated
		protected JsonObject toJson() {
			return new JsonObject()	
				.put("packageName", (String) getPackageNameValue())
				.put("root", (String) getRootValue());}

		protected NeoDomainRenderer getNeoDomainRenderer() {
			final JsonObject jsonObject = new JsonObject()
				.put("packageName", (String) getPackageNameValue())
				.put("root", (String) getRootValue());
			if (uuid != null) jsonObject.put("uuid", uuid);
			return mapNeoDomainRenderer(jsonObject);
		}

		protected void show(NodeCanvas canvas, ConfirmAction confirmAction) {
			showDialog(this, canvas, title, confirmAction);
		}
	}

	public NeoDomainRenderer newNeoDomainRenderer(String packageName, String root) {
		return newNeoDomainRenderer(new JsonObject().
			put("packageName", packageName).
			put("root", root));
	}

	public NeoDomainRenderer newNeoDomainRenderer(JsonObject parameters) {
		return mapNeoDomainRenderer(parameters);
	}

	public void updateNeoDomainRenderer(NeoDomainRenderer neoDomainRenderer, NeoDomainRendererHandler handler) {
		send("neoDomainDomain.update.neoDomainRenderer", new JsonObject().put("uuid", neoDomainRenderer.getUUID().toString()).put("NeoDomainRenderer", neoDomainRenderer.toJson()), handler);
	}

	public void deleteNeoDomainRenderer(UUID uuid,  DeleteHandler handler) {
		send("neoDomainDomain.delete.neoDomainRenderer", new JsonObject().put("uuid", uuid.toString()), handler);
	}

	public void getNeoDomainRenderer(UUID uuid, NeoDomainRendererHandler handler) {
		send("neoDomainDomain.get.neoDomainRenderer", new JsonObject().put("uuid", uuid.toString()), handler);
	}

	public void getAllNeoDomainRenderer(NeoDomainRendererListHandler handler) {
		send("neoDomainDomain.get.all.neoDomainRenderer", new JsonObject(), handler);
	}

	public static abstract class NeoDomainRendererListHandler extends ListHandler<NeoDomainRenderer> {

		@Override
		protected NeoDomainRenderer map(JsonObject jsonObject) {
			return mapNeoDomainRenderer(jsonObject);
		}
	}

	public static abstract class NeoDomainRendererHandler extends MessageHandler {

		public abstract void onSuccess(NeoDomainRenderer neoDomainRenderer);

		@Override
		protected void handleSuccess(JsonObject payload) {
			onSuccess(mapNeoDomainRenderer(payload));
		}
	}

	interface NeoDomainRenderer {

		enum Properties {
			packageName,
			root
		}


		UUID getUUID();

		JsonObject toJson();

		String getPackageName();

		NeoDomainRenderer setPackageName(String packageName);

		String getRoot();

		NeoDomainRenderer setRoot(String root);

	}

	private static NeoDomainRenderer mapNeoDomainRenderer(JsonObject payload) {
		return new NeoDomainRenderer() {

			@Override
			public UUID getUUID() {
				return UUID.fromString(payload.getString("uuid"));
			}
					@Override
			public JsonObject toJson() {
				return payload;
			}

			@Override
			public String toString() {
				return payload.encode();
			}

			@Override
			public String getPackageName() {
				return payload.getString("packageName");
			}

			@Override
			public NeoDomainRenderer setPackageName(String packageName) {
				payload.put("packageName", packageName);
				return this;
			}

			@Override
			public String getRoot() {
				return payload.getString("root");
			}

			@Override
			public NeoDomainRenderer setRoot(String root) {
				payload.put("root", root);
				return this;
			}

		};
	}

	protected void getAllNeoDomainRenderer() {
		getAllNeoDomainRenderer(new NeoDomainRendererListHandler() {
			@Override
			public void onSuccess(java.util.Iterator<NeoDomainRenderer> it) {
				final Set<BasePNode> nodes = new LinkedHashSet<>();
				while (it.hasNext()) nodes.add(newNeoDomainRendererNode(it.next().toJson()));
				addNodes(nodes, new LayoutRelativeTo(getMousePosition() == null ? getCenterPosition() : getMousePosition()));
			}
		});
	}


	// RELATIONS

	// ONE 'NeoDomain' (NeoDomain) -> DOMAIN_VISITORS -> MANY 'NeoVisitor' (NeoVisitor)

	// 
	protected DOMAIN_VISITORSRelation newDOMAIN_VISITORSRelation(JsonObject relationship, JsonPNode neoDomain, JsonPNode neoVisitor) {
			return new DOMAIN_VISITORSRelation(relationship, neoDomain, neoVisitor);
		}

	class DOMAIN_VISITORSRelation extends JsonRelationship {

		DOMAIN_VISITORSRelation(JsonObject relationship, JsonPNode neoDomain, JsonPNode neoVisitor) {
			super(relationship, "DOMAIN_VISITORS", neoDomain, neoVisitor, Color.decode("#bdbdbd"), Color.decode("#636363"), Color.decode("#e34a33"));
		}

		@Override
		protected void onRightClick(JPopupMenu pop, NodeCanvas canvas) {

			super.onRightClick(pop, canvas);
		}
	}

	// NeoDomainDomain DOMAIN_VISITORS
	protected final class DOMAIN_VISITORSForm extends JPanel {

		private final String title = "New DOMAIN_VISITORS";
		private String uuid;

		protected DOMAIN_VISITORSForm() {
			super(new BorderLayout());
				this.uuid = null;

			int c = 1, r = 1;
			final FormPanel form = new FormPanel("100dlu,4dlu,150dlu", "");
			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			add(form.build(), BorderLayout.CENTER);
		}

		protected DOMAIN_VISITORSForm(JsonObject content) {
			this();
			this.uuid = content.getString("uuid");
		}


		@Deprecated
		protected JsonObject toJson() {
			return new JsonObject()	;}

		protected DOMAIN_VISITORS getDOMAIN_VISITORS() {
			final JsonObject jsonObject = new JsonObject();
			if (uuid != null) jsonObject.put("uuid", uuid);
			return mapDOMAIN_VISITORS(jsonObject);
		}

		protected void show(NodeCanvas canvas, ConfirmAction confirmAction) {
			showDialog(this, canvas, title, confirmAction);
		}
	}

	public void relateNeoDomain_DOMAIN_VISITORS_NeoVisitor(UUID neoDomain, NeoVisitor neoVisitor, DOMAIN_VISITORSHandler handler) {
		final JsonObject parameters = new JsonObject().put("NeoDomain", neoDomain.toString()).put("NeoVisitor", neoVisitor.toJson());
		send("neoDomainDomain.relate.neoDomain.DOMAIN_VISITORS.neoVisitor", parameters, handler);
	}

	public static abstract class DOMAIN_VISITORSHandler extends MessageHandler {

		public abstract void onSuccess(DOMAIN_VISITORS relation, NeoVisitor neoVisitor);

		@Override
		protected void handleSuccess(JsonObject payload) {
			onSuccess(mapDOMAIN_VISITORS(payload.getJsonObject("DOMAIN_VISITORS")), mapNeoVisitor(payload.getJsonObject("NeoVisitor")));
		}
	}

	// MISSING
	// one-to-many
	protected class ExpandNeoVisitor_DOMAIN_VISITORS_FOR_NeoDomainHandler extends NeoVisitor_DOMAIN_VISITORS_FOR_NeoDomainHandler {

		private final NeoDomainNode node;

		ExpandNeoVisitor_DOMAIN_VISITORS_FOR_NeoDomainHandler(NeoDomainNode node) {
			this.node = node;
		}

		@Override
		public void onSuccess(Iterator<NeoDomainDOMAIN_VISITORS> it) {
			final Set<BasePNode> nodes = new LinkedHashSet<>();
			final Set<Relation> relations = new LinkedHashSet<>();
			while(it.hasNext()) {
				final NeoDomainDOMAIN_VISITORS next = it.next();
				final NeoVisitorNode entityNode = newNeoVisitorNode(next.getNeoVisitor().toJson());
				nodes.add(entityNode);
				relations.add(newDOMAIN_VISITORSRelation(next.getDOMAIN_VISITORS().toJson(), node, entityNode));
			}
			addNodesAndRelations(nodes, relations, new LayoutRelativeTo(node));
		}
	}

	protected void add_NeoVisitor_DOMAIN_VISITORS_FOR_NeoDomain(final NeoDomainNode node, NodeCanvas canvas) {

		final NeoVisitorForm form = new NeoVisitorForm();
		form.show(canvas, new ConfirmAction() {
			@Override
			public void verifyAndCommit() throws Exception {
				final NeoVisitor entity = newNeoVisitor(form.toJson());

				relateNeoDomain_DOMAIN_VISITORS_NeoVisitor(node.getUUID(), entity, new DOMAIN_VISITORSHandler() {
					@Override
					public void onSuccess(DOMAIN_VISITORS relation, NeoVisitor newEntity) {
						final NeoVisitorNode newNode = newNeoVisitorNode(newEntity.toJson());
						addNodeAndRelation(newNode, newDOMAIN_VISITORSRelation(relation.toJson(), node, newNode), new LayoutRelativeTo(node));
					}
				});
			}
		});
	}

	// message support
	public void get_NeoVisitor_DOMAIN_VISITORS_FOR_NeoDomain(UUID neoDomain, NeoVisitor_DOMAIN_VISITORS_FOR_NeoDomainHandler handler) {
		send("neoDomainDomain.get.neoVisitor.DOMAIN_VISITORS.neoDomain", new JsonObject().put("NeoDomain", neoDomain.toString()), handler);
	}

	public void get_NeoDomain_DOMAIN_VISITORS_FOR_NeoVisitor(UUID neoVisitor, DOMAIN_VISITORSNeoDomainHandler handler) {
		send("neoDomainDomain.get.neoDomain.DOMAIN_VISITORS.neoVisitor", new JsonObject().put("NeoVisitor", neoVisitor.toString()), handler);
	}

	public interface NeoDomainDOMAIN_VISITORS {

		public NeoVisitor getNeoVisitor();

		public DOMAIN_VISITORS getDOMAIN_VISITORS();
	}

	public static abstract class NeoVisitor_DOMAIN_VISITORS_FOR_NeoDomainHandler extends ListHandler<NeoDomainDOMAIN_VISITORS> {

		@Override
		protected NeoDomainDOMAIN_VISITORS map(JsonObject payload) {
			return new NeoDomainDOMAIN_VISITORS() {
				@Override
				public NeoVisitor getNeoVisitor() {
					return mapNeoVisitor(payload.getJsonObject("NeoVisitor"));
				}

				@Override
				public DOMAIN_VISITORS getDOMAIN_VISITORS() {
					return mapDOMAIN_VISITORS(payload.getJsonObject("DOMAIN_VISITORS"));
				}
			};
		}
	}

	public static abstract class DOMAIN_VISITORSNeoDomainHandler extends MessageHandler {

		public abstract void onSuccess(DOMAIN_VISITORS DOMAIN_VISITORS, NeoDomain neoDomain);

		@Override
		protected void handleSuccess(JsonObject payload) {
			if (payload.isEmpty()) return;
			onSuccess(mapDOMAIN_VISITORS(payload.getJsonObject("DOMAIN_VISITORS")),mapNeoDomain(payload.getJsonObject("NeoDomain")));
		}
	}

	public void updateDOMAIN_VISITORS(UUID srcNode, DOMAIN_VISITORS relationship, DOMAIN_VISITORSHandler handler) {
		send("neoDomainDomain.update.DOMAIN_VISITORS", new JsonObject().put("uuid", srcNode.toString()).put("DOMAIN_VISITORS", relationship.toJson()), handler);
	}

	private static DOMAIN_VISITORS mapDOMAIN_VISITORS(JsonObject payload) {
		return new DOMAIN_VISITORS() {
			@Override
			public UUID getUUID() {
				return UUID.fromString(payload.getString("uuid"));
			}

			@Override
			public JsonObject toJson() {
				return payload;
			}

			@Override
			public String toString() {
				return toJson().encode();
			}
		};
	}

	interface DOMAIN_VISITORS {

		UUID getUUID();

		JsonObject toJson();

	}


	// ONE 'NeoVisitor' (NeoVisitor) -> VISITOR_PARAMETERS -> MANY 'VisitorParameter' (VisitorParameter)

	// 
	protected VISITOR_PARAMETERSRelation newVISITOR_PARAMETERSRelation(JsonObject relationship, JsonPNode neoVisitor, JsonPNode visitorParameter) {
			return new VISITOR_PARAMETERSRelation(relationship, neoVisitor, visitorParameter);
		}

	class VISITOR_PARAMETERSRelation extends JsonRelationship {

		VISITOR_PARAMETERSRelation(JsonObject relationship, JsonPNode neoVisitor, JsonPNode visitorParameter) {
			super(relationship, "VISITOR_PARAMETERS", neoVisitor, visitorParameter, Color.decode("#bdbdbd"), Color.decode("#636363"), Color.decode("#e34a33"));
		}

		@Override
		protected void onRightClick(JPopupMenu pop, NodeCanvas canvas) {

			super.onRightClick(pop, canvas);
		}
	}

	// NeoDomainDomain VISITOR_PARAMETERS
	protected final class VISITOR_PARAMETERSForm extends JPanel {

		private final String title = "New VISITOR_PARAMETERS";
		private String uuid;

		protected VISITOR_PARAMETERSForm() {
			super(new BorderLayout());
				this.uuid = null;

			int c = 1, r = 1;
			final FormPanel form = new FormPanel("100dlu,4dlu,150dlu", "");
			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			add(form.build(), BorderLayout.CENTER);
		}

		protected VISITOR_PARAMETERSForm(JsonObject content) {
			this();
			this.uuid = content.getString("uuid");
		}


		@Deprecated
		protected JsonObject toJson() {
			return new JsonObject()	;}

		protected VISITOR_PARAMETERS getVISITOR_PARAMETERS() {
			final JsonObject jsonObject = new JsonObject();
			if (uuid != null) jsonObject.put("uuid", uuid);
			return mapVISITOR_PARAMETERS(jsonObject);
		}

		protected void show(NodeCanvas canvas, ConfirmAction confirmAction) {
			showDialog(this, canvas, title, confirmAction);
		}
	}

	public void relateNeoVisitor_VISITOR_PARAMETERS_VisitorParameter(UUID neoVisitor, VisitorParameter visitorParameter, VISITOR_PARAMETERSHandler handler) {
		final JsonObject parameters = new JsonObject().put("NeoVisitor", neoVisitor.toString()).put("VisitorParameter", visitorParameter.toJson());
		send("neoDomainDomain.relate.neoVisitor.VISITOR_PARAMETERS.visitorParameter", parameters, handler);
	}

	public static abstract class VISITOR_PARAMETERSHandler extends MessageHandler {

		public abstract void onSuccess(VISITOR_PARAMETERS relation, VisitorParameter visitorParameter);

		@Override
		protected void handleSuccess(JsonObject payload) {
			onSuccess(mapVISITOR_PARAMETERS(payload.getJsonObject("VISITOR_PARAMETERS")), mapVisitorParameter(payload.getJsonObject("VisitorParameter")));
		}
	}

	// MISSING
	// one-to-many
	protected class ExpandVisitorParameter_VISITOR_PARAMETERS_FOR_NeoVisitorHandler extends VisitorParameter_VISITOR_PARAMETERS_FOR_NeoVisitorHandler {

		private final NeoVisitorNode node;

		ExpandVisitorParameter_VISITOR_PARAMETERS_FOR_NeoVisitorHandler(NeoVisitorNode node) {
			this.node = node;
		}

		@Override
		public void onSuccess(Iterator<NeoVisitorVISITOR_PARAMETERS> it) {
			final Set<BasePNode> nodes = new LinkedHashSet<>();
			final Set<Relation> relations = new LinkedHashSet<>();
			while(it.hasNext()) {
				final NeoVisitorVISITOR_PARAMETERS next = it.next();
				final VisitorParameterNode entityNode = newVisitorParameterNode(next.getVisitorParameter().toJson());
				nodes.add(entityNode);
				relations.add(newVISITOR_PARAMETERSRelation(next.getVISITOR_PARAMETERS().toJson(), node, entityNode));
			}
			addNodesAndRelations(nodes, relations, new LayoutRelativeTo(node));
		}
	}

	protected void add_VisitorParameter_VISITOR_PARAMETERS_FOR_NeoVisitor(final NeoVisitorNode node, NodeCanvas canvas) {

		final VisitorParameterForm form = new VisitorParameterForm();
		form.show(canvas, new ConfirmAction() {
			@Override
			public void verifyAndCommit() throws Exception {
				final VisitorParameter entity = newVisitorParameter(form.toJson());

				relateNeoVisitor_VISITOR_PARAMETERS_VisitorParameter(node.getUUID(), entity, new VISITOR_PARAMETERSHandler() {
					@Override
					public void onSuccess(VISITOR_PARAMETERS relation, VisitorParameter newEntity) {
						final VisitorParameterNode newNode = newVisitorParameterNode(newEntity.toJson());
						addNodeAndRelation(newNode, newVISITOR_PARAMETERSRelation(relation.toJson(), node, newNode), new LayoutRelativeTo(node));
					}
				});
			}
		});
	}

	// message support
	public void get_VisitorParameter_VISITOR_PARAMETERS_FOR_NeoVisitor(UUID neoVisitor, VisitorParameter_VISITOR_PARAMETERS_FOR_NeoVisitorHandler handler) {
		send("neoDomainDomain.get.visitorParameter.VISITOR_PARAMETERS.neoVisitor", new JsonObject().put("NeoVisitor", neoVisitor.toString()), handler);
	}

	public void get_NeoVisitor_VISITOR_PARAMETERS_FOR_VisitorParameter(UUID visitorParameter, VISITOR_PARAMETERSNeoVisitorHandler handler) {
		send("neoDomainDomain.get.neoVisitor.VISITOR_PARAMETERS.visitorParameter", new JsonObject().put("VisitorParameter", visitorParameter.toString()), handler);
	}

	public interface NeoVisitorVISITOR_PARAMETERS {

		public VisitorParameter getVisitorParameter();

		public VISITOR_PARAMETERS getVISITOR_PARAMETERS();
	}

	public static abstract class VisitorParameter_VISITOR_PARAMETERS_FOR_NeoVisitorHandler extends ListHandler<NeoVisitorVISITOR_PARAMETERS> {

		@Override
		protected NeoVisitorVISITOR_PARAMETERS map(JsonObject payload) {
			return new NeoVisitorVISITOR_PARAMETERS() {
				@Override
				public VisitorParameter getVisitorParameter() {
					return mapVisitorParameter(payload.getJsonObject("VisitorParameter"));
				}

				@Override
				public VISITOR_PARAMETERS getVISITOR_PARAMETERS() {
					return mapVISITOR_PARAMETERS(payload.getJsonObject("VISITOR_PARAMETERS"));
				}
			};
		}
	}

	public static abstract class VISITOR_PARAMETERSNeoVisitorHandler extends MessageHandler {

		public abstract void onSuccess(VISITOR_PARAMETERS VISITOR_PARAMETERS, NeoVisitor neoVisitor);

		@Override
		protected void handleSuccess(JsonObject payload) {
			if (payload.isEmpty()) return;
			onSuccess(mapVISITOR_PARAMETERS(payload.getJsonObject("VISITOR_PARAMETERS")),mapNeoVisitor(payload.getJsonObject("NeoVisitor")));
		}
	}

	public void updateVISITOR_PARAMETERS(UUID srcNode, VISITOR_PARAMETERS relationship, VISITOR_PARAMETERSHandler handler) {
		send("neoDomainDomain.update.VISITOR_PARAMETERS", new JsonObject().put("uuid", srcNode.toString()).put("VISITOR_PARAMETERS", relationship.toJson()), handler);
	}

	private static VISITOR_PARAMETERS mapVISITOR_PARAMETERS(JsonObject payload) {
		return new VISITOR_PARAMETERS() {
			@Override
			public UUID getUUID() {
				return UUID.fromString(payload.getString("uuid"));
			}

			@Override
			public JsonObject toJson() {
				return payload;
			}

			@Override
			public String toString() {
				return toJson().encode();
			}
		};
	}

	interface VISITOR_PARAMETERS {

		UUID getUUID();

		JsonObject toJson();

	}


	// ONE 'NeoEntity' (NeoEntity) -> ENTITY_VISITORS -> MANY 'NeoVisitor' (NeoVisitor)

	// 
	protected ENTITY_VISITORSRelation newENTITY_VISITORSRelation(JsonObject relationship, JsonPNode neoEntity, JsonPNode neoVisitor) {
			return new ENTITY_VISITORSRelation(relationship, neoEntity, neoVisitor);
		}

	class ENTITY_VISITORSRelation extends JsonRelationship {

		ENTITY_VISITORSRelation(JsonObject relationship, JsonPNode neoEntity, JsonPNode neoVisitor) {
			super(relationship, "ENTITY_VISITORS", neoEntity, neoVisitor, Color.decode("#bdbdbd"), Color.decode("#636363"), Color.decode("#e34a33"));
		}

		@Override
		protected void onRightClick(JPopupMenu pop, NodeCanvas canvas) {

			super.onRightClick(pop, canvas);
		}
	}

	// NeoDomainDomain ENTITY_VISITORS
	protected final class ENTITY_VISITORSForm extends JPanel {

		private final String title = "New ENTITY_VISITORS";
		private String uuid;

		protected ENTITY_VISITORSForm() {
			super(new BorderLayout());
				this.uuid = null;

			int c = 1, r = 1;
			final FormPanel form = new FormPanel("100dlu,4dlu,150dlu", "");
			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			add(form.build(), BorderLayout.CENTER);
		}

		protected ENTITY_VISITORSForm(JsonObject content) {
			this();
			this.uuid = content.getString("uuid");
		}


		@Deprecated
		protected JsonObject toJson() {
			return new JsonObject()	;}

		protected ENTITY_VISITORS getENTITY_VISITORS() {
			final JsonObject jsonObject = new JsonObject();
			if (uuid != null) jsonObject.put("uuid", uuid);
			return mapENTITY_VISITORS(jsonObject);
		}

		protected void show(NodeCanvas canvas, ConfirmAction confirmAction) {
			showDialog(this, canvas, title, confirmAction);
		}
	}

	public void relateNeoEntity_ENTITY_VISITORS_NeoVisitor(UUID neoEntity, NeoVisitor neoVisitor, ENTITY_VISITORSHandler handler) {
		final JsonObject parameters = new JsonObject().put("NeoEntity", neoEntity.toString()).put("NeoVisitor", neoVisitor.toJson());
		send("neoDomainDomain.relate.neoEntity.ENTITY_VISITORS.neoVisitor", parameters, handler);
	}

	public static abstract class ENTITY_VISITORSHandler extends MessageHandler {

		public abstract void onSuccess(ENTITY_VISITORS relation, NeoVisitor neoVisitor);

		@Override
		protected void handleSuccess(JsonObject payload) {
			onSuccess(mapENTITY_VISITORS(payload.getJsonObject("ENTITY_VISITORS")), mapNeoVisitor(payload.getJsonObject("NeoVisitor")));
		}
	}

	// MISSING
	// one-to-many
	protected class ExpandNeoVisitor_ENTITY_VISITORS_FOR_NeoEntityHandler extends NeoVisitor_ENTITY_VISITORS_FOR_NeoEntityHandler {

		private final NeoEntityNode node;

		ExpandNeoVisitor_ENTITY_VISITORS_FOR_NeoEntityHandler(NeoEntityNode node) {
			this.node = node;
		}

		@Override
		public void onSuccess(Iterator<NeoEntityENTITY_VISITORS> it) {
			final Set<BasePNode> nodes = new LinkedHashSet<>();
			final Set<Relation> relations = new LinkedHashSet<>();
			while(it.hasNext()) {
				final NeoEntityENTITY_VISITORS next = it.next();
				final NeoVisitorNode entityNode = newNeoVisitorNode(next.getNeoVisitor().toJson());
				nodes.add(entityNode);
				relations.add(newENTITY_VISITORSRelation(next.getENTITY_VISITORS().toJson(), node, entityNode));
			}
			addNodesAndRelations(nodes, relations, new LayoutRelativeTo(node));
		}
	}

	protected void add_NeoVisitor_ENTITY_VISITORS_FOR_NeoEntity(final NeoEntityNode node, NodeCanvas canvas) {

		final NeoVisitorForm form = new NeoVisitorForm();
		form.show(canvas, new ConfirmAction() {
			@Override
			public void verifyAndCommit() throws Exception {
				final NeoVisitor entity = newNeoVisitor(form.toJson());

				relateNeoEntity_ENTITY_VISITORS_NeoVisitor(node.getUUID(), entity, new ENTITY_VISITORSHandler() {
					@Override
					public void onSuccess(ENTITY_VISITORS relation, NeoVisitor newEntity) {
						final NeoVisitorNode newNode = newNeoVisitorNode(newEntity.toJson());
						addNodeAndRelation(newNode, newENTITY_VISITORSRelation(relation.toJson(), node, newNode), new LayoutRelativeTo(node));
					}
				});
			}
		});
	}

	// message support
	public void get_NeoVisitor_ENTITY_VISITORS_FOR_NeoEntity(UUID neoEntity, NeoVisitor_ENTITY_VISITORS_FOR_NeoEntityHandler handler) {
		send("neoDomainDomain.get.neoVisitor.ENTITY_VISITORS.neoEntity", new JsonObject().put("NeoEntity", neoEntity.toString()), handler);
	}

	public void get_NeoEntity_ENTITY_VISITORS_FOR_NeoVisitor(UUID neoVisitor, ENTITY_VISITORSNeoEntityHandler handler) {
		send("neoDomainDomain.get.neoEntity.ENTITY_VISITORS.neoVisitor", new JsonObject().put("NeoVisitor", neoVisitor.toString()), handler);
	}

	public interface NeoEntityENTITY_VISITORS {

		public NeoVisitor getNeoVisitor();

		public ENTITY_VISITORS getENTITY_VISITORS();
	}

	public static abstract class NeoVisitor_ENTITY_VISITORS_FOR_NeoEntityHandler extends ListHandler<NeoEntityENTITY_VISITORS> {

		@Override
		protected NeoEntityENTITY_VISITORS map(JsonObject payload) {
			return new NeoEntityENTITY_VISITORS() {
				@Override
				public NeoVisitor getNeoVisitor() {
					return mapNeoVisitor(payload.getJsonObject("NeoVisitor"));
				}

				@Override
				public ENTITY_VISITORS getENTITY_VISITORS() {
					return mapENTITY_VISITORS(payload.getJsonObject("ENTITY_VISITORS"));
				}
			};
		}
	}

	public static abstract class ENTITY_VISITORSNeoEntityHandler extends MessageHandler {

		public abstract void onSuccess(ENTITY_VISITORS ENTITY_VISITORS, NeoEntity neoEntity);

		@Override
		protected void handleSuccess(JsonObject payload) {
			if (payload.isEmpty()) return;
			onSuccess(mapENTITY_VISITORS(payload.getJsonObject("ENTITY_VISITORS")),mapNeoEntity(payload.getJsonObject("NeoEntity")));
		}
	}

	public void updateENTITY_VISITORS(UUID srcNode, ENTITY_VISITORS relationship, ENTITY_VISITORSHandler handler) {
		send("neoDomainDomain.update.ENTITY_VISITORS", new JsonObject().put("uuid", srcNode.toString()).put("ENTITY_VISITORS", relationship.toJson()), handler);
	}

	private static ENTITY_VISITORS mapENTITY_VISITORS(JsonObject payload) {
		return new ENTITY_VISITORS() {
			@Override
			public UUID getUUID() {
				return UUID.fromString(payload.getString("uuid"));
			}

			@Override
			public JsonObject toJson() {
				return payload;
			}

			@Override
			public String toString() {
				return toJson().encode();
			}
		};
	}

	interface ENTITY_VISITORS {

		UUID getUUID();

		JsonObject toJson();

	}


	// MANY 'NeoEntity' (NeoEntity) -> ENTITY_RELATION -> MANY 'NeoRelation' (NeoRelation)

	// 
	protected ENTITY_RELATIONRelation newENTITY_RELATIONRelation(JsonObject relationship, JsonPNode neoEntity, JsonPNode neoRelation) {
			return new ENTITY_RELATIONRelation(relationship, neoEntity, neoRelation);
		}

	class ENTITY_RELATIONRelation extends JsonRelationship {

		ENTITY_RELATIONRelation(JsonObject relationship, JsonPNode neoEntity, JsonPNode neoRelation) {
			super(relationship, "ENTITY_RELATION", neoEntity, neoRelation, Color.decode("#bdbdbd"), Color.decode("#636363"), Color.decode("#e34a33"));
		}

		@Override
		protected void onRightClick(JPopupMenu pop, NodeCanvas canvas) {

			super.onRightClick(pop, canvas);
		}
	}

	// NeoDomainDomain ENTITY_RELATION
	protected final class ENTITY_RELATIONForm extends JPanel {

		private final String title = "New ENTITY_RELATION";
		private String uuid;

		protected ENTITY_RELATIONForm() {
			super(new BorderLayout());
				this.uuid = null;

			int c = 1, r = 1;
			final FormPanel form = new FormPanel("100dlu,4dlu,150dlu", "");
			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			add(form.build(), BorderLayout.CENTER);
		}

		protected ENTITY_RELATIONForm(JsonObject content) {
			this();
			this.uuid = content.getString("uuid");
		}


		@Deprecated
		protected JsonObject toJson() {
			return new JsonObject()	;}

		protected ENTITY_RELATION getENTITY_RELATION() {
			final JsonObject jsonObject = new JsonObject();
			if (uuid != null) jsonObject.put("uuid", uuid);
			return mapENTITY_RELATION(jsonObject);
		}

		protected void show(NodeCanvas canvas, ConfirmAction confirmAction) {
			showDialog(this, canvas, title, confirmAction);
		}
	}

	public void relateNeoEntity_ENTITY_RELATION_NeoRelation(UUID neoEntity, NeoRelation neoRelation, ENTITY_RELATIONHandler handler) {
		final JsonObject parameters = new JsonObject().put("NeoEntity", neoEntity.toString()).put("NeoRelation", neoRelation.toJson());
		send("neoDomainDomain.relate.neoEntity.ENTITY_RELATION.neoRelation", parameters, handler);
	}

	public static abstract class ENTITY_RELATIONHandler extends MessageHandler {

		public abstract void onSuccess(ENTITY_RELATION relation, NeoRelation neoRelation);

		@Override
		protected void handleSuccess(JsonObject payload) {
			onSuccess(mapENTITY_RELATION(payload.getJsonObject("ENTITY_RELATION")), mapNeoRelation(payload.getJsonObject("NeoRelation")));
		}
	}

	// MISSING
	// many-to-many
	protected class ExpandNeoRelation_ENTITY_RELATION_FOR_NeoEntityHandler extends NeoRelation_ENTITY_RELATION_FOR_NeoEntityHandler {

		private final NeoEntityNode node;

		ExpandNeoRelation_ENTITY_RELATION_FOR_NeoEntityHandler(NeoEntityNode node) {
			this.node = node;
		}

		@Override
		public void onSuccess(Iterator<NeoRelationENTITY_RELATION> it) {
			final Set<BasePNode> nodes = new LinkedHashSet<>();
			final Set<Relation> relations = new LinkedHashSet<>();
			while(it.hasNext()) {
				final NeoRelationENTITY_RELATION next = it.next();
				final NeoRelationNode entityNode = newNeoRelationNode(next.getNeoRelation().toJson());
				nodes.add(entityNode);
				relations.add(newENTITY_RELATIONRelation(next.getENTITY_RELATION().toJson(), node, entityNode));
			}
			addNodesAndRelations(nodes, relations, new LayoutRelativeTo(node));
		}
	}

	protected void add_NeoRelation_ENTITY_RELATION_FOR_NeoEntity(final NeoEntityNode node, NodeCanvas canvas) {

		final NeoRelationForm form = new NeoRelationForm();
		form.show(canvas, new ConfirmAction() {
			@Override
			public void verifyAndCommit() throws Exception {
				final NeoRelation entity = newNeoRelation(form.toJson());
				relateNeoEntity_ENTITY_RELATION_NeoRelation(node.getUUID(), entity, new ENTITY_RELATIONHandler() {
					@Override
					public void onSuccess(ENTITY_RELATION relation, NeoRelation newEntity) {
						final NeoRelationNode newNode = newNeoRelationNode(newEntity.toJson());
						addNodeAndRelation(newNode, newENTITY_RELATIONRelation(relation.toJson(), node, newNode), new LayoutRelativeTo(node));
					}
				});
			}
		});
	}

	public void get_NeoRelation_ENTITY_RELATION_FOR_NeoEntity(UUID neoEntity, NeoRelation_ENTITY_RELATION_FOR_NeoEntityHandler handler) {
		send("neoDomainDomain.get.neoRelation.ENTITY_RELATION.neoEntity", new JsonObject().put("NeoEntity", neoEntity.toString()), handler);
	}

	public void get_NeoEntity_ENTITY_RELATION_FOR_NeoRelation(UUID neoRelation, NeoEntity_ENTITY_RELATION_FOR_NeoRelationHandler handler) {
		send("neoDomainDomain.get.neoEntity.ENTITY_RELATION.neoRelation", new JsonObject().put("NeoRelation", neoRelation.toString()), handler);
	}

	public interface NeoRelationENTITY_RELATION {

		public NeoRelation getNeoRelation();

		public ENTITY_RELATION getENTITY_RELATION();
	}

	public static abstract class NeoRelation_ENTITY_RELATION_FOR_NeoEntityHandler extends ListHandler<NeoRelationENTITY_RELATION> {

		@Override
		protected NeoRelationENTITY_RELATION map(JsonObject payload) {
			return new NeoRelationENTITY_RELATION() {
				@Override
				public NeoRelation getNeoRelation() {
					return mapNeoRelation(payload.getJsonObject("NeoRelation"));
				}

				@Override
				public ENTITY_RELATION getENTITY_RELATION() {
					return mapENTITY_RELATION(payload.getJsonObject("ENTITY_RELATION"));
				}
			};
		}
	}

	public interface NeoEntityENTITY_RELATION {

		public NeoEntity getNeoEntity();

		public ENTITY_RELATION getENTITY_RELATION();
	}

	public static abstract class NeoEntity_ENTITY_RELATION_FOR_NeoRelationHandler extends ListHandler<NeoEntityENTITY_RELATION> {

		@Override
		protected NeoEntityENTITY_RELATION map(JsonObject payload) {
			return new NeoEntityENTITY_RELATION() {
				@Override
				public NeoEntity getNeoEntity() {
					return mapNeoEntity(payload.getJsonObject("NeoEntity"));
				}

				@Override
				public ENTITY_RELATION getENTITY_RELATION() {
					return mapENTITY_RELATION(payload.getJsonObject("ENTITY_RELATION"));
				}
			};
		}
	}

	public void updateENTITY_RELATION(UUID srcNode, ENTITY_RELATION relationship, ENTITY_RELATIONHandler handler) {
		send("neoDomainDomain.update.ENTITY_RELATION", new JsonObject().put("uuid", srcNode.toString()).put("ENTITY_RELATION", relationship.toJson()), handler);
	}

	private static ENTITY_RELATION mapENTITY_RELATION(JsonObject payload) {
		return new ENTITY_RELATION() {
			@Override
			public UUID getUUID() {
				return UUID.fromString(payload.getString("uuid"));
			}

			@Override
			public JsonObject toJson() {
				return payload;
			}

			@Override
			public String toString() {
				return toJson().encode();
			}
		};
	}

	interface ENTITY_RELATION {

		UUID getUUID();

		JsonObject toJson();

	}


	// ONE 'NeoRelation' (NeoRelation) -> RELATION_PROPERTIES -> MANY 'NeoProperty' (NeoProperty)

	// 
	protected RELATION_PROPERTIESRelation newRELATION_PROPERTIESRelation(JsonObject relationship, JsonPNode neoRelation, JsonPNode neoProperty) {
			return new RELATION_PROPERTIESRelation(relationship, neoRelation, neoProperty);
		}

	class RELATION_PROPERTIESRelation extends JsonRelationship {

		RELATION_PROPERTIESRelation(JsonObject relationship, JsonPNode neoRelation, JsonPNode neoProperty) {
			super(relationship, "RELATION_PROPERTIES", neoRelation, neoProperty, Color.decode("#bdbdbd"), Color.decode("#636363"), Color.decode("#e34a33"));
		}

		@Override
		protected void onRightClick(JPopupMenu pop, NodeCanvas canvas) {

			super.onRightClick(pop, canvas);
		}
	}

	// NeoDomainDomain RELATION_PROPERTIES
	protected final class RELATION_PROPERTIESForm extends JPanel {

		private final String title = "New RELATION_PROPERTIES";
		private String uuid;

		protected RELATION_PROPERTIESForm() {
			super(new BorderLayout());
				this.uuid = null;

			int c = 1, r = 1;
			final FormPanel form = new FormPanel("100dlu,4dlu,150dlu", "");
			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			add(form.build(), BorderLayout.CENTER);
		}

		protected RELATION_PROPERTIESForm(JsonObject content) {
			this();
			this.uuid = content.getString("uuid");
		}


		@Deprecated
		protected JsonObject toJson() {
			return new JsonObject()	;}

		protected RELATION_PROPERTIES getRELATION_PROPERTIES() {
			final JsonObject jsonObject = new JsonObject();
			if (uuid != null) jsonObject.put("uuid", uuid);
			return mapRELATION_PROPERTIES(jsonObject);
		}

		protected void show(NodeCanvas canvas, ConfirmAction confirmAction) {
			showDialog(this, canvas, title, confirmAction);
		}
	}

	public void relateNeoRelation_RELATION_PROPERTIES_NeoProperty(UUID neoRelation, NeoProperty neoProperty, RELATION_PROPERTIESHandler handler) {
		final JsonObject parameters = new JsonObject().put("NeoRelation", neoRelation.toString()).put("NeoProperty", neoProperty.toJson());
		send("neoDomainDomain.relate.neoRelation.RELATION_PROPERTIES.neoProperty", parameters, handler);
	}

	public static abstract class RELATION_PROPERTIESHandler extends MessageHandler {

		public abstract void onSuccess(RELATION_PROPERTIES relation, NeoProperty neoProperty);

		@Override
		protected void handleSuccess(JsonObject payload) {
			onSuccess(mapRELATION_PROPERTIES(payload.getJsonObject("RELATION_PROPERTIES")), mapNeoProperty(payload.getJsonObject("NeoProperty")));
		}
	}

	// MISSING
	// one-to-many
	protected class ExpandNeoProperty_RELATION_PROPERTIES_FOR_NeoRelationHandler extends NeoProperty_RELATION_PROPERTIES_FOR_NeoRelationHandler {

		private final NeoRelationNode node;

		ExpandNeoProperty_RELATION_PROPERTIES_FOR_NeoRelationHandler(NeoRelationNode node) {
			this.node = node;
		}

		@Override
		public void onSuccess(Iterator<NeoRelationRELATION_PROPERTIES> it) {
			final Set<BasePNode> nodes = new LinkedHashSet<>();
			final Set<Relation> relations = new LinkedHashSet<>();
			while(it.hasNext()) {
				final NeoRelationRELATION_PROPERTIES next = it.next();
				final NeoPropertyNode entityNode = newNeoPropertyNode(next.getNeoProperty().toJson());
				nodes.add(entityNode);
				relations.add(newRELATION_PROPERTIESRelation(next.getRELATION_PROPERTIES().toJson(), node, entityNode));
			}
			addNodesAndRelations(nodes, relations, new LayoutRelativeTo(node));
		}
	}

	protected void add_NeoProperty_RELATION_PROPERTIES_FOR_NeoRelation(final NeoRelationNode node, NodeCanvas canvas) {

		final NeoPropertyForm form = new NeoPropertyForm();
		form.show(canvas, new ConfirmAction() {
			@Override
			public void verifyAndCommit() throws Exception {
				final NeoProperty entity = newNeoProperty(form.toJson());

				relateNeoRelation_RELATION_PROPERTIES_NeoProperty(node.getUUID(), entity, new RELATION_PROPERTIESHandler() {
					@Override
					public void onSuccess(RELATION_PROPERTIES relation, NeoProperty newEntity) {
						final NeoPropertyNode newNode = newNeoPropertyNode(newEntity.toJson());
						addNodeAndRelation(newNode, newRELATION_PROPERTIESRelation(relation.toJson(), node, newNode), new LayoutRelativeTo(node));
					}
				});
			}
		});
	}

	// message support
	public void get_NeoProperty_RELATION_PROPERTIES_FOR_NeoRelation(UUID neoRelation, NeoProperty_RELATION_PROPERTIES_FOR_NeoRelationHandler handler) {
		send("neoDomainDomain.get.neoProperty.RELATION_PROPERTIES.neoRelation", new JsonObject().put("NeoRelation", neoRelation.toString()), handler);
	}

	public void get_NeoRelation_RELATION_PROPERTIES_FOR_NeoProperty(UUID neoProperty, RELATION_PROPERTIESNeoRelationHandler handler) {
		send("neoDomainDomain.get.neoRelation.RELATION_PROPERTIES.neoProperty", new JsonObject().put("NeoProperty", neoProperty.toString()), handler);
	}

	public interface NeoRelationRELATION_PROPERTIES {

		public NeoProperty getNeoProperty();

		public RELATION_PROPERTIES getRELATION_PROPERTIES();
	}

	public static abstract class NeoProperty_RELATION_PROPERTIES_FOR_NeoRelationHandler extends ListHandler<NeoRelationRELATION_PROPERTIES> {

		@Override
		protected NeoRelationRELATION_PROPERTIES map(JsonObject payload) {
			return new NeoRelationRELATION_PROPERTIES() {
				@Override
				public NeoProperty getNeoProperty() {
					return mapNeoProperty(payload.getJsonObject("NeoProperty"));
				}

				@Override
				public RELATION_PROPERTIES getRELATION_PROPERTIES() {
					return mapRELATION_PROPERTIES(payload.getJsonObject("RELATION_PROPERTIES"));
				}
			};
		}
	}

	public static abstract class RELATION_PROPERTIESNeoRelationHandler extends MessageHandler {

		public abstract void onSuccess(RELATION_PROPERTIES RELATION_PROPERTIES, NeoRelation neoRelation);

		@Override
		protected void handleSuccess(JsonObject payload) {
			if (payload.isEmpty()) return;
			onSuccess(mapRELATION_PROPERTIES(payload.getJsonObject("RELATION_PROPERTIES")),mapNeoRelation(payload.getJsonObject("NeoRelation")));
		}
	}

	public void updateRELATION_PROPERTIES(UUID srcNode, RELATION_PROPERTIES relationship, RELATION_PROPERTIESHandler handler) {
		send("neoDomainDomain.update.RELATION_PROPERTIES", new JsonObject().put("uuid", srcNode.toString()).put("RELATION_PROPERTIES", relationship.toJson()), handler);
	}

	private static RELATION_PROPERTIES mapRELATION_PROPERTIES(JsonObject payload) {
		return new RELATION_PROPERTIES() {
			@Override
			public UUID getUUID() {
				return UUID.fromString(payload.getString("uuid"));
			}

			@Override
			public JsonObject toJson() {
				return payload;
			}

			@Override
			public String toString() {
				return toJson().encode();
			}
		};
	}

	interface RELATION_PROPERTIES {

		UUID getUUID();

		JsonObject toJson();

	}


	// ONE 'NeoEntity' (NeoEntity) -> ENTITY_PROPERTIES -> MANY 'NeoProperty' (NeoProperty)

	// 
	protected ENTITY_PROPERTIESRelation newENTITY_PROPERTIESRelation(JsonObject relationship, JsonPNode neoEntity, JsonPNode neoProperty) {
			return new ENTITY_PROPERTIESRelation(relationship, neoEntity, neoProperty);
		}

	class ENTITY_PROPERTIESRelation extends JsonRelationship {

		ENTITY_PROPERTIESRelation(JsonObject relationship, JsonPNode neoEntity, JsonPNode neoProperty) {
			super(relationship, "ENTITY_PROPERTIES", neoEntity, neoProperty, Color.decode("#bdbdbd"), Color.decode("#636363"), Color.decode("#e34a33"));
		}

		@Override
		protected void onRightClick(JPopupMenu pop, NodeCanvas canvas) {

			super.onRightClick(pop, canvas);
		}
	}

	// NeoDomainDomain ENTITY_PROPERTIES
	protected final class ENTITY_PROPERTIESForm extends JPanel {

		private final String title = "New ENTITY_PROPERTIES";
		private String uuid;

		protected ENTITY_PROPERTIESForm() {
			super(new BorderLayout());
				this.uuid = null;

			int c = 1, r = 1;
			final FormPanel form = new FormPanel("100dlu,4dlu,150dlu", "");
			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			add(form.build(), BorderLayout.CENTER);
		}

		protected ENTITY_PROPERTIESForm(JsonObject content) {
			this();
			this.uuid = content.getString("uuid");
		}


		@Deprecated
		protected JsonObject toJson() {
			return new JsonObject()	;}

		protected ENTITY_PROPERTIES getENTITY_PROPERTIES() {
			final JsonObject jsonObject = new JsonObject();
			if (uuid != null) jsonObject.put("uuid", uuid);
			return mapENTITY_PROPERTIES(jsonObject);
		}

		protected void show(NodeCanvas canvas, ConfirmAction confirmAction) {
			showDialog(this, canvas, title, confirmAction);
		}
	}

	public void relateNeoEntity_ENTITY_PROPERTIES_NeoProperty(UUID neoEntity, NeoProperty neoProperty, ENTITY_PROPERTIESHandler handler) {
		final JsonObject parameters = new JsonObject().put("NeoEntity", neoEntity.toString()).put("NeoProperty", neoProperty.toJson());
		send("neoDomainDomain.relate.neoEntity.ENTITY_PROPERTIES.neoProperty", parameters, handler);
	}

	public static abstract class ENTITY_PROPERTIESHandler extends MessageHandler {

		public abstract void onSuccess(ENTITY_PROPERTIES relation, NeoProperty neoProperty);

		@Override
		protected void handleSuccess(JsonObject payload) {
			onSuccess(mapENTITY_PROPERTIES(payload.getJsonObject("ENTITY_PROPERTIES")), mapNeoProperty(payload.getJsonObject("NeoProperty")));
		}
	}

	// MISSING
	// one-to-many
	protected class ExpandNeoProperty_ENTITY_PROPERTIES_FOR_NeoEntityHandler extends NeoProperty_ENTITY_PROPERTIES_FOR_NeoEntityHandler {

		private final NeoEntityNode node;

		ExpandNeoProperty_ENTITY_PROPERTIES_FOR_NeoEntityHandler(NeoEntityNode node) {
			this.node = node;
		}

		@Override
		public void onSuccess(Iterator<NeoEntityENTITY_PROPERTIES> it) {
			final Set<BasePNode> nodes = new LinkedHashSet<>();
			final Set<Relation> relations = new LinkedHashSet<>();
			while(it.hasNext()) {
				final NeoEntityENTITY_PROPERTIES next = it.next();
				final NeoPropertyNode entityNode = newNeoPropertyNode(next.getNeoProperty().toJson());
				nodes.add(entityNode);
				relations.add(newENTITY_PROPERTIESRelation(next.getENTITY_PROPERTIES().toJson(), node, entityNode));
			}
			addNodesAndRelations(nodes, relations, new LayoutRelativeTo(node));
		}
	}

	protected void add_NeoProperty_ENTITY_PROPERTIES_FOR_NeoEntity(final NeoEntityNode node, NodeCanvas canvas) {

		final NeoPropertyForm form = new NeoPropertyForm();
		form.show(canvas, new ConfirmAction() {
			@Override
			public void verifyAndCommit() throws Exception {
				final NeoProperty entity = newNeoProperty(form.toJson());

				relateNeoEntity_ENTITY_PROPERTIES_NeoProperty(node.getUUID(), entity, new ENTITY_PROPERTIESHandler() {
					@Override
					public void onSuccess(ENTITY_PROPERTIES relation, NeoProperty newEntity) {
						final NeoPropertyNode newNode = newNeoPropertyNode(newEntity.toJson());
						addNodeAndRelation(newNode, newENTITY_PROPERTIESRelation(relation.toJson(), node, newNode), new LayoutRelativeTo(node));
					}
				});
			}
		});
	}

	// message support
	public void get_NeoProperty_ENTITY_PROPERTIES_FOR_NeoEntity(UUID neoEntity, NeoProperty_ENTITY_PROPERTIES_FOR_NeoEntityHandler handler) {
		send("neoDomainDomain.get.neoProperty.ENTITY_PROPERTIES.neoEntity", new JsonObject().put("NeoEntity", neoEntity.toString()), handler);
	}

	public void get_NeoEntity_ENTITY_PROPERTIES_FOR_NeoProperty(UUID neoProperty, ENTITY_PROPERTIESNeoEntityHandler handler) {
		send("neoDomainDomain.get.neoEntity.ENTITY_PROPERTIES.neoProperty", new JsonObject().put("NeoProperty", neoProperty.toString()), handler);
	}

	public interface NeoEntityENTITY_PROPERTIES {

		public NeoProperty getNeoProperty();

		public ENTITY_PROPERTIES getENTITY_PROPERTIES();
	}

	public static abstract class NeoProperty_ENTITY_PROPERTIES_FOR_NeoEntityHandler extends ListHandler<NeoEntityENTITY_PROPERTIES> {

		@Override
		protected NeoEntityENTITY_PROPERTIES map(JsonObject payload) {
			return new NeoEntityENTITY_PROPERTIES() {
				@Override
				public NeoProperty getNeoProperty() {
					return mapNeoProperty(payload.getJsonObject("NeoProperty"));
				}

				@Override
				public ENTITY_PROPERTIES getENTITY_PROPERTIES() {
					return mapENTITY_PROPERTIES(payload.getJsonObject("ENTITY_PROPERTIES"));
				}
			};
		}
	}

	public static abstract class ENTITY_PROPERTIESNeoEntityHandler extends MessageHandler {

		public abstract void onSuccess(ENTITY_PROPERTIES ENTITY_PROPERTIES, NeoEntity neoEntity);

		@Override
		protected void handleSuccess(JsonObject payload) {
			if (payload.isEmpty()) return;
			onSuccess(mapENTITY_PROPERTIES(payload.getJsonObject("ENTITY_PROPERTIES")),mapNeoEntity(payload.getJsonObject("NeoEntity")));
		}
	}

	public void updateENTITY_PROPERTIES(UUID srcNode, ENTITY_PROPERTIES relationship, ENTITY_PROPERTIESHandler handler) {
		send("neoDomainDomain.update.ENTITY_PROPERTIES", new JsonObject().put("uuid", srcNode.toString()).put("ENTITY_PROPERTIES", relationship.toJson()), handler);
	}

	private static ENTITY_PROPERTIES mapENTITY_PROPERTIES(JsonObject payload) {
		return new ENTITY_PROPERTIES() {
			@Override
			public UUID getUUID() {
				return UUID.fromString(payload.getString("uuid"));
			}

			@Override
			public JsonObject toJson() {
				return payload;
			}

			@Override
			public String toString() {
				return toJson().encode();
			}
		};
	}

	interface ENTITY_PROPERTIES {

		UUID getUUID();

		JsonObject toJson();

	}


	// MANY 'NeoRelation' (NeoRelation) -> RELATION_ENTITY -> MANY 'NeoEntity' (NeoEntity)

	// 
	protected RELATION_ENTITYRelation newRELATION_ENTITYRelation(JsonObject relationship, JsonPNode neoRelation, JsonPNode neoEntity) {
			return new RELATION_ENTITYRelation(relationship, neoRelation, neoEntity);
		}

	class RELATION_ENTITYRelation extends JsonRelationship {

		RELATION_ENTITYRelation(JsonObject relationship, JsonPNode neoRelation, JsonPNode neoEntity) {
			super(relationship, "RELATION_ENTITY", neoRelation, neoEntity, Color.decode("#bdbdbd"), Color.decode("#636363"), Color.decode("#e34a33"));
		}

		@Override
		protected void onRightClick(JPopupMenu pop, NodeCanvas canvas) {

			super.onRightClick(pop, canvas);
		}
	}

	// NeoDomainDomain RELATION_ENTITY
	protected final class RELATION_ENTITYForm extends JPanel {

		private final String title = "New RELATION_ENTITY";
		private String uuid;

		protected RELATION_ENTITYForm() {
			super(new BorderLayout());
				this.uuid = null;

			int c = 1, r = 1;
			final FormPanel form = new FormPanel("100dlu,4dlu,150dlu", "");
			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			add(form.build(), BorderLayout.CENTER);
		}

		protected RELATION_ENTITYForm(JsonObject content) {
			this();
			this.uuid = content.getString("uuid");
		}


		@Deprecated
		protected JsonObject toJson() {
			return new JsonObject()	;}

		protected RELATION_ENTITY getRELATION_ENTITY() {
			final JsonObject jsonObject = new JsonObject();
			if (uuid != null) jsonObject.put("uuid", uuid);
			return mapRELATION_ENTITY(jsonObject);
		}

		protected void show(NodeCanvas canvas, ConfirmAction confirmAction) {
			showDialog(this, canvas, title, confirmAction);
		}
	}

	public void relateNeoRelation_RELATION_ENTITY_NeoEntity(UUID neoRelation, NeoEntity neoEntity, RELATION_ENTITYHandler handler) {
		final JsonObject parameters = new JsonObject().put("NeoRelation", neoRelation.toString()).put("NeoEntity", neoEntity.toJson());
		send("neoDomainDomain.relate.neoRelation.RELATION_ENTITY.neoEntity", parameters, handler);
	}

	public static abstract class RELATION_ENTITYHandler extends MessageHandler {

		public abstract void onSuccess(RELATION_ENTITY relation, NeoEntity neoEntity);

		@Override
		protected void handleSuccess(JsonObject payload) {
			onSuccess(mapRELATION_ENTITY(payload.getJsonObject("RELATION_ENTITY")), mapNeoEntity(payload.getJsonObject("NeoEntity")));
		}
	}

	// MISSING
	// many-to-many
	protected class ExpandNeoEntity_RELATION_ENTITY_FOR_NeoRelationHandler extends NeoEntity_RELATION_ENTITY_FOR_NeoRelationHandler {

		private final NeoRelationNode node;

		ExpandNeoEntity_RELATION_ENTITY_FOR_NeoRelationHandler(NeoRelationNode node) {
			this.node = node;
		}

		@Override
		public void onSuccess(Iterator<NeoEntityRELATION_ENTITY> it) {
			final Set<BasePNode> nodes = new LinkedHashSet<>();
			final Set<Relation> relations = new LinkedHashSet<>();
			while(it.hasNext()) {
				final NeoEntityRELATION_ENTITY next = it.next();
				final NeoEntityNode entityNode = newNeoEntityNode(next.getNeoEntity().toJson());
				nodes.add(entityNode);
				relations.add(newRELATION_ENTITYRelation(next.getRELATION_ENTITY().toJson(), node, entityNode));
			}
			addNodesAndRelations(nodes, relations, new LayoutRelativeTo(node));
		}
	}

	protected void add_NeoEntity_RELATION_ENTITY_FOR_NeoRelation(final NeoRelationNode node, NodeCanvas canvas) {

		final NeoEntityForm form = new NeoEntityForm();
		form.show(canvas, new ConfirmAction() {
			@Override
			public void verifyAndCommit() throws Exception {
				final NeoEntity entity = newNeoEntity(form.toJson());
				relateNeoRelation_RELATION_ENTITY_NeoEntity(node.getUUID(), entity, new RELATION_ENTITYHandler() {
					@Override
					public void onSuccess(RELATION_ENTITY relation, NeoEntity newEntity) {
						final NeoEntityNode newNode = newNeoEntityNode(newEntity.toJson());
						addNodeAndRelation(newNode, newRELATION_ENTITYRelation(relation.toJson(), node, newNode), new LayoutRelativeTo(node));
					}
				});
			}
		});
	}

	public void get_NeoEntity_RELATION_ENTITY_FOR_NeoRelation(UUID neoRelation, NeoEntity_RELATION_ENTITY_FOR_NeoRelationHandler handler) {
		send("neoDomainDomain.get.neoEntity.RELATION_ENTITY.neoRelation", new JsonObject().put("NeoRelation", neoRelation.toString()), handler);
	}

	public void get_NeoRelation_RELATION_ENTITY_FOR_NeoEntity(UUID neoEntity, NeoRelation_RELATION_ENTITY_FOR_NeoEntityHandler handler) {
		send("neoDomainDomain.get.neoRelation.RELATION_ENTITY.neoEntity", new JsonObject().put("NeoEntity", neoEntity.toString()), handler);
	}

	public interface NeoEntityRELATION_ENTITY {

		public NeoEntity getNeoEntity();

		public RELATION_ENTITY getRELATION_ENTITY();
	}

	public static abstract class NeoEntity_RELATION_ENTITY_FOR_NeoRelationHandler extends ListHandler<NeoEntityRELATION_ENTITY> {

		@Override
		protected NeoEntityRELATION_ENTITY map(JsonObject payload) {
			return new NeoEntityRELATION_ENTITY() {
				@Override
				public NeoEntity getNeoEntity() {
					return mapNeoEntity(payload.getJsonObject("NeoEntity"));
				}

				@Override
				public RELATION_ENTITY getRELATION_ENTITY() {
					return mapRELATION_ENTITY(payload.getJsonObject("RELATION_ENTITY"));
				}
			};
		}
	}

	public interface NeoRelationRELATION_ENTITY {

		public NeoRelation getNeoRelation();

		public RELATION_ENTITY getRELATION_ENTITY();
	}

	public static abstract class NeoRelation_RELATION_ENTITY_FOR_NeoEntityHandler extends ListHandler<NeoRelationRELATION_ENTITY> {

		@Override
		protected NeoRelationRELATION_ENTITY map(JsonObject payload) {
			return new NeoRelationRELATION_ENTITY() {
				@Override
				public NeoRelation getNeoRelation() {
					return mapNeoRelation(payload.getJsonObject("NeoRelation"));
				}

				@Override
				public RELATION_ENTITY getRELATION_ENTITY() {
					return mapRELATION_ENTITY(payload.getJsonObject("RELATION_ENTITY"));
				}
			};
		}
	}

	public void updateRELATION_ENTITY(UUID srcNode, RELATION_ENTITY relationship, RELATION_ENTITYHandler handler) {
		send("neoDomainDomain.update.RELATION_ENTITY", new JsonObject().put("uuid", srcNode.toString()).put("RELATION_ENTITY", relationship.toJson()), handler);
	}

	private static RELATION_ENTITY mapRELATION_ENTITY(JsonObject payload) {
		return new RELATION_ENTITY() {
			@Override
			public UUID getUUID() {
				return UUID.fromString(payload.getString("uuid"));
			}

			@Override
			public JsonObject toJson() {
				return payload;
			}

			@Override
			public String toString() {
				return toJson().encode();
			}
		};
	}

	interface RELATION_ENTITY {

		UUID getUUID();

		JsonObject toJson();

	}


	// ONE 'NeoDomain' (NeoDomain) -> ENTITIES -> MANY 'NeoEntity' (NeoEntity)

	// 
	protected ENTITIESRelation newENTITIESRelation(JsonObject relationship, JsonPNode neoDomain, JsonPNode neoEntity) {
			return new ENTITIESRelation(relationship, neoDomain, neoEntity);
		}

	class ENTITIESRelation extends JsonRelationship {

		ENTITIESRelation(JsonObject relationship, JsonPNode neoDomain, JsonPNode neoEntity) {
			super(relationship, "ENTITIES", neoDomain, neoEntity, Color.decode("#bdbdbd"), Color.decode("#636363"), Color.decode("#e34a33"));
		}

		@Override
		protected void onRightClick(JPopupMenu pop, NodeCanvas canvas) {

			super.onRightClick(pop, canvas);
		}
	}

	// NeoDomainDomain ENTITIES
	protected final class ENTITIESForm extends JPanel {

		private final String title = "New ENTITIES";
		private String uuid;

		protected ENTITIESForm() {
			super(new BorderLayout());
				this.uuid = null;

			int c = 1, r = 1;
			final FormPanel form = new FormPanel("100dlu,4dlu,150dlu", "");
			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			add(form.build(), BorderLayout.CENTER);
		}

		protected ENTITIESForm(JsonObject content) {
			this();
			this.uuid = content.getString("uuid");
		}


		@Deprecated
		protected JsonObject toJson() {
			return new JsonObject()	;}

		protected ENTITIES getENTITIES() {
			final JsonObject jsonObject = new JsonObject();
			if (uuid != null) jsonObject.put("uuid", uuid);
			return mapENTITIES(jsonObject);
		}

		protected void show(NodeCanvas canvas, ConfirmAction confirmAction) {
			showDialog(this, canvas, title, confirmAction);
		}
	}

	public void relateNeoDomain_ENTITIES_NeoEntity(UUID neoDomain, NeoEntity neoEntity, ENTITIESHandler handler) {
		final JsonObject parameters = new JsonObject().put("NeoDomain", neoDomain.toString()).put("NeoEntity", neoEntity.toJson());
		send("neoDomainDomain.relate.neoDomain.ENTITIES.neoEntity", parameters, handler);
	}

	public static abstract class ENTITIESHandler extends MessageHandler {

		public abstract void onSuccess(ENTITIES relation, NeoEntity neoEntity);

		@Override
		protected void handleSuccess(JsonObject payload) {
			onSuccess(mapENTITIES(payload.getJsonObject("ENTITIES")), mapNeoEntity(payload.getJsonObject("NeoEntity")));
		}
	}

	// MISSING
	// one-to-many
	protected class ExpandNeoEntity_ENTITIES_FOR_NeoDomainHandler extends NeoEntity_ENTITIES_FOR_NeoDomainHandler {

		private final NeoDomainNode node;

		ExpandNeoEntity_ENTITIES_FOR_NeoDomainHandler(NeoDomainNode node) {
			this.node = node;
		}

		@Override
		public void onSuccess(Iterator<NeoDomainENTITIES> it) {
			final Set<BasePNode> nodes = new LinkedHashSet<>();
			final Set<Relation> relations = new LinkedHashSet<>();
			while(it.hasNext()) {
				final NeoDomainENTITIES next = it.next();
				final NeoEntityNode entityNode = newNeoEntityNode(next.getNeoEntity().toJson());
				nodes.add(entityNode);
				relations.add(newENTITIESRelation(next.getENTITIES().toJson(), node, entityNode));
			}
			addNodesAndRelations(nodes, relations, new LayoutRelativeTo(node));
		}
	}

	protected void add_NeoEntity_ENTITIES_FOR_NeoDomain(final NeoDomainNode node, NodeCanvas canvas) {

		final NeoEntityForm form = new NeoEntityForm();
		form.show(canvas, new ConfirmAction() {
			@Override
			public void verifyAndCommit() throws Exception {
				final NeoEntity entity = newNeoEntity(form.toJson());

				relateNeoDomain_ENTITIES_NeoEntity(node.getUUID(), entity, new ENTITIESHandler() {
					@Override
					public void onSuccess(ENTITIES relation, NeoEntity newEntity) {
						final NeoEntityNode newNode = newNeoEntityNode(newEntity.toJson());
						addNodeAndRelation(newNode, newENTITIESRelation(relation.toJson(), node, newNode), new LayoutRelativeTo(node));
					}
				});
			}
		});
	}

	// message support
	public void get_NeoEntity_ENTITIES_FOR_NeoDomain(UUID neoDomain, NeoEntity_ENTITIES_FOR_NeoDomainHandler handler) {
		send("neoDomainDomain.get.neoEntity.ENTITIES.neoDomain", new JsonObject().put("NeoDomain", neoDomain.toString()), handler);
	}

	public void get_NeoDomain_ENTITIES_FOR_NeoEntity(UUID neoEntity, ENTITIESNeoDomainHandler handler) {
		send("neoDomainDomain.get.neoDomain.ENTITIES.neoEntity", new JsonObject().put("NeoEntity", neoEntity.toString()), handler);
	}

	public interface NeoDomainENTITIES {

		public NeoEntity getNeoEntity();

		public ENTITIES getENTITIES();
	}

	public static abstract class NeoEntity_ENTITIES_FOR_NeoDomainHandler extends ListHandler<NeoDomainENTITIES> {

		@Override
		protected NeoDomainENTITIES map(JsonObject payload) {
			return new NeoDomainENTITIES() {
				@Override
				public NeoEntity getNeoEntity() {
					return mapNeoEntity(payload.getJsonObject("NeoEntity"));
				}

				@Override
				public ENTITIES getENTITIES() {
					return mapENTITIES(payload.getJsonObject("ENTITIES"));
				}
			};
		}
	}

	public static abstract class ENTITIESNeoDomainHandler extends MessageHandler {

		public abstract void onSuccess(ENTITIES ENTITIES, NeoDomain neoDomain);

		@Override
		protected void handleSuccess(JsonObject payload) {
			if (payload.isEmpty()) return;
			onSuccess(mapENTITIES(payload.getJsonObject("ENTITIES")),mapNeoDomain(payload.getJsonObject("NeoDomain")));
		}
	}

	public void updateENTITIES(UUID srcNode, ENTITIES relationship, ENTITIESHandler handler) {
		send("neoDomainDomain.update.ENTITIES", new JsonObject().put("uuid", srcNode.toString()).put("ENTITIES", relationship.toJson()), handler);
	}

	private static ENTITIES mapENTITIES(JsonObject payload) {
		return new ENTITIES() {
			@Override
			public UUID getUUID() {
				return UUID.fromString(payload.getString("uuid"));
			}

			@Override
			public JsonObject toJson() {
				return payload;
			}

			@Override
			public String toString() {
				return toJson().encode();
			}
		};
	}

	interface ENTITIES {

		UUID getUUID();

		JsonObject toJson();

	}


	// ONE 'NeoDomain' (NeoDomain) -> RENDERER -> MANY 'NeoDomainRenderer' (NeoDomainRenderer)

	// 
	protected RENDERERRelation newRENDERERRelation(JsonObject relationship, JsonPNode neoDomain, JsonPNode neoDomainRenderer) {
			return new RENDERERRelation(relationship, neoDomain, neoDomainRenderer);
		}

	class RENDERERRelation extends JsonRelationship {

		RENDERERRelation(JsonObject relationship, JsonPNode neoDomain, JsonPNode neoDomainRenderer) {
			super(relationship, "RENDERER", neoDomain, neoDomainRenderer, Color.decode("#bdbdbd"), Color.decode("#636363"), Color.decode("#e34a33"));
		}

		@Override
		protected void onRightClick(JPopupMenu pop, NodeCanvas canvas) {

			super.onRightClick(pop, canvas);
		}
	}

	// NeoDomainDomain RENDERER
	protected final class RENDERERForm extends JPanel {

		private final String title = "New RENDERER";
		private String uuid;

		protected RENDERERForm() {
			super(new BorderLayout());
				this.uuid = null;

			int c = 1, r = 1;
			final FormPanel form = new FormPanel("100dlu,4dlu,150dlu", "");
			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			add(form.build(), BorderLayout.CENTER);
		}

		protected RENDERERForm(JsonObject content) {
			this();
			this.uuid = content.getString("uuid");
		}


		@Deprecated
		protected JsonObject toJson() {
			return new JsonObject()	;}

		protected RENDERER getRENDERER() {
			final JsonObject jsonObject = new JsonObject();
			if (uuid != null) jsonObject.put("uuid", uuid);
			return mapRENDERER(jsonObject);
		}

		protected void show(NodeCanvas canvas, ConfirmAction confirmAction) {
			showDialog(this, canvas, title, confirmAction);
		}
	}

	public void relateNeoDomain_RENDERER_NeoDomainRenderer(UUID neoDomain, NeoDomainRenderer neoDomainRenderer, RENDERERHandler handler) {
		final JsonObject parameters = new JsonObject().put("NeoDomain", neoDomain.toString()).put("NeoDomainRenderer", neoDomainRenderer.toJson());
		send("neoDomainDomain.relate.neoDomain.RENDERER.neoDomainRenderer", parameters, handler);
	}

	public static abstract class RENDERERHandler extends MessageHandler {

		public abstract void onSuccess(RENDERER relation, NeoDomainRenderer neoDomainRenderer);

		@Override
		protected void handleSuccess(JsonObject payload) {
			onSuccess(mapRENDERER(payload.getJsonObject("RENDERER")), mapNeoDomainRenderer(payload.getJsonObject("NeoDomainRenderer")));
		}
	}

	// MISSING
	// one-to-many
	protected class ExpandNeoDomainRenderer_RENDERER_FOR_NeoDomainHandler extends NeoDomainRenderer_RENDERER_FOR_NeoDomainHandler {

		private final NeoDomainNode node;

		ExpandNeoDomainRenderer_RENDERER_FOR_NeoDomainHandler(NeoDomainNode node) {
			this.node = node;
		}

		@Override
		public void onSuccess(Iterator<NeoDomainRENDERER> it) {
			final Set<BasePNode> nodes = new LinkedHashSet<>();
			final Set<Relation> relations = new LinkedHashSet<>();
			while(it.hasNext()) {
				final NeoDomainRENDERER next = it.next();
				final NeoDomainRendererNode entityNode = newNeoDomainRendererNode(next.getNeoDomainRenderer().toJson());
				nodes.add(entityNode);
				relations.add(newRENDERERRelation(next.getRENDERER().toJson(), node, entityNode));
			}
			addNodesAndRelations(nodes, relations, new LayoutRelativeTo(node));
		}
	}

	protected void add_NeoDomainRenderer_RENDERER_FOR_NeoDomain(final NeoDomainNode node, NodeCanvas canvas) {

		final NeoDomainRendererForm form = new NeoDomainRendererForm();
		form.show(canvas, new ConfirmAction() {
			@Override
			public void verifyAndCommit() throws Exception {
				final NeoDomainRenderer entity = newNeoDomainRenderer(form.toJson());

				relateNeoDomain_RENDERER_NeoDomainRenderer(node.getUUID(), entity, new RENDERERHandler() {
					@Override
					public void onSuccess(RENDERER relation, NeoDomainRenderer newEntity) {
						final NeoDomainRendererNode newNode = newNeoDomainRendererNode(newEntity.toJson());
						addNodeAndRelation(newNode, newRENDERERRelation(relation.toJson(), node, newNode), new LayoutRelativeTo(node));
					}
				});
			}
		});
	}

	// message support
	public void get_NeoDomainRenderer_RENDERER_FOR_NeoDomain(UUID neoDomain, NeoDomainRenderer_RENDERER_FOR_NeoDomainHandler handler) {
		send("neoDomainDomain.get.neoDomainRenderer.RENDERER.neoDomain", new JsonObject().put("NeoDomain", neoDomain.toString()), handler);
	}

	public void get_NeoDomain_RENDERER_FOR_NeoDomainRenderer(UUID neoDomainRenderer, RENDERERNeoDomainHandler handler) {
		send("neoDomainDomain.get.neoDomain.RENDERER.neoDomainRenderer", new JsonObject().put("NeoDomainRenderer", neoDomainRenderer.toString()), handler);
	}

	public interface NeoDomainRENDERER {

		public NeoDomainRenderer getNeoDomainRenderer();

		public RENDERER getRENDERER();
	}

	public static abstract class NeoDomainRenderer_RENDERER_FOR_NeoDomainHandler extends ListHandler<NeoDomainRENDERER> {

		@Override
		protected NeoDomainRENDERER map(JsonObject payload) {
			return new NeoDomainRENDERER() {
				@Override
				public NeoDomainRenderer getNeoDomainRenderer() {
					return mapNeoDomainRenderer(payload.getJsonObject("NeoDomainRenderer"));
				}

				@Override
				public RENDERER getRENDERER() {
					return mapRENDERER(payload.getJsonObject("RENDERER"));
				}
			};
		}
	}

	public static abstract class RENDERERNeoDomainHandler extends MessageHandler {

		public abstract void onSuccess(RENDERER RENDERER, NeoDomain neoDomain);

		@Override
		protected void handleSuccess(JsonObject payload) {
			if (payload.isEmpty()) return;
			onSuccess(mapRENDERER(payload.getJsonObject("RENDERER")),mapNeoDomain(payload.getJsonObject("NeoDomain")));
		}
	}

	public void updateRENDERER(UUID srcNode, RENDERER relationship, RENDERERHandler handler) {
		send("neoDomainDomain.update.RENDERER", new JsonObject().put("uuid", srcNode.toString()).put("RENDERER", relationship.toJson()), handler);
	}

	private static RENDERER mapRENDERER(JsonObject payload) {
		return new RENDERER() {
			@Override
			public UUID getUUID() {
				return UUID.fromString(payload.getString("uuid"));
			}

			@Override
			public JsonObject toJson() {
				return payload;
			}

			@Override
			public String toString() {
				return toJson().encode();
			}
		};
	}

	interface RENDERER {

		UUID getUUID();

		JsonObject toJson();

	}


	// VISITORS

	public void renderDomain(String uuid, RenderDomainHandler handler) {
		send("neoDomainDomain.renderDomain", new JsonObject().put("uuid",uuid), handler);
	}

	public static abstract class RenderDomainHandler extends MessageHandler {

	}


	private void send(String address, JsonObject parameters, MessageHandler handler) {

		final JsonObject buffer = new JsonObject().
					put("type", "send").
					put("address", address).
					put("replyAddress", uuid).
					put("body", parameters);

		log.info("sending " + buffer.encode() + " to " + host + ":" + port);

		final HttpClient client = vertx.createHttpClient();
		client.websocket(port, host, "/eventbus/websocket", ws -> {
			ws.handler(handler);
			writeToWS(buffer, ws);
		});
	}

	private void writeToWS(JsonObject buffer, WebSocket ws) {
		final Buffer toBuffer = buffer.toBuffer();
		final int length = toBuffer.length();
		int index = 0;
		boolean first = true;
		while (index < length) {
			final int frameLength = Math.min(65536, length - index);
			final Buffer slice = toBuffer.slice(index, index + frameLength);
			index += frameLength;
			boolean isFinal = index == length;
			if (first)
				ws.writeFrame(WebSocketFrame.binaryFrame(slice, isFinal));
			else
				ws.writeFrame(WebSocketFrame.continuationFrame(slice, isFinal));
			first = false;
		}
	}

	public static abstract class DeleteHandler extends MessageHandler {

		public abstract void onSuccess(UUID deletedUUID);

		@Override
		protected void handleSuccess(String payload) {
			onSuccess(UUID.fromString(payload));
		}
	}

	protected static abstract class ListHandler<T> extends MessageHandler {

		public abstract void onSuccess(java.util.Iterator<T> it);

		@Override
		protected void handleSuccess(JsonArray payload) {
			final java.util.Iterator<Object> iterator = payload.iterator();
			onSuccess(new java.util.Iterator<T>() {
				@Override
				public boolean hasNext() {
					return iterator.hasNext();
				}

				@Override
				public T next() {
					return map((JsonObject) iterator.next());
				}
			});
		}

		protected abstract T map(JsonObject jsonObject);
	}

	protected static class MessageHandler implements Handler<Buffer> {

		enum Type {
			rec, err
		}

		private enum ResponseStatus {
			SUCCESS,
			FAIL
		}

		private enum PayloadType {
			STRING,
			JSONOBJECT,
			JSONARRAY,
			EXCEPTION
		}

		private StringBuilder result;

		@Override
		public void handle(Buffer buffer) {

				final String head = buffer.slice(0, Math.min(7, buffer.length())).toString();
				log.debug(buffer.length() + " : " + head);

				if (head.equals("{\"type\"")) result = new StringBuilder();
				result.append(buffer.toString());
								if (buffer.length() != 65536) {

					final String json = result.toString();
					log.info("handle \"" + json.substring(0, 10) + "\" ... \"" + json.substring(json.length() - 10) + "\"");
					final JsonObject message = new JsonObject(json);

					switch (Type.valueOf(message.getString("type"))) {
						case rec:
								handleResponse(message.getJsonObject("body"));
								break;
						case err:
								handleFail(message.getString("body"));
								break;
					}
				}
		}

		void handleResponse(JsonObject message) {

			switch (ResponseStatus.valueOf(message.getString("status"))) {

				case SUCCESS:
					switch (PayloadType.valueOf(message.getString("payloadType"))) {
						case STRING:
							handleSuccess(message.getString("payload"));
							break;
						case JSONOBJECT:
							handleSuccess(message.getJsonObject("payload"));
							break;
						case JSONARRAY:
							handleSuccess(message.getJsonArray("payload"));
							break;
					}
					break;

				case FAIL:
					switch (PayloadType.valueOf(message.getString("payloadType"))) {
						case STRING:
							handleFail(message.getString("payload"));
							break;
						case JSONOBJECT:
							handleFail(message.getJsonObject("payload"));
							break;
						case JSONARRAY:
							handleFail(message.getJsonArray("payload"));
							break;
						case EXCEPTION:
							final JsonObject payload = message.getJsonObject("payload");
							final JsonArray stackTrace = payload.getJsonArray("stackTrace");
							final StackTraceElement[] stackTraceElements = new StackTraceElement[stackTrace.size()];
							for (int i = 0; i < stackTrace.size(); i++) {
								final JsonObject element = stackTrace.getJsonObject(i);
								stackTraceElements[i] = new StackTraceElement(element.getString("declaringClass"), element.getString("methodName"), element.getString("fileName"), element.getInteger("lineNumber"));
							}

							final Throwable throwable = new Throwable(payload.getString("message"));
							throwable.setStackTrace(stackTraceElements);
							handleException(throwable);
							break;
					}
					break;

				default:
					log.error("unrecognized status '" + message.getString("status") + "'");
					break;
			}
		}

		protected void handleException(Throwable throwable) {
			log.error("unhandled exception " + throwable.getMessage(), throwable);
		}

		protected void handleSuccess(String payload) {
			log.error("unhandled String success " + payload);
		}

		protected void handleSuccess(JsonObject payload) {
			log.error("unhandled JsonObject success " + payload.encode());
		}

		protected void handleSuccess(JsonArray payload) {
			log.error("unhandled JsonArray success " + payload.encode());
		}

		protected void handleFail(JsonArray payload) {
			log.error("unhandled JsonArray fail" + payload.encode());
		}

		protected void handleFail(JsonObject payload) {
			log.error("unhandled JsonObject fail " + payload.encode());
		}

		protected void handleFail(String payload) {
			log.error("unhandled String fail " + payload);
		}
	}

	public static void main(String[] args) {

		setLookAndFeel();

		final Vertx vertx = Vertx.vertx();

		final String host = args.length == 0 ? "127.0.0.1" : args[0];
		final Integer port = args.length == 0 ? 8090 : Integer.valueOf(args[1]);
				if (args.length == 0) {
			NeoDomainDomainVerticle.runServer(vertx, port, "./db_neoDomainDomain", deploymentID -> {
				log.info("NeoDomainDomainVerticle deploymentId " + deploymentID);
				showCanvas(vertx, host, port);
			});

		} else
			showCanvas(vertx, host, port);
	}

	private static void showCanvas(Vertx vertx, String host, Integer port) {
		final JFrame frame = new JFrame("NeoDomainDomainRemoteCanvas @ " + host);
		final NeoDomainDomainRemoteCanvas canvas = new NeoDomainDomainRemoteCanvasImpl(vertx, port, host);
		final EditorPanel editorPanel = new EditorPanel(canvas);
		frame.getContentPane().add(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, canvas, editorPanel), BorderLayout.CENTER);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		SwingUtilities.invokeLater(() -> {
				frame.pack();
				frame.setLocationByPlatform(true);
				frame.setVisible(true);
		});
	}
}