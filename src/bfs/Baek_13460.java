package bfs;
import java.io.*;

public class Baek_13460 {
	static int n,m;
	static String[] map;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/input/Baek_13460.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().trim().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		map = new String[n];
		for(int i = 0;i<n;i++) map[i] = br.readLine().trim();
		
		
		
		
	}
}
