package java.lang;

/**
 * @generated
 */
public final class Integer extends java.lang.Number implements java.lang.Comparable {

   /*+KEY@
     @ public normal_behavior
     @ requires 
     @   param0 > 0;
     @ ensures
     @   \result <= param0 && 
     @   (\bigint)2 * \result > param0;
     @ ensures
     @   (\exists \bigint i;
     @     0 <= i < \result;
     @     \dl_pow(2,i) == \result); // result is a power of two
     @*/
   /*+OPENJML@
     @ public normal_behavior
     @ requires 
     @   param0 > 0;
     @ ensures
     @   \result <= param0 && 
     @   2 * \result > param0;
     @ ensures
     @   (\result & (\result - 1)) == 0; // result is a power of two
     @*/
   public static /*@ strictly_pure @*/ int highestOneBit(int param0);

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public static java.lang.String toString(int param0, int param1);

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public static java.lang.String toHexString(int param0);

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public static java.lang.String toOctalString(int param0);

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public static java.lang.String toBinaryString(int param0);

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public static java.lang.String toString(int param0);

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public static int parseInt(java.lang.String param0, int param1) throws java.lang.NumberFormatException;

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public static int parseInt(java.lang.String param0) throws java.lang.NumberFormatException;

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public static java.lang.Integer valueOf(java.lang.String param0, int param1) throws java.lang.NumberFormatException;

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public static java.lang.Integer valueOf(java.lang.String param0) throws java.lang.NumberFormatException;

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public static java.lang.Integer valueOf(int param0);

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public Integer(int param0);

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public Integer(java.lang.String param0) throws java.lang.NumberFormatException;

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public byte byteValue();

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public short shortValue();

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public int intValue();

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public long longValue();

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public static java.lang.Integer getInteger(java.lang.String param0);

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public static java.lang.Integer getInteger(java.lang.String param0, int param1);

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public static java.lang.Integer getInteger(java.lang.String param0, java.lang.Integer param1);

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public static java.lang.Integer decode(java.lang.String param0) throws java.lang.NumberFormatException;

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public int compareTo(java.lang.Integer param0);

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public static int lowestOneBit(int param0);

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public static int numberOfLeadingZeros(int param0);

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public static int numberOfTrailingZeros(int param0);

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public static int bitCount(int param0);

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public static int rotateLeft(int param0, int param1);

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public static int rotateRight(int param0, int param1);

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public static int reverse(int param0);

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public static int signum(int param0);

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public static int reverseBytes(int param0);
}