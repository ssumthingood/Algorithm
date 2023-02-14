import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int M;
	static boolean[][] board;
	static boolean[] visited;
	static int answer = -1;
	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1] = true;
		while(!q.isEmpty()) {
			int next = q.poll();
			answer++;
			for(int i=1;i<=N;i++) {
				if(board[next][i] && !visited[i]) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		board = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			board[r][c] = true;
			board[c][r] = true;
		}
		bfs();
		System.out.println(answer);
	}
}