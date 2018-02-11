package com.generator.util;

import java.awt.*;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.text.DecimalFormatSymbols;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * User: Geir Ove
 * Date: 16.feb.2009
 * Time: 19:29:33
 */
public final class StringUtil {
   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(StringUtil.class);

   private static final Random random = new Random(System.currentTimeMillis());

   public static void main(String[] args) {
      for (int i = 0; i < 1000; i++) {
         log.info(randomCharacter()+"");
      }
   }



   public interface CharacterHandler {

      void handle(char character);
   }

   public static void iterateAlphabet(boolean capital, CharacterHandler handler) {
      int start = (capital ? 41 : 97);
      int end = (capital ? 90 : 122);
      for (int i = start; i <= end; i++) {
         handler.handle(Character.toChars(i)[0]);
      }
   }


   public static Character randomCharacter() {
      return 'A';
//      int n = random.nextInt(27) + 65;
//      return Character.toChars(n)[0];
   }

   public static Character randomCharacter(int start, int end) {
      int n = random.nextInt((end - start)) + start;
      return Character.toChars(n)[0];
   }

   public static void printCharacterSets(OutputStreamWriter writer) throws IOException {
//      final OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(new File("src/test/java/com/rita/characters.txt")), StandardCharsets.UTF_8);
      for (int i = 0; i <= 65536; i++) {
         if (Character.isDefined(i)) {
            writer.append(unicodeEscaped(Character.toChars(i)[0])).append(" : ").append(Integer.toHexString(i)).append(" : ").append(i + "").append(" : ").append(new String(Character.toChars(i)));
            writer.append("\r\n");
         }
      }
      writer.close();
   }

   public static char[] getCharsBetween(int start, int end) {
      char[] result = new char[end - start + 1];
      for (int i = start; i <= end; i++) {
         if (Character.isDefined(i)) {
            result[i - start] = Character.toChars(i)[0];
         }
      }
      return result;
   }

   public static String unicodeEscaped(char ch) {
      String returnStr;
      final String charEsc = "\\u";
      if (ch < 0x10)
         returnStr = "000" + Integer.toHexString(ch);
      else if (ch < 0x100)
         returnStr = "00" + Integer.toHexString(ch);
      else if (ch < 0x1000)
         returnStr = "0" + Integer.toHexString(ch);
      else
         returnStr = "" + Integer.toHexString(ch);
      return charEsc + returnStr;
   }

   public static int previous(String search, int fromIndex, String line) {

      //nb: not the fastest in the world...
      int index = fromIndex;
      while (index > 0) {
         if (line.substring(index, search.length()).equals(search)) return index;
         index--;
      }

      return index == 0 ? -1 : index;
   }


   public static int indexAfter(String search, String line) {
      return line.indexOf(search) + search.length();
   }

   public static int indexAfter(String search, int fromIndex, String line) {
      return line.indexOf(search, fromIndex) + search.length();
   }


   public static String padRight(String s, int n) {
      return String.format("%1$-" + n + "s", s);
   }

   public static String padLeft(String s, int n) {
      return String.format("%1$" + n + "s", s);
   }

   public static String padRight(Integer s, int n) {
      return padRight("" + s, n);
   }

   public static String padLeft(Integer s, int n) {
      return padLeft("" + s, n);
   }

   public static String formatLine(String... columns) {
      final StringBuilder outBuffer = new StringBuilder();
      for (String s : columns)
         outBuffer.append(s);
      outBuffer.append("\n");
      return outBuffer.toString();
   }


   public static String reverse(String source) {
      int i, len = source.length();
      StringBuilder dest = new StringBuilder(len);
      for (i = (len - 1); i >= 0; i--)
         dest.append(source.charAt(i));
      return dest.toString();
   }

   public static boolean matchUUID(String content) {
      return match("[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}", content, null).length == 1;
   }

   public static String[] match(String regexp, String content, Integer group) {
      final Pattern pattern = Pattern.compile(regexp);
      final Matcher matcher = pattern.matcher(content);

      final List<String> matches = new LinkedList<>();
      while (matcher.find()) {
         matches.add(group == null ? matcher.group() : matcher.group(group));
      }

      return matches.toArray(new String[matches.size()]);
   }

