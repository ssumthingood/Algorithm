import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[N+1][3];
		int[][] answer = new int[N+1][3];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			board[i+1][0]=Integer.parseInt(st.nextToken());
			board[i+1][1]=Integer.parseInt(st.nextToken());
			board[i+1][2]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=N;i++) {
			answer[i][0] = Math.min(answer[i-1][1], answer[i-1][2]) + board[i][0];
			answer[i][1] = Math.min(answer[i-1][0], answer[i-1][2]) + board[i][1];
			answer[i][2] = Math.min(answer[i-1][0], answer[i-1][1]) + board[i][2];
		}
		
		System.out.println(Math.min(Math.min(answer[N][0], answer[N][1]), answer[N][2]));
	}

}
//재귀는 안되고 점화식은 된다 - 시간 소요 차이 중점으로 탐구 필요