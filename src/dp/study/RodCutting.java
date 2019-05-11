import java.util.*;

class RodCutting {
  // input: array of price list for different length of rods and the length of the rod to be cut
  // output: max profit from cutting and how to cut (all optimal solutions)

  int[] prices;
  int N;
  int maxProfit;
  int[] profitTable;
  int[] firstCutTable;

  RodCutting(int[] p, int n) {
    prices = p;
    N = n;
    maxProfit = 0;
    profitTable = new int[n + 1];
    Arrays.fill(profitTable, -1);
    profitTable[0] = 0;
    firstCutTable = new int[n + 1];
  }

  // get the max profit from length-n rod
  int solve_recursive(int n) {
    if (n == 0) return 0;
    if (profitTable[n] != -1) return profitTable[n];
    int curMax;
    int firstCut;
    if (n < prices.length) {curMax = prices[n]; firstCut = n;}
    else {curMax = 0; firstCut = 0;}
    for (int i = 1; i < n; i++) {
      int curProfit = solve_recursive(i) + solve_recursive(n - i);
      if (curProfit > curMax) {curMax = curProfit; firstCut = i;}
    }
    profitTable[n] = curMax;
    firstCutTable[n] = firstCut;
    return curMax;
  }

  int solve_iterative(int n) {
    for (int i = 1; i <= n; i++) {
      int curMax, firstCut;
      if (i < prices.length) {
        curMax = prices[i];
        firstCut = i;
      } else {
        curMax = 0;
        firstCut = 0;
      }

      for (int j = 1; j < i; j++) {
        int curProfit = profitTable[j] + profitTable[i - j];
        if (curProfit > curMax) {
          curMax = curProfit;
          firstCut = j;
        }
      }
      profitTable[i] = curMax;
      firstCutTable[i] = firstCut;
    }
    return profitTable[n];
  }

  int solve_bruteForce(int n) {
    if (n == 0) return 0;
    int curMax;
    if (n < prices.length) {curMax = prices[n];}
    else {curMax = 0;}
    for (int i = 1; i < n; i++) {
      int curProfit = solve_bruteForce(i) + solve_bruteForce(n - i);
      curMax = Math.max(curMax, curProfit);
    }
    return curMax;
  }

  void print() {
    System.out.println(maxProfit);
  }


  public static void main(String[] args) {
    int[] prices = new int[]{0,1,5,8,9,10,17,17,20,24,30};
    // for input length 0 - 10, the answer should be:
    //0 1 5 8 10 13 17 18 22 25 30
    //first cut at :
    //0 1 2 3 2 2 6 1 2 3 10
    long start, end;
    int res;

    start = System.nanoTime();
    int length = ;
    RodCutting rc = new RodCutting(prices, length);
    res = rc.solve_recursive(length);
    end = System.nanoTime();
    Jren.p("result: " + res);
    Jren.p("time_used: " + (end - start) / 10000);
    //Jren.p_index(rc.profitTable);
    //Jren.p(rc.firstCutTable);

    start = System.nanoTime();
    RodCutting rc_iter = new RodCutting(prices, length);
    res = rc_iter.solve_iterative(length);
    end = System.nanoTime();
    Jren.p("result: " + res);
    Jren.p("time_used: " + (end - start) / 10000);
    //Jren.p(rc_iter.profitTable);
    //Jren.p(rc_iter.firstCutTable);
    start = System.nanoTime();
    RodCutting rc_bf = new RodCutting(prices, length);
    res = rc_bf.solve_bruteForce(length);
    end = System.nanoTime();
    Jren.p("result: " + res);
    Jren.p("time_used: " + (end - start) / 10000);
  }

}