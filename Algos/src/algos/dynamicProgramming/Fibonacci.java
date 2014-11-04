package algos.dynamicProgramming;

import java.util.Arrays;

public class Fibonacci {
	private static int[] mem;

	public static void main(String[] args) {
		int num = 50;
		System.out.println(fibBottomUp(3));
		

		mem = new int[num + 1];
		Arrays.fill(mem, -1);
		mem[1] = 1;
		mem[2] = 1;
		System.out.println(fibBottomUp(3));

	}

	private static int fibTopDown(int a) {
		if (mem[a] == -1) {
			mem[a] = fibTopDown(a - 1) + fibTopDown(a - 2);
		}
		

		return mem[a];
	}

	private static int fibBottomUp(int a) {
		mem = new int[a];
		// Arrays.fill(mem, -1);
		mem[0] = 1;
		mem[1] = 1;
		for (int i = 2; i < a; i++) {
			mem[i] = mem[i - 1] + mem[i - 2];
		}

		return mem[a - 1];

	}

}
