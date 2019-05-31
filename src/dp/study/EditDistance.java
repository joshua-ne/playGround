import java.util.*;

class EditDistance {
  String s1, s2;
  int res;
  int[][] dp;
	EditDistance(String s1, String s2) {
    this.s1 = s1;
    this.s2 = s2;
    res = 0;
    //dp[i][j] solves the problem for s1[i:] and s2[j:]
    dp = new int[s1.length()][s2.length()];
    for (int i = 0; i < s1.length(); i++) {
      Arrays.fill(dp[i], -1);
    }
	}

  void solve_recursion(){
    res = solve_recursion(0,0);
  }

  int solve_recursion(int i, int j) {
    if (i == s1.length()) return s2.length() - j;
    if (j == s2.length()) return s1.length() - i;
    if (dp[i][j] != -1) return dp[i][j];
    int cur = Integer.MAX_VALUE;
    if (s1.charAt(i) == s2.charAt(j)) cur = solve_recursion(i + 1, j + 1);
    else cur = solve_recursion(i + 1, j + 1) + 1;
    cur = Math.min(cur, solve_recursion(i + 1, j) + 1);
    cur = Math.min(cur, solve_recursion(i, j + 1) + 1);
    dp[i][j] = cur;
    return cur;
  }

  void solve_iter() {
    for (int i = s1.length() - 1; i >= 0; i--) {
      for (int j = s2.length() - 1; j >= 0; j--) {
        int ed = Integer.MAX_VALUE;
        if (s1.charAt(i) == s2.charAt(j)) {ed = getValue(dp, i + 1, j + 1);}
        else {ed = getValue(dp, i + 1, j + 1) + 1;}
        ed = Math.min(ed, 1 + getValue(dp, i + 1, j));
        ed = Math.min(ed, 1 + getValue(dp, i, j + 1));
        dp[i][j] = ed;
      }
    }
    res = dp[0][0];
    Jren.p(dp);
  }

  int getValue(int[][] dp, int i, int j) {
    if (i == dp.length) {return s2.length() - j;}
    if (j == dp[0].length) {return s1.length() - i;}
    else return dp[i][j];
  }







	public static void main(String[] args) {
		String s1 = "editing";
		String s2 = "distance";

		//ans = 5;
		EditDistance ed = new EditDistance(s1, s2);
    ed.solve_recursion();
    System.out.println(ed.res);
	}
}