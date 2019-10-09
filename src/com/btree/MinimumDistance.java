package com.btree;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumDistance {

	public static void canJump(ArrayList<Integer> A) {
		int result = canJump(A, 0, A.size() - 1);
		if (Integer.MAX_VALUE == result) {
			System.out.println("No Possible Solutions");
		} else {
			System.out.println(" Min No of Jumps is ==>" + result);

		}
	}

	public static void main(String args[]) {
		ArrayList<Integer> val = new ArrayList<>();
		val.add(1);
		val.add(1);
		val.add(1);
		val.add(1);
		val.add(4);
		canJump(val);

	}

	public static int canJump(ArrayList<Integer> A, int low, int high) {

		if (low == 0) {
			return Integer.MAX_VALUE;
		}

		if (low == high) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for (int i = low + 1; i <= high && i <= low + A.get(low); i++) {
			int jumps = canJump(A, i, high);
			if (jumps != Integer.MAX_VALUE && jumps + 1 < min) {
				min = jumps + 1;
			}
		}
		return min;
	}
}
