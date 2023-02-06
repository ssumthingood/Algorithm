import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//이문제 DFS로풀면 무조건 시간초과!!!! 최단거리문제는 BFS로 풀자

public class java2178_DFS {
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
	static char[][] board; // 기본 게임
	static boolean[][] visited; // 방문 상태 나타내는 배열 
	
	// dfs 사용 메소드 
	static void dfs(int r, int c, char[][] board, int count) {
		if(r == R-1 && c == C-1) {
			if(answer ==0) {
				answer = count; return;
			}else {
				answer = Math.min(answer, count); return;
			}
		}
		
		visited[r][c] =true;
		
		for(int i=0;i<4;i++) {
			if(inBoard(r+dir[i][0], c+dir[i][1], R, C) && board[r+dir[i][0]][c+dir[i][1]]== '1' && visited[r+dir[i][0]][c+dir[i][1]]== false) {
				dfs(r+dir[i][0],c+dir[i][1], board, count+1 );
			}
		}
		visited[r][c] =false;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		visited = new boolean[R][C];
		for(int i=0;i<R;i++) {
			String line = br.readLine();
			for(int j=0;j<C;j++) {
				board[i][j] = line.charAt(j);
			}
		}
		
		dfs(0, 0, board, 0);
		// 마지막칸 도달 경우 이동거리가 하나 누락된 상태이므로 1 더함
		System.out.println(answer+1);
	}
}