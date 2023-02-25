import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int[][] board;
	static boolean[][] visited;
	static int R;
	static int C;
	static int answer = 0;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
	static boolean isIn(int r, int c) {
		return (r>=0 && r<R && c>=0 && c<C);
	}
	static void bfs() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(board[i][j] == 1 && !visited[i][j]) {
					Queue<int[]> q=  new LinkedList<>();
					q.add(new int[] {i,j});
					visited[i][j] = true;
					while(!q.isEmpty()){
						int[] now=  q.poll();
						for(int k=0;k<8;k++) {
							int nr = now[0]+dir[k][0];
							int nc = now[1]+dir[k][1];
							if(isIn(nr, nc) && board[nr][nc]==1 && !visited[nr][nc]) {
								visited[nr][nc]=  true;
								q.add(new int[] {nr,nc});
							}
						}
					}
					answer++;
				}else {
					continue;
				}
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		while(!str.equals("0 0")) {
			st = new StringTokenizer(str);
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			board = new int[R][C];
			visited = new boolean[R][C];
			for(int i=0;i<R;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<C;j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			bfs();
			System.out.println(answer);
			answer = 0;
			str = br.readLine();
		}
	}

}