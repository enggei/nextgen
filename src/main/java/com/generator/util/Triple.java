package com.generator.util;

/**
 * Created 04.12.17.
 */
public class Triple<F, S, T> {

   private F first;
   private S second;
   private T third;

   public Triple(F first, S second, T third) {
      this.first = first;
      this.second = second;
      this.third = third;
   }

   public F getFirst() {
      return first;
   }

   public void setFirst(F first) {
      this.first = first;
   }

   public S getSecond() {
      return second;
   }

   public void setSecond(S second) {
      this.second = second;
   }

   public T getThird() {
      return third;
   }

   public void setThird(T third) {
      this.third = third;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Triple<?, ?, ?> triple = (Triple<?, ?, ?>) o;

      return (first != null ? first.equals(triple.first) : triple.first == null) && (second != null ? second.equals(triple.second) : triple.second == null) && (third != null ? third.equals(triple.third) : triple.third == null);
   }

   @Override
   public int hashCode() {
      int result = first != null ? first.hashCode() : 0;
      result = 31 * result + (second != null ? second.hashCode() : 0);
      result = 31 * result + (third != null ? third.hashCode() : 0);
      return result;
   }

   @Override
   public String toString() {
      return "[" + first + "," + second + "," + third + "]";
   }
}