   public static String[] match(String regexp, String content) {
      return match(regexp, content, null);
   }


   public static Dimension toDimension(String s) {
      final String[] wh = s.split(",");
      return new Dimension(new Double(wh[0]).intValue(), new Double(wh[1]).intValue());
   }

   public static String lexical(Dimension dimension) {
      return dimension.getWidth() + "," + dimension.getHeight();
   }

   public static Point toPoint(String s) {
      final String[] xy = s.split(",");
      return new Point(new Double(xy[0]).intValue(), new Double(xy[1]).intValue());
   }

   public static String lexical(Point location) {
      return location.getX() + "," + location.getY();
   }

   public static Color toColor(String s) {
      final String[] rgb = s.split(",");
      return new Color(Integer.parseInt(rgb[0]), Integer.parseInt(rgb[1]), Integer.parseInt(rgb[2]));
   }

   public static String lexical(Color color) {
      return color.getRed() + "," + color.getGreen() + "," + color.getBlue();
   }

   private static final Set<Character> emptyChars = new LinkedHashSet<Character>() {{
      add(' ');
      add('\t');
   }};

   public static String trimSpacesIn(String text) {
      final char[] chars = text.toCharArray();
      final StringBuilder out = new StringBuilder();
      Character lastChar = null;
      for (int i = 0; i < chars.length; i++) {
         Character aChar = chars[i];
         if (emptyChars.contains(aChar) && lastChar != null && emptyChars.contains(lastChar)) {
            lastChar = aChar;
            continue;
         }
         out.append(aChar);
         lastChar = aChar;
      }
      return out.toString();
   }

   public static String printRest(int startIndex, String[] tokens, String delimiter) {
      if (startIndex >= tokens.length) return "";
      final StringBuilder out = new StringBuilder();
      boolean first = true;
      for (int i = startIndex; i < tokens.length; i++) {
         if (!first) out.append(delimiter);
         out.append(tokens[i]);
         first = false;
      }
      return out.toString();
   }

   public static int levensthein(final String s1, final String s2) {
      if (s1 == null) {
         throw new NullPointerException("s1 must not be null");
      }

      if (s2 == null) {
         throw new NullPointerException("s2 must not be null");
      }

      if (s1.equals(s2)) {
         return 0;
      }

      if (s1.length() == 0) {
         return s2.length();
      }

      if (s2.length() == 0) {
         return s1.length();
      }

      // create two work vectors of integer distances
      int[] v0 = new int[s2.length() + 1];
      int[] v1 = new int[s2.length() + 1];
      int[] vtemp;

      // initialize v0 (the previous row of distances)
      // this row is A[0][i]: edit distance for an empty s
      // the distance is just the number of characters to delete from t
      for (int i = 0; i < v0.length; i++) {
         v0[i] = i;
      }

      for (int i = 0; i < s1.length(); i++) {
         // calculate v1 (current row distances) from the previous row v0
         // first element of v1 is A[i+1][0]
         //   edit distance is delete (i+1) chars from s to match empty t
         v1[0] = i + 1;

         // use formula to fill in the rest of the row
         for (int j = 0; j < s2.length(); j++) {
            int cost = 1;
            if (s1.charAt(i) == s2.charAt(j)) {
               cost = 0;
            }
            v1[j + 1] = Math.min(
                  v1[j] + 1,              // Cost of insertion
                  Math.min(
                        v0[j + 1] + 1,  // Cost of remove
                        v0[j] + cost)); // Cost of substitution
         }

         // copy v1 (current row) to v0 (previous row) for next iteration
         //System.arraycopy(v1, 0, v0, 0, v0.length);

         // Flip references to current and previous row
         vtemp = v0;
         v0 = v1;
         v1 = vtemp;

      }

      return v0[s2.length()];
   }

   public static String trimEnds(int offset, String text) {
      return text.substring(offset, text.length() - offset);
   }


   public interface Concatenate<T> {

      String concatenate(T item, boolean isFirst);

   }

