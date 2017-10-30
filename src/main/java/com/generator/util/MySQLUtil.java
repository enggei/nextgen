package com.generator.util;

/**
 * Created 27.10.17.
 */
public class MySQLUtil {

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
}