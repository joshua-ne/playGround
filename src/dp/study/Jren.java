import java.util.*;
import java.util.stream.*;

class Jren {
	static void p(String s) {
		System.out.println(s);
	}
	static void p(int s) {
		System.out.println(s);
	}

	static void p(long s) {
		System.out.println(s);
	}

	static void p() {
		System.out.println();
	}

	static void p(char c) {
		System.out.println(String.valueOf(c));
	}

	static void p(int[] nums) {
		for (int i : nums) {
			System.out.printf("%5d ", i);
		}
		p();
	}

	static void p(char[] chars) {
		for (char c : chars) {
			System.out.print(String.valueOf(c) + " ");
		}
		Jren.p();
	}

	static void p_index(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.printf("%5d ", i);
		}
		p();

		for (int i : nums) {
			System.out.printf("%3d ", i);
		}
		p();
	}

	static void p_index(int[] nums, int k) {
		for (int i = 0; i < nums.length; i++) {
			System.out.printf("%" + k +"d ", i);
		}
		p();

		for (int i : nums) {
			System.out.printf("%" + k +"d ", i);
		}
		p();
	}

	static void p(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.printf("%3d", matrix[i][j]);
			}
			System.out.println();
		}
	}

	//test

	public static void main(String[] args) {
		
	}
}