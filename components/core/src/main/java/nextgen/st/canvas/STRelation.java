package nextgen.st.canvas;

import org.piccolo2d.PNode;
import org.piccolo2d.event.PBasicInputEventHandler;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.nodes.PPath;
import org.piccolo2d.nodes.PText;
import org.piccolo2d.util.PBounds;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Comparator;
import java.util.UUID;

public class STRelation extends PPath.Double implements Comparator<STRelation> {

	protected enum Attributes {
		_defaultColor, _selectedColor, _highlightedColor, _uuid, _text, _selected, _highlight, _order, _type, _src, _dst
	}

	protected STCanvas canvas;
	final protected PText child;

	public STRelation(STCanvas canvas, STNode src, STNode dst, String type, UUID uuid) {
		this.canvas = canvas;
		this.addAttribute(Attributes._defaultColor, Color.decode("#bababa"));
		this.addAttribute(Attributes._selectedColor, Color.decode("#b2182b"));
		this.addAttribute(Attributes._highlightedColor, Color.decode("#f4a582"));
		this.addAttribute(Attributes._uuid, uuid);
		this.addAttribute(Attributes._type, type);
		this.addAttribute(Attributes._src, src);
		this.addAttribute(Attributes._dst, dst);

		src.addOutgoingRelation(getUuid());
		dst.addIncomingRelation(getUuid());

		this.child = new PText(type);

		setPaint((Color) getAttribute(Attributes._defaultColor));
		child.setTextPaint((Color) getAttribute(Attributes._defaultColor));

		final RelationInputEventHandler relationInputEventHandler = new RelationInputEventHandler();
		relationInputEventHandler.getEventFilter().setMarksAcceptedEventsAsHandled(true);
		addInputEventListener(relationInputEventHandler);
		addInputEventListener(canvas.canvasZoomHandler);

		final PNodeChangeListener nodeChangeListener = new PNodeChangeListener();
		src.addPropertyChangeListener(nodeChangeListener);
		dst.addPropertyChangeListener(nodeChangeListener);
		addChild(this.child);

		//org.greenrobot.eventbus.EventBus.getDefault().register(this);
	}

	@Override
	public String toString() {
		return getUuid() + " " + getSrc() + " -> " + getType() + " -> " + getDst();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		STRelation other = (STRelation) o;

		return getUuid().equals(other.getUuid());
	}

	@Override
	public int hashCode() {
		return getUuid().hashCode();
	}

	public UUID getUuid() {
		return (UUID) getAttribute(Attributes._uuid);
	}

	public String getType() {
		return (String) getAttribute(Attributes._type);
	}

	public void unselect() {
		addAttribute(Attributes._selected, Boolean.FALSE);
		SwingUtilities.invokeLater(() -> updatePath((Color) getAttribute(Attributes._defaultColor)));
	}

	public void select() {
		addAttribute(Attributes._selected, Boolean.TRUE);
		SwingUtilities.invokeLater(() -> updatePath((Color) getAttribute(Attributes._selectedColor)));
	}

	public boolean isSelected() {
		return getBooleanAttribute(Attributes._selected, false);
	}

	protected void unhighlight() {
		addAttribute(Attributes._highlight, Boolean.FALSE);
		SwingUtilities.invokeLater(() -> updatePath(isSelected() ? (Color) getAttribute(Attributes._selectedColor) : (Color) getAttribute(Attributes._defaultColor)));
	}

	protected void highlight() {
		addAttribute(Attributes._highlight, Boolean.TRUE);
		SwingUtilities.invokeLater(() -> updatePath((Color) getAttribute(Attributes._highlightedColor)));
	}

	protected STNode getSrc() {
		return (STNode) getAttribute(Attributes._src);
	}

	protected STNode getDst() {
		return (STNode) getAttribute(Attributes._dst);
	}

	public Long getOrder() {
		return (Long) getAttribute(Attributes._order);
	}

	private void updatePath(Color color) {
		setPaint(color);
		child.setTextPaint(color);
		updatePath(getSrc(), getDst());
	}

