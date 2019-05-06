import java.util.*;

// Assume all the numbers in the array is positive and unique!

class SumSubSet {
	int[] nums;
	int target;
	boolean res;
	int count;
	int max;

	SumSubSet(int[] arr) {
		this.nums = arr;
		res = false;
		count = 0;
		for (int i : arr) {
			max += i;
		}
	}

	void setTarget(int n) {
		this.target = n;
		count = 0;
	}

	void solve() {
		if (target == max) {res = true;} 
		else if (target > max) {res = false;}
		else {res = solve(0);}
		if (res) Jren.p("Yes for target: " + target + " count: " + count);
		else Jren.p("No for target: " + target + " count: " + count);
	}

	boolean solve(int curSum) {
		count++;
		if (curSum == target) return true;
		if (curSum > target) return false;
		else {
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] != -1) {
					int cur = nums[i];
					nums[i] = -1;
					if (solve(curSum + cur)) {nums[i] = cur; return true;}
					nums[i] = cur;
				}
			}
			return false;
		}
	}




	public static void main(String[] args) {
		int[] nums = new int[]{2,2,2,2,2,2,2,2,2,2,2};
		//int target = args.length == 0 ? 7 : Integer.parseInt(args[0]);
		SumSubSet sss = new SumSubSet(nums);
		for (int i = 1; i < 30; i++) {
			sss.setTarget(i);
			sss.solve();
		}
	}
}