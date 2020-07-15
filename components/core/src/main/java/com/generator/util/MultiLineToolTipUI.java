package com.generator.util;

import javax.swing.JComponent;
import javax.swing.JToolTip;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.ToolTipUI;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.regex.Pattern;

/**
 * A tooltip that wraps multi-line text.
 */
public final class MultiLineToolTipUI extends ToolTipUI {

    private static final int INSET = 2;
    private static final Pattern LINE_SPLITTER = Pattern.compile("$", Pattern.MULTILINE);
    private static final MultiLineToolTipUI SHARED_INSTANCE = new MultiLineToolTipUI();
    private final String[] emptySplit = new String[0];

    public static void installUI() {
        String toolTipUI = MultiLineToolTipUI.class.getName();
        UIManager.put("ToolTipUI", toolTipUI);
        UIManager.put(toolTipUI, MultiLineToolTipUI.class);
    }

    @SuppressWarnings("UnusedDeclaration")
    public static ComponentUI createUI(JComponent c) {
        return SHARED_INSTANCE;
    }

    private MultiLineToolTipUI() {
    }

    @Override
    public Dimension getMaximumSize(JComponent c) {
        return getPreferredSize(c);
    }

    @Override
    public Dimension getMinimumSize(JComponent c) {
        return getPreferredSize(c);
    }

    @Override
    public Dimension getPreferredSize(JComponent c) {
        String[] lines = getSplit((JToolTip) c);
        if (lines.length == 0) return new Dimension(2 * INSET, 2 * INSET);

        final FontMetrics metrics = c.getFontMetrics(c.getFont());
        final Graphics g = c.getGraphics();
        int w = 0;
        for (String line : lines)
            w = Math.max(w, (int) metrics.getStringBounds(line, g).getWidth());
        int h = lines.length * metrics.getHeight();
        return new Dimension(Math.min(600, w + 2 * INSET), Math.min(600, h + 2 * INSET));
    }

    public String[] getSplit(JToolTip c) {
        return c == null || c.getTipText() == null ? emptySplit : LINE_SPLITTER.split(c.getTipText());
    }

    @Override
    public void installUI(JComponent c) {
        LookAndFeel.installColorsAndFont(c, "ToolTip.background", "ToolTip.foreground", "ToolTip.font");
        LookAndFeel.installBorder(c, "ToolTip.border");
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        int w = c.getWidth(), h = c.getHeight();
        g.setColor(c.getBackground());
        g.fillRect(0, 0, w, h);
        g.setColor(c.getForeground());
        g.drawRect(0, 0, w, h);
        String[] lines = getSplit((JToolTip) c);
        if (lines.length != 0) {
            FontMetrics metrics = c.getFontMetrics(c.getFont());
            int height = metrics.getHeight();
            int y = INSET + metrics.getAscent();
            for (String line : lines) {
                g.drawString(line, INSET, y);
                y += height;
            }
        }
    }

    @Override
    public void uninstallUI(JComponent c) {
        LookAndFeel.uninstallBorder(c);
    }
}