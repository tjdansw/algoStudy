package divide_conquer;

import java.io.*;

public class Baek_18222 {
	static long n;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input/Baek_18222.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Long.parseLong(br.readLine().trim());
		System.out.println(solve(n));
	}
	static int solve(long k) {
		if (k == 0)
			return 0;
		if (k == 1)
			return 1;
		if (k % 2 == 0)
			return solve(k / 2);
		return 1 - solve(k / 2);
	}
}
