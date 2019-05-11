import java.util.*;

class LongestIncreasingSubseq {
	int res;
	int[] A;

	LongestIncreasingSubseq(int[] A) {
		this.A = A;
		res = 0;
	}

	void solve() {
		Deque<Integer> curSeq = new ArrayDeque<>();
		res = solve(curSeq);
		res = solve(-1, 0);
		res = solve(-1);
	}

	// version 3: passing only the lastIndex
	int solve(int lastIndex) {
		int max = 0;
		for (int i = lastIndex + 1; i < A.length; i++) {
			if (A[i] > (lastIndex == -1 ? Integer.MIN_VALUE : A[lastIndex])) {
				max = Math.max(max, solve(i) + 1);
			}
		}
		return max;
	}

	// version 2: only passing the lastIndex and curLen of the subsequence
	int solve(int lastIndex, int curLen) {
		int max = curLen;
		for (int i = lastIndex + 1; i < A.length; i++) {
			if (A[i] > (lastIndex == -1 ? Integer.MIN_VALUE : A[lastIndex])) {
				max = Math.max(max, solve(i, curLen + 1));
			}
		}
		return max;
	}


	// version 1: passing the whole indices list of current subsequence
	int solve(Deque<Integer> curSeq) {
		int max = curSeq.size();
		int lastIndex, lastElement;
		if (curSeq.size() == 0) {
			lastIndex = -1;
			lastElement = Integer.MIN_VALUE;
		} else {
			lastIndex = curSeq.getLast();
			lastElement = A[lastIndex];
		}

		for (int i = lastIndex + 1; i < A.length; i++) {
			if (A[i] > lastElement) {
				curSeq.addLast(i);
				max = Math.max(max, solve(curSeq));
				curSeq.removeLast();
			}
		}
		return max;
	}


	public static void main(String[] args) {
		int[] A = new int[]{7,2,1,3,8,4,9};
		LongestIncreasingSubseq lis = new LongestIncreasingSubseq(A);
		lis.solve();
		Jren.p(lis.res);
	}
}