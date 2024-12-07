package solved;

import java.util.*;
import java.io.*;

public class BJ_10807 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nums = new int[201];
		int n = Integer.parseInt(br.readLine());
		String[] line = br.readLine().trim().split(" ");
		for(String str : line) {
			int idx = Integer.parseInt(str)+100;
			nums[idx]++;
		}
		n = Integer.parseInt(br.readLine()) + 100;
		System.out.println(nums[n]);
	}
}
