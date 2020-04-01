package com.generator.util;


/**
 * Created 24.04.18.
 */
public class Single<V> {

   private V value;

   public Single() {
   }

   public Single(V value) {
      this.value = value;
   }

   public V getValue() {
      return value;
   }

   public void setValue(V value) {
      this.value = value;
   }

   public boolean hasValue() {
      return value != null;
   }

   public boolean isEmpty() { return value == null; }

   @Override
   public String toString() {
      return "[" + (value == null ? "null" : value.toString()) + "]";
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Single<?> single = (Single<?>) o;

      return value.equals(single.value);
   }

   @Override
   public int hashCode() {
      return value.hashCode();
   }
}