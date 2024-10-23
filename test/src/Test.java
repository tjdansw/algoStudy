import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Test {
	public static void main(String[] args) throws Exception{
		 System.setIn(new FileInputStream("input3.txt"));
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 HashMap<String, Double> map = new HashMap<>();
		 map.put("A+", 4.5);
		 map.put("A", 4.0);
		 map.put("B+", 3.5);
		 map.put("B", 3.0);
		 map.put("C+", 2.5);
		 map.put("C", 2.0);
		 double total = 4.5;
		 int cnt = 1 ;
		 String a;
		 while(true) {
			 a = br.readLine();
			 if(a == null) break;
			 total+=map.get(a);
			 cnt++;
		 }
		 System.out.println(total);
		 System.out.println(cnt);
		 System.out.println(total/cnt);
	}
}
