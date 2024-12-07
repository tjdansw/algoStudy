package implement;
import java.io.*;
import java.util.*;

public class Baek_5430 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input/Baek_5430.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] a;
		int T = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> aq;
		for(int tc = 1;tc<=T;tc++) {
			String order =  br.readLine();
			int size = Integer.parseInt(br.readLine());
			String temp = br.readLine();
			a = temp.substring(1, temp.length()-1).split(",");
			aq = new ArrayDeque<>();
			for(int i = 0 ;i<size;i++) aq.add(Integer.parseInt(a[i]));
			boolean isFirst = true;
			boolean flag = true;
			for(int i = 0;i<order.length();i++) {
				if(order.charAt(i)=='R') {
					isFirst = !isFirst;
				}else {
					if(aq.isEmpty()) {
						flag = false;
						break;
					}
					if(isFirst) {
						aq.removeFirst();
					}else {
						aq.removeLast();
					}
				}
			}
			if(flag) {
				if(isFirst) {
					sb.append("[");
					if(!aq.isEmpty()) sb.append(aq.removeFirst());
					while(!aq.isEmpty()) {
						sb.append(",").append(aq.removeFirst());
					}
					sb.append("]\n");
				}else {
					sb.append("[");
					if(!aq.isEmpty()) sb.append(aq.removeLast());
					while(!aq.isEmpty()) {
						sb.append(",").append(aq.removeLast());
					}
					sb.append("]\n");
				}
			}else {
				sb.append("error\n");
			}
		}
		System.out.println(sb.toString());
	}

}
