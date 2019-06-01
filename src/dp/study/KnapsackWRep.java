import java.util.*;

class KnapsackWRep {
	int[] w, v;
	int W, res;
	int[] dp;

	KnapsackWRep(int W, int[] w, int[] v) {
		this.W = W;
		this.w = w;
		this.v = v;
		res = 0;
		dp = new int[W + 1];
		Arrays.fill(dp, -1);
	}

	void solve_recursion() {
		res = solve_recursion(W);
		Jren.p(dp);

	}

	int solve_recursion(int capacityLeft) {
		if (capacityLeft <= 0) return 0;
		if (dp[capacityLeft] != -1) return dp[capacityLeft];
		int cur = 0;
		for (int i = 0; i < w.length; i++) {
			if (capacityLeft >= w[i]) {
				cur = Math.max(cur, solve_recursion(capacityLeft - w[i]) + v[i]);
			}
		}
		dp[capacityLeft] = cur;
		return cur;
	}

	void solve_iteration() {
		dp[0] = 0;
		for (int i = 1; i <= W; i++) {
			int cur = 0;
			for (int k = 0; k < w.length; k++) {
				if (i >= w[k]) {
					cur = Math.max(cur, dp[i - w[k]] + v[k]);
				} 
			}
			dp[i] = cur;
		}
		res = dp[W];
		Jren.p(dp);

	}


	public static void main(String[] args) {
		int W = 10;
		int[] w = new int[]{6, 3, 4, 2};
		int[] v = new int[]{30, 14, 16, 9};
		KnapsackWRep ks = new KnapsackWRep(W, w, v);
		ks.solve_recursion();
		System.out.println(ks.res);

		KnapsackWRep ks2 = new KnapsackWRep(W, w, v);
		ks2.solve_iteration();
		System.out.println(ks2.res);
	}
}