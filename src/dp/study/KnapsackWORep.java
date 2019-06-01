import java.util.*; 

class KnapsackWORep {
	int W, N;
	int[] w, v;
	int res;
	int[][] dp;

	KnapsackWORep(int _W, int[] _w, int[] _v) {
		W = _W;
		N = _w.length;
		w = _w;
		v = _v;
		res = 0;
		dp = new int[W + 1][N + 1];
		for (int i = 0; i <= W; i++) {
			Arrays.fill(dp[i], -1);
		}
	}

	void solve_recursion() {
		res = solve_recursion(W, N);
		Jren.p(dp);
	}

	int solve_recursion(int capacityLeft, int lastItem) {
		if (capacityLeft <= 0 || lastItem <= 0) return 0;
		if (dp[capacityLeft][lastItem] != -1) return dp[capacityLeft][lastItem];
		int cur = 0;
		if (capacityLeft < w[lastItem - 1]) {
			cur = solve_recursion(capacityLeft, lastItem - 1);
		}
		else {
			int take = v[lastItem - 1] + solve_recursion(capacityLeft - w[lastItem - 1], lastItem - 1);
			int notTake = solve_recursion(capacityLeft, lastItem - 1);
			cur = Math.max(take, notTake);
		}
		dp[capacityLeft][lastItem] = cur;
		return cur;
	}

	void solve_bottom_up() {
		for (int i = 0; i <= W; i++) {
			dp[i][0] = 0;
		}
		for (int i = 0; i <= N; i++) {
			dp[0][i] = 0;
		}

		for (int i = 1; i <=W; i++) {
			for (int j = 1; j <= N; j++) {
				if (i < w[j - 1]) dp[i][j] = dp[i][j - 1];
				else dp[i][j] = Math.max(dp[i][j - 1], dp[i - w[j - 1]][j - 1] + v[j - 1]);
			}
		}
		res = dp[W][N];
		Jren.p(dp);
	}	

	public static void main(String[] args) {
		int W = 10;
		int[] w = new int[]{6, 3, 4, 2};
		int[] v = new int[]{30, 14, 16, 9};
		KnapsackWORep ks = new KnapsackWORep(W, w, v);
		ks.solve_recursion();
		System.out.println(ks.res);

		KnapsackWORep ks2 = new KnapsackWORep(W, w, v);
		ks2.solve_bottom_up();
		System.out.println(ks.res);
	}
}