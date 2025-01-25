package brute_force;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baek_25710 {
	static StringTokenizer st;
	static BufferedReader br;

	static int n, max = 0;
	static HashSet<Integer> set = new HashSet<>();
	static int[] arr;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input/Baek_25710.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(set.contains(num)){
				check((num*num)+"");
				continue;
			}
			set.add(num);
		}
		arr = new int[set.size()];
		int idx = 0;
		for(Integer i : set) arr[idx++] = i;
		for(int i = 0;i<set.size()-1;i++){
			for(int j = i+1;j<set.size();j++){
				check((arr[i]*arr[j])+"");
			}
		}
		System.out.println(max);
	}

	static void check(String num){
		int sum = 0;
		for(int i=0;i<num.length();i++){
			sum += num.charAt(i)-'0';
		}
		max = Math.max(max,sum);
	}
}
