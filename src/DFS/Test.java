class Test {


	static int eval(char[] sol) {
		int res = 0;
		for (int i = 0; i < sol.length; i++) {
			//System.out.print(res + " ");
			char curOp = sol[i];
			int nextNum = i + 1;
			while ((i + 1) < sol.length && sol[i + 1] == '.') {
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


	public static void main(String[] args) {
		char[] sol = new char[]{'+','+','+','+','+','-','-','+','-','+','-','-','+','+','-'};
		System.out.println(eval(sol));
	}
}

