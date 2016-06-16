package com.generator.generators;

/**
 * User: goe
 * Date: 11.07.13
 */
public final class DefaultAttributeRenderer implements org.stringtemplate.v4.AttributeRenderer {

   private enum FormatCode {
      capitalize, toUpper, lowFirst, toLower, humpToCap, camelHump, splitCamelHump
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
         default:
            return o.toString();
      }
   }

   public String capitalize(String string) {
      if (string == null || string.length() == 0) return "";
      return Character.toUpperCase(string.charAt(0)) + (string.length() > 1 ? string.substring(1) : "");
   }

   public String lowFirst(String string) {
      if (string == null || string.length() == 0) return "";
      return Character.toLowerCase(string.charAt(0)) + (string.length() > 1 ? string.substring(1) : "");
   }

   public String toUpper(String text) {
      return text.toUpperCase();
   }

   public String humpToCap(String text) {
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

   public String camelHump(String text) {
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

   public String splitCamelHump(String text) {
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
}