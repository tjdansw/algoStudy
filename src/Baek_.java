import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_ {
    static StringTokenizer st;
    static BufferedReader br;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        //st.nextToken()
    }
}
