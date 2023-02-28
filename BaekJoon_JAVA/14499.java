import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int[][] board;
	static int[] dice;
	static int N, M, r, c, K;
	static int[][] dir =  {{0,0},{0,1},{0,-1},{-1,0},{1,0}};
	static boolean isIn(int nr, int nc) {
		return (nr>=0&& nr<N && nc>=0 && nc<M);
	}
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dice = new int[7];
		board = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<K;i++) {
			move(Integer.parseInt(st.nextToken()));
		}
	}
	static void move(int i) {
		int nr = r + dir[i][0];
		int nc = c + dir[i][1];
		if(isIn(nr, nc)) {
			r = nr;
			c = nc;
			switch(i) {
			case 1 : 
				int temp = dice[1];
				dice[1] = dice[4];
				dice[4] = dice[6];
				dice[6] = dice[3];
				dice[3] = temp;
				break;
			case 2 :
				int temp1 = dice[1];
				dice[1] = dice[3];
				dice[3] = dice[6];
				dice[6] = dice[4];
				dice[4] = temp1;
				break;
			case 3 : 
				int temp2 = dice[1];
				dice[1] = dice[5];
				dice[5] = dice[6];
				dice[6] = dice[2];
				dice[2] = temp2;
				break;
			case 4 : 
				int temp3 = dice[1];
				dice[1] = dice[2];
				dice[2] = dice[6];
				dice[6] = dice[5];
				dice[5] = temp3;
				break;
			}
			
			if(board[r][c] ==0) {
				board[r][c] = dice[6];
			}else {
				dice[6] = board[r][c];
				board[r][c] =0;
			}
			System.out.println(dice[1]);
		}else return;
	}

}