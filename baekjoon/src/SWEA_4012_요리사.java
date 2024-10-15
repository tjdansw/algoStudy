import java.util.*;
import java.io.*;

public class SWEA_4012_요리사 {
	static int n,min;
	static int[][] synergy;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		String[] line;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			n = Integer.parseInt(br.readLine());
			synergy = new int[n][n];
			for(int i = 0;i<n;i++) {
				line = br.readLine().split(" ");
				for(int j = 0;j<n;j++) {
					synergy[i][j] = Integer.parseInt(line[j]);
				}
			}
			min = Integer.MAX_VALUE;
			combination(new HashSet<>(),0);
			sb.append(String.format("#%d %d\n", tc,min));
		}
		System.out.println(sb.toString());
	}
	
	static void combination(HashSet<Integer> set, int start) {
		if(set.size() == n/2) {
			int[] a = new int[n/2];
			int[] b = new int[n/2];
			int ai=0,bi=0;
			for(int i = 0;i<n;i++) {
				if(set.contains(i)) {
					a[ai++] = i;
				}else {
					b[bi++] = i;
				}
			}
			checkSynergy(a,b);
			return;
		}
		for(int i = start;i<n;i++) {
			set.add(i);
//			combination((HashSet<Integer>)set.clone(), i+1);
			combination(set,i+1);
			set.remove(i);
		}
	}

	static void checkSynergy(int[] a, int[] b) {
		int totalA = 0;
		int totalB = 0;
		for(int i = 0;i<n/2;i++) {
			for(int j = 0;j<n/2;j++) {
				totalA += synergy[a[i]][a[j]];
				totalB += synergy[b[i]][b[j]];
			}
		}
		min = Math.min(min, Math.abs(totalA-totalB));
	}
	
}
