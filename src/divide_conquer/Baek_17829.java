package divide_conquer;

import java.io.*;
import java.util.*;

public class Baek_17829 {
	static int n;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input/Baek_17829.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine().trim());
		map = new int[n][n];
		String[] line;
		for(int i = 0;i<n;i++) {
			line = br.readLine().trim().split(" ");
			for(int j = 0;j<n;j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}
		System.out.println(solve(map));
	}
	static int solve(int[][] block) {
		if(block.length == 2) {
			int[] arr = {block[0][0],block[1][0],block[0][1],block[1][1]};
			Arrays.sort(arr);
			return arr[2];
		}
		int[][] newBlock = new int[block.length/2][block.length/2];
		for(int i = 0;i<block.length/2;i++) {
			for(int j = 0;j<block.length/2;j++) {
				int[][] temp = {{block[2*i][2*j],block[2*i][2*j+1]},{block[2*i+1][2*j],block[2*i+1][2*j+1]}};
				newBlock[i][j] = solve(temp);
			}
		}
		return solve(newBlock);
	}
}
