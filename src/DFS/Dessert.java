import java.util.*;
import java.io.*;

class Dessert {

	char[] operators = new char[]{'+', '-', '.'};
	int N;
	//solve sol as char[N - 1] representing each char to be inserted
	List<char[]> solList;

	public Dessert(int n) {
		N = n;
		solList = new ArrayList<char[]>();
	}

	void solve() {
		char[] cur = new char[N];
		cur[0] = '+';
		solve(1, cur);
	}

	void solve(int curIndex, char[] curSol) {
		if (curIndex == N) {
			if (eval(curSol) == 0) {solList.add(curSol.clone());}
			return;
		}

		for (char c : operators) {
			curSol[curIndex] = c;
			solve(curIndex + 1, curSol);
			curSol[curIndex] = '\0';
		}
	}

	int eval(char[] sol) {
		int res = 0;
		for (int i = 0; i < N; i++) {
			char curOp = sol[i];
			int nextNum = i + 1;
			while ((i + 1) < N && sol[i + 1] == '.') {
				nextNum = nextNum * 10 + (i + 2);
				i++;
			}

			if (curOp == '+') {
				res += nextNum;
			} else {
				res -= nextNum;
			}
		}
		return res;
	}

	

	void printSol() {
		int i = 0;
		for (char[] sol : solList) {
			for (String c : convertSol(sol)) {
				System.out.print(c + " ");
			}
			System.out.println();
			i++;
			if (i == 20) break;
		}
	}

	String[] convertSol(char[] sol) {
		String[] res = new String[N + N - 1];
		for (int i = 0; i < res.length; i+=2) {
			res[i] = String.valueOf(i / 2 + 1);
			if (i + 1 < res.length) res[i + 1] = String.valueOf(sol[i / 2 + 1]);
		} 
		return res;
	}



	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n = in.nextInt();
		Dessert d = new Dessert(n);
		d.solve();
		d.printSol();
		System.out.println(d.solList.size());
	}
}