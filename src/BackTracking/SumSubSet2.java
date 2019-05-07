import java.util.*;

class SumSubSet2 {
	int[] nums;
	int target;
	List<List<Integer>> res;

	SumSubSet2(int[] nums, int target) {
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
			if (curSum + nums[curIndex] <= target) {
				curSol.addLast(nums[curIndex]);
				solve(curSum + nums[curIndex], curIndex + 1, curSol);
				curSol.removeLast();
			}
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
		int[] testNums = new int[]{2,2,2,2,2,2,2,2,2,1,2,2,2,2,2,2};
		int target = 23;

		long start = System.nanoTime();
		SumSubSet2 sss = new SumSubSet2(testNums, target);
		sss.solve();
		sss.print();
		long end = System.nanoTime();
		Jren.p("time without sorting: " + (end - start) / 10000);
		Jren.p();

		Arrays.sort(testNums);
		start = System.nanoTime();
		SumSubSet2 sss2 = new SumSubSet2(testNums, target);
		sss2.solve();
		sss2.print();
		end = System.nanoTime();
		Jren.p("time with sorting: " + (end - start) / 10000);
	}
}