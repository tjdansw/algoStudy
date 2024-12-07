package divide_conquer;
import java.io.*;

public class Baek_1074 {
	static int n,r,c,x,y,startX,startY,asymptoteX,asymptoteY,total=0;
	static int[] dx = {0,0,1,1};
	static int[] dy = {0,1,0,1};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input/Baek_1074.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] a = br.readLine().split(" ");
		n = Integer.parseInt(a[0]);
		r = Integer.parseInt(a[1]);
		c = Integer.parseInt(a[2]);
		
		x = (int) Math.pow(2.0, n*1.0);
		y = x;
		startX=0;
		startY=0;
		while(true) {
			asymptoteX = (startX+x)/2;
			asymptoteY = (startY+y)/2;
			if(x-startX == 2) {
				for(int i = 0;i<4;i++) {
					int row = startX + dx[i];
					int col = startY + dy[i];
					if(r==row&&c==col) {
						total+=i;
						break;
					}
				}
				break;
			}
			
			int subArea = (x-startX)*(x-startX)/4; 
			if(r<asymptoteX&&c<asymptoteY) {
				//좌상
				x = asymptoteX;
				y = asymptoteY;
			}else if(r<asymptoteX&&c>=asymptoteY) {
				//우상
				total += subArea ;
				x = asymptoteX;
				startY = asymptoteY;
				
			}else if(r>=asymptoteX&&c<asymptoteY) {
				//좌하
				total += 2*subArea; 
				startX = asymptoteX;
				y = asymptoteY;
			}else{
				//우하
				total += 3*subArea;
				startX = asymptoteX;
				startY = asymptoteY;
			}
		}
		System.out.println(total);
	}

}
