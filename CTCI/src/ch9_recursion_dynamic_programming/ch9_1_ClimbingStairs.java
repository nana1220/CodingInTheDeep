package ch9_recursion_dynamic_programming;

import org.junit.Test;

public class ch9_1_ClimbingStairs {

   /**
    * Climbing stairs. 1/2/3 steps each time
    */

   // Dynamic Programming
   public int climbingStairs(int n) {
      int[] mem = new int[n + 1];
      mem[0] = 0;
      mem[1] = 1;
      mem[2] = 2;
      mem[3] = 4;
      for (int i = 4; i <= n; i++) {
         mem[i] = mem[i - 1] + mem[i - 2] + mem[i - 3];
      }
      return mem[n];
   }

   @Test
   public void test() {
      int num = 30;
      System.out.println(num);
      System.out.println(climbingStairs(num));
   }

}
