import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] board = new int[N+1];
		int[] answer = new int[N+1];
		
		int num = 0;

		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			board[i] = Integer.parseInt(st.nextToken());
		}
		
		answer[1] = board[1];
		if(N==1) {
			 System.out.println(answer[1]);
			 return;
		}
		answer[2] = Math.max(board[2], answer[1]+board[2]);
		if(N==2) {
			 System.out.println(answer[2]);
			 return;
		}
		for(int i=3;i<=N;i++) {
			answer[i] = Math.max(answer[i-2]+board[i], answer[i-3]+board[i-1]+board[i]);
			answer[i] = Math.max(answer[i], answer[i-1]);
		}
		
		for(int i=1;i<=N;i++) {
			num = Math.max(num, answer[i]);
		}
		System.out.println(num);
	}

}