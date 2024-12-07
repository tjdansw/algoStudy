package dfs;
import java.io.*;

public class Baek_14888 {
	static int n, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	static int[] nums;
	static int[] operation;// +, -, x, /

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input/Baek_14888.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		nums = new int[n];
		operation = new int[n - 1];
		String[] line = br.readLine().split(" ");
		for (int i = 0; i < n; i++)
			nums[i] = Integer.parseInt(line[i]);
		line = br.readLine().split(" ");
		int idx = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < Integer.parseInt(line[i]); j++) {
				operation[idx++] = i;
			}
		}

		permutaion(new int[n - 1], 0, new boolean[n - 1]);
		System.out.println(max);
		System.out.println(min);
	}

	static void permutaion(int[] set, int idx, boolean[] vistied) {
		if (idx == n - 1) {
			check(set);
			return;
		}
		for (int i = 0; i < n - 1; i++) {
			if (vistied[i])
				continue;
			vistied[i] = true;
			set[idx] = operation[i];
			permutaion(set, idx + 1, vistied);
			vistied[i] = false;
		}
	}

	static void check(int[] set) {
		int idx = 0;
		int total = nums[idx++];
		for(int i = 0;i<n-1;i++) {
			switch (set[i]) {
				case 0: {
					total += nums[idx++];
					break;
				}
				case 1: {
					total -= nums[idx++];			
					break;
				}
				case 2: {
					total *= nums[idx++];
					break;
				}
				case 3: {
					if(total<0) {
						total *= -1;
						total/= nums[idx++];
						total *= -1;
					}else {
						total/= nums[idx++];
					}
					break;
				}
			}
		}
		max = Math.max(max, total);
		min = Math.min(min , total);
	}
}