   public static <T> String concatenate(Collection<T> items, Concatenate<T> concatenator) {
      final StringBuilder out = new StringBuilder();
      boolean first = true;
      for (T item : items) {
         out.append(concatenator.concatenate(item, first));
         first = false;
      }
      return out.toString();
   }

   public static String list(Collection<?> items) {
      final StringBuilder out = new StringBuilder();
      boolean first = true;
      for (Object item : items) {
         if (!first) out.append(",");
         first = false;
         out.append(item.toString());
      }
      return out.toString();
   }

   public static String list(Collection<?> items, String delimiter) {
      final StringBuilder out = new StringBuilder();
      boolean first = true;
      for (Object item : items) {
         if (!first) out.append(delimiter);
         first = false;
         out.append(item.toString());
      }
      return out.toString();
   }

   public static String list(Iterable<?> items) {
      final StringBuilder out = new StringBuilder();
      boolean first = true;
      for (Object item : items) {
         if (!first) out.append(",");
         first = false;
         out.append(item.toString());
      }
      return out.toString();
   }

   public static String list(Iterable<?> items, String delimiter) {
      final StringBuilder out = new StringBuilder();
      boolean first = true;
      for (Object item : items) {
         if (!first) out.append(delimiter);
         first = false;
         out.append(item.toString());
      }
      return out.toString();
   }

   public static String list(Collection<?> keys, Map<?, ?> values) {
      final StringBuilder out = new StringBuilder();
      boolean first = true;
      for (Object item : keys) {
         if (!first) out.append(",");
         first = false;
         out.append(values.get(item).toString());
      }
      return out.toString();
   }

   public static List<Long> stringToLongList(final String commaSeparatedList) {
      return Arrays.asList(commaSeparatedList.split(",")).
            stream().map(String::trim).
            mapToLong(Long::parseLong).
            boxed().
            collect(Collectors.toList());
   }

   public static List<String> stringToStringList(final String commaSeparatedList) {
      return Arrays.asList(commaSeparatedList.split(",")).
            stream().map(String::trim).
            collect(Collectors.toList());
   }


   public static String findAllDigitsAfter(String key, String text) {
      final StringBuilder number = new StringBuilder();


      int i = text.indexOf(key) + key.length();
      boolean isdigit = true;
      while (isdigit && i < text.length()) {
         char candidate = text.charAt(i++);
         final boolean isSpace = ' ' == candidate || 160 == candidate;
         final boolean digit = Character.isDigit(candidate);
         if (digit) number.append(candidate);
         else isdigit = isSpace;
      }
      return number.toString();
   }

   public static String extractBetween(String startKey, String stopKey, String text) {
      int startIndex = text.indexOf(startKey) + startKey.length();
      if (startIndex < 0) return "";
      int stopIndex = text.indexOf(stopKey, startIndex);
      return stopIndex < 0 ? "" : text.substring(startIndex, stopIndex).trim();
   }

   public static String extractAllDigitsBetween(String startKey, String stopKey, String text) {
      final StringBuilder number = new StringBuilder();

      int i = text.indexOf(startKey) + startKey.length();
      int stopIndex = text.indexOf(stopKey, i);
      if (stopIndex == -1) return "";

      while (i < stopIndex) {
         char candidate = text.charAt(i++);
         if (Character.isDigit(candidate)) number.append(candidate);
      }
      return number.toString();
   }

   public static String insert(String text, int startOffset, int endOffset, String word) {
      final String before = text.substring(0, startOffset);
      final String after = endOffset == text.length() ? "" : text.substring(Math.min(text.length() - 1, endOffset));
      return before + word + after;
   }

//    public static String lowFirst(String text) {
//      return text.toLowerCase().substring(0, 1) + text.substring(1);
//   }

   public static String capitalize(Object string) {
      if (string == null) return "";

      final String str = string.toString().trim();
      if (str.length() == 0) return "";

      return Character.toUpperCase(str.charAt(0)) + (str.length() > 1 ? str.substring(1) : "");
   }

