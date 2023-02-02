import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] weights = new int[N+1];
		int[] values = new int[N+1];
		int answer = 0;
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			weights[i] = Integer.parseInt(st.nextToken());
			values[i] = Integer.parseInt(st.nextToken());
		}
		
		int board[][] = new int[N+1][K+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=K;j++) {
				if(weights[i]<=j) {
					board[i][j] = Math.max(board[i-1][j], board[i-1][j-weights[i]]+values[i]);
				}else {
					board[i][j] = board[i-1][j];
				}
				answer = Math.max(answer, board[i][j]);
			}
		}
		
		System.out.println(answer);
	}

}