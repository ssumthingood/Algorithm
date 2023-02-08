import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] dir = {{1,0,0},{-1,0,0},{0,1,0},{0,-1,0},{0,0,1},{0,0,-1}};
	static boolean inBoard(int nowR, int nowC, int nowZ, int R, int C, int Z) {
		if(nowR >=0 && nowR <R && nowC >=0 && nowC <C && nowZ>=0&&nowZ<Z) {
			return true;
		}else return false;
	}	
	static int R;
	static int C;
	static int Z;
	static BufferedReader br;
	static StringTokenizer st;
	static int answer = 0;
	static int[][][] board;
	static int[][][] visited;
	static Queue<int[]> nextGo = new LinkedList<>();
	
	static void bfs() {
		while(!nextGo.isEmpty()) {
			int[] now = nextGo.poll();
			for(int i=0;i<6;i++) {
				int nextR = now[0]+dir[i][0];
				int nextC = now[1]+dir[i][1];
				int nextZ = now[2]+dir[i][2];
					
				if(inBoard(nextR, nextC, nextZ, R, C, Z) && board[nextR][nextC][nextZ] == 0) {
					board[nextR][nextC][nextZ] = 1;
					visited[nextR][nextC][nextZ] = visited[now[0]][now[1]][now[2]]+1;
					nextGo.add(new int[] {nextR, nextC, nextZ});
				}
			}
		}	
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Z = Integer.parseInt(st.nextToken());
		board = new int[R][C][Z];
		visited = new int[R][C][Z];
		for(int k=0;k<Z;k++) {
			for(int i=0;i<R;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<C;j++) {
					board[i][j][k] = Integer.parseInt(st.nextToken());
                    if(board[i][j][k] == 1)nextGo.add(new int[]{i,j,k});
				}
			}
		}
		
		bfs();
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				for(int k=0;k<Z;k++) {
					if(board[i][j][k] == 0) {
						System.out.println(-1);
						return;
					}
					if(visited[i][j][k]>0) {
						answer = Math.max(answer, visited[i][j][k]);
					}
				}
			}
		}
		System.out.println(answer);
	}
}