package backtracking;

import java.util.*;
import java.io.*;

public class Baek_2448 {
	static char[][] result;
	static int n, t;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		t = n/3;
		result = new char[t*3+1][t*6+1];
		for(int i=0;i<t*3+1;i++){
			Arrays.fill(result[i], ' ');
		}

		drawTriangle(1, t*3, t);

		StringBuilder sb = new StringBuilder();
		for(int i =1;i<t*3+1;i++){
			for(int j =1;j<t*6+1;j++){
				sb.append(result[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void drawTriangle(int x, int y, int dept) {
		if(dept == 1){
			for(int i = 0;i<3;i++){
				for(int j = y-i;j<=y+i;j++){
					result[x+i][j]='*';
				}
			}
			result[x+1][y]=' ';
		}
		if(dept > 1){
			drawTriangle(x, y, dept/2);
			int term = dept/2;
			drawTriangle(x+term*3, y-term*3, dept/2);
			drawTriangle(x+term*3, y+term*3, dept/2);
		}
	}
}
