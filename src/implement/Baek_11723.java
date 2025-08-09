package implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_11723 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        int S = 0;

        for (int i = 0; i < m; i++) {
            String line = br.readLine();
            if (line.equals("all")) {
                S = (1 << 21) - 2;
            } else if (line.equals("empty")) {
                S = 0;
            } else {
                StringTokenizer st = new StringTokenizer(line);
                String cmd = st.nextToken();
                int x = Integer.parseInt(st.nextToken());
                int bit = 1 << x;

                switch (cmd) {
                    case "add":
                        S |= bit;
                        break;
                    case "remove":
                        S &= ~bit;
                        break;
                    case "check":
                        sb.append(((S & bit) != 0) ? 1 : 0).append('\n');
                        break;
                    case "toggle":
                        S ^= bit;
                        break;
                }
            }
        }

        System.out.print(sb.toString());
    }
}
