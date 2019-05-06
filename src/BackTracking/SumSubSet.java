import java.util.*;

class SumSubSet {
	int[] nums;
	int target;
	List<List<Integer>> res;

	SumSubSet(int[] nums, int target) {
		this.nums = nums;
		//test if sorting helps
		//Arrays.sort(this.nums);
		this.target = target;
		res = new ArrayList<>();
	}

	void solve() {
		Deque<Integer> curSol = new ArrayDeque<>();
		solve(0, 0, curSol);
	}

	void solve(int curSum, int curIndex, Deque<Integer> curSol) {
		if (curIndex == nums.length) {return;}
		if (curSum > target) {return;}
		else if (curSum == target) {
			res.add(new ArrayList<Integer>(curSol));
		} else {
			curSol.addLast(nums[curIndex]);
			solve(curSum + nums[curIndex], curIndex + 1, curSol);
			curSol.removeLast();
			solve(curSum, curIndex + 1, curSol);
		}
	}

	void print(){
		if (res.size() == 0) {Jren.p("no solution");}
		else {
			Jren.p("there are total of " + res.size() + " solutions: ");
			for (List<Integer> l : res) {
				System.out.println(l.toString());
			}
		}
	}


	public static void main(String[] args) {
		int[] testNums = new int[]{1,2,3,4,5,6,7,8,9,11,12,13,14,15,16,17};
		int target = 12;

		long start = System.nanoTime();
		SumSubSet sss = new SumSubSet(testNums, target);
		sss.solve();
		sss.print();
		long end = System.nanoTime();
		Jren.p("time without sorting: " + (end - start) / 10000);
		Jren.p();

		Arrays.sort(testNums);
		start = System.nanoTime();
		SumSubSet sss2 = new SumSubSet(testNums, target);
		sss2.solve();
		sss2.print();
		end = System.nanoTime();
		Jren.p("time with sorting: " + (end - start) / 10000);
	}
}