import java.util.*;


//don't duplicates in the input string

class PermutationWithSb {
	String s;
	List<String> res;
	StringBuilder inputSb;

	PermutationWithSb(String s) {
		this.s = s;
		inputSb = new StringBuilder(s);
		res = new ArrayList<>();
	}

	void solve() {
		StringBuilder sb = new StringBuilder();
		solve(sb, inputSb);
	}

	void solve(StringBuilder sb, StringBuilder remainChars) {

		if (remainChars.length() == 0) {res.add(sb.toString());}

		for (int i = 0; i < remainChars.length(); i++) {
			char c = remainChars.charAt(i);
			sb.append(c);
			remainChars.deleteCharAt(i);
			solve(sb, remainChars);
			sb.deleteCharAt(sb.length() - 1);
			remainChars.insert(i, c);

		}

	}

	void print() {
		Jren.p("There are total of: " + res.size() + " permuations.");
		for (String s : res) {
			Jren.p(s);
		}
	}




	public static void main(String[] args) {
		PermutationWithSb perm = new PermutationWithSb("abcd");
		perm.solve();
		perm.print();
	}
}