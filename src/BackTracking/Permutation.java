import java.util.*;


//allow duplicates in the input string

class Permutation {
	String s;
	List<String> res;
	Set<Character> charSet;

	Permutation(String s) {
		this.s = s;
		charSet = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			charSet.add(s.charAt(i));
		}
		res = new ArrayList<>();
	}

	void solve() {
		StringBuilder sb = new StringBuilder();
		solve(sb, charSet);
	}

	void solve(StringBuilder sb, Set<Character> availableChars) {

		if (availableChars.size() == 0) {res.add(sb.toString());}

		Iterator iter = availableChars.iterator();
		while (iter.hasNext()) {
			char c = (char)iter.next();
			sb.append(c);
			Set<Character> nextAvailable = new HashSet<>(availableChars);
			nextAvailable.remove(c);
			solve(sb, nextAvailable);
			sb.deleteCharAt(sb.length() - 1);
			//availableChars.add(c);
		}
	}

	void print() {
		Jren.p("There are total of: " + res.size() + " permuations.");
		for (String s : res) {
			Jren.p(s);
		}
	}




	public static void main(String[] args) {
		Permutation perm = new Permutation("abcc");
		perm.solve();
		perm.print();
	}
}