class KnightTour {
	int N;
	int[][] sol;
	boolean isPossible;
	int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2}; 
    int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

    boolean isSafe(int x, int y, int sol[][]) { 
        return (x >= 0 && x < N && y >= 0 && 
                y < N && sol[x][y] == -1); 
    } 

	public KnightTour(int n) {
		this.N = n;
		sol = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sol[i][j] = -1;
			}
		}

		isPossible = this.solve();
	}

	private boolean solve() {
		sol[0][0] = 0;
		return ktHelper(0, 0, 1);
	}

	private boolean ktHelper(int x, int y, int moveNums) {
		if (moveNums == N * N) {return true;}
		Jren.p(this.sol);
		System.out.flush();

		for (int i = 0; i < xMove.length; i++) {
			int nextX = x + xMove[i];
			int nextY = y + yMove[i];
			if (isSafe(nextX, nextY, sol)) {
				sol[nextX][nextY] = moveNums;
				if (ktHelper(nextX, nextY, moveNums + 1)) {
					return true;
				} else {
					sol[nextX][nextY] = -1;
				}
			}
		}
		return false;
	}
	

	public static void main(String[] args) {
		int n = args.length > 0 ? Integer.parseInt(args[0]) : 8;
		KnightTour kt = new KnightTour(n);
		if (kt.isPossible) Jren.p(kt.sol);
		else Jren.p("not possible with input: " + n);

		
	}
}