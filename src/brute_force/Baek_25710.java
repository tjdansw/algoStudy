package brute_force;

import java.io.*;

public class Baek_25710 {
	static int n, max = 0,cnt=0;
	static int[] a = new int[1000];
	static boolean[] check = new boolean[1000];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input/Baek_25710.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine().trim());
		String[] line = br.readLine().trim().split(" ");
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(line[i]);
			if (check[num]) continue;
			a[cnt++] = num;
			check[num] = true;
		}

		for (int i = 0; i < cnt; i++) for (int j = i; j < cnt; j++) checkMax(a[i] * a[j]);

		System.out.println(max);
	}

	static void checkMax(int num) {
		int sum = 0;
		while (num > 0) {
			sum += num % 10;
			num /= 10;
		}
		max = Math.max(max, sum);
	}
}
