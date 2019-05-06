import java.util.*;

class NQueen {
	int N;
	List<int[][]> res;

	NQueen(int n) {
		N = n;
		res = new ArrayList<>();
	}

	void solve() {
		int[][] board = new int[N][N];
		solve(board, 0);
	}

	void solve(int[][] board, int curRow) {
		if (curRow == N) {
			int[][] tmp = new int[N][N];
			for (int i = 0; i < N; i++) {
				tmp[i] = board[i].clone();
			}
			res.add(tmp);
		}

		for (int i = 0; i < N; i++) {
			if (checkBoard(board, curRow, i)) {
				board[curRow][i] = 1;
				solve(board, curRow + 1);
				board[curRow][i] = 0;
			}
		}
	}

	void print() {
		if (res.size() == 0) {
			System.out.println("No Solution for N: " + N);
		} else {
			System.out.println("There are total of " + res.size() + " possible solutions: ");
			for (int[][] m : res) {
				Jren.p(m);
				Jren.p();
			}
		}
	}

	boolean checkBoard(int[][] board, int curRow, int curCol) {
		for (int i = 0; i < curRow; i++) {
			if (board[i][curCol] == 1 || (curCol - curRow + i >= 0 && board[i][curCol - curRow + i] == 1) || (curCol + curRow - i < N && board[i][curCol + curRow - i] == 1)) {
				return false;
			}
		}
		return true;
	}



	public static void main(String[] args) {
		NQueen nq = new NQueen((args.length == 0)? 4 : Integer.parseInt(args[0]));
		nq.solve();
		nq.print();
	}
}