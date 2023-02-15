import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int R;
	static int C;
	static boolean[][] board;
	static int answer = 0;
	public static void main(String[] args) throws Exception, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new boolean[100][100];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			
			for(int j=R;j<R+10;j++) {
				for(int k = C;k<C+10;k++) {
					board[j][k] = true;
				}
			}
		}
		
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(board[i][j]) answer++;
			}
		}
		
		System.out.println(answer);
	}
}