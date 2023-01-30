import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class java17404 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Max = 1000*1000;
		
		int[][] board = new int[N+1][3];
		int[][] answer = new int[N+1][3];
		int ans=0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			board[i+1][0]=Integer.parseInt(st.nextToken());
			board[i+1][1]=Integer.parseInt(st.nextToken());
			board[i+1][2]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(i==j) {
					answer[1][j] = board[1][j];
				}else {
					answer[1][j] =Max;
				}
			}
			
			for(int j=2;j<=N;j++) {
				answer[j][0] = Math.min(answer[j-1][1], answer[j-1][2]) + board[j][0];
				answer[j][1] = Math.min(answer[j-1][0], answer[j-1][2]) + board[j][1];
				answer[j][2] = Math.min(answer[j-1][0], answer[j-1][1]) + board[j][2];
			}
			
			for(int j=0;j<3;j++) {
				if(i!=j) {
					if(ans ==0) {
						ans = answer[N][j];
					}else {
						ans = Math.min(ans, answer[N][j]);
					}
				}
			}
			
		}
		System.out.println(ans);
	}

}