	private void updatePath(STNode source, STNode target) {
		final PBounds src = source.getFullBoundsReference();
		final PBounds dst = target.getFullBoundsReference();
		final boolean horizontalOverlap = !(src.getMaxX() < dst.getMinX() || src.getMinX() > dst.getMaxX());
		final Point2D.Double startCenterBottom = new Point2D.Double(src.getCenterX(), src.getMaxY());
		final Point2D.Double endCenterTop = new Point2D.Double(dst.getCenterX(), dst.getMinY());
		final Point2D.Double startCenterTop = new Point2D.Double(src.getCenterX(), src.getMinY());
		final Point2D.Double endCenterBottom = new Point2D.Double(dst.getCenterX(), dst.getMaxY());
		if (src.getCenterX() < dst.getCenterX()) {
			final Point2D.Double startRightCenter = new Point2D.Double(src.getMaxX(), src.getCenterY());
			final Point2D.Double endRightCenter = new Point2D.Double(dst.getMinX(), dst.getCenterY());
			if (src.getCenterY() < dst.getCenterY()) {
				if (!horizontalOverlap) {
					drawStraightPath(startRightCenter, endRightCenter);
				} else {
					drawStraightPath(startCenterBottom, endCenterTop);
				}
			} else {
				if (!horizontalOverlap) {
					drawStraightPath(startRightCenter, endRightCenter);
				} else {
					drawStraightPath(startCenterTop, endCenterBottom);
				}
			}
		} else {
			final Point2D.Double startLeftCenter = new Point2D.Double(src.getMinX(), src.getCenterY());
			final Point2D.Double endLeftCenter = new Point2D.Double(dst.getMaxX(), dst.getCenterY());
			if (src.getCenterY() < dst.getCenterY()) {
				if (!horizontalOverlap) {
					drawStraightPath(startLeftCenter, endLeftCenter);
				} else {
					drawStraightPath(startCenterBottom, endCenterTop);
				}
			} else {
				if (!horizontalOverlap) {
					drawStraightPath(startLeftCenter, endLeftCenter);
				} else {
					drawStraightPath(startCenterTop, endCenterBottom);
				}
			}
		}
	}

	private void drawStraightPath(Point2D start, Point2D end) {
		reset();
		setStrokePaint(child.getTextPaint());
		moveTo(start.getX(), start.getY());
		lineTo(end.getX(), end.getY());
		child.setOffset(getBounds().getCenter2D());
		final int ARR_SIZE = 4;
		final double dx = end.getX() - start.getX();
		final double dy = end.getY() - start.getY();
		final double angle = Math.atan2(dy, dx);
		final int len = (int) (Math.sqrt(dx * dx + dy * dy) - 10);
		final AffineTransform at = AffineTransform.getTranslateInstance(start.getX(), start.getY());
		at.concatenate(AffineTransform.getRotateInstance(angle));
		append(new Polygon(new int[]{len,
					len - ARR_SIZE,
					len - ARR_SIZE,
					len}, new int[]{0,
					-ARR_SIZE,
					ARR_SIZE,
					0}, 4).getPathIterator(at), false);
		setPaintInvalid(true);
		validateFullPaint();
	}

	@Override
	public int compare(STRelation o1, STRelation o2) {
		return o1.getOrder().compareTo(o2.getOrder());
	}

	private final class PNodeChangeListener implements PropertyChangeListener {

		@Override
		public void propertyChange(PropertyChangeEvent evt) {
			switch (evt.getPropertyName()) {
				case PNode.PROPERTY_FULL_BOUNDS:
				case PNode.PROPERTY_TRANSFORM:
					SwingUtilities.invokeLater(() -> updatePath((getSrc()), getDst()));
					break;
				case PNode.PROPERTY_PARENT:
					break;
			}
		}
	} 

	private final class RelationInputEventHandler extends PBasicInputEventHandler {

		@Override
		public void mouseEntered(PInputEvent event) {
			event.getInputManager().setKeyboardFocus(this);
			highlight();
		}

		@Override
		public void mouseExited(PInputEvent event) {
			unhighlight();
			event.getInputManager().setKeyboardFocus(canvas);
		}

		@Override
		public void mouseClicked(PInputEvent event) {
			if (event.isRightMouseButton()) {
				final JPopupMenu pop = new JPopupMenu();
				canvas.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				onRelationRightClick(event, pop);
				canvas.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				pop.show(canvas, (int) event.getCanvasPosition().getX(), (int) event.getCanvasPosition().getY());
			} else if (event.isLeftMouseButton()) {
				SwingUtilities.invokeLater(() -> onRelationLeftClick(event));
			}
		}

		@Override
		public void keyPressed(PInputEvent event) {
			onRelationKeyPressed(event);
		}
	} 

	protected void onRelationRightClick(PInputEvent event, JPopupMenu pop) {
	}

	protected void onRelationLeftClick(PInputEvent event) {
		if (isSelected()) unselect();
		else select();
	}

	protected void onRelationKeyPressed(PInputEvent event) {
	}

	static abstract class RelationAction<N extends STRelation> extends AbstractAction {

		final N relation;
		final STCanvas canvas;
		final PInputEvent event;

		RelationAction(String name, N relation, STCanvas canvas, PInputEvent event) {
			super(name);
			this.relation = relation;
			this.canvas = canvas;
			this.event = event;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			actionPerformed(relation, canvas, event, e);
		}

		abstract void actionPerformed(N relation, STCanvas canvas, PInputEvent event, ActionEvent e);

		protected void doLaterInTransaction(java.util.function.Consumer<org.neo4j.graphdb.Transaction> consumer){ 
			relation.doLaterInTransaction(consumer);
		}
	}


	protected void doLaterInTransaction(java.util.function.Consumer<org.neo4j.graphdb.Transaction> consumer){ 
		javax.swing.SwingUtilities.invokeLater(() -> canvas.modelDb.doInTransaction(consumer, throwable -> com.generator.util.SwingUtil.showException(canvas, throwable)));
	}
}