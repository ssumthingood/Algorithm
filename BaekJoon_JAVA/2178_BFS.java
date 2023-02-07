import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 최단거리는 BFS
public class java2178 {
	// 사방 탐색 배열과 메소드 
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean inBoard(int nowR, int nowC, int R, int C) {
		if(nowR >=0 && nowR <R && nowC >=0 && nowC <C) {
			return true;
		}else return false;
	}
	static int R;
	static int C;
	
	static BufferedReader br;
	static StringTokenizer st;
	static int answer = 0;
	static int[][] board;
	static int[][] visited;
	static Queue<int[]> q = new LinkedList<>();
	
	// bfs 사용 메소드 
	static void bfs() {
		while(!q.isEmpty()) {
			int[] next = q.poll();

			if(next[0]== R-1 && next[1] == C-1) {
				answer = visited[R-1][C-1];
				return;
			}
			
			for(int i=0;i<4;i++) {
				int newr = next[0]+dir[i][0];
				int newc = next[1]+dir[i][1];
				if(inBoard(newr, newc, R, C) && board[newr][newc] == 1 && visited[newr][newc] == 0) {
					visited[newr][newc] = visited[next[0]][next[1]]+1;
					q.add(new int[] {newr, newc});
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new int[R][C];
		visited = new int[R][C];
		for(int i=0;i<R;i++) {
			String line = br.readLine();
			for(int j=0;j<C;j++) {
				board[i][j] = line.charAt(j)-'0';
			}
		}
		
		q.add(new int[] {0,0});
		visited[0][0] = 1;
		bfs();
		System.out.println(answer);
	}
}