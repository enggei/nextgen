package com.generator.generators.csv.parser;

public class CSVDomain {

   public class CSVDomainSymbol {

   }

   public final class csvFile extends CSVDomainSymbol {

      public hdr hdr;
      public java.util.List<row> rowList = new java.util.ArrayList<>();

   }

   public final class hdr extends CSVDomainSymbol {

      public row row;

   }

   public final class row extends CSVDomainSymbol {

      public java.util.List<field> fieldList = new java.util.ArrayList<>();

   }

   public final class field extends CSVDomainSymbol {

      public CSVDomainSymbol symbol;

      public void setTEXT(TEXT symbol) {
         this.symbol = symbol;
      }

      public void setSTRING(STRING symbol) {
         this.symbol = symbol;
      }
   }

   public final class TEXT extends CSVDomainSymbol {

      private String value;

      public TEXT set(String value) {
         if (value.contains(",")) return this;
         if (value.contains("\n")) return this;
         if (value.contains("\r")) return this;
         if (value.contains("\"")) return this;
         this.value = value;
         return this;
      }

      public String get() {
         return value;
      }
   }

   public final class STRING extends CSVDomainSymbol {

   }
}