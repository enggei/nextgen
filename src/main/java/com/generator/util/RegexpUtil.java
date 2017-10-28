package com.generator.util;

import java.util.LinkedHashMap;
import java.util.Map;
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

   public static String process(String inputText, String regexp, String replacement) {

//      final String lineSeparator = System.getProperty("line.separator");
//
//      final Pattern pattern = Pattern.compile(regexp);
//      final Matcher matcher = pattern.matcher(inputText);
//
      final StringBuilder filteredText = new StringBuilder();
//      final char[] input = inputText.toCharArray();
//      int currentIndex = 0;
//      while (matcher.find()) {
//         final int start = matcher.start();
//         final int end = matcher.end();
//
//         if (replacement.length() > 0) {
//
//            String newLine = replacement;
//            for (int i = 0; i < matcher.groupCount(); i++)
//               newLine = newLine.replace("$" + (i + 1), matcher.group(i + 1));
//
//            if (chkKeepMatches.isSelected()) {
//               filteredText.append(newLine).append(lineSeparator);
//               currentIndex = inputText.length();
//            } else {
//               if (radReplace.isSelected()) {
//                  filteredText.append(inputText.substring(currentIndex, start));
//                  filteredText.append(newLine);
//                  currentIndex = end;
//               } else if (radInsertAfter.isSelected()) {
//                  filteredText.append(inputText.substring(currentIndex, end));
//                  filteredText.append(newLine);
//                  currentIndex = end;
//               } else if (radInsertBefore.isSelected()) {
//                  filteredText.append(inputText.substring(currentIndex, start));
//                  filteredText.append(newLine);
//                  filteredText.append(inputText.substring(start, end));
//                  currentIndex = end;
//               } else if (radInsertLineBefore.isSelected()) {
//                  filteredText.append(inputText.substring(currentIndex, start));
//                  filteredText.append(newLine);
//                  filteredText.append(lineSeparator);
//                  filteredText.append(inputText.substring(start, end));
//                  currentIndex = end;
//               }
//            }
//         }
//
//         if (radRemove.isSelected()) {
//            filteredText.append(inputText.substring(currentIndex, start));
//            currentIndex = end;
//
//         } else if (radRemoveLine.isSelected()) {
//
//            // if there are multiple matches on a line, the first match removes the entire line.
//            // Therefore, just ignore the rest of the matches on this (removed) line.
//            if (start >= currentIndex) {
//               int startOfLine = start;
//               while (startOfLine > 0) {
//                  if (lineSeparator.equals(("" + input[startOfLine])))
//                     break;
//                  startOfLine--;
//               }
//
//               int endOfLine = end;
//               while (endOfLine < input.length) {
//                  if (lineSeparator.equals(("" + input[endOfLine])))
//                     break;
//                  endOfLine++;
//               }
//
//               filteredText.append(inputText.substring(currentIndex, startOfLine));
//               currentIndex = endOfLine;
//            }
//
//         } else if (radRemoveLineBefore.isSelected()) {
//
//            int startOfLine = start;
//            int endOfLine = 0;
//            while (startOfLine > 0) {
//               if (lineSeparator.equals(("" + input[startOfLine]))) {
//                  if (endOfLine == 0) {
//                     endOfLine = startOfLine;
//                  } else
//                     break;
//               }
//               startOfLine--;
//            }
//
//            if (startOfLine >= currentIndex) {
//               filteredText.append(inputText.substring(currentIndex, startOfLine));
//               currentIndex = endOfLine;
//            }
//
//         } else if (radRemoveLineAfter.isSelected()) {
//
//            if (start >= currentIndex) {
//               int endOfLine = end;
//               int startOfLine = -1;
//               while (endOfLine < input.length - 1) {
//                  if (lineSeparator.equals(("" + input[endOfLine]))) {
//                     if (startOfLine == -1) {
//                        startOfLine = endOfLine;
//                     } else
//                        break;
//                  }
//                  endOfLine++;
//               }
//               filteredText.append(inputText.substring(currentIndex, startOfLine == -1 ? end : startOfLine));
//               currentIndex = endOfLine;
//            }
//
//         } else if (radInsertLineAfter.isSelected()) {
//
//            String newLine = "";
//            if (replacement.length() > 0) {
//               newLine = replacement;
//               for (int i = 0; i < matcher.groupCount(); i++)
//                  newLine = newLine.replace("$" + (i + 1), matcher.group(i + 1));
//            }
//
//            filteredText.append(inputText.substring(currentIndex, end));
//            filteredText.append(lineSeparator);
//            filteredText.append(newLine);
//            currentIndex = end;
//
//         } else if (chkKeepMatches.isSelected()) {
//            filteredText.append(inputText.substring(start, end)).append(lineSeparator);
//            currentIndex = inputText.length();
//         }
//      }
//
//      if (currentIndex < inputText.length())
//         filteredText.append(inputText.substring(currentIndex, inputText.length()));
//
//      final StringBuilder outputText = new StringBuilder();
//      if (chkTrimEmptyLines.isSelected()) {
//         final String[] lines = filteredText.toString().split(lineSeparator);
//         String previous = null;
//         for (int i = 0; i < lines.length; i++) {
//            String line = lines[i];
//            if (line.trim().length() == 0 && previous != null && previous.trim().length() == 0)
//               continue;
//            outputText.append(line).append(lineSeparator);
//            previous = line;
//         }
//
//      } else {
//         outputText.append(filteredText.toString());
//      }

      return filteredText.toString();
   }
}