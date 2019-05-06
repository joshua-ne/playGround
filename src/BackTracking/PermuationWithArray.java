import java.util.*;


//don't duplicates in the input string

class PermuationWithArray {
	String s;
	List<String> res;
	char[] chars;

	PermuationWithArray(String s) {
		this.s = s;
		chars = s.toCharArray();
		res = new ArrayList<>();
	}

	void solve() {
		StringBuilder sb = new StringBuilder();
		solve(sb, chars);
	}

	void solve(StringBuilder sb, char[] availableChars) {

		if (sb.length() == this.s.length()) {res.add(sb.toString());}

		for (int i = 0; i < availableChars.length; i++) {
			if (availableChars[i] != '\0') {
				char c = availableChars[i];
				sb.append(c);
				availableChars[i] = '\0';
				solve(sb, availableChars);
				sb.deleteCharAt(sb.length() - 1);
				availableChars[i] = c;
			}

		}

	}

	void print() {
		Jren.p("There are total of: " + res.size() + " permuations.");
		for (String s : res) {
			Jren.p(s);
		}
	}




	public static void main(String[] args) {
		PermuationWithArray perm = new PermuationWithArray("abcd");
		perm.solve();
		perm.print();
	}
}