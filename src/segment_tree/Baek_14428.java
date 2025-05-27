package segment_tree;

import java.util.*;
import java.io.*;

public class Baek_14428 {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int size;
	static int[] nums;
	static int[] segment;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		int pow = (int)Math.ceil(Math.log(n)/Math.log(2));
		size = (int)Math.pow(2,pow+1);
		nums = new int[n+1];
		nums[n] = Integer.MAX_VALUE;
		segment = new int[size];
		Arrays.fill(segment, n);

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			segment[size/2+i] = i;
		}

		for(int i = size/2-1; i >0; i--) {
			int a = segment[i*2];
			int b = segment[i*2+1];
			if(nums[a]==nums[b]){
				segment[i] = Math.min(a,b);
				continue;
			}
			segment[i] = nums[a]>nums[b]?b:a;
		}

		int T = Integer.parseInt(br.readLine());
		for(int tc = 0;tc<T;tc++) {
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if(order == 1) {
				nums[a-1] = b;
				renew((size/2+a-1)/2);
			}else{
				sb.append(findMinIdx(size/2+a-1,size/2+b-1)).append("\n");
			}
		}
		System.out.println(sb);
	}

	static void renew(int i) {
		int a = segment[i*2];
		int b = segment[i*2+1];
		if(nums[a]==nums[b]) {
			segment[i] = Math.min(a,b);
		}else {
			segment[i] = nums[a]>nums[b]?b:a;
		}
		if(i>1){
			renew(i/2);
		}
	}

	static int findMinIdx(int l, int r) {
		int min = Integer.MAX_VALUE;
		int idx = 0;
		while(l<=r){
			if(l%2==1){
				int i = segment[l];
				if(min == nums[i]){
					idx = Math.min(idx,i);
				}else if(min>nums[i]){
					min = nums[i];
					idx = i;
				}
			}

			if(r%2==0){
				int i = segment[r];
				if(min == nums[i]){
					idx = Math.min(idx,i);
				}else if(min>nums[i]){
					min = nums[i];
					idx = i;
				}
			}

			l = (l+1)/2;
			r = (r-1)/2;
		}
		return idx+1;
	}
}
