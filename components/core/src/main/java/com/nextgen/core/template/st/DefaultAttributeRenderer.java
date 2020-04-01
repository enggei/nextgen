package com.nextgen.core.template.st;

import org.stringtemplate.v4.AttributeRenderer;

/**
 * Created 24.04.18.
 */
public final class DefaultAttributeRenderer implements AttributeRenderer {

   private enum FormatCode {
      capitalize, toUpper, lowFirst, toLower, humpToCap, camelHump, splitCamelHump, singlify, packageToPath
   }

   @Override
   public String toString(Object o, String formatString, java.util.Locale locale) {

      final String text = o.toString();

      if (formatString == null) return text;

      switch (FormatCode.valueOf(formatString)) {
         case capitalize:
            return capitalize(text);
         case toUpper:
            return toUpper(text);
         case lowFirst:
            return lowFirst(text);
         case toLower:
            return text.toLowerCase();
         case humpToCap:
            return humpToCap(text);
         case camelHump:
            return camelHump(text);
         case splitCamelHump:
            return splitCamelHump(text);
         case singlify:
            String s = toUpper(text).substring(0, 1) + text.substring(1);
            if (s.toLowerCase().endsWith("ies")) return s.substring(0, s.length() - 3) + "y";
            else if (s.toLowerCase().endsWith("es") || s.toLowerCase().endsWith("nts")) return s.substring(0, s.length() - 1);
            else if (s.toLowerCase().endsWith("ions") || s.toLowerCase().endsWith("mns"))
               return s.substring(0, s.length() - 1);
            return s;
         case packageToPath:
            return packageToPath((text));
         default:
            return o.toString();
      }
   }

   private String capitalize(String string) {
      if (string == null || string.length() == 0) return "";
      return Character.toUpperCase(string.charAt(0)) + (string.length() > 1 ? string.substring(1) : "");
   }

   private String lowFirst(String string) {
      if (string == null || string.length() == 0) return "";
      return Character.toLowerCase(string.charAt(0)) + (string.length() > 1 ? string.substring(1) : "");
   }

   private String toUpper(String text) {
      return text.toUpperCase();
   }

   private String humpToCap(String text) {
      final char[] chars = text.toCharArray();
      final StringBuilder out = new StringBuilder();
      boolean first = true;
      for (int i = 0; i < chars.length; i++) {
         char aChar = chars[i];
         if (!first && Character.isUpperCase(aChar) && (i < chars.length - 2 && Character.isLowerCase(chars[i + 1]))) {
            out.append("_");
         }
         first = false;
         out.append(Character.toUpperCase(aChar));
      }
      return out.toString();
   }

   private String camelHump(String text) {
      final char[] chars = text.toCharArray();
      final StringBuilder out = new StringBuilder();
      boolean capitalize = true;
      for (char aChar : chars) {
         if (Character.isWhitespace(aChar)) {
            capitalize = true;
            continue;
         }
         out.append(capitalize ? Character.toUpperCase(aChar) : aChar);
         capitalize = false;
      }
      return out.toString();
   }

   private String splitCamelHump(String text) {
      final char[] chars = text.toCharArray();
      final StringBuilder out = new StringBuilder();
      boolean first = true;
      for (char aChar : chars) {
         if (Character.isUpperCase(aChar)) out.append(" ");
         out.append(first ? Character.toUpperCase(aChar) : Character.toLowerCase(aChar));
         first = false;
      }
      return out.toString();
   }

   private String packageToPath(String packageName) {
      return (packageName == null ? "" : (packageName.replaceAll("[.]", "/") + java.io.File.separator));
   }
}