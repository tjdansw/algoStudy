package brute_force;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek_12919 {
    static BufferedReader br;

    static String c, t;
    static int size;
    static boolean flag = false;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        c = br.readLine();
        t = br.readLine();
        size = c.length();
        check(0,t.length()-1,false);
        System.out.println(flag?"1":"0");
    }

    static void check(int l, int r, boolean reverse) {
        if(flag) return;
        if(r-l+1 <= size){
            boolean temp = true;
            int idx = 0;
            if(reverse){
                for(int i=r; i>=l&&temp; i--)
                    if(c.charAt(idx++)!=t.charAt(i)) temp = false;
            }else{
                for(int i=l; i<=r&&temp; i++)
                    if(c.charAt(idx++)!=t.charAt(i)) temp = false;
            }
            flag = temp;
            return;
        }
        if(reverse){
            if(t.charAt(r)=='B'){
                check(l,r-1,false);
            }
            if(t.charAt(l)=='A'){
                check(l+1,r,true);
            }
        }else{
            if(t.charAt(l)=='B'){
                check(l+1,r,true);
            }
            if(t.charAt(r)=='A'){
                check(l,r-1,false);
            }
        }
    }
}
