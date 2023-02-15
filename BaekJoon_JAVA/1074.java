import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int r;
	static int c;
	static int answer = 0;
	static void z(int startR, int endR, int startC, int endC, int count) {
		if(endC == startC+1 && endR == startR+1 && r==startR && c==startC) {
			answer = count;
			return;
		}else if(endC == startC+1 && endR == startR+1 && r==startR && c==endC) {
			answer = count+1;
			return;
		}else if(endC == startC+1 && endR == startR+1 && r==endR && c==startC) {
			answer = count+2;
			return;
		}else if(endC == startC+1 && endR == startR+1 && r==endR && c==endC) {
			answer = count+3;
			return;
		}
		
		int centerR = (startR+endR)/2;
		int centerC = (startC+endC)/2;
		int dummies = (centerR-startR+1)*(centerC-startC+1);
		if(r<=centerR && c<=centerC) {
			z(startR, centerR, startC, centerC,count);
		}else if(r<=centerR && c>centerC) {
			z(startR, centerR, centerC+1, endC, count+dummies);
		}else if(r>centerR && c<=centerC) {
			z(centerR+1, endR, startC, centerC,count+dummies*2);
		}else if(r>centerR && c>centerC) {
			z(centerR+1, endR, centerC+1, endC ,count+dummies*3);
		}
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		z(0,(int)Math.pow(2, N)-1,0,(int)Math.pow(2, N)-1,0);
		System.out.println(answer);
	}
}