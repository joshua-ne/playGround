import java.util.*;
import java.io.*;

class Tourist {

	List<Attraction> attractions;
	int K;

	Tourist(List<Attraction> attr, int k) {
		attractions = attr;
		this.K = k;
	}

	
	static class Attraction {
		String name; 
		int pop;
		int vTimes;

		Attraction(String s, int i) {
			name = s;
			pop = i;
			vTimes = 0;
		}

		/*
		public int compareTo(Attraction a) {
			return this.pop - a.pop;	
		}
		*/
	}


	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = in.nextInt();
			int K = in.nextInt();
			long V = in.nextLong();
			List<Attraction> attr = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				attr.add(new Attraction(in.next(), i));
			}

			Tourist tourist = new Tourist(attr, K);

			List<Attraction> visitList = new ArrayList<>();

			int remainder = (int)(((V - 1) * K) % N);

			for (int i = 0; i < K; i++) {
				visitList.add(tourist.attractions.get((i + remainder) % N));
			}

			Collections.sort(visitList, (a, b) -> (a.pop - b.pop));


 



			System.out.print("Case #" + t + ": ");
			for (Attraction a : visitList) {
				System.out.print(a.name + " ");
			}
			Jren.p();
		}
	}
}