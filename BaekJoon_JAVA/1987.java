import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br;
	static StringTokenizer st;
	static int R;
	static int C;
	static char[][] board;
	static List<Character> chars;
	static boolean[][] visited;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static int answer = 1;
	static void dfs(int r, int c, int distance) {
		chars.add(board[r][c]);
		visited[r][c] = true;
		for(int i=0;i<4;i++) {
			int nr = r+dir[i][0];
			int nc = c+dir[i][1];
			if(isIn(nr,nc) && !chars.contains(board[nr][nc]) && !visited[nr][nc]) {
				answer = Math.max(answer, distance+1);
				visited[nr][nc] = true;
				dfs(nr,nc,distance+1);
				chars.remove(chars.size()-1);
				visited[nr][nc] = false;
			}
		}
	}
	
	static boolean isIn(int r, int c) {
		return (r>=0 && r<R && c>=0 && c<C);
	}
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		visited = new boolean[R][C];
		for(int i=0;i<R;i++) {
			String str = br.readLine();
			for(int j=0;j<C;j++) {
				board[i][j] = str.charAt(j);
			}
		}
		
		chars = new ArrayList<>();
		dfs(0,0,1);
		
		System.out.println(answer);
	}

}
