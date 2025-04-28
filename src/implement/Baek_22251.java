package implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_22251 {
	static StringTokenizer st;
	static BufferedReader br;

	static int n, k, p, x, cnt=0;
	static boolean[][] nums = new boolean[10][7];
	static int[][] reverseCnt = new int[10][10];
	static ArrayList<Integer> listFlagNum = new ArrayList<>();

	static {
		// 0
		Arrays.fill(nums[0], true);
		nums[0][3] = false;
		// 1
		nums[1][2] = true;
		nums[1][5] = true;
		// 2
		Arrays.fill(nums[2], true);
		nums[2][1] = false;
		nums[2][5] = false;
		// 3
		Arrays.fill(nums[3], true);
		nums[3][1] = false;
		nums[3][4] = false;
		// 4
		Arrays.fill(nums[4], true);
		nums[4][0] = false;
		nums[4][4] = false;
		nums[4][6] = false;
		// 5
		Arrays.fill(nums[5], true);
		nums[5][2] = false;
		nums[5][4] = false;
		// 6
		Arrays.fill(nums[6], true);
		nums[6][2] = false;
		// 7
		nums[7][0] = true;
		nums[7][2] = true;
		nums[7][5] = true;
		// 8
		Arrays.fill(nums[8], true);
		// 9
		Arrays.fill(nums[9], true);
		nums[9][4] = false;

		for(int i = 0;i<10;i++){
			for(int j = i+1;j<10;j++){
				int cnt = 0;
				for(int k = 0;k<7;k++){
					if(nums[i][k]!=nums[j][k]){
						cnt++;
					}
				}
				reverseCnt[i][j] = cnt;
				reverseCnt[j][i] = cnt;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		int temp = x;
		while(true){
			listFlagNum.add(temp%10);
			if(temp<10) break;
			temp/=10;
		}

		for(int i = 1;i<=n;i++){
			check(i);
		}

		System.out.println(cnt);
	}

	public static void check(int target){
		ArrayList<Integer> listTarget = new ArrayList<>();
		while(true){
			listTarget.add(target%10);
			if(target<10) break;
			target/=10;
		}

		int totalReverse=0;
		if(listTarget.size()>listFlagNum.size()){
			for(int i = 0;i<listFlagNum.size();i++){
				totalReverse+=reverseCnt[listTarget.get(i)][listFlagNum.get(i)];
			}
			for(int i = listFlagNum.size();i<listTarget.size();i++){
				totalReverse+=reverseCnt[0][listTarget.get(i)];
			}
		}else{
			for(int i = 0;i<listTarget.size();i++){
				totalReverse+=reverseCnt[listTarget.get(i)][listFlagNum.get(i)];
			}
			for(int i = listTarget.size();i<listFlagNum.size();i++){
				totalReverse+=reverseCnt[0][listFlagNum.get(i)];
			}
		}
		if(totalReverse>0&&totalReverse<=p){
			cnt++;
		}
	}
}
