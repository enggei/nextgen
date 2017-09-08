package com.generator.util;

import javax.swing.*;

/**
 * Created 25.08.17.
 */
public class RenderingHints {

   public RenderingHints() {
      final JComboBox<Object> cboAntialiasing = new JComboBox<>(new Object[]{
            java.awt.RenderingHints.VALUE_ANTIALIAS_ON,
            java.awt.RenderingHints.VALUE_ANTIALIAS_OFF,
            java.awt.RenderingHints.VALUE_ANTIALIAS_DEFAULT});
//      cboAntialiasing.setSelectedItem(model.hints.get(java.awt.RenderingHints.KEY_ANTIALIASING));

      final JComboBox<Object> cboAlphaInterpolation = new JComboBox<>(new Object[]{
            java.awt.RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY,
            java.awt.RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED,
            java.awt.RenderingHints.VALUE_ALPHA_INTERPOLATION_DEFAULT});
//      cboAlphaInterpolation.setSelectedItem(model.hints.get(java.awt.RenderingHints.KEY_ALPHA_INTERPOLATION));

      final JComboBox<Object> cboColorRendering = new JComboBox<>(new Object[]{
            java.awt.RenderingHints.VALUE_COLOR_RENDER_DEFAULT,
            java.awt.RenderingHints.VALUE_COLOR_RENDER_QUALITY,
            java.awt.RenderingHints.VALUE_COLOR_RENDER_SPEED});
//      cboColorRendering.setSelectedItem(model.hints.get(java.awt.RenderingHints.KEY_COLOR_RENDERING));

      final JComboBox<Object> cboDithering = new JComboBox<>(new Object[]{
            java.awt.RenderingHints.VALUE_DITHER_DISABLE,
            java.awt.RenderingHints.VALUE_DITHER_ENABLE,
            java.awt.RenderingHints.VALUE_DITHER_DEFAULT});
//      cboDithering.setSelectedItem(model.hints.get(java.awt.RenderingHints.KEY_DITHERING));

      final JComboBox<Object> cboFractionalMetrics = new JComboBox<>(new Object[]{
            java.awt.RenderingHints.VALUE_FRACTIONALMETRICS_ON,
            java.awt.RenderingHints.VALUE_FRACTIONALMETRICS_OFF,
            java.awt.RenderingHints.VALUE_FRACTIONALMETRICS_DEFAULT});
//      cboFractionalMetrics.setSelectedItem(model.hints.get(java.awt.RenderingHints.KEY_FRACTIONALMETRICS));

      final JComboBox<Object> cboImageInterpolation = new JComboBox<>(new Object[]{
            java.awt.RenderingHints.VALUE_INTERPOLATION_BICUBIC,
            java.awt.RenderingHints.VALUE_INTERPOLATION_BILINEAR,
            java.awt.RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR});
//      cboImageInterpolation.setSelectedItem(model.hints.get(java.awt.RenderingHints.KEY_INTERPOLATION));

      final JComboBox<Object> cboRendering = new JComboBox<>(new Object[]{
            java.awt.RenderingHints.VALUE_RENDER_QUALITY,
            java.awt.RenderingHints.VALUE_RENDER_SPEED,
            java.awt.RenderingHints.VALUE_RENDER_DEFAULT});
//      cboRendering.setSelectedItem(model.hints.get(java.awt.RenderingHints.KEY_RENDERING));

      final JComboBox<Object> cboKeyStrokeControl = new JComboBox<>(new Object[]{
            java.awt.RenderingHints.VALUE_STROKE_NORMALIZE,
            java.awt.RenderingHints.VALUE_STROKE_DEFAULT,
            java.awt.RenderingHints.VALUE_STROKE_PURE});
//      cboKeyStrokeControl.setSelectedItem(model.hints.get(java.awt.RenderingHints.KEY_STROKE_CONTROL));

      final JComboBox<Object> cboTextAntialiasing = new JComboBox<>(new Object[]{
            java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_ON,
            java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_OFF,
            java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT,
            java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_GASP,
            java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB,
            java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HBGR,
            java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_VRGB,
            java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_VBGR});
//      cboTextAntialiasing.setSelectedItem(model.hints.get(java.awt.RenderingHints.KEY_TEXT_ANTIALIASING));

      final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("75dlu:grow,4dlu,175dlu:grow", "pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref");
      editor.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

      editor.addLabel("Antialiasing", 1, 1);
      editor.add(cboAntialiasing, 3, 1);
      editor.addLabel("Alpha interpolation", 1, 3);
      editor.add(cboAlphaInterpolation, 3, 3);
      editor.addLabel("Color rendering", 1, 5);
      editor.add(cboColorRendering, 3, 5);
      editor.addLabel("Dithering", 1, 7);
      editor.add(cboDithering, 3, 7);
      editor.addLabel("Fractional text metrics", 1, 9);
      editor.add(cboFractionalMetrics, 3, 9);
      editor.addLabel("Image Interpolation", 1, 11);
      editor.add(cboImageInterpolation, 3, 11);
      editor.addLabel("Rendering", 1, 13);
      editor.add(cboRendering, 3, 13);
      editor.addLabel("Stroke Normalization Control", 1, 15);
      editor.add(cboKeyStrokeControl, 3, 15);
      editor.addLabel("Text Antialiasing", 1, 17);
      editor.add(cboTextAntialiasing, 3, 17);

//      SwingUtil.showDialog(editor, workspace, "Rendering hints", () -> {
//
//         model.hints.clear();
//         if (cboAntialiasing.getSelectedItem() != null)
//            model.hints.put(java.awt.RenderingHints.KEY_ANTIALIASING, cboAntialiasing.getSelectedItem());
//         if (cboAlphaInterpolation.getSelectedItem() != null)
//            model.hints.put(java.awt.RenderingHints.KEY_ALPHA_INTERPOLATION, cboAlphaInterpolation.getSelectedItem());
//         if (cboColorRendering.getSelectedItem() != null)
//            model.hints.put(java.awt.RenderingHints.KEY_COLOR_RENDERING, cboColorRendering.getSelectedItem());
//         if (cboDithering.getSelectedItem() != null)
//            model.hints.put(java.awt.RenderingHints.KEY_DITHERING, cboDithering.getSelectedItem());
//         if (cboFractionalMetrics.getSelectedItem() != null)
//            model.hints.put(java.awt.RenderingHints.KEY_FRACTIONALMETRICS, cboFractionalMetrics.getSelectedItem());
//         if (cboImageInterpolation.getSelectedItem() != null)
//            model.hints.put(java.awt.RenderingHints.KEY_INTERPOLATION, cboImageInterpolation.getSelectedItem());
//         if (cboRendering.getSelectedItem() != null)
//            model.hints.put(java.awt.RenderingHints.KEY_RENDERING, cboRendering.getSelectedItem());
//         if (cboKeyStrokeControl.getSelectedItem() != null)
//            model.hints.put(java.awt.RenderingHints.KEY_STROKE_CONTROL, cboKeyStrokeControl.getSelectedItem());
//         if (cboTextAntialiasing.getSelectedItem() != null)
//            model.hints.put(java.awt.RenderingHints.KEY_TEXT_ANTIALIASING, cboTextAntialiasing.getSelectedItem());
//      });
   }
}
