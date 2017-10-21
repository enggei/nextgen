package com.generator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created 20.10.17.
 */
public class RegexpUtil {

   public interface RegexpProcessor {

      void onMatch(int start, int end);

      void onMatch(int start, int end, String group);
   }

   public static void process(String regexp, String input, RegexpProcessor regexpProcessor) {

      final Pattern pattern = Pattern.compile(regexp);
      final Matcher matcher = pattern.matcher(input);

      while (matcher.find()) {
         final int start = matcher.start();
         final int end = matcher.end();

         final int groupCount = matcher.groupCount();

         if (groupCount == 0) {
            regexpProcessor.onMatch(start, end);

         } else {
            for (int i = 0; i < groupCount; i++) {
               final String group = matcher.group(i + 1);
               regexpProcessor.onMatch(start, end, group);
            }
         }
      }
   }

   public static String replace(String regexp, String input, String replacement) {

      final StringBuilder filteredText = new StringBuilder();

      final Pattern pattern = Pattern.compile(regexp);
      final Matcher matcher = pattern.matcher(input);

      int currentIndex = 0;
      while (matcher.find()) {
         final int start = matcher.start();
         final int end = matcher.end();

         String newLine = replacement;
         for (int i = 0; i < matcher.groupCount(); i++)
            newLine = newLine.replace("$" + (i + 1), matcher.group(i + 1));
         filteredText.append(input.substring(currentIndex, start));
         filteredText.append(newLine);
         currentIndex = end;
      }

      if (currentIndex < input.length())
         filteredText.append(input.substring(currentIndex, input.length()));

      return filteredText.toString();
   }

}