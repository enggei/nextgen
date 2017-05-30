package com.generator.generators.regexp;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;

/**
 * Created 28.05.17.
 */
public class RegexpUtils {

   // uses StringUtil to match, and create regexp expressions
   private static final Random random = new Random(System.currentTimeMillis());

   private static final String[] alphabet = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
   private static final String[] symbols = new String[]{" ", "!", ",", "."};

   // atomic methods
   public static String randomString(int length) {
      final StringBuilder string = new StringBuilder();
      for (int i = 0; i < length; i++)
         string.append(alphabet[random.nextInt(alphabet.length)]);
      return string.toString();
   }

   public static String sample(String input) {
      if (input.length() == 0) return "";
      int startIndex = random.nextInt(input.length());
      if (startIndex == input.length() - 1)
         return input.substring(startIndex);
      return input.substring(startIndex, random.nextInt(input.length() - startIndex) + startIndex);
   }
}