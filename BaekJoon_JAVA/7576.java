import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
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
	static int answer =0;
	static int[][] board;
	static int[][] visited;
	static Queue<int[]> q = new LinkedList<>();
	static void bfs() {
		while(!q.isEmpty()) {
			int[] loc = q.poll();
			visited[loc[0]][loc[1]] = loc[2];
//			board[loc[0]][loc[1]] = 1;
			for(int i=0;i<4;i++) {
				if(!inBoard(loc[0]+dir[i][0],loc[1]+dir[i][1],R,C)) continue;
				
				if(board[loc[0]+dir[i][0]][loc[1]+dir[i][1]] ==0) {
					q.add(new int[] {loc[0]+dir[i][0],loc[1]+dir[i][1],loc[2]+1});
					board[loc[0]+dir[i][0]][loc[1]+dir[i][1]]=1; //이러면 좀 달라지나?
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
		for(int i=0;i<C;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<R;j++) {
				board[j][i] = Integer.parseInt(st.nextToken());
				if(board[j][i] == 1) {
					q.add(new int[] {j,i,0});
				}
			}
		}
		
		bfs();
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				answer = Math.max(answer, visited[i][j]);
				if(board[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(answer);
	}
}
