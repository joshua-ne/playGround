import java.util.*;

class LongestSubseq {
  String s1, s2;
  String res;

  LongestSubseq(String _s1, String _s2) {
    s1 = _s1;
    s2 = _s2;
    res = "";
  }

  String solve_dp_recursive() {
    int[][] dp = new int[s1.length()][s2.length()];
    for (int i = 0; i < s1.length(); i++) {
      Arrays.fill(dp[i], -1);
    }
    int[] sol = new int[s1.length()];
    dp[0][0] = (s1.charAt(0) == s2.charAt(0) ? 1 : 0);
    for (int i = 1; i < s1.length(); i++) {
      if (dp[i - 1][0] == 1) dp[i][0] = 1;
      else dp[i][0] = (s1.charAt(i) == s2.charAt(0) ? 1 : 0);
    }
    for (int i = 1; i < s2.length(); i++) {
      if (dp[0][i - 1] == 1) dp[0][i] = 1;
      else dp[0][i] = (s2.charAt(i) == s1.charAt(0) ? 1 : 0);
    }
    solve_dp_recursive(dp, sol, s1.length() - 1, s2.length() - 1);
    //return printRes(sol, s1.length() - 1, s2.length() - 1);
    Jren.p(sol);
    return String.valueOf(dp[s1.length() - 1][s2.length() - 1]);
  }

  int solve_dp_recursive(int[][] dp, int[] sol, int s1LastIndex, int s2LastIndex) {
    if (dp[s1LastIndex][s2LastIndex] != -1) return dp[s1LastIndex][s2LastIndex];
    int res;
    if (s1.charAt(s1LastIndex) == s2.charAt(s2LastIndex)) {
      res = 1 + solve_dp_recursive(dp, sol, s1LastIndex - 1, s2LastIndex - 1);
      sol[s1LastIndex] = res;
      }
    else {
      res = Math.max(solve_dp_recursive(dp, sol, s1LastIndex - 1, s2LastIndex), solve_dp_recursive(dp, sol, s1LastIndex, s2LastIndex-  1));
    }
    dp[s1LastIndex][s2LastIndex] = res;
    return res;
  }

  String solve_bf() {
    Set<String> s1Subseq = generateSubSeqSet(s1);
    //Jren.p(s1Subseq.size());
    Set<String> s2Subseq = generateSubSeqSet(s2);
    //Jren.p(s1Subseq.size());
    for (String str : s1Subseq) {
      //Jren.p(str);
      if (str.length() > 3 && s2Subseq.contains(str)) {
        Jren.p(res);
        res = str;
      }
    }
    return res;
  }

  Set<String> generateSubSeqSet(String s) {
    Set<String> set = new HashSet<>();
    generateSubSeqSet(s, 0, new StringBuilder(), set);
    return set;
  }
  void generateSubSeqSet(String s, int curIndex, StringBuilder sb, Set<String> set) {
    if (curIndex == s.length()) {
      set.add(sb.toString());
      return;
    }
    generateSubSeqSet(s, curIndex + 1, sb, set);
    sb.append(s.charAt(curIndex));
    generateSubSeqSet(s, curIndex + 1, sb, set);
    sb.deleteCharAt(sb.length() - 1);
  }



  public static void main(String[] args) {
    String s1 = "BADCABDC";
    String s2 = "ACCDDBAB";
    LongestSubseq lss = new LongestSubseq(s1, s2);
    Jren.p(lss.solve_bf());
    Jren.p(lss.solve_dp_recursive());
  }
}