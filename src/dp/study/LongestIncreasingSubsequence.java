import java.util.*;

class LongestIncreasingSubsequence {
  int[] nums;
  int res;
  long time, start, end;
  int[] table;
  int count;

  LongestIncreasingSubsequence (int[] A){
    nums = A;
    res = 0;
  }

  int solve_bf_v1() {
    count = 0;
    start = System.nanoTime();
    res = solve_bf_v1(new ArrayDeque<Integer>());
    end = System.nanoTime();
    time = end - start;
    return res;
  }

  int solve_bf_v1(Deque<Integer> curSeq) {
    count++;
    int curMax = curSeq.size();
    int lastIndex, lastElement;
    if (curSeq.size() == 0) {
      lastIndex = -1;
      lastElement = Integer.MIN_VALUE;
    } else {
      lastIndex = curSeq.getLast();
      lastElement = nums[lastIndex];
    }
    for (int i = lastIndex + 1; i < nums.length; i++) {
      if (nums[i] > lastElement) {
        curSeq.addLast(i);
        curMax = Math.max(curMax, solve_bf_v1(curSeq));
        curSeq.removeLast();
      }
    }
    return curMax;
  }


  int solve_bf_v2(){
    count = 0;
    start = System.nanoTime();
    res = solve_bf_v2(-1, 0);
    end = System.nanoTime();
    time = end - start;
    return res;
  }

  int solve_bf_v2(int lastIndex, int curLength) {
    count++;
    int curMax = curLength;
    for (int i = lastIndex + 1; i < nums.length; i++) {
      if (nums[i] > (lastIndex == -1 ? Integer.MIN_VALUE : nums[lastIndex])) {
        curMax = Math.max(curMax, solve_bf_v2(i, curLength + 1));
      }
    }
    return curMax;
  }


  int solve_bf_v3(){
    count = 0;
    start = System.nanoTime();
    res = solve_bf_v3(-1);
    end = System.nanoTime();
    time = end - start;
    return res;
  }

  int solve_bf_v3(int lastIndex) {
    count++;
    int curMax = 0;
    for (int i = lastIndex + 1; i < nums.length; i++) {
      if (nums[i] > (lastIndex == -1 ? Integer.MIN_VALUE : nums[lastIndex])) {
        curMax = Math.max(curMax, 1 + solve_bf_v3(i));
      }
    }
    return curMax;
  }

  int solve_dp_recursive(){
    count = 0;
    start = System.nanoTime();
    table = new int[nums.length];
    Arrays.fill(table, -1);
    res = 0;
    for (int i = 0; i < nums.length; i++) {
      res = Math.max(res, solve_dp_recursive(i));
    }

    end = System.nanoTime();
    time = end - start;
    return res;
  }

  int solve_dp_recursive(int start) {
    
    int curMax = 1;
    //base case
    if (start == nums.length - 1) curMax = 1;
    else if (table[start] != -1) curMax = table[start];
    
    else {
      count++;
      for (int i = start + 1; i < nums.length; i++) {
        if (nums[i] > (start == -1 ? Integer.MIN_VALUE : nums[start])) {
          curMax = Math.max(curMax, 1 + solve_dp_recursive(i));
        }
      }
    }
    table[start] = curMax;
    return curMax;
  }


  public static void main(String[] args) {
    int[] A = new int[]{7,2,1,3,8,4,9};
    //A = new int[]{1,2,3,4,5,6};
    Random rand = new Random();
    A = new int[300];
    for (int i = 0; i < A.length; i++) {
      A[i] = rand.nextInt(10000);
    }
    LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence(A);
    Jren.p(lis.solve_bf_v1());
    Jren.p("time_used: " + lis.time / 10000);
    Jren.p("recursion call counts: " + lis.count);
    Jren.p();
    Jren.p(lis.solve_bf_v2());
    Jren.p("time_used: " + lis.time / 10000);
    Jren.p("recursion call counts: " + lis.count);
    Jren.p();
    Jren.p(lis.solve_bf_v3());
    Jren.p("time_used: " + lis.time / 10000);
    Jren.p("recursion call counts: " + lis.count);
    Jren.p();
    Jren.p(lis.solve_dp_recursive());
    Jren.p("time_used: " + lis.time / 10000);
    Jren.p("recursion call counts: " + lis.count);
    Jren.p(A);
    Jren.p(lis.table);
  }
}