   public static String lowFirst(Object string) {
      if (string == null) return "";

      final String str = string.toString().trim();
      if (str.length() == 0) return "";

      return Character.toLowerCase(str.charAt(0)) + (str.length() > 1 ? str.substring(1) : "");
   }

   public static String toUpper(String text) {
      return text.toUpperCase();
   }

//   public static String capitalize(String text) {
//      return toUpper(text).substring(0, 1) + text.substring(1);
//   }

   public static String humpToCap(String text) {
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

   public static String camelHump(String text) {
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

   public static String splitCamelHump(String text) {
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

   public static String escapeJavaStyleString(String str) {

      if (str == null) return "";

      final StringWriter out = new StringWriter(str.length() * 2);

      int sz;
      sz = str.length();
      for (int i = 0; i < sz; i++) {
         char ch = str.charAt(i);

         // handle unicode
         if (ch > 0xfff) {
            out.write("\\u" + hex(ch));
         } else if (ch > 0xff) {
            out.write("\\u0" + hex(ch));
         } else if (ch > 0x7f) {
            out.write("\\u00" + hex(ch));
         } else if (ch < 32) {
            switch (ch) {
               case '\b':
                  out.write('\\');
                  out.write('b');
                  break;
               case '\n':
                  out.write('\\');
                  out.write('n');
                  break;
               case '\t':
                  out.write('\\');
                  out.write('t');
                  break;
               case '\f':
                  out.write('\\');
                  out.write('f');
                  break;
               case '\r':
                  out.write('\\');
                  out.write('r');
                  break;
               default:
                  if (ch > 0xf) {
                     out.write("\\u00" + hex(ch));
                  } else {
                     out.write("\\u000" + hex(ch));
                  }
                  break;
            }
         } else {
            switch (ch) {
               case '\'':
//                  if (escapeSingleQuote) {
//                     out.write('\\');
//                  }
                  out.write('\'');
                  break;
               case '"':
                  out.write('\\');
                  out.write('"');
                  break;
               case '\\':
                  out.write('\\');
                  out.write('\\');
                  break;
               default:
                  out.write(ch);
                  break;
            }
         }
      }

      return out.toString();
   }

   private static String hex(char ch) {
      return Integer.toHexString(ch).toUpperCase();
   }

   public static String pad(int fill, String pad) {
      return pad(fill, pad, "");
   }

   public static String pad(int fill, String pad, String text) {
      final StringBuilder out = new StringBuilder();
      for (int i = 0; i < fill; i++) out.append(pad);
      return out.append(text).toString();
   }

   public static String toString(Collection<?> list, String delimiter) {
      final StringBuilder out = new StringBuilder();
      boolean first = true;
      for (Object aList : list) {
         if (!first) out.append(delimiter);
         out.append(aList);
         first = false;
      }
      return out.toString();
   }

   public static String toString(Set<String> list, String delimiter) {
      final StringBuilder out = new StringBuilder();
      boolean first = true;
      for (String aList : list) {
         if (!first) out.append(delimiter);
         out.append(aList);
         first = false;
      }
      return out.toString();
   }

   public static String toString(Object[] array, String delimiter) {
      final StringBuilder out = new StringBuilder();
      boolean first = true;
      for (Object aList : array) {
         if (!first) out.append(delimiter);
         out.append(aList);
         first = false;
      }
      return out.toString();
   }

   public static boolean isStringNumeric(String str) {
      if (str == null || str.length() == 0) return false;

      DecimalFormatSymbols currentLocaleSymbols = DecimalFormatSymbols.getInstance();
      char localeMinusSign = currentLocaleSymbols.getMinusSign();
      if (!Character.isDigit(str.charAt(0)) && str.charAt(0) != localeMinusSign) return false;

      boolean isDecimalSeparatorFound = false;
      char localeDecimalSeparator = currentLocaleSymbols.getDecimalSeparator();

      for (char c : str.substring(1).toCharArray()) {
         if (!Character.isDigit(c)) {
            if (c == localeDecimalSeparator && !isDecimalSeparatorFound) {
               isDecimalSeparatorFound = true;
               continue;
            }
            return false;
         }
      }
      return true;
   }
}