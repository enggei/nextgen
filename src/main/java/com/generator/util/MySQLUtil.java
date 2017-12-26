package com.generator.util;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created 27.10.17.
 */
public class MySQLUtil {

   private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(MySQLUtil.class);

   public static Object valueMapping(Object value) {

      if (value instanceof BigInteger) return ((BigInteger) value).longValue();
      if (value instanceof java.sql.Date) return ((java.sql.Date) value).getTime();
      if (value instanceof java.sql.Timestamp) return ((java.sql.Timestamp) value).getTime();

      return value;
   }

   public static String columnMapping(String columnType) {
      if (columnType.toUpperCase().startsWith("BIT(1)")) {
         return "java.lang.Boolean";
      } else if (columnType.toUpperCase().startsWith("CHAR")) {
         return "String";
      } else if (columnType.toUpperCase().startsWith("VARCHAR")) {
         return "String";
      } else if (columnType.toUpperCase().startsWith("LONGVARCHAR")) {
         return "String";
      } else if (columnType.toUpperCase().startsWith("NUMERIC")) {
         return "java.math.BigDecimal";
      } else if (columnType.toUpperCase().startsWith("DECIMAL")) {
         return "java.math.BigDecimal";
      } else if (columnType.toUpperCase().startsWith("BIT")) {
         return "java.lang.Boolean";
      } else if (columnType.toUpperCase().startsWith("TINYINT")) {
         return "byte";
      } else if (columnType.toUpperCase().startsWith("SMALLINT")) {
         return "Short";
      } else if (columnType.toUpperCase().startsWith("INTEGER")) {
         return "Integer";
      } else if (columnType.toUpperCase().startsWith("BIGINT")) {
         return "Long";
      } else if (columnType.toUpperCase().startsWith("REAL")) {
         return "Float";
      } else if (columnType.toUpperCase().startsWith("FLOAT")) {
         return "Double";
      } else if (columnType.toUpperCase().startsWith("DOUBLE")) {
         return "Double";
      } else if (columnType.toUpperCase().startsWith("BINARY")) {
         return "byte []";
      } else if (columnType.toUpperCase().startsWith("VARBINARY")) {
         return "byte []";
      } else if (columnType.toUpperCase().startsWith("LONGVARBINARY")) {
         return "byte []";
      } else if (columnType.toUpperCase().startsWith("DATE")) {
         return "java.sql.Date";
      } else if (columnType.toUpperCase().startsWith("TIME")) {
         return "java.sql.Time";
      } else if (columnType.toUpperCase().startsWith("TIMESTAMP")) {
         return "java.sql.Timestamp";
      }

      return "Object";
   }

   public static String resultSetGetter(String columnType) {
      if (columnType.toUpperCase().startsWith("BIT(1)")) {
         return "Boolean";
      } else if (columnType.toUpperCase().startsWith("CHAR")) {
         return "String";
      } else if (columnType.toUpperCase().startsWith("VARCHAR")) {
         return "String";
      } else if (columnType.toUpperCase().startsWith("LONGVARCHAR")) {
         return "String";
      } else if (columnType.toUpperCase().startsWith("NUMERIC")) {
         return "java.math.BigDecimal";
      } else if (columnType.toUpperCase().startsWith("DECIMAL")) {
         return "java.math.BigDecimal";
      } else if (columnType.toUpperCase().startsWith("BIT")) {
         return "java.lang.Boolean";
      } else if (columnType.toUpperCase().startsWith("TINYINT")) {
         return "byte";
      } else if (columnType.toUpperCase().startsWith("SMALLINT")) {
         return "Short";
      } else if (columnType.toUpperCase().startsWith("INTEGER")) {
         return "Integer";
      } else if (columnType.toUpperCase().startsWith("BIGINT")) {
         return "Long";
      } else if (columnType.toUpperCase().startsWith("REAL")) {
         return "Float";
      } else if (columnType.toUpperCase().startsWith("FLOAT")) {
         return "Double";
      } else if (columnType.toUpperCase().startsWith("DOUBLE")) {
         return "Double";
      } else if (columnType.toUpperCase().startsWith("BINARY")) {
         return "byte []";
      } else if (columnType.toUpperCase().startsWith("VARBINARY")) {
         return "byte []";
      } else if (columnType.toUpperCase().startsWith("LONGVARBINARY")) {
         return "byte []";
      } else if (columnType.toUpperCase().startsWith("DATE")) {
         return "Date";
      } else if (columnType.toUpperCase().startsWith("TIME")) {
         return "Time";
      } else if (columnType.toUpperCase().startsWith("TIMESTAMP")) {
         return "Timestamp";
      }

      return "Object";
   }

   /**
    * turns everything but `[name]` to upper case (antlr is case sensitive)
    *
    * @param string the sql to process
    * @return sql in upper-case
    */
   public static String preprocessSQL(String string) {
      if (string == null || string.trim().length() == 0) return "";
      log.info("init " + string.trim());

      string = string.replaceAll("\'", "`");
      log.info("pre  " + string.trim());

      boolean name = false;
      final StringBuilder output = new StringBuilder();
      final char[] chars = string.toCharArray();
      for (char aChar : chars) {
         char c = name ? aChar : Character.toUpperCase(aChar);
         if (c == '`') name = !name;
         output.append(c);
      }
      log.info("post " + output.toString().trim());
      return output.toString().trim();
   }
}