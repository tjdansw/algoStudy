package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek_2195 {
	static char[] s,p;
	static int n = 0, cnt = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine().toCharArray();
		p = br.readLine().toCharArray();

		while(n<p.length) {
			int max = 0;
			for(int i = 0;i<s.length;i++) {
				if(p[n]!=s[i]) {
					continue;
				}
				int len = 1;
				for(int j=i+1;j<s.length;j++) {
					if(n+len<p.length&&p[n+len]==s[j]) {
						len++;
						continue;
					}
					break;
				}
				max = Math.max(max, len);
			}
			cnt++;
			n+=max;
		}

		System.out.println(cnt);
	}
}
