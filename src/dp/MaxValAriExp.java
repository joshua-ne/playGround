import java.util.*;

class MaxValAriExp {
	int[] inputNum;
	char[] inputOp;
	int[][][] table;
	int res;

	MaxValAriExp(String in) {
		char[] input;
		if (in.charAt(0) != '-') {
			input = new char[in.length() + 1];
			input[0] = '+';
			for (int i = 0; i < in.length(); i++) {
				input[i + 1] = in.charAt(i);
			}
		} else {
			input = in.toCharArray();
		}

		inputOp = new char[input.length / 2];
		inputNum = new int[input.length / 2];
		
		for (int i = 0; i < input.length; i += 2) {
			inputOp[i / 2] = input[i];
			inputNum[i / 2] = input[i + 1] - 48;
		}


		int n = inputNum.length;
		//this table will save both the max/min value of res(i, j) i <= j
		table = new int[n][n][];
		for (int i = 0; i < n; i++) {
			table[i][i] = new int[] {inputNum[i], inputNum[i]};
		}

		//Jren.p(inputOp);
		//Jren.p(inputNum);
	}

	int solve() {
		return solve(0, inputNum.length - 1)[0];
	}

	int[] solve(int start, int end) {
		if (table[start][end] != null) return table[start][end];
		int gmax = Integer.MIN_VALUE, gmin = Integer.MAX_VALUE;
		for (int k = start; k < end; k++) {
			int max, min;
			int[] op1 = solve(start, k);
			int[] op2 = solve(k + 1, end);
			char operator = inputOp[k + 1];
			switch (operator) {
				case '+':
					max = op1[0] + op2[0];
					min = op1[1] + op2[1];
					break;
				case '-':
					max = op1[0] - op2[1];
					min = op1[1] - op2[0];
					break;
				default:
					int[] res = new int[4];
					res[0] = op1[0] * op2[0];
					res[1] = op1[1] * op2[1];
					res[2] = op1[0] * op2[1];
					res[3] = op1[1] * op2[0];
					Arrays.sort(res);
					max = res[3];
					min = res[0];
					break;
			}
			gmax = Math.max(gmax, max);
			gmin = Math.min(gmin, min);
		}
		return new int[]{gmax, gmin};
	}

	public static void main(String[] args) {
		String input = "5-8+7*4-8+9";
		MaxValAriExp mvae = new MaxValAriExp(input);
		Jren.p(mvae.solve());
	}
}