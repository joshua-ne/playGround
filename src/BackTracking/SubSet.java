import java.util.*;

class SubSet {
	String str;
	List<String> res;

	SubSet(String s) {
		str = s;
		res = new ArrayList<>();
	}

	void solve() {
		StringBuilder sb = new StringBuilder();
		solve(sb, str, 0);
	}

	void solve(StringBuilder sb, String s, int index) {
		if (index == s.length() - 1) {res.add(sb.toString());}
		else {
			solve(sb, s, index + 1);
			sb.append(s.charAt(index));
			solve(sb, s, index + 1);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	void print() {
		Jren.p("there are total of: " + res.size() + " subsets");
		for (String s : res) {
			Jren.p(s);
		}
	}

	public static void main(String[] args) {
		SubSet ss = new SubSet("abcd");
		ss.solve();
		ss.print();
	}
}