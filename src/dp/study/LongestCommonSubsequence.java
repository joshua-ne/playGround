import java.util.*;
import java.lang.*;
import java.io.*;
class LongestCommonSubsequence
 {
     int m, n;
     String s, t;
     int res;
     int[][] dp;
     LongestCommonSubsequence(int _m, int _n, String _s, String _t) {
         m = _m;
         n = _n;
         s = _s;
         t = _t;
         res = 0;
         dp = new int[m][n];
     }
     
     void solve() {
         for (int i = m - 1; i >= 0; i--) {
             for (int j = n - 1; j >= 0; j--) {
                 int cur = 0;
                 if (s.charAt(i) == t.charAt(j)) cur = 1 + getValue(dp, i + 1, j + 1);
                 cur = Math.max(cur, getValue(dp, i, j + 1));
                 cur = Math.max(cur, getValue(dp, i + 1, j));
                 dp[i][j] = cur;
             }
         }
         res = dp[0][0];
     }
     
     int getValue(int[][] dp, int i, int j) {
         if (i >= 0 && i < dp.length && j >= 0 && j < dp[0].length) {
             return dp[i][j];
         }
         else return 0;
     }
     
     
     
  public static void main (String[] args)
   {

    int a = 6;
    int b = 6;
    String s = "ABCDGH";
    String t = "AEDFHR";
    LongestCommonSubsequence lcs = new LongestCommonSubsequence(a, b, s, t);
    lcs.solve();
    System.out.println(lcs.res);
      /*
      Scanner in  = new Scanner(System.in);
      int T = in.nextInt();
      for (int k = 1; k <= T; k++) {
          int m = in.nextInt();
          int n = in.nextInt();
          String s = in.next();
          String t = in.next();
          LongestCommonSubsequence lcs = new LongestCommonSubsequence(m, n, s, t);
          lcs.solve();
          System.out.println(lcs.res);
      }
      */
   }
}